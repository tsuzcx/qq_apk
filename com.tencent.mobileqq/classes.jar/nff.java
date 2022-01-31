import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class nff
  implements BusinessObserver
{
  nff(QQAppInterface paramQQAppInterface, boolean paramBoolean, akdn paramakdn) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList isSuccess:" + String.valueOf(paramBoolean));
    }
    paramBundle = paramBundle.getByteArray("data");
    if ((paramBoolean) && (paramBundle != null)) {}
    for (paramInt = nfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean, paramBundle, false);; paramInt = 1)
    {
      if (this.jdField_a_of_type_Akdn != null) {
        this.jdField_a_of_type_Akdn.a(paramBoolean, paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList onReceiveerrCode:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nff
 * JD-Core Version:    0.7.0.1
 */