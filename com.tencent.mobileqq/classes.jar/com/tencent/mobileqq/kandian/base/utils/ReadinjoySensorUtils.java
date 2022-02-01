package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoySensorUtils
  implements SensorEventListener
{
  private static volatile ReadinjoySensorUtils a;
  private SensorManager b;
  private Context c;
  private Sensor d;
  private Sensor e;
  private float[] f = new float[3];
  private double[] g = new double[3];
  private final float h = 0.8F;
  private final double[] i = new double[4];
  private float j;
  private boolean k = false;
  private boolean l;
  private boolean m;
  
  public static ReadinjoySensorUtils a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ReadinjoySensorUtils();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void b()
  {
    if (this.c == null) {
      this.c = BaseApplication.getContext();
    }
    if (this.b == null) {
      this.b = ((SensorManager)this.c.getSystemService("sensor"));
    }
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    if (this.d == null) {
      this.d = ((SensorManager)localObject).getDefaultSensor(4);
    }
    if (this.e == null) {
      this.e = this.b.getDefaultSensor(1);
    }
    if (!this.k)
    {
      this.l = this.b.registerListener(this, this.d, 3);
      this.m = this.b.registerListener(this, this.e, 3);
      this.k = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("register,gyroscopeEnable=");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(" ,accelerometerEnable");
      ((StringBuilder)localObject).append(this.m);
      QLog.d("ReadinjoySensorUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c()
  {
    SensorManager localSensorManager = this.b;
    if (localSensorManager != null) {
      localSensorManager.unregisterListener(this);
    }
    this.k = false;
  }
  
  public double[] d()
  {
    return this.i;
  }
  
  public double[] e()
  {
    return this.g;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int n = paramSensorEvent.sensor.getType();
    if (n != 1)
    {
      if (n != 4) {
        return;
      }
      if (this.j != 0.0F)
      {
        float f7 = (float)paramSensorEvent.timestamp;
        float f8 = this.j;
        float f6 = paramSensorEvent.values[0];
        float f5 = paramSensorEvent.values[1];
        float f4 = paramSensorEvent.values[2];
        double d1 = Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
        float f3 = f6;
        float f2 = f5;
        float f1 = f4;
        if (d1 > 9.999999717180685E-010D)
        {
          d2 = f6;
          Double.isNaN(d2);
          f3 = (float)(d2 / d1);
          d2 = f5;
          Double.isNaN(d2);
          f2 = (float)(d2 / d1);
          d2 = f4;
          Double.isNaN(d2);
          f1 = (float)(d2 / d1);
        }
        double d2 = (f7 - f8) * 1.0E-009F;
        Double.isNaN(d2);
        d2 = d1 * d2 / 2.0D;
        d1 = Math.sin(d2);
        d2 = Math.cos(d2);
        localObject = this.i;
        double d3 = f3;
        Double.isNaN(d3);
        localObject[0] = (d3 * d1);
        d3 = f2;
        Double.isNaN(d3);
        localObject[1] = (d3 * d1);
        d3 = f1;
        Double.isNaN(d3);
        localObject[2] = (d1 * d3);
        localObject[3] = d2;
      }
      this.j = ((float)paramSensorEvent.timestamp);
      return;
    }
    Object localObject = this.f;
    localObject[0] = (localObject[0] * 0.8F + paramSensorEvent.values[0] * 0.2F);
    localObject = this.f;
    localObject[1] = (localObject[1] * 0.8F + paramSensorEvent.values[1] * 0.2F);
    localObject = this.f;
    localObject[2] = (localObject[2] * 0.8F + paramSensorEvent.values[2] * 0.2F);
    this.g[0] = (paramSensorEvent.values[0] - this.f[0]);
    this.g[1] = (paramSensorEvent.values[1] - this.f[1]);
    this.g[2] = (paramSensorEvent.values[2] - this.f[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ReadinjoySensorUtils
 * JD-Core Version:    0.7.0.1
 */