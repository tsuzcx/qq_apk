package com.tencent.mobileqq.msf.sdk.report;

import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class e
{
  public static final String a = "StatReportManager";
  public static String b = "1000";
  private static final String c = "param_ProductVersion";
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3, boolean paramBoolean2)
  {
    if (paramString1 == null) {
      paramString1 = "10000";
    }
    for (;;)
    {
      paramString3 = paramString1;
      if (paramString1 != null)
      {
        paramString3 = paramString1;
        if (paramString1.length() < 1) {
          paramString3 = "10000";
        }
      }
      UserAction.setUserID(paramString3);
      paramString3 = new RdmReq();
      paramString3.eventName = paramString2;
      paramString3.elapse = paramLong1;
      paramString3.size = paramLong2;
      paramString3.isSucceed = paramBoolean1;
      paramString3.isRealTime = paramBoolean2;
      if (paramHashMap == null)
      {
        paramString1 = new HashMap();
        if (paramString1 != null) {
          paramString1.put("param_ProductVersion", "" + BaseApplication.getContext().getAppId());
        }
        if (QLog.isColorLevel()) {
          QLog.d("StatReportManager", 2, "event report: " + paramString2 + " " + paramBoolean1 + " time:" + paramLong1 + " size:" + paramLong2);
        }
        if ((paramBoolean1) && ((!paramString1.containsKey("param_FailCode")) || ("".equals(paramString1.get("param_FailCode"))))) {
          paramString1.put("param_FailCode", String.valueOf(0));
        }
        paramString3.params = paramString1;
      }
      try
      {
        paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString3);
        paramString1.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        Iterator localIterator;
        return;
      }
      paramString1 = new HashSet();
      paramString1.addAll(paramHashMap.keySet());
      localIterator = paramString1.iterator();
      for (;;)
      {
        paramString1 = paramHashMap;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString1 = (String)localIterator.next();
        if ((String)paramHashMap.get(paramString1) == null) {
          paramHashMap.put(paramString1, "");
        }
      }
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    try
    {
      Properties localProperties = new Properties();
      localProperties.put("uin", MsfCore.sCore.getAccountCenter().i());
      localProperties.put("exception", paramThrowable.getMessage());
      if (MTAReportManager.getMtaReporter() != null) {
        MTAReportManager.getMtaReporter().reportKVEvent("monitor_IllegalMonitorStateException", localProperties);
      }
      return;
    }
    catch (Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.report.e
 * JD-Core Version:    0.7.0.1
 */