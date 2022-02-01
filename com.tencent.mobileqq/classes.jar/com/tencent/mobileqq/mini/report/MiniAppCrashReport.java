package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.api.report.IMiniReport;
import com.tencent.qqmini.proxyimpl.MiniReportProxyImpl;

public class MiniAppCrashReport
  implements IMiniReport
{
  public String getCrashReportAppInfo()
  {
    return MiniReportProxyImpl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppCrashReport
 * JD-Core Version:    0.7.0.1
 */