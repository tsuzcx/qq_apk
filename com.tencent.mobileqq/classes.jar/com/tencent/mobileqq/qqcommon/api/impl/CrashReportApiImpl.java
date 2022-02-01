package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.qqcommon.api.ICrashReportApi;
import java.util.Map;

public class CrashReportApiImpl
  implements ICrashReportApi
{
  public void postException(int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    CrashReport.postException(paramInt, paramString1, paramString2, paramString3, paramMap);
  }
  
  public void postException(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    CrashReport.postException(paramThread, paramInt, paramString1, paramString2, paramString3, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.CrashReportApiImpl
 * JD-Core Version:    0.7.0.1
 */