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
    //   11: astore_0
    //   12: new 27	java/io/BufferedReader
    //   15: dup
    //   16: new 29	java/io/InputStreamReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 32	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: invokespecial 35	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore 4
    //   31: aload_0
    //   32: astore_3
    //   33: new 37	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload_2
    //   43: astore 4
    //   45: aload_0
    //   46: astore_3
    //   47: aload_2
    //   48: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnull +74 -> 129
    //   58: aload_2
    //   59: astore 4
    //   61: aload_0
    //   62: astore_3
    //   63: aload 5
    //   65: aload 7
    //   67: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -29 -> 42
    //   74: astore 5
    //   76: aload_2
    //   77: astore 4
    //   79: aload_0
    //   80: astore_3
    //   81: ldc 48
    //   83: iconst_1
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc 50
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_1
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: aload 5
    //   101: aastore
    //   102: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 59	java/io/BufferedReader:close	()V
    //   113: aload 6
    //   115: astore_2
    //   116: aload_0
    //   117: ifnull +10 -> 127
    //   120: aload_0
    //   121: invokevirtual 62	java/io/InputStream:close	()V
    //   124: aload 6
    //   126: astore_2
    //   127: aload_2
    //   128: areturn
    //   129: aload_2
    //   130: astore 4
    //   132: aload_0
    //   133: astore_3
    //   134: aload 5
    //   136: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore 5
    //   141: aload 5
    //   143: astore_3
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 59	java/io/BufferedReader:close	()V
    //   152: aload_3
    //   153: astore_2
    //   154: aload_0
    //   155: ifnull -28 -> 127
    //   158: aload_0
    //   159: invokevirtual 62	java/io/InputStream:close	()V
    //   162: aload_3
    //   163: areturn
    //   164: astore_0
    //   165: ldc 48
    //   167: iconst_1
    //   168: iconst_3
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: ldc 67
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload_1
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: aload_0
    //   184: aastore
    //   185: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   188: aload_3
    //   189: areturn
    //   190: astore_2
    //   191: ldc 48
    //   193: iconst_1
    //   194: iconst_3
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: ldc 69
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload_1
    //   206: aastore
    //   207: dup
    //   208: iconst_2
    //   209: aload_2
    //   210: aastore
    //   211: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   214: goto -62 -> 152
    //   217: astore_2
    //   218: ldc 48
    //   220: iconst_1
    //   221: iconst_3
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: ldc 69
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: aload_1
    //   233: aastore
    //   234: dup
    //   235: iconst_2
    //   236: aload_2
    //   237: aastore
    //   238: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   241: goto -128 -> 113
    //   244: astore_0
    //   245: ldc 48
    //   247: iconst_1
    //   248: iconst_3
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: ldc 67
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload_1
    //   260: aastore
    //   261: dup
    //   262: iconst_2
    //   263: aload_0
    //   264: aastore
    //   265: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   268: aconst_null
    //   269: areturn
    //   270: astore_2
    //   271: aconst_null
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_0
    //   276: aload 4
    //   278: ifnull +8 -> 286
    //   281: aload 4
    //   283: invokevirtual 59	java/io/BufferedReader:close	()V
    //   286: aload_0
    //   287: ifnull +7 -> 294
    //   290: aload_0
    //   291: invokevirtual 62	java/io/InputStream:close	()V
    //   294: aload_2
    //   295: athrow
    //   296: astore_3
    //   297: ldc 48
    //   299: iconst_1
    //   300: iconst_3
    //   301: anewarray 4	java/lang/Object
    //   304: dup
    //   305: iconst_0
    //   306: ldc 69
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: aload_1
    //   312: aastore
    //   313: dup
    //   314: iconst_2
    //   315: aload_3
    //   316: aastore
    //   317: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   320: goto -34 -> 286
    //   323: astore_0
    //   324: ldc 48
    //   326: iconst_1
    //   327: iconst_3
    //   328: anewarray 4	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: ldc 67
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: aload_1
    //   339: aastore
    //   340: dup
    //   341: iconst_2
    //   342: aload_0
    //   343: aastore
    //   344: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   347: goto -53 -> 294
    //   350: astore_2
    //   351: aconst_null
    //   352: astore 4
    //   354: goto -78 -> 276
    //   357: astore_2
    //   358: aload_3
    //   359: astore_0
    //   360: goto -84 -> 276
    //   363: astore 5
    //   365: aconst_null
    //   366: astore_2
    //   367: aconst_null
    //   368: astore_0
    //   369: goto -293 -> 76
    //   372: astore 5
    //   374: aconst_null
    //   375: astore_2
    //   376: goto -300 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramContext	android.content.Context
    //   0	379	1	paramString	java.lang.String
    //   27	127	2	localObject1	Object
    //   190	20	2	localIOException1	java.io.IOException
    //   217	20	2	localIOException2	java.io.IOException
    //   270	25	2	localObject2	Object
    //   350	1	2	localObject3	Object
    //   357	1	2	localObject4	Object
    //   366	10	2	localObject5	Object
    //   32	157	3	localObject6	Object
    //   296	63	3	localIOException3	java.io.IOException
    //   29	324	4	localObject7	Object
    //   40	24	5	localStringBuilder	java.lang.StringBuilder
    //   74	61	5	localIOException4	java.io.IOException
    //   139	3	5	str1	java.lang.String
    //   363	1	5	localIOException5	java.io.IOException
    //   372	1	5	localIOException6	java.io.IOException
    //   1	124	6	localObject8	Object
    //   51	15	7	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   33	42	74	java/io/IOException
    //   47	53	74	java/io/IOException
    //   63	71	74	java/io/IOException
    //   134	141	74	java/io/IOException
    //   158	162	164	java/io/IOException
    //   148	152	190	java/io/IOException
    //   109	113	217	java/io/IOException
    //   120	124	244	java/io/IOException
    //   3	12	270	finally
    //   281	286	296	java/io/IOException
    //   290	294	323	java/io/IOException
    //   12	28	350	finally
    //   33	42	357	finally
    //   47	53	357	finally
    //   63	71	357	finally
    //   81	105	357	finally
    //   134	141	357	finally
    //   3	12	363	java/io/IOException
    //   12	28	372	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */