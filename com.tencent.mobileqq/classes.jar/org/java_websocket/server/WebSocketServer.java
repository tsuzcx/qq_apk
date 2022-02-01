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
  private final AtomicBoolean isclosed;
  private int queueinvokes;
  private final AtomicInteger queuesize;
  private Selector selector;
  private Thread selectorthread;
  private ServerSocketChannel server;
  private WebSocketServerFactory wsf;
  
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
    int i = 0;
    this.isclosed = new AtomicBoolean(false);
    this.queueinvokes = 0;
    this.queuesize = new AtomicInteger(0);
    this.wsf = new DefaultWebSocketServerFactory();
    if ((paramInetSocketAddress != null) && (paramInt >= 1) && (paramCollection != null))
    {
      if (paramList == null) {
        this.drafts = Collections.emptyList();
      } else {
        this.drafts = paramList;
      }
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
      return;
    }
    paramInetSocketAddress = new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
    for (;;)
    {
      throw paramInetSocketAddress;
    }
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, List<Draft> paramList)
  {
    this(paramInetSocketAddress, AVAILABLE_PROCESSORS, paramList);
  }
  
  private void doAccept(SelectionKey paramSelectionKey, Iterator<SelectionKey> paramIterator)
  {
    if (!onConnect(paramSelectionKey))
    {
      paramSelectionKey.cancel();
      return;
    }
    paramSelectionKey = this.server.accept();
    if (paramSelectionKey == null) {
      return;
    }
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
        else
        {
          pushBuffer(localByteBuffer);
        }
      }
      catch (IOException localIOException)
      {
        pushBuffer(localByteBuffer);
        throw localIOException;
      }
    }
  }
  
  private void doBroadcast(Object paramObject, Collection<WebSocket> paramCollection)
  {
    boolean bool = paramObject instanceof String;
    ByteBuffer localByteBuffer = null;
    String str;
    if (bool) {
      str = (String)paramObject;
    } else {
      str = null;
    }
    if ((paramObject instanceof ByteBuffer)) {
      localByteBuffer = (ByteBuffer)paramObject;
    }
    if ((str == null) && (localByteBuffer == null)) {
      return;
    }
    paramObject = new HashMap();
    paramCollection = paramCollection.iterator();
    for (;;)
    {
      WebSocket localWebSocket;
      Draft localDraft;
      if (paramCollection.hasNext())
      {
        localWebSocket = (WebSocket)paramCollection.next();
        if (localWebSocket != null)
        {
          localDraft = localWebSocket.getDraft();
          fillFrames(localDraft, paramObject, str, localByteBuffer);
        }
      }
      else
      {
        try
        {
          localWebSocket.sendFrame((Collection)paramObject.get(localDraft));
        }
        catch (WebsocketNotConnectedException localWebsocketNotConnectedException) {}
        return;
      }
    }
  }
  
  private boolean doEnsureSingleThread()
  {
    try
    {
      if (this.selectorthread == null)
      {
        this.selectorthread = Thread.currentThread();
        return !this.isclosed.get();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getName());
      localStringBuilder.append(" can only be started once.");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    finally {}
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
      if (SocketChannelIOHelper.read(localByteBuffer, localWebSocketImpl, localWebSocketImpl.getChannel()))
      {
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
      else {
        pushBuffer(localByteBuffer);
      }
      return true;
    }
    catch (IOException paramSelectionKey)
    {
      pushBuffer(localByteBuffer);
      throw paramSelectionKey;
    }
  }
  
  private void doServerShutdown()
  {
    stopConnectionLostTimer();
    Object localObject = this.decoders;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WebSocketServer.WebSocketWorker)((Iterator)localObject).next()).interrupt();
      }
    }
    localObject = this.selector;
    if (localObject != null) {
      try
      {
        ((Selector)localObject).close();
      }
      catch (IOException localIOException1)
      {
        log.error("IOException during selector.close", localIOException1);
        onError(null, localIOException1);
      }
    }
    ServerSocketChannel localServerSocketChannel = this.server;
    if (localServerSocketChannel != null) {
      try
      {
        localServerSocketChannel.close();
        return;
      }
      catch (IOException localIOException2)
      {
        log.error("IOException during server.close", localIOException2);
        onError(null, localIOException2);
      }
    }
  }
  
  private boolean doSetupSelectorAndServerThread()
  {
    Object localObject = this.selectorthread;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebSocketSelector-");
    localStringBuilder.append(this.selectorthread.getId());
    ((Thread)localObject).setName(localStringBuilder.toString());
    try
    {
      this.server = ServerSocketChannel.open();
      this.server.configureBlocking(false);
      localObject = this.server.socket();
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
      return true;
    }
    catch (IOException localIOException)
    {
      handleFatal(null, localIOException);
    }
    return false;
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
    paramWebSocket = this.decoders;
    if (paramWebSocket != null)
    {
      paramWebSocket = paramWebSocket.iterator();
      while (paramWebSocket.hasNext()) {
        ((WebSocketServer.WebSocketWorker)paramWebSocket.next()).interrupt();
      }
    }
    paramWebSocket = this.selectorthread;
    if (paramWebSocket != null) {
      paramWebSocket.interrupt();
    }
    try
    {
      stop();
      return;
    }
    catch (InterruptedException paramWebSocket)
    {
      Thread.currentThread().interrupt();
      log.error("Interrupt during stop", paramException);
      onError(null, paramWebSocket);
      return;
    }
    catch (IOException paramWebSocket)
    {
      log.error("Error during shutdown", paramWebSocket);
      onError(null, paramWebSocket);
    }
  }
  
  private void handleIOException(SelectionKey paramSelectionKey, WebSocket paramWebSocket, IOException paramIOException)
  {
    if (paramWebSocket != null)
    {
      paramWebSocket.closeConnection(1006, paramIOException.getMessage());
      return;
    }
    if (paramSelectionKey != null)
    {
      paramSelectionKey = paramSelectionKey.channel();
      if ((paramSelectionKey == null) || (!paramSelectionKey.isOpen())) {}
    }
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
    if ((paramString != null) && (paramCollection != null))
    {
      doBroadcast(paramString, paramCollection);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void broadcast(ByteBuffer paramByteBuffer)
  {
    broadcast(paramByteBuffer, this.connections);
  }
  
  public void broadcast(ByteBuffer paramByteBuffer, Collection<WebSocket> paramCollection)
  {
    if ((paramByteBuffer != null) && (paramCollection != null))
    {
      doBroadcast(paramByteBuffer, paramCollection);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void broadcast(byte[] paramArrayOfByte)
  {
    broadcast(paramArrayOfByte, this.connections);
  }
  
  public void broadcast(byte[] paramArrayOfByte, Collection<WebSocket> paramCollection)
  {
    if ((paramArrayOfByte != null) && (paramCollection != null))
    {
      broadcast(ByteBuffer.wrap(paramArrayOfByte), paramCollection);
      return;
    }
    throw new IllegalArgumentException();
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
      ServerSocketChannel localServerSocketChannel = this.server;
      i = j;
      if (localServerSocketChannel != null) {
        i = localServerSocketChannel.socket().getLocalPort();
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
    label31:
    try
    {
      if (removeConnection(paramWebSocket)) {
        onClose(paramWebSocket, paramInt, paramString, paramBoolean);
      }
    }
    finally {}
    try
    {
      releaseBuffers(paramWebSocket);
      return;
    }
    catch (InterruptedException paramWebSocket)
    {
      break label31;
    }
    Thread.currentThread().interrupt();
    return;
    try
    {
      releaseBuffers(paramWebSocket);
    }
    catch (InterruptedException paramWebSocket)
    {
      label47:
      break label47;
    }
    Thread.currentThread().interrupt();
    throw paramString;
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
    }
    catch (CancelledKeyException localCancelledKeyException)
    {
      label17:
      break label17;
    }
    paramWebSocket.outQueue.clear();
    this.selector.wakeup();
  }
  
  protected void queue(WebSocketImpl paramWebSocketImpl)
  {
    if (paramWebSocketImpl.getWorkerThread() == null)
    {
      List localList = this.decoders;
      paramWebSocketImpl.setWorkerThread((WebSocketServer.WebSocketWorker)localList.get(this.queueinvokes % localList.size()));
      this.queueinvokes += 1;
    }
    paramWebSocketImpl.getWorkerThread().put(paramWebSocketImpl);
  }
  
  protected void releaseBuffers(WebSocket paramWebSocket) {}
  
  protected boolean removeConnection(WebSocket paramWebSocket)
  {
    synchronized (this.connections)
    {
      boolean bool;
      if (this.connections.contains(paramWebSocket))
      {
        bool = this.connections.remove(paramWebSocket);
      }
      else
      {
        log.trace("Removing connection which is not in the connections collection! Possible no handshake recieved! {}", paramWebSocket);
        bool = false;
      }
      if ((this.isclosed.get()) && (this.connections.isEmpty())) {
        this.selectorthread.interrupt();
      }
      return bool;
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
    //   12: ifne +4 -> 16
    //   15: return
    //   16: iconst_5
    //   17: istore_1
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 341	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   24: invokevirtual 705	java/lang/Thread:isInterrupted	()Z
    //   27: istore 10
    //   29: iload 10
    //   31: ifne +446 -> 477
    //   34: iload_1
    //   35: ifeq +442 -> 477
    //   38: iload_3
    //   39: istore_2
    //   40: iload_1
    //   41: istore 6
    //   43: iload_3
    //   44: istore 7
    //   46: iload_1
    //   47: istore 8
    //   49: iload_3
    //   50: istore 9
    //   52: iload_1
    //   53: istore 4
    //   55: iload_3
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 89	org/java_websocket/server/WebSocketServer:isclosed	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   62: invokevirtual 349	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   65: ifeq +5 -> 70
    //   68: iconst_5
    //   69: istore_2
    //   70: iload_1
    //   71: istore_3
    //   72: iload_1
    //   73: istore 6
    //   75: iload_2
    //   76: istore 7
    //   78: iload_1
    //   79: istore 8
    //   81: iload_2
    //   82: istore 9
    //   84: iload_1
    //   85: istore 4
    //   87: iload_2
    //   88: istore 5
    //   90: aload_0
    //   91: getfield 218	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   94: iload_2
    //   95: i2l
    //   96: invokevirtual 709	java/nio/channels/Selector:select	(J)I
    //   99: ifne +37 -> 136
    //   102: iload_1
    //   103: istore_3
    //   104: iload_1
    //   105: istore 6
    //   107: iload_2
    //   108: istore 7
    //   110: iload_1
    //   111: istore 8
    //   113: iload_2
    //   114: istore 9
    //   116: iload_1
    //   117: istore 4
    //   119: iload_2
    //   120: istore 5
    //   122: aload_0
    //   123: getfield 89	org/java_websocket/server/WebSocketServer:isclosed	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   126: invokevirtual 349	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   129: ifeq +7 -> 136
    //   132: iload_1
    //   133: iconst_1
    //   134: isub
    //   135: istore_3
    //   136: iload_3
    //   137: istore 6
    //   139: iload_2
    //   140: istore 7
    //   142: iload_3
    //   143: istore 8
    //   145: iload_2
    //   146: istore 9
    //   148: iload_3
    //   149: istore 4
    //   151: iload_2
    //   152: istore 5
    //   154: aload_0
    //   155: getfield 218	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   158: invokevirtual 713	java/nio/channels/Selector:selectedKeys	()Ljava/util/Set;
    //   161: invokeinterface 716 1 0
    //   166: astore 13
    //   168: aconst_null
    //   169: astore 11
    //   171: iload_3
    //   172: istore 6
    //   174: iload_2
    //   175: istore 7
    //   177: iload_3
    //   178: istore 8
    //   180: iload_2
    //   181: istore 9
    //   183: aload 13
    //   185: invokeinterface 313 1 0
    //   190: ifeq +191 -> 381
    //   193: iload_3
    //   194: istore 6
    //   196: iload_2
    //   197: istore 7
    //   199: iload_3
    //   200: istore 8
    //   202: iload_2
    //   203: istore 9
    //   205: aload 13
    //   207: invokeinterface 317 1 0
    //   212: checkcast 179	java/nio/channels/SelectionKey
    //   215: astore 12
    //   217: iload_3
    //   218: istore 6
    //   220: iload_2
    //   221: istore 7
    //   223: iload_3
    //   224: istore 8
    //   226: iload_2
    //   227: istore 9
    //   229: aload 12
    //   231: invokevirtual 479	java/nio/channels/SelectionKey:isValid	()Z
    //   234: ifne +6 -> 240
    //   237: goto +130 -> 367
    //   240: iload_3
    //   241: istore 6
    //   243: iload_2
    //   244: istore 7
    //   246: iload_3
    //   247: istore 8
    //   249: iload_2
    //   250: istore 9
    //   252: aload 12
    //   254: invokevirtual 719	java/nio/channels/SelectionKey:isAcceptable	()Z
    //   257: ifeq +26 -> 283
    //   260: iload_3
    //   261: istore 6
    //   263: iload_2
    //   264: istore 7
    //   266: iload_3
    //   267: istore 8
    //   269: iload_2
    //   270: istore 9
    //   272: aload_0
    //   273: aload 12
    //   275: aload 13
    //   277: invokespecial 721	org/java_websocket/server/WebSocketServer:doAccept	(Ljava/nio/channels/SelectionKey;Ljava/util/Iterator;)V
    //   280: goto +87 -> 367
    //   283: iload_3
    //   284: istore 6
    //   286: iload_2
    //   287: istore 7
    //   289: iload_3
    //   290: istore 8
    //   292: iload_2
    //   293: istore 9
    //   295: aload 12
    //   297: invokevirtual 724	java/nio/channels/SelectionKey:isReadable	()Z
    //   300: ifeq +29 -> 329
    //   303: iload_3
    //   304: istore 6
    //   306: iload_2
    //   307: istore 7
    //   309: iload_3
    //   310: istore 8
    //   312: iload_2
    //   313: istore 9
    //   315: aload_0
    //   316: aload 12
    //   318: aload 13
    //   320: invokespecial 726	org/java_websocket/server/WebSocketServer:doRead	(Ljava/nio/channels/SelectionKey;Ljava/util/Iterator;)Z
    //   323: ifne +6 -> 329
    //   326: goto +41 -> 367
    //   329: iload_3
    //   330: istore 6
    //   332: iload_2
    //   333: istore 7
    //   335: iload_3
    //   336: istore 8
    //   338: iload_2
    //   339: istore 9
    //   341: aload 12
    //   343: invokevirtual 729	java/nio/channels/SelectionKey:isWritable	()Z
    //   346: ifeq +21 -> 367
    //   349: iload_3
    //   350: istore 6
    //   352: iload_2
    //   353: istore 7
    //   355: iload_3
    //   356: istore 8
    //   358: iload_2
    //   359: istore 9
    //   361: aload_0
    //   362: aload 12
    //   364: invokespecial 731	org/java_websocket/server/WebSocketServer:doWrite	(Ljava/nio/channels/SelectionKey;)V
    //   367: aload 12
    //   369: astore 11
    //   371: goto -200 -> 171
    //   374: astore 11
    //   376: iload_3
    //   377: istore_1
    //   378: goto +56 -> 434
    //   381: iload_3
    //   382: istore 6
    //   384: iload_2
    //   385: istore 7
    //   387: iload_3
    //   388: istore 8
    //   390: iload_2
    //   391: istore 9
    //   393: aload_0
    //   394: invokespecial 733	org/java_websocket/server/WebSocketServer:doAdditionalRead	()V
    //   397: iload_3
    //   398: istore_1
    //   399: iload_2
    //   400: istore_3
    //   401: goto -381 -> 20
    //   404: astore 13
    //   406: aload 11
    //   408: astore 12
    //   410: iload_3
    //   411: istore_1
    //   412: aload 13
    //   414: astore 11
    //   416: goto +18 -> 434
    //   419: invokestatic 347	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   422: invokevirtual 510	java/lang/Thread:interrupt	()V
    //   425: iload 8
    //   427: istore_1
    //   428: iload 9
    //   430: istore_3
    //   431: goto -411 -> 20
    //   434: aload 12
    //   436: ifnull +8 -> 444
    //   439: aload 12
    //   441: invokevirtual 182	java/nio/channels/SelectionKey:cancel	()V
    //   444: aload_0
    //   445: aload 12
    //   447: aconst_null
    //   448: aload 11
    //   450: invokespecial 253	org/java_websocket/server/WebSocketServer:handleIOException	(Ljava/nio/channels/SelectionKey;Lorg/java_websocket/WebSocket;Ljava/io/IOException;)V
    //   453: iload_2
    //   454: istore_3
    //   455: goto -435 -> 20
    //   458: aload_0
    //   459: invokespecial 735	org/java_websocket/server/WebSocketServer:doServerShutdown	()V
    //   462: return
    //   463: astore 11
    //   465: goto +17 -> 482
    //   468: astore 11
    //   470: aload_0
    //   471: aconst_null
    //   472: aload 11
    //   474: invokespecial 163	org/java_websocket/server/WebSocketServer:handleFatal	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   477: aload_0
    //   478: invokespecial 735	org/java_websocket/server/WebSocketServer:doServerShutdown	()V
    //   481: return
    //   482: aload_0
    //   483: invokespecial 735	org/java_websocket/server/WebSocketServer:doServerShutdown	()V
    //   486: goto +6 -> 492
    //   489: aload 11
    //   491: athrow
    //   492: goto -3 -> 489
    //   495: astore 11
    //   497: iload 6
    //   499: istore_1
    //   500: iload 7
    //   502: istore_3
    //   503: goto -483 -> 20
    //   506: astore 11
    //   508: goto -50 -> 458
    //   511: astore 11
    //   513: goto -94 -> 419
    //   516: astore 11
    //   518: aconst_null
    //   519: astore 12
    //   521: iload 4
    //   523: istore_1
    //   524: iload 5
    //   526: istore_2
    //   527: goto -93 -> 434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	WebSocketServer
    //   17	507	1	i	int
    //   39	488	2	j	int
    //   19	484	3	k	int
    //   53	469	4	m	int
    //   56	469	5	n	int
    //   41	457	6	i1	int
    //   44	457	7	i2	int
    //   47	379	8	i3	int
    //   50	379	9	i4	int
    //   27	3	10	bool	boolean
    //   169	201	11	localObject1	Object
    //   374	33	11	localIOException1	IOException
    //   414	35	11	localIOException2	IOException
    //   463	1	11	localObject2	Object
    //   468	22	11	localRuntimeException	java.lang.RuntimeException
    //   495	1	11	localCancelledKeyException	CancelledKeyException
    //   506	1	11	localClosedByInterruptException	java.nio.channels.ClosedByInterruptException
    //   511	1	11	localInterruptedException	InterruptedException
    //   516	1	11	localIOException3	IOException
    //   215	305	12	localObject3	Object
    //   166	153	13	localIterator	Iterator
    //   404	9	13	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   229	237	374	java/io/IOException
    //   252	260	374	java/io/IOException
    //   272	280	374	java/io/IOException
    //   295	303	374	java/io/IOException
    //   315	326	374	java/io/IOException
    //   341	349	374	java/io/IOException
    //   361	367	374	java/io/IOException
    //   183	193	404	java/io/IOException
    //   205	217	404	java/io/IOException
    //   393	397	404	java/io/IOException
    //   20	29	463	finally
    //   58	68	463	finally
    //   90	102	463	finally
    //   122	132	463	finally
    //   154	168	463	finally
    //   183	193	463	finally
    //   205	217	463	finally
    //   229	237	463	finally
    //   252	260	463	finally
    //   272	280	463	finally
    //   295	303	463	finally
    //   315	326	463	finally
    //   341	349	463	finally
    //   361	367	463	finally
    //   393	397	463	finally
    //   419	425	463	finally
    //   439	444	463	finally
    //   444	453	463	finally
    //   470	477	463	finally
    //   20	29	468	java/lang/RuntimeException
    //   58	68	468	java/lang/RuntimeException
    //   90	102	468	java/lang/RuntimeException
    //   122	132	468	java/lang/RuntimeException
    //   154	168	468	java/lang/RuntimeException
    //   183	193	468	java/lang/RuntimeException
    //   205	217	468	java/lang/RuntimeException
    //   229	237	468	java/lang/RuntimeException
    //   252	260	468	java/lang/RuntimeException
    //   272	280	468	java/lang/RuntimeException
    //   295	303	468	java/lang/RuntimeException
    //   315	326	468	java/lang/RuntimeException
    //   341	349	468	java/lang/RuntimeException
    //   361	367	468	java/lang/RuntimeException
    //   393	397	468	java/lang/RuntimeException
    //   419	425	468	java/lang/RuntimeException
    //   439	444	468	java/lang/RuntimeException
    //   444	453	468	java/lang/RuntimeException
    //   58	68	495	java/nio/channels/CancelledKeyException
    //   90	102	495	java/nio/channels/CancelledKeyException
    //   122	132	495	java/nio/channels/CancelledKeyException
    //   154	168	495	java/nio/channels/CancelledKeyException
    //   183	193	495	java/nio/channels/CancelledKeyException
    //   205	217	495	java/nio/channels/CancelledKeyException
    //   229	237	495	java/nio/channels/CancelledKeyException
    //   252	260	495	java/nio/channels/CancelledKeyException
    //   272	280	495	java/nio/channels/CancelledKeyException
    //   295	303	495	java/nio/channels/CancelledKeyException
    //   315	326	495	java/nio/channels/CancelledKeyException
    //   341	349	495	java/nio/channels/CancelledKeyException
    //   361	367	495	java/nio/channels/CancelledKeyException
    //   393	397	495	java/nio/channels/CancelledKeyException
    //   58	68	506	java/nio/channels/ClosedByInterruptException
    //   90	102	506	java/nio/channels/ClosedByInterruptException
    //   122	132	506	java/nio/channels/ClosedByInterruptException
    //   154	168	506	java/nio/channels/ClosedByInterruptException
    //   183	193	506	java/nio/channels/ClosedByInterruptException
    //   205	217	506	java/nio/channels/ClosedByInterruptException
    //   229	237	506	java/nio/channels/ClosedByInterruptException
    //   252	260	506	java/nio/channels/ClosedByInterruptException
    //   272	280	506	java/nio/channels/ClosedByInterruptException
    //   295	303	506	java/nio/channels/ClosedByInterruptException
    //   315	326	506	java/nio/channels/ClosedByInterruptException
    //   341	349	506	java/nio/channels/ClosedByInterruptException
    //   361	367	506	java/nio/channels/ClosedByInterruptException
    //   393	397	506	java/nio/channels/ClosedByInterruptException
    //   58	68	511	java/lang/InterruptedException
    //   90	102	511	java/lang/InterruptedException
    //   122	132	511	java/lang/InterruptedException
    //   154	168	511	java/lang/InterruptedException
    //   183	193	511	java/lang/InterruptedException
    //   205	217	511	java/lang/InterruptedException
    //   229	237	511	java/lang/InterruptedException
    //   252	260	511	java/lang/InterruptedException
    //   272	280	511	java/lang/InterruptedException
    //   295	303	511	java/lang/InterruptedException
    //   315	326	511	java/lang/InterruptedException
    //   341	349	511	java/lang/InterruptedException
    //   361	367	511	java/lang/InterruptedException
    //   393	397	511	java/lang/InterruptedException
    //   58	68	516	java/io/IOException
    //   90	102	516	java/io/IOException
    //   122	132	516	java/io/IOException
    //   154	168	516	java/io/IOException
  }
  
  public final void setWebSocketFactory(WebSocketServerFactory paramWebSocketServerFactory)
  {
    WebSocketServerFactory localWebSocketServerFactory = this.wsf;
    if (localWebSocketServerFactory != null) {
      localWebSocketServerFactory.close();
    }
    this.wsf = paramWebSocketServerFactory;
  }
  
  public void start()
  {
    if (this.selectorthread == null)
    {
      new Thread(this).start();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" can only be started once.");
    throw new IllegalStateException(localStringBuilder.toString());
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
      while (((Iterator)???).hasNext()) {
        ((WebSocket)((Iterator)???).next()).close(1001);
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
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.server.WebSocketServer
 * JD-Core Version:    0.7.0.1
 */