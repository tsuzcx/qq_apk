package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;

public class VideoRedBagDataInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    if (VideoRedbagData.class.getSimpleName().equals(a(paramChain))) {
      return VideoRedbagData.class;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.VideoRedBagDataInterceptor
 * JD-Core Version:    0.7.0.1
 */