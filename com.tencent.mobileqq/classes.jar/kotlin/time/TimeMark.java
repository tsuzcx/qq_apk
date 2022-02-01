package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/TimeMark;", "", "()V", "elapsedNow", "Lkotlin/time/Duration;", "()D", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public abstract class TimeMark
{
  public abstract double elapsedNow();
  
  public final boolean hasNotPassedNow()
  {
    return Duration.isNegative-impl(elapsedNow());
  }
  
  public final boolean hasPassedNow()
  {
    return !Duration.isNegative-impl(elapsedNow());
  }
  
  @NotNull
  public TimeMark minus-LRDsOJo(double paramDouble)
  {
    return plus-LRDsOJo(Duration.unaryMinus-impl(paramDouble));
  }
  
  @NotNull
  public TimeMark plus-LRDsOJo(double paramDouble)
  {
    return (TimeMark)new AdjustedTimeMark(this, paramDouble, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.time.TimeMark
 * JD-Core Version:    0.7.0.1
 */