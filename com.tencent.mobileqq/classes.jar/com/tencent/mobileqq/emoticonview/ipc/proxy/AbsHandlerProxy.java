package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class AbsHandlerProxy<T extends BusinessHandler>
{
  protected T businessHandler;
  protected QQAppInterface mApp;
  
  public AbsHandlerProxy(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.mApp = paramQQAppInterface;
    if (this.mApp != null) {
      this.businessHandler = paramQQAppInterface.getBusinessHandler(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.AbsHandlerProxy
 * JD-Core Version:    0.7.0.1
 */