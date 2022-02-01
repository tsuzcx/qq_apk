package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$14
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$14(AssistantSettingFragment paramAssistantSettingFragment, DoutuManager paramDoutuManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.a(paramBoolean);
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment), "0X800B87F", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.14
 * JD-Core Version:    0.7.0.1
 */