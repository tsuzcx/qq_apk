package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$2$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f="Merge.kt", i={0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l={138, 138}, m="emit", n={"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s={"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
public final class FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  Object L$7;
  int label;
  
  public FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1(FlowKt__MergeKt.flatMapMerge..inlined.map.1.2 param2, Continuation paramContinuation)
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
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__MergeKt.flatMapMerge..inlined.map.1.2.1
 * JD-Core Version:    0.7.0.1
 */