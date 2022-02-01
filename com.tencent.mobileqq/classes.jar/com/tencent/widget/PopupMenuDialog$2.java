package com.tencent.widget;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class PopupMenuDialog$2
  extends View.AccessibilityDelegate
{
  PopupMenuDialog$2(PopupMenuDialog paramPopupMenuDialog) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PopupMenuDialog.2
 * JD-Core Version:    0.7.0.1
 */