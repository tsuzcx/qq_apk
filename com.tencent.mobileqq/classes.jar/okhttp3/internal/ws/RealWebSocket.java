package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Timeout;

public final class RealWebSocket
  implements WebSocket, WebSocketReader.FrameCallback
{
  private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
  private static final long MAX_QUEUE_SIZE = 16777216L;
  private static final List<Protocol> ONLY_HTTP1;
  private boolean awaitingPong;
  private Call call;
  private ScheduledFuture<?> cancelFuture;
  private boolean enqueuedClose;
  private ScheduledExecutorService executor;
  private boolean failed;
  private final String key;
  final WebSocketListener listener;
  private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque();
  private final Request originalRequest;
  private final long pingIntervalMillis;
  private final ArrayDeque<ByteString> pongQueue = new ArrayDeque();
  private long queueSize;
  private final Random random;
  private WebSocketReader reader;
  private int receivedCloseCode = -1;
  private String receivedCloseReason;
  private int receivedPingCount;
  private int receivedPongCount;
  private int sentPingCount;
  private RealWebSocket.Streams streams;
  private WebSocketWriter writer;
  private final Runnable writerRunnable;
  
  static
  {
    if (!RealWebSocket.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
      return;
    }
  }
  
  public RealWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener, Random paramRandom, long paramLong)
  {
    if (!"GET".equals(paramRequest.method())) {
      throw new IllegalArgumentException("Request must be GET: " + paramRequest.method());
    }
    this.originalRequest = paramRequest;
    this.listener = paramWebSocketListener;
    this.random = paramRandom;
    this.pingIntervalMillis = paramLong;
    paramRequest = new byte[16];
    paramRandom.nextBytes(paramRequest);
    this.key = ByteString.of(paramRequest).base64();
    this.writerRunnable = new RealWebSocket.1(this);
  }
  
  private void runWriter()
  {
    assert (Thread.holdsLock(this));
    if (this.executor != null) {
      this.executor.execute(this.writerRunnable);
    }
  }
  
  private boolean send(ByteString paramByteString, int paramInt)
  {
    boolean bool2 = false;
    for (boolean bool1 = bool2;; bool1 = true)
    {
      try
      {
        if (!this.failed)
        {
          bool1 = this.enqueuedClose;
          if (!bool1) {
            break label31;
          }
        }
        for (bool1 = bool2;; bool1 = bool2)
        {
          return bool1;
          label31:
          if (this.queueSize + paramByteString.size() <= 16777216L) {
            break;
          }
          close(1001, null);
        }
        this.queueSize += paramByteString.size();
      }
      finally {}
      this.messageAndCloseQueue.add(new RealWebSocket.Message(paramInt, paramByteString));
      runWriter();
    }
  }
  
  void awaitTermination(int paramInt, TimeUnit paramTimeUnit)
  {
    this.executor.awaitTermination(paramInt, paramTimeUnit);
  }
  
  public void cancel()
  {
    this.call.cancel();
  }
  
  void checkResponse(Response paramResponse)
  {
    if (paramResponse.code() != 101) {
      throw new ProtocolException("Expected HTTP 101 response but was '" + paramResponse.code() + " " + paramResponse.message() + "'");
    }
    String str = paramResponse.header("Connection");
    if (!"Upgrade".equalsIgnoreCase(str)) {
      throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + str + "'");
    }
    str = paramResponse.header("Upgrade");
    if (!"websocket".equalsIgnoreCase(str)) {
      throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + str + "'");
    }
    paramResponse = paramResponse.header("Sec-WebSocket-Accept");
    str = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    if (!str.equals(paramResponse)) {
      throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + str + "' but was '" + paramResponse + "'");
    }
  }
  
  public boolean close(int paramInt, String paramString)
  {
    return close(paramInt, paramString, 60000L);
  }
  
  boolean close(int paramInt, String paramString, long paramLong)
  {
    boolean bool1 = true;
    Object localObject;
    try
    {
      WebSocketProtocol.validateCloseCode(paramInt);
      localObject = null;
      if (paramString != null)
      {
        ByteString localByteString = ByteString.encodeUtf8(paramString);
        localObject = localByteString;
        if (localByteString.size() > 123L) {
          throw new IllegalArgumentException("reason.size() > 123: " + paramString);
        }
      }
    }
    finally {}
    if (!this.failed)
    {
      boolean bool2 = this.enqueuedClose;
      if (!bool2) {}
    }
    else
    {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      this.enqueuedClose = true;
      this.messageAndCloseQueue.add(new RealWebSocket.Close(paramInt, localObject, paramLong));
      runWriter();
    }
  }
  
  public void connect(OkHttpClient paramOkHttpClient)
  {
    paramOkHttpClient = paramOkHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
    Request localRequest = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
    this.call = Internal.instance.newWebSocketCall(paramOkHttpClient, localRequest);
    this.call.timeout().clearTimeout();
    this.call.enqueue(new RealWebSocket.2(this, localRequest));
  }
  
  /* Error */
  public void failWebSocket(Exception paramException, @javax.annotation.Nullable Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 181	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 181	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   17: aload_0
    //   18: getfield 367	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   21: astore_3
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 367	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   27: aload_0
    //   28: getfield 369	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   31: ifnull +14 -> 45
    //   34: aload_0
    //   35: getfield 369	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   38: iconst_0
    //   39: invokeinterface 374 2 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 171	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   49: ifnull +12 -> 61
    //   52: aload_0
    //   53: getfield 171	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   56: invokeinterface 377 1 0
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_0
    //   64: getfield 132	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   67: aload_0
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 383	okhttp3/WebSocketListener:onFailure	(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V
    //   73: aload_3
    //   74: invokestatic 389	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_3
    //   85: invokestatic 389	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	RealWebSocket
    //   0	90	1	paramException	Exception
    //   0	90	2	paramResponse	Response
    //   21	64	3	localStreams	RealWebSocket.Streams
    // Exception table:
    //   from	to	target	type
    //   2	11	78	finally
    //   12	45	78	finally
    //   45	61	78	finally
    //   61	63	78	finally
    //   79	81	78	finally
    //   63	73	83	finally
  }
  
  public void initReaderAndWriter(String paramString, RealWebSocket.Streams paramStreams)
  {
    try
    {
      this.streams = paramStreams;
      this.writer = new WebSocketWriter(paramStreams.client, paramStreams.sink, this.random);
      this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(paramString, false));
      if (this.pingIntervalMillis != 0L) {
        this.executor.scheduleAtFixedRate(new RealWebSocket.PingRunnable(this), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
      }
      if (!this.messageAndCloseQueue.isEmpty()) {
        runWriter();
      }
      this.reader = new WebSocketReader(paramStreams.client, paramStreams.source, this);
      return;
    }
    finally {}
  }
  
  public void loopReader()
  {
    while (this.receivedCloseCode == -1) {
      this.reader.processNextFrame();
    }
  }
  
  public void onReadClose(int paramInt, String paramString)
  {
    if (paramInt == -1) {
      throw new IllegalArgumentException();
    }
    try
    {
      if (this.receivedCloseCode != -1) {
        throw new IllegalStateException("already closed");
      }
    }
    finally {}
    this.receivedCloseCode = paramInt;
    this.receivedCloseReason = paramString;
    RealWebSocket.Streams localStreams;
    if ((this.enqueuedClose) && (this.messageAndCloseQueue.isEmpty()))
    {
      localStreams = this.streams;
      this.streams = null;
      if (this.cancelFuture != null) {
        this.cancelFuture.cancel(false);
      }
      this.executor.shutdown();
    }
    for (;;)
    {
      try
      {
        this.listener.onClosing(this, paramInt, paramString);
        if (localStreams != null) {
          this.listener.onClosed(this, paramInt, paramString);
        }
        return;
      }
      finally
      {
        Util.closeQuietly(localStreams);
      }
      localStreams = null;
    }
  }
  
  public void onReadMessage(String paramString)
  {
    this.listener.onMessage(this, paramString);
  }
  
  public void onReadMessage(ByteString paramByteString)
  {
    this.listener.onMessage(this, paramByteString);
  }
  
  /* Error */
  public void onReadPing(ByteString paramByteString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 181	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 183	okhttp3/internal/ws/RealWebSocket:enqueuedClose	Z
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: getfield 95	okhttp3/internal/ws/RealWebSocket:messageAndCloseQueue	Ljava/util/ArrayDeque;
    //   20: invokevirtual 433	java/util/ArrayDeque:isEmpty	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 93	okhttp3/internal/ws/RealWebSocket:pongQueue	Ljava/util/ArrayDeque;
    //   35: aload_1
    //   36: invokevirtual 201	java/util/ArrayDeque:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: aload_0
    //   41: invokespecial 203	okhttp3/internal/ws/RealWebSocket:runWriter	()V
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 477	okhttp3/internal/ws/RealWebSocket:receivedPingCount	I
    //   49: iconst_1
    //   50: iadd
    //   51: putfield 477	okhttp3/internal/ws/RealWebSocket:receivedPingCount	I
    //   54: goto -26 -> 28
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	RealWebSocket
    //   0	62	1	paramByteString	ByteString
    //   23	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	57	finally
    //   31	54	57	finally
  }
  
  public void onReadPong(ByteString paramByteString)
  {
    try
    {
      this.receivedPongCount += 1;
      this.awaitingPong = false;
      return;
    }
    finally
    {
      paramByteString = finally;
      throw paramByteString;
    }
  }
  
  /* Error */
  boolean pong(ByteString paramByteString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 181	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 183	okhttp3/internal/ws/RealWebSocket:enqueuedClose	Z
    //   13: ifeq +21 -> 34
    //   16: aload_0
    //   17: getfield 95	okhttp3/internal/ws/RealWebSocket:messageAndCloseQueue	Ljava/util/ArrayDeque;
    //   20: invokevirtual 433	java/util/ArrayDeque:isEmpty	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +9 -> 34
    //   28: iconst_0
    //   29: istore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 93	okhttp3/internal/ws/RealWebSocket:pongQueue	Ljava/util/ArrayDeque;
    //   38: aload_1
    //   39: invokevirtual 201	java/util/ArrayDeque:add	(Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: invokespecial 203	okhttp3/internal/ws/RealWebSocket:runWriter	()V
    //   47: iconst_1
    //   48: istore_2
    //   49: goto -19 -> 30
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	RealWebSocket
    //   0	57	1	paramByteString	ByteString
    //   23	26	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	52	finally
    //   34	47	52	finally
  }
  
  boolean processNextFrame()
  {
    boolean bool = false;
    try
    {
      this.reader.processNextFrame();
      int i = this.receivedCloseCode;
      if (i == -1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      failWebSocket(localException, null);
    }
    return false;
  }
  
  public long queueSize()
  {
    try
    {
      long l = this.queueSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int receivedPingCount()
  {
    try
    {
      int i = this.receivedPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int receivedPongCount()
  {
    try
    {
      int i = this.receivedPongCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  public boolean send(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("text == null");
    }
    return send(ByteString.encodeUtf8(paramString), 1);
  }
  
  public boolean send(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException("bytes == null");
    }
    return send(paramByteString, 2);
  }
  
  int sentPingCount()
  {
    try
    {
      int i = this.sentPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void tearDown()
  {
    if (this.cancelFuture != null) {
      this.cancelFuture.cancel(false);
    }
    this.executor.shutdown();
    this.executor.awaitTermination(10L, TimeUnit.SECONDS);
  }
  
  boolean writeOneFrame()
  {
    Object localObject7 = null;
    for (;;)
    {
      WebSocketWriter localWebSocketWriter;
      ByteString localByteString;
      int i;
      try
      {
        if (this.failed) {
          return false;
        }
        localWebSocketWriter = this.writer;
        localByteString = (ByteString)this.pongQueue.poll();
        if (localByteString != null) {
          break label326;
        }
        localObject1 = this.messageAndCloseQueue.poll();
        if ((localObject1 instanceof RealWebSocket.Close))
        {
          i = this.receivedCloseCode;
          localObject3 = this.receivedCloseReason;
          if (i != -1)
          {
            localStreams = this.streams;
            this.streams = null;
            this.executor.shutdown();
            localObject7 = localObject3;
            localObject3 = localObject1;
            localObject1 = localStreams;
            if (localByteString == null) {
              break label175;
            }
          }
        }
      }
      finally {}
      try
      {
        localWebSocketWriter.writePong(localByteString);
        return true;
      }
      finally
      {
        Util.closeQuietly(localCloseable);
      }
      this.cancelFuture = this.executor.schedule(new RealWebSocket.CancelRunnable(this), ((RealWebSocket.Close)localObject1).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
      RealWebSocket.Streams localStreams = null;
      localObject7 = localObject3;
      Object localObject3 = localObject1;
      Object localObject1 = localStreams;
      continue;
      label175:
      Object localObject6;
      if (localObject1 == null)
      {
        return false;
        if ((localObject3 instanceof RealWebSocket.Message))
        {
          localObject7 = ((RealWebSocket.Message)localObject3).data;
          localObject3 = Okio.buffer(localWebSocketWriter.newMessageSink(((RealWebSocket.Message)localObject3).formatOpcode, ((ByteString)localObject7).size()));
          ((BufferedSink)localObject3).write((ByteString)localObject7);
          ((BufferedSink)localObject3).close();
          try
          {
            this.queueSize -= ((ByteString)localObject7).size();
            continue;
          }
          finally {}
        }
        else if ((localObject5 instanceof RealWebSocket.Close))
        {
          localObject6 = (RealWebSocket.Close)localObject5;
          localWebSocketWriter.writeClose(((RealWebSocket.Close)localObject6).code, ((RealWebSocket.Close)localObject6).reason);
          if (localCloseable != null) {
            this.listener.onClosed(this, i, (String)localObject7);
          }
        }
        else
        {
          throw new AssertionError();
        }
      }
      else
      {
        i = -1;
        localStreams = null;
        localObject6 = localCloseable;
        Object localObject2 = localStreams;
        continue;
        label326:
        localObject2 = null;
        i = -1;
        localObject6 = null;
      }
    }
  }
  
  void writePingFrame()
  {
    try
    {
      if (this.failed) {
        return;
      }
      WebSocketWriter localWebSocketWriter = this.writer;
      if (this.awaitingPong) {}
      for (int i = this.sentPingCount;; i = -1)
      {
        this.sentPingCount += 1;
        this.awaitingPong = true;
        if (i == -1) {
          break;
        }
        failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        return;
      }
      try
      {
        localObject.writePing(ByteString.EMPTY);
        return;
      }
      catch (IOException localIOException)
      {
        failWebSocket(localIOException, null);
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket
 * JD-Core Version:    0.7.0.1
 */