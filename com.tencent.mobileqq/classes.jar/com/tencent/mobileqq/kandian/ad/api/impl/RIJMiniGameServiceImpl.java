package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJMiniGameService;

public class RIJMiniGameServiceImpl
  implements IRIJMiniGameService
{
  public void checkIsFollowed()
  {
    AdMiniGameGuideManager.a.a();
  }
  
  public void followMiniGameAccount(String paramString)
  {
    AdMiniGameGuideManager.a.a(paramString);
  }
  
  public void notifySmallGameView(String paramString)
  {
    AdMiniGameGuideManager.a.b(paramString);
  }
  
  public void setEnterTime(Long paramLong)
  {
    AdMiniGameGuideManager.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJMiniGameServiceImpl
 * JD-Core Version:    0.7.0.1
 */