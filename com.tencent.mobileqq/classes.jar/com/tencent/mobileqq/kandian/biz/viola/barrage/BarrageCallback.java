package com.tencent.mobileqq.kandian.biz.viola.barrage;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageCallback;", "", "onEventBarrageDidAppear", "", "onEventBarrageOnClick", "commentId", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface BarrageCallback
{
  public abstract void onEventBarrageDidAppear();
  
  public abstract void onEventBarrageOnClick(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageCallback
 * JD-Core Version:    0.7.0.1
 */