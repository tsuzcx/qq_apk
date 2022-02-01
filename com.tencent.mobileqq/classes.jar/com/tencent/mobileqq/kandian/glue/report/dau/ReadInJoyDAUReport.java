package com.tencent.mobileqq.kandian.glue.report.dau;

import com.tencent.mobileqq.app.automator.AsyncStep;

public class ReadInJoyDAUReport
  extends AsyncStep
{
  public String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\|");
    if (paramString == null) {
      return null;
    }
    paramString = paramString[(paramString.length - 1)].split(".");
    if ((paramString != null) && (paramString.length > 1)) {
      return paramString[1];
    }
    return null;
  }
  
  /* Error */
  protected int doStep()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUReport:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4: getfield 35	com/tencent/mobileqq/app/automator/Automator:k	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 41	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   10: invokevirtual 47	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 5
    //   15: ldc 49
    //   17: monitorenter
    //   18: aconst_null
    //   19: astore 4
    //   21: aload 5
    //   23: ldc 49
    //   25: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   28: astore_3
    //   29: goto +53 -> 82
    //   32: astore_3
    //   33: goto +694 -> 727
    //   36: astore 6
    //   38: aload 4
    //   40: astore_3
    //   41: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +38 -> 82
    //   47: new 63	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   54: astore_3
    //   55: aload_3
    //   56: ldc 66
    //   58: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: aload 6
    //   65: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: ldc 75
    //   71: iconst_2
    //   72: aload_3
    //   73: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload 4
    //   81: astore_3
    //   82: aload_0
    //   83: getfield 29	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUReport:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   86: getfield 35	com/tencent/mobileqq/app/automator/Automator:k	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   89: getstatic 89	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   92: invokevirtual 93	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   95: checkcast 95	com/tencent/mobileqq/app/FriendsManager
    //   98: astore 4
    //   100: iconst_m1
    //   101: istore_1
    //   102: aload 4
    //   104: ifnull +634 -> 738
    //   107: aload 4
    //   109: aload_0
    //   110: getfield 29	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUReport:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   113: getfield 35	com/tencent/mobileqq/app/automator/Automator:k	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   116: invokevirtual 98	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   119: invokevirtual 102	com/tencent/mobileqq/app/FriendsManager:g	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   122: astore 4
    //   124: aload 4
    //   126: ifnull +612 -> 738
    //   129: aload 4
    //   131: getfield 108	com/tencent/mobileqq/data/Card:shGender	S
    //   134: istore_1
    //   135: aload 4
    //   137: getfield 112	com/tencent/mobileqq/data/Card:age	B
    //   140: istore_2
    //   141: goto +3 -> 144
    //   144: aload_3
    //   145: ifnull +568 -> 713
    //   148: aload_3
    //   149: invokeinterface 117 1 0
    //   154: ifle +559 -> 713
    //   157: aload_3
    //   158: invokeinterface 121 1 0
    //   163: astore_3
    //   164: aload_3
    //   165: invokeinterface 126 1 0
    //   170: ifeq +543 -> 713
    //   173: aload_3
    //   174: invokeinterface 130 1 0
    //   179: checkcast 49	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo
    //   182: astore 4
    //   184: new 132	java/util/HashMap
    //   187: dup
    //   188: iconst_2
    //   189: invokespecial 135	java/util/HashMap:<init>	(I)V
    //   192: astore 6
    //   194: aload 6
    //   196: ldc 137
    //   198: aload 4
    //   200: getfield 140	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   203: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: aload 6
    //   209: ldc 146
    //   211: aload 4
    //   213: getfield 148	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   216: invokestatic 152	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   219: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   222: pop
    //   223: aload 6
    //   225: ldc 154
    //   227: iload_1
    //   228: invokestatic 152	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   231: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   234: pop
    //   235: aload 6
    //   237: ldc 155
    //   239: iload_2
    //   240: invokestatic 152	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   243: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload 6
    //   249: ldc 157
    //   251: aload 4
    //   253: getfield 159	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   256: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +114 -> 377
    //   266: new 63	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   273: astore 6
    //   275: aload 6
    //   277: ldc 161
    //   279: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 6
    //   285: aload_0
    //   286: getfield 29	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUReport:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   289: getfield 35	com/tencent/mobileqq/app/automator/Automator:k	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   292: invokevirtual 98	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   295: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 6
    //   301: ldc 163
    //   303: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 6
    //   309: aload 4
    //   311: getfield 166	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   314: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 6
    //   320: ldc 168
    //   322: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 6
    //   328: ldc 170
    //   330: iconst_1
    //   331: anewarray 172	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: invokestatic 177	com/tencent/common/config/AppSetting:h	()Ljava/lang/String;
    //   339: aastore
    //   340: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   343: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 6
    //   349: ldc 183
    //   351: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 6
    //   357: aload 4
    //   359: getfield 187	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   362: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: ldc 75
    //   368: iconst_2
    //   369: aload 6
    //   371: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aconst_null
    //   378: ldc 192
    //   380: ldc 194
    //   382: ldc 194
    //   384: ldc 196
    //   386: ldc 196
    //   388: iconst_0
    //   389: iconst_0
    //   390: aload 4
    //   392: getfield 187	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   395: invokestatic 201	java/lang/Long:toString	(J)Ljava/lang/String;
    //   398: aload 4
    //   400: getfield 166	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   403: ldc 170
    //   405: iconst_1
    //   406: anewarray 172	java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: invokestatic 177	com/tencent/common/config/AppSetting:h	()Ljava/lang/String;
    //   414: aastore
    //   415: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   418: aconst_null
    //   419: invokestatic 207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload_0
    //   423: aload 4
    //   425: getfield 159	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   428: invokevirtual 209	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUReport:a	(Ljava/lang/String;)Ljava/lang/String;
    //   431: astore 6
    //   433: aload 4
    //   435: getfield 140	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   438: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   441: ifne +183 -> 624
    //   444: aload 4
    //   446: getfield 140	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   449: ldc 217
    //   451: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   454: ifeq +170 -> 624
    //   457: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +283 -> 743
    //   463: new 63	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   470: astore 7
    //   472: aload 7
    //   474: ldc 223
    //   476: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 7
    //   482: aload_0
    //   483: getfield 29	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUReport:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   486: getfield 35	com/tencent/mobileqq/app/automator/Automator:k	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   489: invokevirtual 98	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   492: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 7
    //   498: ldc 163
    //   500: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 7
    //   506: aload 4
    //   508: getfield 166	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   511: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 7
    //   517: ldc 168
    //   519: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 7
    //   525: ldc 170
    //   527: iconst_1
    //   528: anewarray 172	java/lang/Object
    //   531: dup
    //   532: iconst_0
    //   533: invokestatic 177	com/tencent/common/config/AppSetting:h	()Ljava/lang/String;
    //   536: aastore
    //   537: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   540: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 7
    //   546: ldc 183
    //   548: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload 7
    //   554: aload 4
    //   556: getfield 187	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   559: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: ldc 75
    //   565: iconst_2
    //   566: aload 7
    //   568: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   574: goto +3 -> 577
    //   577: aconst_null
    //   578: ldc 192
    //   580: ldc 194
    //   582: ldc 194
    //   584: ldc 225
    //   586: ldc 225
    //   588: iconst_0
    //   589: iconst_0
    //   590: aload 4
    //   592: getfield 187	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   595: invokestatic 201	java/lang/Long:toString	(J)Ljava/lang/String;
    //   598: aload 4
    //   600: getfield 166	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   603: ldc 170
    //   605: iconst_1
    //   606: anewarray 172	java/lang/Object
    //   609: dup
    //   610: iconst_0
    //   611: invokestatic 177	com/tencent/common/config/AppSetting:h	()Ljava/lang/String;
    //   614: aastore
    //   615: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   618: invokestatic 229	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	()Ljava/lang/String;
    //   621: invokestatic 207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload 4
    //   626: getfield 140	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   629: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   632: ifne +114 -> 746
    //   635: aload 6
    //   637: ifnull +109 -> 746
    //   640: aload 6
    //   642: ldc 217
    //   644: invokevirtual 221	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   647: ifeq +99 -> 746
    //   650: aload 4
    //   652: getfield 140	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   655: ldc 231
    //   657: invokevirtual 234	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   660: ifeq +86 -> 746
    //   663: aconst_null
    //   664: ldc 192
    //   666: ldc 194
    //   668: ldc 194
    //   670: ldc 225
    //   672: ldc 225
    //   674: iconst_0
    //   675: iconst_0
    //   676: aload 4
    //   678: getfield 187	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   681: invokestatic 201	java/lang/Long:toString	(J)Ljava/lang/String;
    //   684: aload 4
    //   686: getfield 166	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   689: ldc 170
    //   691: iconst_1
    //   692: anewarray 172	java/lang/Object
    //   695: dup
    //   696: iconst_0
    //   697: invokestatic 177	com/tencent/common/config/AppSetting:h	()Ljava/lang/String;
    //   700: aastore
    //   701: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   704: invokestatic 229	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	()Ljava/lang/String;
    //   707: invokestatic 207	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   710: goto +36 -> 746
    //   713: aload 5
    //   715: ldc 49
    //   717: invokevirtual 238	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   720: pop
    //   721: ldc 49
    //   723: monitorexit
    //   724: bipush 7
    //   726: ireturn
    //   727: ldc 49
    //   729: monitorexit
    //   730: goto +5 -> 735
    //   733: aload_3
    //   734: athrow
    //   735: goto -2 -> 733
    //   738: iconst_m1
    //   739: istore_2
    //   740: goto -596 -> 144
    //   743: goto -166 -> 577
    //   746: goto -582 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	this	ReadInJoyDAUReport
    //   101	127	1	i	int
    //   140	600	2	j	int
    //   28	1	3	localList	java.util.List
    //   32	1	3	localObject1	java.lang.Object
    //   40	694	3	localObject2	java.lang.Object
    //   19	666	4	localObject3	java.lang.Object
    //   13	701	5	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   36	28	6	localException	java.lang.Exception
    //   192	449	6	localObject4	java.lang.Object
    //   470	97	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	29	32	finally
    //   41	79	32	finally
    //   82	100	32	finally
    //   107	124	32	finally
    //   129	141	32	finally
    //   148	164	32	finally
    //   164	377	32	finally
    //   377	574	32	finally
    //   577	624	32	finally
    //   624	635	32	finally
    //   640	710	32	finally
    //   713	724	32	finally
    //   727	730	32	finally
    //   21	29	36	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.dau.ReadInJoyDAUReport
 * JD-Core Version:    0.7.0.1
 */