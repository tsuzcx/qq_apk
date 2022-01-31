package com.tencent.qgplayer.rtmpsdk.c;

import java.io.BufferedReader;

public class d
{
  private float a = 0.0F;
  private float b = 0.0F;
  private float c = 0.0F;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(Math.min(paramFloat1, paramFloat3), paramFloat2);
  }
  
  private static float a(String[] paramArrayOfString, Integer... paramVarArgs)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (paramArrayOfString == null) {
      return f2;
    }
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      f2 = f1;
      if (i >= j) {
        break;
      }
      int k = paramVarArgs[i].intValue();
      f1 = (float)(f1 + Double.parseDouble(paramArrayOfString[k]));
      i += 1;
    }
  }
  
  private static String[] a(BufferedReader paramBufferedReader, int paramInt)
  {
    paramBufferedReader = paramBufferedReader.readLine();
    if (paramBufferedReader != null) {
      return paramBufferedReader.split("[ ]+", paramInt);
    }
    return null;
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 9
    //   9: aload 6
    //   11: astore 7
    //   13: getstatic 65	android/os/Build$VERSION:SDK_INT	I
    //   16: bipush 26
    //   18: if_icmpge +692 -> 710
    //   21: aload 6
    //   23: astore 7
    //   25: new 67	java/io/File
    //   28: dup
    //   29: ldc 69
    //   31: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 9
    //   36: aload 6
    //   38: astore 7
    //   40: aload 9
    //   42: invokevirtual 76	java/io/File:exists	()Z
    //   45: ifeq +15 -> 60
    //   48: aload 6
    //   50: astore 7
    //   52: aload 9
    //   54: invokevirtual 79	java/io/File:canRead	()Z
    //   57: ifne +41 -> 98
    //   60: aload 6
    //   62: astore 7
    //   64: ldc 81
    //   66: new 83	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   73: ldc 86
    //   75: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload 9
    //   80: invokevirtual 93	java/io/File:getPath	()Ljava/lang/String;
    //   83: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 95
    //   88: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 104	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aload 6
    //   100: astore 7
    //   102: new 45	java/io/BufferedReader
    //   105: dup
    //   106: new 106	java/io/FileReader
    //   109: dup
    //   110: aload 9
    //   112: invokespecial 109	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   115: sipush 8192
    //   118: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   121: astore 6
    //   123: aload 6
    //   125: bipush 9
    //   127: invokestatic 114	com/tencent/qgplayer/rtmpsdk/c/d:a	(Ljava/io/BufferedReader;I)[Ljava/lang/String;
    //   130: astore 7
    //   132: aload 7
    //   134: iconst_3
    //   135: anewarray 32	java/lang/Integer
    //   138: dup
    //   139: iconst_0
    //   140: iconst_1
    //   141: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: iconst_2
    //   148: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: dup
    //   153: iconst_2
    //   154: iconst_3
    //   155: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: invokestatic 120	com/tencent/qgplayer/rtmpsdk/c/d:a	([Ljava/lang/String;[Ljava/lang/Integer;)F
    //   162: fstore_1
    //   163: aload 7
    //   165: iconst_4
    //   166: anewarray 32	java/lang/Integer
    //   169: dup
    //   170: iconst_0
    //   171: iconst_4
    //   172: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: iconst_5
    //   179: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: bipush 6
    //   187: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: dup
    //   192: iconst_3
    //   193: bipush 7
    //   195: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: invokestatic 120	com/tencent/qgplayer/rtmpsdk/c/d:a	([Ljava/lang/String;[Ljava/lang/Integer;)F
    //   202: fstore_2
    //   203: fload_2
    //   204: fload_1
    //   205: fadd
    //   206: fstore_2
    //   207: aload 6
    //   209: ifnull +8 -> 217
    //   212: aload 6
    //   214: invokevirtual 123	java/io/BufferedReader:close	()V
    //   217: fload_2
    //   218: fstore_3
    //   219: fload_1
    //   220: fstore_2
    //   221: aconst_null
    //   222: astore 7
    //   224: aconst_null
    //   225: astore 8
    //   227: aload 7
    //   229: astore 6
    //   231: new 67	java/io/File
    //   234: dup
    //   235: invokestatic 129	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   238: ldc 131
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: invokestatic 136	android/os/Process:myPid	()I
    //   249: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aastore
    //   253: invokestatic 140	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   256: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   259: astore 9
    //   261: aload 7
    //   263: astore 6
    //   265: aload 9
    //   267: invokevirtual 76	java/io/File:exists	()Z
    //   270: ifeq +15 -> 285
    //   273: aload 7
    //   275: astore 6
    //   277: aload 9
    //   279: invokevirtual 79	java/io/File:canRead	()Z
    //   282: ifne +41 -> 323
    //   285: aload 7
    //   287: astore 6
    //   289: ldc 81
    //   291: new 83	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   298: ldc 86
    //   300: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 9
    //   305: invokevirtual 93	java/io/File:getPath	()Ljava/lang/String;
    //   308: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc 95
    //   313: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 104	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   322: pop
    //   323: aload 7
    //   325: astore 6
    //   327: new 45	java/io/BufferedReader
    //   330: dup
    //   331: new 106	java/io/FileReader
    //   334: dup
    //   335: aload 9
    //   337: invokespecial 109	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   340: sipush 8192
    //   343: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   346: astore 7
    //   348: aload 7
    //   350: bipush 18
    //   352: invokestatic 114	com/tencent/qgplayer/rtmpsdk/c/d:a	(Ljava/io/BufferedReader;I)[Ljava/lang/String;
    //   355: iconst_4
    //   356: anewarray 32	java/lang/Integer
    //   359: dup
    //   360: iconst_0
    //   361: bipush 13
    //   363: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: aastore
    //   367: dup
    //   368: iconst_1
    //   369: bipush 14
    //   371: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: aastore
    //   375: dup
    //   376: iconst_2
    //   377: bipush 15
    //   379: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   382: aastore
    //   383: dup
    //   384: iconst_3
    //   385: bipush 16
    //   387: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: aastore
    //   391: invokestatic 120	com/tencent/qgplayer/rtmpsdk/c/d:a	([Ljava/lang/String;[Ljava/lang/Integer;)F
    //   394: fstore 4
    //   396: fload 4
    //   398: fstore_1
    //   399: aload 7
    //   401: ifnull +11 -> 412
    //   404: aload 7
    //   406: invokevirtual 123	java/io/BufferedReader:close	()V
    //   409: fload 4
    //   411: fstore_1
    //   412: aload_0
    //   413: getfield 14	com/tencent/qgplayer/rtmpsdk/c/d:a	F
    //   416: fconst_0
    //   417: fcmpl
    //   418: ifeq +206 -> 624
    //   421: fload_3
    //   422: aload_0
    //   423: getfield 14	com/tencent/qgplayer/rtmpsdk/c/d:a	F
    //   426: fsub
    //   427: fstore_3
    //   428: aload_0
    //   429: getfield 16	com/tencent/qgplayer/rtmpsdk/c/d:b	F
    //   432: fstore 5
    //   434: aload_0
    //   435: getfield 18	com/tencent/qgplayer/rtmpsdk/c/d:c	F
    //   438: fstore 4
    //   440: fload_2
    //   441: fload 5
    //   443: fsub
    //   444: ldc 141
    //   446: fmul
    //   447: fload_3
    //   448: fdiv
    //   449: fconst_0
    //   450: ldc 141
    //   452: invokestatic 143	com/tencent/qgplayer/rtmpsdk/c/d:a	(FFF)F
    //   455: fstore_2
    //   456: fload_1
    //   457: fload 4
    //   459: fsub
    //   460: ldc 141
    //   462: fmul
    //   463: fload_3
    //   464: fdiv
    //   465: fconst_0
    //   466: ldc 141
    //   468: invokestatic 143	com/tencent/qgplayer/rtmpsdk/c/d:a	(FFF)F
    //   471: fstore_1
    //   472: new 83	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   479: fload_1
    //   480: invokestatic 147	java/lang/Math:round	(F)I
    //   483: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   486: ldc 152
    //   488: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: fload_2
    //   492: invokestatic 147	java/lang/Math:round	(F)I
    //   495: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: ldc 154
    //   500: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: areturn
    //   507: astore 7
    //   509: fconst_0
    //   510: fstore_1
    //   511: aload 8
    //   513: astore 6
    //   515: aload 7
    //   517: astore 8
    //   519: aload 6
    //   521: astore 7
    //   523: aload 8
    //   525: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   528: aload 6
    //   530: ifnull +8 -> 538
    //   533: aload 6
    //   535: invokevirtual 123	java/io/BufferedReader:close	()V
    //   538: fconst_0
    //   539: fstore_3
    //   540: fload_1
    //   541: fstore_2
    //   542: goto -321 -> 221
    //   545: astore 6
    //   547: aload 7
    //   549: ifnull +8 -> 557
    //   552: aload 7
    //   554: invokevirtual 123	java/io/BufferedReader:close	()V
    //   557: aload 6
    //   559: athrow
    //   560: astore 6
    //   562: aload 8
    //   564: astore 7
    //   566: aload 6
    //   568: astore 8
    //   570: aload 7
    //   572: astore 6
    //   574: aload 8
    //   576: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   579: aload 7
    //   581: ifnull +124 -> 705
    //   584: aload 7
    //   586: invokevirtual 123	java/io/BufferedReader:close	()V
    //   589: fconst_0
    //   590: fstore_1
    //   591: goto -179 -> 412
    //   594: astore 6
    //   596: fconst_0
    //   597: fstore_1
    //   598: goto -186 -> 412
    //   601: astore 8
    //   603: aload 6
    //   605: astore 7
    //   607: aload 8
    //   609: astore 6
    //   611: aload 7
    //   613: ifnull +8 -> 621
    //   616: aload 7
    //   618: invokevirtual 123	java/io/BufferedReader:close	()V
    //   621: aload 6
    //   623: athrow
    //   624: aload_0
    //   625: fload_3
    //   626: putfield 14	com/tencent/qgplayer/rtmpsdk/c/d:a	F
    //   629: aload_0
    //   630: fload_2
    //   631: putfield 16	com/tencent/qgplayer/rtmpsdk/c/d:b	F
    //   634: aload_0
    //   635: fload_1
    //   636: putfield 18	com/tencent/qgplayer/rtmpsdk/c/d:c	F
    //   639: ldc 159
    //   641: areturn
    //   642: astore 6
    //   644: goto -427 -> 217
    //   647: astore 6
    //   649: goto -111 -> 538
    //   652: astore 7
    //   654: goto -97 -> 557
    //   657: astore 6
    //   659: fload 4
    //   661: fstore_1
    //   662: goto -250 -> 412
    //   665: astore 7
    //   667: goto -46 -> 621
    //   670: astore 6
    //   672: goto -61 -> 611
    //   675: astore 8
    //   677: goto -107 -> 570
    //   680: astore 8
    //   682: aload 6
    //   684: astore 7
    //   686: aload 8
    //   688: astore 6
    //   690: goto -143 -> 547
    //   693: astore 8
    //   695: fconst_0
    //   696: fstore_1
    //   697: goto -178 -> 519
    //   700: astore 8
    //   702: goto -183 -> 519
    //   705: fconst_0
    //   706: fstore_1
    //   707: goto -295 -> 412
    //   710: fconst_0
    //   711: fstore_2
    //   712: fconst_0
    //   713: fstore_1
    //   714: aload 9
    //   716: astore 6
    //   718: goto -511 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	d
    //   162	552	1	f1	float
    //   202	510	2	f2	float
    //   218	408	3	f3	float
    //   394	266	4	f4	float
    //   432	10	5	f5	float
    //   4	530	6	localObject1	Object
    //   545	13	6	localObject2	Object
    //   560	7	6	localIOException1	java.io.IOException
    //   572	1	6	localObject3	Object
    //   594	10	6	localIOException2	java.io.IOException
    //   609	13	6	localObject4	Object
    //   642	1	6	localIOException3	java.io.IOException
    //   647	1	6	localIOException4	java.io.IOException
    //   657	1	6	localIOException5	java.io.IOException
    //   670	13	6	localObject5	Object
    //   688	29	6	localObject6	Object
    //   11	394	7	localObject7	Object
    //   507	9	7	localIOException6	java.io.IOException
    //   521	96	7	localObject8	Object
    //   652	1	7	localIOException7	java.io.IOException
    //   665	1	7	localIOException8	java.io.IOException
    //   684	1	7	localObject9	Object
    //   1	574	8	localObject10	Object
    //   601	7	8	localObject11	Object
    //   675	1	8	localIOException9	java.io.IOException
    //   680	7	8	localObject12	Object
    //   693	1	8	localIOException10	java.io.IOException
    //   700	1	8	localIOException11	java.io.IOException
    //   7	708	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   13	21	507	java/io/IOException
    //   25	36	507	java/io/IOException
    //   40	48	507	java/io/IOException
    //   52	60	507	java/io/IOException
    //   64	98	507	java/io/IOException
    //   102	123	507	java/io/IOException
    //   13	21	545	finally
    //   25	36	545	finally
    //   40	48	545	finally
    //   52	60	545	finally
    //   64	98	545	finally
    //   102	123	545	finally
    //   523	528	545	finally
    //   231	261	560	java/io/IOException
    //   265	273	560	java/io/IOException
    //   277	285	560	java/io/IOException
    //   289	323	560	java/io/IOException
    //   327	348	560	java/io/IOException
    //   584	589	594	java/io/IOException
    //   231	261	601	finally
    //   265	273	601	finally
    //   277	285	601	finally
    //   289	323	601	finally
    //   327	348	601	finally
    //   574	579	601	finally
    //   212	217	642	java/io/IOException
    //   533	538	647	java/io/IOException
    //   552	557	652	java/io/IOException
    //   404	409	657	java/io/IOException
    //   616	621	665	java/io/IOException
    //   348	396	670	finally
    //   348	396	675	java/io/IOException
    //   123	163	680	finally
    //   163	203	680	finally
    //   123	163	693	java/io/IOException
    //   163	203	700	java/io/IOException
  }
  
  public void b()
  {
    this.a = 0.0F;
    this.b = 0.0F;
    this.c = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.c.d
 * JD-Core Version:    0.7.0.1
 */