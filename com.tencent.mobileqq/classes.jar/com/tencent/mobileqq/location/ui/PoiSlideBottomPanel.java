package com.tencent.mobileqq.location.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.ISlidePanelListener;
import com.tencent.mobileqq.widget.SlideBottomPanel;
import com.tencent.qphone.base.util.QLog;

public class PoiSlideBottomPanel
  extends SlideBottomPanel
{
  private View A;
  private View B;
  private int C = 2;
  
  public PoiSlideBottomPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PoiSlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PoiSlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (!this.c)
    {
      if (this.b) {
        return;
      }
      View localView = findViewWithTag(Integer.valueOf(1));
      float f1 = localView.getY();
      float f2 = this.h;
      float f3 = this.o;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.h - this.o }).setDuration(this.r);
      localValueAnimator.setTarget(localView);
      localValueAnimator.setInterpolator(this.x);
      localValueAnimator.addUpdateListener(new PoiSlideBottomPanel.2(this, localView, f1, f2 - f3));
      localValueAnimator.addListener(new PoiSlideBottomPanel.3(this));
      localValueAnimator.start();
      this.c = true;
      this.w = false;
      if (this.z != null) {
        this.z.displayPanel();
      }
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    if (!this.s) {
      return;
    }
    g();
    if (this.B == null) {
      this.B = findViewWithTag(Integer.valueOf(1));
    }
    if ((!this.n) && (Math.abs(paramMotionEvent.getY() - this.j) > this.f))
    {
      this.n = true;
      this.k = paramMotionEvent.getY();
      this.B.addOnLayoutChangeListener(new PoiSlideBottomPanel.1(this));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[panel] handleActionDown: invoked. isDragging: ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(" Math.abs(event.getY() - firstDownY): ");
      localStringBuilder.append(Math.abs(paramMotionEvent.getY() - this.j));
      localStringBuilder.append(" mTouchSlop: ");
      localStringBuilder.append(this.f);
      QLog.d("PoiSlideBottomPanel", 2, localStringBuilder.toString());
    }
    if (this.n)
    {
      this.l = (paramMotionEvent.getY() - this.k);
      this.k = paramMotionEvent.getY();
      float f = this.B.getY();
      if ((this.z != null) && (f > this.h - this.o) && (f < this.h - this.p))
      {
        if (QLog.isColorLevel())
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("[panel] fadeBackground: invoked. touchingViewY: ");
          paramMotionEvent.append(f);
          paramMotionEvent.append(" mMeasureHeight: ");
          paramMotionEvent.append(this.h);
          paramMotionEvent.append(" mPanelHeight: ");
          paramMotionEvent.append(this.o);
          paramMotionEvent.append(" mTitleHeightNoDisplay: ");
          paramMotionEvent.append(this.p);
          paramMotionEvent.append(" mMeasureHeight - mPanelHeight: ");
          paramMotionEvent.append(this.h - this.o);
          paramMotionEvent.append(" mMeasureHeight - mTitleHeightNoDisplay: ");
          paramMotionEvent.append(this.h - this.p);
          QLog.d("PoiSlideBottomPanel", 2, paramMotionEvent.toString());
        }
        this.z.fadeBackground(1.0F - f / (this.h - this.p));
      }
      if (this.l + f <= this.h - this.o)
      {
        this.B.offsetTopAndBottom((int)(this.h - this.o - f));
        return;
      }
      if (f + this.l >= getBottomHeight())
      {
        if (this.w) {
          return;
        }
        if (this.l > this.u) {
          this.l = this.u;
        }
        this.B.offsetTopAndBottom((int)this.l);
        return;
      }
      this.B.offsetTopAndBottom((int)this.l);
    }
  }
  
  protected void b()
  {
    if (this.b) {
      return;
    }
    View localView = findViewWithTag(Integer.valueOf(1));
    int i = (int)(this.h - this.p);
    float f = localView.getY();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.h - this.p });
    localValueAnimator.setInterpolator(this.y);
    localValueAnimator.setTarget(localView);
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new PoiSlideBottomPanel.4(this, localView, f, i));
    localValueAnimator.addListener(new PoiSlideBottomPanel.5(this));
    localValueAnimator.start();
    if (this.z != null) {
      this.z.hidePanel();
    }
  }
  
  protected void b(MotionEvent paramMotionEvent)
  {
    if (!this.s) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.m;
    g();
    if (((!this.c) && (paramMotionEvent.getY() - this.j < 0.0F) && (Math.abs(paramMotionEvent.getY() - this.j) > this.q)) || ((this.e < 0.0F) && (Math.abs(this.e) > Math.abs(this.d)) && (Math.abs(this.e) > this.g)))
    {
      a();
    }
    else if ((l1 - l2 < 300L) && (a(this.i, this.j, paramMotionEvent.getX(), paramMotionEvent.getY()) < a + 5.0F))
    {
      if (this.c)
      {
        b();
      }
      else
      {
        a();
        this.C = 1;
      }
    }
    else if ((!this.c) && (this.n))
    {
      int i = (int)(paramMotionEvent.getY() - this.j);
      if (((!this.w) && (i > this.v)) || ((this.w) && (i < 0) && (Math.abs(i) < this.q))) {
        c();
      }
      if ((!this.w) && (i < 0) && (Math.abs(i) < this.q))
      {
        paramMotionEvent = findViewWithTag(Integer.valueOf(1));
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { paramMotionEvent.getY(), this.h - this.p }).setDuration(this.r).start();
      }
    }
    if (this.c)
    {
      paramMotionEvent = findViewWithTag(Integer.valueOf(1));
      float f = paramMotionEvent.getY();
      if ((f >= this.h - this.o) && (f >= this.h - this.o + this.q))
      {
        if (f > this.h - this.o + this.q) {
          b();
        }
      }
      else {
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { f, this.h - this.o }).setDuration(this.r).start();
      }
    }
    this.s = false;
    this.n = false;
    this.l = 0.0F;
  }
  
  protected boolean c(MotionEvent paramMotionEvent)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.m;
    boolean bool2 = false;
    if (l1 - l2 <= 500L) {
      return false;
    }
    this.m = System.currentTimeMillis();
    this.i = paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    this.k = f;
    this.j = f;
    paramMotionEvent = new Rect();
    this.A.getGlobalVisibleRect(paramMotionEvent);
    boolean bool1 = bool2;
    if (this.k > paramMotionEvent.top)
    {
      bool1 = bool2;
      if (this.k < paramMotionEvent.bottom) {
        bool1 = true;
      }
    }
    this.s = bool1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[panel] handleActionDown: invoked. firstDownY: ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" actionRect: ");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append(" isConsume: ");
      localStringBuilder.append(bool1);
      QLog.d("PoiSlideBottomPanel", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public int getBottomHeight()
  {
    return this.t;
  }
  
  public int getDisplayFromType()
  {
    return this.C;
  }
  
  public void setBottomHeight(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setDisplayFromType(int paramInt)
  {
    this.C = paramInt;
  }
  
  public void setDragView(View paramView)
  {
    this.A = paramView;
  }
  
  public void setTitleHeightNoDisplay(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.PoiSlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */