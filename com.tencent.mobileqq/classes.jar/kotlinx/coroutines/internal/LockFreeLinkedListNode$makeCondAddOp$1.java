package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class LockFreeLinkedListNode$makeCondAddOp$1
  extends LockFreeLinkedListNode.CondAddOp
{
  public LockFreeLinkedListNode$makeCondAddOp$1(Function0 paramFunction0, LockFreeLinkedListNode paramLockFreeLinkedListNode1, LockFreeLinkedListNode paramLockFreeLinkedListNode2)
  {
    super(paramLockFreeLinkedListNode2);
  }
  
  @Nullable
  public Object prepare(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    if (((Boolean)this.$condition.invoke()).booleanValue()) {
      return null;
    }
    return LockFreeLinkedListKt.getCONDITION_FALSE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeLinkedListNode.makeCondAddOp.1
 * JD-Core Version:    0.7.0.1
 */