package io.flutter.view;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

class AccessibilityBridge$4
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  public void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    if (AccessibilityBridge.access$400(this.this$0)) {
      return;
    }
    if (paramBoolean)
    {
      AccessibilityBridge.access$1076(this.this$0, AccessibilityBridge.AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
    }
    else
    {
      AccessibilityBridge.access$1200(this.this$0);
      AccessibilityBridge.access$1072(this.this$0, AccessibilityBridge.AccessibilityFeature.ACCESSIBLE_NAVIGATION.value ^ 0xFFFFFFFF);
    }
    AccessibilityBridge.access$1100(this.this$0);
    if (AccessibilityBridge.access$700(this.this$0) != null) {
      AccessibilityBridge.access$700(this.this$0).onAccessibilityChanged(this.val$accessibilityManager.isEnabled(), paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.4
 * JD-Core Version:    0.7.0.1
 */