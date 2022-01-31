package com.tencent.mobileqq.msf.sdk.report;

import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Properties;

public class e$a
{
  HashMap a = null;
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public void a(RdmReq paramRdmReq)
  {
    try
    {
      paramRdmReq = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramRdmReq);
      paramRdmReq.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramRdmReq);
      return;
    }
    catch (Exception paramRdmReq) {}
  }
  
  public void a(String paramString)
  {
    RdmReq localRdmReq = new RdmReq();
    localRdmReq.eventName = paramString;
    localRdmReq.isRealTime = true;
    localRdmReq.params = this.a;
    a(localRdmReq);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      Properties localProperties = new Properties();
      if ((this.a != null) && (this.a.size() > 0)) {
        localProperties.putAll(this.a);
      }
      if (MTAReportManager.getMtaReporter() != null) {
        MTAReportManager.getMtaReporter().reportTimeKVEvent(paramString, localProperties, paramInt);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("StatReportManager", 1, "reportTimeMTA", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    this.a.put(paramString1, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
  {
    RdmReq localRdmReq = new RdmReq();
    localRdmReq.eventName = paramString;
    localRdmReq.isSucceed = paramBoolean1;
    localRdmReq.elapse = paramLong1;
    localRdmReq.size = paramLong2;
    localRdmReq.isRealTime = paramBoolean2;
    localRdmReq.params = this.a;
    a(localRdmReq);
  }
  
  public void b(String paramString)
  {
    try
    {
      Properties localProperties = new Properties();
      if ((this.a != null) && (this.a.size() > 0)) {
        localProperties.putAll(this.a);
      }
      if (MTAReportManager.getMtaReporter() != null) {
        MTAReportManager.getMtaReporter().reportKVEvent(paramString, localProperties);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("StatReportManager", 1, "reportMTA", paramString);
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.report.e.a
 * JD-Core Version:    0.7.0.1
 */