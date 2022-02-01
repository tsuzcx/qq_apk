package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$62$1
  implements DialogInterface.OnClickListener
{
  TroopSettingActivity$62$1(TroopSettingActivity.62 param62) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      return;
    }
    try
    {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startGameSdkCallback(this.a.this$0, true, "action_game_join_group", Long.valueOf(this.a.this$0.d).longValue(), -1, this.a.a);
    }
    catch (Exception paramDialogInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAlertDlg error = ");
      localStringBuilder.append(paramDialogInterface);
      QLog.e("Q.chatopttroop", 1, localStringBuilder.toString());
    }
    this.a.this$0.a.cancel();
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.62.1
 * JD-Core Version:    0.7.0.1
 */