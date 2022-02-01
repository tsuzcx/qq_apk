package com.tencent.mobileqq.qqgift.runtime;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;

public class QQGiftToolService
  extends MobileQQServiceBase
{
  private AppInterface a;
  
  public QQGiftToolService(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public void dispatchToHandler(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    BusinessHandler localBusinessHandler = getAppInterface().getBusinessHandler("");
    if (localBusinessHandler != null) {
      try
      {
        localBusinessHandler.onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(localBusinessHandler.getClass().getSimpleName());
          paramFromServiceMsg.append(" onReceive error");
          QLog.w("QQLiveToolService", 2, paramFromServiceMsg.toString(), paramToServiceMsg);
        }
      }
    }
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return QQGiftSdkServlet.class;
  }
  
  public boolean isPBPushCmd(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.runtime.QQGiftToolService
 * JD-Core Version:    0.7.0.1
 */