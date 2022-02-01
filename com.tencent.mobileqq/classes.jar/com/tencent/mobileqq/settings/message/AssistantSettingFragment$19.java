package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$19
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$19(AssistantSettingFragment paramAssistantSettingFragment, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalEntryManager.a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.19
 * JD-Core Version:    0.7.0.1
 */