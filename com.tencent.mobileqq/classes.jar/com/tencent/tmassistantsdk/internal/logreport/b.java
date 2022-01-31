package com.tencent.tmassistantsdk.internal.logreport;

import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport;

public class b
  extends a
{
  protected static b d = null;
  
  public static String a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramTMAssistantCallYYBParamStruct != null) {
      localStringBuffer.append(GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext())).append("_").append(String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()))).append("_").append(paramTMAssistantCallYYBParamStruct.channelId).append("_").append(paramTMAssistantCallYYBParamStruct.via).append("_").append(paramTMAssistantCallYYBParamStruct.uin).append("_").append(paramTMAssistantCallYYBParamStruct.taskAppId).append("_").append(paramTMAssistantCallYYBParamStruct.taskPackageName).append("_").append(paramTMAssistantCallYYBParamStruct.taskVersion);
    }
    ac.c("BusinessReportManager", "logStr=" + localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static b g()
  {
    try
    {
      if (d == null) {
        d = new b();
      }
      b localb = d;
      return localb;
    }
    finally {}
  }
  
  public StatStdReport a(String paramString1, String paramString2, String paramString3)
  {
    ac.c("BusinessReportManager", "createTipsInfoLog");
    StatStdReport localStatStdReport = new StatStdReport();
    localStatStdReport.name = paramString3;
    localStatStdReport.time = System.currentTimeMillis();
    localStatStdReport.versionInfo = "1.0";
    localStatStdReport.extraData = paramString1;
    localStatStdReport.traceId = paramString2;
    return localStatStdReport;
  }
  
  protected com.tencent.tmassistant.common.a.a d()
  {
    return com.tencent.tmassistantsdk.internal.c.a.a.e();
  }
  
  protected byte e()
  {
    return 3;
  }
  
  protected boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.b
 * JD-Core Version:    0.7.0.1
 */