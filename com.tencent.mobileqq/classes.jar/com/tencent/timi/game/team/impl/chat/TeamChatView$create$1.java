package com.tencent.timi.game.team.impl.chat;

import com.tencent.timi.game.component.chat.message.IMessageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamChatView$create$1", "Lcom/tencent/timi/game/component/chat/message/IMessageListener;", "onAvatarClick", "", "uid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamChatView$create$1
  implements IMessageListener
{
  public void a(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "uid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamChatView.create.1
 * JD-Core Version:    0.7.0.1
 */