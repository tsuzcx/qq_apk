package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "cause", "", "invoke"}, k=3, mv={1, 1, 16})
final class ChannelsKt__Channels_commonKt$consumes$1
  extends Lambda
  implements Function1<Throwable, Unit>
{
  ChannelsKt__Channels_commonKt$consumes$1(ReceiveChannel paramReceiveChannel)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Throwable paramThrowable)
  {
    ChannelsKt.cancelConsumed(this.$this_consumes, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumes.1
 * JD-Core Version:    0.7.0.1
 */