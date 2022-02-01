package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.bridge.report.service.IProxyManager;

public class ReportProxyAdapter
  extends BaseProxy
{
  private IProxyManager a = new ReportProxyAdapter.1(this);
  
  public ReportProxyAdapter(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  public void destroy()
  {
    if ((this.app instanceof QQAppInterface))
    {
      ReportController localReportController = ((QQAppInterface)this.app).getReportController();
      if ((localReportController instanceof ReportControllerImpl)) {
        ((ReportControllerImpl)localReportController).b(this.app, this.a);
      }
    }
  }
  
  public void init()
  {
    if ((this.app instanceof QQAppInterface))
    {
      ReportController localReportController = ((QQAppInterface)this.app).getReportController();
      if ((localReportController instanceof ReportControllerImpl)) {
        ((ReportControllerImpl)localReportController).a(this.app, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportProxyAdapter
 * JD-Core Version:    0.7.0.1
 */