package com.tencent.securitysdk.utils;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Properties;
import java.util.zip.ZipException;

public final class ApkExternalInfoTool
{
  private static final ZipLong a = new ZipLong(84298576L);
  private static final ZipLong b = new ZipLong(50613072L);
  private static int c = 0;
  private static final ZipLong d = new ZipLong(101010256L);
  
  private static Pair<ByteBuffer, Long> a(ByteBuffer paramByteBuffer, int paramInt, byte[] paramArrayOfByte)
  {
    ApkSignatureSchemeV2Verifier.a(paramByteBuffer);
    ByteBuffer localByteBuffer1 = ApkSignatureSchemeV2Verifier.a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int j = paramArrayOfByte.length + 12;
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramByteBuffer.capacity() + j);
    localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer2.position(8);
    int i = 0;
    while (localByteBuffer1.hasRemaining())
    {
      i += 1;
      if (localByteBuffer1.remaining() >= 8)
      {
        l1 = localByteBuffer1.getLong();
        if ((l1 >= 4L) && (l1 <= 2147483647L))
        {
          int k = (int)l1;
          int m = localByteBuffer1.position() + k;
          if (k <= localByteBuffer1.remaining())
          {
            int n = localByteBuffer1.getInt();
            if (n == paramInt)
            {
              l1 = paramArrayOfByte.length + 4 - k;
              localByteBuffer2.putLong(paramArrayOfByte.length + 4);
              localByteBuffer2.putInt(n);
              localByteBuffer2.put(paramArrayOfByte);
              localByteBuffer1.position(m);
              localByteBuffer2.put(localByteBuffer1.array(), localByteBuffer1.arrayOffset(), localByteBuffer1.remaining());
              localByteBuffer1.position(localByteBuffer1.limit());
              break label410;
            }
            localByteBuffer2.putLong(l1);
            localByteBuffer2.putInt(n);
            localByteBuffer2.put(ApkSignatureSchemeV2Verifier.a(localByteBuffer1, k - 4));
            localByteBuffer1.position(m);
          }
          else
          {
            paramByteBuffer = new StringBuilder();
            paramByteBuffer.append("APK Signing Block entry #");
            paramByteBuffer.append(i);
            paramByteBuffer.append(" size out of range: ");
            paramByteBuffer.append(k);
            paramByteBuffer.append(", available: ");
            paramByteBuffer.append(localByteBuffer1.remaining());
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException(paramByteBuffer.toString());
          }
        }
        else
        {
          paramByteBuffer = new StringBuilder();
          paramByteBuffer.append("APK Signing Block entry #");
          paramByteBuffer.append(i);
          paramByteBuffer.append(" size out of range: ");
          paramByteBuffer.append(l1);
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
    long l1 = 0L;
    label410:
    long l2 = l1;
    if (l1 == 0L)
    {
      localByteBuffer2.putLong(paramArrayOfByte.length + 4);
      localByteBuffer2.putInt(paramInt);
      localByteBuffer2.put(paramArrayOfByte);
      l2 = j;
    }
    l1 = paramByteBuffer.getLong() + l2;
    localByteBuffer2.putLong(l1);
    localByteBuffer2.put(paramByteBuffer.array(), paramByteBuffer.array().length - 16, 16);
    localByteBuffer2.position(0);
    localByteBuffer2.putLong(l1);
    localByteBuffer2.position(0);
    localByteBuffer2.limit((int)l1 + 8);
    return Pair.create(localByteBuffer2, Long.valueOf(l2));
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: ldc 170
    //   2: iconst_1
    //   3: ldc 172
    //   5: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 120	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc 180
    //   25: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: aload_0
    //   31: invokevirtual 185	java/io/File:getName	()Ljava/lang/String;
    //   34: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 170
    //   40: iconst_1
    //   41: aload_1
    //   42: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: invokevirtual 188	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   52: invokestatic 191	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/lang/String;)Z
    //   55: ifeq +202 -> 257
    //   58: aload_0
    //   59: invokevirtual 188	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   62: ldc 192
    //   64: invokestatic 195	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/lang/String;I)[B
    //   67: astore_1
    //   68: goto +3 -> 71
    //   71: aload_1
    //   72: ifnonnull +190 -> 262
    //   75: new 197	java/io/RandomAccessFile
    //   78: dup
    //   79: aload_0
    //   80: ldc 199
    //   82: invokespecial 202	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: astore_2
    //   88: aload_1
    //   89: astore_0
    //   90: aload_1
    //   91: invokestatic 205	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;)[B
    //   94: astore_3
    //   95: goto +3 -> 98
    //   98: aload_3
    //   99: ifnonnull +45 -> 144
    //   102: aload_1
    //   103: astore_2
    //   104: aload_1
    //   105: astore_0
    //   106: ldc 170
    //   108: iconst_1
    //   109: ldc 207
    //   111: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_1
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 170
    //   120: iconst_1
    //   121: ldc 209
    //   123: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   134: ldc 170
    //   136: iconst_1
    //   137: ldc 214
    //   139: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aconst_null
    //   143: areturn
    //   144: aload_1
    //   145: astore_2
    //   146: aload_1
    //   147: astore_0
    //   148: new 216	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo
    //   151: dup
    //   152: aconst_null
    //   153: invokespecial 219	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:<init>	(Lcom/tencent/securitysdk/utils/ApkExternalInfoTool$1;)V
    //   156: astore 4
    //   158: aload_1
    //   159: astore_2
    //   160: aload_1
    //   161: astore_0
    //   162: aload 4
    //   164: aload_3
    //   165: invokevirtual 222	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	([B)V
    //   168: aload_1
    //   169: astore_2
    //   170: aload_1
    //   171: astore_0
    //   172: aload 4
    //   174: getfield 225	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	Ljava/util/Properties;
    //   177: ldc 227
    //   179: invokevirtual 233	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore_3
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   191: ldc 170
    //   193: iconst_1
    //   194: ldc 214
    //   196: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_3
    //   200: areturn
    //   201: astore_1
    //   202: goto +12 -> 214
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_0
    //   208: goto +31 -> 239
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_2
    //   214: aload_2
    //   215: astore_0
    //   216: aload_1
    //   217: invokevirtual 236	java/lang/Throwable:printStackTrace	()V
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   228: ldc 170
    //   230: iconst_1
    //   231: ldc 214
    //   233: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aconst_null
    //   237: areturn
    //   238: astore_1
    //   239: aload_0
    //   240: ifnull +7 -> 247
    //   243: aload_0
    //   244: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   247: ldc 170
    //   249: iconst_1
    //   250: ldc 214
    //   252: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_1
    //   256: athrow
    //   257: aconst_null
    //   258: astore_1
    //   259: goto -188 -> 71
    //   262: aload_1
    //   263: astore_3
    //   264: aconst_null
    //   265: astore_1
    //   266: goto -168 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramFile	File
    //   21	167	1	localObject1	Object
    //   201	1	1	localThrowable1	Throwable
    //   205	1	1	localObject2	Object
    //   211	6	1	localThrowable2	Throwable
    //   238	18	1	localObject3	Object
    //   258	8	1	localObject4	Object
    //   87	138	2	localObject5	Object
    //   94	170	3	localObject6	Object
    //   156	17	4	localApkSecurityCommentInfo	ApkExternalInfoTool.ApkSecurityCommentInfo
    // Exception table:
    //   from	to	target	type
    //   90	95	201	java/lang/Throwable
    //   106	114	201	java/lang/Throwable
    //   118	126	201	java/lang/Throwable
    //   148	158	201	java/lang/Throwable
    //   162	168	201	java/lang/Throwable
    //   172	183	201	java/lang/Throwable
    //   48	68	205	finally
    //   75	86	205	finally
    //   48	68	211	java/lang/Throwable
    //   75	86	211	java/lang/Throwable
    //   90	95	238	finally
    //   106	114	238	finally
    //   118	126	238	finally
    //   148	158	238	finally
    //   162	168	238	finally
    //   172	183	238	finally
    //   216	220	238	finally
  }
  
  private static ByteBuffer a(RandomAccessFile paramRandomAccessFile, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    return localByteBuffer;
  }
  
  public static void a(File paramFile, String paramString)
  {
    if (ApkSignatureSchemeV2Verifier.a(paramFile.getAbsolutePath()))
    {
      c(paramFile, paramString);
      return;
    }
    b(paramFile, paramString);
  }
  
  /* Error */
  private static void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: new 197	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 255
    //   16: invokespecial 258	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 261	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   24: astore 10
    //   26: aload 10
    //   28: getfield 265	android/util/Pair:first	Ljava/lang/Object;
    //   31: checkcast 43	java/nio/ByteBuffer
    //   34: astore 9
    //   36: aload 10
    //   38: getfield 268	android/util/Pair:second	Ljava/lang/Object;
    //   41: checkcast 152	java/lang/Long
    //   44: invokevirtual 271	java/lang/Long:longValue	()J
    //   47: lstore 5
    //   49: aload_0
    //   50: lload 5
    //   52: invokestatic 276	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/io/RandomAccessFile;J)Z
    //   55: ifne +195 -> 250
    //   58: aload 9
    //   60: lload 5
    //   62: invokestatic 279	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   65: lstore_3
    //   66: aload_0
    //   67: lload_3
    //   68: lload 5
    //   70: lload_3
    //   71: lsub
    //   72: l2i
    //   73: invokestatic 281	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;JI)Ljava/nio/ByteBuffer;
    //   76: astore 10
    //   78: aload_0
    //   79: lload_3
    //   80: invokestatic 284	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   83: astore 11
    //   85: aload 11
    //   87: getfield 265	android/util/Pair:first	Ljava/lang/Object;
    //   90: checkcast 43	java/nio/ByteBuffer
    //   93: astore 12
    //   95: aload 11
    //   97: getfield 268	android/util/Pair:second	Ljava/lang/Object;
    //   100: checkcast 152	java/lang/Long
    //   103: invokevirtual 271	java/lang/Long:longValue	()J
    //   106: lstore 5
    //   108: aload 12
    //   110: iload_1
    //   111: aload_2
    //   112: invokestatic 286	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/nio/ByteBuffer;I[B)Landroid/util/Pair;
    //   115: astore_2
    //   116: aload_2
    //   117: getfield 265	android/util/Pair:first	Ljava/lang/Object;
    //   120: checkcast 43	java/nio/ByteBuffer
    //   123: astore 11
    //   125: aload_2
    //   126: getfield 268	android/util/Pair:second	Ljava/lang/Object;
    //   129: checkcast 152	java/lang/Long
    //   132: invokevirtual 271	java/lang/Long:longValue	()J
    //   135: lstore 7
    //   137: aload 9
    //   139: lload_3
    //   140: lload 7
    //   142: ladd
    //   143: invokestatic 289	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/nio/ByteBuffer;J)V
    //   146: aload_0
    //   147: lload 5
    //   149: invokevirtual 240	java/io/RandomAccessFile:seek	(J)V
    //   152: aload_0
    //   153: aload 11
    //   155: invokevirtual 103	java/nio/ByteBuffer:array	()[B
    //   158: aload 11
    //   160: invokevirtual 106	java/nio/ByteBuffer:arrayOffset	()I
    //   163: aload 11
    //   165: invokevirtual 85	java/nio/ByteBuffer:position	()I
    //   168: iadd
    //   169: aload 11
    //   171: invokevirtual 75	java/nio/ByteBuffer:remaining	()I
    //   174: invokevirtual 292	java/io/RandomAccessFile:write	([BII)V
    //   177: aload_0
    //   178: aload 10
    //   180: invokevirtual 103	java/nio/ByteBuffer:array	()[B
    //   183: aload 10
    //   185: invokevirtual 106	java/nio/ByteBuffer:arrayOffset	()I
    //   188: aload 10
    //   190: invokevirtual 85	java/nio/ByteBuffer:position	()I
    //   193: iadd
    //   194: aload 10
    //   196: invokevirtual 75	java/nio/ByteBuffer:remaining	()I
    //   199: invokevirtual 292	java/io/RandomAccessFile:write	([BII)V
    //   202: aload_0
    //   203: aload 9
    //   205: invokevirtual 103	java/nio/ByteBuffer:array	()[B
    //   208: aload 9
    //   210: invokevirtual 106	java/nio/ByteBuffer:arrayOffset	()I
    //   213: aload 9
    //   215: invokevirtual 85	java/nio/ByteBuffer:position	()I
    //   218: iadd
    //   219: aload 9
    //   221: invokevirtual 75	java/nio/ByteBuffer:remaining	()I
    //   224: invokevirtual 292	java/io/RandomAccessFile:write	([BII)V
    //   227: lload 7
    //   229: lconst_0
    //   230: lcmp
    //   231: ifge +14 -> 245
    //   234: aload_0
    //   235: aload_0
    //   236: invokevirtual 295	java/io/RandomAccessFile:length	()J
    //   239: lload 7
    //   241: ladd
    //   242: invokevirtual 298	java/io/RandomAccessFile:setLength	(J)V
    //   245: aload_0
    //   246: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   249: return
    //   250: new 136	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   253: dup
    //   254: ldc_w 300
    //   257: invokespecial 143	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   260: athrow
    //   261: astore_2
    //   262: goto +52 -> 314
    //   265: astore_2
    //   266: goto +18 -> 284
    //   269: astore_2
    //   270: goto +28 -> 298
    //   273: astore_2
    //   274: aload 9
    //   276: astore_0
    //   277: goto +37 -> 314
    //   280: astore_2
    //   281: aload 10
    //   283: astore_0
    //   284: aload_0
    //   285: astore 9
    //   287: aload_2
    //   288: invokevirtual 301	java/lang/IllegalArgumentException:printStackTrace	()V
    //   291: aload_0
    //   292: ifnull +21 -> 313
    //   295: goto +14 -> 309
    //   298: aload_0
    //   299: astore 9
    //   301: aload_2
    //   302: invokevirtual 302	java/io/FileNotFoundException:printStackTrace	()V
    //   305: aload_0
    //   306: ifnull +7 -> 313
    //   309: aload_0
    //   310: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   313: return
    //   314: aload_0
    //   315: ifnull +7 -> 322
    //   318: aload_0
    //   319: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   322: aload_2
    //   323: athrow
    //   324: astore_2
    //   325: aload 11
    //   327: astore_0
    //   328: goto -30 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramString	String
    //   0	331	1	paramInt	int
    //   0	331	2	paramArrayOfByte	byte[]
    //   65	75	3	l1	long
    //   47	101	5	l2	long
    //   135	105	7	l3	long
    //   7	293	9	localObject1	Object
    //   1	281	10	localObject2	Object
    //   4	322	11	localObject3	Object
    //   93	16	12	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   20	227	261	finally
    //   234	245	261	finally
    //   250	261	261	finally
    //   20	227	265	java/lang/IllegalArgumentException
    //   234	245	265	java/lang/IllegalArgumentException
    //   250	261	265	java/lang/IllegalArgumentException
    //   20	227	269	java/io/FileNotFoundException
    //   234	245	269	java/io/FileNotFoundException
    //   250	261	269	java/io/FileNotFoundException
    //   9	20	273	finally
    //   287	291	273	finally
    //   301	305	273	finally
    //   9	20	280	java/lang/IllegalArgumentException
    //   9	20	324	java/io/FileNotFoundException
  }
  
  public static byte[] a(RandomAccessFile paramRandomAccessFile)
  {
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = d.a();
    int j;
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      j = 0;
      if (i == -1) {
        break;
      }
      if ((i == arrayOfByte[0]) && (paramRandomAccessFile.read() == arrayOfByte[1]) && (paramRandomAccessFile.read() == arrayOfByte[2]) && (paramRandomAccessFile.read() == arrayOfByte[3]))
      {
        j = 1;
        break;
      }
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
    if (j != 0)
    {
      l = l + 16L + 4L;
      paramRandomAccessFile.seek(l);
      if (c != l) {
        c = (int)l;
      }
      arrayOfByte = new byte[2];
      paramRandomAccessFile.readFully(arrayOfByte);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readComment:length bytes data = ");
      localStringBuilder.append(b(arrayOfByte));
      QLog.d("ApkExternalInfoTool", 1, localStringBuilder.toString());
      i = new ZipShort(arrayOfByte).b();
      if (i == 0) {
        return null;
      }
      arrayOfByte = new byte[i];
      paramRandomAccessFile.read(arrayOfByte);
      return arrayOfByte;
    }
    QLog.e("ApkExternalInfoTool", 1, "archive is not a ZIP archive");
    paramRandomAccessFile = new ZipException("archive is not a ZIP archive");
    for (;;)
    {
      throw paramRandomAccessFile;
    }
  }
  
  /* Error */
  private static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 197	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 199
    //   7: invokespecial 258	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: astore_0
    //   15: aload 4
    //   17: invokestatic 261	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   20: astore 5
    //   22: aload 4
    //   24: astore_0
    //   25: aload 5
    //   27: getfield 265	android/util/Pair:first	Ljava/lang/Object;
    //   30: checkcast 43	java/nio/ByteBuffer
    //   33: astore 6
    //   35: aload 4
    //   37: astore_0
    //   38: aload 5
    //   40: getfield 268	android/util/Pair:second	Ljava/lang/Object;
    //   43: checkcast 152	java/lang/Long
    //   46: invokevirtual 271	java/lang/Long:longValue	()J
    //   49: lstore_2
    //   50: aload 4
    //   52: astore_0
    //   53: aload 4
    //   55: lload_2
    //   56: invokestatic 276	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/io/RandomAccessFile;J)Z
    //   59: ifne +64 -> 123
    //   62: aload 4
    //   64: astore_0
    //   65: aload 4
    //   67: aload 6
    //   69: lload_2
    //   70: invokestatic 279	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   73: invokestatic 284	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   76: getfield 265	android/util/Pair:first	Ljava/lang/Object;
    //   79: checkcast 43	java/nio/ByteBuffer
    //   82: iload_1
    //   83: invokestatic 339	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:b	(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    //   86: astore 5
    //   88: aload 4
    //   90: astore_0
    //   91: aload 5
    //   93: invokevirtual 75	java/nio/ByteBuffer:remaining	()I
    //   96: newarray byte
    //   98: astore 6
    //   100: aload 4
    //   102: astore_0
    //   103: aload 5
    //   105: aload 6
    //   107: iconst_0
    //   108: aload 6
    //   110: arraylength
    //   111: invokevirtual 342	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   120: aload 6
    //   122: areturn
    //   123: aload 4
    //   125: astore_0
    //   126: new 136	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   129: dup
    //   130: ldc_w 300
    //   133: invokespecial 143	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   136: athrow
    //   137: astore 5
    //   139: goto +15 -> 154
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_0
    //   146: goto +30 -> 176
    //   149: astore 5
    //   151: aconst_null
    //   152: astore 4
    //   154: aload 4
    //   156: astore_0
    //   157: aload 5
    //   159: invokevirtual 236	java/lang/Throwable:printStackTrace	()V
    //   162: aload 4
    //   164: ifnull +8 -> 172
    //   167: aload 4
    //   169: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   172: aconst_null
    //   173: areturn
    //   174: astore 4
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   184: aload 4
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramString	String
    //   0	187	1	paramInt	int
    //   49	21	2	l	long
    //   10	114	4	localRandomAccessFile	RandomAccessFile
    //   142	1	4	localObject1	Object
    //   152	16	4	localObject2	Object
    //   174	11	4	localObject3	Object
    //   20	84	5	localObject4	Object
    //   137	1	5	localThrowable1	Throwable
    //   149	9	5	localThrowable2	Throwable
    //   33	88	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   15	22	137	java/lang/Throwable
    //   25	35	137	java/lang/Throwable
    //   38	50	137	java/lang/Throwable
    //   53	62	137	java/lang/Throwable
    //   65	88	137	java/lang/Throwable
    //   91	100	137	java/lang/Throwable
    //   103	115	137	java/lang/Throwable
    //   126	137	137	java/lang/Throwable
    //   0	12	142	finally
    //   0	12	149	java/lang/Throwable
    //   15	22	174	finally
    //   25	35	174	finally
    //   38	50	174	finally
    //   53	62	174	finally
    //   65	88	174	finally
    //   91	100	174	finally
    //   103	115	174	finally
    //   126	137	174	finally
    //   157	162	174	finally
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = ByteBuffer.wrap(paramArrayOfByte);
    byte[] arrayOfByte = new byte[a.a().length];
    ((ByteBuffer)localObject).get(arrayOfByte);
    if (a.equals(new ZipLong(arrayOfByte))) {
      return paramArrayOfByte;
    }
    if (b.equals(new ZipLong(arrayOfByte))) {
      return paramArrayOfByte;
    }
    localObject = new ByteArrayOutputStream();
    ((ByteArrayOutputStream)localObject).write(b.a());
    ((ByteArrayOutputStream)localObject).write(new ZipShort(paramArrayOfByte.length).a());
    ((ByteArrayOutputStream)localObject).write(paramArrayOfByte);
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(paramArrayOfByte[i]);
        localStringBuilder.append(",");
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "empty";
  }
  
  /* Error */
  private static void b(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 197	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 255
    //   7: invokespecial 202	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 205	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;)[B
    //   15: invokestatic 371	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	([B)[B
    //   18: astore_2
    //   19: new 216	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo
    //   22: dup
    //   23: aconst_null
    //   24: invokespecial 219	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:<init>	(Lcom/tencent/securitysdk/utils/ApkExternalInfoTool$1;)V
    //   27: astore_3
    //   28: aload_3
    //   29: aload_2
    //   30: invokevirtual 222	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	([B)V
    //   33: aload_3
    //   34: getfield 225	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	Ljava/util/Properties;
    //   37: ldc 227
    //   39: aload_1
    //   40: invokevirtual 375	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 376	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	()[B
    //   48: astore_1
    //   49: aload_0
    //   50: getstatic 28	com/tencent/securitysdk/utils/ApkExternalInfoTool:c	I
    //   53: i2l
    //   54: invokevirtual 240	java/io/RandomAccessFile:seek	(J)V
    //   57: aload_0
    //   58: new 322	com/tencent/securitysdk/utils/ZipShort
    //   61: dup
    //   62: aload_1
    //   63: arraylength
    //   64: invokespecial 361	com/tencent/securitysdk/utils/ZipShort:<init>	(I)V
    //   67: invokevirtual 362	com/tencent/securitysdk/utils/ZipShort:a	()[B
    //   70: invokevirtual 377	java/io/RandomAccessFile:write	([B)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 377	java/io/RandomAccessFile:write	([B)V
    //   78: aload_0
    //   79: getstatic 28	com/tencent/securitysdk/utils/ApkExternalInfoTool:c	I
    //   82: aload_1
    //   83: arraylength
    //   84: iadd
    //   85: iconst_2
    //   86: iadd
    //   87: i2l
    //   88: invokevirtual 298	java/io/RandomAccessFile:setLength	(J)V
    //   91: new 120	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   98: astore_1
    //   99: aload_1
    //   100: ldc_w 379
    //   103: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: aload_0
    //   109: invokevirtual 295	java/io/RandomAccessFile:length	()J
    //   112: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: ldc 170
    //   118: iconst_1
    //   119: aload_1
    //   120: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_0
    //   127: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   130: ldc 170
    //   132: iconst_1
    //   133: ldc_w 381
    //   136: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: return
    //   140: astore_1
    //   141: goto +6 -> 147
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   155: ldc 170
    //   157: iconst_1
    //   158: ldc_w 381
    //   161: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramFile	File
    //   0	166	1	paramString	String
    //   18	12	2	arrayOfByte	byte[]
    //   27	18	3	localApkSecurityCommentInfo	ApkExternalInfoTool.ApkSecurityCommentInfo
    // Exception table:
    //   from	to	target	type
    //   11	126	140	finally
    //   0	11	144	finally
  }
  
  private static void c(File paramFile, String paramString)
  {
    try
    {
      byte[] arrayOfByte = a(a(paramFile.getAbsolutePath(), 2036624993));
      ApkExternalInfoTool.ApkSecurityCommentInfo localApkSecurityCommentInfo = new ApkExternalInfoTool.ApkSecurityCommentInfo(null);
      localApkSecurityCommentInfo.a(arrayOfByte);
      localApkSecurityCommentInfo.a.setProperty("apkSecurityCode", paramString);
      paramString = localApkSecurityCommentInfo.a();
      a(paramFile.getAbsolutePath(), 2036624993, paramString);
      return;
    }
    catch (Throwable paramFile)
    {
      paramFile.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkExternalInfoTool
 * JD-Core Version:    0.7.0.1
 */