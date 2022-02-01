package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/RemoveOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class RemoveOnCancel
  extends CancelHandler
{
  private final LockFreeLinkedListNode node;
  
  public RemoveOnCancel(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    this.node = paramLockFreeLinkedListNode;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    this.node.remove();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RemoveOnCancel[");
    localStringBuilder.append(this.node);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.RemoveOnCancel
 * JD-Core Version:    0.7.0.1
 */