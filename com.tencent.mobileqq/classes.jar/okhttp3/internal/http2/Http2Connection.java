package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

public final class Http2Connection
  implements Closeable
{
  static final int AWAIT_PING = 3;
  static final int DEGRADED_PING = 2;
  static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000L;
  static final int INTERVAL_PING = 1;
  static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
  private long awaitPingsSent = 0L;
  private long awaitPongsReceived = 0L;
  long bytesLeftInWriteWindow;
  final boolean client;
  final Set<Integer> currentPushRequests = new LinkedHashSet();
  private long degradedPingsSent = 0L;
  private long degradedPongDeadlineNs = 0L;
  private long degradedPongsReceived = 0L;
  final String hostname;
  private long intervalPingsSent = 0L;
  private long intervalPongsReceived = 0L;
  int lastGoodStreamId;
  final Http2Connection.Listener listener;
  int nextStreamId;
  Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private final ExecutorService pushExecutor;
  final PushObserver pushObserver;
  final Http2Connection.ReaderRunnable readerRunnable;
  private boolean shutdown;
  final Socket socket;
  final Map<Integer, Http2Stream> streams = new LinkedHashMap();
  long unacknowledgedBytesRead = 0L;
  final Http2Writer writer;
  private final ScheduledExecutorService writerExecutor;
  
  Http2Connection(Http2Connection.Builder paramBuilder)
  {
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    int i;
    if (paramBuilder.client) {
      i = 1;
    } else {
      i = 2;
    }
    this.nextStreamId = i;
    if (paramBuilder.client) {
      this.nextStreamId += 2;
    }
    if (paramBuilder.client) {
      this.okHttpSettings.set(7, 16777216);
    }
    this.hostname = paramBuilder.hostname;
    this.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", new Object[] { this.hostname }), false));
    if (paramBuilder.pingIntervalMillis != 0) {
      this.writerExecutor.scheduleAtFixedRate(new Http2Connection.IntervalPingRunnable(this), paramBuilder.pingIntervalMillis, paramBuilder.pingIntervalMillis, TimeUnit.MILLISECONDS);
    }
    this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", new Object[] { this.hostname }), true));
    this.peerSettings.set(7, 65535);
    this.peerSettings.set(5, 16384);
    this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize();
    this.socket = paramBuilder.socket;
    this.writer = new Http2Writer(paramBuilder.sink, this.client);
    this.readerRunnable = new Http2Connection.ReaderRunnable(this, new Http2Reader(paramBuilder.source, this.client));
  }
  
  private void failConnection()
  {
    try
    {
      close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private Http2Stream newStream(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    boolean bool = paramBoolean ^ true;
    for (;;)
    {
      synchronized (this.writer)
      {
        try
        {
          if (this.nextStreamId > 1073741823) {
            shutdown(ErrorCode.REFUSED_STREAM);
          }
          if (!this.shutdown)
          {
            int j = this.nextStreamId;
            this.nextStreamId += 2;
            Http2Stream localHttp2Stream = new Http2Stream(j, this, bool, false, null);
            if ((!paramBoolean) || (this.bytesLeftInWriteWindow == 0L)) {
              break label217;
            }
            if (localHttp2Stream.bytesLeftInWriteWindow == 0L)
            {
              break label217;
              if (localHttp2Stream.isOpen()) {
                this.streams.put(Integer.valueOf(j), localHttp2Stream);
              }
              if (paramInt == 0)
              {
                this.writer.synStream(bool, j, paramInt, paramList);
              }
              else
              {
                if (this.client) {
                  continue;
                }
                this.writer.pushPromise(paramInt, j, paramList);
              }
              if (i != 0) {
                this.writer.flush();
              }
              return localHttp2Stream;
              throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
          }
          else
          {
            throw new ConnectionShutdownException();
          }
        }
        finally {}
      }
      int i = 0;
      continue;
      label217:
      i = 1;
    }
  }
  
  private void pushExecutorExecute(NamedRunnable paramNamedRunnable)
  {
    try
    {
      if (!this.shutdown) {
        this.pushExecutor.execute(paramNamedRunnable);
      }
      return;
    }
    finally
    {
      paramNamedRunnable = finally;
      throw paramNamedRunnable;
    }
  }
  
  void awaitPong()
  {
    try
    {
      while (this.awaitPongsReceived < this.awaitPingsSent) {
        wait();
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void close()
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
  {
    Http2Stream[] arrayOfHttp2Stream = null;
    try
    {
      shutdown(paramErrorCode1);
      paramErrorCode1 = null;
    }
    catch (IOException paramErrorCode1) {}
    try
    {
      if (!this.streams.isEmpty())
      {
        arrayOfHttp2Stream = (Http2Stream[])this.streams.values().toArray(new Http2Stream[this.streams.size()]);
        this.streams.clear();
      }
      Object localObject = paramErrorCode1;
      if (arrayOfHttp2Stream != null)
      {
        int j = arrayOfHttp2Stream.length;
        int i = 0;
        for (;;)
        {
          localObject = paramErrorCode1;
          if (i >= j) {
            break;
          }
          localObject = arrayOfHttp2Stream[i];
          try
          {
            ((Http2Stream)localObject).close(paramErrorCode2);
            localObject = paramErrorCode1;
          }
          catch (IOException localIOException)
          {
            localObject = paramErrorCode1;
            if (paramErrorCode1 != null) {
              localObject = localIOException;
            }
          }
          i += 1;
          paramErrorCode1 = (ErrorCode)localObject;
        }
      }
      try
      {
        this.writer.close();
        paramErrorCode1 = (ErrorCode)localObject;
      }
      catch (IOException paramErrorCode2)
      {
        paramErrorCode1 = (ErrorCode)localObject;
        if (localObject == null) {
          paramErrorCode1 = paramErrorCode2;
        }
      }
      try
      {
        this.socket.close();
      }
      catch (IOException paramErrorCode1) {}
      this.writerExecutor.shutdown();
      this.pushExecutor.shutdown();
      if (paramErrorCode1 == null) {
        return;
      }
      throw paramErrorCode1;
    }
    finally {}
    for (;;)
    {
      throw paramErrorCode1;
    }
  }
  
  public void flush()
  {
    this.writer.flush();
  }
  
  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }
  
  Http2Stream getStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.get(Integer.valueOf(paramInt));
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isHealthy(long paramLong)
  {
    try
    {
      boolean bool = this.shutdown;
      if (bool) {
        return false;
      }
      if (this.degradedPongsReceived < this.degradedPingsSent)
      {
        long l = this.degradedPongDeadlineNs;
        if (paramLong >= l) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public int maxConcurrentStreams()
  {
    try
    {
      int i = this.peerSettings.getMaxConcurrentStreams(2147483647);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Http2Stream newStream(List<Header> paramList, boolean paramBoolean)
  {
    return newStream(0, paramList, paramBoolean);
  }
  
  public int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void pushDataLater(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
  {
    Buffer localBuffer = new Buffer();
    long l = paramInt2;
    paramBufferedSource.require(l);
    paramBufferedSource.read(localBuffer, l);
    if (localBuffer.size() == l)
    {
      pushExecutorExecute(new Http2Connection.6(this, "OkHttp %s Push Data[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt1) }, paramInt1, localBuffer, paramInt2, paramBoolean));
      return;
    }
    paramBufferedSource = new StringBuilder();
    paramBufferedSource.append(localBuffer.size());
    paramBufferedSource.append(" != ");
    paramBufferedSource.append(paramInt2);
    throw new IOException(paramBufferedSource.toString());
  }
  
  void pushHeadersLater(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    try
    {
      pushExecutorExecute(new Http2Connection.5(this, "OkHttp %s Push Headers[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean));
      return;
    }
    catch (RejectedExecutionException paramList) {}
  }
  
  void pushRequestLater(int paramInt, List<Header> paramList)
  {
    try
    {
      if (this.currentPushRequests.contains(Integer.valueOf(paramInt)))
      {
        writeSynResetLater(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.currentPushRequests.add(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      try
      {
        pushExecutorExecute(new Http2Connection.4(this, "OkHttp %s Push Request[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramList));
        return;
      }
      catch (RejectedExecutionException paramList) {}
      paramList = finally;
    }
  }
  
  void pushResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    pushExecutorExecute(new Http2Connection.7(this, "OkHttp %s Push Reset[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
  }
  
  public Http2Stream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    if (!this.client) {
      return newStream(paramInt, paramList, paramBoolean);
    }
    throw new IllegalStateException("Client cannot push requests.");
  }
  
  boolean pushedStream(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  Http2Stream removeStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.remove(Integer.valueOf(paramInt));
      notifyAll();
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void sendDegradedPingLater()
  {
    try
    {
      if (this.degradedPongsReceived < this.degradedPingsSent) {
        return;
      }
      this.degradedPingsSent += 1L;
      this.degradedPongDeadlineNs = (System.nanoTime() + 1000000000L);
      return;
    }
    finally
    {
      try
      {
        this.writerExecutor.execute(new Http2Connection.3(this, "OkHttp %s ping", new Object[] { this.hostname }));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException) {}
      localObject = finally;
    }
  }
  
  public void setSettings(Settings paramSettings)
  {
    synchronized (this.writer)
    {
      try
      {
        if (!this.shutdown)
        {
          this.okHttpSettings.merge(paramSettings);
          this.writer.settings(paramSettings);
          return;
        }
        throw new ConnectionShutdownException();
      }
      finally {}
    }
  }
  
  public void shutdown(ErrorCode paramErrorCode)
  {
    synchronized (this.writer)
    {
      try
      {
        if (this.shutdown) {
          return;
        }
        this.shutdown = true;
        int i = this.lastGoodStreamId;
        this.writer.goAway(i, paramErrorCode, Util.EMPTY_BYTE_ARRAY);
        return;
      }
      finally {}
    }
  }
  
  public void start()
  {
    start(true);
  }
  
  void start(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.writer.connectionPreface();
      this.writer.settings(this.okHttpSettings);
      int i = this.okHttpSettings.getInitialWindowSize();
      if (i != 65535) {
        this.writer.windowUpdate(0, i - 65535);
      }
    }
    new Thread(this.readerRunnable).start();
  }
  
  void updateConnectionFlowControl(long paramLong)
  {
    try
    {
      this.unacknowledgedBytesRead += paramLong;
      if (this.unacknowledgedBytesRead >= this.okHttpSettings.getInitialWindowSize() / 2)
      {
        writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
        this.unacknowledgedBytesRead = 0L;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
  {
    // Byte code:
    //   0: lload 4
    //   2: lstore 8
    //   4: lload 4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +15 -> 23
    //   11: aload_0
    //   12: getfield 206	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokevirtual 550	okhttp3/internal/http2/Http2Writer:data	(ZILokio/Buffer;I)V
    //   22: return
    //   23: lload 8
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +161 -> 188
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 192	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   36: lconst_0
    //   37: lcmp
    //   38: ifgt +37 -> 75
    //   41: aload_0
    //   42: getfield 100	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   45: iload_1
    //   46: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokeinterface 553 2 0
    //   54: ifeq +10 -> 64
    //   57: aload_0
    //   58: invokevirtual 321	java/lang/Object:wait	()V
    //   61: goto -29 -> 32
    //   64: new 245	java/io/IOException
    //   67: dup
    //   68: ldc_w 555
    //   71: invokespecial 431	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: lload 8
    //   77: aload_0
    //   78: getfield 192	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   81: invokestatic 561	java/lang/Math:min	(JJ)J
    //   84: l2i
    //   85: aload_0
    //   86: getfield 206	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   89: invokevirtual 564	okhttp3/internal/http2/Http2Writer:maxDataLength	()I
    //   92: invokestatic 567	java/lang/Math:min	(II)I
    //   95: istore 6
    //   97: aload_0
    //   98: getfield 192	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   101: lstore 4
    //   103: iload 6
    //   105: i2l
    //   106: lstore 10
    //   108: aload_0
    //   109: lload 4
    //   111: lload 10
    //   113: lsub
    //   114: putfield 192	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   117: aload_0
    //   118: monitorexit
    //   119: lload 8
    //   121: lload 10
    //   123: lsub
    //   124: lstore 8
    //   126: aload_0
    //   127: getfield 206	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   130: astore 12
    //   132: iload_2
    //   133: ifeq +16 -> 149
    //   136: lload 8
    //   138: lconst_0
    //   139: lcmp
    //   140: ifne +9 -> 149
    //   143: iconst_1
    //   144: istore 7
    //   146: goto +6 -> 152
    //   149: iconst_0
    //   150: istore 7
    //   152: aload 12
    //   154: iload 7
    //   156: iload_1
    //   157: aload_3
    //   158: iload 6
    //   160: invokevirtual 550	okhttp3/internal/http2/Http2Writer:data	(ZILokio/Buffer;I)V
    //   163: goto -140 -> 23
    //   166: astore_3
    //   167: goto +17 -> 184
    //   170: invokestatic 571	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   173: invokevirtual 574	java/lang/Thread:interrupt	()V
    //   176: new 576	java/io/InterruptedIOException
    //   179: dup
    //   180: invokespecial 577	java/io/InterruptedIOException:<init>	()V
    //   183: athrow
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_3
    //   187: athrow
    //   188: return
    //   189: astore_3
    //   190: goto -20 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	Http2Connection
    //   0	193	1	paramInt	int
    //   0	193	2	paramBoolean	boolean
    //   0	193	3	paramBuffer	Buffer
    //   0	193	4	paramLong	long
    //   95	64	6	i	int
    //   144	11	7	bool	boolean
    //   2	135	8	l1	long
    //   106	16	10	l2	long
    //   130	23	12	localHttp2Writer	Http2Writer
    // Exception table:
    //   from	to	target	type
    //   32	61	166	finally
    //   64	75	166	finally
    //   75	103	166	finally
    //   108	119	166	finally
    //   170	184	166	finally
    //   184	186	166	finally
    //   32	61	189	java/lang/InterruptedException
    //   64	75	189	java/lang/InterruptedException
  }
  
  void writePing()
  {
    try
    {
      this.awaitPingsSent += 1L;
      writePing(false, 3, 1330343787);
      return;
    }
    finally {}
  }
  
  void writePing(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      this.writer.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      label11:
      break label11;
    }
    failConnection();
  }
  
  void writePingAndAwaitPong()
  {
    writePing();
    awaitPong();
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
  {
    this.writer.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
  {
    this.writer.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    try
    {
      this.writerExecutor.execute(new Http2Connection.1(this, "OkHttp %s stream %d", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
      return;
    }
    catch (RejectedExecutionException paramErrorCode) {}
  }
  
  void writeWindowUpdateLater(int paramInt, long paramLong)
  {
    try
    {
      this.writerExecutor.execute(new Http2Connection.2(this, "OkHttp Window Update %s stream %d", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramLong));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection
 * JD-Core Version:    0.7.0.1
 */