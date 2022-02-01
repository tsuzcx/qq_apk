package com.tencent.mobileqq.msf.core.net.d.b;

import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;

class a
{
  public static final int a = 65536;
  private static final String b = "BufferPool";
  private static int d = 8192;
  private final LruCache c = new b(this, 5);
  
  public static a c()
  {
    return a.a.a();
  }
  
  public byte[] a()
  {
    Thread localThread = Thread.currentThread();
    byte[] arrayOfByte2 = (byte[])this.c.get(localThread);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2.length < d)
    {
      b();
      arrayOfByte1 = new byte[d];
      this.c.put(localThread, arrayOfByte1);
    }
    QLog.d("BufferPool", 1, new Object[] { "[acquireBuffer] buffer size: ", Integer.valueOf(d) });
    return arrayOfByte1;
  }
  
  public void b()
  {
    QLog.d("BufferPool", 1, new Object[] { "[expandBufferSize] before expand size: ", Integer.valueOf(d) });
    int i = d * 2;
    if (i <= 65536) {
      d = i;
    }
    QLog.d("BufferPool", 1, new Object[] { "[expandBufferSize] after expand size: ", Integer.valueOf(d) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.b.a
 * JD-Core Version:    0.7.0.1
 */