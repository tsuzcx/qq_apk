package com.tencent.mobileqq.qwallet.report;

import com.tencent.mobileqq.qroute.QRoute;

public class VACDReportUtil
{
  public static long a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    return ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).startReport(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, long paramLong)
  {
    return ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).startReport(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramLong);
  }
  
  public static void a()
  {
    ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).checkReportsTimeOut();
  }
  
  public static void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).addReportItem(paramLong, paramString1, paramString2, paramString3, paramInt, paramString4);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).singleReport(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
  
  public static void endReport(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ((IVACDReportStaticApi)QRoute.api(IVACDReportStaticApi.class)).endReport(paramLong, paramString1, paramString2, paramInt, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.VACDReportUtil
 * JD-Core Version:    0.7.0.1
 */