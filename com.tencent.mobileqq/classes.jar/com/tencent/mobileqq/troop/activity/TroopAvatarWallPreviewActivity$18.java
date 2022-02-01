package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class TroopAvatarWallPreviewActivity$18
  implements DialogInterface.OnClickListener
{
  TroopAvatarWallPreviewActivity$18(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.mPhotoIds.get(this.jdField_a_of_type_Int);
    long l = Long.parseLong((String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.mPhotoTimes.get(this.jdField_a_of_type_Int));
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).photoWallDelQzonePhotoWall(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app.getCurrentAccountUin(), paramDialogInterface, l);
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.18
 * JD-Core Version:    0.7.0.1
 */