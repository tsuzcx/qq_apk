package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

public class PullToZoomListView
  extends XListView
{
  private static final Interpolator m = new PullToZoomListView.1();
  protected boolean a = false;
  protected int b = -1;
  protected FrameLayout c;
  protected View d;
  protected int e;
  protected int f;
  protected float g = -1.0F;
  protected float h = -1.0F;
  protected float i = -1.0F;
  protected PullToZoomListView.ScalingRunnalable j;
  protected int k;
  protected boolean l = true;
  
  public PullToZoomListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PullToZoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PullToZoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.k = localDisplayMetrics.heightPixels;
    this.j = new PullToZoomListView.ScalingRunnalable(this);
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PullToZoomListView", 2, "initHeaderView");
    }
    this.c = new FrameLayout(getContext());
    this.c.addView(paramView);
  }
  
  private void b()
  {
    if (!this.a) {
      return;
    }
    if ((this.c.getBottom() >= this.e) && (QLog.isColorLevel())) {
      QLog.d("PullToZoomListView", 2, "endScraling");
    }
    this.j.a(200L);
  }
  
  private void c()
  {
    this.b = -1;
    this.g = -1.0F;
    this.i = -1.0F;
    this.h = -1.0F;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void addHeaderView(View paramView)
  {
    a(paramView);
    super.addHeaderView(this.c);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    a(paramView);
    super.addHeaderView(this.c, paramObject, paramBoolean);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (!this.j.b) {
        this.j.a();
      }
      this.g = paramMotionEvent.getY();
      this.b = paramMotionEvent.getPointerId(0);
      this.i = (this.k * 1.0F / this.e);
      this.h = (this.c.getBottom() / this.e);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.e == 0)
    {
      Object localObject = this.c;
      if ((localObject != null) && (this.d != null))
      {
        this.e = ((FrameLayout)localObject).getHeight();
        this.f = (this.e - this.d.getHeight());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mHeaderHeight:");
          ((StringBuilder)localObject).append(this.e);
          ((StringBuilder)localObject).append(" mHeaderBottomHeight:");
          ((StringBuilder)localObject).append(this.f);
          QLog.d("PullToZoomListView", 2, ((StringBuilder)localObject).toString());
        }
        if (this.e > 0) {
          this.a = true;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a) && (this.l))
    {
      int n = paramMotionEvent.getAction() & 0xFF;
      if (n != 1)
      {
        if (n != 2)
        {
          if (n == 3)
          {
            n = paramMotionEvent.getActionIndex();
            this.g = paramMotionEvent.getY(n);
            this.b = paramMotionEvent.getPointerId(n);
          }
        }
        else
        {
          n = paramMotionEvent.findPointerIndex(this.b);
          Object localObject;
          if (n == -1)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Invalid pointerId=");
              ((StringBuilder)localObject).append(this.b);
              ((StringBuilder)localObject).append(" in onTouchEvent");
              QLog.d("PullToZoomListView", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            if (this.g == -1.0F) {
              this.g = paramMotionEvent.getY(n);
            }
            if (this.c.getBottom() >= this.e)
            {
              localObject = this.c.getLayoutParams();
              ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
              float f1 = paramMotionEvent.getY(n);
              float f2 = this.g;
              float f3 = this.c.getBottom();
              int i1 = this.e;
              f2 = (f1 - f2 + f3) / i1;
              f1 = this.h;
              f2 = (f2 - f1) / 2.0F + f1;
              if ((f1 <= 1.0D) && (f2 < f1))
              {
                ((ViewGroup.LayoutParams)localObject).height = i1;
                localLayoutParams.height = (i1 - this.f);
                this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
                this.d.setLayoutParams(localLayoutParams);
                return super.onTouchEvent(paramMotionEvent);
              }
              this.h = Math.min(Math.max(f2, 1.0F), this.i);
              ((ViewGroup.LayoutParams)localObject).height = ((int)(this.e * this.h));
              localLayoutParams.height = (((ViewGroup.LayoutParams)localObject).height - this.f);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("new height:");
                localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
                localStringBuilder.append(" imgHeight:");
                localStringBuilder.append(localLayoutParams.height);
                localStringBuilder.append(" mLastScale:");
                localStringBuilder.append(this.h);
                QLog.d("PullToZoomListView", 2, localStringBuilder.toString());
              }
              if (((ViewGroup.LayoutParams)localObject).height < this.k)
              {
                this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
                this.d.setLayoutParams(localLayoutParams);
              }
              this.g = paramMotionEvent.getY(n);
            }
            else
            {
              this.g = paramMotionEvent.getY(n);
            }
          }
        }
      }
      else
      {
        c();
        b();
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHeaderImage(View paramView)
  {
    this.d = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PullToZoomListView
 * JD-Core Version:    0.7.0.1
 */