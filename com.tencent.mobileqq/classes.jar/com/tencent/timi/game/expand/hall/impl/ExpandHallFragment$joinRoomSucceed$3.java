package com.tencent.timi.game.expand.hall.impl;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.component.chat.message.IMessageListener;
import com.tencent.timi.game.expand.hall.impl.util.ExpandProfileUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$joinRoomSucceed$3", "Lcom/tencent/timi/game/component/chat/message/IMessageListener;", "onAvatarClick", "", "uid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$joinRoomSucceed$3
  implements IMessageListener
{
  public void a(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "uid");
    ExpandProfileUtil localExpandProfileUtil = ExpandProfileUtil.a;
    QBaseActivity localQBaseActivity = this.a.getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
    localExpandProfileUtil.a(localQBaseActivity, paramQQUserId, ExpandHallFragment.g(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.joinRoomSucceed.3
 * JD-Core Version:    0.7.0.1
 */