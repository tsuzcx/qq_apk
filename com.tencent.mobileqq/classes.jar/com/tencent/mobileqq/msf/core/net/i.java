package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.AbsSessionInputBuffer;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.util.ByteArrayBuffer;

public class i
  extends AbsSessionInputBuffer
{
  public i()
  {
    this.linebuffer = new ByteArrayBuffer(1024);
    this.charset = "US-ASCII";
    if ((this.charset.equalsIgnoreCase("US-ASCII")) || (this.charset.equalsIgnoreCase("ASCII"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.ascii = bool;
      this.maxLineLen = -1;
      this.metrics = new HttpTransportMetricsImpl();
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((this.bufferlen != 0) && (this.bufferpos < this.bufferlen))
    {
      int i = this.bufferlen - this.bufferpos;
      byte[] arrayOfByte = new byte[paramArrayOfByte.length + i];
      System.arraycopy(this.buffer, this.bufferpos, arrayOfByte, 0, i);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, i, paramArrayOfByte.length);
      this.buffer = arrayOfByte;
    }
    for (;;)
    {
      this.bufferpos = 0;
      this.bufferlen = this.buffer.length;
      if (this.linebuffer != null) {
        this.linebuffer.clear();
      }
      this.metrics.incrementBytesTransferred(paramArrayOfByte.length);
      return;
      this.buffer = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.buffer, 0, paramArrayOfByte.length);
    }
  }
  
  public int fillBuffer()
  {
    return -1;
  }
  
  public boolean isDataAvailable(int paramInt)
  {
    return hasBufferedData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.i
 * JD-Core Version:    0.7.0.1
 */