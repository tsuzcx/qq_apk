package com.tencent.mobileqq.troop.utils;

public class TroopRewardUtil
{
  /* Error */
  public static com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp a(android.os.Bundle paramBundle, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   9: lstore 6
    //   11: aload_0
    //   12: ldc 23
    //   14: invokevirtual 29	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore 9
    //   19: aload_0
    //   20: ldc 31
    //   22: invokevirtual 29	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 10
    //   27: aload_0
    //   28: ldc 33
    //   30: invokevirtual 29	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_0
    //   34: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +52 -> 89
    //   40: ldc 41
    //   42: iconst_2
    //   43: new 43	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   50: ldc 46
    //   52: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 9
    //   57: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 52
    //   62: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload 10
    //   67: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 54
    //   72: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 10
    //   77: invokestatic 59	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   80: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload 10
    //   91: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +11 -> 105
    //   97: aload 10
    //   99: invokestatic 79	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   102: ifne +39 -> 141
    //   105: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +29 -> 137
    //   111: ldc 41
    //   113: iconst_2
    //   114: new 43	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   121: ldc 81
    //   123: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 10
    //   128: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_1
    //   140: areturn
    //   141: new 86	org/apache/http/client/methods/HttpPost
    //   144: dup
    //   145: ldc 88
    //   147: invokespecial 91	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   150: astore 11
    //   152: aload 11
    //   154: ldc 93
    //   156: ldc 95
    //   158: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 11
    //   163: ldc 101
    //   165: ldc 103
    //   167: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload 11
    //   172: ldc 105
    //   174: ldc 107
    //   176: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 11
    //   181: ldc 109
    //   183: ldc 111
    //   185: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 11
    //   190: ldc 113
    //   192: ldc 115
    //   194: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 11
    //   199: ldc 117
    //   201: new 43	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   208: ldc 119
    //   210: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 121
    //   219: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: new 123	java/util/ArrayList
    //   235: dup
    //   236: invokespecial 124	java/util/ArrayList:<init>	()V
    //   239: astore_1
    //   240: aload_1
    //   241: new 126	org/apache/http/message/BasicNameValuePair
    //   244: dup
    //   245: ldc 23
    //   247: aload 9
    //   249: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: invokeinterface 134 2 0
    //   257: pop
    //   258: aload_1
    //   259: new 126	org/apache/http/message/BasicNameValuePair
    //   262: dup
    //   263: ldc 136
    //   265: aload 10
    //   267: invokestatic 59	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   270: invokestatic 142	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   273: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: invokeinterface 134 2 0
    //   281: pop
    //   282: aload_1
    //   283: new 126	org/apache/http/message/BasicNameValuePair
    //   286: dup
    //   287: ldc 144
    //   289: aload 10
    //   291: invokestatic 149	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   294: invokestatic 155	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   297: invokevirtual 158	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   300: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: invokeinterface 134 2 0
    //   308: pop
    //   309: aload_1
    //   310: new 126	org/apache/http/message/BasicNameValuePair
    //   313: dup
    //   314: ldc 160
    //   316: aload 10
    //   318: invokestatic 162	com/tencent/mobileqq/filemanager/util/FileManagerUtil:e	(Ljava/lang/String;)[B
    //   321: invokestatic 155	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   324: invokevirtual 158	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   327: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: invokeinterface 134 2 0
    //   335: pop
    //   336: aload_1
    //   337: new 126	org/apache/http/message/BasicNameValuePair
    //   340: dup
    //   341: ldc 164
    //   343: new 43	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   350: ldc 166
    //   352: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokestatic 172	com/tencent/mobileqq/troop/utils/TroopUtils:b	(Ljava/lang/String;)I
    //   359: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: invokeinterface 134 2 0
    //   373: pop
    //   374: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +33 -> 410
    //   380: ldc 41
    //   382: iconst_2
    //   383: new 43	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   390: ldc 177
    //   392: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   398: lload 6
    //   400: lsub
    //   401: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   404: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: aload_1
    //   411: new 126	org/apache/http/message/BasicNameValuePair
    //   414: dup
    //   415: ldc 179
    //   417: ldc 181
    //   419: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: invokeinterface 134 2 0
    //   427: pop
    //   428: aload_0
    //   429: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   432: ifne +20 -> 452
    //   435: aload_1
    //   436: new 126	org/apache/http/message/BasicNameValuePair
    //   439: dup
    //   440: ldc 33
    //   442: aload_0
    //   443: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: invokeinterface 134 2 0
    //   451: pop
    //   452: aload 11
    //   454: new 183	org/apache/http/client/entity/UrlEncodedFormEntity
    //   457: dup
    //   458: aload_1
    //   459: ldc 185
    //   461: invokespecial 188	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   464: invokevirtual 192	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   467: new 194	org/apache/http/impl/client/DefaultHttpClient
    //   470: dup
    //   471: invokespecial 195	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   474: aload 11
    //   476: invokevirtual 199	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   479: astore_0
    //   480: aload_0
    //   481: invokeinterface 205 1 0
    //   486: invokeinterface 211 1 0
    //   491: sipush 200
    //   494: if_icmpne +319 -> 813
    //   497: aload_0
    //   498: ldc 213
    //   500: invokeinterface 217 2 0
    //   505: astore_1
    //   506: aload_1
    //   507: arraylength
    //   508: istore 5
    //   510: iconst_0
    //   511: istore_3
    //   512: iload_3
    //   513: iload 5
    //   515: if_icmpge +25 -> 540
    //   518: aload_1
    //   519: iload_3
    //   520: aaload
    //   521: invokeinterface 222 1 0
    //   526: ldc 224
    //   528: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   531: ifeq +289 -> 820
    //   534: iconst_1
    //   535: istore 4
    //   537: goto +283 -> 820
    //   540: aload_0
    //   541: invokeinterface 231 1 0
    //   546: astore_0
    //   547: iload 4
    //   549: ifeq +170 -> 719
    //   552: new 233	java/util/zip/GZIPInputStream
    //   555: dup
    //   556: aload_0
    //   557: invokeinterface 239 1 0
    //   562: invokespecial 242	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   565: astore_0
    //   566: aload_0
    //   567: astore_1
    //   568: aload_0
    //   569: astore_2
    //   570: aload_0
    //   571: invokestatic 247	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   574: astore 8
    //   576: aload_0
    //   577: astore_1
    //   578: aload_0
    //   579: astore_2
    //   580: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +33 -> 616
    //   586: aload_0
    //   587: astore_1
    //   588: aload_0
    //   589: astore_2
    //   590: ldc 41
    //   592: iconst_2
    //   593: new 43	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   600: ldc 249
    //   602: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 8
    //   607: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload_0
    //   617: astore_1
    //   618: aload_0
    //   619: astore_2
    //   620: new 251	org/json/JSONObject
    //   623: dup
    //   624: aload 8
    //   626: invokespecial 252	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   629: astore 8
    //   631: aload_0
    //   632: astore_1
    //   633: aload_0
    //   634: astore_2
    //   635: aload 8
    //   637: ldc 254
    //   639: iconst_m1
    //   640: invokevirtual 258	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   643: ifne +163 -> 806
    //   646: aload_0
    //   647: astore_1
    //   648: aload_0
    //   649: astore_2
    //   650: new 260	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp
    //   653: dup
    //   654: aload 8
    //   656: invokespecial 263	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:<init>	(Lorg/json/JSONObject;)V
    //   659: astore 8
    //   661: aload_0
    //   662: astore_2
    //   663: aload 8
    //   665: astore_1
    //   666: aload_1
    //   667: astore_0
    //   668: aload_2
    //   669: ifnull +9 -> 678
    //   672: aload_2
    //   673: invokevirtual 266	java/util/zip/GZIPInputStream:close	()V
    //   676: aload_1
    //   677: astore_0
    //   678: aload_0
    //   679: astore_1
    //   680: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq -544 -> 139
    //   686: ldc 41
    //   688: iconst_2
    //   689: new 43	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   696: ldc_w 268
    //   699: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   705: lload 6
    //   707: lsub
    //   708: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   711: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   717: aload_0
    //   718: areturn
    //   719: aload_0
    //   720: invokestatic 273	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   723: astore_0
    //   724: aload_0
    //   725: astore 8
    //   727: aconst_null
    //   728: astore_0
    //   729: goto -153 -> 576
    //   732: astore_0
    //   733: aconst_null
    //   734: astore_2
    //   735: aload_2
    //   736: astore_1
    //   737: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   740: ifeq +15 -> 755
    //   743: aload_2
    //   744: astore_1
    //   745: ldc 41
    //   747: iconst_2
    //   748: aload_0
    //   749: invokestatic 277	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   752: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   755: aload_2
    //   756: ifnull +7 -> 763
    //   759: aload_2
    //   760: invokevirtual 266	java/util/zip/GZIPInputStream:close	()V
    //   763: aconst_null
    //   764: astore_0
    //   765: goto -87 -> 678
    //   768: astore_0
    //   769: aconst_null
    //   770: astore_0
    //   771: goto -93 -> 678
    //   774: astore_0
    //   775: aload 8
    //   777: astore_1
    //   778: aload_1
    //   779: ifnull +7 -> 786
    //   782: aload_1
    //   783: invokevirtual 266	java/util/zip/GZIPInputStream:close	()V
    //   786: aload_0
    //   787: athrow
    //   788: astore_0
    //   789: aload_1
    //   790: astore_0
    //   791: goto -113 -> 678
    //   794: astore_1
    //   795: goto -9 -> 786
    //   798: astore_0
    //   799: goto -21 -> 778
    //   802: astore_0
    //   803: goto -68 -> 735
    //   806: aconst_null
    //   807: astore_1
    //   808: aload_0
    //   809: astore_2
    //   810: goto -144 -> 666
    //   813: aconst_null
    //   814: astore_2
    //   815: aconst_null
    //   816: astore_1
    //   817: goto -151 -> 666
    //   820: iload_3
    //   821: iconst_1
    //   822: iadd
    //   823: istore_3
    //   824: goto -312 -> 512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	827	0	paramBundle	android.os.Bundle
    //   0	827	1	paramString1	java.lang.String
    //   0	827	2	paramString2	java.lang.String
    //   511	313	3	i	int
    //   1	547	4	j	int
    //   508	8	5	k	int
    //   9	697	6	l	long
    //   4	772	8	localObject	Object
    //   17	231	9	str1	java.lang.String
    //   25	292	10	str2	java.lang.String
    //   150	325	11	localHttpPost	org.apache.http.client.methods.HttpPost
    // Exception table:
    //   from	to	target	type
    //   452	510	732	java/lang/Exception
    //   518	534	732	java/lang/Exception
    //   540	547	732	java/lang/Exception
    //   552	566	732	java/lang/Exception
    //   719	724	732	java/lang/Exception
    //   759	763	768	java/io/IOException
    //   452	510	774	finally
    //   518	534	774	finally
    //   540	547	774	finally
    //   552	566	774	finally
    //   719	724	774	finally
    //   672	676	788	java/io/IOException
    //   782	786	794	java/io/IOException
    //   570	576	798	finally
    //   580	586	798	finally
    //   590	616	798	finally
    //   620	631	798	finally
    //   635	646	798	finally
    //   650	661	798	finally
    //   737	743	798	finally
    //   745	755	798	finally
    //   570	576	802	java/lang/Exception
    //   580	586	802	java/lang/Exception
    //   590	616	802	java/lang/Exception
    //   620	631	802	java/lang/Exception
    //   635	646	802	java/lang/Exception
    //   650	661	802	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardUtil
 * JD-Core Version:    0.7.0.1
 */