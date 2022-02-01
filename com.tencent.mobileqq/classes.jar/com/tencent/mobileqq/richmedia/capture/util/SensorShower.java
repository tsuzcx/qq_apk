package com.tencent.mobileqq.richmedia.capture.util;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

public class SensorShower
{
  private SensorManager a;
  private SensorShower.LightSensorListener b;
  private SensorShower.OnGetValue c;
  private boolean d = false;
  
  public static SensorShower a()
  {
    return SensorShower.Singleton.a();
  }
  
  public int a(Context paramContext, SensorShower.OnGetValue paramOnGetValue)
  {
    QLog.d("MicroMsg.LightSensor", 1, "SensorShower start");
    if (this.d)
    {
      QLog.d("MicroMsg.LightSensor", 1, "[SensorShower.start] light sensor has started");
      return 2;
    }
    this.d = true;
    this.a = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
    paramContext = this.a.getDefaultSensor(5);
    if (paramContext != null)
    {
      this.b = new SensorShower.LightSensorListener(this, null);
      this.a.registerListener(this.b, paramContext, 3);
      this.c = paramOnGetValue;
      return 0;
    }
    QLog.e("MicroMsg.LightSensor", 1, "[SensorShower.start] System do not have lightSensor");
    return 1;
  }
  
  public void b()
  {
    QLog.d("MicroMsg.LightSensor", 1, "sensorshower stop");
    if (this.d)
    {
      SensorManager localSensorManager = this.a;
      if (localSensorManager != null)
      {
        this.d = false;
        localSensorManager.unregisterListener(this.b);
        return;
      }
    }
    QLog.d("MicroMsg.LightSensor", 1, "sensorshower stop mHasStarted is false or mSensorShower is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.SensorShower
 * JD-Core Version:    0.7.0.1
 */