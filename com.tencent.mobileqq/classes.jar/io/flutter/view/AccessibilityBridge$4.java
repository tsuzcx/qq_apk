package io.flutter.view;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

class AccessibilityBridge$4
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  AccessibilityBridge$4(AccessibilityBridge paramAccessibilityBridge, AccessibilityManager paramAccessibilityManager) {}
  
  public void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    if (AccessibilityBridge.access$400(this.this$0)) {
      return;
    }
    if (paramBoolean) {
      AccessibilityBridge.access$1002(this.this$0, AccessibilityBridge.access$1000(this.this$0) | AccessibilityBridge.AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
    }
    for (;;)
    {
      AccessibilityBridge.access$1100(this.this$0);
      if (AccessibilityBridge.access$700(this.this$0) == null) {
        break;
      }
      AccessibilityBridge.access$700(this.this$0).onAccessibilityChanged(this.val$accessibilityManager.isEnabled(), paramBoolean);
      return;
      AccessibilityBridge.access$1200(this.this$0);
      AccessibilityBridge.access$1002(this.this$0, AccessibilityBridge.access$1000(this.this$0) & (AccessibilityBridge.AccessibilityFeature.ACCESSIBLE_NAVIGATION.value ^ 0xFFFFFFFF));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.4
 * JD-Core Version:    0.7.0.1
 */