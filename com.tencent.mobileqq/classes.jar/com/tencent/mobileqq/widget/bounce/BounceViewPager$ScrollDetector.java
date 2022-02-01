package com.tencent.mobileqq.widget.bounce;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class BounceViewPager$ScrollDetector
  extends GestureDetector.SimpleOnGestureListener
{
  BounceViewPager$ScrollDetector(BounceViewPager paramBounceViewPager) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1) > Math.abs(paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.bounce.BounceViewPager.ScrollDetector
 * JD-Core Version:    0.7.0.1
 */