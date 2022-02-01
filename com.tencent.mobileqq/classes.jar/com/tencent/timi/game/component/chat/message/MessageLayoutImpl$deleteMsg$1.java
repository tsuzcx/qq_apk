package com.tencent.timi.game.component.chat.message;

import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "invoke"}, k=3, mv={1, 1, 16})
final class MessageLayoutImpl$deleteMsg$1
  extends Lambda
  implements Function1<IMsg, Boolean>
{
  MessageLayoutImpl$deleteMsg$1(String paramString)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "it");
    return Intrinsics.areEqual(this.$msgId, paramIMsg.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl.deleteMsg.1
 * JD-Core Version:    0.7.0.1
 */