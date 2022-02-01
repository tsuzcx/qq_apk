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
  
  void start()
  {
    try
    {
      if ((this.mAudioPlayerProxy != null) && (this.mAudioPlayer != null))
      {
        if (!TextUtils.isEmpty(this.mTimerTaskKey))
        {
          TimerTaskManager.getInstance().cancelTimerTask(this.mTimerTaskKey);
          this.mTimerTaskKey = null;
        }
        this.mTimerTaskKey = TimerTaskManager.getInstance().addUIThreadTimerTask(new AudioProgressTimer.1(this), 1000L, 1000L);
        return;
      }
      return;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioProgressTimer
 * JD-Core Version:    0.7.0.1
 */