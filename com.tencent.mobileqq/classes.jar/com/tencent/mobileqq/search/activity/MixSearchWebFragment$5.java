package com.tencent.mobileqq.search.activity;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;

class MixSearchWebFragment$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  MixSearchWebFragment$5(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onGlobalLayout()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      this.a.a.requestFocus();
      localInputMethodManager.showSoftInput(this.a.a, 0);
    }
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MixSearchWebFragment.5
 * JD-Core Version:    0.7.0.1
 */