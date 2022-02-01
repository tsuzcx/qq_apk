package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public class StateScroller
{
  private final Interpolator a = new AccelerateDecelerateInterpolator();
  private boolean b = true;
  private float c;
  private float d;
  private float e;
  private long f;
  private long g = 250L;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat3;
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.b = false;
    this.f = SystemClock.elapsedRealtime();
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat1;
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public boolean b()
  {
    if (this.b) {
      return false;
    }
    long l1 = SystemClock.elapsedRealtime() - this.f;
    long l2 = this.g;
    if (l1 >= l2)
    {
      this.b = true;
      this.e = this.d;
      return false;
    }
    float f1 = this.a.getInterpolation((float)l1 / (float)l2);
    this.e = a(this.c, this.d, f1);
    return true;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public float d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.animation.StateScroller
 * JD-Core Version:    0.7.0.1
 */