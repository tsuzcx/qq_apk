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
import com.tencent.tav.coremedia.CMSampleState;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PlayerThread
  implements Handler.Callback
{
  static final int ACTION_FINISH = -1;
  static final int ACTION_GET_TAV_EXTRA_INFO = 25;
  static final int ACTION_PAUSE = 3;
  static final int ACTION_PLAY = 2;
  static final int ACTION_POST = 101;
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
  public static HashMap<Integer, String> msgMap = new HashMap(20);
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
    msgMap.put(Integer.valueOf(-1), "ACTION_FINISH");
    msgMap.put(Integer.valueOf(1), "初始化");
    msgMap.put(Integer.valueOf(2), "播放");
    msgMap.put(Integer.valueOf(3), "暂停");
    msgMap.put(Integer.valueOf(4), "停止");
    msgMap.put(Integer.valueOf(5), "拖动");
    msgMap.put(Integer.valueOf(6), "结束线程");
    msgMap.put(Integer.valueOf(7), "ACTION_SET_VOLUME");
    msgMap.put(Integer.valueOf(9), "ACTION_SEEK_PRE_SAMPLE");
    msgMap.put(Integer.valueOf(10), "ACTION_UPDATE_PROPERTIES");
    msgMap.put(Integer.valueOf(11), "ACTION_UPDATE_COMPOSITION");
    msgMap.put(Integer.valueOf(20), "ACTION_UPDATE_ALLPROPERTIES");
    msgMap.put(Integer.valueOf(21), "ACTION_UPDATE_SIZE");
    msgMap.put(Integer.valueOf(22), "ACTION_UPDATE_AUDIOCLIP_PROPERTIES");
    msgMap.put(Integer.valueOf(23), "ACTION_UPDATE_AUDIOVOLUME_PROPERTIES");
    msgMap.put(Integer.valueOf(24), "ACTION_READ_SNAP_SHOOT_BITMAP");
    msgMap.put(Integer.valueOf(25), "ACTION_GET_TAV_EXTRA_INFO");
    msgMap.put(Integer.valueOf(850), "ACTION_QUIT");
    msgMap.put(Integer.valueOf(101), "ACTION_POST");
    msgMap.put(Integer.valueOf(12), "读取下一帧");
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
    if (this.renderContext == null) {
      return;
    }
    CGRect localCGRect = this.glViewportRect;
    if ((localCGRect != null) && (localCGRect.origin != null))
    {
      if (this.glViewportRect.size == null) {
        return;
      }
      this.renderContext.updateViewport(this.glViewportRect);
    }
  }
  
  static String catLog(int paramInt)
  {
    String str = (String)msgMap.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str))
    {
      Logger.e("PlayerThreadMain", "catLog: 未加入集合的消息定义！！！");
      return String.valueOf(paramInt);
    }
    return str;
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
    Object localObject3 = CMTime.CMTimeInvalid;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = this.mPlayHandler.getLooper().getQueue();
    }
    else
    {
      localObject1 = Handler.class.getDeclaredField("mQueue");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (MessageQueue)((Field)localObject1).get(this.mPlayHandler);
    }
    Object localObject2 = MessageQueue.class.getDeclaredField("mMessages");
    ((Field)localObject2).setAccessible(true);
    localObject2 = (Message)((Field)localObject2).get(localObject1);
    ArrayList localArrayList = new ArrayList();
    for (Object localObject1 = localObject3; localObject2 != null; localObject1 = localObject3)
    {
      if ((((Message)localObject2).what == 5) && ((((Message)localObject2).obj instanceof PlayerMessage)))
      {
        localObject3 = (CMTime)((PlayerMessage)((Message)localObject2).obj).bizMsg1;
        localArrayList.add(localObject2);
      }
      else
      {
        localObject3 = localObject1;
        if (((Message)localObject2).getTarget() == this.mPlayHandler) {
          break;
        }
      }
      localObject1 = Message.class.getDeclaredField("next");
      ((Field)localObject1).setAccessible(true);
      localObject2 = (Message)((Field)localObject1).get(localObject2);
    }
    if (localObject1 != CMTime.CMTimeInvalid)
    {
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Message)((Iterator)localObject2).next();
        this.mPlayHandler.removeMessages(((Message)localObject3).what, ((Message)localObject3).obj);
      }
    }
    return localObject1;
  }
  
  private long getWaitTime(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = this.frameDuration.getTimeUs();
    long l2 = paramCMTime.getTimeUs();
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l3 = ((float)l1 / Math.abs(this.rate));
      long l4 = l3 - this.decoderConsumerTimeUs;
      paramCMTime = new StringBuilder();
      paramCMTime.append("getWaitTime--position-->");
      paramCMTime.append(l2);
      paramCMTime.append(" rate = ");
      paramCMTime.append(this.rate);
      paramCMTime.append("--decoderConsumerTimeUs-->");
      paramCMTime.append(this.decoderConsumerTimeUs);
      paramCMTime.append("--frameDurationMs-->");
      paramCMTime.append(l1);
      paramCMTime.append("--realTime-->");
      paramCMTime.append(l3);
      paramCMTime.append("--nextFrameTime-->");
      paramCMTime.append(l2 + l3);
      paramCMTime.append("--sleepTime-->");
      paramCMTime.append(l4);
      paramCMTime.append("  mStartTime = ");
      paramCMTime.append(this.mStartTime);
      Logger.v("PlayerThreadMain", paramCMTime.toString());
      return l4;
    }
    paramCMTime = new StringBuilder();
    paramCMTime.append("getWaitTime - 0 ");
    paramCMTime.append(paramBoolean1);
    paramCMTime.append("  |  ");
    paramCMTime.append(paramBoolean2);
    Logger.d("PlayerThreadMain", paramCMTime.toString());
    return 0L;
  }
  
  private void initDecoderTrack(Object paramObject)
  {
    if ((this.renderContext == null) && (this.mDisplayTarget != null))
    {
      localObject = this.renderContextParams;
      if ((localObject != null) && ((((RenderContextParams)localObject).getParam("share_context") instanceof EGLContext))) {
        localObject = (EGLContext)this.renderContextParams.getParam("share_context");
      } else {
        localObject = null;
      }
      if (localObject != null) {
        this.renderContext = new RenderContext((int)this.surfaceSize.width, (int)this.surfaceSize.height, this.mDisplayTarget, (EGLContext)localObject);
      } else {
        this.renderContext = new RenderContext((int)this.surfaceSize.width, (int)this.surfaceSize.height, this.mDisplayTarget);
      }
      this.renderContext.setParams(this.renderContextParams);
    }
    Object localObject = this.mPlayerItem.getVideoComposition();
    if (localObject != null)
    {
      this.renderSize = ((VideoComposition)localObject).getRenderSize();
      this.layoutMode = ((VideoComposition)localObject).getRenderLayoutMode();
    }
    localObject = this.renderContext;
    if (localObject != null)
    {
      CGSize localCGSize = this.renderSize;
      if (localCGSize != null)
      {
        ((RenderContext)localObject).setHeight((int)localCGSize.height);
        this.renderContext.setWidth((int)this.renderSize.width);
      }
    }
    initViewport();
    updateProgressPreNextAction(this.mPosition);
    localObject = this.vDecoderTrack;
    if (localObject != null) {
      try
      {
        ((IDecoderTrack)localObject).setFrameRate((int)(this.frameDuration.timeScale / this.frameDuration.getValue()));
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("prepare: init codec-->");
        ((StringBuilder)localObject).append(Thread.currentThread().getName());
        ((StringBuilder)localObject).append("--vDecoderTrack-->");
        ((StringBuilder)localObject).append(this.vDecoderTrack);
        Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
      }
      catch (Exception localException)
      {
        Logger.e("PlayerThreadMain", "init composition cause exception: ", localException);
        this.vDecoderTrack.release();
        this.vDecoderTrack = null;
        onCompositionUpdate(paramObject, false);
      }
    } else {
      onCompositionUpdate(paramObject, false);
    }
    paramObject = this.aDecoderTrack;
    if (paramObject != null)
    {
      paramObject.start();
      this.aDecoderTrack.seekTo(this.mPosition, false, false);
    }
    updateStatus(2);
    synAudioComposition();
    notifyProgressChange();
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
    CGSize localCGSize = this.renderSize;
    if (localCGSize == null) {
      localCGSize = this.surfaceSize;
    }
    if (this.layoutMode == null) {
      this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, localCGSize);
    } else {
      initViewportByLayoutMode(localCGSize);
    }
    applyViewport();
    this.mMainHandler.obtainMessage(3, this.glViewportRect).sendToTarget();
  }
  
  private void initViewportByLayoutMode(CGSize paramCGSize)
  {
    int i = PlayerThread.2.$SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode[this.layoutMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, paramCGSize);
        return;
      }
      this.glViewportRect = CGMathFunctions.initGLViewportFill(this.surfaceSize, paramCGSize);
      return;
    }
    this.glViewportRect = CGMathFunctions.initGLViewportFit(this.surfaceSize, paramCGSize);
  }
  
  private void isNeedEnsureLooper(int paramInt)
  {
    if (paramInt == 2) {
      this.mLooper = true;
    }
  }
  
  private boolean isRevertModeFinish(CMTime paramCMTime)
  {
    return (this.rate < 0.0F) && (paramCMTime.value == -1L);
  }
  
  private boolean needNotifyProgressChange()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.mPlayHandler.getLooper().getQueue();
      }
      else
      {
        localObject = Handler.class.getDeclaredField("mQueue");
        ((Field)localObject).setAccessible(true);
        localObject = (MessageQueue)((Field)localObject).get(this.mPlayHandler);
      }
      Field localField = MessageQueue.class.getDeclaredField("mMessages");
      localField.setAccessible(true);
      Object localObject = (Message)localField.get(localObject);
      if (localObject != null)
      {
        if ((((Message)localObject).what != 3) && (((Message)localObject).what != 4) && (((Message)localObject).what != 1) && (((Message)localObject).what != 850))
        {
          int i = ((Message)localObject).what;
          if (i == 6) {}
        }
      }
      else {
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
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
    Logger.v("PlayerThreadMain", "pause: mLooper set to false");
    this.mPause = true;
    removePendingMessage(new int[] { 12 });
    notifyStatus(IPlayer.PlayerStatus.PAUSED, "");
  }
  
  private void play()
  {
    int i = this.mStatus;
    if (i == 1)
    {
      if ((this.vDecoderTrack != null) || (this.aDecoderTrack != null))
      {
        sendMessage(1, "not can play");
        sendMessage(2, "not can play");
      }
      return;
    }
    if (i == 3)
    {
      localObject = this.vDecoderTrack;
      if (localObject != null) {
        if (this.mPosition.smallThan(((IDecoderTrack)localObject).getDuration())) {
          this.vDecoderTrack.seekTo(this.mPosition, false, true);
        } else {
          this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
        }
      }
      updateStatus(2);
    }
    removePendingMessage(new int[] { 12 });
    this.mLooper = true;
    Logger.v("PlayerThreadMain", "play: mLooper set to true");
    sendMessage(12, Integer.valueOf(2), "play");
    notifyStatus(IPlayer.PlayerStatus.PLAYING, "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playm() called start play-->");
    ((StringBuilder)localObject).append(this.mStatus);
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
  }
  
  private void playerFinish()
  {
    Logger.d("PlayerThreadMain", "playFinish");
    Object localObject = this.vDecoderTrack;
    if (localObject != null) {
      localObject = ((IDecoderTrack)localObject).getDuration();
    } else {
      localObject = this.mPlayer.duration();
    }
    updateProgressPreNextAction((CMTime)localObject);
    notifyProgressChange();
    updateStatus(3);
    syncAudioOtherMsg(-1, null);
    localObject = this.vDecoderTrack;
    if (localObject != null) {
      ((IDecoderTrack)localObject).seekTo(CMTime.CMTimeZero, false, true);
    }
    this.mStartTime = 0L;
    this.mLooper = false;
    notifyStatus(IPlayer.PlayerStatus.FINISHED, "");
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
    if (this.mAudioThread.lastSyncMessgeId == this.lastSyncMessageId) {
      i = 1;
    } else {
      i = 0;
    }
    CMTime localCMTime;
    if (i != 0) {
      localCMTime = this.mAudioThread.getCurrentPlayingState();
    } else {
      localCMTime = CMTime.CMTimeInvalid;
    }
    readSample(paramInt, localCMTime);
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
    long l1 = getCurrentUsTime();
    long l2 = this.startTimeUsMark;
    try
    {
      l1 = this.frameDuration.divide(this.rate).getTimeUs() - (l1 - l2);
      if (l1 > 0L) {
        Thread.sleep(l1 / 1000L);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.startTimeUsMark = getCurrentUsTime();
    isNeedEnsureLooper(paramInt);
    CMSampleState localCMSampleState = new CMSampleState();
    CMTime localCMTime = this.vDecoderTrack.getCurrentSampleTime();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readSample[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("] lastPosition = ");
    ((StringBuilder)localObject).append(localCMTime);
    ((StringBuilder)localObject).append(" syncPlayingTime = ");
    ((StringBuilder)localObject).append(paramCMTime);
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
    if (paramInt == 2) {
      syncAudioOtherMsg(2, localCMTime);
    }
    localObject = localCMSampleState;
    try
    {
      this.renderContext.makeCurrent();
      localObject = localCMSampleState;
      l1 = System.nanoTime();
      localObject = localCMSampleState;
      CMSampleBuffer localCMSampleBuffer = readSampleBuffer(paramInt, paramCMTime, localCMTime);
      localObject = localCMSampleState;
      l2 = System.nanoTime();
      localObject = localCMSampleState;
      long l3 = System.nanoTime();
      localObject = localCMSampleState;
      renderSampleBuffer(localCMSampleBuffer);
      localObject = localCMSampleState;
      this.reportSession.tickPreview(l2 - l1, System.nanoTime() - l3);
      localObject = localCMSampleState;
      localCMSampleState = localCMSampleBuffer.getState();
      localObject = localCMSampleState;
      this.vDecoderTrack.asyncReadNextSample(localCMSampleState.getTime().add(new CMTime(1L, localCMSampleState.getTime().timeScale)));
      localObject = localCMSampleState;
      this.decoderConsumerTimeUs = (getCurrentUsTime() - this.startTimeUsMark);
      localObject = localCMSampleState;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if ((localException instanceof IllegalStateException))
      {
        notifyStatus(IPlayer.PlayerStatus.ERROR, "解码异常");
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readSample() called with: messageId = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]--currentSampleState-->");
    localStringBuilder.append(localObject);
    localStringBuilder.append("--looper-->");
    localStringBuilder.append(this.mLooper);
    localStringBuilder.append(" consumer = ");
    localStringBuilder.append(System.currentTimeMillis() - this.startTimeUsMark);
    Logger.v("PlayerThreadMain", localStringBuilder.toString());
    if ((!((CMSampleState)localObject).stateMatchingTo(new long[] { -1L, -3L })) && (!isRevertModeFinish(paramCMTime)))
    {
      boolean bool1;
      if (5 == paramInt) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (((CMSampleState)localObject).getStateCode() >= 0L)
      {
        this.mPosition = ((CMSampleState)localObject).getTime();
        paramCMTime = (CMTime)localObject;
        if (!bool1)
        {
          paramCMTime = (CMTime)localObject;
          if (!this.mPlayHandler.hasMessages(5))
          {
            notifyProgressChange();
            paramCMTime = (CMTime)localObject;
          }
        }
      }
      else
      {
        if (((CMSampleState)localObject).stateMatchingTo(new long[] { -100L })) {
          this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
        }
        paramCMTime = new CMSampleState(localCMTime);
      }
      if (this.mLooper)
      {
        boolean bool2 = this.mPause;
        this.decoderConsumerTimeUs = (getCurrentUsTime() - this.startTimeUsMark + 5000L);
        scheduleNextWork(getWaitTime(paramCMTime.getTime(), bool1, bool2));
        this.mPause = false;
      }
      paramCMTime = new StringBuilder();
      paramCMTime.append("readSample end [");
      paramCMTime.append(paramInt);
      paramCMTime.append("]--looper-->");
      paramCMTime.append(this.mLooper);
      paramCMTime.append(" consumer = ");
      paramCMTime.append(getCurrentUsTime() - this.startTimeUsMark);
      Logger.v("PlayerThreadMain", paramCMTime.toString());
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("readSample() called with: finish, currentSampleState = ");
    localStringBuilder.append(localObject);
    localStringBuilder.append(", syncPlayingTime = ");
    localStringBuilder.append(paramCMTime);
    Logger.v("PlayerThreadMain", localStringBuilder.toString());
    playerFinish();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readSampleBuffer: sampleTime = // ");
      localStringBuilder.append(paramCMTime2.add(this.frameDuration));
      Logger.v("PlayerThreadMain", localStringBuilder.toString());
      return this.vDecoderTrack.readSample(paramCMTime1.divide(localCMTime).multi(localCMTime));
    }
    if ((paramCMTime2.bigThan(paramCMTime1.add(localCMTime))) && (paramCMTime1.bigThan(CMTime.CMTimeZero)) && (this.mAudioThread.isFinished()))
    {
      syncAudioOtherMsg(2, paramCMTime2);
      paramCMTime1 = new StringBuilder();
      paramCMTime1.append("readSampleBuffer: sampleTime = /// ");
      paramCMTime1.append(paramCMTime2.add(localCMTime));
      Logger.v("PlayerThreadMain", paramCMTime1.toString());
      return this.vDecoderTrack.readSample(localCMTime);
    }
    paramCMTime1 = new StringBuilder();
    paramCMTime1.append("readSampleBuffer: sampleTime = ");
    paramCMTime1.append(paramCMTime2.add(localCMTime));
    Logger.v("PlayerThreadMain", paramCMTime1.toString());
    return this.vDecoderTrack.readSample(paramCMTime2.add(localCMTime));
  }
  
  private void release(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release player - ");
    ((StringBuilder)localObject).append(this);
    Logger.d("PlayerThreadMain", ((StringBuilder)localObject).toString());
    this.renderContext.makeCurrent();
    if ((paramMessage.obj instanceof PlayerMessage))
    {
      localObject = ((PlayerMessage)paramMessage.obj).bizMsg1;
      if ((localObject instanceof Runnable)) {
        ((Runnable)localObject).run();
      }
    }
    removePendingMessage(new int[0]);
    releaseAudioThread(paramMessage.what, paramMessage.obj);
    updateStatus(1);
    paramMessage = this.reportSession;
    if (paramMessage != null)
    {
      paramMessage.flush();
      this.reportSession = null;
    }
  }
  
  private void releaseAudioThread(int paramInt, Object paramObject)
  {
    if (paramInt == 6)
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("releaseAudioThread SyncMessageId = ");
      localStringBuilder.append(this.lastSyncMessageId);
      localStringBuilder.append("  action = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  obj =  ");
      localStringBuilder.append(paramObject);
      Logger.d("PlayerThreadMain", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage() called with: removeInt = [");
    int j = ???.length;
    int i = 0;
    Object localObject1;
    if (j == 0) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(???[0]);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append("]");
    Logger.v("PlayerThreadMain", localStringBuilder.toString());
    if (???.length == 0) {
      synchronized (this.mPlayHandler)
      {
        if (!this.mPlayHandler.hasMessages(850))
        {
          this.mPlayHandler.removeCallbacksAndMessages(null);
        }
        else
        {
          this.mPlayHandler.removeCallbacksAndMessages(null);
          this.mPlayHandler.sendEmptyMessage(850);
        }
        return;
      }
    }
    j = ???.length;
    while (i < j)
    {
      int k = ???[i];
      this.mPlayHandler.removeMessages(k);
      i += 1;
    }
  }
  
  private void removePendingMessageUnless(int... paramVarArgs)
  {
    try
    {
      Iterator localIterator = msgMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (Arrays.binarySearch(paramVarArgs, localInteger.intValue()) < 0) {
          this.mPlayHandler.removeMessages(localInteger.intValue());
        }
      }
      return;
    }
    catch (Exception paramVarArgs)
    {
      Logger.e("PlayerThreadMain", "removePendingMessageUnless: ", paramVarArgs);
    }
  }
  
  private void renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("renderSampleBuffer() called with: sampleBuffer = [");
    ((StringBuilder)localObject).append(paramCMSampleBuffer);
    ((StringBuilder)localObject).append("]");
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
    if (paramCMSampleBuffer.getTextureInfo() != null)
    {
      if (this.filter == null)
      {
        this.filter = new Filter();
        this.filter.setRendererWidth(this.renderContext.width());
        this.filter.setRendererHeight(this.renderContext.height());
      }
      this.renderContext.makeCurrent();
      localObject = paramCMSampleBuffer.getTextureInfo();
      OnGetTavExtraListener localOnGetTavExtraListener = this.onGetTavExtraListener;
      if (localOnGetTavExtraListener != null)
      {
        localOnGetTavExtraListener.getTextureInfo((TextureInfo)localObject);
        return;
      }
      applyViewport();
      this.filter.setBgColor(this.mPlayer.getBgColor());
      this.filter.applyFilter((TextureInfo)localObject, null, ((TextureInfo)localObject).getTextureMatrix());
      checkCopyPixelBuffer(paramCMSampleBuffer.getTime());
      this.renderContext.setPresentationTime(paramCMSampleBuffer.getTime().getTimeUs());
      this.renderContext.swapBuffers();
    }
  }
  
  private void scheduleNextWork(long paramLong)
  {
    paramLong /= 1000L;
    if (paramLong > 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("waitTime");
      localStringBuilder.append(paramLong);
      Logger.v("scheduleNextWork", localStringBuilder.toString());
      sendMessageDelay(12, paramLong, "schedule next");
      return;
    }
    sendMessage(12, "schedule next");
  }
  
  private void seek(CMTime paramCMTime)
  {
    seek(paramCMTime, null);
  }
  
  private void seek(CMTime paramCMTime, @Nullable Callback paramCallback)
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
      localException.printStackTrace();
    }
    if (((CMTime)localObject).getValue() > -1L) {
      paramCMTime = (CMTime)localObject;
    }
    if (this.vDecoderTrack != null)
    {
      removePendingMessage(new int[] { 12 });
      this.mPosition = paramCMTime;
      notifyProgressChange();
      syncAudioOtherMsg(3, paramCMTime);
      syncAudioOtherMsg(5, paramCMTime);
      readSample(5, paramCMTime);
      this.mPlayHandler.postDelayed(new PlayerThread.1(this), 10L);
    }
    else
    {
      syncAudioOtherMsg(5, paramCMTime);
    }
    if (paramCallback != null) {
      paramCallback.call();
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
    stop(paramBoolean, false);
  }
  
  private void stop(boolean paramBoolean1, boolean paramBoolean2)
  {
    releaseComposition();
    Filter localFilter = this.filter;
    if (localFilter != null)
    {
      localFilter.release();
      this.filter = null;
    }
    this.mStartTime = 0L;
    updateStatus(1);
    if (paramBoolean1)
    {
      notifyStatus(IPlayer.PlayerStatus.STOPPED, "");
      if (paramBoolean2) {
        removePendingMessageUnless(new int[] { 101, 850 });
      } else {
        removePendingMessage(new int[0]);
      }
      this.mLooper = false;
      Logger.v("PlayerThreadMain", "stop: mLooper set to false");
    }
  }
  
  private void synAudioComposition()
  {
    if (this.aDecoderTrack != null)
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("synAudioComposition SyncMessageId = ");
      localStringBuilder.append(this.lastSyncMessageId);
      Logger.d("PlayerThreadMain", localStringBuilder.toString());
      this.mAudioThread.sendMessage(1, null, "syncAudioStatus composition", this.lastSyncMessageId);
    }
  }
  
  private void syncAudioOtherMsg(int paramInt, Object paramObject)
  {
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4) || (paramInt == 6) || (paramInt == 7) || (paramInt == -1) || (paramInt == 5))
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncAudioOtherMsg SyncMessageId = ");
      localStringBuilder.append(this.lastSyncMessageId);
      localStringBuilder.append("  action = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  obj = ");
      localStringBuilder.append(paramObject);
      Logger.d("PlayerThreadMain", localStringBuilder.toString());
      this.mAudioThread.sendMessage(paramInt, paramObject, "syncAudioStatus", this.lastSyncMessageId);
    }
  }
  
  private void syncAudioProgress()
  {
    AudioCompositionDecoderTrack localAudioCompositionDecoderTrack = this.aDecoderTrack;
    if (localAudioCompositionDecoderTrack != null)
    {
      if (!this.mPosition.equalsTo(localAudioCompositionDecoderTrack.getCurrentSampleTime()))
      {
        this.mPosition = this.aDecoderTrack.getCurrentSampleTime();
        notifyProgressChange();
      }
      if (this.mAudioThread.isFinished())
      {
        Logger.v("PlayerThreadMain", "processFrame() called with: finish");
        playerFinish();
        return;
      }
      if (this.mLooper)
      {
        scheduleNextWork(30L);
        this.mPause = false;
      }
    }
  }
  
  private void udpateAudioVolumeProperties() {}
  
  private void updateAllProperties() {}
  
  private void updateAudioClipsProperties()
  {
    AudioCompositionDecoderTrack localAudioCompositionDecoderTrack = this.aDecoderTrack;
    if (localAudioCompositionDecoderTrack != null) {
      localAudioCompositionDecoderTrack.release();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateComposition() called with: obj = [");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("]");
    Logger.i("PlayerThreadMain", localStringBuilder.toString());
    if ((paramObject instanceof PlayerItem))
    {
      paramObject = (PlayerItem)paramObject;
      this.vDecoderTrack = paramObject.getRealDecoderTrack();
      this.aDecoderTrack = paramObject.getAudioCompositionDecoderTrack();
      this.mPlayerItem = paramObject;
    }
    paramObject = this.vDecoderTrack;
    if (paramObject != null) {
      this.frameDuration = paramObject.getFrameDuration();
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
    Object localObject1;
    if (paramMessage.obj == null) {
      localObject1 = null;
    } else {
      localObject1 = (PlayerMessage)paramMessage.obj;
    }
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((PlayerMessage)localObject1).bizMsg1;
      localObject3 = ((PlayerMessage)localObject1).bizMsg2;
    }
    else
    {
      localObject2 = null;
      localObject3 = localObject2;
    }
    if (paramMessage.what != 2) {
      syncAudioOtherMsg(paramMessage.what, paramMessage.obj);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage() called with: msg = [");
    localStringBuilder.append(catLog(paramMessage.what));
    localStringBuilder.append("]--obj-->");
    localStringBuilder.append(localObject2);
    localStringBuilder.append("--from-->");
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((PlayerMessage)localObject1).form;
    }
    localStringBuilder.append((String)localObject1);
    Logger.v("PlayerThreadMain", localStringBuilder.toString());
    if (this.mThread == null) {
      return false;
    }
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        i = paramMessage.what;
        if (i != 101) {
          if (i == 850) {}
        }
        switch (i)
        {
        case 6: 
          if ((localObject2 instanceof OnGetTavExtraListener))
          {
            this.onGetTavExtraListener = ((OnGetTavExtraListener)localObject2);
            return true;
            if ((localObject2 instanceof OnReadSnapShootListener))
            {
              this.onReadSnapShootListener = ((OnReadSnapShootListener)localObject2);
              return true;
              udpateAudioVolumeProperties();
              return true;
              updateAudioClipsProperties();
              return true;
              if ((localObject2 instanceof CGSize))
              {
                this.surfaceSize = ((CGSize)localObject2);
                initViewport();
                return true;
                updateAllProperties();
                return true;
                i = ((Integer)localObject2).intValue();
                readSample(i);
                return true;
                paramMessage = (UpdateCompositionMessage)localObject2;
                stop(true, true);
                releaseComposition();
                if (paramMessage != null)
                {
                  updateComposition(paramMessage.playerItem);
                  prepare(paramMessage.updateListener);
                  return true;
                  updateProperties();
                  return true;
                  seekPreSample();
                  return true;
                  release(paramMessage);
                  return true;
                }
              }
            }
          }
        case 5: 
          if ((localObject3 instanceof Callback))
          {
            seek((CMTime)localObject2, (Callback)localObject3);
            return true;
          }
          seek((CMTime)localObject2);
          return true;
          bool = ((Boolean)localObject2).booleanValue();
          stop(bool);
          return true;
        case 3: 
          pause();
          return true;
        case 2: 
          play();
          return true;
        case 1: 
          prepare(localObject2);
          return true;
          paramMessage = new StringBuilder();
          paramMessage.append("quit: PlayerThreadMain ");
          paramMessage.append(this);
          Logger.i("PlayerThreadMain", paramMessage.toString());
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
          return true;
          if ((localObject2 instanceof Runnable)) {
            ((Runnable)localObject2).run();
          }
          return true;
        }
      }
      catch (Exception paramMessage)
      {
        Logger.e("PlayerThreadMain", "player error:", paramMessage);
        return false;
      }
      switch (i)
      {
      case 11: 
      case 10: 
      case 9: 
      default: 
        switch (i)
        {
        }
        return true;
      }
      if (localObject2 == null)
      {
        i = 0;
        continue;
        if (localObject2 == null) {
          bool = false;
        }
      }
    }
  }
  
  public boolean hasMessage(int paramInt)
  {
    Handler localHandler = this.mPlayHandler;
    if ((localHandler != null) && (this.mThread != null)) {
      return localHandler.hasMessages(paramInt);
    }
    return false;
  }
  
  public boolean post(Runnable paramRunnable)
  {
    if (this.mPlayHandler == null) {
      return false;
    }
    sendMessage(101, paramRunnable, "main");
    return true;
  }
  
  public void sendMessage(int paramInt, Object paramObject1, Object paramObject2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessage() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], obj = [");
    ((StringBuilder)localObject).append(paramObject1);
    ((StringBuilder)localObject).append("], obj2 = [");
    ((StringBuilder)localObject).append(paramObject2);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.i("PlayerThreadMain", ((StringBuilder)localObject).toString());
    localObject = this.mPlayHandler;
    if ((localObject != null) && (this.mThread != null)) {
      ((Handler)localObject).obtainMessage(paramInt, new PlayerMessage(paramObject1, paramObject2, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  public void sendMessage(int paramInt, Object paramObject, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessage() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], obj = [");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
    localObject = this.mPlayHandler;
    if ((localObject != null) && (this.mThread != null)) {
      ((Handler)localObject).obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  public void sendMessage(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessage() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
    localObject = this.mPlayHandler;
    if ((localObject != null) && (this.mThread != null)) {
      ((Handler)localObject).obtainMessage(paramInt, new PlayerMessage(null, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  public void sendMessageDelay(int paramInt, long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessageDelay() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], delay = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
    if (this.mPlayHandler != null)
    {
      localObject = new Message();
      ((Message)localObject).what = paramInt;
      ((Message)localObject).obj = new PlayerMessage(null, paramString, System.currentTimeMillis());
      this.mPlayHandler.sendMessageDelayed((Message)localObject, paramLong);
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
    RenderContext localRenderContext = this.renderContext;
    if (localRenderContext != null) {
      localRenderContext.setParams(paramRenderContextParams);
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