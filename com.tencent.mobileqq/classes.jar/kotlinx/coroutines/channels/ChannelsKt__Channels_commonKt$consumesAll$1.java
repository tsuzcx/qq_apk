package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "cause", "", "invoke"}, k=3, mv={1, 1, 16})
final class ChannelsKt__Channels_commonKt$consumesAll$1
  extends Lambda
  implements Function1<Throwable, Unit>
{
  ChannelsKt__Channels_commonKt$consumesAll$1(ReceiveChannel[] paramArrayOfReceiveChannel)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Throwable paramThrowable)
  {
    Object localObject = (Throwable)null;
    ReceiveChannel[] arrayOfReceiveChannel = this.$channels;
    int j = arrayOfReceiveChannel.length;
    int i = 0;
    while (i < j)
    {
      ReceiveChannel localReceiveChannel = arrayOfReceiveChannel[i];
      try
      {
        ChannelsKt.cancelConsumed(localReceiveChannel, paramThrowable);
      }
      catch (Throwable localThrowable)
      {
        if (localObject == null) {
          localObject = localThrowable;
        } else {
          ExceptionsKt.addSuppressed((Throwable)localObject, localThrowable);
        }
      }
      i += 1;
    }
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumesAll.1
 * JD-Core Version:    0.7.0.1
 */