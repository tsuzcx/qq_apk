package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class QCallRecentInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if ("recent_call".equals(b(paramChain))) {
      return QCallRecent.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.QCallRecentInterceptor
 * JD-Core Version:    0.7.0.1
 */