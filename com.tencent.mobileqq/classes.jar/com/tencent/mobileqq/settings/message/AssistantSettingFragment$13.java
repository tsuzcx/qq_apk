package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$13
  implements View.OnClickListener
{
  AssistantSettingFragment$13(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://zb.vip.qq.com/v2/pages/nudgeMall?_wv=2");
    this.a.startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", "0X800B87B", "0X800B87B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.13
 * JD-Core Version:    0.7.0.1
 */