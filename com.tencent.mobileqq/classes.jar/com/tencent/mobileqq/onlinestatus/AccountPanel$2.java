package com.tencent.mobileqq.onlinestatus;

import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class AccountPanel$2
  extends View.AccessibilityDelegate
{
  AccountPanel$2(AccountPanel paramAccountPanel, ClickableSpan paramClickableSpan) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if (paramInt == 1)
    {
      ClickableSpan localClickableSpan = this.jdField_a_of_type_AndroidTextStyleClickableSpan;
      if (localClickableSpan != null) {
        localClickableSpan.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.2
 * JD-Core Version:    0.7.0.1
 */