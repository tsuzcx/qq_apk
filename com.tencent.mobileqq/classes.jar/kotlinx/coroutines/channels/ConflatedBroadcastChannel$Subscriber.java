package kotlinx.coroutines.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ConflatedBroadcastChannel$Subscriber<E>
  extends ConflatedChannel<E>
  implements ReceiveChannel<E>
{
  private final ConflatedBroadcastChannel<E> broadcastChannel;
  
  public ConflatedBroadcastChannel$Subscriber(@NotNull ConflatedBroadcastChannel<E> paramConflatedBroadcastChannel)
  {
    this.broadcastChannel = paramConflatedBroadcastChannel;
  }
  
  @NotNull
  public Object offerInternal(E paramE)
  {
    return super.offerInternal(paramE);
  }
  
  protected void onCancelIdempotent(boolean paramBoolean)
  {
    if (paramBoolean) {
      ConflatedBroadcastChannel.access$closeSubscriber(this.broadcastChannel, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ConflatedBroadcastChannel.Subscriber
 * JD-Core Version:    0.7.0.1
 */