package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CONDITION_FALSE", "", "CONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class LockFreeLinkedListKt
{
  @NotNull
  private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");
  public static final int FAILURE = 2;
  @NotNull
  private static final Object LIST_EMPTY = new Symbol("LIST_EMPTY");
  public static final int SUCCESS = 1;
  public static final int UNDECIDED = 0;
  
  @NotNull
  public static final Object getCONDITION_FALSE()
  {
    return CONDITION_FALSE;
  }
  
  @NotNull
  public static final Object getLIST_EMPTY()
  {
    return LIST_EMPTY;
  }
  
  @PublishedApi
  @NotNull
  public static final LockFreeLinkedListNode unwrap(@NotNull Object paramObject)
  {
    if (!(paramObject instanceof Removed)) {
      localObject = null;
    } else {
      localObject = paramObject;
    }
    Object localObject = (Removed)localObject;
    if (localObject != null)
    {
      localObject = ((Removed)localObject).ref;
      if (localObject != null) {
        return localObject;
      }
    }
    if (paramObject != null) {
      return (LockFreeLinkedListNode)paramObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListKt
 * JD-Core Version:    0.7.0.1
 */