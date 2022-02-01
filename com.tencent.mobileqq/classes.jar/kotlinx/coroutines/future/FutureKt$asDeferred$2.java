package kotlinx.coroutines.future;

import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlinx.coroutines.CompletableDeferred;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "value", "kotlin.jvm.PlatformType", "exception", "", "accept", "(Ljava/lang/Object;Ljava/lang/Throwable;)V"}, k=3, mv={1, 1, 13})
final class FutureKt$asDeferred$2<T, U>
  implements BiConsumer<T, Throwable>
{
  FutureKt$asDeferred$2(CompletableDeferred paramCompletableDeferred) {}
  
  public final void accept(T paramT, Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      this.$result.complete(paramT);
      return;
    }
    this.$result.cancel(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.future.FutureKt.asDeferred.2
 * JD-Core Version:    0.7.0.1
 */