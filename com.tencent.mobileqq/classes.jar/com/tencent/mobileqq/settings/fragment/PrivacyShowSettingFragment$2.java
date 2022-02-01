package com.tencent.mobileqq.settings.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PrivacyShowSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  PrivacyShowSettingFragment$2(PrivacyShowSettingFragment paramPrivacyShowSettingFragment, TroopManager paramTroopManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqSettingsFragmentPrivacyShowSettingFragment.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B869", "0X800B869", i, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */