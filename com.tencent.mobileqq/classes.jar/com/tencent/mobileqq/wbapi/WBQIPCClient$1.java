package com.tencent.mobileqq.wbapi;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class WBQIPCClient$1
  implements EIPCResultCallback
{
  WBQIPCClient$1(Runnable paramRunnable) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("OpenSdkQIPCClient", 1, "WBQIPCClient installWBSdk onCallback");
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wbapi.WBQIPCClient.1
 * JD-Core Version:    0.7.0.1
 */