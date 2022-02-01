package com.tencent.mobileqq.qqlive.trtc.ipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPClientConnectListener;
import java.util.concurrent.atomic.AtomicInteger;

class TRTCClientIPCModule$IPCConnectListenerImpl
  implements EIPCOnGetConnectionListener, EIPClientConnectListener
{
  AtomicInteger a = new AtomicInteger(0);
  
  private TRTCClientIPCModule$IPCConnectListenerImpl(TRTCClientIPCModule paramTRTCClientIPCModule) {}
  
  public boolean a()
  {
    return this.a.get() == 2;
  }
  
  public void connectFailed()
  {
    this.a.set(3);
    QLog.e("TRTCClientIPCModule", 1, "qq live host connectFailed");
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    this.a.set(2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq live connectSuccess, server[");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.e("TRTCClientIPCModule", 1, localStringBuilder.toString());
    TRTCClientIPCModule.a("Action_Server_OnBind", null);
  }
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ilive onConnectBind, [");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.e("TRTCClientIPCModule", 1, localStringBuilder.toString());
    if (TRTCIPCManager.b().b(paramEIPCConnection.procName)) {
      this.a.set(2);
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ilive onConnectUnbind, [");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.e("TRTCClientIPCModule", 1, localStringBuilder.toString());
    if (TRTCIPCManager.b().b(paramEIPCConnection.procName)) {
      this.a.set(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ipc.TRTCClientIPCModule.IPCConnectListenerImpl
 * JD-Core Version:    0.7.0.1
 */