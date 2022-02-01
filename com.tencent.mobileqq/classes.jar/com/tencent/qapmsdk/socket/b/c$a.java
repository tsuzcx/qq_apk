package com.tencent.qapmsdk.socket.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class c$a
{
  b[] a = new b[8];
  int b = this.a.length - 1;
  int c = 0;
  int d = 0;
  private final List<b> e = new ArrayList();
  private final BufferedSource f;
  private final int g;
  private int h;
  
  c$a(int paramInt1, int paramInt2, Source paramSource)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.f = Okio.buffer(paramSource);
  }
  
  c$a(int paramInt, Source paramSource)
  {
    this(paramInt, paramInt, paramSource);
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    int k = 0;
    if (paramInt > 0)
    {
      i = this.a.length - 1;
      int j = paramInt;
      paramInt = k;
      while ((i >= this.b) && (j > 0))
      {
        j -= this.a[i].i;
        this.d -= this.a[i].i;
        this.c -= 1;
        paramInt += 1;
        i -= 1;
      }
      b[] arrayOfb = this.a;
      i = this.b;
      System.arraycopy(arrayOfb, i + 1, arrayOfb, i + 1 + paramInt, this.c);
      this.b += paramInt;
      i = paramInt;
    }
    return i;
  }
  
  private void a(int paramInt, b paramb)
  {
    this.e.add(paramb);
    int j = paramb.i;
    int i = j;
    if (paramInt != -1) {
      i = j - this.a[c(paramInt)].i;
    }
    j = this.h;
    if (i > j)
    {
      e();
      return;
    }
    j = a(this.d + i - j);
    if (paramInt == -1)
    {
      paramInt = this.c;
      b[] arrayOfb1 = this.a;
      if (paramInt + 1 > arrayOfb1.length)
      {
        b[] arrayOfb2 = new b[arrayOfb1.length * 2];
        System.arraycopy(arrayOfb1, 0, arrayOfb2, arrayOfb1.length, arrayOfb1.length);
        this.b = (this.a.length - 1);
        this.a = arrayOfb2;
      }
      paramInt = this.b;
      this.b = (paramInt - 1);
      this.a[paramInt] = paramb;
      this.c += 1;
    }
    else
    {
      int k = c(paramInt);
      this.a[(paramInt + (k + j))] = paramb;
    }
    this.d += i;
  }
  
  private void b(int paramInt)
  {
    if (g(paramInt))
    {
      localObject = c.a[paramInt];
      this.e.add(localObject);
      return;
    }
    int i = c(paramInt - c.a.length);
    if (i >= 0)
    {
      localObject = this.a;
      if (i < localObject.length)
      {
        this.e.add(localObject[i]);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Header index too large ");
    ((StringBuilder)localObject).append(paramInt + 1);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  private int c(int paramInt)
  {
    return this.b + 1 + paramInt;
  }
  
  private void d()
  {
    int i = this.h;
    int j = this.d;
    if (i < j)
    {
      if (i == 0)
      {
        e();
        return;
      }
      a(j - i);
    }
  }
  
  private void d(int paramInt)
  {
    ByteString localByteString1 = f(paramInt);
    ByteString localByteString2 = c();
    this.e.add(new b(localByteString1, localByteString2));
  }
  
  private void e()
  {
    Arrays.fill(this.a, null);
    this.b = (this.a.length - 1);
    this.c = 0;
    this.d = 0;
  }
  
  private void e(int paramInt)
  {
    a(-1, new b(f(paramInt), c()));
  }
  
  private ByteString f(int paramInt)
  {
    if (g(paramInt)) {
      return c.a[paramInt].g;
    }
    int i = c(paramInt - c.a.length);
    if (i >= 0)
    {
      localObject = this.a;
      if (i < localObject.length) {
        return localObject[i].g;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Header index too large ");
    ((StringBuilder)localObject).append(paramInt + 1);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  private void f()
  {
    ByteString localByteString1 = c.a(c());
    ByteString localByteString2 = c();
    this.e.add(new b(localByteString1, localByteString2));
  }
  
  private void g()
  {
    a(-1, new b(c.a(c()), c()));
  }
  
  private boolean g(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= c.a.length - 1);
  }
  
  private int h()
  {
    return this.f.readByte() & 0xFF;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    paramInt1 &= paramInt2;
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    paramInt1 = 0;
    int i;
    for (;;)
    {
      i = h();
      if ((i & 0x80) == 0) {
        break;
      }
      paramInt2 += ((i & 0x7F) << paramInt1);
      paramInt1 += 7;
    }
    return paramInt2 + (i << paramInt1);
  }
  
  void a()
  {
    while (!this.f.exhausted())
    {
      int i = this.f.readByte() & 0xFF;
      if (i != 128)
      {
        if ((i & 0x80) == 128)
        {
          b(a(i, 127) - 1);
        }
        else if (i == 64)
        {
          g();
        }
        else if ((i & 0x40) == 64)
        {
          e(a(i, 63) - 1);
        }
        else if ((i & 0x20) == 32)
        {
          this.h = a(i, 31);
          i = this.h;
          if ((i >= 0) && (i <= this.g))
          {
            d();
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Invalid dynamic table size update ");
            localStringBuilder.append(this.h);
            throw new IOException(localStringBuilder.toString());
          }
        }
        else if ((i != 16) && (i != 0))
        {
          d(a(i, 15) - 1);
        }
        else
        {
          f();
        }
      }
      else {
        throw new IOException("index == 0");
      }
    }
  }
  
  public List<b> b()
  {
    ArrayList localArrayList = new ArrayList(this.e);
    this.e.clear();
    return localArrayList;
  }
  
  ByteString c()
  {
    int j = h();
    int i;
    if ((j & 0x80) == 128) {
      i = 1;
    } else {
      i = 0;
    }
    j = a(j, 127);
    if (i != 0) {
      return ByteString.of(f.a().a(this.f.readByteArray(j)));
    }
    return this.f.readByteString(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.c.a
 * JD-Core Version:    0.7.0.1
 */