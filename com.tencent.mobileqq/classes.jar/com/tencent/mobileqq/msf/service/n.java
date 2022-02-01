package com.tencent.mobileqq.msf.service;

import android.os.Binder;
import android.os.Process;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.net.c.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.a.b;

class n
  extends IBaseService.Stub
{
  n(MsfService paramMsfService) {}
  
  public int getMsfConnectedIPFamily()
  {
    try
    {
      int i = MsfService.core.sender.b.f();
      return i;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    return 0;
  }
  
  public int getMsfConnectedNetType()
  {
    try
    {
      int i = MsfService.core.sender.b.e();
      return i;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    return 0;
  }
  
  public int onKillProcess()
  {
    Process.killProcess(Process.myPid());
    return 0;
  }
  
  public int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString)
  {
    try
    {
      a locala = MsfService.core.getDeepSleepDetector();
      if (locala != null) {
        locala.a(paramBoolean, paramLong, paramString);
      }
    }
    catch (Exception paramString)
    {
      label22:
      break label22;
    }
    return 0;
  }
  
  public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
  {
    return null;
  }
  
  public int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.S.MsfService", 2, "sendToServiceMsg toServiceMsg null!");
      }
      return -1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MsfService#sendToServiceMsg start: cmd = ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      QLog.d("MSF.S.MsfService", 2, localStringBuilder.toString());
    }
    int i = MsfCore.getNextSeq();
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(i);
    }
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    if (MsfService.core.getMsfAppid() == -1) {
      MsfService.core.setMsfAppid(paramToServiceMsg.getAppId());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MsfService#sendToServiceMsg: ");
      localStringBuilder.append(paramToServiceMsg.getStringForLog());
      QLog.d("MSF.S.MsfService", 2, localStringBuilder.toString());
    }
    try
    {
      int j = Binder.getCallingUid();
      paramToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
      if (paramToServiceMsg.getServiceCmd().startsWith("cmd_sync_syncuser"))
      {
        this.a.handleAccountSyncRequest(this.a, paramToServiceMsg, j);
        return i;
      }
      b.a();
      if (MsfService.isSamePackage(this.a, j, paramToServiceMsg.getServiceCmd()))
      {
        MsfService.msfServiceReqHandler.a(this.a, paramToServiceMsg, j);
        return i;
      }
      return -2;
    }
    catch (Exception paramToServiceMsg)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("service handle msg error ");
      localStringBuilder.append(paramToServiceMsg);
      QLog.w("MSF.S.MsfService", 1, localStringBuilder.toString(), paramToServiceMsg);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.n
 * JD-Core Version:    0.7.0.1
 */