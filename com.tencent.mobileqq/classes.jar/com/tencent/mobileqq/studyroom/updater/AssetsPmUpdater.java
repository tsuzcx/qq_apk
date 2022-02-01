package com.tencent.mobileqq.studyroom.updater;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class AssetsPmUpdater
  implements IShadowPluginManagerUpdater
{
  private final File a;
  private final String b;
  private final String c;
  private final Context d;
  private boolean e;
  private Future<File> f;
  
  /* Error */
  private boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_1
    //   10: invokevirtual 31	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_2
    //   14: invokevirtual 37	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_1
    //   18: new 39	java/io/BufferedInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 43	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore 5
    //   28: new 45	java/io/File
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 52	java/io/File:exists	()Z
    //   41: ifeq +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 55	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_2
    //   50: invokevirtual 58	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: new 60	java/io/FileOutputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 63	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_2
    //   63: new 65	java/io/BufferedOutputStream
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 68	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore_3
    //   72: sipush 1024
    //   75: newarray byte
    //   77: astore 6
    //   79: aload 5
    //   81: aload 6
    //   83: invokevirtual 72	java/io/BufferedInputStream:read	([B)I
    //   86: istore 4
    //   88: iload 4
    //   90: iconst_m1
    //   91: if_icmpeq +15 -> 106
    //   94: aload_3
    //   95: aload 6
    //   97: iconst_0
    //   98: iload 4
    //   100: invokevirtual 76	java/io/BufferedOutputStream:write	([BII)V
    //   103: goto -24 -> 79
    //   106: aload_3
    //   107: invokevirtual 80	java/io/BufferedOutputStream:flush	()V
    //   110: aload_3
    //   111: invokevirtual 83	java/io/BufferedOutputStream:close	()V
    //   114: goto +42 -> 156
    //   117: astore_3
    //   118: new 85	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   125: astore 6
    //   127: aload 6
    //   129: ldc 89
    //   131: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 6
    //   137: aload_3
    //   138: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   141: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 99
    //   147: iconst_1
    //   148: aload 6
    //   150: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_2
    //   157: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   160: goto +38 -> 198
    //   163: astore_2
    //   164: new 85	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   171: astore_3
    //   172: aload_3
    //   173: ldc 89
    //   175: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_3
    //   180: aload_2
    //   181: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   184: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: ldc 99
    //   190: iconst_1
    //   191: aload_3
    //   192: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 5
    //   200: invokevirtual 108	java/io/BufferedInputStream:close	()V
    //   203: goto +38 -> 241
    //   206: astore_2
    //   207: new 85	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   214: astore_3
    //   215: aload_3
    //   216: ldc 89
    //   218: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_3
    //   223: aload_2
    //   224: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   227: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: ldc 99
    //   233: iconst_1
    //   234: aload_3
    //   235: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_1
    //   242: ifnull +44 -> 286
    //   245: aload_1
    //   246: invokevirtual 111	java/io/InputStream:close	()V
    //   249: iconst_1
    //   250: ireturn
    //   251: astore_1
    //   252: new 85	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   259: astore_2
    //   260: aload_2
    //   261: ldc 89
    //   263: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_2
    //   268: aload_1
    //   269: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   272: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: ldc 99
    //   278: iconst_1
    //   279: aload_2
    //   280: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: iconst_1
    //   287: ireturn
    //   288: astore 7
    //   290: aload_3
    //   291: astore 6
    //   293: aload 7
    //   295: astore_3
    //   296: goto +19 -> 315
    //   299: astore 7
    //   301: aload_3
    //   302: astore 6
    //   304: aload 7
    //   306: astore_3
    //   307: goto +78 -> 385
    //   310: astore_3
    //   311: aload 8
    //   313: astore 6
    //   315: goto +273 -> 588
    //   318: astore_3
    //   319: goto +66 -> 385
    //   322: astore_3
    //   323: aconst_null
    //   324: astore_2
    //   325: aload 7
    //   327: astore 6
    //   329: goto +259 -> 588
    //   332: astore_3
    //   333: aconst_null
    //   334: astore_2
    //   335: goto +50 -> 385
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_2
    //   341: aload_2
    //   342: astore 5
    //   344: aload 7
    //   346: astore 6
    //   348: goto +240 -> 588
    //   351: astore_3
    //   352: aconst_null
    //   353: astore_2
    //   354: aload_2
    //   355: astore 5
    //   357: goto +28 -> 385
    //   360: astore_3
    //   361: aconst_null
    //   362: astore_2
    //   363: aload_2
    //   364: astore 5
    //   366: aload 5
    //   368: astore_1
    //   369: aload 7
    //   371: astore 6
    //   373: goto +215 -> 588
    //   376: astore_3
    //   377: aconst_null
    //   378: astore_2
    //   379: aload_2
    //   380: astore 5
    //   382: aload 5
    //   384: astore_1
    //   385: ldc 99
    //   387: iconst_1
    //   388: ldc 113
    //   390: aload_3
    //   391: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: aload 6
    //   396: ifnull +50 -> 446
    //   399: aload 6
    //   401: invokevirtual 83	java/io/BufferedOutputStream:close	()V
    //   404: goto +42 -> 446
    //   407: astore_3
    //   408: new 85	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   415: astore 6
    //   417: aload 6
    //   419: ldc 89
    //   421: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 6
    //   427: aload_3
    //   428: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   431: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: ldc 99
    //   437: iconst_1
    //   438: aload 6
    //   440: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aload_2
    //   447: ifnull +45 -> 492
    //   450: aload_2
    //   451: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   454: goto +38 -> 492
    //   457: astore_2
    //   458: new 85	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   465: astore_3
    //   466: aload_3
    //   467: ldc 89
    //   469: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_3
    //   474: aload_2
    //   475: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   478: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: ldc 99
    //   484: iconst_1
    //   485: aload_3
    //   486: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: aload 5
    //   494: ifnull +46 -> 540
    //   497: aload 5
    //   499: invokevirtual 108	java/io/BufferedInputStream:close	()V
    //   502: goto +38 -> 540
    //   505: astore_2
    //   506: new 85	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   513: astore_3
    //   514: aload_3
    //   515: ldc 89
    //   517: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_3
    //   522: aload_2
    //   523: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   526: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: ldc 99
    //   532: iconst_1
    //   533: aload_3
    //   534: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: aload_1
    //   541: ifnull +44 -> 585
    //   544: aload_1
    //   545: invokevirtual 111	java/io/InputStream:close	()V
    //   548: iconst_0
    //   549: ireturn
    //   550: astore_1
    //   551: new 85	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   558: astore_2
    //   559: aload_2
    //   560: ldc 89
    //   562: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_2
    //   567: aload_1
    //   568: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   571: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: ldc 99
    //   577: iconst_1
    //   578: aload_2
    //   579: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: iconst_0
    //   586: ireturn
    //   587: astore_3
    //   588: aload 6
    //   590: ifnull +52 -> 642
    //   593: aload 6
    //   595: invokevirtual 83	java/io/BufferedOutputStream:close	()V
    //   598: goto +44 -> 642
    //   601: astore 6
    //   603: new 85	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   610: astore 7
    //   612: aload 7
    //   614: ldc 89
    //   616: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 7
    //   622: aload 6
    //   624: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   627: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: ldc 99
    //   633: iconst_1
    //   634: aload 7
    //   636: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: aload_2
    //   643: ifnull +49 -> 692
    //   646: aload_2
    //   647: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   650: goto +42 -> 692
    //   653: astore_2
    //   654: new 85	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   661: astore 6
    //   663: aload 6
    //   665: ldc 89
    //   667: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 6
    //   673: aload_2
    //   674: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   677: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: ldc 99
    //   683: iconst_1
    //   684: aload 6
    //   686: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: aload 5
    //   694: ifnull +50 -> 744
    //   697: aload 5
    //   699: invokevirtual 108	java/io/BufferedInputStream:close	()V
    //   702: goto +42 -> 744
    //   705: astore_2
    //   706: new 85	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   713: astore 5
    //   715: aload 5
    //   717: ldc 89
    //   719: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 5
    //   725: aload_2
    //   726: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   729: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: ldc 99
    //   735: iconst_1
    //   736: aload 5
    //   738: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: aload_1
    //   745: ifnull +45 -> 790
    //   748: aload_1
    //   749: invokevirtual 111	java/io/InputStream:close	()V
    //   752: goto +38 -> 790
    //   755: astore_1
    //   756: new 85	java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   763: astore_2
    //   764: aload_2
    //   765: ldc 89
    //   767: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload_2
    //   772: aload_1
    //   773: invokevirtual 97	java/io/IOException:toString	()Ljava/lang/String;
    //   776: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: ldc 99
    //   782: iconst_1
    //   783: aload_2
    //   784: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   790: goto +5 -> 795
    //   793: aload_3
    //   794: athrow
    //   795: goto -2 -> 793
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	this	AssetsPmUpdater
    //   0	798	1	paramContext	Context
    //   0	798	2	paramString1	String
    //   0	798	3	paramString2	String
    //   86	13	4	i	int
    //   26	711	5	localObject1	Object
    //   1	593	6	localObject2	Object
    //   601	22	6	localIOException1	IOException
    //   661	24	6	localStringBuilder1	StringBuilder
    //   4	1	7	localObject3	Object
    //   288	6	7	localObject4	Object
    //   299	71	7	localIOException2	IOException
    //   610	25	7	localStringBuilder2	StringBuilder
    //   7	305	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   110	114	117	java/io/IOException
    //   156	160	163	java/io/IOException
    //   198	203	206	java/io/IOException
    //   245	249	251	java/io/IOException
    //   72	79	288	finally
    //   79	88	288	finally
    //   94	103	288	finally
    //   106	110	288	finally
    //   72	79	299	java/io/IOException
    //   79	88	299	java/io/IOException
    //   94	103	299	java/io/IOException
    //   106	110	299	java/io/IOException
    //   63	72	310	finally
    //   63	72	318	java/io/IOException
    //   28	49	322	finally
    //   49	63	322	finally
    //   28	49	332	java/io/IOException
    //   49	63	332	java/io/IOException
    //   18	28	338	finally
    //   18	28	351	java/io/IOException
    //   9	18	360	finally
    //   9	18	376	java/io/IOException
    //   399	404	407	java/io/IOException
    //   450	454	457	java/io/IOException
    //   497	502	505	java/io/IOException
    //   544	548	550	java/io/IOException
    //   385	394	587	finally
    //   593	598	601	java/io/IOException
    //   646	650	653	java/io/IOException
    //   697	702	705	java/io/IOException
    //   748	752	755	java/io/IOException
  }
  
  private static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.list(paramString1);
      if (paramContext != null)
      {
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramContext[i].equals(paramString2);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (IOException paramContext)
    {
      QLog.e("studyroom.AssetsPmUpdater", 1, "isAssertFileExists", paramContext);
    }
  }
  
  public boolean a()
  {
    return b(this.d, "shadow/", this.b);
  }
  
  public File getLatest()
  {
    if (a())
    {
      if ((!this.a.exists()) || (!this.e))
      {
        long l = System.currentTimeMillis();
        if (a(this.d, this.c, this.a.getAbsolutePath()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("copy asset pm success, cost=");
          localStringBuilder.append(System.currentTimeMillis() - l);
          QLog.i("studyroom.AssetsPmUpdater", 1, localStringBuilder.toString());
        }
        else
        {
          QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
        }
      }
      if (this.a.exists()) {
        return this.a;
      }
    }
    return null;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    throw new UnsupportedOperationException(HardCodeUtil.a(2131899705));
  }
  
  public Future<File> update()
  {
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.AssetsPmUpdater", 2, "update");
    }
    Future localFuture = this.f;
    if ((localFuture != null) && (!localFuture.isDone()) && (!this.f.isCancelled()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("studyroom.AssetsPmUpdater", 2, "上一次update还没结束，返回相同Future");
      }
      return this.f;
    }
    this.f = ThreadManagerExecutor.getExecutorService(192).submit(new AssetsPmUpdater.1(this));
    return this.f;
  }
  
  public boolean wasUpdating()
  {
    Future localFuture = this.f;
    return (localFuture != null) && (!localFuture.isDone()) && (!this.f.isCancelled());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.AssetsPmUpdater
 * JD-Core Version:    0.7.0.1
 */