package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/IncompleteStateBox;", "", "state", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class IncompleteStateBox
{
  @JvmField
  @NotNull
  public final Incomplete state;
  
  public IncompleteStateBox(@NotNull Incomplete paramIncomplete)
  {
    this.state = paramIncomplete;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.IncompleteStateBox
 * JD-Core Version:    0.7.0.1
 */