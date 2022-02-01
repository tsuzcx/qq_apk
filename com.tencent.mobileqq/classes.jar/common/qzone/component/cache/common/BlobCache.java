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
  private int jdField_a_of_type_Int;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private MappedByteBuffer jdField_a_of_type_JavaNioMappedByteBuffer;
  private FileChannel jdField_a_of_type_JavaNioChannelsFileChannel;
  private Adler32 jdField_a_of_type_JavaUtilZipAdler32 = new Adler32();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[32];
  private int jdField_b_of_type_Int;
  private RandomAccessFile jdField_b_of_type_JavaIoRandomAccessFile;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[20];
  private int jdField_c_of_type_Int;
  private RandomAccessFile jdField_c_of_type_JavaIoRandomAccessFile;
  private int jdField_d_of_type_Int;
  private RandomAccessFile jdField_d_of_type_JavaIoRandomAccessFile;
  private int jdField_e_of_type_Int;
  private RandomAccessFile jdField_e_of_type_JavaIoRandomAccessFile;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public BlobCache(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".idx");
    this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localStringBuilder.toString(), "rw");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".0");
    this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localStringBuilder.toString(), "rw");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".1");
    this.jdField_c_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localStringBuilder.toString(), "rw");
    this.f = paramInt3;
    if ((!paramBoolean) && (a())) {
      return;
    }
    a(paramInt1, paramInt2);
    if (a()) {
      return;
    }
    c();
    throw new IOException("unable to load index");
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramArrayOfByte[paramInt];
    int m = paramArrayOfByte[(paramInt + 1)];
    int n = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | k & 0xFF | (m & 0xFF) << 8 | (n & 0xFF) << 16;
  }
  
  static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = paramArrayOfByte[(paramInt + 7)] & 0xFF;
    int k = 6;
    while (k >= 0)
    {
      l = l << 8 | paramArrayOfByte[(paramInt + k)] & 0xFF;
      k -= 1;
    }
    return l;
  }
  
  private void a(int paramInt)
  {
    byte[] arrayOfByte = new byte[1024];
    this.jdField_a_of_type_JavaNioMappedByteBuffer.position(paramInt);
    paramInt = this.jdField_a_of_type_Int * 12;
    while (paramInt > 0)
    {
      int k = Math.min(paramInt, 1024);
      this.jdField_a_of_type_JavaNioMappedByteBuffer.put(arrayOfByte, 0, k);
      paramInt -= k;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(0L);
    this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(paramInt1 * 12 * 2 + 32);
    this.jdField_a_of_type_JavaIoRandomAccessFile.seek(0L);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    a(arrayOfByte, 0, -1289277377);
    a(arrayOfByte, 4, paramInt1);
    a(arrayOfByte, 8, paramInt2);
    a(arrayOfByte, 12, 0);
    a(arrayOfByte, 16, 0);
    a(arrayOfByte, 20, 4);
    a(arrayOfByte, 24, this.f);
    a(arrayOfByte, 28, a(arrayOfByte, 0, 28));
    this.jdField_a_of_type_JavaIoRandomAccessFile.write(arrayOfByte);
    this.jdField_b_of_type_JavaIoRandomAccessFile.setLength(0L);
    this.jdField_c_of_type_JavaIoRandomAccessFile.setLength(0L);
    this.jdField_b_of_type_JavaIoRandomAccessFile.seek(0L);
    this.jdField_c_of_type_JavaIoRandomAccessFile.seek(0L);
    a(arrayOfByte, 0, -1121680097);
    this.jdField_b_of_type_JavaIoRandomAccessFile.write(arrayOfByte, 0, 4);
    this.jdField_c_of_type_JavaIoRandomAccessFile.write(arrayOfByte, 0, 4);
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    int k = a(paramArrayOfByte, 0, paramInt);
    a(arrayOfByte, 0, paramLong);
    a(arrayOfByte, 8, k);
    a(arrayOfByte, 12, this.jdField_e_of_type_Int);
    a(arrayOfByte, 16, paramInt);
    this.jdField_d_of_type_JavaIoRandomAccessFile.write(arrayOfByte);
    this.jdField_d_of_type_JavaIoRandomAccessFile.write(paramArrayOfByte, 0, paramInt);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.putLong(this.i, paramLong);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.putInt(this.i + 8, this.jdField_e_of_type_Int);
    this.jdField_e_of_type_Int += paramInt + 20;
    a(this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_e_of_type_Int);
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
  
  static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m = 0;
    int k = paramInt2;
    paramInt2 = m;
    while (paramInt2 < 4)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(k & 0xFF));
      k >>= 8;
      paramInt2 += 1;
    }
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    int k = 0;
    while (k < 8)
    {
      paramArrayOfByte[(paramInt + k)] = ((byte)(int)(0xFF & paramLong));
      paramLong >>= 8;
      k += 1;
    }
  }
  
  private boolean a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(0L);
      this.jdField_b_of_type_JavaIoRandomAccessFile.seek(0L);
      this.jdField_c_of_type_JavaIoRandomAccessFile.seek(0L);
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte) != 32) {
        return false;
      }
      if (a(arrayOfByte, 0) != -1289277377) {
        return false;
      }
      if (a(arrayOfByte, 24) != this.f) {
        return false;
      }
      this.jdField_a_of_type_Int = a(arrayOfByte, 4);
      this.jdField_b_of_type_Int = a(arrayOfByte, 8);
      this.jdField_c_of_type_Int = a(arrayOfByte, 12);
      this.jdField_d_of_type_Int = a(arrayOfByte, 16);
      this.jdField_e_of_type_Int = a(arrayOfByte, 20);
      int k = a(arrayOfByte, 28);
      if (a(arrayOfByte, 0, 28) != k) {
        return false;
      }
      if (this.jdField_a_of_type_Int <= 0) {
        return false;
      }
      if (this.jdField_b_of_type_Int <= 0) {
        return false;
      }
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 1)) {
        return false;
      }
      if (this.jdField_d_of_type_Int >= 0)
      {
        if (this.jdField_d_of_type_Int > this.jdField_a_of_type_Int) {
          return false;
        }
        if (this.jdField_e_of_type_Int >= 4)
        {
          if (this.jdField_e_of_type_Int > this.jdField_b_of_type_Int) {
            return false;
          }
          if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() != this.jdField_a_of_type_Int * 12 * 2 + 32) {
            return false;
          }
          arrayOfByte = new byte[4];
          if (this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte) != 4) {
            return false;
          }
          if (a(arrayOfByte, 0) != -1121680097) {
            return false;
          }
          if (this.jdField_c_of_type_JavaIoRandomAccessFile.read(arrayOfByte) != 4) {
            return false;
          }
          if (a(arrayOfByte, 0) != -1121680097) {
            return false;
          }
          this.jdField_a_of_type_JavaNioChannelsFileChannel = this.jdField_a_of_type_JavaIoRandomAccessFile.getChannel();
          this.jdField_a_of_type_JavaNioMappedByteBuffer = this.jdField_a_of_type_JavaNioChannelsFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, this.jdField_a_of_type_JavaIoRandomAccessFile.length());
          this.jdField_a_of_type_JavaNioMappedByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          d();
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
  
  private boolean a(long paramLong, int paramInt)
  {
    int n = this.jdField_a_of_type_Int;
    int m = (int)(paramLong % n);
    int k = m;
    if (m < 0) {
      k = m + n;
    }
    n = k;
    for (;;)
    {
      m = n * 12 + paramInt;
      long l = this.jdField_a_of_type_JavaNioMappedByteBuffer.getLong(m);
      int i1 = this.jdField_a_of_type_JavaNioMappedByteBuffer.getInt(m + 8);
      if (i1 == 0)
      {
        this.i = m;
        return false;
      }
      if (l == paramLong)
      {
        this.i = m;
        this.j = i1;
        return true;
      }
      n += 1;
      m = n;
      if (n >= this.jdField_a_of_type_Int) {
        m = 0;
      }
      n = m;
      if (m == k)
      {
        this.jdField_a_of_type_JavaNioMappedByteBuffer.putInt(m * 12 + paramInt + 8, 0);
        n = m;
      }
    }
  }
  
  /* Error */
  private boolean a(RandomAccessFile paramRandomAccessFile, int paramInt, BlobCache.LookupRequest paramLookupRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	common/qzone/component/cache/common/BlobCache:jdField_b_of_type_ArrayOfByte	[B
    //   4: astore 12
    //   6: aload_1
    //   7: invokevirtual 224	java/io/RandomAccessFile:getFilePointer	()J
    //   10: lstore 6
    //   12: iload_2
    //   13: i2l
    //   14: lstore 8
    //   16: aload_1
    //   17: lload 8
    //   19: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   22: aload_1
    //   23: aload 12
    //   25: invokevirtual 158	java/io/RandomAccessFile:read	([B)I
    //   28: istore 4
    //   30: iload 4
    //   32: bipush 20
    //   34: if_icmpeq +11 -> 45
    //   37: aload_1
    //   38: lload 6
    //   40: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   43: iconst_0
    //   44: ireturn
    //   45: aload 12
    //   47: iconst_0
    //   48: invokestatic 226	common/qzone/component/cache/common/BlobCache:a	([BI)J
    //   51: lstore 8
    //   53: aload_3
    //   54: getfield 231	common/qzone/component/cache/common/BlobCache$LookupRequest:jdField_a_of_type_Long	J
    //   57: lstore 10
    //   59: lload 8
    //   61: lload 10
    //   63: lcmp
    //   64: ifeq +11 -> 75
    //   67: aload_1
    //   68: lload 6
    //   70: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   73: iconst_0
    //   74: ireturn
    //   75: aload 12
    //   77: bipush 8
    //   79: invokestatic 160	common/qzone/component/cache/common/BlobCache:a	([BI)I
    //   82: istore 4
    //   84: aload 12
    //   86: bipush 12
    //   88: invokestatic 160	common/qzone/component/cache/common/BlobCache:a	([BI)I
    //   91: istore 5
    //   93: iload 5
    //   95: iload_2
    //   96: if_icmpeq +11 -> 107
    //   99: aload_1
    //   100: lload 6
    //   102: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 12
    //   109: bipush 16
    //   111: invokestatic 160	common/qzone/component/cache/common/BlobCache:a	([BI)I
    //   114: istore 5
    //   116: iload 5
    //   118: iflt +113 -> 231
    //   121: iload 5
    //   123: aload_0
    //   124: getfield 162	common/qzone/component/cache/common/BlobCache:jdField_b_of_type_Int	I
    //   127: iload_2
    //   128: isub
    //   129: bipush 20
    //   131: isub
    //   132: if_icmple +6 -> 138
    //   135: goto +96 -> 231
    //   138: aload_3
    //   139: getfield 232	common/qzone/component/cache/common/BlobCache$LookupRequest:jdField_a_of_type_ArrayOfByte	[B
    //   142: ifnull +13 -> 155
    //   145: aload_3
    //   146: getfield 232	common/qzone/component/cache/common/BlobCache$LookupRequest:jdField_a_of_type_ArrayOfByte	[B
    //   149: arraylength
    //   150: iload 5
    //   152: if_icmpge +11 -> 163
    //   155: aload_3
    //   156: iload 5
    //   158: newarray byte
    //   160: putfield 232	common/qzone/component/cache/common/BlobCache$LookupRequest:jdField_a_of_type_ArrayOfByte	[B
    //   163: aload_3
    //   164: getfield 232	common/qzone/component/cache/common/BlobCache$LookupRequest:jdField_a_of_type_ArrayOfByte	[B
    //   167: astore 12
    //   169: aload_3
    //   170: iload 5
    //   172: putfield 233	common/qzone/component/cache/common/BlobCache$LookupRequest:jdField_a_of_type_Int	I
    //   175: aload_1
    //   176: aload 12
    //   178: iconst_0
    //   179: iload 5
    //   181: invokevirtual 235	java/io/RandomAccessFile:read	([BII)I
    //   184: istore_2
    //   185: iload_2
    //   186: iload 5
    //   188: if_icmpeq +11 -> 199
    //   191: aload_1
    //   192: lload 6
    //   194: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   197: iconst_0
    //   198: ireturn
    //   199: aload_0
    //   200: aload 12
    //   202: iconst_0
    //   203: iload 5
    //   205: invokevirtual 121	common/qzone/component/cache/common/BlobCache:a	([BII)I
    //   208: istore_2
    //   209: iload_2
    //   210: iload 4
    //   212: if_icmpeq +11 -> 223
    //   215: aload_1
    //   216: lload 6
    //   218: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   221: iconst_0
    //   222: ireturn
    //   223: aload_1
    //   224: lload 6
    //   226: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   229: iconst_1
    //   230: ireturn
    //   231: aload_1
    //   232: lload 6
    //   234: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   237: iconst_0
    //   238: ireturn
    //   239: astore_3
    //   240: goto +21 -> 261
    //   243: astore_3
    //   244: ldc 202
    //   246: iconst_2
    //   247: ldc 237
    //   249: aload_3
    //   250: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_1
    //   254: lload 6
    //   256: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   259: iconst_0
    //   260: ireturn
    //   261: aload_1
    //   262: lload 6
    //   264: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   267: aload_3
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	BlobCache
    //   0	269	1	paramRandomAccessFile	RandomAccessFile
    //   0	269	2	paramInt	int
    //   0	269	3	paramLookupRequest	BlobCache.LookupRequest
    //   28	185	4	k	int
    //   91	113	5	m	int
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
  
  private void c()
  {
    a(this.jdField_a_of_type_JavaNioChannelsFileChannel);
    a(this.jdField_a_of_type_JavaIoRandomAccessFile);
    a(this.jdField_b_of_type_JavaIoRandomAccessFile);
    a(this.jdField_c_of_type_JavaIoRandomAccessFile);
  }
  
  private void d()
  {
    RandomAccessFile localRandomAccessFile;
    if (this.jdField_c_of_type_Int == 0) {
      localRandomAccessFile = this.jdField_b_of_type_JavaIoRandomAccessFile;
    } else {
      localRandomAccessFile = this.jdField_c_of_type_JavaIoRandomAccessFile;
    }
    this.jdField_d_of_type_JavaIoRandomAccessFile = localRandomAccessFile;
    if (this.jdField_c_of_type_Int == 1) {
      localRandomAccessFile = this.jdField_b_of_type_JavaIoRandomAccessFile;
    } else {
      localRandomAccessFile = this.jdField_c_of_type_JavaIoRandomAccessFile;
    }
    this.jdField_e_of_type_JavaIoRandomAccessFile = localRandomAccessFile;
    this.jdField_d_of_type_JavaIoRandomAccessFile.setLength(this.jdField_e_of_type_Int);
    this.jdField_d_of_type_JavaIoRandomAccessFile.seek(this.jdField_e_of_type_Int);
    this.g = 32;
    this.h = 32;
    if (this.jdField_c_of_type_Int == 0)
    {
      this.h += this.jdField_a_of_type_Int * 12;
      return;
    }
    this.g += this.jdField_a_of_type_Int * 12;
  }
  
  private void e()
  {
    this.jdField_c_of_type_Int = (1 - this.jdField_c_of_type_Int);
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 4;
    a(this.jdField_a_of_type_ArrayOfByte, 12, this.jdField_c_of_type_Int);
    a(this.jdField_a_of_type_ArrayOfByte, 16, this.jdField_d_of_type_Int);
    a(this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_e_of_type_Int);
    f();
    d();
    a(this.g);
    a();
  }
  
  private void f()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    a(arrayOfByte, 28, a(arrayOfByte, 0, 28));
    this.jdField_a_of_type_JavaNioMappedByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.put(this.jdField_a_of_type_ArrayOfByte);
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilZipAdler32.reset();
    this.jdField_a_of_type_JavaUtilZipAdler32.update(paramArrayOfByte, paramInt1, paramInt2);
    return (int)this.jdField_a_of_type_JavaUtilZipAdler32.getValue();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaNioMappedByteBuffer.force();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    int m = this.jdField_b_of_type_Int;
    if (k + 24 <= m)
    {
      if ((this.jdField_e_of_type_Int + 20 + paramArrayOfByte.length > m) || (this.jdField_d_of_type_Int * 2 >= this.jdField_a_of_type_Int)) {
        e();
      }
      if (!a(paramLong, this.g))
      {
        this.jdField_d_of_type_Int += 1;
        a(this.jdField_a_of_type_ArrayOfByte, 16, this.jdField_d_of_type_Int);
      }
      a(paramLong, paramArrayOfByte, paramArrayOfByte.length);
      f();
      return;
    }
    throw new RuntimeException("blob is too large!");
  }
  
  public boolean a(BlobCache.LookupRequest paramLookupRequest)
  {
    if ((a(paramLookupRequest.jdField_a_of_type_Long, this.g)) && (a(this.jdField_d_of_type_JavaIoRandomAccessFile, this.j, paramLookupRequest))) {
      return true;
    }
    int k = this.i;
    if ((a(paramLookupRequest.jdField_a_of_type_Long, this.h)) && (a(this.jdField_e_of_type_JavaIoRandomAccessFile, this.j, paramLookupRequest))) {
      if (this.jdField_e_of_type_Int + 20 + paramLookupRequest.jdField_a_of_type_Int <= this.jdField_b_of_type_Int)
      {
        if (this.jdField_d_of_type_Int * 2 >= this.jdField_a_of_type_Int) {
          return true;
        }
        this.i = k;
      }
    }
    try
    {
      a(paramLookupRequest.jdField_a_of_type_Long, paramLookupRequest.jdField_a_of_type_ArrayOfByte, paramLookupRequest.jdField_a_of_type_Int);
      this.jdField_d_of_type_Int += 1;
      a(this.jdField_a_of_type_ArrayOfByte, 16, this.jdField_d_of_type_Int);
      f();
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
      this.jdField_b_of_type_JavaIoRandomAccessFile.getFD().sync();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          this.jdField_c_of_type_JavaIoRandomAccessFile.getFD().sync();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.qzone.component.cache.common.BlobCache
 * JD-Core Version:    0.7.0.1
 */