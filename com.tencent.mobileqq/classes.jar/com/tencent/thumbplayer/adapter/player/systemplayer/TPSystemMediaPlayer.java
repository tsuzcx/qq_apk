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
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamObject;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
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
  private ITPPlayerBaseListener.IOnSubtitleFrameOutListener mOnSubtitleFrameOutListener;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener mOnTimedTextListener = new TPSystemMediaPlayer.7(this);
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
    this.mExtSub.setPlayerPositionListener(new TPSystemMediaPlayer.2(this));
    this.mExtSub.setTrackSelectListener(new TPSystemMediaPlayer.3(this));
  }
  
  private void checkBuffingEvent()
  {
    long l1 = getCurrentPositionMs();
    long l2 = this.mLastCheckPos;
    this.mLastCheckPos = l1;
    Object localObject;
    if (this.mState != TPSystemMediaPlayer.PlayerState.STARTED)
    {
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
      return;
    }
    StringBuilder localStringBuilder;
    if (this.mIsLoopback)
    {
      long l3 = this.mLoopEndPositionMs;
      if ((l3 > 0L) && (l1 >= l3) && (!this.mIsNotSeekable))
      {
        localObject = this.mLogger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkBuffingEvent, loopback skip end, curPosition:");
        localStringBuilder.append(l1);
        localStringBuilder.append(", mLoopStartPositionMs:");
        localStringBuilder.append(this.mLoopStartPositionMs);
        ((TPBaseLogger)localObject).info(localStringBuilder.toString());
        this.mMediaPlayer.seekTo((int)this.mLoopStartPositionMs);
      }
    }
    else if ((this.mSkipEndPositionMs > 0L) && (l1 >= getDurationMs() - this.mSkipEndPositionMs))
    {
      localObject = this.mLogger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkBuffingEvent, skip end, mBaseDuration: ");
      localStringBuilder.append(this.mBaseDuration);
      localStringBuilder.append(", curPosition:");
      localStringBuilder.append(l1);
      localStringBuilder.append(", mSkipEndMilsec:");
      localStringBuilder.append(this.mSkipEndPositionMs);
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
      this.mState = TPSystemMediaPlayer.PlayerState.COMPLETE;
      mediaPlayerStopAndRelease();
      destroyCheckBuffingTimer();
      localObject = this.mOnCompletionListener;
      if (localObject != null) {
        ((ITPPlayerBaseListener.IOnCompletionListener)localObject).onCompletion();
      }
      return;
    }
    if (l1 != l2) {
      this.mPosChangeCount += 1L;
    }
    if ((l1 == l2) && (l1 > 0L))
    {
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
      if (this.mcheckBufferPosNoChangeCount >= this.mCheckBufferTimeroutFrequent)
      {
        this.mLogger.error("checkBuffingEvent post error");
        this.mState = TPSystemMediaPlayer.PlayerState.ERROR;
        mediaPlayerStopAndRelease();
        this.mIsBuffering = false;
        destroyCheckBuffingTimer();
        localObject = this.mOnErrorListener;
        if (localObject != null) {
          ((ITPPlayerBaseListener.IOnErrorListener)localObject).onError(2001, formatErrorCode(-110), 0L, 0L);
        }
      }
    }
    else
    {
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
  }
  
  /* Error */
  private void destroyCheckBufferTimeOutByInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 166	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimerOutByInfoLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 168	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 168	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 475 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 168	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
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
    //   3: getfield 160	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimerLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 477	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   13: ifnull +48 -> 61
    //   16: aload_0
    //   17: getfield 477	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   20: iconst_1
    //   21: putfield 482	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck:mCheckAbort	Z
    //   24: aload_0
    //   25: getfield 477	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   28: getfield 485	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   31: ifnull +17 -> 48
    //   34: aload_0
    //   35: getfield 477	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   38: getfield 485	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   41: iconst_1
    //   42: invokeinterface 475 2 0
    //   47: pop
    //   48: aload_0
    //   49: getfield 477	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
    //   52: aconst_null
    //   53: putfield 485	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 477	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mBufferCheck	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$BufferCheck;
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
    //   3: getfield 154	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 152	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 152	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 475 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 152	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
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
    long l1;
    if (paramInt < 0) {
      l1 = 10000000L - paramInt;
    } else {
      l1 = 10000000L + paramInt;
    }
    long l2 = l1;
    if (l1 >= 2147483647L) {
      l2 = 2147483647L;
    }
    return (int)l2;
  }
  
  private void handleDataSource(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    Object localObject = (TPSystemMediaPlayer.ExternalTrackInfo)this.mAudioTrackInfo.get(paramInt);
    ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
    if (localIOnInfoListener != null)
    {
      TPPlayerMsg.TPAudioTrackInfo localTPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
      localTPAudioTrackInfo.audioTrackUrl = ((TPSystemMediaPlayer.ExternalTrackInfo)localObject).url;
      localTPAudioTrackInfo.keyId = ((TPSystemMediaPlayer.ExternalTrackInfo)localObject).keyId;
      localObject = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDataSource, audioTrack url:");
      localStringBuilder.append(localTPAudioTrackInfo.audioTrackUrl);
      localStringBuilder.append(", keyId:");
      localStringBuilder.append(localTPAudioTrackInfo.keyId);
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
      localIOnInfoListener.onInfo(1011, 0L, 0L, localTPAudioTrackInfo);
    }
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
      localObject = MediaPlayer.class.getDeclaredField("mEventHandler");
      ((Field)localObject).setAccessible(true);
      paramMediaPlayer = (Handler)((Field)localObject).get(paramMediaPlayer);
      localObject = Handler.class.getDeclaredField("mCallback");
      ((Field)localObject).setAccessible(true);
      if ((Handler.Callback)((Field)localObject).get(paramMediaPlayer) == null)
      {
        ((Field)localObject).set(paramMediaPlayer, new TPSystemMediaPlayer.HookCallback(paramMediaPlayer));
        return;
      }
    }
    catch (Exception paramMediaPlayer)
    {
      Object localObject = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mediaPlayerExceptionHook, ");
      localStringBuilder.append(Log.getStackTraceString(paramMediaPlayer));
      ((TPBaseLogger)localObject).error(localStringBuilder.toString());
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
    if (Build.VERSION.SDK_INT >= 26) {
      localTPMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
    } else {
      localTPMediaPlayer.setAudioStreamType(3);
    }
    if (this.mMute)
    {
      this.mMediaPlayer.setVolume(0.0F, 0.0F);
    }
    else if (this.mAudioGain != 1.0F)
    {
      MediaPlayer localMediaPlayer = this.mMediaPlayer;
      f = this.mAudioGain;
      localMediaPlayer.setVolume(f, f);
    }
    float f = this.mPlaySpeed;
    if (f != 1.0D) {
      setPlaySpeedRatio(f);
    }
    if (this.mIsLoopback) {
      this.mMediaPlayer.setLooping(this.mIsLoopback);
    }
    this.mMediaPlayer = localTPMediaPlayer;
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
        Object localObject3 = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playerResetEnd, actionInfo:");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(", mSuspend:");
        localStringBuilder.append(this.mSuspend);
        ((TPBaseLogger)localObject3).info(localStringBuilder.toString());
        Object localObject4;
        if ((localObject1 != null) && (this.mSuspend))
        {
          localObject3 = this.mOnInfoListener;
          if (((TPSystemMediaPlayer.ResetActionInfo)localObject1).mResetType == 1)
          {
            i = 3;
            if (localObject3 != null) {
              ((ITPPlayerBaseListener.IOnInfoListener)localObject3).onInfo(i, 1000L, 0L, Long.valueOf(((TPSystemMediaPlayer.ResetActionInfo)localObject1).opaque));
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
            if ((((TPSystemMediaPlayer.ResetActionInfo)localObject1).position > 0L) && (!this.mIsNotSeekable))
            {
              localObject3 = this.mLogger;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("playerResetEnd, onPrepared(), and seek to:");
              localStringBuilder.append(((TPSystemMediaPlayer.ResetActionInfo)localObject1).position);
              ((TPBaseLogger)localObject3).info(localStringBuilder.toString());
              try
              {
                this.mMediaPlayer.seekTo((int)((TPSystemMediaPlayer.ResetActionInfo)localObject1).position);
              }
              catch (Exception localException2)
              {
                this.mLogger.printException(localException2);
              }
            }
            localObject4 = this.mLogger;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("playerResetEnd, restore state:");
            localStringBuilder.append(((TPSystemMediaPlayer.ResetActionInfo)localObject1).state);
            ((TPBaseLogger)localObject4).info(localStringBuilder.toString());
            if ((((TPSystemMediaPlayer.ResetActionInfo)localObject1).state != TPSystemMediaPlayer.PlayerState.IDLE) && (((TPSystemMediaPlayer.ResetActionInfo)localObject1).state != TPSystemMediaPlayer.PlayerState.INITIALIZED) && (((TPSystemMediaPlayer.ResetActionInfo)localObject1).state != TPSystemMediaPlayer.PlayerState.PREPARING))
            {
              if ((((TPSystemMediaPlayer.ResetActionInfo)localObject1).state != TPSystemMediaPlayer.PlayerState.PREPARED) && (((TPSystemMediaPlayer.ResetActionInfo)localObject1).state != TPSystemMediaPlayer.PlayerState.PAUSED))
              {
                if (((TPSystemMediaPlayer.ResetActionInfo)localObject1).state == TPSystemMediaPlayer.PlayerState.STARTED)
                {
                  this.mLogger.info("playerResetEnd,  MediaPlayer.start().");
                  this.mMediaPlayer.start();
                  this.mState = ((TPSystemMediaPlayer.ResetActionInfo)localObject1).state;
                  this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.STARTED;
                  startCheckBufferingTimer();
                }
                else
                {
                  localObject4 = this.mLogger;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("illegal state, state:");
                  localStringBuilder.append(((TPSystemMediaPlayer.ResetActionInfo)localObject1).state);
                  ((TPBaseLogger)localObject4).error(localStringBuilder.toString());
                  this.mState = TPSystemMediaPlayer.PlayerState.ERROR;
                  mediaPlayerStopAndRelease();
                  localObject1 = this.mOnErrorListener;
                  if (localObject1 != null) {
                    ((ITPPlayerBaseListener.IOnErrorListener)localObject1).onError(2000, formatErrorCode(-10004), 0L, 0L);
                  }
                }
              }
              else {
                this.mState = ((TPSystemMediaPlayer.ResetActionInfo)localObject1).state;
              }
            }
            else
            {
              this.mState = TPSystemMediaPlayer.PlayerState.PREPARED;
              localObject1 = this.mOnPreparedListener;
              if (localObject1 != null) {
                ((ITPPlayerBaseListener.IOnPreparedListener)localObject1).onPrepared();
              }
            }
            this.mSuspend = false;
            this.mLastestAction = null;
          }
        }
        else
        {
          if ((this.mStartPositionMs > 0) && (!this.mIsNotSeekable))
          {
            localObject1 = this.mLogger;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("onPrepared(), and seekto:");
            ((StringBuilder)localObject4).append(this.mStartPositionMs);
            ((TPBaseLogger)localObject1).info(((StringBuilder)localObject4).toString());
            try
            {
              this.mMediaPlayer.seekTo(this.mStartPositionMs);
            }
            catch (Exception localException1)
            {
              this.mLogger.printException(localException1);
            }
          }
          this.mState = TPSystemMediaPlayer.PlayerState.PREPARED;
          ITPPlayerBaseListener.IOnPreparedListener localIOnPreparedListener = this.mOnPreparedListener;
          if (localIOnPreparedListener != null) {
            localIOnPreparedListener.onPrepared();
          }
          return;
        }
      }
      finally {}
      int i = 4;
    }
  }
  
  private void playerResetStart(TPSystemMediaPlayer.ResetActionInfo paramResetActionInfo)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramResetActionInfo.url;
        paramResetActionInfo.position = getCurrentPositionMs();
        paramResetActionInfo.state = this.mState;
        paramResetActionInfo.innerAudioTrackIndex = this.mCurInnerAudioTrackIndex;
        paramResetActionInfo.innerSubtitleTrackIndex = this.mSelectSubtitleIndex;
        Object localObject2 = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playerResetStart, pos:");
        localStringBuilder.append(paramResetActionInfo.position);
        localStringBuilder.append(", state:");
        localStringBuilder.append(paramResetActionInfo.state);
        ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
        this.mSuspend = true;
        mediaPlayerReset();
        this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.IDLE;
        if (this.mFd != null)
        {
          this.mMediaPlayer.setDataSource(this.mFd);
        }
        else
        {
          handleDataSource(paramResetActionInfo.externalAudioTrackIndex);
          if ((this.mHeader != null) && (!this.mHeader.isEmpty()))
          {
            localObject1 = Uri.parse((String)localObject1);
            this.mMediaPlayer.setDataSource(this.mContext, (Uri)localObject1, this.mHeader);
          }
          else
          {
            this.mMediaPlayer.setDataSource((String)localObject1);
          }
        }
        this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
        if (this.mSurfaceObj == null) {
          this.mMediaPlayer.setDisplay(null);
        } else if ((this.mSurfaceObj instanceof SurfaceHolder)) {
          this.mMediaPlayer.setDisplay((SurfaceHolder)this.mSurfaceObj);
        } else if ((this.mSurfaceObj instanceof Surface)) {
          this.mMediaPlayer.setSurface((Surface)this.mSurfaceObj);
        }
        localObject1 = this.mLastestAction;
        if ((localObject1 != null) && (((TPSystemMediaPlayer.ResetActionInfo)localObject1).mResetType != paramResetActionInfo.mResetType))
        {
          localObject2 = this.mOnInfoListener;
          if (((TPSystemMediaPlayer.ResetActionInfo)localObject1).mResetType == 1)
          {
            i = 3;
            if (localObject2 != null) {
              ((ITPPlayerBaseListener.IOnInfoListener)localObject2).onInfo(i, ((TPSystemMediaPlayer.ResetActionInfo)localObject1).opaque, 0L, null);
            }
            paramResetActionInfo.state = ((TPSystemMediaPlayer.ResetActionInfo)localObject1).state;
            paramResetActionInfo.position = ((TPSystemMediaPlayer.ResetActionInfo)localObject1).position;
          }
        }
        else
        {
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
      }
      finally {}
      int i = 4;
    }
  }
  
  private void seekToComm(MediaPlayer paramMediaPlayer, int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      TPBaseLogger localTPBaseLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("os ver is too low, current sdk int:");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append(", is less than ");
      localStringBuilder.append(26);
      localStringBuilder.append(", use seekTo(int positionMs) instead");
      localTPBaseLogger.info(localStringBuilder.toString());
      paramMediaPlayer.seekTo(paramInt1);
      return;
    }
    int i = 0;
    if (paramInt2 != 1) {
      if (paramInt2 == 2) {
        i = 1;
      } else if (paramInt2 == 3) {
        i = 2;
      }
    }
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
    this.mExtSub.setDataSource(localExternalTrackInfo.url, paramLong);
    this.mExtSub.prepare();
  }
  
  private void startCheckBufferTimeOutByInfo()
  {
    synchronized (this.mCheckBufferTimerOutByInfoLock)
    {
      if (this.mCheckBufferTimeOutBySystemInfoTimer == null) {
        this.mCheckBufferTimeOutBySystemInfoTimer = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.6(this), this.mCheckBufferTimeroutFrequent * 400, TimeUnit.MILLISECONDS);
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
        this.mBufferCheck.mCheckBuffingTimer = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.5(this, localBufferCheck), 0L, TimeUnit.MILLISECONDS);
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
        this.mCheckPrepareTimeoutTask = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.4(this), this.mIntervalCheckPreparingTimeOut, TimeUnit.MILLISECONDS);
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
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
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
      paramString1 = this.mLogger;
      paramList = new StringBuilder();
      paramList.append("addAudioTrackSource, name:");
      paramList.append(localTPTrackInfo.name);
      paramList.append(", url:");
      paramList.append(paramString2);
      paramString1.info(paramList.toString());
      this.mAudioTrackInfo.add(localExternalTrackInfo);
      return;
    }
    this.mLogger.error("addAudioTrackSource, illegal argument.");
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString2 = new TPTrackInfo();
      paramString2.name = paramString3;
      paramString2.isExclusive = true;
      paramString2.isInternal = false;
      paramString2.isSelected = false;
      paramString2.trackType = 3;
      TPSystemMediaPlayer.ExternalTrackInfo localExternalTrackInfo = new TPSystemMediaPlayer.ExternalTrackInfo(null);
      localExternalTrackInfo.info = paramString2;
      localExternalTrackInfo.url = paramString1;
      paramString1 = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addSubtitleSource, name:");
      localStringBuilder.append(paramString2.name);
      localStringBuilder.append(", url:");
      localStringBuilder.append(paramString3);
      paramString1.info(localStringBuilder.toString());
      this.mSubTrackInfo.add(localExternalTrackInfo);
      return;
    }
    this.mLogger.error("addSubtitleSource, illegal argument.");
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
    if ((!this.mSuspend) && (this.mState != TPSystemMediaPlayer.PlayerState.ERROR))
    {
      if ((this.mState != TPSystemMediaPlayer.PlayerState.IDLE) && (this.mState != TPSystemMediaPlayer.PlayerState.INITIALIZED) && (this.mState != TPSystemMediaPlayer.PlayerState.PREPARING) && (this.mState != TPSystemMediaPlayer.PlayerState.STOPPED) && (this.mState != TPSystemMediaPlayer.PlayerState.PREPARED)) {}
      for (int i = this.mMediaPlayer.getCurrentPosition();; i = this.mStartPositionMs) {
        return i;
      }
    }
    long l2 = this.mLastCheckPos;
    long l1 = l2;
    if (l2 == -1L) {
      l1 = this.mStartPositionMs;
    }
    return l1;
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
    long l1 = this.mCgiDuration;
    if (l1 > 0L)
    {
      long l2 = this.mBaseDuration;
      if (l2 <= 0L)
      {
        this.mBaseDuration = l1;
      }
      else
      {
        l1 = Math.abs(l1 - l2);
        l2 = this.mCgiDuration;
        if (l1 * 100L / l2 > 1L) {
          this.mBaseDuration = l2;
        }
      }
    }
    return this.mBaseDuration;
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
    if (((this.mState == TPSystemMediaPlayer.PlayerState.PREPARED) || (this.mState == TPSystemMediaPlayer.PlayerState.STARTED) || (this.mState == TPSystemMediaPlayer.PlayerState.PAUSED)) && (TPCommonUtils.SDK_INT > 16)) {}
    try
    {
      arrayOfTrackInfo = this.mMediaPlayer.getTrackInfo();
    }
    catch (Exception localException)
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo;
      label50:
      int j;
      int k;
      int m;
      int i;
      TPTrackInfo[] arrayOfTPTrackInfo;
      Object localObject;
      break label50;
    }
    this.mLogger.error("getTrackInfo, android getTrackInfo crash");
    arrayOfTrackInfo = null;
    j = 0;
    if ((arrayOfTrackInfo == null) && (this.mAudioTrackInfo.isEmpty()) && (this.mSubTrackInfo.isEmpty())) {
      return new TPTrackInfo[0];
    }
    k = this.mAudioTrackInfo.size();
    m = this.mSubTrackInfo.size();
    if (arrayOfTrackInfo == null) {
      i = 0;
    } else {
      i = arrayOfTrackInfo.length;
    }
    arrayOfTPTrackInfo = new TPTrackInfo[k + m + i];
    localObject = this.mAudioTrackInfo.iterator();
    i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfTPTrackInfo[i] = ((TPSystemMediaPlayer.ExternalTrackInfo)((Iterator)localObject).next()).info;
      i += 1;
    }
    localObject = this.mSubTrackInfo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      arrayOfTPTrackInfo[i] = ((TPSystemMediaPlayer.ExternalTrackInfo)((Iterator)localObject).next()).info;
      i += 1;
    }
    if (arrayOfTrackInfo != null)
    {
      if (arrayOfTrackInfo.length <= 0) {
        return arrayOfTPTrackInfo;
      }
      k = arrayOfTrackInfo.length;
      while (j < k)
      {
        localObject = arrayOfTrackInfo[j];
        TPTrackInfo localTPTrackInfo = new TPTrackInfo();
        localTPTrackInfo.name = ((MediaPlayer.TrackInfo)localObject).getLanguage();
        localTPTrackInfo.trackType = systemTrackType2TPTrackType(((MediaPlayer.TrackInfo)localObject).getTrackType());
        arrayOfTPTrackInfo[i] = localTPTrackInfo;
        j += 1;
        i += 1;
      }
    }
    return arrayOfTPTrackInfo;
  }
  
  public int getVideoHeight()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoHeight, height:");
    localStringBuilder.append(this.mVideoHeight);
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mVideoHeight;
  }
  
  public int getVideoWidth()
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoWidth, width:");
    localStringBuilder.append(this.mVideoWidth);
    localTPBaseLogger.info(localStringBuilder.toString());
    return this.mVideoWidth;
  }
  
  public void pause()
  {
    try
    {
      this.mLogger.info("pause ");
      if (this.mSuspend)
      {
        if (this.mLastestAction != null) {
          this.mLastestAction.state = TPSystemMediaPlayer.PlayerState.PAUSED;
        }
        this.mLogger.warn("system player is busy.");
        return;
      }
      if (this.mExtSub != null) {
        this.mExtSub.pauseAsync();
      }
      this.mMediaPlayer.pause();
      this.mState = TPSystemMediaPlayer.PlayerState.PAUSED;
      this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.PAUSED;
      return;
    }
    finally {}
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
      this.mMediaPlayer.reset();
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
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekTo, position: ");
    localStringBuilder.append(paramInt);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    if (this.mIsNotSeekable)
    {
      this.mLogger.info("current media is not seekable, ignore");
      return;
    }
    if (this.mSuspend)
    {
      localObject = this.mLastestAction;
      if (localObject != null) {
        ((TPSystemMediaPlayer.ResetActionInfo)localObject).position = paramInt;
      }
      return;
    }
    try
    {
      this.mMediaPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekTo illegalStateException, e = ");
      localStringBuilder.append(localIllegalStateException.toString());
      TPLogUtil.e("TPSystemMediaPlayer", localStringBuilder.toString());
    }
  }
  
  @TargetApi(26)
  public void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekTo, position: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", mode: ");
    localStringBuilder.append(paramInt2);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    if (this.mIsNotSeekable)
    {
      this.mLogger.info("current media is not seekable, ignore");
      return;
    }
    if (this.mSuspend)
    {
      localObject = this.mLastestAction;
      if (localObject != null) {
        ((TPSystemMediaPlayer.ResetActionInfo)localObject).position = paramInt1;
      }
      return;
    }
    seekToComm(this.mMediaPlayer, paramInt1, paramInt2);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mLogger.error("selectProgram, android mediaplayer not support");
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("selectTrack, trackID:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(", opaque:");
    ((StringBuilder)localObject2).append(paramLong);
    localTPBaseLogger.info(((StringBuilder)localObject2).toString());
    int i = this.mAudioTrackInfo.size();
    int j = this.mSubTrackInfo.size();
    this.mAudioTrackInfo.size();
    ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
    if ((paramInt >= 0) && (paramInt < i)) {
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
        if (localIOnInfoListener != null) {
          localIOnInfoListener.onInfo(4, formatErrorCode(-10000), 0L, Long.valueOf(paramLong));
        }
        return;
      }
    }
    if ((paramInt >= i) && (paramInt < i + j)) {
      try
      {
        selectSubTrack(paramInt - i, paramLong);
        return;
      }
      catch (Exception localException2)
      {
        this.mLogger.printException(localException2);
        if (localIOnInfoListener != null) {
          localIOnInfoListener.onInfo(4, formatErrorCode(-10000), 0L, Long.valueOf(paramLong));
        }
        return;
      }
    }
    paramInt -= i + j;
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mLogger.error("selectTrack, android mediaplayer not support ");
      if (localIOnInfoListener != null) {
        localIOnInfoListener.onInfo(4, formatErrorCode(-10001), 0L, Long.valueOf(paramLong));
      }
      return;
    }
    if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.STARTED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED))
    {
      localObject1 = this.mLogger;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("selectTrack, illegal state:");
      ((StringBuilder)localObject2).append(this.mState);
      ((TPBaseLogger)localObject1).error(((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = this.mMediaPlayer.getTrackInfo();
      localObject1 = localObject2;
    }
    catch (Exception localException3)
    {
      label405:
      break label405;
    }
    this.mLogger.error("getTrackInfo, android getTrackInfo crash");
    if ((localObject1 != null) && (localObject1.length > paramInt))
    {
      localObject1 = localObject1[paramInt];
      if (((MediaPlayer.TrackInfo)localObject1).getTrackType() == 2)
      {
        this.mCurInnerAudioTrackIndex = paramInt;
      }
      else
      {
        if (((MediaPlayer.TrackInfo)localObject1).getTrackType() != 4) {
          break label497;
        }
        this.mSelectSubtitleIndex = paramInt;
      }
      this.mMediaPlayer.selectTrack(paramInt);
      if (localIOnInfoListener != null) {
        localIOnInfoListener.onInfo(4, 1000L, 0L, Long.valueOf(paramLong));
      }
      return;
      label497:
      if (localIOnInfoListener != null) {
        localIOnInfoListener.onInfo(4, formatErrorCode(-10003), 0L, Long.valueOf(paramLong));
      }
      return;
    }
    if (localIOnInfoListener != null) {
      localIOnInfoListener.onInfo(4, formatErrorCode(-10002), 0L, Long.valueOf(paramLong));
    }
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAudioGainRatio, : ");
    ((StringBuilder)localObject).append(paramFloat);
    localTPBaseLogger.info(((StringBuilder)localObject).toString());
    this.mAudioGain = paramFloat;
    try
    {
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localObject = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAudioGainRatio ex : ");
      localStringBuilder.append(localIllegalStateException.toString());
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    }
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    this.mLogger.info("setAudioNormalizeVolumeParams not supported.");
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null)
    {
      TPBaseLogger localTPBaseLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDataSource pfd， pfd: ");
      localStringBuilder.append(paramParcelFileDescriptor.toString());
      localTPBaseLogger.info(localStringBuilder.toString());
      this.mFd = paramParcelFileDescriptor.getFileDescriptor();
      this.mMediaPlayer.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
      this.mTpSystemCapture = new TPSystemCapture(paramParcelFileDescriptor.getFileDescriptor());
      this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
      this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
      return;
    }
    this.mLogger.info("setDataSource pfd is null ");
    throw new IllegalArgumentException("pfd is null");
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    throw new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
  }
  
  public void setDataSource(String paramString)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDataSource， url: ");
    localStringBuilder.append(paramString);
    localTPBaseLogger.info(localStringBuilder.toString());
    this.mUrl = paramString;
    this.mMediaPlayer.setDataSource(paramString);
    this.mTpSystemCapture = new TPSystemCapture(paramString);
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDataSource httpHeader, url: ");
    localStringBuilder.append(paramString);
    localTPBaseLogger.info(localStringBuilder.toString());
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
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLoopback, : ");
    localStringBuilder.append(paramBoolean);
    localTPBaseLogger.info(localStringBuilder.toString());
    this.mIsLoopback = paramBoolean;
    this.mMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLoopback, : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", loopStart: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", loopEnd: ");
    localStringBuilder.append(paramLong2);
    localTPBaseLogger.info(localStringBuilder.toString());
    if (paramLong1 >= 0L)
    {
      long l = this.mBaseDuration;
      if ((paramLong1 <= l) && (paramLong2 <= l))
      {
        this.mIsLoopback = paramBoolean;
        this.mLoopStartPositionMs = paramLong1;
        this.mLoopEndPositionMs = paramLong2;
        this.mMediaPlayer.setLooping(paramBoolean);
        return;
      }
    }
    throw new IllegalArgumentException("position error, must more than 0 and less than duration");
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
    this.mOnSubtitleFrameOutListener = paramIOnSubtitleFrameOutListener;
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
    TPBaseLogger localTPBaseLogger = this.mLogger;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setOutputMute, : ");
    ((StringBuilder)localObject).append(paramBoolean);
    localTPBaseLogger.info(((StringBuilder)localObject).toString());
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
      localObject = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOutputMute, Exception: ");
      localStringBuilder.append(localException.toString());
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    }
    this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
    localTPBaseLogger = this.mLogger;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setOutputMute, false, mAudioGain: ");
    ((StringBuilder)localObject).append(this.mAudioGain);
    localTPBaseLogger.info(((StringBuilder)localObject).toString());
    return;
  }
  
  @TargetApi(23)
  public void setPlaySpeedRatio(float paramFloat)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlaySpeedRatio, : ");
    localStringBuilder.append(paramFloat);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    if (Build.VERSION.SDK_INT < 23)
    {
      localObject = this.mLogger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("os version is too low: ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      ((TPBaseLogger)localObject).info(localStringBuilder.toString());
      return;
    }
    this.mPlaySpeed = paramFloat;
    localObject = this.mLogger;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlaySpeedRatio play speed:");
    localStringBuilder.append(paramFloat);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    try
    {
      localObject = this.mMediaPlayer.getPlaybackParams();
      if (((PlaybackParams)localObject).getSpeed() != paramFloat)
      {
        ((PlaybackParams)localObject).setSpeed(paramFloat);
        this.mMediaPlayer.setPlaybackParams((PlaybackParams)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      this.mLogger.printException(localException);
    }
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    int i = paramTPOptionalParam.getKey();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 7)
              {
                if (i != 100)
                {
                  if (i != 107)
                  {
                    if (i != 128)
                    {
                      if (i != 450)
                      {
                        if (i != 500)
                        {
                          if (i != 507) {
                            return;
                          }
                          paramTPOptionalParam = (TPSubtitleRenderModel)paramTPOptionalParam.getParamObject().objectValue;
                          localObject = this.mExtSub;
                          if (localObject != null) {
                            ((ITPSysPlayerExternalSubtitle)localObject).setSubtitleRenderModel(paramTPOptionalParam);
                          }
                          TPLogUtil.i("TPSystemMediaPlayer", "setPlayerOptionalParam, subtitle render model");
                          return;
                        }
                        this.mSkipEndPositionMs = paramTPOptionalParam.getParamLong().value;
                        paramTPOptionalParam = this.mLogger;
                        localObject = new StringBuilder();
                        ((StringBuilder)localObject).append("setPlayerOptionalParam, skip end position:");
                        ((StringBuilder)localObject).append(this.mSkipEndPositionMs);
                        paramTPOptionalParam.info(((StringBuilder)localObject).toString());
                        return;
                      }
                      i = (int)paramTPOptionalParam.getParamLong().value;
                      localObject = this.mExtSub;
                      if (localObject != null) {
                        ((ITPSysPlayerExternalSubtitle)localObject).setSubtitleType(i);
                      }
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append("setPlayerOptionalParam, subtitle type:");
                      ((StringBuilder)localObject).append(paramTPOptionalParam.getParamLong().value);
                      TPLogUtil.i("TPSystemMediaPlayer", ((StringBuilder)localObject).toString());
                      return;
                    }
                    this.mIntervalCheckPreparingTimeOut = paramTPOptionalParam.getParamLong().value;
                    paramTPOptionalParam = this.mLogger;
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("setPlayerOptionalParam, prepare timeout:");
                    ((StringBuilder)localObject).append(this.mIntervalCheckPreparingTimeOut);
                    ((StringBuilder)localObject).append("(ms)");
                    paramTPOptionalParam.info(((StringBuilder)localObject).toString());
                    return;
                  }
                  this.mCheckBufferTimeroutFrequent = ((int)((paramTPOptionalParam.getParamLong().value + 400L) / 400L));
                  localObject = this.mLogger;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("setPlayerOptionalParam, buffer timeout:");
                  localStringBuilder.append(paramTPOptionalParam.getParamLong().value);
                  localStringBuilder.append("(ms)");
                  ((TPBaseLogger)localObject).info(localStringBuilder.toString());
                  return;
                }
                this.mStartPositionMs = ((int)paramTPOptionalParam.getParamLong().value);
                paramTPOptionalParam = this.mLogger;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("setPlayerOptionalParam, start position:");
                ((StringBuilder)localObject).append(this.mStartPositionMs);
                paramTPOptionalParam.info(((StringBuilder)localObject).toString());
                return;
              }
              this.mCheckBufferFrequent = ((int)(paramTPOptionalParam.getParamLong().value / 400L));
              localObject = this.mLogger;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("setPlayerOptionalParam, on buffer timeout:");
              localStringBuilder.append(paramTPOptionalParam.getParamLong().value);
              localStringBuilder.append("(ms)");
              ((TPBaseLogger)localObject).info(localStringBuilder.toString());
              return;
            }
            this.mIsAllowCheckBuffingByPosition = paramTPOptionalParam.getParamBoolean().value;
            return;
          }
          this.mIsLive = paramTPOptionalParam.getParamBoolean().value;
          this.mIsNotSeekable = true;
          paramTPOptionalParam = this.mLogger;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setPlayerOptionalParam, is live:");
          ((StringBuilder)localObject).append(this.mIsLive);
          paramTPOptionalParam.info(((StringBuilder)localObject).toString());
          return;
        }
        this.mCgiVideoHeight = ((int)paramTPOptionalParam.getParamLong().value);
        paramTPOptionalParam = this.mLogger;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setPlayerOptionalParam, video height:");
        ((StringBuilder)localObject).append(this.mCgiVideoHeight);
        paramTPOptionalParam.info(((StringBuilder)localObject).toString());
        return;
      }
      this.mCgiVideoWidth = ((int)paramTPOptionalParam.getParamLong().value);
      paramTPOptionalParam = this.mLogger;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPlayerOptionalParam, video width:");
      ((StringBuilder)localObject).append(this.mCgiVideoWidth);
      paramTPOptionalParam.info(((StringBuilder)localObject).toString());
      return;
    }
    this.mCgiDuration = paramTPOptionalParam.getParamLong().value;
  }
  
  public void setSurface(Surface paramSurface)
  {
    TPBaseLogger localTPBaseLogger1 = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurface, surface: ");
    localStringBuilder.append(paramSurface);
    localTPBaseLogger1.info(localStringBuilder.toString());
    this.mSurfaceObj = paramSurface;
    try
    {
      this.mMediaPlayer.setSurface(paramSurface);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSurface error, ");
      localStringBuilder.append(localIllegalStateException.toString());
      TPLogUtil.e("TPSystemMediaPlayer", localStringBuilder.toString());
    }
    TPBaseLogger localTPBaseLogger2 = this.mLogger;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurface over, surface: ");
    localStringBuilder.append(paramSurface);
    localTPBaseLogger2.info(localStringBuilder.toString());
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurfaceHolder, sh: ");
    localStringBuilder.append(paramSurfaceHolder);
    localTPBaseLogger.info(localStringBuilder.toString());
    this.mSurfaceObj = paramSurfaceHolder;
    this.mMediaPlayer.setDisplay(paramSurfaceHolder);
    localTPBaseLogger = this.mLogger;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurfaceHolder over, sh: ");
    localStringBuilder.append(paramSurfaceHolder);
    localTPBaseLogger.info(localStringBuilder.toString());
  }
  
  public void start()
  {
    this.mLogger.info("start ");
    if (this.mSuspend)
    {
      localObject = this.mLastestAction;
      if (localObject != null) {
        ((TPSystemMediaPlayer.ResetActionInfo)localObject).state = TPSystemMediaPlayer.PlayerState.STARTED;
      }
      this.mLogger.warn("system player is busy.");
      return;
    }
    if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED))
    {
      localObject = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start(), illegal state, state:");
      localStringBuilder.append(this.mState);
      ((TPBaseLogger)localObject).warn(localStringBuilder.toString());
      return;
    }
    Object localObject = this.mExtSub;
    if (localObject != null) {
      ((ITPSysPlayerExternalSubtitle)localObject).startAsync();
    }
    this.mMediaPlayer.start();
    this.mState = TPSystemMediaPlayer.PlayerState.STARTED;
    this.mMediaPlayerState = TPSystemMediaPlayer.PlayerState.STARTED;
    float f = this.mPlaySpeed;
    if (f != 1.0D) {
      setPlaySpeedRatio(f);
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
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchDefinition, defUrl: ");
    localStringBuilder.append(paramString);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      this.mLogger.info("switchDefinition, defUrl is null");
      return;
    }
    this.mUrl = paramString;
    localObject = new TPSystemMediaPlayer.ResetActionInfo(null);
    ((TPSystemMediaPlayer.ResetActionInfo)localObject).opaque = paramLong;
    ((TPSystemMediaPlayer.ResetActionInfo)localObject).externalAudioTrackIndex = this.mCurAudioTrackIndex;
    ((TPSystemMediaPlayer.ResetActionInfo)localObject).mResetType = 1;
    ((TPSystemMediaPlayer.ResetActionInfo)localObject).url = paramString;
    try
    {
      playerResetStart((TPSystemMediaPlayer.ResetActionInfo)localObject);
      return;
    }
    catch (Exception paramString)
    {
      label108:
      break label108;
    }
    throw new IllegalStateException("playerResetStart");
  }
  
  public void switchDefinition(String paramString, Map<String, String> paramMap, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    paramMap = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchDefinition, defUrl: ");
    localStringBuilder.append(paramString);
    paramMap.info(localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      this.mLogger.info("switchDefinition, defUrl is null");
      return;
    }
    this.mUrl = paramString;
    paramMap = new TPSystemMediaPlayer.ResetActionInfo(null);
    paramMap.opaque = paramLong;
    paramMap.externalAudioTrackIndex = this.mCurAudioTrackIndex;
    paramMap.mResetType = 1;
    paramMap.url = paramString;
    try
    {
      playerResetStart(paramMap);
      return;
    }
    catch (Exception paramString)
    {
      label101:
      break label101;
    }
    throw new IllegalStateException("playerResetStart");
  }
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this.mLogger.updateContext(new TPLoggerContext(paramTPLoggerContext, "TPSystemMediaPlayer"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer
 * JD-Core Version:    0.7.0.1
 */