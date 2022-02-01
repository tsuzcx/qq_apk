package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.qidian.data.QidianProfileUiInfo;

public class QiDianProfileUIInfoInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (QidianProfileUiInfo.class.getSimpleName().equals(a(paramChain))) {
      return QidianProfileUiInfo.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianProfileUIInfoInterceptor
 * JD-Core Version:    0.7.0.1
 */