package com.tencent.mobileqq.businessCard.views;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.qphone.base.util.QLog;

public class BusinessCardViewTouchHandler
{
  static int jdField_a_of_type_Int = -1;
  float jdField_a_of_type_Float;
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  BusinessCardChildView jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardChildView = null;
  BusinessCardView jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView;
  BusinessCardViewScroller jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  int f = jdField_a_of_type_Int;
  int g;
  int h;
  int i;
  private int j;
  
  public BusinessCardViewTouchHandler(Context paramContext, BusinessCardView paramBusinessCardView, BusinessCardViewScroller paramBusinessCardViewScroller)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.g = paramContext.getScaledMinimumFlingVelocity();
    this.h = paramContext.getScaledMaximumFlingVelocity();
    this.i = paramContext.getScaledTouchSlop();
    this.jdField_d_of_type_Float = paramContext.getScaledPagingTouchSlop();
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView = paramBusinessCardView;
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller = paramBusinessCardViewScroller;
  }
  
  MotionEvent a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
    paramMotionEvent.setLocation(0.0F, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a()));
    return paramMotionEvent;
  }
  
  BusinessCardChildView a(int paramInt1, int paramInt2)
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getChildCount() - 1;
    while (k >= 0)
    {
      BusinessCardChildView localBusinessCardChildView = (BusinessCardChildView)this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getChildAt(k);
      if ((localBusinessCardChildView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(paramInt1, paramInt2, localBusinessCardChildView))) {
        return localBusinessCardChildView;
      }
      k -= 1;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
  }
  
  @TargetApi(11)
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getChildCount() > 0) {}
    for (int k = 1; k == 0; k = 0) {
      return false;
    }
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.d();
    boolean bool1;
    if (BusinessCardUtils.a(11)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.jdField_a_of_type_AndroidAnimationObjectAnimator != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()))
      {
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard", 2, "onInterceptTouchEvent hasScrollAnimator:" + bool1 + " wasScrolling:" + bool2);
        }
        if ((!bool2) && (!bool1)) {
          break label180;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      label121:
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        if ((!bool1) && (!this.jdField_a_of_type_Boolean)) {
          break label476;
        }
        return true;
        bool1 = false;
        break;
        label180:
        bool1 = false;
        break label121;
        k = (int)paramMotionEvent.getX();
        this.jdField_d_of_type_Int = k;
        this.jdField_b_of_type_Int = k;
        k = (int)paramMotionEvent.getY();
        this.jdField_e_of_type_Int = k;
        this.jdField_c_of_type_Int = k;
        float f1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.jdField_e_of_type_Int);
        this.jdField_b_of_type_Float = f1;
        this.jdField_a_of_type_Float = f1;
        this.f = paramMotionEvent.getPointerId(0);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardChildView = a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b();
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
        a();
        paramMotionEvent = a(paramMotionEvent);
        this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        paramMotionEvent.recycle();
        continue;
        if (this.f != jdField_a_of_type_Int)
        {
          b();
          MotionEvent localMotionEvent = a(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(localMotionEvent);
          localMotionEvent.recycle();
          int m = paramMotionEvent.findPointerIndex(this.f);
          k = (int)paramMotionEvent.getY(m);
          m = (int)paramMotionEvent.getX(m);
          if (Math.abs(k - this.jdField_c_of_type_Int) > this.i)
          {
            this.jdField_a_of_type_Boolean = true;
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getParent();
            if (paramMotionEvent != null) {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            }
          }
          this.jdField_d_of_type_Int = m;
          this.jdField_e_of_type_Int = k;
          this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.jdField_e_of_type_Int);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
          this.jdField_a_of_type_Boolean = false;
          this.f = jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardChildView = null;
          this.jdField_c_of_type_Float = 0.0F;
          c();
        }
      }
      label476:
      break;
      bool1 = bool2;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  @TargetApi(9)
  public boolean b(MotionEvent paramMotionEvent)
  {
    int m = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getChildCount() > 0) {}
    for (int k = 1; k == 0; k = 0) {
      return false;
    }
    b();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
    case 1: 
    case 6: 
      for (;;)
      {
        return true;
        k = (int)paramMotionEvent.getX();
        this.jdField_d_of_type_Int = k;
        this.jdField_b_of_type_Int = k;
        k = (int)paramMotionEvent.getY();
        this.jdField_e_of_type_Int = k;
        this.jdField_c_of_type_Int = k;
        float f1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.jdField_e_of_type_Int);
        this.jdField_b_of_type_Float = f1;
        this.jdField_a_of_type_Float = f1;
        this.f = paramMotionEvent.getPointerId(0);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardChildView = a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b();
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
        a();
        paramMotionEvent = a(paramMotionEvent);
        this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        paramMotionEvent.recycle();
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getParent();
        if (paramMotionEvent != null) {
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
        }
        this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
        this.j = BusinessCardViewScroller.jdField_c_of_type_Int;
        continue;
        k = paramMotionEvent.getActionIndex();
        this.f = paramMotionEvent.getPointerId(k);
        this.jdField_d_of_type_Int = ((int)paramMotionEvent.getX(k));
        this.jdField_e_of_type_Int = ((int)paramMotionEvent.getY(k));
        this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.jdField_e_of_type_Int);
        this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
        this.j = BusinessCardViewScroller.jdField_c_of_type_Int;
        continue;
        if (this.f != jdField_a_of_type_Int)
        {
          MotionEvent localMotionEvent = a(paramMotionEvent);
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(localMotionEvent);
          localMotionEvent.recycle();
          m = paramMotionEvent.findPointerIndex(this.f);
          k = (int)paramMotionEvent.getX(m);
          m = (int)paramMotionEvent.getY(m);
          int n = Math.abs(m - this.jdField_c_of_type_Int);
          f1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(m);
          float f2 = this.jdField_b_of_type_Float - f1;
          if ((!this.jdField_a_of_type_Boolean) && (n > this.i))
          {
            this.jdField_a_of_type_Boolean = true;
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.getParent();
            if (paramMotionEvent != null) {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            }
          }
          f1 = f2;
          if (this.jdField_a_of_type_Boolean)
          {
            float f3 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
            float f4 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b(f3 + f2);
            f1 = f2;
            if (Float.compare(f4, 0.0F) != 0) {
              f1 = f2 * (1.0F - Math.min(0.0875F, f4) / 0.0875F);
            }
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(f3 + f1);
          }
          this.jdField_d_of_type_Int = k;
          this.jdField_e_of_type_Int = m;
          this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.jdField_e_of_type_Int);
          f2 = this.jdField_c_of_type_Float;
          this.jdField_c_of_type_Float = (Math.abs(f1) + f2);
          f1 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a() - this.jdField_e_of_type_Float;
          if (f1 > 0.05F) {
            this.j = BusinessCardViewScroller.jdField_a_of_type_Int;
          }
          for (;;)
          {
            this.jdField_e_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
            break;
            if (f1 < -0.05F) {
              this.j = BusinessCardViewScroller.jdField_b_of_type_Int;
            } else {
              this.j = BusinessCardViewScroller.jdField_c_of_type_Int;
            }
          }
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.h);
          k = (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(this.f);
          if ((this.jdField_a_of_type_Boolean) && (Math.abs(k) > this.g))
          {
            m = (int)(Math.min(1.0F, Math.abs(k / this.h)) * 96.0F);
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.jdField_a_of_type_AndroidWidgetOverScroller.fling(0, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a()), 0, k, 0, 0, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().jdField_a_of_type_Float), this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().jdField_b_of_type_Float), 0, m + 32);
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.c();
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.invalidate();
          }
          for (;;)
          {
            this.f = jdField_a_of_type_Int;
            this.jdField_a_of_type_Boolean = false;
            this.jdField_c_of_type_Float = 0.0F;
            c();
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b())
            {
              this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.j);
              this.j = BusinessCardViewScroller.jdField_c_of_type_Int;
            }
          }
          n = paramMotionEvent.getActionIndex();
          if (paramMotionEvent.getPointerId(n) == this.f)
          {
            k = m;
            if (n == 0) {
              k = 1;
            }
            this.f = paramMotionEvent.getPointerId(k);
            this.jdField_d_of_type_Int = ((int)paramMotionEvent.getX(k));
            this.jdField_e_of_type_Int = ((int)paramMotionEvent.getY(k));
            this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a().a(this.jdField_e_of_type_Int);
            this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.b()) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
    }
    for (;;)
    {
      this.f = jdField_a_of_type_Int;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Float = 0.0F;
      c();
      break;
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a(this.j);
      this.j = BusinessCardViewScroller.jdField_c_of_type_Int;
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  @TargetApi(12)
  public boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if ((paramMotionEvent.getSource() & 0x2) == 2) {}
    boolean bool1;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!BusinessCardUtils.a(12));
        if (paramMotionEvent.getAxisValue(9) <= 0.0F) {
          break;
        }
        bool1 = bool2;
      } while (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a());
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(true, false);
      return true;
      bool1 = bool2;
    } while (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a());
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(false, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.BusinessCardViewTouchHandler
 * JD-Core Version:    0.7.0.1
 */