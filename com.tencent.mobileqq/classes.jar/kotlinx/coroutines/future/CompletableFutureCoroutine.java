package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/future/CompletableFutureCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Ljava/util/function/BiConsumer;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "completion", "Ljava/util/concurrent/CompletableFuture;", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CompletableFuture;)V", "accept", "", "value", "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "onCompleted", "(Ljava/lang/Object;)V", "onCompletedExceptionally", "kotlinx-coroutines-jdk8"}, k=1, mv={1, 1, 13})
final class CompletableFutureCoroutine<T>
  extends AbstractCoroutine<T>
  implements BiConsumer<T, Throwable>
{
  private final CompletableFuture<T> completion;
  
  public CompletableFutureCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull CompletableFuture<T> paramCompletableFuture)
  {
    super(paramCoroutineContext, false, 2, null);
    this.completion = paramCompletableFuture;
  }
  
  public void accept(@Nullable T paramT, @Nullable Throwable paramThrowable)
  {
    cancel();
  }
  
  protected void onCompleted(T paramT)
  {
    this.completion.complete(paramT);
  }
  
  protected void onCompletedExceptionally(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    if (!this.completion.completeExceptionally(paramThrowable)) {
      CoroutineExceptionHandlerKt.handleCoroutineException(this.parentContext, paramThrowable, (Job)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.future.CompletableFutureCoroutine
 * JD-Core Version:    0.7.0.1
 */