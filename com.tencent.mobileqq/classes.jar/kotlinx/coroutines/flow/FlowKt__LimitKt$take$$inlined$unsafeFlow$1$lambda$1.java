package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$3"}, k=1, mv={1, 1, 16})
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1$lambda$1
  implements FlowCollector<T>
{
  public FlowKt__LimitKt$take$$inlined$unsafeFlow$1$lambda$1(FlowCollector paramFlowCollector, Ref.IntRef paramIntRef, FlowKt__LimitKt.take..inlined.unsafeFlow.1 param1) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    Ref.IntRef localIntRef = this.$consumed$inlined;
    localIntRef.element += 1;
    if (localIntRef.element < this.this$0.$count$inlined)
    {
      paramObject = this.$this_unsafeFlow$inlined.emit(paramObject, paramContinuation);
      if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramObject;
      }
      return Unit.INSTANCE;
    }
    paramObject = FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(this.$this_unsafeFlow$inlined, paramObject, paramContinuation);
    if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramObject;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__LimitKt.take..inlined.unsafeFlow.1.lambda.1
 * JD-Core Version:    0.7.0.1
 */