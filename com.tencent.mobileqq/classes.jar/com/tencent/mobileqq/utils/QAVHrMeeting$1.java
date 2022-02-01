package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;

final class QAVHrMeeting$1
  implements Runnable
{
  QAVHrMeeting$1(String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, String paramString4, QAVHrMeeting.OnGetNickNameOfMaskDisc paramOnGetNickNameOfMaskDisc) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 38
    //   2: astore 5
    //   4: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +55 -> 62
    //   10: aload_0
    //   11: getfield 19	com/tencent/mobileqq/utils/QAVHrMeeting$1:a	Ljava/lang/String;
    //   14: astore 6
    //   16: new 46	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   23: astore 7
    //   25: aload 7
    //   27: ldc 49
    //   29: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 7
    //   35: aload_0
    //   36: getfield 21	com/tencent/mobileqq/utils/QAVHrMeeting$1:b	Ljava/lang/String;
    //   39: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 7
    //   45: ldc 55
    //   47: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 6
    //   53: iconst_2
    //   54: aload 7
    //   56: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: ldc 64
    //   64: invokestatic 69	com/tencent/mobileqq/utils/QQAudioHelper:b	(Ljava/lang/String;)V
    //   67: new 71	org/apache/http/impl/client/DefaultHttpClient
    //   70: dup
    //   71: invokespecial 72	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   74: astore 10
    //   76: new 74	org/apache/http/protocol/BasicHttpContext
    //   79: dup
    //   80: invokespecial 75	org/apache/http/protocol/BasicHttpContext:<init>	()V
    //   83: astore 6
    //   85: new 77	org/apache/http/client/methods/HttpGet
    //   88: dup
    //   89: aload_0
    //   90: getfield 21	com/tencent/mobileqq/utils/QAVHrMeeting$1:b	Ljava/lang/String;
    //   93: invokespecial 79	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   96: astore 7
    //   98: iconst_0
    //   99: istore_1
    //   100: iconst_0
    //   101: istore_3
    //   102: iconst_0
    //   103: istore_2
    //   104: aload_0
    //   105: getfield 23	com/tencent/mobileqq/utils/QAVHrMeeting$1:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: iconst_2
    //   109: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   112: checkcast 87	mqq/manager/TicketManager
    //   115: astore 8
    //   117: aload 8
    //   119: ifnonnull +16 -> 135
    //   122: aload 10
    //   124: invokeinterface 93 1 0
    //   129: invokeinterface 98 1 0
    //   134: return
    //   135: aload 8
    //   137: aload_0
    //   138: getfield 23	com/tencent/mobileqq/utils/QAVHrMeeting$1:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 101	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   144: invokeinterface 105 2 0
    //   149: astore 8
    //   151: aload 8
    //   153: ifnull -31 -> 122
    //   156: aload 8
    //   158: invokevirtual 111	java/lang/String:length	()I
    //   161: ifne +6 -> 167
    //   164: goto -42 -> 122
    //   167: aload_0
    //   168: getfield 23	com/tencent/mobileqq/utils/QAVHrMeeting$1:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   171: invokevirtual 114	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   174: astore 9
    //   176: new 46	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   183: astore 11
    //   185: aload 11
    //   187: ldc 116
    //   189: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 11
    //   195: aload 9
    //   197: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 11
    //   203: ldc 118
    //   205: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 11
    //   211: aload 8
    //   213: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 7
    //   219: ldc 120
    //   221: aload 11
    //   223: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokevirtual 124	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 10
    //   231: aload 7
    //   233: aload 6
    //   235: invokeinterface 128 3 0
    //   240: astore 6
    //   242: aload 6
    //   244: invokeinterface 134 1 0
    //   249: invokeinterface 139 1 0
    //   254: istore 4
    //   256: iload 4
    //   258: sipush 200
    //   261: if_icmpne +239 -> 500
    //   264: aload 6
    //   266: invokeinterface 143 1 0
    //   271: invokestatic 148	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   274: astore 9
    //   276: aload 5
    //   278: astore 8
    //   280: new 150	org/json/JSONObject
    //   283: dup
    //   284: aload 9
    //   286: invokespecial 151	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   289: astore 7
    //   291: aload 5
    //   293: astore 6
    //   295: iload_2
    //   296: istore_1
    //   297: aload 5
    //   299: astore 8
    //   301: aload 7
    //   303: ldc 153
    //   305: invokevirtual 157	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   308: ifne +181 -> 489
    //   311: aload 5
    //   313: astore 6
    //   315: iload_2
    //   316: istore_1
    //   317: aload 5
    //   319: astore 8
    //   321: aload 7
    //   323: ldc 159
    //   325: invokevirtual 163	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   328: ifeq +161 -> 489
    //   331: aload 5
    //   333: astore 8
    //   335: aload 7
    //   337: ldc 159
    //   339: invokevirtual 167	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   342: astore 11
    //   344: aload 5
    //   346: astore 8
    //   348: aload 11
    //   350: ldc 169
    //   352: invokevirtual 163	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   355: ifeq +15 -> 370
    //   358: aload 5
    //   360: astore 8
    //   362: aload 11
    //   364: ldc 169
    //   366: invokevirtual 157	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   369: pop
    //   370: aload 5
    //   372: astore 7
    //   374: aload 5
    //   376: astore 8
    //   378: aload 11
    //   380: ldc 171
    //   382: invokevirtual 163	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   385: ifeq +16 -> 401
    //   388: aload 5
    //   390: astore 8
    //   392: aload 11
    //   394: ldc 171
    //   396: invokevirtual 174	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   399: astore 7
    //   401: aload 7
    //   403: astore 6
    //   405: iload_2
    //   406: istore_1
    //   407: aload 7
    //   409: astore 8
    //   411: aload 11
    //   413: ldc 176
    //   415: invokevirtual 163	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   418: ifeq +71 -> 489
    //   421: aload 7
    //   423: astore 8
    //   425: aload 11
    //   427: ldc 176
    //   429: invokevirtual 174	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: astore 5
    //   434: aload 7
    //   436: astore 6
    //   438: iload_2
    //   439: istore_1
    //   440: aload 7
    //   442: astore 8
    //   444: aload 5
    //   446: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne +40 -> 489
    //   452: aload 7
    //   454: astore 6
    //   456: iload_2
    //   457: istore_1
    //   458: aload 7
    //   460: astore 8
    //   462: aload 5
    //   464: ldc 184
    //   466: invokevirtual 187	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   469: ifeq +20 -> 489
    //   472: aload 7
    //   474: astore 8
    //   476: aload 5
    //   478: invokestatic 193	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   481: invokevirtual 196	java/lang/Integer:intValue	()I
    //   484: istore_1
    //   485: aload 7
    //   487: astore 6
    //   489: aload 6
    //   491: astore 5
    //   493: aload 9
    //   495: astore 7
    //   497: goto +15 -> 512
    //   500: ldc 38
    //   502: astore 6
    //   504: aload 5
    //   506: astore 7
    //   508: aload 6
    //   510: astore 5
    //   512: aload 5
    //   514: astore 6
    //   516: iload_1
    //   517: istore_2
    //   518: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +132 -> 653
    //   524: aload_0
    //   525: getfield 19	com/tencent/mobileqq/utils/QAVHrMeeting$1:a	Ljava/lang/String;
    //   528: astore 6
    //   530: new 46	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   537: astore 8
    //   539: aload 8
    //   541: ldc 198
    //   543: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 8
    //   549: aload 7
    //   551: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 6
    //   557: iconst_2
    //   558: aload 8
    //   560: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload 5
    //   568: astore 6
    //   570: iload_1
    //   571: istore_2
    //   572: goto +81 -> 653
    //   575: astore 7
    //   577: goto +16 -> 593
    //   580: astore 5
    //   582: goto +309 -> 891
    //   585: astore 7
    //   587: ldc 38
    //   589: astore 5
    //   591: iload_3
    //   592: istore_1
    //   593: aload 5
    //   595: astore 6
    //   597: iload_1
    //   598: istore_2
    //   599: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq +51 -> 653
    //   605: aload_0
    //   606: getfield 19	com/tencent/mobileqq/utils/QAVHrMeeting$1:a	Ljava/lang/String;
    //   609: astore 6
    //   611: new 46	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   618: astore 8
    //   620: aload 8
    //   622: ldc 200
    //   624: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 8
    //   630: aload 7
    //   632: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 6
    //   638: iconst_2
    //   639: aload 8
    //   641: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: iload_1
    //   648: istore_2
    //   649: aload 5
    //   651: astore 6
    //   653: aload 10
    //   655: invokeinterface 93 1 0
    //   660: invokeinterface 98 1 0
    //   665: ldc 205
    //   667: invokestatic 69	com/tencent/mobileqq/utils/QQAudioHelper:b	(Ljava/lang/String;)V
    //   670: aload_0
    //   671: getfield 23	com/tencent/mobileqq/utils/QAVHrMeeting$1:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   674: getstatic 211	com/tencent/mobileqq/app/QQManagerFactory:DISCUSSION_MANAGER	I
    //   677: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   680: checkcast 213	com/tencent/mobileqq/app/DiscussionManager
    //   683: astore 5
    //   685: aload_0
    //   686: getfield 25	com/tencent/mobileqq/utils/QAVHrMeeting$1:d	Ljava/lang/String;
    //   689: aload_0
    //   690: getfield 23	com/tencent/mobileqq/utils/QAVHrMeeting$1:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   693: invokevirtual 114	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   696: invokestatic 217	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   699: ifeq +64 -> 763
    //   702: aload 5
    //   704: aload_0
    //   705: getfield 27	com/tencent/mobileqq/utils/QAVHrMeeting$1:e	Ljava/lang/String;
    //   708: invokevirtual 220	com/tencent/mobileqq/app/DiscussionManager:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   711: astore 7
    //   713: aload 7
    //   715: ifnull +48 -> 763
    //   718: aload 7
    //   720: getfield 225	com/tencent/mobileqq/data/DiscussionInfo:mSelfRight	I
    //   723: iload_2
    //   724: if_icmpeq +39 -> 763
    //   727: aload 7
    //   729: iload_2
    //   730: putfield 225	com/tencent/mobileqq/data/DiscussionInfo:mSelfRight	I
    //   733: aload 5
    //   735: aload 7
    //   737: invokevirtual 228	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   740: ldc 230
    //   742: aload_0
    //   743: getfield 23	com/tencent/mobileqq/utils/QAVHrMeeting$1:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   746: aload 7
    //   748: invokestatic 235	com/tencent/mobileqq/utils/QAVHrMeeting:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   751: aload_0
    //   752: getfield 23	com/tencent/mobileqq/utils/QAVHrMeeting$1:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   755: aload 7
    //   757: getfield 238	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   760: invokestatic 241	com/tencent/mobileqq/utils/QAVHrMeeting:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   763: aload 6
    //   765: ifnull +104 -> 869
    //   768: aload 6
    //   770: invokevirtual 111	java/lang/String:length	()I
    //   773: ifle +96 -> 869
    //   776: aload 5
    //   778: aload_0
    //   779: getfield 27	com/tencent/mobileqq/utils/QAVHrMeeting$1:e	Ljava/lang/String;
    //   782: aload_0
    //   783: getfield 25	com/tencent/mobileqq/utils/QAVHrMeeting$1:d	Ljava/lang/String;
    //   786: invokevirtual 244	com/tencent/mobileqq/app/DiscussionManager:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   789: astore 7
    //   791: aload 7
    //   793: ifnull +76 -> 869
    //   796: aload 7
    //   798: aload 6
    //   800: putfield 249	com/tencent/mobileqq/data/DiscussionMemberInfo:memberName	Ljava/lang/String;
    //   803: aload 7
    //   805: aload 6
    //   807: putfield 252	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   810: aload 5
    //   812: aload 7
    //   814: invokevirtual 255	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   817: new 257	java/util/ArrayList
    //   820: dup
    //   821: iconst_2
    //   822: invokespecial 260	java/util/ArrayList:<init>	(I)V
    //   825: astore 5
    //   827: aload 5
    //   829: aload_0
    //   830: getfield 27	com/tencent/mobileqq/utils/QAVHrMeeting$1:e	Ljava/lang/String;
    //   833: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   836: pop
    //   837: aload 5
    //   839: iconst_1
    //   840: iconst_1
    //   841: invokestatic 269	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   844: invokevirtual 272	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   847: aload_0
    //   848: getfield 23	com/tencent/mobileqq/utils/QAVHrMeeting$1:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   851: getstatic 277	com/tencent/mobileqq/app/BusinessHandlerFactory:DISCUSSION_HANDLER	Ljava/lang/String;
    //   854: invokevirtual 281	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   857: checkcast 283	com/tencent/mobileqq/app/DiscussionHandler
    //   860: sipush 1001
    //   863: iconst_1
    //   864: aload 5
    //   866: invokevirtual 287	com/tencent/mobileqq/app/DiscussionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   869: aload_0
    //   870: getfield 29	com/tencent/mobileqq/utils/QAVHrMeeting$1:f	Lcom/tencent/mobileqq/utils/QAVHrMeeting$OnGetNickNameOfMaskDisc;
    //   873: astore 5
    //   875: aload 5
    //   877: ifnull +13 -> 890
    //   880: aload 5
    //   882: aload 6
    //   884: iload_2
    //   885: invokeinterface 292 3 0
    //   890: return
    //   891: aload 10
    //   893: invokeinterface 93 1 0
    //   898: invokeinterface 98 1 0
    //   903: goto +6 -> 909
    //   906: aload 5
    //   908: athrow
    //   909: goto -3 -> 906
    //   912: astore 6
    //   914: goto -414 -> 500
    //   917: astore 5
    //   919: aload 8
    //   921: astore 6
    //   923: iload_2
    //   924: istore_1
    //   925: goto -436 -> 489
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	928	0	this	1
    //   99	826	1	i	int
    //   103	821	2	j	int
    //   101	491	3	k	int
    //   254	8	4	m	int
    //   2	565	5	localObject1	Object
    //   580	1	5	localObject2	Object
    //   589	318	5	localObject3	Object
    //   917	1	5	localException1	java.lang.Exception
    //   14	869	6	localObject4	Object
    //   912	1	6	localException2	java.lang.Exception
    //   921	1	6	localObject5	Object
    //   23	527	7	localObject6	Object
    //   575	1	7	localException3	java.lang.Exception
    //   585	46	7	localException4	java.lang.Exception
    //   711	102	7	localObject7	Object
    //   115	805	8	localObject8	Object
    //   174	320	9	str	String
    //   74	818	10	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   183	243	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   518	566	575	java/lang/Exception
    //   104	117	580	finally
    //   135	151	580	finally
    //   156	164	580	finally
    //   167	256	580	finally
    //   264	276	580	finally
    //   280	291	580	finally
    //   301	311	580	finally
    //   321	331	580	finally
    //   335	344	580	finally
    //   348	358	580	finally
    //   362	370	580	finally
    //   378	388	580	finally
    //   392	401	580	finally
    //   411	421	580	finally
    //   425	434	580	finally
    //   444	452	580	finally
    //   462	472	580	finally
    //   476	485	580	finally
    //   518	566	580	finally
    //   599	647	580	finally
    //   104	117	585	java/lang/Exception
    //   135	151	585	java/lang/Exception
    //   156	164	585	java/lang/Exception
    //   167	256	585	java/lang/Exception
    //   264	276	912	java/lang/Exception
    //   280	291	917	java/lang/Exception
    //   301	311	917	java/lang/Exception
    //   321	331	917	java/lang/Exception
    //   335	344	917	java/lang/Exception
    //   348	358	917	java/lang/Exception
    //   362	370	917	java/lang/Exception
    //   378	388	917	java/lang/Exception
    //   392	401	917	java/lang/Exception
    //   411	421	917	java/lang/Exception
    //   425	434	917	java/lang/Exception
    //   444	452	917	java/lang/Exception
    //   462	472	917	java/lang/Exception
    //   476	485	917	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVHrMeeting.1
 * JD-Core Version:    0.7.0.1
 */