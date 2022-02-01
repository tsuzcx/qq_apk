package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"consumeEach", "", "E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "action", "Lkotlin/Function1;", "", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f="Channels.common.kt", i={0, 0, 0, 0, 0}, l={180}, m="consumeEach", n={"$this$consumeEach", "action", "$this$consume$iv", "cause$iv", "$this$consume"}, s={"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class ChannelsKt__Channels_commonKt$consumeEach$3
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  int label;
  
  public ChannelsKt__Channels_commonKt$consumeEach$3(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return ChannelsKt.consumeEach(null, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach.3
 * JD-Core Version:    0.7.0.1
 */