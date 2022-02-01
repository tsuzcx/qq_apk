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
    //   86: ifne +787 -> 873
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
    //   129: ifne +738 -> 867
    //   132: aload 8
    //   134: ldc 114
    //   136: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: goto +727 -> 867
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
    //   197: goto +670 -> 867
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
    //   246: goto +627 -> 873
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
    //   286: new 50	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   293: astore 5
    //   295: aload 5
    //   297: ldc 142
    //   299: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 5
    //   305: aload_0
    //   306: getfield 112	com/tencent/smtt/sdk/x:c	Z
    //   309: invokevirtual 140	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 5
    //   315: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 147	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   321: aload_0
    //   322: getfield 112	com/tencent/smtt/sdk/x:c	Z
    //   325: ifne +459 -> 784
    //   328: ldc 32
    //   330: ldc 149
    //   332: invokestatic 151	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload 9
    //   337: invokevirtual 94	com/tencent/smtt/sdk/f:b	()Z
    //   340: istore 4
    //   342: iload 4
    //   344: ifeq +321 -> 665
    //   347: aload 10
    //   349: ifnull +316 -> 665
    //   352: aload 6
    //   354: ifnonnull +311 -> 665
    //   357: aload 10
    //   359: invokevirtual 105	com/tencent/smtt/sdk/v:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   362: astore 6
    //   364: aload 7
    //   366: astore 5
    //   368: aload 6
    //   370: ifnull +22 -> 392
    //   373: aload 6
    //   375: ldc 153
    //   377: ldc 155
    //   379: iconst_0
    //   380: anewarray 157	java/lang/Class
    //   383: iconst_0
    //   384: anewarray 4	java/lang/Object
    //   387: invokevirtual 163	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   390: astore 5
    //   392: aload 5
    //   394: instanceof 69
    //   397: ifeq +84 -> 481
    //   400: aload 5
    //   402: checkcast 69	java/lang/Throwable
    //   405: astore 6
    //   407: new 50	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   414: astore 7
    //   416: aload 7
    //   418: ldc 165
    //   420: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 7
    //   426: aload 6
    //   428: invokevirtual 168	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 7
    //   437: ldc 170
    //   439: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 7
    //   445: aload 6
    //   447: invokevirtual 174	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   450: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 7
    //   456: ldc 176
    //   458: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 7
    //   464: aload 6
    //   466: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 8
    //   472: aload 7
    //   474: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 5
    //   483: instanceof 178
    //   486: ifeq +49 -> 535
    //   489: new 50	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   496: astore 6
    //   498: aload 6
    //   500: ldc 180
    //   502: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 6
    //   508: aload 5
    //   510: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 8
    //   516: aload 6
    //   518: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: goto +10 -> 535
    //   528: astore 5
    //   530: aload 5
    //   532: invokevirtual 183	java/lang/Throwable:printStackTrace	()V
    //   535: aload 8
    //   537: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: ldc 185
    //   542: invokevirtual 189	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   545: ifeq +66 -> 611
    //   548: invokestatic 194	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   551: astore 5
    //   553: sipush 408
    //   556: istore_3
    //   557: new 50	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   564: astore 6
    //   566: aload 6
    //   568: ldc 196
    //   570: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 6
    //   576: aload 8
    //   578: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: new 69	java/lang/Throwable
    //   588: dup
    //   589: aload 6
    //   591: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokespecial 198	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   597: astore 6
    //   599: aload 5
    //   601: aload_1
    //   602: iload_3
    //   603: aload 6
    //   605: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   608: goto +224 -> 832
    //   611: invokestatic 194	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   614: astore 5
    //   616: sipush 407
    //   619: istore_3
    //   620: new 50	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   627: astore 6
    //   629: aload 6
    //   631: ldc 196
    //   633: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload 6
    //   639: aload 8
    //   641: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: new 69	java/lang/Throwable
    //   651: dup
    //   652: aload 6
    //   654: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokespecial 198	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   660: astore 6
    //   662: goto -63 -> 599
    //   665: aload 9
    //   667: invokevirtual 94	com/tencent/smtt/sdk/f:b	()Z
    //   670: ifeq +63 -> 733
    //   673: invokestatic 194	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   676: astore 5
    //   678: sipush 409
    //   681: istore_3
    //   682: new 50	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   689: astore 7
    //   691: aload 7
    //   693: ldc 203
    //   695: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 7
    //   701: aload 6
    //   703: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: new 69	java/lang/Throwable
    //   710: dup
    //   711: aload 7
    //   713: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokespecial 198	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   719: astore 6
    //   721: aload 5
    //   723: aload_1
    //   724: iload_3
    //   725: aload 6
    //   727: invokevirtual 201	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   730: goto +102 -> 832
    //   733: invokestatic 194	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   736: astore 5
    //   738: sipush 410
    //   741: istore_3
    //   742: new 50	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   749: astore 7
    //   751: aload 7
    //   753: ldc 205
    //   755: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 7
    //   761: aload 6
    //   763: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: new 69	java/lang/Throwable
    //   770: dup
    //   771: aload 7
    //   773: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokespecial 198	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   779: astore 6
    //   781: goto -60 -> 721
    //   784: new 50	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   791: astore 5
    //   793: aload 5
    //   795: ldc 207
    //   797: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload 5
    //   803: getstatic 42	com/tencent/smtt/sdk/x:e	Ljava/nio/channels/FileLock;
    //   806: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: ldc 32
    //   812: aload 5
    //   814: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 40	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: getstatic 42	com/tencent/smtt/sdk/x:e	Ljava/nio/channels/FileLock;
    //   823: ifnonnull +9 -> 832
    //   826: aload_0
    //   827: aload_1
    //   828: invokevirtual 209	com/tencent/smtt/sdk/x:a	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   831: pop
    //   832: aload_0
    //   833: iconst_1
    //   834: putfield 96	com/tencent/smtt/sdk/x:d	Z
    //   837: aload_2
    //   838: ifnull +10 -> 848
    //   841: aload_2
    //   842: ldc 88
    //   844: iconst_2
    //   845: invokevirtual 78	com/tencent/smtt/sdk/o:a	(Ljava/lang/String;B)V
    //   848: aload_0
    //   849: monitorexit
    //   850: return
    //   851: astore_1
    //   852: aload_0
    //   853: monitorexit
    //   854: goto +5 -> 859
    //   857: aload_1
    //   858: athrow
    //   859: goto -2 -> 857
    //   862: astore 5
    //   864: goto -672 -> 192
    //   867: aconst_null
    //   868: astore 5
    //   870: goto -670 -> 200
    //   873: aconst_null
    //   874: astore 6
    //   876: goto -627 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	879	0	this	x
    //   0	879	1	paramContext	Context
    //   0	879	2	paramo	o
    //   556	186	3	i	int
    //   67	276	4	bool	boolean
    //   143	84	5	localThrowable1	java.lang.Throwable
    //   256	253	5	localObject1	Object
    //   528	3	5	localThrowable2	java.lang.Throwable
    //   551	262	5	localObject2	Object
    //   862	1	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   868	1	5	localObject3	Object
    //   157	718	6	localObject4	Object
    //   70	702	7	localStringBuilder1	StringBuilder
    //   42	598	8	localStringBuilder2	StringBuilder
    //   24	642	9	localf	f
    //   60	298	10	localv	v
    // Exception table:
    //   from	to	target	type
    //   114	140	143	java/lang/Throwable
    //   357	364	528	java/lang/Throwable
    //   373	392	528	java/lang/Throwable
    //   392	481	528	java/lang/Throwable
    //   481	525	528	java/lang/Throwable
    //   2	9	851	finally
    //   13	20	851	finally
    //   20	44	851	finally
    //   48	55	851	finally
    //   55	69	851	finally
    //   82	89	851	finally
    //   93	98	851	finally
    //   98	114	851	finally
    //   114	140	851	finally
    //   145	189	851	finally
    //   192	197	851	finally
    //   204	226	851	finally
    //   233	246	851	finally
    //   249	342	851	finally
    //   357	364	851	finally
    //   373	392	851	finally
    //   392	481	851	finally
    //   481	525	851	finally
    //   530	535	851	finally
    //   535	553	851	finally
    //   557	599	851	finally
    //   599	608	851	finally
    //   611	616	851	finally
    //   620	662	851	finally
    //   665	678	851	finally
    //   682	721	851	finally
    //   721	730	851	finally
    //   733	738	851	finally
    //   742	781	851	finally
    //   784	832	851	finally
    //   832	837	851	finally
    //   841	848	851	finally
    //   114	140	862	java/lang/NoSuchMethodException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.x
 * JD-Core Version:    0.7.0.1
 */