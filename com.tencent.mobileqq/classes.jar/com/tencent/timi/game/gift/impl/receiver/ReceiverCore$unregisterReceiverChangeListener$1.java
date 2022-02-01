package com.tencent.timi.game.gift.impl.receiver;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.util.WeakReference;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/gift/impl/receiver/ReceiverUpdateCallback;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class ReceiverCore$unregisterReceiverChangeListener$1
  extends Lambda
  implements Function1<WeakReference<ReceiverUpdateCallback>, Boolean>
{
  ReceiverCore$unregisterReceiverChangeListener$1(ReceiverUpdateCallback paramReceiverUpdateCallback)
  {
    super(1);
  }
  
  public final boolean invoke(WeakReference<ReceiverUpdateCallback> paramWeakReference)
  {
    return Intrinsics.areEqual((ReceiverUpdateCallback)paramWeakReference.get(), this.$cb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.receiver.ReceiverCore.unregisterReceiverChangeListener.1
 * JD-Core Version:    0.7.0.1
 */