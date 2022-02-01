package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class ClipDianDianTouchAreaLayout
  extends FrameLayout
{
  boolean a = false;
  VelocityTracker b;
  int c;
  int d = 1;
  private View e;
  private Rect f = new Rect();
  private int g;
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    Object localObject;
    if (k == 0)
    {
      this.e.getHitRect(this.f);
      localObject = this.f;
      k = this.g;
      ((Rect)localObject).inset(k, k);
      this.a = false;
      this.d = 1;
      localObject = this.b;
      if (localObject == null) {
        this.b = VelocityTracker.obtain();
      } else {
        ((VelocityTracker)localObject).clear();
      }
      this.b.addMovement(paramMotionEvent);
    }
    else if (k == 2)
    {
      if (this.a) {
        return true;
      }
      localObject = this.b;
      if (localObject != null)
      {
        ((VelocityTracker)localObject).addMovement(paramMotionEvent);
        this.b.computeCurrentVelocity(1000);
        if (Math.abs((int)this.b.getYVelocity()) >= this.c) {
          this.d = 2;
        }
      }
      if (this.d == 2) {
        return true;
      }
    }
    else if ((k == 1) || (k == 3))
    {
      this.b.clear();
      this.b = null;
      this.a = false;
    }
    if (!this.f.contains(i, j)) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if ((k == 1) || (k == 3)) {
      this.a = false;
    }
    Object localObject = this.e;
    if (localObject != null) {
      if (k == 0)
      {
        ((View)localObject).getHitRect(this.f);
        localObject = this.f;
        i = this.g;
        ((Rect)localObject).inset(i, i);
        this.a = false;
      }
      else if (k == 2)
      {
        if (this.d == 2)
        {
          paramMotionEvent = this.b;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.clear();
            this.b = null;
          }
          return false;
        }
        if (this.a)
        {
          paramMotionEvent = this.b;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.clear();
            this.b = null;
          }
          return false;
        }
        if (!this.f.contains(i, j))
        {
          this.a = true;
          super.onTouchEvent(paramMotionEvent);
          setPressed(false);
          return false;
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTouchWidget(View paramView, int paramInt)
  {
    this.e = paramView;
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ClipDianDianTouchAreaLayout
 * JD-Core Version:    0.7.0.1
 */