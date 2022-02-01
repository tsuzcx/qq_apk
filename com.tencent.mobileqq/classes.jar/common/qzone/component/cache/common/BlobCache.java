package common.qzone.component.cache.common;

import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.zip.Adler32;

public class BlobCache
  implements Closeable
{
  private RandomAccessFile a;
  private RandomAccessFile b;
  private RandomAccessFile c;
  private FileChannel d;
  private MappedByteBuffer e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private RandomAccessFile l;
  private RandomAccessFile m;
  private int n;
  private int o;
  private byte[] p = new byte[32];
  private byte[] q = new byte[20];
  private Adler32 r = new Adler32();
  private int s;
  private int t;
  
  public BlobCache(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".idx");
    this.a = new RandomAccessFile(localStringBuilder.toString(), "rw");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".0");
    this.b = new RandomAccessFile(localStringBuilder.toString(), "rw");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".1");
    this.c = new RandomAccessFile(localStringBuilder.toString(), "rw");
    this.k = paramInt3;
    if ((!paramBoolean) && (d())) {
      return;
    }
    a(paramInt1, paramInt2);
    if (d()) {
      return;
    }
    c();
    throw new IOException("unable to load index");
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = paramArrayOfByte[paramInt];
    int i2 = paramArrayOfByte[(paramInt + 1)];
    int i3 = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i1 & 0xFF | (i2 & 0xFF) << 8 | (i3 & 0xFF) << 16;
  }
  
  private void a(int paramInt)
  {
    byte[] arrayOfByte = new byte[1024];
    this.e.position(paramInt);
    paramInt = this.f * 12;
    while (paramInt > 0)
    {
      int i1 = Math.min(paramInt, 1024);
      this.e.put(arrayOfByte, 0, i1);
      paramInt -= i1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.a.setLength(0L);
    this.a.setLength(paramInt1 * 12 * 2 + 32);
    this.a.seek(0L);
    byte[] arrayOfByte = this.p;
    b(arrayOfByte, 0, -1289277377);
    b(arrayOfByte, 4, paramInt1);
    b(arrayOfByte, 8, paramInt2);
    b(arrayOfByte, 12, 0);
    b(arrayOfByte, 16, 0);
    b(arrayOfByte, 20, 4);
    b(arrayOfByte, 24, this.k);
    b(arrayOfByte, 28, a(arrayOfByte, 0, 28));
    this.a.write(arrayOfByte);
    this.b.setLength(0L);
    this.c.setLength(0L);
    this.b.seek(0L);
    this.c.seek(0L);
    b(arrayOfByte, 0, -1121680097);
    this.b.write(arrayOfByte, 0, 4);
    this.c.write(arrayOfByte, 0, 4);
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.q;
    int i1 = a(paramArrayOfByte, 0, paramInt);
    a(arrayOfByte, 0, paramLong);
    b(arrayOfByte, 8, i1);
    b(arrayOfByte, 12, this.j);
    b(arrayOfByte, 16, paramInt);
    this.l.write(arrayOfByte);
    this.l.write(paramArrayOfByte, 0, paramInt);
    this.e.putLong(this.s, paramLong);
    this.e.putInt(this.s + 8, this.j);
    this.j += paramInt + 20;
    b(this.p, 20, this.j);
  }
  
  static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    int i1 = 0;
    while (i1 < 8)
    {
      paramArrayOfByte[(paramInt + i1)] = ((byte)(int)(0xFF & paramLong));
      paramLong >>= 8;
      i1 += 1;
    }
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    int i3 = this.f;
    int i2 = (int)(paramLong % i3);
    int i1 = i2;
    if (i2 < 0) {
      i1 = i2 + i3;
    }
    i3 = i1;
    for (;;)
    {
      i2 = i3 * 12 + paramInt;
      long l1 = this.e.getLong(i2);
      int i4 = this.e.getInt(i2 + 8);
      if (i4 == 0)
      {
        this.s = i2;
        return false;
      }
      if (l1 == paramLong)
      {
        this.s = i2;
        this.t = i4;
        return true;
      }
      i3 += 1;
      i2 = i3;
      if (i3 >= this.f) {
        i2 = 0;
      }
      i3 = i2;
      if (i2 == i1)
      {
        this.e.putInt(i2 * 12 + paramInt + 8, 0);
        i3 = i2;
      }
    }
  }
  
  /* Error */
  private boolean a(RandomAccessFile paramRandomAccessFile, int paramInt, BlobCache.LookupRequest paramLookupRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	common/qzone/component/cache/common/BlobCache:q	[B
    //   4: astore 12
    //   6: aload_1
    //   7: invokevirtual 179	java/io/RandomAccessFile:getFilePointer	()J
    //   10: lstore 6
    //   12: iload_2
    //   13: i2l
    //   14: lstore 8
    //   16: aload_1
    //   17: lload 8
    //   19: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   22: aload_1
    //   23: aload 12
    //   25: invokevirtual 183	java/io/RandomAccessFile:read	([B)I
    //   28: istore 4
    //   30: iload 4
    //   32: bipush 20
    //   34: if_icmpeq +11 -> 45
    //   37: aload_1
    //   38: lload 6
    //   40: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   43: iconst_0
    //   44: ireturn
    //   45: aload 12
    //   47: iconst_0
    //   48: invokestatic 186	common/qzone/component/cache/common/BlobCache:b	([BI)J
    //   51: lstore 8
    //   53: aload_3
    //   54: getfield 191	common/qzone/component/cache/common/BlobCache$LookupRequest:a	J
    //   57: lstore 10
    //   59: lload 8
    //   61: lload 10
    //   63: lcmp
    //   64: ifeq +11 -> 75
    //   67: aload_1
    //   68: lload 6
    //   70: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   73: iconst_0
    //   74: ireturn
    //   75: aload 12
    //   77: bipush 8
    //   79: invokestatic 193	common/qzone/component/cache/common/BlobCache:a	([BI)I
    //   82: istore 4
    //   84: aload 12
    //   86: bipush 12
    //   88: invokestatic 193	common/qzone/component/cache/common/BlobCache:a	([BI)I
    //   91: istore 5
    //   93: iload 5
    //   95: iload_2
    //   96: if_icmpeq +11 -> 107
    //   99: aload_1
    //   100: lload 6
    //   102: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 12
    //   109: bipush 16
    //   111: invokestatic 193	common/qzone/component/cache/common/BlobCache:a	([BI)I
    //   114: istore 5
    //   116: iload 5
    //   118: iflt +113 -> 231
    //   121: iload 5
    //   123: aload_0
    //   124: getfield 195	common/qzone/component/cache/common/BlobCache:g	I
    //   127: iload_2
    //   128: isub
    //   129: bipush 20
    //   131: isub
    //   132: if_icmple +6 -> 138
    //   135: goto +96 -> 231
    //   138: aload_3
    //   139: getfield 197	common/qzone/component/cache/common/BlobCache$LookupRequest:b	[B
    //   142: ifnull +13 -> 155
    //   145: aload_3
    //   146: getfield 197	common/qzone/component/cache/common/BlobCache$LookupRequest:b	[B
    //   149: arraylength
    //   150: iload 5
    //   152: if_icmpge +11 -> 163
    //   155: aload_3
    //   156: iload 5
    //   158: newarray byte
    //   160: putfield 197	common/qzone/component/cache/common/BlobCache$LookupRequest:b	[B
    //   163: aload_3
    //   164: getfield 197	common/qzone/component/cache/common/BlobCache$LookupRequest:b	[B
    //   167: astore 12
    //   169: aload_3
    //   170: iload 5
    //   172: putfield 199	common/qzone/component/cache/common/BlobCache$LookupRequest:c	I
    //   175: aload_1
    //   176: aload 12
    //   178: iconst_0
    //   179: iload 5
    //   181: invokevirtual 201	java/io/RandomAccessFile:read	([BII)I
    //   184: istore_2
    //   185: iload_2
    //   186: iload 5
    //   188: if_icmpeq +11 -> 199
    //   191: aload_1
    //   192: lload 6
    //   194: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   197: iconst_0
    //   198: ireturn
    //   199: aload_0
    //   200: aload 12
    //   202: iconst_0
    //   203: iload 5
    //   205: invokevirtual 130	common/qzone/component/cache/common/BlobCache:a	([BII)I
    //   208: istore_2
    //   209: iload_2
    //   210: iload 4
    //   212: if_icmpeq +11 -> 223
    //   215: aload_1
    //   216: lload 6
    //   218: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   221: iconst_0
    //   222: ireturn
    //   223: aload_1
    //   224: lload 6
    //   226: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   229: iconst_1
    //   230: ireturn
    //   231: aload_1
    //   232: lload 6
    //   234: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   237: iconst_0
    //   238: ireturn
    //   239: astore_3
    //   240: goto +21 -> 261
    //   243: astore_3
    //   244: ldc 203
    //   246: iconst_2
    //   247: ldc 205
    //   249: aload_3
    //   250: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_1
    //   254: lload 6
    //   256: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   259: iconst_0
    //   260: ireturn
    //   261: aload_1
    //   262: lload 6
    //   264: invokevirtual 123	java/io/RandomAccessFile:seek	(J)V
    //   267: aload_3
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	BlobCache
    //   0	269	1	paramRandomAccessFile	RandomAccessFile
    //   0	269	2	paramInt	int
    //   0	269	3	paramLookupRequest	BlobCache.LookupRequest
    //   28	185	4	i1	int
    //   91	113	5	i2	int
    //   10	253	6	l1	long
    //   14	46	8	l2	long
    //   57	5	10	l3	long
    //   4	197	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	30	239	finally
    //   45	59	239	finally
    //   75	93	239	finally
    //   107	116	239	finally
    //   121	135	239	finally
    //   138	155	239	finally
    //   155	163	239	finally
    //   163	185	239	finally
    //   199	209	239	finally
    //   244	253	239	finally
    //   16	30	243	java/lang/Throwable
    //   45	59	243	java/lang/Throwable
    //   75	93	243	java/lang/Throwable
    //   107	116	243	java/lang/Throwable
    //   121	135	243	java/lang/Throwable
    //   138	155	243	java/lang/Throwable
    //   155	163	243	java/lang/Throwable
    //   163	185	243	java/lang/Throwable
    //   199	209	243	java/lang/Throwable
  }
  
  static long b(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[(paramInt + 7)] & 0xFF;
    int i1 = 6;
    while (i1 >= 0)
    {
      l1 = l1 << 8 | paramArrayOfByte[(paramInt + i1)] & 0xFF;
      i1 -= 1;
    }
    return l1;
  }
  
  static void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < 4)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(i1 & 0xFF));
      i1 >>= 8;
      paramInt2 += 1;
    }
  }
  
  private void c()
  {
    a(this.d);
    a(this.a);
    a(this.b);
    a(this.c);
  }
  
  private boolean d()
  {
    try
    {
      this.a.seek(0L);
      this.b.seek(0L);
      this.c.seek(0L);
      byte[] arrayOfByte = this.p;
      if (this.a.read(arrayOfByte) != 32) {
        return false;
      }
      if (a(arrayOfByte, 0) != -1289277377) {
        return false;
      }
      if (a(arrayOfByte, 24) != this.k) {
        return false;
      }
      this.f = a(arrayOfByte, 4);
      this.g = a(arrayOfByte, 8);
      this.h = a(arrayOfByte, 12);
      this.i = a(arrayOfByte, 16);
      this.j = a(arrayOfByte, 20);
      int i1 = a(arrayOfByte, 28);
      if (a(arrayOfByte, 0, 28) != i1) {
        return false;
      }
      if (this.f <= 0) {
        return false;
      }
      if (this.g <= 0) {
        return false;
      }
      if ((this.h != 0) && (this.h != 1)) {
        return false;
      }
      if (this.i >= 0)
      {
        if (this.i > this.f) {
          return false;
        }
        if (this.j >= 4)
        {
          if (this.j > this.g) {
            return false;
          }
          if (this.a.length() != this.f * 12 * 2 + 32) {
            return false;
          }
          arrayOfByte = new byte[4];
          if (this.b.read(arrayOfByte) != 4) {
            return false;
          }
          if (a(arrayOfByte, 0) != -1121680097) {
            return false;
          }
          if (this.c.read(arrayOfByte) != 4) {
            return false;
          }
          if (a(arrayOfByte, 0) != -1121680097) {
            return false;
          }
          this.d = this.a.getChannel();
          this.e = this.d.map(FileChannel.MapMode.READ_WRITE, 0L, this.a.length());
          this.e.order(ByteOrder.LITTLE_ENDIAN);
          e();
          return true;
        }
      }
      return false;
    }
    catch (IOException localIOException)
    {
      QLog.e("BlobCache", 2, "loadIndex failed.", localIOException);
    }
    return false;
  }
  
  private void e()
  {
    RandomAccessFile localRandomAccessFile;
    if (this.h == 0) {
      localRandomAccessFile = this.b;
    } else {
      localRandomAccessFile = this.c;
    }
    this.l = localRandomAccessFile;
    if (this.h == 1) {
      localRandomAccessFile = this.b;
    } else {
      localRandomAccessFile = this.c;
    }
    this.m = localRandomAccessFile;
    this.l.setLength(this.j);
    this.l.seek(this.j);
    this.n = 32;
    this.o = 32;
    if (this.h == 0)
    {
      this.o += this.f * 12;
      return;
    }
    this.n += this.f * 12;
  }
  
  private void f()
  {
    this.h = (1 - this.h);
    this.i = 0;
    this.j = 4;
    b(this.p, 12, this.h);
    b(this.p, 16, this.i);
    b(this.p, 20, this.j);
    g();
    e();
    a(this.n);
    a();
  }
  
  private void g()
  {
    byte[] arrayOfByte = this.p;
    b(arrayOfByte, 28, a(arrayOfByte, 0, 28));
    this.e.position(0);
    this.e.put(this.p);
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.r.reset();
    this.r.update(paramArrayOfByte, paramInt1, paramInt2);
    return (int)this.r.getValue();
  }
  
  public void a()
  {
    try
    {
      this.e.force();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    int i2 = this.g;
    if (i1 + 24 <= i2)
    {
      if ((this.j + 20 + paramArrayOfByte.length > i2) || (this.i * 2 >= this.f)) {
        f();
      }
      if (!a(paramLong, this.n))
      {
        this.i += 1;
        b(this.p, 16, this.i);
      }
      a(paramLong, paramArrayOfByte, paramArrayOfByte.length);
      g();
      return;
    }
    throw new RuntimeException("blob is too large!");
  }
  
  public boolean a(BlobCache.LookupRequest paramLookupRequest)
  {
    if ((a(paramLookupRequest.a, this.n)) && (a(this.l, this.t, paramLookupRequest))) {
      return true;
    }
    int i1 = this.s;
    if ((a(paramLookupRequest.a, this.o)) && (a(this.m, this.t, paramLookupRequest))) {
      if (this.j + 20 + paramLookupRequest.c <= this.g)
      {
        if (this.i * 2 >= this.f) {
          return true;
        }
        this.s = i1;
      }
    }
    try
    {
      a(paramLookupRequest.a, paramLookupRequest.b, paramLookupRequest.c);
      this.i += 1;
      b(this.p, 16, this.i);
      g();
      return true;
    }
    catch (Throwable paramLookupRequest)
    {
      label153:
      break label153;
    }
    QLog.e("BlobCache", 2, "cannot copy over");
    return true;
    return false;
  }
  
  public void b()
  {
    a();
    try
    {
      this.b.getFD().sync();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          this.c.getFD().sync();
          return;
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
      }
    }
  }
  
  public void close()
  {
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.qzone.component.cache.common.BlobCache
 * JD-Core Version:    0.7.0.1
 */