package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;

public class TroopFileTransferItemInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (a(paramChain).startsWith("TroopFileTansferItemEntity")) {
      return TroopFileTansferItemEntity.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopFileTransferItemInterceptor
 * JD-Core Version:    0.7.0.1
 */