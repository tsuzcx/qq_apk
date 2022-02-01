package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class AbsManagerProxy<T extends Manager>
{
  protected QQAppInterface mApp;
  protected T manager;
  
  public AbsManagerProxy(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    if (this.mApp != null) {
      this.manager = paramQQAppInterface.getManager(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.AbsManagerProxy
 * JD-Core Version:    0.7.0.1
 */