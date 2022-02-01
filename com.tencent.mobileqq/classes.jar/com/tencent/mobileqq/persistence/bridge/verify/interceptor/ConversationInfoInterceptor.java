package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class ConversationInfoInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (ConversationInfo.getConversationInfoTableName().equals(a(paramChain))) {
      return ConversationInfo.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.ConversationInfoInterceptor
 * JD-Core Version:    0.7.0.1
 */