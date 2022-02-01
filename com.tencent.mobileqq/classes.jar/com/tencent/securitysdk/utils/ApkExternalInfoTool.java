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
  private static int jdField_a_of_type_Int = 0;
  private static final ZipLong jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong = new ZipLong(84298576L);
  private static final ZipLong b = new ZipLong(50613072L);
  private static final ZipLong c = new ZipLong(101010256L);
  
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
    //   0: ldc 169
    //   2: iconst_1
    //   3: ldc 171
    //   5: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 119	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc 179
    //   25: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: aload_0
    //   31: invokevirtual 184	java/io/File:getName	()Ljava/lang/String;
    //   34: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 169
    //   40: iconst_1
    //   41: aload_1
    //   42: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: invokevirtual 187	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   52: invokestatic 190	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/lang/String;)Z
    //   55: ifeq +202 -> 257
    //   58: aload_0
    //   59: invokevirtual 187	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   62: ldc 191
    //   64: invokestatic 194	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/lang/String;I)[B
    //   67: astore_1
    //   68: goto +3 -> 71
    //   71: aload_1
    //   72: ifnonnull +190 -> 262
    //   75: new 196	java/io/RandomAccessFile
    //   78: dup
    //   79: aload_0
    //   80: ldc 198
    //   82: invokespecial 201	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: astore_2
    //   88: aload_1
    //   89: astore_0
    //   90: aload_1
    //   91: invokestatic 204	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;)[B
    //   94: astore_3
    //   95: goto +3 -> 98
    //   98: aload_3
    //   99: ifnonnull +45 -> 144
    //   102: aload_1
    //   103: astore_2
    //   104: aload_1
    //   105: astore_0
    //   106: ldc 169
    //   108: iconst_1
    //   109: ldc 206
    //   111: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_1
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 169
    //   120: iconst_1
    //   121: ldc 208
    //   123: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   134: ldc 169
    //   136: iconst_1
    //   137: ldc 213
    //   139: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aconst_null
    //   143: areturn
    //   144: aload_1
    //   145: astore_2
    //   146: aload_1
    //   147: astore_0
    //   148: new 215	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo
    //   151: dup
    //   152: aconst_null
    //   153: invokespecial 218	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:<init>	(Lcom/tencent/securitysdk/utils/ApkExternalInfoTool$1;)V
    //   156: astore 4
    //   158: aload_1
    //   159: astore_2
    //   160: aload_1
    //   161: astore_0
    //   162: aload 4
    //   164: aload_3
    //   165: invokevirtual 221	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	([B)V
    //   168: aload_1
    //   169: astore_2
    //   170: aload_1
    //   171: astore_0
    //   172: aload 4
    //   174: getfield 224	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	Ljava/util/Properties;
    //   177: ldc 226
    //   179: invokevirtual 232	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore_3
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   191: ldc 169
    //   193: iconst_1
    //   194: ldc 213
    //   196: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   217: invokevirtual 235	java/lang/Throwable:printStackTrace	()V
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   228: ldc 169
    //   230: iconst_1
    //   231: ldc 213
    //   233: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aconst_null
    //   237: areturn
    //   238: astore_1
    //   239: aload_0
    //   240: ifnull +7 -> 247
    //   243: aload_0
    //   244: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   247: ldc 169
    //   249: iconst_1
    //   250: ldc 213
    //   252: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  private static String a(byte[] paramArrayOfByte)
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
    //   9: new 196	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc_w 259
    //   17: invokespecial 262	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokestatic 265	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   25: astore 10
    //   27: aload 10
    //   29: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   32: checkcast 42	java/nio/ByteBuffer
    //   35: astore 9
    //   37: aload 10
    //   39: getfield 272	android/util/Pair:second	Ljava/lang/Object;
    //   42: checkcast 151	java/lang/Long
    //   45: invokevirtual 275	java/lang/Long:longValue	()J
    //   48: lstore 5
    //   50: aload_0
    //   51: lload 5
    //   53: invokestatic 280	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/io/RandomAccessFile;J)Z
    //   56: ifne +195 -> 251
    //   59: aload 9
    //   61: lload 5
    //   63: invokestatic 283	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   66: lstore_3
    //   67: aload_0
    //   68: lload_3
    //   69: lload 5
    //   71: lload_3
    //   72: lsub
    //   73: l2i
    //   74: invokestatic 285	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;JI)Ljava/nio/ByteBuffer;
    //   77: astore 10
    //   79: aload_0
    //   80: lload_3
    //   81: invokestatic 288	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   84: astore 11
    //   86: aload 11
    //   88: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   91: checkcast 42	java/nio/ByteBuffer
    //   94: astore 12
    //   96: aload 11
    //   98: getfield 272	android/util/Pair:second	Ljava/lang/Object;
    //   101: checkcast 151	java/lang/Long
    //   104: invokevirtual 275	java/lang/Long:longValue	()J
    //   107: lstore 5
    //   109: aload 12
    //   111: iload_1
    //   112: aload_2
    //   113: invokestatic 290	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/nio/ByteBuffer;I[B)Landroid/util/Pair;
    //   116: astore_2
    //   117: aload_2
    //   118: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   121: checkcast 42	java/nio/ByteBuffer
    //   124: astore 11
    //   126: aload_2
    //   127: getfield 272	android/util/Pair:second	Ljava/lang/Object;
    //   130: checkcast 151	java/lang/Long
    //   133: invokevirtual 275	java/lang/Long:longValue	()J
    //   136: lstore 7
    //   138: aload 9
    //   140: lload_3
    //   141: lload 7
    //   143: ladd
    //   144: invokestatic 293	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/nio/ByteBuffer;J)V
    //   147: aload_0
    //   148: lload 5
    //   150: invokevirtual 244	java/io/RandomAccessFile:seek	(J)V
    //   153: aload_0
    //   154: aload 11
    //   156: invokevirtual 102	java/nio/ByteBuffer:array	()[B
    //   159: aload 11
    //   161: invokevirtual 105	java/nio/ByteBuffer:arrayOffset	()I
    //   164: aload 11
    //   166: invokevirtual 84	java/nio/ByteBuffer:position	()I
    //   169: iadd
    //   170: aload 11
    //   172: invokevirtual 74	java/nio/ByteBuffer:remaining	()I
    //   175: invokevirtual 296	java/io/RandomAccessFile:write	([BII)V
    //   178: aload_0
    //   179: aload 10
    //   181: invokevirtual 102	java/nio/ByteBuffer:array	()[B
    //   184: aload 10
    //   186: invokevirtual 105	java/nio/ByteBuffer:arrayOffset	()I
    //   189: aload 10
    //   191: invokevirtual 84	java/nio/ByteBuffer:position	()I
    //   194: iadd
    //   195: aload 10
    //   197: invokevirtual 74	java/nio/ByteBuffer:remaining	()I
    //   200: invokevirtual 296	java/io/RandomAccessFile:write	([BII)V
    //   203: aload_0
    //   204: aload 9
    //   206: invokevirtual 102	java/nio/ByteBuffer:array	()[B
    //   209: aload 9
    //   211: invokevirtual 105	java/nio/ByteBuffer:arrayOffset	()I
    //   214: aload 9
    //   216: invokevirtual 84	java/nio/ByteBuffer:position	()I
    //   219: iadd
    //   220: aload 9
    //   222: invokevirtual 74	java/nio/ByteBuffer:remaining	()I
    //   225: invokevirtual 296	java/io/RandomAccessFile:write	([BII)V
    //   228: lload 7
    //   230: lconst_0
    //   231: lcmp
    //   232: ifge +14 -> 246
    //   235: aload_0
    //   236: aload_0
    //   237: invokevirtual 299	java/io/RandomAccessFile:length	()J
    //   240: lload 7
    //   242: ladd
    //   243: invokevirtual 302	java/io/RandomAccessFile:setLength	(J)V
    //   246: aload_0
    //   247: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   250: return
    //   251: new 135	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   254: dup
    //   255: ldc_w 304
    //   258: invokespecial 142	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   261: athrow
    //   262: astore_2
    //   263: goto +52 -> 315
    //   266: astore_2
    //   267: goto +18 -> 285
    //   270: astore_2
    //   271: goto +28 -> 299
    //   274: astore_2
    //   275: aload 9
    //   277: astore_0
    //   278: goto +37 -> 315
    //   281: astore_2
    //   282: aload 10
    //   284: astore_0
    //   285: aload_0
    //   286: astore 9
    //   288: aload_2
    //   289: invokevirtual 305	java/lang/IllegalArgumentException:printStackTrace	()V
    //   292: aload_0
    //   293: ifnull +21 -> 314
    //   296: goto +14 -> 310
    //   299: aload_0
    //   300: astore 9
    //   302: aload_2
    //   303: invokevirtual 306	java/io/FileNotFoundException:printStackTrace	()V
    //   306: aload_0
    //   307: ifnull +7 -> 314
    //   310: aload_0
    //   311: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   314: return
    //   315: aload_0
    //   316: ifnull +7 -> 323
    //   319: aload_0
    //   320: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   323: aload_2
    //   324: athrow
    //   325: astore_2
    //   326: aload 11
    //   328: astore_0
    //   329: goto -30 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramString	String
    //   0	332	1	paramInt	int
    //   0	332	2	paramArrayOfByte	byte[]
    //   66	75	3	l1	long
    //   48	101	5	l2	long
    //   136	105	7	l3	long
    //   7	294	9	localObject1	Object
    //   1	282	10	localObject2	Object
    //   4	323	11	localObject3	Object
    //   94	16	12	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   21	228	262	finally
    //   235	246	262	finally
    //   251	262	262	finally
    //   21	228	266	java/lang/IllegalArgumentException
    //   235	246	266	java/lang/IllegalArgumentException
    //   251	262	266	java/lang/IllegalArgumentException
    //   21	228	270	java/io/FileNotFoundException
    //   235	246	270	java/io/FileNotFoundException
    //   251	262	270	java/io/FileNotFoundException
    //   9	21	274	finally
    //   288	292	274	finally
    //   302	306	274	finally
    //   9	21	281	java/lang/IllegalArgumentException
    //   9	21	325	java/io/FileNotFoundException
  }
  
  public static byte[] a(RandomAccessFile paramRandomAccessFile)
  {
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = c.a();
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
      if (jdField_a_of_type_Int != l) {
        jdField_a_of_type_Int = (int)l;
      }
      arrayOfByte = new byte[2];
      paramRandomAccessFile.readFully(arrayOfByte);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readComment:length bytes data = ");
      localStringBuilder.append(a(arrayOfByte));
      QLog.d("ApkExternalInfoTool", 1, localStringBuilder.toString());
      i = new ZipShort(arrayOfByte).a();
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
    //   0: new 196	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 198
    //   7: invokespecial 262	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: astore_0
    //   15: aload 4
    //   17: invokestatic 265	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   20: astore 5
    //   22: aload 4
    //   24: astore_0
    //   25: aload 5
    //   27: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   30: checkcast 42	java/nio/ByteBuffer
    //   33: astore 6
    //   35: aload 4
    //   37: astore_0
    //   38: aload 5
    //   40: getfield 272	android/util/Pair:second	Ljava/lang/Object;
    //   43: checkcast 151	java/lang/Long
    //   46: invokevirtual 275	java/lang/Long:longValue	()J
    //   49: lstore_2
    //   50: aload 4
    //   52: astore_0
    //   53: aload 4
    //   55: lload_2
    //   56: invokestatic 280	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/io/RandomAccessFile;J)Z
    //   59: ifne +64 -> 123
    //   62: aload 4
    //   64: astore_0
    //   65: aload 4
    //   67: aload 6
    //   69: lload_2
    //   70: invokestatic 283	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   73: invokestatic 288	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   76: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   79: checkcast 42	java/nio/ByteBuffer
    //   82: iload_1
    //   83: invokestatic 343	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:b	(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    //   86: astore 5
    //   88: aload 4
    //   90: astore_0
    //   91: aload 5
    //   93: invokevirtual 74	java/nio/ByteBuffer:remaining	()I
    //   96: newarray byte
    //   98: astore 6
    //   100: aload 4
    //   102: astore_0
    //   103: aload 5
    //   105: aload 6
    //   107: iconst_0
    //   108: aload 6
    //   110: arraylength
    //   111: invokevirtual 346	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   120: aload 6
    //   122: areturn
    //   123: aload 4
    //   125: astore_0
    //   126: new 135	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   129: dup
    //   130: ldc_w 304
    //   133: invokespecial 142	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
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
    //   159: invokevirtual 235	java/lang/Throwable:printStackTrace	()V
    //   162: aload 4
    //   164: ifnull +8 -> 172
    //   167: aload 4
    //   169: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   172: aconst_null
    //   173: areturn
    //   174: astore 4
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 211	java/io/RandomAccessFile:close	()V
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
    byte[] arrayOfByte = new byte[jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong.a().length];
    ((ByteBuffer)localObject).get(arrayOfByte);
    if (jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong.equals(new ZipLong(arrayOfByte))) {
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
  
  /* Error */
  private static void b(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 196	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 259
    //   8: invokespecial 201	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic 204	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;)[B
    //   16: invokestatic 371	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	([B)[B
    //   19: astore_2
    //   20: new 215	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo
    //   23: dup
    //   24: aconst_null
    //   25: invokespecial 218	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:<init>	(Lcom/tencent/securitysdk/utils/ApkExternalInfoTool$1;)V
    //   28: astore_3
    //   29: aload_3
    //   30: aload_2
    //   31: invokevirtual 221	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	([B)V
    //   34: aload_3
    //   35: getfield 224	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	Ljava/util/Properties;
    //   38: ldc 226
    //   40: aload_1
    //   41: invokevirtual 375	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 376	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	()[B
    //   49: astore_1
    //   50: aload_0
    //   51: getstatic 27	com/tencent/securitysdk/utils/ApkExternalInfoTool:jdField_a_of_type_Int	I
    //   54: i2l
    //   55: invokevirtual 244	java/io/RandomAccessFile:seek	(J)V
    //   58: aload_0
    //   59: new 326	com/tencent/securitysdk/utils/ZipShort
    //   62: dup
    //   63: aload_1
    //   64: arraylength
    //   65: invokespecial 365	com/tencent/securitysdk/utils/ZipShort:<init>	(I)V
    //   68: invokevirtual 366	com/tencent/securitysdk/utils/ZipShort:a	()[B
    //   71: invokevirtual 377	java/io/RandomAccessFile:write	([B)V
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 377	java/io/RandomAccessFile:write	([B)V
    //   79: aload_0
    //   80: getstatic 27	com/tencent/securitysdk/utils/ApkExternalInfoTool:jdField_a_of_type_Int	I
    //   83: aload_1
    //   84: arraylength
    //   85: iadd
    //   86: iconst_2
    //   87: iadd
    //   88: i2l
    //   89: invokevirtual 302	java/io/RandomAccessFile:setLength	(J)V
    //   92: new 119	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   99: astore_1
    //   100: aload_1
    //   101: ldc_w 379
    //   104: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_1
    //   109: aload_0
    //   110: invokevirtual 299	java/io/RandomAccessFile:length	()J
    //   113: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc 169
    //   119: iconst_1
    //   120: aload_1
    //   121: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 324	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   131: ldc 169
    //   133: iconst_1
    //   134: ldc_w 381
    //   137: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: return
    //   141: astore_1
    //   142: goto +6 -> 148
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: ifnull +7 -> 156
    //   152: aload_0
    //   153: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   156: ldc 169
    //   158: iconst_1
    //   159: ldc_w 381
    //   162: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramFile	File
    //   0	167	1	paramString	String
    //   19	12	2	arrayOfByte	byte[]
    //   28	18	3	localApkSecurityCommentInfo	ApkExternalInfoTool.ApkSecurityCommentInfo
    // Exception table:
    //   from	to	target	type
    //   12	127	141	finally
    //   0	12	145	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkExternalInfoTool
 * JD-Core Version:    0.7.0.1
 */