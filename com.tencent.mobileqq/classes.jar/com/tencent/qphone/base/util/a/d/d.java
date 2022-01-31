package com.tencent.qphone.base.util.a.d;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.a.b.e;
import com.tencent.qphone.base.util.a.c.a.a;
import java.io.IOException;
import java.nio.MappedByteBuffer;

public class d
  implements com.tencent.qphone.base.util.a.a, a.a
{
  public static final String a = "JavaMmapAppender";
  protected Object b;
  String c;
  String d;
  int e;
  boolean f;
  boolean g;
  MappedByteBuffer h;
  com.tencent.qphone.base.util.a.c.c i;
  com.tencent.qphone.base.util.a.c.b j;
  com.tencent.qphone.base.util.a.c.a k;
  com.tencent.qphone.base.util.a.b.a l;
  
  public d(d.a parama)
  {
    this.c = d.a.a(parama);
    this.d = d.a.b(parama);
    this.e = d.a.c(parama);
    this.f = d.a.d(parama);
    this.g = d.a.e(parama);
    this.b = this;
    try
    {
      this.h = com.tencent.qphone.base.util.a.c.d.a(this.c, this.e);
      this.i = new com.tencent.qphone.base.util.a.c.c(this.d);
      this.l = new com.tencent.qphone.base.util.a.b.a();
      this.l.a(new com.tencent.qphone.base.util.a.b.b(this.f));
      this.l.a(new e(this.g));
      this.j = new com.tencent.qphone.base.util.a.c.b(this.h, this.f);
      this.k = new com.tencent.qphone.base.util.a.c.a(this);
      a();
      return;
    }
    catch (IOException parama)
    {
      parama.printStackTrace();
    }
  }
  
  private void a()
  {
    this.h.flip();
    if (this.h.limit() > 0) {
      this.i.a(this.h);
    }
    this.h.clear();
    try
    {
      String str = com.tencent.qphone.base.util.a.a.c.a(e.b());
      if (!TextUtils.isEmpty(str))
      {
        this.h.putInt(-20190711);
        byte[] arrayOfByte = str.getBytes(e.a);
        this.h.putInt(arrayOfByte.length + 4);
        this.h.putInt(1);
        this.h.put(arrayOfByte);
        if (QLog.isDebugVersion())
        {
          Log.d("JavaMmapAppender", "copyCacheToLogFileAndReset:  encryptedKey: " + str);
          Log.d("JavaMmapAppender", "writeThroughMmapBuffer first length=" + this.h.position() + " limit=" + this.h.limit());
        }
        this.h.flip();
        this.i.a(this.h);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("JavaMmapAppender", "", localThrowable);
      }
    }
    this.h.clear();
    this.j.b();
  }
  
  private void b()
  {
    if (this.j.c()) {
      this.i.a(this.h);
    }
    this.h.clear();
    this.j.b();
  }
  
  public void a(com.tencent.qphone.base.util.a.b.d paramd)
  {
    paramd = this.l.a(paramd);
    this.h.put(paramd.a, paramd.c, paramd.d);
    this.j.a();
    if (this.h.position() > this.h.capacity() - 2048)
    {
      b();
      this.l.a();
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    synchronized (this.b)
    {
      this.k.a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
  }
  
  public void close()
  {
    synchronized (this.b)
    {
      this.k.a();
      b();
      try
      {
        this.i.a();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void flush()
  {
    synchronized (this.b)
    {
      this.k.a();
      return;
    }
  }
  
  public void write(int paramInt)
  {
    synchronized (this.b)
    {
      this.k.a(paramInt);
      return;
    }
  }
  
  public void write(String paramString)
  {
    synchronized (this.b)
    {
      this.k.a(paramString);
      return;
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    synchronized (this.b)
    {
      this.k.a(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.d.d
 * JD-Core Version:    0.7.0.1
 */