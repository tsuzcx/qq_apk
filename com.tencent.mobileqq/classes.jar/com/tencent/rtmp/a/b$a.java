package com.tencent.rtmp.a;

import java.lang.ref.WeakReference;

class b$a
  implements Runnable
{
  private WeakReference<b> a;
  private String b;
  
  public b$a(b paramb, String paramString)
  {
    this.a = new WeakReference(paramb);
    this.b = paramString;
  }
  
  private float a(String paramString)
  {
    Object localObject1 = paramString.split(":");
    int i = localObject1.length;
    Object localObject2 = null;
    if (i == 3)
    {
      localObject2 = localObject1[0];
      paramString = localObject1[1];
      localObject1 = localObject1[2];
    }
    else if (localObject1.length == 2)
    {
      paramString = localObject1[0];
      localObject1 = localObject1[1];
    }
    else if (localObject1.length == 1)
    {
      localObject1 = localObject1[0];
      paramString = null;
    }
    else
    {
      localObject1 = null;
      paramString = (String)localObject1;
    }
    float f2 = 0.0F;
    if (localObject2 != null) {
      f2 = 0.0F + Float.valueOf(0.0F).floatValue() * 3600.0F;
    }
    float f1 = f2;
    if (paramString != null) {
      f1 = f2 + Float.valueOf(paramString).floatValue() * 60.0F;
    }
    f2 = f1;
    if (localObject1 != null) {
      f2 = f1 + Float.valueOf((String)localObject1).floatValue();
    }
    return f2;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/rtmp/a/b$a:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 57	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 59	com/tencent/rtmp/a/b
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload 5
    //   21: aload_0
    //   22: getfield 25	com/tencent/rtmp/a/b$a:b	Ljava/lang/String;
    //   25: invokestatic 62	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;Ljava/lang/String;)Ljava/io/InputStream;
    //   28: astore 6
    //   30: aload 6
    //   32: ifnonnull +4 -> 36
    //   35: return
    //   36: aload_3
    //   37: astore_2
    //   38: new 64	java/io/BufferedReader
    //   41: dup
    //   42: new 66	java/io/InputStreamReader
    //   45: dup
    //   46: aload 6
    //   48: invokespecial 69	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   51: invokespecial 72	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 76	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +277 -> 338
    //   64: aload_2
    //   65: invokevirtual 80	java/lang/String:length	()I
    //   68: ifeq +270 -> 338
    //   71: aload_2
    //   72: ldc 82
    //   74: invokevirtual 86	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   77: ifne +6 -> 83
    //   80: goto +258 -> 338
    //   83: aload_3
    //   84: invokevirtual 76	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull +240 -> 329
    //   92: aload_2
    //   93: ldc 88
    //   95: invokevirtual 86	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   98: ifeq +231 -> 329
    //   101: aload_2
    //   102: ldc 90
    //   104: invokevirtual 35	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   107: astore 6
    //   109: aload 6
    //   111: arraylength
    //   112: iconst_2
    //   113: if_icmpeq +6 -> 119
    //   116: goto +213 -> 329
    //   119: aload_3
    //   120: invokevirtual 76	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   123: astore 7
    //   125: new 92	com/tencent/rtmp/a/c
    //   128: dup
    //   129: invokespecial 93	com/tencent/rtmp/a/c:<init>	()V
    //   132: astore 4
    //   134: aload 4
    //   136: aload_0
    //   137: aload 6
    //   139: iconst_0
    //   140: aaload
    //   141: invokespecial 95	com/tencent/rtmp/a/b$a:a	(Ljava/lang/String;)F
    //   144: putfield 98	com/tencent/rtmp/a/c:a	F
    //   147: aload 4
    //   149: aload_0
    //   150: aload 6
    //   152: iconst_1
    //   153: aaload
    //   154: invokespecial 95	com/tencent/rtmp/a/b$a:a	(Ljava/lang/String;)F
    //   157: putfield 100	com/tencent/rtmp/a/c:b	F
    //   160: aload 4
    //   162: aload 7
    //   164: putfield 103	com/tencent/rtmp/a/c:c	Ljava/lang/String;
    //   167: aload 7
    //   169: ldc 105
    //   171: invokevirtual 109	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   174: istore_1
    //   175: iload_1
    //   176: iconst_m1
    //   177: if_icmpeq +15 -> 192
    //   180: aload 4
    //   182: aload 7
    //   184: iconst_0
    //   185: iload_1
    //   186: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   189: putfield 116	com/tencent/rtmp/a/c:d	Ljava/lang/String;
    //   192: aload 7
    //   194: ldc 118
    //   196: invokevirtual 109	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   199: istore_1
    //   200: iload_1
    //   201: iconst_m1
    //   202: if_icmpeq +101 -> 303
    //   205: iload_1
    //   206: iconst_1
    //   207: iadd
    //   208: istore_1
    //   209: iload_1
    //   210: aload 7
    //   212: invokevirtual 80	java/lang/String:length	()I
    //   215: if_icmpge +88 -> 303
    //   218: aload 7
    //   220: iload_1
    //   221: aload 7
    //   223: invokevirtual 80	java/lang/String:length	()I
    //   226: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   229: ldc 120
    //   231: invokevirtual 35	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   234: astore 6
    //   236: aload 6
    //   238: arraylength
    //   239: iconst_4
    //   240: if_icmpne +63 -> 303
    //   243: aload 4
    //   245: aload 6
    //   247: iconst_0
    //   248: aaload
    //   249: invokestatic 125	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   252: invokevirtual 128	java/lang/Integer:intValue	()I
    //   255: putfield 132	com/tencent/rtmp/a/c:e	I
    //   258: aload 4
    //   260: aload 6
    //   262: iconst_1
    //   263: aaload
    //   264: invokestatic 125	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   267: invokevirtual 128	java/lang/Integer:intValue	()I
    //   270: putfield 135	com/tencent/rtmp/a/c:f	I
    //   273: aload 4
    //   275: aload 6
    //   277: iconst_2
    //   278: aaload
    //   279: invokestatic 125	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   282: invokevirtual 128	java/lang/Integer:intValue	()I
    //   285: putfield 138	com/tencent/rtmp/a/c:g	I
    //   288: aload 4
    //   290: aload 6
    //   292: iconst_3
    //   293: aaload
    //   294: invokestatic 125	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   297: invokevirtual 128	java/lang/Integer:intValue	()I
    //   300: putfield 141	com/tencent/rtmp/a/c:h	I
    //   303: aload 5
    //   305: ifnull +24 -> 329
    //   308: aload 5
    //   310: invokestatic 144	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;)Ljava/util/List;
    //   313: ifnull +16 -> 329
    //   316: aload 5
    //   318: invokestatic 144	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;)Ljava/util/List;
    //   321: aload 4
    //   323: invokeinterface 150 2 0
    //   328: pop
    //   329: aload_2
    //   330: ifnonnull -247 -> 83
    //   333: aload_3
    //   334: invokevirtual 153	java/io/BufferedReader:close	()V
    //   337: return
    //   338: ldc 155
    //   340: ldc 157
    //   342: invokestatic 162	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload 5
    //   347: ifnull +8 -> 355
    //   350: aload 5
    //   352: invokestatic 165	com/tencent/rtmp/a/b:c	(Lcom/tencent/rtmp/a/b;)V
    //   355: aload_3
    //   356: invokevirtual 153	java/io/BufferedReader:close	()V
    //   359: return
    //   360: astore_2
    //   361: goto +45 -> 406
    //   364: astore 4
    //   366: goto +20 -> 386
    //   369: astore 4
    //   371: aload_2
    //   372: astore_3
    //   373: aload 4
    //   375: astore_2
    //   376: goto +30 -> 406
    //   379: astore_2
    //   380: aload 4
    //   382: astore_3
    //   383: aload_2
    //   384: astore 4
    //   386: aload_3
    //   387: astore_2
    //   388: ldc 155
    //   390: ldc 167
    //   392: aload 4
    //   394: invokestatic 170	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   397: aload_3
    //   398: ifnull +7 -> 405
    //   401: aload_3
    //   402: invokevirtual 153	java/io/BufferedReader:close	()V
    //   405: return
    //   406: aload_3
    //   407: ifnull +7 -> 414
    //   410: aload_3
    //   411: invokevirtual 153	java/io/BufferedReader:close	()V
    //   414: goto +5 -> 419
    //   417: aload_2
    //   418: athrow
    //   419: goto -2 -> 417
    //   422: astore_2
    //   423: return
    //   424: astore_2
    //   425: return
    //   426: astore_3
    //   427: goto -13 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	a
    //   174	47	1	i	int
    //   18	312	2	localObject1	Object
    //   360	12	2	localObject2	Object
    //   375	1	2	localObject3	Object
    //   379	5	2	localIOException1	java.io.IOException
    //   387	31	2	localObject4	Object
    //   422	1	2	localIOException2	java.io.IOException
    //   424	1	2	localIOException3	java.io.IOException
    //   16	395	3	localObject5	Object
    //   426	1	3	localIOException4	java.io.IOException
    //   13	309	4	localc	c
    //   364	1	4	localIOException5	java.io.IOException
    //   369	12	4	localObject6	Object
    //   384	9	4	localObject7	Object
    //   10	341	5	localb	b
    //   28	263	6	localObject8	Object
    //   123	99	7	str	String
    // Exception table:
    //   from	to	target	type
    //   55	60	360	finally
    //   64	80	360	finally
    //   83	88	360	finally
    //   92	116	360	finally
    //   119	175	360	finally
    //   180	192	360	finally
    //   192	200	360	finally
    //   209	303	360	finally
    //   308	329	360	finally
    //   338	345	360	finally
    //   350	355	360	finally
    //   55	60	364	java/io/IOException
    //   64	80	364	java/io/IOException
    //   83	88	364	java/io/IOException
    //   92	116	364	java/io/IOException
    //   119	175	364	java/io/IOException
    //   180	192	364	java/io/IOException
    //   192	200	364	java/io/IOException
    //   209	303	364	java/io/IOException
    //   308	329	364	java/io/IOException
    //   338	345	364	java/io/IOException
    //   350	355	364	java/io/IOException
    //   19	30	369	finally
    //   38	55	369	finally
    //   388	397	369	finally
    //   19	30	379	java/io/IOException
    //   38	55	379	java/io/IOException
    //   333	337	422	java/io/IOException
    //   401	405	422	java/io/IOException
    //   355	359	424	java/io/IOException
    //   410	414	426	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.a.b.a
 * JD-Core Version:    0.7.0.1
 */