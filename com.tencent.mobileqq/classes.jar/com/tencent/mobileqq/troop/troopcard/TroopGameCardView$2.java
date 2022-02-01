package com.tencent.mobileqq.troop.troopcard;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class TroopGameCardView$2
  extends TroopGameObserver
{
  TroopGameCardView$2(TroopGameCardView paramTroopGameCardView) {}
  
  public void onGetTroopGameActivityInfo(String paramString, int paramInt, TroopGameActivityInfo paramTroopGameActivityInfo)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals(this.a.a)) {
        return;
      }
      if ((localAppRuntime instanceof AppInterface)) {
        ((AppInterface)localAppRuntime).removeObserver(this.a.b);
      }
      TroopGameCardView.a(this.a, paramTroopGameActivityInfo);
      this.a.a(paramTroopGameActivityInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopGameCardView.2
 * JD-Core Version:    0.7.0.1
 */