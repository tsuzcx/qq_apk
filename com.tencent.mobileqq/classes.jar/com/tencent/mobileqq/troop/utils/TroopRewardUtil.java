package com.tencent.mobileqq.troop.utils;

public class TroopRewardUtil
{
  /* Error */
  public static com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp a(android.os.Bundle paramBundle, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: ldc 23
    //   8: invokevirtual 29	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 14
    //   13: aload_0
    //   14: ldc 31
    //   16: invokevirtual 29	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_0
    //   22: ldc 33
    //   24: invokevirtual 29	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_0
    //   28: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +74 -> 105
    //   34: new 41	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   41: astore 9
    //   43: aload 9
    //   45: ldc 44
    //   47: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 9
    //   53: aload 14
    //   55: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 9
    //   61: ldc 50
    //   63: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 9
    //   69: aload 10
    //   71: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 9
    //   77: ldc 52
    //   79: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 9
    //   85: aload 10
    //   87: invokestatic 58	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   90: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc 63
    //   96: iconst_2
    //   97: aload 9
    //   99: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload 10
    //   107: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: istore 8
    //   112: aconst_null
    //   113: astore 11
    //   115: aconst_null
    //   116: astore 12
    //   118: aconst_null
    //   119: astore 9
    //   121: aconst_null
    //   122: astore 13
    //   124: iload 8
    //   126: ifne +750 -> 876
    //   129: aload 10
    //   131: invokestatic 81	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   134: ifne +6 -> 140
    //   137: goto +739 -> 876
    //   140: new 83	org/apache/http/client/methods/HttpPost
    //   143: dup
    //   144: ldc 85
    //   146: invokespecial 88	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   149: astore 15
    //   151: aload 15
    //   153: ldc 90
    //   155: ldc 92
    //   157: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload 15
    //   162: ldc 98
    //   164: ldc 100
    //   166: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 15
    //   171: ldc 102
    //   173: ldc 104
    //   175: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 15
    //   180: ldc 106
    //   182: ldc 108
    //   184: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 15
    //   189: ldc 110
    //   191: ldc 112
    //   193: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: new 41	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   203: astore 16
    //   205: aload 16
    //   207: ldc 114
    //   209: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 16
    //   215: aload_2
    //   216: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 16
    //   222: ldc 116
    //   224: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 16
    //   230: aload_1
    //   231: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 15
    //   237: ldc 118
    //   239: aload 16
    //   241: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: new 120	java/util/ArrayList
    //   250: dup
    //   251: invokespecial 121	java/util/ArrayList:<init>	()V
    //   254: astore_1
    //   255: aload_1
    //   256: new 123	org/apache/http/message/BasicNameValuePair
    //   259: dup
    //   260: ldc 23
    //   262: aload 14
    //   264: invokespecial 125	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: invokeinterface 131 2 0
    //   272: pop
    //   273: aload_1
    //   274: new 123	org/apache/http/message/BasicNameValuePair
    //   277: dup
    //   278: ldc 133
    //   280: aload 10
    //   282: invokestatic 58	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   285: invokestatic 139	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   288: invokespecial 125	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: invokeinterface 131 2 0
    //   296: pop
    //   297: aload_1
    //   298: new 123	org/apache/http/message/BasicNameValuePair
    //   301: dup
    //   302: ldc 141
    //   304: aload 10
    //   306: invokestatic 146	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)[B
    //   309: invokestatic 152	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   312: invokevirtual 155	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   315: invokespecial 125	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: invokeinterface 131 2 0
    //   323: pop
    //   324: aload_1
    //   325: new 123	org/apache/http/message/BasicNameValuePair
    //   328: dup
    //   329: ldc 157
    //   331: aload 10
    //   333: invokestatic 160	com/tencent/mobileqq/filemanager/util/FileManagerUtil:g	(Ljava/lang/String;)[B
    //   336: invokestatic 152	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   339: invokevirtual 155	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   342: invokespecial 125	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: invokeinterface 131 2 0
    //   350: pop
    //   351: new 41	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   358: astore 10
    //   360: aload 10
    //   362: ldc 162
    //   364: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 10
    //   370: aload_2
    //   371: invokestatic 167	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;)I
    //   374: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload_1
    //   379: new 123	org/apache/http/message/BasicNameValuePair
    //   382: dup
    //   383: ldc 172
    //   385: aload 10
    //   387: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokespecial 125	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: invokeinterface 131 2 0
    //   398: pop
    //   399: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +39 -> 441
    //   405: new 41	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   412: astore_2
    //   413: aload_2
    //   414: ldc 174
    //   416: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_2
    //   421: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   424: lload 6
    //   426: lsub
    //   427: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: ldc 63
    //   433: iconst_2
    //   434: aload_2
    //   435: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload_1
    //   442: new 123	org/apache/http/message/BasicNameValuePair
    //   445: dup
    //   446: ldc 176
    //   448: ldc 178
    //   450: invokespecial 125	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: invokeinterface 131 2 0
    //   458: pop
    //   459: aload_0
    //   460: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   463: ifne +20 -> 483
    //   466: aload_1
    //   467: new 123	org/apache/http/message/BasicNameValuePair
    //   470: dup
    //   471: ldc 33
    //   473: aload_0
    //   474: invokespecial 125	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: invokeinterface 131 2 0
    //   482: pop
    //   483: aload 15
    //   485: new 180	org/apache/http/client/entity/UrlEncodedFormEntity
    //   488: dup
    //   489: aload_1
    //   490: ldc 182
    //   492: invokespecial 185	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   495: invokevirtual 189	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   498: new 191	org/apache/http/impl/client/DefaultHttpClient
    //   501: dup
    //   502: invokespecial 192	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   505: aload 15
    //   507: invokevirtual 196	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   510: astore_0
    //   511: aload_0
    //   512: invokeinterface 202 1 0
    //   517: invokeinterface 208 1 0
    //   522: sipush 200
    //   525: if_icmpne +227 -> 752
    //   528: aload_0
    //   529: ldc 210
    //   531: invokeinterface 214 2 0
    //   536: astore_1
    //   537: aload_1
    //   538: arraylength
    //   539: istore 5
    //   541: iconst_0
    //   542: istore_3
    //   543: iconst_0
    //   544: istore 4
    //   546: iload_3
    //   547: iload 5
    //   549: if_icmpge +25 -> 574
    //   552: aload_1
    //   553: iload_3
    //   554: aaload
    //   555: invokeinterface 219 1 0
    //   560: ldc 221
    //   562: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   565: ifeq +360 -> 925
    //   568: iconst_1
    //   569: istore 4
    //   571: goto +354 -> 925
    //   574: aload_0
    //   575: invokeinterface 228 1 0
    //   580: astore_0
    //   581: iload 4
    //   583: ifeq +30 -> 613
    //   586: new 230	java/util/zip/GZIPInputStream
    //   589: dup
    //   590: aload_0
    //   591: invokeinterface 236 1 0
    //   596: invokespecial 239	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   599: astore_0
    //   600: aload_0
    //   601: astore 9
    //   603: aload_0
    //   604: astore_1
    //   605: aload_0
    //   606: invokestatic 244	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   609: astore_2
    //   610: goto +10 -> 620
    //   613: aload_0
    //   614: invokestatic 249	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   617: astore_2
    //   618: aconst_null
    //   619: astore_0
    //   620: aload_0
    //   621: astore 9
    //   623: aload_0
    //   624: astore_1
    //   625: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +58 -> 686
    //   631: aload_0
    //   632: astore 9
    //   634: aload_0
    //   635: astore_1
    //   636: new 41	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   643: astore 10
    //   645: aload_0
    //   646: astore 9
    //   648: aload_0
    //   649: astore_1
    //   650: aload 10
    //   652: ldc 251
    //   654: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload_0
    //   659: astore 9
    //   661: aload_0
    //   662: astore_1
    //   663: aload 10
    //   665: aload_2
    //   666: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload_0
    //   671: astore 9
    //   673: aload_0
    //   674: astore_1
    //   675: ldc 63
    //   677: iconst_2
    //   678: aload 10
    //   680: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: aload_0
    //   687: astore 9
    //   689: aload_0
    //   690: astore_1
    //   691: new 253	org/json/JSONObject
    //   694: dup
    //   695: aload_2
    //   696: invokespecial 254	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   699: astore 14
    //   701: aload_0
    //   702: astore 9
    //   704: aload 13
    //   706: astore_2
    //   707: aload_0
    //   708: astore 10
    //   710: aload_0
    //   711: astore_1
    //   712: aload 14
    //   714: ldc_w 256
    //   717: iconst_m1
    //   718: invokevirtual 260	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   721: ifne +37 -> 758
    //   724: aload_0
    //   725: astore 9
    //   727: aload_0
    //   728: astore_1
    //   729: new 262	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp
    //   732: dup
    //   733: aload 14
    //   735: invokespecial 265	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:<init>	(Lorg/json/JSONObject;)V
    //   738: astore_2
    //   739: aload_0
    //   740: astore 10
    //   742: goto +16 -> 758
    //   745: astore_2
    //   746: aload 9
    //   748: astore_0
    //   749: goto +38 -> 787
    //   752: aconst_null
    //   753: astore 10
    //   755: aload 13
    //   757: astore_2
    //   758: aload_2
    //   759: astore_1
    //   760: aload 10
    //   762: ifnull +58 -> 820
    //   765: aload 10
    //   767: astore_0
    //   768: aload_2
    //   769: astore_1
    //   770: aload_0
    //   771: invokevirtual 268	java/util/zip/GZIPInputStream:close	()V
    //   774: goto +46 -> 820
    //   777: astore_0
    //   778: aload 9
    //   780: astore_1
    //   781: goto +85 -> 866
    //   784: astore_2
    //   785: aconst_null
    //   786: astore_0
    //   787: aload_0
    //   788: astore_1
    //   789: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   792: ifeq +15 -> 807
    //   795: aload_0
    //   796: astore_1
    //   797: ldc 63
    //   799: iconst_2
    //   800: aload_2
    //   801: invokestatic 272	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   804: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: aload 12
    //   809: astore_1
    //   810: aload_0
    //   811: ifnull +9 -> 820
    //   814: aload 11
    //   816: astore_1
    //   817: goto -47 -> 770
    //   820: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   823: ifeq +40 -> 863
    //   826: new 41	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   833: astore_0
    //   834: aload_0
    //   835: ldc_w 274
    //   838: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload_0
    //   843: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   846: lload 6
    //   848: lsub
    //   849: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: ldc 63
    //   855: iconst_2
    //   856: aload_0
    //   857: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   863: aload_1
    //   864: areturn
    //   865: astore_0
    //   866: aload_1
    //   867: ifnull +7 -> 874
    //   870: aload_1
    //   871: invokevirtual 268	java/util/zip/GZIPInputStream:close	()V
    //   874: aload_0
    //   875: athrow
    //   876: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   879: ifeq +36 -> 915
    //   882: new 41	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   889: astore_0
    //   890: aload_0
    //   891: ldc_w 276
    //   894: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: pop
    //   898: aload_0
    //   899: aload 10
    //   901: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: ldc 63
    //   907: iconst_2
    //   908: aload_0
    //   909: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   915: aconst_null
    //   916: areturn
    //   917: astore_0
    //   918: goto -98 -> 820
    //   921: astore_1
    //   922: goto -48 -> 874
    //   925: iload_3
    //   926: iconst_1
    //   927: iadd
    //   928: istore_3
    //   929: goto -383 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	932	0	paramBundle	android.os.Bundle
    //   0	932	1	paramString1	java.lang.String
    //   0	932	2	paramString2	java.lang.String
    //   542	387	3	i	int
    //   544	38	4	j	int
    //   539	11	5	k	int
    //   3	844	6	l	long
    //   110	15	8	bool	boolean
    //   41	738	9	localObject1	Object
    //   19	881	10	localObject2	Object
    //   113	702	11	localObject3	Object
    //   116	692	12	localObject4	Object
    //   122	634	13	localObject5	Object
    //   11	723	14	localObject6	Object
    //   149	357	15	localHttpPost	org.apache.http.client.methods.HttpPost
    //   203	37	16	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   605	610	745	java/lang/Exception
    //   625	631	745	java/lang/Exception
    //   636	645	745	java/lang/Exception
    //   650	658	745	java/lang/Exception
    //   663	670	745	java/lang/Exception
    //   675	686	745	java/lang/Exception
    //   691	701	745	java/lang/Exception
    //   712	724	745	java/lang/Exception
    //   729	739	745	java/lang/Exception
    //   483	541	777	finally
    //   552	568	777	finally
    //   574	581	777	finally
    //   586	600	777	finally
    //   613	618	777	finally
    //   483	541	784	java/lang/Exception
    //   552	568	784	java/lang/Exception
    //   574	581	784	java/lang/Exception
    //   586	600	784	java/lang/Exception
    //   613	618	784	java/lang/Exception
    //   605	610	865	finally
    //   625	631	865	finally
    //   636	645	865	finally
    //   650	658	865	finally
    //   663	670	865	finally
    //   675	686	865	finally
    //   691	701	865	finally
    //   712	724	865	finally
    //   729	739	865	finally
    //   789	795	865	finally
    //   797	807	865	finally
    //   770	774	917	java/io/IOException
    //   870	874	921	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardUtil
 * JD-Core Version:    0.7.0.1
 */