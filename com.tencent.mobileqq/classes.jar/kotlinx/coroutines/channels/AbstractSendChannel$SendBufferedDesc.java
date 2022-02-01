package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
class AbstractSendChannel$SendBufferedDesc<E>
  extends LockFreeLinkedListNode.AddLastDesc<AbstractSendChannel.SendBuffered<? extends E>>
{
  public AbstractSendChannel$SendBufferedDesc(@NotNull LockFreeLinkedListHead paramLockFreeLinkedListHead, E paramE)
  {
    super((LockFreeLinkedListNode)paramLockFreeLinkedListHead, (LockFreeLinkedListNode)new AbstractSendChannel.SendBuffered(paramE));
  }
  
  @Nullable
  protected Object failure(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    if ((paramLockFreeLinkedListNode instanceof Closed)) {
      return paramLockFreeLinkedListNode;
    }
    if ((paramLockFreeLinkedListNode instanceof ReceiveOrClosed)) {
      return AbstractChannelKt.OFFER_FAILED;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractSendChannel.SendBufferedDesc
 * JD-Core Version:    0.7.0.1
 */