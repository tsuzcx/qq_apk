package com.tencent.mobileqq.msf.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class aa
  implements SensorEventListener2
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onFlushCompleted(Sensor paramSensor)
  {
    if ((paramSensor != null) && (paramSensor.getType() == 19))
    {
      QLog.i("health_manager", 1, "onFlushCompleted.");
      if ((v.H > v.X) && (v.H - v.X < v.U)) {
        v.X = v.H;
      }
      v.a(false, null, null);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0) && (paramSensorEvent.values[0] != 0.0F))
    {
      if (paramSensorEvent.values[0] > v.T) {
        return;
      }
      if (!v.Z.get())
      {
        v.I = (int)paramSensorEvent.values[0];
        return;
      }
      int i;
      if (paramSensorEvent.values[0] < v.X)
      {
        v.R += 1;
        if (v.R > 2)
        {
          if ((v.ad != null) && (v.ad.has("shut_down")) && (v.ad.optLong("shut_down") == v.g()) && (paramSensorEvent.values[0] < v.U))
          {
            v.ad.remove("shut_down");
            v.X = (int)paramSensorEvent.values[0];
            v.W = 1;
            QLog.i("health_manager", 1, "reset from shut down");
          }
          else
          {
            v.Y = v.X - v.W + v.Y;
            v.X = (int)paramSensorEvent.values[0];
            if (v.X < 1000) {
              i = 1;
            } else {
              i = v.X - 3;
            }
            v.W = i;
          }
          v.H = (int)paramSensorEvent.values[0];
          v.ab = NetConnInfoCenter.getServerTimeMillis();
          paramSensorEvent = new StringBuilder();
          paramSensorEvent.append("step counter exception reset: init = ");
          paramSensorEvent.append(v.W);
          paramSensorEvent.append(",total = ");
          paramSensorEvent.append(v.X);
          paramSensorEvent.append(",offset = ");
          paramSensorEvent.append(v.Y);
          QLog.i("health_manager", 1, paramSensorEvent.toString());
          v.a(false, null, null);
          v.R = 0;
          v.J = System.currentTimeMillis();
        }
        return;
      }
      v.R = 0;
      if ((v.H != 0) && (paramSensorEvent.values[0] - v.H > v.U))
      {
        v.S += 1;
        if (v.S > 4)
        {
          if (v.X - v.W > 0) {
            i = v.X - v.W;
          } else {
            i = 0;
          }
          v.Y = i + v.Y;
          v.W = (int)paramSensorEvent.values[0] - 5;
          v.X = (int)paramSensorEvent.values[0];
          v.H = (int)paramSensorEvent.values[0];
          v.ab = NetConnInfoCenter.getServerTimeMillis();
          v.ae.set(true);
          paramSensorEvent = new StringBuilder();
          paramSensorEvent.append("Jump CallBack reset init = ");
          paramSensorEvent.append(v.W);
          paramSensorEvent.append(",total = ");
          paramSensorEvent.append(v.X);
          paramSensorEvent.append(",offset = ");
          paramSensorEvent.append(v.Y);
          QLog.i("health_manager", 1, paramSensorEvent.toString());
          v.a(false, null, null);
          v.S = 0;
          v.J = System.currentTimeMillis();
        }
        return;
      }
      v.S = 0;
      if ((paramSensorEvent.values[0] - v.H > v.U) && (v.H == 0) && (v.W != 0))
      {
        QLog.i("health_manager", 1, "msf step counter restart!");
        if (v.X == 0) {
          i = v.W;
        } else {
          i = v.X;
        }
        v.H = i;
        v.ab = NetConnInfoCenter.getServerTimeMillis();
        return;
      }
      v.H = (int)paramSensorEvent.values[0];
      v.ab = NetConnInfoCenter.getServerTimeMillis();
      if (System.currentTimeMillis() - v.J < 1200000L) {
        return;
      }
      v.J = System.currentTimeMillis();
      v.X = v.H;
      v.a(true, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aa
 * JD-Core Version:    0.7.0.1
 */