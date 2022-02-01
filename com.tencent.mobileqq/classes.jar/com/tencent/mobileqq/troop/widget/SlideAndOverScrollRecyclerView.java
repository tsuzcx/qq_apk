package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;

public class SlideAndOverScrollRecyclerView
  extends OverScrollRecyclerView
{
  private VelocityTracker b;
  private int c;
  private Rect d;
  private Scroller e;
  private float f;
  private float g;
  private float h;
  private boolean i;
  private ViewGroup j;
  private int k;
  private int l;
  
  public SlideAndOverScrollRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideAndOverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideAndOverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.e = new Scroller(paramContext);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.b == null) {
      this.b = VelocityTracker.obtain();
    }
    this.b.addMovement(paramMotionEvent);
  }
  
  private void d()
  {
    VelocityTracker localVelocityTracker = this.b;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.clear();
      this.b.recycle();
      this.b = null;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int n = ((LinearLayoutManager)getLayoutManager()).findFirstVisibleItemPosition();
    Object localObject2 = this.d;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.d = new Rect();
      localObject1 = this.d;
    }
    int m = getChildCount() - 1;
    while (m >= 0)
    {
      localObject2 = getChildAt(m);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return n + m;
        }
      }
      m -= 1;
    }
    return -1;
  }
  
  public void a()
  {
    ViewGroup localViewGroup = this.j;
    if ((localViewGroup != null) && (localViewGroup.getScrollX() != 0)) {
      this.j.scrollTo(0, 0);
    }
  }
  
  public void computeScroll()
  {
    if (this.e.computeScrollOffset())
    {
      this.j.scrollTo(this.e.getCurrX(), this.e.getCurrY());
      invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    a(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    float f1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          this.b.computeCurrentVelocity(1000);
          f1 = this.b.getXVelocity();
          float f2 = this.b.getYVelocity();
          if ((Math.abs(f1) <= 600.0F) || (Math.abs(f1) <= Math.abs(f2)))
          {
            f1 = m;
            if ((Math.abs(f1 - this.g) < this.c) || (Math.abs(f1 - this.g) <= Math.abs(n - this.h))) {}
          }
          else
          {
            this.i = true;
            return true;
          }
        }
      }
      else {
        d();
      }
    }
    else
    {
      if (!this.e.isFinished()) {
        this.e.abortAnimation();
      }
      f1 = m;
      this.f = f1;
      this.g = f1;
      this.h = n;
      this.k = a(m, n);
      m = this.k;
      if (m != -1)
      {
        ViewGroup localViewGroup = this.j;
        this.j = ((ViewGroup)getChildAt(m - ((LinearLayoutManager)getLayoutManager()).findFirstVisibleItemPosition()));
        if ((localViewGroup != null) && (this.j != localViewGroup) && (localViewGroup.getScrollX() != 0)) {
          localViewGroup.scrollTo(0, 0);
        }
        if (this.j.getChildCount() == 2) {
          this.l = this.j.getChildAt(1).getWidth();
        } else {
          this.l = -1;
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.i) && (this.k != -1))
    {
      float f1 = paramMotionEvent.getX();
      a(paramMotionEvent);
      int m = paramMotionEvent.getAction();
      if (m != 0) {
        if (m != 1)
        {
          if (m != 2) {
            return true;
          }
          if (this.l != -1)
          {
            float f2 = this.f - f1;
            if ((this.j.getScrollX() + f2 <= this.l) && (this.j.getScrollX() + f2 > 0.0F)) {
              this.j.scrollBy((int)f2, 0);
            }
            this.f = f1;
            return true;
          }
        }
        else
        {
          if (this.l != -1)
          {
            m = this.j.getScrollX();
            this.b.computeCurrentVelocity(1000);
            int n;
            if (this.b.getXVelocity() < -600.0F)
            {
              paramMotionEvent = this.e;
              n = this.l;
              paramMotionEvent.startScroll(m, 0, n - m, 0, Math.abs(n - m));
            }
            else if (this.b.getXVelocity() >= 600.0F)
            {
              this.e.startScroll(m, 0, -m, 0, Math.abs(m));
            }
            else
            {
              n = this.l;
              if (m >= n / 2) {
                this.e.startScroll(m, 0, n - m, 0, Math.abs(n - m));
              } else {
                this.e.startScroll(m, 0, -m, 0, Math.abs(m));
              }
            }
            invalidate();
          }
          this.l = -1;
          this.i = false;
          this.k = -1;
          d();
        }
      }
      return true;
    }
    a();
    d();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.SlideAndOverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */