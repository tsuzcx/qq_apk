package com.tencent.mobileqq.search.base.activity;

import android.view.inputmethod.InputMethodManager;

class BaseSearchActivity$1
  implements Runnable
{
  BaseSearchActivity$1(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void run()
  {
    ((InputMethodManager)this.this$0.getSystemService("input_method")).showSoftInput(this.this$0.d, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.activity.BaseSearchActivity.1
 * JD-Core Version:    0.7.0.1
 */