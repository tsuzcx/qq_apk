package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$19
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$19(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    RichTextChatManager.a(AssistantSettingFragment.a(this.a)).a(paramBoolean, AssistantSettingFragment.a(this.a));
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B87E", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.19
 * JD-Core Version:    0.7.0.1
 */