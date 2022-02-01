package okhttp3.internal.http2;

import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class Http2Stream$FramingSink
  implements Sink
{
  private static final long EMIT_BUFFER_SIZE = 16384L;
  boolean closed;
  boolean finished;
  private final Buffer sendBuffer = new Buffer();
  
  static
  {
    if (!Http2Stream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  Http2Stream$FramingSink(Http2Stream paramHttp2Stream) {}
  
  /* Error */
  private void emitFrame(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   13: getfield 48	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   16: invokevirtual 53	okhttp3/internal/http2/Http2Stream$StreamTimeout:enter	()V
    //   19: aload_0
    //   20: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   23: getfield 56	okhttp3/internal/http2/Http2Stream:bytesLeftInWriteWindow	J
    //   26: lconst_0
    //   27: lcmp
    //   28: ifgt +60 -> 88
    //   31: aload_0
    //   32: getfield 58	okhttp3/internal/http2/Http2Stream$FramingSink:finished	Z
    //   35: ifne +53 -> 88
    //   38: aload_0
    //   39: getfield 60	okhttp3/internal/http2/Http2Stream$FramingSink:closed	Z
    //   42: ifne +46 -> 88
    //   45: aload_0
    //   46: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   49: getfield 64	okhttp3/internal/http2/Http2Stream:errorCode	Lokhttp3/internal/http2/ErrorCode;
    //   52: ifnonnull +36 -> 88
    //   55: aload_0
    //   56: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   59: invokevirtual 67	okhttp3/internal/http2/Http2Stream:waitForIo	()V
    //   62: goto -43 -> 19
    //   65: astore 6
    //   67: aload_0
    //   68: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   71: getfield 48	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   74: invokevirtual 70	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   77: aload 6
    //   79: athrow
    //   80: astore 6
    //   82: aload 5
    //   84: monitorexit
    //   85: aload 6
    //   87: athrow
    //   88: aload_0
    //   89: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   92: getfield 48	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   95: invokevirtual 70	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   98: aload_0
    //   99: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   102: invokevirtual 73	okhttp3/internal/http2/Http2Stream:checkOutNotClosed	()V
    //   105: aload_0
    //   106: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   109: getfield 56	okhttp3/internal/http2/Http2Stream:bytesLeftInWriteWindow	J
    //   112: aload_0
    //   113: getfield 42	okhttp3/internal/http2/Http2Stream$FramingSink:sendBuffer	Lokio/Buffer;
    //   116: invokevirtual 77	okio/Buffer:size	()J
    //   119: invokestatic 83	java/lang/Math:min	(JJ)J
    //   122: lstore_3
    //   123: aload_0
    //   124: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   127: astore 6
    //   129: aload 6
    //   131: aload 6
    //   133: getfield 56	okhttp3/internal/http2/Http2Stream:bytesLeftInWriteWindow	J
    //   136: lload_3
    //   137: lsub
    //   138: putfield 56	okhttp3/internal/http2/Http2Stream:bytesLeftInWriteWindow	J
    //   141: aload 5
    //   143: monitorexit
    //   144: aload_0
    //   145: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   148: getfield 48	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   151: invokevirtual 53	okhttp3/internal/http2/Http2Stream$StreamTimeout:enter	()V
    //   154: aload_0
    //   155: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   158: getfield 87	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   161: astore 5
    //   163: aload_0
    //   164: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   167: getfield 91	okhttp3/internal/http2/Http2Stream:id	I
    //   170: istore_2
    //   171: iload_1
    //   172: ifeq +40 -> 212
    //   175: lload_3
    //   176: aload_0
    //   177: getfield 42	okhttp3/internal/http2/Http2Stream$FramingSink:sendBuffer	Lokio/Buffer;
    //   180: invokevirtual 77	okio/Buffer:size	()J
    //   183: lcmp
    //   184: ifne +28 -> 212
    //   187: iconst_1
    //   188: istore_1
    //   189: aload 5
    //   191: iload_2
    //   192: iload_1
    //   193: aload_0
    //   194: getfield 42	okhttp3/internal/http2/Http2Stream$FramingSink:sendBuffer	Lokio/Buffer;
    //   197: lload_3
    //   198: invokevirtual 97	okhttp3/internal/http2/Http2Connection:writeData	(IZLokio/Buffer;J)V
    //   201: aload_0
    //   202: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   205: getfield 48	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   208: invokevirtual 70	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   211: return
    //   212: iconst_0
    //   213: istore_1
    //   214: goto -25 -> 189
    //   217: astore 5
    //   219: aload_0
    //   220: getfield 35	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
    //   223: getfield 48	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   226: invokevirtual 70	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   229: aload 5
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	FramingSink
    //   0	232	1	paramBoolean	boolean
    //   170	22	2	i	int
    //   122	76	3	l	long
    //   4	186	5	localObject1	Object
    //   217	13	5	localObject2	Object
    //   65	13	6	localObject3	Object
    //   80	6	6	localObject4	Object
    //   127	5	6	localHttp2Stream	Http2Stream
    // Exception table:
    //   from	to	target	type
    //   19	62	65	finally
    //   9	19	80	finally
    //   67	80	80	finally
    //   82	85	80	finally
    //   88	144	80	finally
    //   154	171	217	finally
    //   175	187	217	finally
    //   189	201	217	finally
  }
  
  public void close()
  {
    assert (!Thread.holdsLock(this.this$0));
    synchronized (this.this$0)
    {
      if (this.closed) {
        return;
      }
      if (this.this$0.sink.finished) {
        break label113;
      }
      if (this.sendBuffer.size() > 0L)
      {
        if (this.sendBuffer.size() <= 0L) {
          break label113;
        }
        emitFrame(true);
      }
    }
    this.this$0.connection.writeData(this.this$0.id, true, null, 0L);
    label113:
    synchronized (this.this$0)
    {
      this.closed = true;
      this.this$0.connection.flush();
      this.this$0.cancelStreamIfNecessary();
      return;
    }
  }
  
  public void flush()
  {
    assert (!Thread.holdsLock(this.this$0));
    synchronized (this.this$0)
    {
      this.this$0.checkOutNotClosed();
      if (this.sendBuffer.size() > 0L)
      {
        emitFrame(false);
        this.this$0.connection.flush();
      }
    }
  }
  
  public Timeout timeout()
  {
    return this.this$0.writeTimeout;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    assert (!Thread.holdsLock(this.this$0));
    this.sendBuffer.write(paramBuffer, paramLong);
    while (this.sendBuffer.size() >= 16384L) {
      emitFrame(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream.FramingSink
 * JD-Core Version:    0.7.0.1
 */