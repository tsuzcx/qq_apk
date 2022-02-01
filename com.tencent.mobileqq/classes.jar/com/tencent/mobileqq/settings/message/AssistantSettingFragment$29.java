package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$29
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$29(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.d) {
      this.a.a.setContentDescription(HardCodeUtil.a(2131701000));
    }
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B889", paramBoolean);
    SettingCloneUtil.writeValue(this.a.getBaseActivity(), null, this.a.getString(2131694975), "qqsetting_screenshot_key", paramBoolean);
    if (paramBoolean) {
      this.a.getBaseActivity().turnOnShake();
    } else {
      this.a.getBaseActivity().turnOffShake();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.29
 * JD-Core Version:    0.7.0.1
 */