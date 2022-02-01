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
      AssistantSettingFragment.a(this.a, 2131916364, 1);
      localAssistantSettingFragment = this.a;
      AssistantSettingFragment.b(localAssistantSettingFragment, paramBoolean2 ^ true, AssistantSettingFragment.f(localAssistantSettingFragment));
      return;
    }
    AssistantSettingFragment localAssistantSettingFragment = this.a;
    AssistantSettingFragment.b(localAssistantSettingFragment, paramBoolean2, AssistantSettingFragment.f(localAssistantSettingFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */