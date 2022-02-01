package com.tencent.mobileqq.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public class QQLSSensor
{
  public boolean a = false;
  public SensorEventListener b = new QQLSSensor.1(this);
  private SensorManager c;
  private Sensor d;
  private float e;
  private QQLSSensor.ProximitySensorChangeListener f;
  private boolean g;
  private Context h;
  private Handler i = new QQLSSensor.2(this, Looper.getMainLooper());
  
  public QQLSSensor(Context paramContext, QQLSSensor.ProximitySensorChangeListener paramProximitySensorChangeListener)
  {
    this.f = paramProximitySensorChangeListener;
    this.h = paramContext;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "LSSensor open=====");
    }
    this.g = false;
    this.c = ((SensorManager)this.h.getSystemService("sensor"));
    this.d = this.c.getDefaultSensor(8);
    Sensor localSensor = this.d;
    if (localSensor != null)
    {
      this.a = true;
      this.e = localSensor.getMaximumRange();
      if (this.e > 10.0F) {
        this.e = 10.0F;
      }
      this.c.registerListener(this.b, this.d, 2);
      return;
    }
    this.a = false;
    this.f.a(this.g);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "LSSensor shutdown=====");
    }
    SensorManager localSensorManager = this.c;
    if (localSensorManager != null)
    {
      localSensorManager.unregisterListener(this.b);
      this.c = null;
    }
    try
    {
      this.f = null;
      this.d = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQLSSensor
 * JD-Core Version:    0.7.0.1
 */