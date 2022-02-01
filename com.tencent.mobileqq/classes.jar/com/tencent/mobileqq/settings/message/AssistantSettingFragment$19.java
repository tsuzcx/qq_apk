package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$19
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$19(AssistantSettingFragment paramAssistantSettingFragment, IDoutuService paramIDoutuService) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.updateDoutuSetting(paramBoolean);
    ReportClickEventHelper.a(AssistantSettingFragment.c(this.b), "0X800B87F", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.19
 * JD-Core Version:    0.7.0.1
 */