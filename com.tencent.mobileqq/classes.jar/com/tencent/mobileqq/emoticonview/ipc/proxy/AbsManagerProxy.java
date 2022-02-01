package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import mqq.manager.Manager;

public class AbsManagerProxy<T extends Manager>
{
  protected BaseQQAppInterface mApp;
  protected T manager;
  
  public AbsManagerProxy(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    this.mApp = paramBaseQQAppInterface;
    if (this.mApp != null) {
      this.manager = paramBaseQQAppInterface.getManager(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.AbsManagerProxy
 * JD-Core Version:    0.7.0.1
 */