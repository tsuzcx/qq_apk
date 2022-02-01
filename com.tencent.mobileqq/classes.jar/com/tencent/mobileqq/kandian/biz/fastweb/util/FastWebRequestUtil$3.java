package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.biz.fastweb.ResponseCallback;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;

final class FastWebRequestUtil$3
  implements Runnable
{
  FastWebRequestUtil$3(String paramString1, String paramString2, int paramInt, AuthorData paramAuthorData, ResponseCallback paramResponseCallback) {}
  
  /* Error */
  @androidx.annotation.RequiresApi(api=19)
  public void run()
  {
    // Byte code:
    //   0: new 39	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 40	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 45	com/tencent/mobileqq/kandian/biz/common/ReadInJoyUtils:b	()Lmqq/app/AppRuntime;
    //   12: checkcast 47	com/tencent/mobileqq/app/QQAppInterface
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   20: astore 4
    //   22: aload_3
    //   23: iconst_2
    //   24: invokevirtual 55	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   27: checkcast 57	mqq/manager/TicketManager
    //   30: aload 4
    //   32: invokeinterface 61 2 0
    //   37: astore 7
    //   39: iconst_1
    //   40: istore_2
    //   41: new 63	java/util/HashMap
    //   44: dup
    //   45: invokespecial 64	java/util/HashMap:<init>	()V
    //   48: astore 6
    //   50: aload 4
    //   52: astore_3
    //   53: aload 4
    //   55: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +6 -> 64
    //   61: ldc 72
    //   63: astore_3
    //   64: aload 6
    //   66: ldc 74
    //   68: aload_3
    //   69: invokeinterface 80 3 0
    //   74: pop
    //   75: aload 6
    //   77: ldc 82
    //   79: aload_0
    //   80: getfield 19	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:a	Ljava/lang/String;
    //   83: invokeinterface 80 3 0
    //   88: pop
    //   89: aload 6
    //   91: ldc 84
    //   93: aload_0
    //   94: getfield 21	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:b	Ljava/lang/String;
    //   97: invokeinterface 80 3 0
    //   102: pop
    //   103: aload 6
    //   105: ldc 86
    //   107: ldc 88
    //   109: invokeinterface 80 3 0
    //   114: pop
    //   115: aload 6
    //   117: ldc 90
    //   119: ldc 92
    //   121: invokeinterface 80 3 0
    //   126: pop
    //   127: aload 7
    //   129: ifnonnull +9 -> 138
    //   132: ldc 94
    //   134: astore_3
    //   135: goto +9 -> 144
    //   138: aload 7
    //   140: invokestatic 98	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore_3
    //   144: aload 6
    //   146: ldc 100
    //   148: aload_3
    //   149: invokeinterface 80 3 0
    //   154: pop
    //   155: new 102	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   162: astore_3
    //   163: aload_3
    //   164: invokestatic 109	com/tencent/biz/common/util/HttpUtil:getNetWorkType	()I
    //   167: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_3
    //   172: ldc 94
    //   174: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 6
    //   180: ldc 118
    //   182: aload_3
    //   183: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokeinterface 80 3 0
    //   191: pop
    //   192: new 123	org/json/JSONObject
    //   195: dup
    //   196: invokespecial 124	org/json/JSONObject:<init>	()V
    //   199: astore_3
    //   200: aload_3
    //   201: ldc 126
    //   203: ldc 88
    //   205: ldc 128
    //   207: ldc 94
    //   209: invokevirtual 134	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   212: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload_3
    //   217: ldc 139
    //   219: aload_0
    //   220: getfield 23	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:c	I
    //   223: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload_3
    //   228: ldc 144
    //   230: invokestatic 149	com/tencent/open/business/base/MobileInfoUtil:getImei	()Ljava/lang/String;
    //   233: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   236: pop
    //   237: aload 6
    //   239: ldc 151
    //   241: aload_3
    //   242: invokevirtual 152	org/json/JSONObject:toString	()Ljava/lang/String;
    //   245: invokestatic 157	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   248: invokeinterface 80 3 0
    //   253: pop
    //   254: aload 6
    //   256: ldc 159
    //   258: invokestatic 163	com/tencent/mobileqq/kandian/repo/common/RIJUGJsonUtils:a	()Ljava/lang/String;
    //   261: invokestatic 157	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   264: invokeinterface 80 3 0
    //   269: pop
    //   270: new 102	java/lang/StringBuilder
    //   273: dup
    //   274: getstatic 169	com/tencent/mobileqq/kandian/biz/detail/web/api/impl/FastWebRequestUtilSingleton:INSTANCE	Lcom/tencent/mobileqq/kandian/biz/detail/web/api/impl/FastWebRequestUtilSingleton;
    //   277: invokevirtual 172	com/tencent/mobileqq/kandian/biz/detail/web/api/impl/FastWebRequestUtilSingleton:getWebRecLink	()Ljava/lang/String;
    //   280: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: astore_3
    //   284: aload 6
    //   286: invokeinterface 179 1 0
    //   291: invokeinterface 185 1 0
    //   296: astore 4
    //   298: aload 4
    //   300: invokeinterface 191 1 0
    //   305: ifeq +85 -> 390
    //   308: aload 4
    //   310: invokeinterface 195 1 0
    //   315: checkcast 197	java/util/Map$Entry
    //   318: astore 6
    //   320: new 102	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   327: astore 7
    //   329: aload 7
    //   331: ldc 199
    //   333: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 7
    //   339: aload 6
    //   341: invokeinterface 202 1 0
    //   346: checkcast 130	java/lang/String
    //   349: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 7
    //   355: ldc 204
    //   357: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 7
    //   363: aload 6
    //   365: invokeinterface 207 1 0
    //   370: checkcast 130	java/lang/String
    //   373: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_3
    //   378: aload 7
    //   380: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: goto -89 -> 298
    //   390: new 102	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   397: astore 4
    //   399: aload 4
    //   401: ldc 94
    //   403: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 4
    //   409: getstatic 212	com/tencent/mobileqq/kandian/base/utils/RIJLogUtil:a	Lcom/tencent/mobileqq/kandian/base/utils/RIJLogUtil;
    //   412: aload_3
    //   413: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokevirtual 213	com/tencent/mobileqq/kandian/base/utils/RIJLogUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: ldc 215
    //   425: iconst_2
    //   426: aload 4
    //   428: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: new 222	android/os/Bundle
    //   437: dup
    //   438: invokespecial 223	android/os/Bundle:<init>	()V
    //   441: astore 4
    //   443: aload 4
    //   445: invokestatic 227	com/tencent/biz/common/util/HttpUtil:addCookie	(Landroid/os/Bundle;)V
    //   448: aload_3
    //   449: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: iconst_0
    //   453: aconst_null
    //   454: aload 4
    //   456: invokestatic 230	com/tencent/mobileqq/kandian/biz/common/ReadInJoyUtils:a	(Ljava/lang/String;ILandroid/os/Bundle;Landroid/os/Bundle;)[B
    //   459: astore_3
    //   460: aload_3
    //   461: ifnull +15 -> 476
    //   464: new 130	java/lang/String
    //   467: dup
    //   468: aload_3
    //   469: invokespecial 233	java/lang/String:<init>	([B)V
    //   472: astore_3
    //   473: goto +6 -> 479
    //   476: ldc 94
    //   478: astore_3
    //   479: aload_3
    //   480: invokestatic 238	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil:b	(Ljava/lang/String;)I
    //   483: istore_1
    //   484: aload 5
    //   486: aload_0
    //   487: getfield 21	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:b	Ljava/lang/String;
    //   490: bipush 6
    //   492: aload_3
    //   493: iload_1
    //   494: invokestatic 241	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil:a	(Ljava/lang/String;ILjava/lang/String;I)Ljava/util/List;
    //   497: invokeinterface 247 2 0
    //   502: pop
    //   503: aload 5
    //   505: iload_1
    //   506: aload_0
    //   507: getfield 25	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:d	Lcom/tencent/mobileqq/kandian/repo/fastweb/entity/AuthorData;
    //   510: invokestatic 252	com/tencent/mobileqq/kandian/biz/fastweb/util/ItemDatasListUtils:a	(Ljava/util/List;ILcom/tencent/mobileqq/kandian/repo/fastweb/entity/AuthorData;)V
    //   513: new 102	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   520: astore 4
    //   522: aload 4
    //   524: ldc 254
    //   526: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 4
    //   532: aload 5
    //   534: invokeinterface 257 1 0
    //   539: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 4
    //   545: ldc_w 259
    //   548: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload 4
    //   554: aload_3
    //   555: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: ldc_w 261
    //   562: iconst_1
    //   563: aload 4
    //   565: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: goto +66 -> 637
    //   574: astore 4
    //   576: goto +15 -> 591
    //   579: astore 4
    //   581: goto +8 -> 589
    //   584: astore 4
    //   586: ldc 94
    //   588: astore_3
    //   589: iconst_0
    //   590: istore_1
    //   591: new 102	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   598: astore 6
    //   600: aload 6
    //   602: ldc 94
    //   604: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 6
    //   610: aload_3
    //   611: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: ldc 215
    //   617: iconst_2
    //   618: aload 4
    //   620: iconst_1
    //   621: anewarray 4	java/lang/Object
    //   624: dup
    //   625: iconst_0
    //   626: aload 6
    //   628: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: aastore
    //   632: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   635: iconst_0
    //   636: istore_2
    //   637: aload_0
    //   638: getfield 27	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:e	Lcom/tencent/mobileqq/kandian/biz/fastweb/ResponseCallback;
    //   641: astore 4
    //   643: aload 4
    //   645: ifnull +18 -> 663
    //   648: aload 4
    //   650: iload_2
    //   651: aload 5
    //   653: aload_3
    //   654: invokestatic 267	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil:a	(Ljava/lang/String;)Z
    //   657: iload_1
    //   658: invokeinterface 272 5 0
    //   663: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	3
    //   483	175	1	i	int
    //   40	611	2	bool	boolean
    //   15	639	3	localObject1	Object
    //   20	544	4	localObject2	Object
    //   574	1	4	localException1	java.lang.Exception
    //   579	1	4	localException2	java.lang.Exception
    //   584	35	4	localException3	java.lang.Exception
    //   641	8	4	localResponseCallback	ResponseCallback
    //   7	645	5	localArrayList	java.util.ArrayList
    //   48	579	6	localObject3	Object
    //   37	342	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   484	571	574	java/lang/Exception
    //   479	484	579	java/lang/Exception
    //   41	50	584	java/lang/Exception
    //   53	61	584	java/lang/Exception
    //   64	127	584	java/lang/Exception
    //   138	144	584	java/lang/Exception
    //   144	298	584	java/lang/Exception
    //   298	387	584	java/lang/Exception
    //   390	460	584	java/lang/Exception
    //   464	473	584	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil.3
 * JD-Core Version:    0.7.0.1
 */