import android.os.Bundle;
import com.tencent.biz.helper.TroopInfoActivityHelper;
import com.tencent.biz.helper.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class kpi
  implements BusinessObserver
{
  public kpi(QQAppInterface paramQQAppInterface, TroopInfoActivityHelper.ISetSameCityCheckTypeInfo paramISetSameCityCheckTypeInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
      }
      this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo.a("");
      return;
    }
    this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo.a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpi
 * JD-Core Version:    0.7.0.1
 */