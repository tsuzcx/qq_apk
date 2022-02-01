package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

public class RIJSoSoUtils
{
  private static long jdField_a_of_type_Long = 300000L;
  private static SosoLbsInfo jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo;
  private static long b;
  
  public static SosoLbsInfo a()
  {
    long l = System.currentTimeMillis();
    if (l - b > jdField_a_of_type_Long)
    {
      jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_anti_cheating");
      b = l;
    }
    return jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJSoSoUtils
 * JD-Core Version:    0.7.0.1
 */