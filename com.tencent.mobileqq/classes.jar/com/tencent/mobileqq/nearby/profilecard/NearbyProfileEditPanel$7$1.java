package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyProfileEditPanel$7$1
  implements ActionSheet.OnButtonClickListener
{
  NearbyProfileEditPanel$7$1(NearbyProfileEditPanel.7 param7, View paramView, PicInfo paramPicInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_Int == 0) {
      i = paramInt + 1;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo, this.jdField_a_of_type_AndroidViewView);
        }
      }
      else
      {
        paramView = AnimationUtils.a(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showBigPhotoWithDelAndSetHeadView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_Int, paramView, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView, 0);
      NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
      NearbyProfileEditPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$7.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.7.1
 * JD-Core Version:    0.7.0.1
 */