package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.TickerChannelsKt", f="TickerChannels.kt", i={0, 0, 0, 1, 1, 1, 2, 2, 2}, l={106, 108, 109}, m="fixedDelayTicker", n={"delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel"}, s={"J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0"})
final class TickerChannelsKt$fixedDelayTicker$1
  extends ContinuationImpl
{
  long J$0;
  long J$1;
  Object L$0;
  int label;
  
  TickerChannelsKt$fixedDelayTicker$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return TickerChannelsKt.fixedDelayTicker(0L, 0L, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.TickerChannelsKt.fixedDelayTicker.1
 * JD-Core Version:    0.7.0.1
 */