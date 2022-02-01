package com.tencent.mobileqq.ocr.view.gesture.detector;

import android.content.Context;
import android.view.MotionEvent;

public class RotationGestureDetector
{
  private float jdField_a_of_type_Float;
  private final RotationGestureDetector.OnRotationGestureListener jdField_a_of_type_ComTencentMobileqqOcrViewGestureDetectorRotationGestureDetector$OnRotationGestureListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  private float d;
  private float e;
  
  public RotationGestureDetector(Context paramContext, RotationGestureDetector.OnRotationGestureListener paramOnRotationGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureDetectorRotationGestureDetector$OnRotationGestureListener = paramOnRotationGestureListener;
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    return (float)Math.toDegrees(Math.atan2(paramMotionEvent.getY(1) - paramMotionEvent.getY(0), paramMotionEvent.getX(1) - paramMotionEvent.getX(0)));
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (Math.abs(this.c - this.d) < 5.0F) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureDetectorRotationGestureDetector$OnRotationGestureListener.b(this);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureDetectorRotationGestureDetector$OnRotationGestureListener.a(this));
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureDetectorRotationGestureDetector$OnRotationGestureListener.a(this);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((i != 0) && (i != 1))
    {
      float f;
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
            b();
            return true;
          }
          if (paramMotionEvent.getPointerCount() != 2) {
            break label195;
          }
          f = a(paramMotionEvent);
          this.d = f;
          this.e = f;
          this.c = f;
          return true;
        }
      }
      else
      {
        if ((paramMotionEvent.getPointerCount() < 2) || ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))) {
          break label195;
        }
        this.d = a(paramMotionEvent);
        f = paramMotionEvent.getX(1);
        i = 0;
        this.jdField_a_of_type_Float = ((f + paramMotionEvent.getX(0)) * 0.5F);
        this.jdField_b_of_type_Float = ((paramMotionEvent.getY(1) + paramMotionEvent.getY(0)) * 0.5F);
        boolean bool = this.jdField_a_of_type_Boolean;
        a();
        if ((!bool) || (a())) {
          i = 1;
        }
        if (i == 0) {
          break label195;
        }
        this.e = this.d;
        return true;
      }
    }
    b();
    label195:
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public float c()
  {
    return this.d - this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.detector.RotationGestureDetector
 * JD-Core Version:    0.7.0.1
 */