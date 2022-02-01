package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BadgeUtils;

class NotifyPushSettingFragment$8
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$8(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      BadgeUtils.a();
    } else {
      BadgeUtils.b();
    }
    ReportClickEventHelper.a(NotifyPushSettingFragment.a(this.a), "0X800B84D", paramBoolean);
    if (AppSetting.d) {
      NotifyPushSettingFragment.d(this.a).setContentDescription(HardCodeUtil.a(2131707650));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */