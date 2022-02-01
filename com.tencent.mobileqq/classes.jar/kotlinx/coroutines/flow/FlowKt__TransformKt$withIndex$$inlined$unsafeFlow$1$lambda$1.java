package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$7"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1$lambda$1
  implements FlowCollector<T>
{
  public FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1$lambda$1(FlowCollector paramFlowCollector, Ref.IntRef paramIntRef) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    FlowCollector localFlowCollector = this.$this_unsafeFlow$inlined;
    Ref.IntRef localIntRef = this.$index$inlined;
    int i = localIntRef.element;
    localIntRef.element = (i + 1);
    if (i >= 0)
    {
      paramObject = localFlowCollector.emit(new IndexedValue(i, paramObject), paramContinuation);
      if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramObject;
      }
      return Unit.INSTANCE;
    }
    throw ((Throwable)new ArithmeticException("Index overflow has happened"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.withIndex..inlined.unsafeFlow.1.lambda.1
 * JD-Core Version:    0.7.0.1
 */