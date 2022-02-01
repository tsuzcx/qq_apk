package okhttp3.internal.http2;

import okhttp3.internal.NamedRunnable;

class Http2Connection$3
  extends NamedRunnable
{
  Http2Connection$3(Http2Connection paramHttp2Connection, String paramString, Object... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public void execute()
  {
    this.this$0.writePing(false, 2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.3
 * JD-Core Version:    0.7.0.1
 */