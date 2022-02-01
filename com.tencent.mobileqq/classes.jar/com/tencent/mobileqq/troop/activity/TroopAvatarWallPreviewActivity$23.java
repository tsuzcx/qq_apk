package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import java.util.ArrayList;

class TroopAvatarWallPreviewActivity$23
  implements DialogInterface.OnClickListener
{
  TroopAvatarWallPreviewActivity$23(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Bundle paramBundle, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("label_id", 0L);
    long l2 = Long.valueOf((String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.b.get(this.jdField_a_of_type_Int)).longValue();
    ((PersonalityLabelHandler)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app.getCurrentAccountUin(), l1, l2);
    TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getResources().getString(2131691583));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.23
 * JD-Core Version:    0.7.0.1
 */