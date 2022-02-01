package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public class LockFreeLinkedListNode
{
  static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
  static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
  private static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
  volatile Object _next = this;
  volatile Object _prev = this;
  private volatile Object _removedRef = null;
  
  private final LockFreeLinkedListNode correctPrev(OpDescriptor paramOpDescriptor)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode1 = (LockFreeLinkedListNode)this._prev;
    LockFreeLinkedListNode localLockFreeLinkedListNode2 = (LockFreeLinkedListNode)null;
    Object localObject1 = localLockFreeLinkedListNode1;
    label18:
    Object localObject2 = localLockFreeLinkedListNode2;
    for (;;)
    {
      Object localObject3 = ((LockFreeLinkedListNode)localObject1)._next;
      if (localObject3 == (LockFreeLinkedListNode)this)
      {
        if (localLockFreeLinkedListNode1 == localObject1) {
          return localObject1;
        }
        if (!_prev$FU.compareAndSet(this, localLockFreeLinkedListNode1, localObject1)) {
          break;
        }
        return localObject1;
      }
      if (isRemoved()) {
        return null;
      }
      if (localObject3 == paramOpDescriptor) {
        return localObject1;
      }
      if ((localObject3 instanceof OpDescriptor))
      {
        if ((paramOpDescriptor != null) && (paramOpDescriptor.isEarlierThan((OpDescriptor)localObject3))) {
          return null;
        }
        ((OpDescriptor)localObject3).perform(localObject1);
        break;
      }
      if ((localObject3 instanceof Removed))
      {
        if (localObject2 != null)
        {
          if (!_next$FU.compareAndSet(localObject2, localObject1, ((Removed)localObject3).ref)) {
            break;
          }
          localObject1 = localObject2;
          break label18;
        }
        localObject1 = (LockFreeLinkedListNode)((LockFreeLinkedListNode)localObject1)._prev;
        continue;
      }
      if (localObject3 == null) {
        break label188;
      }
      localObject3 = (LockFreeLinkedListNode)localObject3;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    label188:
    paramOpDescriptor = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw paramOpDescriptor;
    }
  }
  
  private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    for (;;)
    {
      if (!paramLockFreeLinkedListNode.isRemoved()) {
        return paramLockFreeLinkedListNode;
      }
      paramLockFreeLinkedListNode = (LockFreeLinkedListNode)paramLockFreeLinkedListNode._prev;
    }
  }
  
  private final void finishAdd(LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode;
    do
    {
      localLockFreeLinkedListNode = (LockFreeLinkedListNode)paramLockFreeLinkedListNode._prev;
      if (getNext() != paramLockFreeLinkedListNode) {
        return;
      }
    } while (!_prev$FU.compareAndSet(paramLockFreeLinkedListNode, localLockFreeLinkedListNode, this));
    if (isRemoved()) {
      paramLockFreeLinkedListNode.correctPrev(null);
    }
  }
  
  private final Removed removed()
  {
    Removed localRemoved = (Removed)this._removedRef;
    if (localRemoved != null) {
      return localRemoved;
    }
    localRemoved = new Removed(this);
    _removedRef$FU.lazySet(this, localRemoved);
    return localRemoved;
  }
  
  public final void addLast(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    while (!getPrevNode().addNext(paramLockFreeLinkedListNode, this)) {}
  }
  
  public final boolean addLastIf(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @NotNull Function0<Boolean> paramFunction0)
  {
    paramFunction0 = (LockFreeLinkedListNode.CondAddOp)new LockFreeLinkedListNode.makeCondAddOp.1(paramFunction0, paramLockFreeLinkedListNode, paramLockFreeLinkedListNode);
    int i;
    do
    {
      i = getPrevNode().tryCondAddNext(paramLockFreeLinkedListNode, this, paramFunction0);
      if (i == 1) {
        break;
      }
    } while (i != 2);
    return false;
    return true;
  }
  
  public final boolean addLastIfPrev(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> paramFunction1)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode;
    do
    {
      localLockFreeLinkedListNode = getPrevNode();
      if (!((Boolean)paramFunction1.invoke(localLockFreeLinkedListNode)).booleanValue()) {
        return false;
      }
    } while (!localLockFreeLinkedListNode.addNext(paramLockFreeLinkedListNode, this));
    return true;
  }
  
  public final boolean addLastIfPrevAndIf(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> paramFunction1, @NotNull Function0<Boolean> paramFunction0)
  {
    paramFunction0 = (LockFreeLinkedListNode.CondAddOp)new LockFreeLinkedListNode.makeCondAddOp.1(paramFunction0, paramLockFreeLinkedListNode, paramLockFreeLinkedListNode);
    int i;
    do
    {
      LockFreeLinkedListNode localLockFreeLinkedListNode = getPrevNode();
      if (!((Boolean)paramFunction1.invoke(localLockFreeLinkedListNode)).booleanValue()) {
        return false;
      }
      i = localLockFreeLinkedListNode.tryCondAddNext(paramLockFreeLinkedListNode, this, paramFunction0);
      if (i == 1) {
        break;
      }
    } while (i != 2);
    return false;
    return true;
  }
  
  @PublishedApi
  public final boolean addNext(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2)
  {
    _prev$FU.lazySet(paramLockFreeLinkedListNode1, this);
    _next$FU.lazySet(paramLockFreeLinkedListNode1, paramLockFreeLinkedListNode2);
    if (!_next$FU.compareAndSet(this, paramLockFreeLinkedListNode2, paramLockFreeLinkedListNode1)) {
      return false;
    }
    paramLockFreeLinkedListNode1.finishAdd(paramLockFreeLinkedListNode2);
    return true;
  }
  
  public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    _prev$FU.lazySet(paramLockFreeLinkedListNode, this);
    _next$FU.lazySet(paramLockFreeLinkedListNode, this);
    do
    {
      if (getNext() != (LockFreeLinkedListNode)this) {
        return false;
      }
    } while (!_next$FU.compareAndSet(this, this, paramLockFreeLinkedListNode));
    paramLockFreeLinkedListNode.finishAdd(this);
    return true;
  }
  
  @NotNull
  public final <T extends LockFreeLinkedListNode> LockFreeLinkedListNode.AddLastDesc<T> describeAddLast(@NotNull T paramT)
  {
    return new LockFreeLinkedListNode.AddLastDesc(this, paramT);
  }
  
  @NotNull
  public final LockFreeLinkedListNode.RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst()
  {
    return new LockFreeLinkedListNode.RemoveFirstDesc(this);
  }
  
  @NotNull
  public final Object getNext()
  {
    for (;;)
    {
      Object localObject = this._next;
      if (!(localObject instanceof OpDescriptor)) {
        return localObject;
      }
      ((OpDescriptor)localObject).perform(this);
    }
  }
  
  @NotNull
  public final LockFreeLinkedListNode getNextNode()
  {
    return LockFreeLinkedListKt.unwrap(getNext());
  }
  
  @NotNull
  public final LockFreeLinkedListNode getPrevNode()
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode = correctPrev(null);
    if (localLockFreeLinkedListNode != null) {
      return localLockFreeLinkedListNode;
    }
    return findPrevNonRemoved((LockFreeLinkedListNode)this._prev);
  }
  
  public final void helpRemove()
  {
    Object localObject = getNext();
    if (localObject != null)
    {
      ((Removed)localObject).ref.correctPrev(null);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
  }
  
  @PublishedApi
  public final void helpRemovePrev()
  {
    Object localObject;
    for (LockFreeLinkedListNode localLockFreeLinkedListNode = (LockFreeLinkedListNode)this;; localLockFreeLinkedListNode = ((Removed)localObject).ref)
    {
      localObject = localLockFreeLinkedListNode.getNext();
      if (!(localObject instanceof Removed))
      {
        localLockFreeLinkedListNode.correctPrev(null);
        return;
      }
    }
  }
  
  public boolean isRemoved()
  {
    return getNext() instanceof Removed;
  }
  
  @PublishedApi
  @NotNull
  public final LockFreeLinkedListNode.CondAddOp makeCondAddOp(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode, @NotNull Function0<Boolean> paramFunction0)
  {
    return (LockFreeLinkedListNode.CondAddOp)new LockFreeLinkedListNode.makeCondAddOp.1(paramFunction0, paramLockFreeLinkedListNode, paramLockFreeLinkedListNode);
  }
  
  @Nullable
  protected LockFreeLinkedListNode nextIfRemoved()
  {
    Object localObject1 = getNext();
    boolean bool = localObject1 instanceof Removed;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    Removed localRemoved = (Removed)localObject1;
    localObject1 = localObject2;
    if (localRemoved != null) {
      localObject1 = localRemoved.ref;
    }
    return localObject1;
  }
  
  public boolean remove()
  {
    return removeOrNext() == null;
  }
  
  @Nullable
  public final LockFreeLinkedListNode removeFirstOrNull()
  {
    for (;;)
    {
      localObject = getNext();
      if (localObject == null) {
        break;
      }
      localObject = (LockFreeLinkedListNode)localObject;
      if (localObject == (LockFreeLinkedListNode)this) {
        return null;
      }
      if (((LockFreeLinkedListNode)localObject).remove()) {
        return localObject;
      }
      ((LockFreeLinkedListNode)localObject).helpRemove();
    }
    Object localObject = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @PublishedApi
  @Nullable
  public final LockFreeLinkedListNode removeOrNext()
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode;
    Removed localRemoved;
    do
    {
      localObject = getNext();
      if ((localObject instanceof Removed)) {
        return ((Removed)localObject).ref;
      }
      if (localObject == (LockFreeLinkedListNode)this) {
        return (LockFreeLinkedListNode)localObject;
      }
      if (localObject == null) {
        break;
      }
      localLockFreeLinkedListNode = (LockFreeLinkedListNode)localObject;
      localRemoved = localLockFreeLinkedListNode.removed();
    } while (!_next$FU.compareAndSet(this, localObject, localRemoved));
    localLockFreeLinkedListNode.correctPrev(null);
    return null;
    Object localObject = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    return localStringBuilder.toString();
  }
  
  @PublishedApi
  public final int tryCondAddNext(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2, @NotNull LockFreeLinkedListNode.CondAddOp paramCondAddOp)
  {
    _prev$FU.lazySet(paramLockFreeLinkedListNode1, this);
    _next$FU.lazySet(paramLockFreeLinkedListNode1, paramLockFreeLinkedListNode2);
    paramCondAddOp.oldNext = paramLockFreeLinkedListNode2;
    if (!_next$FU.compareAndSet(this, paramLockFreeLinkedListNode2, paramCondAddOp)) {
      return 0;
    }
    if (paramCondAddOp.perform(this) == null) {
      return 1;
    }
    return 2;
  }
  
  public final void validateNode$kotlinx_coroutines_core(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode1, @NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode2)
  {
    boolean bool = DebugKt.getASSERTIONS_ENABLED();
    int j = 1;
    int i;
    if (bool)
    {
      if (paramLockFreeLinkedListNode1 == (LockFreeLinkedListNode)this._prev) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if (paramLockFreeLinkedListNode2 == this._next) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      throw ((Throwable)new AssertionError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListNode
 * JD-Core Version:    0.7.0.1
 */