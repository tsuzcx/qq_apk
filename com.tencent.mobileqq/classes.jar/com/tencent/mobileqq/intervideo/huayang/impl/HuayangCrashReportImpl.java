package com.tencent.mobileqq.intervideo.huayang.impl;

import com.tencent.mobileqq.intervideo.huayang.HuayangCrashReport;
import com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport;

public class HuayangCrashReportImpl
  implements IHuayangCrashReport
{
  public void handleReport(Throwable paramThrowable)
  {
    HuayangCrashReport.b(paramThrowable);
  }
  
  public void report(Throwable paramThrowable)
  {
    HuayangCrashReport.a(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangCrashReportImpl
 * JD-Core Version:    0.7.0.1
 */