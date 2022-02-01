package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class NodeList
  extends LockFreeLinkedListHead
  implements Incomplete
{
  @NotNull
  public NodeList getList()
  {
    return this;
  }
  
  @NotNull
  public final String getString(@NotNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("List{");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}[");
    LockFreeLinkedListHead localLockFreeLinkedListHead = (LockFreeLinkedListHead)this;
    paramString = localLockFreeLinkedListHead.getNext();
    if (paramString != null)
    {
      paramString = (LockFreeLinkedListNode)paramString;
      int j;
      for (int i = 1; (Intrinsics.areEqual(paramString, localLockFreeLinkedListHead) ^ true); i = j)
      {
        j = i;
        if ((paramString instanceof JobNode))
        {
          JobNode localJobNode = (JobNode)paramString;
          if (i != 0) {
            i = 0;
          } else {
            localStringBuilder.append(", ");
          }
          localStringBuilder.append(localJobNode);
          j = i;
        }
        paramString = paramString.getNextNode();
      }
      localStringBuilder.append("]");
      paramString = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "StringBuilder().apply(builderAction).toString()");
      return paramString;
    }
    paramString = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean isActive()
  {
    return true;
  }
  
  @NotNull
  public String toString()
  {
    if (DebugKt.getDEBUG()) {
      return getString("Active");
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.NodeList
 * JD-Core Version:    0.7.0.1
 */