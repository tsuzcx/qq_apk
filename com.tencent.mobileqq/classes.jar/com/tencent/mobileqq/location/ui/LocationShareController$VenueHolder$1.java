package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationShareController$VenueHolder$1
  implements View.OnClickListener
{
  LocationShareController$VenueHolder$1(LocationShareController.VenueHolder paramVenueHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(null, "CliOper", "", "", "0X800A966", "0X800A966", 0, 0, "0", "0", "0", "");
      LocationDialogUtil.a(LocationShareController.a(this.a.a), this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.VenueHolder.1
 * JD-Core Version:    0.7.0.1
 */