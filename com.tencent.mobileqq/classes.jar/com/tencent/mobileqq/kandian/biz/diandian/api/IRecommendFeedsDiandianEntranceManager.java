package com.tencent.mobileqq.kandian.biz.diandian.api;

import com.tencent.mobileqq.kandian.biz.reddot.OnEntryIconRefreshListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/diandian/api/IRecommendFeedsDiandianEntranceManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addEntryRefreshListener", "", "listener", "Lcom/tencent/mobileqq/kandian/biz/reddot/OnEntryIconRefreshListener;", "checkAndReqRefreshDianDianIcon", "clearRedIconInfo", "getEntryFeedsType", "", "getReportR5Str", "", "triggerSrc", "channelID", "isVideoFeedsType", "", "onAccountChange", "removeEntryRefreshListener", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRecommendFeedsDiandianEntranceManager
  extends QRouteApi
{
  public abstract void addEntryRefreshListener(@Nullable OnEntryIconRefreshListener paramOnEntryIconRefreshListener);
  
  public abstract void checkAndReqRefreshDianDianIcon();
  
  public abstract void clearRedIconInfo();
  
  public abstract int getEntryFeedsType();
  
  @NotNull
  public abstract String getReportR5Str(int paramInt1, int paramInt2);
  
  public abstract boolean isVideoFeedsType();
  
  public abstract void onAccountChange();
  
  public abstract void removeEntryRefreshListener(@Nullable OnEntryIconRefreshListener paramOnEntryIconRefreshListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.api.IRecommendFeedsDiandianEntranceManager
 * JD-Core Version:    0.7.0.1
 */