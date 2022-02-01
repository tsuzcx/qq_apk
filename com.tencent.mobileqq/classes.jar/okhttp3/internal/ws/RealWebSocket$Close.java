package okhttp3.internal.ws;

import okio.ByteString;

final class RealWebSocket$Close
{
  final long cancelAfterCloseMillis;
  final int code;
  final ByteString reason;
  
  RealWebSocket$Close(int paramInt, ByteString paramByteString, long paramLong)
  {
    this.code = paramInt;
    this.reason = paramByteString;
    this.cancelAfterCloseMillis = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket.Close
 * JD-Core Version:    0.7.0.1
 */