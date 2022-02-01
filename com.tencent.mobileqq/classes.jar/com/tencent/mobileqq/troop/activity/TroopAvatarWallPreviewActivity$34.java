package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import java.util.ArrayList;

class TroopAvatarWallPreviewActivity$34
  implements DialogInterface.OnClickListener
{
  TroopAvatarWallPreviewActivity$34(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Bundle paramBundle, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l1 = this.a.getLong("label_id", 0L);
    long l2 = Long.valueOf((String)this.c.mPhotoIds.get(this.b)).longValue();
    ((PersonalityLabelHandler)this.c.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).b(this.c.app.getCurrentAccountUin(), l1, l2);
    paramDialogInterface = this.c;
    TroopAvatarWallPreviewActivity.access$2200(paramDialogInterface, paramDialogInterface.getResources().getString(2131888463));
    paramDialogInterface = this.c;
    paramDialogInterface.addObserver(paramDialogInterface.mPersonalityLabelObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.34
 * JD-Core Version:    0.7.0.1
 */