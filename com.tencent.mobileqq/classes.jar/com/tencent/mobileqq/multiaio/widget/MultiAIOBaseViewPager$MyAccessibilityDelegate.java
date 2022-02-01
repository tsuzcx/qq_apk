package com.tencent.mobileqq.multiaio.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.PagerAdapter;

class MultiAIOBaseViewPager$MyAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  MultiAIOBaseViewPager$MyAccessibilityDelegate(MultiAIOBaseViewPager paramMultiAIOBaseViewPager) {}
  
  private boolean a()
  {
    return (this.a.a != null) && (this.a.a.getCount() > 1);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MultiAIOBaseViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(a());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (this.a.a != null))
    {
      paramAccessibilityEvent.setItemCount(this.a.a.getCount());
      paramAccessibilityEvent.setFromIndex(this.a.b);
      paramAccessibilityEvent.setToIndex(this.a.b);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(MultiAIOBaseViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(a());
    if (this.a.canScrollHorizontally(1)) {
      paramAccessibilityNodeInfoCompat.addAction(4096);
    }
    if (this.a.canScrollHorizontally(-1)) {
      paramAccessibilityNodeInfoCompat.addAction(8192);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    if (paramInt != 4096)
    {
      if (paramInt != 8192) {
        return false;
      }
      if (this.a.canScrollHorizontally(-1))
      {
        paramView = this.a;
        paramView.setCurrentItem(paramView.b - 1);
        return true;
      }
      return false;
    }
    if (this.a.canScrollHorizontally(1))
    {
      paramView = this.a;
      paramView.setCurrentItem(paramView.b + 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.MyAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */