package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdReqFreshService;
import java.util.Set;

public class RIJAdReqFreshServiceImpl
  implements IRIJAdReqFreshService
{
  public void addAdId(String paramString, Long paramLong)
  {
    AdReqFreshManager.a().a(paramString, paramLong);
  }
  
  public void addAdIds(String paramString, Set<Long> paramSet)
  {
    AdReqFreshManager.a().a(paramString, paramSet);
  }
  
  public void exitScene(String paramString)
  {
    AdReqFreshManager.a().a(paramString);
  }
  
  public int getExposeRate()
  {
    return AdReqFreshManager.a().b();
  }
  
  public Set<Long> getRequestAdIds()
  {
    return AdReqFreshManager.a().c();
  }
  
  public String getRequestAdIdsStr()
  {
    return AdReqFreshManager.a().d();
  }
  
  public void removeAdFromAllScene(Long paramLong)
  {
    AdReqFreshManager.a().a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdReqFreshServiceImpl
 * JD-Core Version:    0.7.0.1
 */