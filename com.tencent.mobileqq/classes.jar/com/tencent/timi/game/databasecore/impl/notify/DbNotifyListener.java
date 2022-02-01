package com.tencent.timi.game.databasecore.impl.notify;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/databasecore/impl/notify/DbNotifyListener;", "T", "", "onUpdate", "", "data", "(Ljava/lang/Object;)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface DbNotifyListener<T>
{
  public abstract void a(@Nullable T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.notify.DbNotifyListener
 * JD-Core Version:    0.7.0.1
 */