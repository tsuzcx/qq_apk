package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/BaseMsgManager$msgListener$1", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "onRecvMessageRevoked", "", "msgID", "", "onRecvNewMessage", "msg", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMsgManager$msgListener$1
  extends V2TIMAdvancedMsgListener
{
  public void onRecvMessageRevoked(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msgID");
    Iterator localIterator = ((Iterable)this.a.a()).iterator();
    while (localIterator.hasNext()) {
      ((IMsgListener)localIterator.next()).a(paramString);
    }
  }
  
  public void onRecvNewMessage(@NotNull V2TIMMessage paramV2TIMMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramV2TIMMessage, "msg");
    Object localObject1 = BaseMsgManager.a(this.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onRecvNewMessage: ");
    ((StringBuilder)localObject2).append(paramV2TIMMessage.getGroupID());
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(paramV2TIMMessage.getSender());
    Logger.b((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = ((Iterable)this.a.a()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IMsgListener)((Iterator)localObject1).next();
      MsgInfo localMsgInfo = new MsgInfo(paramV2TIMMessage);
      if (this.a.b())
      {
        if ((localMsgInfo.k()) && (localMsgInfo.h() == UStringsKt.toULong(this.a.c()))) {
          ((IMsgListener)localObject2).e((IMsg)new MsgInfo(paramV2TIMMessage));
        }
      }
      else if ((!localMsgInfo.k()) && (localMsgInfo.d().uid.get() == UStringsKt.toULong(this.a.c()))) {
        ((IMsgListener)localObject2).e((IMsg)new MsgInfo(paramV2TIMMessage));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager.msgListener.1
 * JD-Core Version:    0.7.0.1
 */