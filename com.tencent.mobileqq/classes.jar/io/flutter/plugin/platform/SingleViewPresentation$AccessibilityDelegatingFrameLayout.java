package io.flutter.plugin.platform;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

class SingleViewPresentation$AccessibilityDelegatingFrameLayout
  extends FrameLayout
{
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private final View embeddedView;
  
  public SingleViewPresentation$AccessibilityDelegatingFrameLayout(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, View paramView)
  {
    super(paramContext);
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.embeddedView = paramView;
  }
  
  public boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.accessibilityEventsDelegate.requestSendAccessibilityEvent(this.embeddedView, paramView, paramAccessibilityEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.AccessibilityDelegatingFrameLayout
 * JD-Core Version:    0.7.0.1
 */