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
    //   4: ifne +644 -> 648
    //   7: aload_1
    //   8: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +6 -> 17
    //   14: goto +634 -> 648
    //   17: new 38	java/util/HashSet
    //   20: dup
    //   21: invokespecial 39	java/util/HashSet:<init>	()V
    //   24: astore 9
    //   26: invokestatic 45	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   29: iconst_0
    //   30: invokevirtual 49	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   33: astore 10
    //   35: aload 10
    //   37: ifnonnull +13 -> 50
    //   40: ldc 21
    //   42: ldc 51
    //   44: invokestatic 57	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: goto +575 -> 622
    //   50: aload_2
    //   51: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: istore_3
    //   55: iload_3
    //   56: ifeq +30 -> 86
    //   59: iconst_3
    //   60: anewarray 59	java/lang/String
    //   63: astore 4
    //   65: aload 4
    //   67: iconst_0
    //   68: aload_0
    //   69: aastore
    //   70: aload 4
    //   72: iconst_1
    //   73: aload_1
    //   74: aastore
    //   75: aload 4
    //   77: iconst_2
    //   78: iconst_4
    //   79: invokestatic 65	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   82: aastore
    //   83: goto +32 -> 115
    //   86: iconst_4
    //   87: anewarray 59	java/lang/String
    //   90: astore 4
    //   92: aload 4
    //   94: iconst_0
    //   95: aload_0
    //   96: aastore
    //   97: aload 4
    //   99: iconst_1
    //   100: aload_1
    //   101: aastore
    //   102: aload 4
    //   104: iconst_2
    //   105: aload_2
    //   106: aastore
    //   107: aload 4
    //   109: iconst_3
    //   110: iconst_4
    //   111: invokestatic 65	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   114: aastore
    //   115: new 67	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   122: astore 6
    //   124: aload 6
    //   126: ldc 70
    //   128: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 6
    //   134: ldc 76
    //   136: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 6
    //   142: ldc 78
    //   144: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 6
    //   150: ldc 76
    //   152: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: iload_3
    //   157: ifne +19 -> 176
    //   160: aload 6
    //   162: ldc 80
    //   164: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 6
    //   170: ldc 76
    //   172: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 6
    //   178: ldc 82
    //   180: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 6
    //   186: ldc 84
    //   188: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aconst_null
    //   193: astore 7
    //   195: aconst_null
    //   196: astore 5
    //   198: aconst_null
    //   199: astore 8
    //   201: aload 6
    //   203: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore 6
    //   208: aload 10
    //   210: ldc 89
    //   212: iconst_1
    //   213: anewarray 59	java/lang/String
    //   216: dup
    //   217: iconst_0
    //   218: ldc 91
    //   220: aastore
    //   221: aload 6
    //   223: aload 4
    //   225: aconst_null
    //   226: aconst_null
    //   227: ldc 93
    //   229: invokevirtual 99	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   232: astore 4
    //   234: aload 4
    //   236: astore 6
    //   238: aload 4
    //   240: ifnull +103 -> 343
    //   243: aload 4
    //   245: astore 6
    //   247: aload 4
    //   249: astore 5
    //   251: aload 4
    //   253: invokeinterface 105 1 0
    //   258: ifeq +85 -> 343
    //   261: aload 4
    //   263: astore 5
    //   265: aload 4
    //   267: iconst_0
    //   268: invokeinterface 108 2 0
    //   273: astore 6
    //   275: aload 4
    //   277: astore 5
    //   279: aload 6
    //   281: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   284: ifne -41 -> 243
    //   287: aload 4
    //   289: astore 5
    //   291: aload 9
    //   293: aload 6
    //   295: invokevirtual 112	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   298: pop
    //   299: goto -56 -> 243
    //   302: astore 6
    //   304: goto +24 -> 328
    //   307: astore 5
    //   309: goto +12 -> 321
    //   312: astore_0
    //   313: aload 5
    //   315: astore_1
    //   316: goto +326 -> 642
    //   319: astore 5
    //   321: aconst_null
    //   322: astore 4
    //   324: aload 5
    //   326: astore 6
    //   328: aload 4
    //   330: astore 5
    //   332: ldc 21
    //   334: aload 6
    //   336: invokestatic 115	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   339: aload 4
    //   341: astore 6
    //   343: aload 6
    //   345: invokestatic 121	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   348: iload_3
    //   349: ifeq +28 -> 377
    //   352: iconst_3
    //   353: anewarray 59	java/lang/String
    //   356: astore_2
    //   357: aload_2
    //   358: iconst_0
    //   359: aload_0
    //   360: aastore
    //   361: aload_2
    //   362: iconst_1
    //   363: aload_1
    //   364: aastore
    //   365: aload_2
    //   366: iconst_2
    //   367: iconst_5
    //   368: invokestatic 65	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   371: aastore
    //   372: aload_2
    //   373: astore_1
    //   374: goto +40 -> 414
    //   377: iconst_5
    //   378: anewarray 59	java/lang/String
    //   381: astore 4
    //   383: aload 4
    //   385: iconst_0
    //   386: aload_0
    //   387: aastore
    //   388: aload 4
    //   390: iconst_1
    //   391: aload_1
    //   392: aastore
    //   393: aload 4
    //   395: iconst_2
    //   396: aload_2
    //   397: aastore
    //   398: aload 4
    //   400: iconst_3
    //   401: aload_2
    //   402: aastore
    //   403: aload 4
    //   405: iconst_4
    //   406: iconst_5
    //   407: invokestatic 65	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   410: aastore
    //   411: aload 4
    //   413: astore_1
    //   414: new 67	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   421: astore_2
    //   422: aload_2
    //   423: ldc 70
    //   425: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_2
    //   430: ldc 76
    //   432: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_2
    //   437: ldc 78
    //   439: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload_2
    //   444: ldc 76
    //   446: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: iload_3
    //   451: ifne +38 -> 489
    //   454: aload_2
    //   455: bipush 40
    //   457: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload_2
    //   462: ldc 126
    //   464: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_2
    //   469: ldc 128
    //   471: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_2
    //   476: ldc 130
    //   478: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_2
    //   483: ldc 132
    //   485: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload_2
    //   490: ldc 82
    //   492: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload_2
    //   497: ldc 84
    //   499: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 8
    //   505: astore_0
    //   506: aload_2
    //   507: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: astore_2
    //   511: aload 8
    //   513: astore_0
    //   514: aload 10
    //   516: ldc 134
    //   518: iconst_1
    //   519: anewarray 59	java/lang/String
    //   522: dup
    //   523: iconst_0
    //   524: ldc 91
    //   526: aastore
    //   527: aload_2
    //   528: aload_1
    //   529: aconst_null
    //   530: aconst_null
    //   531: ldc 93
    //   533: invokevirtual 99	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   536: astore_1
    //   537: aload_1
    //   538: ifnull +49 -> 587
    //   541: aload_1
    //   542: invokeinterface 105 1 0
    //   547: ifeq +40 -> 587
    //   550: aload_1
    //   551: iconst_0
    //   552: invokeinterface 108 2 0
    //   557: astore_0
    //   558: aload_0
    //   559: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   562: ifne -21 -> 541
    //   565: aload 9
    //   567: aload_0
    //   568: invokevirtual 112	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   571: pop
    //   572: goto -31 -> 541
    //   575: astore_2
    //   576: aload_1
    //   577: astore_0
    //   578: aload_2
    //   579: astore_1
    //   580: goto +52 -> 632
    //   583: astore_2
    //   584: goto +18 -> 602
    //   587: aload_1
    //   588: invokestatic 121	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   591: goto +23 -> 614
    //   594: astore_1
    //   595: goto +37 -> 632
    //   598: astore_2
    //   599: aload 7
    //   601: astore_1
    //   602: aload_1
    //   603: astore_0
    //   604: ldc 21
    //   606: aload_2
    //   607: invokestatic 115	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   610: aload_1
    //   611: invokestatic 121	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   614: invokestatic 45	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   617: aload 10
    //   619: invokevirtual 138	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   622: new 140	java/util/ArrayList
    //   625: dup
    //   626: aload 9
    //   628: invokespecial 143	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   631: areturn
    //   632: aload_0
    //   633: invokestatic 121	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   636: aload_1
    //   637: athrow
    //   638: astore_0
    //   639: aload 5
    //   641: astore_1
    //   642: aload_1
    //   643: invokestatic 121	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   646: aload_0
    //   647: athrow
    //   648: new 140	java/util/ArrayList
    //   651: dup
    //   652: iconst_0
    //   653: invokespecial 146	java/util/ArrayList:<init>	(I)V
    //   656: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	paramString1	String
    //   0	657	1	paramString2	String
    //   0	657	2	paramString3	String
    //   54	397	3	bool	boolean
    //   63	349	4	localObject1	Object
    //   196	94	5	localObject2	Object
    //   307	7	5	localThrowable1	java.lang.Throwable
    //   319	6	5	localThrowable2	java.lang.Throwable
    //   330	310	5	localObject3	Object
    //   122	172	6	localObject4	Object
    //   302	1	6	localThrowable3	java.lang.Throwable
    //   326	18	6	localObject5	Object
    //   193	407	7	localObject6	Object
    //   199	313	8	localObject7	Object
    //   24	603	9	localHashSet	java.util.HashSet
    //   33	585	10	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   251	261	302	java/lang/Throwable
    //   265	275	302	java/lang/Throwable
    //   279	287	302	java/lang/Throwable
    //   291	299	302	java/lang/Throwable
    //   208	234	307	java/lang/Throwable
    //   201	208	312	finally
    //   208	234	312	finally
    //   201	208	319	java/lang/Throwable
    //   541	572	575	finally
    //   541	572	583	java/lang/Throwable
    //   506	511	594	finally
    //   514	537	594	finally
    //   604	610	594	finally
    //   506	511	598	java/lang/Throwable
    //   514	537	598	java/lang/Throwable
    //   251	261	638	finally
    //   265	275	638	finally
    //   279	287	638	finally
    //   291	299	638	finally
    //   332	339	638	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.db.OfflineFileHelper
 * JD-Core Version:    0.7.0.1
 */