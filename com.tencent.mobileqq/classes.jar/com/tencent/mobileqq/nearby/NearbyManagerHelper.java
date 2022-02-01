package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.nearby.api.INearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.qroute.QRoute;

public class NearbyManagerHelper
{
  public static INearbyProxy a(Object paramObject)
  {
    return ((INearbyManagerHelper)QRoute.api(INearbyManagerHelper.class)).getNearbyProxy(paramObject);
  }
  
  public static INearByGeneralManager b(Object paramObject)
  {
    return ((INearbyManagerHelper)QRoute.api(INearbyManagerHelper.class)).getNearbyGeneralManager(paramObject);
  }
  
  public static INearbyLikeLimitManager c(Object paramObject)
  {
    return ((INearbyManagerHelper)QRoute.api(INearbyManagerHelper.class)).getNearbyLikeLimitManager(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyManagerHelper
 * JD-Core Version:    0.7.0.1
 */