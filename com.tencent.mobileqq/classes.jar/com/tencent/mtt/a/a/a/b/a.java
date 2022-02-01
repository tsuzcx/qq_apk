package com.tencent.mtt.a.a.a.b;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;

public class a
  implements View.OnTouchListener
{
  protected View a;
  protected c b;
  protected float c = -1.0F;
  protected float d = -1.0F;
  protected boolean e = true;
  private boolean f;
  private int g = -1;
  private b h;
  private ValueAnimator i;
  private e j;
  private d k;
  
  private void a(int paramInt)
  {
    d locald = this.k;
    if (locald != null) {
      locald.a(this.g, paramInt);
    }
    this.g = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    k();
    this.i = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    this.i.addUpdateListener(new a.1(this));
    this.i.addListener(new a.2(this));
    this.i.setDuration(200L).start();
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    return Math.abs(paramMotionEvent.getRawY() - this.d - f()) > 0.0F;
  }
  
  private boolean a(View paramView)
  {
    return paramView.getHeight() >= this.b.getContentHeight();
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.a.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = Math.max(paramInt, 0);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.j;
    if (localObject != null) {
      ((e)localObject).requestLayout();
    }
    this.b.onHeaderHeightChanged(Math.max(c(), 0));
  }
  
  private int f()
  {
    return ViewConfiguration.get(this.a.getContext()).getScaledTouchSlop();
  }
  
  private void g()
  {
    int m;
    if (this.g == 1)
    {
      if (a(this.a)) {
        m = 2;
      } else {
        m = 5;
      }
      a(m);
    }
    int n;
    if (a(this.a))
    {
      m = c();
      n = this.b.getContentHeight();
    }
    else
    {
      m = c();
      n = 0;
    }
    a(m, n);
  }
  
  private void h()
  {
    a(1);
    this.b.onStartDrag();
  }
  
  private void i()
  {
    a(0);
    this.b.onFolded();
  }
  
  private boolean j()
  {
    return this.a.isShown();
  }
  
  private void k()
  {
    ValueAnimator localValueAnimator = this.i;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllListeners();
      this.i.removeAllUpdateListeners();
      this.i.end();
      this.i = null;
    }
  }
  
  public void a()
  {
    if (this.g == 4)
    {
      a(5);
      a(c(), 0);
    }
  }
  
  public void a(b paramb)
  {
    this.h = paramb;
  }
  
  public void a(c paramc)
  {
    this.b = paramc;
    this.a = this.b.getView();
    a(0);
  }
  
  public void a(e parame)
  {
    this.j = parame;
  }
  
  void b()
  {
    this.h.onHeaderRefreshing(this.g);
    a(4);
    this.b.onRefreshing();
  }
  
  public int c()
  {
    if (!this.e) {
      return 0;
    }
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    if (localLayoutParams == null) {
      return 0;
    }
    return localLayoutParams.height;
  }
  
  public void d()
  {
    if (this.g == 0)
    {
      a(3);
      a(0, this.b.getContentHeight());
    }
  }
  
  public boolean e()
  {
    int m = this.g;
    return (m == 2) || (m == 3);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.e;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.c == -1.0F) {
      this.c = paramMotionEvent.getRawY();
    }
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 2)
      {
        this.f = false;
        this.c = -1.0F;
        this.d = -1.0F;
        if (j()) {
          g();
        }
      }
      else
      {
        m = (int)(paramMotionEvent.getRawY() - this.c) / 2;
        this.c = paramMotionEvent.getRawY();
        if ((a(paramMotionEvent)) && (j()))
        {
          k();
          b(m + c());
          if ((!this.f) && (c() <= 0)) {
            bool1 = false;
          } else {
            bool1 = true;
          }
          this.f = bool1;
          if (this.f) {
            h();
          }
        }
      }
    }
    else
    {
      this.c = paramMotionEvent.getRawY();
      this.d = paramMotionEvent.getRawY();
    }
    bool1 = bool2;
    if (this.f)
    {
      bool1 = bool2;
      if (c() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */