package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

class x
{
  private static x a;
  private static FileLock e;
  private y b;
  private boolean c;
  private boolean d;
  
  public static x a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new x();
        }
      }
      finally {}
    }
    return a;
  }
  
  public y a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return c();
  }
  
  public FileLock a(Context paramContext)
  {
    TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
    FileLock localFileLock = e;
    if (localFileLock != null) {
      return localFileLock;
    }
    try
    {
      if (e == null)
      {
        e = FileUtil.e(paramContext);
        if (e == null) {}
        for (paramContext = "init -- sTbsCoreLoadFileLock failed!";; paramContext = paramContext.toString())
        {
          TbsLog.i("X5CoreEngine", paramContext);
          break;
          paramContext = new StringBuilder();
          paramContext.append("init -- sTbsCoreLoadFileLock succeeded: ");
          paramContext.append(e);
        }
      }
      return e;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  /* Error */
  public void a(Context paramContext, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 32
    //   4: ldc 71
    //   6: invokestatic 40	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ifnull +10 -> 20
    //   13: aload_2
    //   14: ldc 73
    //   16: iconst_2
    //   17: invokevirtual 78	com/tencent/smtt/sdk/o:a	(Ljava/lang/String;B)V
    //   20: iconst_1
    //   21: invokestatic 83	com/tencent/smtt/sdk/f:a	(Z)Lcom/tencent/smtt/sdk/f;
    //   24: astore 9
    //   26: aload 9
    //   28: aload_1
    //   29: iconst_0
    //   30: iconst_0
    //   31: aload_2
    //   32: invokevirtual 86	com/tencent/smtt/sdk/f:a	(Landroid/content/Context;ZZLcom/tencent/smtt/sdk/o;)V
    //   35: new 50	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   42: astore 8
    //   44: aload_2
    //   45: ifnull +10 -> 55
    //   48: aload_2
    //   49: ldc 88
    //   51: iconst_1
    //   52: invokevirtual 78	com/tencent/smtt/sdk/o:a	(Ljava/lang/String;B)V
    //   55: aload 9
    //   57: invokevirtual 91	com/tencent/smtt/sdk/f:a	()Lcom/tencent/smtt/sdk/v;
    //   60: astore 10
    //   62: aload 9
    //   64: invokevirtual 94	com/tencent/smtt/sdk/f:b	()Z
    //   67: istore 4
    //   69: aconst_null
    //   70: astore 7
    //   72: iload 4
    //   74: ifeq +159 -> 233
    //   77: aload 10
    //   79: ifnull +154 -> 233
    //   82: aload_0
    //   83: getfield 96	com/tencent/smtt/sdk/x:d	Z
    //   86: ifne +752 -> 838
    //   89: aload_2
    //   90: ifnull +8 -> 98
    //   93: aload_2
    //   94: iconst_1
    //   95: putfield 98	com/tencent/smtt/sdk/o:a	Z
    //   98: aload_0
    //   99: new 100	com/tencent/smtt/sdk/y
    //   102: dup
    //   103: aload 10
    //   105: invokevirtual 105	com/tencent/smtt/sdk/v:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   108: invokespecial 108	com/tencent/smtt/sdk/y:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   111: putfield 26	com/tencent/smtt/sdk/x:b	Lcom/tencent/smtt/sdk/y;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 26	com/tencent/smtt/sdk/x:b	Lcom/tencent/smtt/sdk/y;
    //   119: invokevirtual 110	com/tencent/smtt/sdk/y:a	()Z
    //   122: putfield 112	com/tencent/smtt/sdk/x:c	Z
    //   125: aload_0
    //   126: getfield 112	com/tencent/smtt/sdk/x:c	Z
    //   129: ifne +703 -> 832
    //   132: aload 8
    //   134: ldc 114
    //   136: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: goto +692 -> 832
    //   143: astore 5
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 112	com/tencent/smtt/sdk/x:c	Z
    //   150: new 50	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   157: astore 6
    //   159: aload 6
    //   161: ldc 116
    //   163: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: aload 5
    //   171: invokestatic 122	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   174: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 8
    //   180: aload 6
    //   182: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: goto +11 -> 200
    //   192: aload_0
    //   193: iconst_1
    //   194: putfield 112	com/tencent/smtt/sdk/x:c	Z
    //   197: goto +635 -> 832
    //   200: aload 5
    //   202: astore 6
    //   204: aload_0
    //   205: getfield 112	com/tencent/smtt/sdk/x:c	Z
    //   208: ifeq +41 -> 249
    //   211: invokestatic 128	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   214: aload_1
    //   215: iconst_1
    //   216: iconst_1
    //   217: invokevirtual 131	com/tencent/smtt/sdk/CookieManager:a	(Landroid/content/Context;ZZ)V
    //   220: invokestatic 128	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   223: invokevirtual 133	com/tencent/smtt/sdk/CookieManager:a	()V
    //   226: aload 5
    //   228: astore 6
    //   230: goto +19 -> 249
    //   233: aload_0
    //   234: iconst_0
    //   235: putfield 112	com/tencent/smtt/sdk/x:c	Z
    //   238: aload 8
    //   240: ldc 135
    //   242: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: goto +592 -> 838
    //   249: new 50	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   256: astore 5
    //   258: aload 5
    //   260: ldc 137
    //   262: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 5
    //   268: aload_0
    //   269: getfield 112	com/tencent/smtt/sdk/x:c	Z
    //   272: invokevirtual 140	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: ldc 32
    //   278: aload 5
    //   280: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 40	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_0
    //   287: getfield 112	com/tencent/smtt/sdk/x:c	Z
    //   290: ifne +459 -> 749
    //   293: ldc 32
    //   295: ldc 142
    //   297: invokestatic 144	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload 9
    //   302: invokevirtual 94	com/tencent/smtt/sdk/f:b	()Z
    //   305: istore 4
    //   307: iload 4
    //   309: ifeq +321 -> 630
    //   312: aload 10
    //   314: ifnull +316 -> 630
    //   317: aload 6
    //   319: ifnonnull +311 -> 630
    //   322: aload 10
    //   324: invokevirtual 105	com/tencent/smtt/sdk/v:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   327: astore 6
    //   329: aload 7
    //   331: astore 5
    //   333: aload 6
    //   335: ifnull +22 -> 357
    //   338: aload 6
    //   340: ldc 146
    //   342: ldc 148
    //   344: iconst_0
    //   345: anewarray 150	java/lang/Class
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokevirtual 156	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   355: astore 5
    //   357: aload 5
    //   359: instanceof 69
    //   362: ifeq +84 -> 446
    //   365: aload 5
    //   367: checkcast 69	java/lang/Throwable
    //   370: astore 6
    //   372: new 50	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   379: astore 7
    //   381: aload 7
    //   383: ldc 158
    //   385: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 7
    //   391: aload 6
    //   393: invokevirtual 161	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 7
    //   402: ldc 163
    //   404: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 7
    //   410: aload 6
    //   412: invokevirtual 167	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   415: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 7
    //   421: ldc 169
    //   423: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 7
    //   429: aload 6
    //   431: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 8
    //   437: aload 7
    //   439: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 5
    //   448: instanceof 171
    //   451: ifeq +49 -> 500
    //   454: new 50	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   461: astore 6
    //   463: aload 6
    //   465: ldc 173
    //   467: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 6
    //   473: aload 5
    //   475: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 8
    //   481: aload 6
    //   483: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: goto +10 -> 500
    //   493: astore 5
    //   495: aload 5
    //   497: invokevirtual 176	java/lang/Throwable:printStackTrace	()V
    //   500: aload 8
    //   502: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: ldc 178
    //   507: invokevirtual 182	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   510: ifeq +66 -> 576
    //   513: invokestatic 187	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   516: astore 5
    //   518: sipush 408
    //   521: istore_3
    //   522: new 50	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   529: astore 6
    //   531: aload 6
    //   533: ldc 189
    //   535: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 6
    //   541: aload 8
    //   543: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: new 69	java/lang/Throwable
    //   553: dup
    //   554: aload 6
    //   556: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokespecial 192	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   562: astore 6
    //   564: aload 5
    //   566: aload_1
    //   567: iload_3
    //   568: aload 6
    //   570: invokevirtual 195	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   573: goto +224 -> 797
    //   576: invokestatic 187	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   579: astore 5
    //   581: sipush 407
    //   584: istore_3
    //   585: new 50	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   592: astore 6
    //   594: aload 6
    //   596: ldc 189
    //   598: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 6
    //   604: aload 8
    //   606: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: new 69	java/lang/Throwable
    //   616: dup
    //   617: aload 6
    //   619: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokespecial 192	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   625: astore 6
    //   627: goto -63 -> 564
    //   630: aload 9
    //   632: invokevirtual 94	com/tencent/smtt/sdk/f:b	()Z
    //   635: ifeq +63 -> 698
    //   638: invokestatic 187	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   641: astore 5
    //   643: sipush 409
    //   646: istore_3
    //   647: new 50	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   654: astore 7
    //   656: aload 7
    //   658: ldc 197
    //   660: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 7
    //   666: aload 6
    //   668: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: new 69	java/lang/Throwable
    //   675: dup
    //   676: aload 7
    //   678: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokespecial 192	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   684: astore 6
    //   686: aload 5
    //   688: aload_1
    //   689: iload_3
    //   690: aload 6
    //   692: invokevirtual 195	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   695: goto +102 -> 797
    //   698: invokestatic 187	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   701: astore 5
    //   703: sipush 410
    //   706: istore_3
    //   707: new 50	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   714: astore 7
    //   716: aload 7
    //   718: ldc 199
    //   720: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload 7
    //   726: aload 6
    //   728: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: new 69	java/lang/Throwable
    //   735: dup
    //   736: aload 7
    //   738: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokespecial 192	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   744: astore 6
    //   746: goto -60 -> 686
    //   749: new 50	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   756: astore 5
    //   758: aload 5
    //   760: ldc 201
    //   762: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 5
    //   768: getstatic 42	com/tencent/smtt/sdk/x:e	Ljava/nio/channels/FileLock;
    //   771: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: ldc 32
    //   777: aload 5
    //   779: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   782: invokestatic 40	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: getstatic 42	com/tencent/smtt/sdk/x:e	Ljava/nio/channels/FileLock;
    //   788: ifnonnull +9 -> 797
    //   791: aload_0
    //   792: aload_1
    //   793: invokevirtual 203	com/tencent/smtt/sdk/x:a	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   796: pop
    //   797: aload_0
    //   798: iconst_1
    //   799: putfield 96	com/tencent/smtt/sdk/x:d	Z
    //   802: aload_2
    //   803: ifnull +10 -> 813
    //   806: aload_2
    //   807: ldc 88
    //   809: iconst_2
    //   810: invokevirtual 78	com/tencent/smtt/sdk/o:a	(Ljava/lang/String;B)V
    //   813: aload_0
    //   814: monitorexit
    //   815: return
    //   816: astore_1
    //   817: aload_0
    //   818: monitorexit
    //   819: goto +5 -> 824
    //   822: aload_1
    //   823: athrow
    //   824: goto -2 -> 822
    //   827: astore 5
    //   829: goto -637 -> 192
    //   832: aconst_null
    //   833: astore 5
    //   835: goto -635 -> 200
    //   838: aconst_null
    //   839: astore 6
    //   841: goto -592 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	844	0	this	x
    //   0	844	1	paramContext	Context
    //   0	844	2	paramo	o
    //   521	186	3	i	int
    //   67	241	4	bool	boolean
    //   143	84	5	localThrowable1	java.lang.Throwable
    //   256	218	5	localObject1	Object
    //   493	3	5	localThrowable2	java.lang.Throwable
    //   516	262	5	localObject2	Object
    //   827	1	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   833	1	5	localObject3	Object
    //   157	683	6	localObject4	Object
    //   70	667	7	localStringBuilder1	StringBuilder
    //   42	563	8	localStringBuilder2	StringBuilder
    //   24	607	9	localf	f
    //   60	263	10	localv	v
    // Exception table:
    //   from	to	target	type
    //   114	140	143	java/lang/Throwable
    //   322	329	493	java/lang/Throwable
    //   338	357	493	java/lang/Throwable
    //   357	446	493	java/lang/Throwable
    //   446	490	493	java/lang/Throwable
    //   2	9	816	finally
    //   13	20	816	finally
    //   20	44	816	finally
    //   48	55	816	finally
    //   55	69	816	finally
    //   82	89	816	finally
    //   93	98	816	finally
    //   98	114	816	finally
    //   114	140	816	finally
    //   145	189	816	finally
    //   192	197	816	finally
    //   204	226	816	finally
    //   233	246	816	finally
    //   249	307	816	finally
    //   322	329	816	finally
    //   338	357	816	finally
    //   357	446	816	finally
    //   446	490	816	finally
    //   495	500	816	finally
    //   500	518	816	finally
    //   522	564	816	finally
    //   564	573	816	finally
    //   576	581	816	finally
    //   585	627	816	finally
    //   630	643	816	finally
    //   647	686	816	finally
    //   686	695	816	finally
    //   698	703	816	finally
    //   707	746	816	finally
    //   749	797	816	finally
    //   797	802	816	finally
    //   806	813	816	finally
    //   114	140	827	java/lang/NoSuchMethodException
  }
  
  public boolean b()
  {
    if (QbSdk.a) {
      return false;
    }
    return this.c;
  }
  
  public y c()
  {
    if (QbSdk.a) {
      return null;
    }
    return this.b;
  }
  
  boolean d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.x
 * JD-Core Version:    0.7.0.1
 */