package okhttp3.internal.http2;

import okhttp3.internal.NamedRunnable;

final class Http2Connection$PingRunnable
  extends NamedRunnable
{
  final int payload1;
  final int payload2;
  final boolean reply;
  
  Http2Connection$PingRunnable(Http2Connection paramHttp2Connection, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super("OkHttp %s ping %08x%08x", new Object[] { paramHttp2Connection.hostname, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.reply = paramBoolean;
    this.payload1 = paramInt1;
    this.payload2 = paramInt2;
  }
  
  public void execute()
  {
    this.this$0.writePing(this.reply, this.payload1, this.payload2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.PingRunnable
 * JD-Core Version:    0.7.0.1
 */