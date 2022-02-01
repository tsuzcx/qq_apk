package com.tencent.widget;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class ScaleGestureDetector
{
  private static final float PRESSURE_THRESHOLD = 0.67F;
  private static final String TAG = "ScaleGestureDetector";
  private boolean mActive0MostRecent;
  private int mActiveId0;
  private int mActiveId1;
  private final Context mContext;
  private MotionEvent mCurrEvent;
  private float mCurrFingerDiffX;
  private float mCurrFingerDiffY;
  private float mCurrLen;
  private float mCurrPressure;
  private float mFocusX;
  private float mFocusY;
  private boolean mGestureInProgress;
  private boolean mInvalidGesture;
  private final ScaleGestureDetector.OnScaleGestureListener mListener;
  private MotionEvent mPrevEvent;
  private float mPrevFingerDiffX;
  private float mPrevFingerDiffY;
  private float mPrevLen;
  private float mPrevPressure;
  private float mScaleFactor;
  private long mTimeDelta;
  
  public ScaleGestureDetector(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener)
  {
    this.mContext = paramContext;
    this.mListener = paramOnScaleGestureListener;
  }
  
  private int findNewActiveIndex(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.findPointerIndex(paramInt1);
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      if ((paramInt1 != paramInt2) && (paramInt1 != j)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  private int getActionIndex(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() & 0xFF00) >> 8;
  }
  
  private void reset()
  {
    MotionEvent localMotionEvent = this.mPrevEvent;
    if (localMotionEvent != null)
    {
      localMotionEvent.recycle();
      this.mPrevEvent = null;
    }
    localMotionEvent = this.mCurrEvent;
    if (localMotionEvent != null)
    {
      localMotionEvent.recycle();
      this.mCurrEvent = null;
    }
    this.mGestureInProgress = false;
    this.mActiveId0 = -1;
    this.mActiveId1 = -1;
    this.mInvalidGesture = false;
  }
  
  private void setContext(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = this.mCurrEvent;
    if (localMotionEvent != null) {
      localMotionEvent.recycle();
    }
    this.mCurrEvent = MotionEvent.obtain(paramMotionEvent);
    this.mCurrLen = -1.0F;
    this.mPrevLen = -1.0F;
    this.mScaleFactor = -1.0F;
    localMotionEvent = this.mPrevEvent;
    int i = localMotionEvent.findPointerIndex(this.mActiveId0);
    int j = localMotionEvent.findPointerIndex(this.mActiveId1);
    int k = paramMotionEvent.findPointerIndex(this.mActiveId0);
    int m = paramMotionEvent.findPointerIndex(this.mActiveId1);
    if ((i >= 0) && (j >= 0) && (k >= 0) && (m >= 0))
    {
      float f1 = localMotionEvent.getX(i);
      float f2 = localMotionEvent.getY(i);
      float f3 = localMotionEvent.getX(j);
      float f4 = localMotionEvent.getY(j);
      float f5 = paramMotionEvent.getX(k);
      float f6 = paramMotionEvent.getY(k);
      float f8 = paramMotionEvent.getX(m);
      float f7 = paramMotionEvent.getY(m);
      f8 -= f5;
      f7 -= f6;
      this.mPrevFingerDiffX = (f3 - f1);
      this.mPrevFingerDiffY = (f4 - f2);
      this.mCurrFingerDiffX = f8;
      this.mCurrFingerDiffY = f7;
      this.mFocusX = (f5 + f8 * 0.5F);
      this.mFocusY = (f6 + f7 * 0.5F);
      this.mTimeDelta = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
      this.mCurrPressure = (paramMotionEvent.getPressure(k) + paramMotionEvent.getPressure(m));
      this.mPrevPressure = (localMotionEvent.getPressure(i) + localMotionEvent.getPressure(j));
      return;
    }
    this.mInvalidGesture = true;
    if (QLog.isColorLevel()) {
      QLog.e("ScaleGestureDetector", 2, "Invalid MotionEvent stream detected.", new Throwable());
    }
    if (this.mGestureInProgress) {
      this.mListener.onScaleEnd(this);
    }
  }
  
  public float getCurrentSpan()
  {
    if (this.mCurrLen == -1.0F)
    {
      float f1 = this.mCurrFingerDiffX;
      float f2 = this.mCurrFingerDiffY;
      this.mCurrLen = ((float)Math.sqrt(f1 * f1 + f2 * f2));
    }
    return this.mCurrLen;
  }
  
  public float getCurrentSpanX()
  {
    return this.mCurrFingerDiffX;
  }
  
  public float getCurrentSpanY()
  {
    return this.mCurrFingerDiffY;
  }
  
  public long getEventTime()
  {
    return this.mCurrEvent.getEventTime();
  }
  
  public float getFocusX()
  {
    return this.mFocusX;
  }
  
  public float getFocusY()
  {
    return this.mFocusY;
  }
  
  public float getPreviousSpan()
  {
    if (this.mPrevLen == -1.0F)
    {
      float f1 = this.mPrevFingerDiffX;
      float f2 = this.mPrevFingerDiffY;
      this.mPrevLen = ((float)Math.sqrt(f1 * f1 + f2 * f2));
    }
    return this.mPrevLen;
  }
  
  public float getPreviousSpanX()
  {
    return this.mPrevFingerDiffX;
  }
  
  public float getPreviousSpanY()
  {
    return this.mPrevFingerDiffY;
  }
  
  public float getScaleFactor()
  {
    if (this.mScaleFactor == -1.0F) {
      this.mScaleFactor = (getCurrentSpan() / getPreviousSpan());
    }
    return this.mScaleFactor;
  }
  
  public long getTimeDelta()
  {
    return this.mTimeDelta;
  }
  
  public boolean isInProgress()
  {
    return this.mGestureInProgress;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      reset();
    }
    boolean bool = this.mInvalidGesture;
    int j = 0;
    if (bool) {
      return false;
    }
    Object localObject;
    if (!this.mGestureInProgress)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 5)
          {
            localObject = this.mPrevEvent;
            if (localObject != null) {
              ((MotionEvent)localObject).recycle();
            }
            this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
            this.mTimeDelta = 0L;
            i = getActionIndex(paramMotionEvent);
            j = paramMotionEvent.findPointerIndex(this.mActiveId0);
            this.mActiveId1 = paramMotionEvent.getPointerId(i);
            if ((j < 0) || (j == i)) {
              this.mActiveId0 = paramMotionEvent.getPointerId(findNewActiveIndex(paramMotionEvent, this.mActiveId1, -1));
            }
            this.mActive0MostRecent = false;
            setContext(paramMotionEvent);
            this.mGestureInProgress = this.mListener.onScaleBegin(this);
          }
        }
        else {
          reset();
        }
      }
      else
      {
        this.mActiveId0 = paramMotionEvent.getPointerId(0);
        this.mActive0MostRecent = true;
      }
    }
    else if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5)
          {
            if (i == 6)
            {
              i = paramMotionEvent.getPointerCount();
              int m = getActionIndex(paramMotionEvent);
              int k = paramMotionEvent.getPointerId(m);
              if (i > 2)
              {
                int n = this.mActiveId0;
                if (k == n)
                {
                  i = findNewActiveIndex(paramMotionEvent, this.mActiveId1, m);
                  if (i >= 0)
                  {
                    this.mListener.onScaleEnd(this);
                    this.mActiveId0 = paramMotionEvent.getPointerId(i);
                    this.mActive0MostRecent = true;
                    this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
                    setContext(paramMotionEvent);
                    this.mGestureInProgress = this.mListener.onScaleBegin(this);
                    i = j;
                    break label409;
                  }
                }
                else
                {
                  i = j;
                  if (k != this.mActiveId1) {
                    break label409;
                  }
                  i = findNewActiveIndex(paramMotionEvent, n, m);
                  if (i >= 0)
                  {
                    this.mListener.onScaleEnd(this);
                    this.mActiveId1 = paramMotionEvent.getPointerId(i);
                    this.mActive0MostRecent = false;
                    this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
                    setContext(paramMotionEvent);
                    this.mGestureInProgress = this.mListener.onScaleBegin(this);
                    i = j;
                    break label409;
                  }
                }
                i = 1;
                label409:
                this.mPrevEvent.recycle();
                this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
                setContext(paramMotionEvent);
              }
              else
              {
                i = 1;
              }
              if (i != 0)
              {
                setContext(paramMotionEvent);
                j = this.mActiveId0;
                i = j;
                if (k == j) {
                  i = this.mActiveId1;
                }
                j = paramMotionEvent.findPointerIndex(i);
                this.mFocusX = paramMotionEvent.getX(j);
                this.mFocusY = paramMotionEvent.getY(j);
                this.mListener.onScaleEnd(this);
                reset();
                this.mActiveId0 = i;
                this.mActive0MostRecent = true;
              }
            }
          }
          else
          {
            this.mListener.onScaleEnd(this);
            i = this.mActiveId0;
            j = this.mActiveId1;
            reset();
            this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
            if (!this.mActive0MostRecent) {
              i = j;
            }
            this.mActiveId0 = i;
            this.mActiveId1 = paramMotionEvent.getPointerId(getActionIndex(paramMotionEvent));
            this.mActive0MostRecent = false;
            if ((paramMotionEvent.findPointerIndex(this.mActiveId0) < 0) || (this.mActiveId0 == this.mActiveId1))
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Got ");
                ((StringBuilder)localObject).append(paramMotionEvent.toString());
                ((StringBuilder)localObject).append(" with bad state while a gesture was in progress. Did you forget to pass an event to ScaleGestureDetector#onTouchEvent?");
                QLog.e("ScaleGestureDetector", 2, ((StringBuilder)localObject).toString());
              }
              this.mActiveId0 = paramMotionEvent.getPointerId(findNewActiveIndex(paramMotionEvent, this.mActiveId1, -1));
            }
            setContext(paramMotionEvent);
            this.mGestureInProgress = this.mListener.onScaleBegin(this);
          }
        }
        else
        {
          this.mListener.onScaleEnd(this);
          reset();
        }
      }
      else
      {
        setContext(paramMotionEvent);
        if ((this.mCurrPressure / this.mPrevPressure > 0.67F) && (this.mListener.onScale(this)))
        {
          this.mPrevEvent.recycle();
          this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
        }
      }
    }
    else {
      reset();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ScaleGestureDetector
 * JD-Core Version:    0.7.0.1
 */