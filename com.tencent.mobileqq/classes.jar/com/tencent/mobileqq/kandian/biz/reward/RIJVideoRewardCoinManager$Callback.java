package com.tencent.mobileqq.kandian.biz.reward;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager$Callback;", "", "onRewardCoinWindowVisibilityChanged", "", "visiable", "", "sceneType", "", "onRewardDuplicate", "msg", "", "onRewardResult", "success", "itemIndex", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJVideoRewardCoinManager$Callback
{
  public abstract void a(@NotNull String paramString, int paramInt);
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public abstract void a(boolean paramBoolean, @NotNull String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Callback
 * JD-Core Version:    0.7.0.1
 */