package com.tencent.qqperf.monitor.crash.tools;

public class ThreadInfoRecordHelper
{
  /* Error */
  public static void a(java.lang.StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 17	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 20
    //   13: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 4
    //   19: invokestatic 30	android/os/Process:myPid	()I
    //   22: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 4
    //   28: ldc 35
    //   30: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 4
    //   36: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 8
    //   41: aload_0
    //   42: ldc 41
    //   44: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_0
    //   49: ldc 43
    //   51: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   58: lstore_2
    //   59: new 51	java/io/File
    //   62: dup
    //   63: aload 8
    //   65: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: invokevirtual 58	java/io/File:list	()[Ljava/lang/String;
    //   71: astore 7
    //   73: new 60	java/util/HashMap
    //   76: dup
    //   77: invokespecial 61	java/util/HashMap:<init>	()V
    //   80: astore 9
    //   82: iconst_0
    //   83: istore_1
    //   84: aconst_null
    //   85: astore 4
    //   87: iload_1
    //   88: aload 7
    //   90: arraylength
    //   91: if_icmpge +302 -> 393
    //   94: new 17	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   101: astore 5
    //   103: aload 5
    //   105: aload 8
    //   107: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 5
    //   113: ldc 63
    //   115: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 5
    //   121: aload 7
    //   123: iload_1
    //   124: aaload
    //   125: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 5
    //   131: ldc 65
    //   133: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: new 51	java/io/File
    //   140: dup
    //   141: aload 5
    //   143: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 6
    //   151: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   154: lload_2
    //   155: lsub
    //   156: ldc2_w 66
    //   159: lcmp
    //   160: ifle +34 -> 194
    //   163: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +227 -> 393
    //   169: ldc 75
    //   171: iconst_2
    //   172: iconst_2
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: ldc 77
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: aload_0
    //   184: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aastore
    //   188: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   191: goto +202 -> 393
    //   194: aload 4
    //   196: astore 5
    //   198: aload 6
    //   200: invokevirtual 84	java/io/File:exists	()Z
    //   203: ifeq +179 -> 382
    //   206: new 86	java/io/BufferedReader
    //   209: dup
    //   210: new 88	java/io/FileReader
    //   213: dup
    //   214: aload 6
    //   216: invokespecial 91	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   219: bipush 64
    //   221: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   224: astore 5
    //   226: aload 5
    //   228: astore 4
    //   230: aload 5
    //   232: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   235: astore 6
    //   237: aload 6
    //   239: ifnull +422 -> 661
    //   242: aload 5
    //   244: astore 4
    //   246: aload 6
    //   248: ldc 99
    //   250: invokevirtual 105	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   253: ifeq -27 -> 226
    //   256: aload 5
    //   258: astore 4
    //   260: aload 6
    //   262: ldc 107
    //   264: invokevirtual 111	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   267: iconst_1
    //   268: aaload
    //   269: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   272: astore 6
    //   274: goto +3 -> 277
    //   277: aload 5
    //   279: astore 4
    //   281: aload 9
    //   283: aload 6
    //   285: invokevirtual 118	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   288: ifeq +36 -> 324
    //   291: aload 5
    //   293: astore 4
    //   295: aload 9
    //   297: aload 6
    //   299: aload 9
    //   301: aload 6
    //   303: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 124	java/lang/Integer
    //   309: invokevirtual 127	java/lang/Integer:intValue	()I
    //   312: iconst_1
    //   313: iadd
    //   314: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: invokevirtual 135	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   320: pop
    //   321: goto +19 -> 340
    //   324: aload 5
    //   326: astore 4
    //   328: aload 9
    //   330: aload 6
    //   332: iconst_1
    //   333: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: invokevirtual 135	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: aload 5
    //   342: astore 4
    //   344: aload 5
    //   346: invokevirtual 138	java/io/BufferedReader:close	()V
    //   349: aconst_null
    //   350: astore 5
    //   352: goto +30 -> 382
    //   355: astore 6
    //   357: aload 5
    //   359: astore 4
    //   361: ldc 75
    //   363: iconst_2
    //   364: ldc 140
    //   366: aload 6
    //   368: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: goto +11 -> 382
    //   374: astore 6
    //   376: aload 5
    //   378: astore_0
    //   379: goto +215 -> 594
    //   382: iload_1
    //   383: iconst_1
    //   384: iadd
    //   385: istore_1
    //   386: aload 5
    //   388: astore 4
    //   390: goto -303 -> 87
    //   393: aload 9
    //   395: invokevirtual 148	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   398: invokeinterface 154 1 0
    //   403: astore 5
    //   405: aload 5
    //   407: invokeinterface 159 1 0
    //   412: ifeq +66 -> 478
    //   415: aload 5
    //   417: invokeinterface 163 1 0
    //   422: checkcast 165	java/util/Map$Entry
    //   425: astore 6
    //   427: aload_0
    //   428: aload 6
    //   430: invokeinterface 168 1 0
    //   435: checkcast 101	java/lang/String
    //   438: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload_0
    //   443: ldc 170
    //   445: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_0
    //   450: aload 6
    //   452: invokeinterface 173 1 0
    //   457: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload_0
    //   462: ldc 178
    //   464: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_0
    //   469: ldc 180
    //   471: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: goto -70 -> 405
    //   478: aload_0
    //   479: ldc 182
    //   481: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_0
    //   486: aload 7
    //   488: arraylength
    //   489: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: invokestatic 187	com/tencent/mobileqq/app/ThreadLog:needRecordJob	()Z
    //   496: ifeq +20 -> 516
    //   499: aload 7
    //   501: arraylength
    //   502: sipush 200
    //   505: if_icmple +11 -> 516
    //   508: aload_0
    //   509: invokestatic 192	com/tencent/mobileqq/app/ThreadManager:reportCurrentState	()Ljava/lang/String;
    //   512: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +41 -> 560
    //   522: ldc 75
    //   524: iconst_2
    //   525: iconst_4
    //   526: anewarray 4	java/lang/Object
    //   529: dup
    //   530: iconst_0
    //   531: ldc 194
    //   533: aastore
    //   534: dup
    //   535: iconst_1
    //   536: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   539: lload_2
    //   540: lsub
    //   541: invokestatic 199	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   544: aastore
    //   545: dup
    //   546: iconst_2
    //   547: ldc 201
    //   549: aastore
    //   550: dup
    //   551: iconst_3
    //   552: aload_0
    //   553: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: aastore
    //   557: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   560: aload 4
    //   562: ifnull +64 -> 626
    //   565: aload 4
    //   567: invokevirtual 138	java/io/BufferedReader:close	()V
    //   570: return
    //   571: astore_0
    //   572: goto +56 -> 628
    //   575: astore 6
    //   577: aload 4
    //   579: astore_0
    //   580: goto +14 -> 594
    //   583: astore_0
    //   584: aconst_null
    //   585: astore 4
    //   587: goto +41 -> 628
    //   590: astore 6
    //   592: aconst_null
    //   593: astore_0
    //   594: aload_0
    //   595: astore 4
    //   597: ldc 75
    //   599: iconst_2
    //   600: ldc 140
    //   602: aload 6
    //   604: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   607: aload_0
    //   608: ifnull +18 -> 626
    //   611: aload_0
    //   612: invokevirtual 138	java/io/BufferedReader:close	()V
    //   615: return
    //   616: astore_0
    //   617: ldc 75
    //   619: iconst_2
    //   620: ldc 140
    //   622: aload_0
    //   623: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   626: return
    //   627: astore_0
    //   628: aload 4
    //   630: ifnull +23 -> 653
    //   633: aload 4
    //   635: invokevirtual 138	java/io/BufferedReader:close	()V
    //   638: goto +15 -> 653
    //   641: astore 4
    //   643: ldc 75
    //   645: iconst_2
    //   646: ldc 140
    //   648: aload 4
    //   650: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   653: goto +5 -> 658
    //   656: aload_0
    //   657: athrow
    //   658: goto -2 -> 656
    //   661: aconst_null
    //   662: astore 6
    //   664: goto -387 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	paramStringBuilder	java.lang.StringBuilder
    //   83	303	1	i	int
    //   58	482	2	l	long
    //   7	627	4	localObject1	Object
    //   641	8	4	localIOException1	java.io.IOException
    //   101	315	5	localObject2	Object
    //   149	182	6	localObject3	Object
    //   355	12	6	localIOException2	java.io.IOException
    //   374	1	6	localException1	java.lang.Exception
    //   425	26	6	localEntry	java.util.Map.Entry
    //   575	1	6	localException2	java.lang.Exception
    //   590	13	6	localException3	java.lang.Exception
    //   662	1	6	localObject4	Object
    //   71	429	7	arrayOfString	java.lang.String[]
    //   39	67	8	str	java.lang.String
    //   80	314	9	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   344	349	355	java/io/IOException
    //   230	237	374	java/lang/Exception
    //   246	256	374	java/lang/Exception
    //   260	274	374	java/lang/Exception
    //   281	291	374	java/lang/Exception
    //   295	321	374	java/lang/Exception
    //   328	340	374	java/lang/Exception
    //   344	349	374	java/lang/Exception
    //   361	371	374	java/lang/Exception
    //   87	191	571	finally
    //   198	226	571	finally
    //   393	405	571	finally
    //   405	475	571	finally
    //   478	516	571	finally
    //   516	560	571	finally
    //   87	191	575	java/lang/Exception
    //   198	226	575	java/lang/Exception
    //   393	405	575	java/lang/Exception
    //   405	475	575	java/lang/Exception
    //   478	516	575	java/lang/Exception
    //   516	560	575	java/lang/Exception
    //   59	82	583	finally
    //   59	82	590	java/lang/Exception
    //   565	570	616	java/io/IOException
    //   611	615	616	java/io/IOException
    //   230	237	627	finally
    //   246	256	627	finally
    //   260	274	627	finally
    //   281	291	627	finally
    //   295	321	627	finally
    //   328	340	627	finally
    //   344	349	627	finally
    //   361	371	627	finally
    //   597	607	627	finally
    //   633	638	641	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.ThreadInfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */