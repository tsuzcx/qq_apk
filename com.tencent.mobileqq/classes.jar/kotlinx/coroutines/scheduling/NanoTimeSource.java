package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/TimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class NanoTimeSource
  extends TimeSource
{
  public static final NanoTimeSource INSTANCE = new NanoTimeSource();
  
  public long nanoTime()
  {
    return System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.NanoTimeSource
 * JD-Core Version:    0.7.0.1
 */