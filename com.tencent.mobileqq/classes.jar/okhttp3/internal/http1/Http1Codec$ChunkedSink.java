package okhttp3.internal.http1;

import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

final class Http1Codec$ChunkedSink
  implements Sink
{
  private boolean closed;
  private final ForwardingTimeout timeout = new ForwardingTimeout(this.this$0.sink.timeout());
  
  Http1Codec$ChunkedSink(Http1Codec paramHttp1Codec) {}
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	okhttp3/internal/http1/Http1Codec$ChunkedSink:closed	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 41	okhttp3/internal/http1/Http1Codec$ChunkedSink:closed	Z
    //   19: aload_0
    //   20: getfield 16	okhttp3/internal/http1/Http1Codec$ChunkedSink:this$0	Lokhttp3/internal/http1/Http1Codec;
    //   23: getfield 27	okhttp3/internal/http1/Http1Codec:sink	Lokio/BufferedSink;
    //   26: ldc 43
    //   28: invokeinterface 47 2 0
    //   33: pop
    //   34: aload_0
    //   35: getfield 16	okhttp3/internal/http1/Http1Codec$ChunkedSink:this$0	Lokhttp3/internal/http1/Http1Codec;
    //   38: aload_0
    //   39: getfield 37	okhttp3/internal/http1/Http1Codec$ChunkedSink:timeout	Lokio/ForwardingTimeout;
    //   42: invokevirtual 51	okhttp3/internal/http1/Http1Codec:detachTimeout	(Lokio/ForwardingTimeout;)V
    //   45: aload_0
    //   46: getfield 16	okhttp3/internal/http1/Http1Codec$ChunkedSink:this$0	Lokhttp3/internal/http1/Http1Codec;
    //   49: iconst_3
    //   50: putfield 55	okhttp3/internal/http1/Http1Codec:state	I
    //   53: goto -42 -> 11
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	ChunkedSink
    //   6	2	1	bool	boolean
    //   56	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	56	finally
    //   14	53	56	finally
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	okhttp3/internal/http1/Http1Codec$ChunkedSink:closed	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 16	okhttp3/internal/http1/Http1Codec$ChunkedSink:this$0	Lokhttp3/internal/http1/Http1Codec;
    //   18: getfield 27	okhttp3/internal/http1/Http1Codec:sink	Lokio/BufferedSink;
    //   21: invokeinterface 58 1 0
    //   26: goto -15 -> 11
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	ChunkedSink
    //   6	2	1	bool	boolean
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == 0L) {
      return;
    }
    this.this$0.sink.writeHexadecimalUnsignedLong(paramLong);
    this.this$0.sink.writeUtf8("\r\n");
    this.this$0.sink.write(paramBuffer, paramLong);
    this.this$0.sink.writeUtf8("\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.ChunkedSink
 * JD-Core Version:    0.7.0.1
 */