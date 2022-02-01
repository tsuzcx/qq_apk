package okhttp3.internal.ws;

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
  private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
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
  
  public RealWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener, Random paramRandom, long paramLong)
  {
    if ("GET".equals(paramRequest.method()))
    {
      this.originalRequest = paramRequest;
      this.listener = paramWebSocketListener;
      this.random = paramRandom;
      this.pingIntervalMillis = paramLong;
      paramRequest = new byte[16];
      paramRandom.nextBytes(paramRequest);
      this.key = ByteString.of(paramRequest).base64();
      this.writerRunnable = new RealWebSocket.1(this);
      return;
    }
    paramWebSocketListener = new StringBuilder();
    paramWebSocketListener.append("Request must be GET: ");
    paramWebSocketListener.append(paramRequest.method());
    throw new IllegalArgumentException(paramWebSocketListener.toString());
  }
  
  private void runWriter()
  {
    ScheduledExecutorService localScheduledExecutorService = this.executor;
    if (localScheduledExecutorService != null) {
      localScheduledExecutorService.execute(this.writerRunnable);
    }
  }
  
  private boolean send(ByteString paramByteString, int paramInt)
  {
    try
    {
      if ((!this.failed) && (!this.enqueuedClose))
      {
        if (this.queueSize + paramByteString.size() > 16777216L)
        {
          close(1001, null);
          return false;
        }
        this.queueSize += paramByteString.size();
        this.messageAndCloseQueue.add(new RealWebSocket.Message(paramInt, paramByteString));
        runWriter();
        return true;
      }
      return false;
    }
    finally {}
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
    if (paramResponse.code() == 101)
    {
      localObject = paramResponse.header("Connection");
      if ("Upgrade".equalsIgnoreCase((String)localObject))
      {
        localObject = paramResponse.header("Upgrade");
        if ("websocket".equalsIgnoreCase((String)localObject))
        {
          paramResponse = paramResponse.header("Sec-WebSocket-Accept");
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.key);
          ((StringBuilder)localObject).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
          localObject = ByteString.encodeUtf8(((StringBuilder)localObject).toString()).sha1().base64();
          if (((String)localObject).equals(paramResponse)) {
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Expected 'Sec-WebSocket-Accept' header value '");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("' but was '");
          localStringBuilder.append(paramResponse);
          localStringBuilder.append("'");
          throw new ProtocolException(localStringBuilder.toString());
        }
        paramResponse = new StringBuilder();
        paramResponse.append("Expected 'Upgrade' header value 'websocket' but was '");
        paramResponse.append((String)localObject);
        paramResponse.append("'");
        throw new ProtocolException(paramResponse.toString());
      }
      paramResponse = new StringBuilder();
      paramResponse.append("Expected 'Connection' header value 'Upgrade' but was '");
      paramResponse.append((String)localObject);
      paramResponse.append("'");
      throw new ProtocolException(paramResponse.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected HTTP 101 response but was '");
    ((StringBuilder)localObject).append(paramResponse.code());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramResponse.message());
    ((StringBuilder)localObject).append("'");
    throw new ProtocolException(((StringBuilder)localObject).toString());
  }
  
  public boolean close(int paramInt, String paramString)
  {
    return close(paramInt, paramString, 60000L);
  }
  
  boolean close(int paramInt, String paramString, long paramLong)
  {
    try
    {
      WebSocketProtocol.validateCloseCode(paramInt);
      Object localObject = null;
      if (paramString != null)
      {
        localObject = ByteString.encodeUtf8(paramString);
        if (((ByteString)localObject).size() > 123L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reason.size() > 123: ");
          ((StringBuilder)localObject).append(paramString);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if ((!this.failed) && (!this.enqueuedClose))
      {
        this.enqueuedClose = true;
        this.messageAndCloseQueue.add(new RealWebSocket.Close(paramInt, (ByteString)localObject, paramLong));
        runWriter();
        return true;
      }
      return false;
    }
    finally {}
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
    //   3: getfield 166	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 166	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   17: aload_0
    //   18: getfield 352	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   21: astore_3
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 352	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   27: aload_0
    //   28: getfield 354	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   31: ifnull +14 -> 45
    //   34: aload_0
    //   35: getfield 354	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   38: iconst_0
    //   39: invokeinterface 359 2 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 156	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   49: ifnull +12 -> 61
    //   52: aload_0
    //   53: getfield 156	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   56: invokeinterface 362 1 0
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_0
    //   64: getfield 108	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   67: aload_0
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 368	okhttp3/WebSocketListener:onFailure	(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V
    //   73: aload_3
    //   74: invokestatic 374	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   77: return
    //   78: astore_1
    //   79: aload_3
    //   80: invokestatic 374	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	RealWebSocket
    //   0	90	1	paramException	Exception
    //   0	90	2	paramResponse	Response
    //   21	59	3	localStreams	RealWebSocket.Streams
    // Exception table:
    //   from	to	target	type
    //   63	73	78	finally
    //   2	11	85	finally
    //   12	45	85	finally
    //   45	61	85	finally
    //   61	63	85	finally
    //   86	88	85	finally
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
    if (paramInt != -1) {}
    for (;;)
    {
      try
      {
        if (this.receivedCloseCode == -1)
        {
          this.receivedCloseCode = paramInt;
          this.receivedCloseReason = paramString;
          if ((!this.enqueuedClose) || (!this.messageAndCloseQueue.isEmpty())) {
            break label144;
          }
          localStreams = this.streams;
          this.streams = null;
          if (this.cancelFuture != null) {
            this.cancelFuture.cancel(false);
          }
          this.executor.shutdown();
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
        }
        throw new IllegalStateException("already closed");
      }
      finally {}
      throw new IllegalArgumentException();
      label144:
      RealWebSocket.Streams localStreams = null;
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
  
  public void onReadPing(ByteString paramByteString)
  {
    try
    {
      if ((!this.failed) && ((!this.enqueuedClose) || (!this.messageAndCloseQueue.isEmpty())))
      {
        this.pongQueue.add(paramByteString);
        runWriter();
        this.receivedPingCount += 1;
        return;
      }
      return;
    }
    finally {}
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
  
  boolean pong(ByteString paramByteString)
  {
    try
    {
      if ((!this.failed) && ((!this.enqueuedClose) || (!this.messageAndCloseQueue.isEmpty())))
      {
        this.pongQueue.add(paramByteString);
        runWriter();
        return true;
      }
      return false;
    }
    finally {}
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
    if (paramString != null) {
      return send(ByteString.encodeUtf8(paramString), 1);
    }
    throw new NullPointerException("text == null");
  }
  
  public boolean send(ByteString paramByteString)
  {
    if (paramByteString != null) {
      return send(paramByteString, 2);
    }
    throw new NullPointerException("bytes == null");
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
    ScheduledFuture localScheduledFuture = this.cancelFuture;
    if (localScheduledFuture != null) {
      localScheduledFuture.cancel(false);
    }
    this.executor.shutdown();
    this.executor.awaitTermination(10L, TimeUnit.SECONDS);
  }
  
  boolean writeOneFrame()
  {
    for (;;)
    {
      try
      {
        if (this.failed) {
          return false;
        }
        WebSocketWriter localWebSocketWriter = this.writer;
        ByteString localByteString = (ByteString)this.pongQueue.poll();
        RealWebSocket.Streams localStreams = null;
        if (localByteString == null)
        {
          Object localObject1 = this.messageAndCloseQueue.poll();
          if ((localObject1 instanceof RealWebSocket.Close))
          {
            i = this.receivedCloseCode;
            localObject6 = this.receivedCloseReason;
            if (i != -1)
            {
              localStreams = this.streams;
              this.streams = null;
              this.executor.shutdown();
            }
            else
            {
              this.cancelFuture = this.executor.schedule(new RealWebSocket.CancelRunnable(this), ((RealWebSocket.Close)localObject1).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
            }
          }
          else
          {
            if (localObject1 != null) {
              break label296;
            }
            return false;
          }
          if (localByteString != null) {}
          try
          {
            localWebSocketWriter.writePong(localByteString);
            continue;
            if ((localObject1 instanceof RealWebSocket.Message))
            {
              localObject6 = ((RealWebSocket.Message)localObject1).data;
              localObject1 = Okio.buffer(localWebSocketWriter.newMessageSink(((RealWebSocket.Message)localObject1).formatOpcode, ((ByteString)localObject6).size()));
              ((BufferedSink)localObject1).write((ByteString)localObject6);
              ((BufferedSink)localObject1).close();
              try
              {
                this.queueSize -= ((ByteString)localObject6).size();
              }
              finally {}
            }
            else
            {
              if (!(localObject2 instanceof RealWebSocket.Close)) {
                continue;
              }
              RealWebSocket.Close localClose = (RealWebSocket.Close)localObject2;
              localWebSocketWriter.writeClose(localClose.code, localClose.reason);
              if (localStreams != null) {
                this.listener.onClosed(this, i, (String)localObject6);
              }
            }
            return true;
            throw new AssertionError();
          }
          finally
          {
            Util.closeQuietly(localStreams);
          }
        }
      }
      finally {}
      label296:
      Object localObject5 = null;
      Object localObject6 = null;
      int i = -1;
    }
  }
  
  void writePingFrame()
  {
    for (;;)
    {
      try
      {
        if (this.failed) {
          return;
        }
        Object localObject1 = this.writer;
        if (this.awaitingPong)
        {
          i = this.sentPingCount;
          this.sentPingCount += 1;
          this.awaitingPong = true;
          if (i != -1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sent ping but didn't receive pong within ");
            ((StringBuilder)localObject1).append(this.pingIntervalMillis);
            ((StringBuilder)localObject1).append("ms (after ");
            ((StringBuilder)localObject1).append(i - 1);
            ((StringBuilder)localObject1).append(" successful ping/pongs)");
            failWebSocket(new SocketTimeoutException(((StringBuilder)localObject1).toString()), null);
            return;
          }
          try
          {
            ((WebSocketWriter)localObject1).writePing(ByteString.EMPTY);
            return;
          }
          catch (IOException localIOException)
          {
            failWebSocket(localIOException, null);
            return;
          }
        }
        int i = -1;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket
 * JD-Core Version:    0.7.0.1
 */