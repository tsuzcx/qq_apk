package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;

class NearbyProfileDisplayTribePanel$30
  implements DialogInterface.OnClickListener
{
  NearbyProfileDisplayTribePanel$30(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
      }
      if (NearbyProfileDisplayTribePanel.a(this.a) != null)
      {
        if (!this.a.n) {
          break label88;
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, NearbyProfileDisplayTribePanel.a(this.a).uin, "", "yes", "android");
      }
    }
    label88:
    do
    {
      do
      {
        return;
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, NearbyProfileDisplayTribePanel.a(this.a).uin, "", "yes", "android");
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
    } while (NearbyProfileDisplayTribePanel.a(this.a) == null);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_cancel", 0, 0, NearbyProfileDisplayTribePanel.a(this.a).uin, "", "yes", "android");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.30
 * JD-Core Version:    0.7.0.1
 */