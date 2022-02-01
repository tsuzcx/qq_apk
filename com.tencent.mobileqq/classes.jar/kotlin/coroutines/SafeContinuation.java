package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result.Failure;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@PublishedApi
@SinceKotlin(version="1.3")
public final class SafeContinuation<T>
  implements Continuation<T>, CoroutineStackFrame
{
  @Deprecated
  public static final SafeContinuation.Companion Companion = new SafeContinuation.Companion(null);
  private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
  private final Continuation<T> delegate;
  private volatile Object result;
  
  @PublishedApi
  public SafeContinuation(@NotNull Continuation<? super T> paramContinuation)
  {
    this(paramContinuation, CoroutineSingletons.UNDECIDED);
  }
  
  public SafeContinuation(@NotNull Continuation<? super T> paramContinuation, @Nullable Object paramObject)
  {
    this.delegate = paramContinuation;
    this.result = paramObject;
  }
  
  @Nullable
  public CoroutineStackFrame getCallerFrame()
  {
    Continuation localContinuation2 = this.delegate;
    Continuation localContinuation1 = localContinuation2;
    if (!(localContinuation2 instanceof CoroutineStackFrame)) {
      localContinuation1 = null;
    }
    return (CoroutineStackFrame)localContinuation1;
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.delegate.getContext();
  }
  
  @PublishedApi
  @Nullable
  public final Object getOrThrow()
  {
    Object localObject2 = this.result;
    Object localObject1 = localObject2;
    if (localObject2 == CoroutineSingletons.UNDECIDED) {
      if (RESULT.compareAndSet(this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
        localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
    }
    do
    {
      return localObject2;
      localObject1 = this.result;
      if (localObject1 == CoroutineSingletons.RESUMED) {
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
      localObject2 = localObject1;
    } while (!(localObject1 instanceof Result.Failure));
    throw ((Result.Failure)localObject1).exception;
  }
  
  @Nullable
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != CoroutineSingletons.UNDECIDED) {
          break;
        }
      } while (!RESULT.compareAndSet(this, CoroutineSingletons.UNDECIDED, paramObject));
      return;
      if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        break;
      }
    } while (!RESULT.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED));
    this.delegate.resumeWith(paramObject);
    return;
    throw ((Throwable)new IllegalStateException("Already resumed"));
  }
  
  @NotNull
  public String toString()
  {
    return "SafeContinuation for " + this.delegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.SafeContinuation
 * JD-Core Version:    0.7.0.1
 */