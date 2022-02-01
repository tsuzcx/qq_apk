package kotlin.time;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "D", "elapsedNow", "()D", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class AbstractLongTimeSource$LongTimeMark
  extends TimeMark
{
  private final double offset;
  private final long startedAt;
  private final AbstractLongTimeSource timeSource;
  
  private AbstractLongTimeSource$LongTimeMark(long paramLong, AbstractLongTimeSource paramAbstractLongTimeSource, double paramDouble)
  {
    this.startedAt = paramLong;
    this.timeSource = paramAbstractLongTimeSource;
    this.offset = paramDouble;
  }
  
  public double elapsedNow()
  {
    return Duration.minus-LRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
  }
  
  @NotNull
  public TimeMark plus-LRDsOJo(double paramDouble)
  {
    return (TimeMark)new LongTimeMark(this.startedAt, this.timeSource, Duration.plus-LRDsOJo(this.offset, paramDouble), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.time.AbstractLongTimeSource.LongTimeMark
 * JD-Core Version:    0.7.0.1
 */