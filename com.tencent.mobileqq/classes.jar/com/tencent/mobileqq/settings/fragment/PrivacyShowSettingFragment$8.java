package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

class PrivacyShowSettingFragment$8
  extends InputStatusObserver
{
  PrivacyShowSettingFragment$8(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (!paramBoolean1)
    {
      this.a.a(2131719116, 1);
      return;
    }
    PrivacyShowSettingFragment.a(this.a, PrivacyShowSettingFragment.d(this.a).a(), paramBoolean2);
    QQAppInterface localQQAppInterface = this.a.a;
    if (paramBoolean2) {
      i = 2;
    }
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009D11", "0X8009D11", 0, 0, String.valueOf(i), "", "", "");
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PrivacyShowSettingFragment.a(this.a, PrivacyShowSettingFragment.d(this.a).a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */