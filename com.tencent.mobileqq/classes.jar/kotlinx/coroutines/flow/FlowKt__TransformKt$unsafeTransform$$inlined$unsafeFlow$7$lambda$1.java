package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$8"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1
  implements FlowCollector<T>
{
  public FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1(FlowCollector paramFlowCollector, FlowKt__TransformKt.unsafeTransform..inlined.unsafeFlow.7 param7) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    return this.this$0.$transform$inlined.invoke(this.$this_unsafeFlow$inlined, paramObject, paramContinuation);
  }
  
  @Nullable
  public Object emit$$forInline(Object paramObject, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(4);
    new FlowKt__TransformKt.unsafeTransform..inlined.unsafeFlow.7.lambda.1.1(this, paramContinuation);
    InlineMarker.mark(5);
    return this.this$0.$transform$inlined.invoke(this.$this_unsafeFlow$inlined, paramObject, paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.unsafeTransform..inlined.unsafeFlow.7.lambda.1
 * JD-Core Version:    0.7.0.1
 */