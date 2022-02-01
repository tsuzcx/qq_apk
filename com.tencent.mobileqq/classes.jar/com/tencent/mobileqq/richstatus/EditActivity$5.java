package com.tencent.mobileqq.richstatus;

import android.view.inputmethod.InputMethodManager;

class EditActivity$5
  implements Runnable
{
  EditActivity$5(EditActivity paramEditActivity) {}
  
  public void run()
  {
    EditActivity.a(this.this$0).requestFocus();
    ((InputMethodManager)this.this$0.getSystemService("input_method")).showSoftInput(EditActivity.a(this.this$0), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity.5
 * JD-Core Version:    0.7.0.1
 */