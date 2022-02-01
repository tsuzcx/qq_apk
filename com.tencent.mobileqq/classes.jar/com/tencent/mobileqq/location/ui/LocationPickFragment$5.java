package com.tencent.mobileqq.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationPickFragment$5
  implements View.OnClickListener
{
  LocationPickFragment$5(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).e();
    ReportController.b(null, "CliOper", "", "", "0X800A961", "0X800A961", 0, 0, "0", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.5
 * JD-Core Version:    0.7.0.1
 */