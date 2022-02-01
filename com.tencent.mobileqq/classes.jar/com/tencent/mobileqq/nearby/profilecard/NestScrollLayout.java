package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NestScrollLayout
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private NestScrollHelper jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollHelper;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int;
  private int e;
  private int f = 0;
  private int g = 0;
  private int h;
  private int i;
  
  public NestScrollLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = paramContext.getResources().getDimensionPixelSize(2131299166) + ImmersiveUtils.getStatusBarHeight(paramContext);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollHelper = new NestScrollHelper();
    paramContext = ViewConfiguration.get(paramContext);
    this.jdField_c_of_type_Int = paramContext.getScaledTouchSlop();
    this.jdField_d_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private int a()
  {
    return (int)this.jdField_a_of_type_AndroidWidgetScroller.getCurrVelocity();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private boolean a()
  {
    return this.h == this.f;
  }
  
  public void computeScroll()
  {
    int j;
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      j = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      if (this.jdField_a_of_type_Int != 1) {
        break label99;
      }
      if (a())
      {
        int k = this.jdField_a_of_type_AndroidWidgetScroller.getFinalY();
        int m = a(this.jdField_a_of_type_AndroidWidgetScroller.getDuration(), this.jdField_a_of_type_AndroidWidgetScroller.timePassed());
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollHelper.a(a(), k - j, m);
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
    }
    else
    {
      return;
    }
    scrollTo(0, j);
    invalidate();
    for (;;)
    {
      this.i = j;
      return;
      label99:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollHelper.a())
      {
        scrollTo(0, j - this.i + getScrollY());
        if (this.h <= this.g)
        {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          return;
        }
      }
      invalidate();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1 = Math.abs(f3 - this.jdField_a_of_type_Float);
    float f2 = Math.abs(f4 - this.jdField_b_of_type_Float);
    a(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = f3;
      this.jdField_b_of_type_Float = f4;
      this.jdField_c_of_type_Float = f4;
      this.jdField_d_of_type_Float = 0.0F;
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      continue;
      this.jdField_d_of_type_Float = (this.jdField_c_of_type_Float - f4);
      this.jdField_c_of_type_Float = f4;
      if ((f1 > this.jdField_c_of_type_Int) && (f1 > 2.0F * f2)) {}
      boolean bool;
      for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true) {
        do
        {
          bool = a();
          if ((!this.jdField_a_of_type_Boolean) || (((this.jdField_d_of_type_Float <= 0.0F) || (bool)) && ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollHelper.a()) || (this.jdField_d_of_type_Float >= 0.0F)))) {
            break;
          }
          scrollBy(0, (int)(this.jdField_d_of_type_Float + 0.5D));
          invalidate();
          return true;
        } while ((f2 <= this.jdField_c_of_type_Int) || (f2 <= f1));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_d_of_type_Float < 0.0F) || (!a()))
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
          f3 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
          if (f3 <= 0.0F) {
            break label401;
          }
        }
        label401:
        for (int j = 2;; j = 1)
        {
          this.jdField_a_of_type_Int = j;
          this.jdField_a_of_type_AndroidWidgetScroller.fling(0, getScrollY(), 0, -(int)f3, 0, 0, -2147483647, 2147483647);
          this.i = getScrollY();
          invalidate();
          if (((f1 <= this.jdField_c_of_type_Int) && (f2 <= this.jdField_c_of_type_Int)) || (a())) {
            break;
          }
          j = paramMotionEvent.getAction();
          paramMotionEvent.setAction(3);
          bool = super.dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(j);
          return bool;
        }
      }
      a();
      continue;
      a();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_AndroidViewView.isClickable())) {
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    measureChildWithMargins(this.jdField_a_of_type_AndroidViewView, paramInt1, 0, 0, 0);
    this.e = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    this.f = (this.e - this.jdField_b_of_type_Int);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + this.f, 1073741824));
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int k = getScrollY();
    int j = k + paramInt2;
    if (j >= this.f) {
      paramInt2 = this.f;
    }
    for (;;)
    {
      super.scrollBy(paramInt1, paramInt2 - k);
      return;
      paramInt2 = j;
      if (j <= this.g) {
        paramInt2 = this.g;
      }
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int j;
    if (paramInt2 >= this.f) {
      j = this.f;
    }
    for (;;)
    {
      this.h = j;
      super.scrollTo(paramInt1, j);
      return;
      j = paramInt2;
      if (paramInt2 <= this.g) {
        j = this.g;
      }
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollHelper.a(paramInt);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollHelper.a(paramViewPager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NestScrollLayout
 * JD-Core Version:    0.7.0.1
 */