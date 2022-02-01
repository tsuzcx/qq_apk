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
import com.tencent.qphone.base.util.QLog;

public class OverCoverFrameLayout
  extends FrameLayout
{
  protected int a;
  protected Context a;
  protected GestureDetector a;
  protected Scroller a;
  protected OverCoverFrameLayout.OnActionListener a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected final int c;
  private boolean c;
  protected int d;
  private boolean d;
  protected int e;
  protected int f = 0;
  
  public OverCoverFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 200;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  public OverCoverFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 200;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  protected void a()
  {
    if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) && (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()))
    {
      int i = this.jdField_b_of_type_Int;
      if ((i == this.jdField_a_of_type_Int) || (i == 0))
      {
        OverCoverFrameLayout.OnActionListener localOnActionListener = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener;
        if (localOnActionListener != null)
        {
          if (this.jdField_c_of_type_Boolean)
          {
            i = this.jdField_b_of_type_Int;
            if (i == 0)
            {
              localOnActionListener.a(0, 0, i);
              break label112;
            }
          }
          if (this.jdField_d_of_type_Boolean)
          {
            i = this.jdField_b_of_type_Int;
            if (i == this.jdField_a_of_type_Int) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener.a(0, 1, i);
            }
          }
        }
        label112:
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
      }
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new LinearInterpolator());
    this.jdField_d_of_type_Int = ViewConfiguration.getTouchSlop();
    this.e = ViewConfiguration.getMinimumFlingVelocity();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init: minDis=");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append(", minVelocity=");
      localStringBuilder.append(this.e);
      QLog.d("OverCoverFrameLayout", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new OverCoverFrameLayout.1(this));
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("slideUp, isFgViewOnBottom=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("OverCoverFrameLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidWidgetScroller;
    int i = this.jdField_a_of_type_Int;
    ((Scroller)localObject).startScroll(i, 0, -i, 0, 200);
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener;
    if (localObject != null) {
      ((OverCoverFrameLayout.OnActionListener)localObject).a(1, 0, this.jdField_a_of_type_Int);
    }
    invalidate();
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("slideDown, isFgViewOnBottom=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("OverCoverFrameLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, this.jdField_a_of_type_Int, 0, 200);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener;
    if (localObject != null) {
      ((OverCoverFrameLayout.OnActionListener)localObject).a(1, 1, 0);
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
    int k = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    int i = 0;
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            break label191;
          }
        }
        else
        {
          j -= this.f;
          i = j;
          if (!this.jdField_b_of_type_Boolean) {
            break label191;
          }
          if (j > 0)
          {
            Math.abs(j);
            double d1 = this.jdField_a_of_type_Int;
            Double.isNaN(d1);
            i = (int)(d1 * 0.8D);
            i = j;
            break label191;
          }
          i = j;
          if (j >= 0) {
            break label191;
          }
          Math.abs(j);
          i = this.jdField_d_of_type_Int;
          i = j;
          break label191;
        }
      }
      this.jdField_b_of_type_Boolean = true;
    }
    else
    {
      View localView = getChildAt(0);
      if (this.jdField_a_of_type_Boolean)
      {
        if ((localView != null) && (j <= localView.getHeight())) {
          this.jdField_b_of_type_Boolean = false;
        } else {
          this.jdField_b_of_type_Boolean = true;
        }
      }
      else {
        this.jdField_b_of_type_Boolean = true;
      }
      this.f = j;
    }
    label191:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("dispatchTouchEvent, action=");
      paramMotionEvent.append(k);
      paramMotionEvent.append(", ret=");
      paramMotionEvent.append(bool);
      paramMotionEvent.append(", distance=");
      paramMotionEvent.append(i);
      paramMotionEvent.append(", isNeedDetector=");
      paramMotionEvent.append(this.jdField_b_of_type_Boolean);
      paramMotionEvent.append(", mBgViewHeight=");
      paramMotionEvent.append(this.jdField_a_of_type_Int);
      QLog.d("OverCoverFrameLayout", 2, paramMotionEvent.toString());
    }
    return bool;
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
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        return;
      }
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public void setOnActionListener(OverCoverFrameLayout.OnActionListener paramOnActionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener = paramOnActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout
 * JD-Core Version:    0.7.0.1
 */