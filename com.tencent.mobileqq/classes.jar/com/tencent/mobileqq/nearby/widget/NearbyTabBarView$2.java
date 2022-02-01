package com.tencent.mobileqq.nearby.widget;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class NearbyTabBarView$2
  extends AccessibilityDelegateCompat
{
  NearbyTabBarView$2(NearbyTabBarView paramNearbyTabBarView) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    boolean bool;
    if (NearbyTabBarView.a(this.a, paramView) == NearbyTabBarView.b(this.a)) {
      bool = true;
    } else {
      bool = false;
    }
    paramAccessibilityNodeInfoCompat.setSelected(bool);
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyTabBarView.2
 * JD-Core Version:    0.7.0.1
 */