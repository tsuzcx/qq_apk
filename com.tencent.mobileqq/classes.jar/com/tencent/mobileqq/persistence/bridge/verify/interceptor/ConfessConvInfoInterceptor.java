package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class ConfessConvInfoInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (ConfessConvInfo.getConversationInfoTableName().equals(a(paramChain))) {
      return ConfessConvInfo.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.ConfessConvInfoInterceptor
 * JD-Core Version:    0.7.0.1
 */