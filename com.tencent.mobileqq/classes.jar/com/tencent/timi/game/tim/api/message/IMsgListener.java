package com.tencent.timi.game.tim.api.message;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "", "onDeleted", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onHistoryMsgs", "historyMessages", "", "onMsgRevoked", "msgId", "", "onNewMsg", "onResend", "onSend", "onSendFailed", "code", "", "desc", "onSendSuc", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IMsgListener
{
  public abstract void a(@NotNull IMsg paramIMsg);
  
  public abstract void a(@NotNull IMsg paramIMsg, int paramInt, @Nullable String paramString);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(@NotNull List<? extends IMsg> paramList);
  
  public abstract void b(@NotNull IMsg paramIMsg);
  
  public abstract void c(@NotNull IMsg paramIMsg);
  
  public abstract void d(@NotNull IMsg paramIMsg);
  
  public abstract void e(@NotNull IMsg paramIMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.message.IMsgListener
 * JD-Core Version:    0.7.0.1
 */