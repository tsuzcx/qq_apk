import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class nya
  implements BusinessObserver
{
  nya(QQAppInterface paramQQAppInterface, nyc paramnyc) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        nxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_Nyc);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
      }
      this.jdField_a_of_type_Nyc.a("");
      return;
    }
    this.jdField_a_of_type_Nyc.a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nya
 * JD-Core Version:    0.7.0.1
 */