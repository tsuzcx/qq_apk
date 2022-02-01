package com.tencent.tavcut.view.ext;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.tencent.tavcut.view.TAVCutImageViewKt;

public class TAVGestureDetector
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = null;
  private final ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private OnGestureListener jdField_a_of_type_ComTencentTavcutViewExtOnGestureListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private final float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private final float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  private float j = 0.0F;
  private float k = 0.0F;
  private float l = 0.0F;
  
  public TAVGestureDetector(Context paramContext, OnGestureListener paramOnGestureListener)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_d_of_type_Float = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.jdField_c_of_type_Float = localViewConfiguration.getScaledTouchSlop();
    this.jdField_a_of_type_ComTencentTavcutViewExtOnGestureListener = paramOnGestureListener;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new TAVGestureDetector.1(this));
  }
  
  private float a(double paramDouble1, double paramDouble2)
  {
    float f1 = (float)(paramDouble2 % 360.0D);
    float f2 = (float)(paramDouble1 % 360.0D) - f1;
    if (f2 < -180.0F) {
      return f2 + 360.0F;
    }
    f1 = f2;
    if (f2 > 180.0F) {
      f1 = f2 - 360.0F;
    }
    return f1;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramFloat5 = (float)Math.atan2(paramFloat6 - paramFloat8, paramFloat5 - paramFloat7);
    paramFloat1 = (float)Math.atan2(paramFloat2 - paramFloat4, paramFloat1 - paramFloat3);
    return a(Math.toDegrees(paramFloat5), Math.toDegrees(paramFloat1));
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getX(this.jdField_b_of_type_Int);
      return f1;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getX();
  }
  
  private float b(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getY(this.jdField_b_of_type_Int);
      return f1;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getY();
  }
  
  private boolean b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    int n = 0;
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
            if (m != 5)
            {
              if (m == 6)
              {
                this.jdField_d_of_type_Int = -1;
                if (!this.jdField_d_of_type_Boolean)
                {
                  m = Util.a(paramMotionEvent.getAction());
                  if (paramMotionEvent.getPointerId(m) == this.jdField_a_of_type_Int)
                  {
                    if (m == 0) {
                      m = 1;
                    } else {
                      m = 0;
                    }
                    this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(m);
                    this.jdField_a_of_type_Float = paramMotionEvent.getX(m);
                    this.jdField_b_of_type_Float = paramMotionEvent.getY(m);
                  }
                }
              }
            }
            else if (!this.jdField_d_of_type_Boolean)
            {
              this.f = paramMotionEvent.getX();
              this.g = paramMotionEvent.getY();
              this.j = ((this.f + this.h) / 2.0F);
              this.k = ((this.g + this.i) / 2.0F);
              this.jdField_d_of_type_Int = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.l = 0.0F;
            }
          }
          else
          {
            this.jdField_c_of_type_Int = -1;
            this.jdField_d_of_type_Int = -1;
            this.jdField_a_of_type_Int = -1;
            this.jdField_d_of_type_Boolean = false;
            localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
            if (localVelocityTracker != null)
            {
              localVelocityTracker.recycle();
              this.jdField_a_of_type_AndroidViewVelocityTracker = null;
            }
          }
        }
        else
        {
          float f3 = a(paramMotionEvent);
          f1 = b(paramMotionEvent);
          f2 = f3 - this.jdField_a_of_type_Float;
          float f4 = f1 - this.jdField_b_of_type_Float;
          if (!this.jdField_a_of_type_Boolean)
          {
            if (Math.sqrt(f2 * f2 + f4 * f4) >= this.jdField_c_of_type_Float) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            this.jdField_a_of_type_Boolean = paramBoolean;
          }
          m = this.jdField_c_of_type_Int;
          if ((m != -1) && (this.jdField_d_of_type_Int != -1))
          {
            f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(m));
            f2 = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.jdField_c_of_type_Int));
            f3 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.jdField_d_of_type_Int));
            f4 = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.jdField_d_of_type_Int));
            if (this.jdField_c_of_type_Boolean)
            {
              this.l = 0.0F;
              this.jdField_c_of_type_Boolean = false;
              this.jdField_b_of_type_Boolean = true;
            }
            else
            {
              this.l = a(this.f, this.g, this.h, this.i, f3, f4, f1, f2);
              if (Float.compare(this.l, 0.0F) != 0) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              }
              this.jdField_b_of_type_Boolean = paramBoolean;
            }
            if (Math.abs(this.l) <= 10.0F) {
              this.jdField_a_of_type_ComTencentTavcutViewExtOnGestureListener.b(this.h, this.i, this.l);
            }
            this.f = f3;
            this.g = f4;
            this.h = f1;
            this.i = f2;
          }
          else if (this.jdField_d_of_type_Boolean)
          {
            if (this.jdField_c_of_type_Boolean)
            {
              this.l = 0.0F;
              this.jdField_c_of_type_Boolean = false;
              this.jdField_b_of_type_Boolean = true;
            }
            else
            {
              f4 = this.jdField_a_of_type_AndroidGraphicsPointF.x;
              float f5 = this.jdField_a_of_type_AndroidGraphicsPointF.y;
              float f6 = this.jdField_a_of_type_Float;
              float f7 = this.jdField_b_of_type_Float;
              float f8 = this.jdField_a_of_type_AndroidGraphicsPointF.x;
              float f9 = this.jdField_a_of_type_AndroidGraphicsPointF.y;
              f2 = f1;
              this.l = a(f4, f5, f6, f7, f8, f9, f3, f1);
              if (Float.compare(this.l, 0.0F) != 0) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              }
              this.jdField_b_of_type_Boolean = paramBoolean;
              double d1 = TAVCutImageViewKt.a(this.jdField_a_of_type_AndroidGraphicsPointF, new PointF(f3, f2));
              double d2 = this.e;
              Double.isNaN(d2);
              if (d1 >= d2 * 0.25D)
              {
                f2 = TAVCutImageViewKt.a(this.jdField_a_of_type_AndroidGraphicsPointF, new PointF(f3, f2)) / TAVCutImageViewKt.a(this.jdField_a_of_type_AndroidGraphicsPointF, new PointF(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float));
                this.jdField_a_of_type_ComTencentTavcutViewExtOnGestureListener.a(f2, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
              }
              this.jdField_a_of_type_ComTencentTavcutViewExtOnGestureListener.b(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, this.l);
            }
            this.jdField_a_of_type_Float = f3;
            this.jdField_b_of_type_Float = f1;
          }
          else if (this.jdField_a_of_type_Boolean)
          {
            if ((Math.abs(f2) < this.jdField_c_of_type_Float * 5.0F) && (Math.abs(f4) < this.jdField_c_of_type_Float * 5.0F)) {
              this.jdField_a_of_type_ComTencentTavcutViewExtOnGestureListener.a(f2, f4);
            }
            this.jdField_a_of_type_Float = f3;
            this.jdField_b_of_type_Float = f1;
            localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
            if (localVelocityTracker != null) {
              localVelocityTracker.addMovement(paramMotionEvent);
            }
          }
        }
      }
      else
      {
        this.jdField_c_of_type_Int = -1;
        this.jdField_a_of_type_Int = -1;
        this.jdField_d_of_type_Boolean = false;
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewVelocityTracker != null))
        {
          this.jdField_a_of_type_Float = a(paramMotionEvent);
          this.jdField_b_of_type_Float = b(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
          f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
          f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
          if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.jdField_d_of_type_Float) {
            this.jdField_a_of_type_ComTencentTavcutViewExtOnGestureListener.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, -f1, -f2);
          }
        }
        localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
        if (localVelocityTracker != null)
        {
          localVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
      }
    }
    else
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_c_of_type_Int = paramMotionEvent.getPointerId(0);
      this.h = paramMotionEvent.getX();
      this.i = paramMotionEvent.getY();
      this.l = 0.0F;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.addMovement(paramMotionEvent);
      }
      this.jdField_a_of_type_Float = a(paramMotionEvent);
      this.jdField_b_of_type_Float = b(paramMotionEvent);
      this.jdField_a_of_type_Boolean = false;
    }
    int i1 = this.jdField_a_of_type_Int;
    m = n;
    if (i1 != -1) {
      m = i1;
    }
    this.jdField_b_of_type_Int = paramMotionEvent.findPointerIndex(m);
    return true;
  }
  
  public void a(PointF paramPointF, float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = paramPointF;
    this.e = paramFloat;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress();
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      paramBoolean = b(paramMotionEvent, paramBoolean);
      return paramBoolean;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      label18:
      break label18;
    }
    return true;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.ext.TAVGestureDetector
 * JD-Core Version:    0.7.0.1
 */