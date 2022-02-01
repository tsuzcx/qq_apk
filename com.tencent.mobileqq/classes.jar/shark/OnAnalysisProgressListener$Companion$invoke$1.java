package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/OnAnalysisProgressListener$Companion$invoke$1", "Lshark/OnAnalysisProgressListener;", "onAnalysisProgress", "", "step", "Lshark/OnAnalysisProgressListener$Step;", "shark"}, k=1, mv={1, 4, 1})
public final class OnAnalysisProgressListener$Companion$invoke$1
  implements OnAnalysisProgressListener
{
  public void a(@NotNull OnAnalysisProgressListener.Step paramStep)
  {
    Intrinsics.checkParameterIsNotNull(paramStep, "step");
    this.a.invoke(paramStep);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.OnAnalysisProgressListener.Companion.invoke.1
 * JD-Core Version:    0.7.0.1
 */