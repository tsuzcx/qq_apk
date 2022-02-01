package com.tencent.mobileqq.kandian.biz.reward.api.impl;

import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskArticleTimer;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskArticleTimer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/api/impl/RIJRewardTaskArticleTimerImpl;", "Lcom/tencent/mobileqq/kandian/biz/reward/api/IRIJRewardTaskArticleTimer;", "()V", "enabled", "", "resetStationaryTime", "", "startTiming", "rowKey", "", "maxTaskTimeInMs", "", "stopTiming", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskArticleTimerImpl
  implements IRIJRewardTaskArticleTimer
{
  public boolean enabled()
  {
    return this.$$delegate_0.enabled();
  }
  
  public void resetStationaryTime()
  {
    this.$$delegate_0.resetStationaryTime();
  }
  
  public void startTiming(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    this.$$delegate_0.startTiming(paramString, paramInt);
  }
  
  public void stopTiming()
  {
    this.$$delegate_0.stopTiming();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.api.impl.RIJRewardTaskArticleTimerImpl
 * JD-Core Version:    0.7.0.1
 */