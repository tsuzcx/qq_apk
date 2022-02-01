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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131693256).equals(paramView))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131693262).equals(paramView))
    {
      TroopAvatarWallEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getString(2131693260).equals(paramView))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity;
      paramView.a(paramView.c, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.7
 * JD-Core Version:    0.7.0.1
 */