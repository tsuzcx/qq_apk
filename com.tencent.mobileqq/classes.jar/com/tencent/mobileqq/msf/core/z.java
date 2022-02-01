package com.tencent.mobileqq.msf.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class z
  implements SensorEventListener2
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onFlushCompleted(Sensor paramSensor)
  {
    if ((paramSensor != null) && (paramSensor.getType() == 19))
    {
      QLog.i("health_manager", 1, "onFlushCompleted.");
      if ((u.H > u.X) && (u.H - u.X < u.U)) {
        u.X = u.H;
      }
      u.a(false, null, null);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null) || (paramSensorEvent.values.length <= 0) || (paramSensorEvent.values[0] == 0.0F) || (paramSensorEvent.values[0] > u.T)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!u.Z.get())
          {
            u.I = (int)paramSensorEvent.values[0];
            return;
          }
          if (paramSensorEvent.values[0] >= u.X) {
            break;
          }
          u.R += 1;
        } while (u.R <= 2);
        if ((u.ad != null) && (u.ad.has("shut_down")) && (u.ad.optLong("shut_down") == u.f()) && (paramSensorEvent.values[0] < u.U))
        {
          u.ad.remove("shut_down");
          u.X = (int)paramSensorEvent.values[0];
          u.W = 1;
          QLog.i("health_manager", 1, "reset from shut down");
          u.H = (int)paramSensorEvent.values[0];
          u.ab = NetConnInfoCenter.getServerTimeMillis();
          QLog.i("health_manager", 1, "step counter exception reset: init = " + u.W + ",total = " + u.X + ",offset = " + u.Y);
          u.a(false, null, null);
          u.R = 0;
          u.J = System.currentTimeMillis();
          return;
        }
        u.Y = u.X - u.W + u.Y;
        u.X = (int)paramSensorEvent.values[0];
        if (u.X < 1000) {}
        for (i = 1;; i = u.X - 3)
        {
          u.W = i;
          break;
        }
        u.R = 0;
        if ((u.H == 0) || (paramSensorEvent.values[0] - u.H <= u.U)) {
          break;
        }
        u.S += 1;
      } while (u.S <= 4);
      if (u.X - u.W > 0) {}
      for (int i = u.X - u.W;; i = 0)
      {
        u.Y = i + u.Y;
        u.W = (int)paramSensorEvent.values[0] - 5;
        u.X = (int)paramSensorEvent.values[0];
        u.H = (int)paramSensorEvent.values[0];
        u.ab = NetConnInfoCenter.getServerTimeMillis();
        u.ae.set(true);
        QLog.i("health_manager", 1, "Jump CallBack reset init = " + u.W + ",total = " + u.X + ",offset = " + u.Y);
        u.a(false, null, null);
        u.S = 0;
        u.J = System.currentTimeMillis();
        return;
      }
      u.S = 0;
      if ((paramSensorEvent.values[0] - u.H > u.U) && (u.H == 0) && (u.W != 0))
      {
        QLog.i("health_manager", 1, "msf step counter restart!");
        if (u.X == 0) {}
        for (i = u.W;; i = u.X)
        {
          u.H = i;
          u.ab = NetConnInfoCenter.getServerTimeMillis();
          return;
        }
      }
      u.H = (int)paramSensorEvent.values[0];
      u.ab = NetConnInfoCenter.getServerTimeMillis();
    } while (System.currentTimeMillis() - u.J < 1200000L);
    u.J = System.currentTimeMillis();
    u.X = u.H;
    u.a(true, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.z
 * JD-Core Version:    0.7.0.1
 */