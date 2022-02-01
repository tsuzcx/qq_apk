package cooperation.smartdevice.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class SmartDeviceIPCHost$2
  implements ServiceConnection
{
  SmartDeviceIPCHost$2(SmartDeviceIPCHost paramSmartDeviceIPCHost) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    SmartDeviceIPCHost.a(this.a).removeMessages(1);
    paramComponentName = this.a;
    paramComponentName.jdField_a_of_type_Boolean = false;
    paramComponentName.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService = ISmartDeviceService.Stub.a(paramIBinder);
    this.a.b();
    QLog.d("SmartDeviceIPCHost", 1, "plugin service connected");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      SmartDeviceReport.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Host", 0, 1, 0);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(this.a.jdField_a_of_type_AndroidContentServiceConnection);
      }
      label30:
      paramComponentName = this.a;
      paramComponentName.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService = null;
      paramComponentName.jdField_a_of_type_Boolean = false;
      QLog.d("SmartDeviceIPCHost", 1, "plugin service disconnected");
      return;
    }
    catch (Exception paramComponentName)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.smartdevice.ipc.SmartDeviceIPCHost.2
 * JD-Core Version:    0.7.0.1
 */