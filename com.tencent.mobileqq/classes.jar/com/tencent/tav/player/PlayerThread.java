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
import android.util.Log;
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
import com.tencent.tav.decoder.IDecoder;
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
  
  private void d(String paramString1, String paramString2)
  {
    Logger.d(paramString1, paramString2);
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
    long l3 = this.frameDuration.getTimeUs();
    long l4 = paramCMTime.getTimeUs();
    long l1;
    if ((paramBoolean1) || (paramBoolean2))
    {
      Logger.e("PlayerThreadMain", "getWaitTime - 0 " + paramBoolean1 + "  |  " + paramBoolean2);
      l1 = 0L;
    }
    long l5;
    long l2;
    do
    {
      return l1;
      l5 = ((float)l3 / Math.abs(this.rate));
      l2 = l5 - this.decoderConsumerTimeUs;
      l1 = l2;
    } while (!Logger.LOG_VERBOSE);
    d("WaitTime", "getWaitTime--position-->" + l4 + " rate = " + this.rate + "--decoderConsumerTimeUs-->" + this.decoderConsumerTimeUs + "--frameDurationMs-->" + l3 + "--realTime-->" + l5 + "--nextFrameTime-->" + (l4 + l5) + "--sleepTime-->" + l2 + "  mStartTime = " + this.mStartTime);
    return l2;
  }
  
  private void initDecoderTrack(Object paramObject)
  {
    if ((this.renderContext == null) && (this.mDisplayTarget != null)) {
      if ((this.renderContextParams == null) || (!(this.renderContextParams.getParam("share_context") instanceof EGLContext))) {
        break label468;
      }
    }
    label459:
    label468:
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
          break label459;
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
          d("PlayerThreadMain", "prepare: init codec-->" + Thread.currentThread().getName() + "--vDecoderTrack-->" + this.vDecoderTrack);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          d("PlayerThreadMain", "init composition cause exception: " + localException);
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
    if (this.renderSize != null) {}
    for (CGSize localCGSize = this.renderSize; this.layoutMode == null; localCGSize = this.surfaceSize)
    {
      this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, localCGSize);
      applyViewport();
      return;
    }
    switch (PlayerThread.2.$SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode[this.layoutMode.ordinal()])
    {
    default: 
      this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, localCGSize);
    }
    for (;;)
    {
      applyViewport();
      return;
      this.glViewportRect = CGMathFunctions.initGLViewportFit(this.surfaceSize, localCGSize);
      continue;
      this.glViewportRect = CGMathFunctions.initGLViewportFill(this.surfaceSize, localCGSize);
    }
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
          break label164;
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
      d("PlayerThreadMain", "playm() called start play-->" + this.mStatus);
      return;
      label164:
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
    for (CMTime localCMTime = this.mAudioThread.getCurrentPlayingTime();; localCMTime = CMTime.CMTimeInvalid)
    {
      readSample(paramInt, localCMTime);
      return;
      i = 0;
      break;
    }
  }
  
  private void readSample(int paramInt, CMTime paramCMTime)
  {
    if (this.vDecoderTrack == null)
    {
      syncAudioProgress();
      return;
    }
    if (this.reportSession == null) {
      this.reportSession = new PreviewReportSession();
    }
    long l1 = getCurrentUsTime() - this.startTimeUsMark;
    try
    {
      l2 = this.frameDuration.divide(this.rate).getTimeUs();
      if (l2 - l1 > 0L) {
        Thread.sleep((l2 - l1) / 1000L);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          CMTime localCMTime1;
          this.renderContext.makeCurrent();
          l1 = System.nanoTime();
          paramCMTime = readSampleBuffer(paramInt, paramCMTime, localCMTime2);
          long l2 = System.nanoTime();
          l3 = System.nanoTime();
          renderSampleBuffer(paramCMTime);
          this.reportSession.tickPreview(l2 - l1, System.nanoTime() - l3);
          paramCMTime = paramCMTime.getTime();
        }
        catch (Exception localException2)
        {
          paramCMTime = localThrowable;
          localObject = localException2;
        }
        try
        {
          this.vDecoderTrack.asyncReadNextSample(paramCMTime.add(new CMTime(1L, paramCMTime.timeScale)));
          this.decoderConsumerTimeUs = (getCurrentUsTime() - this.startTimeUsMark);
          if (Logger.LOG_VERBOSE) {
            d("PlayerThreadMain", "readSample() called with: messageId = [" + paramInt + "]--position-->" + paramCMTime + "--looper-->" + this.mLooper + " consumer = " + (System.currentTimeMillis() - this.startTimeUsMark));
          }
          if ((paramCMTime.getTimeUs() != IDecoder.SAMPLE_TIME_FINISH.getTimeUs()) && (paramCMTime.getTimeUs() != IDecoder.SAMPLE_TIME_ERROR.getTimeUs())) {
            break label428;
          }
          if (Logger.LOG_VERBOSE) {
            d("PlayerThreadMain", "readSample() called with: finish");
          }
          playerFinish();
          return;
        }
        catch (Exception localException1)
        {
          boolean bool1;
          break label404;
        }
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
      }
    }
    this.startTimeUsMark = getCurrentUsTime();
    isNeedEnsureLooper(paramInt);
    localCMTime1 = CMTime.CMTimeInvalid;
    CMTime localCMTime2 = this.vDecoderTrack.getCurrentSampleTime();
    if (Logger.LOG_VERBOSE) {
      d("PlayerThreadMain", "readSample[" + paramInt + "] lastPosition = " + localCMTime2 + " syncPlayingTime = " + paramCMTime);
    }
    if (paramInt == 2) {
      syncAudioOtherMsg(2, localCMTime2);
    }
    label404:
    do
    {
      long l3;
      ((Exception)localObject).printStackTrace();
    } while (!(localObject instanceof IllegalStateException));
    notifyStatus(IPlayer.PlayerStatus.ERROR, "解码异常");
    return;
    label428:
    if (5 == paramInt)
    {
      bool1 = true;
      label436:
      if (paramCMTime.getValue() < 0L) {
        break label598;
      }
      this.mPosition = paramCMTime;
      localObject = paramCMTime;
      if (!bool1)
      {
        localObject = paramCMTime;
        if (!this.mPlayHandler.hasMessages(5)) {
          notifyProgressChange();
        }
      }
    }
    for (Object localObject = paramCMTime;; localObject = localCMTime2)
    {
      if (this.mLooper)
      {
        boolean bool2 = this.mPause;
        this.decoderConsumerTimeUs = (getCurrentUsTime() - this.startTimeUsMark + 5000L);
        scheduleNextWork(getWaitTime((CMTime)localObject, bool1, bool2));
        this.mPause = false;
      }
      if (!Logger.LOG_VERBOSE) {
        break;
      }
      d("PlayerThreadMain", "readSample end [" + paramInt + "]--looper-->" + this.mLooper + " consumer = " + (getCurrentUsTime() - this.startTimeUsMark));
      return;
      bool1 = false;
      break label436;
      label598:
      if (paramCMTime.getTimeUs() == IDecoder.SAMPLE_TIME_UNSTART.getTimeUs()) {
        this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
      }
    }
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
      if (Logger.LOG_VERBOSE) {
        Logger.d("PlayerThreadMain", "readSampleBuffer: sampleTime = // " + paramCMTime2.add(this.frameDuration));
      }
      return this.vDecoderTrack.readSample(paramCMTime1.divide(localCMTime).multi(localCMTime));
    }
    if ((paramCMTime2.bigThan(paramCMTime1.add(localCMTime))) && (paramCMTime1.bigThan(CMTime.CMTimeZero)) && (this.mAudioThread.isFinished()))
    {
      syncAudioOtherMsg(2, paramCMTime2);
      if (Logger.LOG_VERBOSE) {
        Logger.d("PlayerThreadMain", "readSampleBuffer: sampleTime = /// " + paramCMTime2.add(localCMTime));
      }
      return this.vDecoderTrack.readSample(localCMTime);
    }
    if (Logger.LOG_VERBOSE) {
      Logger.d("PlayerThreadMain", "readSampleBuffer: sampleTime = " + paramCMTime2.add(localCMTime));
    }
    return this.vDecoderTrack.readSample(paramCMTime2.add(localCMTime));
  }
  
  private void release(Message paramMessage)
  {
    Logger.e("PlayerThreadMain", "release player - " + this);
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
    Object localObject1;
    if (Logger.LOG_VERBOSE)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleMessage() called with: removeInt = [");
      if (???.length == 0)
      {
        localObject1 = "null";
        d("PlayerThreadMain", localObject1 + "]");
      }
    }
    else
    {
      if (???.length != 0) {
        break label129;
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
      label129:
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
    if (Logger.LOG_VERBOSE) {
      Logger.d("PlayerThreadMain", "renderSampleBuffer() called with: sampleBuffer = [" + paramCMSampleBuffer + "]");
    }
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
      if (Logger.LOG_VERBOSE) {
        Logger.d("scheduleNextWork", "waitTime" + paramLong);
      }
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
        break label63;
      }
      d("PlayerThreadMain", "processFrame() called with: finish");
      playerFinish();
    }
    label63:
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
        break label650;
      }
      localObject2 = ((PlayerMessage)localObject1).bizMsg1;
      if (paramMessage.what != 2) {
        syncAudioOtherMsg(paramMessage.what, paramMessage.obj);
      }
      if (Logger.LOG_VERBOSE)
      {
        localStringBuilder = new StringBuilder().append("handleMessage() called with: msg = [").append(catLog(paramMessage.what)).append("]--obj-->").append(localObject2).append("--from-->");
        if (localObject1 != null) {
          break label140;
        }
      }
    }
    label140:
    for (Object localObject1 = localObject3;; localObject1 = ((PlayerMessage)localObject1).form)
    {
      d("PlayerThreadMain", (String)localObject1);
      if (this.mThread != null) {
        break label150;
      }
      return false;
      localObject1 = (PlayerMessage)paramMessage.obj;
      break;
    }
    try
    {
      label150:
      switch (paramMessage.what)
      {
      case 1: 
        prepare(localObject2);
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      d("PlayerThreadMain", "player error:" + Log.getStackTraceString(paramMessage));
      return false;
    }
    play();
    break label656;
    pause();
    break label656;
    label359:
    boolean bool;
    for (;;)
    {
      stop(bool);
      break;
      label367:
      bool = ((Boolean)localObject2).booleanValue();
    }
    seek((CMTime)localObject2);
    for (;;)
    {
      label391:
      readSample(i);
      label650:
      label656:
      do
      {
        i = ((Integer)localObject2).intValue();
        break label391;
        seekPreSample();
        break label656;
        updateProperties();
        break label656;
        updateAllProperties();
        break label656;
        updateAudioClipsProperties();
        break label656;
        udpateAudioVolumeProperties();
        break label656;
        paramMessage = (UpdateCompositionMessage)localObject2;
        stop(true);
        releaseComposition();
        if (paramMessage != null)
        {
          updateComposition(paramMessage.playerItem);
          prepare(paramMessage.updateListener);
          break label656;
          if ((localObject2 instanceof CGSize))
          {
            this.surfaceSize = ((CGSize)localObject2);
            initViewport();
            break label656;
            if ((localObject2 instanceof OnReadSnapShootListener))
            {
              this.onReadSnapShootListener = ((OnReadSnapShootListener)localObject2);
              break label656;
              if ((localObject2 instanceof OnGetTavExtraListener))
              {
                this.onGetTavExtraListener = ((OnGetTavExtraListener)localObject2);
                break label656;
                release(paramMessage);
                break label656;
                Logger.e("PlayerThreadMain", "quit: PlayerThreadMain " + this);
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
                break label656;
                localObject2 = null;
                break;
              }
            }
          }
        }
        return true;
        if (localObject2 != null) {
          break label367;
        }
        bool = false;
        break label359;
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
    if (Logger.LOG_VERBOSE) {
      d("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(paramInt) + "], obj = [" + paramObject + "], from = [" + paramString + "]");
    }
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  public void sendMessage(int paramInt, String paramString)
  {
    if (Logger.LOG_VERBOSE) {
      d("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(paramInt) + "], from = [" + paramString + "]");
    }
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(null, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  public void sendMessageDelay(int paramInt, long paramLong, String paramString)
  {
    if (Logger.LOG_VERBOSE) {
      d("PlayerThreadMain", "sendMessageDelay() called with: what = [" + catLog(paramInt) + "], delay = [" + paramLong + "], from = [" + paramString + "]");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.player.PlayerThread
 * JD-Core Version:    0.7.0.1
 */