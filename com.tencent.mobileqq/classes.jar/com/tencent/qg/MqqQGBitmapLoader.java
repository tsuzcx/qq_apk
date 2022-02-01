package com.tencent.qg;

import com.tencent.qg.sdk.QGBitmapLoader.QGBitmapLoaderImpl;

public class MqqQGBitmapLoader
  implements QGBitmapLoader.QGBitmapLoaderImpl
{
  /* Error */
  public android.graphics.Bitmap load(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_1
    //   7: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +28 -> 46
    //   21: ldc 37
    //   23: iconst_2
    //   24: new 39	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   31: ldc 42
    //   33: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: ldc 56
    //   48: monitorenter
    //   49: aload_1
    //   50: invokestatic 61	com/tencent/mobileqq/utils/CommonImageCacheHelper:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +15 -> 70
    //   58: aload_2
    //   59: invokevirtual 66	android/graphics/Bitmap:isRecycled	()Z
    //   62: ifne +8 -> 70
    //   65: ldc 56
    //   67: monitorexit
    //   68: aload_2
    //   69: areturn
    //   70: ldc 56
    //   72: monitorexit
    //   73: aload_1
    //   74: invokestatic 72	com/tencent/biz/common/util/HttpUtil:isValidUrl	(Ljava/lang/String;)Z
    //   77: ifeq +368 -> 445
    //   80: new 74	java/net/URL
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 77	java/net/URL:<init>	(Ljava/lang/String;)V
    //   88: astore_3
    //   89: ldc 79
    //   91: invokestatic 85	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   94: checkcast 79	com/tencent/biz/pubaccount/util/api/IPublicAccountHttpDownloader
    //   97: invokeinterface 89 1 0
    //   102: astore 4
    //   104: new 91	com/tencent/image/DownloadParams
    //   107: dup
    //   108: invokespecial 92	com/tencent/image/DownloadParams:<init>	()V
    //   111: astore 5
    //   113: aload 5
    //   115: aload_3
    //   116: putfield 96	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   119: aload 5
    //   121: aload_1
    //   122: putfield 100	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   125: aload 4
    //   127: aload 5
    //   129: new 102	com/tencent/qg/MqqQGBitmapLoader$1
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 105	com/tencent/qg/MqqQGBitmapLoader$1:<init>	(Lcom/tencent/qg/MqqQGBitmapLoader;)V
    //   137: invokevirtual 111	com/tencent/mobileqq/transfile/HttpDownloader:loadImageFile	(Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   140: astore_3
    //   141: aload_3
    //   142: astore 8
    //   144: aload_3
    //   145: ifnonnull +28 -> 173
    //   148: new 23	java/io/IOException
    //   151: dup
    //   152: ldc 113
    //   154: invokespecial 114	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   157: athrow
    //   158: astore 4
    //   160: ldc 37
    //   162: ldc 116
    //   164: aload 4
    //   166: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   169: pop
    //   170: aload_3
    //   171: astore 8
    //   173: aload 8
    //   175: ifnull +283 -> 458
    //   178: aload_2
    //   179: astore_3
    //   180: aload_2
    //   181: astore 4
    //   183: aload_2
    //   184: astore 5
    //   186: aload 10
    //   188: astore 7
    //   190: aload 8
    //   192: invokevirtual 127	java/io/File:exists	()Z
    //   195: ifeq +263 -> 458
    //   198: aload_2
    //   199: astore_3
    //   200: aload_2
    //   201: astore 4
    //   203: aload_2
    //   204: astore 5
    //   206: aload 10
    //   208: astore 7
    //   210: aload 8
    //   212: invokevirtual 130	java/io/File:getPath	()Ljava/lang/String;
    //   215: invokestatic 135	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   218: astore 6
    //   220: aload 6
    //   222: astore_2
    //   223: aload 6
    //   225: astore_3
    //   226: aload 6
    //   228: astore 4
    //   230: aload 6
    //   232: astore 5
    //   234: aload 10
    //   236: astore 7
    //   238: aload_1
    //   239: invokestatic 72	com/tencent/biz/common/util/HttpUtil:isValidUrl	(Ljava/lang/String;)Z
    //   242: ifeq +78 -> 320
    //   245: aload 6
    //   247: astore_2
    //   248: aload 6
    //   250: astore_3
    //   251: aload 6
    //   253: astore 4
    //   255: aload 6
    //   257: astore 5
    //   259: aload 10
    //   261: astore 7
    //   263: aload 8
    //   265: invokestatic 141	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   268: ifeq +52 -> 320
    //   271: aload 6
    //   273: astore_3
    //   274: aload 6
    //   276: astore 4
    //   278: aload 6
    //   280: astore 5
    //   282: aload 10
    //   284: astore 7
    //   286: aload 6
    //   288: bipush 100
    //   290: aload 8
    //   292: invokestatic 146	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   295: pop
    //   296: aload 6
    //   298: astore_3
    //   299: aload 6
    //   301: astore 4
    //   303: aload 6
    //   305: astore 5
    //   307: aload 10
    //   309: astore 7
    //   311: aload 8
    //   313: invokevirtual 130	java/io/File:getPath	()Ljava/lang/String;
    //   316: invokestatic 135	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   319: astore_2
    //   320: aload_2
    //   321: astore_3
    //   322: aload_2
    //   323: astore 4
    //   325: aload_2
    //   326: astore 5
    //   328: aload 10
    //   330: astore 7
    //   332: ldc 37
    //   334: iconst_2
    //   335: new 39	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   342: ldc 148
    //   344: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 8
    //   349: invokevirtual 130	java/io/File:getPath	()Ljava/lang/String;
    //   352: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload 9
    //   363: astore_3
    //   364: aload_2
    //   365: astore 4
    //   367: aload 4
    //   369: astore_2
    //   370: aload_3
    //   371: ifnull +10 -> 381
    //   374: aload_3
    //   375: invokevirtual 153	java/io/InputStream:close	()V
    //   378: aload 4
    //   380: astore_2
    //   381: ldc 56
    //   383: monitorenter
    //   384: aload_2
    //   385: ifnull +15 -> 400
    //   388: aload_2
    //   389: invokevirtual 66	android/graphics/Bitmap:isRecycled	()Z
    //   392: ifne +8 -> 400
    //   395: aload_1
    //   396: aload_2
    //   397: invokestatic 156	com/tencent/mobileqq/utils/CommonImageCacheHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   400: ldc 56
    //   402: monitorexit
    //   403: aload_2
    //   404: areturn
    //   405: astore_1
    //   406: ldc 56
    //   408: monitorexit
    //   409: aload_1
    //   410: athrow
    //   411: astore_1
    //   412: ldc 56
    //   414: monitorexit
    //   415: aload_1
    //   416: athrow
    //   417: astore_2
    //   418: ldc 37
    //   420: iconst_2
    //   421: new 39	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   428: ldc 158
    //   430: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_1
    //   434: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: aconst_null
    //   444: areturn
    //   445: new 124	java/io/File
    //   448: dup
    //   449: aload_1
    //   450: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   453: astore 8
    //   455: goto -282 -> 173
    //   458: aload_2
    //   459: astore_3
    //   460: aload_2
    //   461: astore 4
    //   463: aload_2
    //   464: astore 5
    //   466: aload 10
    //   468: astore 7
    //   470: getstatic 167	com/tencent/qg/sdk/QGRenderer:assetManager	Landroid/content/res/AssetManager;
    //   473: aload_1
    //   474: invokevirtual 173	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   477: astore 6
    //   479: aload 6
    //   481: astore_3
    //   482: aload_3
    //   483: astore 7
    //   485: aload_3
    //   486: invokestatic 177	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   489: astore 4
    //   491: goto -124 -> 367
    //   494: astore_2
    //   495: aload_2
    //   496: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   499: aload 4
    //   501: astore_2
    //   502: goto -121 -> 381
    //   505: astore 5
    //   507: aconst_null
    //   508: astore 4
    //   510: aload 4
    //   512: astore_2
    //   513: ldc 37
    //   515: ldc 182
    //   517: aload 5
    //   519: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   522: pop
    //   523: aload_3
    //   524: astore_2
    //   525: aload 4
    //   527: ifnull -146 -> 381
    //   530: aload 4
    //   532: invokevirtual 153	java/io/InputStream:close	()V
    //   535: aload_3
    //   536: astore_2
    //   537: goto -156 -> 381
    //   540: astore_2
    //   541: aload_2
    //   542: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   545: aload_3
    //   546: astore_2
    //   547: goto -166 -> 381
    //   550: astore 5
    //   552: aload 4
    //   554: astore_3
    //   555: aconst_null
    //   556: astore 4
    //   558: aload 4
    //   560: astore_2
    //   561: ldc 37
    //   563: ldc 184
    //   565: aload 5
    //   567: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   570: pop
    //   571: aload_3
    //   572: astore_2
    //   573: aload 4
    //   575: ifnull -194 -> 381
    //   578: aload 4
    //   580: invokevirtual 153	java/io/InputStream:close	()V
    //   583: aload_3
    //   584: astore_2
    //   585: goto -204 -> 381
    //   588: astore_2
    //   589: aload_2
    //   590: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   593: aload_3
    //   594: astore_2
    //   595: goto -214 -> 381
    //   598: astore_2
    //   599: aload 5
    //   601: astore_3
    //   602: aconst_null
    //   603: astore 4
    //   605: aload_2
    //   606: astore 5
    //   608: aload 4
    //   610: astore_2
    //   611: ldc 37
    //   613: ldc 186
    //   615: aload 5
    //   617: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   620: pop
    //   621: aload 4
    //   623: astore_2
    //   624: aload 5
    //   626: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   629: aload_3
    //   630: astore_2
    //   631: aload 4
    //   633: ifnull -252 -> 381
    //   636: aload 4
    //   638: invokevirtual 153	java/io/InputStream:close	()V
    //   641: aload_3
    //   642: astore_2
    //   643: goto -262 -> 381
    //   646: astore_2
    //   647: aload_2
    //   648: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   651: aload_3
    //   652: astore_2
    //   653: goto -272 -> 381
    //   656: astore_1
    //   657: aload 7
    //   659: ifnull +8 -> 667
    //   662: aload 7
    //   664: invokevirtual 153	java/io/InputStream:close	()V
    //   667: aload_1
    //   668: athrow
    //   669: astore_2
    //   670: aload_2
    //   671: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   674: goto -7 -> 667
    //   677: astore_1
    //   678: aload_2
    //   679: astore 7
    //   681: goto -24 -> 657
    //   684: astore 5
    //   686: aload_3
    //   687: astore 4
    //   689: aload_2
    //   690: astore_3
    //   691: goto -83 -> 608
    //   694: astore 5
    //   696: aload_3
    //   697: astore 4
    //   699: aload_2
    //   700: astore_3
    //   701: goto -143 -> 558
    //   704: astore 5
    //   706: aload_3
    //   707: astore 4
    //   709: aload_2
    //   710: astore_3
    //   711: goto -201 -> 510
    //   714: astore 4
    //   716: aconst_null
    //   717: astore_3
    //   718: goto -558 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	MqqQGBitmapLoader
    //   0	721	1	paramString	java.lang.String
    //   53	351	2	localObject1	Object
    //   417	47	2	localMalformedURLException	java.net.MalformedURLException
    //   494	2	2	localIOException1	java.io.IOException
    //   501	36	2	localObject2	Object
    //   540	2	2	localIOException2	java.io.IOException
    //   546	39	2	localObject3	Object
    //   588	2	2	localIOException3	java.io.IOException
    //   594	1	2	localObject4	Object
    //   598	8	2	localIOException4	java.io.IOException
    //   610	33	2	localObject5	Object
    //   646	2	2	localIOException5	java.io.IOException
    //   652	1	2	localObject6	Object
    //   669	41	2	localIOException6	java.io.IOException
    //   88	630	3	localObject7	Object
    //   102	24	4	localHttpDownloader	com.tencent.mobileqq.transfile.HttpDownloader
    //   158	7	4	localThrowable1	java.lang.Throwable
    //   181	527	4	localObject8	Object
    //   714	1	4	localThrowable2	java.lang.Throwable
    //   111	354	5	localObject9	Object
    //   505	13	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   550	50	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   606	19	5	localIOException7	java.io.IOException
    //   684	1	5	localIOException8	java.io.IOException
    //   694	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   704	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   218	262	6	localObject10	Object
    //   188	492	7	localObject11	Object
    //   142	312	8	localObject12	Object
    //   4	358	9	localObject13	Object
    //   1	466	10	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   148	158	158	java/lang/Throwable
    //   388	400	405	finally
    //   400	403	405	finally
    //   406	409	405	finally
    //   49	54	411	finally
    //   58	68	411	finally
    //   70	73	411	finally
    //   412	415	411	finally
    //   80	89	417	java/net/MalformedURLException
    //   374	378	494	java/io/IOException
    //   190	198	505	java/lang/OutOfMemoryError
    //   210	220	505	java/lang/OutOfMemoryError
    //   238	245	505	java/lang/OutOfMemoryError
    //   263	271	505	java/lang/OutOfMemoryError
    //   286	296	505	java/lang/OutOfMemoryError
    //   311	320	505	java/lang/OutOfMemoryError
    //   332	361	505	java/lang/OutOfMemoryError
    //   470	479	505	java/lang/OutOfMemoryError
    //   530	535	540	java/io/IOException
    //   190	198	550	java/io/FileNotFoundException
    //   210	220	550	java/io/FileNotFoundException
    //   238	245	550	java/io/FileNotFoundException
    //   263	271	550	java/io/FileNotFoundException
    //   286	296	550	java/io/FileNotFoundException
    //   311	320	550	java/io/FileNotFoundException
    //   332	361	550	java/io/FileNotFoundException
    //   470	479	550	java/io/FileNotFoundException
    //   578	583	588	java/io/IOException
    //   190	198	598	java/io/IOException
    //   210	220	598	java/io/IOException
    //   238	245	598	java/io/IOException
    //   263	271	598	java/io/IOException
    //   286	296	598	java/io/IOException
    //   311	320	598	java/io/IOException
    //   332	361	598	java/io/IOException
    //   470	479	598	java/io/IOException
    //   636	641	646	java/io/IOException
    //   190	198	656	finally
    //   210	220	656	finally
    //   238	245	656	finally
    //   263	271	656	finally
    //   286	296	656	finally
    //   311	320	656	finally
    //   332	361	656	finally
    //   470	479	656	finally
    //   485	491	656	finally
    //   662	667	669	java/io/IOException
    //   513	523	677	finally
    //   561	571	677	finally
    //   611	621	677	finally
    //   624	629	677	finally
    //   485	491	684	java/io/IOException
    //   485	491	694	java/io/FileNotFoundException
    //   485	491	704	java/lang/OutOfMemoryError
    //   125	141	714	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.MqqQGBitmapLoader
 * JD-Core Version:    0.7.0.1
 */