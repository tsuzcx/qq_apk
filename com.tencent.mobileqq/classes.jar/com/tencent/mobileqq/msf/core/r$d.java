package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.b.c;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class r$d
  implements Runnable
{
  private ToServiceMsg b;
  
  public r$d(r paramr, ToServiceMsg paramToServiceMsg)
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
        if ((ToServiceMsg)this.a.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq())) != null)
        {
          ToServiceMsg localToServiceMsg = (ToServiceMsg)this.a.a.sender.d.remove(Integer.valueOf(this.b.getRequestSsoSeq()));
          if (localToServiceMsg.isNeedCallback()) {
            if (localToServiceMsg == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("MSF.C.NetConnTag", 2, "timeout msg " + localToServiceMsg + " also received resp, return.");
            }
          }
        }
      }
      catch (Exception localException1)
      {
        QLog.d("MSF.C.NetConnTag", 1, "got fail msg. " + localException1, localException1);
        return;
      }
    }
    Object localObject = localException1.getServiceCmd();
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + localException1.getRequestSsoSeq() + " uin:" + localException1.getUin() + " cmd:" + (String)localObject + " costTime:" + localException1.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:" + 1002 + " failMsg:" + "wait serverResp timeout");
    }
    for (;;)
    {
      localObject = t.a(localException1);
      ((FromServiceMsg)localObject).setBusinessFail(1002, "wait serverResp timeout");
      boolean bool = this.a.a.sender.a(localException1, (FromServiceMsg)localObject);
      if (!bool) {
        break;
      }
      try
      {
        this.a.a.getSsoRespHandler().b(localException1, (FromServiceMsg)localObject);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return;
      }
      QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + localException2.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(localException2.getUin()) + " cmd:" + c.a((String)localObject) + " costTime:" + localException2.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:" + 1002 + " failMsg:" + "wait serverResp timeout");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.r.d
 * JD-Core Version:    0.7.0.1
 */