package okio;

import java.io.IOException;

final class Pipe$PipeSink
  implements Sink
{
  final Timeout timeout = new Timeout();
  
  Pipe$PipeSink(Pipe paramPipe) {}
  
  public void close()
  {
    synchronized (this.this$0.buffer)
    {
      if (this.this$0.sinkClosed) {
        return;
      }
      if ((this.this$0.sourceClosed) && (this.this$0.buffer.size() > 0L)) {
        throw new IOException("source is closed");
      }
      this.this$0.sinkClosed = true;
      this.this$0.buffer.notifyAll();
      return;
    }
  }
  
  public void flush()
  {
    synchronized (this.this$0.buffer)
    {
      if (!this.this$0.sinkClosed)
      {
        if ((this.this$0.sourceClosed) && (this.this$0.buffer.size() > 0L)) {
          throw new IOException("source is closed");
        }
        return;
      }
      throw new IllegalStateException("closed");
    }
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    synchronized (this.this$0.buffer)
    {
      if (!this.this$0.sinkClosed)
      {
        while (paramLong > 0L) {
          if (!this.this$0.sourceClosed)
          {
            long l = this.this$0.maxBufferSize - this.this$0.buffer.size();
            if (l == 0L)
            {
              this.timeout.waitUntilNotified(this.this$0.buffer);
            }
            else
            {
              l = Math.min(l, paramLong);
              this.this$0.buffer.write(paramBuffer, l);
              paramLong -= l;
              this.this$0.buffer.notifyAll();
            }
          }
          else
          {
            throw new IOException("source is closed");
          }
        }
        return;
      }
      throw new IllegalStateException("closed");
    }
    for (;;)
    {
      throw paramBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Pipe.PipeSink
 * JD-Core Version:    0.7.0.1
 */