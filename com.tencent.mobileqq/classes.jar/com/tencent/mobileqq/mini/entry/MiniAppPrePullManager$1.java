package com.tencent.mobileqq.mini.entry;

final class MiniAppPrePullManager$1
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 20	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:access$000	()Z
    //   3: ifne +12 -> 15
    //   6: ldc 22
    //   8: iconst_1
    //   9: ldc 24
    //   11: invokestatic 30	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: return
    //   15: ldc 22
    //   17: iconst_1
    //   18: ldc 32
    //   20: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: invokestatic 41	com/tencent/mobileqq/mini/entry/MiniAppUtils:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +12 -> 40
    //   31: ldc 22
    //   33: iconst_1
    //   34: ldc 43
    //   36: invokestatic 30	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: return
    //   40: aload_1
    //   41: getstatic 49	com/tencent/mobileqq/app/QQManagerFactory:MINI_APP_ENTITY_MANAGER	I
    //   44: invokevirtual 55	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   47: checkcast 57	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +258 -> 310
    //   55: aload_1
    //   56: ldc 59
    //   58: iconst_0
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 63	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:queryEntity	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   68: astore_3
    //   69: aload_1
    //   70: ldc 65
    //   72: iconst_0
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 63	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:queryEntity	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   82: astore_2
    //   83: invokestatic 69	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:access$100	()Ljava/lang/Object;
    //   86: astore_1
    //   87: aload_1
    //   88: monitorenter
    //   89: aload_3
    //   90: ifnull +100 -> 190
    //   93: aload_3
    //   94: invokeinterface 75 1 0
    //   99: ifle +91 -> 190
    //   102: aload_3
    //   103: invokeinterface 79 1 0
    //   108: astore_3
    //   109: aload_3
    //   110: invokeinterface 84 1 0
    //   115: ifeq +75 -> 190
    //   118: aload_3
    //   119: invokeinterface 87 1 0
    //   124: checkcast 59	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity
    //   127: astore 4
    //   129: aload 4
    //   131: ifnull -22 -> 109
    //   134: new 89	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper
    //   137: dup
    //   138: invokespecial 90	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:<init>	()V
    //   141: astore 5
    //   143: aload 5
    //   145: aload 4
    //   147: getfield 94	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity:appId	Ljava/lang/String;
    //   150: invokevirtual 98	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setAppId	(Ljava/lang/String;)V
    //   153: aload 5
    //   155: aload 4
    //   157: getfield 101	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity:link	Ljava/lang/String;
    //   160: invokevirtual 104	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setLink	(Ljava/lang/String;)V
    //   163: aload 5
    //   165: aload 4
    //   167: getfield 108	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity:timeStamp	J
    //   170: invokevirtual 112	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setPullTimeStamp	(J)V
    //   173: invokestatic 116	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:access$200	()Ljava/util/HashMap;
    //   176: aload 4
    //   178: getfield 94	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity:appId	Ljava/lang/String;
    //   181: aload 5
    //   183: invokevirtual 122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: goto -78 -> 109
    //   190: aload_2
    //   191: ifnull +94 -> 285
    //   194: aload_2
    //   195: invokeinterface 75 1 0
    //   200: ifle +85 -> 285
    //   203: aload_2
    //   204: invokeinterface 79 1 0
    //   209: astore_2
    //   210: aload_2
    //   211: invokeinterface 84 1 0
    //   216: ifeq +69 -> 285
    //   219: aload_2
    //   220: invokeinterface 87 1 0
    //   225: checkcast 65	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity
    //   228: astore_3
    //   229: aload_3
    //   230: ifnull -20 -> 210
    //   233: new 89	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper
    //   236: dup
    //   237: invokespecial 90	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:<init>	()V
    //   240: astore 4
    //   242: aload 4
    //   244: aload_3
    //   245: getfield 123	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity:appId	Ljava/lang/String;
    //   248: invokevirtual 98	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setAppId	(Ljava/lang/String;)V
    //   251: aload 4
    //   253: aload_3
    //   254: getfield 126	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity:entryPath	Ljava/lang/String;
    //   257: invokevirtual 129	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setEntryPath	(Ljava/lang/String;)V
    //   260: aload 4
    //   262: aload_3
    //   263: getfield 130	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity:timeStamp	J
    //   266: invokevirtual 112	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setPullTimeStamp	(J)V
    //   269: invokestatic 133	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:access$300	()Ljava/util/HashMap;
    //   272: aload_3
    //   273: getfield 123	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity:appId	Ljava/lang/String;
    //   276: aload 4
    //   278: invokevirtual 122	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: goto -72 -> 210
    //   285: aload_1
    //   286: monitorexit
    //   287: ldc 22
    //   289: iconst_1
    //   290: ldc 135
    //   292: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: return
    //   296: aload_1
    //   297: monitorexit
    //   298: aload_2
    //   299: athrow
    //   300: astore_1
    //   301: ldc 22
    //   303: iconst_1
    //   304: ldc 137
    //   306: aload_1
    //   307: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   310: return
    //   311: astore_2
    //   312: goto -16 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	1
    //   26	271	1	localObject1	Object
    //   300	7	1	localThrowable	java.lang.Throwable
    //   82	217	2	localObject2	Object
    //   311	1	2	localObject3	Object
    //   68	205	3	localObject4	Object
    //   127	150	4	localObject5	Object
    //   141	41	5	localMiniAppInfoPrePullWrapper	MiniAppPrePullManager.MiniAppInfoPrePullWrapper
    // Exception table:
    //   from	to	target	type
    //   40	51	300	java/lang/Throwable
    //   55	89	300	java/lang/Throwable
    //   287	295	300	java/lang/Throwable
    //   298	300	300	java/lang/Throwable
    //   93	109	311	finally
    //   109	129	311	finally
    //   134	187	311	finally
    //   194	210	311	finally
    //   210	229	311	finally
    //   233	282	311	finally
    //   285	287	311	finally
    //   296	298	311	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.1
 * JD-Core Version:    0.7.0.1
 */