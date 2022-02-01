package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"collect", "", "T", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.SafeFlow", f="Builders.kt", i={0, 0, 0}, l={56}, m="collect", n={"this", "collector", "safeCollector"}, s={"L$0", "L$1", "L$2"})
final class SafeFlow$collect$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  
  SafeFlow$collect$1(SafeFlow paramSafeFlow, Continuation paramContinuation)
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
 * Qualified Name:     kotlinx.coroutines.flow.SafeFlow.collect.1
 * JD-Core Version:    0.7.0.1
 */