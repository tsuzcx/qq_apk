package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.inputstatus.InputStatusObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import mqq.app.AppRuntime;

class PrivacyShowSettingFragment$8
  extends InputStatusObserver
{
  PrivacyShowSettingFragment$8(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (!paramBoolean1)
    {
      this.a.a(2131718834, 1);
      return;
    }
    Object localObject = this.a;
    PrivacyShowSettingFragment.a((PrivacyShowSettingFragment)localObject, PrivacyShowSettingFragment.d((PrivacyShowSettingFragment)localObject).a(), paramBoolean2);
    localObject = this.a.a;
    if (paramBoolean2) {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009D11", "0X8009D11", 0, 0, String.valueOf(i), "", "", "");
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      PrivacyShowSettingFragment localPrivacyShowSettingFragment = this.a;
      PrivacyShowSettingFragment.a(localPrivacyShowSettingFragment, PrivacyShowSettingFragment.d(localPrivacyShowSettingFragment).a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */