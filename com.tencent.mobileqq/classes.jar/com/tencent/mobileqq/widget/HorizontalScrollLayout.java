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
  private int d = 0;
  
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
    if (i < 0)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, -i, 0, Math.abs(i) * 1);
    }
    else
    {
      int j = this.d;
      if (j < i)
      {
        if (j <= 0) {
          i = getScrollX();
        } else {
          i = getScrollX() - this.d;
        }
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, -i, 0, Math.abs(i) * 1);
      }
    }
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      if (this.d <= 0) {
        i = -getScrollX();
      }
      for (;;)
      {
        break;
        i = this.c;
        int j = getScrollX();
        int k = this.d;
        if (i + j > k) {
          i = k - getScrollX();
        } else {
          i = this.c;
        }
      }
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
    }
    else
    {
      if (-this.c + getScrollX() > 0) {
        i = -this.c;
      } else {
        i = getScrollX() * -1;
      }
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
    }
    invalidate();
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
    if ((i == 2) && (this.jdField_a_of_type_Int != 0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label152;
          }
        }
        else
        {
          i = (int)Math.abs(this.jdField_a_of_type_Float - f1);
          int j = (int)Math.abs(this.jdField_b_of_type_Float - f2);
          if ((i <= this.jdField_b_of_type_Int) || (i <= j)) {
            break label152;
          }
          this.jdField_a_of_type_Int = 1;
          paramMotionEvent = getParent();
          if (paramMotionEvent == null) {
            break label152;
          }
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          break label152;
        }
      }
      this.jdField_a_of_type_Int = 0;
    }
    else
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_AndroidWidgetScroller.isFinished() ^ true);
    }
    label152:
    return this.jdField_a_of_type_Int != 0;
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
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          a();
          this.jdField_a_of_type_Int = 0;
          return true;
        }
        i = (int)(this.jdField_a_of_type_Float - f);
        this.jdField_a_of_type_Float = f;
        scrollBy(i, 0);
        return true;
      }
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if (i > 600) {
        a(false);
      } else if (i < -600) {
        a(true);
      } else {
        a();
      }
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      this.jdField_a_of_type_Int = 0;
      return true;
    }
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    }
    this.jdField_a_of_type_Float = f;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HorizontalScrollLayout
 * JD-Core Version:    0.7.0.1
 */