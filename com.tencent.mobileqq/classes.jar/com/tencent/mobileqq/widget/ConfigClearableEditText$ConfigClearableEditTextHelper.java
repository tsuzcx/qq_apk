package com.tencent.mobileqq.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ConfigClearableEditText$ConfigClearableEditTextHelper
  extends ExploreByTouchHelper
{
  public ConfigClearableEditText$ConfigClearableEditTextHelper(ConfigClearableEditText paramConfigClearableEditText, View paramView)
  {
    super(paramView);
  }
  
  protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    if ((ConfigClearableEditText.c(this.a)) && (paramFloat1 > ConfigClearableEditText.a(this.a))) {
      return 0;
    }
    return -1;
  }
  
  protected void getVisibleVirtualViews(List<Integer> paramList)
  {
    if (ConfigClearableEditText.c(this.a)) {
      paramList.add(Integer.valueOf(0));
    }
  }
  
  protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onPerformActionForVirtualView virtualViewId:");
      paramBundle.append(paramInt1);
      QLog.d("ConfigClearableEditTextHelper", 2, paramBundle.toString());
    }
    return false;
  }
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramInt == 0) {
      paramAccessibilityEvent.setContentDescription(QQUIDelegate.a(2131900145));
    }
  }
  
  protected void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramInt == 0)
    {
      paramAccessibilityNodeInfoCompat.setContentDescription(QQUIDelegate.a(2131900145));
      paramAccessibilityNodeInfoCompat.addAction(16);
      paramInt = ConfigClearableEditText.a(this.a);
      paramAccessibilityNodeInfoCompat.setBoundsInParent(new Rect(paramInt, this.a.getPaddingTop(), this.a.a.getIntrinsicWidth() + paramInt, this.a.getHeight() - this.a.getPaddingBottom()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ConfigClearableEditText.ConfigClearableEditTextHelper
 * JD-Core Version:    0.7.0.1
 */