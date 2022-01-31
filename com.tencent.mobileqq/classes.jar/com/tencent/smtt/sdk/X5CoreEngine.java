package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.FileUtil;
import java.nio.channels.FileLock;

class X5CoreEngine
{
  private static final String LOG_TAG = "X5CoreEngine";
  private static X5CoreEngine mInstance;
  private static FileLock sTbsCoreLoadFileLock = null;
  private boolean mCanUseX5;
  private boolean mIsInited;
  private X5CoreWizard mX5CoreWizard;
  
  public static X5CoreEngine getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new X5CoreEngine();
      }
      return mInstance;
    }
    finally {}
  }
  
  /* Error */
  public void init(Context paramContext, TbsInitPerformanceRecorder paramTbsInitPerformanceRecorder)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 8
    //   7: ldc 38
    //   9: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ifnull +10 -> 23
    //   16: aload_2
    //   17: ldc 46
    //   19: iconst_2
    //   20: invokevirtual 52	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:recordPerformanceEvent	(Ljava/lang/String;B)V
    //   23: iconst_1
    //   24: invokestatic 57	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   27: astore 8
    //   29: aload 8
    //   31: aload_1
    //   32: iconst_0
    //   33: iconst_0
    //   34: aload_2
    //   35: invokevirtual 60	com/tencent/smtt/sdk/SDKEngine:init	(Landroid/content/Context;ZZLcom/tencent/smtt/sdk/TbsInitPerformanceRecorder;)V
    //   38: new 62	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   45: astore 7
    //   47: aload_2
    //   48: ifnull +10 -> 58
    //   51: aload_2
    //   52: ldc 65
    //   54: iconst_1
    //   55: invokevirtual 52	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:recordPerformanceEvent	(Ljava/lang/String;B)V
    //   58: aload 8
    //   60: invokevirtual 69	com/tencent/smtt/sdk/SDKEngine:wizard	()Lcom/tencent/smtt/sdk/TbsWizard;
    //   63: astore 9
    //   65: aload 8
    //   67: invokevirtual 73	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   70: ifeq +430 -> 500
    //   73: aload 9
    //   75: ifnull +425 -> 500
    //   78: aload_0
    //   79: getfield 75	com/tencent/smtt/sdk/X5CoreEngine:mIsInited	Z
    //   82: ifne +616 -> 698
    //   85: aload_2
    //   86: ifnull +8 -> 94
    //   89: aload_2
    //   90: iconst_1
    //   91: putfield 78	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mIsFirstInitX5	Z
    //   94: aload_0
    //   95: new 80	com/tencent/smtt/sdk/X5CoreWizard
    //   98: dup
    //   99: aload 9
    //   101: invokevirtual 86	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   104: invokespecial 89	com/tencent/smtt/sdk/X5CoreWizard:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   107: putfield 91	com/tencent/smtt/sdk/X5CoreEngine:mX5CoreWizard	Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 91	com/tencent/smtt/sdk/X5CoreEngine:mX5CoreWizard	Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   115: invokevirtual 94	com/tencent/smtt/sdk/X5CoreWizard:canUseX5	()Z
    //   118: putfield 96	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   121: aload_0
    //   122: getfield 96	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   125: ifne +11 -> 136
    //   128: aload 7
    //   130: ldc 98
    //   132: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aconst_null
    //   137: astore 4
    //   139: aload 4
    //   141: astore 5
    //   143: aload_0
    //   144: getfield 96	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   147: ifeq +22 -> 169
    //   150: invokestatic 107	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   153: aload_1
    //   154: iconst_1
    //   155: iconst_1
    //   156: invokevirtual 111	com/tencent/smtt/sdk/CookieManager:compatiableCookieDatabaseIfNeed	(Landroid/content/Context;ZZ)V
    //   159: invokestatic 107	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   162: invokevirtual 114	com/tencent/smtt/sdk/CookieManager:syncCookies	()V
    //   165: aload 4
    //   167: astore 5
    //   169: ldc 8
    //   171: new 62	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   178: ldc 116
    //   180: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: getfield 96	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   187: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   190: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_0
    //   197: getfield 96	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   200: ifne +457 -> 657
    //   203: ldc 8
    //   205: ldc 125
    //   207: invokestatic 128	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 8
    //   212: invokevirtual 73	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   215: istore_3
    //   216: iload_3
    //   217: ifeq +352 -> 569
    //   220: aload 9
    //   222: ifnull +347 -> 569
    //   225: aload 5
    //   227: ifnonnull +342 -> 569
    //   230: aload 9
    //   232: invokevirtual 86	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   235: astore 5
    //   237: aload 6
    //   239: astore 4
    //   241: aload 5
    //   243: ifnull +22 -> 265
    //   246: aload 5
    //   248: ldc 130
    //   250: ldc 132
    //   252: iconst_0
    //   253: anewarray 134	java/lang/Class
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokevirtual 140	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   263: astore 4
    //   265: aload 4
    //   267: instanceof 36
    //   270: ifeq +62 -> 332
    //   273: aload 4
    //   275: checkcast 36	java/lang/Throwable
    //   278: astore 5
    //   280: aload 7
    //   282: new 62	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   289: ldc 142
    //   291: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 5
    //   296: invokevirtual 145	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   299: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc 147
    //   304: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 5
    //   309: invokevirtual 151	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   312: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   315: ldc 156
    //   317: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 5
    //   322: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 4
    //   334: instanceof 158
    //   337: ifeq +29 -> 366
    //   340: aload 7
    //   342: new 62	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   349: ldc 160
    //   351: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 4
    //   356: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 7
    //   368: ifnull +158 -> 526
    //   371: aload 7
    //   373: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: ldc 162
    //   378: invokevirtual 166	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   381: ifeq +145 -> 526
    //   384: invokestatic 171	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   387: aload_1
    //   388: sipush 408
    //   391: new 36	java/lang/Throwable
    //   394: dup
    //   395: new 62	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   402: ldc 173
    //   404: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 7
    //   409: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokespecial 176	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   421: invokevirtual 180	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   424: aload_0
    //   425: iconst_1
    //   426: putfield 75	com/tencent/smtt/sdk/X5CoreEngine:mIsInited	Z
    //   429: aload_2
    //   430: ifnull +10 -> 440
    //   433: aload_2
    //   434: ldc 65
    //   436: iconst_2
    //   437: invokevirtual 52	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:recordPerformanceEvent	(Ljava/lang/String;B)V
    //   440: aload_0
    //   441: monitorexit
    //   442: return
    //   443: astore 4
    //   445: aload_0
    //   446: iconst_1
    //   447: putfield 96	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   450: aconst_null
    //   451: astore 4
    //   453: goto -314 -> 139
    //   456: astore 4
    //   458: aload_0
    //   459: iconst_0
    //   460: putfield 96	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   463: aload 7
    //   465: new 62	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   472: ldc 182
    //   474: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 4
    //   479: invokestatic 188	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   482: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: goto -353 -> 139
    //   495: astore_1
    //   496: aload_0
    //   497: monitorexit
    //   498: aload_1
    //   499: athrow
    //   500: aload_0
    //   501: iconst_0
    //   502: putfield 96	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   505: aload 7
    //   507: ldc 190
    //   509: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: goto +185 -> 698
    //   516: astore 4
    //   518: aload 4
    //   520: invokevirtual 193	java/lang/Throwable:printStackTrace	()V
    //   523: goto -157 -> 366
    //   526: invokestatic 171	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   529: aload_1
    //   530: sipush 407
    //   533: new 36	java/lang/Throwable
    //   536: dup
    //   537: new 62	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   544: ldc 173
    //   546: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload 7
    //   551: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokespecial 176	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   563: invokevirtual 180	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   566: goto -142 -> 424
    //   569: aload 8
    //   571: invokevirtual 73	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   574: ifeq +43 -> 617
    //   577: invokestatic 171	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   580: aload_1
    //   581: sipush 409
    //   584: new 36	java/lang/Throwable
    //   587: dup
    //   588: new 62	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   595: ldc 195
    //   597: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload 5
    //   602: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokespecial 176	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   611: invokevirtual 180	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   614: goto -190 -> 424
    //   617: invokestatic 171	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   620: aload_1
    //   621: sipush 410
    //   624: new 36	java/lang/Throwable
    //   627: dup
    //   628: new 62	java/lang/StringBuilder
    //   631: dup
    //   632: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   635: ldc 197
    //   637: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload 5
    //   642: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokespecial 176	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   651: invokevirtual 180	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   654: goto -230 -> 424
    //   657: ldc 8
    //   659: new 62	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   666: ldc 199
    //   668: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   674: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   686: ifnonnull -262 -> 424
    //   689: aload_0
    //   690: aload_1
    //   691: invokevirtual 203	com/tencent/smtt/sdk/X5CoreEngine:tryTbsCoreLoadFileLock	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   694: pop
    //   695: goto -271 -> 424
    //   698: aconst_null
    //   699: astore 5
    //   701: goto -532 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	X5CoreEngine
    //   0	704	1	paramContext	Context
    //   0	704	2	paramTbsInitPerformanceRecorder	TbsInitPerformanceRecorder
    //   215	2	3	bool	boolean
    //   137	218	4	localObject1	Object
    //   443	1	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   451	1	4	localObject2	Object
    //   456	22	4	localThrowable1	Throwable
    //   516	3	4	localThrowable2	Throwable
    //   141	559	5	localObject3	Object
    //   1	237	6	localObject4	Object
    //   45	505	7	localStringBuilder	java.lang.StringBuilder
    //   27	543	8	localSDKEngine	SDKEngine
    //   63	168	9	localTbsWizard	TbsWizard
    // Exception table:
    //   from	to	target	type
    //   110	136	443	java/lang/NoSuchMethodException
    //   110	136	456	java/lang/Throwable
    //   5	12	495	finally
    //   16	23	495	finally
    //   23	47	495	finally
    //   51	58	495	finally
    //   58	73	495	finally
    //   78	85	495	finally
    //   89	94	495	finally
    //   94	110	495	finally
    //   110	136	495	finally
    //   143	165	495	finally
    //   169	216	495	finally
    //   230	237	495	finally
    //   246	265	495	finally
    //   265	332	495	finally
    //   332	366	495	finally
    //   371	424	495	finally
    //   424	429	495	finally
    //   433	440	495	finally
    //   445	450	495	finally
    //   458	492	495	finally
    //   500	513	495	finally
    //   518	523	495	finally
    //   526	566	495	finally
    //   569	614	495	finally
    //   617	654	495	finally
    //   657	695	495	finally
    //   230	237	516	java/lang/Throwable
    //   246	265	516	java/lang/Throwable
    //   265	332	516	java/lang/Throwable
    //   332	366	516	java/lang/Throwable
  }
  
  boolean isInited()
  {
    return this.mIsInited;
  }
  
  public boolean isX5Core()
  {
    if (QbSdk.mIsSysWebViewForced) {
      return false;
    }
    return this.mCanUseX5;
  }
  
  public void releaseTbsCoreLoadFileLock(Context paramContext)
  {
    int i = 1;
    try
    {
      boolean bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    if (i == 0) {}
    while (sTbsCoreLoadFileLock == null) {
      return;
    }
    FileUtil.releaseTbsCoreRenameFileLock(paramContext, sTbsCoreLoadFileLock);
  }
  
  /* Error */
  public FileLock tryTbsCoreLoadFileLock(Context paramContext)
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc 228
    //   4: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   10: ifnull +7 -> 17
    //   13: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   16: areturn
    //   17: ldc 2
    //   19: monitorenter
    //   20: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   23: ifnonnull +23 -> 46
    //   26: aload_1
    //   27: invokestatic 231	com/tencent/smtt/utils/FileUtil:getTbsCoreLoadFileLock	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   30: putstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   33: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   36: ifnonnull +17 -> 53
    //   39: ldc 8
    //   41: ldc 233
    //   43: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: ldc 2
    //   48: monitorexit
    //   49: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   52: areturn
    //   53: ldc 8
    //   55: new 62	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   62: ldc 235
    //   64: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   70: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -33 -> 46
    //   82: astore_1
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	X5CoreEngine
    //   0	88	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   20	46	82	finally
    //   46	49	82	finally
    //   53	79	82	finally
    //   83	86	82	finally
  }
  
  public X5CoreWizard wizard()
  {
    if (QbSdk.mIsSysWebViewForced) {
      return null;
    }
    return this.mX5CoreWizard;
  }
  
  public X5CoreWizard wizardForCoreTypeConfirmed(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mX5CoreWizard;
    }
    return wizard();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.X5CoreEngine
 * JD-Core Version:    0.7.0.1
 */