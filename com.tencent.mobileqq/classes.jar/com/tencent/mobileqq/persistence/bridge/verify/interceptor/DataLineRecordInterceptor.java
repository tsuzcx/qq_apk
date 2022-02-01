package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class DataLineRecordInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (DataLineMsgRecord.tableName().equals(a(paramChain))) {
      return DataLineMsgRecord.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.DataLineRecordInterceptor
 * JD-Core Version:    0.7.0.1
 */