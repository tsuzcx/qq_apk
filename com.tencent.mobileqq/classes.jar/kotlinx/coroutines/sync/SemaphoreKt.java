package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CANCELLED", "Lkotlinx/coroutines/internal/Symbol;", "CANCELLED$annotations", "()V", "RESUMED", "RESUMED$annotations", "SEGMENT_SIZE", "", "SEGMENT_SIZE$annotations", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class SemaphoreKt
{
  private static final Symbol CANCELLED = new Symbol("CANCELLED");
  private static final Symbol RESUMED = new Symbol("RESUMED");
  private static final int SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
  
  @NotNull
  public static final Semaphore Semaphore(int paramInt1, int paramInt2)
  {
    return (Semaphore)new SemaphoreImpl(paramInt1, paramInt2);
  }
  
  @Nullable
  public static final <T> Object withPermit(@NotNull Semaphore paramSemaphore, @NotNull Function0<? extends T> paramFunction0, @NotNull Continuation<? super T> paramContinuation)
  {
    if ((paramContinuation instanceof SemaphoreKt.withPermit.1))
    {
      local1 = (SemaphoreKt.withPermit.1)paramContinuation;
      if ((local1.label & 0x80000000) != 0)
      {
        local1.label += -2147483648;
        break label50;
      }
    }
    SemaphoreKt.withPermit.1 local1 = new SemaphoreKt.withPermit.1(paramContinuation);
    label50:
    Object localObject1 = local1.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = local1.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramFunction0 = (Function0)local1.L$1;
        paramContinuation = (Semaphore)local1.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      local1.L$0 = paramSemaphore;
      local1.L$1 = paramFunction0;
      local1.label = 1;
      paramContinuation = paramSemaphore;
      if (paramSemaphore.acquire(local1) == localObject2) {
        return localObject2;
      }
    }
    try
    {
      paramSemaphore = paramFunction0.invoke();
      return paramSemaphore;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      paramContinuation.release();
      InlineMarker.finallyEnd(1);
    }
  }
  
  @Nullable
  private static final Object withPermit$$forInline(@NotNull Semaphore paramSemaphore, @NotNull Function0 paramFunction0, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    paramSemaphore.acquire(paramContinuation);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      paramSemaphore.release();
      InlineMarker.finallyEnd(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.SemaphoreKt
 * JD-Core Version:    0.7.0.1
 */