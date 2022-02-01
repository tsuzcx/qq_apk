package com.tencent.mobileqq.multiaio.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MultiAIOViewPager$1
  extends GestureDetector.SimpleOnGestureListener
{
  MultiAIOViewPager$1(MultiAIOViewPager paramMultiAIOViewPager) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (MultiAIOViewPager.a(this.a) != null) {
      this.a.performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager.1
 * JD-Core Version:    0.7.0.1
 */