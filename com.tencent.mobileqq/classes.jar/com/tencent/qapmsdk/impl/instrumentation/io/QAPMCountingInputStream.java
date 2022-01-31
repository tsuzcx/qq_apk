package com.tencent.qapmsdk.impl.instrumentation.io;

import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

public class QAPMCountingInputStream
  extends InputStream
  implements QAPMStreamCompleteListenerSource
{
  private static final String TAG = "QAPM_Impl_QAPMCountingInputStream";
  private final ByteBuffer buffer;
  private long count = 0L;
  private boolean enableBuffering = false;
  private final InputStream impl;
  private final QAPMStreamCompleteListenerManager listenerManager = new QAPMStreamCompleteListenerManager();
  
  public QAPMCountingInputStream(InputStream paramInputStream)
  {
    this.impl = paramInputStream;
    if (this.enableBuffering)
    {
      this.buffer = ByteBuffer.allocate(1024);
      fillBuffer();
      return;
    }
    this.buffer = null;
  }
  
  public QAPMCountingInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this.impl = paramInputStream;
    this.enableBuffering = paramBoolean;
    if (paramBoolean)
    {
      this.buffer = ByteBuffer.allocate(1024);
      fillBuffer();
      return;
    }
    this.buffer = null;
  }
  
  private boolean bufferEmpty()
  {
    return !this.buffer.hasRemaining();
  }
  
  private boolean bufferHasBytes(long paramLong)
  {
    return this.buffer.remaining() >= paramLong;
  }
  
  private void notifyStreamComplete()
  {
    if (!this.listenerManager.isComplete()) {
      this.listenerManager.notifyStreamComplete(new QAPMStreamCompleteEvent(this, this.count));
    }
  }
  
  private void notifyStreamError(Exception paramException)
  {
    if (!this.listenerManager.isComplete()) {
      this.listenerManager.notifyStreamError(new QAPMStreamCompleteEvent(this, this.count, paramException));
    }
  }
  
  private int readBuffer()
  {
    if (bufferEmpty()) {
      return -1;
    }
    return this.buffer.get();
  }
  
  private int readBufferBytes(byte[] paramArrayOfByte)
  {
    return readBufferBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private int readBufferBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (bufferEmpty()) {
      return -1;
    }
    int i = this.buffer.remaining();
    this.buffer.get(paramArrayOfByte, paramInt1, paramInt2);
    return i - this.buffer.remaining();
  }
  
  public void addStreamCompleteListener(QAPMStreamCompleteListener paramQAPMStreamCompleteListener)
  {
    this.listenerManager.addStreamCompleteListener(paramQAPMStreamCompleteListener);
  }
  
  public int available()
  {
    int i = 0;
    if (this.enableBuffering) {
      i = this.buffer.remaining();
    }
    try
    {
      int j = this.impl.available();
      return i + j;
    }
    catch (IOException localIOException)
    {
      notifyStreamError(localIOException);
      throw localIOException;
    }
  }
  
  public void close()
  {
    try
    {
      this.impl.close();
      notifyStreamComplete();
      return;
    }
    catch (IOException localIOException)
    {
      notifyStreamError(localIOException);
      throw localIOException;
    }
  }
  
  public void fillBuffer()
  {
    if ((this.buffer == null) || (!this.buffer.hasArray())) {
      return;
    }
    try
    {
      synchronized (this.buffer)
      {
        i = this.impl.read(this.buffer.array(), 0, this.buffer.capacity());
        if (i <= 0)
        {
          this.buffer.limit(0);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCountingInputStream", localIOException.toString() });
        int i = 0;
        continue;
        if (i < this.buffer.capacity()) {
          this.buffer.limit(i);
        }
      }
    }
  }
  
  public String getBufferAsString()
  {
    if (this.buffer != null) {
      synchronized (this.buffer)
      {
        Object localObject1 = new byte[this.buffer.limit()];
        int i = 0;
        while (i < this.buffer.limit())
        {
          localObject1[i] = this.buffer.get(i);
          i += 1;
        }
        localObject1 = new String((byte[])localObject1);
        return localObject1;
      }
    }
    return "";
  }
  
  public void mark(int paramInt)
  {
    if (!markSupported()) {
      return;
    }
    this.impl.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.impl.markSupported();
  }
  
  public int read()
  {
    if (this.enableBuffering) {}
    int i;
    synchronized (this.buffer)
    {
      if (bufferHasBytes(1L))
      {
        i = readBuffer();
        if (i >= 0) {
          this.count += 1L;
        }
        return i;
      }
      try
      {
        i = this.impl.read();
        if (i >= 0)
        {
          this.count += 1L;
          return i;
        }
      }
      catch (IOException localIOException)
      {
        notifyStreamError(localIOException);
        throw localIOException;
      }
    }
    notifyStreamComplete();
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    ByteBuffer localByteBuffer;
    int j;
    if (this.enableBuffering)
    {
      localByteBuffer = this.buffer;
      long l = i;
      try
      {
        if (bufferHasBytes(l))
        {
          i = readBufferBytes(paramArrayOfByte);
          if (i >= 0)
          {
            this.count += i;
            return i;
          }
          throw new IOException("readBufferBytes failed");
        }
      }
      finally {}
      j = this.buffer.remaining();
      if (j > 0)
      {
        j = readBufferBytes(paramArrayOfByte, 0, j);
        if (j < 0) {
          throw new IOException("partial read from buffer failed");
        }
        i -= j;
        this.count += j;
      }
    }
    for (;;)
    {
      try
      {
        i = this.impl.read(paramArrayOfByte, j, i);
        if (i >= 0)
        {
          this.count += i;
          return i + j;
        }
        if (j <= 0)
        {
          notifyStreamComplete();
          return i;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCountingInputStream", paramArrayOfByte.toString() });
        System.out.println("NOTIFY STREAM ERROR: " + paramArrayOfByte);
        paramArrayOfByte.printStackTrace();
        notifyStreamError(paramArrayOfByte);
        throw paramArrayOfByte;
      }
      return j;
      j = 0;
      break;
      j = 0;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = 0;
    int j = paramInt2;
    ByteBuffer localByteBuffer;
    if (this.enableBuffering)
    {
      localByteBuffer = this.buffer;
      long l = paramInt2;
      try
      {
        if (bufferHasBytes(l))
        {
          paramInt1 = readBufferBytes(paramArrayOfByte, paramInt1, paramInt2);
          if (paramInt1 >= 0)
          {
            this.count += paramInt1;
            return paramInt1;
          }
          throw new IOException("readBufferBytes failed");
        }
      }
      finally {}
      int m = this.buffer.remaining();
      i = k;
      j = paramInt2;
      if (m > 0)
      {
        i = readBufferBytes(paramArrayOfByte, paramInt1, m);
        if (i < 0) {
          throw new IOException("partial read from buffer failed");
        }
        j = paramInt2 - i;
        this.count += i;
      }
    }
    try
    {
      paramInt1 = this.impl.read(paramArrayOfByte, paramInt1 + i, j);
      if (paramInt1 >= 0)
      {
        this.count += paramInt1;
        return paramInt1 + i;
      }
      if (i <= 0)
      {
        notifyStreamComplete();
        return paramInt1;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      notifyStreamError(paramArrayOfByte);
      throw paramArrayOfByte;
    }
    return i;
  }
  
  public void removeStreamCompleteListener(QAPMStreamCompleteListener paramQAPMStreamCompleteListener)
  {
    this.listenerManager.removeStreamCompleteListener(paramQAPMStreamCompleteListener);
  }
  
  public void reset()
  {
    if (!markSupported()) {
      return;
    }
    try
    {
      this.impl.reset();
      return;
    }
    catch (IOException localIOException)
    {
      notifyStreamError(localIOException);
      throw localIOException;
    }
  }
  
  public void setBufferingEnabled(boolean paramBoolean)
  {
    this.enableBuffering = paramBoolean;
  }
  
  public long skip(long paramLong)
  {
    long l = paramLong;
    if (this.enableBuffering) {}
    synchronized (this.buffer)
    {
      if (bufferHasBytes(paramLong))
      {
        this.buffer.position((int)paramLong);
        this.count += paramLong;
        return paramLong;
      }
      l = paramLong - this.buffer.remaining();
      if (l > 0L)
      {
        this.buffer.position(this.buffer.remaining());
        try
        {
          paramLong = this.impl.skip(l);
          this.count += paramLong;
          return paramLong;
        }
        catch (IOException localIOException)
        {
          notifyStreamError(localIOException);
          throw localIOException;
        }
      }
      throw new IOException("partial read from buffer (skip) failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.io.QAPMCountingInputStream
 * JD-Core Version:    0.7.0.1
 */