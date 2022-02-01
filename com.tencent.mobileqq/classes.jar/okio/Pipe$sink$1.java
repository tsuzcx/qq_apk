package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public final class Pipe$sink$1
  implements Sink
{
  private final Timeout timeout = new Timeout();
  
  public void close()
  {
    Object localObject1 = (Sink)null;
    synchronized (this.this$0.getBuffer$okio())
    {
      boolean bool = this.this$0.getSinkClosed$okio();
      if (bool) {
        return;
      }
      Object localObject5 = this.this$0.getFoldedSink$okio();
      if (localObject5 != null)
      {
        localObject1 = localObject5;
      }
      else
      {
        if ((this.this$0.getSourceClosed$okio()) && (this.this$0.getBuffer$okio().size() > 0L)) {
          throw ((Throwable)new IOException("source is closed"));
        }
        this.this$0.setSinkClosed$okio(true);
        localObject5 = this.this$0.getBuffer$okio();
        if (localObject5 == null) {
          break label385;
        }
        ((Object)localObject5).notifyAll();
      }
      localObject5 = Unit.INSTANCE;
      if (localObject1 != null)
      {
        ??? = this.this$0;
        localObject5 = ((Sink)localObject1).timeout();
        ??? = ((Pipe)???).sink().timeout();
        long l1 = ((Timeout)localObject5).timeoutNanos();
        ((Timeout)localObject5).timeout(Timeout.Companion.minTimeout(((Timeout)???).timeoutNanos(), ((Timeout)localObject5).timeoutNanos()), TimeUnit.NANOSECONDS);
        if (((Timeout)localObject5).hasDeadline())
        {
          long l2 = ((Timeout)localObject5).deadlineNanoTime();
          if (((Timeout)???).hasDeadline()) {
            ((Timeout)localObject5).deadlineNanoTime(Math.min(((Timeout)localObject5).deadlineNanoTime(), ((Timeout)???).deadlineNanoTime()));
          }
          try
          {
            ((Sink)localObject1).close();
            return;
          }
          finally
          {
            ((Timeout)localObject5).timeout(l1, TimeUnit.NANOSECONDS);
            if (((Timeout)???).hasDeadline()) {
              ((Timeout)localObject5).deadlineNanoTime(l2);
            }
          }
        }
        else
        {
          if (((Timeout)???).hasDeadline()) {
            ((Timeout)localObject5).deadlineNanoTime(((Timeout)???).deadlineNanoTime());
          }
          try
          {
            localObject2.close();
            return;
          }
          finally
          {
            ((Timeout)localObject5).timeout(l1, TimeUnit.NANOSECONDS);
            if (((Timeout)???).hasDeadline()) {
              ((Timeout)localObject5).clearDeadline();
            }
          }
        }
      }
      return;
      label385:
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }
  }
  
  public void flush()
  {
    Object localObject5 = (Sink)null;
    synchronized (this.this$0.getBuffer$okio())
    {
      if ((this.this$0.getSinkClosed$okio() ^ true))
      {
        Object localObject1 = this.this$0.getFoldedSink$okio();
        if (localObject1 == null)
        {
          localObject1 = localObject5;
          if (this.this$0.getSourceClosed$okio()) {
            if (this.this$0.getBuffer$okio().size() <= 0L) {
              localObject1 = localObject5;
            } else {
              throw ((Throwable)new IOException("source is closed"));
            }
          }
        }
        localObject5 = Unit.INSTANCE;
        if (localObject1 != null)
        {
          ??? = this.this$0;
          localObject5 = ((Sink)localObject1).timeout();
          ??? = ((Pipe)???).sink().timeout();
          long l1 = ((Timeout)localObject5).timeoutNanos();
          ((Timeout)localObject5).timeout(Timeout.Companion.minTimeout(((Timeout)???).timeoutNanos(), ((Timeout)localObject5).timeoutNanos()), TimeUnit.NANOSECONDS);
          if (((Timeout)localObject5).hasDeadline())
          {
            long l2 = ((Timeout)localObject5).deadlineNanoTime();
            if (((Timeout)???).hasDeadline()) {
              ((Timeout)localObject5).deadlineNanoTime(Math.min(((Timeout)localObject5).deadlineNanoTime(), ((Timeout)???).deadlineNanoTime()));
            }
            try
            {
              ((Sink)localObject1).flush();
              return;
            }
            finally
            {
              ((Timeout)localObject5).timeout(l1, TimeUnit.NANOSECONDS);
              if (((Timeout)???).hasDeadline()) {
                ((Timeout)localObject5).deadlineNanoTime(l2);
              }
            }
          }
          else
          {
            if (((Timeout)???).hasDeadline()) {
              ((Timeout)localObject5).deadlineNanoTime(((Timeout)???).deadlineNanoTime());
            }
            try
            {
              localObject2.flush();
              return;
            }
            finally
            {
              ((Timeout)localObject5).timeout(l1, TimeUnit.NANOSECONDS);
              if (((Timeout)???).hasDeadline()) {
                ((Timeout)localObject5).clearDeadline();
              }
            }
          }
        }
        return;
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    Object localObject2 = (Sink)null;
    synchronized (this.this$0.getBuffer$okio())
    {
      if ((this.this$0.getSinkClosed$okio() ^ true))
      {
        Object localObject1;
        long l1;
        for (;;)
        {
          localObject1 = localObject2;
          if (paramLong <= 0L) {
            break label191;
          }
          localObject1 = this.this$0.getFoldedSink$okio();
          if (localObject1 != null) {
            break label191;
          }
          if (this.this$0.getSourceClosed$okio()) {
            break label178;
          }
          l1 = this.this$0.getMaxBufferSize$okio() - this.this$0.getBuffer$okio().size();
          if (l1 == 0L)
          {
            this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
          }
          else
          {
            l1 = Math.min(l1, paramLong);
            this.this$0.getBuffer$okio().write(paramBuffer, l1);
            paramLong -= l1;
            localObject1 = this.this$0.getBuffer$okio();
            if (localObject1 == null) {
              break;
            }
            ((Object)localObject1).notifyAll();
          }
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        label178:
        throw ((Throwable)new IOException("source is closed"));
        label191:
        localObject2 = Unit.INSTANCE;
        if (localObject1 != null)
        {
          ??? = this.this$0;
          localObject2 = ((Sink)localObject1).timeout();
          ??? = ((Pipe)???).sink().timeout();
          l1 = ((Timeout)localObject2).timeoutNanos();
          ((Timeout)localObject2).timeout(Timeout.Companion.minTimeout(((Timeout)???).timeoutNanos(), ((Timeout)localObject2).timeoutNanos()), TimeUnit.NANOSECONDS);
          if (((Timeout)localObject2).hasDeadline())
          {
            long l2 = ((Timeout)localObject2).deadlineNanoTime();
            if (((Timeout)???).hasDeadline()) {
              ((Timeout)localObject2).deadlineNanoTime(Math.min(((Timeout)localObject2).deadlineNanoTime(), ((Timeout)???).deadlineNanoTime()));
            }
            try
            {
              ((Sink)localObject1).write(paramBuffer, paramLong);
              return;
            }
            finally
            {
              ((Timeout)localObject2).timeout(l1, TimeUnit.NANOSECONDS);
              if (((Timeout)???).hasDeadline()) {
                ((Timeout)localObject2).deadlineNanoTime(l2);
              }
            }
          }
          else
          {
            if (((Timeout)???).hasDeadline()) {
              ((Timeout)localObject2).deadlineNanoTime(((Timeout)???).deadlineNanoTime());
            }
            try
            {
              ((Sink)localObject1).write(paramBuffer, paramLong);
              return;
            }
            finally
            {
              ((Timeout)localObject2).timeout(l1, TimeUnit.NANOSECONDS);
              if (((Timeout)???).hasDeadline()) {
                ((Timeout)localObject2).clearDeadline();
              }
            }
          }
        }
        return;
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
    for (;;)
    {
      throw paramBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Pipe.sink.1
 * JD-Core Version:    0.7.0.1
 */