package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class NearbyPeopleProfileActivity$22
  implements ActionSheet.OnButtonClickListener
{
  NearbyPeopleProfileActivity$22(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.selectPhotoFromQZone();
        NearbyPeopleProfileActivity.access$1100(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      }
    }
    else
    {
      if (NearbyPeopleProfileActivity.access$400(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity) != null) {
        NearbyPeopleProfileActivity.access$400(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.size());
      }
      NearbyPeopleProfileActivity.access$1100(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.22
 * JD-Core Version:    0.7.0.1
 */