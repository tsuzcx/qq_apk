package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CompletedExceptionallyKt
{
  @NotNull
  public static final <T> Object recoverResult(@Nullable Object paramObject, @NotNull Continuation<? super T> paramContinuation)
  {
    if ((paramObject instanceof CompletedExceptionally))
    {
      Object localObject = Result.Companion;
      localObject = ((CompletedExceptionally)paramObject).cause;
      paramObject = localObject;
      if (DebugKt.getRECOVER_STACK_TRACES()) {
        if (!(paramContinuation instanceof CoroutineStackFrame)) {
          paramObject = localObject;
        } else {
          paramObject = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)localObject, (CoroutineStackFrame)paramContinuation);
        }
      }
      return Result.constructor-impl(ResultKt.createFailure(paramObject));
    }
    paramContinuation = Result.Companion;
    return Result.constructor-impl(paramObject);
  }
  
  @Nullable
  public static final <T> Object toState(@NotNull Object paramObject)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramObject;
    }
    return new CompletedExceptionally(localThrowable, false, 2, null);
  }
  
  @Nullable
  public static final <T> Object toState(@NotNull Object paramObject, @NotNull CancellableContinuation<?> paramCancellableContinuation)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramObject;
    }
    paramCancellableContinuation = (Continuation)paramCancellableContinuation;
    paramObject = localThrowable;
    if (DebugKt.getRECOVER_STACK_TRACES()) {
      if (!(paramCancellableContinuation instanceof CoroutineStackFrame)) {
        paramObject = localThrowable;
      } else {
        paramObject = StackTraceRecoveryKt.access$recoverFromStackFrame(localThrowable, (CoroutineStackFrame)paramCancellableContinuation);
      }
    }
    return new CompletedExceptionally(paramObject, false, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CompletedExceptionallyKt
 * JD-Core Version:    0.7.0.1
 */