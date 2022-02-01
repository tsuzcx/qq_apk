package com.tencent.timi.game.component.chat.at;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/at/AtMessageClickListener;", "", "onClick", "", "atUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface AtMessageClickListener
{
  public abstract void a(@Nullable CommonOuterClass.QQUserId paramQQUserId);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.at.AtMessageClickListener
 * JD-Core Version:    0.7.0.1
 */