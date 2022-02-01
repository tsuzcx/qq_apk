package com.tencent.timi.game.gift.impl.receiver;

import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.gift.impl.IGiftCore;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/receiver/IReceiverCore;", "Lcom/tencent/timi/game/gift/impl/IGiftCore;", "chooseAllReceivers", "", "chosen", "", "chooseReceiver", "chosenInfo", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "getChosenReceiverList", "", "getChosenReceiverLiveData", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "registerReceiverChangeListener", "cb", "Lcom/tencent/timi/game/gift/impl/receiver/ReceiverUpdateCallback;", "replaceAllReceiver", "list", "noAnimate", "reset", "unregisterReceiverChangeListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IReceiverCore
  extends IGiftCore
{
  @NotNull
  public abstract List<ReceiverInfoModel> a();
  
  public abstract void a(@NotNull ReceiverInfoModel paramReceiverInfoModel);
  
  public abstract void a(@NotNull ReceiverUpdateCallback paramReceiverUpdateCallback);
  
  public abstract void a(@NotNull List<ReceiverInfoModel> paramList, boolean paramBoolean);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.receiver.IReceiverCore
 * JD-Core Version:    0.7.0.1
 */