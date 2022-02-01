package com.tencent.mobileqq.nearby.now.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class StuffContainerView$OnGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private StuffContainerView$OnGestureListener(StuffContainerView paramStuffContainerView) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.a.a == null) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((paramMotionEvent2 != null) && (paramMotionEvent1 != null))
    {
      float f1 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      float f2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
      if (Math.abs(f1) > Math.abs(f2))
      {
        double d1 = Math.abs(f2);
        double d2 = Math.sqrt(f2 * f2 + f1 * f1);
        Double.isNaN(d1);
        if (Math.abs(Math.asin(d1 / d2)) < 0.5235987755982988D) {
          if (f1 < 0.0F) {
            this.a.a.onFlingUp();
          } else {
            this.a.a.onFlingDown();
          }
        }
      }
      else if (f2 > 0.0F)
      {
        this.a.a.onFlingRight();
      }
      else
      {
        this.a.a.onFlingLeft();
      }
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.onSingleTap();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.StuffContainerView.OnGestureListener
 * JD-Core Version:    0.7.0.1
 */