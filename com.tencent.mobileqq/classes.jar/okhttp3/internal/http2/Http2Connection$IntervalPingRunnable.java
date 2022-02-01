package okhttp3.internal.http2;

import okhttp3.internal.NamedRunnable;

final class Http2Connection$IntervalPingRunnable
  extends NamedRunnable
{
  Http2Connection$IntervalPingRunnable(Http2Connection paramHttp2Connection)
  {
    super("OkHttp %s ping", new Object[] { paramHttp2Connection.hostname });
  }
  
  public void execute()
  {
    synchronized (this.this$0)
    {
      int i;
      if (Http2Connection.access$100(this.this$0) < Http2Connection.access$200(this.this$0))
      {
        i = 1;
        if (i != 0) {
          Http2Connection.access$000(this.this$0);
        }
      }
      else
      {
        Http2Connection.access$208(this.this$0);
        i = 0;
      }
    }
    this.this$0.writePing(false, 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.IntervalPingRunnable
 * JD-Core Version:    0.7.0.1
 */