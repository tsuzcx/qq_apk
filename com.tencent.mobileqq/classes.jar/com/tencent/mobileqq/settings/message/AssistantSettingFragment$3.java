package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$3
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$3(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B87D", paramBoolean);
    if (!NetworkUtil.d(this.a.getActivity()))
    {
      AssistantSettingFragment.a(this.a, 2131694510, 1);
      AssistantSettingFragment localAssistantSettingFragment = this.a;
      if (!paramBoolean) {
        AssistantSettingFragment.a(localAssistantSettingFragment, bool, this);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((CardHandler)AssistantSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).q(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */