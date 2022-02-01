package org.java_websocket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;

public abstract class WebSocketClient
  extends AbstractWebSocket
  implements Runnable, WebSocket
{
  private CountDownLatch closeLatch = new CountDownLatch(1);
  private CountDownLatch connectLatch = new CountDownLatch(1);
  private Thread connectReadThread;
  private int connectTimeout = 0;
  private Draft draft;
  private WebSocketImpl engine = null;
  private Map<String, String> headers;
  private OutputStream ostream;
  private Proxy proxy = Proxy.NO_PROXY;
  private Socket socket = null;
  private SocketFactory socketFactory = null;
  protected URI uri = null;
  private Thread writeThread;
  
  public WebSocketClient(URI paramURI)
  {
    this(paramURI, new Draft_6455());
  }
  
  public WebSocketClient(URI paramURI, Map<String, String> paramMap)
  {
    this(paramURI, new Draft_6455(), paramMap);
  }
  
  public WebSocketClient(URI paramURI, Draft paramDraft)
  {
    this(paramURI, paramDraft, null, 0);
  }
  
  public WebSocketClient(URI paramURI, Draft paramDraft, Map<String, String> paramMap)
  {
    this(paramURI, paramDraft, paramMap, 0);
  }
  
  public WebSocketClient(URI paramURI, Draft paramDraft, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI != null)
    {
      if (paramDraft != null)
      {
        this.uri = paramURI;
        this.draft = paramDraft;
        this.headers = paramMap;
        this.connectTimeout = paramInt;
        setTcpNoDelay(false);
        setReuseAddr(false);
        this.engine = new WebSocketImpl(this, paramDraft);
        return;
      }
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    throw new IllegalArgumentException();
  }
  
  private int getPort()
  {
    int i = this.uri.getPort();
    if (i == -1)
    {
      String str = this.uri.getScheme();
      if ("wss".equals(str)) {
        return 443;
      }
      if ("ws".equals(str)) {
        return 80;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown scheme: ");
      localStringBuilder.append(str);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return i;
  }
  
  private void handleIOException(IOException paramIOException)
  {
    if ((paramIOException instanceof SSLException)) {
      onError(paramIOException);
    }
    this.engine.eot();
  }
  
  private void reset()
  {
    Thread localThread = Thread.currentThread();
    if ((localThread != this.writeThread) && (localThread != this.connectReadThread)) {
      try
      {
        closeBlocking();
        if (this.writeThread != null)
        {
          this.writeThread.interrupt();
          this.writeThread = null;
        }
        if (this.connectReadThread != null)
        {
          this.connectReadThread.interrupt();
          this.connectReadThread = null;
        }
        this.draft.reset();
        if (this.socket != null)
        {
          this.socket.close();
          this.socket = null;
        }
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.engine = new WebSocketImpl(this, this.draft);
        return;
      }
      catch (Exception localException)
      {
        onError(localException);
        this.engine.closeConnection(1006, localException.getMessage());
        return;
      }
    }
    throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
  }
  
  private void sendHandshake()
  {
    Object localObject2 = this.uri.getRawPath();
    Object localObject3 = this.uri.getRawQuery();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "/";
    }
    localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append('?');
      ((StringBuilder)localObject2).append((String)localObject3);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    int i = getPort();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.uri.getHost());
    if ((i != 80) && (i != 443))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject1 = new HandshakeImpl1Client();
    ((HandshakeImpl1Client)localObject1).setResourceDescriptor((String)localObject2);
    ((HandshakeImpl1Client)localObject1).put("Host", (String)localObject3);
    localObject2 = this.headers;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((HandshakeImpl1Client)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    this.engine.startHandshake((ClientHandshakeBuilder)localObject1);
  }
  
  public void close()
  {
    if (this.writeThread != null) {
      this.engine.close(1000);
    }
  }
  
  public void close(int paramInt)
  {
    this.engine.close(paramInt);
  }
  
  public void close(int paramInt, String paramString)
  {
    this.engine.close(paramInt, paramString);
  }
  
  public void closeBlocking()
  {
    close();
    this.closeLatch.await();
  }
  
  public void closeConnection(int paramInt, String paramString)
  {
    this.engine.closeConnection(paramInt, paramString);
  }
  
  public void connect()
  {
    if (this.connectReadThread == null)
    {
      this.connectReadThread = new Thread(this);
      Thread localThread = this.connectReadThread;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebSocketConnectReadThread-");
      localStringBuilder.append(this.connectReadThread.getId());
      localThread.setName(localStringBuilder.toString());
      this.connectReadThread.start();
      return;
    }
    throw new IllegalStateException("WebSocketClient objects are not reuseable");
  }
  
  public boolean connectBlocking()
  {
    connect();
    this.connectLatch.await();
    return this.engine.isOpen();
  }
  
  public boolean connectBlocking(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    return (this.connectLatch.await(paramLong, paramTimeUnit)) && (this.engine.isOpen());
  }
  
  public <T> T getAttachment()
  {
    return this.engine.getAttachment();
  }
  
  public WebSocket getConnection()
  {
    return this.engine;
  }
  
  protected Collection<WebSocket> getConnections()
  {
    return Collections.singletonList(this.engine);
  }
  
  public Draft getDraft()
  {
    return this.draft;
  }
  
  public InetSocketAddress getLocalSocketAddress()
  {
    return this.engine.getLocalSocketAddress();
  }
  
  public InetSocketAddress getLocalSocketAddress(WebSocket paramWebSocket)
  {
    paramWebSocket = this.socket;
    if (paramWebSocket != null) {
      return (InetSocketAddress)paramWebSocket.getLocalSocketAddress();
    }
    return null;
  }
  
  public ReadyState getReadyState()
  {
    return this.engine.getReadyState();
  }
  
  public InetSocketAddress getRemoteSocketAddress()
  {
    return this.engine.getRemoteSocketAddress();
  }
  
  public InetSocketAddress getRemoteSocketAddress(WebSocket paramWebSocket)
  {
    paramWebSocket = this.socket;
    if (paramWebSocket != null) {
      return (InetSocketAddress)paramWebSocket.getRemoteSocketAddress();
    }
    return null;
  }
  
  public String getResourceDescriptor()
  {
    return this.uri.getPath();
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  public URI getURI()
  {
    return this.uri;
  }
  
  public boolean hasBufferedData()
  {
    return this.engine.hasBufferedData();
  }
  
  public boolean isClosed()
  {
    return this.engine.isClosed();
  }
  
  public boolean isClosing()
  {
    return this.engine.isClosing();
  }
  
  public boolean isFlushAndClose()
  {
    return this.engine.isFlushAndClose();
  }
  
  public boolean isOpen()
  {
    return this.engine.isOpen();
  }
  
  public abstract void onClose(int paramInt, String paramString, boolean paramBoolean);
  
  public void onCloseInitiated(int paramInt, String paramString) {}
  
  public void onClosing(int paramInt, String paramString, boolean paramBoolean) {}
  
  public abstract void onError(Exception paramException);
  
  public abstract void onMessage(String paramString);
  
  public void onMessage(ByteBuffer paramByteBuffer) {}
  
  public abstract void onOpen(ServerHandshake paramServerHandshake);
  
  public final void onWebsocketClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    stopConnectionLostTimer();
    paramWebSocket = this.writeThread;
    if (paramWebSocket != null) {
      paramWebSocket.interrupt();
    }
    onClose(paramInt, paramString, paramBoolean);
    this.connectLatch.countDown();
    this.closeLatch.countDown();
  }
  
  public void onWebsocketCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    onCloseInitiated(paramInt, paramString);
  }
  
  public void onWebsocketClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    onClosing(paramInt, paramString, paramBoolean);
  }
  
  public final void onWebsocketError(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramException);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, String paramString)
  {
    onMessage(paramString);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer)
  {
    onMessage(paramByteBuffer);
  }
  
  public final void onWebsocketOpen(WebSocket paramWebSocket, Handshakedata paramHandshakedata)
  {
    startConnectionLostTimer();
    onOpen((ServerHandshake)paramHandshakedata);
    this.connectLatch.countDown();
  }
  
  public final void onWriteDemand(WebSocket paramWebSocket) {}
  
  public void reconnect()
  {
    reset();
    connect();
  }
  
  public boolean reconnectBlocking()
  {
    reset();
    return connectBlocking();
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.socketFactory != null)
        {
          this.socket = this.socketFactory.createSocket();
        }
        else
        {
          if (this.socket == null)
          {
            this.socket = new Socket(this.proxy);
            i = 1;
          }
          else
          {
            if (this.socket.isClosed()) {
              continue;
            }
            break label355;
          }
          this.socket.setTcpNoDelay(isTcpNoDelay());
          this.socket.setReuseAddress(isReuseAddr());
          if (!this.socket.isBound()) {
            this.socket.connect(new InetSocketAddress(this.uri.getHost(), getPort()), this.connectTimeout);
          }
          if ((i != 0) && ("wss".equals(this.uri.getScheme())))
          {
            localObject = SSLContext.getInstance("TLSv1.2");
            ((SSLContext)localObject).init(null, null, null);
            this.socket = ((SSLContext)localObject).getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
          }
          Object localObject = this.socket.getInputStream();
          this.ostream = this.socket.getOutputStream();
          sendHandshake();
          this.writeThread = new Thread(new WebSocketClient.WebsocketWriteThread(this, this));
          this.writeThread.start();
          byte[] arrayOfByte = new byte[16384];
          try
          {
            if ((!isClosing()) && (!isClosed()))
            {
              i = ((InputStream)localObject).read(arrayOfByte);
              if (i != -1)
              {
                this.engine.decode(ByteBuffer.wrap(arrayOfByte, 0, i));
                continue;
              }
            }
            this.engine.eot();
          }
          catch (RuntimeException localRuntimeException)
          {
            onError(localRuntimeException);
            this.engine.closeConnection(1006, localRuntimeException.getMessage());
          }
          catch (IOException localIOException)
          {
            handleIOException(localIOException);
          }
          this.connectReadThread = null;
          return;
          throw new IOException();
        }
      }
      catch (Exception localException)
      {
        onWebsocketError(this.engine, localException);
        this.engine.closeConnection(-1, localException.getMessage());
        return;
      }
      label355:
      int i = 0;
    }
  }
  
  public void send(String paramString)
  {
    this.engine.send(paramString);
  }
  
  public void send(ByteBuffer paramByteBuffer)
  {
    this.engine.send(paramByteBuffer);
  }
  
  public void send(byte[] paramArrayOfByte)
  {
    this.engine.send(paramArrayOfByte);
  }
  
  public void sendFragmentedFrame(Opcode paramOpcode, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this.engine.sendFragmentedFrame(paramOpcode, paramByteBuffer, paramBoolean);
  }
  
  public void sendFrame(Collection<Framedata> paramCollection)
  {
    this.engine.sendFrame(paramCollection);
  }
  
  public void sendFrame(Framedata paramFramedata)
  {
    this.engine.sendFrame(paramFramedata);
  }
  
  public void sendPing()
  {
    this.engine.sendPing();
  }
  
  public <T> void setAttachment(T paramT)
  {
    this.engine.setAttachment(paramT);
  }
  
  public void setProxy(Proxy paramProxy)
  {
    if (paramProxy != null)
    {
      this.proxy = paramProxy;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Deprecated
  public void setSocket(Socket paramSocket)
  {
    if (this.socket == null)
    {
      this.socket = paramSocket;
      return;
    }
    throw new IllegalStateException("socket has already been set");
  }
  
  public void setSocketFactory(SocketFactory paramSocketFactory)
  {
    this.socketFactory = paramSocketFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.client.WebSocketClient
 * JD-Core Version:    0.7.0.1
 */