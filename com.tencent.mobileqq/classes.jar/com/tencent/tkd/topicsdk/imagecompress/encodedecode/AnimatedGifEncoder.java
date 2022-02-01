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
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private Integer jdField_a_of_type_JavaLangInteger = null;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[256];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f = -1;
  private int g = 0;
  private int h;
  private int i = 7;
  private int j = -1;
  private int k = 10;
  
  private int a(int paramInt)
  {
    if (this.jdField_c_of_type_ArrayOfByte == null) {
      return -1;
    }
    int i4 = Color.red(paramInt);
    int i5 = Color.green(paramInt);
    int i6 = Color.blue(paramInt);
    int i7 = this.jdField_c_of_type_ArrayOfByte.length;
    int i1 = 0;
    int m = 0;
    int n;
    for (paramInt = 16777216; i1 < i7; paramInt = n)
    {
      byte[] arrayOfByte = this.jdField_c_of_type_ArrayOfByte;
      int i2 = i1 + 1;
      n = i4 - (arrayOfByte[i1] & 0xFF);
      int i8 = i2 + 1;
      i1 = i5 - (arrayOfByte[i2] & 0xFF);
      i2 = i6 - (arrayOfByte[i8] & 0xFF);
      int i3 = n * n + i1 * i1 + i2 * i2;
      i2 = i8 / 3;
      i1 = m;
      n = paramInt;
      if (this.jdField_a_of_type_ArrayOfBoolean[i2] != 0)
      {
        i1 = m;
        n = paramInt;
        if (i3 < paramInt)
        {
          n = i3;
          i1 = i2;
        }
      }
      paramInt = i8 + 1;
      m = i1;
      i1 = paramInt;
    }
    return m;
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfByte;
    int n = localObject.length;
    int i2 = n / 3;
    this.jdField_b_of_type_ArrayOfByte = new byte[i2];
    localObject = new NeuQuant((byte[])localObject, n, this.k);
    this.jdField_c_of_type_ArrayOfByte = ((NeuQuant)localObject).b();
    n = 0;
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = this.jdField_c_of_type_ArrayOfByte;
      if (n >= arrayOfByte.length) {
        break;
      }
      int m = arrayOfByte[n];
      i1 = n + 2;
      arrayOfByte[n] = arrayOfByte[i1];
      arrayOfByte[i1] = m;
      this.jdField_a_of_type_ArrayOfBoolean[(n / 3)] = false;
      n += 3;
    }
    n = 0;
    int i1 = 0;
    while (n < i2)
    {
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      int i3 = i1 + 1;
      int i4 = arrayOfByte[i1];
      i1 = i3 + 1;
      i3 = ((NeuQuant)localObject).a(i4 & 0xFF, arrayOfByte[i3] & 0xFF, arrayOfByte[i1] & 0xFF);
      this.jdField_a_of_type_ArrayOfBoolean[i3] = true;
      this.jdField_b_of_type_ArrayOfByte[n] = ((byte)i3);
      n += 1;
      i1 += 1;
    }
    this.jdField_a_of_type_ArrayOfByte = null;
    this.h = 8;
    this.i = 7;
    localObject = this.jdField_a_of_type_JavaLangInteger;
    if (localObject != null)
    {
      this.jdField_e_of_type_Int = a(((Integer)localObject).intValue());
      return;
    }
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_e_of_type_Int = a(0);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private void a(String paramString)
  {
    int m = 0;
    while (m < paramString.length())
    {
      this.jdField_a_of_type_JavaIoOutputStream.write((byte)paramString.charAt(m));
      m += 1;
    }
  }
  
  private void b()
  {
    int m = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    if ((m != this.jdField_a_of_type_Int) || (n != this.jdField_b_of_type_Int))
    {
      localObject = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject).drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
    }
    Object localObject = new int[m * n];
    this.jdField_a_of_type_AndroidGraphicsBitmap.getPixels((int[])localObject, 0, m, 0, 0, m, n);
    this.jdField_a_of_type_ArrayOfByte = new byte[localObject.length * 3];
    boolean bool = false;
    this.jdField_e_of_type_Boolean = false;
    int i3 = localObject.length;
    m = 0;
    int i2 = 0;
    n = 0;
    while (m < i3)
    {
      int i4 = localObject[m];
      int i1 = i2;
      if (i4 == 0) {
        i1 = i2 + 1;
      }
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      i2 = n + 1;
      arrayOfByte[n] = ((byte)(i4 & 0xFF));
      n = i2 + 1;
      arrayOfByte[i2] = ((byte)(i4 >> 8 & 0xFF));
      arrayOfByte[n] = ((byte)(i4 >> 16 & 0xFF));
      m += 1;
      n += 1;
      i2 = i1;
    }
    double d1 = i2 * 100;
    double d2 = localObject.length;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    if (d1 > 4.0D) {
      bool = true;
    }
    this.jdField_e_of_type_Boolean = bool;
    if (Log.isLoggable("AnimatedGifEncoder", 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("got pixels for frame with ");
      ((StringBuilder)localObject).append(d1);
      ((StringBuilder)localObject).append("% transparent pixels");
      Log.d("AnimatedGifEncoder", ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoOutputStream.write(44);
    c(paramInt1);
    c(paramInt2);
    c(this.jdField_a_of_type_Int);
    c(this.jdField_b_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaIoOutputStream.write(0);
      return;
    }
    this.jdField_a_of_type_JavaIoOutputStream.write(this.i | 0x80);
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaIoOutputStream.write(33);
    this.jdField_a_of_type_JavaIoOutputStream.write(249);
    this.jdField_a_of_type_JavaIoOutputStream.write(4);
    int n;
    int m;
    if ((this.jdField_a_of_type_JavaLangInteger == null) && (!this.jdField_e_of_type_Boolean))
    {
      n = 0;
      m = 0;
    }
    else
    {
      n = 1;
      m = 2;
    }
    int i1 = this.j;
    if (i1 >= 0) {
      m = i1 & 0x7;
    }
    this.jdField_a_of_type_JavaIoOutputStream.write(n | m << 2 | 0x0 | 0x0);
    c(this.g);
    this.jdField_a_of_type_JavaIoOutputStream.write(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_JavaIoOutputStream.write(0);
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_JavaIoOutputStream.write(paramInt & 0xFF);
    this.jdField_a_of_type_JavaIoOutputStream.write(paramInt >> 8 & 0xFF);
  }
  
  private void d()
  {
    c(this.jdField_a_of_type_Int);
    c(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_JavaIoOutputStream.write(this.i | 0xF0);
    this.jdField_a_of_type_JavaIoOutputStream.write(0);
    this.jdField_a_of_type_JavaIoOutputStream.write(0);
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaIoOutputStream.write(33);
    this.jdField_a_of_type_JavaIoOutputStream.write(255);
    this.jdField_a_of_type_JavaIoOutputStream.write(11);
    a("NETSCAPE2.0");
    this.jdField_a_of_type_JavaIoOutputStream.write(3);
    this.jdField_a_of_type_JavaIoOutputStream.write(1);
    c(this.f);
    this.jdField_a_of_type_JavaIoOutputStream.write(0);
  }
  
  private void f()
  {
    OutputStream localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
    byte[] arrayOfByte = this.jdField_c_of_type_ArrayOfByte;
    localOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
    int n = this.jdField_c_of_type_ArrayOfByte.length;
    int m = 0;
    while (m < 768 - n)
    {
      this.jdField_a_of_type_JavaIoOutputStream.write(0);
      m += 1;
    }
  }
  
  private void g()
  {
    new LZWEncoder(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_ArrayOfByte, this.h).b(this.jdField_a_of_type_JavaIoOutputStream);
  }
  
  public void a(int paramInt)
  {
    this.g = Math.round(paramInt / 10.0F);
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_JavaIoOutputStream.write(59);
      this.jdField_a_of_type_JavaIoOutputStream.flush();
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
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
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
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
      if (!this.jdField_a_of_type_Boolean) {
        return false;
      }
    }
    try
    {
      if (this.jdField_d_of_type_Boolean) {
        a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      } else {
        a(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      b();
      a();
      if (this.jdField_c_of_type_Boolean)
      {
        d();
        f();
        if (this.f >= 0) {
          e();
        }
      }
      c();
      b(paramInt1, paramInt2);
      if (!this.jdField_c_of_type_Boolean) {
        f();
      }
      g();
      this.jdField_c_of_type_Boolean = false;
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
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
    try
    {
      a("GIF89a");
      bool = true;
    }
    catch (IOException paramOutputStream)
    {
      label26:
      break label26;
    }
    this.jdField_a_of_type_Boolean = bool;
    return bool;
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0) {
      this.f = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.AnimatedGifEncoder
 * JD-Core Version:    0.7.0.1
 */