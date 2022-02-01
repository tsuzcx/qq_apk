package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;

class AssistantSettingFragment$2
  extends ProfileCommonObserver
{
  AssistantSettingFragment$2(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      AssistantSettingFragment.a(this.a, 2131718834, 1);
      localAssistantSettingFragment = this.a;
      AssistantSettingFragment.b(localAssistantSettingFragment, paramBoolean2 ^ true, AssistantSettingFragment.b(localAssistantSettingFragment));
      return;
    }
    AssistantSettingFragment localAssistantSettingFragment = this.a;
    AssistantSettingFragment.b(localAssistantSettingFragment, paramBoolean2, AssistantSettingFragment.b(localAssistantSettingFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */