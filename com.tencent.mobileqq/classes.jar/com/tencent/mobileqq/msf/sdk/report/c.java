package com.tencent.mobileqq.msf.sdk.report;

import com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class c
  implements IMsfLifeCallbacker
{
  public static final String a = "StatManager";
  private boolean b = true;
  
  public static c a()
  {
    return c.a.a();
  }
  
  public void onBindEnd(boolean paramBoolean)
  {
    if (this.b) {}
    try
    {
      e.e.b().a(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("StatManager", 1, "", localException);
      localException.printStackTrace();
    }
  }
  
  public void onBindStart()
  {
    if (this.b) {}
    try
    {
      e.b.b().c();
      e.e.b().c();
      return;
    }
    catch (Exception localException)
    {
      QLog.w("StatManager", 1, "", localException);
      localException.printStackTrace();
    }
  }
  
  public void onReceiveResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void onRecvServicePushResp(FromServiceMsg paramFromServiceMsg) {}
  
  public void onReqServiceConn()
  {
    if (this.b) {}
    try
    {
      e.b.b().a(System.currentTimeMillis());
      return;
    }
    catch (Exception localException)
    {
      QLog.w("StatManager", 1, "", localException);
      localException.printStackTrace();
    }
  }
  
  public void onRespToApp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSendMsg(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return;
      e.b = paramToServiceMsg.getUin();
    } while (!this.b);
  }
  
  public void onSendToService(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {}
    while (!this.b) {
      return;
    }
  }
  
  public void onServiceConnected()
  {
    if (this.b) {}
    try
    {
      e.b.b().a(true);
      e.e.b().d();
      return;
    }
    catch (Exception localException)
    {
      QLog.w("StatManager", 1, "", localException);
      localException.printStackTrace();
    }
  }
  
  public void onServiceDisconnected()
  {
    if (this.b) {}
    try
    {
      e.e.b().e();
      return;
    }
    catch (Exception localException)
    {
      QLog.w("StatManager", 1, "", localException);
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.report.c
 * JD-Core Version:    0.7.0.1
 */