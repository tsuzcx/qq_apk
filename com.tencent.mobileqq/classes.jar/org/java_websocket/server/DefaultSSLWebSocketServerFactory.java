package org.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketServerFactory;
import org.java_websocket.drafts.Draft;

public class DefaultSSLWebSocketServerFactory
  implements WebSocketServerFactory
{
  protected ExecutorService exec;
  protected SSLContext sslcontext;
  
  public DefaultSSLWebSocketServerFactory(SSLContext paramSSLContext)
  {
    this(paramSSLContext, Executors.newSingleThreadScheduledExecutor());
  }
  
  public DefaultSSLWebSocketServerFactory(SSLContext paramSSLContext, ExecutorService paramExecutorService)
  {
    if ((paramSSLContext == null) || (paramExecutorService == null)) {
      throw new IllegalArgumentException();
    }
    this.sslcontext = paramSSLContext;
    this.exec = paramExecutorService;
  }
  
  public void close()
  {
    this.exec.shutdown();
  }
  
  public WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, List<Draft> paramList)
  {
    return new WebSocketImpl(paramWebSocketAdapter, paramList);
  }
  
  public WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, Draft paramDraft)
  {
    return new WebSocketImpl(paramWebSocketAdapter, paramDraft);
  }
  
  public ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey)
  {
    SSLEngine localSSLEngine = this.sslcontext.createSSLEngine();
    ArrayList localArrayList = new ArrayList(Arrays.asList(localSSLEngine.getEnabledCipherSuites()));
    localArrayList.remove("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
    localSSLEngine.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
    localSSLEngine.setUseClientMode(false);
    return new SSLSocketChannel2(paramSocketChannel, localSSLEngine, this.exec, paramSelectionKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.server.DefaultSSLWebSocketServerFactory
 * JD-Core Version:    0.7.0.1
 */