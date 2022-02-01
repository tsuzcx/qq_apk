package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "T", "queue", "node", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "next", "", "finishOnSuccess", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k=1, mv={1, 1, 16})
public class LockFreeLinkedListNode$AddLastDesc<T extends LockFreeLinkedListNode>
  extends LockFreeLinkedListNode.AbstractAtomicDesc
{
  private static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
  private volatile Object _affectedNode;
  @JvmField
  @NotNull
  public final T node;
  @JvmField
  @NotNull
  public final LockFreeLinkedListNode queue;
  
  public LockFreeLinkedListNode$AddLastDesc(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @NotNull T paramT)
  {
    this.queue = paramLockFreeLinkedListNode;
    this.node = paramT;
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      paramLockFreeLinkedListNode = this.node._next;
      paramT = this.node;
      int i;
      if ((paramLockFreeLinkedListNode == paramT) && ((LockFreeLinkedListNode)paramT._prev == this.node)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    this._affectedNode = null;
  }
  
  protected void finishOnSuccess(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2)
  {
    LockFreeLinkedListNode.access$finishAdd(this.node, this.queue);
  }
  
  public void finishPrepare(@NotNull LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    _affectedNode$FU.compareAndSet(this, null, paramPrepareOp.affected);
  }
  
  @Nullable
  protected final LockFreeLinkedListNode getAffectedNode()
  {
    return (LockFreeLinkedListNode)this._affectedNode;
  }
  
  @Nullable
  protected final LockFreeLinkedListNode getOriginalNext()
  {
    return this.queue;
  }
  
  protected boolean retry(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @NotNull Object paramObject)
  {
    return paramObject != this.queue;
  }
  
  @Nullable
  protected final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor paramOpDescriptor)
  {
    return LockFreeLinkedListNode.access$correctPrev(this.queue, paramOpDescriptor);
  }
  
  @NotNull
  protected Object updatedNext(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2)
  {
    paramLockFreeLinkedListNode2 = this.node;
    LockFreeLinkedListNode._prev$FU.compareAndSet(paramLockFreeLinkedListNode2, this.node, paramLockFreeLinkedListNode1);
    paramLockFreeLinkedListNode1 = this.node;
    LockFreeLinkedListNode._next$FU.compareAndSet(paramLockFreeLinkedListNode1, this.node, this.queue);
    return this.node;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc
 * JD-Core Version:    0.7.0.1
 */