package com.tencent.timi.game.team.impl.floating;

import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/floating/TeamFloatingBackgroundView$msgListener$1", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "onDeleted", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onHistoryMsgs", "historyMessages", "", "onMsgRevoked", "msgId", "", "onNewMsg", "onResend", "onSend", "onSendFailed", "code", "", "desc", "onSendSuc", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamFloatingBackgroundView$msgListener$1
  implements IMsgListener
{
  public void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void a(@NotNull IMsg paramIMsg, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msgId");
  }
  
  public void a(@NotNull List<? extends IMsg> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "historyMessages");
  }
  
  public void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void c(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void d(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
  }
  
  public void e(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if ((!TeamFloatingBackgroundView.a.a()) && (TeamFloatingBackgroundView.a(this.a, paramIMsg))) {
      TeamFloatingBackgroundView.a(this.a, "@我");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingBackgroundView.msgListener.1
 * JD-Core Version:    0.7.0.1
 */