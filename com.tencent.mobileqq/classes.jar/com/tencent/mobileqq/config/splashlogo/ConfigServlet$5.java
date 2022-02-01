package com.tencent.mobileqq.config.splashlogo;

import aqlw;

public class ConfigServlet$5
  implements Runnable
{
  public ConfigServlet$5(aqlw paramaqlw, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3, String paramString3, String paramString4, float paramFloat4, boolean paramBoolean, int paramInt, String paramString5) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 54	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 23	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 61
    //   16: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 18
    //   24: aload_0
    //   25: getfield 21	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:this$0	Laqlw;
    //   28: invokevirtual 71	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   31: checkcast 73	com/tencent/common/app/AppInterface
    //   34: aload_0
    //   35: getfield 25	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   38: new 75	java/io/File
    //   41: dup
    //   42: aload 18
    //   44: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokestatic 84	com/tencent/mobileqq/utils/HttpDownloadUtil:download	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   50: ifeq +984 -> 1034
    //   53: invokestatic 90	com/tencent/mobileqq/utils/DeviceInfoUtil:getDispalyWidth	()J
    //   56: l2i
    //   57: istore 7
    //   59: invokestatic 93	com/tencent/mobileqq/utils/DeviceInfoUtil:getDispalyHeight	()J
    //   62: l2i
    //   63: istore 8
    //   65: aload_0
    //   66: getfield 21	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:this$0	Laqlw;
    //   69: aload_0
    //   70: getfield 27	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_a_of_type_Float	F
    //   73: iload 7
    //   75: i2f
    //   76: invokestatic 96	aqlw:a	(Laqlw;FF)F
    //   79: fstore_3
    //   80: aload_0
    //   81: getfield 21	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:this$0	Laqlw;
    //   84: aload_0
    //   85: getfield 29	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_b_of_type_Float	F
    //   88: iload 8
    //   90: i2f
    //   91: iload 7
    //   93: i2f
    //   94: invokestatic 99	aqlw:a	(Laqlw;FFF)F
    //   97: fstore 4
    //   99: aload_0
    //   100: getfield 21	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:this$0	Laqlw;
    //   103: aload_0
    //   104: getfield 31	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_c_of_type_Float	F
    //   107: invokestatic 102	aqlw:a	(Laqlw;F)F
    //   110: fstore 5
    //   112: aconst_null
    //   113: astore 10
    //   115: aconst_null
    //   116: astore 11
    //   118: aload 18
    //   120: invokestatic 108	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   123: astore 12
    //   125: aload 12
    //   127: astore 10
    //   129: aload 10
    //   131: ifnull +1741 -> 1872
    //   134: aload 10
    //   136: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   139: ifne +1733 -> 1872
    //   142: iload 7
    //   144: iload 8
    //   146: getstatic 120	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   149: invokestatic 124	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   152: astore 12
    //   154: aload 12
    //   156: astore 11
    //   158: aload 11
    //   160: astore 15
    //   162: aload 10
    //   164: astore 16
    //   166: aload 11
    //   168: ifnull +830 -> 998
    //   171: aload 11
    //   173: astore 15
    //   175: aload 10
    //   177: astore 16
    //   179: aload 10
    //   181: astore 14
    //   183: aload 11
    //   185: astore 13
    //   187: aload 10
    //   189: astore 12
    //   191: aload 11
    //   193: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   196: ifne +802 -> 998
    //   199: aload 10
    //   201: astore 14
    //   203: aload 11
    //   205: astore 13
    //   207: aload 10
    //   209: astore 12
    //   211: new 126	android/graphics/Canvas
    //   214: dup
    //   215: aload 11
    //   217: invokespecial 129	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   220: astore 19
    //   222: aload 10
    //   224: astore 14
    //   226: aload 11
    //   228: astore 13
    //   230: aload 10
    //   232: astore 12
    //   234: new 131	android/graphics/Paint
    //   237: dup
    //   238: invokespecial 132	android/graphics/Paint:<init>	()V
    //   241: astore 15
    //   243: aload 10
    //   245: astore 14
    //   247: aload 11
    //   249: astore 13
    //   251: aload 10
    //   253: astore 12
    //   255: aload 19
    //   257: aload 10
    //   259: new 134	android/graphics/Rect
    //   262: dup
    //   263: iconst_0
    //   264: iconst_0
    //   265: aload 10
    //   267: invokevirtual 138	android/graphics/Bitmap:getWidth	()I
    //   270: aload 10
    //   272: invokevirtual 141	android/graphics/Bitmap:getHeight	()I
    //   275: invokespecial 144	android/graphics/Rect:<init>	(IIII)V
    //   278: new 134	android/graphics/Rect
    //   281: dup
    //   282: iconst_0
    //   283: iconst_0
    //   284: iload 7
    //   286: iload 8
    //   288: invokespecial 144	android/graphics/Rect:<init>	(IIII)V
    //   291: aload 15
    //   293: invokevirtual 148	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   296: aload 10
    //   298: astore 14
    //   300: aload 11
    //   302: astore 13
    //   304: aload 10
    //   306: astore 12
    //   308: aload 10
    //   310: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   313: aconst_null
    //   314: astore 15
    //   316: aconst_null
    //   317: astore 17
    //   319: aconst_null
    //   320: astore 16
    //   322: aload 15
    //   324: astore 14
    //   326: aload 11
    //   328: astore 13
    //   330: aload 17
    //   332: astore 12
    //   334: new 153	android/text/TextPaint
    //   337: dup
    //   338: invokespecial 154	android/text/TextPaint:<init>	()V
    //   341: astore 20
    //   343: aload 15
    //   345: astore 14
    //   347: aload 11
    //   349: astore 13
    //   351: aload 17
    //   353: astore 12
    //   355: aload 20
    //   357: iconst_1
    //   358: invokevirtual 158	android/text/TextPaint:setAntiAlias	(Z)V
    //   361: aload 15
    //   363: astore 14
    //   365: aload 11
    //   367: astore 13
    //   369: aload 17
    //   371: astore 12
    //   373: aload 20
    //   375: aload_0
    //   376: getfield 33	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   379: invokestatic 164	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   382: invokevirtual 168	android/text/TextPaint:setColor	(I)V
    //   385: aload 15
    //   387: astore 14
    //   389: aload 11
    //   391: astore 13
    //   393: aload 17
    //   395: astore 12
    //   397: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +62 -> 462
    //   403: aload 15
    //   405: astore 14
    //   407: aload 11
    //   409: astore 13
    //   411: aload 17
    //   413: astore 12
    //   415: ldc 175
    //   417: iconst_2
    //   418: new 54	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   425: ldc 177
    //   427: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: fload_3
    //   431: invokevirtual 180	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   434: ldc 182
    //   436: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: fload 4
    //   441: invokevirtual 180	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   444: ldc 184
    //   446: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_0
    //   450: getfield 33	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   453: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload 15
    //   464: astore 14
    //   466: aload 11
    //   468: astore 13
    //   470: aload 17
    //   472: astore 12
    //   474: ldc 190
    //   476: aload_0
    //   477: getfield 35	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   480: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   483: ifeq +657 -> 1140
    //   486: aload 15
    //   488: astore 14
    //   490: aload 11
    //   492: astore 13
    //   494: aload 17
    //   496: astore 12
    //   498: aload 20
    //   500: aload_0
    //   501: getfield 21	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:this$0	Laqlw;
    //   504: invokevirtual 71	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   507: invokevirtual 202	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   510: aload_0
    //   511: getfield 37	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_d_of_type_Float	F
    //   514: invokestatic 208	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   517: i2f
    //   518: invokevirtual 212	android/text/TextPaint:setTextSize	(F)V
    //   521: aload 15
    //   523: astore 14
    //   525: aload 11
    //   527: astore 13
    //   529: aload 17
    //   531: astore 12
    //   533: aload 20
    //   535: invokevirtual 216	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   538: astore 10
    //   540: aload 15
    //   542: astore 14
    //   544: aload 11
    //   546: astore 13
    //   548: aload 17
    //   550: astore 12
    //   552: aload_0
    //   553: getfield 39	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_a_of_type_Boolean	Z
    //   556: ifeq +1329 -> 1885
    //   559: aload 15
    //   561: astore 14
    //   563: aload 11
    //   565: astore 13
    //   567: aload 17
    //   569: astore 12
    //   571: aload 10
    //   573: getfield 221	android/graphics/Paint$FontMetrics:ascent	F
    //   576: fstore_1
    //   577: fload 4
    //   579: fload_1
    //   580: fsub
    //   581: fstore_1
    //   582: aload 15
    //   584: astore 14
    //   586: aload 11
    //   588: astore 13
    //   590: aload 17
    //   592: astore 12
    //   594: aload 20
    //   596: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   599: invokevirtual 227	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   602: fload 5
    //   604: fcmpl
    //   605: ifle +430 -> 1035
    //   608: ldc 229
    //   610: astore 10
    //   612: iconst_1
    //   613: istore 7
    //   615: iconst_1
    //   616: istore 8
    //   618: iload 8
    //   620: ifeq +85 -> 705
    //   623: aload 15
    //   625: astore 14
    //   627: aload 11
    //   629: astore 13
    //   631: aload 17
    //   633: astore 12
    //   635: new 54	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   642: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   645: iconst_0
    //   646: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   649: invokevirtual 232	java/lang/String:length	()I
    //   652: iload 7
    //   654: isub
    //   655: invokevirtual 236	java/lang/String:substring	(II)Ljava/lang/String;
    //   658: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: ldc 238
    //   663: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: astore 10
    //   671: aload 15
    //   673: astore 14
    //   675: aload 11
    //   677: astore 13
    //   679: aload 17
    //   681: astore 12
    //   683: aload 20
    //   685: aload 10
    //   687: invokevirtual 227	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   690: fload 5
    //   692: fcmpl
    //   693: ifle +1197 -> 1890
    //   696: iload 7
    //   698: iconst_1
    //   699: iadd
    //   700: istore 7
    //   702: goto +1180 -> 1882
    //   705: aload 15
    //   707: astore 14
    //   709: aload 11
    //   711: astore 13
    //   713: aload 17
    //   715: astore 12
    //   717: aload 19
    //   719: aload 10
    //   721: fload_3
    //   722: fload_1
    //   723: aload 20
    //   725: invokevirtual 242	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   728: aload 15
    //   730: astore 14
    //   732: aload 11
    //   734: astore 13
    //   736: aload 17
    //   738: astore 12
    //   740: aload 19
    //   742: invokevirtual 245	android/graphics/Canvas:save	()I
    //   745: pop
    //   746: aload 15
    //   748: astore 14
    //   750: aload 11
    //   752: astore 13
    //   754: aload 17
    //   756: astore 12
    //   758: aload 19
    //   760: invokevirtual 248	android/graphics/Canvas:restore	()V
    //   763: aload 15
    //   765: astore 14
    //   767: aload 11
    //   769: astore 13
    //   771: aload 17
    //   773: astore 12
    //   775: new 75	java/io/File
    //   778: dup
    //   779: aload_0
    //   780: getfield 23	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   783: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   786: astore 10
    //   788: aload 15
    //   790: astore 14
    //   792: aload 11
    //   794: astore 13
    //   796: aload 17
    //   798: astore 12
    //   800: new 75	java/io/File
    //   803: dup
    //   804: aload 18
    //   806: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   809: astore 18
    //   811: aload 15
    //   813: astore 14
    //   815: aload 11
    //   817: astore 13
    //   819: aload 17
    //   821: astore 12
    //   823: new 250	java/io/BufferedOutputStream
    //   826: dup
    //   827: new 252	java/io/FileOutputStream
    //   830: dup
    //   831: aload 18
    //   833: invokespecial 255	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   836: invokespecial 258	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   839: astore 19
    //   841: aload 15
    //   843: astore 14
    //   845: aload 11
    //   847: astore 13
    //   849: aload 17
    //   851: astore 12
    //   853: aload 11
    //   855: getstatic 264	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   858: bipush 100
    //   860: aload 19
    //   862: invokevirtual 268	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   865: pop
    //   866: aload 15
    //   868: astore 14
    //   870: aload 11
    //   872: astore 13
    //   874: aload 17
    //   876: astore 12
    //   878: aload 19
    //   880: invokevirtual 271	java/io/BufferedOutputStream:flush	()V
    //   883: aload 15
    //   885: astore 14
    //   887: aload 11
    //   889: astore 13
    //   891: aload 17
    //   893: astore 12
    //   895: aload 19
    //   897: invokevirtual 274	java/io/BufferedOutputStream:close	()V
    //   900: aload 15
    //   902: astore 14
    //   904: aload 11
    //   906: astore 13
    //   908: aload 17
    //   910: astore 12
    //   912: aload 10
    //   914: invokevirtual 277	java/io/File:exists	()Z
    //   917: ifeq +21 -> 938
    //   920: aload 15
    //   922: astore 14
    //   924: aload 11
    //   926: astore 13
    //   928: aload 17
    //   930: astore 12
    //   932: aload 10
    //   934: invokevirtual 280	java/io/File:delete	()Z
    //   937: pop
    //   938: aload 15
    //   940: astore 14
    //   942: aload 11
    //   944: astore 13
    //   946: aload 17
    //   948: astore 12
    //   950: aload 18
    //   952: aload 10
    //   954: invokevirtual 284	java/io/File:renameTo	(Ljava/io/File;)Z
    //   957: pop
    //   958: aload 15
    //   960: astore 14
    //   962: aload 11
    //   964: astore 13
    //   966: aload 17
    //   968: astore 12
    //   970: aload_0
    //   971: getfield 21	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:this$0	Laqlw;
    //   974: invokevirtual 71	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   977: invokevirtual 202	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   980: aload_0
    //   981: getfield 41	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_a_of_type_Int	I
    //   984: aload_0
    //   985: getfield 43	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:e	Ljava/lang/String;
    //   988: getstatic 285	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   991: invokestatic 290	bfyz:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   994: aload 11
    //   996: astore 15
    //   998: aload 16
    //   1000: ifnull +16 -> 1016
    //   1003: aload 16
    //   1005: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   1008: ifne +8 -> 1016
    //   1011: aload 16
    //   1013: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   1016: aload 15
    //   1018: ifnull +16 -> 1034
    //   1021: aload 15
    //   1023: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   1026: ifne +8 -> 1034
    //   1029: aload 15
    //   1031: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   1034: return
    //   1035: aload 15
    //   1037: astore 14
    //   1039: aload 11
    //   1041: astore 13
    //   1043: aload 17
    //   1045: astore 12
    //   1047: aload 19
    //   1049: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   1052: fload_3
    //   1053: fload_1
    //   1054: aload 20
    //   1056: invokevirtual 242	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1059: goto -331 -> 728
    //   1062: astore 12
    //   1064: aconst_null
    //   1065: astore 10
    //   1067: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1070: ifeq +33 -> 1103
    //   1073: ldc 175
    //   1075: iconst_2
    //   1076: new 54	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   1083: ldc_w 292
    //   1086: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: aload 12
    //   1091: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1094: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1100: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1103: aload 10
    //   1105: ifnull +16 -> 1121
    //   1108: aload 10
    //   1110: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   1113: ifne +8 -> 1121
    //   1116: aload 10
    //   1118: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   1121: aload 11
    //   1123: ifnull -89 -> 1034
    //   1126: aload 11
    //   1128: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   1131: ifne -97 -> 1034
    //   1134: aload 11
    //   1136: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   1139: return
    //   1140: aload 15
    //   1142: astore 14
    //   1144: aload 11
    //   1146: astore 13
    //   1148: aload 17
    //   1150: astore 12
    //   1152: ldc_w 297
    //   1155: aload_0
    //   1156: getfield 35	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1159: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1162: ifeq +591 -> 1753
    //   1165: aload 15
    //   1167: astore 14
    //   1169: aload 11
    //   1171: astore 13
    //   1173: aload 17
    //   1175: astore 12
    //   1177: aload_0
    //   1178: getfield 37	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_d_of_type_Float	F
    //   1181: ldc_w 298
    //   1184: fcmpg
    //   1185: ifge +256 -> 1441
    //   1188: ldc_w 298
    //   1191: fstore_1
    //   1192: goto +707 -> 1899
    //   1195: aload 15
    //   1197: astore 14
    //   1199: aload 11
    //   1201: astore 13
    //   1203: aload 17
    //   1205: astore 12
    //   1207: aload 20
    //   1209: aload_0
    //   1210: getfield 21	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:this$0	Laqlw;
    //   1213: invokevirtual 71	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1216: invokevirtual 202	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   1219: fload_1
    //   1220: invokestatic 208	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   1223: i2f
    //   1224: invokevirtual 212	android/text/TextPaint:setTextSize	(F)V
    //   1227: aload 15
    //   1229: astore 14
    //   1231: aload 11
    //   1233: astore 13
    //   1235: aload 17
    //   1237: astore 12
    //   1239: aload 20
    //   1241: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   1244: invokevirtual 227	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   1247: fstore_2
    //   1248: fload_2
    //   1249: fload 5
    //   1251: fcmpg
    //   1252: ifgt +650 -> 1902
    //   1255: iconst_1
    //   1256: istore 7
    //   1258: iload 7
    //   1260: ifeq +201 -> 1461
    //   1263: aload 15
    //   1265: astore 14
    //   1267: aload 11
    //   1269: astore 13
    //   1271: aload 17
    //   1273: astore 12
    //   1275: aload 20
    //   1277: invokevirtual 216	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   1280: astore 10
    //   1282: aload 15
    //   1284: astore 14
    //   1286: aload 11
    //   1288: astore 13
    //   1290: aload 17
    //   1292: astore 12
    //   1294: aload_0
    //   1295: getfield 39	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_a_of_type_Boolean	Z
    //   1298: ifeq +639 -> 1937
    //   1301: aload 15
    //   1303: astore 14
    //   1305: aload 11
    //   1307: astore 13
    //   1309: aload 17
    //   1311: astore 12
    //   1313: aload 10
    //   1315: getfield 221	android/graphics/Paint$FontMetrics:ascent	F
    //   1318: fstore_1
    //   1319: aload 15
    //   1321: astore 14
    //   1323: aload 11
    //   1325: astore 13
    //   1327: aload 17
    //   1329: astore 12
    //   1331: fload_2
    //   1332: fconst_2
    //   1333: fdiv
    //   1334: fstore_2
    //   1335: aload 15
    //   1337: astore 14
    //   1339: aload 11
    //   1341: astore 13
    //   1343: aload 17
    //   1345: astore 12
    //   1347: aload 19
    //   1349: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   1352: fload_3
    //   1353: fload_2
    //   1354: fsub
    //   1355: fload 4
    //   1357: fload_1
    //   1358: fsub
    //   1359: aload 20
    //   1361: invokevirtual 242	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1364: goto -636 -> 728
    //   1367: astore 10
    //   1369: aload 14
    //   1371: astore 10
    //   1373: aload 11
    //   1375: astore 13
    //   1377: aload 10
    //   1379: astore 12
    //   1381: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1384: ifeq +20 -> 1404
    //   1387: aload 11
    //   1389: astore 13
    //   1391: aload 10
    //   1393: astore 12
    //   1395: ldc 175
    //   1397: iconst_2
    //   1398: ldc_w 300
    //   1401: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1404: aload 10
    //   1406: ifnull +16 -> 1422
    //   1409: aload 10
    //   1411: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   1414: ifne +8 -> 1422
    //   1417: aload 10
    //   1419: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   1422: aload 11
    //   1424: ifnull -390 -> 1034
    //   1427: aload 11
    //   1429: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   1432: ifne -398 -> 1034
    //   1435: aload 11
    //   1437: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   1440: return
    //   1441: aload 15
    //   1443: astore 14
    //   1445: aload 11
    //   1447: astore 13
    //   1449: aload 17
    //   1451: astore 12
    //   1453: aload_0
    //   1454: getfield 37	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_d_of_type_Float	F
    //   1457: fstore_1
    //   1458: goto +441 -> 1899
    //   1461: aload 15
    //   1463: astore 14
    //   1465: aload 11
    //   1467: astore 13
    //   1469: aload 17
    //   1471: astore 12
    //   1473: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   1476: invokevirtual 232	java/lang/String:length	()I
    //   1479: istore 9
    //   1481: ldc 229
    //   1483: astore 10
    //   1485: fload_2
    //   1486: fstore_1
    //   1487: iconst_1
    //   1488: istore 8
    //   1490: iload 8
    //   1492: iload 9
    //   1494: if_icmpgt +369 -> 1863
    //   1497: aload 15
    //   1499: astore 14
    //   1501: aload 11
    //   1503: astore 13
    //   1505: aload 17
    //   1507: astore 12
    //   1509: new 54	java/lang/StringBuilder
    //   1512: dup
    //   1513: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   1516: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   1519: iconst_0
    //   1520: invokestatic 223	aqlw:a	()Ljava/lang/String;
    //   1523: invokevirtual 232	java/lang/String:length	()I
    //   1526: iload 8
    //   1528: isub
    //   1529: invokevirtual 236	java/lang/String:substring	(II)Ljava/lang/String;
    //   1532: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: ldc 238
    //   1537: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1543: astore 10
    //   1545: aload 15
    //   1547: astore 14
    //   1549: aload 11
    //   1551: astore 13
    //   1553: aload 17
    //   1555: astore 12
    //   1557: aload 20
    //   1559: aload 10
    //   1561: invokevirtual 227	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   1564: fstore_1
    //   1565: fload_1
    //   1566: fload 5
    //   1568: fcmpl
    //   1569: ifle +373 -> 1942
    //   1572: iload 8
    //   1574: iconst_1
    //   1575: iadd
    //   1576: istore 8
    //   1578: goto -88 -> 1490
    //   1581: iload 7
    //   1583: ifeq +146 -> 1729
    //   1586: aload 15
    //   1588: astore 14
    //   1590: aload 11
    //   1592: astore 13
    //   1594: aload 17
    //   1596: astore 12
    //   1598: aload 20
    //   1600: invokevirtual 216	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   1603: astore 21
    //   1605: aload 15
    //   1607: astore 14
    //   1609: aload 11
    //   1611: astore 13
    //   1613: aload 17
    //   1615: astore 12
    //   1617: aload_0
    //   1618: getfield 39	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_a_of_type_Boolean	Z
    //   1621: ifeq +103 -> 1724
    //   1624: aload 15
    //   1626: astore 14
    //   1628: aload 11
    //   1630: astore 13
    //   1632: aload 17
    //   1634: astore 12
    //   1636: aload 21
    //   1638: getfield 221	android/graphics/Paint$FontMetrics:ascent	F
    //   1641: fstore_2
    //   1642: aload 15
    //   1644: astore 14
    //   1646: aload 11
    //   1648: astore 13
    //   1650: aload 17
    //   1652: astore 12
    //   1654: aload 19
    //   1656: aload 10
    //   1658: fload_3
    //   1659: fload_1
    //   1660: fconst_2
    //   1661: fdiv
    //   1662: fsub
    //   1663: fload 4
    //   1665: fload_2
    //   1666: fsub
    //   1667: aload 20
    //   1669: invokevirtual 242	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1672: goto -944 -> 728
    //   1675: astore 11
    //   1677: aload 12
    //   1679: astore 10
    //   1681: aload 13
    //   1683: astore 12
    //   1685: aload 10
    //   1687: ifnull +16 -> 1703
    //   1690: aload 10
    //   1692: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   1695: ifne +8 -> 1703
    //   1698: aload 10
    //   1700: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   1703: aload 12
    //   1705: ifnull +16 -> 1721
    //   1708: aload 12
    //   1710: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   1713: ifne +8 -> 1721
    //   1716: aload 12
    //   1718: invokevirtual 151	android/graphics/Bitmap:recycle	()V
    //   1721: aload 11
    //   1723: athrow
    //   1724: fconst_0
    //   1725: fstore_2
    //   1726: goto -84 -> 1642
    //   1729: aload 15
    //   1731: astore 14
    //   1733: aload 11
    //   1735: astore 13
    //   1737: aload 17
    //   1739: astore 12
    //   1741: ldc 175
    //   1743: iconst_1
    //   1744: ldc_w 302
    //   1747: invokestatic 304	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1750: goto -1022 -> 728
    //   1753: aload 15
    //   1755: astore 14
    //   1757: aload 11
    //   1759: astore 13
    //   1761: aload 17
    //   1763: astore 12
    //   1765: ldc 175
    //   1767: iconst_1
    //   1768: new 54	java/lang/StringBuilder
    //   1771: dup
    //   1772: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   1775: ldc_w 306
    //   1778: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: aload_0
    //   1782: getfield 35	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1785: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1791: invokestatic 304	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1794: goto -1066 -> 728
    //   1797: astore 11
    //   1799: aconst_null
    //   1800: astore 10
    //   1802: aconst_null
    //   1803: astore 12
    //   1805: goto -120 -> 1685
    //   1808: astore 11
    //   1810: aconst_null
    //   1811: astore 12
    //   1813: goto -128 -> 1685
    //   1816: astore 13
    //   1818: aload 11
    //   1820: astore 12
    //   1822: aload 13
    //   1824: astore 11
    //   1826: goto -141 -> 1685
    //   1829: astore 10
    //   1831: aconst_null
    //   1832: astore 10
    //   1834: aconst_null
    //   1835: astore 11
    //   1837: goto -464 -> 1373
    //   1840: astore 11
    //   1842: aconst_null
    //   1843: astore 11
    //   1845: goto -472 -> 1373
    //   1848: astore 12
    //   1850: goto -783 -> 1067
    //   1853: astore 12
    //   1855: goto -788 -> 1067
    //   1858: astore 12
    //   1860: goto -793 -> 1067
    //   1863: goto -282 -> 1581
    //   1866: iconst_0
    //   1867: istore 7
    //   1869: goto -611 -> 1258
    //   1872: aconst_null
    //   1873: astore 15
    //   1875: aload 10
    //   1877: astore 16
    //   1879: goto -881 -> 998
    //   1882: goto -1264 -> 618
    //   1885: fconst_0
    //   1886: fstore_1
    //   1887: goto -1310 -> 577
    //   1890: iconst_0
    //   1891: istore 8
    //   1893: iconst_0
    //   1894: istore 7
    //   1896: goto -14 -> 1882
    //   1899: goto -704 -> 1195
    //   1902: fload_1
    //   1903: ldc_w 298
    //   1906: fsub
    //   1907: fstore 6
    //   1909: fload 6
    //   1911: fconst_1
    //   1912: fcmpl
    //   1913: ifle +10 -> 1923
    //   1916: fload_1
    //   1917: fconst_1
    //   1918: fsub
    //   1919: fstore_1
    //   1920: goto -725 -> 1195
    //   1923: fload 6
    //   1925: fconst_0
    //   1926: fcmpl
    //   1927: ifle -61 -> 1866
    //   1930: ldc_w 298
    //   1933: fstore_1
    //   1934: goto -739 -> 1195
    //   1937: fconst_0
    //   1938: fstore_1
    //   1939: goto -620 -> 1319
    //   1942: iconst_1
    //   1943: istore 7
    //   1945: goto -364 -> 1581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1948	0	this	5
    //   576	1363	1	f1	float
    //   1247	479	2	f2	float
    //   79	1580	3	f3	float
    //   97	1567	4	f4	float
    //   110	1457	5	f5	float
    //   1907	17	6	f6	float
    //   57	1887	7	i	int
    //   63	1829	8	j	int
    //   1479	16	9	k	int
    //   113	1201	10	localObject1	Object
    //   1367	1	10	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1371	430	10	localObject2	Object
    //   1829	1	10	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1832	44	10	localObject3	Object
    //   116	1531	11	localObject4	Object
    //   1675	83	11	localObject5	Object
    //   1797	1	11	localObject6	Object
    //   1808	11	11	localObject7	Object
    //   1824	12	11	localObject8	Object
    //   1840	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1843	1	11	localObject9	Object
    //   123	923	12	localObject10	Object
    //   1062	28	12	localException1	java.lang.Exception
    //   1150	671	12	localObject11	Object
    //   1848	1	12	localException2	java.lang.Exception
    //   1853	1	12	localException3	java.lang.Exception
    //   1858	1	12	localException4	java.lang.Exception
    //   185	1575	13	localObject12	Object
    //   1816	7	13	localObject13	Object
    //   181	1575	14	localObject14	Object
    //   160	1714	15	localObject15	Object
    //   164	1714	16	localObject16	Object
    //   317	1445	17	localObject17	Object
    //   22	929	18	localObject18	Object
    //   220	1435	19	localObject19	Object
    //   341	1327	20	localTextPaint	android.text.TextPaint
    //   1603	34	21	localFontMetrics	android.graphics.Paint.FontMetrics
    // Exception table:
    //   from	to	target	type
    //   334	343	1062	java/lang/Exception
    //   355	361	1062	java/lang/Exception
    //   373	385	1062	java/lang/Exception
    //   397	403	1062	java/lang/Exception
    //   415	462	1062	java/lang/Exception
    //   474	486	1062	java/lang/Exception
    //   498	521	1062	java/lang/Exception
    //   533	540	1062	java/lang/Exception
    //   552	559	1062	java/lang/Exception
    //   571	577	1062	java/lang/Exception
    //   594	608	1062	java/lang/Exception
    //   635	671	1062	java/lang/Exception
    //   683	696	1062	java/lang/Exception
    //   717	728	1062	java/lang/Exception
    //   740	746	1062	java/lang/Exception
    //   758	763	1062	java/lang/Exception
    //   775	788	1062	java/lang/Exception
    //   800	811	1062	java/lang/Exception
    //   823	841	1062	java/lang/Exception
    //   853	866	1062	java/lang/Exception
    //   878	883	1062	java/lang/Exception
    //   895	900	1062	java/lang/Exception
    //   912	920	1062	java/lang/Exception
    //   932	938	1062	java/lang/Exception
    //   950	958	1062	java/lang/Exception
    //   970	994	1062	java/lang/Exception
    //   1047	1059	1062	java/lang/Exception
    //   1152	1165	1062	java/lang/Exception
    //   1177	1188	1062	java/lang/Exception
    //   1207	1227	1062	java/lang/Exception
    //   1239	1248	1062	java/lang/Exception
    //   1275	1282	1062	java/lang/Exception
    //   1294	1301	1062	java/lang/Exception
    //   1313	1319	1062	java/lang/Exception
    //   1331	1335	1062	java/lang/Exception
    //   1347	1364	1062	java/lang/Exception
    //   1453	1458	1062	java/lang/Exception
    //   1473	1481	1062	java/lang/Exception
    //   1509	1545	1062	java/lang/Exception
    //   1557	1565	1062	java/lang/Exception
    //   1598	1605	1062	java/lang/Exception
    //   1617	1624	1062	java/lang/Exception
    //   1636	1642	1062	java/lang/Exception
    //   1654	1672	1062	java/lang/Exception
    //   1741	1750	1062	java/lang/Exception
    //   1765	1794	1062	java/lang/Exception
    //   191	199	1367	java/lang/OutOfMemoryError
    //   211	222	1367	java/lang/OutOfMemoryError
    //   234	243	1367	java/lang/OutOfMemoryError
    //   255	296	1367	java/lang/OutOfMemoryError
    //   308	313	1367	java/lang/OutOfMemoryError
    //   334	343	1367	java/lang/OutOfMemoryError
    //   355	361	1367	java/lang/OutOfMemoryError
    //   373	385	1367	java/lang/OutOfMemoryError
    //   397	403	1367	java/lang/OutOfMemoryError
    //   415	462	1367	java/lang/OutOfMemoryError
    //   474	486	1367	java/lang/OutOfMemoryError
    //   498	521	1367	java/lang/OutOfMemoryError
    //   533	540	1367	java/lang/OutOfMemoryError
    //   552	559	1367	java/lang/OutOfMemoryError
    //   571	577	1367	java/lang/OutOfMemoryError
    //   594	608	1367	java/lang/OutOfMemoryError
    //   635	671	1367	java/lang/OutOfMemoryError
    //   683	696	1367	java/lang/OutOfMemoryError
    //   717	728	1367	java/lang/OutOfMemoryError
    //   740	746	1367	java/lang/OutOfMemoryError
    //   758	763	1367	java/lang/OutOfMemoryError
    //   775	788	1367	java/lang/OutOfMemoryError
    //   800	811	1367	java/lang/OutOfMemoryError
    //   823	841	1367	java/lang/OutOfMemoryError
    //   853	866	1367	java/lang/OutOfMemoryError
    //   878	883	1367	java/lang/OutOfMemoryError
    //   895	900	1367	java/lang/OutOfMemoryError
    //   912	920	1367	java/lang/OutOfMemoryError
    //   932	938	1367	java/lang/OutOfMemoryError
    //   950	958	1367	java/lang/OutOfMemoryError
    //   970	994	1367	java/lang/OutOfMemoryError
    //   1047	1059	1367	java/lang/OutOfMemoryError
    //   1152	1165	1367	java/lang/OutOfMemoryError
    //   1177	1188	1367	java/lang/OutOfMemoryError
    //   1207	1227	1367	java/lang/OutOfMemoryError
    //   1239	1248	1367	java/lang/OutOfMemoryError
    //   1275	1282	1367	java/lang/OutOfMemoryError
    //   1294	1301	1367	java/lang/OutOfMemoryError
    //   1313	1319	1367	java/lang/OutOfMemoryError
    //   1331	1335	1367	java/lang/OutOfMemoryError
    //   1347	1364	1367	java/lang/OutOfMemoryError
    //   1453	1458	1367	java/lang/OutOfMemoryError
    //   1473	1481	1367	java/lang/OutOfMemoryError
    //   1509	1545	1367	java/lang/OutOfMemoryError
    //   1557	1565	1367	java/lang/OutOfMemoryError
    //   1598	1605	1367	java/lang/OutOfMemoryError
    //   1617	1624	1367	java/lang/OutOfMemoryError
    //   1636	1642	1367	java/lang/OutOfMemoryError
    //   1654	1672	1367	java/lang/OutOfMemoryError
    //   1741	1750	1367	java/lang/OutOfMemoryError
    //   1765	1794	1367	java/lang/OutOfMemoryError
    //   191	199	1675	finally
    //   211	222	1675	finally
    //   234	243	1675	finally
    //   255	296	1675	finally
    //   308	313	1675	finally
    //   334	343	1675	finally
    //   355	361	1675	finally
    //   373	385	1675	finally
    //   397	403	1675	finally
    //   415	462	1675	finally
    //   474	486	1675	finally
    //   498	521	1675	finally
    //   533	540	1675	finally
    //   552	559	1675	finally
    //   571	577	1675	finally
    //   594	608	1675	finally
    //   635	671	1675	finally
    //   683	696	1675	finally
    //   717	728	1675	finally
    //   740	746	1675	finally
    //   758	763	1675	finally
    //   775	788	1675	finally
    //   800	811	1675	finally
    //   823	841	1675	finally
    //   853	866	1675	finally
    //   878	883	1675	finally
    //   895	900	1675	finally
    //   912	920	1675	finally
    //   932	938	1675	finally
    //   950	958	1675	finally
    //   970	994	1675	finally
    //   1047	1059	1675	finally
    //   1152	1165	1675	finally
    //   1177	1188	1675	finally
    //   1207	1227	1675	finally
    //   1239	1248	1675	finally
    //   1275	1282	1675	finally
    //   1294	1301	1675	finally
    //   1313	1319	1675	finally
    //   1331	1335	1675	finally
    //   1347	1364	1675	finally
    //   1381	1387	1675	finally
    //   1395	1404	1675	finally
    //   1453	1458	1675	finally
    //   1473	1481	1675	finally
    //   1509	1545	1675	finally
    //   1557	1565	1675	finally
    //   1598	1605	1675	finally
    //   1617	1624	1675	finally
    //   1636	1642	1675	finally
    //   1654	1672	1675	finally
    //   1741	1750	1675	finally
    //   1765	1794	1675	finally
    //   118	125	1797	finally
    //   134	154	1808	finally
    //   1067	1103	1816	finally
    //   118	125	1829	java/lang/OutOfMemoryError
    //   134	154	1840	java/lang/OutOfMemoryError
    //   118	125	1848	java/lang/Exception
    //   134	154	1853	java/lang/Exception
    //   191	199	1858	java/lang/Exception
    //   211	222	1858	java/lang/Exception
    //   234	243	1858	java/lang/Exception
    //   255	296	1858	java/lang/Exception
    //   308	313	1858	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.5
 * JD-Core Version:    0.7.0.1
 */