package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.FirstLoadDataCallback;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.widget.TabBarView;

class NearbyProfileDisplayPanel$4
  implements NearbyMomentFragment.FirstLoadDataCallback
{
  NearbyProfileDisplayPanel$4(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, int paramInt) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView != null)) {
      if (paramInt > 0) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, false);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a();
      String str = "1";
      Object localObject;
      if (i == 0)
      {
        localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          str = "2";
        }
        ((ReportTask)localObject).a(new String[] { str }).a();
        return;
      }
      ReportTask localReportTask = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      if (paramInt != 0) {
        str = "2";
      }
      localReportTask.a(new String[] { localObject, str }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.4
 * JD-Core Version:    0.7.0.1
 */