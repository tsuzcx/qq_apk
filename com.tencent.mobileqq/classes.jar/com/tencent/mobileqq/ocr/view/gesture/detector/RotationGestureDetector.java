package com.tencent.mobileqq.ocr.view.gesture.detector;

import android.content.Context;
import android.view.MotionEvent;

public class RotationGestureDetector
{
  private final RotationGestureDetector.OnRotationGestureListener a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private boolean g;
  private boolean h;
  
  public RotationGestureDetector(Context paramContext, RotationGestureDetector.OnRotationGestureListener paramOnRotationGestureListener)
  {
    this.a = paramOnRotationGestureListener;
  }
  
  private float b(MotionEvent paramMotionEvent)
  {
    return (float)Math.toDegrees(Math.atan2(paramMotionEvent.getY(1) - paramMotionEvent.getY(0), paramMotionEvent.getX(1) - paramMotionEvent.getX(0)));
  }
  
  private void d()
  {
    if (!this.g)
    {
      if (Math.abs(this.d - this.e) < 5.0F) {
        return;
      }
      this.g = true;
      this.h = this.a.b(this);
    }
  }
  
  private void e()
  {
    if (!this.g) {
      return;
    }
    this.g = false;
    if (this.h)
    {
      this.a.c(this);
      this.h = false;
    }
  }
  
  private boolean f()
  {
    return (this.g) && (this.h) && (this.a.a(this));
  }
  
  public float a()
  {
    return this.b;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((i != 0) && (i != 1))
    {
      float f1;
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5)
          {
            if (i != 6) {
              return true;
            }
            if (paramMotionEvent.getPointerCount() != 2) {
              break label195;
            }
            e();
            return true;
          }
          if (paramMotionEvent.getPointerCount() != 2) {
            break label195;
          }
          f1 = b(paramMotionEvent);
          this.e = f1;
          this.f = f1;
          this.d = f1;
          return true;
        }
      }
      else
      {
        if ((paramMotionEvent.getPointerCount() < 2) || ((this.g) && (!this.h))) {
          break label195;
        }
        this.e = b(paramMotionEvent);
        f1 = paramMotionEvent.getX(1);
        i = 0;
        this.b = ((f1 + paramMotionEvent.getX(0)) * 0.5F);
        this.c = ((paramMotionEvent.getY(1) + paramMotionEvent.getY(0)) * 0.5F);
        boolean bool = this.g;
        d();
        if ((!bool) || (f())) {
          i = 1;
        }
        if (i == 0) {
          break label195;
        }
        this.f = this.e;
        return true;
      }
    }
    e();
    label195:
    return true;
  }
  
  public float b()
  {
    return this.c;
  }
  
  public float c()
  {
    return this.e - this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.detector.RotationGestureDetector
 * JD-Core Version:    0.7.0.1
 */