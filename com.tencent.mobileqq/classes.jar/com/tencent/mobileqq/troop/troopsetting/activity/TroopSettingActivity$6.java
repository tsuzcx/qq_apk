package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopSettingActivity$6
  extends BroadcastReceiver
{
  TroopSettingActivity$6(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    boolean bool;
    if ((this.a.a != null) && (this.a.a.isHomeworkTroop())) {
      bool = true;
    } else {
      bool = false;
    }
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("data");
      if ("onHomeworkTroopIdentityChanged".equals(paramIntent.getStringExtra("event"))) {
        TroopSettingActivity.a(this.a, bool, paramContext);
      }
    }
    else
    {
      if ("start_recomend_page".equals(paramContext))
      {
        this.a.finish();
        return;
      }
      if ("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER".equals(paramContext)) {
        TroopSettingActivity.a(this.a, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */