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
    }
    this.this$0.sinkClosed = true;
    this.this$0.buffer.notifyAll();
  }
  
  public void flush()
  {
    synchronized (this.this$0.buffer)
    {
      if (this.this$0.sinkClosed) {
        throw new IllegalStateException("closed");
      }
    }
    if ((this.this$0.sourceClosed) && (this.this$0.buffer.size() > 0L)) {
      throw new IOException("source is closed");
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
      if (!this.this$0.sinkClosed) {
        break label79;
      }
      throw new IllegalStateException("closed");
    }
    long l = this.this$0.maxBufferSize - this.this$0.buffer.size();
    if (l == 0L) {
      this.timeout.waitUntilNotified(this.this$0.buffer);
    }
    for (;;)
    {
      label79:
      if (paramLong <= 0L) {
        break label144;
      }
      if (!this.this$0.sourceClosed) {
        break;
      }
      throw new IOException("source is closed");
      l = Math.min(l, paramLong);
      this.this$0.buffer.write(paramBuffer, l);
      paramLong -= l;
      this.this$0.buffer.notifyAll();
    }
    label144:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okio.Pipe.PipeSink
 * JD-Core Version:    0.7.0.1
 */