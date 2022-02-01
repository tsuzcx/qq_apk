package com.tencent.mobileqq.qqaudio.audioplayer;

import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class AudioPlayerBase$2
  extends TimerTask
{
  AudioPlayerBase$2(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void run()
  {
    if (this.this$0.a != null) {}
    try
    {
      this.this$0.a.d(this.this$0, this.this$0.c());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, "startProgressTimer e= " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.2
 * JD-Core Version:    0.7.0.1
 */