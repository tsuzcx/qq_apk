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
import com.tencent.mobileqq.util.DisplayUtil;

public class SlideDownFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private SlideDownFrameLayout.OnSlideListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener;
  private float b = 0.0F;
  
  public SlideDownFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener;
    if (localObject == null) {
      return;
    }
    localObject = ValueAnimator.ofFloat(new float[] { ((SlideDownFrameLayout.OnSlideListener)localObject).a().getY(), 0.0F });
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).addUpdateListener(new SlideDownFrameLayout.1(this));
    ((ValueAnimator)localObject).start();
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener;
    if (localObject == null) {
      return;
    }
    localObject = ValueAnimator.ofFloat(new float[] { ((SlideDownFrameLayout.OnSlideListener)localObject).a().getY(), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener.a().getHeight() });
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).addUpdateListener(new SlideDownFrameLayout.2(this));
    ((ValueAnimator)localObject).addListener(new SlideDownFrameLayout.3(this));
    ((ValueAnimator)localObject).start();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener == null) {
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
      if ((this.jdField_a_of_type_Int == 0) && (f < DisplayUtil.a(getContext(), 5.0F))) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      f = this.b - this.jdField_a_of_type_Float;
      if (Math.abs(f) > 0.0F)
      {
        if ((this.jdField_a_of_type_Int == 0) && (f > 0.0F))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener.a())
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
    if (i == 0)
    {
      this.jdField_a_of_type_Float = this.b;
    }
    else
    {
      Object localObject;
      if (i == 2)
      {
        if (this.jdField_a_of_type_Int == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener;
          if (localObject != null)
          {
            ((SlideDownFrameLayout.OnSlideListener)localObject).a().setY(Math.max(this.b - this.jdField_a_of_type_Float, 0.0F));
            this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener.a(Math.max(this.b - this.jdField_a_of_type_Float, 0.0F), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener.a().getHeight());
          }
          if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
            this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
          }
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          return true;
        }
      }
      else if ((i == 1) || (i == 3))
      {
        if (this.jdField_a_of_type_Int != 0)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener;
          if ((localObject != null) && (this.jdField_a_of_type_AndroidViewVelocityTracker != null))
          {
            float f = ((SlideDownFrameLayout.OnSlideListener)localObject).a().getY();
            this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
            if ((f <= DisplayUtil.a(getContext(), 100.0F)) && ((f <= DisplayUtil.a(getContext(), 30.0F)) || (this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity() <= 1000.0F))) {
              a();
            } else {
              b();
            }
          }
        }
        this.jdField_a_of_type_Int = 0;
        localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
        if (localObject != null)
        {
          ((VelocityTracker)localObject).recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnSlideListener(SlideDownFrameLayout.OnSlideListener paramOnSlideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout$OnSlideListener = paramOnSlideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDownFrameLayout
 * JD-Core Version:    0.7.0.1
 */