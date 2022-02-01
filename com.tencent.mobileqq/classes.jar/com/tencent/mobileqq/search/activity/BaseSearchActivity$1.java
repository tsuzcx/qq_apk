package com.tencent.mobileqq.search.activity;

import android.view.inputmethod.InputMethodManager;

class BaseSearchActivity$1
  implements Runnable
{
  BaseSearchActivity$1(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void run()
  {
    ((InputMethodManager)this.this$0.getSystemService("input_method")).showSoftInput(this.this$0.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.BaseSearchActivity.1
 * JD-Core Version:    0.7.0.1
 */