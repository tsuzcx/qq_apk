package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class DefaultExecutorKt
{
  @NotNull
  private static final Delay DefaultDelay = (Delay)DefaultExecutor.INSTANCE;
  
  @NotNull
  public static final Delay getDefaultDelay()
  {
    return DefaultDelay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DefaultExecutorKt
 * JD-Core Version:    0.7.0.1
 */