package okhttp3.internal.ws;

import java.io.Closeable;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class RealWebSocket$Streams
  implements Closeable
{
  public final boolean client;
  public final BufferedSink sink;
  public final BufferedSource source;
  
  public RealWebSocket$Streams(boolean paramBoolean, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.client = paramBoolean;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket.Streams
 * JD-Core Version:    0.7.0.1
 */