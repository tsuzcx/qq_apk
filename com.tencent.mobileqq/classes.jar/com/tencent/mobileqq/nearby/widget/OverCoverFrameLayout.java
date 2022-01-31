package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import avub;
import avuc;
import com.tencent.qphone.base.util.QLog;

public class OverCoverFrameLayout
  extends FrameLayout
{
  protected int a;
  protected Context a;
  protected GestureDetector a;
  protected Scroller a;
  public avuc a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected final int c;
  private boolean c;
  public int d;
  private boolean d;
  public int e;
  protected int f;
  
  public OverCoverFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 200;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  public OverCoverFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 200;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  protected void a()
  {
    if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) && (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) && ((this.jdField_b_of_type_Int == this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Int == 0))) {
      if (this.jdField_a_of_type_Avuc != null)
      {
        if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Int != 0)) {
          break label90;
        }
        this.jdField_a_of_type_Avuc.a(0, 0, this.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      return;
      label90:
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int == this.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_Avuc.a(0, 1, this.jdField_b_of_type_Int);
      }
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new LinearInterpolator());
    this.jdField_d_of_type_Int = ViewConfiguration.getTouchSlop();
    this.e = ViewConfiguration.getMinimumFlingVelocity();
    if (QLog.isColorLevel()) {
      QLog.d("OverCoverFrameLayout", 2, "init: minDis=" + this.jdField_d_of_type_Int + ", minVelocity=" + this.e);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new avub(this));
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OverCoverFrameLayout", 2, "slideUp, isFgViewOnBottom=" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_Int, 0, -this.jdField_a_of_type_Int, 0, 200);
    if (this.jdField_a_of_type_Avuc != null) {
      this.jdField_a_of_type_Avuc.a(1, 0, this.jdField_a_of_type_Int);
    }
    invalidate();
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OverCoverFrameLayout", 2, "slideDown, isFgViewOnBottom=" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, this.jdField_a_of_type_Int, 0, 200);
    if (this.jdField_a_of_type_Avuc != null) {
      this.jdField_a_of_type_Avuc.a(1, 1, 0);
    }
    invalidate();
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      invalidate();
      requestLayout();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int k = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    switch (k)
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("OverCoverFrameLayout", 2, "dispatchTouchEvent, action=" + k + ", ret=" + bool + ", distance=" + i + ", isNeedDetector=" + this.jdField_b_of_type_Boolean + ", mBgViewHeight=" + this.jdField_a_of_type_Int);
      }
      return bool;
      View localView = getChildAt(0);
      if (this.jdField_a_of_type_Boolean) {
        if ((localView != null) && (j <= localView.getHeight())) {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      for (;;)
      {
        this.f = j;
        break;
        this.jdField_b_of_type_Boolean = true;
        continue;
        this.jdField_b_of_type_Boolean = true;
      }
      j -= this.f;
      i = j;
      if (this.jdField_b_of_type_Boolean) {
        if (j > 0)
        {
          i = j;
          if (Math.abs(j) >= (int)(this.jdField_a_of_type_Int * 0.8D)) {
            i = j;
          }
        }
        else
        {
          i = j;
          if (j < 0)
          {
            i = j;
            if (Math.abs(j) >= this.jdField_d_of_type_Int)
            {
              i = j;
              continue;
              this.jdField_b_of_type_Boolean = true;
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView1 = getChildAt(0);
    View localView2 = getChildAt(1);
    localView1.layout(0, 0, localView1.getMeasuredWidth(), localView1.getMeasuredHeight());
    if (localView2 != null)
    {
      localView2.layout(0, this.jdField_b_of_type_Int, localView2.getMeasuredWidth(), getMeasuredHeight());
      a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getChildAt(0).getMeasuredHeight();
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void setOnActionListener(avuc paramavuc)
  {
    this.jdField_a_of_type_Avuc = paramavuc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout
 * JD-Core Version:    0.7.0.1
 */