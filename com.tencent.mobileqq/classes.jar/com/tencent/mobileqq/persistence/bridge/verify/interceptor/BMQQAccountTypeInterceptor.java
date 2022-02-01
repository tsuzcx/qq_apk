package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.qidian.data.BmqqAccountType;

public class BMQQAccountTypeInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (BmqqAccountType.class.getSimpleName().equals(b(paramChain))) {
      return BmqqAccountType.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.BMQQAccountTypeInterceptor
 * JD-Core Version:    0.7.0.1
 */