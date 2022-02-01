package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import okhttp3.Headers;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

final class Http2Stream$FramingSource
  implements Source
{
  boolean closed;
  boolean finished;
  private final long maxByteCount;
  private final Buffer readBuffer = new Buffer();
  private final Buffer receiveBuffer = new Buffer();
  
  static
  {
    if (!Http2Stream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  Http2Stream$FramingSource(Http2Stream paramHttp2Stream, long paramLong)
  {
    this.maxByteCount = paramLong;
  }
  
  private void updateConnectionFlowControl(long paramLong)
  {
    assert (!Thread.holdsLock(this.this$0));
    this.this$0.connection.updateConnectionFlowControl(paramLong);
  }
  
  public void close()
  {
    Object localObject1 = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        this.closed = true;
        long l = this.readBuffer.size();
        this.readBuffer.clear();
        if ((Http2Stream.access$000(this.this$0).isEmpty()) || (Http2Stream.access$100(this.this$0) == null)) {
          break label167;
        }
        localObject1 = new ArrayList(Http2Stream.access$000(this.this$0));
        Http2Stream.access$000(this.this$0).clear();
        localListener = Http2Stream.access$100(this.this$0);
        this.this$0.notifyAll();
        if (l > 0L) {
          updateConnectionFlowControl(l);
        }
        this.this$0.cancelStreamIfNecessary();
        if (localListener != null)
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext()) {
            localListener.onHeaders((Headers)((Iterator)localObject1).next());
          }
        }
      }
      return;
      label167:
      Header.Listener localListener = null;
    }
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    for (;;)
    {
      Http2Stream localHttp2Stream;
      try
      {
        if ((this.finished) || (localErrorCode != null)) {
          break label392;
        }
        this.this$0.waitForIo();
        label65:
        if (Http2Stream.access$000(this.this$0).isEmpty()) {
          break label230;
        }
      }
      finally
      {
        try
        {
          this.this$0.readTimeout.exitAndThrowIfTimedOut();
          localHttp2Stream = this.this$0;
          this.this$0.readTimeout.enter();
          if (this.this$0.errorCode == null) {
            break label415;
          }
          localErrorCode = this.this$0.errorCode;
          if (!this.closed) {
            break label139;
          }
          throw new IOException("stream closed");
        }
        finally {}
        paramBuffer = finally;
        this.this$0.readTimeout.exitAndThrowIfTimedOut();
      }
      label139:
      Headers localHeaders;
      Object localObject;
      long l;
      if (Http2Stream.access$100(this.this$0) != null)
      {
        localHeaders = (Headers)Http2Stream.access$000(this.this$0).removeFirst();
        localObject = Http2Stream.access$100(this.this$0);
        l = -1L;
      }
      for (;;)
      {
        this.this$0.readTimeout.exitAndThrowIfTimedOut();
        if ((localHeaders != null) && (localObject != null))
        {
          ((Header.Listener)localObject).onHeaders(localHeaders);
          break label65;
          label230:
          if (this.readBuffer.size() <= 0L) {
            break;
          }
          l = this.readBuffer.read(paramBuffer, Math.min(paramLong, this.readBuffer.size()));
          localObject = this.this$0;
          ((Http2Stream)localObject).unacknowledgedBytesRead += l;
          if ((localErrorCode != null) || (this.this$0.unacknowledgedBytesRead < this.this$0.connection.okHttpSettings.getInitialWindowSize() / 2)) {
            break label406;
          }
          this.this$0.connection.writeWindowUpdateLater(this.this$0.id, this.this$0.unacknowledgedBytesRead);
          this.this$0.unacknowledgedBytesRead = 0L;
          localObject = null;
          localHeaders = null;
          continue;
        }
        if (l != -1L)
        {
          updateConnectionFlowControl(l);
          return l;
        }
        if (localErrorCode != null) {
          throw new StreamResetException(localErrorCode);
        }
        return -1L;
        label392:
        l = -1L;
        localObject = null;
        localHeaders = null;
        continue;
        label406:
        localObject = null;
        localHeaders = null;
      }
      label415:
      ErrorCode localErrorCode = null;
    }
  }
  
  void receive(BufferedSource paramBufferedSource, long paramLong)
  {
    long l1 = paramLong;
    long l2;
    if (!$assertionsDisabled)
    {
      l1 = paramLong;
      if (Thread.holdsLock(this.this$0))
      {
        throw new AssertionError();
        l2 = l1 - paramLong;
      }
    }
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.closed)
        {
          paramLong = this.receiveBuffer.size();
          this.receiveBuffer.clear();
          l1 = l2;
          if (paramLong > 0L)
          {
            updateConnectionFlowControl(paramLong);
            l1 = l2;
          }
          if (l1 > 0L) {}
          boolean bool;
          synchronized (this.this$0)
          {
            bool = this.finished;
            if (this.readBuffer.size() + l1 > this.maxByteCount)
            {
              i = 1;
              if (i != 0)
              {
                paramBufferedSource.skip(l1);
                this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
              }
            }
            else
            {
              i = 0;
            }
          }
          if (bool)
          {
            paramBufferedSource.skip(l1);
            return;
          }
          paramLong = paramBufferedSource.read(this.receiveBuffer, l1);
          if (paramLong != -1L) {
            break;
          }
          throw new EOFException();
        }
        if (this.readBuffer.size() != 0L) {
          break label267;
        }
        i = 1;
        this.readBuffer.writeAll(this.receiveBuffer);
        if (i != 0) {
          this.this$0.notifyAll();
        }
      }
      paramLong = 0L;
      continue;
      label267:
      int i = 0;
    }
  }
  
  public Timeout timeout()
  {
    return this.this$0.readTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream.FramingSource
 * JD-Core Version:    0.7.0.1
 */