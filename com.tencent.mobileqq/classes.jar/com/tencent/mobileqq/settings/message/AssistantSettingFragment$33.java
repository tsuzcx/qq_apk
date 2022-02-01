package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$33
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$33(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ScreenShotDetector.a(paramBoolean);
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B888", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.33
 * JD-Core Version:    0.7.0.1
 */