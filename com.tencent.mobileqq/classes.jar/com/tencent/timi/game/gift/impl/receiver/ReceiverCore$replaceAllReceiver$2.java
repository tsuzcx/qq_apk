package com.tencent.timi.game.gift.impl.receiver;

import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "invoke"}, k=3, mv={1, 1, 16})
final class ReceiverCore$replaceAllReceiver$2
  extends Lambda
  implements Function1<ReceiverInfoModel, String>
{
  public static final 2 INSTANCE = new 2();
  
  ReceiverCore$replaceAllReceiver$2()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull ReceiverInfoModel paramReceiverInfoModel)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverInfoModel, "it");
    return String.valueOf(paramReceiverInfoModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.receiver.ReceiverCore.replaceAllReceiver.2
 * JD-Core Version:    0.7.0.1
 */