package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class HorizontalScrollLayout
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  
  public HorizontalScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_b_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.c = a();
  }
  
  public int a()
  {
    return getResources().getDisplayMetrics().widthPixels;
  }
  
  public void a()
  {
    int i = getScrollX();
    if (i < 0) {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, -i, 0, Math.abs(i) * 1);
    }
    while (this.d >= i)
    {
      invalidate();
      return;
    }
    if (this.d <= 0) {}
    for (i = getScrollX();; i = getScrollX() - this.d)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, -i, 0, Math.abs(i) * 1);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.d <= 0)
      {
        i = -getScrollX();
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
        invalidate();
        return;
      }
      if (this.c + getScrollX() > this.d) {}
      for (i = this.d - getScrollX();; i = this.c) {
        break;
      }
    }
    if (-this.c + getScrollX() > 0) {}
    for (int i = -this.c;; i = getScrollX() * -1)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
      break;
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.jdField_a_of_type_Int != 0)) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (i)
      {
      }
      while (this.jdField_a_of_type_Int == 0)
      {
        return false;
        i = (int)Math.abs(this.jdField_a_of_type_Float - f1);
        int j = (int)Math.abs(this.jdField_b_of_type_Float - f2);
        if ((i > this.jdField_b_of_type_Int) && (i > j))
        {
          this.jdField_a_of_type_Int = 1;
          paramMotionEvent = getParent();
          if (paramMotionEvent != null)
          {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            continue;
            this.jdField_a_of_type_Float = f1;
            this.jdField_b_of_type_Float = f2;
            if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {}
            for (i = 0;; i = 1)
            {
              this.jdField_a_of_type_Int = i;
              break;
            }
            this.jdField_a_of_type_Int = 0;
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (1 <= getChildCount()) {
      this.d = (getChildAt(getChildCount() - 1).getRight() - this.c);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (i)
    {
    default: 
      return true;
    case 0: 
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
      this.jdField_a_of_type_Float = f;
      return true;
    case 2: 
      i = (int)(this.jdField_a_of_type_Float - f);
      this.jdField_a_of_type_Float = f;
      scrollBy(i, 0);
      return true;
    case 1: 
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if (i > 600) {
        a(false);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.jdField_a_of_type_Int = 0;
        return true;
        if (i < -600) {
          a(true);
        } else {
          a();
        }
      }
    }
    a();
    this.jdField_a_of_type_Int = 0;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HorizontalScrollLayout
 * JD-Core Version:    0.7.0.1
 */