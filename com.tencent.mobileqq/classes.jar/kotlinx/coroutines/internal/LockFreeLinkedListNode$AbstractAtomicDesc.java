package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "()V", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "", "affected", "finishOnSuccess", "next", "finishPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "onPrepare", "prepare", "retry", "", "takeAffectedNode", "Lkotlinx/coroutines/internal/OpDescriptor;", "updatedNext", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class LockFreeLinkedListNode$AbstractAtomicDesc
  extends AtomicDesc
{
  public final void complete(@NotNull AtomicOp<?> paramAtomicOp, @Nullable Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    LockFreeLinkedListNode localLockFreeLinkedListNode2 = getAffectedNode();
    if (localLockFreeLinkedListNode2 != null)
    {
      LockFreeLinkedListNode localLockFreeLinkedListNode1 = getOriginalNext();
      if (localLockFreeLinkedListNode1 != null)
      {
        if (i != 0) {
          paramObject = updatedNext(localLockFreeLinkedListNode2, localLockFreeLinkedListNode1);
        } else {
          paramObject = localLockFreeLinkedListNode1;
        }
        if ((LockFreeLinkedListNode._next$FU.compareAndSet(localLockFreeLinkedListNode2, paramAtomicOp, paramObject)) && (i != 0)) {
          finishOnSuccess(localLockFreeLinkedListNode2, localLockFreeLinkedListNode1);
        }
        return;
      }
      paramAtomicOp = (AbstractAtomicDesc)this;
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        if ((i ^ 0x1) != 0) {
          return;
        }
        throw ((Throwable)new AssertionError());
      }
      return;
    }
    paramAtomicOp = (AbstractAtomicDesc)this;
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if ((i ^ 0x1) != 0) {
        return;
      }
      throw ((Throwable)new AssertionError());
    }
  }
  
  @Nullable
  protected Object failure(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    return null;
  }
  
  protected abstract void finishOnSuccess(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2);
  
  public abstract void finishPrepare(@NotNull LockFreeLinkedListNode.PrepareOp paramPrepareOp);
  
  @Nullable
  protected abstract LockFreeLinkedListNode getAffectedNode();
  
  @Nullable
  protected abstract LockFreeLinkedListNode getOriginalNext();
  
  @Nullable
  public Object onPrepare(@NotNull LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    finishPrepare(paramPrepareOp);
    return null;
  }
  
  @Nullable
  public final Object prepare(@NotNull AtomicOp<?> paramAtomicOp)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode;
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        for (;;)
        {
          localLockFreeLinkedListNode = takeAffectedNode((OpDescriptor)paramAtomicOp);
          if (localLockFreeLinkedListNode == null) {
            break label210;
          }
          localObject1 = localLockFreeLinkedListNode._next;
          if (localObject1 == paramAtomicOp) {
            return null;
          }
          if (paramAtomicOp.isDecided()) {
            return null;
          }
          if (!(localObject1 instanceof OpDescriptor)) {
            break;
          }
          localObject1 = (OpDescriptor)localObject1;
          if (paramAtomicOp.isEarlierThan((OpDescriptor)localObject1)) {
            return AtomicKt.RETRY_ATOMIC;
          }
          ((OpDescriptor)localObject1).perform(localLockFreeLinkedListNode);
        }
        localObject2 = failure(localLockFreeLinkedListNode);
        if (localObject2 != null) {
          return localObject2;
        }
      } while (retry(localLockFreeLinkedListNode, localObject1));
      if (localObject1 == null) {
        break;
      }
      localObject2 = new LockFreeLinkedListNode.PrepareOp(localLockFreeLinkedListNode, (LockFreeLinkedListNode)localObject1, this);
    } while (!LockFreeLinkedListNode._next$FU.compareAndSet(localLockFreeLinkedListNode, localObject1, localObject2));
    int i;
    label210:
    label214:
    do
    {
      try
      {
        Object localObject3 = ((LockFreeLinkedListNode.PrepareOp)localObject2).perform(localLockFreeLinkedListNode);
        if (localObject3 == LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
          break;
        }
        if (DebugKt.getASSERTIONS_ENABLED())
        {
          if (localObject3 != null) {
            break label214;
          }
          i = 1;
          continue;
          throw ((Throwable)new AssertionError());
        }
        return null;
      }
      catch (Throwable paramAtomicOp)
      {
        LockFreeLinkedListNode._next$FU.compareAndSet(localLockFreeLinkedListNode, localObject2, localObject1);
        throw paramAtomicOp;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      return AtomicKt.RETRY_ATOMIC;
      i = 0;
    } while (i == 0);
    return null;
  }
  
  protected boolean retry(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @NotNull Object paramObject)
  {
    return false;
  }
  
  @Nullable
  protected LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor paramOpDescriptor)
  {
    paramOpDescriptor = getAffectedNode();
    if (paramOpDescriptor == null) {
      Intrinsics.throwNpe();
    }
    return paramOpDescriptor;
  }
  
  @NotNull
  protected abstract Object updatedNext(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
 * JD-Core Version:    0.7.0.1
 */