package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LocaleManager;

class LangSettingFragment$4
  implements Runnable
{
  LangSettingFragment$4(LangSettingFragment paramLangSettingFragment) {}
  
  public void run()
  {
    LocaleManager.c(this.this$0.getBaseActivity());
    this.this$0.getBaseActivity().finish();
    HiddenChatHelper.b(this.this$0.getBaseActivity(), GeneralSettingActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */