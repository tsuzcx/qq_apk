package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.bridge.report.service.IProxyManager;
import com.tencent.mobileqq.persistence.Entity;

class ReportProxyAdapter$1
  implements IProxyManager
{
  ReportProxyAdapter$1(ReportProxyAdapter paramReportProxyAdapter) {}
  
  public void a(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2)
  {
    ReportProxyAdapter.a(this.a).addMsgQueue(paramString1, paramInt1, paramString2, paramEntity, paramInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportProxyAdapter.1
 * JD-Core Version:    0.7.0.1
 */