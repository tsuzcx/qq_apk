package okhttp3.internal.http2;

import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class Http2Stream$FramingSink
  implements Sink
{
  private static final long EMIT_BUFFER_SIZE = 16384L;
  boolean closed;
  boolean finished;
  private final Buffer sendBuffer = new Buffer();
  
  Http2Stream$FramingSink(Http2Stream paramHttp2Stream) {}
  
  private void emitFrame(boolean paramBoolean)
  {
    label236:
    synchronized (this.this$0)
    {
      this.this$0.writeTimeout.enter();
      try
      {
        while ((this.this$0.bytesLeftInWriteWindow <= 0L) && (!this.finished) && (!this.closed) && (this.this$0.errorCode == null)) {
          this.this$0.waitForIo();
        }
        this.this$0.writeTimeout.exitAndThrowIfTimedOut();
        this.this$0.checkOutNotClosed();
        long l = Math.min(this.this$0.bytesLeftInWriteWindow, this.sendBuffer.size());
        Http2Stream localHttp2Stream = this.this$0;
        localHttp2Stream.bytesLeftInWriteWindow -= l;
        this.this$0.writeTimeout.enter();
        try
        {
          ??? = this.this$0.connection;
          int i = this.this$0.id;
          if ((!paramBoolean) || (l != this.sendBuffer.size())) {
            break label236;
          }
          paramBoolean = true;
          ((Http2Connection)???).writeData(i, paramBoolean, this.sendBuffer, l);
          return;
        }
        finally
        {
          this.this$0.writeTimeout.exitAndThrowIfTimedOut();
        }
        localObject4 = finally;
      }
      finally
      {
        this.this$0.writeTimeout.exitAndThrowIfTimedOut();
      }
    }
  }
  
  public void close()
  {
    synchronized (this.this$0)
    {
      if (this.closed) {
        return;
      }
      if (!this.this$0.sink.finished)
      {
        if (this.sendBuffer.size() > 0L) {
          while (this.sendBuffer.size() > 0L) {
            emitFrame(true);
          }
        }
        this.this$0.connection.writeData(this.this$0.id, true, null, 0L);
      }
      synchronized (this.this$0)
      {
        this.closed = true;
        this.this$0.connection.flush();
        this.this$0.cancelStreamIfNecessary();
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void flush()
  {
    synchronized (this.this$0)
    {
      this.this$0.checkOutNotClosed();
      while (this.sendBuffer.size() > 0L)
      {
        emitFrame(false);
        this.this$0.connection.flush();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public Timeout timeout()
  {
    return this.this$0.writeTimeout;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    this.sendBuffer.write(paramBuffer, paramLong);
    while (this.sendBuffer.size() >= 16384L) {
      emitFrame(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream.FramingSink
 * JD-Core Version:    0.7.0.1
 */