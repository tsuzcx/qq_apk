package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;

class NearbyProfileDisplayTribePanel$29
  extends Handler
{
  NearbyProfileDisplayTribePanel$29(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 6: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a();
        return;
      }
      break;
    case 5: 
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131699176, 0).a();
      return;
    case 4: 
      if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null) && (NearbyProfileDisplayTribePanel.a(this.a) != null))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131698757);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(NearbyProfileDisplayTribePanel.a(this.a).uRoomid);
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_bootstrap", 0, 0, NearbyProfileDisplayTribePanel.a(this.a).uin, "", "yes", "android");
        return;
      }
      break;
    case 3: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(100);
        return;
      }
      break;
    case 2: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(paramMessage.arg1);
        return;
      }
      break;
    case 1: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131699179);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.29
 * JD-Core Version:    0.7.0.1
 */