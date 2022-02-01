package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class CardProfileInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (CardProfile.tableName().equals(a(paramChain))) {
      return CardProfile.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.CardProfileInterceptor
 * JD-Core Version:    0.7.0.1
 */