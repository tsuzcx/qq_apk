package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import mqq.app.api.IRuntimeService;

public class AbsEmoRuntimeServiceProxy<T extends IRuntimeService>
{
  protected BaseQQAppInterface mApp;
  protected T manager;
  
  public AbsEmoRuntimeServiceProxy(BaseQQAppInterface paramBaseQQAppInterface, Class<T> paramClass)
  {
    this.mApp = paramBaseQQAppInterface;
    if (this.mApp != null) {
      this.manager = paramBaseQQAppInterface.getRuntimeService(paramClass);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.AbsEmoRuntimeServiceProxy
 * JD-Core Version:    0.7.0.1
 */