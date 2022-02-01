package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "element", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class AbstractSendChannel$TryOfferDesc<E>
  extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>>
{
  @JvmField
  public final E element;
  
  public AbstractSendChannel$TryOfferDesc(E paramE, @NotNull LockFreeLinkedListHead paramLockFreeLinkedListHead)
  {
    super((LockFreeLinkedListNode)paramLockFreeLinkedListHead);
    this.element = paramE;
  }
  
  @Nullable
  protected Object failure(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    if ((paramLockFreeLinkedListNode instanceof Closed)) {
      return paramLockFreeLinkedListNode;
    }
    if (!(paramLockFreeLinkedListNode instanceof ReceiveOrClosed)) {
      return AbstractChannelKt.OFFER_FAILED;
    }
    return null;
  }
  
  @Nullable
  public Object onPrepare(@NotNull LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode = paramPrepareOp.affected;
    if (localLockFreeLinkedListNode != null)
    {
      paramPrepareOp = ((ReceiveOrClosed)localLockFreeLinkedListNode).tryResumeReceive(this.element, paramPrepareOp);
      if (paramPrepareOp != null)
      {
        if (paramPrepareOp == AtomicKt.RETRY_ATOMIC) {
          return AtomicKt.RETRY_ATOMIC;
        }
        if (DebugKt.getASSERTIONS_ENABLED())
        {
          int i;
          if (paramPrepareOp == CancellableContinuationImplKt.RESUME_TOKEN) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            throw ((Throwable)new AssertionError());
          }
        }
        return null;
      }
      return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveOrClosed<E>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractSendChannel.TryOfferDesc
 * JD-Core Version:    0.7.0.1
 */