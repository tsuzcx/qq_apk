package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Build.VERSION;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public final class g
  extends Writer
{
  static boolean c = true;
  static Class d;
  static Field e;
  static Field f;
  CharBuffer a;
  boolean b = false;
  private final OutputStream g;
  private CharsetEncoder h;
  private ByteBuffer i = ByteBuffer.allocate(8192);
  
  public g(File paramFile, boolean paramBoolean)
  {
    this(new BufferedOutputStream(new FileOutputStream(paramFile, paramBoolean)));
  }
  
  public g(OutputStream paramOutputStream)
  {
    this(paramOutputStream, Charset.defaultCharset());
  }
  
  public g(OutputStream paramOutputStream, Charset paramCharset)
  {
    super(paramOutputStream);
    this.g = paramOutputStream;
    this.h = paramCharset.newEncoder();
    this.h.onMalformedInput(CodingErrorAction.REPLACE);
    this.h.onUnmappableCharacter(CodingErrorAction.REPLACE);
  }
  
  private CharBuffer a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!this.b)
    {
      this.a = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
      this.b = true;
      return this.a;
    }
    if (c)
    {
      this.a.clear();
      try
      {
        if ((d == null) || (e == null) || (f == null))
        {
          int j = Build.VERSION.SDK_INT;
          if ((j >= 8) && (Build.VERSION.SDK_INT <= 17))
          {
            d = Class.forName("java.nio.ReadWriteCharArrayBuffer");
            e = d.getSuperclass().getDeclaredField("backingArray");
            f = d.getSuperclass().getSuperclass().getSuperclass().getDeclaredField("capacity");
          }
          else if (Build.VERSION.SDK_INT >= 18)
          {
            d = Class.forName("java.nio.CharArrayBuffer");
            e = d.getDeclaredField("backingArray");
            f = d.getSuperclass().getSuperclass().getDeclaredField("capacity");
          }
          if (e != null) {
            e.setAccessible(true);
          }
          if (f != null) {
            f.setAccessible(true);
          }
        }
        if ((f != null) && (e != null) && (d != null) && (d.isInstance(this.a)))
        {
          e.set(this.a, paramArrayOfChar);
          f.set(this.a, g.a.a(paramArrayOfChar.length));
          this.a.position(paramInt1);
          this.a.limit(paramInt1 + paramInt2);
          CharBuffer localCharBuffer = this.a;
          return localCharBuffer;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
      }
      c = false;
      this.a = null;
    }
    return CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  private void a()
  {
    Object localObject = CharBuffer.allocate(0);
    for (;;)
    {
      CoderResult localCoderResult = this.h.encode((CharBuffer)localObject, this.i, true);
      if (localCoderResult.isError())
      {
        localCoderResult.throwException();
        break;
      }
      if (!localCoderResult.isOverflow()) {
        break;
      }
      a(false);
    }
    localObject = this.h.flush(this.i);
    while (!((CoderResult)localObject).isUnderflow()) {
      if (((CoderResult)localObject).isOverflow())
      {
        a(false);
        localObject = this.h.flush(this.i);
      }
      else
      {
        ((CoderResult)localObject).throwException();
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) >= 0) && (paramInt2 <= paramInt1) && (paramInt1 - paramInt2 >= paramInt3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("length=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; regionStart=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("; regionLength=");
    localStringBuilder.append(paramInt3);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  private void a(CharBuffer paramCharBuffer)
  {
    CoderResult localCoderResult;
    for (;;)
    {
      localCoderResult = this.h.encode(paramCharBuffer, this.i, false);
      if (!localCoderResult.isOverflow()) {
        break;
      }
      a(false);
    }
    if (localCoderResult.isError()) {
      localCoderResult.throwException();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      b();
      int j = this.i.position();
      if (j > 0)
      {
        this.i.flip();
        this.g.write(this.i.array(), this.i.arrayOffset(), j);
        this.i.clear();
      }
      if (paramBoolean) {
        this.g.flush();
      }
      return;
    }
  }
  
  private void b()
  {
    if (this.h != null) {
      return;
    }
    throw new IOException("OutputStreamWriter is closed");
  }
  
  public void close()
  {
    synchronized (this.lock)
    {
      if (this.h != null)
      {
        a();
        a(false);
        this.g.close();
        this.h = null;
        this.i = null;
      }
      return;
    }
  }
  
  public void flush()
  {
    a(true);
  }
  
  public void write(int paramInt)
  {
    synchronized (this.lock)
    {
      b();
      a(CharBuffer.wrap(new char[] { (char)paramInt }));
      return;
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    localObject = this.lock;
    if ((paramInt2 < 0) || ((paramString == null) || ((paramInt1 | paramInt2) >= 0))) {}
    try
    {
      if (paramInt1 <= paramString.length() - paramInt2)
      {
        b();
        a(CharBuffer.wrap(paramString, paramInt1, paramInt2 + paramInt1));
        return;
      }
      localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("length=");
      localStringBuilder.append(paramString.length());
      localStringBuilder.append("; regionStart=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; regionLength=");
      localStringBuilder.append(paramInt2);
      throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
    }
    finally {}
    throw new NullPointerException("str == null");
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("length=");
    localStringBuilder.append(paramString.length());
    localStringBuilder.append("; regionStart=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; regionLength=");
    localStringBuilder.append(paramInt2);
    throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      b();
      a(paramArrayOfChar.length, paramInt1, paramInt2);
      a(a(paramArrayOfChar, paramInt1, paramInt2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.g
 * JD-Core Version:    0.7.0.1
 */