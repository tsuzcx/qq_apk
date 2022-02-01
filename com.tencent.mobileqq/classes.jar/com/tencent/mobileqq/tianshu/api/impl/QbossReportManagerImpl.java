package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.tianshu.impl.qboss.QbossReportManager;

public class QbossReportManagerImpl
  implements IQbossReportManager
{
  public void reportClick(String paramString1, String paramString2)
  {
    QbossReportManager.a().b(paramString1, paramString2);
  }
  
  public void reportClose(String paramString1, String paramString2)
  {
    QbossReportManager.a().a(paramString1, paramString2);
  }
  
  public void reportExpose(String paramString1, String paramString2)
  {
    QbossReportManager.a().c(paramString1, paramString2);
  }
  
  public void reportIntercept(String paramString1, String paramString2)
  {
    QbossReportManager.a().e(paramString1, paramString2);
  }
  
  public void reportSlide(String paramString1, String paramString2, int paramInt)
  {
    QbossReportManager.a().a(paramString1, paramString2, paramInt);
  }
  
  public void reportUrlClick(String paramString1, String paramString2)
  {
    QbossReportManager.a().d(paramString1, paramString2);
  }
  
  public void sendErrorReport(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QbossReportManager.a().a(paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void sendReport(String paramString1, String paramString2, int paramInt)
  {
    QbossReportManager.a().b(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.QbossReportManagerImpl
 * JD-Core Version:    0.7.0.1
 */