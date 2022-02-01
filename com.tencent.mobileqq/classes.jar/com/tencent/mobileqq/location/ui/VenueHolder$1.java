package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VenueHolder$1
  implements View.OnClickListener
{
  VenueHolder$1(VenueHolder paramVenueHolder) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a.a())
    {
      ReportController.b(null, "CliOper", "", "", "0X800A966", "0X800A966", 0, 0, "0", "0", "0", "");
      LocationDialogUtil.a(this.a.a.a, this.a.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.VenueHolder.1
 * JD-Core Version:    0.7.0.1
 */