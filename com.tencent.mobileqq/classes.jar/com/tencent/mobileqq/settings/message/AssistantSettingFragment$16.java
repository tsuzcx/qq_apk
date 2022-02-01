package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

class AssistantSettingFragment$16
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$16(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 1;
      ReadInJoyHelper.d(i);
      ReadInJoyHelper.a(paramBoolean);
      ReadInJoyHelper.a(true);
      if (!paramBoolean) {
        break label70;
      }
      QQToast.a(this.a.getActivity(), 2, 2131718387, 2000).a();
    }
    for (;;)
    {
      ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B88A", paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label70:
      QQToast.a(this.a.getActivity(), 2, 2131718385, 2000).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.16
 * JD-Core Version:    0.7.0.1
 */