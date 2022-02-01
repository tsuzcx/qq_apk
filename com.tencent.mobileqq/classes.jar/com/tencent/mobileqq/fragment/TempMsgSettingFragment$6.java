package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TempMsgSettingFragment$6
  implements View.OnClickListener
{
  TempMsgSettingFragment$6(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.a, "dc00898", "", "", "0X800BB8E", "0X800BB8E", 0, 0, "", "", "", "");
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).openGameMsgSettingPage(this.a.getContext(), "TempMsgSettingFragment");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */