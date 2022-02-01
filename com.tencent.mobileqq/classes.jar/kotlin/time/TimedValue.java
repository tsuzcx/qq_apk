package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration", "()D", "D", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;D)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public final class TimedValue<T>
{
  private final double duration;
  private final T value;
  
  private TimedValue(T paramT, double paramDouble)
  {
    this.value = paramT;
    this.duration = paramDouble;
  }
  
  public final T component1()
  {
    return this.value;
  }
  
  public final double component2()
  {
    return this.duration;
  }
  
  @NotNull
  public final TimedValue<T> copy-RFiDyg4(T paramT, double paramDouble)
  {
    return new TimedValue(paramT, paramDouble);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof TimedValue))
      {
        paramObject = (TimedValue)paramObject;
        if ((!Intrinsics.areEqual(this.value, paramObject.value)) || (Double.compare(this.duration, paramObject.duration) != 0)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final double getDuration()
  {
    return this.duration;
  }
  
  public final T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = this.value;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      long l = Double.doubleToLongBits(this.duration);
      return i * 31 + (int)(l ^ l >>> 32);
    }
  }
  
  @NotNull
  public String toString()
  {
    return "TimedValue(value=" + this.value + ", duration=" + Duration.toString-impl(this.duration) + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.time.TimedValue
 * JD-Core Version:    0.7.0.1
 */