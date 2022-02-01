package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "queue", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "result$annotations", "()V", "result", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k=1, mv={1, 1, 16})
public class LockFreeLinkedListNode$RemoveFirstDesc<T>
  extends LockFreeLinkedListNode.AbstractAtomicDesc
{
  private static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
  private static final AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
  private volatile Object _affectedNode;
  private volatile Object _originalNext;
  @JvmField
  @NotNull
  public final LockFreeLinkedListNode queue;
  
  public LockFreeLinkedListNode$RemoveFirstDesc(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    this.queue = paramLockFreeLinkedListNode;
    this._affectedNode = null;
    this._originalNext = null;
  }
  
  @Nullable
  protected Object failure(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    if (paramLockFreeLinkedListNode == this.queue) {
      return LockFreeLinkedListKt.getLIST_EMPTY();
    }
    return null;
  }
  
  protected final void finishOnSuccess(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2)
  {
    LockFreeLinkedListNode.access$correctPrev(paramLockFreeLinkedListNode2, null);
  }
  
  public void finishPrepare(@NotNull LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    _affectedNode$FU.compareAndSet(this, null, paramPrepareOp.affected);
    _originalNext$FU.compareAndSet(this, null, paramPrepareOp.next);
  }
  
  @Nullable
  protected final LockFreeLinkedListNode getAffectedNode()
  {
    return (LockFreeLinkedListNode)this._affectedNode;
  }
  
  @Nullable
  protected final LockFreeLinkedListNode getOriginalNext()
  {
    return (LockFreeLinkedListNode)this._originalNext;
  }
  
  public final T getResult()
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode = getAffectedNode();
    if (localLockFreeLinkedListNode == null) {
      Intrinsics.throwNpe();
    }
    return (Object)localLockFreeLinkedListNode;
  }
  
  protected final boolean retry(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @NotNull Object paramObject)
  {
    if (!(paramObject instanceof Removed)) {
      return false;
    }
    ((Removed)paramObject).ref.helpRemovePrev();
    return true;
  }
  
  @Nullable
  protected final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor paramOpDescriptor)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode = this.queue;
    Object localObject;
    for (;;)
    {
      localObject = localLockFreeLinkedListNode._next;
      if (!(localObject instanceof OpDescriptor)) {
        break;
      }
      localObject = (OpDescriptor)localObject;
      if (paramOpDescriptor.isEarlierThan((OpDescriptor)localObject)) {
        return null;
      }
      ((OpDescriptor)localObject).perform(this.queue);
    }
    if (localObject != null) {
      return (LockFreeLinkedListNode)localObject;
    }
    paramOpDescriptor = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw paramOpDescriptor;
    }
  }
  
  @NotNull
  protected final Object updatedNext(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2)
  {
    return LockFreeLinkedListNode.access$removed(paramLockFreeLinkedListNode2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc
 * JD-Core Version:    0.7.0.1
 */