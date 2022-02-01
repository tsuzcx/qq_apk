package com.tencent.mobileqq.nearby.profilecard.api;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.nearby.profilecard.IMiniCardManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IMiniCardManagerUtils
  extends QRouteApi
{
  public abstract boolean containsKey(String paramString);
  
  public abstract NowSummaryCard.MiniCard getMiniCard(String paramString);
  
  public abstract void handleMiniCardReq(List<RecentBaseData> paramList, IMiniCardManager paramIMiniCardManager, IMiniCardManagerUtils.onMiniCardRsp paramonMiniCardRsp);
  
  public abstract void putMiniCard(String paramString, NowSummaryCard.MiniCard paramMiniCard);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils
 * JD-Core Version:    0.7.0.1
 */