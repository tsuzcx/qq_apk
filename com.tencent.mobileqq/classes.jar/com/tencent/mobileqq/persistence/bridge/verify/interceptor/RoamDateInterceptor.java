package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class RoamDateInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if ("MessageRoamDate".equals(b(paramChain))) {
      return RoamDate.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.RoamDateInterceptor
 * JD-Core Version:    0.7.0.1
 */