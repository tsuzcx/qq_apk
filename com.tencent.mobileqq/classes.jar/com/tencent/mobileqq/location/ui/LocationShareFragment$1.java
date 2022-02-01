package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationShareFragment$1
  implements View.OnClickListener
{
  LocationShareFragment$1(LocationShareFragment paramLocationShareFragment, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!LocationShareFragment.a(this.c).d())
    {
      LocationPickFragment.a(this.c.getActivity(), this.a, this.b, LocationShareFragment.b(this.c).getLastCameraPosition());
      ReportController.b(null, "CliOper", "", "", "0X800A95C", "0X800A95C", 0, 0, "", "0", "0", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareFragment.1
 * JD-Core Version:    0.7.0.1
 */