package com.tencent.timi.game.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.EmptyDialog;
import com.tencent.timi.game.utils.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/api/impl/TimiGameApp$openExpandHall$task$1", "Lcom/tencent/timi/game/api/impl/TimiGameApp$IStartTask;", "runStartTask", "", "locker", "Ljava/util/concurrent/CountDownLatch;", "dialog", "Lcom/tencent/timi/game/ui/widget/EmptyDialog;", "timeOutFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "alreadyStart", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameApp$openExpandHall$task$1
  implements TimiGameApp.IStartTask
{
  TimiGameApp$openExpandHall$task$1(Context paramContext, ExpandHallLaunchParam paramExpandHallLaunchParam, long paramLong) {}
  
  public void a(@NotNull CountDownLatch paramCountDownLatch, @Nullable EmptyDialog paramEmptyDialog, @NotNull AtomicBoolean paramAtomicBoolean1, @NotNull AtomicBoolean paramAtomicBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramCountDownLatch, "locker");
    Intrinsics.checkParameterIsNotNull(paramAtomicBoolean1, "timeOutFlag");
    Intrinsics.checkParameterIsNotNull(paramAtomicBoolean2, "alreadyStart");
    if (!paramAtomicBoolean1.get()) {
      ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a(this.a, this.b);
    }
    paramAtomicBoolean2.set(true);
    paramAtomicBoolean1 = new StringBuilder();
    paramAtomicBoolean1.append("openExpandHall ");
    paramAtomicBoolean1.append(System.currentTimeMillis() - this.c);
    paramAtomicBoolean1.append("ms");
    Logger.a("TimiGameApp_", paramAtomicBoolean1.toString());
    paramCountDownLatch.countDown();
    if (paramEmptyDialog != null) {
      TimiGameApp.a(TimiGameApp.a, (DialogInterface)paramEmptyDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApp.openExpandHall.task.1
 * JD-Core Version:    0.7.0.1
 */