package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(D)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public final class TestTimeSource
  extends AbstractLongTimeSource
{
  private long reading;
  
  public TestTimeSource()
  {
    super(TimeUnit.NANOSECONDS);
  }
  
  private final void overflow-LRDsOJo(double paramDouble)
  {
    throw ((Throwable)new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + Duration.toString-impl(paramDouble) + '.'));
  }
  
  public final void plusAssign-LRDsOJo(double paramDouble)
  {
    double d = Duration.toDouble-impl(paramDouble, getUnit());
    long l3 = d;
    long l2;
    if ((l3 != -9223372036854775808L) && (l3 != 9223372036854775807L))
    {
      l2 = this.reading + l3;
      l1 = l2;
      if ((l3 ^ this.reading) >= 0L)
      {
        l1 = l2;
        if ((this.reading ^ l2) < 0L) {
          overflow-LRDsOJo(paramDouble);
        }
      }
    }
    for (long l1 = l2;; l1 = d)
    {
      this.reading = l1;
      return;
      d += this.reading;
      if ((d > 9223372036854775807L) || (d < -9223372036854775808L)) {
        overflow-LRDsOJo(paramDouble);
      }
    }
  }
  
  protected long read()
  {
    return this.reading;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.time.TestTimeSource
 * JD-Core Version:    0.7.0.1
 */