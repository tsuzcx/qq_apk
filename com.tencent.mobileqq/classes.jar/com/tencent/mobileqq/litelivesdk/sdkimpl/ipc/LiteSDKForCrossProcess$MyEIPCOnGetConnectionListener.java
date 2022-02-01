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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ilive onConnectBind, [");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.i("LiteSDKForCrossProcess", 1, localStringBuilder.toString());
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
    QLog.i("LiteSDKForCrossProcess", 1, localStringBuilder.toString());
    if (TextUtils.equals(paramEIPCConnection.procName, "com.tencent.mobileqq:tool")) {
      LiteSDKForCrossProcess.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteSDKForCrossProcess.MyEIPCOnGetConnectionListener
 * JD-Core Version:    0.7.0.1
 */