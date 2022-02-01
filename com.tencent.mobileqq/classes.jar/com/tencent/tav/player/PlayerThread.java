package com.tencent.tav.player;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.tav.Utils;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.PreviewReportSession;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerThread
  implements Handler.Callback
{
  static final int ACTION_FINISH = -1;
  static final int ACTION_GET_TAV_EXTRA_INFO = 25;
  static final int ACTION_PAUSE = 3;
  static final int ACTION_PLAY = 2;
  static final int ACTION_PREPARE = 1;
  static final int ACTION_QUIT = 850;
  static final int ACTION_READ_SAMPLE = 12;
  static final int ACTION_READ_SNAP_SHOOT_BITMAP = 24;
  static final int ACTION_RELEASE = 6;
  static final int ACTION_SEEK = 5;
  static final int ACTION_SEEK_PRE_SAMPLE = 9;
  static final int ACTION_SET_VOLUME = 7;
  static final int ACTION_STOP = 4;
  static final int ACTION_UPDATE_ALLPROPERTIES = 20;
  static final int ACTION_UPDATE_AUDIOCLIP_PROPERTIES = 22;
  static final int ACTION_UPDATE_AUDIOVOLUME_PROPERTIES = 23;
  static final int ACTION_UPDATE_COMPOSITION = 11;
  static final int ACTION_UPDATE_PROPERTIES = 10;
  static final int ACTION_UPDATE_SIZE = 21;
  static final int STATUS_FINISH = 3;
  static final int STATUS_INIT_CODEC = 2;
  static final int STATUS_NONE = 1;
  public static final String TAG = "PlayerThreadMain";
  private static final long UNIT_TIME = 1000L;
  public static SparseArrayCompat<String> map = new SparseArrayCompat(10);
  private AudioCompositionDecoderTrack aDecoderTrack;
  private long decoderConsumerTimeUs = 0L;
  private Filter filter;
  private CMTime frameDuration = new CMTime(1L, 30);
  @Nullable
  private CGRect glViewportRect;
  private volatile long lastSyncMessageId = 0L;
  private VideoComposition.RenderLayoutMode layoutMode;
  private PlayerThreadAudio mAudioThread;
  @Nullable
  private Surface mDisplayTarget;
  private boolean mLooper;
  @NonNull
  private Handler mMainHandler;
  private boolean mPause;
  private Handler mPlayHandler;
  @NonNull
  private Player mPlayer;
  private PlayerItem mPlayerItem;
  private CMTime mPosition = CMTime.CMTimeZero;
  private long mStartTime;
  private int mStatus = 1;
  private HandlerThread mThread;
  private OnGetTavExtraListener onGetTavExtraListener;
  @Nullable
  private OnReadSnapShootListener onReadSnapShootListener;
  private float rate = 1.0F;
  private RenderContext renderContext;
  private RenderContextParams renderContextParams;
  @Nullable
  private CGSize renderSize;
  @Nullable
  private PreviewReportSession reportSession;
  private long startTimeUsMark = getCurrentUsTime();
  private CGSize surfaceSize;
  private IDecoderTrack vDecoderTrack;
  
  static
  {
    map.put(1, "初始化");
    map.put(2, "播放");
    map.put(3, "暂停");
    map.put(4, "停止");
    map.put(5, "拖动");
    map.put(12, "读取下一帧");
    map.put(6, "结束线程");
  }
  
  PlayerThread(@Nullable IDecoderTrack paramIDecoderTrack, @Nullable AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack, @NonNull CGSize paramCGSize, @Nullable Surface paramSurface, @NonNull Handler paramHandler, @NonNull Player paramPlayer)
  {
    this.vDecoderTrack = paramIDecoderTrack;
    this.aDecoderTrack = paramAudioCompositionDecoderTrack;
    this.mDisplayTarget = paramSurface;
    this.mMainHandler = paramHandler;
    this.renderSize = paramCGSize;
    if (paramIDecoderTrack != null) {
      this.frameDuration = paramIDecoderTrack.getFrameDuration();
    }
    this.mPlayer = paramPlayer;
    this.mPlayerItem = paramPlayer.getCurrentItem();
    initThread();
  }
  
  private void applyViewport()
  {
    if (this.renderContext == null) {}
    while ((this.glViewportRect == null) || (this.glViewportRect.origin == null) || (this.glViewportRect.size == null)) {
      return;
    }
    this.renderContext.updateViewport(this.glViewportRect);
  }
  
  private String catLog(int paramInt)
  {
    String str2 = (String)map.get(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = String.valueOf(paramInt);
    }
    return str1;
  }
  
  private void checkCopyPixelBuffer(CMTime paramCMTime)
  {
    if (this.onReadSnapShootListener != null)
    {
      Object localObject = ByteBuffer.allocateDirect(this.renderContext.width() * this.renderContext.height() * 4);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
      ((ByteBuffer)localObject).rewind();
      GLES20.glReadPixels(0, 0, this.renderContext.width(), this.renderContext.height(), 6408, 5121, (Buffer)localObject);
      Bitmap localBitmap = Bitmap.createBitmap(this.renderContext.width(), this.renderContext.height(), Bitmap.Config.ARGB_4444);
      ((ByteBuffer)localObject).rewind();
      localBitmap.copyPixelsFromBuffer((Buffer)localObject);
      localObject = Utils.flipYBitmap(localBitmap);
      this.onReadSnapShootListener.onSuccess((Bitmap)localObject, paramCMTime);
      this.onReadSnapShootListener = null;
    }
  }
  
  private long getCurrentUsTime()
  {
    return System.nanoTime() / 1000L;
  }
  
  private CMTime getLastSeekPosAndRemoveOther()
  {
    Object localObject2 = CMTime.CMTimeInvalid;
    Object localObject1;
    Object localObject3;
    ArrayList localArrayList;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = this.mPlayHandler.getLooper().getQueue();
      localObject3 = MessageQueue.class.getDeclaredField("mMessages");
      ((Field)localObject3).setAccessible(true);
      localObject1 = (Message)((Field)localObject3).get(localObject1);
      localArrayList = new ArrayList();
      label56:
      if (localObject1 == null) {
        break label171;
      }
      if ((((Message)localObject1).what != 5) || (!(((Message)localObject1).obj instanceof PlayerMessage))) {
        break label158;
      }
      localObject3 = (CMTime)((PlayerMessage)((Message)localObject1).obj).bizMsg1;
      localArrayList.add(localObject1);
    }
    label158:
    do
    {
      localObject2 = Message.class.getDeclaredField("next");
      ((Field)localObject2).setAccessible(true);
      localObject1 = (Message)((Field)localObject2).get(localObject1);
      localObject2 = localObject3;
      break label56;
      localObject1 = Handler.class.getDeclaredField("mQueue");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (MessageQueue)((Field)localObject1).get(this.mPlayHandler);
      break;
      localObject3 = localObject2;
    } while (((Message)localObject1).getTarget() != this.mPlayHandler);
    label171:
    if (localObject2 != CMTime.CMTimeInvalid)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Message)((Iterator)localObject1).next();
        this.mPlayHandler.removeMessages(((Message)localObject3).what, ((Message)localObject3).obj);
      }
    }
    return localObject2;
  }
  
  private long getWaitTime(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = this.frameDuration.getTimeUs();
    long l2 = paramCMTime.getTimeUs();
    if ((paramBoolean1) || (paramBoolean2))
    {
      Logger.d("PlayerThreadMain", "getWaitTime - 0 " + paramBoolean1 + "  |  " + paramBoolean2);
      return 0L;
    }
    long l3 = ((float)l1 / Math.abs(this.rate));
    long l4 = l3 - this.decoderConsumerTimeUs;
    Logger.v("PlayerThreadMain", "getWaitTime--position-->" + l2 + " rate = " + this.rate + "--decoderConsumerTimeUs-->" + this.decoderConsumerTimeUs + "--frameDurationMs-->" + l1 + "--realTime-->" + l3 + "--nextFrameTime-->" + (l2 + l3) + "--sleepTime-->" + l4 + "  mStartTime = " + this.mStartTime);
    return l4;
  }
  
  private void initDecoderTrack(Object paramObject)
  {
    if ((this.renderContext == null) && (this.mDisplayTarget != null)) {
      if ((this.renderContextParams == null) || (!(this.renderContextParams.getParam("share_context") instanceof EGLContext))) {
        break label446;
      }
    }
    label437:
    label446:
    Object localObject2;
    for (Object localObject1 = (EGLContext)this.renderContextParams.getParam("share_context");; localObject2 = null)
    {
      if (localObject1 != null)
      {
        this.renderContext = new RenderContext((int)this.surfaceSize.width, (int)this.surfaceSize.height, this.mDisplayTarget, (EGLContext)localObject1);
        this.renderContext.setParams(this.renderContextParams);
        localObject1 = this.mPlayerItem.getVideoComposition();
        if (localObject1 != null)
        {
          this.renderSize = ((VideoComposition)localObject1).getRenderSize();
          this.layoutMode = ((VideoComposition)localObject1).getRenderLayoutMode();
        }
        if ((this.renderContext != null) && (this.renderSize != null))
        {
          this.renderContext.setHeight((int)this.renderSize.height);
          this.renderContext.setWidth((int)this.renderSize.width);
        }
        initViewport();
        updateProgressPreNextAction(this.mPosition);
        if (this.vDecoderTrack == null) {
          break label437;
        }
      }
      for (;;)
      {
        try
        {
          this.vDecoderTrack.setFrameRate((int)(this.frameDuration.timeScale / this.frameDuration.getValue()));
          this.vDecoderTrack.start(this.renderContext);
          if (!this.mLooper)
          {
            if (this.mPosition == CMTime.CMTimeInvalid) {
              this.mPosition = this.vDecoderTrack.getDuration();
            }
            this.vDecoderTrack.seekTo(this.mPosition, false, true);
            readSample(-1);
          }
          onCompositionUpdate(paramObject, true);
          Logger.v("PlayerThreadMain", "prepare: init codec-->" + Thread.currentThread().getName() + "--vDecoderTrack-->" + this.vDecoderTrack);
        }
        catch (Exception localException)
        {
          Logger.e("PlayerThreadMain", "init composition cause exception: ", localException);
          this.vDecoderTrack.release();
          this.vDecoderTrack = null;
          onCompositionUpdate(paramObject, false);
          continue;
        }
        if (this.aDecoderTrack != null)
        {
          this.aDecoderTrack.start();
          this.aDecoderTrack.seekTo(this.mPosition, false, false);
        }
        updateStatus(2);
        synAudioComposition();
        notifyProgressChange();
        return;
        this.renderContext = new RenderContext((int)this.surfaceSize.width, (int)this.surfaceSize.height, this.mDisplayTarget);
        break;
        onCompositionUpdate(paramObject, false);
      }
    }
  }
  
  private void initThread()
  {
    this.mThread = new HandlerThread("PlayerVideoThread");
    this.mThread.start();
    this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
    this.mAudioThread = new PlayerThreadAudio(this.aDecoderTrack, this.mMainHandler, getPlayHandler());
  }
  
  private void initViewport()
  {
    CGSize localCGSize;
    if (this.renderSize != null)
    {
      localCGSize = this.renderSize;
      if (this.layoutMode != null) {
        break label59;
      }
      this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, localCGSize);
    }
    for (;;)
    {
      applyViewport();
      this.mMainHandler.obtainMessage(3, this.glViewportRect).sendToTarget();
      return;
      localCGSize = this.surfaceSize;
      break;
      label59:
      initViewportByLayoutMode(localCGSize);
    }
  }
  
  private void initViewportByLayoutMode(CGSize paramCGSize)
  {
    switch (PlayerThread.2.$SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode[this.layoutMode.ordinal()])
    {
    default: 
      this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, paramCGSize);
      return;
    case 1: 
      this.glViewportRect = CGMathFunctions.initGLViewportFit(this.surfaceSize, paramCGSize);
      return;
    }
    this.glViewportRect = CGMathFunctions.initGLViewportFill(this.surfaceSize, paramCGSize);
  }
  
  private void isNeedEnsureLooper(int paramInt)
  {
    if (paramInt == 2) {
      this.mLooper = true;
    }
  }
  
  private boolean needNotifyProgressChange()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 23) {}
      for (Object localObject = this.mPlayHandler.getLooper().getQueue();; localObject = (MessageQueue)((Field)localObject).get(this.mPlayHandler))
      {
        Field localField = MessageQueue.class.getDeclaredField("mMessages");
        localField.setAccessible(true);
        localObject = (Message)localField.get(localObject);
        if (localObject == null) {
          break label130;
        }
        if ((((Message)localObject).what == 3) || (((Message)localObject).what == 4) || (((Message)localObject).what == 1) || (((Message)localObject).what == 850) || (((Message)localObject).what == 6)) {
          break;
        }
        break label130;
        localObject = Handler.class.getDeclaredField("mQueue");
        ((Field)localObject).setAccessible(true);
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    label130:
    return true;
  }
  
  private void notifyProgressChange()
  {
    if (needNotifyProgressChange()) {
      this.mMainHandler.obtainMessage(2, this.mPosition).sendToTarget();
    }
  }
  
  private void notifyStatus(IPlayer.PlayerStatus paramPlayerStatus, String paramString)
  {
    this.mMainHandler.obtainMessage(1, new PlayerStatusMsg(paramPlayerStatus, paramString)).sendToTarget();
  }
  
  private void onCompositionUpdate(Object paramObject, boolean paramBoolean)
  {
    if ((paramObject instanceof OnCompositionUpdateListener)) {
      ((OnCompositionUpdateListener)paramObject).onUpdated(this.mPlayer, paramBoolean);
    }
  }
  
  private void pause()
  {
    this.mLooper = false;
    this.mPause = true;
    removePendingMessage(new int[] { 12 });
    notifyStatus(IPlayer.PlayerStatus.PAUSED, "");
  }
  
  private void play()
  {
    if (this.mStatus == 1)
    {
      if ((this.vDecoderTrack != null) || (this.aDecoderTrack != null))
      {
        sendMessage(1, "not can play");
        sendMessage(2, "not can play");
      }
      return;
    }
    if (this.mStatus == 3) {
      if (this.vDecoderTrack != null)
      {
        if (!this.mPosition.smallThan(this.vDecoderTrack.getDuration())) {
          break label163;
        }
        this.vDecoderTrack.seekTo(this.mPosition, false, true);
      }
    }
    for (;;)
    {
      updateStatus(2);
      removePendingMessage(new int[] { 12 });
      this.mLooper = true;
      sendMessage(12, Integer.valueOf(2), "play");
      notifyStatus(IPlayer.PlayerStatus.PLAYING, "");
      Logger.v("PlayerThreadMain", "playm() called start play-->" + this.mStatus);
      return;
      label163:
      this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
    }
  }
  
  private void playerFinish()
  {
    Logger.d("PlayerThreadMain", "playFinish");
    if (this.vDecoderTrack != null) {}
    for (CMTime localCMTime = this.vDecoderTrack.getDuration();; localCMTime = this.mPlayer.duration())
    {
      updateProgressPreNextAction(localCMTime);
      notifyProgressChange();
      updateStatus(3);
      syncAudioOtherMsg(-1, null);
      if (this.vDecoderTrack != null) {
        this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
      }
      this.mStartTime = 0L;
      this.mLooper = false;
      notifyStatus(IPlayer.PlayerStatus.FINISHED, "");
      return;
    }
  }
  
  private void prepare(Object paramObject)
  {
    if (this.mStatus == 1)
    {
      initDecoderTrack(paramObject);
      return;
    }
    sendMessage(4, Boolean.valueOf(false), "prepare");
    sendMessage(1, paramObject, "prepare");
  }
  
  private void readSample(int paramInt)
  {
    int i;
    if (this.mAudioThread.lastSyncMessgeId == this.lastSyncMessageId)
    {
      i = 1;
      if (i == 0) {
        break label41;
      }
    }
    label41:
    for (CMTime localCMTime = this.mAudioThread.getCurrentPlayingState();; localCMTime = CMTime.CMTimeInvalid)
    {
      readSample(paramInt, localCMTime);
      return;
      i = 0;
      break;
    }
  }
  
  /* Error */
  private void readSample(int paramInt, CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 170	com/tencent/tav/player/PlayerThread:vDecoderTrack	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   4: ifnonnull +8 -> 12
    //   7: aload_0
    //   8: invokespecial 749	com/tencent/tav/player/PlayerThread:syncAudioProgress	()V
    //   11: return
    //   12: aload_0
    //   13: getfield 751	com/tencent/tav/player/PlayerThread:reportSession	Lcom/tencent/tav/report/PreviewReportSession;
    //   16: ifnonnull +14 -> 30
    //   19: aload_0
    //   20: new 753	com/tencent/tav/report/PreviewReportSession
    //   23: dup
    //   24: invokespecial 754	com/tencent/tav/report/PreviewReportSession:<init>	()V
    //   27: putfield 751	com/tencent/tav/player/PlayerThread:reportSession	Lcom/tencent/tav/report/PreviewReportSession;
    //   30: aload_0
    //   31: invokespecial 166	com/tencent/tav/player/PlayerThread:getCurrentUsTime	()J
    //   34: aload_0
    //   35: getfield 168	com/tencent/tav/player/PlayerThread:startTimeUsMark	J
    //   38: lsub
    //   39: lstore_3
    //   40: aload_0
    //   41: getfield 158	com/tencent/tav/player/PlayerThread:frameDuration	Lcom/tencent/tav/coremedia/CMTime;
    //   44: aload_0
    //   45: getfield 162	com/tencent/tav/player/PlayerThread:rate	F
    //   48: invokevirtual 758	com/tencent/tav/coremedia/CMTime:divide	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   51: invokevirtual 406	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   54: lstore 5
    //   56: lload 5
    //   58: lload_3
    //   59: lsub
    //   60: lconst_0
    //   61: lcmp
    //   62: ifle +14 -> 76
    //   65: lload 5
    //   67: lload_3
    //   68: lsub
    //   69: ldc2_w 55
    //   72: ldiv
    //   73: invokestatic 762	java/lang/Thread:sleep	(J)V
    //   76: aload_0
    //   77: aload_0
    //   78: invokespecial 166	com/tencent/tav/player/PlayerThread:getCurrentUsTime	()J
    //   81: putfield 168	com/tencent/tav/player/PlayerThread:startTimeUsMark	J
    //   84: aload_0
    //   85: iload_1
    //   86: invokespecial 764	com/tencent/tav/player/PlayerThread:isNeedEnsureLooper	(I)V
    //   89: new 766	com/tencent/tav/coremedia/CMSampleState
    //   92: dup
    //   93: invokespecial 767	com/tencent/tav/coremedia/CMSampleState:<init>	()V
    //   96: astore 11
    //   98: aload_0
    //   99: getfield 170	com/tencent/tav/player/PlayerThread:vDecoderTrack	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   102: invokeinterface 770 1 0
    //   107: astore 13
    //   109: ldc 52
    //   111: new 408	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 772
    //   121: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload_1
    //   125: invokevirtual 717	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc_w 774
    //   131: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 13
    //   136: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: ldc_w 776
    //   142: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_2
    //   146: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 424	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 463	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: iload_1
    //   156: iconst_2
    //   157: if_icmpne +10 -> 167
    //   160: aload_0
    //   161: iconst_2
    //   162: aload 13
    //   164: invokespecial 207	com/tencent/tav/player/PlayerThread:syncAudioOtherMsg	(ILjava/lang/Object;)V
    //   167: aload_0
    //   168: getfield 210	com/tencent/tav/player/PlayerThread:renderContext	Lcom/tencent/tav/decoder/RenderContext;
    //   171: invokevirtual 779	com/tencent/tav/decoder/RenderContext:makeCurrent	()V
    //   174: invokestatic 314	java/lang/System:nanoTime	()J
    //   177: lstore_3
    //   178: aload_0
    //   179: iload_1
    //   180: aload_2
    //   181: aload 13
    //   183: invokespecial 783	com/tencent/tav/player/PlayerThread:readSampleBuffer	(ILcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   186: astore_2
    //   187: invokestatic 314	java/lang/System:nanoTime	()J
    //   190: lstore 5
    //   192: invokestatic 314	java/lang/System:nanoTime	()J
    //   195: lstore 7
    //   197: aload_0
    //   198: aload_2
    //   199: invokespecial 787	com/tencent/tav/player/PlayerThread:renderSampleBuffer	(Lcom/tencent/tav/coremedia/CMSampleBuffer;)V
    //   202: aload_0
    //   203: getfield 751	com/tencent/tav/player/PlayerThread:reportSession	Lcom/tencent/tav/report/PreviewReportSession;
    //   206: lload 5
    //   208: lload_3
    //   209: lsub
    //   210: invokestatic 314	java/lang/System:nanoTime	()J
    //   213: lload 7
    //   215: lsub
    //   216: invokevirtual 791	com/tencent/tav/report/PreviewReportSession:tickPreview	(JJ)V
    //   219: aload_2
    //   220: invokevirtual 797	com/tencent/tav/coremedia/CMSampleBuffer:getState	()Lcom/tencent/tav/coremedia/CMSampleState;
    //   223: astore_2
    //   224: aload_0
    //   225: getfield 170	com/tencent/tav/player/PlayerThread:vDecoderTrack	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   228: aload_2
    //   229: invokevirtual 800	com/tencent/tav/coremedia/CMSampleState:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   232: new 148	com/tencent/tav/coremedia/CMTime
    //   235: dup
    //   236: lconst_1
    //   237: aload_2
    //   238: invokevirtual 800	com/tencent/tav/coremedia/CMSampleState:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   241: getfield 527	com/tencent/tav/coremedia/CMTime:timeScale	I
    //   244: invokespecial 156	com/tencent/tav/coremedia/CMTime:<init>	(JI)V
    //   247: invokevirtual 803	com/tencent/tav/coremedia/CMTime:add	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   250: invokeinterface 806 2 0
    //   255: aload_0
    //   256: aload_0
    //   257: invokespecial 166	com/tencent/tav/player/PlayerThread:getCurrentUsTime	()J
    //   260: aload_0
    //   261: getfield 168	com/tencent/tav/player/PlayerThread:startTimeUsMark	J
    //   264: lsub
    //   265: putfield 146	com/tencent/tav/player/PlayerThread:decoderConsumerTimeUs	J
    //   268: ldc 52
    //   270: new 408	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 808
    //   280: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload_1
    //   284: invokevirtual 717	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: ldc_w 810
    //   290: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_2
    //   294: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   297: ldc_w 812
    //   300: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: getfield 202	com/tencent/tav/player/PlayerThread:mLooper	Z
    //   307: invokevirtual 418	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   310: ldc_w 814
    //   313: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokestatic 817	java/lang/System:currentTimeMillis	()J
    //   319: aload_0
    //   320: getfield 168	com/tencent/tav/player/PlayerThread:startTimeUsMark	J
    //   323: lsub
    //   324: invokevirtual 441	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   327: invokevirtual 424	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 463	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_2
    //   334: iconst_2
    //   335: newarray long
    //   337: dup
    //   338: iconst_0
    //   339: ldc2_w 818
    //   342: lastore
    //   343: dup
    //   344: iconst_1
    //   345: ldc2_w 820
    //   348: lastore
    //   349: invokevirtual 825	com/tencent/tav/coremedia/CMSampleState:stateMatchingTo	([J)Z
    //   352: ifeq +59 -> 411
    //   355: ldc 52
    //   357: ldc_w 827
    //   360: invokestatic 463	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload_0
    //   364: invokespecial 829	com/tencent/tav/player/PlayerThread:playerFinish	()V
    //   367: return
    //   368: astore 11
    //   370: aload 11
    //   372: invokevirtual 830	java/lang/Throwable:printStackTrace	()V
    //   375: goto -299 -> 76
    //   378: astore 12
    //   380: aload 11
    //   382: astore_2
    //   383: aload 12
    //   385: astore 11
    //   387: aload 11
    //   389: invokevirtual 658	java/lang/Exception:printStackTrace	()V
    //   392: aload 11
    //   394: instanceof 832
    //   397: ifeq -129 -> 268
    //   400: aload_0
    //   401: getstatic 835	com/tencent/tav/player/IPlayer$PlayerStatus:ERROR	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   404: ldc_w 837
    //   407: invokespecial 689	com/tencent/tav/player/PlayerThread:notifyStatus	(Lcom/tencent/tav/player/IPlayer$PlayerStatus;Ljava/lang/String;)V
    //   410: return
    //   411: iconst_5
    //   412: iload_1
    //   413: if_icmpne +161 -> 574
    //   416: iconst_1
    //   417: istore 9
    //   419: aload_2
    //   420: invokevirtual 840	com/tencent/tav/coremedia/CMSampleState:getStateCode	()J
    //   423: lconst_0
    //   424: lcmp
    //   425: iflt +155 -> 580
    //   428: aload_0
    //   429: aload_2
    //   430: invokevirtual 800	com/tencent/tav/coremedia/CMSampleState:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   433: putfield 153	com/tencent/tav/player/PlayerThread:mPosition	Lcom/tencent/tav/coremedia/CMTime;
    //   436: aload_2
    //   437: astore 11
    //   439: iload 9
    //   441: ifne +24 -> 465
    //   444: aload_2
    //   445: astore 11
    //   447: aload_0
    //   448: getfield 325	com/tencent/tav/player/PlayerThread:mPlayHandler	Landroid/os/Handler;
    //   451: iconst_5
    //   452: invokevirtual 844	android/os/Handler:hasMessages	(I)Z
    //   455: ifne +10 -> 465
    //   458: aload_0
    //   459: invokespecial 581	com/tencent/tav/player/PlayerThread:notifyProgressChange	()V
    //   462: aload_2
    //   463: astore 11
    //   465: aload_0
    //   466: getfield 202	com/tencent/tav/player/PlayerThread:mLooper	Z
    //   469: ifeq +48 -> 517
    //   472: aload_0
    //   473: getfield 675	com/tencent/tav/player/PlayerThread:mPause	Z
    //   476: istore 10
    //   478: aload_0
    //   479: aload_0
    //   480: invokespecial 166	com/tencent/tav/player/PlayerThread:getCurrentUsTime	()J
    //   483: aload_0
    //   484: getfield 168	com/tencent/tav/player/PlayerThread:startTimeUsMark	J
    //   487: lsub
    //   488: ldc2_w 845
    //   491: ladd
    //   492: putfield 146	com/tencent/tav/player/PlayerThread:decoderConsumerTimeUs	J
    //   495: aload_0
    //   496: aload_0
    //   497: aload 11
    //   499: invokevirtual 800	com/tencent/tav/coremedia/CMSampleState:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   502: iload 9
    //   504: iload 10
    //   506: invokespecial 848	com/tencent/tav/player/PlayerThread:getWaitTime	(Lcom/tencent/tav/coremedia/CMTime;ZZ)J
    //   509: invokespecial 851	com/tencent/tav/player/PlayerThread:scheduleNextWork	(J)V
    //   512: aload_0
    //   513: iconst_0
    //   514: putfield 675	com/tencent/tav/player/PlayerThread:mPause	Z
    //   517: ldc 52
    //   519: new 408	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 853
    //   529: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: iload_1
    //   533: invokevirtual 717	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc_w 855
    //   539: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_0
    //   543: getfield 202	com/tencent/tav/player/PlayerThread:mLooper	Z
    //   546: invokevirtual 418	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   549: ldc_w 814
    //   552: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_0
    //   556: invokespecial 166	com/tencent/tav/player/PlayerThread:getCurrentUsTime	()J
    //   559: aload_0
    //   560: getfield 168	com/tencent/tav/player/PlayerThread:startTimeUsMark	J
    //   563: lsub
    //   564: invokevirtual 441	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   567: invokevirtual 424	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 463	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: return
    //   574: iconst_0
    //   575: istore 9
    //   577: goto -158 -> 419
    //   580: aload_2
    //   581: iconst_1
    //   582: newarray long
    //   584: dup
    //   585: iconst_0
    //   586: ldc2_w 856
    //   589: lastore
    //   590: invokevirtual 825	com/tencent/tav/coremedia/CMSampleState:stateMatchingTo	([J)Z
    //   593: ifeq +18 -> 611
    //   596: aload_0
    //   597: getfield 170	com/tencent/tav/player/PlayerThread:vDecoderTrack	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   600: getstatic 151	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   603: iconst_0
    //   604: iconst_1
    //   605: invokeinterface 544 4 0
    //   610: pop
    //   611: new 766	com/tencent/tav/coremedia/CMSampleState
    //   614: dup
    //   615: aload 13
    //   617: invokespecial 859	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   620: astore 11
    //   622: goto -157 -> 465
    //   625: astore 11
    //   627: goto -240 -> 387
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	this	PlayerThread
    //   0	630	1	paramInt	int
    //   0	630	2	paramCMTime	CMTime
    //   39	170	3	l1	long
    //   54	153	5	l2	long
    //   195	19	7	l3	long
    //   417	159	9	bool1	boolean
    //   476	29	10	bool2	boolean
    //   96	1	11	localCMSampleState	com.tencent.tav.coremedia.CMSampleState
    //   368	13	11	localThrowable	java.lang.Throwable
    //   385	236	11	localObject	Object
    //   625	1	11	localException1	Exception
    //   378	6	12	localException2	Exception
    //   107	509	13	localCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   40	56	368	java/lang/Throwable
    //   65	76	368	java/lang/Throwable
    //   167	224	378	java/lang/Exception
    //   224	268	625	java/lang/Exception
  }
  
  @NonNull
  private CMSampleBuffer readSampleBuffer(int paramInt, CMTime paramCMTime1, CMTime paramCMTime2)
  {
    if (paramInt == 5) {
      return this.vDecoderTrack.seekTo(paramCMTime1, true, true);
    }
    CMTime localCMTime = this.frameDuration.multi(this.rate);
    if (paramCMTime2.smallThan(paramCMTime1.sub(localCMTime.multi(3.0F))))
    {
      Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = // " + paramCMTime2.add(this.frameDuration));
      return this.vDecoderTrack.readSample(paramCMTime1.divide(localCMTime).multi(localCMTime));
    }
    if ((paramCMTime2.bigThan(paramCMTime1.add(localCMTime))) && (paramCMTime1.bigThan(CMTime.CMTimeZero)) && (this.mAudioThread.isFinished()))
    {
      syncAudioOtherMsg(2, paramCMTime2);
      Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = /// " + paramCMTime2.add(localCMTime));
      return this.vDecoderTrack.readSample(localCMTime);
    }
    Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = " + paramCMTime2.add(localCMTime));
    return this.vDecoderTrack.readSample(paramCMTime2.add(localCMTime));
  }
  
  private void release(Message paramMessage)
  {
    Logger.d("PlayerThreadMain", "release player - " + this);
    this.renderContext.makeCurrent();
    if ((paramMessage.obj instanceof PlayerMessage))
    {
      Object localObject = ((PlayerMessage)paramMessage.obj).bizMsg1;
      if ((localObject instanceof Runnable)) {
        ((Runnable)localObject).run();
      }
    }
    removePendingMessage(new int[0]);
    releaseAudioThread(paramMessage.what, paramMessage.obj);
    updateStatus(1);
    if (this.reportSession != null)
    {
      this.reportSession.flush();
      this.reportSession = null;
    }
  }
  
  private void releaseAudioThread(int paramInt, Object paramObject)
  {
    if (paramInt == 6)
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      Logger.d("PlayerThreadMain", "releaseAudioThread SyncMessageId = " + this.lastSyncMessageId + "  action = " + paramInt + "  obj =  " + paramObject);
      this.mAudioThread.sendMessage(paramInt, paramObject, "syncAudioStatus", this.lastSyncMessageId);
    }
  }
  
  private void releaseComposition()
  {
    if (this.vDecoderTrack == null) {
      return;
    }
    if (this.mPlayerItem.getCustomVideoCompositor() != null) {
      this.mPlayerItem.getCustomVideoCompositor().release();
    }
    this.vDecoderTrack.release();
    this.aDecoderTrack.release();
  }
  
  private void removePendingMessage(int... arg1)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleMessage() called with: removeInt = [");
    Object localObject1;
    if (???.length == 0)
    {
      localObject1 = "null";
      Logger.v("PlayerThreadMain", localObject1 + "]");
      if (???.length != 0) {
        break label122;
      }
    }
    for (;;)
    {
      synchronized (this.mPlayHandler)
      {
        if (!this.mPlayHandler.hasMessages(850))
        {
          this.mPlayHandler.removeCallbacksAndMessages(null);
          return;
          localObject1 = Integer.valueOf(???[0]);
          break;
        }
        this.mPlayHandler.removeCallbacksAndMessages(null);
        this.mPlayHandler.sendEmptyMessage(850);
      }
      label122:
      int j = ???.length;
      int i = 0;
      while (i < j)
      {
        int k = ???[i];
        this.mPlayHandler.removeMessages(k);
        i += 1;
      }
    }
  }
  
  private void renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    Logger.v("PlayerThreadMain", "renderSampleBuffer() called with: sampleBuffer = [" + paramCMSampleBuffer + "]");
    TextureInfo localTextureInfo;
    if (paramCMSampleBuffer.getTextureInfo() != null)
    {
      if (this.filter == null)
      {
        this.filter = new Filter();
        this.filter.setRendererWidth(this.renderContext.width());
        this.filter.setRendererHeight(this.renderContext.height());
      }
      this.renderContext.makeCurrent();
      localTextureInfo = paramCMSampleBuffer.getTextureInfo();
      if (this.onGetTavExtraListener != null) {
        this.onGetTavExtraListener.getTextureInfo(localTextureInfo);
      }
    }
    else
    {
      return;
    }
    applyViewport();
    this.filter.setBgColor(this.mPlayer.getBgColor());
    this.filter.applyFilter(localTextureInfo, null, localTextureInfo.getTextureMatrix());
    checkCopyPixelBuffer(paramCMSampleBuffer.getTime());
    this.renderContext.setPresentationTime(paramCMSampleBuffer.getTime().getTimeUs());
    this.renderContext.swapBuffers();
  }
  
  private void scheduleNextWork(long paramLong)
  {
    paramLong /= 1000L;
    if (paramLong > 0L)
    {
      Logger.v("scheduleNextWork", "waitTime" + paramLong);
      sendMessageDelay(12, paramLong, "schedule next");
      return;
    }
    sendMessage(12, "schedule next");
  }
  
  private void seek(CMTime paramCMTime)
  {
    if (this.mStatus == 1) {
      return;
    }
    Object localObject = CMTime.CMTimeInvalid;
    try
    {
      CMTime localCMTime = getLastSeekPosAndRemoveOther();
      localObject = localCMTime;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      syncAudioOtherMsg(5, localObject);
      return;
    }
    if (((CMTime)localObject).getValue() > -1L) {}
    for (;;)
    {
      if (this.vDecoderTrack != null)
      {
        removePendingMessage(new int[] { 12 });
        this.mPosition = ((CMTime)localObject);
        notifyProgressChange();
        syncAudioOtherMsg(3, localObject);
        syncAudioOtherMsg(5, localObject);
        readSample(5, (CMTime)localObject);
        this.mPlayHandler.postDelayed(new PlayerThread.1(this), 10L);
        return;
      }
      localObject = paramCMTime;
    }
  }
  
  private void seekPreSample()
  {
    CMTime localCMTime = this.vDecoderTrack.getCurrentSampleTime();
    if (localCMTime != CMTime.CMTimeInvalid) {
      seek(localCMTime);
    }
  }
  
  private void stop(boolean paramBoolean)
  {
    releaseComposition();
    if (this.filter != null)
    {
      this.filter.release();
      this.filter = null;
    }
    this.mStartTime = 0L;
    updateStatus(1);
    if (paramBoolean)
    {
      notifyStatus(IPlayer.PlayerStatus.STOPPED, "");
      removePendingMessage(new int[0]);
      this.mLooper = false;
    }
  }
  
  private void synAudioComposition()
  {
    if (this.aDecoderTrack != null)
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      Logger.d("PlayerThreadMain", "synAudioComposition SyncMessageId = " + this.lastSyncMessageId);
      this.mAudioThread.sendMessage(1, null, "syncAudioStatus composition", this.lastSyncMessageId);
    }
  }
  
  private void syncAudioOtherMsg(int paramInt, Object paramObject)
  {
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4) || (paramInt == 6) || (paramInt == 7) || (paramInt == -1) || (paramInt == 5))
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      Logger.d("PlayerThreadMain", "syncAudioOtherMsg SyncMessageId = " + this.lastSyncMessageId + "  action = " + paramInt + "  obj = " + paramObject);
      this.mAudioThread.sendMessage(paramInt, paramObject, "syncAudioStatus", this.lastSyncMessageId);
    }
  }
  
  private void syncAudioProgress()
  {
    if (this.aDecoderTrack != null)
    {
      if (!this.mPosition.equalsTo(this.aDecoderTrack.getCurrentSampleTime()))
      {
        this.mPosition = this.aDecoderTrack.getCurrentSampleTime();
        notifyProgressChange();
      }
      if (!this.mAudioThread.isFinished()) {
        break label62;
      }
      Logger.v("PlayerThreadMain", "processFrame() called with: finish");
      playerFinish();
    }
    label62:
    while (!this.mLooper) {
      return;
    }
    scheduleNextWork(30L);
    this.mPause = false;
  }
  
  private void udpateAudioVolumeProperties() {}
  
  private void updateAllProperties() {}
  
  private void updateAudioClipsProperties()
  {
    if (this.aDecoderTrack != null) {
      this.aDecoderTrack.release();
    }
    this.aDecoderTrack = this.mPlayerItem.initAudioCompositionDecoderTrack();
    this.aDecoderTrack.start();
    this.mAudioThread.update(this.aDecoderTrack);
    if (this.mLooper) {
      syncAudioOtherMsg(2, this.mPosition);
    }
  }
  
  private void updateComposition(Object paramObject)
  {
    Logger.i("PlayerThreadMain", "updateComposition() called with: obj = [" + paramObject + "]");
    if ((paramObject instanceof PlayerItem))
    {
      paramObject = (PlayerItem)paramObject;
      this.vDecoderTrack = paramObject.getRealDecoderTrack();
      this.aDecoderTrack = paramObject.getAudioCompositionDecoderTrack();
      this.mPlayerItem = paramObject;
    }
    if (this.vDecoderTrack != null) {
      this.frameDuration = this.vDecoderTrack.getFrameDuration();
    }
    this.mAudioThread.update(this.aDecoderTrack);
  }
  
  private void updateProgressPreNextAction(CMTime paramCMTime)
  {
    this.mPosition = paramCMTime;
  }
  
  private void updateProperties() {}
  
  private void updateStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  void bindSurface(IDecoderTrack paramIDecoderTrack, PlayerLayer paramPlayerLayer)
  {
    this.mDisplayTarget = paramPlayerLayer.surface;
    this.vDecoderTrack = paramIDecoderTrack;
    this.surfaceSize = new CGSize(paramPlayerLayer.surfaceWidth, paramPlayerLayer.surfaceHeight);
    sendMessage(1, "bind surface");
  }
  
  public void cancelAllPendingSeeks()
  {
    removePendingMessage(new int[] { 5 });
  }
  
  @Nullable
  public CGRect getGlViewportRect()
  {
    return this.glViewportRect;
  }
  
  Handler getPlayHandler()
  {
    return this.mPlayHandler;
  }
  
  public CMTime getPosition()
  {
    return this.mPosition;
  }
  
  RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject3 = null;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (paramMessage.obj == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label618;
      }
      localObject2 = ((PlayerMessage)localObject1).bizMsg1;
      if (paramMessage.what != 2) {
        syncAudioOtherMsg(paramMessage.what, paramMessage.obj);
      }
      localStringBuilder = new StringBuilder().append("handleMessage() called with: msg = [").append(catLog(paramMessage.what)).append("]--obj-->").append(localObject2).append("--from-->");
      if (localObject1 != null) {
        break label133;
      }
    }
    label133:
    for (Object localObject1 = localObject3;; localObject1 = ((PlayerMessage)localObject1).form)
    {
      Logger.v("PlayerThreadMain", (String)localObject1);
      if (this.mThread != null) {
        break label143;
      }
      return false;
      localObject1 = (PlayerMessage)paramMessage.obj;
      break;
    }
    try
    {
      label143:
      switch (paramMessage.what)
      {
      case 1: 
        prepare(localObject2);
      }
    }
    catch (Exception paramMessage)
    {
      Logger.e("PlayerThreadMain", "player error:", paramMessage);
      return false;
    }
    play();
    break label624;
    pause();
    break label624;
    label327:
    boolean bool;
    for (;;)
    {
      stop(bool);
      break;
      label335:
      bool = ((Boolean)localObject2).booleanValue();
    }
    seek((CMTime)localObject2);
    for (;;)
    {
      label359:
      readSample(i);
      label618:
      label624:
      do
      {
        i = ((Integer)localObject2).intValue();
        break label359;
        seekPreSample();
        break label624;
        updateProperties();
        break label624;
        updateAllProperties();
        break label624;
        updateAudioClipsProperties();
        break label624;
        udpateAudioVolumeProperties();
        break label624;
        paramMessage = (UpdateCompositionMessage)localObject2;
        stop(true);
        releaseComposition();
        if (paramMessage != null)
        {
          updateComposition(paramMessage.playerItem);
          prepare(paramMessage.updateListener);
          break label624;
          if ((localObject2 instanceof CGSize))
          {
            this.surfaceSize = ((CGSize)localObject2);
            initViewport();
            break label624;
            if ((localObject2 instanceof OnReadSnapShootListener))
            {
              this.onReadSnapShootListener = ((OnReadSnapShootListener)localObject2);
              break label624;
              if ((localObject2 instanceof OnGetTavExtraListener))
              {
                this.onGetTavExtraListener = ((OnGetTavExtraListener)localObject2);
                break label624;
                release(paramMessage);
                break label624;
                Logger.i("PlayerThreadMain", "quit: PlayerThreadMain " + this);
                removePendingMessage(new int[0]);
                this.mThread.quit();
                this.mThread = null;
                this.vDecoderTrack.release();
                this.aDecoderTrack.release();
                this.renderContext.release();
                this.renderContext = null;
                this.vDecoderTrack = null;
                this.aDecoderTrack = null;
                this.mPlayHandler.removeCallbacksAndMessages(null);
                break label624;
                localObject2 = null;
                break;
              }
            }
          }
        }
        return true;
        if (localObject2 != null) {
          break label335;
        }
        bool = false;
        break label327;
      } while (localObject2 != null);
      int i = 0;
    }
  }
  
  public boolean hasMessage(int paramInt)
  {
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      return this.mPlayHandler.hasMessages(paramInt);
    }
    return false;
  }
  
  public void sendMessage(int paramInt, Object paramObject, String paramString)
  {
    Logger.v("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(paramInt) + "], obj = [" + paramObject + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  public void sendMessage(int paramInt, String paramString)
  {
    Logger.v("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(paramInt) + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(null, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  public void sendMessageDelay(int paramInt, long paramLong, String paramString)
  {
    Logger.v("PlayerThreadMain", "sendMessageDelay() called with: what = [" + catLog(paramInt) + "], delay = [" + paramLong + "], from = [" + paramString + "]");
    if (this.mPlayHandler != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = new PlayerMessage(null, paramString, System.currentTimeMillis());
      this.mPlayHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setRate(float paramFloat)
  {
    this.rate = paramFloat;
    this.mAudioThread.setRate(paramFloat);
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    if (this.renderContext != null) {
      this.renderContext.setParams(paramRenderContextParams);
    }
  }
  
  public void updatePositionRightAway(CMTime paramCMTime)
  {
    this.mPosition = paramCMTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.player.PlayerThread
 * JD-Core Version:    0.7.0.1
 */