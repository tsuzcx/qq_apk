package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"}, k=1, mv={1, 1, 16})
final class DispatchedCoroutine<T>
  extends ScopeCoroutine<T>
{
  private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
  private volatile int _decision = 0;
  
  public DispatchedCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Continuation<? super T> paramContinuation)
  {
    super(paramCoroutineContext, paramContinuation);
  }
  
  private final boolean tryResume()
  {
    do
    {
      int i = this._decision;
      if (i != 0)
      {
        if (i == 1) {
          return false;
        }
        throw ((Throwable)new IllegalStateException("Already resumed".toString()));
      }
    } while (!_decision$FU.compareAndSet(this, 0, 2));
    return true;
  }
  
  private final boolean trySuspend()
  {
    do
    {
      int i = this._decision;
      if (i != 0)
      {
        if (i == 2) {
          return false;
        }
        throw ((Throwable)new IllegalStateException("Already suspended".toString()));
      }
    } while (!_decision$FU.compareAndSet(this, 0, 1));
    return true;
  }
  
  protected void afterCompletion(@Nullable Object paramObject)
  {
    afterResume(paramObject);
  }
  
  protected void afterResume(@Nullable Object paramObject)
  {
    if (tryResume()) {
      return;
    }
    DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(this.uCont), CompletedExceptionallyKt.recoverResult(paramObject, this.uCont));
  }
  
  @Nullable
  public final Object getResult()
  {
    if (trySuspend()) {
      return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
    Object localObject = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
    if (!(localObject instanceof CompletedExceptionally)) {
      return localObject;
    }
    throw ((CompletedExceptionally)localObject).cause;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DispatchedCoroutine
 * JD-Core Version:    0.7.0.1
 */