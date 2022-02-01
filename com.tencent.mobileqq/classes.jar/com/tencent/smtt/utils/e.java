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
    c localc = new c(paramFile);
    this.g = localc;
    localc.a(this.b);
    if (!a()) {
      throw new UnknownFormatConversionException("Invalid elf magic: " + paramFile);
    }
    localc.a(e());
    boolean bool = d();
    int k;
    label238:
    Object localObject;
    if (bool)
    {
      paramFile = new e.f();
      paramFile.a = localc.a();
      paramFile.b = localc.a();
      paramFile.c = localc.b();
      paramFile.k = localc.c();
      paramFile.l = localc.c();
      paramFile.m = localc.c();
      this.h = paramFile;
      paramFile = this.h;
      paramFile.d = localc.b();
      paramFile.e = localc.a();
      paramFile.f = localc.a();
      paramFile.g = localc.a();
      paramFile.h = localc.a();
      paramFile.i = localc.a();
      paramFile.j = localc.a();
      this.i = new e.k[paramFile.i];
      k = 0;
      if (k >= paramFile.i) {
        break label581;
      }
      localc.a(paramFile.a() + paramFile.h * k);
      if (!bool) {
        break label461;
      }
      localObject = new e.h();
      ((e.h)localObject).g = localc.b();
      ((e.h)localObject).h = localc.b();
      ((e.h)localObject).a = localc.c();
      ((e.h)localObject).b = localc.c();
      ((e.h)localObject).c = localc.c();
      ((e.h)localObject).d = localc.c();
      ((e.h)localObject).i = localc.b();
      ((e.h)localObject).j = localc.b();
      ((e.h)localObject).e = localc.c();
      ((e.h)localObject).f = localc.c();
      this.i[k] = localObject;
    }
    for (;;)
    {
      k += 1;
      break label238;
      paramFile = new e.b();
      paramFile.a = localc.a();
      paramFile.b = localc.a();
      paramFile.c = localc.b();
      paramFile.k = localc.b();
      paramFile.l = localc.b();
      paramFile.m = localc.b();
      this.h = paramFile;
      break;
      label461:
      localObject = new e.d();
      ((e.d)localObject).g = localc.b();
      ((e.d)localObject).h = localc.b();
      ((e.d)localObject).a = localc.b();
      ((e.d)localObject).b = localc.b();
      ((e.d)localObject).c = localc.b();
      ((e.d)localObject).d = localc.b();
      ((e.d)localObject).i = localc.b();
      ((e.d)localObject).j = localc.b();
      ((e.d)localObject).e = localc.b();
      ((e.d)localObject).f = localc.b();
      this.i[k] = localObject;
    }
    label581:
    if ((paramFile.j > -1) && (paramFile.j < this.i.length))
    {
      localObject = this.i[paramFile.j];
      if (((e.k)localObject).h == 3)
      {
        this.j = new byte[((e.k)localObject).a()];
        localc.a(((e.k)localObject).b());
        localc.a(this.j);
        if (this.c) {
          f();
        }
        return;
      }
      throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + paramFile.j);
    }
    throw new UnknownFormatConversionException("Invalid e_shstrndx=" + paramFile.j);
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
    if ((g()) && (a(paramFile))) {}
    try
    {
      new e(paramFile);
      return true;
    }
    catch (IOException paramFile)
    {
      Log.e("ELF", "checkElfFile IOException: " + paramFile);
      return false;
    }
    catch (UnknownFormatConversionException paramFile)
    {
      for (;;)
      {
        Log.e("ELF", "checkElfFile UnknownFormatConversionException: " + paramFile);
      }
    }
    catch (Throwable paramFile)
    {
      for (;;)
      {
        Log.e("ELF", "checkElfFile Throwable: " + paramFile);
      }
    }
  }
  
  private void f()
  {
    e.a locala = this.h;
    c localc = this.g;
    boolean bool = d();
    Object localObject1 = a(".dynsym");
    if (localObject1 != null)
    {
      localc.a(((e.k)localObject1).b());
      int m = ((e.k)localObject1).a();
      char[] arrayOfChar;
      label72:
      Object localObject2;
      if (bool)
      {
        k = 24;
        m /= k;
        this.e = new e.l[m];
        arrayOfChar = new char[1];
        k = 0;
        if (k >= m) {
          break label279;
        }
        if (!bool) {
          break label185;
        }
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
      for (;;)
      {
        k += 1;
        break label72;
        k = 16;
        break;
        label185:
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
      label279:
      localObject1 = this.i[localObject1.i];
      localc.a(((e.k)localObject1).b());
      this.f = new byte[((e.k)localObject1).a()];
      localc.a(this.f);
    }
    this.d = new e.j[locala.g];
    int k = 0;
    if (k < locala.g)
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
      for (;;)
      {
        k += 1;
        break;
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
    while (this.j[k] != 0) {
      k += 1;
    }
    return new String(this.j, paramInt, k - paramInt);
  }
  
  final boolean a()
  {
    boolean bool = false;
    if (this.b[0] == a[0]) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.e
 * JD-Core Version:    0.7.0.1
 */