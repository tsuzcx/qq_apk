package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$3$1"}, k=3, mv={1, 1, 16})
public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3$lambda$1$1
  extends ContinuationImpl
{
  int label;
  
  public FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3$lambda$1$1(FlowKt__TransformKt.unsafeTransform..inlined.unsafeFlow.3.lambda.1 param1, Continuation paramContinuation)
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
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.unsafeTransform..inlined.unsafeFlow.3.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */