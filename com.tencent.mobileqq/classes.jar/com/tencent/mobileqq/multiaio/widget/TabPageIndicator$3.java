package com.tencent.mobileqq.multiaio.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class TabPageIndicator$3
  extends GestureDetector.SimpleOnGestureListener
{
  TabPageIndicator$3(TabPageIndicator paramTabPageIndicator) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSingleTapConfirmed() called with: e = [");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("]");
      QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
    }
    if (TabPageIndicator.a(this.a) != null) {
      this.a.performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.TabPageIndicator.3
 * JD-Core Version:    0.7.0.1
 */