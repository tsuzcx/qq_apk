package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractSendChannel$SendConflatedDesc;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "finishOnSuccess", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class AbstractSendChannel$SendConflatedDesc<E>
  extends AbstractSendChannel.SendBufferedDesc<E>
{
  public AbstractSendChannel$SendConflatedDesc(@NotNull LockFreeLinkedListHead paramLockFreeLinkedListHead, E paramE)
  {
    super(paramLockFreeLinkedListHead, paramE);
  }
  
  protected void finishOnSuccess(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2)
  {
    super.finishOnSuccess(paramLockFreeLinkedListNode1, paramLockFreeLinkedListNode2);
    paramLockFreeLinkedListNode2 = paramLockFreeLinkedListNode1;
    if (!(paramLockFreeLinkedListNode1 instanceof AbstractSendChannel.SendBuffered)) {
      paramLockFreeLinkedListNode2 = null;
    }
    paramLockFreeLinkedListNode1 = (AbstractSendChannel.SendBuffered)paramLockFreeLinkedListNode2;
    if (paramLockFreeLinkedListNode1 != null) {
      paramLockFreeLinkedListNode1.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractSendChannel.SendConflatedDesc
 * JD-Core Version:    0.7.0.1
 */