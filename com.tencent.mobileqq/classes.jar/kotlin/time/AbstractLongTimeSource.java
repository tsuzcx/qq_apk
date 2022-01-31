package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "LongTimeMark", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public abstract class AbstractLongTimeSource
  implements TimeSource
{
  @NotNull
  private final TimeUnit unit;
  
  public AbstractLongTimeSource(@NotNull TimeUnit paramTimeUnit)
  {
    this.unit = paramTimeUnit;
  }
  
  @NotNull
  protected final TimeUnit getUnit()
  {
    return this.unit;
  }
  
  @NotNull
  public TimeMark markNow()
  {
    return (TimeMark)new AbstractLongTimeSource.LongTimeMark(read(), this, Duration.Companion.getZERO(), null);
  }
  
  protected abstract long read();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.time.AbstractLongTimeSource
 * JD-Core Version:    0.7.0.1
 */