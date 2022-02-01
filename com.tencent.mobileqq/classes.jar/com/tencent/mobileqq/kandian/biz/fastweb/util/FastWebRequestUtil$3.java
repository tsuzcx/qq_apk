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
    //   0: new 36	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 37	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 42	com/tencent/mobileqq/kandian/biz/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   12: checkcast 44	com/tencent/mobileqq/app/QQAppInterface
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   20: astore 4
    //   22: aload_3
    //   23: iconst_2
    //   24: invokevirtual 52	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   27: checkcast 54	mqq/manager/TicketManager
    //   30: aload 4
    //   32: invokeinterface 58 2 0
    //   37: astore 7
    //   39: iconst_1
    //   40: istore_2
    //   41: new 60	java/util/HashMap
    //   44: dup
    //   45: invokespecial 61	java/util/HashMap:<init>	()V
    //   48: astore 6
    //   50: aload 4
    //   52: astore_3
    //   53: aload 4
    //   55: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +6 -> 64
    //   61: ldc 69
    //   63: astore_3
    //   64: aload 6
    //   66: ldc 71
    //   68: aload_3
    //   69: invokeinterface 77 3 0
    //   74: pop
    //   75: aload 6
    //   77: ldc 79
    //   79: aload_0
    //   80: getfield 16	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: invokeinterface 77 3 0
    //   88: pop
    //   89: aload 6
    //   91: ldc 81
    //   93: aload_0
    //   94: getfield 18	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:b	Ljava/lang/String;
    //   97: invokeinterface 77 3 0
    //   102: pop
    //   103: aload 6
    //   105: ldc 83
    //   107: ldc 85
    //   109: invokeinterface 77 3 0
    //   114: pop
    //   115: aload 6
    //   117: ldc 87
    //   119: ldc 89
    //   121: invokeinterface 77 3 0
    //   126: pop
    //   127: aload 7
    //   129: ifnonnull +9 -> 138
    //   132: ldc 91
    //   134: astore_3
    //   135: goto +9 -> 144
    //   138: aload 7
    //   140: invokestatic 95	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore_3
    //   144: aload 6
    //   146: ldc 97
    //   148: aload_3
    //   149: invokeinterface 77 3 0
    //   154: pop
    //   155: new 99	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   162: astore_3
    //   163: aload_3
    //   164: invokestatic 106	com/tencent/biz/common/util/HttpUtil:getNetWorkType	()I
    //   167: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_3
    //   172: ldc 91
    //   174: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 6
    //   180: ldc 115
    //   182: aload_3
    //   183: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokeinterface 77 3 0
    //   191: pop
    //   192: new 120	org/json/JSONObject
    //   195: dup
    //   196: invokespecial 121	org/json/JSONObject:<init>	()V
    //   199: astore_3
    //   200: aload_3
    //   201: ldc 123
    //   203: ldc 85
    //   205: ldc 125
    //   207: ldc 91
    //   209: invokevirtual 131	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   212: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload_3
    //   217: ldc 136
    //   219: aload_0
    //   220: getfield 20	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:jdField_a_of_type_Int	I
    //   223: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload_3
    //   228: ldc 141
    //   230: invokestatic 146	com/tencent/open/business/base/MobileInfoUtil:getImei	()Ljava/lang/String;
    //   233: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   236: pop
    //   237: aload 6
    //   239: ldc 148
    //   241: aload_3
    //   242: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   245: invokestatic 154	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   248: invokeinterface 77 3 0
    //   253: pop
    //   254: aload 6
    //   256: ldc 156
    //   258: invokestatic 160	com/tencent/mobileqq/kandian/repo/common/RIJUGJsonUtils:a	()Ljava/lang/String;
    //   261: invokestatic 154	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   264: invokeinterface 77 3 0
    //   269: pop
    //   270: new 99	java/lang/StringBuilder
    //   273: dup
    //   274: ldc 162
    //   276: invokestatic 167	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   279: checkcast 162	com/tencent/mobileqq/kandian/biz/detail/web/api/IFastWebRequestUtil
    //   282: invokeinterface 170 1 0
    //   287: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: astore_3
    //   291: aload 6
    //   293: invokeinterface 177 1 0
    //   298: invokeinterface 183 1 0
    //   303: astore 4
    //   305: aload 4
    //   307: invokeinterface 189 1 0
    //   312: ifeq +85 -> 397
    //   315: aload 4
    //   317: invokeinterface 193 1 0
    //   322: checkcast 195	java/util/Map$Entry
    //   325: astore 6
    //   327: new 99	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   334: astore 7
    //   336: aload 7
    //   338: ldc 197
    //   340: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 7
    //   346: aload 6
    //   348: invokeinterface 200 1 0
    //   353: checkcast 127	java/lang/String
    //   356: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 7
    //   362: ldc 202
    //   364: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 7
    //   370: aload 6
    //   372: invokeinterface 205 1 0
    //   377: checkcast 127	java/lang/String
    //   380: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_3
    //   385: aload 7
    //   387: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: goto -89 -> 305
    //   397: new 99	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   404: astore 4
    //   406: aload 4
    //   408: ldc 91
    //   410: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 4
    //   416: aload_3
    //   417: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: ldc 210
    //   423: iconst_2
    //   424: aload 4
    //   426: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: new 218	android/os/Bundle
    //   435: dup
    //   436: invokespecial 219	android/os/Bundle:<init>	()V
    //   439: astore 4
    //   441: aload 4
    //   443: invokestatic 223	com/tencent/biz/common/util/HttpUtil:addCookie	(Landroid/os/Bundle;)V
    //   446: aload_3
    //   447: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: iconst_0
    //   451: aconst_null
    //   452: aload 4
    //   454: invokestatic 226	com/tencent/mobileqq/kandian/biz/common/ReadInJoyUtils:a	(Ljava/lang/String;ILandroid/os/Bundle;Landroid/os/Bundle;)[B
    //   457: astore_3
    //   458: aload_3
    //   459: ifnull +15 -> 474
    //   462: new 127	java/lang/String
    //   465: dup
    //   466: aload_3
    //   467: invokespecial 229	java/lang/String:<init>	([B)V
    //   470: astore_3
    //   471: goto +6 -> 477
    //   474: ldc 91
    //   476: astore_3
    //   477: aload_3
    //   478: invokestatic 234	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil:a	(Ljava/lang/String;)I
    //   481: istore_1
    //   482: aload 5
    //   484: aload_0
    //   485: getfield 18	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:b	Ljava/lang/String;
    //   488: bipush 6
    //   490: aload_3
    //   491: iload_1
    //   492: invokestatic 237	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil:a	(Ljava/lang/String;ILjava/lang/String;I)Ljava/util/List;
    //   495: invokeinterface 243 2 0
    //   500: pop
    //   501: aload 5
    //   503: iload_1
    //   504: aload_0
    //   505: getfield 22	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityAuthorData	Lcom/tencent/mobileqq/kandian/repo/fastweb/entity/AuthorData;
    //   508: invokestatic 248	com/tencent/mobileqq/kandian/biz/fastweb/util/ItemDatasListUtils:a	(Ljava/util/List;ILcom/tencent/mobileqq/kandian/repo/fastweb/entity/AuthorData;)V
    //   511: new 99	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   518: astore 4
    //   520: aload 4
    //   522: ldc 250
    //   524: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 4
    //   530: aload 5
    //   532: invokeinterface 253 1 0
    //   537: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 4
    //   543: ldc 255
    //   545: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 4
    //   551: aload_3
    //   552: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: ldc_w 257
    //   559: iconst_1
    //   560: aload 4
    //   562: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: goto +66 -> 634
    //   571: astore 4
    //   573: goto +15 -> 588
    //   576: astore 4
    //   578: goto +8 -> 586
    //   581: astore 4
    //   583: ldc 91
    //   585: astore_3
    //   586: iconst_0
    //   587: istore_1
    //   588: new 99	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   595: astore 6
    //   597: aload 6
    //   599: ldc 91
    //   601: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 6
    //   607: aload_3
    //   608: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: ldc 210
    //   614: iconst_2
    //   615: aload 4
    //   617: iconst_1
    //   618: anewarray 4	java/lang/Object
    //   621: dup
    //   622: iconst_0
    //   623: aload 6
    //   625: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: aastore
    //   629: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   632: iconst_0
    //   633: istore_2
    //   634: aload_0
    //   635: getfield 24	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil$3:jdField_a_of_type_ComTencentMobileqqKandianBizFastwebResponseCallback	Lcom/tencent/mobileqq/kandian/biz/fastweb/ResponseCallback;
    //   638: astore 4
    //   640: aload 4
    //   642: ifnull +18 -> 660
    //   645: aload 4
    //   647: iload_2
    //   648: aload 5
    //   650: aload_3
    //   651: invokestatic 264	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebRequestUtil:a	(Ljava/lang/String;)Z
    //   654: iload_1
    //   655: invokeinterface 269 5 0
    //   660: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	3
    //   481	174	1	i	int
    //   40	608	2	bool	boolean
    //   15	636	3	localObject1	Object
    //   20	541	4	localObject2	Object
    //   571	1	4	localException1	java.lang.Exception
    //   576	1	4	localException2	java.lang.Exception
    //   581	35	4	localException3	java.lang.Exception
    //   638	8	4	localResponseCallback	ResponseCallback
    //   7	642	5	localArrayList	java.util.ArrayList
    //   48	576	6	localObject3	Object
    //   37	349	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   482	568	571	java/lang/Exception
    //   477	482	576	java/lang/Exception
    //   41	50	581	java/lang/Exception
    //   53	61	581	java/lang/Exception
    //   64	127	581	java/lang/Exception
    //   138	144	581	java/lang/Exception
    //   144	305	581	java/lang/Exception
    //   305	394	581	java/lang/Exception
    //   397	458	581	java/lang/Exception
    //   462	471	581	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil.3
 * JD-Core Version:    0.7.0.1
 */