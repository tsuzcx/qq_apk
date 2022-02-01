package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/OnAnalysisProgressListener;", "", "onAnalysisProgress", "", "step", "Lshark/OnAnalysisProgressListener$Step;", "Companion", "Step", "shark"}, k=1, mv={1, 4, 1})
public abstract interface OnAnalysisProgressListener
{
  @NotNull
  public static final OnAnalysisProgressListener.Companion b = OnAnalysisProgressListener.Companion.a;
  
  public abstract void a(@NotNull OnAnalysisProgressListener.Step paramStep);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.OnAnalysisProgressListener
 * JD-Core Version:    0.7.0.1
 */