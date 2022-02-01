package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnMediaTimeDiscontinuityListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer;", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioPlayer;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "(Lcom/tencent/mobileqq/triton/utils/LogDelegate;)V", "isPrepared", "", "()Z", "mAudioId", "", "mAudioPath", "", "mAudioStateChangeListener", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;", "mAutoPlay", "mBufferedTime", "", "mCacheDuration", "mIsPrepared", "mLoop", "mMediaPlayer", "Landroid/media/MediaPlayer;", "mNeedToResume", "mOnCompletionListener", "Landroid/media/MediaPlayer$OnCompletionListener;", "mOnPreparedListener", "Landroid/media/MediaPlayer$OnPreparedListener;", "mOnSeekCompleteListener", "Landroid/media/MediaPlayer$OnSeekCompleteListener;", "mPaused", "mPendingOperateTasks", "", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "", "mStartTime", "mTimeUpdateTimer", "Ljava/util/Timer;", "mVolume", "", "onBufferingUpdateListener", "Landroid/media/MediaPlayer$OnBufferingUpdateListener;", "onErrorListener", "Landroid/media/MediaPlayer$OnErrorListener;", "addOperateTask", "", "runnable", "execOperateTasks", "getAudioId", "getAudioPath", "getAutoPlay", "getBufferedTime", "getCurrentPosition", "getDuration", "getLoop", "getStartTime", "getStateChangeListener", "getVolume", "isNeedResume", "isPaused", "isPlaying", "pause", "play", "preparePlayer", "release", "reset", "resume", "seekTo", "pos", "setAudioId", "audioId", "setAudioPath", "path", "setAutoPlay", "autoplay", "setLoop", "loop", "setNeedResume", "needResume", "setStartTime", "startTime", "setStateChangeListener", "listener", "setVolume", "vol", "startTimeUpdateCallback", "stop", "stopTimeUpdateCallback", "Companion", "ResetTask", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class InnerAudioPlayer
  implements IAudioPlayer
{
  private static final int AUDIO_DURATION_THREADHOLD = 500;
  public static final InnerAudioPlayer.Companion Companion = new InnerAudioPlayer.Companion(null);
  private static final String TAG = "[audio] InnerAudioPlayer";
  private static final int TIME_UPDATE_FIXED_PERIOD = 250;
  private final LogDelegate logger;
  private int mAudioId;
  private String mAudioPath;
  private IAudioStateChangeListener mAudioStateChangeListener;
  private boolean mAutoPlay;
  private double mBufferedTime;
  private volatile int mCacheDuration;
  private volatile boolean mIsPrepared;
  private boolean mLoop;
  private MediaPlayer mMediaPlayer;
  private boolean mNeedToResume;
  private final MediaPlayer.OnCompletionListener mOnCompletionListener;
  private final MediaPlayer.OnPreparedListener mOnPreparedListener;
  private final MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
  private volatile boolean mPaused;
  private final List<Runnable> mPendingOperateTasks;
  private int mStartTime;
  private Timer mTimeUpdateTimer;
  private float mVolume;
  private final MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
  private final MediaPlayer.OnErrorListener onErrorListener;
  
  public InnerAudioPlayer(@Nullable LogDelegate paramLogDelegate)
  {
    this.logger = paramLogDelegate;
    this.mPaused = true;
    this.mVolume = 1.0F;
    this.onBufferingUpdateListener = ((MediaPlayer.OnBufferingUpdateListener)new InnerAudioPlayer.onBufferingUpdateListener.1(this));
    this.mOnCompletionListener = ((MediaPlayer.OnCompletionListener)new InnerAudioPlayer.mOnCompletionListener.1(this));
    this.mOnSeekCompleteListener = ((MediaPlayer.OnSeekCompleteListener)new InnerAudioPlayer.mOnSeekCompleteListener.1(this));
    this.onErrorListener = ((MediaPlayer.OnErrorListener)new InnerAudioPlayer.onErrorListener.1(this));
    this.mOnPreparedListener = ((MediaPlayer.OnPreparedListener)new InnerAudioPlayer.mOnPreparedListener.1(this));
    this.mPendingOperateTasks = Collections.synchronizedList((List)new ArrayList());
  }
  
  private final void addOperateTask(Runnable paramRunnable)
  {
    this.mPendingOperateTasks.add(paramRunnable);
  }
  
  private final void execOperateTasks()
  {
    if (this.mPendingOperateTasks.size() > 0)
    {
      Iterator localIterator = this.mPendingOperateTasks.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      this.mPendingOperateTasks.clear();
    }
  }
  
  private final boolean isPrepared()
  {
    return (this.mMediaPlayer != null) && (this.mIsPrepared);
  }
  
  private final MediaPlayer preparePlayer()
  {
    MediaPlayer localMediaPlayer = MediaPlayerManager.getInstance().dequeuePlayer();
    if (localMediaPlayer != null)
    {
      localMediaPlayer.setOnErrorListener(this.onErrorListener);
      localMediaPlayer.setOnCompletionListener(this.mOnCompletionListener);
      localMediaPlayer.setOnPreparedListener(this.mOnPreparedListener);
      localMediaPlayer.setOnBufferingUpdateListener(this.onBufferingUpdateListener);
      localMediaPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
      if (Build.VERSION.SDK_INT >= 28) {
        localMediaPlayer.setOnMediaTimeDiscontinuityListener((MediaPlayer.OnMediaTimeDiscontinuityListener)new InnerAudioPlayer.preparePlayer.1(this));
      }
    }
    return localMediaPlayer;
  }
  
  private final void startTimeUpdateCallback()
  {
    if (this.mTimeUpdateTimer == null) {
      this.mTimeUpdateTimer = new Timer(true);
    }
    Timer localTimer = this.mTimeUpdateTimer;
    if (localTimer == null) {
      Intrinsics.throwNpe();
    }
    localTimer.scheduleAtFixedRate((TimerTask)new InnerAudioPlayer.startTimeUpdateCallback.1(this), 0L, 'ú');
  }
  
  private final void stopTimeUpdateCallback()
  {
    Timer localTimer = this.mTimeUpdateTimer;
    if (localTimer != null)
    {
      if (localTimer == null) {
        Intrinsics.throwNpe();
      }
      localTimer.cancel();
      this.mTimeUpdateTimer = ((Timer)null);
    }
  }
  
  public int getAudioId()
  {
    return this.mAudioId;
  }
  
  @Nullable
  public String getAudioPath()
  {
    return this.mAudioPath;
  }
  
  public boolean getAutoPlay()
  {
    return this.mAutoPlay;
  }
  
  public double getBufferedTime()
  {
    return this.mBufferedTime;
  }
  
  public int getCurrentPosition()
  {
    boolean bool = isPrepared();
    int i = 0;
    if (bool) {
      try
      {
        MediaPlayer localMediaPlayer = this.mMediaPlayer;
        if (localMediaPlayer != null) {
          i = localMediaPlayer.getCurrentPosition();
        }
        return i;
      }
      catch (Throwable localThrowable)
      {
        LogDelegate localLogDelegate = this.logger;
        if (localLogDelegate != null)
        {
          LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCurrentPosition error. audioId=");
          localStringBuilder.append(getAudioId());
          localStringBuilder.append(" path=");
          localStringBuilder.append(getAudioPath());
          localLogDelegate.printLog(localLevel, str, localStringBuilder.toString(), localThrowable);
        }
      }
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (this.mCacheDuration > 0) {
      return this.mCacheDuration;
    }
    if (isPrepared()) {
      try
      {
        if (this.mMediaPlayer != null)
        {
          MediaPlayer localMediaPlayer = this.mMediaPlayer;
          if (localMediaPlayer == null) {
            Intrinsics.throwNpe();
          }
          this.mCacheDuration = localMediaPlayer.getDuration();
        }
      }
      catch (Throwable localThrowable)
      {
        LogDelegate localLogDelegate = this.logger;
        if (localLogDelegate != null)
        {
          LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getDuration error. audioId=");
          localStringBuilder.append(getAudioId());
          localStringBuilder.append(" path=");
          localStringBuilder.append(getAudioPath());
          localLogDelegate.printLog(localLevel, str, localStringBuilder.toString(), localThrowable);
        }
      }
    }
    if (this.mCacheDuration < 0) {
      this.mCacheDuration = 0;
    }
    return this.mCacheDuration;
  }
  
  public boolean getLoop()
  {
    return this.mLoop;
  }
  
  public float getStartTime()
  {
    return this.mStartTime;
  }
  
  @Nullable
  public IAudioStateChangeListener getStateChangeListener()
  {
    return this.mAudioStateChangeListener;
  }
  
  public float getVolume()
  {
    return this.mVolume;
  }
  
  public boolean isNeedResume()
  {
    return this.mNeedToResume;
  }
  
  public boolean isPaused()
  {
    return this.mPaused;
  }
  
  public boolean isPlaying()
  {
    boolean bool2 = isPrepared();
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (bool2)
    {
      MediaPlayer localMediaPlayer = this.mMediaPlayer;
      if (localMediaPlayer != null) {
        bool2 = localMediaPlayer.isPlaying();
      } else {
        bool2 = false;
      }
      bool1 = bool3;
      if (bool2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void pause()
  {
    if (this.mMediaPlayer == null) {
      return;
    }
    if (!isPrepared())
    {
      addOperateTask((Runnable)new InnerAudioPlayer.pause.1(this));
      return;
    }
    try
    {
      this.mPaused = true;
      if (this.mMediaPlayer != null)
      {
        MediaPlayer localMediaPlayer = this.mMediaPlayer;
        if (localMediaPlayer == null) {
          Intrinsics.throwNpe();
        }
        localMediaPlayer.pause();
      }
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null)
      {
        LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pause error. audioId=");
        localStringBuilder.append(getAudioId());
        localStringBuilder.append(" path=");
        localStringBuilder.append(getAudioPath());
        localLogDelegate.printLog(localLevel, str, localStringBuilder.toString(), localThrowable);
      }
    }
    stopTimeUpdateCallback();
    IAudioStateChangeListener localIAudioStateChangeListener = getStateChangeListener();
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onPause();
    }
  }
  
  public void play()
  {
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (TextUtils.isEmpty((CharSequence)getAudioPath()))
    {
      localObject1 = this.logger;
      if (localObject1 != null)
      {
        localObject3 = LogDelegate.Level.WARN;
        localObject4 = TAG;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("play error on empty audio path, audioId=");
        ((StringBuilder)localObject5).append(getAudioId());
        ((StringBuilder)localObject5).append(" path=");
        ((StringBuilder)localObject5).append(getAudioPath());
        LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject1, (LogDelegate.Level)localObject3, (String)localObject4, ((StringBuilder)localObject5).toString(), null, 8, null);
      }
      return;
    }
    StringBuilder localStringBuilder;
    Object localObject2;
    if (this.mMediaPlayer == null)
    {
      this.mMediaPlayer = preparePlayer();
      localObject1 = this.mMediaPlayer;
      if (localObject1 != null)
      {
        if (localObject1 == null) {}
        try
        {
          Intrinsics.throwNpe();
          ((MediaPlayer)localObject1).setDataSource(getAudioPath());
          localObject1 = this.mMediaPlayer;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject1).prepareAsync();
          boolean bool = getAutoPlay();
          if (bool) {
            return;
          }
        }
        catch (Throwable localThrowable1)
        {
          localObject3 = this.logger;
          if (localObject3 != null)
          {
            localObject4 = LogDelegate.Level.ERROR;
            localObject5 = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("play error on setDataSource and prepareAsync.");
            localStringBuilder.append(" audioId=");
            localStringBuilder.append(getAudioId());
            localStringBuilder.append(" path=");
            localStringBuilder.append(getAudioPath());
            ((LogDelegate)localObject3).printLog((LogDelegate.Level)localObject4, (String)localObject5, localStringBuilder.toString(), localThrowable1);
          }
          localObject2 = getStateChangeListener();
          if (localObject2 != null) {
            ((IAudioStateChangeListener)localObject2).onError(10003);
          }
        }
      }
    }
    if (this.mMediaPlayer == null)
    {
      localObject2 = this.logger;
      if (localObject2 != null)
      {
        localObject3 = LogDelegate.Level.WARN;
        localObject4 = TAG;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("play error on null mMediaPlayer, audioId=");
        ((StringBuilder)localObject5).append(getAudioId());
        ((StringBuilder)localObject5).append(" path=");
        ((StringBuilder)localObject5).append(getAudioPath());
        LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject2, (LogDelegate.Level)localObject3, (String)localObject4, ((StringBuilder)localObject5).toString(), null, 8, null);
      }
      return;
    }
    if (isPlaying()) {
      return;
    }
    if (!isPrepared())
    {
      addOperateTask((Runnable)new InnerAudioPlayer.play.1(this));
      return;
    }
    try
    {
      if (this.mMediaPlayer != null)
      {
        localObject2 = this.mMediaPlayer;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((MediaPlayer)localObject2).setLooping(getLoop());
        localObject2 = this.logger;
        if (localObject2 != null)
        {
          localObject3 = LogDelegate.Level.INFO;
          localObject4 = TAG;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("play volume=");
          ((StringBuilder)localObject5).append(getVolume());
          LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject2, (LogDelegate.Level)localObject3, (String)localObject4, ((StringBuilder)localObject5).toString(), null, 8, null);
        }
        float f1 = getVolume();
        float f2 = 0;
        if (f1 >= f2)
        {
          localObject2 = this.mMediaPlayer;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject2).setVolume(getVolume(), getVolume());
        }
        if ((!isPaused()) && (getStartTime() > f2))
        {
          localObject2 = this.mMediaPlayer;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject2).seekTo(this.mStartTime);
        }
        localObject2 = this.mMediaPlayer;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((MediaPlayer)localObject2).start();
        startTimeUpdateCallback();
      }
      this.mPaused = false;
    }
    catch (Throwable localThrowable2)
    {
      localObject3 = this.logger;
      if (localObject3 != null)
      {
        localObject4 = LogDelegate.Level.ERROR;
        localObject5 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play error. audioId=");
        localStringBuilder.append(getAudioId());
        localStringBuilder.append(" path=");
        localStringBuilder.append(getAudioPath());
        ((LogDelegate)localObject3).printLog((LogDelegate.Level)localObject4, (String)localObject5, localStringBuilder.toString(), localThrowable2);
      }
    }
    IAudioStateChangeListener localIAudioStateChangeListener = getStateChangeListener();
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onPlay();
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +58 -> 64
    //   9: aload_0
    //   10: invokevirtual 434	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:isPlaying	()Z
    //   13: ifeq +19 -> 32
    //   16: aload_0
    //   17: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +6 -> 28
    //   25: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   28: aload_1
    //   29: invokevirtual 473	android/media/MediaPlayer:stop	()V
    //   32: aload_0
    //   33: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +6 -> 44
    //   41: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   44: aload_1
    //   45: invokevirtual 475	android/media/MediaPlayer:reset	()V
    //   48: aload_0
    //   49: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnonnull +6 -> 60
    //   57: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   60: aload_1
    //   61: invokevirtual 477	android/media/MediaPlayer:release	()V
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 312	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioId	I
    //   69: aload_0
    //   70: aconst_null
    //   71: checkcast 479	java/lang/String
    //   74: putfield 314	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioPath	Ljava/lang/String;
    //   77: aload_0
    //   78: iconst_0
    //   79: putfield 373	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mNeedToResume	Z
    //   82: aload_0
    //   83: dconst_0
    //   84: putfield 198	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mBufferedTime	D
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 368	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mStartTime	I
    //   92: aload_0
    //   93: ldc_w 480
    //   96: putfield 138	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mVolume	F
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 365	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mLoop	Z
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 317	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAutoPlay	Z
    //   109: aload_0
    //   110: iconst_1
    //   111: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   114: aload_0
    //   115: aconst_null
    //   116: checkcast 252	android/media/MediaPlayer
    //   119: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   122: aload_0
    //   123: getfield 188	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPendingOperateTasks	Ljava/util/List;
    //   126: astore_1
    //   127: aload_1
    //   128: invokeinterface 238 1 0
    //   133: goto +154 -> 287
    //   136: astore_1
    //   137: goto +153 -> 290
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 134	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:logger	Lcom/tencent/mobileqq/triton/utils/LogDelegate;
    //   145: astore_2
    //   146: aload_2
    //   147: ifnull +74 -> 221
    //   150: getstatic 330	com/tencent/mobileqq/triton/utils/LogDelegate$Level:ERROR	Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;
    //   153: astore_3
    //   154: getstatic 128	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:TAG	Ljava/lang/String;
    //   157: astore 4
    //   159: new 332	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   166: astore 5
    //   168: aload 5
    //   170: ldc_w 482
    //   173: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 5
    //   179: aload_0
    //   180: invokevirtual 341	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getAudioId	()I
    //   183: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 5
    //   189: ldc_w 346
    //   192: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 5
    //   198: aload_0
    //   199: invokevirtual 348	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getAudioPath	()Ljava/lang/String;
    //   202: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_2
    //   207: aload_3
    //   208: aload 4
    //   210: aload 5
    //   212: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: aload_1
    //   216: invokeinterface 357 5 0
    //   221: aload_0
    //   222: iconst_0
    //   223: putfield 312	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioId	I
    //   226: aload_0
    //   227: aconst_null
    //   228: checkcast 479	java/lang/String
    //   231: putfield 314	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioPath	Ljava/lang/String;
    //   234: aload_0
    //   235: iconst_0
    //   236: putfield 373	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mNeedToResume	Z
    //   239: aload_0
    //   240: dconst_0
    //   241: putfield 198	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mBufferedTime	D
    //   244: aload_0
    //   245: iconst_0
    //   246: putfield 368	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mStartTime	I
    //   249: aload_0
    //   250: ldc_w 480
    //   253: putfield 138	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mVolume	F
    //   256: aload_0
    //   257: iconst_0
    //   258: putfield 365	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mLoop	Z
    //   261: aload_0
    //   262: iconst_0
    //   263: putfield 317	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAutoPlay	Z
    //   266: aload_0
    //   267: iconst_1
    //   268: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   271: aload_0
    //   272: aconst_null
    //   273: checkcast 252	android/media/MediaPlayer
    //   276: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   279: aload_0
    //   280: getfield 188	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPendingOperateTasks	Ljava/util/List;
    //   283: astore_1
    //   284: goto -157 -> 127
    //   287: aload_0
    //   288: monitorexit
    //   289: return
    //   290: aload_0
    //   291: iconst_0
    //   292: putfield 312	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioId	I
    //   295: aload_0
    //   296: aconst_null
    //   297: checkcast 479	java/lang/String
    //   300: putfield 314	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioPath	Ljava/lang/String;
    //   303: aload_0
    //   304: iconst_0
    //   305: putfield 373	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mNeedToResume	Z
    //   308: aload_0
    //   309: dconst_0
    //   310: putfield 198	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mBufferedTime	D
    //   313: aload_0
    //   314: iconst_0
    //   315: putfield 368	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mStartTime	I
    //   318: aload_0
    //   319: ldc_w 480
    //   322: putfield 138	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mVolume	F
    //   325: aload_0
    //   326: iconst_0
    //   327: putfield 365	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mLoop	Z
    //   330: aload_0
    //   331: iconst_0
    //   332: putfield 317	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAutoPlay	Z
    //   335: aload_0
    //   336: iconst_1
    //   337: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   340: aload_0
    //   341: aconst_null
    //   342: checkcast 252	android/media/MediaPlayer
    //   345: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   348: aload_0
    //   349: getfield 188	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPendingOperateTasks	Ljava/util/List;
    //   352: invokeinterface 238 1 0
    //   357: aload_1
    //   358: athrow
    //   359: astore_1
    //   360: aload_0
    //   361: monitorexit
    //   362: goto +5 -> 367
    //   365: aload_1
    //   366: athrow
    //   367: goto -2 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	InnerAudioPlayer
    //   20	108	1	localObject1	Object
    //   136	1	1	localObject2	Object
    //   140	76	1	localThrowable	Throwable
    //   283	75	1	localList	List
    //   359	7	1	localObject3	Object
    //   145	62	2	localLogDelegate	LogDelegate
    //   153	55	3	localLevel	LogDelegate.Level
    //   157	52	4	str	String
    //   166	45	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	21	136	finally
    //   25	28	136	finally
    //   28	32	136	finally
    //   32	37	136	finally
    //   41	44	136	finally
    //   44	53	136	finally
    //   57	60	136	finally
    //   60	64	136	finally
    //   141	146	136	finally
    //   150	221	136	finally
    //   2	21	140	java/lang/Throwable
    //   25	28	140	java/lang/Throwable
    //   28	32	140	java/lang/Throwable
    //   32	37	140	java/lang/Throwable
    //   41	44	140	java/lang/Throwable
    //   44	53	140	java/lang/Throwable
    //   57	60	140	java/lang/Throwable
    //   60	64	140	java/lang/Throwable
    //   64	127	359	finally
    //   127	133	359	finally
    //   221	284	359	finally
    //   290	359	359	finally
  }
  
  /* Error */
  public final void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 134	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:logger	Lcom/tencent/mobileqq/triton/utils/LogDelegate;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +54 -> 62
    //   11: getstatic 445	com/tencent/mobileqq/triton/utils/LogDelegate$Level:INFO	Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;
    //   14: astore_2
    //   15: getstatic 128	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:TAG	Ljava/lang/String;
    //   18: astore_3
    //   19: new 332	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: ldc_w 484
    //   33: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: aload_0
    //   40: invokevirtual 449	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getVolume	()F
    //   43: invokevirtual 452	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_1
    //   48: aload_2
    //   49: aload_3
    //   50: aload 4
    //   52: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: aconst_null
    //   56: bipush 8
    //   58: aconst_null
    //   59: invokestatic 412	com/tencent/mobileqq/triton/utils/LogDelegate$DefaultImpls:printLog$default	(Lcom/tencent/mobileqq/triton/utils/LogDelegate;Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   62: aload_0
    //   63: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   66: ifnull +46 -> 112
    //   69: aload_0
    //   70: invokevirtual 434	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:isPlaying	()Z
    //   73: ifeq +19 -> 92
    //   76: aload_0
    //   77: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnonnull +6 -> 88
    //   85: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   88: aload_1
    //   89: invokevirtual 473	android/media/MediaPlayer:stop	()V
    //   92: aload_0
    //   93: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   96: astore_1
    //   97: aload_1
    //   98: ifnonnull +6 -> 104
    //   101: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   104: aload_1
    //   105: invokevirtual 475	android/media/MediaPlayer:reset	()V
    //   108: aload_0
    //   109: invokespecial 386	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:stopTimeUpdateCallback	()V
    //   112: aload_0
    //   113: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +130 -> 248
    //   121: aload_0
    //   122: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   125: astore_1
    //   126: aload_1
    //   127: ifnonnull +6 -> 133
    //   130: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   133: aload_1
    //   134: aconst_null
    //   135: invokevirtual 256	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   138: aload_0
    //   139: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   142: astore_1
    //   143: aload_1
    //   144: ifnonnull +6 -> 150
    //   147: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   150: aload_1
    //   151: aconst_null
    //   152: invokevirtual 260	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   155: aload_0
    //   156: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   159: astore_1
    //   160: aload_1
    //   161: ifnonnull +6 -> 167
    //   164: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   167: aload_1
    //   168: aconst_null
    //   169: invokevirtual 264	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   172: aload_0
    //   173: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   176: astore_1
    //   177: aload_1
    //   178: ifnonnull +6 -> 184
    //   181: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   184: aload_1
    //   185: aconst_null
    //   186: invokevirtual 268	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   189: aload_0
    //   190: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   193: astore_1
    //   194: aload_1
    //   195: ifnonnull +6 -> 201
    //   198: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   201: aload_1
    //   202: aconst_null
    //   203: invokevirtual 272	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   206: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   209: bipush 28
    //   211: if_icmplt +19 -> 230
    //   214: aload_0
    //   215: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   218: astore_1
    //   219: aload_1
    //   220: ifnonnull +6 -> 226
    //   223: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   226: aload_1
    //   227: invokevirtual 487	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   230: invokestatic 247	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:getInstance	()Lcom/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager;
    //   233: aload_0
    //   234: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   237: invokevirtual 491	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:enqueuePlayer	(Landroid/media/MediaPlayer;)V
    //   240: aload_0
    //   241: aconst_null
    //   242: checkcast 252	android/media/MediaPlayer
    //   245: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   248: aload_0
    //   249: iconst_0
    //   250: putfield 202	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mIsPrepared	Z
    //   253: aload_0
    //   254: iconst_1
    //   255: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   258: aload_0
    //   259: iconst_0
    //   260: putfield 359	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mCacheDuration	I
    //   263: goto +237 -> 500
    //   266: astore_1
    //   267: goto +236 -> 503
    //   270: astore_1
    //   271: aload_0
    //   272: getfield 134	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:logger	Lcom/tencent/mobileqq/triton/utils/LogDelegate;
    //   275: astore_2
    //   276: aload_2
    //   277: ifnull +74 -> 351
    //   280: getstatic 330	com/tencent/mobileqq/triton/utils/LogDelegate$Level:ERROR	Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;
    //   283: astore_3
    //   284: getstatic 128	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:TAG	Ljava/lang/String;
    //   287: astore 4
    //   289: new 332	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   296: astore 5
    //   298: aload 5
    //   300: ldc_w 493
    //   303: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: aload_0
    //   310: invokevirtual 341	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getAudioId	()I
    //   313: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 5
    //   319: ldc_w 346
    //   322: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 5
    //   328: aload_0
    //   329: invokevirtual 348	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getAudioPath	()Ljava/lang/String;
    //   332: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_2
    //   337: aload_3
    //   338: aload 4
    //   340: aload 5
    //   342: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: aload_1
    //   346: invokeinterface 357 5 0
    //   351: aload_0
    //   352: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   355: astore_1
    //   356: aload_1
    //   357: ifnull +130 -> 487
    //   360: aload_0
    //   361: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   364: astore_1
    //   365: aload_1
    //   366: ifnonnull +6 -> 372
    //   369: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   372: aload_1
    //   373: aconst_null
    //   374: invokevirtual 256	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   377: aload_0
    //   378: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   381: astore_1
    //   382: aload_1
    //   383: ifnonnull +6 -> 389
    //   386: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   389: aload_1
    //   390: aconst_null
    //   391: invokevirtual 260	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   394: aload_0
    //   395: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   398: astore_1
    //   399: aload_1
    //   400: ifnonnull +6 -> 406
    //   403: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   406: aload_1
    //   407: aconst_null
    //   408: invokevirtual 264	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   411: aload_0
    //   412: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   415: astore_1
    //   416: aload_1
    //   417: ifnonnull +6 -> 423
    //   420: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   423: aload_1
    //   424: aconst_null
    //   425: invokevirtual 268	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   428: aload_0
    //   429: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   432: astore_1
    //   433: aload_1
    //   434: ifnonnull +6 -> 440
    //   437: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   440: aload_1
    //   441: aconst_null
    //   442: invokevirtual 272	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   445: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   448: bipush 28
    //   450: if_icmplt +19 -> 469
    //   453: aload_0
    //   454: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   457: astore_1
    //   458: aload_1
    //   459: ifnonnull +6 -> 465
    //   462: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   465: aload_1
    //   466: invokevirtual 487	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   469: invokestatic 247	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:getInstance	()Lcom/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager;
    //   472: aload_0
    //   473: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   476: invokevirtual 491	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:enqueuePlayer	(Landroid/media/MediaPlayer;)V
    //   479: aload_0
    //   480: aconst_null
    //   481: checkcast 252	android/media/MediaPlayer
    //   484: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   487: aload_0
    //   488: iconst_0
    //   489: putfield 202	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mIsPrepared	Z
    //   492: aload_0
    //   493: iconst_1
    //   494: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   497: goto -239 -> 258
    //   500: aload_0
    //   501: monitorexit
    //   502: return
    //   503: aload_0
    //   504: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   507: astore_2
    //   508: aload_2
    //   509: ifnull +130 -> 639
    //   512: aload_0
    //   513: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   516: astore_2
    //   517: aload_2
    //   518: ifnonnull +6 -> 524
    //   521: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   524: aload_2
    //   525: aconst_null
    //   526: invokevirtual 256	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   529: aload_0
    //   530: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   533: astore_2
    //   534: aload_2
    //   535: ifnonnull +6 -> 541
    //   538: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   541: aload_2
    //   542: aconst_null
    //   543: invokevirtual 260	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   546: aload_0
    //   547: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   550: astore_2
    //   551: aload_2
    //   552: ifnonnull +6 -> 558
    //   555: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   558: aload_2
    //   559: aconst_null
    //   560: invokevirtual 264	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   563: aload_0
    //   564: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   567: astore_2
    //   568: aload_2
    //   569: ifnonnull +6 -> 575
    //   572: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   575: aload_2
    //   576: aconst_null
    //   577: invokevirtual 268	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   580: aload_0
    //   581: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   584: astore_2
    //   585: aload_2
    //   586: ifnonnull +6 -> 592
    //   589: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   592: aload_2
    //   593: aconst_null
    //   594: invokevirtual 272	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   597: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   600: bipush 28
    //   602: if_icmplt +19 -> 621
    //   605: aload_0
    //   606: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   609: astore_2
    //   610: aload_2
    //   611: ifnonnull +6 -> 617
    //   614: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   617: aload_2
    //   618: invokevirtual 487	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   621: invokestatic 247	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:getInstance	()Lcom/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager;
    //   624: aload_0
    //   625: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   628: invokevirtual 491	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:enqueuePlayer	(Landroid/media/MediaPlayer;)V
    //   631: aload_0
    //   632: aconst_null
    //   633: checkcast 252	android/media/MediaPlayer
    //   636: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   639: aload_0
    //   640: iconst_0
    //   641: putfield 202	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mIsPrepared	Z
    //   644: aload_0
    //   645: iconst_1
    //   646: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   649: aload_0
    //   650: iconst_0
    //   651: putfield 359	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mCacheDuration	I
    //   654: aload_1
    //   655: athrow
    //   656: astore_1
    //   657: aload_0
    //   658: monitorexit
    //   659: goto +5 -> 664
    //   662: aload_1
    //   663: athrow
    //   664: goto -2 -> 662
    //   667: astore_1
    //   668: goto -420 -> 248
    //   671: astore_1
    //   672: goto -185 -> 487
    //   675: astore_2
    //   676: goto -37 -> 639
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	679	0	this	InnerAudioPlayer
    //   6	221	1	localObject1	Object
    //   266	1	1	localObject2	Object
    //   270	76	1	localThrowable1	Throwable
    //   355	300	1	localMediaPlayer	MediaPlayer
    //   656	7	1	localObject3	Object
    //   667	1	1	localThrowable2	Throwable
    //   671	1	1	localThrowable3	Throwable
    //   14	604	2	localObject4	Object
    //   675	1	2	localThrowable4	Throwable
    //   18	320	3	localObject5	Object
    //   26	313	4	localObject6	Object
    //   296	45	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	7	266	finally
    //   11	62	266	finally
    //   62	81	266	finally
    //   85	88	266	finally
    //   88	92	266	finally
    //   92	97	266	finally
    //   101	104	266	finally
    //   104	112	266	finally
    //   271	276	266	finally
    //   280	351	266	finally
    //   2	7	270	java/lang/Throwable
    //   11	62	270	java/lang/Throwable
    //   62	81	270	java/lang/Throwable
    //   85	88	270	java/lang/Throwable
    //   88	92	270	java/lang/Throwable
    //   92	97	270	java/lang/Throwable
    //   101	104	270	java/lang/Throwable
    //   104	112	270	java/lang/Throwable
    //   112	117	656	finally
    //   121	126	656	finally
    //   130	133	656	finally
    //   133	143	656	finally
    //   147	150	656	finally
    //   150	160	656	finally
    //   164	167	656	finally
    //   167	177	656	finally
    //   181	184	656	finally
    //   184	194	656	finally
    //   198	201	656	finally
    //   201	219	656	finally
    //   223	226	656	finally
    //   226	230	656	finally
    //   230	248	656	finally
    //   248	258	656	finally
    //   258	263	656	finally
    //   351	356	656	finally
    //   360	365	656	finally
    //   369	372	656	finally
    //   372	382	656	finally
    //   386	389	656	finally
    //   389	399	656	finally
    //   403	406	656	finally
    //   406	416	656	finally
    //   420	423	656	finally
    //   423	433	656	finally
    //   437	440	656	finally
    //   440	458	656	finally
    //   462	465	656	finally
    //   465	469	656	finally
    //   469	487	656	finally
    //   487	497	656	finally
    //   503	508	656	finally
    //   512	517	656	finally
    //   521	524	656	finally
    //   524	534	656	finally
    //   538	541	656	finally
    //   541	551	656	finally
    //   555	558	656	finally
    //   558	568	656	finally
    //   572	575	656	finally
    //   575	585	656	finally
    //   589	592	656	finally
    //   592	610	656	finally
    //   614	617	656	finally
    //   617	621	656	finally
    //   621	639	656	finally
    //   639	656	656	finally
    //   121	126	667	java/lang/Throwable
    //   130	133	667	java/lang/Throwable
    //   133	143	667	java/lang/Throwable
    //   147	150	667	java/lang/Throwable
    //   150	160	667	java/lang/Throwable
    //   164	167	667	java/lang/Throwable
    //   167	177	667	java/lang/Throwable
    //   181	184	667	java/lang/Throwable
    //   184	194	667	java/lang/Throwable
    //   198	201	667	java/lang/Throwable
    //   201	219	667	java/lang/Throwable
    //   223	226	667	java/lang/Throwable
    //   226	230	667	java/lang/Throwable
    //   230	248	667	java/lang/Throwable
    //   360	365	671	java/lang/Throwable
    //   369	372	671	java/lang/Throwable
    //   372	382	671	java/lang/Throwable
    //   386	389	671	java/lang/Throwable
    //   389	399	671	java/lang/Throwable
    //   403	406	671	java/lang/Throwable
    //   406	416	671	java/lang/Throwable
    //   420	423	671	java/lang/Throwable
    //   423	433	671	java/lang/Throwable
    //   437	440	671	java/lang/Throwable
    //   440	458	671	java/lang/Throwable
    //   462	465	671	java/lang/Throwable
    //   465	469	671	java/lang/Throwable
    //   469	487	671	java/lang/Throwable
    //   512	517	675	java/lang/Throwable
    //   521	524	675	java/lang/Throwable
    //   524	534	675	java/lang/Throwable
    //   538	541	675	java/lang/Throwable
    //   541	551	675	java/lang/Throwable
    //   555	558	675	java/lang/Throwable
    //   558	568	675	java/lang/Throwable
    //   572	575	675	java/lang/Throwable
    //   575	585	675	java/lang/Throwable
    //   589	592	675	java/lang/Throwable
    //   592	610	675	java/lang/Throwable
    //   614	617	675	java/lang/Throwable
    //   617	621	675	java/lang/Throwable
    //   621	639	675	java/lang/Throwable
  }
  
  public void resume()
  {
    if (this.mMediaPlayer == null) {
      return;
    }
    if (!isPrepared())
    {
      addOperateTask((Runnable)new InnerAudioPlayer.resume.1(this));
      return;
    }
    try
    {
      if (this.mMediaPlayer != null)
      {
        MediaPlayer localMediaPlayer = this.mMediaPlayer;
        if (localMediaPlayer == null) {
          Intrinsics.throwNpe();
        }
        localMediaPlayer.start();
        startTimeUpdateCallback();
      }
      this.mPaused = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null)
      {
        LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resume error. audioId=");
        localStringBuilder.append(getAudioId());
        localStringBuilder.append(" path=audioPath");
        localLogDelegate.printLog(localLevel, str, localStringBuilder.toString(), localThrowable);
      }
    }
  }
  
  public void seekTo(float paramFloat)
  {
    if (Float.isNaN(paramFloat)) {
      return;
    }
    if (!isPrepared())
    {
      addOperateTask((Runnable)new InnerAudioPlayer.seekTo.1(this, paramFloat));
      return;
    }
    try
    {
      MediaPlayer localMediaPlayer = this.mMediaPlayer;
      if (localMediaPlayer != null) {
        localMediaPlayer.seekTo((int)paramFloat);
      }
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null)
      {
        LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seekTo error. audioId=");
        localStringBuilder.append(getAudioId());
        localStringBuilder.append(" path=");
        localStringBuilder.append(getAudioPath());
        localLogDelegate.printLog(localLevel, str, localStringBuilder.toString(), localThrowable);
      }
    }
    IAudioStateChangeListener localIAudioStateChangeListener = getStateChangeListener();
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onSeeking();
    }
  }
  
  public void setAudioId(int paramInt)
  {
    this.mAudioId = paramInt;
  }
  
  public void setAudioPath(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((TextUtils.isEmpty(localCharSequence)) || ((Intrinsics.areEqual(paramString, getAudioPath()) ^ true)))
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null)
      {
        LogDelegate.Level localLevel = LogDelegate.Level.WARN;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAudioPath audioId=");
        localStringBuilder.append(getAudioId());
        localStringBuilder.append(", from ");
        localStringBuilder.append(getAudioPath());
        localStringBuilder.append(" to ");
        localStringBuilder.append(paramString);
        LogDelegate.DefaultImpls.printLog$default(localLogDelegate, localLevel, str, localStringBuilder.toString(), null, 8, null);
      }
      this.mAudioPath = paramString;
      reset();
    }
    if (TextUtils.isEmpty(localCharSequence)) {
      return;
    }
    paramString = getStateChangeListener();
    if (paramString != null) {
      paramString.onCanPlay();
    }
    if (getAutoPlay()) {
      play();
    }
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.mAutoPlay = paramBoolean;
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)getAudioPath()))) {
      play();
    }
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (!isPrepared())
    {
      addOperateTask((Runnable)new InnerAudioPlayer.setLoop.1(this, paramBoolean));
      return;
    }
    this.mLoop = paramBoolean;
    try
    {
      MediaPlayer localMediaPlayer = this.mMediaPlayer;
      if (localMediaPlayer != null)
      {
        localMediaPlayer.setLooping(paramBoolean);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null)
      {
        LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setLoop error. audioId=");
        localStringBuilder.append(getAudioId());
        localStringBuilder.append(" path=");
        localStringBuilder.append(getAudioPath());
        localLogDelegate.printLog(localLevel, str, localStringBuilder.toString(), localThrowable);
      }
    }
  }
  
  public void setNeedResume(boolean paramBoolean)
  {
    this.mNeedToResume = paramBoolean;
  }
  
  public void setStartTime(float paramFloat)
  {
    this.mStartTime = ((int)paramFloat);
  }
  
  public void setStateChangeListener(@Nullable IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    this.mAudioStateChangeListener = paramIAudioStateChangeListener;
  }
  
  public void setVolume(float paramFloat)
  {
    float f;
    if (paramFloat < 0)
    {
      f = 0.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat > 1) {
        f = 1.0F;
      }
    }
    if (!isPrepared())
    {
      addOperateTask((Runnable)new InnerAudioPlayer.setVolume.1(this, f));
      return;
    }
    this.mVolume = f;
    try
    {
      MediaPlayer localMediaPlayer = this.mMediaPlayer;
      if (localMediaPlayer != null)
      {
        localMediaPlayer.setVolume(f, f);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null)
      {
        LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVolume error. audioId=");
        localStringBuilder.append(getAudioId());
        localStringBuilder.append(" path=");
        localStringBuilder.append(getAudioPath());
        localLogDelegate.printLog(localLevel, str, localStringBuilder.toString(), localThrowable);
      }
    }
  }
  
  public void stop()
  {
    if (this.mMediaPlayer == null) {
      return;
    }
    try
    {
      if (isPrepared())
      {
        if (isPlaying())
        {
          localMediaPlayer = this.mMediaPlayer;
          if (localMediaPlayer == null) {
            Intrinsics.throwNpe();
          }
          localMediaPlayer.pause();
        }
        if (getStartTime() > 0) {
          setStartTime(0.0F);
        }
        MediaPlayer localMediaPlayer = this.mMediaPlayer;
        if (localMediaPlayer == null) {
          Intrinsics.throwNpe();
        }
        localMediaPlayer.seekTo(this.mStartTime);
        stopTimeUpdateCallback();
      }
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null)
      {
        LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop error. audioId=");
        localStringBuilder.append(getAudioId());
        localStringBuilder.append(" path=");
        localStringBuilder.append(getAudioPath());
        localLogDelegate.printLog(localLevel, str, localStringBuilder.toString(), localThrowable);
      }
    }
    IAudioStateChangeListener localIAudioStateChangeListener = getStateChangeListener();
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer
 * JD-Core Version:    0.7.0.1
 */