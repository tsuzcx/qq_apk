package com.tencent.ttpic.baseutils.device;

import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.device.DeviceCoffee;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class DeviceParser
{
  private static final String TAG = DeviceParser.class.getSimpleName();
  
  private static InputStream drinkACupOfCoffeeForCamera(InputStream paramInputStream, String paramString1, String paramString2)
  {
    return new ByteArrayInputStream(DeviceCoffee.drink(IOUtils.toByteArray(paramInputStream), paramString1, paramString2));
  }
  
  private static InputStream drinkACupOfCoffeeForFast(InputStream paramInputStream, String paramString)
  {
    return new ByteArrayInputStream(DeviceCoffee.drinkRawData(IOUtils.toByteArray(paramInputStream), paramString));
  }
  
  /* Error */
  public static String parseCameraAttrsFile(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: getstatic 16	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   6: new 55	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   13: ldc 58
    //   15: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 71	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: new 73	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 80	java/io/File:exists	()Z
    //   43: ifeq +410 -> 453
    //   46: aload 4
    //   48: invokevirtual 83	java/io/File:isFile	()Z
    //   51: ifeq +402 -> 453
    //   54: getstatic 16	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   57: ldc 85
    //   59: invokestatic 71	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: new 87	java/io/FileInputStream
    //   65: dup
    //   66: aload 4
    //   68: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_0
    //   72: aload_0
    //   73: aload_2
    //   74: aload_3
    //   75: invokestatic 92	com/tencent/ttpic/baseutils/device/DeviceParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   78: astore_1
    //   79: aload_0
    //   80: astore_2
    //   81: aload_1
    //   82: astore_3
    //   83: aload_0
    //   84: invokestatic 96	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   87: aload_0
    //   88: astore_2
    //   89: aload_1
    //   90: astore_3
    //   91: aload_1
    //   92: ifnull +21 -> 113
    //   95: aload_0
    //   96: astore_2
    //   97: aload_1
    //   98: astore 4
    //   100: aload_0
    //   101: astore_3
    //   102: aload_1
    //   103: astore 5
    //   105: aload_1
    //   106: invokevirtual 101	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: astore_3
    //   111: aload_0
    //   112: astore_2
    //   113: aload_3
    //   114: astore_1
    //   115: aload_2
    //   116: astore_0
    //   117: aload_1
    //   118: ifnull +823 -> 941
    //   121: new 103	java/io/InputStreamReader
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 105	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   129: astore 4
    //   131: new 107	java/io/BufferedReader
    //   134: dup
    //   135: aload 4
    //   137: sipush 1024
    //   140: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   143: astore_2
    //   144: aload_0
    //   145: astore 7
    //   147: aload 4
    //   149: astore 8
    //   151: aload_2
    //   152: astore 6
    //   154: aload_1
    //   155: astore 5
    //   157: new 112	java/lang/StringBuffer
    //   160: dup
    //   161: invokespecial 113	java/lang/StringBuffer:<init>	()V
    //   164: astore_3
    //   165: aload_0
    //   166: astore 7
    //   168: aload 4
    //   170: astore 8
    //   172: aload_2
    //   173: astore 6
    //   175: aload_1
    //   176: astore 5
    //   178: aload_2
    //   179: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   182: astore 9
    //   184: aload 9
    //   186: ifnull +443 -> 629
    //   189: aload_0
    //   190: astore 7
    //   192: aload 4
    //   194: astore 8
    //   196: aload_2
    //   197: astore 6
    //   199: aload_1
    //   200: astore 5
    //   202: aload_3
    //   203: aload 9
    //   205: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   208: pop
    //   209: goto -44 -> 165
    //   212: astore_3
    //   213: aload_0
    //   214: astore 7
    //   216: aload 4
    //   218: astore 8
    //   220: aload_2
    //   221: astore 6
    //   223: aload_1
    //   224: astore 5
    //   226: getstatic 16	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   229: ldc 121
    //   231: aload_3
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 125	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 126	java/io/BufferedReader:close	()V
    //   247: aload 4
    //   249: ifnull +8 -> 257
    //   252: aload 4
    //   254: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 101	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 128	java/io/FileInputStream:close	()V
    //   273: aconst_null
    //   274: astore_1
    //   275: aload_1
    //   276: areturn
    //   277: astore 4
    //   279: aconst_null
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_0
    //   283: aload_0
    //   284: astore_2
    //   285: aload_1
    //   286: astore_3
    //   287: aload 4
    //   289: invokevirtual 131	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   292: aload_0
    //   293: astore_2
    //   294: aload_1
    //   295: astore_3
    //   296: aload_1
    //   297: ifnull -184 -> 113
    //   300: aload_0
    //   301: astore_2
    //   302: aload_1
    //   303: astore 4
    //   305: aload_0
    //   306: astore_3
    //   307: aload_1
    //   308: astore 5
    //   310: aload_1
    //   311: invokevirtual 101	java/io/InputStream:close	()V
    //   314: aload_0
    //   315: astore_2
    //   316: aload_1
    //   317: astore_3
    //   318: goto -205 -> 113
    //   321: astore_3
    //   322: aconst_null
    //   323: astore 5
    //   325: aload 4
    //   327: astore_1
    //   328: aload_2
    //   329: astore_0
    //   330: aconst_null
    //   331: astore 4
    //   333: aload 5
    //   335: astore_2
    //   336: goto -123 -> 213
    //   339: astore 4
    //   341: aconst_null
    //   342: astore_1
    //   343: aconst_null
    //   344: astore_0
    //   345: aload_0
    //   346: astore_2
    //   347: aload_1
    //   348: astore_3
    //   349: aload 4
    //   351: invokevirtual 132	java/lang/Exception:printStackTrace	()V
    //   354: aload_0
    //   355: astore_2
    //   356: aload_1
    //   357: astore_3
    //   358: aload_1
    //   359: ifnull -246 -> 113
    //   362: aload_0
    //   363: astore_2
    //   364: aload_1
    //   365: astore 4
    //   367: aload_0
    //   368: astore_3
    //   369: aload_1
    //   370: astore 5
    //   372: aload_1
    //   373: invokevirtual 101	java/io/InputStream:close	()V
    //   376: aload_0
    //   377: astore_2
    //   378: aload_1
    //   379: astore_3
    //   380: goto -267 -> 113
    //   383: astore_2
    //   384: aconst_null
    //   385: astore_0
    //   386: aload 5
    //   388: astore_1
    //   389: aload 6
    //   391: astore 4
    //   393: aload_0
    //   394: ifnull +7 -> 401
    //   397: aload_0
    //   398: invokevirtual 126	java/io/BufferedReader:close	()V
    //   401: aload 4
    //   403: ifnull +8 -> 411
    //   406: aload 4
    //   408: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   411: aload_1
    //   412: ifnull +7 -> 419
    //   415: aload_1
    //   416: invokevirtual 101	java/io/InputStream:close	()V
    //   419: aload_3
    //   420: ifnull +7 -> 427
    //   423: aload_3
    //   424: invokevirtual 128	java/io/FileInputStream:close	()V
    //   427: aload_2
    //   428: athrow
    //   429: astore_2
    //   430: aconst_null
    //   431: astore_0
    //   432: aconst_null
    //   433: astore_1
    //   434: aload_1
    //   435: ifnull +7 -> 442
    //   438: aload_1
    //   439: invokevirtual 101	java/io/InputStream:close	()V
    //   442: aload_2
    //   443: athrow
    //   444: astore_3
    //   445: aconst_null
    //   446: astore_2
    //   447: aconst_null
    //   448: astore 4
    //   450: goto -237 -> 213
    //   453: getstatic 16	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   456: ldc 134
    //   458: invokestatic 71	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: aload_0
    //   462: ifnull +497 -> 959
    //   465: aload_0
    //   466: invokevirtual 140	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   469: aload_1
    //   470: invokevirtual 146	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   473: astore_0
    //   474: aload_0
    //   475: aload_2
    //   476: aload_3
    //   477: invokestatic 92	com/tencent/ttpic/baseutils/device/DeviceParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   480: astore_1
    //   481: aload_0
    //   482: astore_3
    //   483: aload_1
    //   484: astore_2
    //   485: aload_0
    //   486: invokestatic 96	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   489: aload_1
    //   490: astore_2
    //   491: aload_0
    //   492: ifnull +460 -> 952
    //   495: aload_1
    //   496: astore_2
    //   497: aload_1
    //   498: astore_3
    //   499: aload_0
    //   500: invokevirtual 101	java/io/InputStream:close	()V
    //   503: aconst_null
    //   504: astore_0
    //   505: goto -388 -> 117
    //   508: astore 5
    //   510: aconst_null
    //   511: astore 4
    //   513: aconst_null
    //   514: astore_0
    //   515: aload 4
    //   517: astore_3
    //   518: aload_0
    //   519: astore_2
    //   520: aload 5
    //   522: invokevirtual 131	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   525: aload_0
    //   526: astore_2
    //   527: aload 4
    //   529: ifnull +423 -> 952
    //   532: aload_0
    //   533: astore_2
    //   534: aload_0
    //   535: astore_3
    //   536: aload 4
    //   538: invokevirtual 101	java/io/InputStream:close	()V
    //   541: aconst_null
    //   542: astore_2
    //   543: aload_0
    //   544: astore_1
    //   545: aload_2
    //   546: astore_0
    //   547: goto -430 -> 117
    //   550: astore 5
    //   552: aconst_null
    //   553: astore 4
    //   555: aconst_null
    //   556: astore_0
    //   557: aload 4
    //   559: astore_3
    //   560: aload_0
    //   561: astore_2
    //   562: aload 5
    //   564: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   567: aload_0
    //   568: astore_2
    //   569: aload 4
    //   571: ifnull +381 -> 952
    //   574: aload_0
    //   575: astore_2
    //   576: aload_0
    //   577: astore_3
    //   578: aload 4
    //   580: invokevirtual 101	java/io/InputStream:close	()V
    //   583: aconst_null
    //   584: astore_2
    //   585: aload_0
    //   586: astore_1
    //   587: aload_2
    //   588: astore_0
    //   589: goto -472 -> 117
    //   592: aload 4
    //   594: ifnull +12 -> 606
    //   597: aload_0
    //   598: astore_2
    //   599: aload_0
    //   600: astore_3
    //   601: aload 4
    //   603: invokevirtual 101	java/io/InputStream:close	()V
    //   606: aload_0
    //   607: astore_2
    //   608: aload_0
    //   609: astore_3
    //   610: aload_1
    //   611: athrow
    //   612: astore_3
    //   613: aconst_null
    //   614: astore_0
    //   615: aconst_null
    //   616: astore 5
    //   618: aload_2
    //   619: astore_1
    //   620: aconst_null
    //   621: astore 4
    //   623: aload 5
    //   625: astore_2
    //   626: goto -413 -> 213
    //   629: aload_0
    //   630: astore 7
    //   632: aload 4
    //   634: astore 8
    //   636: aload_2
    //   637: astore 6
    //   639: aload_1
    //   640: astore 5
    //   642: aload_3
    //   643: invokevirtual 148	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   646: astore_3
    //   647: aload_2
    //   648: astore 5
    //   650: aload_3
    //   651: astore_2
    //   652: aload 5
    //   654: ifnull +8 -> 662
    //   657: aload 5
    //   659: invokevirtual 126	java/io/BufferedReader:close	()V
    //   662: aload 4
    //   664: ifnull +8 -> 672
    //   667: aload 4
    //   669: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   672: aload_1
    //   673: ifnull +7 -> 680
    //   676: aload_1
    //   677: invokevirtual 101	java/io/InputStream:close	()V
    //   680: aload_2
    //   681: astore_1
    //   682: aload_0
    //   683: ifnull -408 -> 275
    //   686: aload_0
    //   687: invokevirtual 128	java/io/FileInputStream:close	()V
    //   690: aload_2
    //   691: areturn
    //   692: astore_0
    //   693: aload_0
    //   694: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   697: aload_2
    //   698: areturn
    //   699: astore_0
    //   700: aload_0
    //   701: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   704: aconst_null
    //   705: areturn
    //   706: astore_0
    //   707: aload_0
    //   708: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   711: goto -284 -> 427
    //   714: astore_2
    //   715: aconst_null
    //   716: astore_3
    //   717: aconst_null
    //   718: astore_0
    //   719: aconst_null
    //   720: astore_1
    //   721: aload 6
    //   723: astore 4
    //   725: goto -332 -> 393
    //   728: astore_2
    //   729: aconst_null
    //   730: astore 5
    //   732: aload_0
    //   733: astore_3
    //   734: aload 6
    //   736: astore 4
    //   738: aload 5
    //   740: astore_0
    //   741: goto -348 -> 393
    //   744: astore_2
    //   745: aconst_null
    //   746: astore 4
    //   748: aconst_null
    //   749: astore_0
    //   750: aload_3
    //   751: astore_1
    //   752: aload 4
    //   754: astore_3
    //   755: aload 6
    //   757: astore 4
    //   759: goto -366 -> 393
    //   762: astore_2
    //   763: aconst_null
    //   764: astore 5
    //   766: aload_0
    //   767: astore_3
    //   768: aload 6
    //   770: astore 4
    //   772: aload 5
    //   774: astore_0
    //   775: goto -382 -> 393
    //   778: astore_2
    //   779: aconst_null
    //   780: astore 5
    //   782: aload_0
    //   783: astore_3
    //   784: aload 5
    //   786: astore_0
    //   787: goto -394 -> 393
    //   790: astore_2
    //   791: aload 8
    //   793: astore 4
    //   795: aload 7
    //   797: astore_3
    //   798: aload 6
    //   800: astore_0
    //   801: aload 5
    //   803: astore_1
    //   804: goto -411 -> 393
    //   807: astore_3
    //   808: aconst_null
    //   809: astore_0
    //   810: aconst_null
    //   811: astore 4
    //   813: aconst_null
    //   814: astore_2
    //   815: aconst_null
    //   816: astore_1
    //   817: goto -604 -> 213
    //   820: astore_3
    //   821: aconst_null
    //   822: astore 4
    //   824: aconst_null
    //   825: astore_2
    //   826: goto -613 -> 213
    //   829: astore_3
    //   830: aconst_null
    //   831: astore_2
    //   832: goto -619 -> 213
    //   835: astore_1
    //   836: aconst_null
    //   837: astore_2
    //   838: aload_0
    //   839: astore 4
    //   841: aload_2
    //   842: astore_0
    //   843: goto -251 -> 592
    //   846: astore_1
    //   847: aload_3
    //   848: astore 4
    //   850: aload_2
    //   851: astore_0
    //   852: goto -260 -> 592
    //   855: astore 5
    //   857: aconst_null
    //   858: astore_1
    //   859: aload_0
    //   860: astore 4
    //   862: aload_1
    //   863: astore_0
    //   864: goto -307 -> 557
    //   867: astore 5
    //   869: aload_0
    //   870: astore 4
    //   872: aload_1
    //   873: astore_0
    //   874: goto -317 -> 557
    //   877: astore 5
    //   879: aconst_null
    //   880: astore_1
    //   881: aload_0
    //   882: astore 4
    //   884: aload_1
    //   885: astore_0
    //   886: goto -371 -> 515
    //   889: astore 5
    //   891: aload_0
    //   892: astore 4
    //   894: aload_1
    //   895: astore_0
    //   896: goto -381 -> 515
    //   899: astore_2
    //   900: aconst_null
    //   901: astore_1
    //   902: goto -468 -> 434
    //   905: astore 4
    //   907: aload_3
    //   908: astore_1
    //   909: aload_2
    //   910: astore_0
    //   911: aload 4
    //   913: astore_2
    //   914: goto -480 -> 434
    //   917: astore 4
    //   919: aconst_null
    //   920: astore_1
    //   921: goto -576 -> 345
    //   924: astore 4
    //   926: goto -581 -> 345
    //   929: astore 4
    //   931: aconst_null
    //   932: astore_1
    //   933: goto -650 -> 283
    //   936: astore 4
    //   938: goto -655 -> 283
    //   941: aconst_null
    //   942: astore 4
    //   944: aconst_null
    //   945: astore 5
    //   947: aconst_null
    //   948: astore_2
    //   949: goto -297 -> 652
    //   952: aconst_null
    //   953: astore_0
    //   954: aload_2
    //   955: astore_1
    //   956: goto -839 -> 117
    //   959: aconst_null
    //   960: astore_0
    //   961: aconst_null
    //   962: astore_1
    //   963: goto -474 -> 489
    //   966: astore_1
    //   967: aconst_null
    //   968: astore 4
    //   970: aconst_null
    //   971: astore_0
    //   972: goto -380 -> 592
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	975	0	paramContext	android.content.Context
    //   0	975	1	paramString1	String
    //   0	975	2	paramString2	String
    //   0	975	3	paramString3	String
    //   36	217	4	localObject1	Object
    //   277	11	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   303	29	4	str1	String
    //   339	11	4	localException1	java.lang.Exception
    //   365	528	4	localObject2	Object
    //   905	7	4	localObject3	Object
    //   917	1	4	localException2	java.lang.Exception
    //   924	1	4	localException3	java.lang.Exception
    //   929	1	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   936	1	4	localUnsatisfiedLinkError3	java.lang.UnsatisfiedLinkError
    //   942	27	4	localObject4	Object
    //   103	284	5	str2	String
    //   508	13	5	localUnsatisfiedLinkError4	java.lang.UnsatisfiedLinkError
    //   550	13	5	localIOException1	java.io.IOException
    //   616	186	5	str3	String
    //   855	1	5	localIOException2	java.io.IOException
    //   867	1	5	localIOException3	java.io.IOException
    //   877	1	5	localUnsatisfiedLinkError5	java.lang.UnsatisfiedLinkError
    //   889	1	5	localUnsatisfiedLinkError6	java.lang.UnsatisfiedLinkError
    //   945	1	5	localObject5	Object
    //   1	798	6	str4	String
    //   145	651	7	localContext	android.content.Context
    //   149	643	8	localObject6	Object
    //   182	22	9	str5	String
    // Exception table:
    //   from	to	target	type
    //   157	165	212	java/lang/Exception
    //   178	184	212	java/lang/Exception
    //   202	209	212	java/lang/Exception
    //   642	647	212	java/lang/Exception
    //   62	72	277	java/lang/UnsatisfiedLinkError
    //   105	109	321	java/lang/Exception
    //   310	314	321	java/lang/Exception
    //   372	376	321	java/lang/Exception
    //   62	72	339	java/lang/Exception
    //   105	109	383	finally
    //   310	314	383	finally
    //   372	376	383	finally
    //   62	72	429	finally
    //   438	442	444	java/lang/Exception
    //   442	444	444	java/lang/Exception
    //   465	474	508	java/lang/UnsatisfiedLinkError
    //   465	474	550	java/io/IOException
    //   499	503	612	java/lang/Exception
    //   536	541	612	java/lang/Exception
    //   578	583	612	java/lang/Exception
    //   601	606	612	java/lang/Exception
    //   610	612	612	java/lang/Exception
    //   657	662	692	java/io/IOException
    //   667	672	692	java/io/IOException
    //   676	680	692	java/io/IOException
    //   686	690	692	java/io/IOException
    //   243	247	699	java/io/IOException
    //   252	257	699	java/io/IOException
    //   261	265	699	java/io/IOException
    //   269	273	699	java/io/IOException
    //   397	401	706	java/io/IOException
    //   406	411	706	java/io/IOException
    //   415	419	706	java/io/IOException
    //   423	427	706	java/io/IOException
    //   28	62	714	finally
    //   453	461	714	finally
    //   438	442	728	finally
    //   442	444	728	finally
    //   499	503	744	finally
    //   536	541	744	finally
    //   578	583	744	finally
    //   601	606	744	finally
    //   610	612	744	finally
    //   121	131	762	finally
    //   131	144	778	finally
    //   157	165	790	finally
    //   178	184	790	finally
    //   202	209	790	finally
    //   226	239	790	finally
    //   642	647	790	finally
    //   28	62	807	java/lang/Exception
    //   453	461	807	java/lang/Exception
    //   121	131	820	java/lang/Exception
    //   131	144	829	java/lang/Exception
    //   474	481	835	finally
    //   485	489	846	finally
    //   520	525	846	finally
    //   562	567	846	finally
    //   474	481	855	java/io/IOException
    //   485	489	867	java/io/IOException
    //   474	481	877	java/lang/UnsatisfiedLinkError
    //   485	489	889	java/lang/UnsatisfiedLinkError
    //   72	79	899	finally
    //   83	87	905	finally
    //   287	292	905	finally
    //   349	354	905	finally
    //   72	79	917	java/lang/Exception
    //   83	87	924	java/lang/Exception
    //   72	79	929	java/lang/UnsatisfiedLinkError
    //   83	87	936	java/lang/UnsatisfiedLinkError
    //   465	474	966	finally
  }
  
  /* Error */
  public static String parseFastCaptureFile(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: getstatic 16	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   9: new 55	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   16: ldc 155
    //   18: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 71	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: getstatic 16	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   34: ldc 157
    //   36: invokestatic 71	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: ifnull +457 -> 497
    //   43: aload_0
    //   44: invokevirtual 140	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   47: aload_1
    //   48: invokevirtual 146	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   51: astore_1
    //   52: aload_1
    //   53: aload_2
    //   54: invokestatic 159	com/tencent/ttpic/baseutils/device/DeviceParser:drinkACupOfCoffeeForFast	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   57: astore_0
    //   58: aload_1
    //   59: astore 4
    //   61: aload_0
    //   62: astore_2
    //   63: aload_1
    //   64: invokestatic 96	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   67: aload_1
    //   68: astore_3
    //   69: aload_0
    //   70: astore_1
    //   71: aload_3
    //   72: ifnull +420 -> 492
    //   75: aload_0
    //   76: astore_1
    //   77: aload_0
    //   78: astore_2
    //   79: aload_3
    //   80: invokevirtual 101	java/io/InputStream:close	()V
    //   83: aload_0
    //   84: ifnull +397 -> 481
    //   87: new 103	java/io/InputStreamReader
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 105	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   95: astore_3
    //   96: new 107	java/io/BufferedReader
    //   99: dup
    //   100: aload_3
    //   101: sipush 1024
    //   104: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   107: astore_1
    //   108: aload_3
    //   109: astore 6
    //   111: aload_1
    //   112: astore 5
    //   114: aload_0
    //   115: astore 4
    //   117: new 112	java/lang/StringBuffer
    //   120: dup
    //   121: invokespecial 113	java/lang/StringBuffer:<init>	()V
    //   124: astore_2
    //   125: aload_3
    //   126: astore 6
    //   128: aload_1
    //   129: astore 5
    //   131: aload_0
    //   132: astore 4
    //   134: aload_1
    //   135: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   138: astore 8
    //   140: aload 8
    //   142: ifnull +131 -> 273
    //   145: aload_3
    //   146: astore 6
    //   148: aload_1
    //   149: astore 5
    //   151: aload_0
    //   152: astore 4
    //   154: aload_2
    //   155: aload 8
    //   157: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   160: pop
    //   161: goto -36 -> 125
    //   164: astore_2
    //   165: aload_3
    //   166: astore 6
    //   168: aload_1
    //   169: astore 5
    //   171: aload_0
    //   172: astore 4
    //   174: aload_2
    //   175: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   178: aload_1
    //   179: ifnull +7 -> 186
    //   182: aload_1
    //   183: invokevirtual 126	java/io/BufferedReader:close	()V
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   194: aload 7
    //   196: astore_2
    //   197: aload_0
    //   198: ifnull +10 -> 208
    //   201: aload_0
    //   202: invokevirtual 101	java/io/InputStream:close	()V
    //   205: aload 7
    //   207: astore_2
    //   208: aload_2
    //   209: areturn
    //   210: astore 5
    //   212: aconst_null
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_3
    //   217: astore 4
    //   219: aload_0
    //   220: astore_2
    //   221: aload 5
    //   223: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   226: aload_0
    //   227: astore_1
    //   228: aload_3
    //   229: ifnull +263 -> 492
    //   232: aload_0
    //   233: astore_1
    //   234: aload_0
    //   235: astore_2
    //   236: aload_3
    //   237: invokevirtual 101	java/io/InputStream:close	()V
    //   240: goto -157 -> 83
    //   243: aload 4
    //   245: ifnull +12 -> 257
    //   248: aload_0
    //   249: astore_1
    //   250: aload_0
    //   251: astore_2
    //   252: aload 4
    //   254: invokevirtual 101	java/io/InputStream:close	()V
    //   257: aload_0
    //   258: astore_1
    //   259: aload_0
    //   260: astore_2
    //   261: aload_3
    //   262: athrow
    //   263: astore_2
    //   264: aconst_null
    //   265: astore_3
    //   266: aload_1
    //   267: astore_0
    //   268: aconst_null
    //   269: astore_1
    //   270: goto -105 -> 165
    //   273: aload_3
    //   274: astore 6
    //   276: aload_1
    //   277: astore 5
    //   279: aload_0
    //   280: astore 4
    //   282: aload_2
    //   283: invokevirtual 148	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   286: astore_2
    //   287: aload_1
    //   288: astore 4
    //   290: aload_2
    //   291: astore_1
    //   292: aload 4
    //   294: ifnull +8 -> 302
    //   297: aload 4
    //   299: invokevirtual 126	java/io/BufferedReader:close	()V
    //   302: aload_3
    //   303: ifnull +7 -> 310
    //   306: aload_3
    //   307: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   310: aload_1
    //   311: astore_2
    //   312: aload_0
    //   313: ifnull -105 -> 208
    //   316: aload_0
    //   317: invokevirtual 101	java/io/InputStream:close	()V
    //   320: aload_1
    //   321: areturn
    //   322: astore_0
    //   323: aload_0
    //   324: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   327: aload_1
    //   328: areturn
    //   329: astore_0
    //   330: aload_0
    //   331: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   334: aconst_null
    //   335: areturn
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_2
    //   339: aconst_null
    //   340: astore_3
    //   341: aconst_null
    //   342: astore_0
    //   343: aload_3
    //   344: ifnull +7 -> 351
    //   347: aload_3
    //   348: invokevirtual 126	java/io/BufferedReader:close	()V
    //   351: aload_2
    //   352: ifnull +7 -> 359
    //   355: aload_2
    //   356: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   359: aload_0
    //   360: ifnull +7 -> 367
    //   363: aload_0
    //   364: invokevirtual 101	java/io/InputStream:close	()V
    //   367: aload_1
    //   368: athrow
    //   369: astore_0
    //   370: aload_0
    //   371: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   374: goto -7 -> 367
    //   377: astore_1
    //   378: aconst_null
    //   379: astore_3
    //   380: aload_2
    //   381: astore_0
    //   382: aconst_null
    //   383: astore 4
    //   385: aload_3
    //   386: astore_2
    //   387: aload 4
    //   389: astore_3
    //   390: goto -47 -> 343
    //   393: astore_1
    //   394: aconst_null
    //   395: astore_2
    //   396: aconst_null
    //   397: astore_3
    //   398: goto -55 -> 343
    //   401: astore_1
    //   402: aconst_null
    //   403: astore 4
    //   405: aload_3
    //   406: astore_2
    //   407: aload 4
    //   409: astore_3
    //   410: goto -67 -> 343
    //   413: astore_1
    //   414: aload 6
    //   416: astore_2
    //   417: aload 5
    //   419: astore_3
    //   420: aload 4
    //   422: astore_0
    //   423: goto -80 -> 343
    //   426: astore_2
    //   427: aconst_null
    //   428: astore_3
    //   429: aconst_null
    //   430: astore_1
    //   431: aconst_null
    //   432: astore_0
    //   433: goto -268 -> 165
    //   436: astore_2
    //   437: aconst_null
    //   438: astore_3
    //   439: aconst_null
    //   440: astore_1
    //   441: goto -276 -> 165
    //   444: astore_2
    //   445: aconst_null
    //   446: astore_1
    //   447: goto -282 -> 165
    //   450: astore_3
    //   451: aconst_null
    //   452: astore_0
    //   453: aload_1
    //   454: astore 4
    //   456: goto -213 -> 243
    //   459: astore_3
    //   460: aload_2
    //   461: astore_0
    //   462: goto -219 -> 243
    //   465: astore 5
    //   467: aconst_null
    //   468: astore_0
    //   469: aload_1
    //   470: astore_3
    //   471: goto -255 -> 216
    //   474: astore 5
    //   476: aload_1
    //   477: astore_3
    //   478: goto -262 -> 216
    //   481: aconst_null
    //   482: astore_3
    //   483: aconst_null
    //   484: astore 4
    //   486: aload 6
    //   488: astore_1
    //   489: goto -197 -> 292
    //   492: aload_1
    //   493: astore_0
    //   494: goto -411 -> 83
    //   497: aconst_null
    //   498: astore_3
    //   499: aconst_null
    //   500: astore_0
    //   501: goto -432 -> 69
    //   504: astore_3
    //   505: aconst_null
    //   506: astore 4
    //   508: aconst_null
    //   509: astore_0
    //   510: goto -267 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	paramContext	android.content.Context
    //   0	513	1	paramString1	String
    //   0	513	2	paramString2	String
    //   68	371	3	localObject1	Object
    //   450	1	3	localObject2	Object
    //   459	1	3	localObject3	Object
    //   470	29	3	str1	String
    //   504	1	3	localObject4	Object
    //   59	448	4	localObject5	Object
    //   112	58	5	str2	String
    //   210	12	5	localIOException1	java.io.IOException
    //   277	141	5	str3	String
    //   465	1	5	localIOException2	java.io.IOException
    //   474	1	5	localIOException3	java.io.IOException
    //   1	486	6	localObject6	Object
    //   4	202	7	localObject7	Object
    //   138	18	8	str4	String
    // Exception table:
    //   from	to	target	type
    //   117	125	164	java/lang/Exception
    //   134	140	164	java/lang/Exception
    //   154	161	164	java/lang/Exception
    //   282	287	164	java/lang/Exception
    //   43	52	210	java/io/IOException
    //   79	83	263	java/lang/Exception
    //   236	240	263	java/lang/Exception
    //   252	257	263	java/lang/Exception
    //   261	263	263	java/lang/Exception
    //   297	302	322	java/io/IOException
    //   306	310	322	java/io/IOException
    //   316	320	322	java/io/IOException
    //   182	186	329	java/io/IOException
    //   190	194	329	java/io/IOException
    //   201	205	329	java/io/IOException
    //   31	39	336	finally
    //   347	351	369	java/io/IOException
    //   355	359	369	java/io/IOException
    //   363	367	369	java/io/IOException
    //   79	83	377	finally
    //   236	240	377	finally
    //   252	257	377	finally
    //   261	263	377	finally
    //   87	96	393	finally
    //   96	108	401	finally
    //   117	125	413	finally
    //   134	140	413	finally
    //   154	161	413	finally
    //   174	178	413	finally
    //   282	287	413	finally
    //   31	39	426	java/lang/Exception
    //   87	96	436	java/lang/Exception
    //   96	108	444	java/lang/Exception
    //   52	58	450	finally
    //   63	67	459	finally
    //   221	226	459	finally
    //   52	58	465	java/io/IOException
    //   63	67	474	java/io/IOException
    //   43	52	504	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceParser
 * JD-Core Version:    0.7.0.1
 */