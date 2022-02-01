package cooperation.comic;

final class VipComicReportUtils$2
  implements Runnable
{
  VipComicReportUtils$2(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, String paramString8, String paramString9, String paramString10) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 61	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 65	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6: astore 7
    //   8: aload 7
    //   10: invokevirtual 71	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   13: astore 10
    //   15: aload 7
    //   17: iconst_2
    //   18: invokevirtual 75	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   21: checkcast 77	mqq/manager/TicketManager
    //   24: astore 7
    //   26: aload 7
    //   28: ifnull +76 -> 104
    //   31: new 79	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   38: bipush 64
    //   40: invokevirtual 84	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   43: aload 7
    //   45: aload 10
    //   47: invokeinterface 88 2 0
    //   52: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 7
    //   60: aload 7
    //   62: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifne +746 -> 811
    //   68: ldc2_w 101
    //   71: lstore_3
    //   72: iconst_0
    //   73: istore_1
    //   74: iload_1
    //   75: aload 7
    //   77: invokevirtual 108	java/lang/String:length	()I
    //   80: if_icmpge +30 -> 110
    //   83: lload_3
    //   84: lload_3
    //   85: iconst_5
    //   86: lshl
    //   87: aload 7
    //   89: iload_1
    //   90: invokevirtual 112	java/lang/String:charAt	(I)C
    //   93: i2l
    //   94: ladd
    //   95: ladd
    //   96: lstore_3
    //   97: iload_1
    //   98: iconst_1
    //   99: iadd
    //   100: istore_1
    //   101: goto -27 -> 74
    //   104: aconst_null
    //   105: astore 7
    //   107: goto -47 -> 60
    //   110: getstatic 118	java/util/Locale:US	Ljava/util/Locale;
    //   113: ldc 120
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: ldc 122
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: lload_3
    //   127: ldc2_w 123
    //   130: land
    //   131: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   134: aastore
    //   135: invokestatic 132	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   138: astore 9
    //   140: new 79	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   147: invokestatic 138	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   150: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   153: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: bipush 95
    //   158: invokevirtual 84	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   161: invokestatic 143	cooperation/comic/VipComicReportUtils:a	()Ljava/util/Random;
    //   164: sipush 10000
    //   167: invokevirtual 149	java/util/Random:nextInt	(I)I
    //   170: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore 11
    //   178: invokestatic 155	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   181: lstore_3
    //   182: new 79	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   189: aload_0
    //   190: getfield 22	cooperation/comic/VipComicReportUtils$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   193: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   199: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore 12
    //   207: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   210: lstore 5
    //   212: invokestatic 168	com/tencent/biz/common/util/HttpUtil:getNetWorkType	()I
    //   215: istore_2
    //   216: iload_2
    //   217: iflt +13 -> 230
    //   220: iload_2
    //   221: istore_1
    //   222: iload_2
    //   223: getstatic 174	com/tencent/mobileqq/app/AppConstants:NET_TYPE_NAME	[Ljava/lang/String;
    //   226: arraylength
    //   227: if_icmplt +5 -> 232
    //   230: iconst_0
    //   231: istore_1
    //   232: getstatic 174	com/tencent/mobileqq/app/AppConstants:NET_TYPE_NAME	[Ljava/lang/String;
    //   235: iload_1
    //   236: aaload
    //   237: astore 13
    //   239: new 176	org/json/JSONObject
    //   242: dup
    //   243: invokespecial 177	org/json/JSONObject:<init>	()V
    //   246: astore 8
    //   248: new 176	org/json/JSONObject
    //   251: dup
    //   252: invokespecial 177	org/json/JSONObject:<init>	()V
    //   255: astore 14
    //   257: new 176	org/json/JSONObject
    //   260: dup
    //   261: invokespecial 177	org/json/JSONObject:<init>	()V
    //   264: astore 15
    //   266: new 176	org/json/JSONObject
    //   269: dup
    //   270: invokespecial 177	org/json/JSONObject:<init>	()V
    //   273: astore 16
    //   275: new 179	org/json/JSONArray
    //   278: dup
    //   279: invokespecial 180	org/json/JSONArray:<init>	()V
    //   282: astore 17
    //   284: new 176	org/json/JSONObject
    //   287: dup
    //   288: invokespecial 177	org/json/JSONObject:<init>	()V
    //   291: astore 18
    //   293: new 176	org/json/JSONObject
    //   296: dup
    //   297: invokespecial 177	org/json/JSONObject:<init>	()V
    //   300: astore 19
    //   302: new 176	org/json/JSONObject
    //   305: dup
    //   306: invokespecial 177	org/json/JSONObject:<init>	()V
    //   309: astore 20
    //   311: aload 19
    //   313: ldc 182
    //   315: iconst_1
    //   316: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   319: pop
    //   320: aload 19
    //   322: ldc 188
    //   324: aload 10
    //   326: invokestatic 194	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   329: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   332: pop
    //   333: aload 19
    //   335: ldc 199
    //   337: aload 7
    //   339: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   342: pop
    //   343: aload 16
    //   345: ldc 204
    //   347: iconst_2
    //   348: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload 16
    //   354: ldc 206
    //   356: ldc 208
    //   358: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   361: pop
    //   362: aload 16
    //   364: ldc 210
    //   366: iconst_0
    //   367: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   370: pop
    //   371: aload 16
    //   373: ldc 212
    //   375: aload 10
    //   377: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   380: pop
    //   381: aload 16
    //   383: ldc 214
    //   385: aload 10
    //   387: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   390: pop
    //   391: aload 16
    //   393: ldc 216
    //   395: ldc 122
    //   397: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   400: pop
    //   401: aload 16
    //   403: ldc 218
    //   405: ldc 220
    //   407: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   410: pop
    //   411: aload 16
    //   413: ldc 222
    //   415: aload 13
    //   417: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   420: pop
    //   421: aload 16
    //   423: ldc 224
    //   425: iconst_1
    //   426: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 16
    //   432: ldc 226
    //   434: new 79	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   441: ldc 228
    //   443: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 11
    //   448: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: ldc 230
    //   453: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 235	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   462: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   465: pop
    //   466: aload 16
    //   468: ldc 237
    //   470: ldc 238
    //   472: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   475: pop
    //   476: aload 16
    //   478: ldc 240
    //   480: aload 12
    //   482: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   485: pop
    //   486: aload 16
    //   488: ldc 242
    //   490: aload_0
    //   491: getfield 24	cooperation/comic/VipComicReportUtils$2:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   494: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   497: pop
    //   498: aload 16
    //   500: ldc 244
    //   502: aload_0
    //   503: getfield 26	cooperation/comic/VipComicReportUtils$2:c	Ljava/lang/String;
    //   506: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   509: pop
    //   510: aload_0
    //   511: getfield 28	cooperation/comic/VipComicReportUtils$2:d	Ljava/lang/String;
    //   514: invokevirtual 247	java/lang/String:isEmpty	()Z
    //   517: ifeq +305 -> 822
    //   520: aload 16
    //   522: ldc 249
    //   524: aload 11
    //   526: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   529: pop
    //   530: aload 16
    //   532: ldc 251
    //   534: aload_0
    //   535: getfield 30	cooperation/comic/VipComicReportUtils$2:jdField_a_of_type_Int	I
    //   538: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   541: pop
    //   542: aload 16
    //   544: ldc 253
    //   546: lload_3
    //   547: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   550: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   553: pop
    //   554: aload 18
    //   556: ldc 255
    //   558: aload_0
    //   559: getfield 22	cooperation/comic/VipComicReportUtils$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   562: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   565: pop
    //   566: aload 18
    //   568: ldc_w 257
    //   571: lload 5
    //   573: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   576: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   579: pop
    //   580: aload 18
    //   582: ldc_w 259
    //   585: aload_0
    //   586: getfield 32	cooperation/comic/VipComicReportUtils$2:e	Ljava/lang/String;
    //   589: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   592: pop
    //   593: aload 18
    //   595: ldc_w 261
    //   598: aload_0
    //   599: getfield 34	cooperation/comic/VipComicReportUtils$2:f	Ljava/lang/String;
    //   602: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   605: pop
    //   606: aload 18
    //   608: ldc_w 263
    //   611: ldc_w 265
    //   614: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   617: pop
    //   618: aload 18
    //   620: ldc_w 267
    //   623: aload_0
    //   624: getfield 36	cooperation/comic/VipComicReportUtils$2:g	Ljava/lang/String;
    //   627: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   630: pop
    //   631: aload 18
    //   633: ldc_w 269
    //   636: aload_0
    //   637: getfield 38	cooperation/comic/VipComicReportUtils$2:jdField_b_of_type_Int	I
    //   640: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   643: pop
    //   644: aload 20
    //   646: ldc_w 271
    //   649: aload_0
    //   650: getfield 40	cooperation/comic/VipComicReportUtils$2:h	Ljava/lang/String;
    //   653: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   656: pop
    //   657: aload 20
    //   659: ldc_w 273
    //   662: aload_0
    //   663: getfield 42	cooperation/comic/VipComicReportUtils$2:i	Ljava/lang/String;
    //   666: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   669: pop
    //   670: aload 18
    //   672: ldc_w 275
    //   675: aload 20
    //   677: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   680: pop
    //   681: aload 17
    //   683: aload 18
    //   685: invokevirtual 278	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   688: pop
    //   689: aload 14
    //   691: ldc_w 280
    //   694: ldc_w 282
    //   697: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   700: pop
    //   701: aload 14
    //   703: ldc_w 284
    //   706: ldc_w 286
    //   709: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   712: pop
    //   713: aload 15
    //   715: ldc_w 288
    //   718: aload 16
    //   720: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   723: pop
    //   724: aload 15
    //   726: ldc_w 290
    //   729: aload 17
    //   731: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   734: pop
    //   735: aload 15
    //   737: ldc_w 292
    //   740: aload 19
    //   742: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   745: pop
    //   746: aload 15
    //   748: ldc_w 294
    //   751: iconst_2
    //   752: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   755: pop
    //   756: aload 15
    //   758: ldc_w 296
    //   761: iconst_3
    //   762: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   765: pop
    //   766: aload 15
    //   768: ldc_w 298
    //   771: aload_0
    //   772: getfield 44	cooperation/comic/VipComicReportUtils$2:j	Ljava/lang/String;
    //   775: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   778: pop
    //   779: aload 14
    //   781: ldc_w 300
    //   784: aload 15
    //   786: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   789: pop
    //   790: aload 8
    //   792: ldc_w 302
    //   795: aload 14
    //   797: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   800: pop
    //   801: aload 8
    //   803: astore 7
    //   805: aload 7
    //   807: ifnonnull +43 -> 850
    //   810: return
    //   811: ldc_w 304
    //   814: iconst_1
    //   815: ldc_w 306
    //   818: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   821: return
    //   822: aload 16
    //   824: ldc 249
    //   826: aload_0
    //   827: getfield 28	cooperation/comic/VipComicReportUtils$2:d	Ljava/lang/String;
    //   830: invokevirtual 202	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   833: pop
    //   834: goto -304 -> 530
    //   837: astore 7
    //   839: aload 7
    //   841: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   844: aconst_null
    //   845: astore 7
    //   847: goto -42 -> 805
    //   850: invokestatic 317	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq +34 -> 887
    //   856: ldc_w 304
    //   859: iconst_2
    //   860: new 79	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   867: ldc_w 319
    //   870: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload 7
    //   875: invokevirtual 320	org/json/JSONObject:toString	()Ljava/lang/String;
    //   878: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   887: aconst_null
    //   888: astore 8
    //   890: aconst_null
    //   891: astore 11
    //   893: aconst_null
    //   894: astore 10
    //   896: aconst_null
    //   897: astore 12
    //   899: new 79	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 324
    //   909: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload 7
    //   914: invokevirtual 320	org/json/JSONObject:toString	()Ljava/lang/String;
    //   917: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokevirtual 328	java/lang/String:getBytes	()[B
    //   926: astore 13
    //   928: new 330	java/net/URL
    //   931: dup
    //   932: aload 9
    //   934: invokespecial 333	java/net/URL:<init>	(Ljava/lang/String;)V
    //   937: invokevirtual 337	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   940: checkcast 339	java/net/HttpURLConnection
    //   943: astore 7
    //   945: aload 7
    //   947: sipush 5000
    //   950: invokevirtual 343	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   953: aload 7
    //   955: sipush 30000
    //   958: invokevirtual 346	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   961: aload 7
    //   963: iconst_0
    //   964: invokevirtual 350	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   967: aload 7
    //   969: ldc_w 352
    //   972: invokevirtual 355	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   975: aload 7
    //   977: ldc_w 357
    //   980: ldc_w 359
    //   983: invokevirtual 363	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   986: aload 7
    //   988: ldc_w 365
    //   991: ldc_w 367
    //   994: invokevirtual 363	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   997: aload 7
    //   999: ldc_w 369
    //   1002: aload 13
    //   1004: arraylength
    //   1005: invokestatic 372	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1008: invokevirtual 363	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1011: aload 7
    //   1013: iconst_1
    //   1014: invokevirtual 375	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1017: aload 7
    //   1019: iconst_1
    //   1020: invokevirtual 378	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1023: aload 7
    //   1025: invokevirtual 382	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1028: astore 9
    //   1030: aload 9
    //   1032: aload 13
    //   1034: invokevirtual 388	java/io/OutputStream:write	([B)V
    //   1037: aload 9
    //   1039: invokevirtual 391	java/io/OutputStream:flush	()V
    //   1042: aload 7
    //   1044: invokevirtual 394	java/net/HttpURLConnection:getResponseCode	()I
    //   1047: istore_1
    //   1048: iload_1
    //   1049: sipush 200
    //   1052: if_icmpne +89 -> 1141
    //   1055: new 396	java/io/BufferedInputStream
    //   1058: dup
    //   1059: aload 7
    //   1061: invokevirtual 400	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1064: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1067: astore 8
    //   1069: aload 8
    //   1071: invokestatic 408	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   1074: astore 10
    //   1076: invokestatic 317	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1079: ifeq +31 -> 1110
    //   1082: ldc_w 304
    //   1085: iconst_2
    //   1086: new 79	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1093: ldc_w 410
    //   1096: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: aload 10
    //   1101: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1107: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1110: aload 9
    //   1112: ifnull +8 -> 1120
    //   1115: aload 9
    //   1117: invokevirtual 413	java/io/OutputStream:close	()V
    //   1120: aload 8
    //   1122: ifnull +8 -> 1130
    //   1125: aload 8
    //   1127: invokevirtual 414	java/io/BufferedInputStream:close	()V
    //   1130: aload 7
    //   1132: ifnull -322 -> 810
    //   1135: aload 7
    //   1137: invokevirtual 417	java/net/HttpURLConnection:disconnect	()V
    //   1140: return
    //   1141: aload 12
    //   1143: astore 8
    //   1145: invokestatic 317	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1148: ifeq -38 -> 1110
    //   1151: ldc_w 304
    //   1154: iconst_2
    //   1155: new 79	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1162: ldc_w 419
    //   1165: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: iload_1
    //   1169: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1172: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1178: aload 12
    //   1180: astore 8
    //   1182: goto -72 -> 1110
    //   1185: astore 11
    //   1187: aconst_null
    //   1188: astore 12
    //   1190: aload 7
    //   1192: astore 8
    //   1194: aload 9
    //   1196: astore 10
    //   1198: aload 12
    //   1200: astore 7
    //   1202: aload 11
    //   1204: astore 9
    //   1206: aload 9
    //   1208: invokevirtual 420	java/lang/Exception:printStackTrace	()V
    //   1211: aload 10
    //   1213: ifnull +8 -> 1221
    //   1216: aload 10
    //   1218: invokevirtual 413	java/io/OutputStream:close	()V
    //   1221: aload 7
    //   1223: ifnull +8 -> 1231
    //   1226: aload 7
    //   1228: invokevirtual 414	java/io/BufferedInputStream:close	()V
    //   1231: aload 8
    //   1233: ifnull -423 -> 810
    //   1236: aload 8
    //   1238: invokevirtual 417	java/net/HttpURLConnection:disconnect	()V
    //   1241: return
    //   1242: astore 9
    //   1244: aload 9
    //   1246: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   1249: goto -129 -> 1120
    //   1252: astore 8
    //   1254: aload 8
    //   1256: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   1259: goto -129 -> 1130
    //   1262: astore 9
    //   1264: aload 9
    //   1266: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   1269: goto -48 -> 1221
    //   1272: astore 7
    //   1274: aload 7
    //   1276: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   1279: goto -48 -> 1231
    //   1282: astore 7
    //   1284: aconst_null
    //   1285: astore 9
    //   1287: aload 9
    //   1289: ifnull +8 -> 1297
    //   1292: aload 9
    //   1294: invokevirtual 413	java/io/OutputStream:close	()V
    //   1297: aload 10
    //   1299: ifnull +8 -> 1307
    //   1302: aload 10
    //   1304: invokevirtual 414	java/io/BufferedInputStream:close	()V
    //   1307: aload 8
    //   1309: ifnull +8 -> 1317
    //   1312: aload 8
    //   1314: invokevirtual 417	java/net/HttpURLConnection:disconnect	()V
    //   1317: aload 7
    //   1319: athrow
    //   1320: astore 9
    //   1322: aload 9
    //   1324: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   1327: goto -30 -> 1297
    //   1330: astore 9
    //   1332: aload 9
    //   1334: invokevirtual 421	java/io/IOException:printStackTrace	()V
    //   1337: goto -30 -> 1307
    //   1340: astore 11
    //   1342: aconst_null
    //   1343: astore 9
    //   1345: aload 7
    //   1347: astore 8
    //   1349: aload 11
    //   1351: astore 7
    //   1353: goto -66 -> 1287
    //   1356: astore 11
    //   1358: aload 7
    //   1360: astore 8
    //   1362: aload 11
    //   1364: astore 7
    //   1366: goto -79 -> 1287
    //   1369: astore 11
    //   1371: aload 8
    //   1373: astore 10
    //   1375: aload 7
    //   1377: astore 8
    //   1379: aload 11
    //   1381: astore 7
    //   1383: goto -96 -> 1287
    //   1386: astore 11
    //   1388: aload 10
    //   1390: astore 9
    //   1392: aload 7
    //   1394: astore 10
    //   1396: aload 11
    //   1398: astore 7
    //   1400: goto -113 -> 1287
    //   1403: astore 9
    //   1405: aconst_null
    //   1406: astore 8
    //   1408: aconst_null
    //   1409: astore 7
    //   1411: aload 11
    //   1413: astore 10
    //   1415: goto -209 -> 1206
    //   1418: astore 9
    //   1420: aconst_null
    //   1421: astore 10
    //   1423: aload 7
    //   1425: astore 8
    //   1427: aload 10
    //   1429: astore 7
    //   1431: aload 11
    //   1433: astore 10
    //   1435: goto -229 -> 1206
    //   1438: astore 10
    //   1440: aload 7
    //   1442: astore 11
    //   1444: aload 10
    //   1446: astore 7
    //   1448: aload 9
    //   1450: astore 10
    //   1452: aload 7
    //   1454: astore 9
    //   1456: aload 8
    //   1458: astore 7
    //   1460: aload 11
    //   1462: astore 8
    //   1464: goto -258 -> 1206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1467	0	this	2
    //   73	1096	1	k	int
    //   215	13	2	m	int
    //   71	476	3	l1	long
    //   210	362	5	l2	long
    //   6	800	7	localObject1	Object
    //   837	3	7	localJSONException	org.json.JSONException
    //   845	382	7	localObject2	Object
    //   1272	3	7	localIOException1	java.io.IOException
    //   1282	64	7	localObject3	Object
    //   1351	108	7	localObject4	Object
    //   246	991	8	localObject5	Object
    //   1252	61	8	localIOException2	java.io.IOException
    //   1347	116	8	localObject6	Object
    //   138	1069	9	localObject7	Object
    //   1242	3	9	localIOException3	java.io.IOException
    //   1262	3	9	localIOException4	java.io.IOException
    //   1285	8	9	localObject8	Object
    //   1320	3	9	localIOException5	java.io.IOException
    //   1330	3	9	localIOException6	java.io.IOException
    //   1343	48	9	localObject9	Object
    //   1403	1	9	localException1	java.lang.Exception
    //   1418	31	9	localException2	java.lang.Exception
    //   1454	1	9	localObject10	Object
    //   13	1421	10	localObject11	Object
    //   1438	7	10	localException3	java.lang.Exception
    //   1450	1	10	localObject12	Object
    //   176	716	11	str1	String
    //   1185	18	11	localException4	java.lang.Exception
    //   1340	10	11	localObject13	Object
    //   1356	7	11	localObject14	Object
    //   1369	11	11	localObject15	Object
    //   1386	46	11	localObject16	Object
    //   1442	19	11	localObject17	Object
    //   205	994	12	str2	String
    //   237	796	13	localObject18	Object
    //   255	541	14	localJSONObject1	org.json.JSONObject
    //   264	521	15	localJSONObject2	org.json.JSONObject
    //   273	550	16	localJSONObject3	org.json.JSONObject
    //   282	448	17	localJSONArray	org.json.JSONArray
    //   291	393	18	localJSONObject4	org.json.JSONObject
    //   300	441	19	localJSONObject5	org.json.JSONObject
    //   309	367	20	localJSONObject6	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   248	530	837	org/json/JSONException
    //   530	801	837	org/json/JSONException
    //   822	834	837	org/json/JSONException
    //   1030	1048	1185	java/lang/Exception
    //   1055	1069	1185	java/lang/Exception
    //   1145	1178	1185	java/lang/Exception
    //   1115	1120	1242	java/io/IOException
    //   1125	1130	1252	java/io/IOException
    //   1216	1221	1262	java/io/IOException
    //   1226	1231	1272	java/io/IOException
    //   928	945	1282	finally
    //   1292	1297	1320	java/io/IOException
    //   1302	1307	1330	java/io/IOException
    //   945	1030	1340	finally
    //   1030	1048	1356	finally
    //   1055	1069	1356	finally
    //   1145	1178	1356	finally
    //   1069	1110	1369	finally
    //   1206	1211	1386	finally
    //   928	945	1403	java/lang/Exception
    //   945	1030	1418	java/lang/Exception
    //   1069	1110	1438	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicReportUtils.2
 * JD-Core Version:    0.7.0.1
 */