package com.tencent.viola.ui.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.viola.ui.component.VDiv;
import java.lang.ref.WeakReference;

public class VFrameLayout
  extends FrameLayout
  implements IVView<VDiv>
{
  private WeakReference<VDiv> mDivWeakReference;
  private float mLastX;
  private float mLastY;
  private float mStartX;
  private float mStartY;
  private int mTouchSlop = 20;
  private VelocityTracker mVelocityTracker = null;
  
  public VFrameLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    if (paramContext != null) {
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
  }
  
  public void bindComponent(VDiv paramVDiv)
  {
    this.mDivWeakReference = new WeakReference(paramVDiv);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getComponent() != null) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (getComponent().isContainTargetEvent("touchDown"))
      {
        setClickable(true);
        getComponent().divFireTouchEvent("touchDown", paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        continue;
        if (getComponent().isContainTargetEvent("touchUp")) {
          getComponent().divFireTouchEvent("touchUp", paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        }
      }
    }
  }
  
  @Nullable
  public VDiv getComponent()
  {
    if (this.mDivWeakReference != null) {
      return (VDiv)this.mDivWeakReference.get();
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getComponent() != null)
    {
      int i = paramMotionEvent.getAction();
      if (getComponent().isContainTargetEvent("pan"))
      {
        if (this.mVelocityTracker == null) {
          this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(100);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.mLastX = paramMotionEvent.getX();
      this.mLastY = paramMotionEvent.getY();
      this.mStartX = paramMotionEvent.getX();
      this.mStartY = paramMotionEvent.getY();
      getComponent().firePanEvent("begin", 0.0F, 0.0F, paramMotionEvent.getX(), paramMotionEvent.getY(), this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity());
      continue;
      if ((Math.abs(paramMotionEvent.getX() - this.mStartX) > this.mTouchSlop) || (Math.abs(paramMotionEvent.getY() - this.mStartY) > this.mTouchSlop))
      {
        getComponent().firePanEvent("change", paramMotionEvent.getX() - this.mLastX, paramMotionEvent.getY() - this.mLastY, paramMotionEvent.getX(), paramMotionEvent.getY(), this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity());
        this.mLastX = paramMotionEvent.getX();
        this.mLastY = paramMotionEvent.getY();
        continue;
        getComponent().firePanEvent("end", paramMotionEvent.getX() - this.mLastX, paramMotionEvent.getY() - this.mLastY, paramMotionEvent.getX(), paramMotionEvent.getY(), this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity());
        this.mLastX = paramMotionEvent.getX();
        this.mLastY = paramMotionEvent.getY();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getComponent() != null) {
      return (getComponent().needInterceptTouchEvent()) || (super.onTouchEvent(paramMotionEvent));
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VFrameLayout
 * JD-Core Version:    0.7.0.1
 */