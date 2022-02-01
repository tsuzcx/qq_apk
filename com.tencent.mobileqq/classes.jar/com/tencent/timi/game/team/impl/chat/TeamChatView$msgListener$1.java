package com.tencent.timi.game.team.impl.chat;

import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.impl.message.MessageOuterClassExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamChatView$msgListener$1", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "onDeleted", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onHistoryMsgs", "historyMessages", "", "onMsgRevoked", "msgId", "", "onNewMsg", "onResend", "onSend", "onSendFailed", "code", "", "desc", "onSendSuc", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamChatView$msgListener$1
  implements IMsgListener
{
  public void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (!TeamChatView.f(this.a).contains(paramIMsg.a())) {
      TeamChatView.f(this.a).add(paramIMsg.a());
    }
    TeamChatView.a(this.a).a(paramIMsg);
  }
  
  public void a(@NotNull IMsg paramIMsg, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    TeamChatView.a(this.a).b(paramIMsg.a());
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msgId");
    TeamChatView.a(this.a).a(paramString);
  }
  
  public void a(@NotNull List<? extends IMsg> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "historyMessages");
    if ((!this.a.getRetryGetHistory()) && (paramList.isEmpty()))
    {
      this.a.setRetryGetHistory(true);
      TeamChatView.b(this.a).sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    if ((((Collection)paramList).isEmpty() ^ true)) {
      TeamChatView.a(this.a, (IMsg)paramList.get(0));
    }
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      IMsg localIMsg = (IMsg)paramList.next();
      if ((TeamChatView.a(this.a, localIMsg, false)) && (!TeamChatView.b(this.a, localIMsg, false)))
      {
        if ((localIMsg.c() == MessageOuterClassExKt.b()) && ((TeamChatView.h(this.a) == 1) || (TeamChatView.h(this.a) == 2)) && (localIMsg.m() == 0)) {
          localIMsg.a(-1);
        }
        localList.add(localIMsg);
      }
    }
    paramList = TeamChatView.a(this.a);
    if (paramList != null) {
      paramList.a(localList);
    }
  }
  
  public void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    TeamChatView.a(this.a).b(paramIMsg.a());
  }
  
  public void c(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    TeamChatView.a(this.a).b(paramIMsg.a());
    IReportService localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
    ConcurrentHashMap localConcurrentHashMap = YoloRoomUtil.c(TeamChatView.g(this.a));
    localConcurrentHashMap.put("yes_msg_type", String.valueOf(paramIMsg.c()));
    Intrinsics.checkExpressionValueIsNotNull(localConcurrentHashMap, "YoloRoomUtil.getCommonRo…g.type()}\")\n            }");
    localIReportService.a("ev_yes_msg_send", (Map)localConcurrentHashMap);
  }
  
  public void d(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    TeamChatView.a(this.a).c(paramIMsg.a());
  }
  
  public void e(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if ((TeamChatView.a(this.a, paramIMsg, true)) && (!TeamChatView.b(this.a, paramIMsg, true)))
    {
      MessageLayoutImpl localMessageLayoutImpl = TeamChatView.a(this.a);
      if (localMessageLayoutImpl != null) {
        localMessageLayoutImpl.b(paramIMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamChatView.msgListener.1
 * JD-Core Version:    0.7.0.1
 */