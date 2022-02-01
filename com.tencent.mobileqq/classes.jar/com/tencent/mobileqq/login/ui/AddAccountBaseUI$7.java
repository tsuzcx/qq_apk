package com.tencent.mobileqq.login.ui;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

class AddAccountBaseUI$7
  implements Runnable
{
  AddAccountBaseUI$7(AddAccountBaseUI paramAddAccountBaseUI) {}
  
  public void run()
  {
    AddAccountBaseUI localAddAccountBaseUI = this.this$0;
    AddAccountBaseUI.a(localAddAccountBaseUI, new AddAccountBaseUI.KeyboardLayoutListener(localAddAccountBaseUI));
    this.this$0.i.getViewTreeObserver().addOnGlobalLayoutListener(AddAccountBaseUI.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI.7
 * JD-Core Version:    0.7.0.1
 */