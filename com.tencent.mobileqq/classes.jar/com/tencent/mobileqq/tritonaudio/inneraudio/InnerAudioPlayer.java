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
    if (this.mTimeUpdateTimer != null)
    {
      Timer localTimer = this.mTimeUpdateTimer;
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
    int j = 0;
    int i = j;
    if (isPrepared()) {}
    try
    {
      MediaPlayer localMediaPlayer = this.mMediaPlayer;
      i = j;
      if (localMediaPlayer != null) {
        i = localMediaPlayer.getCurrentPosition();
      }
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate;
      do
      {
        localLogDelegate = this.logger;
        i = j;
      } while (localLogDelegate == null);
      localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "getCurrentPosition error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable);
    }
    return i;
    return 0;
  }
  
  public int getDuration()
  {
    if (this.mCacheDuration > 0) {
      return this.mCacheDuration;
    }
    if (isPrepared()) {}
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
      for (;;)
      {
        LogDelegate localLogDelegate = this.logger;
        if (localLogDelegate != null) {
          localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "getDuration error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable);
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
    boolean bool3 = false;
    boolean bool2 = bool3;
    MediaPlayer localMediaPlayer;
    if (isPrepared())
    {
      localMediaPlayer = this.mMediaPlayer;
      if (localMediaPlayer == null) {
        break label38;
      }
    }
    label38:
    for (boolean bool1 = localMediaPlayer.isPlaying();; bool1 = false)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public void pause()
  {
    if (this.mMediaPlayer == null) {}
    do
    {
      return;
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
          localObject = this.mMediaPlayer;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject).pause();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject;
          LogDelegate localLogDelegate = this.logger;
          if (localLogDelegate != null) {
            localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "pause error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable);
          }
        }
      }
      stopTimeUpdateCallback();
      localObject = getStateChangeListener();
    } while (localObject == null);
    ((IAudioStateChangeListener)localObject).onPause();
  }
  
  public void play()
  {
    Object localObject1;
    if (TextUtils.isEmpty((CharSequence)getAudioPath()))
    {
      localObject1 = this.logger;
      if (localObject1 != null) {
        LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject1, LogDelegate.Level.WARN, TAG, "play error on empty audio path, audioId=" + getAudioId() + " path=" + getAudioPath(), null, 8, null);
      }
    }
    Object localObject2;
    label293:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (this.mMediaPlayer == null)
            {
              this.mMediaPlayer = preparePlayer();
              if (this.mMediaPlayer == null) {}
            }
            try
            {
              localObject1 = this.mMediaPlayer;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              ((MediaPlayer)localObject1).setDataSource(getAudioPath());
              localObject1 = this.mMediaPlayer;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              ((MediaPlayer)localObject1).prepareAsync();
              boolean bool = getAutoPlay();
              if (bool) {}
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                localLogDelegate = this.logger;
                if (localLogDelegate != null) {
                  localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "play error on setDataSource and prepareAsync." + " audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable1);
                }
                localObject2 = getStateChangeListener();
                if (localObject2 != null) {
                  ((IAudioStateChangeListener)localObject2).onError(10003);
                }
              }
            }
          }
          if (this.mMediaPlayer != null) {
            break label293;
          }
          localObject1 = this.logger;
        } while (localObject1 == null);
        LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject1, LogDelegate.Level.WARN, TAG, "play error on null mMediaPlayer, audioId=" + getAudioId() + " path=" + getAudioPath(), null, 8, null);
        return;
      } while (isPlaying());
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
          if (getVolume() >= 0)
          {
            localObject2 = this.mMediaPlayer;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            ((MediaPlayer)localObject2).setVolume(getVolume(), getVolume());
          }
          if ((!isPaused()) && (getStartTime() > 0))
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
        for (;;)
        {
          localLogDelegate = this.logger;
          if (localLogDelegate != null) {
            localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "play error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable2);
          }
        }
      }
      localObject2 = getStateChangeListener();
    } while (localObject2 == null);
    ((IAudioStateChangeListener)localObject2).onPlay();
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
    //   126: invokeinterface 238 1 0
    //   131: aload_0
    //   132: monitorexit
    //   133: return
    //   134: astore_1
    //   135: aload_0
    //   136: getfield 134	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:logger	Lcom/tencent/mobileqq/triton/utils/LogDelegate;
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +52 -> 193
    //   144: aload_2
    //   145: getstatic 330	com/tencent/mobileqq/triton/utils/LogDelegate$Level:ERROR	Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;
    //   148: getstatic 128	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:TAG	Ljava/lang/String;
    //   151: new 332	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 474
    //   161: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: invokevirtual 341	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getAudioId	()I
    //   168: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc_w 346
    //   174: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 348	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:getAudioPath	()Ljava/lang/String;
    //   181: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aload_1
    //   188: invokeinterface 357 5 0
    //   193: aload_0
    //   194: iconst_0
    //   195: putfield 312	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioId	I
    //   198: aload_0
    //   199: aconst_null
    //   200: checkcast 471	java/lang/String
    //   203: putfield 314	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioPath	Ljava/lang/String;
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 373	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mNeedToResume	Z
    //   211: aload_0
    //   212: dconst_0
    //   213: putfield 198	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mBufferedTime	D
    //   216: aload_0
    //   217: iconst_0
    //   218: putfield 368	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mStartTime	I
    //   221: aload_0
    //   222: ldc_w 472
    //   225: putfield 138	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mVolume	F
    //   228: aload_0
    //   229: iconst_0
    //   230: putfield 365	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mLoop	Z
    //   233: aload_0
    //   234: iconst_0
    //   235: putfield 317	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAutoPlay	Z
    //   238: aload_0
    //   239: iconst_1
    //   240: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   243: aload_0
    //   244: aconst_null
    //   245: checkcast 252	android/media/MediaPlayer
    //   248: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   251: aload_0
    //   252: getfield 188	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPendingOperateTasks	Ljava/util/List;
    //   255: invokeinterface 238 1 0
    //   260: goto -129 -> 131
    //   263: astore_1
    //   264: aload_0
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    //   268: astore_1
    //   269: aload_0
    //   270: iconst_0
    //   271: putfield 312	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioId	I
    //   274: aload_0
    //   275: aconst_null
    //   276: checkcast 471	java/lang/String
    //   279: putfield 314	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAudioPath	Ljava/lang/String;
    //   282: aload_0
    //   283: iconst_0
    //   284: putfield 373	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mNeedToResume	Z
    //   287: aload_0
    //   288: dconst_0
    //   289: putfield 198	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mBufferedTime	D
    //   292: aload_0
    //   293: iconst_0
    //   294: putfield 368	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mStartTime	I
    //   297: aload_0
    //   298: ldc_w 472
    //   301: putfield 138	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mVolume	F
    //   304: aload_0
    //   305: iconst_0
    //   306: putfield 365	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mLoop	Z
    //   309: aload_0
    //   310: iconst_0
    //   311: putfield 317	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mAutoPlay	Z
    //   314: aload_0
    //   315: iconst_1
    //   316: putfield 136	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPaused	Z
    //   319: aload_0
    //   320: aconst_null
    //   321: checkcast 252	android/media/MediaPlayer
    //   324: putfield 240	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   327: aload_0
    //   328: getfield 188	com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer:mPendingOperateTasks	Ljava/util/List;
    //   331: invokeinterface 238 1 0
    //   336: aload_1
    //   337: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	InnerAudioPlayer
    //   20	41	1	localMediaPlayer	MediaPlayer
    //   134	54	1	localThrowable	Throwable
    //   263	4	1	localObject1	Object
    //   268	69	1	localObject2	Object
    //   139	6	2	localLogDelegate	LogDelegate
    // Exception table:
    //   from	to	target	type
    //   2	21	134	java/lang/Throwable
    //   25	28	134	java/lang/Throwable
    //   28	32	134	java/lang/Throwable
    //   32	37	134	java/lang/Throwable
    //   41	44	134	java/lang/Throwable
    //   44	53	134	java/lang/Throwable
    //   57	60	134	java/lang/Throwable
    //   60	64	134	java/lang/Throwable
    //   64	131	263	finally
    //   193	260	263	finally
    //   269	338	263	finally
    //   2	21	268	finally
    //   25	28	268	finally
    //   28	32	268	finally
    //   32	37	268	finally
    //   41	44	268	finally
    //   44	53	268	finally
    //   57	60	268	finally
    //   60	64	268	finally
    //   135	140	268	finally
    //   144	193	268	finally
  }
  
  public final void reset()
  {
    for (;;)
    {
      try
      {
        if (this.mMediaPlayer != null)
        {
          if (isPlaying())
          {
            localMediaPlayer1 = this.mMediaPlayer;
            if (localMediaPlayer1 == null) {
              Intrinsics.throwNpe();
            }
            localMediaPlayer1.stop();
          }
          localMediaPlayer1 = this.mMediaPlayer;
          if (localMediaPlayer1 == null) {
            Intrinsics.throwNpe();
          }
          localMediaPlayer1.reset();
          stopTimeUpdateCallback();
        }
      }
      catch (Throwable localThrowable1)
      {
        MediaPlayer localMediaPlayer1;
        label188:
        localObject3 = this.logger;
        if (localObject3 != null) {
          ((LogDelegate)localObject3).printLog(LogDelegate.Level.ERROR, TAG, "reset error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable1);
        }
        MediaPlayer localMediaPlayer2 = this.mMediaPlayer;
        if (localMediaPlayer2 != null) {}
        try
        {
          localMediaPlayer2 = this.mMediaPlayer;
          if (localMediaPlayer2 == null) {
            Intrinsics.throwNpe();
          }
          localMediaPlayer2.setOnErrorListener(null);
          localMediaPlayer2 = this.mMediaPlayer;
          if (localMediaPlayer2 == null) {
            Intrinsics.throwNpe();
          }
          localMediaPlayer2.setOnCompletionListener(null);
          localMediaPlayer2 = this.mMediaPlayer;
          if (localMediaPlayer2 == null) {
            Intrinsics.throwNpe();
          }
          localMediaPlayer2.setOnPreparedListener(null);
          localMediaPlayer2 = this.mMediaPlayer;
          if (localMediaPlayer2 == null) {
            Intrinsics.throwNpe();
          }
          localMediaPlayer2.setOnBufferingUpdateListener(null);
          localMediaPlayer2 = this.mMediaPlayer;
          if (localMediaPlayer2 == null) {
            Intrinsics.throwNpe();
          }
          localMediaPlayer2.setOnSeekCompleteListener(null);
          if (Build.VERSION.SDK_INT >= 28)
          {
            localMediaPlayer2 = this.mMediaPlayer;
            if (localMediaPlayer2 == null) {
              Intrinsics.throwNpe();
            }
            localMediaPlayer2.clearOnMediaTimeDiscontinuityListener();
          }
          MediaPlayerManager.getInstance().enqueuePlayer(this.mMediaPlayer);
          this.mMediaPlayer = ((MediaPlayer)null);
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        this.mIsPrepared = false;
        this.mPaused = true;
        this.mCacheDuration = 0;
        continue;
      }
      finally
      {
        Object localObject3 = this.mMediaPlayer;
        if (localObject3 == null) {
          continue;
        }
        try
        {
          localObject3 = this.mMediaPlayer;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject3).setOnErrorListener(null);
          localObject3 = this.mMediaPlayer;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject3).setOnCompletionListener(null);
          localObject3 = this.mMediaPlayer;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject3).setOnPreparedListener(null);
          localObject3 = this.mMediaPlayer;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject3).setOnBufferingUpdateListener(null);
          localObject3 = this.mMediaPlayer;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject3).setOnSeekCompleteListener(null);
          if (Build.VERSION.SDK_INT >= 28)
          {
            localObject3 = this.mMediaPlayer;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            ((MediaPlayer)localObject3).clearOnMediaTimeDiscontinuityListener();
          }
          MediaPlayerManager.getInstance().enqueuePlayer(this.mMediaPlayer);
          this.mMediaPlayer = ((MediaPlayer)null);
        }
        catch (Throwable localThrowable4)
        {
          continue;
        }
        this.mIsPrepared = false;
        this.mPaused = true;
        this.mCacheDuration = 0;
      }
      try
      {
        localMediaPlayer1 = this.mMediaPlayer;
        if (localMediaPlayer1 == null) {}
      }
      finally {}
    }
    try
    {
      localMediaPlayer1 = this.mMediaPlayer;
      if (localMediaPlayer1 == null) {
        Intrinsics.throwNpe();
      }
      localMediaPlayer1.setOnErrorListener(null);
      localMediaPlayer1 = this.mMediaPlayer;
      if (localMediaPlayer1 == null) {
        Intrinsics.throwNpe();
      }
      localMediaPlayer1.setOnCompletionListener(null);
      localMediaPlayer1 = this.mMediaPlayer;
      if (localMediaPlayer1 == null) {
        Intrinsics.throwNpe();
      }
      localMediaPlayer1.setOnPreparedListener(null);
      localMediaPlayer1 = this.mMediaPlayer;
      if (localMediaPlayer1 == null) {
        Intrinsics.throwNpe();
      }
      localMediaPlayer1.setOnBufferingUpdateListener(null);
      localMediaPlayer1 = this.mMediaPlayer;
      if (localMediaPlayer1 == null) {
        Intrinsics.throwNpe();
      }
      localMediaPlayer1.setOnSeekCompleteListener(null);
      if (Build.VERSION.SDK_INT >= 28)
      {
        localMediaPlayer1 = this.mMediaPlayer;
        if (localMediaPlayer1 == null) {
          Intrinsics.throwNpe();
        }
        localMediaPlayer1.clearOnMediaTimeDiscontinuityListener();
      }
      MediaPlayerManager.getInstance().enqueuePlayer(this.mMediaPlayer);
      this.mMediaPlayer = ((MediaPlayer)null);
    }
    catch (Throwable localThrowable3)
    {
      break label188;
    }
    this.mIsPrepared = false;
    this.mPaused = true;
    this.mCacheDuration = 0;
  }
  
  public void resume()
  {
    if (this.mMediaPlayer == null) {}
    LogDelegate localLogDelegate;
    do
    {
      return;
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
        localLogDelegate = this.logger;
      }
    } while (localLogDelegate == null);
    localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "resume error. audioId=" + getAudioId() + " path=audioPath", localThrowable);
  }
  
  public void seekTo(float paramFloat)
  {
    if (Float.isNaN(paramFloat)) {}
    do
    {
      return;
      if (!isPrepared())
      {
        addOperateTask((Runnable)new InnerAudioPlayer.seekTo.1(this, paramFloat));
        return;
      }
      try
      {
        localObject = this.mMediaPlayer;
        if (localObject != null) {
          ((MediaPlayer)localObject).seekTo((int)paramFloat);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject;
          LogDelegate localLogDelegate = this.logger;
          if (localLogDelegate != null) {
            localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "seekTo error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable);
          }
        }
      }
      localObject = getStateChangeListener();
    } while (localObject == null);
    ((IAudioStateChangeListener)localObject).onSeeking();
  }
  
  public void setAudioId(int paramInt)
  {
    this.mAudioId = paramInt;
  }
  
  public void setAudioPath(@Nullable String paramString)
  {
    if ((TextUtils.isEmpty((CharSequence)paramString)) || ((Intrinsics.areEqual(paramString, getAudioPath()) ^ true)))
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null) {
        LogDelegate.DefaultImpls.printLog$default(localLogDelegate, LogDelegate.Level.WARN, TAG, "setAudioPath audioId=" + getAudioId() + ", from " + getAudioPath() + " to " + paramString, null, 8, null);
      }
      this.mAudioPath = paramString;
      reset();
    }
    if (TextUtils.isEmpty((CharSequence)paramString)) {}
    do
    {
      return;
      paramString = getStateChangeListener();
      if (paramString != null) {
        paramString.onCanPlay();
      }
    } while (!getAutoPlay());
    play();
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
    if (!isPrepared()) {
      addOperateTask((Runnable)new InnerAudioPlayer.setLoop.1(this, paramBoolean));
    }
    LogDelegate localLogDelegate;
    do
    {
      for (;;)
      {
        return;
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
          localLogDelegate = this.logger;
        }
      }
    } while (localLogDelegate == null);
    localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "setLoop error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable);
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
      if (isPrepared()) {
        break label47;
      }
      addOperateTask((Runnable)new InnerAudioPlayer.setVolume.1(this, f));
    }
    label47:
    LogDelegate localLogDelegate;
    do
    {
      for (;;)
      {
        return;
        f = paramFloat;
        if (paramFloat <= 1) {
          break;
        }
        f = 1.0F;
        break;
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
          localLogDelegate = this.logger;
        }
      }
    } while (localLogDelegate == null);
    localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "setVolume error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable);
  }
  
  public void stop()
  {
    if (this.mMediaPlayer == null) {}
    do
    {
      return;
      try
      {
        if (isPrepared())
        {
          if (isPlaying())
          {
            localObject = this.mMediaPlayer;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            ((MediaPlayer)localObject).pause();
          }
          if (getStartTime() > 0) {
            setStartTime(0.0F);
          }
          localObject = this.mMediaPlayer;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((MediaPlayer)localObject).seekTo(this.mStartTime);
          stopTimeUpdateCallback();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject;
          LogDelegate localLogDelegate = this.logger;
          if (localLogDelegate != null) {
            localLogDelegate.printLog(LogDelegate.Level.ERROR, TAG, "stop error. audioId=" + getAudioId() + " path=" + getAudioPath(), localThrowable);
          }
        }
      }
      localObject = getStateChangeListener();
    } while (localObject == null);
    ((IAudioStateChangeListener)localObject).onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer
 * JD-Core Version:    0.7.0.1
 */