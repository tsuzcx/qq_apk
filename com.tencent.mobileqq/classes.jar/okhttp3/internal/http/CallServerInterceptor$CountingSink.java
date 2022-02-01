package okhttp3.internal.http;

import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

final class CallServerInterceptor$CountingSink
  extends ForwardingSink
{
  long successfulCount;
  
  CallServerInterceptor$CountingSink(Sink paramSink)
  {
    super(paramSink);
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    super.write(paramBuffer, paramLong);
    this.successfulCount += paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http.CallServerInterceptor.CountingSink
 * JD-Core Version:    0.7.0.1
 */