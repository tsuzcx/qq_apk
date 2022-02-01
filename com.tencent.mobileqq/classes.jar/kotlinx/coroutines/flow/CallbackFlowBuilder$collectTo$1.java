package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"collectTo", "", "T", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.CallbackFlowBuilder", f="Builders.kt", i={0, 0}, l={340}, m="collectTo", n={"this", "scope"}, s={"L$0", "L$1"})
final class CallbackFlowBuilder$collectTo$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  int label;
  
  CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder paramCallbackFlowBuilder, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return this.this$0.collectTo(null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.CallbackFlowBuilder.collectTo.1
 * JD-Core Version:    0.7.0.1
 */