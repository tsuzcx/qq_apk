package com.tencent.thumbplayer.core.downloadproxy.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TPDLProxyUtils
{
  private static final String FILE_NAME = "TPDLProxyUtils";
  
  public static String byteArrayToString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("byteArrayToString failed, error:");
      localStringBuilder.append(paramArrayOfByte.toString());
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", localStringBuilder.toString());
    }
    return "";
  }
  
  public static String losePackageCheck(int paramInt)
  {
    Object localObject1 = "";
    Object localObject2;
    Object localObject3;
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ping -c ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" www.qq.com");
      localObject2 = ((StringBuilder)localObject2).toString();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject2).getInputStream()));
      Object localObject6 = "";
      for (;;)
      {
        localObject2 = localObject6;
        localObject3 = localObject1;
        try
        {
          String str = localBufferedReader.readLine();
          localObject3 = localObject1;
          Object localObject4 = localObject2;
          if (str == null) {
            break label210;
          }
          localObject4 = localObject1;
          localObject3 = localObject1;
          if (str.contains(" packet loss"))
          {
            localObject3 = localObject1;
            localObject4 = str.substring(10 + str.indexOf("received, "), str.indexOf("%") + 1);
          }
          localObject1 = localObject4;
          localObject6 = localObject2;
          localObject3 = localObject4;
          if (str.contains("avg"))
          {
            localObject3 = localObject4;
            paramInt = str.indexOf("/", 20);
            localObject3 = localObject4;
            localObject6 = str.substring(paramInt + 1, str.indexOf(".", paramInt));
            localObject1 = localObject4;
          }
        }
        catch (Throwable localThrowable1) {}
      }
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2)
    {
      localObject2 = "";
      localObject3 = localObject1;
    }
    Object localObject5 = localObject2;
    label210:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(localObject3);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(localObject5);
    return ((StringBuilder)localObject1).toString();
  }
  
  public static int objectToInt(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      return paramInt;
    }
    try
    {
      int i = ((Integer)paramObject).intValue();
      return i;
    }
    catch (Throwable paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object to int failed, error:");
      localStringBuilder.append(paramObject.toString());
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public static long objectToLong(Object paramObject, long paramLong)
  {
    if (paramObject == null) {
      return paramLong;
    }
    try
    {
      long l = ((Long)paramObject).longValue();
      return l;
    }
    catch (Throwable paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object to long failed, error:");
      localStringBuilder.append(paramObject.toString());
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", localStringBuilder.toString());
    }
    return paramLong;
  }
  
  /* Error */
  public static String serialize(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: new 142	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 143	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore_1
    //   15: aload_2
    //   16: astore_3
    //   17: aload_1
    //   18: astore_2
    //   19: new 145	java/io/ObjectOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 148	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: invokevirtual 152	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   35: aload_1
    //   36: ldc 154
    //   38: invokevirtual 157	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_0
    //   42: aload 4
    //   44: invokevirtual 160	java/io/ObjectOutputStream:close	()V
    //   47: goto +40 -> 87
    //   50: astore_2
    //   51: new 28	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   58: astore_3
    //   59: aload_3
    //   60: ldc 162
    //   62: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_3
    //   67: aload_2
    //   68: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   71: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: ldc 8
    //   77: iconst_0
    //   78: ldc 41
    //   80: aload_3
    //   81: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   87: aload_1
    //   88: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   91: aload_0
    //   92: areturn
    //   93: astore_1
    //   94: new 28	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   101: astore_2
    //   102: aload_2
    //   103: ldc 165
    //   105: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_2
    //   110: aload_1
    //   111: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   114: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 8
    //   120: iconst_0
    //   121: ldc 41
    //   123: aload_2
    //   124: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: areturn
    //   132: astore_0
    //   133: aload 4
    //   135: astore_3
    //   136: goto +192 -> 328
    //   139: astore_2
    //   140: aload 4
    //   142: astore_0
    //   143: aload_2
    //   144: astore 4
    //   146: goto +30 -> 176
    //   149: astore_0
    //   150: aload_2
    //   151: astore_1
    //   152: goto +176 -> 328
    //   155: astore 4
    //   157: aload 5
    //   159: astore_0
    //   160: goto +16 -> 176
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_1
    //   166: goto +162 -> 328
    //   169: astore 4
    //   171: aconst_null
    //   172: astore_1
    //   173: aload 5
    //   175: astore_0
    //   176: aload_0
    //   177: astore_3
    //   178: aload_1
    //   179: astore_2
    //   180: new 28	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   187: astore 5
    //   189: aload_0
    //   190: astore_3
    //   191: aload_1
    //   192: astore_2
    //   193: aload 5
    //   195: ldc 167
    //   197: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_0
    //   202: astore_3
    //   203: aload_1
    //   204: astore_2
    //   205: aload 5
    //   207: aload 4
    //   209: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   212: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_0
    //   217: astore_3
    //   218: aload_1
    //   219: astore_2
    //   220: ldc 8
    //   222: iconst_0
    //   223: ldc 41
    //   225: aload 5
    //   227: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: ifnull +47 -> 281
    //   237: aload_0
    //   238: invokevirtual 160	java/io/ObjectOutputStream:close	()V
    //   241: goto +40 -> 281
    //   244: astore_0
    //   245: new 28	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   252: astore_2
    //   253: aload_2
    //   254: ldc 162
    //   256: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_2
    //   261: aload_0
    //   262: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   265: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: ldc 8
    //   271: iconst_0
    //   272: ldc 41
    //   274: aload_2
    //   275: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   281: aload_1
    //   282: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   285: goto +40 -> 325
    //   288: astore_0
    //   289: new 28	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   296: astore_1
    //   297: aload_1
    //   298: ldc 165
    //   300: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: aload_0
    //   306: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   309: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 8
    //   315: iconst_0
    //   316: ldc 41
    //   318: aload_1
    //   319: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   325: ldc 19
    //   327: areturn
    //   328: aload_3
    //   329: ifnull +47 -> 376
    //   332: aload_3
    //   333: invokevirtual 160	java/io/ObjectOutputStream:close	()V
    //   336: goto +40 -> 376
    //   339: astore_2
    //   340: new 28	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   347: astore_3
    //   348: aload_3
    //   349: ldc 162
    //   351: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload_3
    //   356: aload_2
    //   357: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   360: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: ldc 8
    //   366: iconst_0
    //   367: ldc 41
    //   369: aload_3
    //   370: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   376: aload_1
    //   377: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   380: goto +40 -> 420
    //   383: astore_1
    //   384: new 28	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   391: astore_2
    //   392: aload_2
    //   393: ldc 165
    //   395: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_2
    //   400: aload_1
    //   401: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   404: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: ldc 8
    //   410: iconst_0
    //   411: ldc 41
    //   413: aload_2
    //   414: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   420: aload_0
    //   421: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	paramObject	Object
    //   14	74	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   93	18	1	localThrowable1	Throwable
    //   151	226	1	localObject1	Object
    //   383	18	1	localThrowable2	Throwable
    //   6	13	2	localObject2	Object
    //   50	18	2	localThrowable3	Throwable
    //   101	23	2	localStringBuilder1	StringBuilder
    //   139	12	2	localThrowable4	Throwable
    //   179	96	2	localObject3	Object
    //   339	18	2	localThrowable5	Throwable
    //   391	23	2	localStringBuilder2	StringBuilder
    //   4	366	3	localObject4	Object
    //   27	118	4	localObject5	Object
    //   155	1	4	localThrowable6	Throwable
    //   169	39	4	localThrowable7	Throwable
    //   1	225	5	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   42	47	50	java/lang/Throwable
    //   87	91	93	java/lang/Throwable
    //   29	42	132	finally
    //   29	42	139	java/lang/Throwable
    //   19	29	149	finally
    //   180	189	149	finally
    //   193	201	149	finally
    //   205	216	149	finally
    //   220	233	149	finally
    //   19	29	155	java/lang/Throwable
    //   7	15	163	finally
    //   7	15	169	java/lang/Throwable
    //   237	241	244	java/lang/Throwable
    //   281	285	288	java/lang/Throwable
    //   332	336	339	java/lang/Throwable
    //   376	380	383	java/lang/Throwable
  }
  
  /* Error */
  public static Object serializeToObject(String paramString)
  {
    // Byte code:
    //   0: new 171	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: ldc 154
    //   7: invokevirtual 175	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   10: invokespecial 178	java/io/ByteArrayInputStream:<init>	([B)V
    //   13: astore_0
    //   14: new 180	java/io/ObjectInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 181	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore 5
    //   24: aload_0
    //   25: astore_2
    //   26: aload 5
    //   28: astore_3
    //   29: aload 5
    //   31: invokevirtual 185	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   34: astore_1
    //   35: aload 5
    //   37: invokevirtual 186	java/io/ObjectInputStream:close	()V
    //   40: goto +40 -> 80
    //   43: astore_2
    //   44: new 28	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   51: astore_3
    //   52: aload_3
    //   53: ldc 188
    //   55: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   64: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: ldc 8
    //   70: iconst_0
    //   71: ldc 41
    //   73: aload_3
    //   74: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: invokevirtual 189	java/io/ByteArrayInputStream:close	()V
    //   84: aload_1
    //   85: areturn
    //   86: astore_0
    //   87: new 28	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   94: astore_2
    //   95: aload_2
    //   96: ldc 191
    //   98: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_2
    //   103: aload_0
    //   104: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   107: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 8
    //   113: iconst_0
    //   114: ldc 41
    //   116: aload_2
    //   117: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: areturn
    //   125: astore 4
    //   127: aload_0
    //   128: astore_1
    //   129: aload 5
    //   131: astore_0
    //   132: goto +34 -> 166
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_3
    //   138: goto +185 -> 323
    //   141: astore 4
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_0
    //   146: astore_1
    //   147: aload_2
    //   148: astore_0
    //   149: goto +17 -> 166
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: aload_0
    //   156: astore_3
    //   157: goto +166 -> 323
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: astore_1
    //   166: aload_1
    //   167: astore_2
    //   168: aload_0
    //   169: astore_3
    //   170: new 28	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   177: astore 5
    //   179: aload_1
    //   180: astore_2
    //   181: aload_0
    //   182: astore_3
    //   183: aload 5
    //   185: ldc 193
    //   187: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: astore_2
    //   193: aload_0
    //   194: astore_3
    //   195: aload 5
    //   197: aload 4
    //   199: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   202: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: astore_2
    //   208: aload_0
    //   209: astore_3
    //   210: ldc 8
    //   212: iconst_0
    //   213: ldc 41
    //   215: aload 5
    //   217: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: ifnull +47 -> 271
    //   227: aload_0
    //   228: invokevirtual 186	java/io/ObjectInputStream:close	()V
    //   231: goto +40 -> 271
    //   234: astore_0
    //   235: new 28	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   242: astore_2
    //   243: aload_2
    //   244: ldc 188
    //   246: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: aload_0
    //   252: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   255: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: ldc 8
    //   261: iconst_0
    //   262: ldc 41
    //   264: aload_2
    //   265: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   271: aload_1
    //   272: ifnull +46 -> 318
    //   275: aload_1
    //   276: invokevirtual 189	java/io/ByteArrayInputStream:close	()V
    //   279: aconst_null
    //   280: areturn
    //   281: astore_0
    //   282: new 28	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   289: astore_1
    //   290: aload_1
    //   291: ldc 191
    //   293: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_1
    //   298: aload_0
    //   299: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   302: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: ldc 8
    //   308: iconst_0
    //   309: ldc 41
    //   311: aload_1
    //   312: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   318: aconst_null
    //   319: areturn
    //   320: astore_1
    //   321: aload_2
    //   322: astore_0
    //   323: aload_3
    //   324: ifnull +47 -> 371
    //   327: aload_3
    //   328: invokevirtual 186	java/io/ObjectInputStream:close	()V
    //   331: goto +40 -> 371
    //   334: astore_2
    //   335: new 28	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   342: astore_3
    //   343: aload_3
    //   344: ldc 188
    //   346: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_3
    //   351: aload_2
    //   352: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   355: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: ldc 8
    //   361: iconst_0
    //   362: ldc 41
    //   364: aload_3
    //   365: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   371: aload_0
    //   372: ifnull +47 -> 419
    //   375: aload_0
    //   376: invokevirtual 189	java/io/ByteArrayInputStream:close	()V
    //   379: goto +40 -> 419
    //   382: astore_0
    //   383: new 28	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   390: astore_2
    //   391: aload_2
    //   392: ldc 191
    //   394: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_2
    //   399: aload_0
    //   400: invokevirtual 39	java/lang/Throwable:toString	()Ljava/lang/String;
    //   403: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: ldc 8
    //   409: iconst_0
    //   410: ldc 41
    //   412: aload_2
    //   413: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   419: aload_1
    //   420: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramString	String
    //   34	95	1	localObject1	Object
    //   135	1	1	localObject2	Object
    //   146	1	1	str1	String
    //   152	1	1	localObject3	Object
    //   165	147	1	localObject4	Object
    //   320	100	1	localObject5	Object
    //   25	1	2	str2	String
    //   43	18	2	localThrowable1	Throwable
    //   94	228	2	localObject6	Object
    //   334	18	2	localThrowable2	Throwable
    //   390	23	2	localStringBuilder	StringBuilder
    //   28	337	3	localObject7	Object
    //   125	1	4	localThrowable3	Throwable
    //   141	1	4	localThrowable4	Throwable
    //   160	38	4	localThrowable5	Throwable
    //   22	194	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   35	40	43	java/lang/Throwable
    //   80	84	86	java/lang/Throwable
    //   29	35	125	java/lang/Throwable
    //   14	24	135	finally
    //   14	24	141	java/lang/Throwable
    //   0	14	152	finally
    //   0	14	160	java/lang/Throwable
    //   227	231	234	java/lang/Throwable
    //   275	279	281	java/lang/Throwable
    //   29	35	320	finally
    //   170	179	320	finally
    //   183	191	320	finally
    //   195	206	320	finally
    //   210	223	320	finally
    //   327	331	334	java/lang/Throwable
    //   375	379	382	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils
 * JD-Core Version:    0.7.0.1
 */