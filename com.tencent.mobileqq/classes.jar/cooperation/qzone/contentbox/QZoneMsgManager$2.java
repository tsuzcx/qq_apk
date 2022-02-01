package cooperation.qzone.contentbox;

import com.tencent.qzonehub.model.QZoneMsgEntityNew;

class QZoneMsgManager$2
  implements Runnable
{
  QZoneMsgManager$2(QZoneMsgManager paramQZoneMsgManager, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: aload 4
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 14	cooperation/qzone/contentbox/QZoneMsgManager$2:this$0	Lcooperation/qzone/contentbox/QZoneMsgManager;
    //   14: invokevirtual 29	cooperation/qzone/contentbox/QZoneMsgManager:getApp	()Lmqq/app/AppRuntime;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnonnull +16 -> 37
    //   24: aload_3
    //   25: astore_2
    //   26: aload 4
    //   28: astore_1
    //   29: ldc 31
    //   31: ldc 33
    //   33: invokestatic 39	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: return
    //   37: aload_3
    //   38: astore_2
    //   39: aload 4
    //   41: astore_1
    //   42: aload_0
    //   43: getfield 16	cooperation/qzone/contentbox/QZoneMsgManager$2:val$entity	Lcom/tencent/qzonehub/model/QZoneMsgEntityNew;
    //   46: invokestatic 45	cooperation/qzone/contentbox/model/MsgEntityConverter:writeArkNewsToBuffer	(Lcom/tencent/qzonehub/model/QZoneMsgEntityNew;)V
    //   49: aload_3
    //   50: astore_2
    //   51: aload 4
    //   53: astore_1
    //   54: aload 5
    //   56: invokevirtual 51	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   59: invokevirtual 57	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   62: astore_3
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 16	cooperation/qzone/contentbox/QZoneMsgManager$2:val$entity	Lcom/tencent/qzonehub/model/QZoneMsgEntityNew;
    //   71: invokevirtual 63	com/tencent/qzonehub/model/QZoneMsgEntityNew:getStatus	()I
    //   74: sipush 1000
    //   77: if_icmpne +18 -> 95
    //   80: aload_3
    //   81: astore_2
    //   82: aload_3
    //   83: astore_1
    //   84: aload_3
    //   85: aload_0
    //   86: getfield 16	cooperation/qzone/contentbox/QZoneMsgManager$2:val$entity	Lcom/tencent/qzonehub/model/QZoneMsgEntityNew;
    //   89: invokevirtual 69	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   92: goto +16 -> 108
    //   95: aload_3
    //   96: astore_2
    //   97: aload_3
    //   98: astore_1
    //   99: aload_3
    //   100: aload_0
    //   101: getfield 16	cooperation/qzone/contentbox/QZoneMsgManager$2:val$entity	Lcom/tencent/qzonehub/model/QZoneMsgEntityNew;
    //   104: invokevirtual 73	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   107: pop
    //   108: aload_3
    //   109: ifnull +34 -> 143
    //   112: aload_3
    //   113: astore_1
    //   114: goto +25 -> 139
    //   117: astore_1
    //   118: goto +26 -> 144
    //   121: astore_3
    //   122: aload_1
    //   123: astore_2
    //   124: ldc 31
    //   126: iconst_1
    //   127: aload_3
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 76	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 79	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   143: return
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 79	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	2
    //   9	105	1	localObject1	Object
    //   117	36	1	localObject2	Object
    //   6	143	2	localObject3	Object
    //   4	109	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   121	7	3	localThrowable	java.lang.Throwable
    //   1	51	4	localObject4	Object
    //   17	38	5	localAppRuntime	mqq.app.AppRuntime
    // Exception table:
    //   from	to	target	type
    //   10	19	117	finally
    //   29	36	117	finally
    //   42	49	117	finally
    //   54	63	117	finally
    //   67	80	117	finally
    //   84	92	117	finally
    //   99	108	117	finally
    //   124	135	117	finally
    //   10	19	121	java/lang/Throwable
    //   29	36	121	java/lang/Throwable
    //   42	49	121	java/lang/Throwable
    //   54	63	121	java/lang/Throwable
    //   67	80	121	java/lang/Throwable
    //   84	92	121	java/lang/Throwable
    //   99	108	121	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.2
 * JD-Core Version:    0.7.0.1
 */