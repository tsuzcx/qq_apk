package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"EMPTY_LOCKED", "Lkotlinx/coroutines/sync/Empty;", "EMPTY_LOCKED$annotations", "()V", "EMPTY_UNLOCKED", "EMPTY_UNLOCKED$annotations", "ENQUEUE_FAIL", "Lkotlinx/coroutines/internal/Symbol;", "ENQUEUE_FAIL$annotations", "LOCKED", "LOCKED$annotations", "LOCK_FAIL", "LOCK_FAIL$annotations", "SELECT_SUCCESS", "SELECT_SUCCESS$annotations", "UNLOCKED", "UNLOCKED$annotations", "UNLOCK_FAIL", "UNLOCK_FAIL$annotations", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class MutexKt
{
  private static final Empty EMPTY_LOCKED = new Empty(LOCKED);
  private static final Empty EMPTY_UNLOCKED = new Empty(UNLOCKED);
  private static final Symbol ENQUEUE_FAIL;
  private static final Symbol LOCKED;
  private static final Symbol LOCK_FAIL = new Symbol("LOCK_FAIL");
  private static final Symbol SELECT_SUCCESS;
  private static final Symbol UNLOCKED;
  private static final Symbol UNLOCK_FAIL;
  
  static
  {
    ENQUEUE_FAIL = new Symbol("ENQUEUE_FAIL");
    UNLOCK_FAIL = new Symbol("UNLOCK_FAIL");
    SELECT_SUCCESS = new Symbol("SELECT_SUCCESS");
    LOCKED = new Symbol("LOCKED");
    UNLOCKED = new Symbol("UNLOCKED");
  }
  
  @NotNull
  public static final Mutex Mutex(boolean paramBoolean)
  {
    return (Mutex)new MutexImpl(paramBoolean);
  }
  
  @Nullable
  public static final <T> Object withLock(@NotNull Mutex paramMutex, @Nullable Object paramObject, @NotNull Function0<? extends T> paramFunction0, @NotNull Continuation<? super T> paramContinuation)
  {
    if ((paramContinuation instanceof MutexKt.withLock.1))
    {
      local1 = (MutexKt.withLock.1)paramContinuation;
      if ((local1.label & 0x80000000) != 0)
      {
        local1.label += -2147483648;
        break label50;
      }
    }
    MutexKt.withLock.1 local1 = new MutexKt.withLock.1(paramContinuation);
    label50:
    Object localObject2 = local1.result;
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = local1.label;
    Object localObject1;
    if (i != 0)
    {
      if (i == 1)
      {
        paramFunction0 = (Function0)local1.L$2;
        localObject1 = local1.L$1;
        paramContinuation = (Mutex)local1.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject2);
      local1.L$0 = paramMutex;
      local1.L$1 = paramObject;
      local1.L$2 = paramFunction0;
      local1.label = 1;
      paramContinuation = paramMutex;
      localObject1 = paramObject;
      if (paramMutex.lock(paramObject, local1) == localObject3) {
        return localObject3;
      }
    }
    try
    {
      paramMutex = paramFunction0.invoke();
      return paramMutex;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      paramContinuation.unlock(localObject1);
      InlineMarker.finallyEnd(1);
    }
  }
  
  @Nullable
  private static final Object withLock$$forInline(@NotNull Mutex paramMutex, @Nullable Object paramObject, @NotNull Function0 paramFunction0, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(0);
    paramMutex.lock(paramObject, paramContinuation);
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
      paramMutex.unlock(paramObject);
      InlineMarker.finallyEnd(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.MutexKt
 * JD-Core Version:    0.7.0.1
 */