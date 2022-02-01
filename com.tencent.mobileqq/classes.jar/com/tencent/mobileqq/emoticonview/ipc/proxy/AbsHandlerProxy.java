package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;

public class AbsHandlerProxy<T>
{
  protected T businessHandler;
  protected BaseQQAppInterface mApp;
  
  public AbsHandlerProxy(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    this.mApp = paramBaseQQAppInterface;
    if (this.mApp != null) {
      this.businessHandler = paramBaseQQAppInterface.getBusinessHandler(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.AbsHandlerProxy
 * JD-Core Version:    0.7.0.1
 */