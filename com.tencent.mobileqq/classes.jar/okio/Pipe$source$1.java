package okio;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Pipe$source$1", "Lokio/Source;", "timeout", "Lokio/Timeout;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okio"}, k=1, mv={1, 1, 16})
public final class Pipe$source$1
  implements Source
{
  private final Timeout timeout = new Timeout();
  
  public void close()
  {
    synchronized (this.this$0.getBuffer$okio())
    {
      this.this$0.setSourceClosed$okio(true);
      Object localObject1 = this.this$0.getBuffer$okio();
      if (localObject1 != null)
      {
        ((Object)localObject1).notifyAll();
        localObject1 = Unit.INSTANCE;
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    synchronized (this.this$0.getBuffer$okio())
    {
      if ((this.this$0.getSourceClosed$okio() ^ true))
      {
        while (this.this$0.getBuffer$okio().size() == 0L)
        {
          boolean bool = this.this$0.getSinkClosed$okio();
          if (bool) {
            return -1L;
          }
          this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
        }
        paramLong = this.this$0.getBuffer$okio().read(paramBuffer, paramLong);
        paramBuffer = this.this$0.getBuffer$okio();
        if (paramBuffer != null)
        {
          ((Object)paramBuffer).notifyAll();
          return paramLong;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  @NotNull
  public Timeout timeout()
  {
    return this.timeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Pipe.source.1
 * JD-Core Version:    0.7.0.1
 */