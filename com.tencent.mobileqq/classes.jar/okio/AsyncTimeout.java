package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, k=1, mv={1, 1, 16})
public class AsyncTimeout
  extends Timeout
{
  public static final AsyncTimeout.Companion Companion = new AsyncTimeout.Companion(null);
  private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
  private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
  private static final int TIMEOUT_WRITE_SIZE = 65536;
  private static AsyncTimeout head;
  private boolean inQueue;
  private AsyncTimeout next;
  private long timeoutAt;
  
  private final long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }
  
  @PublishedApi
  @NotNull
  public final IOException access$newTimeoutException(@Nullable IOException paramIOException)
  {
    return newTimeoutException(paramIOException);
  }
  
  public final void enter()
  {
    if ((this.inQueue ^ true))
    {
      long l = timeoutNanos();
      boolean bool = hasDeadline();
      if ((l == 0L) && (!bool)) {
        return;
      }
      this.inQueue = true;
      AsyncTimeout.Companion.access$scheduleTimeout(Companion, this, l, bool);
      return;
    }
    throw ((Throwable)new IllegalStateException("Unbalanced enter/exit".toString()));
  }
  
  public final boolean exit()
  {
    if (!this.inQueue) {
      return false;
    }
    this.inQueue = false;
    return AsyncTimeout.Companion.access$cancelScheduledTimeout(Companion, this);
  }
  
  @NotNull
  protected IOException newTimeoutException(@Nullable IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause((Throwable)paramIOException);
    }
    return (IOException)localInterruptedIOException;
  }
  
  @NotNull
  public final Sink sink(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    return (Sink)new AsyncTimeout.sink.1(this, paramSink);
  }
  
  @NotNull
  public final Source source(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    return (Source)new AsyncTimeout.source.1(this, paramSource);
  }
  
  protected void timedOut() {}
  
  /* Error */
  public final <T> T withTimeout(@NotNull kotlin.jvm.functions.Function0<? extends T> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 187
    //   3: invokestatic 170	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokevirtual 189	okio/AsyncTimeout:enter	()V
    //   10: aload_1
    //   11: invokeinterface 195 1 0
    //   16: astore_1
    //   17: iconst_1
    //   18: invokestatic 201	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   21: aload_0
    //   22: invokevirtual 203	okio/AsyncTimeout:exit	()Z
    //   25: ifne +9 -> 34
    //   28: iconst_1
    //   29: invokestatic 206	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   32: aload_1
    //   33: areturn
    //   34: aload_0
    //   35: aconst_null
    //   36: invokevirtual 208	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   39: checkcast 147	java/lang/Throwable
    //   42: athrow
    //   43: astore_1
    //   44: goto +30 -> 74
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 203	okio/AsyncTimeout:exit	()Z
    //   52: ifne +11 -> 63
    //   55: aload_1
    //   56: checkcast 147	java/lang/Throwable
    //   59: astore_1
    //   60: goto +12 -> 72
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 208	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   68: astore_1
    //   69: goto -14 -> 55
    //   72: aload_1
    //   73: athrow
    //   74: iconst_1
    //   75: invokestatic 201	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   78: aload_0
    //   79: invokevirtual 203	okio/AsyncTimeout:exit	()Z
    //   82: pop
    //   83: iconst_1
    //   84: invokestatic 206	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   87: goto +5 -> 92
    //   90: aload_1
    //   91: athrow
    //   92: goto -2 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	AsyncTimeout
    //   0	95	1	paramFunction0	kotlin.jvm.functions.Function0<? extends T>
    // Exception table:
    //   from	to	target	type
    //   10	17	43	finally
    //   48	55	43	finally
    //   55	60	43	finally
    //   63	69	43	finally
    //   72	74	43	finally
    //   10	17	47	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.AsyncTimeout
 * JD-Core Version:    0.7.0.1
 */