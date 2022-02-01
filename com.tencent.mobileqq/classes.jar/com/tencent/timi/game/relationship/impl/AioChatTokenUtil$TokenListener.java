package com.tencent.timi.game.relationship.impl;

import com.tencent.mobileqq.app.QBaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/relationship/impl/AioChatTokenUtil$TokenListener;", "", "onError", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "onSuccess", "token", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface AioChatTokenUtil$TokenListener
{
  public abstract void a(@Nullable QBaseActivity paramQBaseActivity);
  
  public abstract void a(@Nullable QBaseActivity paramQBaseActivity, @NotNull byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.impl.AioChatTokenUtil.TokenListener
 * JD-Core Version:    0.7.0.1
 */