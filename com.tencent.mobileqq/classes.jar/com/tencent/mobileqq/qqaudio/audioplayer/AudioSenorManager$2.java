package com.tencent.mobileqq.qqaudio.audioplayer;

import android.hardware.SensorManager;

class AudioSenorManager$2
  implements Runnable
{
  AudioSenorManager$2(AudioSenorManager paramAudioSenorManager) {}
  
  public void run()
  {
    AudioSenorManager.d(this.this$0).unregisterListener(AudioSenorManager.c(this.this$0));
    AudioSenorManager.d(this.this$0).unregisterListener(AudioSenorManager.e(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager.2
 * JD-Core Version:    0.7.0.1
 */