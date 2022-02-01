package com.tencent.qqmini.sdk.core.utils;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

final class AccessibilityUtil$1
  extends View.AccessibilityDelegate
{
  AccessibilityUtil$1(CharSequence paramCharSequence, String paramString) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if (this.val$contentDesc != null) {
      paramAccessibilityNodeInfo.setContentDescription(this.val$contentDesc);
    }
    paramAccessibilityNodeInfo.setClassName(this.val$className);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.AccessibilityUtil.1
 * JD-Core Version:    0.7.0.1
 */