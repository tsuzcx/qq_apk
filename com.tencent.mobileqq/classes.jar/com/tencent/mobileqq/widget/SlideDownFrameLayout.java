package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.util.DisplayUtil;

public class SlideDownFrameLayout
  extends FrameLayout
{
  private SlideDownFrameLayout.OnSlideListener a;
  private float b = 0.0F;
  private float c = 0.0F;
  private int d = 0;
  private VelocityTracker e;
  
  public SlideDownFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ValueAnimator.ofFloat(new float[] { ((SlideDownFrameLayout.OnSlideListener)localObject).e().getY(), 0.0F });
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).addUpdateListener(new SlideDownFrameLayout.1(this));
    ((ValueAnimator)localObject).start();
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ValueAnimator.ofFloat(new float[] { ((SlideDownFrameLayout.OnSlideListener)localObject).e().getY(), this.a.e().getHeight() });
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).addUpdateListener(new SlideDownFrameLayout.2(this));
    ((ValueAnimator)localObject).addListener(new SlideDownFrameLayout.3(this));
    ((ValueAnimator)localObject).start();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a == null) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getPointerCount() > 1) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    this.c = paramMotionEvent.getY();
    if (i == 0)
    {
      this.b = this.c;
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      float f = Math.abs(this.c - this.b);
      if ((this.d == 0) && (f < DisplayUtil.a(getContext(), 5.0F))) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      f = this.c - this.b;
      if (Math.abs(f) > 0.0F)
      {
        if ((this.d == 0) && (f > 0.0F))
        {
          if (this.a.c())
          {
            this.b = this.c;
            this.d = 1;
            return true;
          }
          this.b = this.c;
          return super.onInterceptTouchEvent(paramMotionEvent);
        }
      }
      else
      {
        this.b = this.c;
        this.d = 0;
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
    }
    else if ((i == 1) || (i == 3))
    {
      this.d = 0;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.c = paramMotionEvent.getY();
    if (i == 0)
    {
      this.b = this.c;
    }
    else
    {
      Object localObject;
      if (i == 2)
      {
        if (this.d == 1)
        {
          localObject = this.a;
          if (localObject != null)
          {
            ((SlideDownFrameLayout.OnSlideListener)localObject).e().setY(Math.max(this.c - this.b, 0.0F));
            this.a.a(Math.max(this.c - this.b, 0.0F), this.a.e().getHeight());
          }
          if (this.e == null) {
            this.e = VelocityTracker.obtain();
          }
          this.e.addMovement(paramMotionEvent);
          return true;
        }
      }
      else if ((i == 1) || (i == 3))
      {
        if (this.d != 0)
        {
          localObject = this.a;
          if ((localObject != null) && (this.e != null))
          {
            float f = ((SlideDownFrameLayout.OnSlideListener)localObject).e().getY();
            this.e.computeCurrentVelocity(1000);
            if ((f <= DisplayUtil.a(getContext(), 100.0F)) && ((f <= DisplayUtil.a(getContext(), 30.0F)) || (this.e.getYVelocity() <= 1000.0F))) {
              a();
            } else {
              b();
            }
          }
        }
        this.d = 0;
        localObject = this.e;
        if (localObject != null)
        {
          ((VelocityTracker)localObject).recycle();
          this.e = null;
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnSlideListener(SlideDownFrameLayout.OnSlideListener paramOnSlideListener)
  {
    this.a = paramOnSlideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDownFrameLayout
 * JD-Core Version:    0.7.0.1
 */