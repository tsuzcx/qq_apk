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
    //   41: sipush 330
    //   44: invokevirtual 49	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   47: checkcast 51	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull -38 -> 14
    //   55: aload_1
    //   56: ldc 53
    //   58: iconst_0
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 57	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:queryEntity	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   68: astore_3
    //   69: aload_1
    //   70: ldc 59
    //   72: iconst_0
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 57	com/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager:queryEntity	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   82: astore_2
    //   83: invokestatic 63	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:access$100	()Ljava/lang/Object;
    //   86: astore_1
    //   87: aload_1
    //   88: monitorenter
    //   89: aload_3
    //   90: ifnull +116 -> 206
    //   93: aload_3
    //   94: invokeinterface 69 1 0
    //   99: ifle +107 -> 206
    //   102: aload_3
    //   103: invokeinterface 73 1 0
    //   108: astore_3
    //   109: aload_3
    //   110: invokeinterface 78 1 0
    //   115: ifeq +91 -> 206
    //   118: aload_3
    //   119: invokeinterface 81 1 0
    //   124: checkcast 53	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity
    //   127: astore 4
    //   129: aload 4
    //   131: ifnull -22 -> 109
    //   134: new 83	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper
    //   137: dup
    //   138: invokespecial 84	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:<init>	()V
    //   141: astore 5
    //   143: aload 5
    //   145: aload 4
    //   147: getfield 88	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity:appId	Ljava/lang/String;
    //   150: invokevirtual 92	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setAppId	(Ljava/lang/String;)V
    //   153: aload 5
    //   155: aload 4
    //   157: getfield 95	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity:link	Ljava/lang/String;
    //   160: invokevirtual 98	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setLink	(Ljava/lang/String;)V
    //   163: aload 5
    //   165: aload 4
    //   167: getfield 102	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity:timeStamp	J
    //   170: invokevirtual 106	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setPullTimeStamp	(J)V
    //   173: invokestatic 110	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:access$200	()Ljava/util/HashMap;
    //   176: aload 4
    //   178: getfield 88	com/tencent/mobileqq/mini/apkgEntity/MiniAppByLinkEntity:appId	Ljava/lang/String;
    //   181: aload 5
    //   183: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: goto -78 -> 109
    //   190: astore_2
    //   191: aload_1
    //   192: monitorexit
    //   193: aload_2
    //   194: athrow
    //   195: astore_1
    //   196: ldc 22
    //   198: iconst_1
    //   199: ldc 118
    //   201: aload_1
    //   202: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: return
    //   206: aload_2
    //   207: ifnull +94 -> 301
    //   210: aload_2
    //   211: invokeinterface 69 1 0
    //   216: ifle +85 -> 301
    //   219: aload_2
    //   220: invokeinterface 73 1 0
    //   225: astore_2
    //   226: aload_2
    //   227: invokeinterface 78 1 0
    //   232: ifeq +69 -> 301
    //   235: aload_2
    //   236: invokeinterface 81 1 0
    //   241: checkcast 59	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity
    //   244: astore_3
    //   245: aload_3
    //   246: ifnull -20 -> 226
    //   249: new 83	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper
    //   252: dup
    //   253: invokespecial 84	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:<init>	()V
    //   256: astore 4
    //   258: aload 4
    //   260: aload_3
    //   261: getfield 122	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity:appId	Ljava/lang/String;
    //   264: invokevirtual 92	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setAppId	(Ljava/lang/String;)V
    //   267: aload 4
    //   269: aload_3
    //   270: getfield 125	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity:entryPath	Ljava/lang/String;
    //   273: invokevirtual 128	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setEntryPath	(Ljava/lang/String;)V
    //   276: aload 4
    //   278: aload_3
    //   279: getfield 129	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity:timeStamp	J
    //   282: invokevirtual 106	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager$MiniAppInfoPrePullWrapper:setPullTimeStamp	(J)V
    //   285: invokestatic 132	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:access$300	()Ljava/util/HashMap;
    //   288: aload_3
    //   289: getfield 122	com/tencent/mobileqq/mini/apkgEntity/MiniAppByIdEntity:appId	Ljava/lang/String;
    //   292: aload 4
    //   294: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   297: pop
    //   298: goto -72 -> 226
    //   301: aload_1
    //   302: monitorexit
    //   303: ldc 22
    //   305: iconst_1
    //   306: ldc 134
    //   308: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	1
    //   26	166	1	localObject1	Object
    //   195	107	1	localThrowable	java.lang.Throwable
    //   82	1	2	localList	java.util.List
    //   190	30	2	localObject2	Object
    //   225	11	2	localIterator	java.util.Iterator
    //   68	221	3	localObject3	Object
    //   127	166	4	localObject4	Object
    //   141	41	5	localMiniAppInfoPrePullWrapper	MiniAppPrePullManager.MiniAppInfoPrePullWrapper
    // Exception table:
    //   from	to	target	type
    //   93	109	190	finally
    //   109	129	190	finally
    //   134	187	190	finally
    //   191	193	190	finally
    //   210	226	190	finally
    //   226	245	190	finally
    //   249	298	190	finally
    //   301	303	190	finally
    //   40	51	195	java/lang/Throwable
    //   55	89	195	java/lang/Throwable
    //   193	195	195	java/lang/Throwable
    //   303	311	195	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.1
 * JD-Core Version:    0.7.0.1
 */