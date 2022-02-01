package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class ProduceKt$awaitClose$4$1
  extends Lambda
  implements Function1<Throwable, Unit>
{
  ProduceKt$awaitClose$4$1(CancellableContinuation paramCancellableContinuation)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Throwable paramThrowable)
  {
    paramThrowable = (Continuation)this.$cont;
    Unit localUnit = Unit.INSTANCE;
    Result.Companion localCompanion = Result.Companion;
    paramThrowable.resumeWith(Result.constructor-impl(localUnit));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ProduceKt.awaitClose.4.1
 * JD-Core Version:    0.7.0.1
 */