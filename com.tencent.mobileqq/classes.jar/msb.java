import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class msb
  implements Runnable
{
  public msb(ServiceAccountFolderManager paramServiceAccountFolderManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_last_read_time", ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_last_enter_time", ServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager));
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "setFolderLastReadTime->mFolderLastReadTime:" + ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager) + ", mFolderLastEnterTime:" + ServiceAccountFolderManager.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msb
 * JD-Core Version:    0.7.0.1
 */