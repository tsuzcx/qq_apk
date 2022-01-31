import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager;
import com.tencent.qphone.base.util.QLog;

public class rbp
  implements DialogInterface.OnClickListener
{
  public rbp(DefaultDoraemonAPIManager paramDefaultDoraemonAPIManager, UserPermission paramUserPermission, APIConfig paramAPIConfig, APIParam paramAPIParam, APICallback paramAPICallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "reject " + this.jdField_a_of_type_ComTencentMobileqqDoraemonUserPermission.a);
    DefaultDoraemonAPIManager.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAPIManager, this.jdField_a_of_type_ComTencentMobileqqDoraemonUserPermission, 1);
    DefaultDoraemonAPIManager.b(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAPIManager, 4, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPIConfig, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPIParam, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbp
 * JD-Core Version:    0.7.0.1
 */