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
    Object localObject1 = new a(paramFile);
    this.g = ((a)localObject1);
    ((a)localObject1).a(this.b);
    Object localObject2 = this.b;
    int m = 0;
    int k = localObject2[0];
    int n = a[0];
    boolean bool = true;
    if (k == n) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      if (this.b[5] != '\001') {
        bool = false;
      }
      ((a)localObject1).a = bool;
      bool = a();
      if (bool)
      {
        paramFile = new d.f();
        paramFile.a = ((a)localObject1).a();
        paramFile.b = ((a)localObject1).a();
        paramFile.c = ((a)localObject1).b();
        paramFile.k = ((a)localObject1).c();
        paramFile.l = ((a)localObject1).c();
        paramFile.m = ((a)localObject1).c();
        this.h = paramFile;
      }
      else
      {
        paramFile = new d.b();
        paramFile.a = ((a)localObject1).a();
        paramFile.b = ((a)localObject1).a();
        paramFile.c = ((a)localObject1).b();
        paramFile.k = ((a)localObject1).b();
        paramFile.l = ((a)localObject1).b();
        paramFile.m = ((a)localObject1).b();
        this.h = paramFile;
      }
      paramFile = this.h;
      paramFile.d = ((a)localObject1).b();
      paramFile.e = ((a)localObject1).a();
      paramFile.f = ((a)localObject1).a();
      paramFile.g = ((a)localObject1).a();
      paramFile.h = ((a)localObject1).a();
      paramFile.i = ((a)localObject1).a();
      paramFile.j = ((a)localObject1).a();
      this.i = new d.k[paramFile.i];
      k = m;
      while (k < paramFile.i)
      {
        ((a)localObject1).a(paramFile.a() + paramFile.h * k);
        if (bool)
        {
          localObject2 = new d.h();
          ((d.h)localObject2).g = ((a)localObject1).b();
          ((d.h)localObject2).h = ((a)localObject1).b();
          ((d.h)localObject2).a = ((a)localObject1).c();
          ((d.h)localObject2).b = ((a)localObject1).c();
          ((d.h)localObject2).c = ((a)localObject1).c();
          ((d.h)localObject2).d = ((a)localObject1).c();
          ((d.h)localObject2).i = ((a)localObject1).b();
          ((d.h)localObject2).j = ((a)localObject1).b();
          ((d.h)localObject2).e = ((a)localObject1).c();
          ((d.h)localObject2).f = ((a)localObject1).c();
          this.i[k] = localObject2;
        }
        else
        {
          localObject2 = new d.d();
          ((d.d)localObject2).g = ((a)localObject1).b();
          ((d.d)localObject2).h = ((a)localObject1).b();
          ((d.d)localObject2).a = ((a)localObject1).b();
          ((d.d)localObject2).b = ((a)localObject1).b();
          ((d.d)localObject2).c = ((a)localObject1).b();
          ((d.d)localObject2).d = ((a)localObject1).b();
          ((d.d)localObject2).i = ((a)localObject1).b();
          ((d.d)localObject2).j = ((a)localObject1).b();
          ((d.d)localObject2).e = ((a)localObject1).b();
          ((d.d)localObject2).f = ((a)localObject1).b();
          this.i[k] = localObject2;
        }
        k += 1;
      }
      if (paramFile.j >= 0)
      {
        k = paramFile.j;
        localObject2 = this.i;
        if (k < localObject2.length)
        {
          localObject2 = localObject2[paramFile.j];
          if (((d.k)localObject2).h == 3)
          {
            this.j = new byte[((d.k)localObject2).a()];
            ((a)localObject1).a(((d.k)localObject2).b());
            ((a)localObject1).a(this.j);
            if (this.c) {
              b();
            }
            return;
          }
          localObject1 = new StringBuilder("Wrong string section e_shstrndx=");
          ((StringBuilder)localObject1).append(paramFile.j);
          throw new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
        }
      }
      localObject1 = new StringBuilder("Invalid e_shstrndx=");
      ((StringBuilder)localObject1).append(paramFile.j);
      throw new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder("Invalid elf magic: ");
    ((StringBuilder)localObject1).append(paramFile);
    paramFile = new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramFile;
    }
  }
  
  private boolean a()
  {
    return this.b[4] == '\002';
  }
  
  /* Error */
  public static boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: new 207	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: ldc 209
    //   13: invokespecial 212	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: astore 5
    //   18: aload 5
    //   20: invokevirtual 215	java/io/RandomAccessFile:readInt	()I
    //   23: istore_1
    //   24: iload_1
    //   25: i2l
    //   26: lstore_2
    //   27: aload 5
    //   29: invokestatic 220	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   32: goto +62 -> 94
    //   35: astore_0
    //   36: aload 5
    //   38: astore 4
    //   40: goto +66 -> 106
    //   43: astore 4
    //   45: aload 4
    //   47: astore 6
    //   49: goto +13 -> 62
    //   52: astore_0
    //   53: goto +53 -> 106
    //   56: astore 6
    //   58: aload 7
    //   60: astore 5
    //   62: aload 5
    //   64: astore 4
    //   66: ldc 222
    //   68: iconst_2
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload 6
    //   83: aastore
    //   84: invokestatic 232	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload 5
    //   89: invokestatic 220	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   92: lconst_0
    //   93: lstore_2
    //   94: lload_2
    //   95: ldc2_w 233
    //   98: lcmp
    //   99: ifne +5 -> 104
    //   102: iconst_1
    //   103: ireturn
    //   104: iconst_0
    //   105: ireturn
    //   106: aload 4
    //   108: invokestatic 220	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   111: aload_0
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramFile	File
    //   23	2	1	k	int
    //   26	69	2	l	long
    //   4	35	4	localObject1	Object
    //   43	3	4	localThrowable1	java.lang.Throwable
    //   64	43	4	localObject2	Object
    //   16	72	5	localObject3	Object
    //   47	1	6	localThrowable2	java.lang.Throwable
    //   56	26	6	localThrowable3	java.lang.Throwable
    //   1	58	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   18	24	35	finally
    //   18	24	43	java/lang/Throwable
    //   6	18	52	finally
    //   66	87	52	finally
    //   6	18	56	java/lang/Throwable
  }
  
  private void b()
  {
    d.a locala = this.h;
    a locala1 = this.g;
    boolean bool = a();
    Object localObject2 = this.i;
    int i2 = localObject2.length;
    int n = 0;
    int k = 0;
    char[] arrayOfChar;
    int m;
    while (k < i2)
    {
      arrayOfChar = localObject2[k];
      int i1 = arrayOfChar.g;
      if (i1 == 0)
      {
        localObject1 = "SHN_UNDEF";
      }
      else
      {
        m = i1;
        for (;;)
        {
          localObject1 = this.j;
          if (localObject1[m] == 0) {
            break;
          }
          m += 1;
        }
        localObject1 = new String((byte[])localObject1, i1, m - i1);
      }
      if (".dynsym".equals(localObject1))
      {
        localObject1 = arrayOfChar;
        break label131;
      }
      k += 1;
    }
    Object localObject1 = null;
    label131:
    if (localObject1 != null)
    {
      locala1.a(((d.k)localObject1).b());
      m = ((d.k)localObject1).a();
      if (bool) {
        k = 24;
      } else {
        k = 16;
      }
      m /= k;
      this.e = new d.l[m];
      arrayOfChar = new char[1];
      k = 0;
      while (k < m)
      {
        if (bool)
        {
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
        else
        {
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
        k += 1;
      }
      localObject1 = this.i[localObject1.i];
      locala1.a(((d.k)localObject1).b());
      this.f = new byte[((d.k)localObject1).a()];
      locala1.a(this.f);
    }
    this.d = new d.j[locala.g];
    k = n;
    while (k < locala.g)
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
      else
      {
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
      k += 1;
    }
  }
  
  public final void close()
  {
    this.g.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.d
 * JD-Core Version:    0.7.0.1
 */