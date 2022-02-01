package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallEditActivity$5
  implements ActionSheet.OnButtonClickListener
{
  TroopAvatarWallEditActivity$5(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (System.currentTimeMillis() - TroopAvatarWallEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity) > 500L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onDeleteItem(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_Int);
        TroopAvatarWallEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity, System.currentTimeMillis());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.5
 * JD-Core Version:    0.7.0.1
 */