package com.tencent.tbs.one.impl.c.a;

import java.io.Closeable;
import java.io.File;
import java.util.UnknownFormatConversionException;

public final class d
  implements Closeable
{
  static final char[] a = { 127, 69, 76, 70, 0 };
  final char[] b = new char[16];
  boolean c;
  d.j[] d;
  d.l[] e;
  byte[] f;
  private final a g;
  private final d.a h;
  private final d.k[] i;
  private byte[] j;
  
  public d(File paramFile)
  {
    a locala = new a(paramFile);
    this.g = locala;
    locala.a(this.b);
    if (this.b[0] == a[0]) {}
    for (int k = 1; k == 0; k = 0) {
      throw new UnknownFormatConversionException("Invalid elf magic: " + paramFile);
    }
    label187:
    Object localObject;
    if (this.b[5] == '\001')
    {
      locala.a = bool;
      bool = a();
      if (!bool) {
        break label428;
      }
      paramFile = new d.f();
      paramFile.a = locala.a();
      paramFile.b = locala.a();
      paramFile.c = locala.b();
      paramFile.k = locala.c();
      paramFile.l = locala.c();
      paramFile.m = locala.c();
      this.h = paramFile;
      paramFile = this.h;
      paramFile.d = locala.b();
      paramFile.e = locala.a();
      paramFile.f = locala.a();
      paramFile.g = locala.a();
      paramFile.h = locala.a();
      paramFile.i = locala.a();
      paramFile.j = locala.a();
      this.i = new d.k[paramFile.i];
      k = m;
      label268:
      if (k >= paramFile.i) {
        break label618;
      }
      locala.a(paramFile.a() + paramFile.h * k);
      if (!bool) {
        break label498;
      }
      localObject = new d.h();
      ((d.h)localObject).g = locala.b();
      ((d.h)localObject).h = locala.b();
      ((d.h)localObject).a = locala.c();
      ((d.h)localObject).b = locala.c();
      ((d.h)localObject).c = locala.c();
      ((d.h)localObject).d = locala.c();
      ((d.h)localObject).i = locala.b();
      ((d.h)localObject).j = locala.b();
      ((d.h)localObject).e = locala.c();
      ((d.h)localObject).f = locala.c();
      this.i[k] = localObject;
    }
    for (;;)
    {
      k += 1;
      break label268;
      bool = false;
      break;
      label428:
      paramFile = new d.b();
      paramFile.a = locala.a();
      paramFile.b = locala.a();
      paramFile.c = locala.b();
      paramFile.k = locala.b();
      paramFile.l = locala.b();
      paramFile.m = locala.b();
      this.h = paramFile;
      break label187;
      label498:
      localObject = new d.d();
      ((d.d)localObject).g = locala.b();
      ((d.d)localObject).h = locala.b();
      ((d.d)localObject).a = locala.b();
      ((d.d)localObject).b = locala.b();
      ((d.d)localObject).c = locala.b();
      ((d.d)localObject).d = locala.b();
      ((d.d)localObject).i = locala.b();
      ((d.d)localObject).j = locala.b();
      ((d.d)localObject).e = locala.b();
      ((d.d)localObject).f = locala.b();
      this.i[k] = localObject;
    }
    label618:
    if ((paramFile.j >= 0) && (paramFile.j < this.i.length))
    {
      localObject = this.i[paramFile.j];
      if (((d.k)localObject).h == 3)
      {
        this.j = new byte[((d.k)localObject).a()];
        locala.a(((d.k)localObject).b());
        locala.a(this.j);
        if (this.c) {
          b();
        }
        return;
      }
      throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + paramFile.j);
    }
    throw new UnknownFormatConversionException("Invalid e_shstrndx=" + paramFile.j);
  }
  
  private boolean a()
  {
    return this.b[4] == '\002';
  }
  
  /* Error */
  public static boolean a(File paramFile)
  {
    // Byte code:
    //   0: new 207	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 209
    //   7: invokespecial 212	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload 5
    //   14: astore 4
    //   16: aload 5
    //   18: invokevirtual 215	java/io/RandomAccessFile:readInt	()I
    //   21: istore_1
    //   22: iload_1
    //   23: i2l
    //   24: lstore_2
    //   25: aload 5
    //   27: invokestatic 220	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   30: lload_2
    //   31: ldc2_w 221
    //   34: lcmp
    //   35: ifne +56 -> 91
    //   38: iconst_1
    //   39: ireturn
    //   40: astore 6
    //   42: aconst_null
    //   43: astore 5
    //   45: aload 5
    //   47: astore 4
    //   49: ldc 224
    //   51: iconst_2
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_0
    //   58: invokevirtual 229	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload 6
    //   66: aastore
    //   67: invokestatic 234	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload 5
    //   72: invokestatic 220	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   75: lconst_0
    //   76: lstore_2
    //   77: goto -47 -> 30
    //   80: astore_0
    //   81: aconst_null
    //   82: astore 4
    //   84: aload 4
    //   86: invokestatic 220	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   89: aload_0
    //   90: athrow
    //   91: iconst_0
    //   92: ireturn
    //   93: astore_0
    //   94: goto -10 -> 84
    //   97: astore 6
    //   99: goto -54 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   21	2	1	k	int
    //   24	53	2	l	long
    //   14	71	4	localRandomAccessFile1	java.io.RandomAccessFile
    //   10	61	5	localRandomAccessFile2	java.io.RandomAccessFile
    //   40	25	6	localThrowable1	java.lang.Throwable
    //   97	1	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	12	40	java/lang/Throwable
    //   0	12	80	finally
    //   16	22	93	finally
    //   49	70	93	finally
    //   16	22	97	java/lang/Throwable
  }
  
  private void b()
  {
    d.a locala = this.h;
    a locala1 = this.g;
    boolean bool = a();
    Object localObject2 = this.i;
    int i1 = localObject2.length;
    int k = 0;
    char[] arrayOfChar;
    int n;
    label57:
    label71:
    int m;
    if (k < i1)
    {
      arrayOfChar = localObject2[k];
      n = arrayOfChar.g;
      if (n == 0)
      {
        localObject1 = "SHN_UNDEF";
        if (!".dynsym".equals(localObject1)) {
          break label265;
        }
        localObject1 = arrayOfChar;
        if (localObject1 == null) {
          break label421;
        }
        locala1.a(((d.k)localObject1).b());
        m = ((d.k)localObject1).a();
        if (!bool) {
          break label278;
        }
        k = 24;
        label100:
        m /= k;
        this.e = new d.l[m];
        arrayOfChar = new char[1];
        k = 0;
        label119:
        if (k >= m) {
          break label378;
        }
        if (!bool) {
          break label284;
        }
        localObject2 = new d.i();
        ((d.i)localObject2).c = locala1.b();
        locala1.a(arrayOfChar);
        ((d.i)localObject2).d = arrayOfChar[0];
        locala1.a(arrayOfChar);
        ((d.i)localObject2).e = arrayOfChar[0];
        ((d.i)localObject2).a = locala1.c();
        ((d.i)localObject2).b = locala1.c();
        ((d.i)localObject2).f = locala1.a();
        this.e[k] = localObject2;
      }
    }
    for (;;)
    {
      k += 1;
      break label119;
      m = n;
      while (this.j[m] != 0) {
        m += 1;
      }
      localObject1 = new String(this.j, n, m - n);
      break label57;
      label265:
      k += 1;
      break;
      localObject1 = null;
      break label71;
      label278:
      k = 16;
      break label100;
      label284:
      localObject2 = new d.e();
      ((d.e)localObject2).c = locala1.b();
      ((d.e)localObject2).a = locala1.b();
      ((d.e)localObject2).b = locala1.b();
      locala1.a(arrayOfChar);
      ((d.e)localObject2).d = arrayOfChar[0];
      locala1.a(arrayOfChar);
      ((d.e)localObject2).e = arrayOfChar[0];
      ((d.e)localObject2).f = locala1.a();
      this.e[k] = localObject2;
    }
    label378:
    Object localObject1 = this.i[localObject1.i];
    locala1.a(((d.k)localObject1).b());
    this.f = new byte[((d.k)localObject1).a()];
    locala1.a(this.f);
    label421:
    this.d = new d.j[locala.g];
    k = 0;
    if (k < locala.g)
    {
      locala1.a(locala.b() + locala.f * k);
      if (bool)
      {
        localObject1 = new d.g();
        ((d.g)localObject1).g = locala1.b();
        ((d.g)localObject1).h = locala1.b();
        ((d.g)localObject1).a = locala1.c();
        ((d.g)localObject1).b = locala1.c();
        ((d.g)localObject1).c = locala1.c();
        ((d.g)localObject1).d = locala1.c();
        ((d.g)localObject1).e = locala1.c();
        ((d.g)localObject1).f = locala1.c();
        this.d[k] = localObject1;
      }
      for (;;)
      {
        k += 1;
        break;
        localObject1 = new d.c();
        ((d.c)localObject1).g = locala1.b();
        ((d.c)localObject1).h = locala1.b();
        ((d.c)localObject1).a = locala1.b();
        ((d.c)localObject1).b = locala1.b();
        ((d.c)localObject1).c = locala1.b();
        ((d.c)localObject1).d = locala1.b();
        ((d.c)localObject1).e = locala1.b();
        ((d.c)localObject1).f = locala1.b();
        this.d[k] = localObject1;
      }
    }
  }
  
  public final void close()
  {
    this.g.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.d
 * JD-Core Version:    0.7.0.1
 */