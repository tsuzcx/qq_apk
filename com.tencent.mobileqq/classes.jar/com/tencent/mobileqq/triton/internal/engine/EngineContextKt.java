package com.tencent.mobileqq.triton.internal.engine;

import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"engineApi", "T", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "defaultValueOnEngineDestroyed", "action", "Lkotlin/Function0;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Triton_release"}, k=2, mv={1, 1, 16})
public final class EngineContextKt
{
  public static final <T> T engineApi(@NotNull EngineContext paramEngineContext, T paramT, @NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineContext, "$this$engineApi");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    Lock localLock = (Lock)paramEngineContext.getLock();
    localLock.lock();
    try
    {
      if (paramEngineContext.isAlive())
      {
        paramEngineContext = paramFunction0.invoke();
        InlineMarker.finallyStart(3);
        localLock.unlock();
        InlineMarker.finallyEnd(3);
        return paramEngineContext;
      }
      InlineMarker.finallyStart(2);
      localLock.unlock();
      InlineMarker.finallyEnd(2);
      return paramT;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      localLock.unlock();
      InlineMarker.finallyEnd(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EngineContextKt
 * JD-Core Version:    0.7.0.1
 */