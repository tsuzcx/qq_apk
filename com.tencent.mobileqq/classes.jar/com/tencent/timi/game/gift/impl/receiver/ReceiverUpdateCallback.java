package com.tencent.timi.game.gift.impl.receiver;

import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/receiver/ReceiverUpdateCallback;", "", "onUpdate", "", "receiverList", "", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "noAnimate", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ReceiverUpdateCallback
{
  public abstract void a(@NotNull List<ReceiverInfoModel> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.receiver.ReceiverUpdateCallback
 * JD-Core Version:    0.7.0.1
 */