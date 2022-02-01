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
      if ((this.a.jdField_a_of_type_Float != -999.0F) || (this.a.b != -999.0F) || (this.a.c != -999.0F))
      {
        f4 = Math.abs(this.a.jdField_a_of_type_Float - f2);
        f5 = Math.abs(this.a.b - f1);
        f6 = Math.abs(this.a.c - f3);
        if ((f4 < AudioSenorManager.a(this.a)) && (f5 < AudioSenorManager.a(this.a)) && (f6 < AudioSenorManager.a(this.a)))
        {
          if ((f4 < AudioSenorManager.b(this.a)) && (f5 < AudioSenorManager.b(this.a)) && (f6 < AudioSenorManager.b(this.a)))
          {
            if ((this.a.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
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
              paramSensorEvent.append(AudioSenorManager.a(this.a));
              QLog.d("AudioPlayer_SenorManager", 2, paramSensorEvent.toString());
            }
            this.a.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          if ((!this.a.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
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
            paramSensorEvent.append(AudioSenorManager.a(this.a));
            QLog.d("AudioPlayer_SenorManager", 2, paramSensorEvent.toString());
          }
          this.a.jdField_a_of_type_Boolean = true;
        }
      }
      paramSensorEvent = this.a;
      paramSensorEvent.jdField_a_of_type_Float = f2;
      paramSensorEvent.b = f1;
      paramSensorEvent.c = f3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager.AccelerationEventListener
 * JD-Core Version:    0.7.0.1
 */