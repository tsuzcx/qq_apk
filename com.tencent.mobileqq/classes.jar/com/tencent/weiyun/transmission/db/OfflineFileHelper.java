package com.tencent.weiyun.transmission.db;

public class OfflineFileHelper
{
  private static final int DOWNLOAD_STATE_FAILED = 5;
  private static final int DOWNLOAD_STATE_INIT = 0;
  private static final int DOWNLOAD_STATE_RUNNING = 2;
  private static final int DOWNLOAD_STATE_SUCCESS = 4;
  private static final int DOWNLOAD_STATE_SUSPEND = 3;
  private static final int DOWNLOAD_STATE_WAIT = 1;
  private static final String TAG = "OfflineFileHelper";
  
  /* Error */
  public static java.util.List<String> getOfflineFilePath(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +12 -> 23
    //   14: new 38	java/util/ArrayList
    //   17: dup
    //   18: iconst_0
    //   19: invokespecial 41	java/util/ArrayList:<init>	(I)V
    //   22: areturn
    //   23: new 43	java/util/HashSet
    //   26: dup
    //   27: invokespecial 44	java/util/HashSet:<init>	()V
    //   30: astore 9
    //   32: invokestatic 50	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   35: iconst_0
    //   36: invokevirtual 54	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   39: astore 10
    //   41: aload 10
    //   43: ifnonnull +20 -> 63
    //   46: ldc 21
    //   48: ldc 56
    //   50: invokestatic 62	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: new 38	java/util/ArrayList
    //   56: dup
    //   57: aload 9
    //   59: invokespecial 65	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   62: areturn
    //   63: aload_2
    //   64: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: istore_3
    //   68: aconst_null
    //   69: astore 8
    //   71: aconst_null
    //   72: astore 7
    //   74: iload_3
    //   75: ifeq +457 -> 532
    //   78: iconst_3
    //   79: anewarray 67	java/lang/String
    //   82: astore 6
    //   84: aload 6
    //   86: iconst_0
    //   87: aload_0
    //   88: aastore
    //   89: aload 6
    //   91: iconst_1
    //   92: aload_1
    //   93: aastore
    //   94: aload 6
    //   96: iconst_2
    //   97: iconst_4
    //   98: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   101: aastore
    //   102: new 75	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   109: ldc 78
    //   111: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 84
    //   116: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 86
    //   121: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 84
    //   126: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: astore 11
    //   131: iload_3
    //   132: ifne +16 -> 148
    //   135: aload 11
    //   137: ldc 88
    //   139: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 84
    //   144: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 11
    //   150: ldc 90
    //   152: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 92
    //   157: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 7
    //   163: astore 5
    //   165: aload 8
    //   167: astore 4
    //   169: aload 11
    //   171: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 11
    //   176: aload 7
    //   178: astore 5
    //   180: aload 8
    //   182: astore 4
    //   184: aload 10
    //   186: ldc 97
    //   188: iconst_1
    //   189: anewarray 67	java/lang/String
    //   192: dup
    //   193: iconst_0
    //   194: ldc 99
    //   196: aastore
    //   197: aload 11
    //   199: aload 6
    //   201: aconst_null
    //   202: aconst_null
    //   203: ldc 101
    //   205: invokevirtual 107	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   208: astore 6
    //   210: aload 6
    //   212: ifnull +352 -> 564
    //   215: aload 6
    //   217: astore 5
    //   219: aload 6
    //   221: astore 4
    //   223: aload 6
    //   225: invokeinterface 113 1 0
    //   230: ifeq +334 -> 564
    //   233: aload 6
    //   235: astore 5
    //   237: aload 6
    //   239: astore 4
    //   241: aload 6
    //   243: iconst_0
    //   244: invokeinterface 116 2 0
    //   249: astore 7
    //   251: aload 6
    //   253: astore 5
    //   255: aload 6
    //   257: astore 4
    //   259: aload 7
    //   261: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   264: ifne -49 -> 215
    //   267: aload 6
    //   269: astore 5
    //   271: aload 6
    //   273: astore 4
    //   275: aload 9
    //   277: aload 7
    //   279: invokevirtual 120	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   282: pop
    //   283: goto -68 -> 215
    //   286: astore 6
    //   288: aload 5
    //   290: astore 4
    //   292: ldc 21
    //   294: aload 6
    //   296: invokestatic 123	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   299: aload 5
    //   301: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   304: aconst_null
    //   305: astore 5
    //   307: aconst_null
    //   308: astore 4
    //   310: iload_3
    //   311: ifeq +269 -> 580
    //   314: iconst_3
    //   315: anewarray 67	java/lang/String
    //   318: astore_2
    //   319: aload_2
    //   320: iconst_0
    //   321: aload_0
    //   322: aastore
    //   323: aload_2
    //   324: iconst_1
    //   325: aload_1
    //   326: aastore
    //   327: aload_2
    //   328: iconst_2
    //   329: iconst_5
    //   330: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   333: aastore
    //   334: new 75	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   341: ldc 78
    //   343: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc 84
    //   348: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc 86
    //   353: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc 84
    //   358: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: astore 6
    //   363: iload_3
    //   364: ifne +31 -> 395
    //   367: aload 6
    //   369: bipush 40
    //   371: invokevirtual 132	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   374: ldc 134
    //   376: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc 136
    //   381: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc 138
    //   386: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc 140
    //   391: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 6
    //   397: ldc 90
    //   399: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc 92
    //   404: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 4
    //   410: astore_1
    //   411: aload 5
    //   413: astore_0
    //   414: aload 6
    //   416: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: astore 6
    //   421: aload 4
    //   423: astore_1
    //   424: aload 5
    //   426: astore_0
    //   427: aload 10
    //   429: ldc 142
    //   431: iconst_1
    //   432: anewarray 67	java/lang/String
    //   435: dup
    //   436: iconst_0
    //   437: ldc 99
    //   439: aastore
    //   440: aload 6
    //   442: aload_2
    //   443: aconst_null
    //   444: aconst_null
    //   445: ldc 101
    //   447: invokevirtual 107	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   450: astore_2
    //   451: aload_2
    //   452: ifnull +168 -> 620
    //   455: aload_2
    //   456: astore_1
    //   457: aload_2
    //   458: astore_0
    //   459: aload_2
    //   460: invokeinterface 113 1 0
    //   465: ifeq +155 -> 620
    //   468: aload_2
    //   469: astore_1
    //   470: aload_2
    //   471: astore_0
    //   472: aload_2
    //   473: iconst_0
    //   474: invokeinterface 116 2 0
    //   479: astore 4
    //   481: aload_2
    //   482: astore_1
    //   483: aload_2
    //   484: astore_0
    //   485: aload 4
    //   487: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   490: ifne -35 -> 455
    //   493: aload_2
    //   494: astore_1
    //   495: aload_2
    //   496: astore_0
    //   497: aload 9
    //   499: aload 4
    //   501: invokevirtual 120	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   504: pop
    //   505: goto -50 -> 455
    //   508: astore_2
    //   509: aload_1
    //   510: astore_0
    //   511: ldc 21
    //   513: aload_2
    //   514: invokestatic 123	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   517: aload_1
    //   518: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   521: invokestatic 50	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   524: aload 10
    //   526: invokevirtual 146	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   529: goto -476 -> 53
    //   532: iconst_4
    //   533: anewarray 67	java/lang/String
    //   536: astore 6
    //   538: aload 6
    //   540: iconst_0
    //   541: aload_0
    //   542: aastore
    //   543: aload 6
    //   545: iconst_1
    //   546: aload_1
    //   547: aastore
    //   548: aload 6
    //   550: iconst_2
    //   551: aload_2
    //   552: aastore
    //   553: aload 6
    //   555: iconst_3
    //   556: iconst_4
    //   557: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   560: aastore
    //   561: goto -459 -> 102
    //   564: aload 6
    //   566: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   569: goto -265 -> 304
    //   572: astore_0
    //   573: aload 4
    //   575: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   578: aload_0
    //   579: athrow
    //   580: iconst_5
    //   581: anewarray 67	java/lang/String
    //   584: astore 6
    //   586: aload 6
    //   588: iconst_0
    //   589: aload_0
    //   590: aastore
    //   591: aload 6
    //   593: iconst_1
    //   594: aload_1
    //   595: aastore
    //   596: aload 6
    //   598: iconst_2
    //   599: aload_2
    //   600: aastore
    //   601: aload 6
    //   603: iconst_3
    //   604: aload_2
    //   605: aastore
    //   606: aload 6
    //   608: iconst_4
    //   609: iconst_5
    //   610: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   613: aastore
    //   614: aload 6
    //   616: astore_2
    //   617: goto -283 -> 334
    //   620: aload_2
    //   621: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   624: goto -103 -> 521
    //   627: astore_1
    //   628: aload_0
    //   629: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   632: aload_1
    //   633: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	paramString1	String
    //   0	634	1	paramString2	String
    //   0	634	2	paramString3	String
    //   67	297	3	bool	boolean
    //   167	407	4	localObject1	Object
    //   163	262	5	localObject2	Object
    //   82	190	6	localObject3	Object
    //   286	9	6	localThrowable	java.lang.Throwable
    //   361	254	6	localObject4	Object
    //   72	206	7	str	String
    //   69	112	8	localObject5	Object
    //   30	468	9	localHashSet	java.util.HashSet
    //   39	486	10	localJobDbWrapper	JobDbWrapper
    //   129	69	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   169	176	286	java/lang/Throwable
    //   184	210	286	java/lang/Throwable
    //   223	233	286	java/lang/Throwable
    //   241	251	286	java/lang/Throwable
    //   259	267	286	java/lang/Throwable
    //   275	283	286	java/lang/Throwable
    //   414	421	508	java/lang/Throwable
    //   427	451	508	java/lang/Throwable
    //   459	468	508	java/lang/Throwable
    //   472	481	508	java/lang/Throwable
    //   485	493	508	java/lang/Throwable
    //   497	505	508	java/lang/Throwable
    //   169	176	572	finally
    //   184	210	572	finally
    //   223	233	572	finally
    //   241	251	572	finally
    //   259	267	572	finally
    //   275	283	572	finally
    //   292	299	572	finally
    //   414	421	627	finally
    //   427	451	627	finally
    //   459	468	627	finally
    //   472	481	627	finally
    //   485	493	627	finally
    //   497	505	627	finally
    //   511	517	627	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.db.OfflineFileHelper
 * JD-Core Version:    0.7.0.1
 */