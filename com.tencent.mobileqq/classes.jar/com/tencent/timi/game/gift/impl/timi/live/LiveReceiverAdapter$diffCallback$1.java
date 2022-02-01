package com.tencent.timi.game.gift.impl.timi.live;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/gift/impl/timi/live/LiveReceiverAdapter$diffCallback$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/timi/game/gift/impl/timi/live/LiveReceiverInfoModel;", "areContentsTheSame", "", "p0", "p1", "areItemsTheSame", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveReceiverAdapter$diffCallback$1
  extends DiffUtil.ItemCallback<LiveReceiverInfoModel>
{
  public boolean a(@NotNull LiveReceiverInfoModel paramLiveReceiverInfoModel1, @NotNull LiveReceiverInfoModel paramLiveReceiverInfoModel2)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveReceiverInfoModel1, "p0");
    Intrinsics.checkParameterIsNotNull(paramLiveReceiverInfoModel2, "p1");
    return true;
  }
  
  public boolean b(@NotNull LiveReceiverInfoModel paramLiveReceiverInfoModel1, @NotNull LiveReceiverInfoModel paramLiveReceiverInfoModel2)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveReceiverInfoModel1, "p0");
    Intrinsics.checkParameterIsNotNull(paramLiveReceiverInfoModel2, "p1");
    return (paramLiveReceiverInfoModel1.a() == paramLiveReceiverInfoModel2.a()) && (Intrinsics.areEqual(paramLiveReceiverInfoModel1.c(), paramLiveReceiverInfoModel2.c())) && (Intrinsics.areEqual(paramLiveReceiverInfoModel1.b(), paramLiveReceiverInfoModel2.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.live.LiveReceiverAdapter.diffCallback.1
 * JD-Core Version:    0.7.0.1
 */