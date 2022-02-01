package com.tencent.mobileqq.settings.message;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;

class AssistantSettingFragment$15
  implements Runnable
{
  AssistantSettingFragment$15(AssistantSettingFragment paramAssistantSettingFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    AssistantSettingFragment.k(this.this$0).setChecked(this.a);
    String str = this.b;
    if ((str != null) && (!TextUtils.isEmpty(str))) {
      AssistantSettingFragment.k(this.this$0).setText(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.15
 * JD-Core Version:    0.7.0.1
 */