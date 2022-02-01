package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$37
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$37(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.d(this.a.getActivity()))
    {
      AssistantSettingFragment.a(this.a, 2131694507, 1);
      localObject = this.a;
      if (!paramBoolean) {
        bool = true;
      }
      AssistantSettingFragment.b((AssistantSettingFragment)localObject, bool);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    QQAppInterface localQQAppInterface = AssistantSettingFragment.a(this.a);
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A5D5", "0X800A5D5", 0, 0, (String)localObject, "", "", "");
      this.a.a.b(paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.37
 * JD-Core Version:    0.7.0.1
 */