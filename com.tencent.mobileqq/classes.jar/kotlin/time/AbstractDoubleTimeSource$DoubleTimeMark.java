package kotlin.time;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleTimeSource;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "D", "elapsedNow", "()D", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class AbstractDoubleTimeSource$DoubleTimeMark
  extends TimeMark
{
  private final double offset;
  private final double startedAt;
  private final AbstractDoubleTimeSource timeSource;
  
  private AbstractDoubleTimeSource$DoubleTimeMark(double paramDouble1, AbstractDoubleTimeSource paramAbstractDoubleTimeSource, double paramDouble2)
  {
    this.startedAt = paramDouble1;
    this.timeSource = paramAbstractDoubleTimeSource;
    this.offset = paramDouble2;
  }
  
  public double elapsedNow()
  {
    return Duration.minus-LRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
  }
  
  @NotNull
  public TimeMark plus-LRDsOJo(double paramDouble)
  {
    return (TimeMark)new DoubleTimeMark(this.startedAt, this.timeSource, Duration.plus-LRDsOJo(this.offset, paramDouble), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.time.AbstractDoubleTimeSource.DoubleTimeMark
 * JD-Core Version:    0.7.0.1
 */