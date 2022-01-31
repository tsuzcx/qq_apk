package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnTimedTextListener;
import android.media.MediaPlayer.TrackInfo;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.caputure.TPSystemCapture;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TPSystemMediaPlayer
  implements ITPPlayerBase
{
  private static final int CHECK_BUFFER_FREQUENT = 3;
  private static final int START_AUTO_SEEK_DELAY_TIME = 2000;
  private static final String TAG = "TPThumbPlayer[TPSystemMediaPlayer.java]";
  private static final int mIntervalCheckBuffering = 400;
  private boolean isSwitchingDef;
  private float mAudioGain = 1.0F;
  private long mBaseDuration = 0L;
  private int mBasePosition = 0;
  private int mBufferPercent = 0;
  private long mCgiDuration = -1L;
  private int mCgiVideoHeight = -1;
  private int mCgiVideoWidth = -1;
  private Future<?> mCheckBufferTimeOutBySystemInfoTimer = null;
  private Object mCheckBufferTimerOutByInfoLock = new Object();
  private int mCheckBufferTimeroutFrequent = 30;
  private Future<?> mCheckBuffingTimer = null;
  private Object mCheckBuffingTimerLock = new Object();
  private Object mCheckPrepareTimeoutLock = new Object();
  private Future<?> mCheckPrepareTimeoutTask = null;
  private Context mContext = null;
  private TPSystemMediaPlayer.EventHandler mEventHandler;
  private boolean mFirstAutoSeek;
  private Map<String, String> mHeader;
  private TPSystemMediaPlayer.InnerPlayerListener mInnerPlayerListener;
  private long mIntervalCheckPreparingTimeOut = 25000L;
  private boolean mIsAllowCheckBuffingByPosition = true;
  private boolean mIsBuffering = false;
  private boolean mIsLive = false;
  private boolean mIsLoopback = false;
  private boolean mIsNotSeekable = false;
  private boolean mIsStartGetCurrentPosChange = false;
  private long mLastCheckPos = 0L;
  private long mLoopEndPositionMs = 0L;
  private long mLoopStartPositionMs = 0L;
  private MediaPlayer mMediaPlayer;
  private ITPPlayerBaseListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerBaseListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerBaseListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerBaseListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerBaseListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerBaseListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener mOnTimedTextListener = new TPSystemMediaPlayer.5(this);
  private ITPPlayerBaseListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private float mPlaySpeed = 1.0F;
  private int mSelectSubtitleIndex = -1;
  private long mSkipEndPositionMs = -1L;
  private int mStartPositionMs = 0;
  private TPSystemMediaPlayer.PlayerState mState;
  private long mSwitchDefTag;
  private TPSystemCapture mTpSystemCapture;
  private String mUrl;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private int mcheckBufferPosNoChangeCount = 0;
  
  public TPSystemMediaPlayer(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInnerPlayerListener = new TPSystemMediaPlayer.InnerPlayerListener(this, null);
    initMediaPlayer();
  }
  
  private void checkBuffingEvent()
  {
    long l1 = getCurrentPositionMs();
    long l2 = this.mLastCheckPos;
    this.mLastCheckPos = l1;
    if (this.mState != TPSystemMediaPlayer.PlayerState.STARTED)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, state not equal start, state:" + this.mState);
      if ((this.mState == TPSystemMediaPlayer.PlayerState.PAUSED) && (this.mIsBuffering))
      {
        TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, pause state and send end buffering");
        this.mIsBuffering = false;
        this.mcheckBufferPosNoChangeCount = 0;
        if (this.mOnInfoListener != null) {
          this.mOnInfoListener.onInfo(201, 0L, 0L, null);
        }
      }
    }
    for (;;)
    {
      return;
      if (this.mIsLoopback) {
        if ((this.mLoopEndPositionMs > 0L) && (l1 >= this.mLoopEndPositionMs) && (!this.mIsNotSeekable))
        {
          TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, skip end, curPosition:" + l1 + ", mSkipEndPositionMs:" + this.mSkipEndPositionMs);
          this.mMediaPlayer.seekTo((int)this.mLoopStartPositionMs);
        }
      }
      for (;;)
      {
        if ((l1 == l2) && (l1 > 0L))
        {
          int i = this.mcheckBufferPosNoChangeCount + 1;
          this.mcheckBufferPosNoChangeCount = i;
          if ((i >= 3) && (!this.mIsBuffering))
          {
            this.mIsBuffering = true;
            TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, position no change,send start buffering");
            if (this.mOnInfoListener != null) {
              this.mOnInfoListener.onInfo(200, 0L, 0L, null);
            }
          }
          if (this.mcheckBufferPosNoChangeCount < this.mCheckBufferTimeroutFrequent) {
            break;
          }
          TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent post error");
          this.mMediaPlayer.stop();
          this.mState = TPSystemMediaPlayer.PlayerState.ERROR;
          this.mIsBuffering = false;
          destroyCheckBuffingTimer();
          if (this.mOnErrorListener == null) {
            break;
          }
          this.mOnErrorListener.onError(2001, formatErrorCode(-110), 0L, 0L);
          return;
          if ((this.mSkipEndPositionMs > 0L) && (l1 >= getDurationMs() - this.mSkipEndPositionMs)) {
            try
            {
              this.mMediaPlayer.pause();
              this.mMediaPlayer.stop();
              this.mState = TPSystemMediaPlayer.PlayerState.COMPLETE;
              destroyCheckBuffingTimer();
              if (this.mOnCompletionListener == null) {
                break;
              }
              this.mOnCompletionListener.onCompletion();
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
              }
            }
          }
        }
      }
    }
    if (this.mIsBuffering)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, position change, send end buffering");
      if (this.mOnInfoListener != null) {
        this.mOnInfoListener.onInfo(201, 0L, 0L, null);
      }
    }
    this.mIsBuffering = false;
    this.mcheckBufferPosNoChangeCount = 0;
    this.mIsStartGetCurrentPosChange = true;
  }
  
  /* Error */
  private void destroyCheckBufferTimeOutByInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 141	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimerOutByInfoLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 143	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 143	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 381 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 143	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_2
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	TPSystemMediaPlayer
    //   42	4	1	localObject2	Object
    //   37	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	32	37	finally
    //   32	34	37	finally
    //   38	40	37	finally
    //   2	9	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  private void destroyCheckBuffingTimer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 137	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimerLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 135	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 135	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 381 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 135	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_2
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	TPSystemMediaPlayer
    //   42	4	1	localObject2	Object
    //   37	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	32	37	finally
    //   32	34	37	finally
    //   38	40	37	finally
    //   2	9	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  private void destroyCheckPrepareTimeoutTimer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 129	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 127	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 127	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 381 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 127	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_2
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	TPSystemMediaPlayer
    //   42	4	1	localObject2	Object
    //   37	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	32	37	finally
    //   32	34	37	finally
    //   38	40	37	finally
    //   2	9	42	finally
    //   40	42	42	finally
  }
  
  private int formatErrorCode(int paramInt)
  {
    if (paramInt < 0) {
      return 10000000 - paramInt;
    }
    return 10000000 + paramInt;
  }
  
  private void initMediaPlayer()
  {
    this.mMediaPlayer = new TPMediaPlayer();
    this.mMediaPlayer.setOnPreparedListener(this.mInnerPlayerListener);
    this.mMediaPlayer.setOnCompletionListener(this.mInnerPlayerListener);
    this.mMediaPlayer.setOnErrorListener(this.mInnerPlayerListener);
    this.mMediaPlayer.setOnInfoListener(this.mInnerPlayerListener);
    this.mMediaPlayer.setOnBufferingUpdateListener(this.mInnerPlayerListener);
    this.mMediaPlayer.setOnSeekCompleteListener(this.mInnerPlayerListener);
    this.mMediaPlayer.setOnVideoSizeChangedListener(this.mInnerPlayerListener);
    if (Build.VERSION.SDK_INT >= 16) {
      this.mMediaPlayer.setOnTimedTextListener(this.mOnTimedTextListener);
    }
    Looper localLooper;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
      localLooper = Looper.myLooper();
      if (localLooper == null) {
        break label180;
      }
      this.mEventHandler = new TPSystemMediaPlayer.EventHandler(localLooper, this);
    }
    for (;;)
    {
      this.mState = TPSystemMediaPlayer.PlayerState.IDLE;
      return;
      this.mMediaPlayer.setAudioStreamType(3);
      break;
      label180:
      localLooper = Looper.getMainLooper();
      if (localLooper != null) {
        this.mEventHandler = new TPSystemMediaPlayer.EventHandler(localLooper, this);
      } else {
        this.mEventHandler = null;
      }
    }
  }
  
  private boolean isAllowCheckBufferByPosition()
  {
    if (this.mIsLive) {}
    while (getDurationMs() <= 0L) {
      return false;
    }
    return this.mIsAllowCheckBuffingByPosition;
  }
  
  private void startCheckBufferTimeOutByInfo()
  {
    synchronized (this.mCheckBufferTimerOutByInfoLock)
    {
      if (this.mCheckBufferTimeOutBySystemInfoTimer == null) {
        this.mCheckBufferTimeOutBySystemInfoTimer = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.4(this), 1200L, TimeUnit.MILLISECONDS);
      }
      return;
    }
  }
  
  private void startCheckBufferingTimer()
  {
    synchronized (this.mCheckBuffingTimerLock)
    {
      if (!isAllowCheckBufferByPosition())
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckBufferingTimer, forbidden check buffer by position");
        return;
      }
      if (this.mCheckBuffingTimer == null) {
        this.mCheckBuffingTimer = TPThreadUtil.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new TPSystemMediaPlayer.3(this), 0L, 400L, TimeUnit.MILLISECONDS);
      }
      return;
    }
  }
  
  private void startCheckPrepareTimeoutTimer()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckPrepareTimeoutTimer");
    synchronized (this.mCheckPrepareTimeoutLock)
    {
      if (this.mCheckPrepareTimeoutTask == null) {
        this.mCheckPrepareTimeoutTask = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.2(this), this.mIntervalCheckPreparingTimeOut, TimeUnit.MILLISECONDS);
      }
      return;
    }
  }
  
  private int systemTrackType2TPTrackType(int paramInt)
  {
    if (2 == paramInt) {
      return 2;
    }
    if (1 == paramInt) {
      return 1;
    }
    if (4 == paramInt) {
      return 3;
    }
    return 0;
  }
  
  private void unRegisterListener()
  {
    this.mOnPreparedListener = null;
    this.mOnCompletionListener = null;
    this.mOnInfoListener = null;
    this.mOnErrorListener = null;
    this.mOnSeekCompleteListener = null;
    this.mOnVideoSizeChangedListener = null;
    this.mOnSubtitleDataListener = null;
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2)
  {
    TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addAudioTrackSource, android mediaplayer not support");
  }
  
  @TargetApi(16)
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addSubtitleSource android mediaplayer not support ");
      return;
    }
    try
    {
      this.mMediaPlayer.addTimedTextSource(this.mContext, Uri.parse(paramString1), paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramString1, "addTimedTextSource error");
    }
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    if (this.mTpSystemCapture != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      this.mTpSystemCapture.generateImageAsyncAtTime(getCurrentPositionMs(), localTPImageGeneratorParams, paramTPCaptureCallBack);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
  }
  
  @TargetApi(16)
  public void deselectTrack(int paramInt, long paramLong)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "deselectTrack, android mediaplayer not support ");
      return;
    }
    this.mMediaPlayer.deselectTrack(paramInt);
  }
  
  public int getBufferPercent()
  {
    return this.mBufferPercent;
  }
  
  public long getCurrentPositionMs()
  {
    if ((this.mMediaPlayer == null) || (this.mState == TPSystemMediaPlayer.PlayerState.IDLE) || (this.mState == TPSystemMediaPlayer.PlayerState.INITIALIZED) || (this.mState == TPSystemMediaPlayer.PlayerState.PREPARING) || (this.mState == TPSystemMediaPlayer.PlayerState.STOPPED)) {
      return 0L;
    }
    if (this.mState == TPSystemMediaPlayer.PlayerState.PREPARED) {
      return this.mStartPositionMs;
    }
    return this.mMediaPlayer.getCurrentPosition();
  }
  
  public long getDurationMs()
  {
    if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.STARTED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED)) {
      return -1L;
    }
    if (this.mBaseDuration <= 0L) {
      this.mBaseDuration = this.mMediaPlayer.getDuration();
    }
    if (this.mCgiDuration > 0L) {
      if (this.mBaseDuration > 0L) {
        break label86;
      }
    }
    for (this.mBaseDuration = this.mCgiDuration;; this.mBaseDuration = this.mCgiDuration) {
      label86:
      do
      {
        return this.mBaseDuration;
      } while ((this.mBaseDuration <= 0L) || (Math.abs(this.mCgiDuration - this.mBaseDuration) * 100L / this.mCgiDuration <= 1L));
    }
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    return new TPProgramInfo[0];
  }
  
  public long getPropertyLong(int paramInt)
  {
    return -1L;
  }
  
  public String getPropertyString(int paramInt)
  {
    return null;
  }
  
  @TargetApi(16)
  public TPTrackInfo[] getTrackInfo()
  {
    int i = 0;
    Object localObject2 = null;
    Object localObject1;
    TPTrackInfo[] arrayOfTPTrackInfo;
    int k;
    int j;
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.mMediaPlayer.getTrackInfo();
      if (arrayOfTrackInfo == null) {
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "getTrackInfo, android getTrackInfo crash");
          localObject1 = null;
        }
      } while (localObject1 == null);
      arrayOfTPTrackInfo = new TPTrackInfo[localObject1.length];
      k = localObject1.length;
      j = 0;
    }
    for (;;)
    {
      localObject2 = arrayOfTPTrackInfo;
      if (i >= k) {
        break;
      }
      localObject2 = localObject1[i];
      TPTrackInfo localTPTrackInfo = new TPTrackInfo();
      localTPTrackInfo.name = ((MediaPlayer.TrackInfo)localObject2).getLanguage();
      localTPTrackInfo.trackType = systemTrackType2TPTrackType(((MediaPlayer.TrackInfo)localObject2).getTrackType());
      arrayOfTPTrackInfo[j] = localTPTrackInfo;
      j += 1;
      i += 1;
    }
  }
  
  public int getVideoHeight()
  {
    int j = 1;
    if (this.mVideoHeight <= 0) {
      this.mVideoHeight = this.mMediaPlayer.getVideoHeight();
    }
    int i;
    if (this.mVideoHeight <= 0)
    {
      i = 1;
      if (this.mCgiVideoHeight <= 0) {
        break label90;
      }
    }
    for (;;)
    {
      if (((i & j) != 0) && ((this.mState == TPSystemMediaPlayer.PlayerState.PREPARED) || (this.mState == TPSystemMediaPlayer.PlayerState.STARTED) || (this.mState == TPSystemMediaPlayer.PlayerState.PAUSED))) {
        this.mVideoHeight = this.mCgiVideoHeight;
      }
      return this.mVideoHeight;
      i = 0;
      break;
      label90:
      j = 0;
    }
  }
  
  public int getVideoWidth()
  {
    if (this.mVideoWidth <= 0) {
      this.mVideoWidth = this.mMediaPlayer.getVideoWidth();
    }
    if (((this.mState == TPSystemMediaPlayer.PlayerState.PREPARED) || (this.mState == TPSystemMediaPlayer.PlayerState.STARTED) || (this.mState == TPSystemMediaPlayer.PlayerState.PAUSED)) && (this.mVideoWidth <= 0) && (this.mCgiVideoWidth > 0)) {
      this.mVideoWidth = this.mCgiVideoWidth;
    }
    return this.mVideoWidth;
  }
  
  public void pause()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "pause ");
    this.mMediaPlayer.pause();
    this.mState = TPSystemMediaPlayer.PlayerState.PAUSED;
  }
  
  public void prepare()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "prepare ");
    this.mState = TPSystemMediaPlayer.PlayerState.PREPARING;
    this.mMediaPlayer.prepare();
  }
  
  public void prepareAsync()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "prepareAsync ");
    this.mState = TPSystemMediaPlayer.PlayerState.PREPARING;
    this.mMediaPlayer.prepareAsync();
    startCheckPrepareTimeoutTimer();
  }
  
  public void release()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "release ");
    this.mIsStartGetCurrentPosChange = false;
    destroyCheckPrepareTimeoutTimer();
    destroyCheckBuffingTimer();
    destroyCheckBufferTimeOutByInfo();
    this.mMediaPlayer.release();
    unRegisterListener();
    this.mEventHandler = null;
    this.mState = TPSystemMediaPlayer.PlayerState.RELEASE;
    this.isSwitchingDef = false;
  }
  
  public void reset()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "reset ");
    this.mIsStartGetCurrentPosChange = false;
    this.mMediaPlayer.reset();
    this.mSelectSubtitleIndex = -1;
    destroyCheckPrepareTimeoutTimer();
    destroyCheckBuffingTimer();
    destroyCheckBufferTimeOutByInfo();
    this.mState = TPSystemMediaPlayer.PlayerState.IDLE;
  }
  
  public void seekTo(int paramInt)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "seekTo, position: " + paramInt);
    if (this.mIsNotSeekable)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "current media is not seekable, ignore");
      return;
    }
    this.mMediaPlayer.seekTo(paramInt);
  }
  
  @TargetApi(26)
  public void seekTo(int paramInt1, int paramInt2)
  {
    int i = 0;
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.mIsNotSeekable)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "current media is not seekable, ignore");
      return;
    }
    if (Build.VERSION.SDK_INT < 26)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than " + 26 + ", use seekTo(int positionMs) instead");
      this.mMediaPlayer.seekTo(paramInt1);
      return;
    }
    if (paramInt2 == 1) {}
    for (;;)
    {
      try
      {
        this.mMediaPlayer.seekTo(paramInt1, i);
        return;
      }
      catch (Exception localException1)
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        try
        {
          this.mMediaPlayer.seekTo(paramInt1);
          return;
        }
        catch (Exception localException2)
        {
          TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException2);
          return;
        }
      }
      if (paramInt2 == 2) {
        i = 1;
      } else if (paramInt2 == 3) {
        i = 2;
      }
    }
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectProgram, android mediaplayer not support");
  }
  
  @TargetApi(16)
  public void selectTrack(int paramInt, long paramLong)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, android mediaplayer not support ");
      return;
    }
    this.mSelectSubtitleIndex = paramInt;
    this.mMediaPlayer.selectTrack(paramInt);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setAudioGainRatio, : " + paramFloat);
    this.mAudioGain = paramFloat;
    try
    {
      if (this.mMediaPlayer != null) {
        this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setAudioGainRatio ex : " + localIllegalStateException.toString());
    }
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd is null ");
      throw new IllegalArgumentException("pfd is null");
    }
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    if (paramParcelFileDescriptor != null) {
      this.mMediaPlayer.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    }
    this.mTpSystemCapture = new TPSystemCapture(paramParcelFileDescriptor.getFileDescriptor());
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    throw new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
  }
  
  public void setDataSource(String paramString)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource， url: " + paramString);
    this.mUrl = paramString;
    this.mMediaPlayer.setDataSource(paramString);
    this.mTpSystemCapture = new TPSystemCapture(paramString);
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource httpHeader， url: " + paramString);
    this.mUrl = paramString;
    this.mHeader = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.mMediaPlayer.setDataSource(this.mContext, paramMap, this.mHeader);
    this.mTpSystemCapture = new TPSystemCapture(paramString);
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setLoopback, : " + paramBoolean);
    this.mIsLoopback = paramBoolean;
    this.mMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l2 = 0L;
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
    if (this.mState == TPSystemMediaPlayer.PlayerState.ERROR) {
      throw new IllegalStateException("state error, current state is error state");
    }
    this.mIsLoopback = paramBoolean;
    long l1 = paramLong1;
    if (paramLong1 < 0L) {
      l1 = 0L;
    }
    this.mLoopStartPositionMs = l1;
    if (paramLong2 < 0L) {}
    for (paramLong1 = l2;; paramLong1 = paramLong2)
    {
      this.mLoopEndPositionMs = paramLong1;
      this.mMediaPlayer.setLooping(paramBoolean);
      return;
    }
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support audio frame out");
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mOnCompletionListener = paramIOnCompletionListener;
  }
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    this.mOnErrorListener = paramIOnErrorListener;
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    this.mOnInfoListener = paramIOnInfoListener;
  }
  
  public void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mOnPreparedListener = paramIOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramIOnSeekCompleteListener;
  }
  
  public void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    this.mOnSubtitleDataListener = paramIOnSubtitleDataListener;
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support video frame out");
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramIOnVideoSizeChangedListener;
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, : " + paramBoolean);
    if (this.mMediaPlayer == null)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, player is null");
      return;
    }
    if (paramBoolean) {
      try
      {
        this.mMediaPlayer.setVolume(0.0F, 0.0F);
        TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, true");
        return;
      }
      catch (Exception localException)
      {
        TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, Exception: " + localException.toString());
        return;
      }
    }
    this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, false, mAudioGain: " + this.mAudioGain);
  }
  
  @TargetApi(23)
  public void setPlaySpeedRatio(float paramFloat)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setPlaySpeedRatio, : " + paramFloat);
    if (Build.VERSION.SDK_INT < 23) {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "os version is too low: " + Build.VERSION.SDK_INT);
    }
    for (;;)
    {
      return;
      this.mPlaySpeed = paramFloat;
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setPlaySpeedRatio play speed:" + paramFloat);
      try
      {
        PlaybackParams localPlaybackParams = this.mMediaPlayer.getPlaybackParams();
        if (localPlaybackParams.getSpeed() != paramFloat)
        {
          localPlaybackParams.setSpeed(paramFloat);
          this.mMediaPlayer.setPlaybackParams(localPlaybackParams);
          return;
        }
      }
      catch (Exception localException)
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
      }
    }
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    switch (paramTPOptionalParam.getKey())
    {
    default: 
      return;
    case 100: 
      this.mStartPositionMs = ((int)paramTPOptionalParam.getParamLong().value);
      return;
    case 500: 
      this.mSkipEndPositionMs = paramTPOptionalParam.getParamLong().value;
      return;
    case 1: 
      this.mCgiDuration = paramTPOptionalParam.getParamLong().value;
      return;
    case 2: 
      this.mCgiVideoWidth = ((int)paramTPOptionalParam.getParamLong().value);
      return;
    case 3: 
      this.mCgiVideoHeight = ((int)paramTPOptionalParam.getParamLong().value);
      return;
    case 4: 
      this.mIsLive = paramTPOptionalParam.getParamBoolean().value;
      return;
    case 5: 
      this.mIsAllowCheckBuffingByPosition = paramTPOptionalParam.getParamBoolean().value;
      return;
    case 207: 
      this.mIntervalCheckPreparingTimeOut = paramTPOptionalParam.getParamLong().value;
      return;
    }
    this.mCheckBufferTimeroutFrequent = ((int)((paramTPOptionalParam.getParamLong().value + 400L) / 400L));
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mMediaPlayer.setSurface(paramSurface);
  }
  
  public void start()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "start ");
    this.mIsStartGetCurrentPosChange = false;
    this.mMediaPlayer.start();
    this.mState = TPSystemMediaPlayer.PlayerState.STARTED;
    if (this.mPlaySpeed != 1.0D) {
      setPlaySpeedRatio(this.mPlaySpeed);
    }
    startCheckBufferingTimer();
    if ((this.mStartPositionMs == 0) && (!this.mIsNotSeekable)) {
      this.mEventHandler.postDelayed(new TPSystemMediaPlayer.1(this), 2000L);
    }
  }
  
  public void stop()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "stop ");
    destroyCheckPrepareTimeoutTimer();
    destroyCheckBuffingTimer();
    destroyCheckBufferTimeOutByInfo();
    this.mMediaPlayer.stop();
    this.mState = TPSystemMediaPlayer.PlayerState.STOPPED;
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong) {}
  
  public void switchDefinition(String paramString, long paramLong)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, defUrl: " + paramString);
    if (this.mMediaPlayer == null)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, player is null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, defUrl is null");
      return;
    }
    try
    {
      this.isSwitchingDef = true;
      this.mSwitchDefTag = paramLong;
      this.mStartPositionMs = ((int)getCurrentPositionMs());
      release();
      initMediaPlayer();
      setDataSource(paramString);
      prepare();
      return;
    }
    catch (Exception paramString)
    {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, Exception: " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer
 * JD-Core Version:    0.7.0.1
 */