package com.tencent.securitysdk.utils;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ApkSignatureSchemeV2Verifier
{
  static long a(ByteBuffer paramByteBuffer, long paramLong)
  {
    long l = ZipUtils.a(paramByteBuffer);
    if (l < paramLong)
    {
      if (ZipUtils.b(paramByteBuffer) + l == paramLong) {
        return l;
      }
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("ZIP Central Directory offset out of range: ");
    paramByteBuffer.append(l);
    paramByteBuffer.append(". ZIP End of Central Directory offset: ");
    paramByteBuffer.append(paramLong);
    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
  }
  
  static Pair<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile)
  {
    paramRandomAccessFile = ZipUtils.a(paramRandomAccessFile);
    if (paramRandomAccessFile != null) {
      return paramRandomAccessFile;
    }
    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
  }
  
  static Pair<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    if (paramLong >= 32L)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      paramRandomAccessFile.seek(paramLong - localByteBuffer.capacity());
      paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
      if ((localByteBuffer.getLong(8) == 2334950737559900225L) && (localByteBuffer.getLong(16) == 3617552046287187010L))
      {
        long l1 = localByteBuffer.getLong(0);
        if ((l1 >= localByteBuffer.capacity()) && (l1 <= 2147483639L))
        {
          int i = (int)(8L + l1);
          paramLong -= i;
          if (paramLong >= 0L)
          {
            localByteBuffer = ByteBuffer.allocate(i);
            localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            paramRandomAccessFile.seek(paramLong);
            paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
            long l2 = localByteBuffer.getLong(0);
            if (l2 == l1) {
              return Pair.create(localByteBuffer, Long.valueOf(paramLong));
            }
            paramRandomAccessFile = new StringBuilder();
            paramRandomAccessFile.append("APK Signing Block sizes in header and footer do not match: ");
            paramRandomAccessFile.append(l2);
            paramRandomAccessFile.append(" vs ");
            paramRandomAccessFile.append(l1);
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramRandomAccessFile.toString());
          }
          paramRandomAccessFile = new StringBuilder();
          paramRandomAccessFile.append("APK Signing Block offset out of range: ");
          paramRandomAccessFile.append(paramLong);
          throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramRandomAccessFile.toString());
        }
        paramRandomAccessFile = new StringBuilder();
        paramRandomAccessFile.append("APK Signing Block size out of range: ");
        paramRandomAccessFile.append(l1);
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramRandomAccessFile.toString());
      }
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
    }
    paramRandomAccessFile = new StringBuilder();
    paramRandomAccessFile.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
    paramRandomAccessFile.append(paramLong);
    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramRandomAccessFile.toString());
  }
  
  static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = paramByteBuffer.limit();
      int j = paramByteBuffer.position();
      paramInt += j;
      if ((paramInt >= j) && (paramInt <= i))
      {
        paramByteBuffer.limit(paramInt);
        try
        {
          ByteBuffer localByteBuffer = paramByteBuffer.slice();
          localByteBuffer.order(paramByteBuffer.order());
          paramByteBuffer.position(paramInt);
          return localByteBuffer;
        }
        finally
        {
          paramByteBuffer.limit(i);
        }
      }
      throw new BufferUnderflowException();
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("size: ");
    paramByteBuffer.append(paramInt);
    throw new IllegalArgumentException(paramByteBuffer.toString());
  }
  
  static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= paramInt1)
      {
        int i = paramByteBuffer.capacity();
        if (paramInt2 <= paramByteBuffer.capacity())
        {
          i = paramByteBuffer.limit();
          int j = paramByteBuffer.position();
          try
          {
            paramByteBuffer.position(0);
            paramByteBuffer.limit(paramInt2);
            paramByteBuffer.position(paramInt1);
            ByteBuffer localByteBuffer = paramByteBuffer.slice();
            localByteBuffer.order(paramByteBuffer.order());
            return localByteBuffer;
          }
          finally
          {
            paramByteBuffer.position(0);
            paramByteBuffer.limit(i);
            paramByteBuffer.position(j);
          }
        }
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("end > capacity: ");
        paramByteBuffer.append(paramInt2);
        paramByteBuffer.append(" > ");
        paramByteBuffer.append(i);
        throw new IllegalArgumentException(paramByteBuffer.toString());
      }
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("end < start: ");
      paramByteBuffer.append(paramInt2);
      paramByteBuffer.append(" < ");
      paramByteBuffer.append(paramInt1);
      throw new IllegalArgumentException(paramByteBuffer.toString());
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("start: ");
    paramByteBuffer.append(paramInt1);
    throw new IllegalArgumentException(paramByteBuffer.toString());
  }
  
  static void a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
      return;
    }
    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
  }
  
  /* Error */
  public static boolean a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: new 76	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 177
    //   12: invokespecial 180	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokestatic 181	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   20: astore_3
    //   21: aload_3
    //   22: getfield 185	android/util/Pair:first	Ljava/lang/Object;
    //   25: checkcast 56	java/nio/ByteBuffer
    //   28: astore 4
    //   30: aload_3
    //   31: getfield 188	android/util/Pair:second	Ljava/lang/Object;
    //   34: checkcast 105	java/lang/Long
    //   37: invokevirtual 192	java/lang/Long:longValue	()J
    //   40: lstore_1
    //   41: aload_0
    //   42: lload_1
    //   43: invokestatic 195	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/io/RandomAccessFile;J)Z
    //   46: ifne +29 -> 75
    //   49: aload_0
    //   50: aload 4
    //   52: lload_1
    //   53: invokestatic 197	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   56: invokestatic 199	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   59: getfield 185	android/util/Pair:first	Ljava/lang/Object;
    //   62: checkcast 56	java/nio/ByteBuffer
    //   65: invokestatic 202	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:b	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   68: pop
    //   69: aload_0
    //   70: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   73: iconst_1
    //   74: ireturn
    //   75: new 21	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   78: dup
    //   79: ldc 207
    //   81: invokespecial 26	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   84: athrow
    //   85: astore_3
    //   86: goto +43 -> 129
    //   89: astore 4
    //   91: goto +21 -> 112
    //   94: goto +47 -> 141
    //   97: astore 4
    //   99: aload_3
    //   100: astore_0
    //   101: aload 4
    //   103: astore_3
    //   104: goto +25 -> 129
    //   107: astore 4
    //   109: aload 5
    //   111: astore_0
    //   112: aload_0
    //   113: astore_3
    //   114: aload 4
    //   116: invokevirtual 210	java/lang/Throwable:printStackTrace	()V
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   137: aload_3
    //   138: athrow
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_0
    //   152: goto -13 -> 139
    //   155: astore_3
    //   156: goto -62 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	java.lang.String
    //   40	13	1	l	long
    //   4	27	3	localPair	Pair
    //   85	15	3	localObject1	Object
    //   103	35	3	localObject2	Object
    //   155	1	3	localSignatureNotFoundException	ApkSignatureSchemeV2Verifier.SignatureNotFoundException
    //   28	23	4	localByteBuffer	ByteBuffer
    //   89	1	4	localThrowable1	java.lang.Throwable
    //   97	5	4	localObject3	Object
    //   107	8	4	localThrowable2	java.lang.Throwable
    //   1	109	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	69	85	finally
    //   75	85	85	finally
    //   16	69	89	java/lang/Throwable
    //   75	85	89	java/lang/Throwable
    //   5	16	97	finally
    //   114	119	97	finally
    //   5	16	107	java/lang/Throwable
    //   5	16	151	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   16	69	155	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   75	85	155	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
  }
  
  private static ByteBuffer b(ByteBuffer paramByteBuffer)
  {
    a(paramByteBuffer);
    paramByteBuffer = a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() >= 8)
      {
        long l = paramByteBuffer.getLong();
        if ((l >= 4L) && (l <= 2147483647L))
        {
          int j = (int)l;
          int k = paramByteBuffer.position();
          if (j <= paramByteBuffer.remaining())
          {
            if (paramByteBuffer.getInt() == 1896449818) {
              return a(paramByteBuffer, j - 4);
            }
            paramByteBuffer.position(k + j);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("APK Signing Block entry #");
            localStringBuilder.append(i);
            localStringBuilder.append(" size out of range: ");
            localStringBuilder.append(j);
            localStringBuilder.append(", available: ");
            localStringBuilder.append(paramByteBuffer.remaining());
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(localStringBuilder.toString());
          }
        }
        else
        {
          paramByteBuffer = new StringBuilder();
          paramByteBuffer.append("APK Signing Block entry #");
          paramByteBuffer.append(i);
          paramByteBuffer.append(" size out of range: ");
          paramByteBuffer.append(l);
          throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
        }
      }
      else
      {
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("Insufficient data to read size of APK Signing Block entry #");
        paramByteBuffer.append(i);
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
      }
    }
    paramByteBuffer = new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
  
  static ByteBuffer b(ByteBuffer paramByteBuffer, int paramInt)
  {
    a(paramByteBuffer);
    paramByteBuffer = a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() >= 8)
      {
        long l = paramByteBuffer.getLong();
        if ((l >= 4L) && (l <= 2147483647L))
        {
          int j = (int)l;
          int k = paramByteBuffer.position();
          if (j <= paramByteBuffer.remaining())
          {
            if (paramByteBuffer.getInt() == paramInt) {
              return a(paramByteBuffer, j - 4);
            }
            paramByteBuffer.position(k + j);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("APK Signing Block entry #");
            localStringBuilder.append(i);
            localStringBuilder.append(" size out of range: ");
            localStringBuilder.append(j);
            localStringBuilder.append(", available: ");
            localStringBuilder.append(paramByteBuffer.remaining());
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(localStringBuilder.toString());
          }
        }
        else
        {
          paramByteBuffer = new StringBuilder();
          paramByteBuffer.append("APK Signing Block entry #");
          paramByteBuffer.append(i);
          paramByteBuffer.append(" size out of range: ");
          paramByteBuffer.append(l);
          throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
        }
      }
      else
      {
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("Insufficient data to read size of APK Signing Block entry #");
        paramByteBuffer.append(i);
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
      }
    }
    paramByteBuffer = new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No Channel block in APK Signing Block");
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier
 * JD-Core Version:    0.7.0.1
 */