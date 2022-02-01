package com.tencent.mobileqq.transfile.dns;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class BaseInnerDns$2
  implements EIPCOnGetConnectionListener
{
  BaseInnerDns$2(BaseInnerDns paramBaseInnerDns) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      BaseInnerDns.access$002(this.this$0, paramEIPCConnection.procName);
    }
    BaseInnerDns.access$102(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      BaseInnerDns.access$002(this.this$0, paramEIPCConnection.procName);
    }
    BaseInnerDns.access$102(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.BaseInnerDns.2
 * JD-Core Version:    0.7.0.1
 */