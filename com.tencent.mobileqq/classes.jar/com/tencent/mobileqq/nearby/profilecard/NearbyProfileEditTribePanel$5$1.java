package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyProfileEditTribePanel$5$1
  implements ActionSheet.OnButtonClickListener
{
  NearbyProfileEditTribePanel$5$1(NearbyProfileEditTribePanel.5 param5, View paramView, PicInfo paramPicInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$5.jdField_a_of_type_Int == 0) {
      i = paramInt + 1;
    }
    if (i != 0) {
      if (i != 1)
      {
        if (i == 2) {
          NearbyProfileEditTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$5.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel, this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo, this.jdField_a_of_type_AndroidViewView);
        }
      }
      else
      {
        paramView = AnimationUtils.a(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$5.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showBigPhotoWithDelAndSetHeadView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$5.jdField_a_of_type_Int, paramView, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$5.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.5.1
 * JD-Core Version:    0.7.0.1
 */