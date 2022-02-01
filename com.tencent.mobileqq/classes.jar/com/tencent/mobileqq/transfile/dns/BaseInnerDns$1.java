package com.tencent.mobileqq.transfile.dns;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class BaseInnerDns$1
  implements EIPClientConnectListener
{
  BaseInnerDns$1(BaseInnerDns paramBaseInnerDns) {}
  
  public void connectFailed()
  {
    BaseInnerDns.access$102(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      BaseInnerDns.access$002(this.this$0, paramEIPCConnection.procName);
    }
    BaseInnerDns.access$102(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectSuccess");
    }
    BaseInnerDns.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.BaseInnerDns.1
 * JD-Core Version:    0.7.0.1
 */