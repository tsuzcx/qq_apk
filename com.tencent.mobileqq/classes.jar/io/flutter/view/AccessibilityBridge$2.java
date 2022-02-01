package io.flutter.view;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;

class AccessibilityBridge$2
  implements AccessibilityManager.AccessibilityStateChangeListener
{
  AccessibilityBridge$2(AccessibilityBridge paramAccessibilityBridge) {}
  
  public void onAccessibilityStateChanged(boolean paramBoolean)
  {
    if (AccessibilityBridge.access$400(this.this$0)) {
      return;
    }
    if (paramBoolean)
    {
      AccessibilityBridge.access$600(this.this$0).setAccessibilityMessageHandler(AccessibilityBridge.access$500(this.this$0));
      AccessibilityBridge.access$600(this.this$0).onAndroidAccessibilityEnabled();
    }
    else
    {
      AccessibilityBridge.access$600(this.this$0).setAccessibilityMessageHandler(null);
      AccessibilityBridge.access$600(this.this$0).onAndroidAccessibilityDisabled();
    }
    if (AccessibilityBridge.access$700(this.this$0) != null) {
      AccessibilityBridge.access$700(this.this$0).onAccessibilityChanged(paramBoolean, AccessibilityBridge.access$800(this.this$0).isTouchExplorationEnabled());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.2
 * JD-Core Version:    0.7.0.1
 */