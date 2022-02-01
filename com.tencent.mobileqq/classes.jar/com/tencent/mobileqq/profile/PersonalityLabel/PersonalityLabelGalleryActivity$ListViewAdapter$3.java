package com.tencent.mobileqq.profile.PersonalityLabel;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PersonalityLabelGalleryActivity$ListViewAdapter$3
  implements ActionSheet.OnButtonClickListener
{
  PersonalityLabelGalleryActivity$ListViewAdapter$3(PersonalityLabelGalleryActivity.ListViewAdapter paramListViewAdapter, PersonalityLabelInfo paramPersonalityLabelInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter.a, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo);
      }
    }
    else {
      PersonalityLabelGalleryActivity.ListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.ListViewAdapter.3
 * JD-Core Version:    0.7.0.1
 */