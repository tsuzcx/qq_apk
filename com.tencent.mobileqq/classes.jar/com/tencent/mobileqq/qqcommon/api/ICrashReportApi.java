package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface ICrashReportApi
  extends QRouteApi
{
  public abstract void postException(int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap);
  
  public abstract void postException(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.ICrashReportApi
 * JD-Core Version:    0.7.0.1
 */