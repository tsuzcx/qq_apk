package com.tencent.mobileqq.mini.entry.desktop.item;

import java.util.List;

class DesktopDataManager$22
  implements Runnable
{
  DesktopDataManager$22(DesktopDataManager paramDesktopDataManager, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/mobileqq/mini/entry/MiniAppUtils:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnonnull +12 -> 17
    //   8: ldc 31
    //   10: iconst_1
    //   11: ldc 33
    //   13: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: return
    //   17: aload_1
    //   18: invokevirtual 45	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   21: invokevirtual 51	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +216 -> 242
    //   29: aload_3
    //   30: invokevirtual 57	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 62	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   38: new 64	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 16	com/tencent/mobileqq/mini/entry/desktop/item/DesktopDataManager$22:val$appInfoList	Ljava/util/List;
    //   51: invokeinterface 71 1 0
    //   56: astore 5
    //   58: aload 5
    //   60: invokeinterface 77 1 0
    //   65: ifeq +110 -> 175
    //   68: aload 5
    //   70: invokeinterface 81 1 0
    //   75: checkcast 83	com/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo
    //   78: astore 6
    //   80: aconst_null
    //   81: astore_1
    //   82: aload 6
    //   84: instanceof 85
    //   87: ifeq +22 -> 109
    //   90: new 87	com/tencent/mobileqq/mini/entry/desktop/item/DeskTopAppEntity
    //   93: dup
    //   94: aload 6
    //   96: checkcast 85	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo
    //   99: getfield 91	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:mMiniAppInfo	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   102: invokespecial 94	com/tencent/mobileqq/mini/entry/desktop/item/DeskTopAppEntity:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   105: astore_1
    //   106: goto +27 -> 133
    //   109: aload 6
    //   111: instanceof 96
    //   114: ifeq +19 -> 133
    //   117: new 87	com/tencent/mobileqq/mini/entry/desktop/item/DeskTopAppEntity
    //   120: dup
    //   121: aload 6
    //   123: checkcast 96	com/tencent/mobileqq/mini/entry/desktop/item/DesktopSearchInfo
    //   126: getfield 99	com/tencent/mobileqq/mini/entry/desktop/item/DesktopSearchInfo:mAppInfo	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   129: invokespecial 94	com/tencent/mobileqq/mini/entry/desktop/item/DeskTopAppEntity:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull -76 -> 58
    //   137: aload_1
    //   138: sipush 1000
    //   141: invokevirtual 103	com/tencent/mobileqq/mini/entry/desktop/item/DeskTopAppEntity:setStatus	(I)V
    //   144: aload_0
    //   145: getfield 14	com/tencent/mobileqq/mini/entry/desktop/item/DesktopDataManager$22:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopDataManager;
    //   148: aload_3
    //   149: aload_1
    //   150: invokestatic 109	com/tencent/mobileqq/mini/entry/desktop/item/DesktopDataManager:access$2200	(Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopDataManager;Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   153: pop
    //   154: aload 4
    //   156: aload_1
    //   157: getfield 113	com/tencent/mobileqq/mini/entry/desktop/item/DeskTopAppEntity:name	Ljava/lang/String;
    //   160: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 4
    //   166: ldc 119
    //   168: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: goto -114 -> 58
    //   175: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +26 -> 204
    //   181: ldc 31
    //   183: iconst_2
    //   184: iconst_2
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: ldc 124
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: aload 4
    //   197: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   204: aload_2
    //   205: invokevirtual 135	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   208: goto +23 -> 231
    //   211: astore_1
    //   212: goto +24 -> 236
    //   215: astore_1
    //   216: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +12 -> 231
    //   222: ldc 31
    //   224: iconst_2
    //   225: ldc 137
    //   227: aload_1
    //   228: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_2
    //   232: invokevirtual 143	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   235: return
    //   236: aload_2
    //   237: invokevirtual 143	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   240: aload_1
    //   241: athrow
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	22
    //   3	154	1	localObject1	Object
    //   211	1	1	localObject2	Object
    //   215	26	1	localException	java.lang.Exception
    //   33	204	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   24	125	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   45	151	4	localStringBuilder	java.lang.StringBuilder
    //   56	13	5	localIterator	java.util.Iterator
    //   78	44	6	localDesktopItemInfo	DesktopItemInfo
    // Exception table:
    //   from	to	target	type
    //   38	58	211	finally
    //   58	80	211	finally
    //   82	106	211	finally
    //   109	133	211	finally
    //   137	172	211	finally
    //   175	204	211	finally
    //   204	208	211	finally
    //   216	231	211	finally
    //   38	58	215	java/lang/Exception
    //   58	80	215	java/lang/Exception
    //   82	106	215	java/lang/Exception
    //   109	133	215	java/lang/Exception
    //   137	172	215	java/lang/Exception
    //   175	204	215	java/lang/Exception
    //   204	208	215	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.22
 * JD-Core Version:    0.7.0.1
 */