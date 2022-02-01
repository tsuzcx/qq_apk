package com.tencent.timi.game.component.chat.message;

import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/MessageLayout$OnScrollMsgListener;", "", "onScrollMsg", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "position", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface MessageLayout$OnScrollMsgListener
{
  public abstract void a(@NotNull IMsg paramIMsg, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayout.OnScrollMsgListener
 * JD-Core Version:    0.7.0.1
 */