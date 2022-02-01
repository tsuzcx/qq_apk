package com.tencent.open;

import com.tencent.open.agent.util.SSOLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

final class OpenSdkQIPCClient$1
  implements EIPClientConnectListener
{
  public void connectFailed()
  {
    SSOLog.a("OpenSdkQIPCClient", new Object[] { "connectFailed" });
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    SSOLog.a("OpenSdkQIPCClient", new Object[] { "connectSuccess" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.OpenSdkQIPCClient.1
 * JD-Core Version:    0.7.0.1
 */