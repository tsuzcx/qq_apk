package com.tencent.timi.game.component.chat.message;

import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;", "", "nickTextColor", "", "iMsg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "shouldShowSenderNick", "", "textMessageBgColor", "textMessageTextColor", "timeBgColor", "timeTextColor", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface MessageLayout$IIMConfig
{
  public abstract int a();
  
  public abstract int a(@NotNull IMsg paramIMsg);
  
  public abstract int b(@NotNull IMsg paramIMsg);
  
  public abstract boolean b();
  
  public abstract int c(@NotNull IMsg paramIMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayout.IIMConfig
 * JD-Core Version:    0.7.0.1
 */