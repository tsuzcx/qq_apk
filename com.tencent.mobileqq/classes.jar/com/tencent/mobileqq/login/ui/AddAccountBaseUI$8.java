package com.tencent.mobileqq.login.ui;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class AddAccountBaseUI$8
  implements Runnable
{
  AddAccountBaseUI$8(AddAccountBaseUI paramAddAccountBaseUI) {}
  
  public void run()
  {
    Object localObject;
    if (this.this$0.m == 1) {
      localObject = this.this$0.b;
    } else {
      localObject = this.this$0.c;
    }
    ((EditText)localObject).requestFocus();
    this.this$0.j.showSoftInput((View)localObject, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI.8
 * JD-Core Version:    0.7.0.1
 */