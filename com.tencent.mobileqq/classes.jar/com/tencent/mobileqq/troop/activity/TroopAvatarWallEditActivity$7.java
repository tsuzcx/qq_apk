package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallEditActivity$7
  implements ActionSheet.OnButtonClickListener
{
  String jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_Int);
  
  TroopAvatarWallEditActivity$7(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131693302).equals(paramView)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131693308).equals(paramView)) {
        TroopAvatarWallEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131693306).equals(paramView)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.c, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.7
 * JD-Core Version:    0.7.0.1
 */