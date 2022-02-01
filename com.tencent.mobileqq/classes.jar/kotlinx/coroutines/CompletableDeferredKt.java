package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CompletableDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;", "parent", "Lkotlinx/coroutines/Job;", "completeWith", "", "result", "Lkotlin/Result;", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CompletableDeferredKt
{
  @NotNull
  public static final <T> CompletableDeferred<T> CompletableDeferred(T paramT)
  {
    CompletableDeferredImpl localCompletableDeferredImpl = new CompletableDeferredImpl(null);
    localCompletableDeferredImpl.complete(paramT);
    return (CompletableDeferred)localCompletableDeferredImpl;
  }
  
  @NotNull
  public static final <T> CompletableDeferred<T> CompletableDeferred(@Nullable Job paramJob)
  {
    return (CompletableDeferred)new CompletableDeferredImpl(paramJob);
  }
  
  @ExperimentalCoroutinesApi
  public static final <T> boolean completeWith(@NotNull CompletableDeferred<T> paramCompletableDeferred, @NotNull Object paramObject)
  {
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null) {
      return paramCompletableDeferred.complete(paramObject);
    }
    return paramCompletableDeferred.completeExceptionally(localThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CompletableDeferredKt
 * JD-Core Version:    0.7.0.1
 */