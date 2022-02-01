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
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
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
import java.util.concurrent.atomic.AtomicInteger;

public class TPSystemMediaPlayer
  implements ITPPlayerBase
{
  private static final int CHECK_BUFFER_FREQUENT = 3;
  private static final int RESET_TYPE_SEL_AUDIO_TRACK = 2;
  private static final int RESET_TYPE_SWITCH_URL = 1;
  private static final String STAG = "TPThumbPlayer[TPSystemMediaPlayer.java]";
  private static final int START_AUTO_SEEK_DELAY_TIME = 2000;
  private static final int mIntervalCheckBuffering = 400;
  private static AtomicInteger mPlayerIndex = new AtomicInteger();
  private String TAG = "TPThumbPlayer[TPSystemMediaPlayer.java]";
  private float mAudioGain = 1.0F;
  private List<TPSystemMediaPlayer.ExternalTrackInfo> mAudioTrackInfo = new ArrayList();
  private long mBaseDuration = 0L;
  private long mBufferMs = 0L;
  private long mCgiDuration = -1L;
  private int mCgiVideoHeight = -1;
  private int mCgiVideoWidth = -1;
  private Future<?> mCheckBufferTimeOutBySystemInfoTimer = null;
  private final Object mCheckBufferTimerOutByInfoLock = new Object();
  private int mCheckBufferTimeroutFrequent = 30;
  private Future<?> mCheckBuffingTimer = null;
  private final Object mCheckBuffingTimerLock = new Object();
  private final Object mCheckPrepareTimeoutLock = new Object();
  private Future<?> mCheckPrepareTimeoutTask = null;
  private Context mContext;
  private int mCurAudioTrackIndex = 0;
  private int mCurInnerAudioTrackIndex = -1;
  private TPSystemMediaPlayer.EventHandler mEventHandler;
  private FileDescriptor mFd;
  private Map<String, String> mHeader;
  private TPSystemMediaPlayer.InnerPlayerListener mInnerPlayerListener;
  private long mIntervalCheckPreparingTimeOut = 25000L;
  private boolean mIsAllowCheckBuffingByPosition = true;
  private boolean mIsBuffering = false;
  private boolean mIsLive = false;
  private boolean mIsLoopback = false;
  private boolean mIsNotSeekable = false;
  private long mLastCheckPos = -1L;
  private TPSystemMediaPlayer.ResetActionInfo mLastestAction = null;
  private long mLoopEndPositionMs = 0L;
  private long mLoopStartPositionMs = 0L;
  private MediaPlayer mMediaPlayer;
  private boolean mMute = false;
  private ITPPlayerBaseListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerBaseListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerBaseListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerBaseListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerBaseListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerBaseListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener mOnTimedTextListener = new TPSystemMediaPlayer.4(this);
  private ITPPlayerBaseListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private float mPlaySpeed = 1.0F;
  private long mPlayableDurationMs = 0L;
  private int mSelectSubtitleIndex = -1;
  private long mSkipEndPositionMs = -1L;
  private int mStartPositionMs = 0;
  private TPSystemMediaPlayer.PlayerState mState;
  private List<TPSystemMediaPlayer.ExternalTrackInfo> mSubTrackInfo = new ArrayList();
  private Object mSurfaceObj;
  private boolean mSuspend = false;
  private TPSystemCapture mTpSystemCapture;
  private String mUrl;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private int mcheckBufferPosNoChangeCount = 0;
  
  public TPSystemMediaPlayer(Context paramContext)
  {
    int i = mPlayerIndex.incrementAndGet();
    this.TAG = (this.TAG + "_" + i);
    this.mContext = paramContext;
    this.mInnerPlayerListener = new TPSystemMediaPlayer.InnerPlayerListener(this, null);
    paramContext = new TPSystemMediaPlayer.ExternalTrackInfo(null);
    paramContext.info = new TPTrackInfo();
    paramContext.info.isSelected = true;
    paramContext.info.name = "audio_1";
    this.mAudioTrackInfo.add(paramContext);
    initMediaPlayer();
  }
  
  private void checkBuffingEvent()
  {
    long l1 = getCurrentPositionMs();
    long l2 = this.mLastCheckPos;
    this.mLastCheckPos = l1;
    if (this.mState != TPSystemMediaPlayer.PlayerState.STARTED) {
      if ((this.mState == TPSystemMediaPlayer.PlayerState.PAUSED) && (this.mIsBuffering))
      {
        TPLogUtil.i(this.TAG, "checkBuffingEvent, pause state and send end buffering");
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
          TPLogUtil.i(this.TAG, "checkBuffingEvent, skip end, curPosition:" + l1 + ", mSkipEndPositionMs:" + this.mSkipEndPositionMs);
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
            TPLogUtil.i(this.TAG, "checkBuffingEvent, position no change,send start buffering");
            if (this.mOnInfoListener != null) {
              this.mOnInfoListener.onInfo(200, 0L, 0L, null);
            }
          }
          if (this.mcheckBufferPosNoChangeCount < this.mCheckBufferTimeroutFrequent) {
            break;
          }
          TPLogUtil.e(this.TAG, "checkBuffingEvent post error");
          this.mMediaPlayer.reset();
          this.mMediaPlayer.release();
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
              this.mMediaPlayer.reset();
              this.mMediaPlayer.release();
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
                TPLogUtil.e(this.TAG, localException);
              }
            }
          }
        }
      }
    }
    if (this.mIsBuffering)
    {
      TPLogUtil.i(this.TAG, "checkBuffingEvent, position change, send end buffering");
      if (this.mOnInfoListener != null) {
        this.mOnInfoListener.onInfo(201, 0L, 0L, null);
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
    //   21: invokeinterface 446 2 0
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
    //   3: getfield 162	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimerLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 160	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 160	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 446 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 160	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
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
    //   21: invokeinterface 446 2 0
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
  
  private int formatErrorCode(int paramInt)
  {
    if (paramInt < 0) {
      return 10000000 - paramInt;
    }
    return 10000000 + paramInt;
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
    TPLogUtil.i(this.TAG, "handleDataSource, audioTrack url:" + localTPAudioTrackInfo.audioTrackUrl + ", keyId:" + localTPAudioTrackInfo.keyId);
    localIOnInfoListener.onInfo(1011, 0L, 0L, localTPAudioTrackInfo);
  }
  
  private void initMediaPlayer()
  {
    this.mMediaPlayer = mediaPlayerCreate();
    Looper localLooper = Looper.myLooper();
    if (localLooper != null) {
      this.mEventHandler = new TPSystemMediaPlayer.EventHandler(localLooper, this);
    }
    for (;;)
    {
      this.mState = TPSystemMediaPlayer.PlayerState.IDLE;
      return;
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
      TPLogUtil.e(this.TAG, "mediaPlayerExceptionHook, " + Log.getStackTraceString(paramMediaPlayer));
    }
  }
  
  private void mediaPlayerReset()
  {
    destroyCheckPrepareTimeoutTimer();
    destroyCheckBuffingTimer();
    destroyCheckBufferTimeOutByInfo();
    unRegisterListener();
    this.mMediaPlayer.reset();
    this.mMediaPlayer.release();
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
        break label219;
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
      label219:
      if (this.mAudioGain != 1.0F) {
        this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
      }
    }
  }
  
  private void playerResetEnd()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.mLastestAction;
        TPLogUtil.i(this.TAG, "playerResetEnd, actionInfo:" + localObject1 + ", mSuspend:" + this.mSuspend);
        if ((localObject1 == null) || (!this.mSuspend)) {
          break label427;
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
            TPLogUtil.i(this.TAG, "playerResetEnd, onPrepared(), and seek to:" + ((TPSystemMediaPlayer.ResetActionInfo)localObject1).position);
          }
        }
        try
        {
          this.mMediaPlayer.seekTo((int)((TPSystemMediaPlayer.ResetActionInfo)localObject1).position);
          TPLogUtil.i(this.TAG, "playerResetEnd, restore state:" + ((TPSystemMediaPlayer.ResetActionInfo)localObject1).state);
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
          TPLogUtil.e(this.TAG, localException2);
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
        TPLogUtil.i(this.TAG, "playerResetEnd,  MediaPlayer.start().");
        this.mMediaPlayer.start();
        this.mState = localObject2.state;
        startCheckBufferingTimer();
        continue;
      }
      this.mState = TPSystemMediaPlayer.PlayerState.ERROR;
      TPLogUtil.e(this.TAG, "illegal state, state:" + localObject2.state);
      continue;
      label427:
      if ((this.mStartPositionMs > 0) && (!this.mIsNotSeekable)) {
        TPLogUtil.i(this.TAG, "onPrepared(), and seekto:" + this.mStartPositionMs);
      }
      try
      {
        this.mMediaPlayer.seekTo(this.mStartPositionMs);
        this.mState = TPSystemMediaPlayer.PlayerState.PREPARED;
        ITPPlayerBaseListener.IOnPreparedListener localIOnPreparedListener = this.mOnPreparedListener;
        if (localIOnPreparedListener == null) {
          continue;
        }
        localIOnPreparedListener.onPrepared();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          TPLogUtil.e(this.TAG, localException1);
        }
      }
    }
  }
  
  private void playerResetStart(TPSystemMediaPlayer.ResetActionInfo paramResetActionInfo)
  {
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
        TPLogUtil.i(this.TAG, "playerResetStart, pos:" + paramResetActionInfo.position + ", state:" + paramResetActionInfo.state);
        this.mSuspend = true;
        mediaPlayerReset();
        if (this.mFd != null)
        {
          this.mMediaPlayer.setDataSource(this.mFd);
          if (this.mSurfaceObj != null) {
            break label328;
          }
          this.mMediaPlayer.setDisplay(null);
          localObject = this.mLastestAction;
          if ((localObject != null) && (((TPSystemMediaPlayer.ResetActionInfo)localObject).mResetType != paramResetActionInfo.mResetType))
          {
            ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
            if (((TPSystemMediaPlayer.ResetActionInfo)localObject).mResetType != 1) {
              break label382;
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
      label328:
      if ((this.mSurfaceObj instanceof SurfaceHolder))
      {
        this.mMediaPlayer.setDisplay((SurfaceHolder)this.mSurfaceObj);
      }
      else if ((this.mSurfaceObj instanceof Surface))
      {
        this.mMediaPlayer.setSurface((Surface)this.mSurfaceObj);
        continue;
        label382:
        i = 4;
      }
    }
  }
  
  private void seekToComm(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 26)
    {
      TPLogUtil.i(this.TAG, "os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than " + 26 + ", use seekTo(int positionMs) instead");
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
        TPLogUtil.e(this.TAG, localException);
        try
        {
          paramMediaPlayer.seekTo(paramInt1);
          return;
        }
        catch (Exception paramMediaPlayer)
        {
          TPLogUtil.e(this.TAG, paramMediaPlayer);
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
  
  private void startCheckBufferTimeOutByInfo()
  {
    synchronized (this.mCheckBufferTimerOutByInfoLock)
    {
      if (this.mCheckBufferTimeOutBySystemInfoTimer == null) {
        this.mCheckBufferTimeOutBySystemInfoTimer = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.3(this), 1200L, TimeUnit.MILLISECONDS);
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
        TPLogUtil.e(this.TAG, "startCheckBufferingTimer, forbidden check buffer by position");
        return;
      }
      if (this.mCheckBuffingTimer == null) {
        this.mCheckBuffingTimer = TPThreadUtil.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new TPSystemMediaPlayer.2(this), 0L, 400L, TimeUnit.MILLISECONDS);
      }
      return;
    }
  }
  
  private void startCheckPrepareTimeoutTimer()
  {
    TPLogUtil.i(this.TAG, "startCheckPrepareTimeoutTimer");
    synchronized (this.mCheckPrepareTimeoutLock)
    {
      if (this.mCheckPrepareTimeoutTask == null) {
        this.mCheckPrepareTimeoutTask = TPThreadUtil.getScheduledExecutorServiceInstance().schedule(new TPSystemMediaPlayer.1(this), this.mIntervalCheckPreparingTimeOut, TimeUnit.MILLISECONDS);
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
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      TPLogUtil.e(this.TAG, "addAudioTrackSource, illegal argument.");
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
    TPLogUtil.i(this.TAG, "addAudioTrackSource, name:" + localTPTrackInfo.name + ", url:" + paramString2);
    this.mAudioTrackInfo.add(localExternalTrackInfo);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      TPLogUtil.e(this.TAG, "addSubtitleSource, illegal argument.");
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
    TPLogUtil.i(this.TAG, "addSubtitleSource, name:" + paramString2.name + ", url:" + paramString3);
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
      TPLogUtil.e(this.TAG, "deselectTrack, android mediaplayer not support ");
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
    return this.mPlayableDurationMs;
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
    if ((this.mState == TPSystemMediaPlayer.PlayerState.PREPARED) || (this.mState == TPSystemMediaPlayer.PlayerState.STARTED) || (this.mState == TPSystemMediaPlayer.PlayerState.PAUSED)) {}
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
        TPLogUtil.e(this.TAG, "getTrackInfo, android getTrackInfo crash");
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
    if (localObject == null) {
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
    TPLogUtil.i(this.TAG, "getVideoHeight, height:" + this.mVideoHeight);
    return this.mVideoHeight;
  }
  
  public int getVideoWidth()
  {
    TPLogUtil.i(this.TAG, "getVideoWidth, width:" + this.mVideoWidth);
    return this.mVideoWidth;
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 122	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:TAG	Ljava/lang/String;
    //   6: ldc_w 962
    //   9: invokestatic 380	com/tencent/thumbplayer/utils/TPLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 172	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mSuspend	Z
    //   16: ifeq +33 -> 49
    //   19: aload_0
    //   20: getfield 203	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mLastestAction	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$ResetActionInfo;
    //   23: ifnull +13 -> 36
    //   26: aload_0
    //   27: getfield 203	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mLastestAction	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$ResetActionInfo;
    //   30: getstatic 372	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:PAUSED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   33: putfield 656	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$ResetActionInfo:state	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   36: aload_0
    //   37: getfield 122	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:TAG	Ljava/lang/String;
    //   40: ldc_w 964
    //   43: invokestatic 967	com/tencent/thumbplayer/utils/TPLogUtil:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield 341	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   53: invokevirtual 427	android/media/MediaPlayer:pause	()V
    //   56: aload_0
    //   57: getstatic 372	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:PAUSED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   60: putfield 333	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   63: goto -17 -> 46
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	TPSystemMediaPlayer
    //   66	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	66	finally
    //   36	46	66	finally
    //   49	63	66	finally
  }
  
  public void prepare()
  {
    TPLogUtil.i(this.TAG, "prepare ");
    this.mState = TPSystemMediaPlayer.PlayerState.PREPARING;
    this.mMediaPlayer.prepare();
  }
  
  public void prepareAsync()
  {
    TPLogUtil.i(this.TAG, "prepareAsync ");
    this.mState = TPSystemMediaPlayer.PlayerState.PREPARING;
    this.mMediaPlayer.prepareAsync();
    startCheckPrepareTimeoutTimer();
  }
  
  public void release()
  {
    try
    {
      TPLogUtil.i(this.TAG, "release ");
      destroyCheckPrepareTimeoutTimer();
      destroyCheckBuffingTimer();
      destroyCheckBufferTimeOutByInfo();
      unRegisterListener();
      this.mMediaPlayer.reset();
      this.mMediaPlayer.release();
      this.mOnPreparedListener = null;
      this.mOnCompletionListener = null;
      this.mOnInfoListener = null;
      this.mOnErrorListener = null;
      this.mOnSeekCompleteListener = null;
      this.mOnVideoSizeChangedListener = null;
      this.mOnSubtitleDataListener = null;
      this.mEventHandler = null;
      this.mState = TPSystemMediaPlayer.PlayerState.RELEASE;
      this.mSurfaceObj = null;
      TPLogUtil.i(this.TAG, "release over.");
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
      TPLogUtil.i(this.TAG, "reset ");
      this.mMediaPlayer.reset();
      destroyCheckPrepareTimeoutTimer();
      destroyCheckBuffingTimer();
      destroyCheckBufferTimeOutByInfo();
      this.mState = TPSystemMediaPlayer.PlayerState.IDLE;
      TPLogUtil.i(this.TAG, "reset over.");
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
    TPLogUtil.i(this.TAG, "seekTo, position: " + paramInt);
    if (this.mIsNotSeekable) {
      TPLogUtil.i(this.TAG, "current media is not seekable, ignore");
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
      TPLogUtil.e(this.TAG, "seekTo illegalStateException, e = " + localIllegalStateException.toString());
    }
  }
  
  @TargetApi(26)
  public void seekTo(int paramInt1, int paramInt2)
  {
    TPLogUtil.i(this.TAG, "seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.mIsNotSeekable) {
      TPLogUtil.i(this.TAG, "current media is not seekable, ignore");
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
    TPLogUtil.e(this.TAG, "selectProgram, android mediaplayer not support");
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    int i = this.mAudioTrackInfo.size();
    ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
    if ((paramInt >= 0) && (paramInt < i)) {}
    label368:
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
          TPLogUtil.e(this.TAG, localException1);
          if (localIOnInfoListener == null) {
            continue;
          }
          localIOnInfoListener.onInfo(4, formatErrorCode(-10000), 0L, Long.valueOf(paramLong));
          return;
        }
        paramInt -= i;
        if (Build.VERSION.SDK_INT < 16)
        {
          TPLogUtil.e(this.TAG, "selectTrack, android mediaplayer not support ");
          if (localIOnInfoListener != null) {
            localIOnInfoListener.onInfo(4, formatErrorCode(-10001), 0L, Long.valueOf(paramLong));
          }
        }
        else
        {
          if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.STARTED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED))
          {
            TPLogUtil.e(this.TAG, "selectTrack, illegal state:" + this.mState);
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
          catch (Exception localException2)
          {
            for (;;)
            {
              TPLogUtil.e(this.TAG, "getTrackInfo, android getTrackInfo crash");
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
                break label368;
              }
              this.mSelectSubtitleIndex = paramInt;
            }
          }
        }
      }
    } while (localIOnInfoListener == null);
    localIOnInfoListener.onInfo(4, formatErrorCode(-10003), 0L, Long.valueOf(paramLong));
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    TPLogUtil.i(this.TAG, "setAudioGainRatio, : " + paramFloat);
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
      TPLogUtil.i(this.TAG, "setAudioGainRatio ex : " + localIllegalStateException.toString());
    }
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null)
    {
      TPLogUtil.i(this.TAG, "setDataSource pfd is null ");
      throw new IllegalArgumentException("pfd is null");
    }
    TPLogUtil.i(this.TAG, "setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    this.mFd = paramParcelFileDescriptor.getFileDescriptor();
    this.mMediaPlayer.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    this.mTpSystemCapture = new TPSystemCapture(paramParcelFileDescriptor.getFileDescriptor());
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    throw new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
  }
  
  public void setDataSource(String paramString)
  {
    TPLogUtil.i(this.TAG, "setDataSource， url: " + paramString);
    this.mUrl = paramString;
    this.mMediaPlayer.setDataSource(paramString);
    this.mTpSystemCapture = new TPSystemCapture(paramString);
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    TPLogUtil.i(this.TAG, "setDataSource httpHeader, url: " + paramString);
    this.mUrl = paramString;
    this.mHeader = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.mMediaPlayer.setDataSource(this.mContext, paramMap, this.mHeader);
    this.mTpSystemCapture = new TPSystemCapture(paramString);
    this.mState = TPSystemMediaPlayer.PlayerState.INITIALIZED;
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    TPLogUtil.i(this.TAG, "setLoopback, : " + paramBoolean);
    this.mIsLoopback = paramBoolean;
    this.mMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(this.TAG, "setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
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
    throw new IllegalStateException("system Mediaplayer now not support subtitle frame out");
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
    TPLogUtil.i(this.TAG, "setOutputMute, : " + paramBoolean);
    this.mMute = paramBoolean;
    if (paramBoolean) {}
    try
    {
      this.mMediaPlayer.setVolume(0.0F, 0.0F);
      TPLogUtil.i(this.TAG, "setOutputMute, true");
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.i(this.TAG, "setOutputMute, Exception: " + localException.toString());
    }
    this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
    TPLogUtil.i(this.TAG, "setOutputMute, false, mAudioGain: " + this.mAudioGain);
    return;
  }
  
  @TargetApi(23)
  public void setPlaySpeedRatio(float paramFloat)
  {
    TPLogUtil.i(this.TAG, "setPlaySpeedRatio, : " + paramFloat);
    if (Build.VERSION.SDK_INT < 23) {
      TPLogUtil.i(this.TAG, "os version is too low: " + Build.VERSION.SDK_INT);
    }
    for (;;)
    {
      return;
      this.mPlaySpeed = paramFloat;
      TPLogUtil.i(this.TAG, "setPlaySpeedRatio play speed:" + paramFloat);
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
        TPLogUtil.e(this.TAG, localException);
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
      TPLogUtil.i(this.TAG, "setPlayerOptionalParam, start position:" + this.mStartPositionMs);
      return;
    case 500: 
      this.mSkipEndPositionMs = paramTPOptionalParam.getParamLong().value;
      TPLogUtil.i(this.TAG, "setPlayerOptionalParam, skip end position:" + this.mSkipEndPositionMs);
      return;
    case 1: 
      this.mCgiDuration = paramTPOptionalParam.getParamLong().value;
      return;
    case 2: 
      this.mCgiVideoWidth = ((int)paramTPOptionalParam.getParamLong().value);
      TPLogUtil.i(this.TAG, "setPlayerOptionalParam, video width:" + this.mCgiVideoWidth);
      return;
    case 3: 
      this.mCgiVideoHeight = ((int)paramTPOptionalParam.getParamLong().value);
      TPLogUtil.i(this.TAG, "setPlayerOptionalParam, video height:" + this.mCgiVideoHeight);
      return;
    case 4: 
      this.mIsLive = paramTPOptionalParam.getParamBoolean().value;
      this.mIsNotSeekable = true;
      TPLogUtil.i(this.TAG, "setPlayerOptionalParam, is live:" + this.mIsLive);
      return;
    case 5: 
      this.mIsAllowCheckBuffingByPosition = paramTPOptionalParam.getParamBoolean().value;
      return;
    case 207: 
      this.mIntervalCheckPreparingTimeOut = paramTPOptionalParam.getParamLong().value;
      TPLogUtil.i(this.TAG, "setPlayerOptionalParam, prepare timeout:" + this.mIntervalCheckPreparingTimeOut + "(ms)");
      return;
    }
    this.mCheckBufferTimeroutFrequent = ((int)((paramTPOptionalParam.getParamLong().value + 400L) / 400L));
    TPLogUtil.i(this.TAG, "setPlayerOptionalParam, buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
  }
  
  public void setSurface(Surface paramSurface)
  {
    TPLogUtil.i(this.TAG, "setSurface, surface: " + paramSurface);
    this.mSurfaceObj = paramSurface;
    try
    {
      this.mMediaPlayer.setSurface(paramSurface);
      TPLogUtil.i(this.TAG, "setSurface over, surface: " + paramSurface);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        TPLogUtil.e(this.TAG, "setSurface error, " + localIllegalStateException.toString());
      }
    }
  }
  
  public void start()
  {
    TPLogUtil.i(this.TAG, "start ");
    if (this.mSuspend)
    {
      if (this.mLastestAction != null) {
        this.mLastestAction.state = TPSystemMediaPlayer.PlayerState.STARTED;
      }
      TPLogUtil.w(this.TAG, "system player is busy.");
      return;
    }
    if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED))
    {
      TPLogUtil.w(this.TAG, "start(), illegal state, state:" + this.mState);
      return;
    }
    this.mMediaPlayer.start();
    this.mState = TPSystemMediaPlayer.PlayerState.STARTED;
    if (this.mPlaySpeed != 1.0D) {
      setPlaySpeedRatio(this.mPlaySpeed);
    }
    startCheckBufferingTimer();
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 122	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:TAG	Ljava/lang/String;
    //   6: ldc_w 1160
    //   9: invokestatic 380	com/tencent/thumbplayer/utils/TPLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokespecial 345	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:destroyCheckPrepareTimeoutTimer	()V
    //   16: aload_0
    //   17: invokespecial 288	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:destroyCheckBuffingTimer	()V
    //   20: aload_0
    //   21: invokespecial 276	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:destroyCheckBufferTimeOutByInfo	()V
    //   24: aload_0
    //   25: getfield 333	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   28: getstatic 489	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:IDLE	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   31: if_acmpeq +43 -> 74
    //   34: aload_0
    //   35: getfield 333	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   38: getstatic 659	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:INITIALIZED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   41: if_acmpeq +33 -> 74
    //   44: aload_0
    //   45: getfield 333	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   48: getstatic 662	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:PREPARING	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   51: if_acmpeq +23 -> 74
    //   54: aload_0
    //   55: getfield 333	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   58: getstatic 415	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:ERROR	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   61: if_acmpeq +13 -> 74
    //   64: aload_0
    //   65: getfield 333	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   68: getstatic 979	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:RELEASE	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   71: if_acmpne +50 -> 121
    //   74: aload_0
    //   75: getfield 341	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   78: invokevirtual 409	android/media/MediaPlayer:reset	()V
    //   81: aload_0
    //   82: getstatic 909	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState:STOPPED	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   85: putfield 333	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mState	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$PlayerState;
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 192	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCurAudioTrackIndex	I
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 203	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mLastestAction	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer$ResetActionInfo;
    //   98: aload_0
    //   99: iconst_m1
    //   100: putfield 190	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mSelectSubtitleIndex	I
    //   103: aload_0
    //   104: iconst_m1
    //   105: putfield 194	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCurInnerAudioTrackIndex	I
    //   108: aload_0
    //   109: getfield 122	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:TAG	Ljava/lang/String;
    //   112: ldc_w 1162
    //   115: invokestatic 380	com/tencent/thumbplayer/utils/TPLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: monitorexit
    //   120: return
    //   121: aload_0
    //   122: getfield 341	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   125: invokevirtual 1164	android/media/MediaPlayer:stop	()V
    //   128: goto -47 -> 81
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	TPSystemMediaPlayer
    //   131	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	74	131	finally
    //   74	81	131	finally
    //   81	118	131	finally
    //   121	128	131	finally
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, int paramInt, long paramLong) {}
  
  public void switchDefinition(String paramString, int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, "switchDefinition, defUrl: " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.i(this.TAG, "switchDefinition, defUrl is null");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer
 * JD-Core Version:    0.7.0.1
 */