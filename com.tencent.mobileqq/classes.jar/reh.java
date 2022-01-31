import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager;
import com.tencent.qphone.base.util.QLog;

public class reh
  implements DialogInterface.OnCancelListener
{
  public reh(DefaultDoraemonAPIManager paramDefaultDoraemonAPIManager, UserPermission paramUserPermission, APIConfig paramAPIConfig, APIParam paramAPIParam, APICallback paramAPICallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_ComTencentMobileqqDoraemonUserPermission.a);
    DefaultDoraemonAPIManager.c(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAPIManager, 4, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPIConfig, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPIParam, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     reh
 * JD-Core Version:    0.7.0.1
 */