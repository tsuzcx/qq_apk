package cooperation.qqdataline.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class DatalineRemoteManager$7
  implements ServiceConnection
{
  DatalineRemoteManager$7(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    paramComponentName = this.a;
    paramComponentName.jdField_a_of_type_Boolean = false;
    paramComponentName.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService = IDatalineService.Stub.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService connected");
    }
    paramComponentName = (RegisterProxySvcPackHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    this.a.a(paramComponentName.a(), paramComponentName.d(), paramComponentName.e(), paramComponentName.f(), paramComponentName.a());
    DatalineRemoteManager.d(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(DatalineRemoteManager.a(this.a));
    paramComponentName = this.a;
    paramComponentName.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService = null;
    paramComponentName.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService disconnected");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.7
 * JD-Core Version:    0.7.0.1
 */