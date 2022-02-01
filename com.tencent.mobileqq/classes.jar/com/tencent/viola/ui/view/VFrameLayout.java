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
  
  @Nullable
  public VDiv getComponent()
  {
    WeakReference localWeakReference = this.mDivWeakReference;
    if (localWeakReference != null) {
      return (VDiv)localWeakReference.get();
    }
    return null;
  }
  
  public void onDestroy()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getComponent() != null)
    {
      int i = paramMotionEvent.getAction();
      if ((getComponent().isContainTargetEvent("pan")) || (getComponent().isContainTargetEvent("androidPan")))
      {
        if (this.mVelocityTracker == null) {
          this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(100);
        if (i != 0)
        {
          if (i != 1) {
            if (i != 2)
            {
              if (i != 3) {
                break label332;
              }
            }
            else
            {
              if ((Math.abs(paramMotionEvent.getX() - this.mStartX) <= this.mTouchSlop) && (Math.abs(paramMotionEvent.getY() - this.mStartY) <= this.mTouchSlop)) {
                break label332;
              }
              getComponent().firePanEvent("change", paramMotionEvent.getX() - this.mLastX, paramMotionEvent.getY() - this.mLastY, paramMotionEvent.getX(), paramMotionEvent.getY(), this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity());
              this.mLastX = paramMotionEvent.getX();
              this.mLastY = paramMotionEvent.getY();
              break label332;
            }
          }
          getComponent().firePanEvent("end", paramMotionEvent.getX() - this.mLastX, paramMotionEvent.getY() - this.mLastY, paramMotionEvent.getX(), paramMotionEvent.getY(), this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity());
          this.mLastX = paramMotionEvent.getX();
          this.mLastY = paramMotionEvent.getY();
        }
        else
        {
          this.mLastX = paramMotionEvent.getX();
          this.mLastY = paramMotionEvent.getY();
          this.mStartX = paramMotionEvent.getX();
          this.mStartY = paramMotionEvent.getY();
          getComponent().firePanEvent("begin", 0.0F, 0.0F, paramMotionEvent.getX(), paramMotionEvent.getY(), this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity());
        }
      }
    }
    label332:
    return super.onInterceptTouchEvent(paramMotionEvent);
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