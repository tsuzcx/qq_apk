package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GifHeaderParser
{
  private static final int a = (int)Long.parseLong("0b00011100", 2);
  private static final int b = (int)Long.parseLong("0b00000001", 2);
  private static final int c = (int)Long.parseLong("0b10000000", 2);
  private static final int d = (int)Long.parseLong("0b01000000", 2);
  private static final int e = (int)Long.parseLong("0b00000111", 2);
  private static final int f = (int)Long.parseLong("0b10000000", 2);
  private static final int g = (int)Long.parseLong("0b00000111", 2);
  private final byte[] h = new byte[256];
  private ByteBuffer i;
  private GifHeader j;
  private int k = 0;
  
  private void a(int paramInt)
  {
    int m = 0;
    while ((m == 0) && (!n()) && (this.j.d <= paramInt))
    {
      int n = l();
      if (n != 33)
      {
        if (n != 44)
        {
          if (n != 59) {
            this.j.c = 1;
          } else {
            m = 1;
          }
        }
        else
        {
          if (this.j.e == null) {
            this.j.e = new GifFrame();
          }
          e();
        }
      }
      else
      {
        n = l();
        if (n != 1)
        {
          if (n != 249)
          {
            if (n != 254)
            {
              if (n != 255)
              {
                j();
              }
              else
              {
                k();
                StringBuilder localStringBuilder = new StringBuilder();
                n = 0;
                while (n < 11)
                {
                  localStringBuilder.append((char)this.h[n]);
                  n += 1;
                }
                if (localStringBuilder.toString().equals("NETSCAPE2.0")) {
                  f();
                } else {
                  j();
                }
              }
            }
            else {
              j();
            }
          }
          else
          {
            this.j.e = new GifFrame();
            d();
          }
        }
        else {
          j();
        }
      }
    }
  }
  
  private void b()
  {
    this.i = null;
    Arrays.fill(this.h, (byte)0);
    this.j = new GifHeader();
    this.k = 0;
  }
  
  @Nullable
  private int[] b(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt * 3];
    localObject = null;
    try
    {
      this.i.get(arrayOfByte);
      int[] arrayOfInt = new int[256];
      int m = 0;
      int n = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (m >= paramInt) {
          break;
        }
        int i1 = n + 1;
        n = arrayOfByte[n];
        int i2 = i1 + 1;
        arrayOfInt[m] = ((n & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[i1] & 0xFF) << 8 | arrayOfByte[i2] & 0xFF);
        n = i2 + 1;
        m += 1;
      }
      return localObject;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      if (Log.isLoggable("GifHeaderParser", 3)) {
        Log.d("GifHeaderParser", "Format Error Reading Color Table", localBufferUnderflowException);
      }
      this.j.c = 1;
    }
  }
  
  private void c()
  {
    a(2147483647);
  }
  
  private void d()
  {
    l();
    int m = l();
    this.j.e.g = ((a & m) >> 2);
    int n = this.j.e.g;
    boolean bool = true;
    if (n == 0) {
      this.j.e.g = 1;
    }
    GifFrame localGifFrame = this.j.e;
    if ((m & b) == 0) {
      bool = false;
    }
    localGifFrame.f = bool;
    n = m();
    m = n;
    if (n < 2) {
      m = 10;
    }
    this.j.e.i = (m * 10);
    this.j.e.h = l();
    l();
  }
  
  private void e()
  {
    this.j.e.a = m();
    this.j.e.b = m();
    this.j.e.c = m();
    this.j.e.d = m();
    int n = l();
    int m = c;
    boolean bool = false;
    if ((m & n) != 0) {
      m = 1;
    } else {
      m = 0;
    }
    int i1 = (int)Math.pow(2.0D, (e & n) + 1);
    Object localObject = this.j.e;
    if ((n & d) != 0) {
      bool = true;
    }
    ((GifFrame)localObject).e = bool;
    if (m != 0) {
      this.j.e.k = b(i1);
    } else {
      this.j.e.k = null;
    }
    this.j.e.j = this.i.position();
    i();
    if (n()) {
      return;
    }
    localObject = this.j;
    ((GifHeader)localObject).d += 1;
    this.j.a.add(this.j.e);
  }
  
  private void f()
  {
    do
    {
      k();
      byte[] arrayOfByte = this.h;
      if (arrayOfByte[0] == 1)
      {
        int m = arrayOfByte[1];
        int n = arrayOfByte[2];
        this.j.m = ((n & 0xFF) << 8 | m & 0xFF);
      }
    } while ((this.k > 0) && (!n()));
  }
  
  private void g()
  {
    Object localObject = new StringBuilder();
    int m = 0;
    while (m < 6)
    {
      ((StringBuilder)localObject).append((char)l());
      m += 1;
    }
    if (!((StringBuilder)localObject).toString().startsWith("GIF"))
    {
      this.j.c = 1;
      return;
    }
    h();
    if ((this.j.h) && (!n()))
    {
      localObject = this.j;
      ((GifHeader)localObject).b = b(((GifHeader)localObject).i);
      localObject = this.j;
      ((GifHeader)localObject).l = localObject.b[this.j.j];
    }
  }
  
  private void h()
  {
    this.j.f = m();
    this.j.g = m();
    int m = l();
    GifHeader localGifHeader = this.j;
    boolean bool;
    if ((f & m) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localGifHeader.h = bool;
    this.j.i = ((int)Math.pow(2.0D, (m & g) + 1));
    this.j.j = l();
    this.j.k = l();
  }
  
  private void i()
  {
    l();
    j();
  }
  
  private void j()
  {
    int m;
    do
    {
      m = l();
      int n = Math.min(this.i.position() + m, this.i.limit());
      this.i.position(n);
    } while (m > 0);
  }
  
  private void k()
  {
    this.k = l();
    if (this.k > 0)
    {
      int n = 0;
      int m = 0;
      for (;;)
      {
        int i1 = m;
        try
        {
          if (n < this.k)
          {
            i1 = m;
            m = this.k - n;
            i1 = m;
            this.i.get(this.h, n, m);
            n += m;
          }
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("GifHeaderParser", 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Error Reading Block n: ");
            localStringBuilder.append(n);
            localStringBuilder.append(" count: ");
            localStringBuilder.append(i1);
            localStringBuilder.append(" blockSize: ");
            localStringBuilder.append(this.k);
            Log.d("GifHeaderParser", localStringBuilder.toString(), localException);
          }
          this.j.c = 1;
        }
      }
    }
  }
  
  private int l()
  {
    try
    {
      int m = this.i.get();
      return m & 0xFF;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    this.j.c = 1;
    return 0;
  }
  
  private int m()
  {
    return this.i.getShort();
  }
  
  private boolean n()
  {
    return this.j.c != 0;
  }
  
  @NotNull
  public GifHeader a()
  {
    if (this.i != null)
    {
      if (n()) {
        return this.j;
      }
      g();
      if (!n())
      {
        c();
        if (this.j.d < 0) {
          this.j.c = 1;
        }
      }
      return this.j;
    }
    throw new IllegalStateException("You must call setData() before parseHeader()");
  }
  
  public GifHeaderParser a(@NotNull ByteBuffer paramByteBuffer)
  {
    b();
    this.i = paramByteBuffer.asReadOnlyBuffer();
    this.i.position(0);
    this.i.order(ByteOrder.LITTLE_ENDIAN);
    return this;
  }
  
  public GifHeaderParser a(@Nullable byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      a(ByteBuffer.wrap(paramArrayOfByte));
      return this;
    }
    this.i = null;
    this.j.c = 2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.GifHeaderParser
 * JD-Core Version:    0.7.0.1
 */