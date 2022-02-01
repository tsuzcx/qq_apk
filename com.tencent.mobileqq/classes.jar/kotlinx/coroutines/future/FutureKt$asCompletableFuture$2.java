package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke"}, k=3, mv={1, 1, 13})
final class FutureKt$asCompletableFuture$2
  extends Lambda
  implements Function1<Throwable, Unit>
{
  FutureKt$asCompletableFuture$2(Deferred paramDeferred, CompletableFuture paramCompletableFuture)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Throwable paramThrowable)
  {
    try
    {
      this.$future.complete(this.$this_asCompletableFuture.getCompleted());
      return;
    }
    catch (Throwable paramThrowable)
    {
      this.$future.completeExceptionally(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.future.FutureKt.asCompletableFuture.2
 * JD-Core Version:    0.7.0.1
 */