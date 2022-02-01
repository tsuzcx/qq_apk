package com.tencent.qcircle.tavcut.view.ext;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.tencent.qcircle.tavcut.view.TAVCutImageViewKt;

public class TAVGestureDetector
{
  private static final int INVALID_POINTER_ID = -1;
  private float angle = 0.0F;
  private PointF center = null;
  private float fX = 0.0F;
  private float fY = 0.0F;
  private boolean firstTouch = false;
  private float focalX = 0.0F;
  private float focalY = 0.0F;
  private boolean isRotating;
  private boolean isZoomButtonOperating = false;
  private int mActivePointerId = -1;
  private int mActivePointerIndex = 0;
  private boolean mIsDragging;
  private float mLastTouchX;
  private float mLastTouchY;
  private OnGestureListener mListener;
  private final float mMinimumVelocity;
  private final ScaleGestureDetector mScaleDetector;
  private final float mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private float maxDis = 0.0F;
  private int ptrID1 = -1;
  private int ptrID2 = -1;
  private float sX = 0.0F;
  private float sY = 0.0F;
  
  public TAVGestureDetector(Context paramContext, OnGestureListener paramOnGestureListener)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mListener = paramOnGestureListener;
    this.mScaleDetector = new ScaleGestureDetector(paramContext, new TAVGestureDetector.1(this));
  }
  
  private float angleBetweenLines(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramFloat5 = (float)Math.atan2(paramFloat6 - paramFloat8, paramFloat5 - paramFloat7);
    paramFloat1 = (float)Math.atan2(paramFloat2 - paramFloat4, paramFloat1 - paramFloat3);
    return findAngleDelta(Math.toDegrees(paramFloat5), Math.toDegrees(paramFloat1));
  }
  
  private float findAngleDelta(double paramDouble1, double paramDouble2)
  {
    float f1 = (float)(paramDouble2 % 360.0D);
    float f2 = (float)(paramDouble1 % 360.0D) - f1;
    if (f2 < -180.0F) {
      return f2 + 360.0F;
    }
    f1 = f2;
    if (f2 > 180.0F) {
      f1 = f2 - 360.0F;
    }
    return f1;
  }
  
  private float getActiveX(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getX(this.mActivePointerIndex);
      return f;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getX();
  }
  
  private float getActiveY(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getY(this.mActivePointerIndex);
      return f;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return paramMotionEvent.getY();
  }
  
  private boolean processTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    int j = 0;
    VelocityTracker localVelocityTracker;
    if (i != 0)
    {
      float f1;
      float f2;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i == 6)
              {
                this.ptrID2 = -1;
                if (!this.isZoomButtonOperating)
                {
                  i = Util.getPointerIndex(paramMotionEvent.getAction());
                  if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
                  {
                    if (i == 0) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    this.mActivePointerId = paramMotionEvent.getPointerId(i);
                    this.mLastTouchX = paramMotionEvent.getX(i);
                    this.mLastTouchY = paramMotionEvent.getY(i);
                  }
                }
              }
            }
            else if (!this.isZoomButtonOperating)
            {
              this.fX = paramMotionEvent.getX();
              this.fY = paramMotionEvent.getY();
              this.focalX = ((this.fX + this.sX) / 2.0F);
              this.focalY = ((this.fY + this.sY) / 2.0F);
              this.ptrID2 = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.angle = 0.0F;
            }
          }
          else
          {
            this.ptrID1 = -1;
            this.ptrID2 = -1;
            this.mActivePointerId = -1;
            this.isZoomButtonOperating = false;
            localVelocityTracker = this.mVelocityTracker;
            if (localVelocityTracker != null)
            {
              localVelocityTracker.recycle();
              this.mVelocityTracker = null;
            }
          }
        }
        else
        {
          float f3 = getActiveX(paramMotionEvent);
          f1 = getActiveY(paramMotionEvent);
          f2 = f3 - this.mLastTouchX;
          float f4 = f1 - this.mLastTouchY;
          if (!this.mIsDragging)
          {
            if (Math.sqrt(f2 * f2 + f4 * f4) >= this.mTouchSlop) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            this.mIsDragging = paramBoolean;
          }
          i = this.ptrID1;
          if ((i != -1) && (this.ptrID2 != -1))
          {
            f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(i));
            f2 = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.ptrID1));
            f3 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.ptrID2));
            f4 = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.ptrID2));
            if (this.firstTouch)
            {
              this.angle = 0.0F;
              this.firstTouch = false;
              this.isRotating = true;
            }
            else
            {
              this.angle = angleBetweenLines(this.fX, this.fY, this.sX, this.sY, f3, f4, f1, f2);
              if (Float.compare(this.angle, 0.0F) != 0) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              }
              this.isRotating = paramBoolean;
            }
            if (Math.abs(this.angle) <= 10.0F) {
              this.mListener.onRotation(this.sX, this.sY, this.angle);
            }
            this.fX = f3;
            this.fY = f4;
            this.sX = f1;
            this.sY = f2;
          }
          else if (this.isZoomButtonOperating)
          {
            if (this.firstTouch)
            {
              this.angle = 0.0F;
              this.firstTouch = false;
              this.isRotating = true;
            }
            else
            {
              f4 = this.center.x;
              float f5 = this.center.y;
              float f6 = this.mLastTouchX;
              float f7 = this.mLastTouchY;
              float f8 = this.center.x;
              float f9 = this.center.y;
              f2 = f1;
              this.angle = angleBetweenLines(f4, f5, f6, f7, f8, f9, f3, f1);
              if (Float.compare(this.angle, 0.0F) != 0) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              }
              this.isRotating = paramBoolean;
              double d1 = TAVCutImageViewKt.calcDistance(this.center, new PointF(f3, f2));
              double d2 = this.maxDis;
              Double.isNaN(d2);
              if (d1 >= d2 * 0.25D)
              {
                f2 = TAVCutImageViewKt.calcDistance(this.center, new PointF(f3, f2)) / TAVCutImageViewKt.calcDistance(this.center, new PointF(this.mLastTouchX, this.mLastTouchY));
                this.mListener.onScale(f2, this.center.x, this.center.y);
              }
              this.mListener.onRotation(this.center.x, this.center.y, this.angle);
            }
            this.mLastTouchX = f3;
            this.mLastTouchY = f1;
          }
          else if (this.mIsDragging)
          {
            if ((Math.abs(f2) < this.mTouchSlop * 5.0F) && (Math.abs(f4) < this.mTouchSlop * 5.0F)) {
              this.mListener.onDrag(f2, f4);
            }
            this.mLastTouchX = f3;
            this.mLastTouchY = f1;
            localVelocityTracker = this.mVelocityTracker;
            if (localVelocityTracker != null) {
              localVelocityTracker.addMovement(paramMotionEvent);
            }
          }
        }
      }
      else
      {
        this.ptrID1 = -1;
        this.mActivePointerId = -1;
        this.isZoomButtonOperating = false;
        if ((this.mIsDragging) && (this.mVelocityTracker != null))
        {
          this.mLastTouchX = getActiveX(paramMotionEvent);
          this.mLastTouchY = getActiveY(paramMotionEvent);
          this.mVelocityTracker.addMovement(paramMotionEvent);
          this.mVelocityTracker.computeCurrentVelocity(1000);
          f1 = this.mVelocityTracker.getXVelocity();
          f2 = this.mVelocityTracker.getYVelocity();
          if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.mMinimumVelocity) {
            this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -f1, -f2);
          }
        }
        localVelocityTracker = this.mVelocityTracker;
        if (localVelocityTracker != null)
        {
          localVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
      }
    }
    else
    {
      this.isZoomButtonOperating = paramBoolean;
      this.ptrID1 = paramMotionEvent.getPointerId(0);
      this.sX = paramMotionEvent.getX();
      this.sY = paramMotionEvent.getY();
      this.angle = 0.0F;
      this.firstTouch = true;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mVelocityTracker = VelocityTracker.obtain();
      localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.addMovement(paramMotionEvent);
      }
      this.mLastTouchX = getActiveX(paramMotionEvent);
      this.mLastTouchY = getActiveY(paramMotionEvent);
      this.mIsDragging = false;
    }
    int k = this.mActivePointerId;
    i = j;
    if (k != -1) {
      i = k;
    }
    this.mActivePointerIndex = paramMotionEvent.findPointerIndex(i);
    return true;
  }
  
  public boolean isDragging()
  {
    return this.mIsDragging;
  }
  
  public boolean isRotating()
  {
    return this.isRotating;
  }
  
  public boolean isScaling()
  {
    return this.mScaleDetector.isInProgress();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    try
    {
      this.mScaleDetector.onTouchEvent(paramMotionEvent);
      paramBoolean = processTouchEvent(paramMotionEvent, paramBoolean);
      return paramBoolean;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      label18:
      break label18;
    }
    return true;
  }
  
  public void setCenter(PointF paramPointF, float paramFloat)
  {
    this.center = paramPointF;
    this.maxDis = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.ext.TAVGestureDetector
 * JD-Core Version:    0.7.0.1
 */