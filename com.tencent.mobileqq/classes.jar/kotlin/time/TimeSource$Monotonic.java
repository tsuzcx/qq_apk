package kotlin.time;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "()V", "markNow", "Lkotlin/time/TimeMark;", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TimeSource$Monotonic
  implements TimeSource
{
  public static final Monotonic INSTANCE = new Monotonic();
  
  @NotNull
  public TimeMark markNow()
  {
    return this.$$delegate_0.markNow();
  }
  
  @NotNull
  public String toString()
  {
    return MonotonicTimeSource.INSTANCE.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.time.TimeSource.Monotonic
 * JD-Core Version:    0.7.0.1
 */