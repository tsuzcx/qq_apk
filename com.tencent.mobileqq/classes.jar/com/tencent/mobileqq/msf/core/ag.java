package com.tencent.mobileqq.msf.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class ag
  implements SensorEventListener2
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onFlushCompleted(Sensor paramSensor)
  {
    if ((paramSensor != null) && (paramSensor.getType() == 19))
    {
      QLog.i("health_manager", 1, "onFlushCompleted.");
      if ((ab.H > ab.X) && (ab.H - ab.X < ab.U)) {
        ab.X = ab.H;
      }
      ab.a(false, null, null);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null) || (paramSensorEvent.values.length <= 0) || (paramSensorEvent.values[0] == 0.0F) || (paramSensorEvent.values[0] > ab.T)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!ab.Z.get())
          {
            ab.I = (int)paramSensorEvent.values[0];
            return;
          }
          if (paramSensorEvent.values[0] >= ab.X) {
            break;
          }
          ab.R += 1;
        } while (ab.R <= 2);
        if ((ab.ad != null) && (ab.ad.has("shut_down")) && (ab.ad.optLong("shut_down") == ab.f()) && (paramSensorEvent.values[0] < ab.U))
        {
          ab.ad.remove("shut_down");
          ab.X = (int)paramSensorEvent.values[0];
          ab.W = 1;
          QLog.i("health_manager", 1, "reset from shut down");
          ab.H = (int)paramSensorEvent.values[0];
          ab.ab = NetConnInfoCenter.getServerTimeMillis();
          QLog.i("health_manager", 1, "step counter exception reset: init = " + ab.W + ",total = " + ab.X + ",offset = " + ab.Y);
          ab.a(false, null, null);
          ab.R = 0;
          ab.J = System.currentTimeMillis();
          return;
        }
        ab.Y = ab.X - ab.W + ab.Y;
        ab.X = (int)paramSensorEvent.values[0];
        if (ab.X < 1000) {}
        for (i = 1;; i = ab.X - 3)
        {
          ab.W = i;
          break;
        }
        ab.R = 0;
        if ((ab.H == 0) || (paramSensorEvent.values[0] - ab.H <= ab.U)) {
          break;
        }
        ab.S += 1;
      } while (ab.S <= 4);
      if (ab.X - ab.W > 0) {}
      for (int i = ab.X - ab.W;; i = 0)
      {
        ab.Y = i + ab.Y;
        ab.W = (int)paramSensorEvent.values[0] - 5;
        ab.X = (int)paramSensorEvent.values[0];
        ab.H = (int)paramSensorEvent.values[0];
        ab.ab = NetConnInfoCenter.getServerTimeMillis();
        ab.ae.set(true);
        QLog.i("health_manager", 1, "Jump CallBack reset init = " + ab.W + ",total = " + ab.X + ",offset = " + ab.Y);
        ab.a(false, null, null);
        ab.S = 0;
        ab.J = System.currentTimeMillis();
        return;
      }
      ab.S = 0;
      if ((paramSensorEvent.values[0] - ab.H > ab.U) && (ab.H == 0) && (ab.W != 0))
      {
        QLog.i("health_manager", 1, "msf step counter restart!");
        if (ab.X == 0) {}
        for (i = ab.W;; i = ab.X)
        {
          ab.H = i;
          ab.ab = NetConnInfoCenter.getServerTimeMillis();
          return;
        }
      }
      ab.H = (int)paramSensorEvent.values[0];
      ab.ab = NetConnInfoCenter.getServerTimeMillis();
    } while (System.currentTimeMillis() - ab.J < 1200000L);
    ab.J = System.currentTimeMillis();
    ab.X = ab.H;
    ab.a(true, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ag
 * JD-Core Version:    0.7.0.1
 */