package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.app.AppRuntime;

class NotifyPushSettingFragment$12
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$12(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a.getBaseActivity(), this.a.a, this.a.getString(2131718135), "qqsetting_lock_screen_whenexit_key", paramBoolean);
    Object localObject2 = NotifyPushSettingFragment.a(this.a);
    if (paramBoolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject1, "", "", "");
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("collectPerformance qqls setting isChecked=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.i("qqls", 4, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashMap();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("param_ls_setting", ((StringBuilder)localObject2).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(NotifyPushSettingFragment.a(this.a).getCurrentAccountUin(), "qqlsSettingReprotTag", true, 0L, 0L, (HashMap)localObject1, "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.12
 * JD-Core Version:    0.7.0.1
 */