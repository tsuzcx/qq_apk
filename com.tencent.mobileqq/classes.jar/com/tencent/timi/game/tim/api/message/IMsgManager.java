package com.tencent.timi.game.tim.api.message;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "", "createChat", "", "listener", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "delete", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "destroyChat", "getHistoryMsgList", "lastMsg", "count", "", "insertGroupMsg", "", "timMsgBody", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "sender", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "markMsgAsRead", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "resend", "sendAtMessage", "userId", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "sendCustom", "type", "sendText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IMsgManager
{
  @Nullable
  public abstract IMsg a(@NotNull CommonOuterClass.QQUserId paramQQUserId, int paramInt, @NotNull MessageOuterClass.MsgContent paramMsgContent);
  
  @Nullable
  public abstract IMsg a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull String paramString);
  
  @Nullable
  public abstract IMsg a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent);
  
  public abstract void a(@Nullable IMsg paramIMsg);
  
  public abstract void a(@Nullable IMsgListener paramIMsgListener);
  
  public abstract boolean a(@NotNull MessageOuterClass.TimMsgBody paramTimMsgBody, @NotNull CommonOuterClass.QQUserId paramQQUserId);
  
  public abstract void b(@NotNull IMsg paramIMsg);
  
  public abstract void b(@Nullable IMsgListener paramIMsgListener);
  
  public abstract void c(@NotNull IMsg paramIMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.message.IMsgManager
 * JD-Core Version:    0.7.0.1
 */