package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;

public class AccountPanelRootLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private AccountPanelRootLayout.AccountPanelRootLayoutListener jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout$AccountPanelRootLayoutListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public AccountPanelRootLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public AccountPanelRootLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public AccountPanelRootLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private int a()
  {
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if (localView.getVisibility() == 0) {
        k = j + localView.getHeight();
      }
      i += 1;
    }
    return j / 3;
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int i = (int)paramMotionEvent.getRawY();
    int j = (int)paramMotionEvent.getRawX();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int k = paramMotionEvent[0];
    int m = paramMotionEvent[1];
    int n = paramView.getMeasuredWidth();
    int i1 = paramView.getMeasuredHeight();
    return (i >= m) && (i <= i1 + m) && (j >= k) && (j <= n + k);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().heightPixels;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if (a(paramView, paramMotionEvent))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365166);
    }
  }
  
  public float a(float paramFloat)
  {
    int i = (int)(getScrollY() + paramFloat);
    if (i < 0) {
      return paramFloat;
    }
    if (i >= 0)
    {
      AccountPanelRootLayout.AccountPanelRootLayoutListener localAccountPanelRootLayoutListener = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout$AccountPanelRootLayoutListener;
      if (localAccountPanelRootLayoutListener != null) {
        localAccountPanelRootLayoutListener.b();
      }
      return 0 - getScrollY();
    }
    return 0.0F;
  }
  
  @RequiresApi(api=14)
  public void a()
  {
    setScrollY(0);
  }
  
  public void a(int paramInt)
  {
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    if (localScroller != null)
    {
      localScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Boolean = false;
    float f1 = paramMotionEvent.getY();
    float f2 = paramMotionEvent.getX();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          if ((Math.abs(f2 - this.jdField_b_of_type_Float) > 5.0F) || (Math.abs(f1 - this.jdField_a_of_type_Float) > 5.0F)) {
            this.jdField_b_of_type_Boolean = true;
          }
          this.jdField_b_of_type_Float = f2;
          this.jdField_a_of_type_Float = f1;
          return true;
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      return true;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Float = f1;
    this.jdField_b_of_type_Float = f2;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    Object localObject = this.jdField_a_of_type_AndroidWidgetScroller;
    if ((localObject != null) && (((Scroller)localObject).computeScrollOffset()))
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      invalidate();
      return;
    }
    if (this.c)
    {
      this.c = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout$AccountPanelRootLayoutListener;
      if (localObject != null) {
        ((AccountPanelRootLayout.AccountPanelRootLayoutListener)localObject).a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    c();
    if (!b(this.jdField_a_of_type_AndroidViewView, paramMotionEvent)) {
      return a(paramMotionEvent);
    }
    float f2 = paramMotionEvent.getY();
    float f3 = paramMotionEvent.getX();
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          float f1 = -(f2 - this.jdField_a_of_type_Float);
          float f4 = this.jdField_b_of_type_Float;
          this.jdField_a_of_type_Float = f2;
          this.jdField_b_of_type_Float = f3;
          if (((f1 <= 0.0F) || (getScrollY() < 0)) && (Math.abs(f3 - f4) <= Math.abs(f1)) && (this.jdField_a_of_type_AndroidViewView.getScrollY() <= 0))
          {
            f2 = a(f1);
            if ((this.jdField_a_of_type_Boolean) && (f2 != 0.0F)) {
              scrollBy(0, (int)f2);
            } else if (f2 > 0.0F) {
              scrollBy(0, (int)f2);
            }
            if (Math.abs(f1) > 5.0F) {
              this.jdField_b_of_type_Boolean = true;
            }
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout$AccountPanelRootLayoutListener;
            if (paramMotionEvent != null)
            {
              if (getScrollY() > 0) {
                bool = true;
              }
              paramMotionEvent.a(bool);
            }
            return true;
          }
          return super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      if (!this.jdField_b_of_type_Boolean) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < a()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 1)
      {
        a(0);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout$AccountPanelRootLayoutListener != null)
      {
        this.c = true;
        a(-this.jdField_a_of_type_Int);
      }
      return false;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Float = paramMotionEvent.getY();
    this.jdField_b_of_type_Float = paramMotionEvent.getX();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAccountPanelRootLayoutListener(AccountPanelRootLayout.AccountPanelRootLayoutListener paramAccountPanelRootLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout$AccountPanelRootLayoutListener = paramAccountPanelRootLayoutListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout
 * JD-Core Version:    0.7.0.1
 */