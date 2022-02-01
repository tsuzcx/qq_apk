package com.tencent.qg;

import com.tencent.qg.sdk.QGBitmapLoader.QGBitmapLoaderImpl;

public class MqqQGBitmapLoader
  implements QGBitmapLoader.QGBitmapLoaderImpl
{
  /* Error */
  public android.graphics.Bitmap load(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 14
    //   8: aconst_null
    //   9: astore 15
    //   11: aconst_null
    //   12: astore 16
    //   14: aconst_null
    //   15: astore 17
    //   17: aconst_null
    //   18: astore 13
    //   20: iload_2
    //   21: ifeq +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +34 -> 63
    //   32: new 37	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   39: astore_3
    //   40: aload_3
    //   41: ldc 40
    //   43: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: aload_1
    //   49: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 46
    //   55: iconst_2
    //   56: aload_3
    //   57: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: ldc 56
    //   65: monitorenter
    //   66: aload_1
    //   67: invokestatic 61	com/tencent/mobileqq/utils/CommonImageCacheHelper:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   70: astore 8
    //   72: aload 8
    //   74: ifnull +17 -> 91
    //   77: aload 8
    //   79: invokevirtual 66	android/graphics/Bitmap:isRecycled	()Z
    //   82: ifne +9 -> 91
    //   85: ldc 56
    //   87: monitorexit
    //   88: aload 8
    //   90: areturn
    //   91: ldc 56
    //   93: monitorexit
    //   94: aload_1
    //   95: invokestatic 72	com/tencent/biz/common/util/HttpUtil:isValidUrl	(Ljava/lang/String;)Z
    //   98: ifeq +139 -> 237
    //   101: new 74	java/net/URL
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 77	java/net/URL:<init>	(Ljava/lang/String;)V
    //   109: astore_3
    //   110: ldc 79
    //   112: invokestatic 85	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   115: checkcast 79	com/tencent/mobileqq/kandian/base/image/api/IPublicAccountHttpDownloader
    //   118: invokeinterface 89 1 0
    //   123: checkcast 91	com/tencent/mobileqq/transfile/HttpDownloader
    //   126: astore 4
    //   128: new 93	com/tencent/image/DownloadParams
    //   131: dup
    //   132: invokespecial 94	com/tencent/image/DownloadParams:<init>	()V
    //   135: astore 5
    //   137: aload 5
    //   139: aload_3
    //   140: putfield 98	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   143: aload 5
    //   145: aload_1
    //   146: putfield 102	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   149: aload 4
    //   151: aload 5
    //   153: new 104	com/tencent/qg/MqqQGBitmapLoader$1
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 107	com/tencent/qg/MqqQGBitmapLoader$1:<init>	(Lcom/tencent/qg/MqqQGBitmapLoader;)V
    //   161: invokevirtual 111	com/tencent/mobileqq/transfile/HttpDownloader:loadImageFile	(Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   164: astore 12
    //   166: aload 12
    //   168: ifnull +6 -> 174
    //   171: goto +76 -> 247
    //   174: new 23	java/io/IOException
    //   177: dup
    //   178: ldc 113
    //   180: invokespecial 114	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   183: athrow
    //   184: astore_3
    //   185: goto +7 -> 192
    //   188: astore_3
    //   189: aconst_null
    //   190: astore 12
    //   192: ldc 46
    //   194: ldc 116
    //   196: aload_3
    //   197: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   200: pop
    //   201: goto +46 -> 247
    //   204: new 37	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   211: astore_3
    //   212: aload_3
    //   213: ldc 124
    //   215: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: aload_1
    //   221: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 46
    //   227: iconst_2
    //   228: aload_3
    //   229: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aconst_null
    //   236: areturn
    //   237: new 128	java/io/File
    //   240: dup
    //   241: aload_1
    //   242: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore 12
    //   247: aload 12
    //   249: ifnull +378 -> 627
    //   252: aload 14
    //   254: astore 4
    //   256: aload 15
    //   258: astore 9
    //   260: aload 8
    //   262: astore 5
    //   264: aload 16
    //   266: astore 10
    //   268: aload 8
    //   270: astore 6
    //   272: aload 17
    //   274: astore 11
    //   276: aload 8
    //   278: astore 7
    //   280: aload 12
    //   282: invokevirtual 132	java/io/File:exists	()Z
    //   285: ifeq +342 -> 627
    //   288: aload 14
    //   290: astore 4
    //   292: aload 15
    //   294: astore 9
    //   296: aload 8
    //   298: astore 5
    //   300: aload 16
    //   302: astore 10
    //   304: aload 8
    //   306: astore 6
    //   308: aload 17
    //   310: astore 11
    //   312: aload 8
    //   314: astore 7
    //   316: aload 12
    //   318: invokevirtual 135	java/io/File:getPath	()Ljava/lang/String;
    //   321: invokestatic 140	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   324: astore 8
    //   326: aload 8
    //   328: astore_3
    //   329: aload 14
    //   331: astore 4
    //   333: aload 15
    //   335: astore 9
    //   337: aload 8
    //   339: astore 5
    //   341: aload 16
    //   343: astore 10
    //   345: aload 8
    //   347: astore 6
    //   349: aload 17
    //   351: astore 11
    //   353: aload 8
    //   355: astore 7
    //   357: aload_1
    //   358: invokestatic 72	com/tencent/biz/common/util/HttpUtil:isValidUrl	(Ljava/lang/String;)Z
    //   361: ifeq +117 -> 478
    //   364: aload 8
    //   366: astore_3
    //   367: aload 14
    //   369: astore 4
    //   371: aload 15
    //   373: astore 9
    //   375: aload 8
    //   377: astore 5
    //   379: aload 16
    //   381: astore 10
    //   383: aload 8
    //   385: astore 6
    //   387: aload 17
    //   389: astore 11
    //   391: aload 8
    //   393: astore 7
    //   395: aload 12
    //   397: invokestatic 146	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   400: ifeq +78 -> 478
    //   403: aload 14
    //   405: astore 4
    //   407: aload 15
    //   409: astore 9
    //   411: aload 8
    //   413: astore 5
    //   415: aload 16
    //   417: astore 10
    //   419: aload 8
    //   421: astore 6
    //   423: aload 17
    //   425: astore 11
    //   427: aload 8
    //   429: astore 7
    //   431: aload 8
    //   433: bipush 100
    //   435: aload 12
    //   437: invokestatic 151	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   440: pop
    //   441: aload 14
    //   443: astore 4
    //   445: aload 15
    //   447: astore 9
    //   449: aload 8
    //   451: astore 5
    //   453: aload 16
    //   455: astore 10
    //   457: aload 8
    //   459: astore 6
    //   461: aload 17
    //   463: astore 11
    //   465: aload 8
    //   467: astore 7
    //   469: aload 12
    //   471: invokevirtual 135	java/io/File:getPath	()Ljava/lang/String;
    //   474: invokestatic 140	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   477: astore_3
    //   478: aload 14
    //   480: astore 4
    //   482: aload 15
    //   484: astore 9
    //   486: aload_3
    //   487: astore 5
    //   489: aload 16
    //   491: astore 10
    //   493: aload_3
    //   494: astore 6
    //   496: aload 17
    //   498: astore 11
    //   500: aload_3
    //   501: astore 7
    //   503: new 37	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   510: astore 8
    //   512: aload 14
    //   514: astore 4
    //   516: aload 15
    //   518: astore 9
    //   520: aload_3
    //   521: astore 5
    //   523: aload 16
    //   525: astore 10
    //   527: aload_3
    //   528: astore 6
    //   530: aload 17
    //   532: astore 11
    //   534: aload_3
    //   535: astore 7
    //   537: aload 8
    //   539: ldc 153
    //   541: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 14
    //   547: astore 4
    //   549: aload 15
    //   551: astore 9
    //   553: aload_3
    //   554: astore 5
    //   556: aload 16
    //   558: astore 10
    //   560: aload_3
    //   561: astore 6
    //   563: aload 17
    //   565: astore 11
    //   567: aload_3
    //   568: astore 7
    //   570: aload 8
    //   572: aload 12
    //   574: invokevirtual 135	java/io/File:getPath	()Ljava/lang/String;
    //   577: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 14
    //   583: astore 4
    //   585: aload 15
    //   587: astore 9
    //   589: aload_3
    //   590: astore 5
    //   592: aload 16
    //   594: astore 10
    //   596: aload_3
    //   597: astore 6
    //   599: aload 17
    //   601: astore 11
    //   603: aload_3
    //   604: astore 7
    //   606: ldc 46
    //   608: iconst_2
    //   609: aload 8
    //   611: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: aload 13
    //   619: astore 5
    //   621: aload_3
    //   622: astore 4
    //   624: goto +76 -> 700
    //   627: aload 14
    //   629: astore 4
    //   631: aload 15
    //   633: astore 9
    //   635: aload 8
    //   637: astore 5
    //   639: aload 16
    //   641: astore 10
    //   643: aload 8
    //   645: astore 6
    //   647: aload 17
    //   649: astore 11
    //   651: aload 8
    //   653: astore 7
    //   655: getstatic 159	com/tencent/qg/sdk/QGRenderer:assetManager	Landroid/content/res/AssetManager;
    //   658: aload_1
    //   659: invokevirtual 165	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   662: astore_3
    //   663: aload_3
    //   664: astore 4
    //   666: aload_3
    //   667: astore 9
    //   669: aload 8
    //   671: astore 5
    //   673: aload_3
    //   674: astore 10
    //   676: aload 8
    //   678: astore 6
    //   680: aload_3
    //   681: astore 11
    //   683: aload 8
    //   685: astore 7
    //   687: aload_3
    //   688: invokestatic 169	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   691: astore 8
    //   693: aload 8
    //   695: astore 4
    //   697: aload_3
    //   698: astore 5
    //   700: aload 4
    //   702: astore_3
    //   703: aload 5
    //   705: ifnull +144 -> 849
    //   708: aload 4
    //   710: astore_3
    //   711: aload 5
    //   713: invokevirtual 174	java/io/InputStream:close	()V
    //   716: aload 4
    //   718: astore_3
    //   719: goto +130 -> 849
    //   722: astore 4
    //   724: aload 4
    //   726: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   729: goto +120 -> 849
    //   732: astore_1
    //   733: goto +146 -> 879
    //   736: astore_3
    //   737: aload 9
    //   739: astore 4
    //   741: ldc 46
    //   743: ldc 179
    //   745: aload_3
    //   746: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   749: pop
    //   750: aload 9
    //   752: astore 4
    //   754: aload_3
    //   755: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   758: aload 5
    //   760: astore_3
    //   761: aload 9
    //   763: ifnull +86 -> 849
    //   766: aload 5
    //   768: astore_3
    //   769: aload 9
    //   771: invokevirtual 174	java/io/InputStream:close	()V
    //   774: aload 5
    //   776: astore_3
    //   777: goto +72 -> 849
    //   780: astore_3
    //   781: aload 10
    //   783: astore 4
    //   785: ldc 46
    //   787: ldc 181
    //   789: aload_3
    //   790: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   793: pop
    //   794: aload 6
    //   796: astore_3
    //   797: aload 10
    //   799: ifnull +50 -> 849
    //   802: aload 6
    //   804: astore_3
    //   805: aload 10
    //   807: invokevirtual 174	java/io/InputStream:close	()V
    //   810: aload 6
    //   812: astore_3
    //   813: goto +36 -> 849
    //   816: astore_3
    //   817: aload 11
    //   819: astore 4
    //   821: ldc 46
    //   823: ldc 183
    //   825: aload_3
    //   826: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   829: pop
    //   830: aload 7
    //   832: astore_3
    //   833: aload 11
    //   835: ifnull +14 -> 849
    //   838: aload 7
    //   840: astore_3
    //   841: aload 11
    //   843: invokevirtual 174	java/io/InputStream:close	()V
    //   846: aload 7
    //   848: astore_3
    //   849: ldc 56
    //   851: monitorenter
    //   852: aload_3
    //   853: ifnull +15 -> 868
    //   856: aload_3
    //   857: invokevirtual 66	android/graphics/Bitmap:isRecycled	()Z
    //   860: ifne +8 -> 868
    //   863: aload_1
    //   864: aload_3
    //   865: invokestatic 186	com/tencent/mobileqq/utils/CommonImageCacheHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   868: ldc 56
    //   870: monitorexit
    //   871: aload_3
    //   872: areturn
    //   873: astore_1
    //   874: ldc 56
    //   876: monitorexit
    //   877: aload_1
    //   878: athrow
    //   879: aload 4
    //   881: ifnull +16 -> 897
    //   884: aload 4
    //   886: invokevirtual 174	java/io/InputStream:close	()V
    //   889: goto +8 -> 897
    //   892: astore_3
    //   893: aload_3
    //   894: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   897: aload_1
    //   898: athrow
    //   899: astore_1
    //   900: ldc 56
    //   902: monitorexit
    //   903: aload_1
    //   904: athrow
    //   905: astore_3
    //   906: goto -702 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	909	0	this	MqqQGBitmapLoader
    //   0	909	1	paramString	java.lang.String
    //   4	17	2	bool	boolean
    //   39	101	3	localObject1	Object
    //   184	1	3	localThrowable1	java.lang.Throwable
    //   188	9	3	localThrowable2	java.lang.Throwable
    //   211	508	3	localObject2	Object
    //   736	19	3	localIOException1	java.io.IOException
    //   760	17	3	localObject3	Object
    //   780	10	3	localFileNotFoundException	java.io.FileNotFoundException
    //   796	17	3	localObject4	Object
    //   816	10	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   832	40	3	localObject5	Object
    //   892	2	3	localIOException2	java.io.IOException
    //   905	1	3	localMalformedURLException	java.net.MalformedURLException
    //   126	591	4	localObject6	Object
    //   722	3	4	localIOException3	java.io.IOException
    //   739	146	4	localObject7	Object
    //   135	640	5	localObject8	Object
    //   270	541	6	localObject9	Object
    //   278	569	7	localObject10	Object
    //   70	624	8	localObject11	Object
    //   258	512	9	localObject12	Object
    //   266	540	10	localObject13	Object
    //   274	568	11	localObject14	Object
    //   164	409	12	localFile	java.io.File
    //   18	600	13	localObject15	Object
    //   6	622	14	localObject16	Object
    //   9	623	15	localObject17	Object
    //   12	628	16	localObject18	Object
    //   15	633	17	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   174	184	184	java/lang/Throwable
    //   149	166	188	java/lang/Throwable
    //   711	716	722	java/io/IOException
    //   769	774	722	java/io/IOException
    //   805	810	722	java/io/IOException
    //   841	846	722	java/io/IOException
    //   280	288	732	finally
    //   316	326	732	finally
    //   357	364	732	finally
    //   395	403	732	finally
    //   431	441	732	finally
    //   469	478	732	finally
    //   503	512	732	finally
    //   537	545	732	finally
    //   570	581	732	finally
    //   606	617	732	finally
    //   655	663	732	finally
    //   687	693	732	finally
    //   741	750	732	finally
    //   754	758	732	finally
    //   785	794	732	finally
    //   821	830	732	finally
    //   280	288	736	java/io/IOException
    //   316	326	736	java/io/IOException
    //   357	364	736	java/io/IOException
    //   395	403	736	java/io/IOException
    //   431	441	736	java/io/IOException
    //   469	478	736	java/io/IOException
    //   503	512	736	java/io/IOException
    //   537	545	736	java/io/IOException
    //   570	581	736	java/io/IOException
    //   606	617	736	java/io/IOException
    //   655	663	736	java/io/IOException
    //   687	693	736	java/io/IOException
    //   280	288	780	java/io/FileNotFoundException
    //   316	326	780	java/io/FileNotFoundException
    //   357	364	780	java/io/FileNotFoundException
    //   395	403	780	java/io/FileNotFoundException
    //   431	441	780	java/io/FileNotFoundException
    //   469	478	780	java/io/FileNotFoundException
    //   503	512	780	java/io/FileNotFoundException
    //   537	545	780	java/io/FileNotFoundException
    //   570	581	780	java/io/FileNotFoundException
    //   606	617	780	java/io/FileNotFoundException
    //   655	663	780	java/io/FileNotFoundException
    //   687	693	780	java/io/FileNotFoundException
    //   280	288	816	java/lang/OutOfMemoryError
    //   316	326	816	java/lang/OutOfMemoryError
    //   357	364	816	java/lang/OutOfMemoryError
    //   395	403	816	java/lang/OutOfMemoryError
    //   431	441	816	java/lang/OutOfMemoryError
    //   469	478	816	java/lang/OutOfMemoryError
    //   503	512	816	java/lang/OutOfMemoryError
    //   537	545	816	java/lang/OutOfMemoryError
    //   570	581	816	java/lang/OutOfMemoryError
    //   606	617	816	java/lang/OutOfMemoryError
    //   655	663	816	java/lang/OutOfMemoryError
    //   687	693	816	java/lang/OutOfMemoryError
    //   856	868	873	finally
    //   868	871	873	finally
    //   874	877	873	finally
    //   884	889	892	java/io/IOException
    //   66	72	899	finally
    //   77	88	899	finally
    //   91	94	899	finally
    //   900	903	899	finally
    //   101	110	905	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.MqqQGBitmapLoader
 * JD-Core Version:    0.7.0.1
 */