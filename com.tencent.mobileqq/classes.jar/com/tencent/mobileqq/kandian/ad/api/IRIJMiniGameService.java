package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJMiniGameService
  extends QRouteApi
{
  public abstract void checkIsFollowed();
  
  public abstract void followMiniGameAccount(String paramString);
  
  public abstract void notifySmallGameView(String paramString);
  
  public abstract void setEnterTime(Long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJMiniGameService
 * JD-Core Version:    0.7.0.1
 */