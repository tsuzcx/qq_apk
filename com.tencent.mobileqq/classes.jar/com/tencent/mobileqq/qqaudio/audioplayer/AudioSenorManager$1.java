package com.tencent.mobileqq.qqaudio.audioplayer;

import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

class AudioSenorManager$1
  implements Runnable
{
  AudioSenorManager$1(AudioSenorManager paramAudioSenorManager) {}
  
  public void run()
  {
    if (AudioSenorManager.a(this.this$0) != null)
    {
      if (AudioSenorManager.b(this.this$0) != null) {
        try
        {
          AudioSenorManager.d(this.this$0).registerListener(AudioSenorManager.c(this.this$0), AudioSenorManager.b(this.this$0), 3);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      try
      {
        AudioSenorManager.d(this.this$0).registerListener(AudioSenorManager.e(this.this$0), AudioSenorManager.a(this.this$0), 3);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("$requestPlay| mAccelerationSensro=");
      localStringBuilder.append(AudioSenorManager.b(this.this$0));
      localStringBuilder.append(" | mProximitySensor = ");
      localStringBuilder.append(AudioSenorManager.a(this.this$0));
      QLog.d("AudioPlayer_SenorManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager.1
 * JD-Core Version:    0.7.0.1
 */