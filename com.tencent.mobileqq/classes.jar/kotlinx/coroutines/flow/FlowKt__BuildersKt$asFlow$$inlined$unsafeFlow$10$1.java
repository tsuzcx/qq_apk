package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"collect", "", "T", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10", f="Builders.kt", i={0, 0, 0, 0, 0, 0, 0}, l={115}, m="collect", n={"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s={"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "J$0"})
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1
  extends ContinuationImpl
{
  long J$0;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  int label;
  
  public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1(FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.10 param10, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return this.this$0.collect(null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.10.1
 * JD-Core Version:    0.7.0.1
 */