package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingFragment$6
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$6(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (NotifyPushSettingFragment.a())
    {
      NotifyPushSettingFragment.b(this.a).setChecked(false);
      NotifyPushSettingFragment.b(this.a).setVisibility(8);
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      ReportController.b(NotifyPushSettingFragment.a(this.a), "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        NotifyPushSettingFragment.b(this.a).setVisibility(0);
        NotifyPushSettingFragment.b(this.a).setVisibility(8);
        break;
      }
      NotifyPushSettingFragment.b(this.a).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */