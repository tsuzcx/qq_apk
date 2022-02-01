package kotlinx.coroutines.future;

import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "exception", "", "accept", "(Ljava/lang/Object;Ljava/lang/Throwable;)V"}, k=3, mv={1, 1, 13})
final class FutureKt$asCompletableFuture$1<T, U>
  implements BiConsumer<T, Throwable>
{
  FutureKt$asCompletableFuture$1(Deferred paramDeferred) {}
  
  public final void accept(T paramT, Throwable paramThrowable)
  {
    this.$this_asCompletableFuture.cancel(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.future.FutureKt.asCompletableFuture.1
 * JD-Core Version:    0.7.0.1
 */