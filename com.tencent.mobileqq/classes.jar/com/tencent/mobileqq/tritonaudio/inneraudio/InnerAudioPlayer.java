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
    //   29: invokevirtual 465	android/media/MediaPlayer:stop	()V
    //   32: aload_0
    //   33: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +6 -> 44
    //   41: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   44: aload_1
    //   45: invokevirtual 467	android/media/MediaPlayer:reset	()V
    //   48: aload_0
    //   49: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnonnull +6 -> 60
    //   57: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   60: aload_1
    //   61: invokevirtual 469	android/media/MediaPlayer:release	()V
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 312	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioId	I
    //   69: aload_0
    //   70: aconst_null
    //   71: checkcast 471	java/lang/String
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
    //   93: ldc_w 472
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
    //   170: ldc_w 474
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
    //   228: checkcast 471	java/lang/String
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
    //   250: ldc_w 472
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
    //   297: checkcast 471	java/lang/String
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
    //   319: ldc_w 472
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
    //   3: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +46 -> 52
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
    //   29: invokevirtual 465	android/media/MediaPlayer:stop	()V
    //   32: aload_0
    //   33: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +6 -> 44
    //   41: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   44: aload_1
    //   45: invokevirtual 467	android/media/MediaPlayer:reset	()V
    //   48: aload_0
    //   49: invokespecial 386	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:stopTimeUpdateCallback	()V
    //   52: aload_0
    //   53: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +130 -> 188
    //   61: aload_0
    //   62: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnonnull +6 -> 73
    //   70: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   73: aload_1
    //   74: aconst_null
    //   75: invokevirtual 256	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   78: aload_0
    //   79: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnonnull +6 -> 90
    //   87: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   90: aload_1
    //   91: aconst_null
    //   92: invokevirtual 260	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   95: aload_0
    //   96: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnonnull +6 -> 107
    //   104: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   107: aload_1
    //   108: aconst_null
    //   109: invokevirtual 264	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   112: aload_0
    //   113: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   116: astore_1
    //   117: aload_1
    //   118: ifnonnull +6 -> 124
    //   121: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   124: aload_1
    //   125: aconst_null
    //   126: invokevirtual 268	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   129: aload_0
    //   130: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   133: astore_1
    //   134: aload_1
    //   135: ifnonnull +6 -> 141
    //   138: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   141: aload_1
    //   142: aconst_null
    //   143: invokevirtual 272	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   146: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   149: bipush 28
    //   151: if_icmplt +19 -> 170
    //   154: aload_0
    //   155: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   158: astore_1
    //   159: aload_1
    //   160: ifnonnull +6 -> 166
    //   163: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   166: aload_1
    //   167: invokevirtual 477	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   170: invokestatic 247	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:getInstance	()Lcom/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager;
    //   173: aload_0
    //   174: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   177: invokevirtual 481	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:enqueuePlayer	(Landroid/media/MediaPlayer;)V
    //   180: aload_0
    //   181: aconst_null
    //   182: checkcast 252	android/media/MediaPlayer
    //   185: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   188: aload_0
    //   189: iconst_0
    //   190: putfield 202	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mIsPrepared	Z
    //   193: aload_0
    //   194: iconst_1
    //   195: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   198: aload_0
    //   199: iconst_0
    //   200: putfield 359	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mCacheDuration	I
    //   203: goto +237 -> 440
    //   206: astore_1
    //   207: goto +236 -> 443
    //   210: astore_1
    //   211: aload_0
    //   212: getfield 134	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:logger	Lcom/tencent/mobileqq/triton/utils/LogDelegate;
    //   215: astore_2
    //   216: aload_2
    //   217: ifnull +74 -> 291
    //   220: getstatic 330	com/tencent/mobileqq/triton/utils/LogDelegate$Level:ERROR	Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;
    //   223: astore_3
    //   224: getstatic 128	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:TAG	Ljava/lang/String;
    //   227: astore 4
    //   229: new 332	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   236: astore 5
    //   238: aload 5
    //   240: ldc_w 483
    //   243: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 5
    //   249: aload_0
    //   250: invokevirtual 341	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getAudioId	()I
    //   253: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 5
    //   259: ldc_w 346
    //   262: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 5
    //   268: aload_0
    //   269: invokevirtual 348	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getAudioPath	()Ljava/lang/String;
    //   272: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: aload_3
    //   278: aload 4
    //   280: aload 5
    //   282: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: aload_1
    //   286: invokeinterface 357 5 0
    //   291: aload_0
    //   292: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   295: astore_1
    //   296: aload_1
    //   297: ifnull +130 -> 427
    //   300: aload_0
    //   301: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   304: astore_1
    //   305: aload_1
    //   306: ifnonnull +6 -> 312
    //   309: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   312: aload_1
    //   313: aconst_null
    //   314: invokevirtual 256	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   317: aload_0
    //   318: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   321: astore_1
    //   322: aload_1
    //   323: ifnonnull +6 -> 329
    //   326: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   329: aload_1
    //   330: aconst_null
    //   331: invokevirtual 260	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   334: aload_0
    //   335: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   338: astore_1
    //   339: aload_1
    //   340: ifnonnull +6 -> 346
    //   343: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   346: aload_1
    //   347: aconst_null
    //   348: invokevirtual 264	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   351: aload_0
    //   352: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   355: astore_1
    //   356: aload_1
    //   357: ifnonnull +6 -> 363
    //   360: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   363: aload_1
    //   364: aconst_null
    //   365: invokevirtual 268	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   368: aload_0
    //   369: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   372: astore_1
    //   373: aload_1
    //   374: ifnonnull +6 -> 380
    //   377: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   380: aload_1
    //   381: aconst_null
    //   382: invokevirtual 272	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   385: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   388: bipush 28
    //   390: if_icmplt +19 -> 409
    //   393: aload_0
    //   394: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   397: astore_1
    //   398: aload_1
    //   399: ifnonnull +6 -> 405
    //   402: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   405: aload_1
    //   406: invokevirtual 477	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   409: invokestatic 247	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:getInstance	()Lcom/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager;
    //   412: aload_0
    //   413: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   416: invokevirtual 481	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:enqueuePlayer	(Landroid/media/MediaPlayer;)V
    //   419: aload_0
    //   420: aconst_null
    //   421: checkcast 252	android/media/MediaPlayer
    //   424: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   427: aload_0
    //   428: iconst_0
    //   429: putfield 202	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mIsPrepared	Z
    //   432: aload_0
    //   433: iconst_1
    //   434: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   437: goto -239 -> 198
    //   440: aload_0
    //   441: monitorexit
    //   442: return
    //   443: aload_0
    //   444: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   447: astore_2
    //   448: aload_2
    //   449: ifnull +130 -> 579
    //   452: aload_0
    //   453: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   456: astore_2
    //   457: aload_2
    //   458: ifnonnull +6 -> 464
    //   461: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   464: aload_2
    //   465: aconst_null
    //   466: invokevirtual 256	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   469: aload_0
    //   470: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   473: astore_2
    //   474: aload_2
    //   475: ifnonnull +6 -> 481
    //   478: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   481: aload_2
    //   482: aconst_null
    //   483: invokevirtual 260	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   486: aload_0
    //   487: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   490: astore_2
    //   491: aload_2
    //   492: ifnonnull +6 -> 498
    //   495: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   498: aload_2
    //   499: aconst_null
    //   500: invokevirtual 264	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   503: aload_0
    //   504: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   507: astore_2
    //   508: aload_2
    //   509: ifnonnull +6 -> 515
    //   512: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   515: aload_2
    //   516: aconst_null
    //   517: invokevirtual 268	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   520: aload_0
    //   521: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   524: astore_2
    //   525: aload_2
    //   526: ifnonnull +6 -> 532
    //   529: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   532: aload_2
    //   533: aconst_null
    //   534: invokevirtual 272	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   537: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   540: bipush 28
    //   542: if_icmplt +19 -> 561
    //   545: aload_0
    //   546: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   549: astore_2
    //   550: aload_2
    //   551: ifnonnull +6 -> 557
    //   554: invokestatic 298	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   557: aload_2
    //   558: invokevirtual 477	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   561: invokestatic 247	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:getInstance	()Lcom/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager;
    //   564: aload_0
    //   565: getfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   568: invokevirtual 481	com/tencent/mobileqq/tritonaudio/inneraudio/MediaPlayerManager:enqueuePlayer	(Landroid/media/MediaPlayer;)V
    //   571: aload_0
    //   572: aconst_null
    //   573: checkcast 252	android/media/MediaPlayer
    //   576: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   579: aload_0
    //   580: iconst_0
    //   581: putfield 202	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mIsPrepared	Z
    //   584: aload_0
    //   585: iconst_1
    //   586: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   589: aload_0
    //   590: iconst_0
    //   591: putfield 359	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mCacheDuration	I
    //   594: aload_1
    //   595: athrow
    //   596: astore_1
    //   597: aload_0
    //   598: monitorexit
    //   599: goto +5 -> 604
    //   602: aload_1
    //   603: athrow
    //   604: goto -2 -> 602
    //   607: astore_1
    //   608: goto -420 -> 188
    //   611: astore_1
    //   612: goto -185 -> 427
    //   615: astore_2
    //   616: goto -37 -> 579
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	InnerAudioPlayer
    //   20	147	1	localMediaPlayer1	MediaPlayer
    //   206	1	1	localObject1	Object
    //   210	76	1	localThrowable1	Throwable
    //   295	300	1	localMediaPlayer2	MediaPlayer
    //   596	7	1	localObject2	Object
    //   607	1	1	localThrowable2	Throwable
    //   611	1	1	localThrowable3	Throwable
    //   215	343	2	localObject3	Object
    //   615	1	2	localThrowable4	Throwable
    //   223	55	3	localLevel	LogDelegate.Level
    //   227	52	4	str	String
    //   236	45	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	21	206	finally
    //   25	28	206	finally
    //   28	32	206	finally
    //   32	37	206	finally
    //   41	44	206	finally
    //   44	52	206	finally
    //   211	216	206	finally
    //   220	291	206	finally
    //   2	21	210	java/lang/Throwable
    //   25	28	210	java/lang/Throwable
    //   28	32	210	java/lang/Throwable
    //   32	37	210	java/lang/Throwable
    //   41	44	210	java/lang/Throwable
    //   44	52	210	java/lang/Throwable
    //   52	57	596	finally
    //   61	66	596	finally
    //   70	73	596	finally
    //   73	83	596	finally
    //   87	90	596	finally
    //   90	100	596	finally
    //   104	107	596	finally
    //   107	117	596	finally
    //   121	124	596	finally
    //   124	134	596	finally
    //   138	141	596	finally
    //   141	159	596	finally
    //   163	166	596	finally
    //   166	170	596	finally
    //   170	188	596	finally
    //   188	198	596	finally
    //   198	203	596	finally
    //   291	296	596	finally
    //   300	305	596	finally
    //   309	312	596	finally
    //   312	322	596	finally
    //   326	329	596	finally
    //   329	339	596	finally
    //   343	346	596	finally
    //   346	356	596	finally
    //   360	363	596	finally
    //   363	373	596	finally
    //   377	380	596	finally
    //   380	398	596	finally
    //   402	405	596	finally
    //   405	409	596	finally
    //   409	427	596	finally
    //   427	437	596	finally
    //   443	448	596	finally
    //   452	457	596	finally
    //   461	464	596	finally
    //   464	474	596	finally
    //   478	481	596	finally
    //   481	491	596	finally
    //   495	498	596	finally
    //   498	508	596	finally
    //   512	515	596	finally
    //   515	525	596	finally
    //   529	532	596	finally
    //   532	550	596	finally
    //   554	557	596	finally
    //   557	561	596	finally
    //   561	579	596	finally
    //   579	596	596	finally
    //   61	66	607	java/lang/Throwable
    //   70	73	607	java/lang/Throwable
    //   73	83	607	java/lang/Throwable
    //   87	90	607	java/lang/Throwable
    //   90	100	607	java/lang/Throwable
    //   104	107	607	java/lang/Throwable
    //   107	117	607	java/lang/Throwable
    //   121	124	607	java/lang/Throwable
    //   124	134	607	java/lang/Throwable
    //   138	141	607	java/lang/Throwable
    //   141	159	607	java/lang/Throwable
    //   163	166	607	java/lang/Throwable
    //   166	170	607	java/lang/Throwable
    //   170	188	607	java/lang/Throwable
    //   300	305	611	java/lang/Throwable
    //   309	312	611	java/lang/Throwable
    //   312	322	611	java/lang/Throwable
    //   326	329	611	java/lang/Throwable
    //   329	339	611	java/lang/Throwable
    //   343	346	611	java/lang/Throwable
    //   346	356	611	java/lang/Throwable
    //   360	363	611	java/lang/Throwable
    //   363	373	611	java/lang/Throwable
    //   377	380	611	java/lang/Throwable
    //   380	398	611	java/lang/Throwable
    //   402	405	611	java/lang/Throwable
    //   405	409	611	java/lang/Throwable
    //   409	427	611	java/lang/Throwable
    //   452	457	615	java/lang/Throwable
    //   461	464	615	java/lang/Throwable
    //   464	474	615	java/lang/Throwable
    //   478	481	615	java/lang/Throwable
    //   481	491	615	java/lang/Throwable
    //   495	498	615	java/lang/Throwable
    //   498	508	615	java/lang/Throwable
    //   512	515	615	java/lang/Throwable
    //   515	525	615	java/lang/Throwable
    //   529	532	615	java/lang/Throwable
    //   532	550	615	java/lang/Throwable
    //   554	557	615	java/lang/Throwable
    //   557	561	615	java/lang/Throwable
    //   561	579	615	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer
 * JD-Core Version:    0.7.0.1
 */