package com.tencent.mobileqq.transfile.dns;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class InnerDns$1
  implements EIPClientConnectListener
{
  InnerDns$1(InnerDns paramInnerDns) {}
  
  public void connectFailed()
  {
    InnerDns.access$102(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      InnerDns.access$002(this.this$0, paramEIPCConnection.procName);
    }
    InnerDns.access$102(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectSuccess");
    }
    InnerDns.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.InnerDns.1
 * JD-Core Version:    0.7.0.1
 */