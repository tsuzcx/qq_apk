package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class AssistantSettingFragment$7
  extends C2CShortcutBarObserver
{
  AssistantSettingFragment$7(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((AssistantSettingFragment.c(this.a) != null) && (paramBoolean2 != AssistantSettingFragment.c(this.a).a()))
      {
        AssistantSettingFragment.c(this.a).setOnCheckedChangeListener(null);
        AssistantSettingFragment.c(this.a).setChecked(paramBoolean2);
        AssistantSettingFragment.c(this.a).setOnCheckedChangeListener(this.a);
      }
      return;
    }
    AssistantSettingFragment.a(this.a, 2131690784, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */