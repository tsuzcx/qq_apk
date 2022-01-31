package okio;

final class Pipe$PipeSource
  implements Source
{
  final Timeout timeout = new Timeout();
  
  Pipe$PipeSource(Pipe paramPipe) {}
  
  public void close()
  {
    synchronized (this.this$0.buffer)
    {
      this.this$0.sourceClosed = true;
      this.this$0.buffer.notifyAll();
      return;
    }
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    synchronized (this.this$0.buffer)
    {
      if (this.this$0.sourceClosed) {
        throw new IllegalStateException("closed");
      }
    }
    do
    {
      this.timeout.waitUntilNotified(this.this$0.buffer);
      if (this.this$0.buffer.size() != 0L) {
        break;
      }
    } while (!this.this$0.sinkClosed);
    return -1L;
    paramLong = this.this$0.buffer.read(paramBuffer, paramLong);
    this.this$0.buffer.notifyAll();
    return paramLong;
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okio.Pipe.PipeSource
 * JD-Core Version:    0.7.0.1
 */