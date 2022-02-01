package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;

public class CustomHorizontalScrollView
  extends HorizontalScrollView
{
  Handler i = new Handler();
  float j = getResources().getDisplayMetrics().density;
  int k = -1;
  int l;
  int m;
  int n;
  int o = getResources().getDisplayMetrics().widthPixels;
  Runnable p = new CustomHorizontalScrollView.1(this);
  float q;
  float r;
  int s = 3;
  
  public CustomHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
    float f = this.j;
    double d = 70.0F * f;
    Double.isNaN(d);
    this.l = ((int)(d + 0.5D));
    d = f;
    Double.isNaN(d);
    this.m = ((int)(d + 0.5D));
  }
  
  public CustomHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    float f = this.j;
    double d = 70.0F * f;
    Double.isNaN(d);
    this.l = ((int)(d + 0.5D));
    d = f;
    Double.isNaN(d);
    this.m = ((int)(d + 0.5D));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 2) && (i1 != 3)) {
        return bool;
      }
      if (((this.s * Math.abs(f1 - this.q) > Math.abs(f2 - this.r)) || ((f1 == this.q) && (f2 == this.r))) && (getScrollX() != 0))
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        return bool;
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      return bool;
    }
    getParent().requestDisallowInterceptTouchEvent(true);
    this.q = f1;
    this.r = f2;
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      View localView = getChildAt(0);
      if (localView != null) {
        this.n = localView.getMeasuredWidth();
      }
      this.i.postDelayed(this.p, 5L);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */