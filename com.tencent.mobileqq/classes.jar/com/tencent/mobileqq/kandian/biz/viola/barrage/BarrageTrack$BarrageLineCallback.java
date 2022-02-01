package com.tencent.mobileqq.kandian.biz.viola.barrage;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLineCallback;", "", "onBarragePlaceInLine", "", "barrageInfo", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageInfo;", "barrageLines", "", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLine;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface BarrageTrack$BarrageLineCallback
{
  public abstract void a(@NotNull BarrageInfo paramBarrageInfo, @NotNull List<BarrageTrack.BarrageLine> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageTrack.BarrageLineCallback
 * JD-Core Version:    0.7.0.1
 */