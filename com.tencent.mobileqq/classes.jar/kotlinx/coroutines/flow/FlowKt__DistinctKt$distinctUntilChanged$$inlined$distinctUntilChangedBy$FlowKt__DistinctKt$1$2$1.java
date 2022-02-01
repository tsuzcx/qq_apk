package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__DistinctKt$$special$$inlined$collect$1$1", "kotlinx/coroutines/flow/FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$1$lambda$1$1"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2", f="Distinct.kt", i={0, 0, 0, 0, 0}, l={141}, m="emit", n={"this", "value", "continuation", "value", "key"}, s={"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  
  public FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2$1(FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2 param2, Continuation paramContinuation)
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
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2.1
 * JD-Core Version:    0.7.0.1
 */