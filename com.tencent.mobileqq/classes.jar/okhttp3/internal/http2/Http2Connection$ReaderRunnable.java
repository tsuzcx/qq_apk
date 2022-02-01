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
    ??? = null;
    label275:
    label283:
    for (;;)
    {
      int i;
      synchronized (this.this$0.writer)
      {
        synchronized (this.this$0)
        {
          i = this.this$0.peerSettings.getInitialWindowSize();
          if (paramBoolean) {
            this.this$0.peerSettings.clear();
          }
          this.this$0.peerSettings.merge(paramSettings);
          int j = this.this$0.peerSettings.getInitialWindowSize();
          if ((j == -1) || (j == i)) {
            break label275;
          }
          l = j - i;
          paramSettings = ???;
          if (this.this$0.streams.isEmpty()) {
            break label283;
          }
          paramSettings = (Http2Stream[])this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);
          break label283;
          try
          {
            this.this$0.writer.applyAndAckSettings(this.this$0.peerSettings);
            if (paramSettings == null) {
              break label242;
            }
            j = paramSettings.length;
            i = 0;
          }
          catch (IOException localIOException)
          {
            synchronized (paramSettings[i])
            {
              ???.addBytesToWriteWindow(l);
              i += 1;
              continue;
              paramSettings = finally;
              throw paramSettings;
              paramSettings = finally;
              throw paramSettings;
              localIOException = localIOException;
              Http2Connection.access$000(this.this$0);
            }
          }
          if (i >= j) {}
        }
      }
      label242:
      Http2Connection.access$400().execute(new Http2Connection.ReaderRunnable.3(this, "OkHttp %s settings", new Object[] { this.this$0.hostname }));
      return;
      long l = 0L;
      paramSettings = null;
    }
  }
  
  public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
  {
    if (this.this$0.pushedStream(paramInt1)) {
      this.this$0.pushDataLater(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
    }
    Http2Stream localHttp2Stream;
    do
    {
      return;
      localHttp2Stream = this.this$0.getStream(paramInt1);
      if (localHttp2Stream == null)
      {
        this.this$0.writeSynResetLater(paramInt1, ErrorCode.PROTOCOL_ERROR);
        this.this$0.updateConnectionFlowControl(paramInt2);
        paramBufferedSource.skip(paramInt2);
        return;
      }
      localHttp2Stream.receiveData(paramBufferedSource, paramInt2);
    } while (!paramBoolean);
    localHttp2Stream.receiveFin();
  }
  
  /* Error */
  public void execute()
  {
    // Byte code:
    //   0: getstatic 157	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   3: astore_3
    //   4: getstatic 157	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   7: astore 4
    //   9: aload_3
    //   10: astore_2
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   17: aload_0
    //   18: invokevirtual 163	okhttp3/internal/http2/Http2Reader:readConnectionPreface	(Lokhttp3/internal/http2/Http2Reader$Handler;)V
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   29: iconst_0
    //   30: aload_0
    //   31: invokevirtual 167	okhttp3/internal/http2/Http2Reader:nextFrame	(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z
    //   34: ifne -13 -> 21
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: getstatic 170	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: astore_1
    //   49: getstatic 173	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
    //   58: aload_3
    //   59: aload 5
    //   61: invokevirtual 177	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
    //   64: aload_0
    //   65: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   68: invokestatic 183	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   71: return
    //   72: astore_1
    //   73: aload_2
    //   74: astore_1
    //   75: getstatic 135	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   78: astore_3
    //   79: getstatic 135	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   82: astore_1
    //   83: aload_0
    //   84: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
    //   87: aload_3
    //   88: aload_1
    //   89: invokevirtual 177	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
    //   92: aload_0
    //   93: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   96: invokestatic 183	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   99: return
    //   100: astore_2
    //   101: aload_1
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 14	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
    //   109: aload_3
    //   110: aload 4
    //   112: invokevirtual 177	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
    //   115: aload_0
    //   116: getfield 29	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
    //   119: invokestatic 183	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_2
    //   125: goto -10 -> 115
    //   128: astore_1
    //   129: goto -24 -> 105
    //   132: astore_1
    //   133: goto -41 -> 92
    //   136: astore_1
    //   137: goto -73 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	ReaderRunnable
    //   12	37	1	localObject1	Object
    //   72	1	1	localIOException1	IOException
    //   74	49	1	localObject2	Object
    //   128	1	1	localObject3	Object
    //   132	1	1	localIOException2	IOException
    //   136	1	1	localIOException3	IOException
    //   10	64	2	localObject4	Object
    //   100	4	2	localObject5	Object
    //   124	1	2	localIOException4	IOException
    //   3	107	3	localObject6	Object
    //   7	104	4	localErrorCode1	ErrorCode
    //   52	8	5	localErrorCode2	ErrorCode
    // Exception table:
    //   from	to	target	type
    //   13	21	72	java/io/IOException
    //   25	37	72	java/io/IOException
    //   41	45	72	java/io/IOException
    //   49	54	72	java/io/IOException
    //   13	21	100	finally
    //   25	37	100	finally
    //   41	45	100	finally
    //   49	54	100	finally
    //   75	79	100	finally
    //   105	115	124	java/io/IOException
    //   79	83	128	finally
    //   83	92	132	java/io/IOException
    //   54	64	136	java/io/IOException
  }
  
  public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
  {
    if (paramByteString.size() > 0) {}
    synchronized (this.this$0)
    {
      paramByteString = (Http2Stream[])this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);
      Http2Connection.access$302(this.this$0, true);
      int j = paramByteString.length;
      int i = 0;
      if (i < j)
      {
        ??? = paramByteString[i];
        if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
        {
          ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
          this.this$0.removeStream(???.getId());
        }
        i += 1;
      }
    }
  }
  
  public void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList)
  {
    if (this.this$0.pushedStream(paramInt1)) {
      this.this$0.pushHeadersLater(paramInt1, paramList, paramBoolean);
    }
    Http2Stream localHttp2Stream;
    label200:
    do
    {
      return;
      synchronized (this.this$0)
      {
        localHttp2Stream = this.this$0.getStream(paramInt1);
        if (localHttp2Stream != null) {
          break label200;
        }
        if (Http2Connection.access$300(this.this$0)) {
          return;
        }
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
      localHttp2Stream.receiveHeaders(paramList);
    } while (!paramBoolean);
    localHttp2Stream.receiveFin();
  }
  
  public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      Http2Connection localHttp2Connection = this.this$0;
      if (paramInt1 == 1) {}
      for (;;)
      {
        try
        {
          Http2Connection.access$108(this.this$0);
          return;
        }
        finally {}
        if (paramInt1 == 2)
        {
          Http2Connection.access$608(this.this$0);
        }
        else if (paramInt1 == 3)
        {
          Http2Connection.access$708(this.this$0);
          this.this$0.notifyAll();
        }
      }
    }
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
    if (this.this$0.pushedStream(paramInt)) {
      this.this$0.pushResetLater(paramInt, paramErrorCode);
    }
    Http2Stream localHttp2Stream;
    do
    {
      return;
      localHttp2Stream = this.this$0.removeStream(paramInt);
    } while (localHttp2Stream == null);
    localHttp2Stream.receiveRstStream(paramErrorCode);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.ReaderRunnable
 * JD-Core Version:    0.7.0.1
 */