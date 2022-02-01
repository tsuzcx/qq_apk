package com.tencent.mobileqq.swipe;

import android.app.Activity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class SwipeBackLayout$DefaultLayoutGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  protected SwipeBackLayout$DefaultLayoutGestureDetector(SwipeBackLayout paramSwipeBackLayout) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      if ((this.a.allowedSliding) && (paramFloat1 >= 200.0F))
      {
        if ((f1 < 0.0F) && (f2 < 0.5F)) {
          if ((this.a.mContext instanceof Activity))
          {
            SwipeBackLayout localSwipeBackLayout = this.a;
            localSwipeBackLayout.isFling = true;
            localSwipeBackLayout.scrollRight();
          }
          else
          {
            this.a.scrollRight();
          }
        }
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.swipe.SwipeBackLayout.DefaultLayoutGestureDetector
 * JD-Core Version:    0.7.0.1
 */