package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IUtil
  extends QRouteApi
{
  public abstract boolean checkLikeRankListRedPointConfig(Object paramObject);
  
  public abstract boolean checkMedalRedPointConfig(Object paramObject);
  
  public abstract void onLikeRankListConfigChanged(Object paramObject, boolean paramBoolean);
  
  public abstract void onMedalConfigChanged(Object paramObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.IUtil
 * JD-Core Version:    0.7.0.1
 */