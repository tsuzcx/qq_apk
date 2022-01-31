import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class nce
  implements BusinessObserver
{
  nce(QQAppInterface paramQQAppInterface, ncg paramncg) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        ncd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_Ncg);
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
    }
    this.jdField_a_of_type_Ncg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nce
 * JD-Core Version:    0.7.0.1
 */