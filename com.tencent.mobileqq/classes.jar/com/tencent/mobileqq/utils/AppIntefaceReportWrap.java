package com.tencent.mobileqq.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.ilive.IliveAppInterface;

@Deprecated
public class AppIntefaceReportWrap
{
  @Deprecated
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ReportController.b(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    }
    do
    {
      return;
      if (((paramAppInterface instanceof IliveAppInterface)) || ((paramAppInterface instanceof OlympicToolAppInterface)))
      {
        ReportController.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
        return;
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    ((NearbyAppInterface)paramAppInterface).b(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AppIntefaceReportWrap
 * JD-Core Version:    0.7.0.1
 */