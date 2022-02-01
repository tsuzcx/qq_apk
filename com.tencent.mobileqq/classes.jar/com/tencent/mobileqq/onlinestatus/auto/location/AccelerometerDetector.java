package com.tencent.mobileqq.onlinestatus.auto.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class AccelerometerDetector
  extends StepMovementDetector
{
  private float[] i = new float[3];
  private final int j = 4;
  private float[] k = new float[4];
  private int l = 0;
  private boolean m = false;
  private int n = 0;
  private int o = 0;
  private boolean p = false;
  private float q = 0.0F;
  private float r = 0.0F;
  private long s = 0L;
  private long t = 0L;
  private long u = 0L;
  private float v = 0.0F;
  private float w = 0.0F;
  private final float x = 1.3F;
  private float y = 2.0F;
  private int z = 250;
  
  AccelerometerDetector()
  {
    super(1);
    this.a = "AccelerometerDetector";
  }
  
  private float a(float[] paramArrayOfFloat, int paramInt)
  {
    float f = 0.0F;
    int i1 = 0;
    while (i1 < paramInt)
    {
      f += paramArrayOfFloat[i1];
      i1 += 1;
    }
    f /= 4.0F;
    if (f >= 8.0F) {
      return 4.3F;
    }
    if ((f >= 7.0F) && (f < 8.0F)) {
      return 3.3F;
    }
    if ((f >= 4.0F) && (f < 7.0F)) {
      return 2.3F;
    }
    if ((f >= 3.0F) && (f < 4.0F)) {
      return 2.0F;
    }
    return 1.3F;
  }
  
  private void a(float paramFloat)
  {
    float f1 = this.w;
    if (f1 == 0.0F)
    {
      this.w = paramFloat;
    }
    else if (a(paramFloat, f1))
    {
      this.t = this.s;
      this.u = System.currentTimeMillis();
      long l1 = this.u;
      if ((l1 - this.t >= this.z) && (this.q - this.r >= this.y))
      {
        this.s = l1;
        g();
      }
      l1 = this.u;
      if (l1 - this.t >= this.z)
      {
        f1 = this.q;
        float f2 = this.r;
        if (f1 - f2 >= 1.3F)
        {
          this.s = l1;
          this.y = b(f1 - f2);
        }
      }
    }
    this.w = paramFloat;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    this.p = this.m;
    if (paramFloat1 >= paramFloat2)
    {
      this.m = true;
      this.n += 1;
    }
    else
    {
      this.o = this.n;
      this.n = 0;
      this.m = false;
    }
    if ((!this.m) && (this.p) && ((this.o >= 2) || (paramFloat2 >= 20.0F)))
    {
      this.q = paramFloat2;
      return true;
    }
    if ((!this.p) && (this.m)) {
      this.r = paramFloat2;
    }
    return false;
  }
  
  private float b(float paramFloat)
  {
    float f = this.y;
    int i1 = this.l;
    if (i1 < 4)
    {
      this.k[i1] = paramFloat;
      this.l = (i1 + 1);
      return f;
    }
    f = a(this.k, 4);
    float[] arrayOfFloat = this.k;
    System.arraycopy(arrayOfFloat, 1, arrayOfFloat, 0, 3);
    this.k[3] = paramFloat;
    return f;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    System.arraycopy(paramSensorEvent.values, 0, this.i, 0, 3);
    paramSensorEvent = this.i;
    this.v = ((float)Math.sqrt(paramSensorEvent[0] * paramSensorEvent[0] + paramSensorEvent[1] * paramSensorEvent[1] + paramSensorEvent[2] * paramSensorEvent[2]));
    a(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.AccelerometerDetector
 * JD-Core Version:    0.7.0.1
 */