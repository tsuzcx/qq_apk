package com.tencent.mobileqq.troop.troopnotification.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyAndRecAdapter$1
  implements View.OnClickListener
{
  NotifyAndRecAdapter$1(NotifyAndRecAdapter paramNotifyAndRecAdapter, View paramView) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(NotifyAndRecAdapter.a(this.b), "dc00899", "Grp_contacts_news", "", "notice", "verify_clk", 0, 0, "", "", "", "");
    NotifyAndRecAdapter.a(this.b, true);
    this.a.setVisibility(8);
    this.b.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.1
 * JD-Core Version:    0.7.0.1
 */