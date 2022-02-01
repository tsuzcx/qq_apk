package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Runnable", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/Function0;", "", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class RunnableKt
{
  @NotNull
  public static final Runnable Runnable(@NotNull Function0<Unit> paramFunction0)
  {
    return (Runnable)new RunnableKt.Runnable.1(paramFunction0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.RunnableKt
 * JD-Core Version:    0.7.0.1
 */