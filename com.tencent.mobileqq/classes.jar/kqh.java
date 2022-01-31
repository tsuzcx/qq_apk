import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class kqh
  implements BusinessObserver
{
  public kqh(QQAppInterface paramQQAppInterface, boolean paramBoolean, PublicAccountObserver paramPublicAccountObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList isSuccess:" + String.valueOf(paramBoolean));
    }
    paramBundle = paramBundle.getByteArray("data");
    if ((paramBoolean) && (paramBundle != null)) {}
    for (paramInt = AccountDetailDynamicListModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean, paramBundle, false);; paramInt = 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(paramBoolean, paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList onReceiveerrCode:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqh
 * JD-Core Version:    0.7.0.1
 */