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
  
  Http2Stream$FramingSource(Http2Stream paramHttp2Stream, long paramLong)
  {
    this.maxByteCount = paramLong;
  }
  
  private void updateConnectionFlowControl(long paramLong)
  {
    this.this$0.connection.updateConnectionFlowControl(paramLong);
  }
  
  public void close()
  {
    Object localObject2;
    synchronized (this.this$0)
    {
      this.closed = true;
      long l = this.readBuffer.size();
      this.readBuffer.clear();
      boolean bool = Http2Stream.access$000(this.this$0).isEmpty();
      Object localObject3 = null;
      if ((!bool) && (Http2Stream.access$100(this.this$0) != null))
      {
        localObject3 = new ArrayList(Http2Stream.access$000(this.this$0));
        Http2Stream.access$000(this.this$0).clear();
        Header.Listener localListener = Http2Stream.access$100(this.this$0);
        this.this$0.notifyAll();
        if (l > 0L) {
          updateConnectionFlowControl(l);
        }
        this.this$0.cancelStreamIfNecessary();
        if (localListener != null)
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            localListener.onHeaders((Headers)((Iterator)localObject3).next());
          }
        }
        return;
      }
    }
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramLong >= 0L) {}
    for (;;)
    {
      synchronized (this.this$0)
      {
        this.this$0.readTimeout.enter();
        try
        {
          if (this.this$0.errorCode == null) {
            break label421;
          }
          localErrorCode = this.this$0.errorCode;
          if (!this.closed)
          {
            if ((!Http2Stream.access$000(this.this$0).isEmpty()) && (Http2Stream.access$100(this.this$0) != null))
            {
              localObject = (Headers)Http2Stream.access$000(this.this$0).removeFirst();
              localListener = Http2Stream.access$100(this.this$0);
              l1 = -1L;
            }
            else
            {
              if (this.readBuffer.size() > 0L)
              {
                long l2 = this.readBuffer.read(paramBuffer, Math.min(paramLong, this.readBuffer.size()));
                localObject = this.this$0;
                ((Http2Stream)localObject).unacknowledgedBytesRead += l2;
                l1 = l2;
                if (localErrorCode != null) {
                  break label432;
                }
                l1 = l2;
                if (this.this$0.unacknowledgedBytesRead < this.this$0.connection.okHttpSettings.getInitialWindowSize() / 2) {
                  break label432;
                }
                this.this$0.connection.writeWindowUpdateLater(this.this$0.id, this.this$0.unacknowledgedBytesRead);
                this.this$0.unacknowledgedBytesRead = 0L;
                l1 = l2;
                break label432;
              }
              if ((this.finished) || (localErrorCode != null)) {
                break label427;
              }
              this.this$0.waitForIo();
              this.this$0.readTimeout.exitAndThrowIfTimedOut();
              continue;
            }
            this.this$0.readTimeout.exitAndThrowIfTimedOut();
            if ((localObject != null) && (localListener != null))
            {
              localListener.onHeaders((Headers)localObject);
              continue;
            }
            if (l1 != -1L)
            {
              updateConnectionFlowControl(l1);
              return l1;
            }
            if (localErrorCode == null) {
              return -1L;
            }
            throw new StreamResetException(localErrorCode);
          }
          throw new IOException("stream closed");
        }
        finally
        {
          this.this$0.readTimeout.exitAndThrowIfTimedOut();
        }
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      paramBuffer = new IllegalArgumentException(paramBuffer.toString());
      for (;;)
      {
        throw paramBuffer;
      }
      label421:
      ErrorCode localErrorCode = null;
      continue;
      label427:
      long l1 = -1L;
      label432:
      Object localObject = null;
      Header.Listener localListener = null;
    }
  }
  
  void receive(BufferedSource paramBufferedSource, long paramLong)
  {
    if (paramLong > 0L) {}
    for (;;)
    {
      synchronized (this.this$0)
      {
        for (;;)
        {
          boolean bool = this.finished;
          l1 = this.readBuffer.size();
          long l2 = this.maxByteCount;
          int j = 1;
          if (l1 + paramLong <= l2) {
            break label249;
          }
          i = 1;
          if (i != 0)
          {
            paramBufferedSource.skip(paramLong);
            this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
          }
          if (bool)
          {
            paramBufferedSource.skip(paramLong);
            return;
          }
          l1 = paramBufferedSource.read(this.receiveBuffer, paramLong);
          if (l1 != -1L)
          {
            l2 = paramLong - l1;
            synchronized (this.this$0)
            {
              if (this.closed)
              {
                l1 = this.receiveBuffer.size();
                this.receiveBuffer.clear();
              }
              else
              {
                if (this.readBuffer.size() != 0L) {
                  break label255;
                }
                i = j;
                this.readBuffer.writeAll(this.receiveBuffer);
                if (i == 0) {
                  break label261;
                }
                this.this$0.notifyAll();
                break label261;
              }
              paramLong = l2;
              if (l1 <= 0L) {
                break;
              }
              updateConnectionFlowControl(l1);
              paramLong = l2;
            }
          }
        }
        throw new EOFException();
      }
      return;
      label249:
      int i = 0;
      continue;
      label255:
      i = 0;
      continue;
      label261:
      long l1 = 0L;
    }
  }
  
  public Timeout timeout()
  {
    return this.this$0.readTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream.FramingSource
 * JD-Core Version:    0.7.0.1
 */