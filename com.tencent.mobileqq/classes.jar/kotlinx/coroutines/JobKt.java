package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k=4, mv={1, 1, 16})
public final class JobKt
{
  @InternalCoroutinesApi
  @NotNull
  public static final DisposableHandle DisposableHandle(@NotNull Function0<Unit> paramFunction0)
  {
    return JobKt__JobKt.DisposableHandle(paramFunction0);
  }
  
  @NotNull
  public static final CompletableJob Job(@Nullable Job paramJob)
  {
    return JobKt__JobKt.Job(paramJob);
  }
  
  public static final void cancel(@NotNull CoroutineContext paramCoroutineContext, @Nullable CancellationException paramCancellationException)
  {
    JobKt__JobKt.cancel(paramCoroutineContext, paramCancellationException);
  }
  
  public static final void cancel(@NotNull Job paramJob, @NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    JobKt__JobKt.cancel(paramJob, paramString, paramThrowable);
  }
  
  @Nullable
  public static final Object cancelAndJoin(@NotNull Job paramJob, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return JobKt__JobKt.cancelAndJoin(paramJob, paramContinuation);
  }
  
  public static final void cancelChildren(@NotNull CoroutineContext paramCoroutineContext, @Nullable CancellationException paramCancellationException)
  {
    JobKt__JobKt.cancelChildren(paramCoroutineContext, paramCancellationException);
  }
  
  public static final void cancelChildren(@NotNull Job paramJob, @Nullable CancellationException paramCancellationException)
  {
    JobKt__JobKt.cancelChildren(paramJob, paramCancellationException);
  }
  
  public static final void cancelFutureOnCancellation(@NotNull CancellableContinuation<?> paramCancellableContinuation, @NotNull Future<?> paramFuture)
  {
    JobKt__FutureKt.cancelFutureOnCancellation(paramCancellableContinuation, paramFuture);
  }
  
  @InternalCoroutinesApi
  @NotNull
  public static final DisposableHandle cancelFutureOnCompletion(@NotNull Job paramJob, @NotNull Future<?> paramFuture)
  {
    return JobKt__FutureKt.cancelFutureOnCompletion(paramJob, paramFuture);
  }
  
  @NotNull
  public static final DisposableHandle disposeOnCompletion(@NotNull Job paramJob, @NotNull DisposableHandle paramDisposableHandle)
  {
    return JobKt__JobKt.disposeOnCompletion(paramJob, paramDisposableHandle);
  }
  
  public static final void ensureActive(@NotNull CoroutineContext paramCoroutineContext)
  {
    JobKt__JobKt.ensureActive(paramCoroutineContext);
  }
  
  public static final void ensureActive(@NotNull Job paramJob)
  {
    JobKt__JobKt.ensureActive(paramJob);
  }
  
  public static final boolean isActive(@NotNull CoroutineContext paramCoroutineContext)
  {
    return JobKt__JobKt.isActive(paramCoroutineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobKt
 * JD-Core Version:    0.7.0.1
 */