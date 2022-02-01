package eipc;

import com.tencent.qphone.base.util.QLog;

class EIPCClient$ClientDeathRecipient$1
  implements EIPClientConnectListener
{
  EIPCClient$ClientDeathRecipient$1(EIPCClient.ClientDeathRecipient paramClientDeathRecipient) {}
  
  public void connectFailed()
  {
    QLog.d("EIPCConst", 2, "client binderDied connectFailed");
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    QLog.d("EIPCConst", 2, "client binderDied connectSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCClient.ClientDeathRecipient.1
 * JD-Core Version:    0.7.0.1
 */