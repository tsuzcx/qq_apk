package com.tencent.smtt.utils;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public class e
  implements Closeable
{
  static final char[] a = { 127, 69, 76, 70, 0 };
  final char[] b = new char[16];
  boolean c;
  e.j[] d;
  e.l[] e;
  byte[] f;
  private final c g;
  private final e.a h;
  private final e.k[] i;
  private byte[] j;
  
  public e(File paramFile)
  {
    Object localObject1 = new c(paramFile);
    this.g = ((c)localObject1);
    ((c)localObject1).a(this.b);
    if (a())
    {
      ((c)localObject1).a(e());
      boolean bool = d();
      if (bool)
      {
        paramFile = new e.f();
        paramFile.a = ((c)localObject1).a();
        paramFile.b = ((c)localObject1).a();
        paramFile.c = ((c)localObject1).b();
        paramFile.k = ((c)localObject1).c();
        paramFile.l = ((c)localObject1).c();
        paramFile.m = ((c)localObject1).c();
      }
      else
      {
        paramFile = new e.b();
        paramFile.a = ((c)localObject1).a();
        paramFile.b = ((c)localObject1).a();
        paramFile.c = ((c)localObject1).b();
        paramFile.k = ((c)localObject1).b();
        paramFile.l = ((c)localObject1).b();
        paramFile.m = ((c)localObject1).b();
      }
      this.h = paramFile;
      paramFile = this.h;
      paramFile.d = ((c)localObject1).b();
      paramFile.e = ((c)localObject1).a();
      paramFile.f = ((c)localObject1).a();
      paramFile.g = ((c)localObject1).a();
      paramFile.h = ((c)localObject1).a();
      paramFile.i = ((c)localObject1).a();
      paramFile.j = ((c)localObject1).a();
      this.i = new e.k[paramFile.i];
      int k = 0;
      Object localObject2;
      while (k < paramFile.i)
      {
        ((c)localObject1).a(paramFile.a() + paramFile.h * k);
        if (bool)
        {
          localObject2 = new e.h();
          ((e.h)localObject2).g = ((c)localObject1).b();
          ((e.h)localObject2).h = ((c)localObject1).b();
          ((e.h)localObject2).a = ((c)localObject1).c();
          ((e.h)localObject2).b = ((c)localObject1).c();
          ((e.h)localObject2).c = ((c)localObject1).c();
          ((e.h)localObject2).d = ((c)localObject1).c();
          ((e.h)localObject2).i = ((c)localObject1).b();
          ((e.h)localObject2).j = ((c)localObject1).b();
          ((e.h)localObject2).e = ((c)localObject1).c();
          ((e.h)localObject2).f = ((c)localObject1).c();
          this.i[k] = localObject2;
        }
        else
        {
          localObject2 = new e.d();
          ((e.d)localObject2).g = ((c)localObject1).b();
          ((e.d)localObject2).h = ((c)localObject1).b();
          ((e.d)localObject2).a = ((c)localObject1).b();
          ((e.d)localObject2).b = ((c)localObject1).b();
          ((e.d)localObject2).c = ((c)localObject1).b();
          ((e.d)localObject2).d = ((c)localObject1).b();
          ((e.d)localObject2).i = ((c)localObject1).b();
          ((e.d)localObject2).j = ((c)localObject1).b();
          ((e.d)localObject2).e = ((c)localObject1).b();
          ((e.d)localObject2).f = ((c)localObject1).b();
          this.i[k] = localObject2;
        }
        k += 1;
      }
      if (paramFile.j > -1)
      {
        k = paramFile.j;
        localObject2 = this.i;
        if (k < localObject2.length)
        {
          localObject2 = localObject2[paramFile.j];
          if (((e.k)localObject2).h == 3)
          {
            this.j = new byte[((e.k)localObject2).a()];
            ((c)localObject1).a(((e.k)localObject2).b());
            ((c)localObject1).a(this.j);
            if (this.c) {
              f();
            }
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Wrong string section e_shstrndx=");
          ((StringBuilder)localObject1).append(paramFile.j);
          throw new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid e_shstrndx=");
      ((StringBuilder)localObject1).append(paramFile.j);
      throw new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid elf magic: ");
    ((StringBuilder)localObject1).append(paramFile);
    paramFile = new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramFile;
    }
  }
  
  public static boolean a(File paramFile)
  {
    boolean bool = false;
    try
    {
      paramFile = new RandomAccessFile(paramFile, "r");
      long l = paramFile.readInt();
      paramFile.close();
      if (l == 2135247942L) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(File paramFile)
  {
    if ((g()) && (a(paramFile))) {
      try
      {
        try
        {
          new e(paramFile);
        }
        catch (Throwable localThrowable)
        {
          paramFile = new StringBuilder();
          localObject = "checkElfFile Throwable: ";
        }
        catch (UnknownFormatConversionException localUnknownFormatConversionException)
        {
          paramFile = new StringBuilder();
          localObject = "checkElfFile UnknownFormatConversionException: ";
        }
        paramFile.append((String)localObject);
        paramFile.append(localUnknownFormatConversionException);
        Log.e("ELF", paramFile.toString());
      }
      catch (IOException paramFile)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkElfFile IOException: ");
        ((StringBuilder)localObject).append(paramFile);
        Log.e("ELF", ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  private void f()
  {
    e.a locala = this.h;
    c localc = this.g;
    boolean bool = d();
    Object localObject1 = a(".dynsym");
    int m = 0;
    if (localObject1 != null)
    {
      localc.a(((e.k)localObject1).b());
      int n = ((e.k)localObject1).a();
      if (bool) {
        k = 24;
      } else {
        k = 16;
      }
      n /= k;
      this.e = new e.l[n];
      char[] arrayOfChar = new char[1];
      k = 0;
      while (k < n)
      {
        Object localObject2;
        if (bool)
        {
          localObject2 = new e.i();
          ((e.i)localObject2).c = localc.b();
          localc.a(arrayOfChar);
          ((e.i)localObject2).d = arrayOfChar[0];
          localc.a(arrayOfChar);
          ((e.i)localObject2).e = arrayOfChar[0];
          ((e.i)localObject2).a = localc.c();
          ((e.i)localObject2).b = localc.c();
          ((e.i)localObject2).f = localc.a();
          this.e[k] = localObject2;
        }
        else
        {
          localObject2 = new e.e();
          ((e.e)localObject2).c = localc.b();
          ((e.e)localObject2).a = localc.b();
          ((e.e)localObject2).b = localc.b();
          localc.a(arrayOfChar);
          ((e.e)localObject2).d = arrayOfChar[0];
          localc.a(arrayOfChar);
          ((e.e)localObject2).e = arrayOfChar[0];
          ((e.e)localObject2).f = localc.a();
          this.e[k] = localObject2;
        }
        k += 1;
      }
      localObject1 = this.i[localObject1.i];
      localc.a(((e.k)localObject1).b());
      this.f = new byte[((e.k)localObject1).a()];
      localc.a(this.f);
    }
    this.d = new e.j[locala.g];
    int k = m;
    while (k < locala.g)
    {
      localc.a(locala.b() + locala.f * k);
      if (bool)
      {
        localObject1 = new e.g();
        ((e.g)localObject1).g = localc.b();
        ((e.g)localObject1).h = localc.b();
        ((e.g)localObject1).a = localc.c();
        ((e.g)localObject1).b = localc.c();
        ((e.g)localObject1).c = localc.c();
        ((e.g)localObject1).d = localc.c();
        ((e.g)localObject1).e = localc.c();
        ((e.g)localObject1).f = localc.c();
        this.d[k] = localObject1;
      }
      else
      {
        localObject1 = new e.c();
        ((e.c)localObject1).g = localc.b();
        ((e.c)localObject1).h = localc.b();
        ((e.c)localObject1).a = localc.b();
        ((e.c)localObject1).b = localc.b();
        ((e.c)localObject1).c = localc.b();
        ((e.c)localObject1).d = localc.b();
        ((e.c)localObject1).e = localc.b();
        ((e.c)localObject1).f = localc.b();
        this.d[k] = localObject1;
      }
      k += 1;
    }
  }
  
  private static boolean g()
  {
    String str = System.getProperty("java.vm.version");
    return (str != null) && (str.startsWith("2"));
  }
  
  public final e.k a(String paramString)
  {
    e.k[] arrayOfk = this.i;
    int m = arrayOfk.length;
    int k = 0;
    while (k < m)
    {
      e.k localk = arrayOfk[k];
      if (paramString.equals(a(localk.g))) {
        return localk;
      }
      k += 1;
    }
    return null;
  }
  
  public final String a(int paramInt)
  {
    if (paramInt == 0) {
      return "SHN_UNDEF";
    }
    int k = paramInt;
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = this.j;
      if (arrayOfByte[k] == 0) {
        break;
      }
      k += 1;
    }
    return new String(arrayOfByte, paramInt, k - paramInt);
  }
  
  final boolean a()
  {
    char[] arrayOfChar = this.b;
    boolean bool = false;
    if (arrayOfChar[0] == a[0]) {
      bool = true;
    }
    return bool;
  }
  
  final char b()
  {
    return this.b[4];
  }
  
  final char c()
  {
    return this.b[5];
  }
  
  public void close()
  {
    this.g.close();
  }
  
  public final boolean d()
  {
    return b() == '\002';
  }
  
  public final boolean e()
  {
    return c() == '\001';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.e
 * JD-Core Version:    0.7.0.1
 */