package com.tencent.mobileqq.msf.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class ad
  implements SensorEventListener2
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onFlushCompleted(Sensor paramSensor)
  {
    if ((paramSensor != null) && (paramSensor.getType() == 19))
    {
      QLog.i("health_manager", 1, "onFlushCompleted.");
      if ((y.H > y.X) && (y.H - y.X < y.U)) {
        y.X = y.H;
      }
      y.a(false, null, null);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null) || (paramSensorEvent.values.length <= 0) || (paramSensorEvent.values[0] == 0.0F) || (paramSensorEvent.values[0] > y.T)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!y.Z.get())
          {
            y.I = (int)paramSensorEvent.values[0];
            return;
          }
          if (paramSensorEvent.values[0] >= y.X) {
            break;
          }
          y.R += 1;
        } while (y.R <= 2);
        if ((y.ad != null) && (y.ad.has("shut_down")) && (y.ad.optLong("shut_down") == y.f()) && (paramSensorEvent.values[0] < y.U))
        {
          y.ad.remove("shut_down");
          y.X = (int)paramSensorEvent.values[0];
          y.W = 1;
          QLog.i("health_manager", 1, "reset from shut down");
          y.H = (int)paramSensorEvent.values[0];
          y.ab = NetConnInfoCenter.getServerTimeMillis();
          QLog.i("health_manager", 1, "step counter exception reset: init = " + y.W + ",total = " + y.X + ",offset = " + y.Y);
          y.a(false, null, null);
          y.R = 0;
          y.J = System.currentTimeMillis();
          return;
        }
        y.Y = y.X - y.W + y.Y;
        y.X = (int)paramSensorEvent.values[0];
        if (y.X < 1000) {}
        for (i = 1;; i = y.X - 3)
        {
          y.W = i;
          break;
        }
        y.R = 0;
        if ((y.H == 0) || (paramSensorEvent.values[0] - y.H <= y.U)) {
          break;
        }
        y.S += 1;
      } while (y.S <= 4);
      if (y.X - y.W > 0) {}
      for (int i = y.X - y.W;; i = 0)
      {
        y.Y = i + y.Y;
        y.W = (int)paramSensorEvent.values[0] - 5;
        y.X = (int)paramSensorEvent.values[0];
        y.H = (int)paramSensorEvent.values[0];
        y.ab = NetConnInfoCenter.getServerTimeMillis();
        y.ae.set(true);
        QLog.i("health_manager", 1, "Jump CallBack reset init = " + y.W + ",total = " + y.X + ",offset = " + y.Y);
        y.a(false, null, null);
        y.S = 0;
        y.J = System.currentTimeMillis();
        return;
      }
      y.S = 0;
      if ((paramSensorEvent.values[0] - y.H > y.U) && (y.H == 0) && (y.W != 0))
      {
        QLog.i("health_manager", 1, "msf step counter restart!");
        if (y.X == 0) {}
        for (i = y.W;; i = y.X)
        {
          y.H = i;
          y.ab = NetConnInfoCenter.getServerTimeMillis();
          return;
        }
      }
      y.H = (int)paramSensorEvent.values[0];
      y.ab = NetConnInfoCenter.getServerTimeMillis();
    } while (System.currentTimeMillis() - y.J < 1200000L);
    y.J = System.currentTimeMillis();
    y.X = y.H;
    y.a(true, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ad
 * JD-Core Version:    0.7.0.1
 */