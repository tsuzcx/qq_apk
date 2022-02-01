package com.tencent.mobileqq.kandian.biz.reward.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/api/IRIJRewardTaskTimer;", "", "enabled", "", "startTiming", "", "rowKey", "", "maxTaskTimeInMs", "", "stopTiming", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJRewardTaskTimer
{
  public abstract void startTiming(@NotNull String paramString, int paramInt);
  
  public abstract void stopTiming();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskTimer
 * JD-Core Version:    0.7.0.1
 */