package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$15
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$15(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    MultiAIOHelper.a(paramBoolean);
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B887", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.15
 * JD-Core Version:    0.7.0.1
 */