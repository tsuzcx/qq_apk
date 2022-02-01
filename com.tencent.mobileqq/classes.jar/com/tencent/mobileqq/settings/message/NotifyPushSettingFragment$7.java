package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingFragment$7
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$7(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (AppSetting.d) {
      NotifyPushSettingFragment.c(this.a).setContentDescription(HardCodeUtil.a(2131718680));
    }
    SettingCloneUtil.writeValue(this.a.getActivity(), this.a.a, this.a.getString(2131718680), "qqsetting_notify_blncontrol_key", paramBoolean);
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      NotifyPushSettingFragment.a(this.a.getActivity(), NotifyPushSettingFragment.a(this.a).getCurrentAccountUin(), "LED_light", 1);
      localQQAppInterface = NotifyPushSettingFragment.a(this.a);
      if (!paramBoolean) {
        break label160;
      }
      label92:
      if (!paramBoolean) {
        break label165;
      }
    }
    label160:
    label165:
    for (String str = "1";; str = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Led_blinking", 0, i, str, "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      NotifyPushSettingFragment.a(this.a.getActivity(), NotifyPushSettingFragment.a(this.a).getCurrentAccountUin(), "LED_light", 0);
      break;
      i = 0;
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */