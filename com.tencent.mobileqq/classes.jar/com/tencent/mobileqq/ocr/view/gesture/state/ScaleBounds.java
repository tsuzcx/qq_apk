package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.Settings.Fit;
import com.tencent.mobileqq.ocr.view.gesture.utils.MathUtils;

public class ScaleBounds
{
  private static final Matrix a = new Matrix();
  private static final RectF b = new RectF();
  private final Settings c;
  private float d;
  private float e;
  private float f;
  
  public ScaleBounds(Settings paramSettings)
  {
    this.c = paramSettings;
  }
  
  public float a()
  {
    return this.d;
  }
  
  public float a(float paramFloat1, float paramFloat2)
  {
    return MathUtils.a(paramFloat1, this.d / paramFloat2, this.e * paramFloat2);
  }
  
  public ScaleBounds a(State paramState)
  {
    float f5 = this.c.g();
    float f6 = this.c.h();
    float f7 = this.c.e();
    float f8 = this.c.f();
    if ((f5 != 0.0F) && (f6 != 0.0F) && (f7 != 0.0F) && (f8 != 0.0F))
    {
      this.d = this.c.i();
      this.e = this.c.j();
      float f9 = paramState.e();
      float f3 = f5;
      float f1 = f6;
      float f2 = f7;
      float f4 = f8;
      if (!State.c(f9, 0.0F)) {
        if (this.c.q() == Settings.Fit.OUTSIDE)
        {
          a.setRotate(-f9);
          b.set(0.0F, 0.0F, f7, f8);
          a.mapRect(b);
          f2 = b.width();
          f4 = b.height();
          f3 = f5;
          f1 = f6;
        }
        else
        {
          a.setRotate(f9);
          b.set(0.0F, 0.0F, f5, f6);
          a.mapRect(b);
          f3 = b.width();
          f1 = b.height();
          f4 = f8;
          f2 = f7;
        }
      }
      int i = ScaleBounds.1.a[this.c.q().ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              f1 = this.d;
              if (f1 <= 0.0F) {
                f1 = 1.0F;
              }
              this.f = f1;
            }
            else
            {
              this.f = Math.max(f2 / f3, f4 / f1);
            }
          }
          else {
            this.f = Math.min(f2 / f3, f4 / f1);
          }
        }
        else {
          this.f = (f4 / f1);
        }
      }
      else {
        this.f = (f2 / f3);
      }
      if (this.d <= 0.0F) {
        this.d = this.f;
      }
      if (this.e <= 0.0F) {
        this.e = this.f;
      }
      if (this.f > this.e) {
        if (this.c.o()) {
          this.e = this.f;
        } else {
          this.f = this.e;
        }
      }
      f1 = this.d;
      f2 = this.e;
      if (f1 > f2) {
        this.d = f2;
      }
      if (this.f < this.d)
      {
        if (this.c.o())
        {
          this.d = this.f;
          return this;
        }
        this.f = this.d;
      }
      return this;
    }
    this.f = 1.0F;
    this.e = 1.0F;
    this.d = 1.0F;
    return this;
  }
  
  public float b()
  {
    return this.e;
  }
  
  public float c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.state.ScaleBounds
 * JD-Core Version:    0.7.0.1
 */