package com.tencent.timi.game.component.chat.message;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/IMessageListener;", "", "onAvatarClick", "", "uid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IMessageListener
{
  public abstract void a(@NotNull CommonOuterClass.QQUserId paramQQUserId);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.IMessageListener
 * JD-Core Version:    0.7.0.1
 */