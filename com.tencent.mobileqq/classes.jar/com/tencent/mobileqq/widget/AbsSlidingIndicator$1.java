package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class AbsSlidingIndicator$1
  extends View.AccessibilityDelegate
{
  AbsSlidingIndicator$1(AbsSlidingIndicator paramAbsSlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AbsSlidingIndicator.1
 * JD-Core Version:    0.7.0.1
 */