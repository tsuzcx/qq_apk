package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.nearby.profilecard.api.INestScrollHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NestScrollLayout
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private INestScrollHelper jdField_a_of_type_ComTencentMobileqqNearbyProfilecardApiINestScrollHelper;
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
    paramInt = paramContext.getResources().getDimensionPixelSize(2131299168) + ImmersiveUtils.getStatusBarHeight(paramContext);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardApiINestScrollHelper = ((INestScrollHelper)QRoute.api(INestScrollHelper.class));
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
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
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
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      int j = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      int k;
      if (this.jdField_a_of_type_Int == 1)
      {
        if (a())
        {
          k = this.jdField_a_of_type_AndroidWidgetScroller.getFinalY();
          int m = a(this.jdField_a_of_type_AndroidWidgetScroller.getDuration(), this.jdField_a_of_type_AndroidWidgetScroller.timePassed());
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardApiINestScrollHelper.smoothScrollBy(a(), k - j, m);
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          return;
        }
        scrollTo(0, j);
        invalidate();
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardApiINestScrollHelper.isTop())
        {
          k = this.i;
          scrollTo(0, getScrollY() + (j - k));
          if (this.h <= this.g)
          {
            this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
            return;
          }
        }
        invalidate();
      }
      this.i = j;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1 = Math.abs(f3 - this.jdField_a_of_type_Float);
    float f2 = Math.abs(f4 - this.jdField_b_of_type_Float);
    a(paramMotionEvent);
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      int j = 2;
      boolean bool;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k == 3) {
            a();
          }
        }
        else
        {
          this.jdField_d_of_type_Float = (this.jdField_c_of_type_Float - f4);
          this.jdField_c_of_type_Float = f4;
          if ((f1 > this.jdField_c_of_type_Int) && (f1 > 2.0F * f2)) {
            this.jdField_a_of_type_Boolean = false;
          } else if ((f2 > this.jdField_c_of_type_Int) && (f2 > f1)) {
            this.jdField_a_of_type_Boolean = true;
          }
          bool = a();
          if ((this.jdField_a_of_type_Boolean) && (((this.jdField_d_of_type_Float > 0.0F) && (!bool)) || ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardApiINestScrollHelper.isTop()) && (this.jdField_d_of_type_Float < 0.0F))))
          {
            double d1 = this.jdField_d_of_type_Float;
            Double.isNaN(d1);
            scrollBy(0, (int)(d1 + 0.5D));
            invalidate();
            return true;
          }
        }
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if ((this.jdField_d_of_type_Float < 0.0F) || (!a()))
          {
            this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
            f3 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
            if (f3 <= 0.0F) {
              j = 1;
            }
            this.jdField_a_of_type_Int = j;
            this.jdField_a_of_type_AndroidWidgetScroller.fling(0, getScrollY(), 0, -(int)f3, 0, 0, -2147483647, 2147483647);
            this.i = getScrollY();
            invalidate();
          }
          j = this.jdField_c_of_type_Int;
          if (((f1 > j) || (f2 > j)) && (!a()))
          {
            j = paramMotionEvent.getAction();
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            paramMotionEvent.setAction(j);
            return bool;
          }
        }
        a();
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = f3;
      this.jdField_b_of_type_Float = f4;
      this.jdField_c_of_type_Float = f4;
      this.jdField_d_of_type_Float = 0.0F;
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    }
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (!localView.isClickable())) {
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
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
    paramInt2 += k;
    int j = this.f;
    if (paramInt2 >= j)
    {
      paramInt2 = j;
    }
    else
    {
      j = this.g;
      if (paramInt2 <= j) {
        paramInt2 = j;
      }
    }
    super.scrollBy(paramInt1, paramInt2 - k);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int j = this.f;
    if (paramInt2 >= j)
    {
      paramInt2 = j;
    }
    else
    {
      j = this.g;
      if (paramInt2 <= j) {
        paramInt2 = j;
      }
    }
    this.h = paramInt2;
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardApiINestScrollHelper.setPosition(paramInt);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardApiINestScrollHelper.setViewPager(paramViewPager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NestScrollLayout
 * JD-Core Version:    0.7.0.1
 */