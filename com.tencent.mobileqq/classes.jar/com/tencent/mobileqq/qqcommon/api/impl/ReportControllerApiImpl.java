package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.qqcommon.api.IReportControllerApi;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReportControllerApiImpl
  implements IReportControllerApi
{
  private AppRuntime getRunTime()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(getRunTime(), paramString1, paramString2, paramInt);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.b(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.b(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, int paramInt)
  {
    ReportController.a(getRunTime(), paramString1, paramString2, paramInt);
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.a(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.a(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportDeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    ReportController.b(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public void reportDeviceInfoRuntime(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    ReportController.a(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5);
  }
  
  public void reportDeviceInfoRuntime(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    ReportController.a(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public void reportDeviceInfoWithPerformance(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    ReportController.a(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
  }
  
  public void reportDeviceInfoWithPerformanceRuntime(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    ReportController.b(getRunTime(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5);
  }
  
  public void reportPushNotification(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    ReportController.a(getRunTime(), paramBoolean, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public void reportWith898(String paramString)
  {
    ReportController.a(getRunTime(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.ReportControllerApiImpl
 * JD-Core Version:    0.7.0.1
 */