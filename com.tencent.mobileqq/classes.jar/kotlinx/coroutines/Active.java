package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/Active;", "Lkotlinx/coroutines/NotCompleted;", "()V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class Active
  implements NotCompleted
{
  public static final Active INSTANCE = new Active();
  
  @NotNull
  public String toString()
  {
    return "Active";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Active
 * JD-Core Version:    0.7.0.1
 */