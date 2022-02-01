package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPClientConnectListener;
import java.util.concurrent.atomic.AtomicInteger;

class LiteLiveSDKClientIPCModule$IPCConnectListenerImpl
  implements EIPCOnGetConnectionListener, EIPClientConnectListener
{
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private LiteLiveSDKClientIPCModule$IPCConnectListenerImpl(LiteLiveSDKClientIPCModule paramLiteLiveSDKClientIPCModule) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public void connectFailed()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    QLog.e("LiteLiveSDKClientIPCModule", 1, "ilive connectFailed");
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ilive connectSuccess, server[");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.e("LiteLiveSDKClientIPCModule", 1, localStringBuilder.toString());
    if (BaseApplicationImpl.getApplication().getQQProcessName().equals("com.tencent.mobileqq:tool"))
    {
      paramEIPCConnection = new Bundle();
      QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnBind", paramEIPCConnection);
    }
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
    QLog.e("LiteLiveSDKClientIPCModule", 1, localStringBuilder.toString());
    if (TextUtils.equals("com.tencent.mobileqq", paramEIPCConnection.procName)) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
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
    QLog.e("LiteLiveSDKClientIPCModule", 1, localStringBuilder.toString());
    if (TextUtils.equals("com.tencent.mobileqq", paramEIPCConnection.procName)) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteLiveSDKClientIPCModule.IPCConnectListenerImpl
 * JD-Core Version:    0.7.0.1
 */