package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$3", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3$lambda$1"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2
  implements FlowCollector<T>
{
  public FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2(FlowCollector paramFlowCollector, FlowKt__TransformKt.filter..inlined.unsafeTransform.2 param2) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    FlowCollector localFlowCollector = this.$this_unsafeFlow$inlined;
    if (((Boolean)this.this$0.$predicate$inlined.invoke(paramObject, paramContinuation)).booleanValue())
    {
      paramObject = localFlowCollector.emit(paramObject, paramContinuation);
      if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramObject;
      }
      return Unit.INSTANCE;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public Object emit$$forInline(Object paramObject, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(4);
    new FlowKt__TransformKt.filter..inlined.unsafeTransform.2.2.1(this, paramContinuation);
    InlineMarker.mark(5);
    FlowCollector localFlowCollector = this.$this_unsafeFlow$inlined;
    if (((Boolean)this.this$0.$predicate$inlined.invoke(paramObject, paramContinuation)).booleanValue())
    {
      InlineMarker.mark(0);
      paramObject = localFlowCollector.emit(paramObject, paramContinuation);
      InlineMarker.mark(2);
      InlineMarker.mark(1);
      return paramObject;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.filter..inlined.unsafeTransform.2.2
 * JD-Core Version:    0.7.0.1
 */