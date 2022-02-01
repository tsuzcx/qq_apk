package com.tencent.mobileqq.troop.temporaryban;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;

class TemporaryBanJoinTroopAbilityHelper$2
  implements DialogInterface.OnClickListener
{
  TemporaryBanJoinTroopAbilityHelper$2(TemporaryBanJoinTroopAbilityHelper paramTemporaryBanJoinTroopAbilityHelper, Context paramContext, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ActivityURIRequest(this.a, "/base/browser");
    paramDialogInterface.extra().putString("url", this.b);
    QRoute.startUri(paramDialogInterface, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.temporaryban.TemporaryBanJoinTroopAbilityHelper.2
 * JD-Core Version:    0.7.0.1
 */