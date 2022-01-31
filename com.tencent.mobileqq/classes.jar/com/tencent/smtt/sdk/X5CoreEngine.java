package com.tencent.smtt.sdk;

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
  public void init(android.content.Context paramContext, TbsInitPerformanceRecorder paramTbsInitPerformanceRecorder)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: ifnull +10 -> 16
    //   9: aload_2
    //   10: ldc 38
    //   12: iconst_2
    //   13: invokevirtual 44	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:recordPerformanceEvent	(Ljava/lang/String;B)V
    //   16: iconst_1
    //   17: invokestatic 49	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   20: astore 8
    //   22: aload 8
    //   24: aload_1
    //   25: iconst_0
    //   26: iconst_0
    //   27: aload_2
    //   28: invokevirtual 52	com/tencent/smtt/sdk/SDKEngine:init	(Landroid/content/Context;ZZLcom/tencent/smtt/sdk/TbsInitPerformanceRecorder;)V
    //   31: new 54	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   38: astore 7
    //   40: aload_2
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: ldc 57
    //   47: iconst_1
    //   48: invokevirtual 44	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:recordPerformanceEvent	(Ljava/lang/String;B)V
    //   51: aload 8
    //   53: invokevirtual 61	com/tencent/smtt/sdk/SDKEngine:wizard	()Lcom/tencent/smtt/sdk/TbsWizard;
    //   56: astore 9
    //   58: aload 8
    //   60: invokevirtual 65	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   63: ifeq +403 -> 466
    //   66: aload 9
    //   68: ifnull +398 -> 466
    //   71: aload_0
    //   72: getfield 67	com/tencent/smtt/sdk/X5CoreEngine:mIsInited	Z
    //   75: ifne +563 -> 638
    //   78: aload_2
    //   79: ifnull +8 -> 87
    //   82: aload_2
    //   83: iconst_1
    //   84: putfield 70	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mIsFirstInitX5	Z
    //   87: aload_0
    //   88: new 72	com/tencent/smtt/sdk/X5CoreWizard
    //   91: dup
    //   92: aload 9
    //   94: invokevirtual 78	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   97: invokespecial 81	com/tencent/smtt/sdk/X5CoreWizard:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   100: putfield 83	com/tencent/smtt/sdk/X5CoreEngine:mX5CoreWizard	Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 83	com/tencent/smtt/sdk/X5CoreEngine:mX5CoreWizard	Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   108: invokevirtual 86	com/tencent/smtt/sdk/X5CoreWizard:canUseX5	()Z
    //   111: putfield 88	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   114: aload_0
    //   115: getfield 88	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   118: ifne +11 -> 129
    //   121: aload 7
    //   123: ldc 90
    //   125: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aconst_null
    //   130: astore 4
    //   132: aload 4
    //   134: astore 5
    //   136: aload_0
    //   137: getfield 88	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   140: ifeq +22 -> 162
    //   143: invokestatic 99	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   146: aload_1
    //   147: iconst_1
    //   148: iconst_1
    //   149: invokevirtual 103	com/tencent/smtt/sdk/CookieManager:compatiableCookieDatabaseIfNeed	(Landroid/content/Context;ZZ)V
    //   152: invokestatic 99	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   155: invokevirtual 106	com/tencent/smtt/sdk/CookieManager:syncCookies	()V
    //   158: aload 4
    //   160: astore 5
    //   162: aload_0
    //   163: getfield 88	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   166: ifne +457 -> 623
    //   169: ldc 8
    //   171: ldc 108
    //   173: invokestatic 114	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 8
    //   178: invokevirtual 65	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   181: istore_3
    //   182: iload_3
    //   183: ifeq +352 -> 535
    //   186: aload 9
    //   188: ifnull +347 -> 535
    //   191: aload 5
    //   193: ifnonnull +342 -> 535
    //   196: aload 9
    //   198: invokevirtual 78	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   201: astore 5
    //   203: aload 6
    //   205: astore 4
    //   207: aload 5
    //   209: ifnull +22 -> 231
    //   212: aload 5
    //   214: ldc 116
    //   216: ldc 118
    //   218: iconst_0
    //   219: anewarray 120	java/lang/Class
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokevirtual 126	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   229: astore 4
    //   231: aload 4
    //   233: instanceof 36
    //   236: ifeq +62 -> 298
    //   239: aload 4
    //   241: checkcast 36	java/lang/Throwable
    //   244: astore 5
    //   246: aload 7
    //   248: new 54	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   255: ldc 128
    //   257: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 5
    //   262: invokevirtual 132	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 134
    //   270: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 5
    //   275: invokevirtual 138	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   278: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   281: ldc 143
    //   283: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload 5
    //   288: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 4
    //   300: instanceof 148
    //   303: ifeq +29 -> 332
    //   306: aload 7
    //   308: new 54	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   315: ldc 150
    //   317: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 4
    //   322: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 7
    //   334: ifnull +158 -> 492
    //   337: aload 7
    //   339: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: ldc 152
    //   344: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   347: ifeq +145 -> 492
    //   350: invokestatic 161	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   353: aload_1
    //   354: sipush 408
    //   357: new 36	java/lang/Throwable
    //   360: dup
    //   361: new 54	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   368: ldc 163
    //   370: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 7
    //   375: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokespecial 166	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   387: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   390: aload_0
    //   391: iconst_1
    //   392: putfield 67	com/tencent/smtt/sdk/X5CoreEngine:mIsInited	Z
    //   395: aload_2
    //   396: ifnull +10 -> 406
    //   399: aload_2
    //   400: ldc 57
    //   402: iconst_2
    //   403: invokevirtual 44	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:recordPerformanceEvent	(Ljava/lang/String;B)V
    //   406: aload_0
    //   407: monitorexit
    //   408: return
    //   409: astore 4
    //   411: aload_0
    //   412: iconst_1
    //   413: putfield 88	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   416: aconst_null
    //   417: astore 4
    //   419: goto -287 -> 132
    //   422: astore 4
    //   424: aload_0
    //   425: iconst_0
    //   426: putfield 88	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   429: aload 7
    //   431: new 54	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   438: ldc 172
    //   440: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 4
    //   445: invokestatic 178	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   448: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: goto -326 -> 132
    //   461: astore_1
    //   462: aload_0
    //   463: monitorexit
    //   464: aload_1
    //   465: athrow
    //   466: aload_0
    //   467: iconst_0
    //   468: putfield 88	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   471: aload 7
    //   473: ldc 180
    //   475: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: goto +159 -> 638
    //   482: astore 4
    //   484: aload 4
    //   486: invokevirtual 183	java/lang/Throwable:printStackTrace	()V
    //   489: goto -157 -> 332
    //   492: invokestatic 161	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   495: aload_1
    //   496: sipush 407
    //   499: new 36	java/lang/Throwable
    //   502: dup
    //   503: new 54	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   510: ldc 163
    //   512: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload 7
    //   517: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokespecial 166	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   529: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   532: goto -142 -> 390
    //   535: aload 8
    //   537: invokevirtual 65	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   540: ifeq +43 -> 583
    //   543: invokestatic 161	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   546: aload_1
    //   547: sipush 409
    //   550: new 36	java/lang/Throwable
    //   553: dup
    //   554: new 54	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   561: ldc 185
    //   563: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload 5
    //   568: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokespecial 166	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   577: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   580: goto -190 -> 390
    //   583: invokestatic 161	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   586: aload_1
    //   587: sipush 410
    //   590: new 36	java/lang/Throwable
    //   593: dup
    //   594: new 54	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   601: ldc 187
    //   603: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload 5
    //   608: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokespecial 166	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   617: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   620: goto -230 -> 390
    //   623: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   626: ifnonnull -236 -> 390
    //   629: aload_0
    //   630: aload_1
    //   631: invokevirtual 191	com/tencent/smtt/sdk/X5CoreEngine:tryTbsCoreLoadFileLock	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   634: pop
    //   635: goto -245 -> 390
    //   638: aconst_null
    //   639: astore 5
    //   641: goto -479 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	X5CoreEngine
    //   0	644	1	paramContext	android.content.Context
    //   0	644	2	paramTbsInitPerformanceRecorder	TbsInitPerformanceRecorder
    //   181	2	3	bool	boolean
    //   130	191	4	localObject1	Object
    //   409	1	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   417	1	4	localObject2	Object
    //   422	22	4	localThrowable1	java.lang.Throwable
    //   482	3	4	localThrowable2	java.lang.Throwable
    //   134	506	5	localObject3	Object
    //   1	203	6	localObject4	Object
    //   38	478	7	localStringBuilder	java.lang.StringBuilder
    //   20	516	8	localSDKEngine	SDKEngine
    //   56	141	9	localTbsWizard	TbsWizard
    // Exception table:
    //   from	to	target	type
    //   103	129	409	java/lang/NoSuchMethodException
    //   103	129	422	java/lang/Throwable
    //   9	16	461	finally
    //   16	40	461	finally
    //   44	51	461	finally
    //   51	66	461	finally
    //   71	78	461	finally
    //   82	87	461	finally
    //   87	103	461	finally
    //   103	129	461	finally
    //   136	158	461	finally
    //   162	182	461	finally
    //   196	203	461	finally
    //   212	231	461	finally
    //   231	298	461	finally
    //   298	332	461	finally
    //   337	390	461	finally
    //   390	395	461	finally
    //   399	406	461	finally
    //   411	416	461	finally
    //   424	458	461	finally
    //   466	479	461	finally
    //   484	489	461	finally
    //   492	532	461	finally
    //   535	580	461	finally
    //   583	620	461	finally
    //   623	635	461	finally
    //   196	203	482	java/lang/Throwable
    //   212	231	482	java/lang/Throwable
    //   231	298	482	java/lang/Throwable
    //   298	332	482	java/lang/Throwable
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
  
  /* Error */
  public FileLock tryTbsCoreLoadFileLock(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   5: ifnull +11 -> 16
    //   8: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_1
    //   17: invokestatic 203	com/tencent/smtt/utils/FileUtil:getTbsCoreLoadFileLock	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   20: putstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   23: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   26: ifnonnull +3 -> 29
    //   29: getstatic 21	com/tencent/smtt/sdk/X5CoreEngine:sTbsCoreLoadFileLock	Ljava/nio/channels/FileLock;
    //   32: astore_1
    //   33: goto -21 -> 12
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	X5CoreEngine
    //   0	41	1	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   2	12	36	finally
    //   16	29	36	finally
    //   29	33	36	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.X5CoreEngine
 * JD-Core Version:    0.7.0.1
 */