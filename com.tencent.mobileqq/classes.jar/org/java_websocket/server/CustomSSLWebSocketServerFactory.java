package org.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;

public class CustomSSLWebSocketServerFactory
  extends DefaultSSLWebSocketServerFactory
{
  private final String[] enabledCiphersuites;
  private final String[] enabledProtocols;
  
  public CustomSSLWebSocketServerFactory(SSLContext paramSSLContext, ExecutorService paramExecutorService, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    super(paramSSLContext, paramExecutorService);
    this.enabledProtocols = paramArrayOfString1;
    this.enabledCiphersuites = paramArrayOfString2;
  }
  
  public CustomSSLWebSocketServerFactory(SSLContext paramSSLContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this(paramSSLContext, Executors.newSingleThreadScheduledExecutor(), paramArrayOfString1, paramArrayOfString2);
  }
  
  public ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey)
  {
    SSLEngine localSSLEngine = this.sslcontext.createSSLEngine();
    if (this.enabledProtocols != null) {
      localSSLEngine.setEnabledProtocols(this.enabledProtocols);
    }
    if (this.enabledCiphersuites != null) {
      localSSLEngine.setEnabledCipherSuites(this.enabledCiphersuites);
    }
    localSSLEngine.setUseClientMode(false);
    return new SSLSocketChannel2(paramSocketChannel, localSSLEngine, this.exec, paramSelectionKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.server.CustomSSLWebSocketServerFactory
 * JD-Core Version:    0.7.0.1
 */