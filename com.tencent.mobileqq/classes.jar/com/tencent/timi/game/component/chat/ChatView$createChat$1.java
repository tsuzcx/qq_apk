package com.tencent.timi.game.component.chat;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.expand.hall.impl.util.SafeNoticeMsgManager;
import com.tencent.timi.game.expand.hall.impl.util.SafeNoticeMsgManager.Companion;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/ChatView$createChat$1", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "onDeleted", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onHistoryMsgs", "historyMessages", "", "onMsgRevoked", "msgId", "", "onNewMsg", "onResend", "onSend", "onSendFailed", "code", "", "desc", "onSendSuc", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ChatView$createChat$1
  implements IMsgListener
{
  ChatView$createChat$1(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo) {}
  
  public void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    MessageLayoutImpl localMessageLayoutImpl = (MessageLayoutImpl)this.a.a(2131438151);
    if (localMessageLayoutImpl != null) {
      localMessageLayoutImpl.a(paramIMsg);
    }
    paramIMsg = SafeNoticeMsgManager.a.a();
    if (paramIMsg != null) {
      paramIMsg.a(this.a);
    }
  }
  
  public void a(@NotNull IMsg paramIMsg, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    ((MessageLayoutImpl)this.a.a(2131438151)).b(paramIMsg.a());
    paramString = this.a.getMsgSendStatusListener();
    if (paramString != null) {
      paramString.a(paramInt, paramIMsg);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msgId");
    ((MessageLayoutImpl)this.a.a(2131438151)).a(paramString);
  }
  
  public void a(@NotNull List<? extends IMsg> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "historyMessages");
    ((MessageLayoutImpl)this.a.a(2131438151)).a(paramList);
    SafeNoticeMsgManager localSafeNoticeMsgManager = SafeNoticeMsgManager.a.a();
    if (localSafeNoticeMsgManager != null) {
      localSafeNoticeMsgManager.a(paramList.size());
    }
  }
  
  public void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    MessageLayoutImpl localMessageLayoutImpl = (MessageLayoutImpl)this.a.a(2131438151);
    if (localMessageLayoutImpl != null) {
      localMessageLayoutImpl.c(paramIMsg.a());
    }
    localMessageLayoutImpl = (MessageLayoutImpl)this.a.a(2131438151);
    if (localMessageLayoutImpl != null) {
      localMessageLayoutImpl.a(paramIMsg);
    }
  }
  
  public void c(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    ((MessageLayoutImpl)this.a.a(2131438151)).b(paramIMsg.a());
    if (paramIMsg.c() == 78) {
      QQToast.makeText((Context)MobileQQ.getContext(), 5, (CharSequence)"分享车队成功", 0).show();
    }
    Object localObject = SafeNoticeMsgManager.a.a();
    if (localObject != null) {
      ((SafeNoticeMsgManager)localObject).a(this.a);
    }
    localObject = (IReportService)ServiceCenter.a(IReportService.class);
    ConcurrentHashMap localConcurrentHashMap = YoloRoomUtil.c(this.b);
    localConcurrentHashMap.put("yes_msg_type", String.valueOf(paramIMsg.c()));
    Intrinsics.checkExpressionValueIsNotNull(localConcurrentHashMap, "YoloRoomUtil.getCommonRo…}\")\n                    }");
    ((IReportService)localObject).a("ev_yes_msg_send", (Map)localConcurrentHashMap);
    localObject = this.a.getMsgSendStatusListener();
    if (localObject != null) {
      ((ChatView.IMsgSendStatusListener)localObject).a(paramIMsg);
    }
  }
  
  public void d(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    MessageLayoutImpl localMessageLayoutImpl = (MessageLayoutImpl)this.a.a(2131438151);
    if (localMessageLayoutImpl != null) {
      localMessageLayoutImpl.c(paramIMsg.a());
    }
  }
  
  public void e(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    ((MessageLayoutImpl)this.a.a(2131438151)).b(paramIMsg);
    paramIMsg = SafeNoticeMsgManager.a.a();
    if (paramIMsg != null) {
      paramIMsg.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.ChatView.createChat.1
 * JD-Core Version:    0.7.0.1
 */