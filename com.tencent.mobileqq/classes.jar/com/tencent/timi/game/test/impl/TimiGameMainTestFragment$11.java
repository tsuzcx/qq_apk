package com.tencent.timi.game.test.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.Logger;

class TimiGameMainTestFragment$11
  implements View.OnClickListener
{
  TimiGameMainTestFragment$11(TimiGameMainTestFragment paramTimiGameMainTestFragment) {}
  
  public void onClick(View paramView)
  {
    Logger.a("QQDtReporter", "ranlili BtnClick");
    VideoReport.traverseExposure();
    VideoReport.reportEvent("clck", paramView, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.test.impl.TimiGameMainTestFragment.11
 * JD-Core Version:    0.7.0.1
 */