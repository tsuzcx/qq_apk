package kotlin.coroutines.experimental;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/SafeContinuation;", "T", "Lkotlin/coroutines/experimental/Continuation;", "delegate", "(Lkotlin/coroutines/experimental/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/experimental/Continuation;Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "result", "getResult", "resume", "", "value", "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "Companion", "Fail", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
@PublishedApi
public final class SafeContinuation<T>
  implements Continuation<T>
{
  public static final SafeContinuation.Companion Companion = new SafeContinuation.Companion(null);
  private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
  private static final Object RESUMED;
  private static final Object UNDECIDED = new Object();
  private final Continuation<T> delegate;
  private volatile Object result;
  
  static
  {
    RESUMED = new Object();
  }
  
  @PublishedApi
  public SafeContinuation(@NotNull Continuation<? super T> paramContinuation)
  {
    this(paramContinuation, UNDECIDED);
  }
  
  public SafeContinuation(@NotNull Continuation<? super T> paramContinuation, @Nullable Object paramObject)
  {
    this.delegate = paramContinuation;
    this.result = paramObject;
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.delegate.getContext();
  }
  
  @PublishedApi
  @Nullable
  public final Object getResult()
  {
    Object localObject2 = this.result;
    Object localObject1 = localObject2;
    if (localObject2 == UNDECIDED) {
      if (RESULT.compareAndSet(this, UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
        localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
    }
    do
    {
      return localObject2;
      localObject1 = this.result;
      if (localObject1 == RESUMED) {
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
      localObject2 = localObject1;
    } while (!(localObject1 instanceof SafeContinuation.Fail));
    throw ((SafeContinuation.Fail)localObject1).getException();
  }
  
  public void resume(T paramT)
  {
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != UNDECIDED) {
          break;
        }
      } while (!RESULT.compareAndSet(this, UNDECIDED, paramT));
      return;
      if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        break;
      }
    } while (!RESULT.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), RESUMED));
    this.delegate.resume(paramT);
    return;
    throw ((Throwable)new IllegalStateException("Already resumed"));
  }
  
  public void resumeWithException(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != UNDECIDED) {
          break;
        }
      } while (!RESULT.compareAndSet(this, UNDECIDED, new SafeContinuation.Fail(paramThrowable)));
      return;
      if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        break;
      }
    } while (!RESULT.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), RESUMED));
    this.delegate.resumeWithException(paramThrowable);
    return;
    throw ((Throwable)new IllegalStateException("Already resumed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.experimental.SafeContinuation
 * JD-Core Version:    0.7.0.1
 */