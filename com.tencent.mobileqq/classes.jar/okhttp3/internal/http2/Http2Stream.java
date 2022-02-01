package okhttp3.internal.http2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream
{
  long bytesLeftInWriteWindow;
  final Http2Connection connection;
  ErrorCode errorCode = null;
  private boolean hasResponseHeaders;
  private Header.Listener headersListener;
  private final Deque<Headers> headersQueue = new ArrayDeque();
  final int id;
  final Http2Stream.StreamTimeout readTimeout = new Http2Stream.StreamTimeout(this);
  final Http2Stream.FramingSink sink;
  private final Http2Stream.FramingSource source;
  long unacknowledgedBytesRead = 0L;
  final Http2Stream.StreamTimeout writeTimeout = new Http2Stream.StreamTimeout(this);
  
  static
  {
    if (!Http2Stream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  Http2Stream(int paramInt, Http2Connection paramHttp2Connection, boolean paramBoolean1, boolean paramBoolean2, @Nullable Headers paramHeaders)
  {
    if (paramHttp2Connection == null) {
      throw new NullPointerException("connection == null");
    }
    this.id = paramInt;
    this.connection = paramHttp2Connection;
    this.bytesLeftInWriteWindow = paramHttp2Connection.peerSettings.getInitialWindowSize();
    this.source = new Http2Stream.FramingSource(this, paramHttp2Connection.okHttpSettings.getInitialWindowSize());
    this.sink = new Http2Stream.FramingSink(this);
    this.source.finished = paramBoolean2;
    this.sink.finished = paramBoolean1;
    if (paramHeaders != null) {
      this.headersQueue.add(paramHeaders);
    }
    if ((isLocallyInitiated()) && (paramHeaders != null)) {
      throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
    }
    if ((!isLocallyInitiated()) && (paramHeaders == null)) {
      throw new IllegalStateException("remotely-initiated streams should have headers");
    }
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    assert (!Thread.holdsLock(this));
    try
    {
      if (this.errorCode != null) {
        return false;
      }
      if ((this.source.finished) && (this.sink.finished)) {
        return false;
      }
    }
    finally {}
    this.errorCode = paramErrorCode;
    notifyAll();
    this.connection.removeStream(this.id);
    return true;
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  void cancelStreamIfNecessary()
  {
    assert (!Thread.holdsLock(this));
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.source.finished) && (this.source.closed))
        {
          if (this.sink.finished) {
            break label112;
          }
          if (this.sink.closed)
          {
            break label112;
            bool = isOpen();
            if (i == 0) {
              break label95;
            }
            close(ErrorCode.CANCEL);
            return;
          }
        }
        i = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.connection.removeStream(this.id);
      return;
      label112:
      int i = 1;
    }
  }
  
  void checkOutNotClosed()
  {
    if (this.sink.closed) {
      throw new IOException("stream closed");
    }
    if (this.sink.finished) {
      throw new IOException("stream finished");
    }
    if (this.errorCode != null) {
      throw new StreamResetException(this.errorCode);
    }
  }
  
  public void close(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynReset(this.id, paramErrorCode);
  }
  
  public void closeLater(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }
  
  public Http2Connection getConnection()
  {
    return this.connection;
  }
  
  public ErrorCode getErrorCode()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public Sink getSink()
  {
    try
    {
      if ((!this.hasResponseHeaders) && (!isLocallyInitiated())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.sink;
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isLocallyInitiated()
  {
    if ((this.id & 0x1) == 1) {}
    for (int i = 1; this.connection.client == i; i = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public boolean isOpen()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 62	okhttp3/internal/http2/Http2Stream:errorCode	Lokhttp3/internal/http2/ErrorCode;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 97	okhttp3/internal/http2/Http2Stream:source	Lokhttp3/internal/http2/Http2Stream$FramingSource;
    //   21: getfield 105	okhttp3/internal/http2/Http2Stream$FramingSource:finished	Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 97	okhttp3/internal/http2/Http2Stream:source	Lokhttp3/internal/http2/Http2Stream$FramingSource;
    //   31: getfield 152	okhttp3/internal/http2/Http2Stream$FramingSource:closed	Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 102	okhttp3/internal/http2/Http2Stream:sink	Lokhttp3/internal/http2/Http2Stream$FramingSink;
    //   41: getfield 106	okhttp3/internal/http2/Http2Stream$FramingSink:finished	Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 102	okhttp3/internal/http2/Http2Stream:sink	Lokhttp3/internal/http2/Http2Stream$FramingSink;
    //   51: getfield 153	okhttp3/internal/http2/Http2Stream$FramingSink:closed	Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 196	okhttp3/internal/http2/Http2Stream:hasResponseHeaders	Z
    //   61: istore_2
    //   62: iload_2
    //   63: ifne -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	Http2Stream
    //   1	67	1	bool1	boolean
    //   61	2	2	bool2	boolean
    //   8	2	3	localErrorCode	ErrorCode
    //   71	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public Timeout readTimeout()
  {
    return this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt)
  {
    assert (!Thread.holdsLock(this));
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin()
  {
    assert (!Thread.holdsLock(this));
    try
    {
      this.source.finished = true;
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveHeaders(List<Header> paramList)
  {
    assert (!Thread.holdsLock(this));
    try
    {
      this.hasResponseHeaders = true;
      this.headersQueue.add(Util.toHeaders(paramList));
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveRstStream(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public void setHeadersListener(Header.Listener paramListener)
  {
    try
    {
      this.headersListener = paramListener;
      if ((!this.headersQueue.isEmpty()) && (paramListener != null)) {
        notifyAll();
      }
      return;
    }
    finally {}
  }
  
  public Headers takeHeaders()
  {
    try
    {
      this.readTimeout.enter();
    }
    finally
    {
      try
      {
        while ((this.headersQueue.isEmpty()) && (this.errorCode == null)) {
          waitForIo();
        }
      }
      finally
      {
        this.readTimeout.exitAndThrowIfTimedOut();
      }
    }
    this.readTimeout.exitAndThrowIfTimedOut();
    if (!this.headersQueue.isEmpty())
    {
      Headers localHeaders = (Headers)this.headersQueue.removeFirst();
      return localHeaders;
    }
    throw new StreamResetException(this.errorCode);
  }
  
  void waitForIo()
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      throw new InterruptedIOException();
    }
  }
  
  /* Error */
  public void writeHeaders(List<Header> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 38	okhttp3/internal/http2/Http2Stream:$assertionsDisabled	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 136	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 138	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 139	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_1
    //   22: ifnonnull +14 -> 36
    //   25: new 64	java/lang/NullPointerException
    //   28: dup
    //   29: ldc_w 263
    //   32: invokespecial 69	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 196	okhttp3/internal/http2/Http2Stream:hasResponseHeaders	Z
    //   43: iload_2
    //   44: ifne +95 -> 139
    //   47: aload_0
    //   48: getfield 102	okhttp3/internal/http2/Http2Stream:sink	Lokhttp3/internal/http2/Http2Stream$FramingSink;
    //   51: iconst_1
    //   52: putfield 106	okhttp3/internal/http2/Http2Stream$FramingSink:finished	Z
    //   55: iconst_1
    //   56: istore_3
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: istore 4
    //   64: iload_3
    //   65: ifne +32 -> 97
    //   68: aload_0
    //   69: getfield 73	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   72: astore 5
    //   74: aload 5
    //   76: monitorenter
    //   77: aload_0
    //   78: getfield 73	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   81: getfield 264	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   84: lconst_0
    //   85: lcmp
    //   86: ifne +42 -> 128
    //   89: iconst_1
    //   90: istore_3
    //   91: aload 5
    //   93: monitorexit
    //   94: iload_3
    //   95: istore 4
    //   97: aload_0
    //   98: getfield 73	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   101: aload_0
    //   102: getfield 71	okhttp3/internal/http2/Http2Stream:id	I
    //   105: iload_2
    //   106: aload_1
    //   107: invokevirtual 268	okhttp3/internal/http2/Http2Connection:writeSynReply	(IZLjava/util/List;)V
    //   110: iload 4
    //   112: ifeq +10 -> 122
    //   115: aload_0
    //   116: getfield 73	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   119: invokevirtual 271	okhttp3/internal/http2/Http2Connection:flush	()V
    //   122: return
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: iconst_0
    //   129: istore_3
    //   130: goto -39 -> 91
    //   133: astore_1
    //   134: aload 5
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: iconst_0
    //   140: istore_3
    //   141: iconst_0
    //   142: istore_2
    //   143: goto -84 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	Http2Stream
    //   0	146	1	paramList	List<Header>
    //   0	146	2	paramBoolean	boolean
    //   56	85	3	i	int
    //   62	49	4	j	int
    // Exception table:
    //   from	to	target	type
    //   38	43	123	finally
    //   47	55	123	finally
    //   59	61	123	finally
    //   124	126	123	finally
    //   77	89	133	finally
    //   91	94	133	finally
    //   134	137	133	finally
  }
  
  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream
 * JD-Core Version:    0.7.0.1
 */