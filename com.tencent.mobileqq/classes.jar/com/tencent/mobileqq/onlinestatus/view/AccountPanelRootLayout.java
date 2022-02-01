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
  private float a = 0.0F;
  private float b = 0.0F;
  private boolean c = false;
  private boolean d = false;
  private Scroller e;
  private AccountPanelRootLayout.AccountPanelRootLayoutListener f;
  private int g = 0;
  private boolean h = false;
  private View i;
  
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
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int j = (int)paramMotionEvent.getRawY();
    int k = (int)paramMotionEvent.getRawX();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int m = paramMotionEvent[0];
    int n = paramMotionEvent[1];
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    return (j >= n) && (j <= i2 + n) && (k >= m) && (k <= i1 + m);
  }
  
  private void b()
  {
    this.e = new Scroller(getContext());
    this.g = getResources().getDisplayMetrics().heightPixels;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.c) {
      return true;
    }
    if (a(paramView, paramMotionEvent))
    {
      this.c = true;
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (this.i == null) {
      this.i = findViewById(2131431319);
    }
  }
  
  private int getMaxScrollDistance()
  {
    int j = 0;
    int m;
    for (int k = 0; j < getChildCount(); k = m)
    {
      View localView = getChildAt(j);
      m = k;
      if (localView.getVisibility() == 0) {
        m = k + localView.getHeight();
      }
      j += 1;
    }
    return k / 3;
  }
  
  public float a(float paramFloat)
  {
    int j = (int)(getScrollY() + paramFloat);
    if (j < 0) {
      return paramFloat;
    }
    if (j >= 0)
    {
      AccountPanelRootLayout.AccountPanelRootLayoutListener localAccountPanelRootLayoutListener = this.f;
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
    Scroller localScroller = this.e;
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
    this.c = false;
    float f1 = paramMotionEvent.getY();
    float f2 = paramMotionEvent.getX();
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            return false;
          }
        }
        else
        {
          if ((Math.abs(f2 - this.b) > 5.0F) || (Math.abs(f1 - this.a) > 5.0F)) {
            this.d = true;
          }
          this.b = f2;
          this.a = f1;
          return true;
        }
      }
      if (!this.d) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      return true;
    }
    this.d = false;
    this.a = f1;
    this.b = f2;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    Object localObject = this.e;
    if ((localObject != null) && (((Scroller)localObject).computeScrollOffset()))
    {
      scrollTo(this.e.getCurrX(), this.e.getCurrY());
      invalidate();
      return;
    }
    if (this.h)
    {
      this.h = false;
      localObject = this.f;
      if (localObject != null) {
        ((AccountPanelRootLayout.AccountPanelRootLayoutListener)localObject).a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    c();
    if (!b(this.i, paramMotionEvent)) {
      return a(paramMotionEvent);
    }
    float f2 = paramMotionEvent.getY();
    float f3 = paramMotionEvent.getX();
    int j = paramMotionEvent.getAction();
    boolean bool = false;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            return false;
          }
        }
        else
        {
          float f1 = -(f2 - this.a);
          float f4 = this.b;
          this.a = f2;
          this.b = f3;
          if (((f1 <= 0.0F) || (getScrollY() < 0)) && (Math.abs(f3 - f4) <= Math.abs(f1)) && (this.i.getScrollY() <= 0))
          {
            f2 = a(f1);
            if ((this.c) && (f2 != 0.0F)) {
              scrollBy(0, (int)f2);
            } else if (f2 > 0.0F) {
              scrollBy(0, (int)f2);
            }
            if (Math.abs(f1) > 5.0F) {
              this.d = true;
            }
            paramMotionEvent = this.f;
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
      this.c = false;
      if (!this.d) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < getMaxScrollDistance()) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 1)
      {
        a(0);
        return false;
      }
      if (this.f != null)
      {
        this.h = true;
        a(-this.g);
      }
      return false;
    }
    this.d = false;
    this.a = paramMotionEvent.getY();
    this.b = paramMotionEvent.getX();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAccountPanelRootLayoutListener(AccountPanelRootLayout.AccountPanelRootLayoutListener paramAccountPanelRootLayoutListener)
  {
    this.f = paramAccountPanelRootLayoutListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout
 * JD-Core Version:    0.7.0.1
 */