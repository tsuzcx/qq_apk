package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@PublishedApi
public abstract class LockFreeLinkedListNode$CondAddOp
  extends AtomicOp<LockFreeLinkedListNode>
{
  @JvmField
  @NotNull
  public final LockFreeLinkedListNode newNode;
  @JvmField
  @Nullable
  public LockFreeLinkedListNode oldNext;
  
  public LockFreeLinkedListNode$CondAddOp(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    this.newNode = paramLockFreeLinkedListNode;
  }
  
  public void complete(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @Nullable Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramObject = this.newNode;
    } else {
      paramObject = this.oldNext;
    }
    if ((paramObject != null) && (LockFreeLinkedListNode._next$FU.compareAndSet(paramLockFreeLinkedListNode, this, paramObject)) && (i != 0))
    {
      paramLockFreeLinkedListNode = this.newNode;
      paramObject = this.oldNext;
      if (paramObject == null) {
        Intrinsics.throwNpe();
      }
      LockFreeLinkedListNode.access$finishAdd(paramLockFreeLinkedListNode, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp
 * JD-Core Version:    0.7.0.1
 */