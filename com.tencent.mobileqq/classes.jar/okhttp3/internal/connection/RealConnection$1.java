package okhttp3.internal.connection;

import okhttp3.internal.ws.RealWebSocket.Streams;
import okio.BufferedSink;
import okio.BufferedSource;

class RealConnection$1
  extends RealWebSocket.Streams
{
  RealConnection$1(RealConnection paramRealConnection, boolean paramBoolean, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink, StreamAllocation paramStreamAllocation)
  {
    super(paramBoolean, paramBufferedSource, paramBufferedSink);
  }
  
  public void close()
  {
    this.val$streamAllocation.streamFinished(true, this.val$streamAllocation.codec(), -1L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.connection.RealConnection.1
 * JD-Core Version:    0.7.0.1
 */