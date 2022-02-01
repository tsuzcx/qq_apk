package okhttp3.internal.http2;

import java.io.IOException;
import java.net.SocketTimeoutException;
import okio.AsyncTimeout;

class Http2Stream$StreamTimeout
  extends AsyncTimeout
{
  Http2Stream$StreamTimeout(Http2Stream paramHttp2Stream) {}
  
  public void exitAndThrowIfTimedOut()
  {
    if (!exit()) {
      return;
    }
    throw newTimeoutException(null);
  }
  
  protected IOException newTimeoutException(IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause(paramIOException);
    }
    return localSocketTimeoutException;
  }
  
  protected void timedOut()
  {
    this.this$0.closeLater(ErrorCode.CANCEL);
    this.this$0.connection.sendDegradedPingLater();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream.StreamTimeout
 * JD-Core Version:    0.7.0.1
 */