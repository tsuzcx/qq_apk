package com.tencent.mobileqq.persistence.bridge.corruption.interceptor;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import mqq.app.AppRuntime;

public abstract class CorruptionInterceptor
  implements Interceptor<Void>
{
  public AppRuntime a()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.interceptor.CorruptionInterceptor
 * JD-Core Version:    0.7.0.1
 */