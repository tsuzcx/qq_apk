package com.tencent.timi.game.component.chat.at;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/at/AtMsgManager$AtMsgListener;", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "myUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "atMsgNeedRemindList", "", "", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;Ljava/util/List;)V", "getAtMsgNeedRemindList", "()Ljava/util/List;", "getMyUserId", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "onDeleted", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onHistoryMsgs", "historyMessages", "", "onMsgRevoked", "msgId", "onNewMsg", "onResend", "onSend", "onSendFailed", "code", "", "desc", "onSendSuc", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
final class AtMsgManager$AtMsgListener
  implements IMsgListener
{
  @NotNull
  private final CommonOuterClass.QQUserId a;
  @NotNull
  private final List<String> b;
  
  public AtMsgManager$AtMsgListener(@NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull List<String> paramList)
  {
    this.a = paramQQUserId;
    this.b = paramList;
  }
  
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
    if ((paramIMsg.g().at_user_msg.user_list.size() > 0) && (paramIMsg.d().uid.get() != this.a.uid.get()) && (SpecialMsgUtil.a.a(paramIMsg, this.a)) && (!this.b.contains(paramIMsg.a()))) {
      this.b.add(paramIMsg.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.at.AtMsgManager.AtMsgListener
 * JD-Core Version:    0.7.0.1
 */