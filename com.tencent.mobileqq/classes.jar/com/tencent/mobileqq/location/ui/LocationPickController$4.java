package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationPickController$4
  implements View.OnClickListener
{
  LocationPickController$4(LocationPickController paramLocationPickController, Activity paramActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).setClickable(false);
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840630));
    LocationPickController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController).a(true);
    LocationPickController localLocationPickController = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController;
    LocationPickController.a(localLocationPickController, LocationPickController.a(localLocationPickController).a());
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    } else {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController.a("");
    }
    ReportController.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.4
 * JD-Core Version:    0.7.0.1
 */