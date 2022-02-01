package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdHippyService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.qroute.QRoute;

public class RIJAdHippyServiceImpl
  implements IRIJAdHippyService
{
  public Object createReadinjoyAdHippyFragment(int paramInt, String paramString1, String paramString2)
  {
    return ReadinjoyAdHippyFragment.a(paramInt, paramString1, paramString2);
  }
  
  public boolean instanceOfReadinjoyAdHippyFragment(Object paramObject)
  {
    return paramObject instanceof ReadinjoyAdHippyFragment;
  }
  
  public void setHippyUrl(Object paramObject, String paramString)
  {
    try
    {
      ((ReadinjoyAdHippyFragment)paramObject).a(paramString);
      return;
    }
    catch (Throwable paramObject)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).e("RIJHippyServiceImpl", paramObject.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdHippyServiceImpl
 * JD-Core Version:    0.7.0.1
 */