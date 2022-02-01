package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "next", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "finishPrepare", "", "perform", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class LockFreeLinkedListNode$PrepareOp
  extends OpDescriptor
{
  @JvmField
  @NotNull
  public final LockFreeLinkedListNode affected;
  @JvmField
  @NotNull
  public final LockFreeLinkedListNode.AbstractAtomicDesc desc;
  @JvmField
  @NotNull
  public final LockFreeLinkedListNode next;
  
  public LockFreeLinkedListNode$PrepareOp(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2, @NotNull LockFreeLinkedListNode.AbstractAtomicDesc paramAbstractAtomicDesc)
  {
    this.affected = paramLockFreeLinkedListNode1;
    this.next = paramLockFreeLinkedListNode2;
    this.desc = paramAbstractAtomicDesc;
  }
  
  public final void finishPrepare()
  {
    this.desc.finishPrepare(this);
  }
  
  @NotNull
  public AtomicOp<?> getAtomicOp()
  {
    return this.desc.getAtomicOp();
  }
  
  @Nullable
  public Object perform(@Nullable Object paramObject)
  {
    boolean bool2 = DebugKt.getASSERTIONS_ENABLED();
    boolean bool1 = true;
    if (bool2)
    {
      int i;
      if (paramObject == this.affected) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (paramObject != null)
    {
      LockFreeLinkedListNode localLockFreeLinkedListNode = (LockFreeLinkedListNode)paramObject;
      paramObject = this.desc.onPrepare(this);
      if (paramObject == LockFreeLinkedList_commonKt.REMOVE_PREPARED)
      {
        paramObject = this.next;
        Removed localRemoved = LockFreeLinkedListNode.access$removed(paramObject);
        if (LockFreeLinkedListNode._next$FU.compareAndSet(localLockFreeLinkedListNode, this, localRemoved)) {
          LockFreeLinkedListNode.access$correctPrev(paramObject, null);
        }
        return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
      }
      if (paramObject != null) {
        getAtomicOp().decide(paramObject);
      } else {
        bool1 = getAtomicOp().isDecided();
      }
      if (bool1) {
        paramObject = this.next;
      } else {
        paramObject = getAtomicOp();
      }
      LockFreeLinkedListNode._next$FU.compareAndSet(localLockFreeLinkedListNode, this, paramObject);
      return null;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrepareOp(op=");
    localStringBuilder.append(getAtomicOp());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp
 * JD-Core Version:    0.7.0.1
 */