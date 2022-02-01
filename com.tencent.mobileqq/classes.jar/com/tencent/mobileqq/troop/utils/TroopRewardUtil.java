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
    //   126: ifne +749 -> 875
    //   129: aload 10
    //   131: invokestatic 81	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   134: ifne +6 -> 140
    //   137: goto +738 -> 875
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
    //   306: invokestatic 146	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
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
    //   333: invokestatic 159	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)[B
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
    //   362: ldc 161
    //   364: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 10
    //   370: aload_2
    //   371: invokestatic 166	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;)I
    //   374: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload_1
    //   379: new 123	org/apache/http/message/BasicNameValuePair
    //   382: dup
    //   383: ldc 171
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
    //   414: ldc 173
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
    //   446: ldc 175
    //   448: ldc 177
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
    //   485: new 179	org/apache/http/client/entity/UrlEncodedFormEntity
    //   488: dup
    //   489: aload_1
    //   490: ldc 181
    //   492: invokespecial 184	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   495: invokevirtual 188	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   498: new 190	org/apache/http/impl/client/DefaultHttpClient
    //   501: dup
    //   502: invokespecial 191	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   505: aload 15
    //   507: invokevirtual 195	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   510: astore_0
    //   511: aload_0
    //   512: invokeinterface 201 1 0
    //   517: invokeinterface 207 1 0
    //   522: sipush 200
    //   525: if_icmpne +226 -> 751
    //   528: aload_0
    //   529: ldc 209
    //   531: invokeinterface 213 2 0
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
    //   555: invokeinterface 218 1 0
    //   560: ldc 220
    //   562: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   565: ifeq +359 -> 924
    //   568: iconst_1
    //   569: istore 4
    //   571: goto +353 -> 924
    //   574: aload_0
    //   575: invokeinterface 227 1 0
    //   580: astore_0
    //   581: iload 4
    //   583: ifeq +30 -> 613
    //   586: new 229	java/util/zip/GZIPInputStream
    //   589: dup
    //   590: aload_0
    //   591: invokeinterface 235 1 0
    //   596: invokespecial 238	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   599: astore_0
    //   600: aload_0
    //   601: astore 9
    //   603: aload_0
    //   604: astore_1
    //   605: aload_0
    //   606: invokestatic 243	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   609: astore_2
    //   610: goto +10 -> 620
    //   613: aload_0
    //   614: invokestatic 248	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
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
    //   652: ldc 250
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
    //   691: new 252	org/json/JSONObject
    //   694: dup
    //   695: aload_2
    //   696: invokespecial 253	org/json/JSONObject:<init>	(Ljava/lang/String;)V
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
    //   714: ldc 255
    //   716: iconst_m1
    //   717: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   720: ifne +37 -> 757
    //   723: aload_0
    //   724: astore 9
    //   726: aload_0
    //   727: astore_1
    //   728: new 261	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp
    //   731: dup
    //   732: aload 14
    //   734: invokespecial 264	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:<init>	(Lorg/json/JSONObject;)V
    //   737: astore_2
    //   738: aload_0
    //   739: astore 10
    //   741: goto +16 -> 757
    //   744: astore_2
    //   745: aload 9
    //   747: astore_0
    //   748: goto +38 -> 786
    //   751: aconst_null
    //   752: astore 10
    //   754: aload 13
    //   756: astore_2
    //   757: aload_2
    //   758: astore_1
    //   759: aload 10
    //   761: ifnull +58 -> 819
    //   764: aload 10
    //   766: astore_0
    //   767: aload_2
    //   768: astore_1
    //   769: aload_0
    //   770: invokevirtual 267	java/util/zip/GZIPInputStream:close	()V
    //   773: goto +46 -> 819
    //   776: astore_0
    //   777: aload 9
    //   779: astore_1
    //   780: goto +85 -> 865
    //   783: astore_2
    //   784: aconst_null
    //   785: astore_0
    //   786: aload_0
    //   787: astore_1
    //   788: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +15 -> 806
    //   794: aload_0
    //   795: astore_1
    //   796: ldc 63
    //   798: iconst_2
    //   799: aload_2
    //   800: invokestatic 271	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   803: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: aload 12
    //   808: astore_1
    //   809: aload_0
    //   810: ifnull +9 -> 819
    //   813: aload 11
    //   815: astore_1
    //   816: goto -47 -> 769
    //   819: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   822: ifeq +40 -> 862
    //   825: new 41	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   832: astore_0
    //   833: aload_0
    //   834: ldc_w 273
    //   837: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload_0
    //   842: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   845: lload 6
    //   847: lsub
    //   848: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: ldc 63
    //   854: iconst_2
    //   855: aload_0
    //   856: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   862: aload_1
    //   863: areturn
    //   864: astore_0
    //   865: aload_1
    //   866: ifnull +7 -> 873
    //   869: aload_1
    //   870: invokevirtual 267	java/util/zip/GZIPInputStream:close	()V
    //   873: aload_0
    //   874: athrow
    //   875: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq +36 -> 914
    //   881: new 41	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   888: astore_0
    //   889: aload_0
    //   890: ldc_w 275
    //   893: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload_0
    //   898: aload 10
    //   900: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: ldc 63
    //   906: iconst_2
    //   907: aload_0
    //   908: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: aconst_null
    //   915: areturn
    //   916: astore_0
    //   917: goto -98 -> 819
    //   920: astore_1
    //   921: goto -48 -> 873
    //   924: iload_3
    //   925: iconst_1
    //   926: iadd
    //   927: istore_3
    //   928: goto -382 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	931	0	paramBundle	android.os.Bundle
    //   0	931	1	paramString1	java.lang.String
    //   0	931	2	paramString2	java.lang.String
    //   542	386	3	i	int
    //   544	38	4	j	int
    //   539	11	5	k	int
    //   3	843	6	l	long
    //   110	15	8	bool	boolean
    //   41	737	9	localObject1	Object
    //   19	880	10	localObject2	Object
    //   113	701	11	localObject3	Object
    //   116	691	12	localObject4	Object
    //   122	633	13	localObject5	Object
    //   11	722	14	localObject6	Object
    //   149	357	15	localHttpPost	org.apache.http.client.methods.HttpPost
    //   203	37	16	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   605	610	744	java/lang/Exception
    //   625	631	744	java/lang/Exception
    //   636	645	744	java/lang/Exception
    //   650	658	744	java/lang/Exception
    //   663	670	744	java/lang/Exception
    //   675	686	744	java/lang/Exception
    //   691	701	744	java/lang/Exception
    //   712	723	744	java/lang/Exception
    //   728	738	744	java/lang/Exception
    //   483	541	776	finally
    //   552	568	776	finally
    //   574	581	776	finally
    //   586	600	776	finally
    //   613	618	776	finally
    //   483	541	783	java/lang/Exception
    //   552	568	783	java/lang/Exception
    //   574	581	783	java/lang/Exception
    //   586	600	783	java/lang/Exception
    //   613	618	783	java/lang/Exception
    //   605	610	864	finally
    //   625	631	864	finally
    //   636	645	864	finally
    //   650	658	864	finally
    //   663	670	864	finally
    //   675	686	864	finally
    //   691	701	864	finally
    //   712	723	864	finally
    //   728	738	864	finally
    //   788	794	864	finally
    //   796	806	864	finally
    //   769	773	916	java/io/IOException
    //   869	873	920	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardUtil
 * JD-Core Version:    0.7.0.1
 */