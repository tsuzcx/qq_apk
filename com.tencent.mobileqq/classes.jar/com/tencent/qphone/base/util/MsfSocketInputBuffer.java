package com.tencent.qphone.base.util;

import com.tencent.mobileqq.msf.core.net.m;
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
  private int inputBufferSize = 0;
  public InputStream instream;
  private final Socket socket;
  
  public MsfSocketInputBuffer(Socket paramSocket, int paramInt1, String paramString, int paramInt2)
  {
    if (paramSocket != null)
    {
      this.socket = paramSocket;
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = paramSocket.getReceiveBufferSize();
      }
      paramInt1 = i;
      if (i < 1024) {
        paramInt1 = 1024;
      }
      paramSocket = paramSocket.getInputStream();
      if (!m.q.contains(paramSocket.toString())) {
        m.q.add(paramSocket.toString());
      }
      init(paramSocket, paramInt1, paramString, paramInt2);
      return;
    }
    throw new IllegalArgumentException("Socket may not be null");
  }
  
  private static Class SocketTimeoutExceptionClass()
  {
    try
    {
      Class localClass = Class.forName("java.net.SocketTimeoutException");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  private static boolean isSocketTimeoutException(InterruptedIOException paramInterruptedIOException)
  {
    Class localClass = SOCKET_TIMEOUT_CLASS;
    if (localClass != null) {
      return localClass.isInstance(paramInterruptedIOException);
    }
    return true;
  }
  
  protected int fillBuffer()
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
    if (paramInputStream != null)
    {
      if (paramInt1 > 0)
      {
        this.instream = paramInputStream;
        this.inputBufferSize = paramInt1;
        this.buffer = new byte[this.inputBufferSize];
        boolean bool = false;
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
        return;
      }
      throw new IllegalArgumentException("Buffer size may not be negative or zero");
    }
    throw new IllegalArgumentException("Input stream may not be null");
  }
  
  /* Error */
  public boolean isDataAvailable(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 164	com/tencent/qphone/base/util/MsfSocketInputBuffer:hasBufferedData	()Z
    //   4: istore_3
    //   5: iload_3
    //   6: ifne +88 -> 94
    //   9: aload_0
    //   10: getfield 29	com/tencent/qphone/base/util/MsfSocketInputBuffer:socket	Ljava/net/Socket;
    //   13: invokevirtual 167	java/net/Socket:getSoTimeout	()I
    //   16: istore_2
    //   17: aload_0
    //   18: getfield 29	com/tencent/qphone/base/util/MsfSocketInputBuffer:socket	Ljava/net/Socket;
    //   21: iload_1
    //   22: invokevirtual 170	java/net/Socket:setSoTimeout	(I)V
    //   25: aload_0
    //   26: invokevirtual 172	com/tencent/qphone/base/util/MsfSocketInputBuffer:fillBuffer	()I
    //   29: iconst_m1
    //   30: if_icmpeq +22 -> 52
    //   33: aload_0
    //   34: invokevirtual 164	com/tencent/qphone/base/util/MsfSocketInputBuffer:hasBufferedData	()Z
    //   37: istore 4
    //   39: iload 4
    //   41: istore_3
    //   42: aload_0
    //   43: getfield 29	com/tencent/qphone/base/util/MsfSocketInputBuffer:socket	Ljava/net/Socket;
    //   46: iload_2
    //   47: invokevirtual 170	java/net/Socket:setSoTimeout	(I)V
    //   50: iload_3
    //   51: ireturn
    //   52: new 174	java/io/IOException
    //   55: dup
    //   56: ldc 176
    //   58: invokespecial 177	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   61: athrow
    //   62: astore 5
    //   64: goto +19 -> 83
    //   67: astore 5
    //   69: aload 5
    //   71: invokestatic 179	com/tencent/qphone/base/util/MsfSocketInputBuffer:isSocketTimeoutException	(Ljava/io/InterruptedIOException;)Z
    //   74: ifeq +6 -> 80
    //   77: goto -35 -> 42
    //   80: aload 5
    //   82: athrow
    //   83: aload_0
    //   84: getfield 29	com/tencent/qphone/base/util/MsfSocketInputBuffer:socket	Ljava/net/Socket;
    //   87: iload_2
    //   88: invokevirtual 170	java/net/Socket:setSoTimeout	(I)V
    //   91: aload 5
    //   93: athrow
    //   94: iload_3
    //   95: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	MsfSocketInputBuffer
    //   0	96	1	paramInt	int
    //   16	72	2	i	int
    //   4	91	3	bool1	boolean
    //   37	3	4	bool2	boolean
    //   62	1	5	localObject	Object
    //   67	25	5	localInterruptedIOException	InterruptedIOException
    // Exception table:
    //   from	to	target	type
    //   17	39	62	finally
    //   52	62	62	finally
    //   69	77	62	finally
    //   80	83	62	finally
    //   17	39	67	java/io/InterruptedIOException
    //   52	62	67	java/io/InterruptedIOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.MsfSocketInputBuffer
 * JD-Core Version:    0.7.0.1
 */