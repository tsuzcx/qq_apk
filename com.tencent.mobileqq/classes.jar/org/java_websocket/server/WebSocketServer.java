package org.java_websocket.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.SocketChannelIOHelper;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketServerFactory;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WebSocketServer
  extends AbstractWebSocket
  implements Runnable
{
  private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
  private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
  private final InetSocketAddress address;
  private BlockingQueue<ByteBuffer> buffers;
  private final Collection<WebSocket> connections;
  protected List<WebSocketServer.WebSocketWorker> decoders;
  private List<Draft> drafts;
  private List<WebSocketImpl> iqueue;
  private final AtomicBoolean isclosed = new AtomicBoolean(false);
  private int queueinvokes = 0;
  private final AtomicInteger queuesize = new AtomicInteger(0);
  private Selector selector;
  private Thread selectorthread;
  private ServerSocketChannel server;
  private WebSocketServerFactory wsf = new DefaultWebSocketServerFactory();
  
  public WebSocketServer()
  {
    this(new InetSocketAddress(80), AVAILABLE_PROCESSORS, null);
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress)
  {
    this(paramInetSocketAddress, AVAILABLE_PROCESSORS, null);
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    this(paramInetSocketAddress, paramInt, null);
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt, List<Draft> paramList)
  {
    this(paramInetSocketAddress, paramInt, paramList, new HashSet());
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt, List<Draft> paramList, Collection<WebSocket> paramCollection)
  {
    if ((paramInetSocketAddress == null) || (paramInt < 1) || (paramCollection == null)) {
      throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
    }
    if (paramList == null) {}
    for (this.drafts = Collections.emptyList();; this.drafts = paramList)
    {
      this.address = paramInetSocketAddress;
      this.connections = paramCollection;
      setTcpNoDelay(false);
      setReuseAddr(false);
      this.iqueue = new LinkedList();
      this.decoders = new ArrayList(paramInt);
      this.buffers = new LinkedBlockingQueue();
      while (i < paramInt)
      {
        paramInetSocketAddress = new WebSocketServer.WebSocketWorker(this);
        this.decoders.add(paramInetSocketAddress);
        i += 1;
      }
    }
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, List<Draft> paramList)
  {
    this(paramInetSocketAddress, AVAILABLE_PROCESSORS, paramList);
  }
  
  private void doAccept(SelectionKey paramSelectionKey, Iterator<SelectionKey> paramIterator)
  {
    if (!onConnect(paramSelectionKey)) {
      paramSelectionKey.cancel();
    }
    do
    {
      return;
      paramSelectionKey = this.server.accept();
    } while (paramSelectionKey == null);
    paramSelectionKey.configureBlocking(false);
    Object localObject = paramSelectionKey.socket();
    ((Socket)localObject).setTcpNoDelay(isTcpNoDelay());
    ((Socket)localObject).setKeepAlive(true);
    localObject = this.wsf.createWebSocket(this, this.drafts);
    ((WebSocketImpl)localObject).setSelectionKey(paramSelectionKey.register(this.selector, 1, localObject));
    try
    {
      ((WebSocketImpl)localObject).setChannel(this.wsf.wrapChannel(paramSelectionKey, ((WebSocketImpl)localObject).getSelectionKey()));
      paramIterator.remove();
      allocateBuffers((WebSocket)localObject);
      return;
    }
    catch (IOException paramSelectionKey)
    {
      if (((WebSocketImpl)localObject).getSelectionKey() != null) {
        ((WebSocketImpl)localObject).getSelectionKey().cancel();
      }
      handleIOException(((WebSocketImpl)localObject).getSelectionKey(), null, paramSelectionKey);
    }
  }
  
  private void doAdditionalRead()
  {
    while (!this.iqueue.isEmpty())
    {
      WebSocketImpl localWebSocketImpl = (WebSocketImpl)this.iqueue.remove(0);
      WrappedByteChannel localWrappedByteChannel = (WrappedByteChannel)localWebSocketImpl.getChannel();
      ByteBuffer localByteBuffer = takeBuffer();
      try
      {
        if (SocketChannelIOHelper.readMore(localByteBuffer, localWebSocketImpl, localWrappedByteChannel)) {
          this.iqueue.add(localWebSocketImpl);
        }
        if (localByteBuffer.hasRemaining())
        {
          localWebSocketImpl.inQueue.put(localByteBuffer);
          queue(localWebSocketImpl);
        }
      }
      catch (IOException localIOException)
      {
        pushBuffer(localByteBuffer);
        throw localIOException;
      }
      pushBuffer(localByteBuffer);
    }
  }
  
  private void doBroadcast(Object paramObject, Collection<WebSocket> paramCollection)
  {
    if ((paramObject instanceof String)) {}
    for (String str = (String)paramObject;; str = null)
    {
      if ((paramObject instanceof ByteBuffer)) {}
      for (paramObject = (ByteBuffer)paramObject;; paramObject = null)
      {
        if ((str == null) && (paramObject == null)) {}
        for (;;)
        {
          return;
          HashMap localHashMap = new HashMap();
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext())
          {
            WebSocket localWebSocket = (WebSocket)paramCollection.next();
            if (localWebSocket != null)
            {
              Draft localDraft = localWebSocket.getDraft();
              fillFrames(localDraft, localHashMap, str, paramObject);
              try
              {
                localWebSocket.sendFrame((Collection)localHashMap.get(localDraft));
              }
              catch (WebsocketNotConnectedException localWebsocketNotConnectedException) {}
            }
          }
        }
      }
    }
  }
  
  private boolean doEnsureSingleThread()
  {
    try
    {
      if (this.selectorthread != null) {
        throw new IllegalStateException(getClass().getName() + " can only be started once.");
      }
    }
    finally {}
    this.selectorthread = Thread.currentThread();
    return !this.isclosed.get();
  }
  
  private boolean doRead(SelectionKey paramSelectionKey, Iterator<SelectionKey> paramIterator)
  {
    WebSocketImpl localWebSocketImpl = (WebSocketImpl)paramSelectionKey.attachment();
    ByteBuffer localByteBuffer = takeBuffer();
    if (localWebSocketImpl.getChannel() == null)
    {
      paramSelectionKey.cancel();
      handleIOException(paramSelectionKey, localWebSocketImpl, new IOException());
      return false;
    }
    try
    {
      if (SocketChannelIOHelper.read(localByteBuffer, localWebSocketImpl, localWebSocketImpl.getChannel())) {
        if (localByteBuffer.hasRemaining())
        {
          localWebSocketImpl.inQueue.put(localByteBuffer);
          queue(localWebSocketImpl);
          paramIterator.remove();
          if (((localWebSocketImpl.getChannel() instanceof WrappedByteChannel)) && (((WrappedByteChannel)localWebSocketImpl.getChannel()).isNeedRead())) {
            this.iqueue.add(localWebSocketImpl);
          }
        }
        else
        {
          pushBuffer(localByteBuffer);
        }
      }
    }
    catch (IOException paramSelectionKey)
    {
      pushBuffer(localByteBuffer);
      throw paramSelectionKey;
    }
    pushBuffer(localByteBuffer);
    return true;
  }
  
  private void doServerShutdown()
  {
    stopConnectionLostTimer();
    if (this.decoders != null)
    {
      Iterator localIterator = this.decoders.iterator();
      while (localIterator.hasNext()) {
        ((WebSocketServer.WebSocketWorker)localIterator.next()).interrupt();
      }
    }
    if (this.selector != null) {}
    try
    {
      this.selector.close();
      if (this.server == null) {}
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          this.server.close();
          return;
        }
        catch (IOException localIOException2)
        {
          log.error("IOException during server.close", localIOException2);
          onError(null, localIOException2);
        }
        localIOException1 = localIOException1;
        log.error("IOException during selector.close", localIOException1);
        onError(null, localIOException1);
      }
    }
  }
  
  private boolean doSetupSelectorAndServerThread()
  {
    this.selectorthread.setName("WebSocketSelector-" + this.selectorthread.getId());
    try
    {
      this.server = ServerSocketChannel.open();
      this.server.configureBlocking(false);
      Object localObject = this.server.socket();
      ((ServerSocket)localObject).setReceiveBufferSize(16384);
      ((ServerSocket)localObject).setReuseAddress(isReuseAddr());
      ((ServerSocket)localObject).bind(this.address);
      this.selector = Selector.open();
      this.server.register(this.selector, this.server.validOps());
      startConnectionLostTimer();
      localObject = this.decoders.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WebSocketServer.WebSocketWorker)((Iterator)localObject).next()).start();
      }
      onStart();
    }
    catch (IOException localIOException)
    {
      handleFatal(null, localIOException);
      return false;
    }
    return true;
  }
  
  private void doWrite(SelectionKey paramSelectionKey)
  {
    WebSocketImpl localWebSocketImpl = (WebSocketImpl)paramSelectionKey.attachment();
    if ((SocketChannelIOHelper.batch(localWebSocketImpl, localWebSocketImpl.getChannel())) && (paramSelectionKey.isValid())) {
      paramSelectionKey.interestOps(1);
    }
  }
  
  private void fillFrames(Draft paramDraft, Map<Draft, List<Framedata>> paramMap, String paramString, ByteBuffer paramByteBuffer)
  {
    if (!paramMap.containsKey(paramDraft))
    {
      List localList = null;
      if (paramString != null) {
        localList = paramDraft.createFrames(paramString, false);
      }
      if (paramByteBuffer != null) {
        localList = paramDraft.createFrames(paramByteBuffer, false);
      }
      if (localList != null) {
        paramMap.put(paramDraft, localList);
      }
    }
  }
  
  private Socket getSocket(WebSocket paramWebSocket)
  {
    return ((SocketChannel)((WebSocketImpl)paramWebSocket).getSelectionKey().channel()).socket();
  }
  
  private void handleFatal(WebSocket paramWebSocket, Exception paramException)
  {
    log.error("Shutdown due to fatal error", paramException);
    onError(paramWebSocket, paramException);
    if (this.decoders != null)
    {
      paramWebSocket = this.decoders.iterator();
      while (paramWebSocket.hasNext()) {
        ((WebSocketServer.WebSocketWorker)paramWebSocket.next()).interrupt();
      }
    }
    if (this.selectorthread != null) {
      this.selectorthread.interrupt();
    }
    try
    {
      stop();
      return;
    }
    catch (IOException paramWebSocket)
    {
      log.error("Error during shutdown", paramWebSocket);
      onError(null, paramWebSocket);
      return;
    }
    catch (InterruptedException paramWebSocket)
    {
      Thread.currentThread().interrupt();
      log.error("Interrupt during stop", paramException);
      onError(null, paramWebSocket);
    }
  }
  
  private void handleIOException(SelectionKey paramSelectionKey, WebSocket paramWebSocket, IOException paramIOException)
  {
    if (paramWebSocket != null) {
      paramWebSocket.closeConnection(1006, paramIOException.getMessage());
    }
    do
    {
      do
      {
        return;
      } while (paramSelectionKey == null);
      paramSelectionKey = paramSelectionKey.channel();
    } while ((paramSelectionKey == null) || (!paramSelectionKey.isOpen()));
    try
    {
      paramSelectionKey.close();
      label42:
      log.trace("Connection closed because of exception", paramIOException);
      return;
    }
    catch (IOException paramSelectionKey)
    {
      break label42;
    }
  }
  
  private void pushBuffer(ByteBuffer paramByteBuffer)
  {
    if (this.buffers.size() > this.queuesize.intValue()) {
      return;
    }
    this.buffers.put(paramByteBuffer);
  }
  
  private ByteBuffer takeBuffer()
  {
    return (ByteBuffer)this.buffers.take();
  }
  
  protected boolean addConnection(WebSocket paramWebSocket)
  {
    if (!this.isclosed.get()) {
      synchronized (this.connections)
      {
        boolean bool = this.connections.add(paramWebSocket);
        return bool;
      }
    }
    paramWebSocket.close(1001);
    return true;
  }
  
  protected void allocateBuffers(WebSocket paramWebSocket)
  {
    if (this.queuesize.get() >= this.decoders.size() * 2 + 1) {
      return;
    }
    this.queuesize.incrementAndGet();
    this.buffers.put(createBuffer());
  }
  
  public void broadcast(String paramString)
  {
    broadcast(paramString, this.connections);
  }
  
  public void broadcast(String paramString, Collection<WebSocket> paramCollection)
  {
    if ((paramString == null) || (paramCollection == null)) {
      throw new IllegalArgumentException();
    }
    doBroadcast(paramString, paramCollection);
  }
  
  public void broadcast(ByteBuffer paramByteBuffer)
  {
    broadcast(paramByteBuffer, this.connections);
  }
  
  public void broadcast(ByteBuffer paramByteBuffer, Collection<WebSocket> paramCollection)
  {
    if ((paramByteBuffer == null) || (paramCollection == null)) {
      throw new IllegalArgumentException();
    }
    doBroadcast(paramByteBuffer, paramCollection);
  }
  
  public void broadcast(byte[] paramArrayOfByte)
  {
    broadcast(paramArrayOfByte, this.connections);
  }
  
  public void broadcast(byte[] paramArrayOfByte, Collection<WebSocket> paramCollection)
  {
    if ((paramArrayOfByte == null) || (paramCollection == null)) {
      throw new IllegalArgumentException();
    }
    broadcast(ByteBuffer.wrap(paramArrayOfByte), paramCollection);
  }
  
  public ByteBuffer createBuffer()
  {
    return ByteBuffer.allocate(16384);
  }
  
  public InetSocketAddress getAddress()
  {
    return this.address;
  }
  
  public Collection<WebSocket> getConnections()
  {
    return Collections.unmodifiableCollection(new ArrayList(this.connections));
  }
  
  public List<Draft> getDraft()
  {
    return Collections.unmodifiableList(this.drafts);
  }
  
  public InetSocketAddress getLocalSocketAddress(WebSocket paramWebSocket)
  {
    return (InetSocketAddress)getSocket(paramWebSocket).getLocalSocketAddress();
  }
  
  public int getPort()
  {
    int j = getAddress().getPort();
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.server != null) {
        i = this.server.socket().getLocalPort();
      }
    }
    return i;
  }
  
  public InetSocketAddress getRemoteSocketAddress(WebSocket paramWebSocket)
  {
    return (InetSocketAddress)getSocket(paramWebSocket).getRemoteSocketAddress();
  }
  
  public final WebSocketFactory getWebSocketFactory()
  {
    return this.wsf;
  }
  
  public abstract void onClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean);
  
  public void onCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString) {}
  
  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean) {}
  
  protected boolean onConnect(SelectionKey paramSelectionKey)
  {
    return true;
  }
  
  public abstract void onError(WebSocket paramWebSocket, Exception paramException);
  
  public abstract void onMessage(WebSocket paramWebSocket, String paramString);
  
  public void onMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer) {}
  
  public abstract void onOpen(WebSocket paramWebSocket, ClientHandshake paramClientHandshake);
  
  public abstract void onStart();
  
  public final void onWebsocketClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    this.selector.wakeup();
    try
    {
      if (removeConnection(paramWebSocket)) {
        onClose(paramWebSocket, paramInt, paramString, paramBoolean);
      }
      try
      {
        releaseBuffers(paramWebSocket);
        return;
      }
      catch (InterruptedException paramWebSocket)
      {
        Thread.currentThread().interrupt();
        return;
      }
      try
      {
        releaseBuffers(paramWebSocket);
        throw paramString;
      }
      catch (InterruptedException paramWebSocket)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
    finally {}
  }
  
  public void onWebsocketCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    onCloseInitiated(paramWebSocket, paramInt, paramString);
  }
  
  public void onWebsocketClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    onClosing(paramWebSocket, paramInt, paramString, paramBoolean);
  }
  
  public final void onWebsocketError(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramWebSocket, paramException);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, String paramString)
  {
    onMessage(paramWebSocket, paramString);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer)
  {
    onMessage(paramWebSocket, paramByteBuffer);
  }
  
  public final void onWebsocketOpen(WebSocket paramWebSocket, Handshakedata paramHandshakedata)
  {
    if (addConnection(paramWebSocket)) {
      onOpen(paramWebSocket, (ClientHandshake)paramHandshakedata);
    }
  }
  
  public final void onWriteDemand(WebSocket paramWebSocket)
  {
    paramWebSocket = (WebSocketImpl)paramWebSocket;
    try
    {
      paramWebSocket.getSelectionKey().interestOps(5);
      this.selector.wakeup();
      return;
    }
    catch (CancelledKeyException localCancelledKeyException)
    {
      for (;;)
      {
        paramWebSocket.outQueue.clear();
      }
    }
  }
  
  protected void queue(WebSocketImpl paramWebSocketImpl)
  {
    if (paramWebSocketImpl.getWorkerThread() == null)
    {
      paramWebSocketImpl.setWorkerThread((WebSocketServer.WebSocketWorker)this.decoders.get(this.queueinvokes % this.decoders.size()));
      this.queueinvokes += 1;
    }
    paramWebSocketImpl.getWorkerThread().put(paramWebSocketImpl);
  }
  
  protected void releaseBuffers(WebSocket paramWebSocket) {}
  
  protected boolean removeConnection(WebSocket paramWebSocket)
  {
    boolean bool = false;
    synchronized (this.connections)
    {
      if (this.connections.contains(paramWebSocket))
      {
        bool = this.connections.remove(paramWebSocket);
        if ((this.isclosed.get()) && (this.connections.isEmpty())) {
          this.selectorthread.interrupt();
        }
        return bool;
      }
      log.trace("Removing connection which is not in the connections collection! Possible no handshake recieved! {}", paramWebSocket);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 700	org/java_websocket/server/WebSocketServer:doEnsureSingleThread	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokespecial 702	org/java_websocket/server/WebSocketServer:doSetupSelectorAndServerThread	()Z
    //   12: ifeq -5 -> 7
    //   15: iconst_0
    //   16: istore_1
    //   17: iconst_5
    //   18: istore_3
    //   19: aload_0
    //   20: getfield 341	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   23: invokevirtual 705	java/lang/Thread:isInterrupted	()Z
    //   26: istore 10
    //   28: iload 10
    //   30: ifne +462 -> 492
    //   33: iload_3
    //   34: ifeq +458 -> 492
    //   37: iload_1
    //   38: istore_2
    //   39: iload_1
    //   40: istore 6
    //   42: iload_3
    //   43: istore 4
    //   45: iload_1
    //   46: istore 7
    //   48: iload_3
    //   49: istore 5
    //   51: iload_1
    //   52: istore 9
    //   54: iload_3
    //   55: istore 8
    //   57: aload_0
    //   58: getfield 89	org/java_websocket/server/WebSocketServer:isclosed	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   61: invokevirtual 376	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   64: ifeq +5 -> 69
    //   67: iconst_5
    //   68: istore_2
    //   69: iload_3
    //   70: istore_1
    //   71: iload_2
    //   72: istore 6
    //   74: iload_3
    //   75: istore 4
    //   77: iload_2
    //   78: istore 7
    //   80: iload_3
    //   81: istore 5
    //   83: iload_2
    //   84: istore 9
    //   86: iload_3
    //   87: istore 8
    //   89: aload_0
    //   90: getfield 218	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   93: iload_2
    //   94: i2l
    //   95: invokevirtual 709	java/nio/channels/Selector:select	(J)I
    //   98: ifne +37 -> 135
    //   101: iload_3
    //   102: istore_1
    //   103: iload_2
    //   104: istore 6
    //   106: iload_3
    //   107: istore 4
    //   109: iload_2
    //   110: istore 7
    //   112: iload_3
    //   113: istore 5
    //   115: iload_2
    //   116: istore 9
    //   118: iload_3
    //   119: istore 8
    //   121: aload_0
    //   122: getfield 89	org/java_websocket/server/WebSocketServer:isclosed	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   125: invokevirtual 376	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   128: ifeq +7 -> 135
    //   131: iload_3
    //   132: iconst_1
    //   133: isub
    //   134: istore_1
    //   135: iload_2
    //   136: istore 6
    //   138: iload_1
    //   139: istore 4
    //   141: iload_2
    //   142: istore 7
    //   144: iload_1
    //   145: istore 5
    //   147: iload_2
    //   148: istore 9
    //   150: iload_1
    //   151: istore 8
    //   153: aload_0
    //   154: getfield 218	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   157: invokevirtual 713	java/nio/channels/Selector:selectedKeys	()Ljava/util/Set;
    //   160: invokeinterface 716 1 0
    //   165: astore 13
    //   167: aconst_null
    //   168: astore 11
    //   170: iload_2
    //   171: istore 7
    //   173: iload_1
    //   174: istore 5
    //   176: iload_2
    //   177: istore 9
    //   179: iload_1
    //   180: istore 8
    //   182: aload 13
    //   184: invokeinterface 313 1 0
    //   189: ifeq +196 -> 385
    //   192: iload_2
    //   193: istore 7
    //   195: iload_1
    //   196: istore 5
    //   198: iload_2
    //   199: istore 9
    //   201: iload_1
    //   202: istore 8
    //   204: aload 13
    //   206: invokeinterface 317 1 0
    //   211: checkcast 179	java/nio/channels/SelectionKey
    //   214: astore 12
    //   216: iload_2
    //   217: istore 7
    //   219: iload_1
    //   220: istore 5
    //   222: iload_2
    //   223: istore 9
    //   225: iload_1
    //   226: istore 8
    //   228: aload 12
    //   230: invokevirtual 479	java/nio/channels/SelectionKey:isValid	()Z
    //   233: ifne +10 -> 243
    //   236: aload 12
    //   238: astore 11
    //   240: goto -70 -> 170
    //   243: iload_2
    //   244: istore 7
    //   246: iload_1
    //   247: istore 5
    //   249: iload_2
    //   250: istore 9
    //   252: iload_1
    //   253: istore 8
    //   255: aload 12
    //   257: invokevirtual 719	java/nio/channels/SelectionKey:isAcceptable	()Z
    //   260: ifeq +30 -> 290
    //   263: iload_2
    //   264: istore 7
    //   266: iload_1
    //   267: istore 5
    //   269: iload_2
    //   270: istore 9
    //   272: iload_1
    //   273: istore 8
    //   275: aload_0
    //   276: aload 12
    //   278: aload 13
    //   280: invokespecial 721	org/java_websocket/server/WebSocketServer:doAccept	(Ljava/nio/channels/SelectionKey;Ljava/util/Iterator;)V
    //   283: aload 12
    //   285: astore 11
    //   287: goto -117 -> 170
    //   290: iload_2
    //   291: istore 7
    //   293: iload_1
    //   294: istore 5
    //   296: iload_2
    //   297: istore 9
    //   299: iload_1
    //   300: istore 8
    //   302: aload 12
    //   304: invokevirtual 724	java/nio/channels/SelectionKey:isReadable	()Z
    //   307: ifeq +33 -> 340
    //   310: iload_2
    //   311: istore 7
    //   313: iload_1
    //   314: istore 5
    //   316: iload_2
    //   317: istore 9
    //   319: iload_1
    //   320: istore 8
    //   322: aload_0
    //   323: aload 12
    //   325: aload 13
    //   327: invokespecial 726	org/java_websocket/server/WebSocketServer:doRead	(Ljava/nio/channels/SelectionKey;Ljava/util/Iterator;)Z
    //   330: ifne +10 -> 340
    //   333: aload 12
    //   335: astore 11
    //   337: goto -167 -> 170
    //   340: iload_2
    //   341: istore 7
    //   343: iload_1
    //   344: istore 5
    //   346: iload_2
    //   347: istore 9
    //   349: iload_1
    //   350: istore 8
    //   352: aload 12
    //   354: invokevirtual 729	java/nio/channels/SelectionKey:isWritable	()Z
    //   357: ifeq +181 -> 538
    //   360: iload_2
    //   361: istore 7
    //   363: iload_1
    //   364: istore 5
    //   366: iload_2
    //   367: istore 9
    //   369: iload_1
    //   370: istore 8
    //   372: aload_0
    //   373: aload 12
    //   375: invokespecial 731	org/java_websocket/server/WebSocketServer:doWrite	(Ljava/nio/channels/SelectionKey;)V
    //   378: aload 12
    //   380: astore 11
    //   382: goto -212 -> 170
    //   385: iload_2
    //   386: istore 7
    //   388: iload_1
    //   389: istore 5
    //   391: iload_2
    //   392: istore 9
    //   394: iload_1
    //   395: istore 8
    //   397: aload_0
    //   398: invokespecial 733	org/java_websocket/server/WebSocketServer:doAdditionalRead	()V
    //   401: iload_2
    //   402: istore_3
    //   403: iload_1
    //   404: istore_2
    //   405: iload_3
    //   406: istore_1
    //   407: iload_2
    //   408: istore_3
    //   409: goto -390 -> 19
    //   412: astore 11
    //   414: aload_0
    //   415: invokespecial 735	org/java_websocket/server/WebSocketServer:doServerShutdown	()V
    //   418: return
    //   419: astore 11
    //   421: aconst_null
    //   422: astore 12
    //   424: iload 6
    //   426: istore_1
    //   427: iload 4
    //   429: istore_2
    //   430: aload 12
    //   432: ifnull +8 -> 440
    //   435: aload 12
    //   437: invokevirtual 182	java/nio/channels/SelectionKey:cancel	()V
    //   440: aload_0
    //   441: aload 12
    //   443: aconst_null
    //   444: aload 11
    //   446: invokespecial 253	org/java_websocket/server/WebSocketServer:handleIOException	(Ljava/nio/channels/SelectionKey;Lorg/java_websocket/WebSocket;Ljava/io/IOException;)V
    //   449: goto -42 -> 407
    //   452: astore 11
    //   454: aload_0
    //   455: aconst_null
    //   456: aload 11
    //   458: invokespecial 163	org/java_websocket/server/WebSocketServer:handleFatal	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   461: aload_0
    //   462: invokespecial 735	org/java_websocket/server/WebSocketServer:doServerShutdown	()V
    //   465: return
    //   466: astore 11
    //   468: iload 7
    //   470: istore_1
    //   471: iload 5
    //   473: istore_2
    //   474: invokestatic 374	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   477: invokevirtual 510	java/lang/Thread:interrupt	()V
    //   480: goto -73 -> 407
    //   483: astore 11
    //   485: aload_0
    //   486: invokespecial 735	org/java_websocket/server/WebSocketServer:doServerShutdown	()V
    //   489: aload 11
    //   491: athrow
    //   492: aload_0
    //   493: invokespecial 735	org/java_websocket/server/WebSocketServer:doServerShutdown	()V
    //   496: return
    //   497: astore 13
    //   499: aload 11
    //   501: astore 12
    //   503: iload_1
    //   504: istore_3
    //   505: aload 13
    //   507: astore 11
    //   509: iload_2
    //   510: istore_1
    //   511: iload_3
    //   512: istore_2
    //   513: goto -83 -> 430
    //   516: astore 11
    //   518: iload_1
    //   519: istore_3
    //   520: iload_2
    //   521: istore_1
    //   522: iload_3
    //   523: istore_2
    //   524: goto -94 -> 430
    //   527: astore 11
    //   529: iload 9
    //   531: istore_1
    //   532: iload 8
    //   534: istore_2
    //   535: goto -128 -> 407
    //   538: aload 12
    //   540: astore 11
    //   542: goto -372 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	WebSocketServer
    //   16	516	1	i	int
    //   38	497	2	j	int
    //   18	505	3	k	int
    //   43	385	4	m	int
    //   49	423	5	n	int
    //   40	385	6	i1	int
    //   46	423	7	i2	int
    //   55	478	8	i3	int
    //   52	478	9	i4	int
    //   26	3	10	bool	boolean
    //   168	213	11	localObject1	Object
    //   412	1	11	localClosedByInterruptException	java.nio.channels.ClosedByInterruptException
    //   419	26	11	localIOException1	IOException
    //   452	5	11	localRuntimeException	java.lang.RuntimeException
    //   466	1	11	localInterruptedException	InterruptedException
    //   483	17	11	localObject2	Object
    //   507	1	11	localIOException2	IOException
    //   516	1	11	localIOException3	IOException
    //   527	1	11	localCancelledKeyException	CancelledKeyException
    //   540	1	11	localObject3	Object
    //   214	325	12	localObject4	Object
    //   165	161	13	localIterator	Iterator
    //   497	9	13	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   57	67	412	java/nio/channels/ClosedByInterruptException
    //   89	101	412	java/nio/channels/ClosedByInterruptException
    //   121	131	412	java/nio/channels/ClosedByInterruptException
    //   153	167	412	java/nio/channels/ClosedByInterruptException
    //   182	192	412	java/nio/channels/ClosedByInterruptException
    //   204	216	412	java/nio/channels/ClosedByInterruptException
    //   228	236	412	java/nio/channels/ClosedByInterruptException
    //   255	263	412	java/nio/channels/ClosedByInterruptException
    //   275	283	412	java/nio/channels/ClosedByInterruptException
    //   302	310	412	java/nio/channels/ClosedByInterruptException
    //   322	333	412	java/nio/channels/ClosedByInterruptException
    //   352	360	412	java/nio/channels/ClosedByInterruptException
    //   372	378	412	java/nio/channels/ClosedByInterruptException
    //   397	401	412	java/nio/channels/ClosedByInterruptException
    //   57	67	419	java/io/IOException
    //   89	101	419	java/io/IOException
    //   121	131	419	java/io/IOException
    //   153	167	419	java/io/IOException
    //   19	28	452	java/lang/RuntimeException
    //   57	67	452	java/lang/RuntimeException
    //   89	101	452	java/lang/RuntimeException
    //   121	131	452	java/lang/RuntimeException
    //   153	167	452	java/lang/RuntimeException
    //   182	192	452	java/lang/RuntimeException
    //   204	216	452	java/lang/RuntimeException
    //   228	236	452	java/lang/RuntimeException
    //   255	263	452	java/lang/RuntimeException
    //   275	283	452	java/lang/RuntimeException
    //   302	310	452	java/lang/RuntimeException
    //   322	333	452	java/lang/RuntimeException
    //   352	360	452	java/lang/RuntimeException
    //   372	378	452	java/lang/RuntimeException
    //   397	401	452	java/lang/RuntimeException
    //   435	440	452	java/lang/RuntimeException
    //   440	449	452	java/lang/RuntimeException
    //   474	480	452	java/lang/RuntimeException
    //   57	67	466	java/lang/InterruptedException
    //   89	101	466	java/lang/InterruptedException
    //   121	131	466	java/lang/InterruptedException
    //   153	167	466	java/lang/InterruptedException
    //   182	192	466	java/lang/InterruptedException
    //   204	216	466	java/lang/InterruptedException
    //   228	236	466	java/lang/InterruptedException
    //   255	263	466	java/lang/InterruptedException
    //   275	283	466	java/lang/InterruptedException
    //   302	310	466	java/lang/InterruptedException
    //   322	333	466	java/lang/InterruptedException
    //   352	360	466	java/lang/InterruptedException
    //   372	378	466	java/lang/InterruptedException
    //   397	401	466	java/lang/InterruptedException
    //   19	28	483	finally
    //   57	67	483	finally
    //   89	101	483	finally
    //   121	131	483	finally
    //   153	167	483	finally
    //   182	192	483	finally
    //   204	216	483	finally
    //   228	236	483	finally
    //   255	263	483	finally
    //   275	283	483	finally
    //   302	310	483	finally
    //   322	333	483	finally
    //   352	360	483	finally
    //   372	378	483	finally
    //   397	401	483	finally
    //   435	440	483	finally
    //   440	449	483	finally
    //   454	461	483	finally
    //   474	480	483	finally
    //   182	192	497	java/io/IOException
    //   204	216	497	java/io/IOException
    //   397	401	497	java/io/IOException
    //   228	236	516	java/io/IOException
    //   255	263	516	java/io/IOException
    //   275	283	516	java/io/IOException
    //   302	310	516	java/io/IOException
    //   322	333	516	java/io/IOException
    //   352	360	516	java/io/IOException
    //   372	378	516	java/io/IOException
    //   57	67	527	java/nio/channels/CancelledKeyException
    //   89	101	527	java/nio/channels/CancelledKeyException
    //   121	131	527	java/nio/channels/CancelledKeyException
    //   153	167	527	java/nio/channels/CancelledKeyException
    //   182	192	527	java/nio/channels/CancelledKeyException
    //   204	216	527	java/nio/channels/CancelledKeyException
    //   228	236	527	java/nio/channels/CancelledKeyException
    //   255	263	527	java/nio/channels/CancelledKeyException
    //   275	283	527	java/nio/channels/CancelledKeyException
    //   302	310	527	java/nio/channels/CancelledKeyException
    //   322	333	527	java/nio/channels/CancelledKeyException
    //   352	360	527	java/nio/channels/CancelledKeyException
    //   372	378	527	java/nio/channels/CancelledKeyException
    //   397	401	527	java/nio/channels/CancelledKeyException
  }
  
  public final void setWebSocketFactory(WebSocketServerFactory paramWebSocketServerFactory)
  {
    if (this.wsf != null) {
      this.wsf.close();
    }
    this.wsf = paramWebSocketServerFactory;
  }
  
  public void start()
  {
    if (this.selectorthread != null) {
      throw new IllegalStateException(getClass().getName() + " can only be started once.");
    }
    new Thread(this).start();
  }
  
  public void stop()
  {
    stop(0);
  }
  
  public void stop(int paramInt)
  {
    if (!this.isclosed.compareAndSet(false, true)) {
      return;
    }
    synchronized (this.connections)
    {
      ArrayList localArrayList = new ArrayList(this.connections);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((WebSocket)((Iterator)???).next()).close(1001);
      }
    }
    this.wsf.close();
    try
    {
      if ((this.selectorthread != null) && (this.selector != null))
      {
        this.selector.wakeup();
        this.selectorthread.join(paramInt);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.server.WebSocketServer
 * JD-Core Version:    0.7.0.1
 */