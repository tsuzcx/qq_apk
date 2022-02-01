package com.tencent.timi.game.gift.impl.timi;

import com.tencent.timi.game.gift.api.OnSelectGiftToUserListener;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.gift.impl.receiver.IReceiverCore;
import com.tencent.timi.game.gift.impl.receiver.ReceiverUpdateCallback;
import com.tencent.timi.game.gift.impl.widget.adapter.ReceiverAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/gift/impl/timi/TimiGiftController$receiverUpdateCallback$1", "Lcom/tencent/timi/game/gift/impl/receiver/ReceiverUpdateCallback;", "onUpdate", "", "receiverList", "", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "noAnimate", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftController$receiverUpdateCallback$1
  implements ReceiverUpdateCallback
{
  public void a(@NotNull List<ReceiverInfoModel> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "receiverList");
    Object localObject1 = TimiGiftController.b(this.a);
    if (localObject1 != null) {
      ((ReceiverAdapter)localObject1).a(paramList);
    }
    paramList = TimiGiftController.c(this.a);
    if (paramList != null)
    {
      Object localObject2 = (Iterable)TimiGiftController.d(this.a).a();
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((ReceiverInfoModel)((Iterator)localObject2).next()).a());
      }
      paramList.a((List)localObject1, TimiGiftController.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftController.receiverUpdateCallback.1
 * JD-Core Version:    0.7.0.1
 */