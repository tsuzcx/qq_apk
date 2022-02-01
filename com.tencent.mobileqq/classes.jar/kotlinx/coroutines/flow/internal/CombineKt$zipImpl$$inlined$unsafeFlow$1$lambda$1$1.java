package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T1", "T2", "R", "it", "", "invoke", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$1"}, k=3, mv={1, 1, 16})
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1
  extends Lambda
  implements Function1<Throwable, Unit>
{
  CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1(CombineKt.zipImpl..inlined.unsafeFlow.1.lambda.1 param1, ReceiveChannel paramReceiveChannel)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Throwable paramThrowable)
  {
    if (!this.$first.isClosedForReceive()) {
      this.$first.cancel((CancellationException)new AbortFlowException(this.this$0.$this_unsafeFlow));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.zipImpl..inlined.unsafeFlow.1.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */