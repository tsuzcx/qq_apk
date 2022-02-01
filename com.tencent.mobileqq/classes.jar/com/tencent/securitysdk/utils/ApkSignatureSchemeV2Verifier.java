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
    if (l >= paramLong) {
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP Central Directory offset out of range: " + l + ". ZIP End of Central Directory offset: " + paramLong);
    }
    if (ZipUtils.b(paramByteBuffer) + l != paramLong) {
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
    }
    return l;
  }
  
  static Pair<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile)
  {
    paramRandomAccessFile = ZipUtils.a(paramRandomAccessFile);
    if (paramRandomAccessFile == null) {
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }
    return paramRandomAccessFile;
  }
  
  static Pair<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    if (paramLong < 32L) {
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + paramLong);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong - localByteBuffer.capacity());
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    if ((localByteBuffer.getLong(8) != 2334950737559900225L) || (localByteBuffer.getLong(16) != 3617552046287187010L)) {
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
    }
    long l1 = localByteBuffer.getLong(0);
    if ((l1 < localByteBuffer.capacity()) || (l1 > 2147483639L)) {
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block size out of range: " + l1);
    }
    int i = (int)(8L + l1);
    paramLong -= i;
    if (paramLong < 0L) {
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block offset out of range: " + paramLong);
    }
    localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    long l2 = localByteBuffer.getLong(0);
    if (l2 != l1) {
      throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + l2 + " vs " + l1);
    }
    return Pair.create(localByteBuffer, Long.valueOf(paramLong));
  }
  
  private static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    a(paramByteBuffer);
    paramByteBuffer = a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + l);
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining()) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
      }
      if (paramByteBuffer.getInt() == 1896449818) {
        return a(paramByteBuffer, j - 4);
      }
      paramByteBuffer.position(k + j);
    }
    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
  }
  
  static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("size: " + paramInt);
    }
    int i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    paramInt = j + paramInt;
    if ((paramInt < j) || (paramInt > i)) {
      throw new BufferUnderflowException();
    }
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
  
  static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("start: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("end < start: " + paramInt2 + " < " + paramInt1);
    }
    int i = paramByteBuffer.capacity();
    if (paramInt2 > paramByteBuffer.capacity()) {
      throw new IllegalArgumentException("end > capacity: " + paramInt2 + " > " + i);
    }
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
  
  static void a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
      throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
  }
  
  /* Error */
  public static boolean a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 78	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_0
    //   8: ldc 212
    //   10: invokespecial 215	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: astore 4
    //   17: aload_0
    //   18: invokestatic 216	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   21: astore 5
    //   23: aload_0
    //   24: astore 4
    //   26: aload 5
    //   28: getfield 220	android/util/Pair:first	Ljava/lang/Object;
    //   31: checkcast 58	java/nio/ByteBuffer
    //   34: astore 6
    //   36: aload_0
    //   37: astore 4
    //   39: aload 5
    //   41: getfield 223	android/util/Pair:second	Ljava/lang/Object;
    //   44: checkcast 117	java/lang/Long
    //   47: invokevirtual 226	java/lang/Long:longValue	()J
    //   50: lstore_1
    //   51: aload_0
    //   52: astore 4
    //   54: aload_0
    //   55: lload_1
    //   56: invokestatic 229	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/io/RandomAccessFile;J)Z
    //   59: ifeq +30 -> 89
    //   62: aload_0
    //   63: astore 4
    //   65: new 18	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   68: dup
    //   69: ldc 231
    //   71: invokespecial 39	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore 4
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 234	java/io/RandomAccessFile:close	()V
    //   85: iconst_0
    //   86: istore_3
    //   87: iload_3
    //   88: ireturn
    //   89: aload_0
    //   90: astore 4
    //   92: aload_0
    //   93: aload 6
    //   95: lload_1
    //   96: invokestatic 236	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   99: invokestatic 238	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   102: getfield 220	android/util/Pair:first	Ljava/lang/Object;
    //   105: checkcast 58	java/nio/ByteBuffer
    //   108: invokestatic 240	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   111: pop
    //   112: iconst_1
    //   113: istore_3
    //   114: aload_0
    //   115: ifnull -28 -> 87
    //   118: aload_0
    //   119: invokevirtual 234	java/io/RandomAccessFile:close	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore 5
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: astore 4
    //   131: aload 5
    //   133: invokevirtual 243	java/lang/Throwable:printStackTrace	()V
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 234	java/io/RandomAccessFile:close	()V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: aconst_null
    //   148: astore 4
    //   150: aload 4
    //   152: ifnull +8 -> 160
    //   155: aload 4
    //   157: invokevirtual 234	java/io/RandomAccessFile:close	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -13 -> 150
    //   166: astore 5
    //   168: goto -40 -> 128
    //   171: astore_0
    //   172: aload 4
    //   174: astore_0
    //   175: goto -98 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramString	java.lang.String
    //   50	46	1	l	long
    //   86	28	3	bool	boolean
    //   1	63	4	str1	java.lang.String
    //   75	1	4	localSignatureNotFoundException	ApkSignatureSchemeV2Verifier.SignatureNotFoundException
    //   90	83	4	str2	java.lang.String
    //   21	19	5	localPair	Pair
    //   124	8	5	localThrowable1	java.lang.Throwable
    //   166	1	5	localThrowable2	java.lang.Throwable
    //   34	60	6	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   17	23	75	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   26	36	75	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   39	51	75	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   54	62	75	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   65	75	75	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   92	112	75	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   3	14	124	java/lang/Throwable
    //   3	14	146	finally
    //   17	23	162	finally
    //   26	36	162	finally
    //   39	51	162	finally
    //   54	62	162	finally
    //   65	75	162	finally
    //   92	112	162	finally
    //   131	136	162	finally
    //   17	23	166	java/lang/Throwable
    //   26	36	166	java/lang/Throwable
    //   39	51	166	java/lang/Throwable
    //   54	62	166	java/lang/Throwable
    //   65	75	166	java/lang/Throwable
    //   92	112	166	java/lang/Throwable
    //   3	14	171	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
  }
  
  static ByteBuffer b(ByteBuffer paramByteBuffer, int paramInt)
  {
    a(paramByteBuffer);
    paramByteBuffer = a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + l);
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining()) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
      }
      if (paramByteBuffer.getInt() == paramInt) {
        return a(paramByteBuffer, j - 4);
      }
      paramByteBuffer.position(k + j);
    }
    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No Channel block in APK Signing Block");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier
 * JD-Core Version:    0.7.0.1
 */