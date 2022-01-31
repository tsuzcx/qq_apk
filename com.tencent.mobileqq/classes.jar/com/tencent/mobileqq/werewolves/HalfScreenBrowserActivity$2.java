package com.tencent.mobileqq.werewolves;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

class HalfScreenBrowserActivity$2
  implements Runnable
{
  HalfScreenBrowserActivity$2(HalfScreenBrowserActivity paramHalfScreenBrowserActivity) {}
  
  public void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.this$0.getSystemService("input_method");
    if ((localInputMethodManager != null) && (this.this$0.getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(this.this$0.getCurrentFocus().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity.2
 * JD-Core Version:    0.7.0.1
 */