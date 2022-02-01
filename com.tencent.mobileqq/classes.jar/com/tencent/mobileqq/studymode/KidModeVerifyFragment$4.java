package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;

class KidModeVerifyFragment$4
  implements Runnable
{
  KidModeVerifyFragment$4(KidModeVerifyFragment paramKidModeVerifyFragment) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if (localFragmentActivity != null) {
      ((InputMethodManager)localFragmentActivity.getSystemService("input_method")).showSoftInput(KidModeVerifyFragment.a(this.this$0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeVerifyFragment.4
 * JD-Core Version:    0.7.0.1
 */