package com.tencent.mobileqq.settings.message;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$28
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$28(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.d) {
      this.a.a.setContentDescription(HardCodeUtil.a(2131700857));
    }
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B889", paramBoolean);
    SettingCloneUtil.writeValue(this.a.getActivity(), null, this.a.getString(2131694985), "qqsetting_screenshot_key", paramBoolean);
    if (paramBoolean) {
      this.a.getActivity().turnOnShake();
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.a.getActivity().turnOffShake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.28
 * JD-Core Version:    0.7.0.1
 */