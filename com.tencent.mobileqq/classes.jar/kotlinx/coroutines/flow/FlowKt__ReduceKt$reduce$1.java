package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"reduce", "", "S", "T", "Lkotlinx/coroutines/flow/Flow;", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/Continuation;", "continuation"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ReduceKt", f="Reduce.kt", i={0, 0, 0, 0}, l={124}, m="reduce", n={"$this$reduce", "operation", "accumulator", "$this$collect$iv"}, s={"L$0", "L$1", "L$2", "L$3"})
final class FlowKt__ReduceKt$reduce$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  
  FlowKt__ReduceKt$reduce$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return FlowKt.reduce(null, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ReduceKt.reduce.1
 * JD-Core Version:    0.7.0.1
 */