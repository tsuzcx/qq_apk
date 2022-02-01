package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke", "kotlinx/coroutines/future/FutureKt$await$2$1"}, k=3, mv={1, 1, 13})
final class FutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1
  extends Lambda
  implements Function1<Throwable, Unit>
{
  FutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(ContinuationConsumer paramContinuationConsumer, CompletionStage paramCompletionStage)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Throwable paramThrowable)
  {
    CompletionStage localCompletionStage = this.$this_await$inlined;
    paramThrowable = localCompletionStage;
    if (!(localCompletionStage instanceof CompletableFuture)) {
      paramThrowable = null;
    }
    paramThrowable = (CompletableFuture)paramThrowable;
    if (paramThrowable != null) {
      paramThrowable.cancel(false);
    }
    this.$consumer.cont = ((Continuation)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.future.FutureKt.await..inlined.suspendCancellableCoroutine.lambda.1
 * JD-Core Version:    0.7.0.1
 */