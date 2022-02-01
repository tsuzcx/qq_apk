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
    if ((paramInt == 1) && (this.a != null)) {
      this.a.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.AccessibilityUtil.5
 * JD-Core Version:    0.7.0.1
 */