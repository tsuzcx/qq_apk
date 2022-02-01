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
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.caputure.TPSystemCapture;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TPSystemMediaPlayer
  implements ITPPlayerBase
{
  private static final int RESET_TYPE_SEL_AUDIO_TRACK = 2;
  private static final int RESET_TYPE_SWITCH_URL = 1;
  private static final String TAG = "TPSystemMediaPlayer";
  private static final int TP_SYSTEM_PLAYER_INNER_RESTORE_STATE_ERR = -10004;
  private static final int TP_SYSTEM_PLAYER_INNER_SEL_TRACK_EXCEPTION = -10000;
  private static final int TP_SYSTEM_PLAYER_INNER_SEL_TRACK_NOT_SUPPORT = -10001;
  private static final int TP_SYSTEM_PLAYER_INNER_TRACK_INDEX_ERR = -10002;
  private static final int TP_SYSTEM_PLAYER_INNER_TRACK_TYPE_NOT_SUPPORT = -10003;
  private static final int mIntervalCheckBuffering = 400;
  private float mAudioGain = 1.0F;
  private List<TPSystemMediaPlayer.ExternalTrackInfo> mAudioTrackInfo = new ArrayList();
  private long mBaseDuration = 0L;
  private TPSystemMediaPlayer.BufferCheck mBufferCheck;
  private long mCgiDuration = -1L;
  private int mCgiVideoHeight = -1;
  private int mCgiVideoWidth = -1;
  private int mCheckBufferFrequent = 3;
  private Future<?> mCheckBufferTimeOutBySystemInfoTimer = null;
  private final Object mCheckBufferTimerOutByInfoLock = new Object();
  private int mCheckBufferTimeroutFrequent = 30;
  private final Object mCheckBuffingTimerLock = new Object();
  private final Object mCheckPrepareTimeoutLock = new Object();
  private Future<?> mCheckPrepareTimeoutTask = null;
  private Context mContext;
  private int mCurAudioTrackIndex = 0;
  private int mCurInnerAudioTrackIndex = -1;
  private ITPSysPlayerExternalSubtitle mExtSub;
  private FileDescriptor mFd;
  private Map<String, String> mHeader;
  private TPSystemMediaPlayer.InnerPlayerListener mInnerPlayerListener;
  private long mIntervalCheckPreparingTimeOut = 25000L;
  private boolean mIsAllowCheckBuffingByPosition = true;
  private volatile boolean mIsBuffering = false;
  private boolean mIsLive = false;
  private boolean mIsLoopback = false;
  private boolean mIsNotSeekable = false;
  private long mLastCheckPos = -1L;
  private TPSystemMediaPlayer.ResetActionInfo mLastestAction = null;
  private TPBaseLogger mLogger;
  private long mLoopEndPositionMs = 0L;
  private long mLoopStartPositionMs = 0L;
  private volatile MediaPlayer mMediaPlayer;
  private volatile TPSystemMediaPlayer.PlayerState mMediaPlayerState;
  private boolean mMute = false;
  private ITPPlayerBaseListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerBaseListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerBaseListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerBaseListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerBaseListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerBaseListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener mOnTimedTextListener = new TPSystemMediaPlayer.6(this);
  private ITPPlayerBaseListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private float mPlaySpeed = 1.0F;
  private long mPosChangeCount = 0L;
  private int mSelectSubtitleIndex = -1;
  private long mSkipEndPositionMs = -1L;
  private int mStartPositionMs = 0;
  private volatile TPSystemMediaPlayer.PlayerState mState;
  private List<TPSystemMediaPlayer.ExternalTrackInfo> mSubTrackInfo = new ArrayList();
  private Object mSurfaceObj;
  private boolean mSuspend = false;
  private TPSystemCapture mTpSystemCapture;
  private String mUrl;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private int mcheckBufferPosNoChangeCount = 0;
  
  public TPSystemMediaPlayer(Context paramContext, TPLoggerContext paramTPLoggerContext)
  {
    this.mLogger = new TPBaseLogger(paramTPLoggerContext, "TPSystemMediaPlayer");
    this.mContext = paramContext;
    this.mInnerPlayerListener = new TPSystemMediaPlayer.InnerPlayerListener(this, null);
    paramContext = new TPSystemMediaPlayer.ExternalTrackInfo(null);
    paramContext.info = new TPTrackInfo();
    paramContext.info.isSelected = true;
    paramContext.info.name = "audio_1";
    this.mAudioTrackInfo.add(paramContext);
    initMediaPlayer();
    this.mExtSub = new TPSysPlayerExternalSubtitle();
    this.mExtSub.setOnSubTitleListener(new TPSystemMediaPlayer.1(this));
    this.mExtSub.setPlayerPostionListener(new TPSystemMediaPlayer.2(this));
  }
  
  private void checkBuffingEvent()
  {
    long l1 = getCurrentPositionMs();
    long l2 = this.mLastCheckPos;
    this.mLastCheckPos = l1;
    Object localObject;
    if (this.mState != TPSystemMediaPlayer.PlayerState.STARTED) {
      if ((this.mState == TPSystemMediaPlayer.PlayerState.PAUSED) && (this.mIsBuffering))
      {
        this.mLogger.info("checkBuffingEvent, pause state and send end buffering");
        this.mIsBuffering = false;
        this.mcheckBufferPosNoChangeCount = 0;
        localObject = this.mOnInfoListener;
        if (localObject != null) {
          ((ITPPlayerBaseListener.IOnInfoListener)localObject).onInfo(201, 0L, 0L, null);
        }
      }
    }
    do
    {
      return;
      if (this.mIsLoopback) {
        if ((this.mLoopEndPositionMs > 0L) && (l1 >= this.mLoopEndPositionMs) && (!this.mIsNotSeekable))
        {
          this.mLogger.info("checkBuffingEvent, loopback skip end, curPosition:" + l1 + ", mLoopStartPositionMs:" + this.mLoopStartPositionMs);
          this.mMediaPlayer.seekTo((int)this.mLoopStartPositionMs);
        }
      }
      while ((this.mSkipEndPositionMs <= 0L) || (l1 < getDurationMs() - this.mSkipEndPositionMs))
      {
        if (l1 != l2) {
          this.mPosChangeCount += 1L;
        }
        if ((l1 != l2) || (l1 <= 0L)) {
          break label457;
        }
        int i = this.mcheckBufferPosNoChangeCount + 1;
        this.mcheckBufferPosNoChangeCount = i;
        if ((i >= this.mCheckBufferFrequent) && (!this.mIsBuffering))
        {
          this.mIsBuffering = true;
          this.mLogger.info("checkBuffingEvent, position no change,send start buffering");
          localObject = this.mOnInfoListener;
          if (localObject != null) {
            ((ITPPlayerBaseListener.IOnInfoListener)localObject).onInfo(200, l1, this.mBaseDuration, Long.valueOf(this.mPosChangeCount));
          }
        }
        if (this.mcheckBufferPosNoChangeCount < this.mCheckBufferTimeroutFrequent) {
          break;
        }
        this.mLogger.error("checkBuffingEvent post error");
        this.mState = TPSystemMediaPlayer.PlayerState.ERROR;
        mediaPlayerStopAndRelease();
        this.mIsBuffering = false;
        destroyCheckBuffingTimer();
        localObject = this.mOnErrorListener;
        if (localObject == null) {
          break;
        }
        ((ITPPlayerBaseListener.IOnErrorListener)localObject).onError(2001, formatErrorCode(-110), 0L, 0L);
        return;
      }
      this.mLogger.info("checkBuffingEvent, skip end, mBaseDuration: " + this.mBaseDuration + ", curPosition:" + l1 + ", mSkipEndMilsec:" + this.mSkipEndPositionMs);
      this.mState = TPSystemMediaPlayer.PlayerState.COMPLETE;
      mediaPlayerStopAndRelease();
      destroyCheckBuffingTimer();
      localObject = this.mOnCompletionListener;
    } while (localObject == null);
    ((ITPPlayerBaseListener.IOnCompletionListener)localObject).onCompletion();
    return;
    label457:
    if (this.mIsBuffering)
    {
      this.mLogger.info("checkBuffingEvent, position change, send end buffering");
      localObject = this.mOnInfoListener;
      if (localObject != null) {
        ((ITPPlayerBaseListener.IOnInfoListener)localObject).onInfo(201, l1, this.mBaseDuration, Long.valueOf(this.mPosChangeCount));
      }
    }
    this.mIsBuffering = false;
    this.mcheckBufferPosNoChangeCount = 0;
  }
  
  /* Error */
  private void destroyCheckBufferTimeOutByInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 164	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimerOutByInfoLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 166	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 166	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 460 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 166	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
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
    //   3: getfield 158	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimerLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 462	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   13: ifnull +48 -> 61
    //   16: aload_0
    //   17: getfield 462	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   20: iconst_1
    //   21: putfield 467	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck:mCheckAbort	Z
    //   24: aload_0
    //   25: getfield 462	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   28: getfield 470	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   31: ifnull +17 -> 48
    //   34: aload_0
    //   35: getfield 462	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   38: getfield 470	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   41: iconst_1
    //   42: invokeinterface 460 2 0
    //   47: pop
    //   48: aload_0
    //   49: getfield 462	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   52: aconst_null
    //   53: putfield 470	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 462	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   61: aload_1
    //   62: monitorexit
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: astore_2
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	TPSystemMediaPlayer
    //   71	4	1	localObject2	Object
    //   66	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	48	66	finally
    //   48	61	66	finally
    //   61	63	66	finally
    //   67	69	66	finally
    //   2	9	71	finally
    //   69	71	71	finally
  }
  
  /* Error */
  private void destroyCheckPrepareTimeoutTimer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 152	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 150	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 150	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 460 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 150	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
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
  
  private static int formatErrorCode(int paramInt)
  {
    long l2 = 2147483647L;
    long l1;
    if (paramInt < 0)
    {
      l1 = 10000000L - paramInt;
      if (l1 < 2147483647L) {
        break label38;
      }
      l1 = l2;
    }
    label38:
    for (;;)
    {
      return (int)l1;
      l1 = paramInt + 10000000L;
      break;
    }
  }
  
  private void handleDataSource(int paramInt)
  {
    if (paramInt <= 0) {}
    TPSystemMediaPlayer.ExternalTrackInfo localExternalTrackInfo;
    ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener;
    do
    {
      return;
      localExternalTrackInfo = (TPSystemMediaPlayer.ExternalTrackInfo)this.mAudioTrackInfo.get(paramInt);
      localIOnInfoListener = this.mOnInfoListener;
    } while (localIOnInfoListener == null);
    TPPlayerMsg.TPAudioTrackInfo localTPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
    localTPAudioTrackInfo.audioTrackUrl = localExternalTrackInfo.url;
    localTPAudioTrackInfo.keyId = localExternalTrackInfo.keyId;
    this.mLogger.info("handleDataSource, audioTrack url:" + localTPAudioTrackInfo.audioTrackUrl + ", keyId:" + localTPAudioTrackInfo.keyId);
    localIOnInfoListener.onInfo(1011, 0L, 0L, localTPAudioTrackInfo);
  }
  
  private void initMediaPlayer()
  {
    this.mMediaPlayer = mediaPlayerCreate();
    this.mState = TPSystemMediaPlayer.PlayerState.IDLE;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.IDLE;
  }
  
  private boolean isAllowCheckBufferByPosition()
  {
    if (this.mIsLive) {
      return false;
    }
    return this.mIsAllowCheckBuffingByPosition;
  }
  
  private boolean isValidRelease(TPSystemMediaPlayer.PlayerState paramPlayerState)
  {
    return paramPlayerState != TPSystemMediaPlayer.PlayerState.RELEASE;
  }
  
  private boolean isValidStop(TPSystemMediaPlayer.PlayerState paramPlayerState)
  {
    return (paramPlayerState == TPSystemMediaPlayer.PlayerState.PREPARED) || (paramPlayerState == TPSystemMediaPlayer.PlayerState.STARTED) || (paramPlayerState == TPSystemMediaPlayer.PlayerState.PAUSED);
  }
  
  private MediaPlayer mediaPlayerCreate()
  {
    TPMediaPlayer localTPMediaPlayer = new TPMediaPlayer();
    if (Build.VERSION.SDK_INT <= 19) {
      mediaPlayerExceptionHook(localTPMediaPlayer);
    }
    localTPMediaPlayer.setOnPreparedListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnCompletionListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnErrorListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnInfoListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnBufferingUpdateListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnSeekCompleteListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnVideoSizeChangedListener(this.mInnerPlayerListener);
    if (Build.VERSION.SDK_INT >= 16) {
      localTPMediaPlayer.setOnTimedTextListener(this.mOnTimedTextListener);
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      localTPMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
      return localTPMediaPlayer;
    }
    localTPMediaPlayer.setAudioStreamType(3);
    return localTPMediaPlayer;
  }
  
  private void mediaPlayerExceptionHook(MediaPlayer paramMediaPlayer)
  {
    try
    {
      Field localField = MediaPlayer.class.getDeclaredField("mEventHandler");
      localField.setAccessible(true);
      paramMediaPlayer = (Handler)localField.get(paramMediaPlayer);
      localField = Handler.class.getDeclaredField("mCallback");
      localField.setAccessible(true);
      if ((Handler.Callback)localField.get(paramMediaPlayer) == null) {
        localField.set(paramMediaPlayer, new TPSystemMediaPlayer.HookCallback(paramMediaPlayer));
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      this.mLogger.error("mediaPlayerExceptionHook, " + Log.getStackTraceString(paramMediaPlayer));
    }
  }
  
  private void mediaPlayerRelease()
  {
    if (isValidRelease(this.mMediaPlayerState))
    {
      this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.RELEASE;
      this.mLogger.info("MediaPlayer release.");
      this.mMediaPlayer.release();
    }
  }
  
  private void mediaPlayerReset()
  {
    destroyCheckPrepareTimeoutTimer();
    destroyCheckBuffingTimer();
    destroyCheckBufferTimeOutByInfo();
    mediaPlayerStopAndRelease();
    TPMediaPlayer localTPMediaPlayer = new TPMediaPlayer();
    if (Build.VERSION.SDK_INT <= 19) {
      mediaPlayerExceptionHook(localTPMediaPlayer);
    }
    localTPMediaPlayer.setOnPreparedListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnCompletionListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnErrorListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnInfoListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnBufferingUpdateListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnSeekCompleteListener(this.mInnerPlayerListener);
    localTPMediaPlayer.setOnVideoSizeChangedListener(this.mInnerPlayerListener);
    if (Build.VERSION.SDK_INT >= 16) {
      localTPMediaPlayer.setOnTimedTextListener(this.mOnTimedTextListener);
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      localTPMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
      if (!this.mMute) {
        break label205;
      }
      this.mMediaPlayer.setVolume(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.mPlaySpeed != 1.0D) {
        setPlaySpeedRatio(this.mPlaySpeed);
      }
      if (this.mIsLoopback) {
        this.mMediaPlayer.setLooping(this.mIsLoopback);
      }
      this.mMediaPlayer = localTPMediaPlayer;
      return;
      localTPMediaPlayer.setAudioStreamType(3);
      break;
      label205:
      if (this.mAudioGain != 1.0F) {
        this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
      }
    }
  }
  
  private void mediaPlayerStopAndRelease()
  {
    unRegisterListener();
    mediaPlayerstop();
    mediaPlayerRelease();
  }
  
  private void mediaPlayerstop()
  {
    if (isValidStop(this.mMediaPlayerState))
    {
      this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.STOPPED;
      this.mLogger.info("MediaPlayer stop.");
      this.mMediaPlayer.stop();
    }
  }
  
  private void playerResetEnd()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.mLastestAction;
        this.mLogger.info("playerResetEnd, actionInfo:" + localObject1 + ", mSuspend:" + this.mSuspend);
        if ((localObject1 == null) || (!this.mSuspend)) {
          break label464;
        }
        ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
        int i;
        if (((TPSystemMediaPlayer.ResetActionInfo)localObject1).mResetType == 1)
        {
          i = 3;
          if (localIOnInfoListener != null) {
            localIOnInfoListener.onInfo(i, 1000L, 0L, Long.valueOf(((TPSystemMediaPlayer.ResetActionInfo)localObject1).opaque));
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            if (((TPSystemMediaPlayer.ResetActionInfo)localObject1).innerAudioTrackIndex > 0) {
              this.mMediaPlayer.selectTrack(((TPSystemMediaPlayer.ResetActionInfo)localObject1).innerAudioTrackIndex);
            }
            if (((TPSystemMediaPlayer.ResetActionInfo)localObject1).innerSubtitleTrackIndex > 0) {
              this.mMediaPlayer.selectTrack(((TPSystemMediaPlayer.ResetActionInfo)localObject1).innerSubtitleTrackIndex);
            }
          }
          if ((((TPSystemMediaPlayer.ResetActionInfo)localObject1).position > 0L) && (!this.mIsNotSeekable)) {
            this.mLogger.info("playerResetEnd, onPrepared(), and seek to:" + ((TPSystemMediaPlayer.ResetActionInfo)localObject1).position);
          }
        }
        try
        {
          this.mMediaPlayer.seekTo((int)((TPSystemMediaPlayer.ResetActionInfo)localObject1).position);
          this.mLogger.info("playerResetEnd, restore state:" + ((TPSystemMediaPlayer.ResetActionInfo)localObject1).state);
          if ((((TPSystemMediaPlayer.ResetActionInfo)localObject1).state == TPSystemMediaPlayer.PlayerState.IDLE) || (((TPSystemMediaPlayer.ResetActionInfo)localObject1).state == TPSystemMediaPlayer.PlayerState.INITIALIZED) || (((TPSystemMediaPlayer.ResetActionInfo)localObject1).state == TPSystemMediaPlayer.PlayerState.PREPARING))
          {
            this.mState = TPSystemMediaPlayer.PlayerState.PREPARED;
            localObject1 = this.mOnPreparedListener;
            if (localObject1 != null) {
              ((ITPPlayerBaseListener.IOnPreparedListener)localObject1).onPrepared();
            }
            this.mSuspend = false;
            this.mLastestAction = null;
            return;
            i = 4;
          }
        }
        catch (Exception localException2)
        {
          this.mLogger.printException(localException2);
          continue;
        }
        if (localObject2.state == TPSystemMediaPlayer.PlayerState.PREPARED) {
          break label334;
        }
      }
      finally {}
      if (localObject2.state == TPSystemMediaPlayer.PlayerState.PAUSED)
      {
        label334:
        this.mState = localObject2.state;
        continue;
      }
      if (localObject2.state == TPSystemMediaPlayer.PlayerState.STARTED)
      {
        this.mLogger.info("playerResetEnd,  MediaPlayer.start().");
        this.mMediaPlayer.start();
        this.mState = localObject2.state;
        this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.STARTED;
        startCheckBufferingTimer();
        continue;
      }
      this.mLogger.error("illegal state, state:" + localObject2.state);
      this.mState = TPSystemMediaPlayer.PlayerState.ERROR;
      mediaPlayerStopAndRelease();
      Object localObject3 = this.mOnErrorListener;
      if (localObject3 == null) {
        continue;
      }
      ((ITPPlayerBaseListener.IOnErrorListener)localObject3).onError(2000, formatErrorCode(-10004), 0L, 0L);
      continue;
      label464:
      if ((this.mStartPositionMs > 0) && (!this.mIsNotSeekable)) {
        this.mLogger.info("onPrepared(), and seekto:" + this.mStartPositionMs);
      }
      try
      {
        this.mMediaPlayer.seekTo(this.mStartPositionMs);
        this.mState = TPSystemMediaPlayer.PlayerState.PREPARED;
        localObject3 = this.mOnPreparedListener;
        if (localObject3 == null) {
          continue;
        }
        ((ITPPlayerBaseListener.IOnPreparedListener)localObject3).onPrepared();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          this.mLogger.printException(localException1);
        }
      }
    }
  }
  
  private void playerResetStart(TPSystemMediaPlayer.ResetActionInfo paramResetActionInfo)
  {
    label403:
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramResetActionInfo.url;
        paramResetActionInfo.position = getCurrentPositionMs();
        paramResetActionInfo.state = this.mState;
        paramResetActionInfo.innerAudioTrackIndex = this.mCurInnerAudioTrackIndex;
        paramResetActionInfo.innerSubtitleTrackIndex = this.mSelectSubtitleIndex;
        this.mLogger.info("playerResetStart, pos:" + paramResetActionInfo.position + ", state:" + paramResetActionInfo.state);
        this.mSuspend = true;
        mediaPlayerReset();
        this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.IDLE;
        if (this.mFd != null)
        {
          this.mMediaPlayer.setDataSource(this.mFd);
          this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
          if (this.mSurfaceObj != null) {
            break label349;
          }
          this.mMediaPlayer.setDisplay(null);
          localObject = this.mLastestAction;
          if ((localObject != null) && (((TPSystemMediaPlayer.ResetActionInfo)localObject).mResetType != paramResetActionInfo.mResetType))
          {
            ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
            if (((TPSystemMediaPlayer.ResetActionInfo)localObject).mResetType != 1) {
              break label403;
            }
            i = 3;
            if (localIOnInfoListener != null) {
              localIOnInfoListener.onInfo(i, ((TPSystemMediaPlayer.ResetActionInfo)localObject).opaque, 0L, null);
            }
            paramResetActionInfo.state = ((TPSystemMediaPlayer.ResetActionInfo)localObject).state;
            paramResetActionInfo.position = ((TPSystemMediaPlayer.ResetActionInfo)localObject).position;
          }
          this.mLastestAction = paramResetActionInfo;
          if ((paramResetActionInfo.state == TPSystemMediaPlayer.PlayerState.PREPARING) || (paramResetActionInfo.state == TPSystemMediaPlayer.PlayerState.PREPARED) || (paramResetActionInfo.state == TPSystemMediaPlayer.PlayerState.STARTED) || (paramResetActionInfo.state == TPSystemMediaPlayer.PlayerState.PAUSED))
          {
            this.mMediaPlayer.prepareAsync();
            this.mState = TPSystemMediaPlayer.PlayerState.PREPARING;
            this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.PREPARING;
            startCheckPrepareTimeoutTimer();
          }
          return;
        }
        handleDataSource(paramResetActionInfo.externalAudioTrackIndex);
        if ((this.mHeader != null) && (!this.mHeader.isEmpty()))
        {
          localObject = Uri.parse((String)localObject);
          this.mMediaPlayer.setDataSource(this.mContext, (Uri)localObject, this.mHeader);
          continue;
        }
        this.mMediaPlayer.setDataSource((String)localObject);
      }
      finally {}
      continue;
      label349:
      if ((this.mSurfaceObj instanceof SurfaceHolder))
      {
        this.mMediaPlayer.setDisplay((SurfaceHolder)this.mSurfaceObj);
      }
      else if ((this.mSurfaceObj instanceof Surface))
      {
        this.mMediaPlayer.setSurface((Surface)this.mSurfaceObj);
        continue;
        i = 4;
      }
    }
  }
  
  private void seekToComm(MediaPlayer paramMediaPlayer, int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 26)
    {
      this.mLogger.info("os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than " + 26 + ", use seekTo(int positionMs) instead");
      paramMediaPlayer.seekTo(paramInt1);
      return;
    }
    if (paramInt2 == 1) {}
    for (;;)
    {
      long l = paramInt1;
      try
      {
        paramMediaPlayer.seekTo(l, i);
        return;
      }
      catch (Exception localException)
      {
        this.mLogger.printException(localException);
        try
        {
          paramMediaPlayer.seekTo(paramInt1);
          return;
        }
        catch (Exception paramMediaPlayer)
        {
          this.mLogger.printException(paramMediaPlayer);
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
  
  private void selectAudioTrack(int paramInt, long paramLong)
  {
    TPSystemMediaPlayer.ResetActionInfo localResetActionInfo = new TPSystemMediaPlayer.ResetActionInfo(null);
    localResetActionInfo.opaque = paramLong;
    localResetActionInfo.externalAudioTrackIndex = paramInt;
    localResetActionInfo.mResetType = 2;
    localResetActionInfo.url = this.mUrl;
    playerResetStart(localResetActionInfo);
  }
  
  private void selectSubTrack(int paramInt, long paramLong)
  {
    this.mExtSub.reset();
    TPSystemMediaPlayer.ExternalTrackInfo localExternalTrackInfo = (TPSystemMediaPlayer.ExternalTrackInfo)this.mSubTrackInfo.get(paramInt);
    this.mExtSub.setDataSource(localExternalTrackInfo.url);
    this.mExtSub.prepare();
  }
  
  private void startCheckBufferTimeOutByInfo()
  {
    synchronized (this.mCheckBufferTimerOutByInfoLock)
    {
      if (this.mCheckBufferTimeOutBySystemInfoTimer == null) {
        this.mCheckBufferTimeOutBySystemInfoTimer = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.5(this), this.mCheckBufferTimeroutFrequent * 400, TimeUnit.MILLISECONDS);
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
        this.mLogger.info("startCheckBufferingTimer, forbidden check buffer by position");
        return;
      }
      if (this.mBufferCheck == null)
      {
        this.mBufferCheck = new TPSystemMediaPlayer.BufferCheck(null);
        TPSystemMediaPlayer.BufferCheck localBufferCheck = this.mBufferCheck;
        this.mBufferCheck.mCheckAbort = false;
        this.mBufferCheck.mCheckBuffingTimer = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.4(this, localBufferCheck), 0L, TimeUnit.MILLISECONDS);
      }
      return;
    }
  }
  
  private void startCheckPrepareTimeoutTimer()
  {
    this.mLogger.info("startCheckPrepareTimeoutTimer");
    synchronized (this.mCheckPrepareTimeoutLock)
    {
      if (this.mCheckPrepareTimeoutTask == null) {
        this.mCheckPrepareTimeoutTask = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.3(this), this.mIntervalCheckPreparingTimeOut, TimeUnit.MILLISECONDS);
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
    this.mMediaPlayer.setOnPreparedListener(null);
    this.mMediaPlayer.setOnCompletionListener(null);
    this.mMediaPlayer.setOnErrorListener(null);
    this.mMediaPlayer.setOnInfoListener(null);
    this.mMediaPlayer.setOnBufferingUpdateListener(null);
    this.mMediaPlayer.setOnSeekCompleteListener(null);
    this.mMediaPlayer.setOnVideoSizeChangedListener(null);
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      this.mLogger.error("addAudioTrackSource, illegal argument.");
      return;
    }
    TPTrackInfo localTPTrackInfo = new TPTrackInfo();
    localTPTrackInfo.name = paramString2;
    localTPTrackInfo.isExclusive = true;
    localTPTrackInfo.isInternal = false;
    localTPTrackInfo.isSelected = false;
    localTPTrackInfo.trackType = 2;
    TPSystemMediaPlayer.ExternalTrackInfo localExternalTrackInfo = new TPSystemMediaPlayer.ExternalTrackInfo(null);
    localExternalTrackInfo.info = localTPTrackInfo;
    localExternalTrackInfo.url = paramString1;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramList = (TPOptionalParam)paramString1.next();
      if (paramList.getKey() == 6) {
        localExternalTrackInfo.keyId = paramList.getParamString().value;
      }
    }
    this.mLogger.info("addAudioTrackSource, name:" + localTPTrackInfo.name + ", url:" + paramString2);
    this.mAudioTrackInfo.add(localExternalTrackInfo);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      this.mLogger.error("addSubtitleSource, illegal argument.");
      return;
    }
    paramString2 = new TPTrackInfo();
    paramString2.name = paramString3;
    paramString2.isExclusive = true;
    paramString2.isInternal = false;
    paramString2.isSelected = false;
    paramString2.trackType = 3;
    TPSystemMediaPlayer.ExternalTrackInfo localExternalTrackInfo = new TPSystemMediaPlayer.ExternalTrackInfo(null);
    localExternalTrackInfo.info = paramString2;
    localExternalTrackInfo.url = paramString1;
    this.mLogger.info("addSubtitleSource, name:" + paramString2.name + ", url:" + paramString3);
    this.mSubTrackInfo.add(localExternalTrackInfo);
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
      this.mTpSystemCapture.generateImageAsyncAtTime(paramTPCaptureParams.requestedTimeMs, localTPImageGeneratorParams, paramTPCaptureCallBack);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
  }
  
  @TargetApi(16)
  public void deselectTrack(int paramInt, long paramLong)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mLogger.error("deselectTrack, android mediaplayer not support ");
      return;
    }
    this.mMediaPlayer.deselectTrack(paramInt);
  }
  
  public long getCurrentPositionMs()
  {
    if (this.mIsLive) {
      return 0L;
    }
    if ((this.mSuspend) || (this.mState == TPSystemMediaPlayer.PlayerState.ERROR))
    {
      if (this.mLastCheckPos == -1L) {
        return this.mStartPositionMs;
      }
      return this.mLastCheckPos;
    }
    if ((this.mState == TPSystemMediaPlayer.PlayerState.IDLE) || (this.mState == TPSystemMediaPlayer.PlayerState.INITIALIZED) || (this.mState == TPSystemMediaPlayer.PlayerState.PREPARING) || (this.mState == TPSystemMediaPlayer.PlayerState.STOPPED) || (this.mState == TPSystemMediaPlayer.PlayerState.PREPARED)) {
      return this.mStartPositionMs;
    }
    return this.mMediaPlayer.getCurrentPosition();
  }
  
  public long getDurationMs()
  {
    if (this.mIsLive) {
      return 0L;
    }
    if (this.mSuspend) {
      return this.mBaseDuration;
    }
    if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.STARTED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED)) {
      return -1L;
    }
    if (this.mBaseDuration <= 0L) {
      this.mBaseDuration = this.mMediaPlayer.getDuration();
    }
    if (this.mCgiDuration > 0L)
    {
      if (this.mBaseDuration > 0L) {
        break label107;
      }
      this.mBaseDuration = this.mCgiDuration;
    }
    for (;;)
    {
      return this.mBaseDuration;
      label107:
      if (Math.abs(this.mCgiDuration - this.mBaseDuration) * 100L / this.mCgiDuration > 1L) {
        this.mBaseDuration = this.mCgiDuration;
      }
    }
  }
  
  public int getNativePlayerId()
  {
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    return 0L;
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
    int j = 0;
    if (((this.mState == TPSystemMediaPlayer.PlayerState.PREPARED) || (this.mState == TPSystemMediaPlayer.PlayerState.STARTED) || (this.mState == TPSystemMediaPlayer.PlayerState.PAUSED)) && (TPCommonUtils.SDK_INT > 16)) {}
    Object localObject;
    for (;;)
    {
      try
      {
        MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.mMediaPlayer.getTrackInfo();
        if ((arrayOfTrackInfo != null) || (!this.mAudioTrackInfo.isEmpty()) || (!this.mSubTrackInfo.isEmpty())) {
          break;
        }
        return new TPTrackInfo[0];
      }
      catch (Exception localException)
      {
        this.mLogger.error("getTrackInfo, android getTrackInfo crash");
      }
      localObject = null;
    }
    int k = this.mAudioTrackInfo.size();
    int m = this.mSubTrackInfo.size();
    if (localObject == null) {}
    TPTrackInfo[] arrayOfTPTrackInfo;
    for (int i = 0;; i = localObject.length)
    {
      arrayOfTPTrackInfo = new TPTrackInfo[i + (m + k)];
      localIterator = this.mAudioTrackInfo.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        arrayOfTPTrackInfo[i] = ((TPSystemMediaPlayer.ExternalTrackInfo)localIterator.next()).info;
        i += 1;
      }
    }
    Iterator localIterator = this.mSubTrackInfo.iterator();
    while (localIterator.hasNext())
    {
      arrayOfTPTrackInfo[i] = ((TPSystemMediaPlayer.ExternalTrackInfo)localIterator.next()).info;
      i += 1;
    }
    if ((localObject == null) || (localObject.length <= 0)) {
      return arrayOfTPTrackInfo;
    }
    k = localObject.length;
    while (j < k)
    {
      localIterator = localObject[j];
      TPTrackInfo localTPTrackInfo = new TPTrackInfo();
      localTPTrackInfo.name = localIterator.getLanguage();
      localTPTrackInfo.trackType = systemTrackType2TPTrackType(localIterator.getTrackType());
      arrayOfTPTrackInfo[i] = localTPTrackInfo;
      j += 1;
      i += 1;
    }
    return arrayOfTPTrackInfo;
  }
  
  public int getVideoHeight()
  {
    this.mLogger.info("getVideoHeight, height:" + this.mVideoHeight);
    return this.mVideoHeight;
  }
  
  public int getVideoWidth()
  {
    this.mLogger.info("getVideoWidth, width:" + this.mVideoWidth);
    return this.mVideoWidth;
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 213	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mLogger	Lcom/tencent/thumbplayer/log/TPBaseLogger;
    //   6: ldc_w 1012
    //   9: invokevirtual 383	com/tencent/thumbplayer/log/TPBaseLogger:info	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 170	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mSuspend	Z
    //   16: ifeq +33 -> 49
    //   19: aload_0
    //   20: getfield 199	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mLastestAction	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$ResetActionInfo;
    //   23: ifnull +13 -> 36
    //   26: aload_0
    //   27: getfield 199	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mLastestAction	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$ResetActionInfo;
    //   30: getstatic 378	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:PAUSED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   33: putfield 696	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$ResetActionInfo:state	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   36: aload_0
    //   37: getfield 213	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mLogger	Lcom/tencent/thumbplayer/log/TPBaseLogger;
    //   40: ldc_w 1014
    //   43: invokevirtual 1017	com/tencent/thumbplayer/log/TPBaseLogger:warn	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield 293	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   53: invokevirtual 1019	android/media/MediaPlayer:pause	()V
    //   56: aload_0
    //   57: getstatic 378	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:PAUSED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   60: putfield 344	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   63: aload_0
    //   64: getstatic 378	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:PAUSED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   67: putfield 289	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mMediaPlayerState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   70: goto -24 -> 46
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	TPSystemMediaPlayer
    //   73	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	73	finally
    //   36	46	73	finally
    //   49	70	73	finally
  }
  
  public void prepare()
  {
    this.mLogger.info("prepare ");
    this.mState = TPSystemMediaPlayer.PlayerState.PREPARING;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.PREPARING;
    this.mMediaPlayer.prepare();
  }
  
  public void prepareAsync()
  {
    this.mLogger.info("prepareAsync ");
    this.mState = TPSystemMediaPlayer.PlayerState.PREPARING;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.PREPARING;
    this.mMediaPlayer.prepareAsync();
    startCheckPrepareTimeoutTimer();
  }
  
  public void release()
  {
    try
    {
      this.mLogger.info("release ");
      this.mExtSub.release();
      destroyCheckPrepareTimeoutTimer();
      destroyCheckBuffingTimer();
      destroyCheckBufferTimeOutByInfo();
      this.mState = TPSystemMediaPlayer.PlayerState.RELEASE;
      mediaPlayerStopAndRelease();
      this.mOnPreparedListener = null;
      this.mOnCompletionListener = null;
      this.mOnInfoListener = null;
      this.mOnErrorListener = null;
      this.mOnSeekCompleteListener = null;
      this.mOnVideoSizeChangedListener = null;
      this.mOnSubtitleDataListener = null;
      this.mSurfaceObj = null;
      this.mLogger.info("release over.");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void reset()
  {
    try
    {
      this.mLogger.info("reset ");
      this.mState = TPSystemMediaPlayer.PlayerState.IDLE;
      this.mExtSub.reset();
      mediaPlayerstop();
      destroyCheckPrepareTimeoutTimer();
      destroyCheckBuffingTimer();
      destroyCheckBufferTimeOutByInfo();
      this.mLogger.info("reset over.");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void seekTo(int paramInt)
  {
    this.mLogger.info("seekTo, position: " + paramInt);
    if (this.mIsNotSeekable) {
      this.mLogger.info("current media is not seekable, ignore");
    }
    do
    {
      return;
      if (!this.mSuspend) {
        break;
      }
    } while (this.mLastestAction == null);
    this.mLastestAction.position = paramInt;
    return;
    try
    {
      this.mMediaPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      TPLogUtil.e("TPSystemMediaPlayer", "seekTo illegalStateException, e = " + localIllegalStateException.toString());
    }
  }
  
  @TargetApi(26)
  public void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    this.mLogger.info("seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.mIsNotSeekable) {
      this.mLogger.info("current media is not seekable, ignore");
    }
    do
    {
      return;
      if (!this.mSuspend) {
        break;
      }
    } while (this.mLastestAction == null);
    this.mLastestAction.position = paramInt1;
    return;
    seekToComm(this.mMediaPlayer, paramInt1, paramInt2);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mLogger.error("selectProgram, android mediaplayer not support");
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mLogger.info("selectTrack, trackID:" + paramInt + ", opaque:" + paramLong);
    int i = this.mAudioTrackInfo.size();
    int j = this.mSubTrackInfo.size();
    ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
    if ((paramInt >= 0) && (paramInt < i)) {}
    label478:
    do
    {
      for (;;)
      {
        try
        {
          selectAudioTrack(paramInt, paramLong);
          ((TPSystemMediaPlayer.ExternalTrackInfo)this.mAudioTrackInfo.get(this.mCurAudioTrackIndex)).info.isSelected = false;
          ((TPSystemMediaPlayer.ExternalTrackInfo)this.mAudioTrackInfo.get(paramInt)).info.isSelected = true;
          this.mCurAudioTrackIndex = paramInt;
          return;
        }
        catch (Exception localException1)
        {
          this.mLogger.printException(localException1);
          if (localIOnInfoListener == null) {
            continue;
          }
          localIOnInfoListener.onInfo(4, formatErrorCode(-10000), 0L, Long.valueOf(paramLong));
          return;
        }
        if ((paramInt >= i) && (paramInt < i + j))
        {
          try
          {
            selectSubTrack(paramInt - i, paramLong);
            return;
          }
          catch (Exception localException2)
          {
            this.mLogger.printException(localException2);
          }
          if (localIOnInfoListener != null) {
            localIOnInfoListener.onInfo(4, formatErrorCode(-10000), 0L, Long.valueOf(paramLong));
          }
        }
        else
        {
          paramInt -= i + j;
          if (Build.VERSION.SDK_INT < 16)
          {
            this.mLogger.error("selectTrack, android mediaplayer not support ");
            if (localIOnInfoListener != null) {
              localIOnInfoListener.onInfo(4, formatErrorCode(-10001), 0L, Long.valueOf(paramLong));
            }
          }
          else
          {
            if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.STARTED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED))
            {
              this.mLogger.error("selectTrack, illegal state:" + this.mState);
              return;
            }
            Object localObject = null;
            try
            {
              MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.mMediaPlayer.getTrackInfo();
              localObject = arrayOfTrackInfo;
              if ((localObject == null) || (localObject.length <= paramInt))
              {
                if (localIOnInfoListener == null) {
                  continue;
                }
                localIOnInfoListener.onInfo(4, formatErrorCode(-10002), 0L, Long.valueOf(paramLong));
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                this.mLogger.error("getTrackInfo, android getTrackInfo crash");
              }
              localObject = localObject[paramInt];
              if (localObject.getTrackType() == 2) {
                this.mCurInnerAudioTrackIndex = paramInt;
              }
              for (;;)
              {
                this.mMediaPlayer.selectTrack(paramInt);
                if (localIOnInfoListener == null) {
                  break;
                }
                localIOnInfoListener.onInfo(4, 1000L, 0L, Long.valueOf(paramLong));
                return;
                if (localObject.getTrackType() != 4) {
                  break label478;
                }
                this.mSelectSubtitleIndex = paramInt;
              }
            }
          }
        }
      }
    } while (localIOnInfoListener == null);
    localIOnInfoListener.onInfo(4, formatErrorCode(-10003), 0L, Long.valueOf(paramLong));
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    this.mLogger.info("setAudioGainRatio, : " + paramFloat);
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
      this.mLogger.info("setAudioGainRatio ex : " + localIllegalStateException.toString());
    }
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    this.mLogger.info("setAudioNormalizeVolumeParams not supported.");
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null)
    {
      this.mLogger.info("setDataSource pfd is null ");
      throw new IllegalArgumentException("pfd is null");
    }
    this.mLogger.info("setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    this.mFd = paramParcelFileDescriptor.getFileDescriptor();
    this.mMediaPlayer.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    this.mTpSystemCapture = new TPSystemCapture(paramParcelFileDescriptor.getFileDescriptor());
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    throw new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
  }
  
  public void setDataSource(String paramString)
  {
    this.mLogger.info("setDataSource， url: " + paramString);
    this.mUrl = paramString;
    this.mMediaPlayer.setDataSource(paramString);
    this.mTpSystemCapture = new TPSystemCapture(paramString);
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    this.mLogger.info("setDataSource httpHeader, url: " + paramString);
    this.mUrl = paramString;
    this.mHeader = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.mMediaPlayer.setDataSource(this.mContext, paramMap, this.mHeader);
    this.mTpSystemCapture = new TPSystemCapture(paramString);
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    this.mLogger.info("setLoopback, : " + paramBoolean);
    this.mIsLoopback = paramBoolean;
    this.mMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.mLogger.info("setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
    if ((paramLong1 < 0L) || (paramLong1 > this.mBaseDuration) || (paramLong2 > this.mBaseDuration)) {
      throw new IllegalArgumentException("position error, must more than 0 and less than duration");
    }
    this.mIsLoopback = paramBoolean;
    this.mLoopStartPositionMs = paramLong1;
    this.mLoopEndPositionMs = paramLong2;
    this.mMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support audio frame out");
  }
  
  public void setOnAudioProcessOutputListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
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
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support subtitle frame out");
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support video frame out");
  }
  
  public void setOnVideoProcessOutputListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
  {
    throw new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramIOnVideoSizeChangedListener;
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    this.mLogger.info("setOutputMute, : " + paramBoolean);
    this.mMute = paramBoolean;
    if (paramBoolean) {}
    try
    {
      this.mMediaPlayer.setVolume(0.0F, 0.0F);
      this.mLogger.info("setOutputMute, true");
      return;
    }
    catch (Exception localException)
    {
      this.mLogger.info("setOutputMute, Exception: " + localException.toString());
    }
    this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
    this.mLogger.info("setOutputMute, false, mAudioGain: " + this.mAudioGain);
    return;
  }
  
  @TargetApi(23)
  public void setPlaySpeedRatio(float paramFloat)
  {
    this.mLogger.info("setPlaySpeedRatio, : " + paramFloat);
    if (Build.VERSION.SDK_INT < 23) {
      this.mLogger.info("os version is too low: " + Build.VERSION.SDK_INT);
    }
    for (;;)
    {
      return;
      this.mPlaySpeed = paramFloat;
      this.mLogger.info("setPlaySpeedRatio play speed:" + paramFloat);
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
        this.mLogger.printException(localException);
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
      this.mLogger.info("setPlayerOptionalParam, start position:" + this.mStartPositionMs);
      return;
    case 500: 
      this.mSkipEndPositionMs = paramTPOptionalParam.getParamLong().value;
      this.mLogger.info("setPlayerOptionalParam, skip end position:" + this.mSkipEndPositionMs);
      return;
    case 1: 
      this.mCgiDuration = paramTPOptionalParam.getParamLong().value;
      return;
    case 2: 
      this.mCgiVideoWidth = ((int)paramTPOptionalParam.getParamLong().value);
      this.mLogger.info("setPlayerOptionalParam, video width:" + this.mCgiVideoWidth);
      return;
    case 3: 
      this.mCgiVideoHeight = ((int)paramTPOptionalParam.getParamLong().value);
      this.mLogger.info("setPlayerOptionalParam, video height:" + this.mCgiVideoHeight);
      return;
    case 4: 
      this.mIsLive = paramTPOptionalParam.getParamBoolean().value;
      this.mIsNotSeekable = true;
      this.mLogger.info("setPlayerOptionalParam, is live:" + this.mIsLive);
      return;
    case 5: 
      this.mIsAllowCheckBuffingByPosition = paramTPOptionalParam.getParamBoolean().value;
      return;
    case 128: 
      this.mIntervalCheckPreparingTimeOut = paramTPOptionalParam.getParamLong().value;
      this.mLogger.info("setPlayerOptionalParam, prepare timeout:" + this.mIntervalCheckPreparingTimeOut + "(ms)");
      return;
    case 107: 
      this.mCheckBufferTimeroutFrequent = ((int)((paramTPOptionalParam.getParamLong().value + 400L) / 400L));
      this.mLogger.info("setPlayerOptionalParam, buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
      return;
    }
    this.mCheckBufferFrequent = ((int)(paramTPOptionalParam.getParamLong().value / 400L));
    this.mLogger.info("setPlayerOptionalParam, on buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mLogger.info("setSurface, surface: " + paramSurface);
    this.mSurfaceObj = paramSurface;
    try
    {
      this.mMediaPlayer.setSurface(paramSurface);
      this.mLogger.info("setSurface over, surface: " + paramSurface);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        TPLogUtil.e("TPSystemMediaPlayer", "setSurface error, " + localIllegalStateException.toString());
      }
    }
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    this.mLogger.info("setSurfaceHolder, sh: " + paramSurfaceHolder);
    this.mSurfaceObj = paramSurfaceHolder;
    this.mMediaPlayer.setDisplay(paramSurfaceHolder);
    this.mLogger.info("setSurfaceHolder over, sh: " + paramSurfaceHolder);
  }
  
  public void start()
  {
    this.mLogger.info("start ");
    if (this.mSuspend)
    {
      if (this.mLastestAction != null) {
        this.mLastestAction.state = TPSystemMediaPlayer.PlayerState.STARTED;
      }
      this.mLogger.warn("system player is busy.");
      return;
    }
    if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED))
    {
      this.mLogger.warn("start(), illegal state, state:" + this.mState);
      return;
    }
    this.mMediaPlayer.start();
    this.mState = TPSystemMediaPlayer.PlayerState.STARTED;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.STARTED;
    if (this.mPlaySpeed != 1.0D) {
      setPlaySpeedRatio(this.mPlaySpeed);
    }
    startCheckBufferingTimer();
  }
  
  public void stop()
  {
    try
    {
      this.mLogger.info("stop ");
      destroyCheckPrepareTimeoutTimer();
      destroyCheckBuffingTimer();
      destroyCheckBufferTimeOutByInfo();
      this.mState = TPSystemMediaPlayer.PlayerState.STOPPED;
      mediaPlayerstop();
      this.mCurAudioTrackIndex = 0;
      this.mLastestAction = null;
      this.mSelectSubtitleIndex = -1;
      this.mCurInnerAudioTrackIndex = -1;
      this.mExtSub.stop();
      this.mPosChangeCount = 0L;
      this.mLogger.info("stop over.");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public void switchDefinition(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    this.mLogger.info("switchDefinition, defUrl: " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      this.mLogger.info("switchDefinition, defUrl is null");
      return;
    }
    this.mUrl = paramString;
    TPSystemMediaPlayer.ResetActionInfo localResetActionInfo = new TPSystemMediaPlayer.ResetActionInfo(null);
    localResetActionInfo.opaque = paramLong;
    localResetActionInfo.externalAudioTrackIndex = this.mCurAudioTrackIndex;
    localResetActionInfo.mResetType = 1;
    localResetActionInfo.url = paramString;
    try
    {
      playerResetStart(localResetActionInfo);
      return;
    }
    catch (Exception paramString)
    {
      throw new IllegalStateException("playerResetStart");
    }
  }
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this.mLogger.updateContext(new TPLoggerContext(paramTPLoggerContext, "TPSystemMediaPlayer"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer
 * JD-Core Version:    0.7.0.1
 */