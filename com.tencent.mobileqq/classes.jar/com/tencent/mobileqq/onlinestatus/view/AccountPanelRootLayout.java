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
import aytd;

public class AccountPanelRootLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 2;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private aytd jdField_a_of_type_Aytd;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
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
    if (paramView == null) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    do
    {
      return false;
      i = (int)paramMotionEvent.getRawY();
      j = (int)paramMotionEvent.getRawX();
      paramMotionEvent = new int[2];
      paramView.getLocationOnScreen(paramMotionEvent);
      k = paramMotionEvent[0];
      m = paramMotionEvent[1];
      n = paramView.getMeasuredWidth();
      i1 = paramView.getMeasuredHeight();
    } while ((i < m) || (i > i1 + m) || (j < k) || (j > n + k));
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    this.jdField_b_of_type_Int = getResources().getDisplayMetrics().heightPixels;
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
      this.jdField_a_of_type_AndroidViewView = findViewById(2131364996);
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
      if (this.jdField_a_of_type_Aytd != null) {
        this.jdField_a_of_type_Aytd.b();
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
    if (this.jdField_a_of_type_AndroidWidgetScroller != null)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    this.jdField_a_of_type_Boolean = false;
    float f1 = paramMotionEvent.getY();
    float f2 = paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((Math.abs(f2 - this.jdField_b_of_type_Float) > 5.0F) || (Math.abs(f1 - this.jdField_a_of_type_Float) > 5.0F)) {
        this.jdField_b_of_type_Boolean = true;
      }
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Float = f1;
      return true;
    } while (this.jdField_b_of_type_Boolean);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.jdField_a_of_type_AndroidWidgetScroller != null) && (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()))
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      invalidate();
    }
    do
    {
      do
      {
        return;
      } while (!this.c);
      this.c = false;
    } while (this.jdField_a_of_type_Aytd == null);
    this.jdField_a_of_type_Aytd.b(this.jdField_a_of_type_Int);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    c();
    if (!b(this.jdField_a_of_type_AndroidViewView, paramMotionEvent))
    {
      bool1 = a(paramMotionEvent);
      return bool1;
    }
    float f2 = paramMotionEvent.getY();
    float f3 = paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      return super.dispatchTouchEvent(paramMotionEvent);
      float f1 = -(f2 - this.jdField_a_of_type_Float);
      float f4 = this.jdField_b_of_type_Float;
      this.jdField_a_of_type_Float = f2;
      this.jdField_b_of_type_Float = f3;
      if (((f1 > 0.0F) && (getScrollY() >= 0)) || (Math.abs(f3 - f4) > Math.abs(f1)) || (this.jdField_a_of_type_AndroidViewView.getScrollY() > 0)) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      f2 = a(f1);
      if ((this.jdField_a_of_type_Boolean) && (f2 != 0.0F)) {
        scrollBy(0, (int)f2);
      }
      for (;;)
      {
        if (Math.abs(f1) > 5.0F) {
          this.jdField_b_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_Aytd == null) {
          break;
        }
        paramMotionEvent = this.jdField_a_of_type_Aytd;
        bool1 = bool2;
        if (getScrollY() > 0) {
          bool1 = true;
        }
        paramMotionEvent.a(bool1);
        return true;
        if (f2 > 0.0F) {
          scrollBy(0, (int)f2);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      if (!this.jdField_b_of_type_Boolean) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < a()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 1) {
          break label332;
        }
        a(0);
        break;
      }
      label332:
      if (this.jdField_a_of_type_Aytd != null)
      {
        this.c = true;
        a(-this.jdField_b_of_type_Int);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAccountPanelRootLayoutListener(aytd paramaytd)
  {
    this.jdField_a_of_type_Aytd = paramaytd;
  }
  
  public void setMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout
 * JD-Core Version:    0.7.0.1
 */