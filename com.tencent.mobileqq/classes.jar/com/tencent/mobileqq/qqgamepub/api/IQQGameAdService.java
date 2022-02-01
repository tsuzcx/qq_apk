package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQGameAdService
  extends QRouteApi
{
  public abstract void doOnRunningForeground();
  
  public abstract void pullAd();
  
  public abstract void reportGdt(QQGameMsgInfo paramQQGameMsgInfo, int paramInt);
  
  public abstract void updatePullAdInfo(boolean paramBoolean, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameAdService
 * JD-Core Version:    0.7.0.1
 */