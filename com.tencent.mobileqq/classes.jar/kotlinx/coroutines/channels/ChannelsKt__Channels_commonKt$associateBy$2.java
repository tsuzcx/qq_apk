package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"associateBy", "", "E", "K", "V", "Lkotlinx/coroutines/channels/ReceiveChannel;", "keySelector", "Lkotlin/Function1;", "valueTransform", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f="Channels.common.kt", i={0, 0, 0, 0, 0, 0, 0, 0, 0}, l={2827}, m="associateBy", n={"$this$associateBy", "keySelector", "valueTransform", "$this$associateByTo$iv", "destination$iv", "$this$consumeEach$iv$iv", "$this$consume$iv$iv$iv", "cause$iv$iv$iv", "$this$consume$iv$iv"}, s={"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
public final class ChannelsKt__Channels_commonKt$associateBy$2
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  Object L$7;
  Object L$8;
  Object L$9;
  int label;
  
  public ChannelsKt__Channels_commonKt$associateBy$2(Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return ChannelsKt.associateBy(null, null, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.associateBy.2
 * JD-Core Version:    0.7.0.1
 */