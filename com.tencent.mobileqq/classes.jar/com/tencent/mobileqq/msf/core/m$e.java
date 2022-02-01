package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class m$e
  implements Runnable
{
  private m.d b;
  private ToServiceMsg c;
  
  public m$e(m paramm, ToServiceMsg paramToServiceMsg)
  {
    this.c = paramToServiceMsg;
  }
  
  public m$e(m paramm, ToServiceMsg paramToServiceMsg, m.d paramd)
  {
    this.c = paramToServiceMsg;
    this.b = paramd;
  }
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.c;
    if (localToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "req null, return.");
      }
      return;
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((m.d)localObject).a(localToServiceMsg);
    }
    try
    {
      if ((ToServiceMsg)this.a.a.sender.d.get(Integer.valueOf(this.c.getRequestSsoSeq())) != null)
      {
        localToServiceMsg = (ToServiceMsg)this.a.a.sender.d.remove(Integer.valueOf(this.c.getRequestSsoSeq()));
        if (!localToServiceMsg.isNeedCallback()) {
          return;
        }
        if (localToServiceMsg == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("timeout msg ");
          ((StringBuilder)localObject).append(localToServiceMsg);
          ((StringBuilder)localObject).append(" also received resp, return.");
          QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localObject = localToServiceMsg.getServiceCmd();
        boolean bool = QLog.isDevelopLevel();
        StringBuilder localStringBuilder2;
        if (bool)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("netRecv ssoSeq:");
          localStringBuilder2.append(localToServiceMsg.getRequestSsoSeq());
          localStringBuilder2.append(" uin:");
          localStringBuilder2.append(localToServiceMsg.getUin());
          localStringBuilder2.append(" cmd:");
          localStringBuilder2.append((String)localObject);
          localStringBuilder2.append(" costTime:");
          localStringBuilder2.append(localToServiceMsg.getTimeout());
          localStringBuilder2.append(NetConnInfoCenter.getSignalStrengthsLog());
          localStringBuilder2.append(" code:");
          localStringBuilder2.append(1002);
          localStringBuilder2.append(" failMsg:");
          localStringBuilder2.append("wait serverResp timeout");
          QLog.d("MSF.C.NetConnTag", 1, localStringBuilder2.toString());
        }
        else
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("netRecv ssoSeq:");
          localStringBuilder2.append(localToServiceMsg.getRequestSsoSeq());
          localStringBuilder2.append(" uin:");
          localStringBuilder2.append(MsfSdkUtils.getShortUin(localToServiceMsg.getUin()));
          localStringBuilder2.append(" cmd:");
          localStringBuilder2.append(a.a((String)localObject));
          localStringBuilder2.append(" costTime:");
          localStringBuilder2.append(localToServiceMsg.getTimeout());
          localStringBuilder2.append(NetConnInfoCenter.getSignalStrengthsLog());
          localStringBuilder2.append(" code:");
          localStringBuilder2.append(1002);
          localStringBuilder2.append(" failMsg:");
          localStringBuilder2.append("wait serverResp timeout");
          QLog.d("MSF.C.NetConnTag", 1, localStringBuilder2.toString());
        }
        localObject = o.a(localToServiceMsg);
        ((FromServiceMsg)localObject).setBusinessFail(1002, "wait serverResp timeout");
        bool = this.a.a.sender.a(localToServiceMsg, (FromServiceMsg)localObject);
        if (bool) {
          try
          {
            this.a.a.getSsoRespHandler().b(localToServiceMsg, (FromServiceMsg)localObject);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        if ((this.a.a.getStatReporter() != null) && (localToServiceMsg.isSupportRetry()))
        {
          this.a.a.getStatReporter().e(false);
          return;
        }
      }
    }
    catch (Exception localException1)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("got fail msg. ");
      localStringBuilder1.append(localException1);
      QLog.d("MSF.C.NetConnTag", 1, localStringBuilder1.toString(), localException1);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.m.e
 * JD-Core Version:    0.7.0.1
 */