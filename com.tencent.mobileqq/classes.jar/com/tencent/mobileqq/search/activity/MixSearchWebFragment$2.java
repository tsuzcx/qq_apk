package com.tencent.mobileqq.search.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MixSearchWebFragment$2
  implements View.OnClickListener
{
  MixSearchWebFragment$2(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    this.a.a.requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this.a.a, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MixSearchWebFragment.2
 * JD-Core Version:    0.7.0.1
 */