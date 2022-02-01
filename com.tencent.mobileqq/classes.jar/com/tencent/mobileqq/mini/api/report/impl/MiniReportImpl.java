package com.tencent.mobileqq.mini.api.report.impl;

import com.tencent.mobileqq.mini.api.report.IMiniReport;
import com.tencent.qqmini.proxyimpl.MiniReportProxyImpl;

public class MiniReportImpl
  implements IMiniReport
{
  public String getCrashReportAppInfo()
  {
    return MiniReportProxyImpl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.report.impl.MiniReportImpl
 * JD-Core Version:    0.7.0.1
 */