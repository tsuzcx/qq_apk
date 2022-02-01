package com.tencent.timi.game.component.chat;

import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/ChatView$IMsgSendStatusListener;", "", "onSendFiled", "", "errorCode", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onSendSuc", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ChatView$IMsgSendStatusListener
{
  public abstract void a(int paramInt, @NotNull IMsg paramIMsg);
  
  public abstract void a(@NotNull IMsg paramIMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.ChatView.IMsgSendStatusListener
 * JD-Core Version:    0.7.0.1
 */