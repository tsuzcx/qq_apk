package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1
  extends LockFreeLinkedListNode.CondAddOp
{
  public AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(LockFreeLinkedListNode paramLockFreeLinkedListNode1, LockFreeLinkedListNode paramLockFreeLinkedListNode2, AbstractChannel paramAbstractChannel)
  {
    super(paramLockFreeLinkedListNode2);
  }
  
  @Nullable
  public Object prepare(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    if (this.this$0.isBufferEmpty()) {
      return null;
    }
    return LockFreeLinkedListKt.getCONDITION_FALSE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannel.enqueueReceiveInternal..inlined.addLastIfPrevAndIf.1
 * JD-Core Version:    0.7.0.1
 */