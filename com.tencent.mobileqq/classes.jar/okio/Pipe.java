package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "", "getSinkClosed$okio", "()Z", "setSinkClosed$okio", "(Z)V", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "fold", "", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"}, k=1, mv={1, 1, 16})
public final class Pipe
{
  @NotNull
  private final Buffer buffer;
  @Nullable
  private Sink foldedSink;
  private final long maxBufferSize;
  @NotNull
  private final Sink sink;
  private boolean sinkClosed;
  @NotNull
  private final Source source;
  private boolean sourceClosed;
  
  public Pipe(long paramLong)
  {
    this.maxBufferSize = paramLong;
    this.buffer = new Buffer();
    int i;
    if (this.maxBufferSize >= 1L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.sink = ((Sink)new Pipe.sink.1(this));
      this.source = ((Source)new Pipe.source.1(this));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxBufferSize < 1: ");
    localStringBuilder.append(this.maxBufferSize);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  private final void forward(@NotNull Sink paramSink, Function1<? super Sink, Unit> paramFunction1)
  {
    Timeout localTimeout1 = paramSink.timeout();
    Timeout localTimeout2 = sink().timeout();
    long l1 = localTimeout1.timeoutNanos();
    localTimeout1.timeout(Timeout.Companion.minTimeout(localTimeout2.timeoutNanos(), localTimeout1.timeoutNanos()), TimeUnit.NANOSECONDS);
    if (localTimeout1.hasDeadline())
    {
      long l2 = localTimeout1.deadlineNanoTime();
      if (localTimeout2.hasDeadline()) {
        localTimeout1.deadlineNanoTime(Math.min(localTimeout1.deadlineNanoTime(), localTimeout2.deadlineNanoTime()));
      }
      try
      {
        paramFunction1.invoke(paramSink);
        return;
      }
      finally
      {
        InlineMarker.finallyStart(1);
        localTimeout1.timeout(l1, TimeUnit.NANOSECONDS);
        if (localTimeout2.hasDeadline()) {
          localTimeout1.deadlineNanoTime(l2);
        }
        InlineMarker.finallyEnd(1);
      }
    }
    if (localTimeout2.hasDeadline()) {
      localTimeout1.deadlineNanoTime(localTimeout2.deadlineNanoTime());
    }
    try
    {
      paramFunction1.invoke(paramSink);
      return;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      localTimeout1.timeout(l1, TimeUnit.NANOSECONDS);
      if (localTimeout2.hasDeadline()) {
        localTimeout1.clearDeadline();
      }
      InlineMarker.finallyEnd(1);
    }
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="sink", imports={}))
  @JvmName(name="-deprecated_sink")
  @NotNull
  public final Sink -deprecated_sink()
  {
    return this.sink;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="source", imports={}))
  @JvmName(name="-deprecated_source")
  @NotNull
  public final Source -deprecated_source()
  {
    return this.source;
  }
  
  public final void fold(@NotNull Sink arg1)
  {
    Intrinsics.checkParameterIsNotNull(???, "sink");
    int i;
    label217:
    label245:
    synchronized (this.buffer)
    {
      for (;;)
      {
        if (this.foldedSink != null) {
          break label245;
        }
        i = 1;
        if (i == 0) {
          break label217;
        }
        if (this.buffer.exhausted())
        {
          this.sourceClosed = true;
          this.foldedSink = ???;
          return;
        }
        boolean bool = this.sinkClosed;
        Object localObject3 = new Buffer();
        ((Buffer)localObject3).write(this.buffer, this.buffer.size());
        Object localObject4 = this.buffer;
        if (localObject4 != null)
        {
          ((Object)localObject4).notifyAll();
          localObject4 = Unit.INSTANCE;
          try
          {
            ???.write((Buffer)localObject3, ((Buffer)localObject3).size());
            if (bool) {
              ???.close();
            } else {
              ???.flush();
            }
          }
          finally
          {
            synchronized (this.buffer)
            {
              this.sourceClosed = true;
              localObject3 = this.buffer;
              if (localObject3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
              }
              ((Object)localObject3).notifyAll();
              localObject3 = Unit.INSTANCE;
              throw localObject1;
            }
          }
        }
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
      throw ((Throwable)new IllegalStateException("sink already folded".toString()));
    }
  }
  
  @NotNull
  public final Buffer getBuffer$okio()
  {
    return this.buffer;
  }
  
  @Nullable
  public final Sink getFoldedSink$okio()
  {
    return this.foldedSink;
  }
  
  public final long getMaxBufferSize$okio()
  {
    return this.maxBufferSize;
  }
  
  public final boolean getSinkClosed$okio()
  {
    return this.sinkClosed;
  }
  
  public final boolean getSourceClosed$okio()
  {
    return this.sourceClosed;
  }
  
  public final void setFoldedSink$okio(@Nullable Sink paramSink)
  {
    this.foldedSink = paramSink;
  }
  
  public final void setSinkClosed$okio(boolean paramBoolean)
  {
    this.sinkClosed = paramBoolean;
  }
  
  public final void setSourceClosed$okio(boolean paramBoolean)
  {
    this.sourceClosed = paramBoolean;
  }
  
  @JvmName(name="sink")
  @NotNull
  public final Sink sink()
  {
    return this.sink;
  }
  
  @JvmName(name="source")
  @NotNull
  public final Source source()
  {
    return this.source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Pipe
 * JD-Core Version:    0.7.0.1
 */