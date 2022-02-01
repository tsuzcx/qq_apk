package com.tencent.ttpic.baseutils.device;

import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.device.DeviceCoffee;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class DeviceParser
{
  private static final String TAG = "DeviceParser";
  
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
    //   0: getstatic 49	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   3: astore 4
    //   5: new 51	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: ldc 54
    //   18: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 5
    //   24: aload_1
    //   25: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 4
    //   31: aload 5
    //   33: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 68	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aconst_null
    //   40: astore 8
    //   42: aconst_null
    //   43: astore 10
    //   45: aconst_null
    //   46: astore 9
    //   48: aconst_null
    //   49: astore 11
    //   51: new 70	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 4
    //   61: aload 4
    //   63: invokevirtual 77	java/io/File:exists	()Z
    //   66: ifeq +222 -> 288
    //   69: aload 4
    //   71: invokevirtual 80	java/io/File:isFile	()Z
    //   74: ifeq +214 -> 288
    //   77: getstatic 49	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   80: ldc 82
    //   82: invokestatic 68	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: new 84	java/io/FileInputStream
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: astore 4
    //   96: aload 4
    //   98: aload_2
    //   99: aload_3
    //   100: invokestatic 89	com/tencent/ttpic/baseutils/device/DeviceParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +24 -> 129
    //   108: aload 4
    //   110: astore_1
    //   111: aload_2
    //   112: astore_0
    //   113: aload 4
    //   115: invokestatic 93	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   118: goto +11 -> 129
    //   121: astore_3
    //   122: goto +74 -> 196
    //   125: astore_3
    //   126: goto +96 -> 222
    //   129: aload 4
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload_2
    //   135: ifnull +385 -> 520
    //   138: aload_2
    //   139: astore_1
    //   140: aload 4
    //   142: astore_0
    //   143: aload_0
    //   144: astore 6
    //   146: aload_1
    //   147: astore_3
    //   148: aload_0
    //   149: astore 7
    //   151: aload_1
    //   152: astore 5
    //   154: aload_1
    //   155: invokevirtual 98	java/io/InputStream:close	()V
    //   158: goto +362 -> 520
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_0
    //   164: goto +88 -> 252
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_2
    //   170: goto +26 -> 196
    //   173: astore_3
    //   174: aconst_null
    //   175: astore_2
    //   176: goto +46 -> 222
    //   179: astore_2
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 4
    //   185: astore_0
    //   186: goto +66 -> 252
    //   189: astore_3
    //   190: aconst_null
    //   191: astore 4
    //   193: aload 4
    //   195: astore_2
    //   196: aload 4
    //   198: astore_1
    //   199: aload_2
    //   200: astore_0
    //   201: aload_3
    //   202: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   205: aload 4
    //   207: astore_0
    //   208: aload_2
    //   209: astore_1
    //   210: aload_2
    //   211: ifnull +309 -> 520
    //   214: aload 4
    //   216: astore_0
    //   217: aload_2
    //   218: astore_1
    //   219: goto -76 -> 143
    //   222: aload 4
    //   224: astore_1
    //   225: aload_2
    //   226: astore_0
    //   227: aload_3
    //   228: invokevirtual 102	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   231: aload 4
    //   233: astore_0
    //   234: aload_2
    //   235: astore_1
    //   236: aload_2
    //   237: ifnull +283 -> 520
    //   240: aload 4
    //   242: astore_0
    //   243: aload_2
    //   244: astore_1
    //   245: goto -102 -> 143
    //   248: astore_2
    //   249: aload_1
    //   250: astore 4
    //   252: aload_0
    //   253: ifnull +20 -> 273
    //   256: aload 4
    //   258: astore 6
    //   260: aload_0
    //   261: astore_3
    //   262: aload 4
    //   264: astore 7
    //   266: aload_0
    //   267: astore 5
    //   269: aload_0
    //   270: invokevirtual 98	java/io/InputStream:close	()V
    //   273: aload 4
    //   275: astore 6
    //   277: aload_0
    //   278: astore_3
    //   279: aload 4
    //   281: astore 7
    //   283: aload_0
    //   284: astore 5
    //   286: aload_2
    //   287: athrow
    //   288: getstatic 49	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   291: ldc 104
    //   293: invokestatic 68	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_0
    //   297: ifnull +608 -> 905
    //   300: aload_0
    //   301: invokevirtual 110	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   304: aload_1
    //   305: invokevirtual 116	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   308: astore_0
    //   309: aload_0
    //   310: aload_2
    //   311: aload_3
    //   312: invokestatic 89	com/tencent/ttpic/baseutils/device/DeviceParser:drinkACupOfCoffeeForCamera	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   315: astore 4
    //   317: aload_0
    //   318: astore_3
    //   319: aload 4
    //   321: astore_2
    //   322: aload 4
    //   324: ifnull +585 -> 909
    //   327: aload_0
    //   328: astore_1
    //   329: aload 4
    //   331: astore_3
    //   332: aload_0
    //   333: invokestatic 93	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   336: aload_0
    //   337: astore_3
    //   338: aload 4
    //   340: astore_2
    //   341: goto +568 -> 909
    //   344: astore_1
    //   345: aload_0
    //   346: astore_2
    //   347: aload 4
    //   349: astore_0
    //   350: aload_1
    //   351: astore 4
    //   353: goto +63 -> 416
    //   356: astore_1
    //   357: aload_0
    //   358: astore_2
    //   359: aload 4
    //   361: astore_0
    //   362: aload_1
    //   363: astore 4
    //   365: goto +72 -> 437
    //   368: astore 4
    //   370: aconst_null
    //   371: astore_1
    //   372: aload_0
    //   373: astore_2
    //   374: aload_1
    //   375: astore_0
    //   376: goto +88 -> 464
    //   379: astore 4
    //   381: aconst_null
    //   382: astore_1
    //   383: aload_0
    //   384: astore_2
    //   385: aload_1
    //   386: astore_0
    //   387: goto +29 -> 416
    //   390: astore 4
    //   392: aconst_null
    //   393: astore_1
    //   394: aload_0
    //   395: astore_2
    //   396: aload_1
    //   397: astore_0
    //   398: goto +39 -> 437
    //   401: astore 4
    //   403: aconst_null
    //   404: astore_2
    //   405: aload_2
    //   406: astore_0
    //   407: goto +57 -> 464
    //   410: astore 4
    //   412: aconst_null
    //   413: astore_2
    //   414: aload_2
    //   415: astore_0
    //   416: aload_2
    //   417: astore_1
    //   418: aload_0
    //   419: astore_3
    //   420: aload 4
    //   422: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   425: aload_0
    //   426: astore_1
    //   427: aload_2
    //   428: ifnull +90 -> 518
    //   431: aload_2
    //   432: astore 4
    //   434: goto +49 -> 483
    //   437: aload_2
    //   438: astore_1
    //   439: aload_0
    //   440: astore_3
    //   441: aload 4
    //   443: invokevirtual 102	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   446: aload_0
    //   447: astore_1
    //   448: aload_2
    //   449: ifnull +69 -> 518
    //   452: aload_2
    //   453: astore 4
    //   455: goto +28 -> 483
    //   458: astore 4
    //   460: aload_3
    //   461: astore_0
    //   462: aload_1
    //   463: astore_2
    //   464: aload_2
    //   465: ifnull +11 -> 476
    //   468: aload_0
    //   469: astore_1
    //   470: aload_0
    //   471: astore_3
    //   472: aload_2
    //   473: invokevirtual 98	java/io/InputStream:close	()V
    //   476: aload_0
    //   477: astore_1
    //   478: aload_0
    //   479: astore_3
    //   480: aload 4
    //   482: athrow
    //   483: aload_0
    //   484: astore_1
    //   485: aload_0
    //   486: astore_3
    //   487: aload 4
    //   489: invokevirtual 98	java/io/InputStream:close	()V
    //   492: aload_0
    //   493: astore_1
    //   494: goto +24 -> 518
    //   497: astore_3
    //   498: aconst_null
    //   499: astore_2
    //   500: aload_2
    //   501: astore_0
    //   502: aload 10
    //   504: astore 4
    //   506: goto +328 -> 834
    //   509: astore_0
    //   510: aload_3
    //   511: astore 5
    //   513: aload_0
    //   514: astore_3
    //   515: goto +235 -> 750
    //   518: aconst_null
    //   519: astore_0
    //   520: aload_1
    //   521: ifnull +143 -> 664
    //   524: aload_0
    //   525: astore 6
    //   527: aload_1
    //   528: astore_3
    //   529: aload_0
    //   530: astore 7
    //   532: aload_1
    //   533: astore 5
    //   535: new 119	java/io/InputStreamReader
    //   538: dup
    //   539: aload_1
    //   540: invokespecial 121	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   543: astore_2
    //   544: new 123	java/io/BufferedReader
    //   547: dup
    //   548: aload_2
    //   549: sipush 1024
    //   552: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   555: astore 4
    //   557: new 128	java/lang/StringBuffer
    //   560: dup
    //   561: invokespecial 129	java/lang/StringBuffer:<init>	()V
    //   564: astore_3
    //   565: aload 4
    //   567: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   570: astore 5
    //   572: aload 5
    //   574: ifnull +13 -> 587
    //   577: aload_3
    //   578: aload 5
    //   580: invokevirtual 135	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   583: pop
    //   584: goto -19 -> 565
    //   587: aload_3
    //   588: invokevirtual 136	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   591: astore_3
    //   592: aload 4
    //   594: astore 5
    //   596: goto +76 -> 672
    //   599: astore_3
    //   600: goto +234 -> 834
    //   603: astore_3
    //   604: aload_1
    //   605: astore 5
    //   607: aload 4
    //   609: astore_1
    //   610: goto +146 -> 756
    //   613: astore_3
    //   614: aload 10
    //   616: astore 4
    //   618: goto +216 -> 834
    //   621: astore_3
    //   622: aconst_null
    //   623: astore 4
    //   625: aload_1
    //   626: astore 5
    //   628: aload 4
    //   630: astore_1
    //   631: goto +125 -> 756
    //   634: astore 5
    //   636: aload 6
    //   638: astore_0
    //   639: aconst_null
    //   640: astore_2
    //   641: aload 10
    //   643: astore 4
    //   645: aload_3
    //   646: astore_1
    //   647: aload 5
    //   649: astore_3
    //   650: goto +184 -> 834
    //   653: astore_3
    //   654: aload 7
    //   656: astore_0
    //   657: aconst_null
    //   658: astore_2
    //   659: aload_2
    //   660: astore_1
    //   661: goto +95 -> 756
    //   664: aconst_null
    //   665: astore_2
    //   666: aload_2
    //   667: astore 5
    //   669: aload 11
    //   671: astore_3
    //   672: aload 5
    //   674: ifnull +14 -> 688
    //   677: aload_3
    //   678: astore 4
    //   680: aload 5
    //   682: invokevirtual 137	java/io/BufferedReader:close	()V
    //   685: goto +3 -> 688
    //   688: aload_2
    //   689: ifnull +10 -> 699
    //   692: aload_3
    //   693: astore 4
    //   695: aload_2
    //   696: invokevirtual 138	java/io/InputStreamReader:close	()V
    //   699: aload_1
    //   700: ifnull +10 -> 710
    //   703: aload_3
    //   704: astore 4
    //   706: aload_1
    //   707: invokevirtual 98	java/io/InputStream:close	()V
    //   710: aload_3
    //   711: astore_1
    //   712: aload_0
    //   713: ifnull +112 -> 825
    //   716: aload_3
    //   717: astore 4
    //   719: aload_0
    //   720: invokevirtual 139	java/io/FileInputStream:close	()V
    //   723: aload_3
    //   724: areturn
    //   725: aload_0
    //   726: invokestatic 143	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   729: aload 4
    //   731: areturn
    //   732: astore_3
    //   733: aconst_null
    //   734: astore_2
    //   735: aload_2
    //   736: astore_1
    //   737: aload_1
    //   738: astore_0
    //   739: aload 10
    //   741: astore 4
    //   743: goto +91 -> 834
    //   746: astore_3
    //   747: aconst_null
    //   748: astore 5
    //   750: aconst_null
    //   751: astore_1
    //   752: aconst_null
    //   753: astore_2
    //   754: aconst_null
    //   755: astore_0
    //   756: getstatic 49	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   759: ldc 145
    //   761: aload_3
    //   762: iconst_0
    //   763: anewarray 4	java/lang/Object
    //   766: invokestatic 148	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   769: aload_1
    //   770: ifnull +11 -> 781
    //   773: aload 9
    //   775: astore 4
    //   777: aload_1
    //   778: invokevirtual 137	java/io/BufferedReader:close	()V
    //   781: aload_2
    //   782: ifnull +11 -> 793
    //   785: aload 9
    //   787: astore 4
    //   789: aload_2
    //   790: invokevirtual 138	java/io/InputStreamReader:close	()V
    //   793: aload 5
    //   795: ifnull +12 -> 807
    //   798: aload 9
    //   800: astore 4
    //   802: aload 5
    //   804: invokevirtual 98	java/io/InputStream:close	()V
    //   807: aload 8
    //   809: astore_1
    //   810: aload_0
    //   811: ifnull +14 -> 825
    //   814: aload 9
    //   816: astore 4
    //   818: aload_0
    //   819: invokevirtual 139	java/io/FileInputStream:close	()V
    //   822: aload 8
    //   824: astore_1
    //   825: aload_1
    //   826: areturn
    //   827: astore_3
    //   828: aload_1
    //   829: astore 4
    //   831: aload 5
    //   833: astore_1
    //   834: aload 4
    //   836: ifnull +11 -> 847
    //   839: aload 4
    //   841: invokevirtual 137	java/io/BufferedReader:close	()V
    //   844: goto +3 -> 847
    //   847: aload_2
    //   848: ifnull +7 -> 855
    //   851: aload_2
    //   852: invokevirtual 138	java/io/InputStreamReader:close	()V
    //   855: aload_1
    //   856: ifnull +7 -> 863
    //   859: aload_1
    //   860: invokevirtual 98	java/io/InputStream:close	()V
    //   863: aload_0
    //   864: ifnull +14 -> 878
    //   867: aload_0
    //   868: invokevirtual 139	java/io/FileInputStream:close	()V
    //   871: goto +7 -> 878
    //   874: aload_0
    //   875: invokestatic 143	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   878: goto +5 -> 883
    //   881: aload_3
    //   882: athrow
    //   883: goto -2 -> 881
    //   886: astore_3
    //   887: aconst_null
    //   888: astore 4
    //   890: aload 4
    //   892: astore_2
    //   893: goto -671 -> 222
    //   896: astore 4
    //   898: aconst_null
    //   899: astore_2
    //   900: aload_2
    //   901: astore_0
    //   902: goto -465 -> 437
    //   905: aconst_null
    //   906: astore_3
    //   907: aload_3
    //   908: astore_2
    //   909: aload_2
    //   910: astore_1
    //   911: aload_3
    //   912: ifnull -394 -> 518
    //   915: aload_3
    //   916: astore 4
    //   918: aload_2
    //   919: astore_0
    //   920: goto -437 -> 483
    //   923: astore_0
    //   924: goto -199 -> 725
    //   927: astore_0
    //   928: goto -54 -> 874
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	931	0	paramContext	android.content.Context
    //   0	931	1	paramString1	String
    //   0	931	2	paramString2	String
    //   0	931	3	paramString3	String
    //   3	361	4	localObject1	Object
    //   368	1	4	localObject2	Object
    //   379	1	4	localIOException1	java.io.IOException
    //   390	1	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   401	1	4	localObject3	Object
    //   410	11	4	localIOException2	java.io.IOException
    //   432	22	4	str1	String
    //   458	30	4	localObject4	Object
    //   504	387	4	localObject5	Object
    //   896	1	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   916	1	4	str2	String
    //   12	615	5	localObject6	Object
    //   634	14	5	localObject7	Object
    //   667	165	5	str3	String
    //   144	493	6	localObject8	Object
    //   149	506	7	localObject9	Object
    //   40	783	8	localObject10	Object
    //   46	769	9	localObject11	Object
    //   43	697	10	localObject12	Object
    //   49	621	11	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   113	118	121	java/lang/Exception
    //   113	118	125	java/lang/UnsatisfiedLinkError
    //   96	104	161	finally
    //   96	104	167	java/lang/Exception
    //   96	104	173	java/lang/UnsatisfiedLinkError
    //   85	96	179	finally
    //   85	96	189	java/lang/Exception
    //   113	118	248	finally
    //   201	205	248	finally
    //   227	231	248	finally
    //   332	336	344	java/io/IOException
    //   332	336	356	java/lang/UnsatisfiedLinkError
    //   309	317	368	finally
    //   309	317	379	java/io/IOException
    //   309	317	390	java/lang/UnsatisfiedLinkError
    //   300	309	401	finally
    //   300	309	410	java/io/IOException
    //   332	336	458	finally
    //   420	425	458	finally
    //   441	446	458	finally
    //   472	476	497	finally
    //   480	483	497	finally
    //   487	492	497	finally
    //   472	476	509	java/lang/Exception
    //   480	483	509	java/lang/Exception
    //   487	492	509	java/lang/Exception
    //   557	565	599	finally
    //   565	572	599	finally
    //   577	584	599	finally
    //   587	592	599	finally
    //   557	565	603	java/lang/Exception
    //   565	572	603	java/lang/Exception
    //   577	584	603	java/lang/Exception
    //   587	592	603	java/lang/Exception
    //   544	557	613	finally
    //   544	557	621	java/lang/Exception
    //   154	158	634	finally
    //   269	273	634	finally
    //   286	288	634	finally
    //   535	544	634	finally
    //   154	158	653	java/lang/Exception
    //   269	273	653	java/lang/Exception
    //   286	288	653	java/lang/Exception
    //   535	544	653	java/lang/Exception
    //   51	85	732	finally
    //   288	296	732	finally
    //   51	85	746	java/lang/Exception
    //   288	296	746	java/lang/Exception
    //   756	769	827	finally
    //   85	96	886	java/lang/UnsatisfiedLinkError
    //   300	309	896	java/lang/UnsatisfiedLinkError
    //   680	685	923	java/io/IOException
    //   695	699	923	java/io/IOException
    //   706	710	923	java/io/IOException
    //   719	723	923	java/io/IOException
    //   777	781	923	java/io/IOException
    //   789	793	923	java/io/IOException
    //   802	807	923	java/io/IOException
    //   818	822	923	java/io/IOException
    //   839	844	927	java/io/IOException
    //   851	855	927	java/io/IOException
    //   859	863	927	java/io/IOException
    //   867	871	927	java/io/IOException
  }
  
  /* Error */
  public static String parseFastCaptureFile(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 49	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   3: astore_3
    //   4: new 51	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   11: astore 4
    //   13: aload 4
    //   15: ldc 152
    //   17: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 4
    //   23: aload_1
    //   24: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: aload 4
    //   31: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 68	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aconst_null
    //   38: astore 6
    //   40: aconst_null
    //   41: astore 8
    //   43: aconst_null
    //   44: astore 7
    //   46: aconst_null
    //   47: astore 5
    //   49: getstatic 49	com/tencent/ttpic/baseutils/device/DeviceParser:TAG	Ljava/lang/String;
    //   52: ldc 154
    //   54: invokestatic 68	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: ifnull +402 -> 460
    //   61: aload_0
    //   62: invokevirtual 110	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   65: aload_1
    //   66: invokevirtual 116	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   69: astore_0
    //   70: aload_0
    //   71: aload_2
    //   72: invokestatic 156	com/tencent/ttpic/baseutils/device/DeviceParser:drinkACupOfCoffeeForFast	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   75: astore_1
    //   76: aload_0
    //   77: astore_3
    //   78: aload_1
    //   79: astore 4
    //   81: aload_0
    //   82: invokestatic 93	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   85: aload_0
    //   86: astore_2
    //   87: goto +377 -> 464
    //   90: astore_3
    //   91: aload_0
    //   92: astore_2
    //   93: aload_3
    //   94: astore_0
    //   95: goto +38 -> 133
    //   98: astore 5
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_0
    //   103: astore_1
    //   104: aload_2
    //   105: astore_0
    //   106: goto +57 -> 163
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_0
    //   113: astore_2
    //   114: aload_3
    //   115: astore_0
    //   116: goto +17 -> 133
    //   119: astore 5
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: astore_0
    //   125: goto +38 -> 163
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: astore_1
    //   133: aload_2
    //   134: astore_3
    //   135: aload_1
    //   136: astore 4
    //   138: aload_0
    //   139: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   142: aload_1
    //   143: astore_0
    //   144: aload_2
    //   145: ifnull +49 -> 194
    //   148: aload_2
    //   149: astore 4
    //   151: aload_1
    //   152: astore_0
    //   153: goto +29 -> 182
    //   156: astore 5
    //   158: aload 4
    //   160: astore_0
    //   161: aload_3
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +11 -> 175
    //   167: aload_0
    //   168: astore_2
    //   169: aload_0
    //   170: astore_3
    //   171: aload_1
    //   172: invokevirtual 98	java/io/InputStream:close	()V
    //   175: aload_0
    //   176: astore_2
    //   177: aload_0
    //   178: astore_3
    //   179: aload 5
    //   181: athrow
    //   182: aload_0
    //   183: astore_2
    //   184: aload_0
    //   185: astore_3
    //   186: aload 4
    //   188: invokevirtual 98	java/io/InputStream:close	()V
    //   191: goto +3 -> 194
    //   194: aload_0
    //   195: ifnull +96 -> 291
    //   198: aload_0
    //   199: astore_2
    //   200: aload_0
    //   201: astore_3
    //   202: new 119	java/io/InputStreamReader
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 121	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   210: astore_1
    //   211: new 123	java/io/BufferedReader
    //   214: dup
    //   215: aload_1
    //   216: sipush 1024
    //   219: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   222: astore 4
    //   224: new 128	java/lang/StringBuffer
    //   227: dup
    //   228: invokespecial 129	java/lang/StringBuffer:<init>	()V
    //   231: astore_2
    //   232: aload 4
    //   234: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   237: astore_3
    //   238: aload_3
    //   239: ifnull +12 -> 251
    //   242: aload_2
    //   243: aload_3
    //   244: invokevirtual 135	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   247: pop
    //   248: goto -16 -> 232
    //   251: aload_2
    //   252: invokevirtual 136	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   255: astore_2
    //   256: goto +43 -> 299
    //   259: astore_3
    //   260: aload_1
    //   261: astore_2
    //   262: aload_3
    //   263: astore_1
    //   264: goto +151 -> 415
    //   267: astore_3
    //   268: aload 4
    //   270: astore_2
    //   271: goto +91 -> 362
    //   274: astore_3
    //   275: aload_1
    //   276: astore_2
    //   277: aload_3
    //   278: astore_1
    //   279: aload 8
    //   281: astore_3
    //   282: goto +136 -> 418
    //   285: astore_3
    //   286: aconst_null
    //   287: astore_2
    //   288: goto +74 -> 362
    //   291: aconst_null
    //   292: astore_1
    //   293: aload_1
    //   294: astore 4
    //   296: aload 5
    //   298: astore_2
    //   299: aload 4
    //   301: ifnull +13 -> 314
    //   304: aload_2
    //   305: astore_3
    //   306: aload 4
    //   308: invokevirtual 137	java/io/BufferedReader:close	()V
    //   311: goto +3 -> 314
    //   314: aload_1
    //   315: ifnull +9 -> 324
    //   318: aload_2
    //   319: astore_3
    //   320: aload_1
    //   321: invokevirtual 138	java/io/InputStreamReader:close	()V
    //   324: aload_2
    //   325: astore_1
    //   326: aload_0
    //   327: ifnull +78 -> 405
    //   330: aload_2
    //   331: astore_3
    //   332: aload_0
    //   333: invokevirtual 98	java/io/InputStream:close	()V
    //   336: aload_2
    //   337: areturn
    //   338: aload_0
    //   339: invokestatic 143	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   342: aload_3
    //   343: areturn
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_2
    //   347: aload_2
    //   348: astore_0
    //   349: aload 8
    //   351: astore_3
    //   352: goto +66 -> 418
    //   355: astore_3
    //   356: aconst_null
    //   357: astore_1
    //   358: aload_1
    //   359: astore_2
    //   360: aload_2
    //   361: astore_0
    //   362: aload_3
    //   363: invokestatic 143	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   366: aload_2
    //   367: ifnull +10 -> 377
    //   370: aload 7
    //   372: astore_3
    //   373: aload_2
    //   374: invokevirtual 137	java/io/BufferedReader:close	()V
    //   377: aload_1
    //   378: ifnull +10 -> 388
    //   381: aload 7
    //   383: astore_3
    //   384: aload_1
    //   385: invokevirtual 138	java/io/InputStreamReader:close	()V
    //   388: aload 6
    //   390: astore_1
    //   391: aload_0
    //   392: ifnull +13 -> 405
    //   395: aload 7
    //   397: astore_3
    //   398: aload_0
    //   399: invokevirtual 98	java/io/InputStream:close	()V
    //   402: aload 6
    //   404: astore_1
    //   405: aload_1
    //   406: areturn
    //   407: astore_3
    //   408: aload_2
    //   409: astore 4
    //   411: aload_1
    //   412: astore_2
    //   413: aload_3
    //   414: astore_1
    //   415: aload 4
    //   417: astore_3
    //   418: aload_3
    //   419: ifnull +10 -> 429
    //   422: aload_3
    //   423: invokevirtual 137	java/io/BufferedReader:close	()V
    //   426: goto +3 -> 429
    //   429: aload_2
    //   430: ifnull +7 -> 437
    //   433: aload_2
    //   434: invokevirtual 138	java/io/InputStreamReader:close	()V
    //   437: aload_0
    //   438: ifnull +14 -> 452
    //   441: aload_0
    //   442: invokevirtual 98	java/io/InputStream:close	()V
    //   445: goto +7 -> 452
    //   448: aload_0
    //   449: invokestatic 143	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   452: goto +5 -> 457
    //   455: aload_1
    //   456: athrow
    //   457: goto -2 -> 455
    //   460: aconst_null
    //   461: astore_2
    //   462: aload_2
    //   463: astore_1
    //   464: aload_1
    //   465: astore_0
    //   466: aload_2
    //   467: ifnull -273 -> 194
    //   470: aload_2
    //   471: astore 4
    //   473: aload_1
    //   474: astore_0
    //   475: goto -293 -> 182
    //   478: astore_1
    //   479: aload_2
    //   480: astore_0
    //   481: aconst_null
    //   482: astore_2
    //   483: aload 8
    //   485: astore_3
    //   486: goto -68 -> 418
    //   489: astore 4
    //   491: aload_3
    //   492: astore_0
    //   493: aconst_null
    //   494: astore_1
    //   495: aload_1
    //   496: astore_2
    //   497: aload 4
    //   499: astore_3
    //   500: goto -138 -> 362
    //   503: astore_0
    //   504: goto -166 -> 338
    //   507: astore_0
    //   508: goto -60 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	paramContext	android.content.Context
    //   0	511	1	paramString1	String
    //   0	511	2	paramString2	String
    //   3	75	3	localObject1	Object
    //   90	4	3	localIOException1	java.io.IOException
    //   109	6	3	localIOException2	java.io.IOException
    //   134	110	3	localObject2	Object
    //   259	4	3	localObject3	Object
    //   267	1	3	localException1	java.lang.Exception
    //   274	4	3	localObject4	Object
    //   281	1	3	localObject5	Object
    //   285	1	3	localException2	java.lang.Exception
    //   305	47	3	localObject6	Object
    //   355	8	3	localException3	java.lang.Exception
    //   372	26	3	localObject7	Object
    //   407	7	3	localObject8	Object
    //   417	83	3	localObject9	Object
    //   11	461	4	localObject10	Object
    //   489	9	4	localException4	java.lang.Exception
    //   47	1	5	localObject11	Object
    //   98	1	5	localObject12	Object
    //   119	1	5	localObject13	Object
    //   156	141	5	localObject14	Object
    //   38	365	6	localObject15	Object
    //   44	352	7	localObject16	Object
    //   41	443	8	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   81	85	90	java/io/IOException
    //   70	76	98	finally
    //   70	76	109	java/io/IOException
    //   61	70	119	finally
    //   61	70	128	java/io/IOException
    //   81	85	156	finally
    //   138	142	156	finally
    //   224	232	259	finally
    //   232	238	259	finally
    //   242	248	259	finally
    //   251	256	259	finally
    //   224	232	267	java/lang/Exception
    //   232	238	267	java/lang/Exception
    //   242	248	267	java/lang/Exception
    //   251	256	267	java/lang/Exception
    //   211	224	274	finally
    //   211	224	285	java/lang/Exception
    //   49	57	344	finally
    //   49	57	355	java/lang/Exception
    //   362	366	407	finally
    //   171	175	478	finally
    //   179	182	478	finally
    //   186	191	478	finally
    //   202	211	478	finally
    //   171	175	489	java/lang/Exception
    //   179	182	489	java/lang/Exception
    //   186	191	489	java/lang/Exception
    //   202	211	489	java/lang/Exception
    //   306	311	503	java/io/IOException
    //   320	324	503	java/io/IOException
    //   332	336	503	java/io/IOException
    //   373	377	503	java/io/IOException
    //   384	388	503	java/io/IOException
    //   398	402	503	java/io/IOException
    //   422	426	507	java/io/IOException
    //   433	437	507	java/io/IOException
    //   441	445	507	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceParser
 * JD-Core Version:    0.7.0.1
 */