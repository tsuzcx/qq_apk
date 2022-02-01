package com.tencent.mobileqq.onlinestatus.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.StatusVisibleFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoStatusSelectView$1
  implements View.OnClickListener
{
  AutoStatusSelectView$1(AutoStatusSelectView paramAutoStatusSelectView, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int i = 1;
    if (bool) {
      ReportHelperKt.a("0X800AF41", 2, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusSelectView.jdField_a_of_type_Int));
    } else {
      ReportHelperKt.a("0X800AF41", 1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusSelectView.jdField_a_of_type_Int));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusSelectView.jdField_a_of_type_Int != 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusSelectView.jdField_a_of_type_Int == 2) {
        i = 3;
      } else {
        i = 0;
      }
    }
    StatusVisibleFragment.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusSelectView.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusSelectView.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, i, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusSelectView.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusSelectView.1
 * JD-Core Version:    0.7.0.1
 */