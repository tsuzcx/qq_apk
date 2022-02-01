package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class PersonalityLabelGalleryActivity$ListViewAdapter$4
  implements DialogInterface.OnClickListener
{
  PersonalityLabelGalleryActivity$ListViewAdapter$4(PersonalityLabelGalleryActivity.ListViewAdapter paramListViewAdapter, View paramView, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.jdField_a_of_type_AndroidViewView.getTag(2131365630);
    if (paramDialogInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity$ListViewAdapter.a.a(paramDialogInterface.e, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.ListViewAdapter.4
 * JD-Core Version:    0.7.0.1
 */