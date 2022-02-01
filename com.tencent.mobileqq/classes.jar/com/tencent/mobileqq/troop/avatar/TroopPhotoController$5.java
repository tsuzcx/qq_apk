package com.tencent.mobileqq.troop.avatar;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.AppActivity;

class TroopPhotoController$5
  implements ActionSheet.OnButtonClickListener
{
  TroopPhotoController$5(TroopPhotoController paramTroopPhotoController, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.jdField_a_of_type_ArrayOfInt != null)
    {
      if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.jdField_a_of_type_ArrayOfInt.length) {
        return;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.jdField_a_of_type_ArrayOfInt[paramInt];
      if (paramInt != 13)
      {
        if (paramInt == 14) {
          ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoListEdit(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.jdField_a_of_type_AndroidAppActivity, ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getBusiByType(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.c));
        }
      }
      else if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((AppActivity)this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.jdField_a_of_type_AndroidAppActivity).requestPermissions(new TroopPhotoController.5.1(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          TroopPhotoController.a(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController);
        }
      }
      else {
        TroopPhotoController.a(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController);
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.5
 * JD-Core Version:    0.7.0.1
 */