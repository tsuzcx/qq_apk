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
  private VelocityTracker a;
  private int b;
  private int c = 0;
  private int d;
  private int e;
  private float f;
  private float g;
  private float h;
  private boolean i = false;
  private float j = 0.0F;
  private View k;
  private int l;
  private int m = 0;
  private int n = 0;
  private int o;
  private int p;
  private Scroller q;
  private INestScrollHelper r;
  
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
    paramInt = paramContext.getResources().getDimensionPixelSize(2131299920) + ImmersiveUtils.getStatusBarHeight(paramContext);
    this.c = paramInt;
    this.c = paramInt;
    this.q = new Scroller(paramContext);
    this.r = ((INestScrollHelper)QRoute.api(INestScrollHelper.class));
    paramContext = ViewConfiguration.get(paramContext);
    this.d = paramContext.getScaledTouchSlop();
    this.e = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return paramInt1 - paramInt2;
  }
  
  private void a()
  {
    VelocityTracker localVelocityTracker = this.a;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.a = null;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.a == null) {
      this.a = VelocityTracker.obtain();
    }
    this.a.addMovement(paramMotionEvent);
  }
  
  private boolean b()
  {
    return this.o == this.m;
  }
  
  private int getScrollerVelocity()
  {
    return (int)this.q.getCurrVelocity();
  }
  
  public void computeScroll()
  {
    if (this.q.computeScrollOffset())
    {
      int i1 = this.q.getCurrY();
      int i2;
      if (this.b == 1)
      {
        if (b())
        {
          i2 = this.q.getFinalY();
          int i3 = a(this.q.getDuration(), this.q.timePassed());
          this.r.smoothScrollBy(getScrollerVelocity(), i2 - i1, i3);
          this.q.abortAnimation();
          return;
        }
        scrollTo(0, i1);
        invalidate();
      }
      else
      {
        if (this.r.isTop())
        {
          i2 = this.p;
          scrollTo(0, getScrollY() + (i1 - i2));
          if (this.o <= this.n)
          {
            this.q.abortAnimation();
            return;
          }
        }
        invalidate();
      }
      this.p = i1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1 = Math.abs(f3 - this.f);
    float f2 = Math.abs(f4 - this.g);
    a(paramMotionEvent);
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      int i1 = 2;
      boolean bool;
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 == 3) {
            a();
          }
        }
        else
        {
          this.j = (this.h - f4);
          this.h = f4;
          if ((f1 > this.d) && (f1 > 2.0F * f2)) {
            this.i = false;
          } else if ((f2 > this.d) && (f2 > f1)) {
            this.i = true;
          }
          bool = b();
          if ((this.i) && (((this.j > 0.0F) && (!bool)) || ((this.r.isTop()) && (this.j < 0.0F))))
          {
            double d1 = this.j;
            Double.isNaN(d1);
            scrollBy(0, (int)(d1 + 0.5D));
            invalidate();
            return true;
          }
        }
      }
      else
      {
        if (this.i)
        {
          if ((this.j < 0.0F) || (!b()))
          {
            this.a.computeCurrentVelocity(1000, this.e);
            f3 = this.a.getYVelocity();
            if (f3 <= 0.0F) {
              i1 = 1;
            }
            this.b = i1;
            this.q.fling(0, getScrollY(), 0, -(int)f3, 0, 0, -2147483647, 2147483647);
            this.p = getScrollY();
            invalidate();
          }
          i1 = this.d;
          if (((f1 > i1) || (f2 > i1)) && (!b()))
          {
            i1 = paramMotionEvent.getAction();
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            paramMotionEvent.setAction(i1);
            return bool;
          }
        }
        a();
      }
    }
    else
    {
      this.i = false;
      this.f = f3;
      this.g = f4;
      this.h = f4;
      this.j = 0.0F;
      this.q.abortAnimation();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = this.k;
    if ((localView != null) && (!localView.isClickable())) {
      this.k.setClickable(true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.k = getChildAt(0);
    measureChildWithMargins(this.k, paramInt1, 0, 0, 0);
    this.l = this.k.getMeasuredHeight();
    this.m = (this.l - this.c);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) + this.m, 1073741824));
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int i2 = getScrollY();
    paramInt2 += i2;
    int i1 = this.m;
    if (paramInt2 >= i1)
    {
      paramInt2 = i1;
    }
    else
    {
      i1 = this.n;
      if (paramInt2 <= i1) {
        paramInt2 = i1;
      }
    }
    super.scrollBy(paramInt1, paramInt2 - i2);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i1 = this.m;
    if (paramInt2 >= i1)
    {
      paramInt2 = i1;
    }
    else
    {
      i1 = this.n;
      if (paramInt2 <= i1) {
        paramInt2 = i1;
      }
    }
    this.o = paramInt2;
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setPosition(int paramInt)
  {
    this.r.setPosition(paramInt);
  }
  
  public void setTopOffset(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.r.setViewPager(paramViewPager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NestScrollLayout
 * JD-Core Version:    0.7.0.1
 */