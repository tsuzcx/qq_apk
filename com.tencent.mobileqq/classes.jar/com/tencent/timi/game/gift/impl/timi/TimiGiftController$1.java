package com.tencent.timi.game.gift.impl.timi;

import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.gift.impl.receiver.IReceiverCore;
import com.tencent.timi.game.gift.impl.widget.adapter.ReceiverAdapter.IOnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/gift/impl/timi/TimiGiftController$1", "Lcom/tencent/timi/game/gift/impl/widget/adapter/ReceiverAdapter$IOnClickListener;", "onClick", "", "receiverInfo", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftController$1
  implements ReceiverAdapter.IOnClickListener
{
  public void a(@NotNull ReceiverInfoModel paramReceiverInfoModel)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverInfoModel, "receiverInfo");
    TimiGiftController.d(this.a).a(paramReceiverInfoModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftController.1
 * JD-Core Version:    0.7.0.1
 */