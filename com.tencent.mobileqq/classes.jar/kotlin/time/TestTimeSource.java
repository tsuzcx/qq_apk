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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TestTimeSource will overflow if its reading ");
    localStringBuilder.append(this.reading);
    localStringBuilder.append("ns is advanced by ");
    localStringBuilder.append(Duration.toString-impl(paramDouble));
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
  
  public final void plusAssign-LRDsOJo(double paramDouble)
  {
    double d1 = Duration.toDouble-impl(paramDouble, getUnit());
    long l3 = d1;
    long l1;
    if ((l3 != -9223372036854775808L) && (l3 != 9223372036854775807L))
    {
      long l4 = this.reading;
      long l2 = l4 + l3;
      l1 = l2;
      if ((l3 ^ l4) >= 0L)
      {
        l1 = l2;
        if ((l4 ^ l2) < 0L)
        {
          overflow-LRDsOJo(paramDouble);
          l1 = l2;
        }
      }
    }
    else
    {
      double d2 = this.reading;
      Double.isNaN(d2);
      d1 = d2 + d1;
      if ((d1 > 9223372036854775807L) || (d1 < -9223372036854775808L)) {
        overflow-LRDsOJo(paramDouble);
      }
      l1 = d1;
    }
    this.reading = l1;
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