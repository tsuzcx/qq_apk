package com.tencent.mobileqq.statistics;

import ahrq;
import ahrr;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class DcReportUtil
{
  private static AtomicLong a = new AtomicLong(0L);
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DcReportUtil", 2, "reportDCEvent tag or detail is null: " + paramString1 + ", " + paramString2);
      }
      return;
    }
    if (paramQQAppInterface == null)
    {
      ThreadManager.post(new ahrr(paramString1, paramString2), 5, null, true);
      return;
    }
    a(paramQQAppInterface, paramString1, paramString2, 1);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      ReportController localReportController = paramQQAppInterface.a();
      if (localReportController != null)
      {
        String str = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          str = paramString2.replace("${uin_unknown}", paramQQAppInterface.getCurrentAccountUin());
        }
        localReportController.a(paramString1, str, paramInt);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
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
    if (paramQQAppInterface == null)
    {
      ThreadManager.post(new ahrq(paramString1, paramString2), 5, null, true);
      return;
    }
    a(paramQQAppInterface, paramString1, paramString2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DcReportUtil
 * JD-Core Version:    0.7.0.1
 */