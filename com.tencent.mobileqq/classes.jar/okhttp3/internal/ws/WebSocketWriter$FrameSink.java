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
    if (!this.closed)
    {
      WebSocketWriter localWebSocketWriter = this.this$0;
      localWebSocketWriter.writeMessageFrame(this.formatOpcode, localWebSocketWriter.buffer.size(), this.isFirstFrame, true);
      this.closed = true;
      this.this$0.activeWriter = false;
      return;
    }
    throw new IOException("closed");
  }
  
  public void flush()
  {
    if (!this.closed)
    {
      WebSocketWriter localWebSocketWriter = this.this$0;
      localWebSocketWriter.writeMessageFrame(this.formatOpcode, localWebSocketWriter.buffer.size(), this.isFirstFrame, false);
      this.isFirstFrame = false;
      return;
    }
    throw new IOException("closed");
  }
  
  public Timeout timeout()
  {
    return this.this$0.sink.timeout();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (!this.closed)
    {
      this.this$0.buffer.write(paramBuffer, paramLong);
      int i;
      if ((this.isFirstFrame) && (this.contentLength != -1L) && (this.this$0.buffer.size() > this.contentLength - 8192L)) {
        i = 1;
      } else {
        i = 0;
      }
      paramLong = this.this$0.buffer.completeSegmentByteCount();
      if ((paramLong > 0L) && (i == 0))
      {
        this.this$0.writeMessageFrame(this.formatOpcode, paramLong, this.isFirstFrame, false);
        this.isFirstFrame = false;
      }
      return;
    }
    throw new IOException("closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketWriter.FrameSink
 * JD-Core Version:    0.7.0.1
 */