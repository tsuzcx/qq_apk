package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$35
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$35(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingFragment.a(this.a, AssistantSettingFragment.a(this.a).a(), paramBoolean);
    AssistantSettingFragment.a(this.a).a(paramBoolean, true);
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B88B", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.35
 * JD-Core Version:    0.7.0.1
 */