package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RouteHolder$2
  implements View.OnClickListener
{
  RouteHolder$2(RouteHolder paramRouteHolder) {}
  
  public void onClick(View paramView)
  {
    if (!RouteHolder.a(this.a).d())
    {
      RouteHolder.a(this.a).a.a(RouteHolder.b(this.a));
      ReportController.b(null, "CliOper", "", "", "0X800A96F", "0X800A96F", 0, 0, "0", "0", "0", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.RouteHolder.2
 * JD-Core Version:    0.7.0.1
 */