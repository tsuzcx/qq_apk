package com.tencent.mobileqq.triton.internal.utils;

import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
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
    if (localObject == null)
    {
      localObject = this.result;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("result");
      }
      return localObject;
    }
    throw ((Throwable)localObject);
  }
  
  /* Error */
  public final void run(@NotNull kotlin.jvm.functions.Function0<? extends T> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 66
    //   3: invokestatic 70	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokeinterface 75 1 0
    //   13: putfield 52	com/tencent/mobileqq/triton/internal/utils/AsyncResult:result	Ljava/lang/Object;
    //   16: aload_0
    //   17: getfield 43	com/tencent/mobileqq/triton/internal/utils/AsyncResult:latch	Ljava/util/concurrent/CountDownLatch;
    //   20: invokevirtual 78	java/util/concurrent/CountDownLatch:countDown	()V
    //   23: return
    //   24: astore_1
    //   25: goto +12 -> 37
    //   28: astore_1
    //   29: aload_0
    //   30: aload_1
    //   31: putfield 50	com/tencent/mobileqq/triton/internal/utils/AsyncResult:error	Ljava/lang/Throwable;
    //   34: goto -18 -> 16
    //   37: aload_0
    //   38: getfield 43	com/tencent/mobileqq/triton/internal/utils/AsyncResult:latch	Ljava/util/concurrent/CountDownLatch;
    //   41: invokevirtual 78	java/util/concurrent/CountDownLatch:countDown	()V
    //   44: goto +5 -> 49
    //   47: aload_1
    //   48: athrow
    //   49: goto -2 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	AsyncResult
    //   0	52	1	paramFunction0	kotlin.jvm.functions.Function0<? extends T>
    // Exception table:
    //   from	to	target	type
    //   6	16	24	finally
    //   29	34	24	finally
    //   6	16	28	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.AsyncResult
 * JD-Core Version:    0.7.0.1
 */