package okhttp3.internal.ws;

import okio.ByteString;

final class RealWebSocket$Message
{
  final ByteString data;
  final int formatOpcode;
  
  RealWebSocket$Message(int paramInt, ByteString paramByteString)
  {
    this.formatOpcode = paramInt;
    this.data = paramByteString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket.Message
 * JD-Core Version:    0.7.0.1
 */