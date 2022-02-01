package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;

public class TracePointsDataInterceptor
  extends FindTableClassInterceptor
{
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    Class localClass = ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).getTracePointDataClass();
    if (localClass.getSimpleName().equals(a(paramChain))) {
      return localClass;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.TracePointsDataInterceptor
 * JD-Core Version:    0.7.0.1
 */