package okhttp3.internal.http2;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okio.BufferedSource;
import okio.ByteString;

class Http2Connection$ReaderRunnable
  extends NamedRunnable
  implements Http2Reader.Handler
{
  final Http2Reader reader;
  
  Http2Connection$ReaderRunnable(Http2Connection paramHttp2Connection, Http2Reader paramHttp2Reader)
  {
    super("OkHttp %s", new Object[] { paramHttp2Connection.hostname });
    this.reader = paramHttp2Reader;
  }
  
  public void ackSettings() {}
  
  public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
  
  void applyAndAckSettings(boolean paramBoolean, Settings paramSettings)
  {
    long l1;
    synchronized (this.this$0.writer)
    {
      synchronized (this.this$0)
      {
        int i = this.this$0.peerSettings.getInitialWindowSize();
        if (paramBoolean) {
          this.this$0.peerSettings.clear();
        }
        this.this$0.peerSettings.merge(paramSettings);
        int j = this.this$0.peerSettings.getInitialWindowSize();
        paramSettings = null;
        if ((j != -1) && (j != i))
        {
          long l2 = j - i;
          l1 = l2;
          if (!this.this$0.streams.isEmpty())
          {
            paramSettings = (Http2Stream[])this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);
            l1 = l2;
          }
          try
          {
            this.this$0.writer.applyAndAckSettings(this.this$0.peerSettings);
          }
          catch (IOException localIOException)
          {
            label175:
            break label175;
          }
          Http2Connection.access$000(this.this$0);
          if (paramSettings != null)
          {
            j = paramSettings.length;
            i = 0;
            while (i < j) {
              synchronized (paramSettings[i])
              {
                ???.addBytesToWriteWindow(l1);
                i += 1;
              }
            }
          }
          Http2Connection.access$400().execute(new Http2Connection.ReaderRunnable.3(this, "OkHttp %s settings", new Object[] { this.this$0.hostname }));
          return;
        }
      }
    }
  }
  
  public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
  {
    if (this.this$0.pushedStream(paramInt1))
    {
      this.this$0.pushDataLater(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
      return;
    }
    Object localObject = this.this$0.getStream(paramInt1);
    if (localObject == null)
    {
      this.this$0.writeSynResetLater(paramInt1, ErrorCode.PROTOCOL_ERROR);
      localObject = this.this$0;
      long l = paramInt2;
      ((Http2Connection)localObject).updateConnectionFlowControl(l);
      paramBufferedSource.skip(l);
      return;
    }
    ((Http2Stream)localObject).receiveData(paramBufferedSource, paramInt2);
    if (paramBoolean) {
      ((Http2Stream)localObject).receiveFin();
    }
  }
  
  /* Error */
  protected void execute()
  {
    // Byte code:
    //   0: getstatic 157	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   3: astore_3
    //   4: getstatic 157	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   7: astore 5
    //   9: aload_3
    //   10: astore_1
    //   11: aload_3
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   17: aload_0
    //   18: invokevirtual 163	okhttp3/internal/http2/Http2Reader:readConnectionPreface	(Lokhttp3/internal/http2/Http2Reader$Handler;)V
    //   21: aload_3
    //   22: astore_1
    //   23: aload_3
    //   24: astore_2
    //   25: aload_0
    //   26: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   29: iconst_0
    //   30: aload_0
    //   31: invokevirtual 167	okhttp3/internal/http2/Http2Reader:nextFrame	(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z
    //   34: ifeq +6 -> 40
    //   37: goto -16 -> 21
    //   40: aload_3
    //   41: astore_1
    //   42: aload_3
    //   43: astore_2
    //   44: getstatic 170	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   47: astore_3
    //   48: aload_3
    //   49: astore_1
    //   50: aload_3
    //   51: astore_2
    //   52: getstatic 173	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
    //   55: astore 4
    //   57: aload_0
    //   58: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
    //   61: astore 5
    //   63: aload_3
    //   64: astore_2
    //   65: aload 4
    //   67: astore_1
    //   68: aload 5
    //   70: astore_3
    //   71: goto +28 -> 99
    //   74: astore_2
    //   75: goto +38 -> 113
    //   78: aload_2
    //   79: astore_1
    //   80: getstatic 135	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: getstatic 135	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
    //   95: astore_3
    //   96: aload 4
    //   98: astore_1
    //   99: aload_3
    //   100: aload_2
    //   101: aload_1
    //   102: invokevirtual 177	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
    //   105: aload_0
    //   106: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   109: invokestatic 183	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   112: return
    //   113: aload_0
    //   114: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
    //   117: aload_1
    //   118: aload 5
    //   120: invokevirtual 177	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
    //   123: aload_0
    //   124: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   127: invokestatic 183	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   130: goto +5 -> 135
    //   133: aload_2
    //   134: athrow
    //   135: goto -2 -> 133
    //   138: astore_1
    //   139: goto -61 -> 78
    //   142: astore_1
    //   143: goto -38 -> 105
    //   146: astore_1
    //   147: goto -24 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	ReaderRunnable
    //   10	108	1	localObject1	Object
    //   138	1	1	localIOException1	IOException
    //   142	1	1	localIOException2	IOException
    //   146	1	1	localIOException3	IOException
    //   12	53	2	localObject2	Object
    //   74	5	2	localObject3	Object
    //   83	51	2	localErrorCode1	ErrorCode
    //   3	97	3	localObject4	Object
    //   55	42	4	localErrorCode2	ErrorCode
    //   7	112	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   13	21	74	finally
    //   25	37	74	finally
    //   44	48	74	finally
    //   52	57	74	finally
    //   80	84	74	finally
    //   86	91	74	finally
    //   13	21	138	java/io/IOException
    //   25	37	138	java/io/IOException
    //   44	48	138	java/io/IOException
    //   52	57	138	java/io/IOException
    //   57	63	142	java/io/IOException
    //   91	96	142	java/io/IOException
    //   99	105	142	java/io/IOException
    //   113	123	146	java/io/IOException
  }
  
  public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
  {
    paramByteString.size();
    synchronized (this.this$0)
    {
      paramByteString = (Http2Stream[])this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);
      Http2Connection.access$302(this.this$0, true);
      int j = paramByteString.length;
      int i = 0;
      while (i < j)
      {
        ??? = paramByteString[i];
        if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
        {
          ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
          this.this$0.removeStream(???.getId());
        }
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  public void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList)
  {
    if (this.this$0.pushedStream(paramInt1))
    {
      this.this$0.pushHeadersLater(paramInt1, paramList, paramBoolean);
      return;
    }
    synchronized (this.this$0)
    {
      Http2Stream localHttp2Stream = this.this$0.getStream(paramInt1);
      if (localHttp2Stream == null)
      {
        if (Http2Connection.access$300(this.this$0)) {
          return;
        }
        if (paramInt1 <= this.this$0.lastGoodStreamId) {
          return;
        }
        if (paramInt1 % 2 == this.this$0.nextStreamId % 2) {
          return;
        }
        paramList = Util.toHeaders(paramList);
        paramList = new Http2Stream(paramInt1, this.this$0, false, paramBoolean, paramList);
        this.this$0.lastGoodStreamId = paramInt1;
        this.this$0.streams.put(Integer.valueOf(paramInt1), paramList);
        Http2Connection.access$400().execute(new Http2Connection.ReaderRunnable.1(this, "OkHttp %s stream %d", new Object[] { this.this$0.hostname, Integer.valueOf(paramInt1) }, paramList));
        return;
      }
      localHttp2Stream.receiveHeaders(paramList);
      if (paramBoolean) {
        localHttp2Stream.receiveFin();
      }
      return;
    }
  }
  
  public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Http2Connection localHttp2Connection;
    if (paramBoolean)
    {
      localHttp2Connection = this.this$0;
      if (paramInt1 != 1) {}
    }
    try
    {
      Http2Connection.access$108(this.this$0);
      break label65;
      if (paramInt1 == 2)
      {
        Http2Connection.access$608(this.this$0);
      }
      else if (paramInt1 == 3)
      {
        Http2Connection.access$708(this.this$0);
        this.this$0.notifyAll();
      }
      label65:
      return;
    }
    finally
    {
      label69:
      Object localObject1;
      break label69;
    }
    throw localObject1;
    try
    {
      Http2Connection.access$500(this.this$0).execute(new Http2Connection.PingRunnable(this.this$0, true, paramInt1, paramInt2));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
  {
    this.this$0.pushRequestLater(paramInt2, paramList);
  }
  
  public void rstStream(int paramInt, ErrorCode paramErrorCode)
  {
    if (this.this$0.pushedStream(paramInt))
    {
      this.this$0.pushResetLater(paramInt, paramErrorCode);
      return;
    }
    Http2Stream localHttp2Stream = this.this$0.removeStream(paramInt);
    if (localHttp2Stream != null) {
      localHttp2Stream.receiveRstStream(paramErrorCode);
    }
  }
  
  public void settings(boolean paramBoolean, Settings paramSettings)
  {
    try
    {
      Http2Connection.access$500(this.this$0).execute(new Http2Connection.ReaderRunnable.2(this, "OkHttp %s ACK Settings", new Object[] { this.this$0.hostname }, paramBoolean, paramSettings));
      return;
    }
    catch (RejectedExecutionException paramSettings) {}
  }
  
  public void windowUpdate(int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      synchronized (this.this$0)
      {
        Http2Connection localHttp2Connection = this.this$0;
        localHttp2Connection.bytesLeftInWriteWindow += paramLong;
        this.this$0.notifyAll();
        return;
      }
    }
    ??? = this.this$0.getStream(paramInt);
    if (??? != null) {
      try
      {
        ((Http2Stream)???).addBytesToWriteWindow(paramLong);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.ReaderRunnable
 * JD-Core Version:    0.7.0.1
 */