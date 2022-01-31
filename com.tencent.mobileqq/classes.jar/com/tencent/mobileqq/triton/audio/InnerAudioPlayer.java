package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayer;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

public class InnerAudioPlayer
  implements IAudioPlayer
{
  private static final String TAG = "[audio] InnerAudioPlayer";
  private final int TIME_UPDATE_FIXED_PERIOD = 250;
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
  private volatile boolean mPaused = true;
  private List<Runnable> mPendingOperateTasks = Collections.synchronizedList(new ArrayList());
  private int mStartTime;
  private Timer mTimeUpdateTimer;
  private float mVolume = 1.0F;
  MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = new InnerAudioPlayer.12(this);
  MediaPlayer.OnCompletionListener onCompletionListener = new InnerAudioPlayer.10(this);
  MediaPlayer.OnErrorListener onErrorListener = new InnerAudioPlayer.9(this);
  MediaPlayer.OnPreparedListener onPreparedListener = new InnerAudioPlayer.11(this);
  MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = new InnerAudioPlayer.13(this);
  
  private void addOperateTask(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.mPendingOperateTasks.add(paramRunnable);
    }
  }
  
  private void execOperateTasks()
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
  
  private MediaPlayer preparePlayer()
  {
    MediaPlayer localMediaPlayer = MediaPlayerManager.getInstance().dequeuePlayer();
    if (localMediaPlayer != null)
    {
      localMediaPlayer.setOnErrorListener(this.onErrorListener);
      localMediaPlayer.setOnCompletionListener(this.onCompletionListener);
      localMediaPlayer.setOnPreparedListener(this.onPreparedListener);
      localMediaPlayer.setOnBufferingUpdateListener(this.onBufferingUpdateListener);
      localMediaPlayer.setOnSeekCompleteListener(this.onSeekCompleteListener);
      if (Build.VERSION.SDK_INT >= 28) {
        localMediaPlayer.setOnMediaTimeDiscontinuityListener(new InnerAudioPlayer.1(this));
      }
    }
    return localMediaPlayer;
  }
  
  private void startTimeUpdateCallback()
  {
    if (this.mTimeUpdateTimer == null) {
      this.mTimeUpdateTimer = new Timer(true);
    }
    this.mTimeUpdateTimer.scheduleAtFixedRate(new InnerAudioPlayer.8(this), 0L, 250L);
  }
  
  private void stopTimeUpdateCallback()
  {
    if (this.mTimeUpdateTimer != null)
    {
      this.mTimeUpdateTimer.cancel();
      this.mTimeUpdateTimer = null;
    }
  }
  
  public int getAudioId()
  {
    return this.mAudioId;
  }
  
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
    if (isPrepared()) {
      i = j;
    }
    try
    {
      if (this.mMediaPlayer != null) {
        i = this.mMediaPlayer.getCurrentPosition();
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("[audio] InnerAudioPlayer", String.format("getCurrentPosition error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
    }
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
      if (this.mMediaPlayer != null) {
        this.mCacheDuration = this.mMediaPlayer.getDuration();
      }
      if (this.mCacheDuration < 0) {
        this.mCacheDuration = 0;
      }
      return this.mCacheDuration;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TTLog.e("[audio] InnerAudioPlayer", String.format("getDuration error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
      }
    }
  }
  
  public boolean getLoop()
  {
    return this.mLoop;
  }
  
  public float getStartTime()
  {
    return this.mStartTime;
  }
  
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
    return (isPrepared()) && (this.mMediaPlayer.isPlaying());
  }
  
  public boolean isPrepared()
  {
    return (this.mMediaPlayer != null) && (this.mIsPrepared);
  }
  
  public void pause()
  {
    if (this.mMediaPlayer == null) {}
    for (;;)
    {
      return;
      if (!isPrepared())
      {
        addOperateTask(new InnerAudioPlayer.3(this));
        return;
      }
      try
      {
        this.mPaused = true;
        if (this.mMediaPlayer != null) {
          this.mMediaPlayer.pause();
        }
        stopTimeUpdateCallback();
        if (getStateChangeListener() == null) {
          continue;
        }
        getStateChangeListener().onPause();
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TTLog.e("[audio] InnerAudioPlayer", String.format("pause error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
        }
      }
    }
  }
  
  public void play()
  {
    if (TextUtils.isEmpty(getAudioPath())) {
      TTLog.w("[audio] InnerAudioPlayer", String.format("play error on empty audio path, audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }));
    }
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
            this.mMediaPlayer.setDataSource(getAudioPath());
            this.mMediaPlayer.prepareAsync();
            boolean bool = getAutoPlay();
            if (bool) {}
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              TTLog.e("[audio] InnerAudioPlayer", String.format("play error on setDataSource and prepareAsync. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable1);
            }
          }
        }
        if (this.mMediaPlayer == null)
        {
          TTLog.w("[audio] InnerAudioPlayer", String.format("play error on null mMediaPlayer, audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }));
          return;
        }
      } while (isPlaying());
      if (!isPrepared())
      {
        addOperateTask(new InnerAudioPlayer.2(this));
        return;
      }
      try
      {
        if (this.mMediaPlayer != null)
        {
          this.mMediaPlayer.setLooping(getLoop());
          if (getVolume() >= 0.0F) {
            this.mMediaPlayer.setVolume(getVolume(), getVolume());
          }
          if ((!isPaused()) && (getStartTime() > 0.0F)) {
            this.mMediaPlayer.seekTo(this.mStartTime);
          }
          this.mMediaPlayer.start();
          startTimeUpdateCallback();
        }
        this.mPaused = false;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          TTLog.e("[audio] InnerAudioPlayer", String.format("play error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable2);
        }
      }
    } while (getStateChangeListener() == null);
    getStateChangeListener().onPlay();
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 226	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +31 -> 37
    //   9: aload_0
    //   10: invokevirtual 326	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:isPlaying	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: getfield 226	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   20: invokevirtual 362	android/media/MediaPlayer:stop	()V
    //   23: aload_0
    //   24: getfield 226	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   27: invokevirtual 365	android/media/MediaPlayer:reset	()V
    //   30: aload_0
    //   31: getfield 226	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   34: invokevirtual 367	android/media/MediaPlayer:release	()V
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 209	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAudioId	I
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 213	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAudioPath	Ljava/lang/String;
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 274	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mNeedToResume	Z
    //   52: aload_0
    //   53: dconst_0
    //   54: putfield 102	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mBufferedTime	D
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 266	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mStartTime	I
    //   62: aload_0
    //   63: ldc_w 368
    //   66: putfield 53	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mVolume	F
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 262	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mLoop	Z
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 216	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAutoPlay	Z
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 51	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mPaused	Z
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 226	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   89: aload_0
    //   90: getfield 64	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mPendingOperateTasks	Ljava/util/List;
    //   93: invokeinterface 140 1 0
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore_1
    //   102: ldc 10
    //   104: ldc_w 370
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: invokevirtual 232	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:getAudioId	()I
    //   117: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_0
    //   124: invokevirtual 240	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:getAudioPath	()Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 246	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   131: aload_1
    //   132: invokestatic 252	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   135: pop
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 209	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAudioId	I
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 213	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAudioPath	Ljava/lang/String;
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 274	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mNeedToResume	Z
    //   151: aload_0
    //   152: dconst_0
    //   153: putfield 102	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mBufferedTime	D
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 266	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mStartTime	I
    //   161: aload_0
    //   162: ldc_w 368
    //   165: putfield 53	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mVolume	F
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield 262	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mLoop	Z
    //   173: aload_0
    //   174: iconst_0
    //   175: putfield 216	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAutoPlay	Z
    //   178: aload_0
    //   179: iconst_1
    //   180: putfield 51	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mPaused	Z
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 226	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   188: aload_0
    //   189: getfield 64	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mPendingOperateTasks	Ljava/util/List;
    //   192: invokeinterface 140 1 0
    //   197: goto -99 -> 98
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 209	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAudioId	I
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 213	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAudioPath	Ljava/lang/String;
    //   216: aload_0
    //   217: iconst_0
    //   218: putfield 274	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mNeedToResume	Z
    //   221: aload_0
    //   222: dconst_0
    //   223: putfield 102	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mBufferedTime	D
    //   226: aload_0
    //   227: iconst_0
    //   228: putfield 266	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mStartTime	I
    //   231: aload_0
    //   232: ldc_w 368
    //   235: putfield 53	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mVolume	F
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 262	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mLoop	Z
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 216	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mAutoPlay	Z
    //   248: aload_0
    //   249: iconst_1
    //   250: putfield 51	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mPaused	Z
    //   253: aload_0
    //   254: aconst_null
    //   255: putfield 226	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mMediaPlayer	Landroid/media/MediaPlayer;
    //   258: aload_0
    //   259: getfield 64	com/tencent/mobileqq/triton/audio/InnerAudioPlayer:mPendingOperateTasks	Ljava/util/List;
    //   262: invokeinterface 140 1 0
    //   267: aload_1
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	InnerAudioPlayer
    //   101	31	1	localThrowable	Throwable
    //   200	4	1	localObject1	Object
    //   205	63	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	101	java/lang/Throwable
    //   23	37	101	java/lang/Throwable
    //   37	98	200	finally
    //   136	197	200	finally
    //   206	269	200	finally
    //   2	23	205	finally
    //   23	37	205	finally
    //   102	136	205	finally
  }
  
  public void reset()
  {
    for (;;)
    {
      try
      {
        if (this.mMediaPlayer != null)
        {
          if (isPlaying()) {
            this.mMediaPlayer.stop();
          }
          this.mMediaPlayer.reset();
          stopTimeUpdateCallback();
        }
      }
      catch (Throwable localThrowable1)
      {
        MediaPlayer localMediaPlayer1;
        label113:
        TTLog.e("[audio] InnerAudioPlayer", String.format("reset error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable1);
        MediaPlayer localMediaPlayer2 = this.mMediaPlayer;
        if (localMediaPlayer2 != null) {}
        try
        {
          this.mMediaPlayer.setOnErrorListener(null);
          this.mMediaPlayer.setOnCompletionListener(null);
          this.mMediaPlayer.setOnPreparedListener(null);
          this.mMediaPlayer.setOnBufferingUpdateListener(null);
          this.mMediaPlayer.setOnSeekCompleteListener(null);
          if (Build.VERSION.SDK_INT >= 28) {
            this.mMediaPlayer.clearOnMediaTimeDiscontinuityListener();
          }
          MediaPlayerManager.getInstance().enqueuePlayer(this.mMediaPlayer);
          this.mMediaPlayer = null;
        }
        catch (Throwable localThrowable2)
        {
          MediaPlayer localMediaPlayer3;
          continue;
        }
        this.mIsPrepared = false;
        this.mPaused = true;
        this.mCacheDuration = 0;
        continue;
      }
      finally
      {
        localMediaPlayer3 = this.mMediaPlayer;
        if (localMediaPlayer3 == null) {
          continue;
        }
        try
        {
          this.mMediaPlayer.setOnErrorListener(null);
          this.mMediaPlayer.setOnCompletionListener(null);
          this.mMediaPlayer.setOnPreparedListener(null);
          this.mMediaPlayer.setOnBufferingUpdateListener(null);
          this.mMediaPlayer.setOnSeekCompleteListener(null);
          if (Build.VERSION.SDK_INT >= 28) {
            this.mMediaPlayer.clearOnMediaTimeDiscontinuityListener();
          }
          MediaPlayerManager.getInstance().enqueuePlayer(this.mMediaPlayer);
          this.mMediaPlayer = null;
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
      this.mMediaPlayer.setOnErrorListener(null);
      this.mMediaPlayer.setOnCompletionListener(null);
      this.mMediaPlayer.setOnPreparedListener(null);
      this.mMediaPlayer.setOnBufferingUpdateListener(null);
      this.mMediaPlayer.setOnSeekCompleteListener(null);
      if (Build.VERSION.SDK_INT >= 28) {
        this.mMediaPlayer.clearOnMediaTimeDiscontinuityListener();
      }
      MediaPlayerManager.getInstance().enqueuePlayer(this.mMediaPlayer);
      this.mMediaPlayer = null;
    }
    catch (Throwable localThrowable3)
    {
      break label113;
    }
    this.mIsPrepared = false;
    this.mPaused = true;
    this.mCacheDuration = 0;
  }
  
  public void resume()
  {
    if (this.mMediaPlayer == null)
    {
      TTLog.w("[audio] InnerAudioPlayer", String.format("resume error on null mMediaPlayer. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }));
      return;
    }
    if (!isPrepared())
    {
      addOperateTask(new InnerAudioPlayer.4(this));
      return;
    }
    try
    {
      if (this.mMediaPlayer != null)
      {
        this.mMediaPlayer.start();
        startTimeUpdateCallback();
      }
      this.mPaused = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("[audio] InnerAudioPlayer", String.format("resume error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
    }
  }
  
  public void seekTo(float paramFloat)
  {
    if (Float.isNaN(paramFloat)) {}
    for (;;)
    {
      return;
      if (!isPrepared())
      {
        addOperateTask(new InnerAudioPlayer.5(this, paramFloat));
        return;
      }
      try
      {
        if (this.mMediaPlayer != null) {
          this.mMediaPlayer.seekTo((int)paramFloat);
        }
        if (getStateChangeListener() == null) {
          continue;
        }
        getStateChangeListener().onSeeking();
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TTLog.e("[audio] InnerAudioPlayer", String.format("seekTo error. audioId=%d path=%", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
        }
      }
    }
  }
  
  public void setAudioId(int paramInt)
  {
    this.mAudioId = paramInt;
  }
  
  public void setAudioPath(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(getAudioPath())))
    {
      TTLog.w("[audio] InnerAudioPlayer", String.format("setAudioPath audioId=%d, from %s to %s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath(), paramString }));
      this.mAudioPath = paramString;
      reset();
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (getStateChangeListener() != null) {
        getStateChangeListener().onCanPlay();
      }
    } while (!getAutoPlay());
    play();
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.mAutoPlay = paramBoolean;
    if ((paramBoolean) && (!TextUtils.isEmpty(getAudioPath()))) {
      play();
    }
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (!isPrepared()) {
      addOperateTask(new InnerAudioPlayer.7(this, paramBoolean));
    }
    for (;;)
    {
      return;
      this.mLoop = paramBoolean;
      try
      {
        if (this.mMediaPlayer != null)
        {
          this.mMediaPlayer.setLooping(paramBoolean);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        TTLog.e("[audio] InnerAudioPlayer", String.format("setLoop error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
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
  
  public void setStateChangeListener(IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    this.mAudioStateChangeListener = paramIAudioStateChangeListener;
  }
  
  public void setVolume(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramFloat < 0.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat > 1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        if (!isPrepared()) {
          addOperateTask(new InnerAudioPlayer.6(this, paramFloat));
        }
        for (;;)
        {
          return;
          this.mVolume = paramFloat;
          try
          {
            if (this.mMediaPlayer != null)
            {
              this.mMediaPlayer.setVolume(paramFloat, paramFloat);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            TTLog.e("[audio] InnerAudioPlayer", String.format("setVolume error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
            return;
          }
        }
      }
    }
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
          if (isPlaying()) {
            this.mMediaPlayer.pause();
          }
          if (getStartTime() > 0.0F) {
            setStartTime(0.0F);
          }
          this.mMediaPlayer.seekTo(this.mStartTime);
          stopTimeUpdateCallback();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TTLog.e("[audio] InnerAudioPlayer", String.format("stop error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
        }
      }
    } while (getStateChangeListener() == null);
    getStateChangeListener().onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer
 * JD-Core Version:    0.7.0.1
 */