package com.tencent.mobileqq.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.LocationPickViewModel;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationPickFragment$3
  implements View.OnClickListener
{
  LocationPickFragment$3(LocationPickFragment paramLocationPickFragment, QBaseActivity paramQBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693828, 0).a();
    }
    else
    {
      LocationRoom.Venue localVenue = LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[venue] pick confirm click: venue: ");
        ((StringBuilder)localObject).append(localVenue);
        QLog.d("LocationPickFragment", 2, ((StringBuilder)localObject).toString());
      }
      int i;
      if (LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a()) {
        i = 2;
      } else {
        i = 1;
      }
      ReportController.b(null, "CliOper", "", "", "0X800A962", "0X800A962", i, 0, "", "0", "0", "");
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_picked_location", localVenue);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setResult(-1, (Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.3
 * JD-Core Version:    0.7.0.1
 */