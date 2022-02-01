package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyPeopleProfileActivity$5
  implements View.OnClickListener
{
  NearbyPeopleProfileActivity$5(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!this.a.isFinishing()))
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    this.a.d();
    this.a.b(true);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004824", "0X8004824", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.5
 * JD-Core Version:    0.7.0.1
 */