package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class TickerChannelsKt
{
  @ObsoleteCoroutinesApi
  @NotNull
  public static final ReceiveChannel<Unit> ticker(long paramLong1, long paramLong2, @NotNull CoroutineContext paramCoroutineContext, @NotNull TickerMode paramTickerMode)
  {
    int j = 1;
    int i;
    if (paramLong1 >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramLong2 >= 0L) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0) {
        return ProduceKt.produce((CoroutineScope)GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(paramCoroutineContext), 0, (Function2)new TickerChannelsKt.ticker.3(paramTickerMode, paramLong1, paramLong2, null));
      }
      paramCoroutineContext = new StringBuilder();
      paramCoroutineContext.append("Expected non-negative initial delay, but has ");
      paramCoroutineContext.append(paramLong2);
      paramCoroutineContext.append(" ms");
      throw ((Throwable)new IllegalArgumentException(paramCoroutineContext.toString().toString()));
    }
    paramCoroutineContext = new StringBuilder();
    paramCoroutineContext.append("Expected non-negative delay, but has ");
    paramCoroutineContext.append(paramLong1);
    paramCoroutineContext.append(" ms");
    throw ((Throwable)new IllegalArgumentException(paramCoroutineContext.toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.TickerChannelsKt
 * JD-Core Version:    0.7.0.1
 */