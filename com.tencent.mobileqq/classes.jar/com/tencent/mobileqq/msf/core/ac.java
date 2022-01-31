package com.tencent.mobileqq.msf.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class ac
  implements SensorEventListener2
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onFlushCompleted(Sensor paramSensor)
  {
    if ((paramSensor != null) && (paramSensor.getType() == 19))
    {
      QLog.i("health_manager", 1, "onFlushCompleted.");
      if ((x.H > x.X) && (x.H - x.X < x.U)) {
        x.X = x.H;
      }
      x.a(false, null, null);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null) || (paramSensorEvent.values.length <= 0) || (paramSensorEvent.values[0] == 0.0F) || (paramSensorEvent.values[0] > x.T)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!x.Z.get())
          {
            x.I = (int)paramSensorEvent.values[0];
            return;
          }
          if (paramSensorEvent.values[0] >= x.X) {
            break;
          }
          x.R += 1;
        } while (x.R <= 2);
        if ((x.ac != null) && (x.ac.has("shut_down")) && (x.ac.optLong("shut_down") == x.f()) && (paramSensorEvent.values[0] < x.U))
        {
          x.ac.remove("shut_down");
          x.X = (int)paramSensorEvent.values[0];
          x.W = 1;
          QLog.i("health_manager", 1, "reset from shut down");
          x.H = (int)paramSensorEvent.values[0];
          QLog.i("health_manager", 1, "step counter exception reset: init = " + x.W + ",total = " + x.X + ",offset = " + x.Y);
          x.a(false, null, null);
          x.R = 0;
          x.J = System.currentTimeMillis();
          return;
        }
        x.Y = x.X - x.W + x.Y;
        x.X = (int)paramSensorEvent.values[0];
        if (x.X < 1000) {}
        for (i = 1;; i = x.X - 3)
        {
          x.W = i;
          break;
        }
        x.R = 0;
        if ((x.H == 0) || (paramSensorEvent.values[0] - x.H <= x.U)) {
          break;
        }
        x.S += 1;
      } while (x.S <= 4);
      if (x.X - x.W > 0) {}
      for (int i = x.X - x.W;; i = 0)
      {
        x.Y = i + x.Y;
        x.W = (int)paramSensorEvent.values[0] - 5;
        x.X = (int)paramSensorEvent.values[0];
        x.H = (int)paramSensorEvent.values[0];
        x.ad.set(true);
        QLog.i("health_manager", 1, "Jump CallBack reset init = " + x.W + ",total = " + x.X + ",offset = " + x.Y);
        x.a(false, null, null);
        x.S = 0;
        x.J = System.currentTimeMillis();
        return;
      }
      x.S = 0;
      if ((paramSensorEvent.values[0] - x.H > x.U) && (x.H == 0) && (x.W != 0))
      {
        QLog.i("health_manager", 1, "msf step counter restart!");
        if (x.X == 0) {}
        for (i = x.W;; i = x.X)
        {
          x.H = i;
          return;
        }
      }
      x.H = (int)paramSensorEvent.values[0];
    } while (System.currentTimeMillis() - x.J < 1200000L);
    x.J = System.currentTimeMillis();
    x.X = x.H;
    x.a(true, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ac
 * JD-Core Version:    0.7.0.1
 */