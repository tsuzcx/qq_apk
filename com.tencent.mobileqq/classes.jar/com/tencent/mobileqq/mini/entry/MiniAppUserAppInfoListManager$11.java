package com.tencent.mobileqq.mini.entry;

import java.util.List;

class MiniAppUserAppInfoListManager$11
  implements Runnable
{
  MiniAppUserAppInfoListManager$11(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, boolean paramBoolean, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/mobileqq/mini/entry/MiniAppUtils:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   3: astore_2
    //   4: aload_2
    //   5: ifnonnull +12 -> 17
    //   8: ldc 35
    //   10: iconst_1
    //   11: ldc 37
    //   13: invokestatic 43	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: getfield 18	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$11:val$needCheckDbData	Z
    //   21: ifeq +15 -> 36
    //   24: aload_0
    //   25: getfield 16	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$11:this$0	Lcom/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager;
    //   28: aload_2
    //   29: aload_0
    //   30: getfield 20	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$11:val$appInfoList	Ljava/util/List;
    //   33: invokestatic 49	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:access$1200	(Lcom/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager;Lcom/tencent/common/app/AppInterface;Ljava/util/List;)V
    //   36: aload_2
    //   37: invokevirtual 55	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   40: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +205 -> 250
    //   48: aload_3
    //   49: invokevirtual 67	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +7 -> 61
    //   57: aload_2
    //   58: invokevirtual 72	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   61: new 74	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   68: astore 4
    //   70: aload_0
    //   71: getfield 20	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$11:val$appInfoList	Ljava/util/List;
    //   74: invokeinterface 81 1 0
    //   79: astore 5
    //   81: iconst_1
    //   82: istore_1
    //   83: aload 5
    //   85: invokeinterface 87 1 0
    //   90: ifeq +77 -> 167
    //   93: aload 5
    //   95: invokeinterface 91 1 0
    //   100: checkcast 93	com/tencent/mobileqq/mini/apkg/MiniAppInfo
    //   103: astore 6
    //   105: aload 6
    //   107: iload_1
    //   108: putfield 97	com/tencent/mobileqq/mini/apkg/MiniAppInfo:position	I
    //   111: new 99	com/tencent/mobileqq/mini/entry/MiniAppEntity
    //   114: dup
    //   115: aload 6
    //   117: invokespecial 102	com/tencent/mobileqq/mini/entry/MiniAppEntity:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   120: astore 7
    //   122: aload 7
    //   124: sipush 1000
    //   127: invokevirtual 106	com/tencent/mobileqq/mini/entry/MiniAppEntity:setStatus	(I)V
    //   130: aload_0
    //   131: getfield 16	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$11:this$0	Lcom/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager;
    //   134: aload_3
    //   135: aload 7
    //   137: invokestatic 110	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:access$1100	(Lcom/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager;Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   140: pop
    //   141: iload_1
    //   142: iconst_1
    //   143: iadd
    //   144: istore_1
    //   145: aload 4
    //   147: aload 6
    //   149: getfield 114	com/tencent/mobileqq/mini/apkg/MiniAppInfo:name	Ljava/lang/String;
    //   152: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 4
    //   158: ldc 120
    //   160: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: goto -81 -> 83
    //   167: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +26 -> 196
    //   173: ldc 35
    //   175: iconst_2
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: ldc 125
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload 4
    //   189: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 136	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   204: aload_2
    //   205: ifnull +45 -> 250
    //   208: goto +27 -> 235
    //   211: astore_3
    //   212: goto +28 -> 240
    //   215: astore_3
    //   216: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +12 -> 231
    //   222: ldc 35
    //   224: iconst_2
    //   225: ldc 138
    //   227: aload_3
    //   228: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_2
    //   232: ifnull +18 -> 250
    //   235: aload_2
    //   236: invokevirtual 144	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   239: return
    //   240: aload_2
    //   241: ifnull +7 -> 248
    //   244: aload_2
    //   245: invokevirtual 144	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   248: aload_3
    //   249: athrow
    //   250: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	11
    //   82	63	1	i	int
    //   3	242	2	localObject1	Object
    //   43	92	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   211	1	3	localObject2	Object
    //   215	34	3	localException	java.lang.Exception
    //   68	120	4	localStringBuilder	java.lang.StringBuilder
    //   79	15	5	localIterator	java.util.Iterator
    //   103	45	6	localMiniAppInfo	com.tencent.mobileqq.mini.apkg.MiniAppInfo
    //   120	16	7	localMiniAppEntity	MiniAppEntity
    // Exception table:
    //   from	to	target	type
    //   57	61	211	finally
    //   61	81	211	finally
    //   83	141	211	finally
    //   145	164	211	finally
    //   167	196	211	finally
    //   200	204	211	finally
    //   216	231	211	finally
    //   57	61	215	java/lang/Exception
    //   61	81	215	java/lang/Exception
    //   83	141	215	java/lang/Exception
    //   145	164	215	java/lang/Exception
    //   167	196	215	java/lang/Exception
    //   200	204	215	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.11
 * JD-Core Version:    0.7.0.1
 */