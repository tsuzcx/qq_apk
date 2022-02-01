package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;

class NearbyProfileDisplayPanel$38
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayPanel$38(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
      }
      if (NearbyProfileDisplayPanel.a(this.a) != null)
      {
        if (!this.a.m) {
          break label91;
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, String.valueOf(NearbyProfileDisplayPanel.a(this.a).tinyId), "", "yes", "android");
      }
    }
    label91:
    do
    {
      do
      {
        return;
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, String.valueOf(NearbyProfileDisplayPanel.a(this.a).tinyId), "", "yes", "android");
        return;
      } while (paramInt != 0);
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(10);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131698688);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
      }
      this.a.jdField_a_of_type_Int = 2;
    } while (NearbyProfileDisplayPanel.a(this.a) == null);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_cancel", 0, 0, String.valueOf(NearbyProfileDisplayPanel.a(this.a).tinyId), "", "yes", "android");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.38
 * JD-Core Version:    0.7.0.1
 */