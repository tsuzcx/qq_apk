package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class TroopBarDataInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (TroopBarData.class.getSimpleName().equals(a(paramChain))) {
      return TroopBarData.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopBarDataInterceptor
 * JD-Core Version:    0.7.0.1
 */