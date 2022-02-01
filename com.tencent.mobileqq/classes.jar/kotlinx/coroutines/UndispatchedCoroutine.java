package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "afterResume", "", "state", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class UndispatchedCoroutine<T>
  extends ScopeCoroutine<T>
{
  public UndispatchedCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Continuation<? super T> paramContinuation)
  {
    super(paramCoroutineContext, paramContinuation);
  }
  
  protected void afterResume(@Nullable Object paramObject)
  {
    Object localObject2 = CompletedExceptionallyKt.recoverResult(paramObject, this.uCont);
    paramObject = this.uCont.getContext();
    Object localObject1 = ThreadContextKt.updateThreadContext(paramObject, null);
    try
    {
      this.uCont.resumeWith(localObject2);
      localObject2 = Unit.INSTANCE;
      return;
    }
    finally
    {
      ThreadContextKt.restoreThreadContext(paramObject, localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.UndispatchedCoroutine
 * JD-Core Version:    0.7.0.1
 */