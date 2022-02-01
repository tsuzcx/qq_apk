package com.tencent.qcircle.cooperation.config;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.HashMap;
import java.util.Map;

public class QCircleRouteCacheManager
{
  private static volatile QCircleRouteCacheManager a;
  private Map<String, QRouteApi> b = new HashMap(0);
  
  public static QCircleRouteCacheManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleRouteCacheManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private <T extends QRouteApi> void a(String paramString, QRouteApi paramQRouteApi)
  {
    if (paramQRouteApi == null) {
      return;
    }
    this.b.put(paramString, paramQRouteApi);
  }
  
  public <T extends QRouteApi> T a(Class<T> paramClass)
  {
    String str = paramClass.getName();
    QRouteApi localQRouteApi2 = (QRouteApi)this.b.get(str);
    QRouteApi localQRouteApi1 = localQRouteApi2;
    if (localQRouteApi2 == null)
    {
      localQRouteApi1 = QRoute.api(paramClass);
      a(str, localQRouteApi1);
    }
    return localQRouteApi1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.QCircleRouteCacheManager
 * JD-Core Version:    0.7.0.1
 */