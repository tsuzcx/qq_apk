package com.tencent.mobileqq.winkpublish.widget.multitouchimg;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class CustomGestureDetector
{
  private int a = -1;
  private int b = 0;
  private final ScaleGestureDetector c;
  private VelocityTracker d;
  private boolean e;
  private float f;
  private float g;
  private final float h;
  private final float i;
  private OnGestureListener j;
  private OnScaleBeginListener k;
  private OnScaleEndListener l;
  
  public CustomGestureDetector(Context paramContext, OnGestureListener paramOnGestureListener)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.i = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.h = localViewConfiguration.getScaledTouchSlop();
    this.j = paramOnGestureListener;
    this.c = new ScaleGestureDetector(paramContext, new CustomGestureDetector.1(this));
  }
  
  private float b(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getX(this.b);
      return f1;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getX();
  }
  
  private float c(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getY(this.b);
      return f1;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getY();
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    VelocityTracker localVelocityTracker;
    if (m != 0)
    {
      float f1;
      float f2;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m == 6)
            {
              m = Util.a(paramMotionEvent.getAction());
              if (paramMotionEvent.getPointerId(m) == this.a)
              {
                if (m == 0) {
                  m = 1;
                } else {
                  m = 0;
                }
                this.a = paramMotionEvent.getPointerId(m);
                this.f = paramMotionEvent.getX(m);
                this.g = paramMotionEvent.getY(m);
              }
            }
          }
          else
          {
            this.a = -1;
            localVelocityTracker = this.d;
            if (localVelocityTracker != null)
            {
              localVelocityTracker.recycle();
              this.d = null;
            }
          }
        }
        else
        {
          f1 = b(paramMotionEvent);
          f2 = c(paramMotionEvent);
          m = paramMotionEvent.getPointerCount();
          float f3 = f1 - this.f;
          float f4 = f2 - this.g;
          if (!this.e)
          {
            boolean bool;
            if (Math.sqrt(f3 * f3 + f4 * f4) >= this.h) {
              bool = true;
            } else {
              bool = false;
            }
            this.e = bool;
          }
          if (m > 1) {
            this.e = false;
          }
          if (this.e)
          {
            this.f = f1;
            this.g = f2;
            localVelocityTracker = this.d;
            if (localVelocityTracker != null) {
              localVelocityTracker.addMovement(paramMotionEvent);
            }
          }
        }
      }
      else
      {
        this.a = -1;
        if ((this.e) && (this.d != null))
        {
          this.f = b(paramMotionEvent);
          this.g = c(paramMotionEvent);
          this.d.addMovement(paramMotionEvent);
          this.d.computeCurrentVelocity(1000);
          f1 = this.d.getXVelocity();
          f2 = this.d.getYVelocity();
          if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.i) {
            this.j.a(this.f, this.g, -f1, -f2);
          }
        }
        localVelocityTracker = this.d;
        if (localVelocityTracker != null)
        {
          localVelocityTracker.recycle();
          this.d = null;
        }
      }
    }
    else
    {
      this.a = paramMotionEvent.getPointerId(0);
      this.d = VelocityTracker.obtain();
      localVelocityTracker = this.d;
      if (localVelocityTracker != null) {
        localVelocityTracker.addMovement(paramMotionEvent);
      }
      this.f = b(paramMotionEvent);
      this.g = c(paramMotionEvent);
      this.e = false;
    }
    m = this.a;
    if (m == -1) {
      m = 0;
    }
    this.b = paramMotionEvent.findPointerIndex(m);
    return true;
  }
  
  public void a(OnScaleBeginListener paramOnScaleBeginListener)
  {
    this.k = paramOnScaleBeginListener;
  }
  
  public void a(OnScaleEndListener paramOnScaleEndListener)
  {
    this.l = paramOnScaleEndListener;
  }
  
  public boolean a()
  {
    return this.c.isInProgress();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    try
    {
      boolean bool3 = this.c.onTouchEvent(paramMotionEvent);
      boolean bool4 = d(paramMotionEvent);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public boolean b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.multitouchimg.CustomGestureDetector
 * JD-Core Version:    0.7.0.1
 */