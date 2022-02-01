package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

public class RIJSoSoUtils
{
  private static long a = 300000L;
  private static long b;
  private static SosoLbsInfo c;
  
  public static SosoLbsInfo a()
  {
    long l = System.currentTimeMillis();
    if (l - b > a)
    {
      c = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_anti_cheating");
      b = l;
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJSoSoUtils
 * JD-Core Version:    0.7.0.1
 */