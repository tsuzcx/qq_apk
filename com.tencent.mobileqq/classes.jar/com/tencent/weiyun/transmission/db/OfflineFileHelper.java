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
    //   30: astore 7
    //   32: invokestatic 50	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   35: iconst_0
    //   36: invokevirtual 54	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   39: astore 8
    //   41: aload 8
    //   43: ifnonnull +20 -> 63
    //   46: ldc 21
    //   48: ldc 56
    //   50: invokestatic 62	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: new 38	java/util/ArrayList
    //   56: dup
    //   57: aload 7
    //   59: invokespecial 65	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   62: areturn
    //   63: aload_2
    //   64: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: istore_3
    //   68: aconst_null
    //   69: astore 5
    //   71: iload_3
    //   72: ifeq +399 -> 471
    //   75: iconst_3
    //   76: anewarray 67	java/lang/String
    //   79: astore 4
    //   81: aload 4
    //   83: iconst_0
    //   84: aload_0
    //   85: aastore
    //   86: aload 4
    //   88: iconst_1
    //   89: aload_1
    //   90: aastore
    //   91: aload 4
    //   93: iconst_2
    //   94: iconst_4
    //   95: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   98: aastore
    //   99: new 75	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   106: ldc 78
    //   108: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 84
    //   113: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 86
    //   118: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 84
    //   123: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore 6
    //   128: iload_3
    //   129: ifne +16 -> 145
    //   132: aload 6
    //   134: ldc 88
    //   136: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 84
    //   141: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 6
    //   147: ldc 90
    //   149: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 92
    //   154: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 6
    //   160: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 6
    //   165: aload 8
    //   167: ldc 97
    //   169: iconst_1
    //   170: anewarray 67	java/lang/String
    //   173: dup
    //   174: iconst_0
    //   175: ldc 99
    //   177: aastore
    //   178: aload 6
    //   180: aload 4
    //   182: aconst_null
    //   183: aconst_null
    //   184: ldc 101
    //   186: invokevirtual 107	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   189: astore 4
    //   191: aload 4
    //   193: astore 5
    //   195: aload 5
    //   197: ifnull +306 -> 503
    //   200: aload 5
    //   202: astore 4
    //   204: aload 5
    //   206: invokeinterface 113 1 0
    //   211: ifeq +292 -> 503
    //   214: aload 5
    //   216: astore 4
    //   218: aload 5
    //   220: iconst_0
    //   221: invokeinterface 116 2 0
    //   226: astore 6
    //   228: aload 5
    //   230: astore 4
    //   232: aload 6
    //   234: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne -37 -> 200
    //   240: aload 5
    //   242: astore 4
    //   244: aload 7
    //   246: aload 6
    //   248: invokevirtual 120	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   251: pop
    //   252: goto -52 -> 200
    //   255: astore 6
    //   257: aload 5
    //   259: astore 4
    //   261: ldc 21
    //   263: aload 6
    //   265: invokestatic 123	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   268: aload 5
    //   270: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   273: aconst_null
    //   274: astore 4
    //   276: iload_3
    //   277: ifeq +244 -> 521
    //   280: iconst_3
    //   281: anewarray 67	java/lang/String
    //   284: astore_2
    //   285: aload_2
    //   286: iconst_0
    //   287: aload_0
    //   288: aastore
    //   289: aload_2
    //   290: iconst_1
    //   291: aload_1
    //   292: aastore
    //   293: aload_2
    //   294: iconst_2
    //   295: iconst_5
    //   296: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   299: aastore
    //   300: aload_2
    //   301: astore_0
    //   302: new 75	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   309: ldc 78
    //   311: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc 84
    //   316: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc 86
    //   321: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 84
    //   326: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: astore_1
    //   330: iload_3
    //   331: ifne +30 -> 361
    //   334: aload_1
    //   335: bipush 40
    //   337: invokevirtual 132	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   340: ldc 134
    //   342: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc 136
    //   347: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 138
    //   352: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 140
    //   357: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload_1
    //   362: ldc 90
    //   364: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 92
    //   369: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_1
    //   374: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore_1
    //   378: aload 8
    //   380: ldc 142
    //   382: iconst_1
    //   383: anewarray 67	java/lang/String
    //   386: dup
    //   387: iconst_0
    //   388: ldc 99
    //   390: aastore
    //   391: aload_1
    //   392: aload_0
    //   393: aconst_null
    //   394: aconst_null
    //   395: ldc 101
    //   397: invokevirtual 107	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   400: astore_1
    //   401: aload_1
    //   402: ifnull +159 -> 561
    //   405: aload_1
    //   406: astore_0
    //   407: aload_1
    //   408: invokeinterface 113 1 0
    //   413: ifeq +148 -> 561
    //   416: aload_1
    //   417: astore_0
    //   418: aload_1
    //   419: iconst_0
    //   420: invokeinterface 116 2 0
    //   425: astore_2
    //   426: aload_1
    //   427: astore_0
    //   428: aload_2
    //   429: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   432: ifne -27 -> 405
    //   435: aload_1
    //   436: astore_0
    //   437: aload 7
    //   439: aload_2
    //   440: invokevirtual 120	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   443: pop
    //   444: goto -39 -> 405
    //   447: astore_2
    //   448: aload_1
    //   449: astore_0
    //   450: ldc 21
    //   452: aload_2
    //   453: invokestatic 123	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   456: aload_1
    //   457: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   460: invokestatic 50	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   463: aload 8
    //   465: invokevirtual 146	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   468: goto -415 -> 53
    //   471: iconst_4
    //   472: anewarray 67	java/lang/String
    //   475: astore 4
    //   477: aload 4
    //   479: iconst_0
    //   480: aload_0
    //   481: aastore
    //   482: aload 4
    //   484: iconst_1
    //   485: aload_1
    //   486: aastore
    //   487: aload 4
    //   489: iconst_2
    //   490: aload_2
    //   491: aastore
    //   492: aload 4
    //   494: iconst_3
    //   495: iconst_4
    //   496: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   499: aastore
    //   500: goto -401 -> 99
    //   503: aload 5
    //   505: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   508: goto -235 -> 273
    //   511: astore_0
    //   512: aload 5
    //   514: astore_1
    //   515: aload_1
    //   516: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   519: aload_0
    //   520: athrow
    //   521: iconst_5
    //   522: anewarray 67	java/lang/String
    //   525: astore 5
    //   527: aload 5
    //   529: iconst_0
    //   530: aload_0
    //   531: aastore
    //   532: aload 5
    //   534: iconst_1
    //   535: aload_1
    //   536: aastore
    //   537: aload 5
    //   539: iconst_2
    //   540: aload_2
    //   541: aastore
    //   542: aload 5
    //   544: iconst_3
    //   545: aload_2
    //   546: aastore
    //   547: aload 5
    //   549: iconst_4
    //   550: iconst_5
    //   551: invokestatic 73	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   554: aastore
    //   555: aload 5
    //   557: astore_0
    //   558: goto -256 -> 302
    //   561: aload_1
    //   562: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   565: goto -105 -> 460
    //   568: astore_0
    //   569: aload 4
    //   571: astore_1
    //   572: aload_1
    //   573: invokestatic 129	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   576: aload_0
    //   577: athrow
    //   578: astore_2
    //   579: aload_0
    //   580: astore_1
    //   581: aload_2
    //   582: astore_0
    //   583: goto -11 -> 572
    //   586: astore_2
    //   587: aconst_null
    //   588: astore_1
    //   589: goto -141 -> 448
    //   592: astore_0
    //   593: aload 4
    //   595: astore_1
    //   596: goto -81 -> 515
    //   599: astore 6
    //   601: aconst_null
    //   602: astore 5
    //   604: goto -347 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	paramString1	String
    //   0	607	1	paramString2	String
    //   0	607	2	paramString3	String
    //   67	264	3	bool	boolean
    //   79	515	4	localObject1	Object
    //   69	534	5	localObject2	Object
    //   126	121	6	localObject3	Object
    //   255	9	6	localThrowable1	java.lang.Throwable
    //   599	1	6	localThrowable2	java.lang.Throwable
    //   30	408	7	localHashSet	java.util.HashSet
    //   39	425	8	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   204	214	255	java/lang/Throwable
    //   218	228	255	java/lang/Throwable
    //   232	240	255	java/lang/Throwable
    //   244	252	255	java/lang/Throwable
    //   407	416	447	java/lang/Throwable
    //   418	426	447	java/lang/Throwable
    //   428	435	447	java/lang/Throwable
    //   437	444	447	java/lang/Throwable
    //   158	191	511	finally
    //   373	401	568	finally
    //   407	416	578	finally
    //   418	426	578	finally
    //   428	435	578	finally
    //   437	444	578	finally
    //   450	456	578	finally
    //   373	401	586	java/lang/Throwable
    //   204	214	592	finally
    //   218	228	592	finally
    //   232	240	592	finally
    //   244	252	592	finally
    //   261	268	592	finally
    //   158	191	599	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.db.OfflineFileHelper
 * JD-Core Version:    0.7.0.1
 */