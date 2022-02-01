package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class RecentUserInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if ("recent".equals(a(paramChain))) {
      return RecentUser.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.RecentUserInterceptor
 * JD-Core Version:    0.7.0.1
 */