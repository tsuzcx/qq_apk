package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"mapIndexedTo", "", "E", "R", "C", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "destination", "transform", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f="Channels.common.kt", i={0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l={3184, 1536}, m="mapIndexedTo", n={"$this$mapIndexedTo", "destination", "transform", "index", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "$this$mapIndexedTo", "destination", "transform", "index", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "it"}, s={"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10"})
public final class ChannelsKt__Channels_commonKt$mapIndexedTo$3
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$10;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  Object L$7;
  Object L$8;
  Object L$9;
  int label;
  
  public ChannelsKt__Channels_commonKt$mapIndexedTo$3(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return ChannelsKt.mapIndexedTo(null, null, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.mapIndexedTo.3
 * JD-Core Version:    0.7.0.1
 */