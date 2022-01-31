package kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="TimersKt")
public final class TimersKt
{
  @InlineOnly
  private static final Timer fixedRateTimer(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramString = timer(paramString, paramBoolean);
    paramString.scheduleAtFixedRate((TimerTask)new TimersKt.timerTask.1(paramFunction1), paramLong1, paramLong2);
    return paramString;
  }
  
  @InlineOnly
  private static final Timer fixedRateTimer(String paramString, boolean paramBoolean, Date paramDate, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramString = timer(paramString, paramBoolean);
    paramString.scheduleAtFixedRate((TimerTask)new TimersKt.timerTask.1(paramFunction1), paramDate, paramLong);
    return paramString;
  }
  
  @InlineOnly
  private static final TimerTask schedule(@NotNull Timer paramTimer, long paramLong1, long paramLong2, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimersKt.timerTask.1(paramFunction1);
    paramTimer.schedule(paramFunction1, paramLong1, paramLong2);
    return paramFunction1;
  }
  
  @InlineOnly
  private static final TimerTask schedule(@NotNull Timer paramTimer, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimersKt.timerTask.1(paramFunction1);
    paramTimer.schedule(paramFunction1, paramLong);
    return paramFunction1;
  }
  
  @InlineOnly
  private static final TimerTask schedule(@NotNull Timer paramTimer, Date paramDate, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimersKt.timerTask.1(paramFunction1);
    paramTimer.schedule(paramFunction1, paramDate, paramLong);
    return paramFunction1;
  }
  
  @InlineOnly
  private static final TimerTask schedule(@NotNull Timer paramTimer, Date paramDate, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimersKt.timerTask.1(paramFunction1);
    paramTimer.schedule(paramFunction1, paramDate);
    return paramFunction1;
  }
  
  @InlineOnly
  private static final TimerTask scheduleAtFixedRate(@NotNull Timer paramTimer, long paramLong1, long paramLong2, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimersKt.timerTask.1(paramFunction1);
    paramTimer.scheduleAtFixedRate(paramFunction1, paramLong1, paramLong2);
    return paramFunction1;
  }
  
  @InlineOnly
  private static final TimerTask scheduleAtFixedRate(@NotNull Timer paramTimer, Date paramDate, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimersKt.timerTask.1(paramFunction1);
    paramTimer.scheduleAtFixedRate(paramFunction1, paramDate, paramLong);
    return paramFunction1;
  }
  
  @PublishedApi
  @NotNull
  public static final Timer timer(@Nullable String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return new Timer(paramBoolean);
    }
    return new Timer(paramString, paramBoolean);
  }
  
  @InlineOnly
  private static final Timer timer(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramString = timer(paramString, paramBoolean);
    paramString.schedule((TimerTask)new TimersKt.timerTask.1(paramFunction1), paramLong1, paramLong2);
    return paramString;
  }
  
  @InlineOnly
  private static final Timer timer(String paramString, boolean paramBoolean, Date paramDate, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramString = timer(paramString, paramBoolean);
    paramString.schedule((TimerTask)new TimersKt.timerTask.1(paramFunction1), paramDate, paramLong);
    return paramString;
  }
  
  @InlineOnly
  private static final TimerTask timerTask(Function1<? super TimerTask, Unit> paramFunction1)
  {
    return (TimerTask)new TimersKt.timerTask.1(paramFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.concurrent.TimersKt
 * JD-Core Version:    0.7.0.1
 */