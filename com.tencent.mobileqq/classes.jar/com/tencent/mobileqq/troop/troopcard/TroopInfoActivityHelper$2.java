package com.tencent.mobileqq.troop.troopcard;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class TroopInfoActivityHelper$2
  implements BusinessObserver
{
  TroopInfoActivityHelper$2(AppInterface paramAppInterface, TroopInfoActivityHelper.ISetSameCityCheckTypeInfo paramISetSameCityCheckTypeInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        TroopInfoActivityHelper.a(this.a, paramBundle, this.b);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
      }
      this.b.a("");
      return;
    }
    this.b.a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivityHelper.2
 * JD-Core Version:    0.7.0.1
 */