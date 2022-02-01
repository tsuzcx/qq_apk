package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.app.BaseActivity;

class KidModeVerifyFragment$4
  implements Runnable
{
  KidModeVerifyFragment$4(KidModeVerifyFragment paramKidModeVerifyFragment) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = this.this$0.getBaseActivity();
    if (localBaseActivity != null) {
      ((InputMethodManager)localBaseActivity.getSystemService("input_method")).showSoftInput(KidModeVerifyFragment.e(this.this$0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeVerifyFragment.4
 * JD-Core Version:    0.7.0.1
 */