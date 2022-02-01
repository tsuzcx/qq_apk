package dov.com.qq.im.editipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class PeakIpcModuleClient$1
  implements EIPClientConnectListener
{
  PeakIpcModuleClient$1(PeakIpcModuleClient paramPeakIpcModuleClient) {}
  
  public void connectFailed()
  {
    PeakIpcModuleClient.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectFailed!");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      PeakIpcModuleClient.a(this.a, paramEIPCConnection.procName);
    }
    PeakIpcModuleClient.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectSuccess:" + PeakIpcModuleClient.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleClient.1
 * JD-Core Version:    0.7.0.1
 */