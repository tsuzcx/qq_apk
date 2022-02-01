package com.tencent.mobileqq.util;

import android.view.View;
import android.view.View.AccessibilityDelegate;

final class AccessibilityUtil$5
  extends View.AccessibilityDelegate
{
  AccessibilityUtil$5(AccessibilityUtil.ViewOnClickListener paramViewOnClickListener) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if (paramInt == 1)
    {
      AccessibilityUtil.ViewOnClickListener localViewOnClickListener = this.a;
      if (localViewOnClickListener != null) {
        localViewOnClickListener.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.AccessibilityUtil.5
 * JD-Core Version:    0.7.0.1
 */