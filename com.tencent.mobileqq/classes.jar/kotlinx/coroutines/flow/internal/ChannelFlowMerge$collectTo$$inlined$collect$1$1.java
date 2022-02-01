package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1", f="Merge.kt", i={0, 0, 0, 0}, l={138}, m="emit", n={"this", "value", "continuation", "inner"}, s={"L$0", "L$1", "L$2", "L$3"})
public final class ChannelFlowMerge$collectTo$$inlined$collect$1$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  
  public ChannelFlowMerge$collectTo$$inlined$collect$1$1(ChannelFlowMerge.collectTo..inlined.collect.1 param1, Continuation paramContinuation)
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
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowMerge.collectTo..inlined.collect.1.1
 * JD-Core Version:    0.7.0.1
 */