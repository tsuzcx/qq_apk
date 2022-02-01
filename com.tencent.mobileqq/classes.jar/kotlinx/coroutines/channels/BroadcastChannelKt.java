package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"BroadcastChannel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "capacity", "", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class BroadcastChannelKt
{
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <E> BroadcastChannel<E> BroadcastChannel(int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt != 2147483647) {
            return (BroadcastChannel)new ArrayBroadcastChannel(paramInt);
          }
          throw ((Throwable)new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel"));
        }
        throw ((Throwable)new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel"));
      }
      return (BroadcastChannel)new ConflatedBroadcastChannel();
    }
    return (BroadcastChannel)new ArrayBroadcastChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.BroadcastChannelKt
 * JD-Core Version:    0.7.0.1
 */