package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "isRemoved", "forEach", "", "T", "Lkotlinx/coroutines/internal/Node;", "block", "Lkotlin/Function1;", "nextIfRemoved", "remove", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class LockFreeLinkedListHead
  extends LockFreeLinkedListNode
{
  public final boolean isEmpty()
  {
    return getNext() == (LockFreeLinkedListHead)this;
  }
  
  public boolean isRemoved()
  {
    return false;
  }
  
  @Nullable
  protected LockFreeLinkedListNode nextIfRemoved()
  {
    return null;
  }
  
  public final boolean remove()
  {
    throw ((Throwable)new IllegalStateException("head cannot be removed".toString()));
  }
  
  public final void validate$kotlinx_coroutines_core()
  {
    Object localObject2 = (LockFreeLinkedListNode)this;
    Object localObject1 = getNext();
    if (localObject1 != null)
    {
      LockFreeLinkedListNode localLockFreeLinkedListNode;
      for (localObject1 = (LockFreeLinkedListNode)localObject1; (Intrinsics.areEqual(localObject1, (LockFreeLinkedListHead)this) ^ true); localObject1 = localLockFreeLinkedListNode)
      {
        localLockFreeLinkedListNode = ((LockFreeLinkedListNode)localObject1).getNextNode();
        ((LockFreeLinkedListNode)localObject1).validateNode$kotlinx_coroutines_core((LockFreeLinkedListNode)localObject2, localLockFreeLinkedListNode);
        localObject2 = localObject1;
      }
      localObject1 = getNext();
      if (localObject1 != null)
      {
        validateNode$kotlinx_coroutines_core((LockFreeLinkedListNode)localObject2, (LockFreeLinkedListNode)localObject1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListHead
 * JD-Core Version:    0.7.0.1
 */