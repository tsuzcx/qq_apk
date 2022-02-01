package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IReportControllerApi
  extends QRouteApi
{
  public abstract void reportClickEvent(String paramString1, String paramString2, int paramInt);
  
  public abstract void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void reportClickEventRuntime(String paramString1, String paramString2, int paramInt);
  
  public abstract void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void reportDeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13);
  
  public abstract void reportDeviceInfoRuntime(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5);
  
  public abstract void reportDeviceInfoRuntime(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13);
  
  public abstract void reportDeviceInfoWithPerformance(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12);
  
  public abstract void reportDeviceInfoWithPerformanceRuntime(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5);
  
  public abstract void reportPushNotification(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13);
  
  public abstract void reportWith898(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.IReportControllerApi
 * JD-Core Version:    0.7.0.1
 */