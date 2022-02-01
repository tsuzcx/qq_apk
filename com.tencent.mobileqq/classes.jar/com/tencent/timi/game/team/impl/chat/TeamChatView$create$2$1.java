package com.tencent.timi.game.team.impl.chat;

import com.tencent.timi.game.component.chat.message.MessageLayout.OnScrollMsgListener;
import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamChatView$create$2$1", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$OnScrollMsgListener;", "onScrollMsg", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "position", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamChatView$create$2$1
  implements MessageLayout.OnScrollMsgListener
{
  public void a(@NotNull IMsg paramIMsg, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (paramInt < 6)
    {
      TeamChatView.b(this.a.this$0).removeMessages(1);
      TeamChatView.b(this.a.this$0).sendEmptyMessageDelayed(1, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamChatView.create.2.1
 * JD-Core Version:    0.7.0.1
 */