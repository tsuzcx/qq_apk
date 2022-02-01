package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationPickFragment$2
  implements View.OnClickListener
{
  LocationPickFragment$2(LocationPickFragment paramLocationPickFragment, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppActivity.setResult(0);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    ReportController.b(null, "CliOper", "", "", "0X800A963", "0X800A963", 0, 0, "0", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.2
 * JD-Core Version:    0.7.0.1
 */