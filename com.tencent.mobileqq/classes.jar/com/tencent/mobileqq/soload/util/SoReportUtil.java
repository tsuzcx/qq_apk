package com.tencent.mobileqq.soload.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.temp.api.ISoloadOtherService;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

public class SoReportUtil
{
  private static ISoloadOtherService a = (ISoloadOtherService)QRoute.api(ISoloadOtherService.class);
  
  public static long a(LoadParam paramLoadParam)
  {
    int i = LoadParam.getItemSize(paramLoadParam);
    if (a != null) {}
    long l = a(paramLoadParam, null, "SoLoadModule", "SoLoad", "load.start", LoadParam.getReportStr(paramLoadParam), i, null);
    paramLoadParam.mReportSeq = l;
    return l;
  }
  
  public static long a(LoadParam paramLoadParam, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    if (LoadParam.isCloseReport(paramLoadParam)) {}
    while (a == null) {
      return 0L;
    }
    return a.startReport(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
  
  public static void a(LoadParam paramLoadParam, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (LoadParam.isCloseReport(paramLoadParam)) {}
    while (a == null) {
      return;
    }
    a.endReport(paramLong, paramString1, paramString2, paramInt, paramString3);
  }
  
  public static void a(LoadParam paramLoadParam, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (LoadParam.isCloseReport(paramLoadParam)) {}
    while (a == null) {
      return;
    }
    a.addReportItem(paramLong, paramString1, paramString2, paramString3, paramInt, paramString4);
  }
  
  public static void a(String paramString)
  {
    WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
    localWadlReportBuilder.a("dc00087").g("10").c("202528").a(32, paramString);
    localWadlReportBuilder.a();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(null, "SoLoadModule", "SoLoadSingle", "Exception", paramString1, 1, paramString2);
    a(paramString2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    if (a != null) {
      a.singleReport(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.b(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoReportUtil
 * JD-Core Version:    0.7.0.1
 */