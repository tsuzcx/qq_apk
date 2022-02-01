package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/Receive;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "()V", "offerResult", "", "getOfferResult", "()Ljava/lang/Object;", "resumeReceiveClosed", "", "closed", "Lkotlinx/coroutines/channels/Closed;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class Receive<E>
  extends LockFreeLinkedListNode
  implements ReceiveOrClosed<E>
{
  @NotNull
  public Object getOfferResult()
  {
    return AbstractChannelKt.OFFER_SUCCESS;
  }
  
  public abstract void resumeReceiveClosed(@NotNull Closed<?> paramClosed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.Receive
 * JD-Core Version:    0.7.0.1
 */