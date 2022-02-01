package com.tencent.mobileqq.utils;

public class AssetsUtil
{
  /* Error */
  public static java.lang.String a(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 19	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_1
    //   8: invokevirtual 25	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_2
    //   12: new 27	java/io/BufferedReader
    //   15: dup
    //   16: new 29	java/io/InputStreamReader
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 32	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: invokespecial 35	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_0
    //   28: aload_0
    //   29: astore_3
    //   30: aload_2
    //   31: astore 4
    //   33: new 37	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload_0
    //   43: astore_3
    //   44: aload_2
    //   45: astore 4
    //   47: aload_0
    //   48: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnull +19 -> 74
    //   58: aload_0
    //   59: astore_3
    //   60: aload_2
    //   61: astore 4
    //   63: aload 5
    //   65: aload 7
    //   67: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -29 -> 42
    //   74: aload_0
    //   75: astore_3
    //   76: aload_2
    //   77: astore 4
    //   79: aload 5
    //   81: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 5
    //   86: aload_0
    //   87: invokevirtual 52	java/io/BufferedReader:close	()V
    //   90: goto +27 -> 117
    //   93: astore_0
    //   94: ldc 54
    //   96: iconst_1
    //   97: iconst_3
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: ldc 56
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload_1
    //   109: aastore
    //   110: dup
    //   111: iconst_2
    //   112: aload_0
    //   113: aastore
    //   114: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   117: aload 5
    //   119: astore_0
    //   120: aload_2
    //   121: ifnull +173 -> 294
    //   124: aload_2
    //   125: invokevirtual 65	java/io/InputStream:close	()V
    //   128: aload 5
    //   130: areturn
    //   131: astore_0
    //   132: ldc 54
    //   134: iconst_1
    //   135: iconst_3
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: ldc 67
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload_1
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: aload_0
    //   151: aastore
    //   152: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   155: aload 5
    //   157: areturn
    //   158: astore 5
    //   160: goto +30 -> 190
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_3
    //   166: goto +134 -> 300
    //   169: astore 5
    //   171: aconst_null
    //   172: astore_0
    //   173: goto +17 -> 190
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: astore_2
    //   181: goto +119 -> 300
    //   184: astore 5
    //   186: aconst_null
    //   187: astore_2
    //   188: aload_2
    //   189: astore_0
    //   190: aload_0
    //   191: astore_3
    //   192: aload_2
    //   193: astore 4
    //   195: ldc 54
    //   197: iconst_1
    //   198: iconst_3
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: ldc 69
    //   206: aastore
    //   207: dup
    //   208: iconst_1
    //   209: aload_1
    //   210: aastore
    //   211: dup
    //   212: iconst_2
    //   213: aload 5
    //   215: aastore
    //   216: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   219: aload_0
    //   220: ifnull +34 -> 254
    //   223: aload_0
    //   224: invokevirtual 52	java/io/BufferedReader:close	()V
    //   227: goto +27 -> 254
    //   230: astore_0
    //   231: ldc 54
    //   233: iconst_1
    //   234: iconst_3
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: ldc 56
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: aload_1
    //   246: aastore
    //   247: dup
    //   248: iconst_2
    //   249: aload_0
    //   250: aastore
    //   251: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   254: aload 6
    //   256: astore_0
    //   257: aload_2
    //   258: ifnull +36 -> 294
    //   261: aload_2
    //   262: invokevirtual 65	java/io/InputStream:close	()V
    //   265: aconst_null
    //   266: areturn
    //   267: astore_0
    //   268: ldc 54
    //   270: iconst_1
    //   271: iconst_3
    //   272: anewarray 4	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: ldc 67
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: aload_1
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: aload_0
    //   287: aastore
    //   288: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   291: aload 6
    //   293: astore_0
    //   294: aload_0
    //   295: areturn
    //   296: astore_0
    //   297: aload 4
    //   299: astore_2
    //   300: aload_3
    //   301: ifnull +34 -> 335
    //   304: aload_3
    //   305: invokevirtual 52	java/io/BufferedReader:close	()V
    //   308: goto +27 -> 335
    //   311: astore_3
    //   312: ldc 54
    //   314: iconst_1
    //   315: iconst_3
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: ldc 56
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: aload_1
    //   327: aastore
    //   328: dup
    //   329: iconst_2
    //   330: aload_3
    //   331: aastore
    //   332: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   335: aload_2
    //   336: ifnull +34 -> 370
    //   339: aload_2
    //   340: invokevirtual 65	java/io/InputStream:close	()V
    //   343: goto +27 -> 370
    //   346: astore_2
    //   347: ldc 54
    //   349: iconst_1
    //   350: iconst_3
    //   351: anewarray 4	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: ldc 67
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: aload_1
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: aload_2
    //   366: aastore
    //   367: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   370: goto +5 -> 375
    //   373: aload_0
    //   374: athrow
    //   375: goto -2 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramContext	android.content.Context
    //   0	378	1	paramString	java.lang.String
    //   11	329	2	localObject1	Object
    //   346	20	2	localIOException1	java.io.IOException
    //   29	276	3	localContext	android.content.Context
    //   311	20	3	localIOException2	java.io.IOException
    //   31	267	4	localObject2	Object
    //   40	116	5	localObject3	Object
    //   158	1	5	localIOException3	java.io.IOException
    //   169	1	5	localIOException4	java.io.IOException
    //   184	30	5	localIOException5	java.io.IOException
    //   1	291	6	localObject4	Object
    //   51	15	7	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   86	90	93	java/io/IOException
    //   124	128	131	java/io/IOException
    //   33	42	158	java/io/IOException
    //   47	53	158	java/io/IOException
    //   63	71	158	java/io/IOException
    //   79	86	158	java/io/IOException
    //   12	28	163	finally
    //   12	28	169	java/io/IOException
    //   3	12	176	finally
    //   3	12	184	java/io/IOException
    //   223	227	230	java/io/IOException
    //   261	265	267	java/io/IOException
    //   33	42	296	finally
    //   47	53	296	finally
    //   63	71	296	finally
    //   79	86	296	finally
    //   195	219	296	finally
    //   304	308	311	java/io/IOException
    //   339	343	346	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */