package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$11
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$11(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingFragment localAssistantSettingFragment = this.a;
    AssistantSettingFragment.a(localAssistantSettingFragment, AssistantSettingFragment.a(localAssistantSettingFragment).getSwitch(), paramBoolean);
    AssistantSettingFragment.j(this.a).a(paramBoolean, true);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.11
 * JD-Core Version:    0.7.0.1
 */