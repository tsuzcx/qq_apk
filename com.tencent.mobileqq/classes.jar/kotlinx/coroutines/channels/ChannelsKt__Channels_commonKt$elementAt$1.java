package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"elementAt", "", "E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "index", "", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f="Channels.common.kt", i={0, 0, 0, 0, 0, 0, 0}, l={2257}, m="elementAt", n={"$this$elementAt", "index", "$this$elementAtOrElse$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "count$iv"}, s={"L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "I$1"})
final class ChannelsKt__Channels_commonKt$elementAt$1
  extends ContinuationImpl
{
  int I$0;
  int I$1;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  int label;
  
  ChannelsKt__Channels_commonKt$elementAt$1(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return ChannelsKt.elementAt(null, 0, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.elementAt.1
 * JD-Core Version:    0.7.0.1
 */