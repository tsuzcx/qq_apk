package com.tencent.timi.game.expand.hall.impl;

import com.tencent.timi.game.component.chat.ChatView.IMsgSendStatusListener;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$joinRoomSucceed$4", "Lcom/tencent/timi/game/component/chat/ChatView$IMsgSendStatusListener;", "onSendFiled", "", "errorCode", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onSendSuc", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$joinRoomSucceed$4
  implements ChatView.IMsgSendStatusListener
{
  public void a(int paramInt, @NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (paramInt == 10007)
    {
      paramIMsg = new StringBuilder();
      paramIMsg.append("onSendMsgFiled error code ");
      paramIMsg.append(paramInt);
      paramIMsg.append("  kickoff");
      Logger.a("ExpandHallFragment_", paramIMsg.toString());
      this.a.a(3);
    }
  }
  
  public void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.joinRoomSucceed.4
 * JD-Core Version:    0.7.0.1
 */