package com.tencent.mobileqq.troop.troopcard;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class TroopInfoActivityHelper$1
  implements BusinessObserver
{
  TroopInfoActivityHelper$1(AppInterface paramAppInterface, TroopInfoActivityHelper.IGetSameCityCheckTypeInfo paramIGetSameCityCheckTypeInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBundle, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivityHelper$IGetSameCityCheckTypeInfo);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivityHelper$IGetSameCityCheckTypeInfo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivityHelper.1
 * JD-Core Version:    0.7.0.1
 */