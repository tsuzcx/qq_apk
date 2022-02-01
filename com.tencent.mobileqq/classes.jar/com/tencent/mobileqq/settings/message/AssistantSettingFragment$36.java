package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$36
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$36(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingFragment localAssistantSettingFragment = this.a;
    AssistantSettingFragment.a(localAssistantSettingFragment, AssistantSettingFragment.a(localAssistantSettingFragment).a(), paramBoolean);
    AssistantSettingFragment.a(this.a).a(paramBoolean, true);
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B88B", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.36
 * JD-Core Version:    0.7.0.1
 */