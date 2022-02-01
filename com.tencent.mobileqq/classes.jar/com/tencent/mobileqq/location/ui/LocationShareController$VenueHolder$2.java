package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationShareController$VenueHolder$2
  implements View.OnClickListener
{
  LocationShareController$VenueHolder$2(LocationShareController.VenueHolder paramVenueHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LocationShareController.a(this.a.a, null);
      ReportController.b(null, "CliOper", "", "", "0X800A96B", "0X800A96B", 0, 0, "0", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.VenueHolder.2
 * JD-Core Version:    0.7.0.1
 */