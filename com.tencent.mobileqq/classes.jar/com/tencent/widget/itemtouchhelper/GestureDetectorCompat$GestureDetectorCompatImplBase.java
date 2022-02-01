package com.tencent.widget.itemtouchhelper;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class GestureDetectorCompat$GestureDetectorCompatImplBase
  implements GestureDetectorCompat.GestureDetectorCompatImpl
{
  private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
  private static final int LONGPRESS_TIMEOUT = ;
  private static final int LONG_PRESS = 2;
  private static final int SHOW_PRESS = 1;
  private static final int TAP = 3;
  private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
  private boolean mAlwaysInBiggerTapRegion;
  private boolean mAlwaysInTapRegion;
  MotionEvent mCurrentDownEvent;
  boolean mDeferConfirmSingleTap;
  GestureDetector.OnDoubleTapListener mDoubleTapListener;
  private int mDoubleTapSlopSquare;
  private float mDownFocusX;
  private float mDownFocusY;
  private final Handler mHandler;
  private boolean mInLongPress;
  private boolean mIsDoubleTapping;
  private boolean mIsLongpressEnabled;
  private float mLastFocusX;
  private float mLastFocusY;
  final GestureDetector.OnGestureListener mListener;
  private int mMaximumFlingVelocity;
  private int mMinimumFlingVelocity;
  private MotionEvent mPreviousUpEvent;
  boolean mStillDown;
  private int mTouchSlopSquare;
  private VelocityTracker mVelocityTracker;
  
  public GestureDetectorCompat$GestureDetectorCompatImplBase(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (paramHandler != null) {
      this.mHandler = new GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(this, paramHandler);
    } else {
      this.mHandler = new GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(this);
    }
    this.mListener = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    init(paramContext);
  }
  
  private void cancel()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
    this.mHandler.removeMessages(3);
    this.mVelocityTracker.recycle();
    this.mVelocityTracker = null;
    this.mIsDoubleTapping = false;
    this.mStillDown = false;
    this.mAlwaysInTapRegion = false;
    this.mAlwaysInBiggerTapRegion = false;
    this.mDeferConfirmSingleTap = false;
    if (this.mInLongPress) {
      this.mInLongPress = false;
    }
  }
  
  private void cancelTaps()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
    this.mHandler.removeMessages(3);
    this.mIsDoubleTapping = false;
    this.mAlwaysInTapRegion = false;
    this.mAlwaysInBiggerTapRegion = false;
    this.mDeferConfirmSingleTap = false;
    if (this.mInLongPress) {
      this.mInLongPress = false;
    }
  }
  
  private void init(Context paramContext)
  {
    if (paramContext != null)
    {
      if (this.mListener != null)
      {
        this.mIsLongpressEnabled = true;
        paramContext = ViewConfiguration.get(paramContext);
        int i = paramContext.getScaledTouchSlop();
        int j = paramContext.getScaledDoubleTapSlop();
        this.mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
        this.mTouchSlopSquare = (i * i);
        this.mDoubleTapSlopSquare = (j * j);
        return;
      }
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    throw new IllegalArgumentException("Context must not be null");
  }
  
  private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    boolean bool2 = this.mAlwaysInBiggerTapRegion;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > DOUBLE_TAP_TIMEOUT) {
      return false;
    }
    int i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
    int j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    if (i * i + j * j < this.mDoubleTapSlopSquare) {
      bool1 = true;
    }
    return bool1;
  }
  
  void dispatchLongPress()
  {
    this.mHandler.removeMessages(3);
    this.mDeferConfirmSingleTap = false;
    this.mInLongPress = true;
    this.mListener.onLongPress(this.mCurrentDownEvent);
  }
  
  public boolean isLongpressEnabled()
  {
    return this.mIsLongpressEnabled;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int n = i & 0xFF;
    boolean bool3 = false;
    if (n == 6) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = paramMotionEvent.getActionIndex();
    } else {
      j = -1;
    }
    int m = paramMotionEvent.getPointerCount();
    int k = 0;
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (k < m)
    {
      if (j != k)
      {
        f2 += paramMotionEvent.getX(k);
        f1 += paramMotionEvent.getY(k);
      }
      k += 1;
    }
    if (i != 0) {
      i = m - 1;
    } else {
      i = m;
    }
    float f3 = i;
    f2 /= f3;
    f1 /= f3;
    boolean bool2;
    MotionEvent localMotionEvent;
    Object localObject;
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 5)
            {
              if (n != 6) {
                return false;
              }
              this.mLastFocusX = f2;
              this.mDownFocusX = f2;
              this.mLastFocusY = f1;
              this.mDownFocusY = f1;
              this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
              j = paramMotionEvent.getActionIndex();
              i = paramMotionEvent.getPointerId(j);
              f1 = this.mVelocityTracker.getXVelocity(i);
              f2 = this.mVelocityTracker.getYVelocity(i);
              i = 0;
              for (;;)
              {
                bool2 = bool3;
                if (i >= m) {
                  break;
                }
                if (i != j)
                {
                  k = paramMotionEvent.getPointerId(i);
                  if (this.mVelocityTracker.getXVelocity(k) * f1 + this.mVelocityTracker.getYVelocity(k) * f2 < 0.0F)
                  {
                    this.mVelocityTracker.clear();
                    return false;
                  }
                }
                i += 1;
              }
            }
            this.mLastFocusX = f2;
            this.mDownFocusX = f2;
            this.mLastFocusY = f1;
            this.mDownFocusY = f1;
            cancelTaps();
            return false;
          }
          cancel();
          return false;
        }
        if (this.mInLongPress) {
          return false;
        }
        f3 = this.mLastFocusX - f2;
        float f4 = this.mLastFocusY - f1;
        if (this.mIsDoubleTapping) {
          return false | this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
        }
        if (this.mAlwaysInTapRegion)
        {
          i = (int)(f2 - this.mDownFocusX);
          j = (int)(f1 - this.mDownFocusY);
          i = i * i + j * j;
          if (i > this.mTouchSlopSquare)
          {
            bool2 = this.mListener.onScroll(this.mCurrentDownEvent, paramMotionEvent, f3, f4);
            this.mLastFocusX = f2;
            this.mLastFocusY = f1;
            this.mAlwaysInTapRegion = false;
            this.mHandler.removeMessages(3);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
          }
          else
          {
            bool2 = false;
          }
          bool3 = bool2;
          if (i > this.mTouchSlopSquare)
          {
            this.mAlwaysInBiggerTapRegion = false;
            bool3 = bool2;
          }
        }
        else
        {
          if (Math.abs(f3) < 1.0F)
          {
            bool2 = bool3;
            if (Math.abs(f4) < 1.0F) {
              break label1157;
            }
          }
          bool2 = this.mListener.onScroll(this.mCurrentDownEvent, paramMotionEvent, f3, f4);
          this.mLastFocusX = f2;
          this.mLastFocusY = f1;
          return bool2;
        }
      }
      else
      {
        this.mStillDown = false;
        localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.mIsDoubleTapping)
        {
          bool2 = this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
        }
        else
        {
          if (this.mInLongPress)
          {
            this.mHandler.removeMessages(3);
            this.mInLongPress = false;
          }
          else
          {
            if (this.mAlwaysInTapRegion)
            {
              bool2 = this.mListener.onSingleTapUp(paramMotionEvent);
              if (this.mDeferConfirmSingleTap)
              {
                localObject = this.mDoubleTapListener;
                if (localObject != null) {
                  ((GestureDetector.OnDoubleTapListener)localObject).onSingleTapConfirmed(paramMotionEvent);
                }
              }
              break label820;
            }
            localObject = this.mVelocityTracker;
            i = paramMotionEvent.getPointerId(0);
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            f1 = ((VelocityTracker)localObject).getYVelocity(i);
            f2 = ((VelocityTracker)localObject).getXVelocity(i);
            if ((Math.abs(f1) > this.mMinimumFlingVelocity) || (Math.abs(f2) > this.mMinimumFlingVelocity)) {
              break label802;
            }
          }
          bool2 = false;
          break label820;
          label802:
          bool2 = this.mListener.onFling(this.mCurrentDownEvent, paramMotionEvent, f2, f1);
        }
        label820:
        paramMotionEvent = this.mPreviousUpEvent;
        if (paramMotionEvent != null) {
          paramMotionEvent.recycle();
        }
        this.mPreviousUpEvent = localMotionEvent;
        paramMotionEvent = this.mVelocityTracker;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.mVelocityTracker = null;
        }
        this.mIsDoubleTapping = false;
        this.mDeferConfirmSingleTap = false;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        bool3 = bool2;
      }
      return bool3;
    }
    else
    {
      boolean bool1;
      if (this.mDoubleTapListener != null)
      {
        bool2 = this.mHandler.hasMessages(3);
        if (bool2) {
          this.mHandler.removeMessages(3);
        }
        localMotionEvent = this.mCurrentDownEvent;
        if (localMotionEvent != null)
        {
          localObject = this.mPreviousUpEvent;
          if ((localObject != null) && (bool2) && (isConsideredDoubleTap(localMotionEvent, (MotionEvent)localObject, paramMotionEvent)))
          {
            this.mIsDoubleTapping = true;
            bool1 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
            break label1011;
          }
        }
        this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
      }
      else
      {
        bool1 = false;
      }
      label1011:
      this.mLastFocusX = f2;
      this.mDownFocusX = f2;
      this.mLastFocusY = f1;
      this.mDownFocusY = f1;
      localMotionEvent = this.mCurrentDownEvent;
      if (localMotionEvent != null) {
        localMotionEvent.recycle();
      }
      this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
      this.mAlwaysInTapRegion = true;
      this.mAlwaysInBiggerTapRegion = true;
      this.mStillDown = true;
      this.mInLongPress = false;
      this.mDeferConfirmSingleTap = false;
      if (this.mIsLongpressEnabled)
      {
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
      }
      this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
      bool2 = bool1 | this.mListener.onDown(paramMotionEvent);
    }
    label1157:
    return bool2;
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean)
  {
    this.mIsLongpressEnabled = paramBoolean;
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.mDoubleTapListener = paramOnDoubleTapListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.GestureDetectorCompat.GestureDetectorCompatImplBase
 * JD-Core Version:    0.7.0.1
 */