package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RouteHolder$4
  implements View.OnClickListener
{
  RouteHolder$4(RouteHolder paramRouteHolder) {}
  
  public void onClick(View paramView)
  {
    if ((!RouteHolder.a(this.a).d()) && (!paramView.isSelected()))
    {
      this.a.a(paramView);
      RouteHolder localRouteHolder = this.a;
      localRouteHolder.q = 2;
      RouteHolder.a(localRouteHolder).a(Integer.valueOf(2));
      ReportController.b(null, "CliOper", "", "", "0X800A96E", "0X800A96E", 3, 0, "0", "0", "0", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.RouteHolder.4
 * JD-Core Version:    0.7.0.1
 */