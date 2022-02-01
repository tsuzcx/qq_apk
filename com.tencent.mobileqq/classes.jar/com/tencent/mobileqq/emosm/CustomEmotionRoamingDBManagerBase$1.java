package com.tencent.mobileqq.emosm;

import java.util.List;

class CustomEmotionRoamingDBManagerBase$1
  implements Runnable
{
  CustomEmotionRoamingDBManagerBase$1(CustomEmotionRoamingDBManagerBase paramCustomEmotionRoamingDBManagerBase, List paramList, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:this$0	Lcom/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase;
    //   4: getfield 33	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase:app	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 16	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:this$0	Lcom/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase;
    //   15: getfield 33	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase:app	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   18: invokevirtual 39	com/tencent/common/app/business/BaseQQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   21: invokevirtual 45	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   24: astore 9
    //   26: aload 9
    //   28: ifnonnull +4 -> 32
    //   31: return
    //   32: aconst_null
    //   33: astore 7
    //   35: aconst_null
    //   36: astore 6
    //   38: iconst_0
    //   39: istore_1
    //   40: aload 9
    //   42: invokevirtual 51	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   45: astore 5
    //   47: aload 5
    //   49: astore 6
    //   51: aload 5
    //   53: astore 7
    //   55: aload 5
    //   57: invokevirtual 56	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   60: iconst_0
    //   61: istore_3
    //   62: aload 5
    //   64: astore 6
    //   66: iload_1
    //   67: aload_0
    //   68: getfield 18	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:a	Ljava/util/List;
    //   71: invokeinterface 62 1 0
    //   76: if_icmpge +180 -> 256
    //   79: aload 5
    //   81: astore 6
    //   83: aload_0
    //   84: getfield 18	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:a	Ljava/util/List;
    //   87: iload_1
    //   88: invokeinterface 66 2 0
    //   93: checkcast 68	com/tencent/mobileqq/data/CustomEmotionBase
    //   96: astore 7
    //   98: aload 5
    //   100: astore 6
    //   102: aload_0
    //   103: getfield 20	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:b	I
    //   106: istore_2
    //   107: iload_2
    //   108: iconst_1
    //   109: if_icmpeq +118 -> 227
    //   112: iload_2
    //   113: iconst_2
    //   114: if_icmpeq +97 -> 211
    //   117: iload_2
    //   118: iconst_4
    //   119: if_icmpeq +76 -> 195
    //   122: aload 5
    //   124: astore 6
    //   126: iload_3
    //   127: istore 4
    //   129: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +305 -> 437
    //   135: aload 5
    //   137: astore 6
    //   139: new 76	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   146: astore 7
    //   148: aload 5
    //   150: astore 6
    //   152: aload 7
    //   154: ldc 79
    //   156: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 5
    //   162: astore 6
    //   164: aload 7
    //   166: aload_0
    //   167: getfield 20	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:b	I
    //   170: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 5
    //   176: astore 6
    //   178: ldc 88
    //   180: iconst_2
    //   181: aload 7
    //   183: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iload_3
    //   190: istore 4
    //   192: goto +245 -> 437
    //   195: aload 5
    //   197: astore 6
    //   199: aload 9
    //   201: aload 7
    //   203: invokevirtual 100	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   206: istore 4
    //   208: goto +229 -> 437
    //   211: aload 5
    //   213: astore 6
    //   215: aload 9
    //   217: aload 7
    //   219: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   222: istore 4
    //   224: goto +213 -> 437
    //   227: aload 5
    //   229: astore 6
    //   231: aload 7
    //   233: sipush 1000
    //   236: invokevirtual 107	com/tencent/mobileqq/data/CustomEmotionBase:setStatus	(I)V
    //   239: aload 5
    //   241: astore 6
    //   243: aload 9
    //   245: aload 7
    //   247: invokevirtual 111	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   250: iload_3
    //   251: istore 4
    //   253: goto +184 -> 437
    //   256: aload 5
    //   258: astore 6
    //   260: aload 5
    //   262: invokevirtual 114	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   265: iload_3
    //   266: istore 4
    //   268: aload 5
    //   270: ifnull +54 -> 324
    //   273: goto +43 -> 316
    //   276: astore 8
    //   278: goto +16 -> 294
    //   281: astore 5
    //   283: goto +130 -> 413
    //   286: astore 8
    //   288: iconst_0
    //   289: istore_3
    //   290: aload 7
    //   292: astore 5
    //   294: aload 5
    //   296: astore 6
    //   298: ldc 88
    //   300: iconst_1
    //   301: ldc 116
    //   303: aload 8
    //   305: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   308: iload_3
    //   309: istore 4
    //   311: aload 5
    //   313: ifnull +11 -> 324
    //   316: aload 5
    //   318: invokevirtual 123	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   321: iload_3
    //   322: istore 4
    //   324: aload 9
    //   326: invokevirtual 126	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   329: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +80 -> 412
    //   335: new 76	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   342: astore 5
    //   344: aload 5
    //   346: ldc 128
    //   348: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 5
    //   354: aload_0
    //   355: getfield 20	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:b	I
    //   358: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 5
    //   364: ldc 130
    //   366: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 5
    //   372: aload_0
    //   373: getfield 18	com/tencent/mobileqq/emosm/CustomEmotionRoamingDBManagerBase$1:a	Ljava/util/List;
    //   376: invokeinterface 62 1 0
    //   381: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 5
    //   387: ldc 132
    //   389: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 5
    //   395: iload 4
    //   397: invokevirtual 135	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: ldc 88
    //   403: iconst_2
    //   404: aload 5
    //   406: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: return
    //   413: aload 6
    //   415: ifnull +8 -> 423
    //   418: aload 6
    //   420: invokevirtual 123	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   423: aload 9
    //   425: invokevirtual 126	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   428: goto +6 -> 434
    //   431: aload 5
    //   433: athrow
    //   434: goto -3 -> 431
    //   437: iload_1
    //   438: iconst_1
    //   439: iadd
    //   440: istore_1
    //   441: iload 4
    //   443: istore_3
    //   444: goto -382 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	1
    //   39	402	1	i	int
    //   106	14	2	j	int
    //   61	383	3	bool1	boolean
    //   127	315	4	bool2	boolean
    //   45	224	5	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   281	1	5	localObject1	Object
    //   292	140	5	localObject2	Object
    //   36	383	6	localObject3	Object
    //   33	258	7	localObject4	Object
    //   276	1	8	localException1	java.lang.Exception
    //   286	18	8	localException2	java.lang.Exception
    //   24	400	9	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    // Exception table:
    //   from	to	target	type
    //   66	79	276	java/lang/Exception
    //   83	98	276	java/lang/Exception
    //   102	107	276	java/lang/Exception
    //   129	135	276	java/lang/Exception
    //   139	148	276	java/lang/Exception
    //   152	160	276	java/lang/Exception
    //   164	174	276	java/lang/Exception
    //   178	189	276	java/lang/Exception
    //   199	208	276	java/lang/Exception
    //   215	224	276	java/lang/Exception
    //   231	239	276	java/lang/Exception
    //   243	250	276	java/lang/Exception
    //   260	265	276	java/lang/Exception
    //   40	47	281	finally
    //   55	60	281	finally
    //   66	79	281	finally
    //   83	98	281	finally
    //   102	107	281	finally
    //   129	135	281	finally
    //   139	148	281	finally
    //   152	160	281	finally
    //   164	174	281	finally
    //   178	189	281	finally
    //   199	208	281	finally
    //   215	224	281	finally
    //   231	239	281	finally
    //   243	250	281	finally
    //   260	265	281	finally
    //   298	308	281	finally
    //   40	47	286	java/lang/Exception
    //   55	60	286	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.1
 * JD-Core Version:    0.7.0.1
 */