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
  
  Http2Stream(int paramInt, Http2Connection paramHttp2Connection, boolean paramBoolean1, boolean paramBoolean2, @Nullable Headers paramHeaders)
  {
    if (paramHttp2Connection != null)
    {
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
      if (!isLocallyInitiated())
      {
        if (paramHeaders != null) {
          return;
        }
        throw new IllegalStateException("remotely-initiated streams should have headers");
      }
      return;
    }
    throw new NullPointerException("connection == null");
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode != null) {
        return false;
      }
      if ((this.source.finished) && (this.sink.finished)) {
        return false;
      }
      this.errorCode = paramErrorCode;
      notifyAll();
      this.connection.removeStream(this.id);
      return true;
    }
    finally {}
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
    for (;;)
    {
      try
      {
        if ((this.source.finished) || (!this.source.closed)) {
          break label91;
        }
        if (this.sink.finished) {
          break label86;
        }
        if (!this.sink.closed) {
          break label91;
        }
      }
      finally {}
      boolean bool = isOpen();
      if (i != 0)
      {
        close(ErrorCode.CANCEL);
        return;
      }
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
      label86:
      int i = 1;
      continue;
      label91:
      i = 0;
    }
  }
  
  void checkOutNotClosed()
  {
    if (!this.sink.closed)
    {
      if (!this.sink.finished)
      {
        ErrorCode localErrorCode = this.errorCode;
        if (localErrorCode == null) {
          return;
        }
        throw new StreamResetException(localErrorCode);
      }
      throw new IOException("stream finished");
    }
    throw new IOException("stream closed");
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
      return this.sink;
    }
    finally {}
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isLocallyInitiated()
  {
    int i;
    if ((this.id & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    return this.connection.client == i;
  }
  
  public boolean isOpen()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      if (localErrorCode != null) {
        return false;
      }
      if (((this.source.finished) || (this.source.closed)) && ((this.sink.finished) || (this.sink.closed)))
      {
        boolean bool = this.hasResponseHeaders;
        if (bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public Timeout readTimeout()
  {
    return this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt)
  {
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin()
  {
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
      try
      {
        while ((this.headersQueue.isEmpty()) && (this.errorCode == null)) {
          waitForIo();
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!this.headersQueue.isEmpty())
        {
          Headers localHeaders = (Headers)this.headersQueue.removeFirst();
          return localHeaders;
        }
        throw new StreamResetException(this.errorCode);
      }
      finally
      {
        this.readTimeout.exitAndThrowIfTimedOut();
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
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
      label5:
      break label5;
    }
    Thread.currentThread().interrupt();
    throw new InterruptedIOException();
  }
  
  public void writeHeaders(List<Header> paramList, boolean paramBoolean)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.hasResponseHeaders = true;
        if (paramBoolean) {
          break label122;
        }
        this.sink.finished = true;
        i = 1;
        paramBoolean = true;
        int j = i;
        if (i == 0) {
          synchronized (this.connection)
          {
            if (this.connection.bytesLeftInWriteWindow != 0L) {
              break label129;
            }
            i = 1;
            j = i;
          }
        }
        this.connection.writeSynReply(this.id, paramBoolean, paramList);
        if (j != 0) {
          this.connection.flush();
        }
        return;
      }
      finally {}
      throw new NullPointerException("headers == null");
      label122:
      int i = 0;
      paramBoolean = false;
      continue;
      label129:
      i = 0;
    }
  }
  
  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream
 * JD-Core Version:    0.7.0.1
 */