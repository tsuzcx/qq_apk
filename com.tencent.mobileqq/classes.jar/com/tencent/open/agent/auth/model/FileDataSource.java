package com.tencent.open.agent.auth.model;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class FileDataSource
{
  private static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("qqconnect/");
    a = localStringBuilder.toString();
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqconnect/");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aload 9
    //   8: astore 7
    //   10: new 47	java/io/File
    //   13: dup
    //   14: invokestatic 55	com/tencent/open/agent/auth/model/FileDataSource:a	()Ljava/lang/String;
    //   17: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 10
    //   22: aload 9
    //   24: astore 7
    //   26: aload 10
    //   28: invokevirtual 62	java/io/File:exists	()Z
    //   31: ifne +16 -> 47
    //   34: aload 9
    //   36: astore 7
    //   38: aload 10
    //   40: invokevirtual 65	java/io/File:mkdirs	()Z
    //   43: pop
    //   44: goto +35 -> 79
    //   47: aload 9
    //   49: astore 7
    //   51: aload 10
    //   53: invokevirtual 68	java/io/File:isFile	()Z
    //   56: ifeq +23 -> 79
    //   59: aload 9
    //   61: astore 7
    //   63: aload 10
    //   65: invokevirtual 71	java/io/File:delete	()Z
    //   68: pop
    //   69: aload 9
    //   71: astore 7
    //   73: aload 10
    //   75: invokevirtual 65	java/io/File:mkdirs	()Z
    //   78: pop
    //   79: aload 9
    //   81: astore 7
    //   83: new 10	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   90: astore 11
    //   92: aload 9
    //   94: astore 7
    //   96: aload 11
    //   98: aload_0
    //   99: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 9
    //   105: astore 7
    //   107: aload 11
    //   109: ldc 73
    //   111: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 9
    //   117: astore 7
    //   119: aload 11
    //   121: aload_1
    //   122: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 9
    //   128: astore 7
    //   130: aload 11
    //   132: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 79	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore_1
    //   139: aload 9
    //   141: astore 7
    //   143: new 47	java/io/File
    //   146: dup
    //   147: aload 10
    //   149: aload_1
    //   150: invokespecial 82	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   153: astore 10
    //   155: aload 9
    //   157: astore 7
    //   159: aload 10
    //   161: invokevirtual 62	java/io/File:exists	()Z
    //   164: ifeq +13 -> 177
    //   167: aload 9
    //   169: astore 7
    //   171: aload 10
    //   173: invokevirtual 71	java/io/File:delete	()Z
    //   176: pop
    //   177: aload 9
    //   179: astore 7
    //   181: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   184: ldc2_w 89
    //   187: ldiv
    //   188: lstore 5
    //   190: aload 9
    //   192: astore 7
    //   194: new 92	java/io/DataOutputStream
    //   197: dup
    //   198: new 94	java/io/FileOutputStream
    //   201: dup
    //   202: aload 10
    //   204: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   207: invokespecial 100	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   210: astore_0
    //   211: aload_0
    //   212: lload 5
    //   214: lload_2
    //   215: ladd
    //   216: invokevirtual 104	java/io/DataOutputStream:writeLong	(J)V
    //   219: aload_0
    //   220: aload 4
    //   222: aload_1
    //   223: ldc 106
    //   225: invokevirtual 112	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   228: invokestatic 117	com/tencent/util/ThreeDes:a	([B[B)[B
    //   231: invokevirtual 121	java/io/DataOutputStream:write	([B)V
    //   234: ldc 123
    //   236: iconst_2
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: ldc 125
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload 10
    //   249: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   252: aastore
    //   253: invokestatic 133	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: aload_0
    //   257: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   260: return
    //   261: astore_1
    //   262: aload_0
    //   263: astore 7
    //   265: aload_1
    //   266: astore_0
    //   267: goto +31 -> 298
    //   270: astore_1
    //   271: goto +11 -> 282
    //   274: astore_0
    //   275: goto +23 -> 298
    //   278: astore_1
    //   279: aload 8
    //   281: astore_0
    //   282: aload_0
    //   283: astore 7
    //   285: ldc 123
    //   287: ldc 140
    //   289: aload_1
    //   290: invokestatic 144	com/tencent/open/agent/util/SSOLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   293: aload_0
    //   294: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   297: return
    //   298: aload 7
    //   300: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   303: aload_0
    //   304: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramString1	String
    //   0	305	1	paramString2	String
    //   0	305	2	paramLong	long
    //   0	305	4	paramArrayOfByte	byte[]
    //   188	25	5	l	long
    //   8	291	7	localObject1	Object
    //   1	279	8	localObject2	Object
    //   4	187	9	localObject3	Object
    //   20	228	10	localFile	File
    //   90	41	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   211	256	261	finally
    //   211	256	270	java/io/IOException
    //   10	22	274	finally
    //   26	34	274	finally
    //   38	44	274	finally
    //   51	59	274	finally
    //   63	69	274	finally
    //   73	79	274	finally
    //   83	92	274	finally
    //   96	103	274	finally
    //   107	115	274	finally
    //   119	126	274	finally
    //   130	139	274	finally
    //   143	155	274	finally
    //   159	167	274	finally
    //   171	177	274	finally
    //   181	190	274	finally
    //   194	211	274	finally
    //   285	293	274	finally
    //   10	22	278	java/io/IOException
    //   26	34	278	java/io/IOException
    //   38	44	278	java/io/IOException
    //   51	59	278	java/io/IOException
    //   63	69	278	java/io/IOException
    //   73	79	278	java/io/IOException
    //   83	92	278	java/io/IOException
    //   96	103	278	java/io/IOException
    //   107	115	278	java/io/IOException
    //   119	126	278	java/io/IOException
    //   130	139	278	java/io/IOException
    //   143	155	278	java/io/IOException
    //   159	167	278	java/io/IOException
    //   171	177	278	java/io/IOException
    //   181	190	278	java/io/IOException
    //   194	211	278	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 10	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: aload_0
    //   14: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 4
    //   20: ldc 73
    //   22: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 4
    //   28: aload_1
    //   29: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 4
    //   35: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 79	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 4
    //   43: new 10	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 55	com/tencent/open/agent/auth/model/FileDataSource:a	()Ljava/lang/String;
    //   55: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_0
    //   60: aload 4
    //   62: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: new 47	java/io/File
    //   69: dup
    //   70: aload_0
    //   71: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: aload_1
    //   81: invokevirtual 62	java/io/File:exists	()Z
    //   84: ifne +59 -> 143
    //   87: ldc 123
    //   89: iconst_2
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: ldc 147
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_1
    //   101: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   104: aastore
    //   105: invokestatic 133	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: new 10	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   115: astore_0
    //   116: aload_0
    //   117: getstatic 30	com/tencent/open/agent/auth/model/FileDataSource:a	Ljava/lang/String;
    //   120: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_0
    //   125: aload 4
    //   127: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: new 47	java/io/File
    //   134: dup
    //   135: aload_0
    //   136: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 62	java/io/File:exists	()Z
    //   147: ifne +30 -> 177
    //   150: ldc 123
    //   152: iconst_2
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: ldc 149
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload_0
    //   164: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   167: aastore
    //   168: invokestatic 133	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aconst_null
    //   172: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   175: aconst_null
    //   176: areturn
    //   177: ldc 123
    //   179: iconst_2
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: ldc 151
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: aload_0
    //   191: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   194: aastore
    //   195: invokestatic 133	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: new 153	java/io/DataInputStream
    //   201: dup
    //   202: new 155	java/io/FileInputStream
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 156	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   210: invokespecial 159	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   213: astore_1
    //   214: aload_1
    //   215: astore_0
    //   216: aload_1
    //   217: invokevirtual 162	java/io/DataInputStream:readLong	()J
    //   220: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   223: ldc2_w 89
    //   226: ldiv
    //   227: lcmp
    //   228: ifgt +25 -> 253
    //   231: aload_1
    //   232: astore_0
    //   233: ldc 123
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: ldc 164
    //   243: aastore
    //   244: invokestatic 133	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload_1
    //   248: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   251: aconst_null
    //   252: areturn
    //   253: aload_1
    //   254: astore_0
    //   255: aload_1
    //   256: invokevirtual 168	java/io/DataInputStream:available	()I
    //   259: istore_2
    //   260: iload_2
    //   261: ifgt +9 -> 270
    //   264: aload_1
    //   265: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   268: aconst_null
    //   269: areturn
    //   270: aload_1
    //   271: astore_0
    //   272: iload_2
    //   273: newarray byte
    //   275: astore_3
    //   276: aload_1
    //   277: astore_0
    //   278: aload_1
    //   279: aload_3
    //   280: invokevirtual 172	java/io/DataInputStream:read	([B)I
    //   283: pop
    //   284: aload_1
    //   285: astore_0
    //   286: aload_1
    //   287: invokevirtual 175	java/io/DataInputStream:close	()V
    //   290: aload_1
    //   291: astore_0
    //   292: aload_3
    //   293: aload 4
    //   295: ldc 106
    //   297: invokevirtual 112	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   300: invokestatic 178	com/tencent/util/ThreeDes:b	([B[B)[B
    //   303: astore_3
    //   304: aload_1
    //   305: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   308: aload_3
    //   309: areturn
    //   310: astore_3
    //   311: goto +12 -> 323
    //   314: astore_1
    //   315: aload_3
    //   316: astore_0
    //   317: goto +23 -> 340
    //   320: astore_3
    //   321: aconst_null
    //   322: astore_1
    //   323: aload_1
    //   324: astore_0
    //   325: ldc 123
    //   327: ldc 140
    //   329: aload_3
    //   330: invokestatic 144	com/tencent/open/agent/util/SSOLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   333: aload_1
    //   334: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   337: aconst_null
    //   338: areturn
    //   339: astore_1
    //   340: aload_0
    //   341: invokestatic 138	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   344: aload_1
    //   345: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramString1	String
    //   0	346	1	paramString2	String
    //   259	14	2	i	int
    //   1	308	3	arrayOfByte	byte[]
    //   310	6	3	localIOException1	java.io.IOException
    //   320	10	3	localIOException2	java.io.IOException
    //   9	285	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   216	231	310	java/io/IOException
    //   233	247	310	java/io/IOException
    //   255	260	310	java/io/IOException
    //   272	276	310	java/io/IOException
    //   278	284	310	java/io/IOException
    //   286	290	310	java/io/IOException
    //   292	304	310	java/io/IOException
    //   2	78	314	finally
    //   80	143	314	finally
    //   143	171	314	finally
    //   177	214	314	finally
    //   2	78	320	java/io/IOException
    //   80	143	320	java/io/IOException
    //   143	171	320	java/io/IOException
    //   177	214	320	java/io/IOException
    //   216	231	339	finally
    //   233	247	339	finally
    //   255	260	339	finally
    //   272	276	339	finally
    //   278	284	339	finally
    //   286	290	339	finally
    //   292	304	339	finally
    //   325	333	339	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.FileDataSource
 * JD-Core Version:    0.7.0.1
 */