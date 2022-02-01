package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor;

class TroopSettingActivity$4
  implements Runnable
{
  TroopSettingActivity$4(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void run()
  {
    this.this$0.at = TroopUrlConfProcessor.a();
    if (this.this$0.i != null) {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).preloadQunAlbum(TroopSettingActivity.a(this.this$0), this.this$0.i.troopUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */