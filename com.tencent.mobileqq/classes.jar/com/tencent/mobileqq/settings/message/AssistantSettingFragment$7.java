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
      if ((AssistantSettingFragment.h(this.a) != null) && (paramBoolean2 != AssistantSettingFragment.h(this.a).a()))
      {
        AssistantSettingFragment.h(this.a).setOnCheckedChangeListener(null);
        AssistantSettingFragment.h(this.a).setChecked(paramBoolean2);
        AssistantSettingFragment.h(this.a).setOnCheckedChangeListener(this.a);
      }
    }
    else {
      AssistantSettingFragment.a(this.a, 2131887632, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */