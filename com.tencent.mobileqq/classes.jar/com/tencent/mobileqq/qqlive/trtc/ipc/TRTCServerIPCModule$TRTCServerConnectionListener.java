package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class TRTCServerIPCModule$TRTCServerConnectionListener
  implements EIPCOnGetConnectionListener
{
  TRTCServerIPCModule$TRTCServerConnectionListener(TRTCServerIPCModule paramTRTCServerIPCModule) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    QLog.d("TRTCServerIPCModule", 1, "onConnectBind");
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    QLog.d("TRTCServerIPCModule", 1, "onConnectUnbind");
    if (paramEIPCConnection == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq live onConnectUnbind, [");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.e("TRTCServerIPCModule", 1, localStringBuilder.toString());
    if (TextUtils.equals(paramEIPCConnection.procName, TRTCIPCManager.b().g()))
    {
      TRTCServerIPCModule.c(this.a);
      paramEIPCConnection = TRTCServerIPCModule.d(this.a).iterator();
      while (paramEIPCConnection.hasNext()) {
        ((ITRTCIPCListener)paramEIPCConnection.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule.TRTCServerConnectionListener
 * JD-Core Version:    0.7.0.1
 */