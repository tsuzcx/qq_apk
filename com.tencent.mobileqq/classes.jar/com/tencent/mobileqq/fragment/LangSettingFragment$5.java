package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LocaleManager;

class LangSettingFragment$5
  implements Runnable
{
  LangSettingFragment$5(LangSettingFragment paramLangSettingFragment, int paramInt, Runnable paramRunnable) {}
  
  public void run()
  {
    LocaleManager.a(this.this$0.getBaseActivity(), this.a);
    this.this$0.getBaseActivity().runOnUiThread(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */