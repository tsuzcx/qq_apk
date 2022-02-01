package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"emitAllImpl", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "consume", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ChannelsKt", f="Channels.kt", i={0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l={48, 59}, m="emitAllImpl$FlowKt__ChannelsKt", n={"$this$emitAllImpl", "channel", "consume", "cause", "$this$run", "$this$emitAllImpl", "channel", "consume", "cause", "result"}, s={"L$0", "L$1", "Z$0", "L$2", "L$3", "L$0", "L$1", "Z$0", "L$2", "L$3"})
final class FlowKt__ChannelsKt$emitAllImpl$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  boolean Z$0;
  int label;
  
  FlowKt__ChannelsKt$emitAllImpl$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl.1
 * JD-Core Version:    0.7.0.1
 */