package com.tencent.mobileqq.search.activity;

import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

class ActiveEntitySearchActivity$1
  implements Runnable
{
  ActiveEntitySearchActivity$1(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void run()
  {
    this.this$0.a.requestFocus();
    ((InputMethodManager)this.this$0.getSystemService("input_method")).showSoftInput(this.this$0.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity.1
 * JD-Core Version:    0.7.0.1
 */