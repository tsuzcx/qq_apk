package okhttp3.internal.http2;

public abstract class Http2Connection$Listener
{
  public static final Listener REFUSE_INCOMING_STREAMS = new Http2Connection.Listener.1();
  
  public void onSettings(Http2Connection paramHttp2Connection) {}
  
  public abstract void onStream(Http2Stream paramHttp2Stream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.Listener
 * JD-Core Version:    0.7.0.1
 */