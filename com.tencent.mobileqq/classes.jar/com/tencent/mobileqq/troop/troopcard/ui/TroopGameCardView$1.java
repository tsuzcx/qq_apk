package com.tencent.mobileqq.troop.troopcard.ui;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class TroopGameCardView$1
  extends TroopGameObserver
{
  TroopGameCardView$1(TroopGameCardView paramTroopGameCardView) {}
  
  protected void onGetTroopGameGameCard(boolean paramBoolean, String paramString, TroopGameInfo paramTroopGameInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetTroopGameGameCard. isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", hasGameInfo = ");
      boolean bool;
      if (paramTroopGameInfo != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("TroopGameCardView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof AppInterface)) {
      ((AppInterface)localObject).removeObserver(this.a.b);
    }
    if (TextUtils.isEmpty(this.a.a)) {
      return;
    }
    if (this.a.a.equals(paramString))
    {
      TroopGameCardView.a(this.a, paramTroopGameInfo);
      this.a.a(paramBoolean, paramTroopGameInfo);
      paramString = this.a;
      paramString.a(TroopGameCardView.a(paramString));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardView", 2, "onGetTroopGameGameCard. troopUin doesn't match.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopGameCardView.1
 * JD-Core Version:    0.7.0.1
 */