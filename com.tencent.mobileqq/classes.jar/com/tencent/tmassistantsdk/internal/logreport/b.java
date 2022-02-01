package com.tencent.tmassistantsdk.internal.logreport;

import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport;

public class b
  extends a
{
  protected static b d;
  
  public static String a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramTMAssistantCallYYBParamStruct != null)
    {
      localStringBuffer.append(GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()));
      localStringBuffer.append("_");
      localStringBuffer.append(String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext())));
      localStringBuffer.append("_");
      localStringBuffer.append(paramTMAssistantCallYYBParamStruct.channelId);
      localStringBuffer.append("_");
      localStringBuffer.append(paramTMAssistantCallYYBParamStruct.via);
      localStringBuffer.append("_");
      localStringBuffer.append(paramTMAssistantCallYYBParamStruct.uin);
      localStringBuffer.append("_");
      localStringBuffer.append(paramTMAssistantCallYYBParamStruct.taskAppId);
      localStringBuffer.append("_");
      localStringBuffer.append(paramTMAssistantCallYYBParamStruct.taskPackageName);
      localStringBuffer.append("_");
      localStringBuffer.append(paramTMAssistantCallYYBParamStruct.taskVersion);
    }
    paramTMAssistantCallYYBParamStruct = new StringBuilder();
    paramTMAssistantCallYYBParamStruct.append("logStr=");
    paramTMAssistantCallYYBParamStruct.append(localStringBuffer);
    ab.c("BusinessReportManager", paramTMAssistantCallYYBParamStruct.toString());
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
    ab.c("BusinessReportManager", "createTipsInfoLog");
    StatStdReport localStatStdReport = new StatStdReport();
    localStatStdReport.name = paramString3;
    localStatStdReport.time = System.currentTimeMillis();
    localStatStdReport.versionInfo = "1.3";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.b
 * JD-Core Version:    0.7.0.1
 */