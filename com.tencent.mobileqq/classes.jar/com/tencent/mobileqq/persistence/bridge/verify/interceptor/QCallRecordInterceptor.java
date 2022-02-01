package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class QCallRecordInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (a(paramChain).startsWith("qc_")) {
      return QCallRecord.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.QCallRecordInterceptor
 * JD-Core Version:    0.7.0.1
 */