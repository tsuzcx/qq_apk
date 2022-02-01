package com.tencent.timi.game.component.chat.message;

import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/IMessageView;", "", "refresh", "", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "preMsg", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IMessageView
{
  public abstract void a(@Nullable CommonOuterClass.QQUserId paramQQUserId, @NotNull IMsg paramIMsg1, @Nullable IMsg paramIMsg2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.IMessageView
 * JD-Core Version:    0.7.0.1
 */