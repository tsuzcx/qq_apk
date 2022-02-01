package com.tencent.mobileqq.nearby.profilecard.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;

@QAPI(process={"all"})
public abstract interface IMiniCardManagerUtils
  extends QRouteApi
{
  public abstract boolean containsKey(String paramString);
  
  public abstract NowSummaryCard.MiniCard getMiniCard(String paramString);
  
  public abstract void putMiniCard(String paramString, NowSummaryCard.MiniCard paramMiniCard);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils
 * JD-Core Version:    0.7.0.1
 */