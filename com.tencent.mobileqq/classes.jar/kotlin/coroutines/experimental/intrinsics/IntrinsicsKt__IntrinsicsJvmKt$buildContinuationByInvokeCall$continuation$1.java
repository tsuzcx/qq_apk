package kotlin.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/coroutines/experimental/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$buildContinuationByInvokeCall$continuation$1", "Lkotlin/coroutines/experimental/Continuation;", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "resume", "value", "(Lkotlin/Unit;)V", "resumeWithException", "exception", "", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
public final class IntrinsicsKt__IntrinsicsJvmKt$buildContinuationByInvokeCall$continuation$1
  implements Continuation<Unit>
{
  public IntrinsicsKt__IntrinsicsJvmKt$buildContinuationByInvokeCall$continuation$1(Continuation paramContinuation, Function0 paramFunction0) {}
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.$completion.getContext();
  }
  
  public void resume(@NotNull Unit paramUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramUnit, "value");
    paramUnit = this.$completion;
    try
    {
      Object localObject = this.$block.invoke();
      if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED())
      {
        if (paramUnit != null)
        {
          paramUnit.resume(localObject);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
      }
    }
    catch (Throwable localThrowable)
    {
      paramUnit.resumeWithException(localThrowable);
    }
  }
  
  public void resumeWithException(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    this.$completion.resumeWithException(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.buildContinuationByInvokeCall.continuation.1
 * JD-Core Version:    0.7.0.1
 */