package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class q
  extends IMsfServiceCallbacker.Stub
{
  q(p paramp) {}
  
  public boolean isBinderAlive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "isBinderAlive");
    }
    return super.isBinderAlive();
  }
  
  public void onRecvPushResp(FromServiceMsg paramFromServiceMsg)
  {
    p.a(this.a, paramFromServiceMsg);
    c.a().onRecvServicePushResp(paramFromServiceMsg);
  }
  
  public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    p.a(this.a, paramToServiceMsg, paramFromServiceMsg);
    c.a().onReceiveResp(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean pingBinder()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "pingBinder");
    }
    return super.pingBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.q
 * JD-Core Version:    0.7.0.1
 */