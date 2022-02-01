package kotlinx.coroutines.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Channel", "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", "", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ChannelKt
{
  @NotNull
  public static final <E> Channel<E> Channel(int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt != 2147483647) {
            return (Channel)new ArrayChannel(paramInt);
          }
          return (Channel)new LinkedListChannel();
        }
        return (Channel)new RendezvousChannel();
      }
      return (Channel)new ConflatedChannel();
    }
    return (Channel)new ArrayChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelKt
 * JD-Core Version:    0.7.0.1
 */