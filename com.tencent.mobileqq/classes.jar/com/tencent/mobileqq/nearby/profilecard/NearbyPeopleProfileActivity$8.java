package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyPeopleProfileActivity$8
  implements View.OnClickListener
{
  NearbyPeopleProfileActivity$8(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (!this.a.isFinishing()))
    {
      this.a.b.dismiss();
      this.a.b = null;
    }
    this.a.a(300L);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004BB0", "0X8004BB0", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.8
 * JD-Core Version:    0.7.0.1
 */