import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class nsq
  implements BusinessObserver
{
  nsq(QQAppInterface paramQQAppInterface, boolean paramBoolean, aoeg paramaoeg) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList isSuccess:" + String.valueOf(paramBoolean));
    }
    paramBundle = paramBundle.getByteArray("data");
    if ((paramBoolean) && (paramBundle != null)) {}
    for (paramInt = nsp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean, paramBundle, false);; paramInt = 1)
    {
      if (this.jdField_a_of_type_Aoeg != null) {
        this.jdField_a_of_type_Aoeg.onDynamicListGet(paramBoolean, paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList onReceiveerrCode:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsq
 * JD-Core Version:    0.7.0.1
 */