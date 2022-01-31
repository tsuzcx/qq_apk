package com.tencent.viola.ui.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class VPageSliderView$YScrollDetector
  extends GestureDetector.SimpleOnGestureListener
{
  VPageSliderView$YScrollDetector(VPageSliderView paramVPageSliderView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) > Math.abs(paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.VPageSliderView.YScrollDetector
 * JD-Core Version:    0.7.0.1
 */