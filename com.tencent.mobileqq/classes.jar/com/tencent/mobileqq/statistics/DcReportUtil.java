package com.tencent.mobileqq.statistics;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class DcReportUtil
{
  private static AtomicLong a = new AtomicLong(0L);
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DcReportUtil", 2, "reportDCEvent tag or detail is null: " + paramString1 + ", " + paramString2);
      }
      return;
    }
    if (paramAppRuntime == null)
    {
      ThreadManager.post(new DcReportUtil.2(paramString1, paramString2), 5, null, true);
      return;
    }
    a(paramAppRuntime, paramString1, paramString2, 1);
  }
  
  private static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      paramString1 = ReportControllerServiceHolder.a();
      if (paramString1 != null) {
        paramString1.a(paramAppRuntime);
      }
      if (0 != 0)
      {
        paramString1 = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          paramString1 = paramString2.replace("${uin_unknown}", paramAppRuntime.getAccount());
        }
        throw new NullPointerException();
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String str = "${count_unknown}|" + paramString2;
    paramString2 = str;
    if (!paramBoolean)
    {
      long l = a.incrementAndGet();
      paramString2 = "${report_seq_prefix}" + l + "|" + str;
    }
    if (paramAppRuntime == null)
    {
      ThreadManager.post(new DcReportUtil.1(paramString1, paramString2), 5, null, true);
      return;
    }
    a(paramAppRuntime, paramString1, paramString2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DcReportUtil
 * JD-Core Version:    0.7.0.1
 */