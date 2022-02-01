package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$22
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$22(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    RichTextChatManager.a(AssistantSettingFragment.c(this.a)).a(paramBoolean, AssistantSettingFragment.c(this.a));
    ReportClickEventHelper.a(AssistantSettingFragment.c(this.a), "0X800B87E", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.22
 * JD-Core Version:    0.7.0.1
 */