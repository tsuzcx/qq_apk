package com.tencent.mobileqq.troop.temporaryban;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;

class TemporaryBanJoinTroopAbilityHelper$3
  implements DialogInterface.OnClickListener
{
  TemporaryBanJoinTroopAbilityHelper$3(TemporaryBanJoinTroopAbilityHelper paramTemporaryBanJoinTroopAbilityHelper, Context paramContext, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a, this.b, 2010, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.temporaryban.TemporaryBanJoinTroopAbilityHelper.3
 * JD-Core Version:    0.7.0.1
 */