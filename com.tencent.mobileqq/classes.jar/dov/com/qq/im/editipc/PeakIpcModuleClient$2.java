package dov.com.qq.im.editipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class PeakIpcModuleClient$2
  implements EIPCOnGetConnectionListener
{
  PeakIpcModuleClient$2(PeakIpcModuleClient paramPeakIpcModuleClient) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      PeakIpcModuleClient.a(this.a, paramEIPCConnection.procName);
    }
    PeakIpcModuleClient.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "onConnectBind!");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      PeakIpcModuleClient.a(this.a, paramEIPCConnection.procName);
    }
    PeakIpcModuleClient.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "onConnectUnbind:" + PeakIpcModuleClient.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleClient.2
 * JD-Core Version:    0.7.0.1
 */