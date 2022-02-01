package kotlin.time;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment", "()D", "D", "getMark", "()Lkotlin/time/TimeMark;", "elapsedNow", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalTime
final class AdjustedTimeMark
  extends TimeMark
{
  private final double adjustment;
  @NotNull
  private final TimeMark mark;
  
  private AdjustedTimeMark(TimeMark paramTimeMark, double paramDouble)
  {
    this.mark = paramTimeMark;
    this.adjustment = paramDouble;
  }
  
  public double elapsedNow()
  {
    return Duration.minus-LRDsOJo(this.mark.elapsedNow(), this.adjustment);
  }
  
  public final double getAdjustment()
  {
    return this.adjustment;
  }
  
  @NotNull
  public final TimeMark getMark()
  {
    return this.mark;
  }
  
  @NotNull
  public TimeMark plus-LRDsOJo(double paramDouble)
  {
    return (TimeMark)new AdjustedTimeMark(this.mark, Duration.plus-LRDsOJo(this.adjustment, paramDouble), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.time.AdjustedTimeMark
 * JD-Core Version:    0.7.0.1
 */