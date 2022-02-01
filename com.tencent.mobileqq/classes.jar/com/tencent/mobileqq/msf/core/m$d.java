package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class m$d
  implements Runnable
{
  private ToServiceMsg b;
  
  public m$d(m paramm, ToServiceMsg paramToServiceMsg)
  {
    this.b = paramToServiceMsg;
  }
  
  public void run()
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "req null, return.");
      }
    }
    for (;;)
    {
      return;
      try
      {
        if ((ToServiceMsg)this.a.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq())) == null) {
          continue;
        }
        ToServiceMsg localToServiceMsg = (ToServiceMsg)this.a.a.sender.d.remove(Integer.valueOf(this.b.getRequestSsoSeq()));
        if (!localToServiceMsg.isNeedCallback()) {
          continue;
        }
        if (localToServiceMsg == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MSF.C.NetConnTag", 2, "timeout msg " + localToServiceMsg + " also received resp, return.");
          return;
        }
      }
      catch (Exception localException1)
      {
        QLog.d("MSF.C.NetConnTag", 1, "got fail msg. " + localException1, localException1);
        return;
      }
      Object localObject = localException1.getServiceCmd();
      if (QLog.isDevelopLevel())
      {
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + localException1.getRequestSsoSeq() + " uin:" + localException1.getUin() + " cmd:" + (String)localObject + " costTime:" + localException1.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:" + 1002 + " failMsg:" + "wait serverResp timeout");
        localObject = o.a(localException1);
        ((FromServiceMsg)localObject).setBusinessFail(1002, "wait serverResp timeout");
        boolean bool = this.a.a.sender.a(localException1, (FromServiceMsg)localObject);
        if (!bool) {}
      }
      try
      {
        this.a.a.getSsoRespHandler().b(localException1, (FromServiceMsg)localObject);
        if ((this.a.a.getStatReporter() == null) || (!localException1.isSupportRetry())) {
          continue;
        }
        this.a.a.getStatReporter().e(false);
        return;
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + localException1.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(localException1.getUin()) + " cmd:" + a.a((String)localObject) + " costTime:" + localException1.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:" + 1002 + " failMsg:" + "wait serverResp timeout");
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.m.d
 * JD-Core Version:    0.7.0.1
 */