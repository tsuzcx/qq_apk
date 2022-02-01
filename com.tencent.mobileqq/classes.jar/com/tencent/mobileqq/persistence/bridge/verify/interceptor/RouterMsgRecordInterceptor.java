package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class RouterMsgRecordInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (a(paramChain).startsWith(RouterMsgRecord.tableBasicName())) {
      return RouterMsgRecord.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.RouterMsgRecordInterceptor
 * JD-Core Version:    0.7.0.1
 */