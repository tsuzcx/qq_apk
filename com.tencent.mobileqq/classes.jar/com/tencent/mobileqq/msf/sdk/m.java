package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class m
  extends IMsfServiceCallbacker.Stub
{
  m(k paramk) {}
  
  public boolean isBinderAlive()
  {
    QLog.i("MSF.D.Proxy", 1, "isBinderAlive");
    return super.isBinderAlive();
  }
  
  public void onRecvPushResp(FromServiceMsg paramFromServiceMsg)
  {
    k.a(this.a, paramFromServiceMsg);
    c.a().onRecvServicePushResp(paramFromServiceMsg);
  }
  
  public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    k.a(this.a, paramToServiceMsg, paramFromServiceMsg);
    c.a().onReceiveResp(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean pingBinder()
  {
    QLog.i("MSF.D.Proxy", 1, "pingBinder");
    return super.pingBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.m
 * JD-Core Version:    0.7.0.1
 */