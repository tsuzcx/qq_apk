package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class InactiveNodeList
  implements Incomplete
{
  @NotNull
  private final NodeList list;
  
  public InactiveNodeList(@NotNull NodeList paramNodeList)
  {
    this.list = paramNodeList;
  }
  
  @NotNull
  public NodeList getList()
  {
    return this.list;
  }
  
  public boolean isActive()
  {
    return false;
  }
  
  @NotNull
  public String toString()
  {
    if (DebugKt.getDEBUG()) {
      return getList().getString("New");
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.InactiveNodeList
 * JD-Core Version:    0.7.0.1
 */