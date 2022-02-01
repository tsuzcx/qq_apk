package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"RESUMED", "", "RESUME_TOKEN", "Lkotlinx/coroutines/internal/Symbol;", "RESUME_TOKEN$annotations", "()V", "SUSPENDED", "UNDECIDED", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CancellableContinuationImplKt
{
  private static final int RESUMED = 2;
  @JvmField
  @NotNull
  public static final Symbol RESUME_TOKEN = new Symbol("RESUME_TOKEN");
  private static final int SUSPENDED = 1;
  private static final int UNDECIDED = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CancellableContinuationImplKt
 * JD-Core Version:    0.7.0.1
 */