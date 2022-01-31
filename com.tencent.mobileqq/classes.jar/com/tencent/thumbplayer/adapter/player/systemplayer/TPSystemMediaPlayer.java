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
  private static final int CHECK_BUFFER_FREQUENT = 3;
  private static final int RESET_TYPE_SEL_AUDIO_TRACK = 2;
  private static final int RESET_TYPE_SWITCH_URL = 1;
  private static final int START_AUTO_SEEK_DELAY_TIME = 2000;
  private static final String TAG = "TPThumbPlayer[TPSystemMediaPlayer.java]";
  private static final int mIntervalCheckBuffering = 400;
  private float mAudioGain = 1.0F;
  private List<TPSystemMediaPlayer.ExternalTrackInfo> mAudioTrackInfo = new ArrayList();
  private long mBaseDuration = 0L;
  private long mBufferMs = 0L;
  private long mCgiDuration = -1L;
  private int mCgiVideoHeight = -1;
  private int mCgiVideoWidth = -1;
  private Future<?> mCheckBufferTimeOutBySystemInfoTimer = null;
  private Object mCheckBufferTimerOutByInfoLock = new Object();
  private int mCheckBufferTimeroutFrequent = 30;
  private Future<?> mCheckBuffingTimer = null;
  private final Object mCheckBuffingTimerLock = new Object();
  private Object mCheckPrepareTimeoutLock = new Object();
  private Future<?> mCheckPrepareTimeoutTask = null;
  private Context mContext = null;
  private int mCurAudioTrackIndex = 0;
  private int mCurInnerAudioTrackIndex = -1;
  private TPSystemMediaPlayer.EventHandler mEventHandler;
  private FileDescriptor mFd;
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
  private TPSystemMediaPlayer.ResetActionInfo mLastestAction = null;
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
  private TPSystemCapture mTpSystemCapture;
  private String mUrl;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private int mcheckBufferPosNoChangeCount = 0;
  
  public TPSystemMediaPlayer(Context paramContext)
  {
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
    //   3: getfield 151	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimerOutByInfoLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 153	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 153	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 414 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 153	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBufferTimeOutBySystemInfoTimer	Ljava/util/concurrent/Future;
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
    //   3: getfield 147	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimerLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 145	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 145	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 414 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 145	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckBuffingTimer	Ljava/util/concurrent/Future;
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
    //   3: getfield 139	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 137	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 137	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
    //   20: iconst_1
    //   21: invokeinterface 414 2 0
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 137	com/tencent/thumbplayer/adapter/player/systemplayer/TPSystemMediaPlayer:mCheckPrepareTimeoutTask	Ljava/util/concurrent/Future;
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
    localIOnInfoListener.onInfo(1011, 0L, 0L, localTPAudioTrackInfo);
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
  
  private void playerResetEnd()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.mLastestAction;
        if (localObject1 == null) {
          break label325;
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
            TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + this.mStartPositionMs);
          }
        }
        try
        {
          this.mMediaPlayer.seekTo((int)((TPSystemMediaPlayer.ResetActionInfo)localObject1).position);
          if ((((TPSystemMediaPlayer.ResetActionInfo)localObject1).state == TPSystemMediaPlayer.PlayerState.IDLE) || (((TPSystemMediaPlayer.ResetActionInfo)localObject1).state == TPSystemMediaPlayer.PlayerState.INITIALIZED) || (((TPSystemMediaPlayer.ResetActionInfo)localObject1).state == TPSystemMediaPlayer.PlayerState.PREPARING))
          {
            localObject1 = this.mOnPreparedListener;
            if (localObject1 != null) {
              ((ITPPlayerBaseListener.IOnPreparedListener)localObject1).onPrepared();
            }
            this.mState = TPSystemMediaPlayer.PlayerState.PREPARED;
            this.mLastestAction = null;
            return;
            i = 4;
          }
        }
        catch (Exception localException2)
        {
          TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException2);
          continue;
        }
        if (localObject2.state == TPSystemMediaPlayer.PlayerState.PREPARED) {
          break label248;
        }
      }
      finally {}
      if (localObject2.state == TPSystemMediaPlayer.PlayerState.PAUSED)
      {
        label248:
        this.mState = localObject2.state;
        continue;
      }
      if (localObject2.state == TPSystemMediaPlayer.PlayerState.STARTED)
      {
        this.mMediaPlayer.start();
        this.mState = localObject2.state;
        continue;
      }
      this.mState = TPSystemMediaPlayer.PlayerState.ERROR;
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "illegal state, state:" + localObject2.state);
      continue;
      label325:
      if ((this.mStartPositionMs > 0) && (!this.mIsNotSeekable)) {
        TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + this.mStartPositionMs);
      }
      try
      {
        this.mMediaPlayer.seekTo(this.mStartPositionMs);
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
          TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        }
      }
    }
  }
  
  private void playerResetStart(TPSystemMediaPlayer.ResetActionInfo paramResetActionInfo)
  {
    for (;;)
    {
      Object localObject;
      float f1;
      float f2;
      try
      {
        localObject = paramResetActionInfo.url;
        paramResetActionInfo.position = getCurrentPositionMs();
        paramResetActionInfo.state = this.mState;
        paramResetActionInfo.innerAudioTrackIndex = this.mCurInnerAudioTrackIndex;
        paramResetActionInfo.innerSubtitleTrackIndex = this.mSelectSubtitleIndex;
        f1 = this.mAudioGain;
        f2 = this.mPlaySpeed;
        boolean bool = this.mIsLoopback;
        this.mMediaPlayer.reset();
        if (this.mFd != null)
        {
          this.mMediaPlayer.setDataSource(this.mFd);
          break label337;
          this.mMediaPlayer.setVolume(this.mAudioGain, this.mAudioGain);
          break label352;
          setPlaySpeedRatio(f2);
          if (bool) {
            this.mMediaPlayer.setLooping(bool);
          }
          localObject = this.mLastestAction;
          if ((localObject != null) && (((TPSystemMediaPlayer.ResetActionInfo)localObject).mResetType != paramResetActionInfo.mResetType))
          {
            ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
            if (((TPSystemMediaPlayer.ResetActionInfo)localObject).mResetType != 1) {
              break label331;
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
            startCheckBufferingTimer();
          }
          return;
        }
        handleDataSource(paramResetActionInfo.externalAudioTrackIndex);
        if ((this.mHeader != null) && (!this.mHeader.isEmpty()))
        {
          localObject = Uri.parse((String)localObject);
          this.mMediaPlayer.setDataSource(this.mContext, (Uri)localObject, this.mHeader);
        }
      }
      finally {}
      this.mMediaPlayer.setDataSource((String)localObject);
      break label337;
      label331:
      int i = 4;
      continue;
      label337:
      if ((f1 <= 1.0F) && (f1 >= 1.0F)) {
        label352:
        if (f2 <= 1.0F) {
          if (f2 >= 1.0F) {}
        }
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
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addAudioTrackSource, illegal argument.");
    }
    TPTrackInfo localTPTrackInfo = new TPTrackInfo();
    localTPTrackInfo.name = paramString2;
    localTPTrackInfo.isExclusive = true;
    localTPTrackInfo.isInternal = false;
    localTPTrackInfo.isSelected = false;
    paramString2 = new TPSystemMediaPlayer.ExternalTrackInfo(null);
    paramString2.info = localTPTrackInfo;
    paramString2.url = paramString1;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramList = (TPOptionalParam)paramString1.next();
      if (paramList.getKey() == 6) {
        paramString2.keyId = paramList.getParamString().value;
      }
    }
    this.mAudioTrackInfo.add(paramString2);
  }
  
  @TargetApi(16)
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addSubtitleSource android mediaplayer not support ");
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      String str = "";
      if (paramString2.equals("text/x-subrip"))
      {
        paramString3 = "application/x-subrip";
        if (Build.VERSION.SDK_INT >= 28) {
          paramString3 = "application/x-subrip";
        }
      }
      while (TextUtils.isEmpty(paramString3))
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addTimedTextSource, mimeType no support.");
        return;
        paramString3 = str;
        if (paramString2.equals("text/vtt"))
        {
          paramString3 = str;
          if (Build.VERSION.SDK_INT >= 28) {
            paramString3 = "application/x-subrip";
          }
        }
      }
      try
      {
        this.mMediaPlayer.addTimedTextSource(this.mContext, Uri.parse(paramString1), paramString3);
        return;
      }
      catch (Exception paramString1)
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramString1, "addTimedTextSource error");
        return;
      }
    }
    TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addTimedTextSource, mimeType no support.");
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
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "deselectTrack, android mediaplayer not support ");
      return;
    }
    this.mMediaPlayer.deselectTrack(paramInt);
  }
  
  public long getBufferedDurationMs()
  {
    return this.mBufferMs;
  }
  
  public long getCurrentPositionMs()
  {
    if ((this.mMediaPlayer == null) || (this.mState == TPSystemMediaPlayer.PlayerState.IDLE) || (this.mState == TPSystemMediaPlayer.PlayerState.INITIALIZED) || (this.mState == TPSystemMediaPlayer.PlayerState.PREPARING) || (this.mState == TPSystemMediaPlayer.PlayerState.STOPPED) || (this.mState == TPSystemMediaPlayer.PlayerState.PREPARED)) {
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
    int j = 0;
    if ((this.mState == TPSystemMediaPlayer.PlayerState.PREPARED) || (this.mState == TPSystemMediaPlayer.PlayerState.STARTED) || (this.mState == TPSystemMediaPlayer.PlayerState.PAUSED)) {}
    Object localObject;
    for (;;)
    {
      try
      {
        MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.mMediaPlayer.getTrackInfo();
        if ((arrayOfTrackInfo != null) || (!this.mAudioTrackInfo.isEmpty())) {
          break;
        }
        return new TPTrackInfo[0];
      }
      catch (Exception localException)
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "getTrackInfo, android getTrackInfo crash");
      }
      localObject = null;
    }
    int k = this.mAudioTrackInfo.size();
    if (localObject == null) {}
    TPTrackInfo[] arrayOfTPTrackInfo;
    Iterator localIterator;
    for (int i = 0;; i = localObject.length)
    {
      arrayOfTPTrackInfo = new TPTrackInfo[i + k];
      localIterator = this.mAudioTrackInfo.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        arrayOfTPTrackInfo[i] = ((TPSystemMediaPlayer.ExternalTrackInfo)localIterator.next()).info;
        i += 1;
      }
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
    if (this.mVideoHeight <= 0) {
      this.mVideoHeight = this.mMediaPlayer.getVideoHeight();
    }
    if ((this.mVideoHeight <= 0) && (this.mCgiVideoHeight > 0) && ((this.mState == TPSystemMediaPlayer.PlayerState.PREPARED) || (this.mState == TPSystemMediaPlayer.PlayerState.STARTED) || (this.mState == TPSystemMediaPlayer.PlayerState.PAUSED))) {
      this.mVideoHeight = this.mCgiVideoHeight;
    }
    return this.mVideoHeight;
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
    this.mMediaPlayer.reset();
    this.mMediaPlayer.release();
    unRegisterListener();
    this.mEventHandler = null;
    this.mState = TPSystemMediaPlayer.PlayerState.RELEASE;
  }
  
  public void reset()
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "reset ");
    this.mIsStartGetCurrentPosChange = false;
    this.mMediaPlayer.reset();
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
  
  public void selectTrack(int paramInt, long paramLong)
  {
    int i = this.mAudioTrackInfo.size();
    ITPPlayerBaseListener.IOnInfoListener localIOnInfoListener = this.mOnInfoListener;
    if ((paramInt >= 0) && (paramInt < i)) {}
    label360:
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
          TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
          if (localIOnInfoListener == null) {
            continue;
          }
          localIOnInfoListener.onInfo(4, formatErrorCode(-10000), 0L, Long.valueOf(paramLong));
          return;
        }
        paramInt -= i;
        if (Build.VERSION.SDK_INT < 16)
        {
          TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, android mediaplayer not support ");
          if (localIOnInfoListener != null) {
            localIOnInfoListener.onInfo(4, formatErrorCode(-10001), 0L, Long.valueOf(paramLong));
          }
        }
        else
        {
          if ((this.mState != TPSystemMediaPlayer.PlayerState.PREPARED) && (this.mState != TPSystemMediaPlayer.PlayerState.STARTED) && (this.mState != TPSystemMediaPlayer.PlayerState.PAUSED))
          {
            TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, illegal state:" + this.mState);
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
              TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "getTrackInfo, android getTrackInfo crash");
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
                break label360;
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
    if (paramParcelFileDescriptor == null) {
      try
      {
        TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd is null ");
        throw new IllegalArgumentException("pfd is null");
      }
      finally {}
    }
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
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
    this.mCurAudioTrackIndex = 0;
    this.mSelectSubtitleIndex = -1;
    this.mCurInnerAudioTrackIndex = -1;
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, int paramInt, long paramLong) {}
  
  public void switchDefinition(String paramString, int paramInt, long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer
 * JD-Core Version:    0.7.0.1
 */