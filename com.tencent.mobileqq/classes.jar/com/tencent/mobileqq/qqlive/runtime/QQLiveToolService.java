package com.tencent.mobileqq.qqlive.runtime;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import mqq.app.MSFServlet;

public class QQLiveToolService
  extends MobileQQServiceBase
{
  private AppInterface a;
  
  public QQLiveToolService(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return QQLiveSdkServlet.class;
  }
  
  public boolean isPBPushCmd(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.runtime.QQLiveToolService
 * JD-Core Version:    0.7.0.1
 */