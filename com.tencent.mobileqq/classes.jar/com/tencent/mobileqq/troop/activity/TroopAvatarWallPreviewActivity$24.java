package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class TroopAvatarWallPreviewActivity$24
  implements DialogInterface.OnClickListener
{
  TroopAvatarWallPreviewActivity$24(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (String)this.b.mPhotoIds.get(this.a);
    long l = Long.parseLong((String)this.b.mPhotoTimes.get(this.a));
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).photoWallDelQzonePhotoWall(this.b.app, this.b.app.getCurrentAccountUin(), paramDialogInterface, l);
    if (!this.b.isFinishing()) {
      this.b.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.24
 * JD-Core Version:    0.7.0.1
 */