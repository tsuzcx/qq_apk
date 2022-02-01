package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RouteHolder$1
  implements View.OnClickListener
{
  RouteHolder$1(RouteHolder paramRouteHolder) {}
  
  public void onClick(View paramView)
  {
    if (!RouteHolder.a(this.a).a())
    {
      RouteHolder.a(this.a).a.c(true);
      RouteHolder.a(this.a).c();
      ReportController.b(null, "CliOper", "", "", "0X800A973", "0X800A973", 0, 0, "0", "0", "0", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.RouteHolder.1
 * JD-Core Version:    0.7.0.1
 */