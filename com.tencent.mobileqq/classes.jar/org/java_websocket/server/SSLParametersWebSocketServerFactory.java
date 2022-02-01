package org.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import org.java_websocket.SSLSocketChannel2;

public class SSLParametersWebSocketServerFactory
  extends DefaultSSLWebSocketServerFactory
{
  private final SSLParameters sslParameters;
  
  public SSLParametersWebSocketServerFactory(SSLContext paramSSLContext, ExecutorService paramExecutorService, SSLParameters paramSSLParameters)
  {
    super(paramSSLContext, paramExecutorService);
    if (paramSSLParameters != null)
    {
      this.sslParameters = paramSSLParameters;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public SSLParametersWebSocketServerFactory(SSLContext paramSSLContext, SSLParameters paramSSLParameters)
  {
    this(paramSSLContext, Executors.newSingleThreadScheduledExecutor(), paramSSLParameters);
  }
  
  public ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey)
  {
    SSLEngine localSSLEngine = this.sslcontext.createSSLEngine();
    localSSLEngine.setUseClientMode(false);
    localSSLEngine.setSSLParameters(this.sslParameters);
    return new SSLSocketChannel2(paramSocketChannel, localSSLEngine, this.exec, paramSelectionKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.server.SSLParametersWebSocketServerFactory
 * JD-Core Version:    0.7.0.1
 */