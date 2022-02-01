package io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.view.AccessibilityBridge;

class AccessibilityEventsDelegate
{
  private AccessibilityBridge accessibilityBridge;
  
  public boolean requestSendAccessibilityEvent(@NonNull View paramView1, @NonNull View paramView2, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityBridge localAccessibilityBridge = this.accessibilityBridge;
    if (localAccessibilityBridge == null) {
      return false;
    }
    return localAccessibilityBridge.externalViewRequestSendAccessibilityEvent(paramView1, paramView2, paramAccessibilityEvent);
  }
  
  void setAccessibilityBridge(@Nullable AccessibilityBridge paramAccessibilityBridge)
  {
    this.accessibilityBridge = paramAccessibilityBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.AccessibilityEventsDelegate
 * JD-Core Version:    0.7.0.1
 */