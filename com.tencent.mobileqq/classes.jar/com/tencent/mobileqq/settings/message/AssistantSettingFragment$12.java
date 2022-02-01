package com.tencent.mobileqq.settings.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.graytip.CustomizeGrayTipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$12
  implements View.OnClickListener
{
  AssistantSettingFragment$12(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    CustomizeGrayTipsManager.a(AssistantSettingFragment.c(this.a), this.a.getBaseActivity(), "2", -1);
    ReportController.b(AssistantSettingFragment.c(this.a), "dc00898", "", "", "0X800B87C", "0X800B87C", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.12
 * JD-Core Version:    0.7.0.1
 */