package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.entitymanager.FindTableNameInterceptorChain;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public abstract class FindTableClassInterceptor
  implements Interceptor<Class>
{
  protected String a(Interceptor.Chain paramChain)
  {
    if ((paramChain instanceof FindTableNameInterceptorChain)) {
      return ((FindTableNameInterceptorChain)paramChain).tableName;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.FindTableClassInterceptor
 * JD-Core Version:    0.7.0.1
 */