package com.tencent.mobileqq.emosm.api.impl;

import java.util.List;

class EmoticonManagerServiceImpl$10
  implements Runnable
{
  EmoticonManagerServiceImpl$10(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 25	java/util/HashSet
    //   3: dup
    //   4: invokespecial 26	java/util/HashSet:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 14	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl$10:this$0	Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;
    //   12: getfield 32	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: invokevirtual 38	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 43	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   23: aload_0
    //   24: getfield 16	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl$10:a	Ljava/util/List;
    //   27: invokeinterface 49 1 0
    //   32: astore_3
    //   33: aload_3
    //   34: invokeinterface 55 1 0
    //   39: ifeq +114 -> 153
    //   42: aload_3
    //   43: invokeinterface 59 1 0
    //   48: checkcast 61	com/tencent/mobileqq/data/Emoticon
    //   51: astore 4
    //   53: aload 4
    //   55: ifnonnull +6 -> 61
    //   58: goto -25 -> 33
    //   61: aload_2
    //   62: aload 4
    //   64: getfield 65	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   67: invokevirtual 69	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   70: pop
    //   71: aload_0
    //   72: getfield 14	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl$10:this$0	Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;
    //   75: aload 4
    //   77: invokestatic 73	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:access$200	(Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;Lcom/tencent/mobileqq/data/Emoticon;)V
    //   80: aload_0
    //   81: getfield 14	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl$10:this$0	Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;
    //   84: aload 4
    //   86: invokestatic 77	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:access$100	(Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   89: ifne -56 -> 33
    //   92: new 79	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   99: astore 5
    //   101: aload 5
    //   103: ldc 82
    //   105: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 5
    //   111: aload 4
    //   113: getfield 89	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   116: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: ldc 91
    //   124: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: aload 4
    //   132: getfield 94	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   135: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 96
    //   141: iconst_1
    //   142: aload 5
    //   144: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: goto -117 -> 33
    //   153: aload_1
    //   154: invokevirtual 109	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   157: aload_1
    //   158: invokevirtual 112	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   161: goto +49 -> 210
    //   164: astore_2
    //   165: goto +60 -> 225
    //   168: astore_3
    //   169: new 79	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   176: astore 4
    //   178: aload 4
    //   180: ldc 114
    //   182: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: aload_3
    //   189: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: ldc 96
    //   198: iconst_1
    //   199: aload 4
    //   201: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -50 -> 157
    //   210: aload_0
    //   211: getfield 14	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl$10:this$0	Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;
    //   214: getfield 121	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:app	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   217: invokestatic 127	com/tencent/mobileqq/activity/aio/stickerrecommended/impl/StickerRecManagerImpl:get	(Lcom/tencent/common/app/AppInterface;)Lcom/tencent/mobileqq/activity/aio/stickerrecommended/impl/StickerRecManagerImpl;
    //   220: aload_2
    //   221: invokevirtual 131	com/tencent/mobileqq/activity/aio/stickerrecommended/impl/StickerRecManagerImpl:syncAddLocalEmoticonKeywords	(Ljava/util/Collection;)V
    //   224: return
    //   225: aload_1
    //   226: invokevirtual 112	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   229: goto +5 -> 234
    //   232: aload_2
    //   233: athrow
    //   234: goto -2 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	10
    //   18	208	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   7	55	2	localHashSet	java.util.HashSet
    //   164	69	2	localCollection	java.util.Collection
    //   32	11	3	localIterator	java.util.Iterator
    //   168	21	3	localException	java.lang.Exception
    //   51	149	4	localObject	Object
    //   99	44	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	33	164	finally
    //   33	53	164	finally
    //   61	150	164	finally
    //   153	157	164	finally
    //   169	207	164	finally
    //   19	33	168	java/lang/Exception
    //   33	53	168	java/lang/Exception
    //   61	150	168	java/lang/Exception
    //   153	157	168	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */