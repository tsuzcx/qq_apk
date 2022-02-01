package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$9$1"}, k=3, mv={1, 1, 16})
public final class FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  
  public FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1$1(FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1 param1, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return this.this$0.emit(null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */