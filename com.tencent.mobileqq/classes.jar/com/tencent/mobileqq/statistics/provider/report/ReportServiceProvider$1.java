package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bridge.report.service.IReportService;
import com.tencent.mobileqq.kandian.base.report.api.IReadInJoyDataProviderObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class ReportServiceProvider$1
  implements IReportService
{
  ReportServiceProvider$1(ReportServiceProvider paramReportServiceProvider) {}
  
  public AppRuntime a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime == null) && (BaseApplicationImpl.sProcessId == 1))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return localAppRuntime;
      }
    }
    return paramAppRuntime;
  }
  
  /* Error */
  public void a(android.content.Intent paramIntent, AppRuntime paramAppRuntime)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 33
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: checkcast 33	com/tencent/mobileqq/app/QQAppInterface
    //   12: astore_2
    //   13: aload_1
    //   14: ldc 40
    //   16: iconst_m1
    //   17: invokevirtual 46	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   20: istore_3
    //   21: iload_3
    //   22: sipush 1001
    //   25: if_icmpne +18 -> 43
    //   28: aload_2
    //   29: getstatic 51	com/tencent/mobileqq/app/QQManagerFactory:LBS_REPORT_MANAGER	I
    //   32: invokevirtual 55	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   35: checkcast 57	com/tencent/mobileqq/app/soso/LbsInfoReportManager
    //   38: aload_1
    //   39: invokevirtual 60	com/tencent/mobileqq/app/soso/LbsInfoReportManager:a	(Landroid/content/Intent;)V
    //   42: return
    //   43: aload_1
    //   44: ldc 62
    //   46: invokevirtual 66	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 4
    //   51: aload_1
    //   52: ldc 68
    //   54: invokevirtual 66	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 5
    //   59: ldc 70
    //   61: aload 4
    //   63: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifeq +24 -> 90
    //   69: iload_3
    //   70: iconst_1
    //   71: if_icmpne +68 -> 139
    //   74: aload 4
    //   76: aload_2
    //   77: aload_1
    //   78: ldc 68
    //   80: invokevirtual 80	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   83: checkcast 82	com/tencent/mobileqq/search/report/ReportModel
    //   86: invokestatic 87	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Ljava/lang/String;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModel;)V
    //   89: return
    //   90: ldc 89
    //   92: aload 4
    //   94: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +42 -> 139
    //   100: iload_3
    //   101: ifne +12 -> 113
    //   104: aload 4
    //   106: aload_2
    //   107: aload 5
    //   109: invokestatic 95	com/tencent/mobileqq/statistics/CaptureReportController:b	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   112: return
    //   113: iload_3
    //   114: iconst_1
    //   115: if_icmpne +24 -> 139
    //   118: aload 4
    //   120: aload_2
    //   121: aload 5
    //   123: invokestatic 97	com/tencent/mobileqq/statistics/CaptureReportController:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   126: return
    //   127: astore_1
    //   128: ldc 99
    //   130: iconst_1
    //   131: aload_1
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   139: return
    //   140: astore_1
    //   141: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	1
    //   0	142	1	paramIntent	android.content.Intent
    //   0	142	2	paramAppRuntime	AppRuntime
    //   20	96	3	i	int
    //   49	70	4	str1	String
    //   57	65	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   13	21	127	java/lang/Exception
    //   28	42	127	java/lang/Exception
    //   43	59	127	java/lang/Exception
    //   59	69	127	java/lang/Exception
    //   74	89	127	java/lang/Exception
    //   90	100	127	java/lang/Exception
    //   104	112	127	java/lang/Exception
    //   118	126	127	java/lang/Exception
    //   59	69	140	java/lang/OutOfMemoryError
    //   74	89	140	java/lang/OutOfMemoryError
    //   90	100	140	java/lang/OutOfMemoryError
    //   104	112	140	java/lang/OutOfMemoryError
    //   118	126	140	java/lang/OutOfMemoryError
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!"CliOper".equals(paramString1)) {
      try
      {
        ((IReadInJoyDataProviderObserver)QRoute.api(IReadInJoyDataProviderObserver.class)).doReport(paramString2, paramString3);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("ReportServiceProvider", 1, "afterReportClickEvent error", paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.ReportServiceProvider.1
 * JD-Core Version:    0.7.0.1
 */