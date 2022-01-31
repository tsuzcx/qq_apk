package okhttp3.internal.ws;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter$FrameSink
  implements Sink
{
  boolean closed;
  long contentLength;
  int formatOpcode;
  boolean isFirstFrame;
  
  WebSocketWriter$FrameSink(WebSocketWriter paramWebSocketWriter) {}
  
  public void close()
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    this.this$0.writeMessageFrame(this.formatOpcode, this.this$0.buffer.size(), this.isFirstFrame, true);
    this.closed = true;
    this.this$0.activeWriter = false;
  }
  
  public void flush()
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    this.this$0.writeMessageFrame(this.formatOpcode, this.this$0.buffer.size(), this.isFirstFrame, false);
    this.isFirstFrame = false;
  }
  
  public Timeout timeout()
  {
    return this.this$0.sink.timeout();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    this.this$0.buffer.write(paramBuffer, paramLong);
    if ((this.isFirstFrame) && (this.contentLength != -1L) && (this.this$0.buffer.size() > this.contentLength - 8192L)) {}
    for (int i = 1;; i = 0)
    {
      paramLong = this.this$0.buffer.completeSegmentByteCount();
      if ((paramLong > 0L) && (i == 0))
      {
        this.this$0.writeMessageFrame(this.formatOpcode, paramLong, this.isFirstFrame, false);
        this.isFirstFrame = false;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketWriter.FrameSink
 * JD-Core Version:    0.7.0.1
 */