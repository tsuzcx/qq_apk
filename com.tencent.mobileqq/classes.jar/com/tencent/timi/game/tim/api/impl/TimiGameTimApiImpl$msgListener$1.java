package com.tencent.timi.game.tim.api.impl;

import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.timi.game.tim.api.impl.message.MsgInfo;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.INewMsgListener;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$msgListener$1", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "onRecvNewMessage", "", "msg", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTimApiImpl$msgListener$1
  extends V2TIMAdvancedMsgListener
{
  public void onRecvNewMessage(@NotNull V2TIMMessage paramV2TIMMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramV2TIMMessage, "msg");
    super.onRecvNewMessage(paramV2TIMMessage);
    Object localObject = paramV2TIMMessage.getGroupID();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "msg.groupID");
    if ((StringsKt.isBlank((CharSequence)localObject) ^ true))
    {
      localObject = paramV2TIMMessage.getGroupID();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "msg.groupID");
      if (UStringsKt.toULongOrNull((String)localObject) == null) {
        return;
      }
    }
    localObject = ((Iterable)TimiGameTimApiImpl.c(this.a)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((INewMsgListener)((Iterator)localObject).next()).a((IMsg)new MsgInfo(paramV2TIMMessage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.msgListener.1
 * JD-Core Version:    0.7.0.1
 */