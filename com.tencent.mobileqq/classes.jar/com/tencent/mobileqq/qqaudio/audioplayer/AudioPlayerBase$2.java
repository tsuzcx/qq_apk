package com.tencent.mobileqq.qqaudio.audioplayer;

import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class AudioPlayerBase$2
  extends TimerTask
{
  AudioPlayerBase$2(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void run()
  {
    if (this.this$0.r != null) {
      try
      {
        this.this$0.r.d(this.this$0, this.this$0.h());
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startProgressTimer e= ");
          localStringBuilder.append(localException);
          QLog.e("AudioPlayer", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.2
 * JD-Core Version:    0.7.0.1
 */