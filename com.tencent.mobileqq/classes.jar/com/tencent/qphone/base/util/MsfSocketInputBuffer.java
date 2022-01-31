package com.tencent.qphone.base.util;

import com.tencent.mobileqq.msf.core.net.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.ArrayList;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.util.ByteArrayBuffer;

public class MsfSocketInputBuffer
  extends AbsSessionInputBuffer
{
  private static final Class SOCKET_TIMEOUT_CLASS = ;
  private int inputBufferSize;
  public InputStream instream;
  private final Socket socket;
  
  public MsfSocketInputBuffer(Socket paramSocket, int paramInt1, String paramString, int paramInt2)
    throws IOException
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("Socket may not be null");
    }
    this.socket = paramSocket;
    if (paramInt1 < 0) {
      paramInt1 = paramSocket.getReceiveBufferSize();
    }
    for (;;)
    {
      if (paramInt1 < 1024) {
        paramInt1 = i;
      }
      for (;;)
      {
        paramSocket = paramSocket.getInputStream();
        if (!l.n.contains(paramSocket.toString())) {
          l.n.add(paramSocket.toString());
        }
        init(paramSocket, paramInt1, paramString, paramInt2);
        return;
      }
    }
  }
  
  private static Class SocketTimeoutExceptionClass()
  {
    try
    {
      Class localClass = Class.forName("java.net.SocketTimeoutException");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  private static boolean isSocketTimeoutException(InterruptedIOException paramInterruptedIOException)
  {
    if (SOCKET_TIMEOUT_CLASS != null) {
      return SOCKET_TIMEOUT_CLASS.isInstance(paramInterruptedIOException);
    }
    return true;
  }
  
  protected int fillBuffer()
    throws IOException
  {
    if (this.bufferpos > 0)
    {
      i = this.bufferlen - this.bufferpos;
      if (i > 0) {
        System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, i);
      }
      this.bufferpos = 0;
      this.bufferlen = i;
    }
    int i = this.bufferlen;
    int j = this.buffer.length;
    j = this.instream.read(this.buffer, i, j - i);
    if (j == -1) {
      return -1;
    }
    this.bufferlen = (i + j);
    this.metrics.incrementBytesTransferred(j);
    return j;
  }
  
  protected void init(InputStream paramInputStream, int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = false;
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Input stream may not be null");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("Buffer size may not be negative or zero");
    }
    this.instream = paramInputStream;
    this.inputBufferSize = paramInt1;
    this.buffer = new byte[this.inputBufferSize];
    this.bufferpos = 0;
    this.bufferlen = 0;
    this.linebuffer = new ByteArrayBuffer(paramInt1);
    this.charset = paramString;
    if ((this.charset.equalsIgnoreCase("US-ASCII")) || (this.charset.equalsIgnoreCase("ASCII"))) {
      bool = true;
    }
    this.ascii = bool;
    this.maxLineLen = paramInt2;
    this.metrics = new HttpTransportMetricsImpl();
  }
  
  public boolean isDataAvailable(int paramInt)
    throws IOException
  {
    boolean bool1 = hasBufferedData();
    boolean bool2 = bool1;
    int i;
    if (!bool1)
    {
      i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(paramInt);
        if (fillBuffer() == -1) {
          throw new IOException("readData return -1");
        }
      }
      catch (InterruptedIOException localInterruptedIOException)
      {
        if (isSocketTimeoutException(localInterruptedIOException)) {
          break label99;
        }
        throw localInterruptedIOException;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
      bool2 = hasBufferedData();
      bool1 = bool2;
    }
    label99:
    for (Socket localSocket = this.socket;; localSocket = this.socket)
    {
      localSocket.setSoTimeout(i);
      bool2 = bool1;
      return bool2;
    }
  }
  
  public void reset()
  {
    if (this.buffer == null) {
      this.buffer = new byte[this.inputBufferSize];
    }
    this.bufferpos = 0;
    this.bufferlen = 0;
    if (this.linebuffer != null) {
      this.linebuffer.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.MsfSocketInputBuffer
 * JD-Core Version:    0.7.0.1
 */