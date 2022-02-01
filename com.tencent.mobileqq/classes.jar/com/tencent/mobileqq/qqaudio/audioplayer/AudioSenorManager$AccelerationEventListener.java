package com.tencent.mobileqq.qqaudio.audioplayer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.qphone.base.util.QLog;

class AudioSenorManager$AccelerationEventListener
  implements SensorEventListener
{
  AudioSenorManager$AccelerationEventListener(AudioSenorManager paramAudioSenorManager) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      float f6 = paramSensorEvent.values[0];
      float f5 = paramSensorEvent.values[1];
      float f4 = paramSensorEvent.values[2];
      float f3 = f4;
      float f2 = f6;
      float f1 = f5;
      if (AudioSenorManager.a())
      {
        f2 = f6 * 10.0F;
        f1 = f5 * 10.0F;
        f3 = f4 * 10.0F;
      }
      if ((this.a.d != -999.0F) || (this.a.e != -999.0F) || (this.a.f != -999.0F))
      {
        f4 = Math.abs(this.a.d - f2);
        f5 = Math.abs(this.a.e - f1);
        f6 = Math.abs(this.a.f - f3);
        if ((f4 < AudioSenorManager.f(this.a)) && (f5 < AudioSenorManager.f(this.a)) && (f6 < AudioSenorManager.f(this.a)))
        {
          if ((f4 < AudioSenorManager.g(this.a)) && (f5 < AudioSenorManager.g(this.a)) && (f6 < AudioSenorManager.g(this.a)))
          {
            if ((this.a.a) && (QLog.isColorLevel()))
            {
              paramSensorEvent = new StringBuilder();
              paramSensorEvent.append("AccelerationListener$onSensorChanged stop moving | x=");
              paramSensorEvent.append(f2);
              paramSensorEvent.append(" | y = ");
              paramSensorEvent.append(f1);
              paramSensorEvent.append(" | z = ");
              paramSensorEvent.append(f3);
              paramSensorEvent.append(" | ax = ");
              paramSensorEvent.append(f4);
              paramSensorEvent.append(" | ay = ");
              paramSensorEvent.append(f5);
              paramSensorEvent.append(" | az = ");
              paramSensorEvent.append(f6);
              paramSensorEvent.append(" | value=");
              paramSensorEvent.append(AudioSenorManager.f(this.a));
              QLog.d("AudioPlayer_SenorManager", 2, paramSensorEvent.toString());
            }
            this.a.a = false;
          }
        }
        else
        {
          if ((!this.a.a) && (QLog.isColorLevel()))
          {
            paramSensorEvent = new StringBuilder();
            paramSensorEvent.append("AccelerationListener$onSensorChanged moving | x=");
            paramSensorEvent.append(f2);
            paramSensorEvent.append(" | y = ");
            paramSensorEvent.append(f1);
            paramSensorEvent.append(" | z = ");
            paramSensorEvent.append(f3);
            paramSensorEvent.append(" | ax = ");
            paramSensorEvent.append(f4);
            paramSensorEvent.append(" | ay = ");
            paramSensorEvent.append(f5);
            paramSensorEvent.append(" | az = ");
            paramSensorEvent.append(f6);
            paramSensorEvent.append(" | value=");
            paramSensorEvent.append(AudioSenorManager.f(this.a));
            QLog.d("AudioPlayer_SenorManager", 2, paramSensorEvent.toString());
          }
          this.a.a = true;
        }
      }
      paramSensorEvent = this.a;
      paramSensorEvent.d = f2;
      paramSensorEvent.e = f1;
      paramSensorEvent.f = f3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager.AccelerationEventListener
 * JD-Core Version:    0.7.0.1
 */