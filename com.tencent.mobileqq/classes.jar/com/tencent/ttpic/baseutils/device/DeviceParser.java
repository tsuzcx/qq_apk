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
    paramInputStream = DeviceCoffee.drink(IOUtils.toByteArray(paramInputStream), paramString1, paramString2);
    if (paramInputStream == null) {
      return null;
    }
    return new ByteArrayInputStream(paramInputStream);
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
    //   43: ifeq +414 -> 457
    //   46: aload 4
    //   48: invokevirtual 83	java/io/File:isFile	()Z
    //   51: ifeq +406 -> 457
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
    //   79: aload_1
    //   80: ifnull +11 -> 91
    //   83: aload_0
    //   84: astore_2
    //   85: aload_1
    //   86: astore_3
    //   87: aload_0
    //   88: invokestatic 96	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   91: aload_0
    //   92: astore_2
    //   93: aload_1
    //   94: astore_3
    //   95: aload_1
    //   96: ifnull +21 -> 117
    //   99: aload_0
    //   100: astore_2
    //   101: aload_1
    //   102: astore 4
    //   104: aload_0
    //   105: astore_3
    //   106: aload_1
    //   107: astore 5
    //   109: aload_1
    //   110: invokevirtual 101	java/io/InputStream:close	()V
    //   113: aload_1
    //   114: astore_3
    //   115: aload_0
    //   116: astore_2
    //   117: aload_3
    //   118: astore_1
    //   119: aload_2
    //   120: astore_0
    //   121: aload_1
    //   122: ifnull +842 -> 964
    //   125: new 103	java/io/InputStreamReader
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 105	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   133: astore 4
    //   135: new 107	java/io/BufferedReader
    //   138: dup
    //   139: aload 4
    //   141: sipush 1024
    //   144: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   147: astore_2
    //   148: aload_0
    //   149: astore 7
    //   151: aload 4
    //   153: astore 8
    //   155: aload_2
    //   156: astore 6
    //   158: aload_1
    //   159: astore 5
    //   161: new 112	java/lang/StringBuffer
    //   164: dup
    //   165: invokespecial 113	java/lang/StringBuffer:<init>	()V
    //   168: astore_3
    //   169: aload_0
    //   170: astore 7
    //   172: aload 4
    //   174: astore 8
    //   176: aload_2
    //   177: astore 6
    //   179: aload_1
    //   180: astore 5
    //   182: aload_2
    //   183: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   186: astore 9
    //   188: aload 9
    //   190: ifnull +460 -> 650
    //   193: aload_0
    //   194: astore 7
    //   196: aload 4
    //   198: astore 8
    //   200: aload_2
    //   201: astore 6
    //   203: aload_1
    //   204: astore 5
    //   206: aload_3
    //   207: aload 9
    //   209: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: goto -44 -> 169
    //   216: astore_3
    //   217: aload_0
    //   218: astore 7
    //   220: aload 4
    //   222: astore 8
    //   224: aload_2
    //   225: astore 6
    //   227: aload_1
    //   228: astore 5
    //   230: getstatic 16	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   233: ldc 121
    //   235: aload_3
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 125	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 126	java/io/BufferedReader:close	()V
    //   251: aload 4
    //   253: ifnull +8 -> 261
    //   256: aload 4
    //   258: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   261: aload_1
    //   262: ifnull +7 -> 269
    //   265: aload_1
    //   266: invokevirtual 101	java/io/InputStream:close	()V
    //   269: aload_0
    //   270: ifnull +7 -> 277
    //   273: aload_0
    //   274: invokevirtual 128	java/io/FileInputStream:close	()V
    //   277: aconst_null
    //   278: astore_1
    //   279: aload_1
    //   280: areturn
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_1
    //   285: aconst_null
    //   286: astore_0
    //   287: aload_0
    //   288: astore_2
    //   289: aload_1
    //   290: astore_3
    //   291: aload 4
    //   293: invokevirtual 131	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   296: aload_0
    //   297: astore_2
    //   298: aload_1
    //   299: astore_3
    //   300: aload_1
    //   301: ifnull -184 -> 117
    //   304: aload_0
    //   305: astore_2
    //   306: aload_1
    //   307: astore 4
    //   309: aload_0
    //   310: astore_3
    //   311: aload_1
    //   312: astore 5
    //   314: aload_1
    //   315: invokevirtual 101	java/io/InputStream:close	()V
    //   318: aload_0
    //   319: astore_2
    //   320: aload_1
    //   321: astore_3
    //   322: goto -205 -> 117
    //   325: astore_3
    //   326: aconst_null
    //   327: astore 5
    //   329: aload 4
    //   331: astore_1
    //   332: aload_2
    //   333: astore_0
    //   334: aconst_null
    //   335: astore 4
    //   337: aload 5
    //   339: astore_2
    //   340: goto -123 -> 217
    //   343: astore 4
    //   345: aconst_null
    //   346: astore_1
    //   347: aconst_null
    //   348: astore_0
    //   349: aload_0
    //   350: astore_2
    //   351: aload_1
    //   352: astore_3
    //   353: aload 4
    //   355: invokevirtual 132	java/lang/Exception:printStackTrace	()V
    //   358: aload_0
    //   359: astore_2
    //   360: aload_1
    //   361: astore_3
    //   362: aload_1
    //   363: ifnull -246 -> 117
    //   366: aload_0
    //   367: astore_2
    //   368: aload_1
    //   369: astore 4
    //   371: aload_0
    //   372: astore_3
    //   373: aload_1
    //   374: astore 5
    //   376: aload_1
    //   377: invokevirtual 101	java/io/InputStream:close	()V
    //   380: aload_0
    //   381: astore_2
    //   382: aload_1
    //   383: astore_3
    //   384: goto -267 -> 117
    //   387: astore_2
    //   388: aconst_null
    //   389: astore_0
    //   390: aload 5
    //   392: astore_1
    //   393: aload 6
    //   395: astore 4
    //   397: aload_0
    //   398: ifnull +7 -> 405
    //   401: aload_0
    //   402: invokevirtual 126	java/io/BufferedReader:close	()V
    //   405: aload 4
    //   407: ifnull +8 -> 415
    //   410: aload 4
    //   412: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   415: aload_1
    //   416: ifnull +7 -> 423
    //   419: aload_1
    //   420: invokevirtual 101	java/io/InputStream:close	()V
    //   423: aload_3
    //   424: ifnull +7 -> 431
    //   427: aload_3
    //   428: invokevirtual 128	java/io/FileInputStream:close	()V
    //   431: aload_2
    //   432: athrow
    //   433: astore_2
    //   434: aconst_null
    //   435: astore_0
    //   436: aconst_null
    //   437: astore_1
    //   438: aload_1
    //   439: ifnull +7 -> 446
    //   442: aload_1
    //   443: invokevirtual 101	java/io/InputStream:close	()V
    //   446: aload_2
    //   447: athrow
    //   448: astore_3
    //   449: aconst_null
    //   450: astore_2
    //   451: aconst_null
    //   452: astore 4
    //   454: goto -237 -> 217
    //   457: getstatic 16	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   460: ldc 134
    //   462: invokestatic 71	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload_0
    //   466: ifnull +516 -> 982
    //   469: aload_0
    //   470: invokevirtual 140	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   473: aload_1
    //   474: invokevirtual 146	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   477: astore_0
    //   478: aload_0
    //   479: aload_2
    //   480: aload_3
    //   481: invokestatic 92	com/tencent/ttpic/baseutils/device/DeviceParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   484: astore_2
    //   485: aload_0
    //   486: astore 4
    //   488: aload_2
    //   489: astore_1
    //   490: aload_2
    //   491: ifnull +16 -> 507
    //   494: aload_0
    //   495: astore_3
    //   496: aload_2
    //   497: astore_1
    //   498: aload_0
    //   499: invokestatic 96	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   502: aload_2
    //   503: astore_1
    //   504: aload_0
    //   505: astore 4
    //   507: aload_1
    //   508: astore_2
    //   509: aload 4
    //   511: ifnull +464 -> 975
    //   514: aload_1
    //   515: astore_2
    //   516: aload_1
    //   517: astore_3
    //   518: aload 4
    //   520: invokevirtual 101	java/io/InputStream:close	()V
    //   523: aconst_null
    //   524: astore_0
    //   525: goto -404 -> 121
    //   528: astore 5
    //   530: aconst_null
    //   531: astore 4
    //   533: aconst_null
    //   534: astore_0
    //   535: aload 4
    //   537: astore_3
    //   538: aload_0
    //   539: astore_1
    //   540: aload 5
    //   542: invokevirtual 131	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   545: aload_0
    //   546: astore_2
    //   547: aload 4
    //   549: ifnull +426 -> 975
    //   552: aload_0
    //   553: astore_2
    //   554: aload_0
    //   555: astore_3
    //   556: aload 4
    //   558: invokevirtual 101	java/io/InputStream:close	()V
    //   561: aconst_null
    //   562: astore_2
    //   563: aload_0
    //   564: astore_1
    //   565: aload_2
    //   566: astore_0
    //   567: goto -446 -> 121
    //   570: astore 5
    //   572: aconst_null
    //   573: astore 4
    //   575: aconst_null
    //   576: astore_0
    //   577: aload 4
    //   579: astore_3
    //   580: aload_0
    //   581: astore_1
    //   582: aload 5
    //   584: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   587: aload_0
    //   588: astore_2
    //   589: aload 4
    //   591: ifnull +384 -> 975
    //   594: aload_0
    //   595: astore_2
    //   596: aload_0
    //   597: astore_3
    //   598: aload 4
    //   600: invokevirtual 101	java/io/InputStream:close	()V
    //   603: aconst_null
    //   604: astore_2
    //   605: aload_0
    //   606: astore_1
    //   607: aload_2
    //   608: astore_0
    //   609: goto -488 -> 121
    //   612: aload 5
    //   614: ifnull +12 -> 626
    //   617: aload_0
    //   618: astore_2
    //   619: aload_0
    //   620: astore_3
    //   621: aload 5
    //   623: invokevirtual 101	java/io/InputStream:close	()V
    //   626: aload_0
    //   627: astore_2
    //   628: aload_0
    //   629: astore_3
    //   630: aload 4
    //   632: athrow
    //   633: astore_3
    //   634: aconst_null
    //   635: astore_0
    //   636: aconst_null
    //   637: astore 5
    //   639: aload_2
    //   640: astore_1
    //   641: aconst_null
    //   642: astore 4
    //   644: aload 5
    //   646: astore_2
    //   647: goto -430 -> 217
    //   650: aload_0
    //   651: astore 7
    //   653: aload 4
    //   655: astore 8
    //   657: aload_2
    //   658: astore 6
    //   660: aload_1
    //   661: astore 5
    //   663: aload_3
    //   664: invokevirtual 148	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   667: astore_3
    //   668: aload_2
    //   669: astore 5
    //   671: aload_3
    //   672: astore_2
    //   673: aload 5
    //   675: ifnull +8 -> 683
    //   678: aload 5
    //   680: invokevirtual 126	java/io/BufferedReader:close	()V
    //   683: aload 4
    //   685: ifnull +8 -> 693
    //   688: aload 4
    //   690: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   693: aload_1
    //   694: ifnull +7 -> 701
    //   697: aload_1
    //   698: invokevirtual 101	java/io/InputStream:close	()V
    //   701: aload_2
    //   702: astore_1
    //   703: aload_0
    //   704: ifnull -425 -> 279
    //   707: aload_0
    //   708: invokevirtual 128	java/io/FileInputStream:close	()V
    //   711: aload_2
    //   712: areturn
    //   713: astore_0
    //   714: aload_0
    //   715: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   718: aload_2
    //   719: areturn
    //   720: astore_0
    //   721: aload_0
    //   722: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   725: aconst_null
    //   726: areturn
    //   727: astore_0
    //   728: aload_0
    //   729: invokestatic 151	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   732: goto -301 -> 431
    //   735: astore_2
    //   736: aconst_null
    //   737: astore_3
    //   738: aconst_null
    //   739: astore_0
    //   740: aconst_null
    //   741: astore_1
    //   742: aload 6
    //   744: astore 4
    //   746: goto -349 -> 397
    //   749: astore_2
    //   750: aconst_null
    //   751: astore 5
    //   753: aload_0
    //   754: astore_3
    //   755: aload 6
    //   757: astore 4
    //   759: aload 5
    //   761: astore_0
    //   762: goto -365 -> 397
    //   765: astore_2
    //   766: aconst_null
    //   767: astore 4
    //   769: aconst_null
    //   770: astore_0
    //   771: aload_3
    //   772: astore_1
    //   773: aload 4
    //   775: astore_3
    //   776: aload 6
    //   778: astore 4
    //   780: goto -383 -> 397
    //   783: astore_2
    //   784: aconst_null
    //   785: astore 5
    //   787: aload_0
    //   788: astore_3
    //   789: aload 6
    //   791: astore 4
    //   793: aload 5
    //   795: astore_0
    //   796: goto -399 -> 397
    //   799: astore_2
    //   800: aconst_null
    //   801: astore 5
    //   803: aload_0
    //   804: astore_3
    //   805: aload 5
    //   807: astore_0
    //   808: goto -411 -> 397
    //   811: astore_2
    //   812: aload 8
    //   814: astore 4
    //   816: aload 7
    //   818: astore_3
    //   819: aload 6
    //   821: astore_0
    //   822: aload 5
    //   824: astore_1
    //   825: goto -428 -> 397
    //   828: astore_3
    //   829: aconst_null
    //   830: astore_0
    //   831: aconst_null
    //   832: astore 4
    //   834: aconst_null
    //   835: astore_2
    //   836: aconst_null
    //   837: astore_1
    //   838: goto -621 -> 217
    //   841: astore_3
    //   842: aconst_null
    //   843: astore 4
    //   845: aconst_null
    //   846: astore_2
    //   847: goto -630 -> 217
    //   850: astore_3
    //   851: aconst_null
    //   852: astore_2
    //   853: goto -636 -> 217
    //   856: astore 4
    //   858: aconst_null
    //   859: astore_1
    //   860: aload_0
    //   861: astore 5
    //   863: aload_1
    //   864: astore_0
    //   865: goto -253 -> 612
    //   868: astore 4
    //   870: aload_3
    //   871: astore 5
    //   873: aload_1
    //   874: astore_0
    //   875: goto -263 -> 612
    //   878: astore 5
    //   880: aconst_null
    //   881: astore_1
    //   882: aload_0
    //   883: astore 4
    //   885: aload_1
    //   886: astore_0
    //   887: goto -310 -> 577
    //   890: astore 5
    //   892: aload_0
    //   893: astore 4
    //   895: aload_2
    //   896: astore_0
    //   897: goto -320 -> 577
    //   900: astore 5
    //   902: aconst_null
    //   903: astore_1
    //   904: aload_0
    //   905: astore 4
    //   907: aload_1
    //   908: astore_0
    //   909: goto -374 -> 535
    //   912: astore 5
    //   914: aload_0
    //   915: astore 4
    //   917: aload_2
    //   918: astore_0
    //   919: goto -384 -> 535
    //   922: astore_2
    //   923: aconst_null
    //   924: astore_1
    //   925: goto -487 -> 438
    //   928: astore 4
    //   930: aload_3
    //   931: astore_1
    //   932: aload_2
    //   933: astore_0
    //   934: aload 4
    //   936: astore_2
    //   937: goto -499 -> 438
    //   940: astore 4
    //   942: aconst_null
    //   943: astore_1
    //   944: goto -595 -> 349
    //   947: astore 4
    //   949: goto -600 -> 349
    //   952: astore 4
    //   954: aconst_null
    //   955: astore_1
    //   956: goto -669 -> 287
    //   959: astore 4
    //   961: goto -674 -> 287
    //   964: aconst_null
    //   965: astore 4
    //   967: aconst_null
    //   968: astore 5
    //   970: aconst_null
    //   971: astore_2
    //   972: goto -299 -> 673
    //   975: aconst_null
    //   976: astore_0
    //   977: aload_2
    //   978: astore_1
    //   979: goto -858 -> 121
    //   982: aconst_null
    //   983: astore 4
    //   985: aconst_null
    //   986: astore_1
    //   987: goto -480 -> 507
    //   990: astore 4
    //   992: aconst_null
    //   993: astore 5
    //   995: aconst_null
    //   996: astore_0
    //   997: goto -385 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1000	0	paramContext	android.content.Context
    //   0	1000	1	paramString1	String
    //   0	1000	2	paramString2	String
    //   0	1000	3	paramString3	String
    //   36	221	4	localObject1	Object
    //   281	11	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   307	29	4	str1	String
    //   343	11	4	localException1	java.lang.Exception
    //   369	475	4	localObject2	Object
    //   856	1	4	localObject3	Object
    //   868	1	4	localObject4	Object
    //   883	33	4	localContext1	android.content.Context
    //   928	7	4	localObject5	Object
    //   940	1	4	localException2	java.lang.Exception
    //   947	1	4	localException3	java.lang.Exception
    //   952	1	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   959	1	4	localUnsatisfiedLinkError3	java.lang.UnsatisfiedLinkError
    //   965	19	4	localObject6	Object
    //   990	1	4	localObject7	Object
    //   107	284	5	str2	String
    //   528	13	5	localUnsatisfiedLinkError4	java.lang.UnsatisfiedLinkError
    //   570	52	5	localIOException1	java.io.IOException
    //   637	235	5	localObject8	Object
    //   878	1	5	localIOException2	java.io.IOException
    //   890	1	5	localIOException3	java.io.IOException
    //   900	1	5	localUnsatisfiedLinkError5	java.lang.UnsatisfiedLinkError
    //   912	1	5	localUnsatisfiedLinkError6	java.lang.UnsatisfiedLinkError
    //   968	26	5	localObject9	Object
    //   1	819	6	str3	String
    //   149	668	7	localContext2	android.content.Context
    //   153	660	8	localObject10	Object
    //   186	22	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   161	169	216	java/lang/Exception
    //   182	188	216	java/lang/Exception
    //   206	213	216	java/lang/Exception
    //   663	668	216	java/lang/Exception
    //   62	72	281	java/lang/UnsatisfiedLinkError
    //   109	113	325	java/lang/Exception
    //   314	318	325	java/lang/Exception
    //   376	380	325	java/lang/Exception
    //   62	72	343	java/lang/Exception
    //   109	113	387	finally
    //   314	318	387	finally
    //   376	380	387	finally
    //   62	72	433	finally
    //   442	446	448	java/lang/Exception
    //   446	448	448	java/lang/Exception
    //   469	478	528	java/lang/UnsatisfiedLinkError
    //   469	478	570	java/io/IOException
    //   518	523	633	java/lang/Exception
    //   556	561	633	java/lang/Exception
    //   598	603	633	java/lang/Exception
    //   621	626	633	java/lang/Exception
    //   630	633	633	java/lang/Exception
    //   678	683	713	java/io/IOException
    //   688	693	713	java/io/IOException
    //   697	701	713	java/io/IOException
    //   707	711	713	java/io/IOException
    //   247	251	720	java/io/IOException
    //   256	261	720	java/io/IOException
    //   265	269	720	java/io/IOException
    //   273	277	720	java/io/IOException
    //   401	405	727	java/io/IOException
    //   410	415	727	java/io/IOException
    //   419	423	727	java/io/IOException
    //   427	431	727	java/io/IOException
    //   28	62	735	finally
    //   457	465	735	finally
    //   442	446	749	finally
    //   446	448	749	finally
    //   518	523	765	finally
    //   556	561	765	finally
    //   598	603	765	finally
    //   621	626	765	finally
    //   630	633	765	finally
    //   125	135	783	finally
    //   135	148	799	finally
    //   161	169	811	finally
    //   182	188	811	finally
    //   206	213	811	finally
    //   230	243	811	finally
    //   663	668	811	finally
    //   28	62	828	java/lang/Exception
    //   457	465	828	java/lang/Exception
    //   125	135	841	java/lang/Exception
    //   135	148	850	java/lang/Exception
    //   478	485	856	finally
    //   498	502	868	finally
    //   540	545	868	finally
    //   582	587	868	finally
    //   478	485	878	java/io/IOException
    //   498	502	890	java/io/IOException
    //   478	485	900	java/lang/UnsatisfiedLinkError
    //   498	502	912	java/lang/UnsatisfiedLinkError
    //   72	79	922	finally
    //   87	91	928	finally
    //   291	296	928	finally
    //   353	358	928	finally
    //   72	79	940	java/lang/Exception
    //   87	91	947	java/lang/Exception
    //   72	79	952	java/lang/UnsatisfiedLinkError
    //   87	91	959	java/lang/UnsatisfiedLinkError
    //   469	478	990	finally
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