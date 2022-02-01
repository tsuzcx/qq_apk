package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class ECShopDataInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if ("EcShopData".equals(b(paramChain))) {
      return EcShopData.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.ECShopDataInterceptor
 * JD-Core Version:    0.7.0.1
 */