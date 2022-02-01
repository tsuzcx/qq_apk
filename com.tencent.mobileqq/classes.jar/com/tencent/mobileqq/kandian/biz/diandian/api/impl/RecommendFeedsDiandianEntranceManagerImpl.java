package com.tencent.mobileqq.kandian.biz.diandian.api.impl;

import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.diandian.api.IRecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.reddot.OnEntryIconRefreshListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/diandian/api/impl/RecommendFeedsDiandianEntranceManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/diandian/api/IRecommendFeedsDiandianEntranceManager;", "()V", "addEntryRefreshListener", "", "listener", "Lcom/tencent/mobileqq/kandian/biz/reddot/OnEntryIconRefreshListener;", "checkAndReqRefreshDianDianIcon", "clearRedIconInfo", "getEntryFeedsType", "", "getReportR5Str", "", "triggerSrc", "channelID", "isVideoFeedsType", "", "onAccountChange", "removeEntryRefreshListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RecommendFeedsDiandianEntranceManagerImpl
  implements IRecommendFeedsDiandianEntranceManager
{
  public RecommendFeedsDiandianEntranceManagerImpl()
  {
    RecommendFeedsDiandianEntranceManager localRecommendFeedsDiandianEntranceManager = RecommendFeedsDiandianEntranceManager.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localRecommendFeedsDiandianEntranceManager, "RecommendFeedsDiandianEn…anceManager.getInstance()");
    this.$$delegate_0 = localRecommendFeedsDiandianEntranceManager;
  }
  
  public void addEntryRefreshListener(@Nullable OnEntryIconRefreshListener paramOnEntryIconRefreshListener)
  {
    this.$$delegate_0.addEntryRefreshListener(paramOnEntryIconRefreshListener);
  }
  
  public void checkAndReqRefreshDianDianIcon()
  {
    this.$$delegate_0.checkAndReqRefreshDianDianIcon();
  }
  
  public void clearRedIconInfo()
  {
    this.$$delegate_0.clearRedIconInfo();
  }
  
  public int getEntryFeedsType()
  {
    return this.$$delegate_0.getEntryFeedsType();
  }
  
  @NotNull
  public String getReportR5Str(int paramInt1, int paramInt2)
  {
    String str = this.$$delegate_0.getReportR5Str(paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(str, "getReportR5Str(...)");
    return str;
  }
  
  public boolean isVideoFeedsType()
  {
    return this.$$delegate_0.isVideoFeedsType();
  }
  
  public void onAccountChange()
  {
    this.$$delegate_0.onAccountChange();
  }
  
  public void removeEntryRefreshListener(@Nullable OnEntryIconRefreshListener paramOnEntryIconRefreshListener)
  {
    this.$$delegate_0.removeEntryRefreshListener(paramOnEntryIconRefreshListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.api.impl.RecommendFeedsDiandianEntranceManagerImpl
 * JD-Core Version:    0.7.0.1
 */