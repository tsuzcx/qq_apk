package com.tencent.mobileqq.troop.trooplink.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.FileUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class TroopLinkApiImpl$2
  implements Runnable
{
  TroopLinkApiImpl$2(TroopLinkApiImpl paramTroopLinkApiImpl, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!FileUtils.writeFile(this.a, this.b)) {
      MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences().edit().putInt("troop_link_config_version", 0).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.trooplink.api.impl.TroopLinkApiImpl.2
 * JD-Core Version:    0.7.0.1
 */