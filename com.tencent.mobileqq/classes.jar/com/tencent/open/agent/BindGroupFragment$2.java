package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BindGroupFragment$2
  implements View.OnClickListener
{
  BindGroupFragment$2(BindGroupFragment paramBindGroupFragment) {}
  
  public void onClick(View paramView)
  {
    BindGroupFragment.a(this.a, HardCodeUtil.a(2131701341));
    ((ITroopTokenHandler)BindGroupFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment.2
 * JD-Core Version:    0.7.0.1
 */