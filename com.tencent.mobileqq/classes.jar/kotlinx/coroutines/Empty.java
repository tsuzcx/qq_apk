package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", "", "(Z)V", "()Z", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class Empty
  implements Incomplete
{
  private final boolean isActive;
  
  public Empty(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  @Nullable
  public NodeList getList()
  {
    return null;
  }
  
  public boolean isActive()
  {
    return this.isActive;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty{");
    String str;
    if (isActive()) {
      str = "Active";
    } else {
      str = "New";
    }
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Empty
 * JD-Core Version:    0.7.0.1
 */