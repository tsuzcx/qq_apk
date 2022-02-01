package com.tencent.mobileqq.multicard;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class MultiCardPageIndicator$2
  extends GestureDetector.SimpleOnGestureListener
{
  MultiCardPageIndicator$2(MultiCardPageIndicator paramMultiCardPageIndicator) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onSingleTapConfirmed() called with: e = [" + paramMotionEvent + "]");
    }
    if (MultiCardPageIndicator.a(this.a) != null) {
      this.a.performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPageIndicator.2
 * JD-Core Version:    0.7.0.1
 */