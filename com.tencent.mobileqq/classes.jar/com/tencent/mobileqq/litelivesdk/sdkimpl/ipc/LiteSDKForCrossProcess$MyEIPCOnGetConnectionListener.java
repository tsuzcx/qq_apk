package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class LiteSDKForCrossProcess$MyEIPCOnGetConnectionListener
  implements EIPCOnGetConnectionListener
{
  LiteSDKForCrossProcess$MyEIPCOnGetConnectionListener(LiteSDKForCrossProcess paramLiteSDKForCrossProcess) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {
      return;
    }
    QLog.i("LiteSDKForCrossProcess", 1, "ilive onConnectBind, [" + paramEIPCConnection.procName + "]");
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {}
    do
    {
      return;
      QLog.i("LiteSDKForCrossProcess", 1, "ilive onConnectUnbind, [" + paramEIPCConnection.procName + "]");
    } while (!TextUtils.equals(paramEIPCConnection.procName, "com.tencent.mobileqq:tool"));
    LiteSDKForCrossProcess.a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteSDKForCrossProcess.MyEIPCOnGetConnectionListener
 * JD-Core Version:    0.7.0.1
 */