package com.tencent.mobileqq.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class BounceScrollView$1
  extends GestureDetector.SimpleOnGestureListener
{
  BounceScrollView$1(BounceScrollView paramBounceScrollView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) >= Math.abs(paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BounceScrollView.1
 * JD-Core Version:    0.7.0.1
 */