import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class npq
  implements BusinessObserver
{
  npq(QQAppInterface paramQQAppInterface, nps paramnps) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        npo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_Nps);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
      }
      this.jdField_a_of_type_Nps.a("");
      return;
    }
    this.jdField_a_of_type_Nps.a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npq
 * JD-Core Version:    0.7.0.1
 */