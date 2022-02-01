package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;

class NotifyPushSettingFragment$9
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$9(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getString(2131915888));
    localStringBuilder.append(this.a.a);
    LocalMultiProcConfig.putBooleanAsync(localStringBuilder.toString(), paramBoolean);
    if (AppSetting.e) {
      NotifyPushSettingFragment.m(this.a).setContentDescription(HardCodeUtil.a(2131905480));
    }
    ReportClickEventHelper.a(NotifyPushSettingFragment.c(this.a), "0X800B84E", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */