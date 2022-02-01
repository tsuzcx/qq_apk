package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"storageUnit", "Ljava/util/concurrent/TimeUnit;", "storageUnit$annotations", "()V", "getStorageUnit", "()Ljava/util/concurrent/TimeUnit;", "days", "Lkotlin/time/Duration;", "", "days$annotations", "(D)V", "getDays", "(D)D", "", "(I)V", "(I)D", "", "(J)V", "(J)D", "hours", "hours$annotations", "getHours", "microseconds", "microseconds$annotations", "getMicroseconds", "milliseconds", "milliseconds$annotations", "getMilliseconds", "minutes", "minutes$annotations", "getMinutes", "nanoseconds", "nanoseconds$annotations", "getNanoseconds", "seconds", "seconds$annotations", "getSeconds", "times", "duration", "times-kIfJnKk", "(DD)D", "times-mvk6XK0", "(ID)D", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLjava/util/concurrent/TimeUnit;)D", "(ILjava/util/concurrent/TimeUnit;)D", "(JLjava/util/concurrent/TimeUnit;)D", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class DurationKt
{
  public static final double getDays(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.DAYS);
  }
  
  public static final double getDays(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.DAYS);
  }
  
  public static final double getDays(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.DAYS);
  }
  
  public static final double getHours(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.HOURS);
  }
  
  public static final double getHours(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.HOURS);
  }
  
  public static final double getHours(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.HOURS);
  }
  
  public static final double getMicroseconds(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.MICROSECONDS);
  }
  
  public static final double getMicroseconds(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.MICROSECONDS);
  }
  
  public static final double getMicroseconds(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.MICROSECONDS);
  }
  
  public static final double getMilliseconds(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.MILLISECONDS);
  }
  
  public static final double getMilliseconds(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public static final double getMilliseconds(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.MILLISECONDS);
  }
  
  public static final double getMinutes(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.MINUTES);
  }
  
  public static final double getMinutes(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.MINUTES);
  }
  
  public static final double getMinutes(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.MINUTES);
  }
  
  public static final double getNanoseconds(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.NANOSECONDS);
  }
  
  public static final double getNanoseconds(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.NANOSECONDS);
  }
  
  public static final double getNanoseconds(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.NANOSECONDS);
  }
  
  public static final double getSeconds(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.SECONDS);
  }
  
  public static final double getSeconds(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.SECONDS);
  }
  
  public static final double getSeconds(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.SECONDS);
  }
  
  private static final TimeUnit getStorageUnit()
  {
    return TimeUnit.NANOSECONDS;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  @ExperimentalTime
  private static final double times-kIfJnKk(double paramDouble1, double paramDouble2)
  {
    return Duration.times-impl(paramDouble2, paramDouble1);
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  @ExperimentalTime
  private static final double times-mvk6XK0(int paramInt, double paramDouble)
  {
    return Duration.times-impl(paramDouble, paramInt);
  }
  
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  public static final double toDuration(double paramDouble, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return Duration.constructor-impl(DurationUnitKt.convertDurationUnit(paramDouble, paramTimeUnit, TimeUnit.NANOSECONDS));
  }
  
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  public static final double toDuration(int paramInt, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return toDuration(paramInt, paramTimeUnit);
  }
  
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  public static final double toDuration(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return toDuration(paramLong, paramTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.time.DurationKt
 * JD-Core Version:    0.7.0.1
 */