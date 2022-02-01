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
    paramComponentName.c = false;
    paramComponentName.b = ISmartDeviceService.Stub.a(paramIBinder);
    this.a.b();
    QLog.d("SmartDeviceIPCHost", 1, "plugin service connected");
    if (this.a.a != null) {
      SmartDeviceReport.a(this.a.a, "Net_Start_Service_Host", 0, 1, 0);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (this.a.a != null) {
        this.a.a.getApplication().unbindService(this.a.e);
      }
      label30:
      paramComponentName = this.a;
      paramComponentName.b = null;
      paramComponentName.c = false;
      QLog.d("SmartDeviceIPCHost", 1, "plugin service disconnected");
      return;
    }
    catch (Exception paramComponentName)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.smartdevice.ipc.SmartDeviceIPCHost.2
 * JD-Core Version:    0.7.0.1
 */