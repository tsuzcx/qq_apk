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
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B87D", paramBoolean);
    if (!NetworkUtil.isNetSupport(this.a.getBaseActivity()))
    {
      AssistantSettingFragment.a(this.a, 2131694475, 1);
      AssistantSettingFragment.a(this.a, paramBoolean ^ true, this);
    }
    else
    {
      ((CardHandler)AssistantSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).q(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */