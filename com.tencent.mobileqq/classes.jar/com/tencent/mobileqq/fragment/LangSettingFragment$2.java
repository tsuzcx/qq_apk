package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LangSettingFragment$2
  implements View.OnClickListener
{
  LangSettingFragment$2(LangSettingFragment paramLangSettingFragment) {}
  
  public void onClick(View paramView)
  {
    LangSettingFragment.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */