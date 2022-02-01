package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.task.TimerTaskManager;

class AudioProgressTimer
{
  private static final int BEAT_INTERVAL = 1000;
  private IAudioPlayer mAudioPlayer;
  private IAudioPlayerProxy mAudioPlayerProxy;
  private String mTimerTaskKey;
  
  @SuppressLint({"HandlerLeak"})
  AudioProgressTimer(@NonNull IAudioPlayer paramIAudioPlayer, @NonNull IAudioPlayerProxy paramIAudioPlayerProxy)
  {
    this.mAudioPlayer = paramIAudioPlayer;
    this.mAudioPlayerProxy = paramIAudioPlayerProxy;
  }
  
  /* Error */
  void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer:mAudioPlayerProxy	Lcom/tencent/qqlive/module/videoreport/dtreport/audio/playback/IAudioPlayerProxy;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 24	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer:mAudioPlayer	Lcom/tencent/qqlive/module/videoreport/dtreport/audio/api/IAudioPlayer;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 36	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer:mTimerTaskKey	Ljava/lang/String;
    //   25: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +18 -> 46
    //   31: invokestatic 48	com/tencent/qqlive/module/videoreport/task/TimerTaskManager:getInstance	()Lcom/tencent/qqlive/module/videoreport/task/TimerTaskManager;
    //   34: aload_0
    //   35: getfield 36	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer:mTimerTaskKey	Ljava/lang/String;
    //   38: invokevirtual 52	com/tencent/qqlive/module/videoreport/task/TimerTaskManager:cancelTimerTask	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 36	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer:mTimerTaskKey	Ljava/lang/String;
    //   46: aload_0
    //   47: invokestatic 48	com/tencent/qqlive/module/videoreport/task/TimerTaskManager:getInstance	()Lcom/tencent/qqlive/module/videoreport/task/TimerTaskManager;
    //   50: new 54	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer$1
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 57	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer$1:<init>	(Lcom/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer;)V
    //   58: ldc2_w 58
    //   61: ldc2_w 58
    //   64: invokevirtual 63	com/tencent/qqlive/module/videoreport/task/TimerTaskManager:addUIThreadTimerTask	(Ljava/lang/Runnable;JJ)Ljava/lang/String;
    //   67: putfield 36	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/AudioProgressTimer:mTimerTaskKey	Ljava/lang/String;
    //   70: goto -52 -> 18
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	AudioProgressTimer
    //   13	2	1	localIAudioPlayer	IAudioPlayer
    //   73	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	73	finally
    //   21	46	73	finally
    //   46	70	73	finally
  }
  
  void stop()
  {
    try
    {
      if (!TextUtils.isEmpty(this.mTimerTaskKey))
      {
        TimerTaskManager.getInstance().cancelTimerTask(this.mTimerTaskKey);
        this.mTimerTaskKey = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioProgressTimer
 * JD-Core Version:    0.7.0.1
 */