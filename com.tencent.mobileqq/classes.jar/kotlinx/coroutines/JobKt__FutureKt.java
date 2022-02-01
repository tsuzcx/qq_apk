package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cancelFutureOnCancellation", "", "Lkotlinx/coroutines/CancellableContinuation;", "future", "Ljava/util/concurrent/Future;", "cancelFutureOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/JobKt")
final class JobKt__FutureKt
{
  public static final void cancelFutureOnCancellation(@NotNull CancellableContinuation<?> arg0, @NotNull Future<?> arg1) {}
  
  @InternalCoroutinesApi
  @NotNull
  public static final DisposableHandle cancelFutureOnCompletion(@NotNull Job arg0, @NotNull Future<?> arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobKt__FutureKt
 * JD-Core Version:    0.7.0.1
 */