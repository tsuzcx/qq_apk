package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$41
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$41(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(this.a.getBaseActivity()))
    {
      AssistantSettingFragment.a(this.a, 2131892155, 1);
      AssistantSettingFragment.c(this.a, paramBoolean ^ true);
    }
    else
    {
      QQAppInterface localQQAppInterface = AssistantSettingFragment.c(this.a);
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "2";
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A5D5", "0X800A5D5", 0, 0, str, "", "", "");
      this.a.i.b(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.41
 * JD-Core Version:    0.7.0.1
 */