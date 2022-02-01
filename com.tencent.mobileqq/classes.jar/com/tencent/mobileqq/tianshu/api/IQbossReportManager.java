package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQbossReportManager
  extends QRouteApi
{
  public abstract void reportClick(String paramString1, String paramString2);
  
  public abstract void reportClose(String paramString1, String paramString2);
  
  public abstract void reportExpose(String paramString1, String paramString2);
  
  public abstract void reportIntercept(String paramString1, String paramString2);
  
  public abstract void reportSlide(String paramString1, String paramString2, int paramInt);
  
  public abstract void reportUrlClick(String paramString1, String paramString2);
  
  public abstract void sendErrorReport(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void sendReport(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.IQbossReportManager
 * JD-Core Version:    0.7.0.1
 */