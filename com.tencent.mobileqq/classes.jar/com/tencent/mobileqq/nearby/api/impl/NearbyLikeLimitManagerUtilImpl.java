package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.nearby.api.NearbyLikeLimitManagerUtil;

public class NearbyLikeLimitManagerUtilImpl
  implements INearbyLikeLimitManagerUtil
{
  public boolean isNeedNewLimitCheck(long paramLong)
  {
    return NearbyLikeLimitManagerUtil.a(paramLong);
  }
  
  public void report(Object paramObject, String paramString1, String paramString2)
  {
    NearbyLikeLimitManagerUtil.a((QQAppInterface)paramObject, paramString1, paramString2);
  }
  
  public void report(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    NearbyLikeLimitManagerUtil.a((QQAppInterface)paramObject, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyLikeLimitManagerUtilImpl
 * JD-Core Version:    0.7.0.1
 */