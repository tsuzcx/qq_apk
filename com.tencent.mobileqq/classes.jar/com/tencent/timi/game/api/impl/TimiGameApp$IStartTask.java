package com.tencent.timi.game.api.impl;

import com.tencent.timi.game.ui.widget.EmptyDialog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/api/impl/TimiGameApp$IStartTask;", "", "runStartTask", "", "locker", "Ljava/util/concurrent/CountDownLatch;", "dialog", "Lcom/tencent/timi/game/ui/widget/EmptyDialog;", "timeOutFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "alreadyStart", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
abstract interface TimiGameApp$IStartTask
{
  public abstract void a(@NotNull CountDownLatch paramCountDownLatch, @Nullable EmptyDialog paramEmptyDialog, @NotNull AtomicBoolean paramAtomicBoolean1, @NotNull AtomicBoolean paramAtomicBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApp.IStartTask
 * JD-Core Version:    0.7.0.1
 */