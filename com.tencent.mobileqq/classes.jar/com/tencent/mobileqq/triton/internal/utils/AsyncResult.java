package com.tencent.mobileqq.triton.internal.utils;

import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/utils/AsyncResult;", "T", "", "()V", "error", "", "latch", "Ljava/util/concurrent/CountDownLatch;", "result", "Ljava/lang/Object;", "awaitResult", "()Ljava/lang/Object;", "run", "", "producer", "Lkotlin/Function0;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class AsyncResult<T>
{
  private Throwable error;
  private final CountDownLatch latch = new CountDownLatch(1);
  private T result;
  
  @NotNull
  public final T awaitResult()
  {
    this.latch.await();
    Object localObject = this.error;
    if (localObject != null) {
      throw ((Throwable)localObject);
    }
    localObject = this.result;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("result");
    }
    return localObject;
  }
  
  public final void run(@NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "producer");
    try
    {
      this.result = paramFunction0.invoke();
      return;
    }
    catch (Throwable paramFunction0)
    {
      this.error = paramFunction0;
      return;
    }
    finally
    {
      this.latch.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.AsyncResult
 * JD-Core Version:    0.7.0.1
 */