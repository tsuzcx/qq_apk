package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import bdaq;
import bevk;
import bevl;
import bevm;
import bevn;

public class SlideDownFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private bevn jdField_a_of_type_Bevn;
  private float b;
  
  public SlideDownFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bevn == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_a_of_type_Bevn.a().getY(), 0.0F });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new bevk(this));
    localValueAnimator.start();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bevn == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_a_of_type_Bevn.a().getY(), this.jdField_a_of_type_Bevn.a().getHeight() });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new bevl(this));
    localValueAnimator.addListener(new bevm(this));
    localValueAnimator.start();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bevn == null) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    this.b = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = this.b;
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      float f = Math.abs(this.b - this.jdField_a_of_type_Float);
      if ((this.jdField_a_of_type_Int == 0) && (f < bdaq.a(getContext(), 5.0F))) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      f = this.b - this.jdField_a_of_type_Float;
      if (Math.abs(f) > 0.0F)
      {
        if ((this.jdField_a_of_type_Int == 0) && (f > 0.0F))
        {
          if (this.jdField_a_of_type_Bevn.a())
          {
            this.jdField_a_of_type_Float = this.b;
            this.jdField_a_of_type_Int = 1;
            return true;
          }
          this.jdField_a_of_type_Float = this.b;
          return super.onInterceptTouchEvent(paramMotionEvent);
        }
      }
      else
      {
        this.jdField_a_of_type_Float = this.b;
        this.jdField_a_of_type_Int = 0;
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
    }
    else if ((i == 1) || (i == 3))
    {
      this.jdField_a_of_type_Int = 0;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.b = paramMotionEvent.getY();
    if (i == 0) {
      this.jdField_a_of_type_Float = this.b;
    }
    do
    {
      do
      {
        return super.onTouchEvent(paramMotionEvent);
        if (i != 2) {
          break;
        }
      } while (this.jdField_a_of_type_Int != 1);
      if (this.jdField_a_of_type_Bevn != null)
      {
        this.jdField_a_of_type_Bevn.a().setY(Math.max(this.b - this.jdField_a_of_type_Float, 0.0F));
        this.jdField_a_of_type_Bevn.a(Math.max(this.b - this.jdField_a_of_type_Float, 0.0F), this.jdField_a_of_type_Bevn.a().getHeight());
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      return true;
    } while ((i != 1) && (i != 3));
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Bevn != null) && (this.jdField_a_of_type_AndroidViewVelocityTracker != null))
    {
      float f = this.jdField_a_of_type_Bevn.a().getY();
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      if ((f <= bdaq.a(getContext(), 100.0F)) && ((f <= bdaq.a(getContext(), 30.0F)) || (this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity() <= 1000.0F))) {
        break label262;
      }
      b();
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      break;
      label262:
      a();
    }
  }
  
  public void setOnSlideListener(bevn parambevn)
  {
    this.jdField_a_of_type_Bevn = parambevn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDownFrameLayout
 * JD-Core Version:    0.7.0.1
 */