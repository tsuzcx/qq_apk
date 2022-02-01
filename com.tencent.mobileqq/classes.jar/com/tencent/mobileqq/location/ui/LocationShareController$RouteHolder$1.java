package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationShareController$RouteHolder$1
  implements View.OnClickListener
{
  LocationShareController$RouteHolder$1(LocationShareController.RouteHolder paramRouteHolder, LocationShareController paramLocationShareController) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).c(true);
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController);
      ReportController.b(null, "CliOper", "", "", "0X800A973", "0X800A973", 0, 0, "0", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.RouteHolder.1
 * JD-Core Version:    0.7.0.1
 */