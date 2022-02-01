package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$39
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$39(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingFragment localAssistantSettingFragment = this.a;
    AssistantSettingFragment.a(localAssistantSettingFragment, AssistantSettingFragment.a(localAssistantSettingFragment).getSwitch(), paramBoolean);
    AssistantSettingFragment.j(this.a).a(paramBoolean, true);
    ReportClickEventHelper.a(AssistantSettingFragment.c(this.a), "0X800B88B", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.39
 * JD-Core Version:    0.7.0.1
 */