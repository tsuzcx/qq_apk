package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;

class TroopSettingActivity$59
  implements DialogInterface.OnClickListener
{
  TroopSettingActivity$59(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = (IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class);
      TroopSettingActivity localTroopSettingActivity = this.a;
      paramDialogInterface.startJumpAccountLogin(localTroopSettingActivity, localTroopSettingActivity.aW);
      this.a.finish();
      return;
    }
    if (paramInt == 0) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.59
 * JD-Core Version:    0.7.0.1
 */