package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class MPFileTaskInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (MpfileTaskRecord.tableName().equals(a(paramChain))) {
      return MpfileTaskRecord.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.MPFileTaskInterceptor
 * JD-Core Version:    0.7.0.1
 */