package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/Incomplete;", "", "isActive", "", "()Z", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface Incomplete
{
  @Nullable
  public abstract NodeList getList();
  
  public abstract boolean isActive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Incomplete
 * JD-Core Version:    0.7.0.1
 */