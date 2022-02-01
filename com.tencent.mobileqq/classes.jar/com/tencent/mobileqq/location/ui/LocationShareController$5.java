package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationShareController$5
  implements View.OnClickListener
{
  LocationShareController$5(LocationShareController paramLocationShareController, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
      }
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setClickable(false);
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840755));
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).a(true);
      ReportController.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.5
 * JD-Core Version:    0.7.0.1
 */