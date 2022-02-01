package com.tencent.timi.game.test.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.web.business.api.IWebBusinessService;

class TimiGameMainTestFragment$6
  implements View.OnClickListener
{
  TimiGameMainTestFragment$6(TimiGameMainTestFragment paramTimiGameMainTestFragment) {}
  
  public void onClick(View paramView)
  {
    ((IWebBusinessService)ServiceCenter.a(IWebBusinessService.class)).a(this.a.getActivity(), "https://www.baidu.com/");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.test.impl.TimiGameMainTestFragment.6
 * JD-Core Version:    0.7.0.1
 */