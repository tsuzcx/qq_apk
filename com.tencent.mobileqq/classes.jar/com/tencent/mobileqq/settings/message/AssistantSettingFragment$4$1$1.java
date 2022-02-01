package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.qassistant.wake.WakeDialog;
import com.tencent.mobileqq.widget.QQToast;

class AssistantSettingFragment$4$1$1
  implements Runnable
{
  AssistantSettingFragment$4$1$1(AssistantSettingFragment.4.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      new WakeDialog(this.b.a.a.getBaseActivity(), false).show();
      return;
    }
    QQToast.makeText(this.b.a.a.getBaseActivity(), 2131893056, 0).show();
    AssistantSettingFragment.b(this.b.a.a, false, AssistantSettingFragment.f(this.b.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.4.1.1
 * JD-Core Version:    0.7.0.1
 */