package com.tencent.mobileqq.profile.upload;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import java.io.File;
import mqq.manager.TicketManager;

public class VipUploadUtils
{
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append(paramAppInterface.getCurrentAccountUin());
    paramString.append(System.currentTimeMillis());
    return paramString.toString();
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: ldc 45
    //   2: invokestatic 51	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 54	java/security/MessageDigest:reset	()V
    //   10: new 56	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_1
    //   19: aload_2
    //   20: aload_1
    //   21: invokevirtual 63	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   24: getstatic 69	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   27: lconst_0
    //   28: aload_0
    //   29: invokevirtual 74	java/io/File:length	()J
    //   32: invokevirtual 80	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   35: invokevirtual 84	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   38: aload_2
    //   39: invokevirtual 88	java/security/MessageDigest:digest	()[B
    //   42: invokestatic 94	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 97	java/io/FileInputStream:close	()V
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: goto +6 -> 59
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +7 -> 67
    //   63: aload_1
    //   64: invokevirtual 97	java/io/FileInputStream:close	()V
    //   67: aload_0
    //   68: athrow
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +28 -> 100
    //   75: aload_1
    //   76: invokevirtual 97	java/io/FileInputStream:close	()V
    //   79: goto +21 -> 100
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +15 -> 100
    //   88: goto -13 -> 75
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +6 -> 100
    //   97: goto -22 -> 75
    //   100: ldc 99
    //   102: areturn
    //   103: astore_0
    //   104: goto -13 -> 91
    //   107: astore_0
    //   108: goto -26 -> 82
    //   111: astore_0
    //   112: goto -43 -> 69
    //   115: astore_0
    //   116: goto -23 -> 93
    //   119: astore_0
    //   120: goto -36 -> 84
    //   123: astore_0
    //   124: goto -53 -> 71
    //   127: astore_1
    //   128: aload_0
    //   129: areturn
    //   130: astore_1
    //   131: goto -64 -> 67
    //   134: astore_0
    //   135: goto -35 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramFile	File
    //   18	76	1	localFileInputStream	java.io.FileInputStream
    //   127	1	1	localIOException1	java.io.IOException
    //   130	1	1	localIOException2	java.io.IOException
    //   5	34	2	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   19	46	52	finally
    //   0	19	56	finally
    //   0	19	103	java/security/NoSuchAlgorithmException
    //   0	19	107	java/io/FileNotFoundException
    //   0	19	111	java/io/IOException
    //   19	46	115	java/security/NoSuchAlgorithmException
    //   19	46	119	java/io/FileNotFoundException
    //   19	46	123	java/io/IOException
    //   46	50	127	java/io/IOException
    //   63	67	130	java/io/IOException
    //   75	79	134	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = null;
    if (!bool)
    {
      paramString = new File(paramString);
      if (paramString.length() < 204800L) {
        paramString = a(paramString);
      } else {
        paramString = b(paramString);
      }
      if ("".equals(paramString)) {
        return null;
      }
      str = paramString;
    }
    return str;
  }
  
  public static byte[] a(AppInterface paramAppInterface)
  {
    return HexUtil.hexStr2Bytes(((TicketManager)paramAppInterface.getManager(2)).getA2(paramAppInterface.getCurrentAccountUin()));
  }
  
  /* Error */
  public static android.graphics.Bitmap b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: iload_1
    //   8: ifne +92 -> 100
    //   11: new 71	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 147	java/io/File:exists	()Z
    //   24: ifeq +76 -> 100
    //   27: new 149	java/io/BufferedInputStream
    //   30: dup
    //   31: new 56	java/io/FileInputStream
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: invokespecial 152	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic 158	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   47: astore_2
    //   48: aload_0
    //   49: invokevirtual 159	java/io/BufferedInputStream:close	()V
    //   52: aload_2
    //   53: areturn
    //   54: astore_3
    //   55: aload_0
    //   56: astore_2
    //   57: aload_3
    //   58: astore_0
    //   59: goto +10 -> 69
    //   62: goto +19 -> 81
    //   65: goto +28 -> 93
    //   68: astore_0
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 159	java/io/BufferedInputStream:close	()V
    //   77: aload_0
    //   78: athrow
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +18 -> 100
    //   85: aload_0
    //   86: invokevirtual 159	java/io/BufferedInputStream:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: ifnull +6 -> 100
    //   97: goto -12 -> 85
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: goto -12 -> 91
    //   106: astore_0
    //   107: goto -28 -> 79
    //   110: astore_2
    //   111: goto -46 -> 65
    //   114: astore_2
    //   115: goto -53 -> 62
    //   118: astore_0
    //   119: aload_2
    //   120: areturn
    //   121: astore_2
    //   122: goto -45 -> 77
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   4	4	1	bool	boolean
    //   6	68	2	localObject1	Object
    //   110	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   114	6	2	localException1	java.lang.Exception
    //   121	1	2	localException2	java.lang.Exception
    //   54	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   43	48	54	finally
    //   27	43	68	finally
    //   27	43	102	java/lang/OutOfMemoryError
    //   27	43	106	java/lang/Exception
    //   43	48	110	java/lang/OutOfMemoryError
    //   43	48	114	java/lang/Exception
    //   48	52	118	java/lang/Exception
    //   73	77	121	java/lang/Exception
    //   85	89	125	java/lang/Exception
  }
  
  /* Error */
  private static String b(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +270 -> 271
    //   4: aload_0
    //   5: invokevirtual 147	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: ldc 99
    //   13: areturn
    //   14: aload_0
    //   15: invokevirtual 74	java/io/File:length	()J
    //   18: lstore_2
    //   19: lload_2
    //   20: ldc2_w 160
    //   23: lcmp
    //   24: ifle +130 -> 154
    //   27: lload_2
    //   28: ldc2_w 162
    //   31: ldiv
    //   32: lstore_2
    //   33: bipush 32
    //   35: newarray byte
    //   37: astore 4
    //   39: new 56	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_0
    //   48: aload_0
    //   49: lload_2
    //   50: invokevirtual 167	java/io/FileInputStream:skip	(J)J
    //   53: pop2
    //   54: iconst_0
    //   55: istore_1
    //   56: iload_1
    //   57: iconst_4
    //   58: if_icmpge +33 -> 91
    //   61: aload_0
    //   62: aload 4
    //   64: iload_1
    //   65: bipush 8
    //   67: imul
    //   68: bipush 8
    //   70: invokevirtual 171	java/io/FileInputStream:read	([BII)I
    //   73: pop
    //   74: aload_0
    //   75: lload_2
    //   76: ldc2_w 172
    //   79: lsub
    //   80: invokevirtual 167	java/io/FileInputStream:skip	(J)J
    //   83: pop2
    //   84: iload_1
    //   85: iconst_1
    //   86: iadd
    //   87: istore_1
    //   88: goto -32 -> 56
    //   91: aload 4
    //   93: invokestatic 94	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   96: astore 4
    //   98: aload_0
    //   99: invokevirtual 97	java/io/FileInputStream:close	()V
    //   102: aload 4
    //   104: areturn
    //   105: astore 5
    //   107: aload_0
    //   108: astore 4
    //   110: aload 5
    //   112: astore_0
    //   113: goto +7 -> 120
    //   116: astore_0
    //   117: aconst_null
    //   118: astore 4
    //   120: aload 4
    //   122: ifnull +8 -> 130
    //   125: aload 4
    //   127: invokevirtual 97	java/io/FileInputStream:close	()V
    //   130: aload_0
    //   131: athrow
    //   132: aconst_null
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull +136 -> 271
    //   138: aload_0
    //   139: invokevirtual 97	java/io/FileInputStream:close	()V
    //   142: ldc 99
    //   144: areturn
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +123 -> 271
    //   151: goto -13 -> 138
    //   154: ldc 45
    //   156: invokestatic 51	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   159: astore 5
    //   161: aload 5
    //   163: invokevirtual 54	java/security/MessageDigest:reset	()V
    //   166: new 56	java/io/FileInputStream
    //   169: dup
    //   170: aload_0
    //   171: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   174: astore 4
    //   176: aload 5
    //   178: aload 4
    //   180: invokevirtual 63	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   183: getstatic 69	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   186: lconst_0
    //   187: aload_0
    //   188: invokevirtual 74	java/io/File:length	()J
    //   191: invokevirtual 80	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   194: invokevirtual 84	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   197: aload 5
    //   199: invokevirtual 88	java/security/MessageDigest:digest	()[B
    //   202: invokestatic 94	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   205: astore_0
    //   206: aload 4
    //   208: invokevirtual 97	java/io/FileInputStream:close	()V
    //   211: aload_0
    //   212: areturn
    //   213: astore_0
    //   214: goto +7 -> 221
    //   217: astore_0
    //   218: aconst_null
    //   219: astore 4
    //   221: aload 4
    //   223: ifnull +8 -> 231
    //   226: aload 4
    //   228: invokevirtual 97	java/io/FileInputStream:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: aconst_null
    //   234: astore 4
    //   236: aload 4
    //   238: ifnull +33 -> 271
    //   241: aload 4
    //   243: invokevirtual 97	java/io/FileInputStream:close	()V
    //   246: ldc 99
    //   248: areturn
    //   249: aconst_null
    //   250: astore 4
    //   252: aload 4
    //   254: ifnull +17 -> 271
    //   257: goto -16 -> 241
    //   260: aconst_null
    //   261: astore 4
    //   263: aload 4
    //   265: ifnull +6 -> 271
    //   268: goto -27 -> 241
    //   271: ldc 99
    //   273: areturn
    //   274: astore_0
    //   275: goto -130 -> 145
    //   278: astore_0
    //   279: goto -147 -> 132
    //   282: astore 4
    //   284: goto -137 -> 147
    //   287: astore 4
    //   289: goto -155 -> 134
    //   292: astore_0
    //   293: aload 4
    //   295: areturn
    //   296: astore 4
    //   298: goto -168 -> 130
    //   301: astore_0
    //   302: ldc 99
    //   304: areturn
    //   305: astore_0
    //   306: goto -46 -> 260
    //   309: astore_0
    //   310: goto -61 -> 249
    //   313: astore_0
    //   314: goto -81 -> 233
    //   317: astore_0
    //   318: goto -55 -> 263
    //   321: astore_0
    //   322: goto -70 -> 252
    //   325: astore_0
    //   326: goto -90 -> 236
    //   329: astore 4
    //   331: aload_0
    //   332: areturn
    //   333: astore 4
    //   335: goto -104 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramFile	File
    //   55	33	1	i	int
    //   18	58	2	l	long
    //   37	227	4	localObject1	Object
    //   282	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   287	7	4	localIOException1	java.io.IOException
    //   296	1	4	localIOException2	java.io.IOException
    //   329	1	4	localIOException3	java.io.IOException
    //   333	1	4	localIOException4	java.io.IOException
    //   105	6	5	localObject2	Object
    //   159	39	5	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   48	54	105	finally
    //   61	84	105	finally
    //   91	98	105	finally
    //   39	48	116	finally
    //   176	206	213	finally
    //   154	176	217	finally
    //   39	48	274	java/io/FileNotFoundException
    //   39	48	278	java/io/IOException
    //   48	54	282	java/io/FileNotFoundException
    //   61	84	282	java/io/FileNotFoundException
    //   91	98	282	java/io/FileNotFoundException
    //   48	54	287	java/io/IOException
    //   61	84	287	java/io/IOException
    //   91	98	287	java/io/IOException
    //   98	102	292	java/io/IOException
    //   125	130	296	java/io/IOException
    //   138	142	301	java/io/IOException
    //   241	246	301	java/io/IOException
    //   154	176	305	java/security/NoSuchAlgorithmException
    //   154	176	309	java/io/FileNotFoundException
    //   154	176	313	java/io/IOException
    //   176	206	317	java/security/NoSuchAlgorithmException
    //   176	206	321	java/io/FileNotFoundException
    //   176	206	325	java/io/IOException
    //   206	211	329	java/io/IOException
    //   226	231	333	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.VipUploadUtils
 * JD-Core Version:    0.7.0.1
 */