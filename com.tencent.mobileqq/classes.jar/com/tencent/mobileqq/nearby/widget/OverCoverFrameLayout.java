package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class OverCoverFrameLayout
  extends FrameLayout
{
  protected Context a;
  protected Scroller b;
  protected int c = 0;
  protected int d = 0;
  protected boolean e = true;
  protected final int f = 200;
  protected GestureDetector g;
  protected int h;
  protected int i;
  protected boolean j = true;
  protected int k = 0;
  protected OverCoverFrameLayout.OnActionListener l;
  private boolean m = false;
  private boolean n = false;
  
  public OverCoverFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public OverCoverFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  protected void a()
  {
    if (((this.m) || (this.n)) && (this.b.isFinished()))
    {
      int i1 = this.d;
      if ((i1 == this.c) || (i1 == 0))
      {
        OverCoverFrameLayout.OnActionListener localOnActionListener = this.l;
        if (localOnActionListener != null)
        {
          if (this.m)
          {
            i1 = this.d;
            if (i1 == 0)
            {
              localOnActionListener.a(0, 0, i1);
              break label112;
            }
          }
          if (this.n)
          {
            i1 = this.d;
            if (i1 == this.c) {
              this.l.a(0, 1, i1);
            }
          }
        }
        label112:
        this.m = false;
        this.n = false;
      }
    }
  }
  
  protected void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new Scroller(paramContext, new LinearInterpolator());
    this.h = ViewConfiguration.getTouchSlop();
    this.i = ViewConfiguration.getMinimumFlingVelocity();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init: minDis=");
      localStringBuilder.append(this.h);
      localStringBuilder.append(", minVelocity=");
      localStringBuilder.append(this.i);
      QLog.d("OverCoverFrameLayout", 2, localStringBuilder.toString());
    }
    this.g = new GestureDetector(paramContext, new OverCoverFrameLayout.1(this));
  }
  
  public boolean b()
  {
    if (!this.e) {
      return false;
    }
    if (!this.b.isFinished()) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("slideUp, isFgViewOnBottom=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("OverCoverFrameLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.b.abortAnimation();
    this.m = true;
    this.n = false;
    Object localObject = this.b;
    int i1 = this.c;
    ((Scroller)localObject).startScroll(i1, 0, -i1, 0, 200);
    localObject = this.l;
    if (localObject != null) {
      ((OverCoverFrameLayout.OnActionListener)localObject).a(1, 0, this.c);
    }
    invalidate();
    this.e = false;
    return true;
  }
  
  public boolean c()
  {
    if (this.e) {
      return false;
    }
    if (!this.b.isFinished()) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("slideDown, isFgViewOnBottom=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("OverCoverFrameLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.b.abortAnimation();
    this.m = false;
    this.n = true;
    this.b.startScroll(0, 0, this.c, 0, 200);
    Object localObject = this.l;
    if (localObject != null) {
      ((OverCoverFrameLayout.OnActionListener)localObject).a(1, 1, 0);
    }
    invalidate();
    this.e = true;
    return true;
  }
  
  public void computeScroll()
  {
    if (this.b.computeScrollOffset())
    {
      this.d = this.b.getCurrX();
      invalidate();
      requestLayout();
    }
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = paramMotionEvent.getAction();
    int i2 = (int)paramMotionEvent.getY();
    int i1 = 0;
    if (i3 != 0)
    {
      if (i3 != 1) {
        if (i3 != 2)
        {
          if (i3 != 3) {
            break label191;
          }
        }
        else
        {
          i2 -= this.k;
          i1 = i2;
          if (!this.j) {
            break label191;
          }
          if (i2 > 0)
          {
            Math.abs(i2);
            double d1 = this.c;
            Double.isNaN(d1);
            i1 = (int)(d1 * 0.8D);
            i1 = i2;
            break label191;
          }
          i1 = i2;
          if (i2 >= 0) {
            break label191;
          }
          Math.abs(i2);
          i1 = this.h;
          i1 = i2;
          break label191;
        }
      }
      this.j = true;
    }
    else
    {
      View localView = getChildAt(0);
      if (this.e)
      {
        if ((localView != null) && (i2 <= localView.getHeight())) {
          this.j = false;
        } else {
          this.j = true;
        }
      }
      else {
        this.j = true;
      }
      this.k = i2;
    }
    label191:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("dispatchTouchEvent, action=");
      paramMotionEvent.append(i3);
      paramMotionEvent.append(", ret=");
      paramMotionEvent.append(bool);
      paramMotionEvent.append(", distance=");
      paramMotionEvent.append(i1);
      paramMotionEvent.append(", isNeedDetector=");
      paramMotionEvent.append(this.j);
      paramMotionEvent.append(", mBgViewHeight=");
      paramMotionEvent.append(this.c);
      QLog.d("OverCoverFrameLayout", 2, paramMotionEvent.toString());
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView1 = getChildAt(0);
    View localView2 = getChildAt(1);
    localView1.layout(0, 0, localView1.getMeasuredWidth(), localView1.getMeasuredHeight());
    if (localView2 != null)
    {
      localView2.layout(0, this.d, localView2.getMeasuredWidth(), getMeasuredHeight());
      a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getChildAt(0).getMeasuredHeight();
    if (this.c != paramInt1)
    {
      this.c = paramInt1;
      this.b.abortAnimation();
      if (this.e)
      {
        this.d = this.c;
        return;
      }
      this.d = 0;
    }
  }
  
  public void setOnActionListener(OverCoverFrameLayout.OnActionListener paramOnActionListener)
  {
    this.l = paramOnActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout
 * JD-Core Version:    0.7.0.1
 */