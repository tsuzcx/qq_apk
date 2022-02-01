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
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramAppRuntime == null)
      {
        ThreadManager.post(new DcReportUtil.2(paramString1, paramString2), 5, null, true);
        return;
      }
      a(paramAppRuntime, paramString1, paramString2, 1);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("reportDCEvent tag or detail is null: ");
      paramAppRuntime.append(paramString1);
      paramAppRuntime.append(", ");
      paramAppRuntime.append(paramString2);
      QLog.d("DcReportUtil", 2, paramAppRuntime.toString());
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 == null) {
      return;
    }
    Object localObject = ReportControllerServiceHolder.a();
    if (localObject == null) {
      return;
    }
    ReportController localReportController = (ReportController)((IReportDataProviderService)localObject).a(paramAppRuntime);
    if (localReportController == null) {
      return;
    }
    localObject = paramString2;
    if (paramString2.contains("${uin_unknown}")) {
      localObject = paramString2.replace("${uin_unknown}", paramAppRuntime.getAccount());
    }
    localReportController.a(paramString1, (String)localObject, paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("${count_unknown}|");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
      paramString2 = (String)localObject;
      if (!paramBoolean)
      {
        long l = a.incrementAndGet();
        paramString2 = new StringBuilder();
        paramString2.append("${report_seq_prefix}");
        paramString2.append(l);
        paramString2.append("|");
        paramString2.append((String)localObject);
        paramString2 = paramString2.toString();
      }
      if (paramAppRuntime == null)
      {
        ThreadManager.post(new DcReportUtil.1(paramString1, paramString2), 5, null, true);
        return;
      }
      a(paramAppRuntime, paramString1, paramString2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DcReportUtil
 * JD-Core Version:    0.7.0.1
 */