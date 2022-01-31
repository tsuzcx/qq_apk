package okhttp3.internal.http2;

import java.net.InetSocketAddress;
import java.net.Socket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class Http2Connection$Builder
{
  boolean client;
  String hostname;
  Http2Connection.Listener listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
  int pingIntervalMillis;
  PushObserver pushObserver = PushObserver.CANCEL;
  BufferedSink sink;
  Socket socket;
  BufferedSource source;
  
  public Http2Connection$Builder(boolean paramBoolean)
  {
    this.client = paramBoolean;
  }
  
  public Http2Connection build()
  {
    return new Http2Connection(this);
  }
  
  public Builder listener(Http2Connection.Listener paramListener)
  {
    this.listener = paramListener;
    return this;
  }
  
  public Builder pingIntervalMillis(int paramInt)
  {
    this.pingIntervalMillis = paramInt;
    return this;
  }
  
  public Builder pushObserver(PushObserver paramPushObserver)
  {
    this.pushObserver = paramPushObserver;
    return this;
  }
  
  public Builder socket(Socket paramSocket)
  {
    return socket(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(paramSocket)), Okio.buffer(Okio.sink(paramSocket)));
  }
  
  public Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.socket = paramSocket;
    this.hostname = paramString;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.Builder
 * JD-Core Version:    0.7.0.1
 */