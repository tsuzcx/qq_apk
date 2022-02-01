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
    long l1;
    int k;
    int m;
    int n;
    if (localByteBuffer1.hasRemaining())
    {
      i += 1;
      if (localByteBuffer1.remaining() < 8) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      l1 = localByteBuffer1.getLong();
      if ((l1 < 4L) || (l1 > 2147483647L)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + l1);
      }
      k = (int)l1;
      m = localByteBuffer1.position() + k;
      if (k > localByteBuffer1.remaining()) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + k + ", available: " + localByteBuffer1.remaining());
      }
      n = localByteBuffer1.getInt();
      if (n == paramInt)
      {
        l1 = paramArrayOfByte.length + 4 - k;
        localByteBuffer2.putLong(paramArrayOfByte.length + 4);
        localByteBuffer2.putInt(n);
        localByteBuffer2.put(paramArrayOfByte);
        localByteBuffer1.position(m);
        localByteBuffer2.put(localByteBuffer1.array(), localByteBuffer1.arrayOffset(), localByteBuffer1.remaining());
        localByteBuffer1.position(localByteBuffer1.limit());
      }
    }
    for (;;)
    {
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
      localByteBuffer2.putLong(l1);
      localByteBuffer2.putInt(n);
      localByteBuffer2.put(ApkSignatureSchemeV2Verifier.a(localByteBuffer1, k - 4));
      localByteBuffer1.position(m);
      break;
      l1 = 0L;
    }
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
    //   14: ldc 169
    //   16: iconst_1
    //   17: new 78	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   24: ldc 179
    //   26: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: invokevirtual 184	java/io/File:getName	()Ljava/lang/String;
    //   33: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: invokevirtual 187	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: invokestatic 190	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/lang/String;)Z
    //   49: ifeq +209 -> 258
    //   52: aload_0
    //   53: invokevirtual 187	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: ldc 191
    //   58: invokestatic 194	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/lang/String;I)[B
    //   61: astore_1
    //   62: aload_1
    //   63: ifnonnull +186 -> 249
    //   66: new 196	java/io/RandomAccessFile
    //   69: dup
    //   70: aload_0
    //   71: ldc 198
    //   73: invokespecial 201	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: aload_1
    //   80: astore_2
    //   81: aload_1
    //   82: invokestatic 204	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;)[B
    //   85: astore_3
    //   86: aload_3
    //   87: ifnonnull +45 -> 132
    //   90: aload_1
    //   91: astore_0
    //   92: aload_1
    //   93: astore_2
    //   94: ldc 169
    //   96: iconst_1
    //   97: ldc 206
    //   99: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload_1
    //   103: astore_0
    //   104: aload_1
    //   105: astore_2
    //   106: ldc 169
    //   108: iconst_1
    //   109: ldc 208
    //   111: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   122: ldc 169
    //   124: iconst_1
    //   125: ldc 213
    //   127: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aconst_null
    //   131: areturn
    //   132: aload_1
    //   133: astore_0
    //   134: aload_1
    //   135: astore_2
    //   136: new 215	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo
    //   139: dup
    //   140: aconst_null
    //   141: invokespecial 218	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:<init>	(Lcom/tencent/securitysdk/utils/ApkExternalInfoTool$1;)V
    //   144: astore 4
    //   146: aload_1
    //   147: astore_0
    //   148: aload_1
    //   149: astore_2
    //   150: aload 4
    //   152: aload_3
    //   153: invokevirtual 221	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	([B)V
    //   156: aload_1
    //   157: astore_0
    //   158: aload_1
    //   159: astore_2
    //   160: aload 4
    //   162: getfield 224	com/tencent/securitysdk/utils/ApkExternalInfoTool$ApkSecurityCommentInfo:a	Ljava/util/Properties;
    //   165: ldc 226
    //   167: invokevirtual 232	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_3
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   179: ldc 169
    //   181: iconst_1
    //   182: ldc 213
    //   184: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_3
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: astore_0
    //   194: aload_1
    //   195: invokevirtual 235	java/lang/Throwable:printStackTrace	()V
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   206: ldc 169
    //   208: iconst_1
    //   209: ldc 213
    //   211: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_0
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_0
    //   220: astore_1
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   229: ldc 169
    //   231: iconst_1
    //   232: ldc 213
    //   234: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: aload_0
    //   241: astore_2
    //   242: goto -21 -> 221
    //   245: astore_1
    //   246: goto -54 -> 192
    //   249: aconst_null
    //   250: astore_0
    //   251: aload_1
    //   252: astore_3
    //   253: aload_0
    //   254: astore_1
    //   255: goto -169 -> 86
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -198 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramFile	File
    //   61	115	1	localObject1	Object
    //   189	6	1	localThrowable1	Throwable
    //   220	18	1	localFile1	File
    //   239	1	1	localObject2	Object
    //   245	7	1	localThrowable2	Throwable
    //   254	6	1	localFile2	File
    //   80	162	2	localObject3	Object
    //   85	168	3	localObject4	Object
    //   144	17	4	localApkSecurityCommentInfo	ApkExternalInfoTool.ApkSecurityCommentInfo
    // Exception table:
    //   from	to	target	type
    //   42	62	189	java/lang/Throwable
    //   66	77	189	java/lang/Throwable
    //   42	62	216	finally
    //   66	77	216	finally
    //   81	86	239	finally
    //   94	102	239	finally
    //   106	114	239	finally
    //   136	146	239	finally
    //   150	156	239	finally
    //   160	171	239	finally
    //   194	198	239	finally
    //   81	86	245	java/lang/Throwable
    //   94	102	245	java/lang/Throwable
    //   106	114	245	java/lang/Throwable
    //   136	146	245	java/lang/Throwable
    //   150	156	245	java/lang/Throwable
    //   160	171	245	java/lang/Throwable
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
    //   1: astore 9
    //   3: new 196	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_0
    //   8: ldc_w 259
    //   11: invokespecial 262	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: astore 9
    //   18: aload_0
    //   19: invokestatic 265	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   22: astore 11
    //   24: aload_0
    //   25: astore 9
    //   27: aload 11
    //   29: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   32: checkcast 42	java/nio/ByteBuffer
    //   35: astore 10
    //   37: aload_0
    //   38: astore 9
    //   40: aload 11
    //   42: getfield 272	android/util/Pair:second	Ljava/lang/Object;
    //   45: checkcast 145	java/lang/Long
    //   48: invokevirtual 275	java/lang/Long:longValue	()J
    //   51: lstore 5
    //   53: aload_0
    //   54: astore 9
    //   56: aload_0
    //   57: lload 5
    //   59: invokestatic 280	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/io/RandomAccessFile;J)Z
    //   62: ifeq +31 -> 93
    //   65: aload_0
    //   66: astore 9
    //   68: new 76	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   71: dup
    //   72: ldc_w 282
    //   75: invokespecial 95	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: astore_2
    //   80: aload_2
    //   81: invokevirtual 283	java/io/FileNotFoundException:printStackTrace	()V
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   92: return
    //   93: aload_0
    //   94: astore 9
    //   96: aload 10
    //   98: lload 5
    //   100: invokestatic 286	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   103: lstore_3
    //   104: aload_0
    //   105: astore 9
    //   107: aload_0
    //   108: lload_3
    //   109: lload 5
    //   111: lload_3
    //   112: lsub
    //   113: l2i
    //   114: invokestatic 288	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;JI)Ljava/nio/ByteBuffer;
    //   117: astore 11
    //   119: aload_0
    //   120: astore 9
    //   122: aload_0
    //   123: lload_3
    //   124: invokestatic 291	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   127: astore 12
    //   129: aload_0
    //   130: astore 9
    //   132: aload 12
    //   134: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   137: checkcast 42	java/nio/ByteBuffer
    //   140: astore 13
    //   142: aload_0
    //   143: astore 9
    //   145: aload 12
    //   147: getfield 272	android/util/Pair:second	Ljava/lang/Object;
    //   150: checkcast 145	java/lang/Long
    //   153: invokevirtual 275	java/lang/Long:longValue	()J
    //   156: lstore 5
    //   158: aload_0
    //   159: astore 9
    //   161: aload 13
    //   163: iload_1
    //   164: aload_2
    //   165: invokestatic 293	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/nio/ByteBuffer;I[B)Landroid/util/Pair;
    //   168: astore_2
    //   169: aload_0
    //   170: astore 9
    //   172: aload_2
    //   173: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   176: checkcast 42	java/nio/ByteBuffer
    //   179: astore 12
    //   181: aload_0
    //   182: astore 9
    //   184: aload_2
    //   185: getfield 272	android/util/Pair:second	Ljava/lang/Object;
    //   188: checkcast 145	java/lang/Long
    //   191: invokevirtual 275	java/lang/Long:longValue	()J
    //   194: lstore 7
    //   196: aload_0
    //   197: astore 9
    //   199: aload 10
    //   201: lload_3
    //   202: lload 7
    //   204: ladd
    //   205: invokestatic 296	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/nio/ByteBuffer;J)V
    //   208: aload_0
    //   209: astore 9
    //   211: aload_0
    //   212: lload 5
    //   214: invokevirtual 244	java/io/RandomAccessFile:seek	(J)V
    //   217: aload_0
    //   218: astore 9
    //   220: aload_0
    //   221: aload 12
    //   223: invokevirtual 132	java/nio/ByteBuffer:array	()[B
    //   226: aload 12
    //   228: invokevirtual 135	java/nio/ByteBuffer:arrayOffset	()I
    //   231: aload 12
    //   233: invokevirtual 112	java/nio/ByteBuffer:position	()I
    //   236: iadd
    //   237: aload 12
    //   239: invokevirtual 74	java/nio/ByteBuffer:remaining	()I
    //   242: invokevirtual 299	java/io/RandomAccessFile:write	([BII)V
    //   245: aload_0
    //   246: astore 9
    //   248: aload_0
    //   249: aload 11
    //   251: invokevirtual 132	java/nio/ByteBuffer:array	()[B
    //   254: aload 11
    //   256: invokevirtual 135	java/nio/ByteBuffer:arrayOffset	()I
    //   259: aload 11
    //   261: invokevirtual 112	java/nio/ByteBuffer:position	()I
    //   264: iadd
    //   265: aload 11
    //   267: invokevirtual 74	java/nio/ByteBuffer:remaining	()I
    //   270: invokevirtual 299	java/io/RandomAccessFile:write	([BII)V
    //   273: aload_0
    //   274: astore 9
    //   276: aload_0
    //   277: aload 10
    //   279: invokevirtual 132	java/nio/ByteBuffer:array	()[B
    //   282: aload 10
    //   284: invokevirtual 135	java/nio/ByteBuffer:arrayOffset	()I
    //   287: aload 10
    //   289: invokevirtual 112	java/nio/ByteBuffer:position	()I
    //   292: iadd
    //   293: aload 10
    //   295: invokevirtual 74	java/nio/ByteBuffer:remaining	()I
    //   298: invokevirtual 299	java/io/RandomAccessFile:write	([BII)V
    //   301: lload 7
    //   303: lconst_0
    //   304: lcmp
    //   305: ifge +17 -> 322
    //   308: aload_0
    //   309: astore 9
    //   311: aload_0
    //   312: aload_0
    //   313: invokevirtual 302	java/io/RandomAccessFile:length	()J
    //   316: lload 7
    //   318: ladd
    //   319: invokevirtual 305	java/io/RandomAccessFile:setLength	(J)V
    //   322: aload_0
    //   323: ifnull -231 -> 92
    //   326: aload_0
    //   327: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   330: return
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_0
    //   334: aload_0
    //   335: astore 9
    //   337: aload_2
    //   338: invokevirtual 306	java/lang/IllegalArgumentException:printStackTrace	()V
    //   341: aload_0
    //   342: ifnull -250 -> 92
    //   345: aload_0
    //   346: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   349: return
    //   350: astore_0
    //   351: aconst_null
    //   352: astore 9
    //   354: aload 9
    //   356: ifnull +8 -> 364
    //   359: aload 9
    //   361: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   364: aload_0
    //   365: athrow
    //   366: astore_0
    //   367: goto -13 -> 354
    //   370: astore_2
    //   371: aload_0
    //   372: astore 9
    //   374: aload_2
    //   375: astore_0
    //   376: goto -22 -> 354
    //   379: astore_2
    //   380: goto -46 -> 334
    //   383: astore_2
    //   384: aload 9
    //   386: astore_0
    //   387: goto -307 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramString	String
    //   0	390	1	paramInt	int
    //   0	390	2	paramArrayOfByte	byte[]
    //   103	99	3	l1	long
    //   51	162	5	l2	long
    //   194	123	7	l3	long
    //   1	384	9	str	String
    //   35	259	10	localByteBuffer1	ByteBuffer
    //   22	244	11	localObject1	Object
    //   127	111	12	localObject2	Object
    //   140	22	13	localByteBuffer2	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   18	24	79	java/io/FileNotFoundException
    //   27	37	79	java/io/FileNotFoundException
    //   40	53	79	java/io/FileNotFoundException
    //   56	65	79	java/io/FileNotFoundException
    //   68	79	79	java/io/FileNotFoundException
    //   96	104	79	java/io/FileNotFoundException
    //   107	119	79	java/io/FileNotFoundException
    //   122	129	79	java/io/FileNotFoundException
    //   132	142	79	java/io/FileNotFoundException
    //   145	158	79	java/io/FileNotFoundException
    //   161	169	79	java/io/FileNotFoundException
    //   172	181	79	java/io/FileNotFoundException
    //   184	196	79	java/io/FileNotFoundException
    //   199	208	79	java/io/FileNotFoundException
    //   211	217	79	java/io/FileNotFoundException
    //   220	245	79	java/io/FileNotFoundException
    //   248	273	79	java/io/FileNotFoundException
    //   276	301	79	java/io/FileNotFoundException
    //   311	322	79	java/io/FileNotFoundException
    //   3	15	331	java/lang/IllegalArgumentException
    //   3	15	350	finally
    //   18	24	366	finally
    //   27	37	366	finally
    //   40	53	366	finally
    //   56	65	366	finally
    //   68	79	366	finally
    //   96	104	366	finally
    //   107	119	366	finally
    //   122	129	366	finally
    //   132	142	366	finally
    //   145	158	366	finally
    //   161	169	366	finally
    //   172	181	366	finally
    //   184	196	366	finally
    //   199	208	366	finally
    //   211	217	366	finally
    //   220	245	366	finally
    //   248	273	366	finally
    //   276	301	366	finally
    //   311	322	366	finally
    //   337	341	366	finally
    //   80	84	370	finally
    //   18	24	379	java/lang/IllegalArgumentException
    //   27	37	379	java/lang/IllegalArgumentException
    //   40	53	379	java/lang/IllegalArgumentException
    //   56	65	379	java/lang/IllegalArgumentException
    //   68	79	379	java/lang/IllegalArgumentException
    //   96	104	379	java/lang/IllegalArgumentException
    //   107	119	379	java/lang/IllegalArgumentException
    //   122	129	379	java/lang/IllegalArgumentException
    //   132	142	379	java/lang/IllegalArgumentException
    //   145	158	379	java/lang/IllegalArgumentException
    //   161	169	379	java/lang/IllegalArgumentException
    //   172	181	379	java/lang/IllegalArgumentException
    //   184	196	379	java/lang/IllegalArgumentException
    //   199	208	379	java/lang/IllegalArgumentException
    //   211	217	379	java/lang/IllegalArgumentException
    //   220	245	379	java/lang/IllegalArgumentException
    //   248	273	379	java/lang/IllegalArgumentException
    //   276	301	379	java/lang/IllegalArgumentException
    //   311	322	379	java/lang/IllegalArgumentException
    //   3	15	383	java/io/FileNotFoundException
  }
  
  public static byte[] a(RandomAccessFile paramRandomAccessFile)
  {
    int k = 0;
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = c.a();
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      int j = k;
      if (i != -1)
      {
        if ((i == arrayOfByte[0]) && (paramRandomAccessFile.read() == arrayOfByte[1]) && (paramRandomAccessFile.read() == arrayOfByte[2]) && (paramRandomAccessFile.read() == arrayOfByte[3])) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.e("ApkExternalInfoTool", 1, "archive is not a ZIP archive");
        throw new ZipException("archive is not a ZIP archive");
      }
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
    paramRandomAccessFile.seek(l + 16L + 4L);
    if (jdField_a_of_type_Int != l + 16L + 4L) {
      jdField_a_of_type_Int = (int)(l + 16L + 4L);
    }
    arrayOfByte = new byte[2];
    paramRandomAccessFile.readFully(arrayOfByte);
    QLog.d("ApkExternalInfoTool", 1, "readComment:length bytes data = " + a(arrayOfByte));
    i = new ZipShort(arrayOfByte).a();
    if (i == 0) {
      return null;
    }
    arrayOfByte = new byte[i];
    paramRandomAccessFile.read(arrayOfByte);
    return arrayOfByte;
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
    //   14: invokestatic 265	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   17: astore_0
    //   18: aload_0
    //   19: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   22: checkcast 42	java/nio/ByteBuffer
    //   25: astore 5
    //   27: aload_0
    //   28: getfield 272	android/util/Pair:second	Ljava/lang/Object;
    //   31: checkcast 145	java/lang/Long
    //   34: invokevirtual 275	java/lang/Long:longValue	()J
    //   37: lstore_2
    //   38: aload 4
    //   40: lload_2
    //   41: invokestatic 280	com/tencent/securitysdk/utils/ZipUtils:a	(Ljava/io/RandomAccessFile;J)Z
    //   44: ifeq +40 -> 84
    //   47: new 76	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   50: dup
    //   51: ldc_w 282
    //   54: invokespecial 95	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   57: athrow
    //   58: astore 5
    //   60: aload 4
    //   62: astore_0
    //   63: aload 5
    //   65: astore 4
    //   67: aload 4
    //   69: invokevirtual 235	java/lang/Throwable:printStackTrace	()V
    //   72: aload_0
    //   73: ifnull +7 -> 80
    //   76: aload_0
    //   77: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: areturn
    //   84: aload 4
    //   86: aload 5
    //   88: lload_2
    //   89: invokestatic 286	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   92: invokestatic 291	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   95: getfield 269	android/util/Pair:first	Ljava/lang/Object;
    //   98: checkcast 42	java/nio/ByteBuffer
    //   101: iload_1
    //   102: invokestatic 343	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:b	(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 74	java/nio/ByteBuffer:remaining	()I
    //   110: newarray byte
    //   112: astore 5
    //   114: aload_0
    //   115: aload 5
    //   117: iconst_0
    //   118: aload 5
    //   120: arraylength
    //   121: invokevirtual 346	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   124: pop
    //   125: aload 5
    //   127: astore_0
    //   128: aload 4
    //   130: ifnull -48 -> 82
    //   133: aload 4
    //   135: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   138: aload 5
    //   140: areturn
    //   141: astore_0
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 4
    //   147: ifnull +8 -> 155
    //   150: aload 4
    //   152: invokevirtual 211	java/io/RandomAccessFile:close	()V
    //   155: aload_0
    //   156: athrow
    //   157: astore_0
    //   158: goto -13 -> 145
    //   161: astore 5
    //   163: aload_0
    //   164: astore 4
    //   166: aload 5
    //   168: astore_0
    //   169: goto -24 -> 145
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_0
    //   176: goto -109 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramString	String
    //   0	179	1	paramInt	int
    //   37	52	2	l	long
    //   10	155	4	localObject1	Object
    //   172	1	4	localThrowable1	Throwable
    //   25	1	5	localByteBuffer	ByteBuffer
    //   58	29	5	localThrowable2	Throwable
    //   112	27	5	arrayOfByte	byte[]
    //   161	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	58	58	java/lang/Throwable
    //   84	125	58	java/lang/Throwable
    //   0	12	141	finally
    //   12	58	157	finally
    //   84	125	157	finally
    //   67	72	161	finally
    //   0	12	172	java/lang/Throwable
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      localObject = null;
    }
    byte[] arrayOfByte;
    do
    {
      do
      {
        return localObject;
        localObject = ByteBuffer.wrap(paramArrayOfByte);
        arrayOfByte = new byte[jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong.a().length];
        ((ByteBuffer)localObject).get(arrayOfByte);
        localObject = paramArrayOfByte;
      } while (jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong.equals(new ZipLong(arrayOfByte)));
      localObject = paramArrayOfByte;
    } while (b.equals(new ZipLong(arrayOfByte)));
    Object localObject = new ByteArrayOutputStream();
    ((ByteArrayOutputStream)localObject).write(b.a());
    ((ByteArrayOutputStream)localObject).write(new ZipShort(paramArrayOfByte.length).a());
    ((ByteArrayOutputStream)localObject).write(paramArrayOfByte);
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  private static void b(File paramFile, String paramString)
  {
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      ApkExternalInfoTool.ApkSecurityCommentInfo localApkSecurityCommentInfo;
      int i;
      if (paramString == null) {
        break label156;
      }
    }
    finally
    {
      try
      {
        paramFile = a(a(localRandomAccessFile));
        localApkSecurityCommentInfo = new ApkExternalInfoTool.ApkSecurityCommentInfo(null);
        localApkSecurityCommentInfo.a(paramFile);
        localApkSecurityCommentInfo.a.setProperty("apkSecurityCode", paramString);
        paramFile = localApkSecurityCommentInfo.a();
        localRandomAccessFile.seek(jdField_a_of_type_Int);
        localRandomAccessFile.write(new ZipShort(paramFile.length).a());
        localRandomAccessFile.write(paramFile);
        i = jdField_a_of_type_Int;
        localRandomAccessFile.setLength(paramFile.length + i + 2);
        QLog.d("ApkExternalInfoTool", 1, "file length is = " + localRandomAccessFile.length());
        if (localRandomAccessFile != null) {
          localRandomAccessFile.close();
        }
        QLog.i("ApkExternalInfoTool", 1, "exit writeSecurityCode");
        return;
      }
      finally
      {
        RandomAccessFile localRandomAccessFile;
        paramString = localRandomAccessFile;
      }
      paramFile = finally;
      paramString = null;
    }
    paramString.close();
    label156:
    QLog.i("ApkExternalInfoTool", 1, "exit writeSecurityCode");
    throw paramFile;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkExternalInfoTool
 * JD-Core Version:    0.7.0.1
 */