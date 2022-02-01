package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;

@QAPI(process={"all"})
public abstract interface IRIJAdReqFreshService
  extends IAdFreshService, QRouteApi
{
  public abstract void addAdId(String paramString, Long paramLong);
  
  public abstract void addAdIds(String paramString, Set<Long> paramSet);
  
  public abstract int getExposeRate();
  
  public abstract Set<Long> getRequestAdIds();
  
  public abstract String getRequestAdIdsStr();
  
  public abstract void removeAdFromAllScene(Long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdReqFreshService
 * JD-Core Version:    0.7.0.1
 */