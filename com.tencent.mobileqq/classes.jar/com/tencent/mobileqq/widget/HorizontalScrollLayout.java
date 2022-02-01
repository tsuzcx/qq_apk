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
  private Scroller a;
  private VelocityTracker b;
  private int c = 0;
  private int d;
  private float e;
  private float f;
  private int g;
  private int h = 0;
  
  public HorizontalScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new Scroller(paramContext);
    this.d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.g = getDispalyWidth();
  }
  
  public void a()
  {
    int i = getScrollX();
    if (i < 0)
    {
      this.a.startScroll(i, 0, -i, 0, Math.abs(i) * 1);
    }
    else
    {
      int j = this.h;
      if (j < i)
      {
        if (j <= 0) {
          i = getScrollX();
        } else {
          i = getScrollX() - this.h;
        }
        this.a.startScroll(getScrollX(), 0, -i, 0, Math.abs(i) * 1);
      }
    }
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      if (this.h <= 0) {
        i = -getScrollX();
      }
      for (;;)
      {
        break;
        i = this.g;
        int j = getScrollX();
        int k = this.h;
        if (i + j > k) {
          i = k - getScrollX();
        } else {
          i = this.g;
        }
      }
      this.a.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
    }
    else
    {
      if (-this.g + getScrollX() > 0) {
        i = -this.g;
      } else {
        i = getScrollX() * -1;
      }
      this.a.startScroll(getScrollX(), 0, i, 0, Math.abs(i) * 1);
    }
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.a.computeScrollOffset())
    {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      postInvalidate();
    }
  }
  
  public int getDispalyWidth()
  {
    return getResources().getDisplayMetrics().widthPixels;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.c != 0)) {
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
          i = (int)Math.abs(this.e - f1);
          int j = (int)Math.abs(this.f - f2);
          if ((i <= this.d) || (i <= j)) {
            break label152;
          }
          this.c = 1;
          paramMotionEvent = getParent();
          if (paramMotionEvent == null) {
            break label152;
          }
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          break label152;
        }
      }
      this.c = 0;
    }
    else
    {
      this.e = f1;
      this.f = f2;
      this.c = (this.a.isFinished() ^ true);
    }
    label152:
    return this.c != 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (1 <= getChildCount()) {
      this.h = (getChildAt(getChildCount() - 1).getRight() - this.g);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b == null) {
      this.b = VelocityTracker.obtain();
    }
    this.b.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
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
          this.c = 0;
          return true;
        }
        i = (int)(this.e - f1);
        this.e = f1;
        scrollBy(i, 0);
        return true;
      }
      paramMotionEvent = this.b;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if (i > 600) {
        a(false);
      } else if (i < -600) {
        a(true);
      } else {
        a();
      }
      paramMotionEvent = this.b;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.recycle();
        this.b = null;
      }
      this.c = 0;
      return true;
    }
    if (!this.a.isFinished()) {
      this.a.abortAnimation();
    }
    this.e = f1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HorizontalScrollLayout
 * JD-Core Version:    0.7.0.1
 */