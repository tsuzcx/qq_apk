package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import org.jetbrains.annotations.Nullable;

public class AnimatedGifEncoder
{
  private int a;
  private int b;
  private int c;
  private int d;
  private Integer e = null;
  private int f;
  private int g = -1;
  private int h = 0;
  private boolean i = false;
  private OutputStream j;
  private Bitmap k;
  private byte[] l;
  private byte[] m;
  private int n;
  private byte[] o;
  private boolean[] p = new boolean[256];
  private int q = 7;
  private int r = -1;
  private boolean s = false;
  private boolean t = true;
  private boolean u = false;
  private int v = 10;
  private boolean w;
  
  private void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private void a(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      this.j.write((byte)paramString.charAt(i1));
      i1 += 1;
    }
  }
  
  private void b()
  {
    Object localObject = this.l;
    int i2 = localObject.length;
    int i4 = i2 / 3;
    this.m = new byte[i4];
    localObject = new NeuQuant((byte[])localObject, i2, this.v);
    this.o = ((NeuQuant)localObject).d();
    i2 = 0;
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = this.o;
      if (i2 >= arrayOfByte.length) {
        break;
      }
      int i1 = arrayOfByte[i2];
      i3 = i2 + 2;
      arrayOfByte[i2] = arrayOfByte[i3];
      arrayOfByte[i3] = i1;
      this.p[(i2 / 3)] = false;
      i2 += 3;
    }
    i2 = 0;
    int i3 = 0;
    while (i2 < i4)
    {
      arrayOfByte = this.l;
      int i5 = i3 + 1;
      int i6 = arrayOfByte[i3];
      i3 = i5 + 1;
      i5 = ((NeuQuant)localObject).a(i6 & 0xFF, arrayOfByte[i5] & 0xFF, arrayOfByte[i3] & 0xFF);
      this.p[i5] = true;
      this.m[i2] = ((byte)i5);
      i2 += 1;
      i3 += 1;
    }
    this.l = null;
    this.n = 8;
    this.q = 7;
    localObject = this.e;
    if (localObject != null)
    {
      this.f = c(((Integer)localObject).intValue());
      return;
    }
    if (this.w) {
      this.f = c(0);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.j.write(44);
    d(paramInt1);
    d(paramInt2);
    d(this.a);
    d(this.b);
    if (this.t)
    {
      this.j.write(0);
      return;
    }
    this.j.write(this.q | 0x80);
  }
  
  private int c(int paramInt)
  {
    if (this.o == null) {
      return -1;
    }
    int i6 = Color.red(paramInt);
    int i7 = Color.green(paramInt);
    int i8 = Color.blue(paramInt);
    int i9 = this.o.length;
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (paramInt = 16777216; i3 < i9; paramInt = i2)
    {
      byte[] arrayOfByte = this.o;
      int i4 = i3 + 1;
      i2 = i6 - (arrayOfByte[i3] & 0xFF);
      int i10 = i4 + 1;
      i3 = i7 - (arrayOfByte[i4] & 0xFF);
      i4 = i8 - (arrayOfByte[i10] & 0xFF);
      int i5 = i2 * i2 + i3 * i3 + i4 * i4;
      i4 = i10 / 3;
      i3 = i1;
      i2 = paramInt;
      if (this.p[i4] != 0)
      {
        i3 = i1;
        i2 = paramInt;
        if (i5 < paramInt)
        {
          i2 = i5;
          i3 = i4;
        }
      }
      paramInt = i10 + 1;
      i1 = i3;
      i3 = paramInt;
    }
    return i1;
  }
  
  private void c()
  {
    int i1 = this.k.getWidth();
    int i2 = this.k.getHeight();
    if ((i1 != this.a) || (i2 != this.b))
    {
      localObject = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject).drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
      this.k = ((Bitmap)localObject);
    }
    Object localObject = new int[i1 * i2];
    this.k.getPixels((int[])localObject, 0, i1, 0, 0, i1, i2);
    this.l = new byte[localObject.length * 3];
    boolean bool = false;
    this.w = false;
    int i5 = localObject.length;
    i1 = 0;
    int i4 = 0;
    i2 = 0;
    while (i1 < i5)
    {
      int i6 = localObject[i1];
      int i3 = i4;
      if (i6 == 0) {
        i3 = i4 + 1;
      }
      byte[] arrayOfByte = this.l;
      i4 = i2 + 1;
      arrayOfByte[i2] = ((byte)(i6 & 0xFF));
      i2 = i4 + 1;
      arrayOfByte[i4] = ((byte)(i6 >> 8 & 0xFF));
      arrayOfByte[i2] = ((byte)(i6 >> 16 & 0xFF));
      i1 += 1;
      i2 += 1;
      i4 = i3;
    }
    double d1 = i4 * 100;
    double d2 = localObject.length;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    if (d1 > 4.0D) {
      bool = true;
    }
    this.w = bool;
    if (Log.isLoggable("AnimatedGifEncoder", 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("got pixels for frame with ");
      ((StringBuilder)localObject).append(d1);
      ((StringBuilder)localObject).append("% transparent pixels");
      Log.d("AnimatedGifEncoder", ((StringBuilder)localObject).toString());
    }
  }
  
  private void d()
  {
    this.j.write(33);
    this.j.write(249);
    this.j.write(4);
    int i2;
    int i1;
    if ((this.e == null) && (!this.w))
    {
      i2 = 0;
      i1 = 0;
    }
    else
    {
      i2 = 1;
      i1 = 2;
    }
    int i3 = this.r;
    if (i3 >= 0) {
      i1 = i3 & 0x7;
    }
    this.j.write(i2 | i1 << 2 | 0x0 | 0x0);
    d(this.h);
    this.j.write(this.f);
    this.j.write(0);
  }
  
  private void d(int paramInt)
  {
    this.j.write(paramInt & 0xFF);
    this.j.write(paramInt >> 8 & 0xFF);
  }
  
  private void e()
  {
    d(this.a);
    d(this.b);
    this.j.write(this.q | 0xF0);
    this.j.write(0);
    this.j.write(0);
  }
  
  private void f()
  {
    this.j.write(33);
    this.j.write(255);
    this.j.write(11);
    a("NETSCAPE2.0");
    this.j.write(3);
    this.j.write(1);
    d(this.g);
    this.j.write(0);
  }
  
  private void g()
  {
    OutputStream localOutputStream = this.j;
    byte[] arrayOfByte = this.o;
    localOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
    int i2 = this.o.length;
    int i1 = 0;
    while (i1 < 768 - i2)
    {
      this.j.write(0);
      i1 += 1;
    }
  }
  
  private void h()
  {
    new LZWEncoder(this.a, this.b, this.m, this.n).b(this.j);
  }
  
  public void a(int paramInt)
  {
    this.h = Math.round(paramInt / 10.0F);
  }
  
  public boolean a()
  {
    if (!this.i) {
      return false;
    }
    this.i = false;
    try
    {
      this.j.write(59);
      this.j.flush();
      if (this.s) {
        this.j.close();
      }
      bool = true;
    }
    catch (IOException localIOException)
    {
      boolean bool;
      label49:
      break label49;
    }
    bool = false;
    this.f = 0;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.o = null;
    this.s = false;
    this.t = true;
    return bool;
  }
  
  public boolean a(@Nullable Bitmap paramBitmap)
  {
    return a(paramBitmap, 0, 0);
  }
  
  public boolean a(@Nullable Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramBitmap != null) {
      if (!this.i) {
        return false;
      }
    }
    try
    {
      if (this.u) {
        a(this.c, this.d);
      } else {
        a(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      this.k = paramBitmap;
      c();
      b();
      if (this.t)
      {
        e();
        g();
        if (this.g >= 0) {
          f();
        }
      }
      d();
      b(paramInt1, paramInt2);
      if (!this.t) {
        g();
      }
      h();
      this.t = false;
      bool = true;
      return bool;
    }
    catch (IOException paramBitmap) {}
    return false;
  }
  
  public boolean a(@Nullable OutputStream paramOutputStream)
  {
    boolean bool = false;
    if (paramOutputStream == null) {
      return false;
    }
    this.s = false;
    this.j = paramOutputStream;
    try
    {
      a("GIF89a");
      bool = true;
    }
    catch (IOException paramOutputStream)
    {
      label27:
      break label27;
    }
    this.i = bool;
    return bool;
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0) {
      this.g = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.AnimatedGifEncoder
 * JD-Core Version:    0.7.0.1
 */