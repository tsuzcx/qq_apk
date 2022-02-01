package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;

class AssistantSettingFragment$14
  implements View.OnClickListener
{
  AssistantSettingFragment$14(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssistantSettingFragment", 2, "click cmshow setting");
    }
    Intent localIntent = new Intent(this.a.getBaseActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", QzoneConfig.getInstance().getConfig("CMShow", "CMShowSettingUrl", "https://h5.cmshow.qq.com/next/setting.html?_wv=2&_wwv=4&adtag=qqsetting"));
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.14
 * JD-Core Version:    0.7.0.1
 */