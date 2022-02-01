package com.tencent.mobileqq.onlinestatus;

import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class AccountPanel$3
  extends View.AccessibilityDelegate
{
  AccountPanel$3(AccountPanel paramAccountPanel, ClickableSpan paramClickableSpan) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if ((paramInt == 1) && (this.jdField_a_of_type_AndroidTextStyleClickableSpan != null)) {
      this.jdField_a_of_type_AndroidTextStyleClickableSpan.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.3
 * JD-Core Version:    0.7.0.1
 */