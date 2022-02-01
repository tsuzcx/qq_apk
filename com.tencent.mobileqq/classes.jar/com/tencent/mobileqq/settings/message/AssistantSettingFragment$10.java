package com.tencent.mobileqq.settings.message;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$10
  implements View.OnClickListener
{
  AssistantSettingFragment$10(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("start_from", 2);
    AssistantSettingFragment.a(paramView.getContext(), localBundle);
    ReportController.a(AssistantSettingFragment.a(this.a), "0X800B886");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */