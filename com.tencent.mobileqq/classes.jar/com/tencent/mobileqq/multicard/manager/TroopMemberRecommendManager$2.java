package com.tencent.mobileqq.multicard.manager;

class TroopMemberRecommendManager$2
  implements Runnable
{
  TroopMemberRecommendManager$2(TroopMemberRecommendManager paramTroopMemberRecommendManager, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 25	java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial 26	java/util/LinkedHashMap:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 14	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:this$0	Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;
    //   12: invokestatic 31	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager:a	(Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   18: invokevirtual 43	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +127 -> 152
    //   28: aload 4
    //   30: ldc 45
    //   32: iconst_1
    //   33: ldc 47
    //   35: iconst_1
    //   36: anewarray 49	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: getfield 16	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:a	Ljava/lang/String;
    //   45: aastore
    //   46: ldc 51
    //   48: aconst_null
    //   49: ldc 53
    //   51: aconst_null
    //   52: invokevirtual 59	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   55: checkcast 61	java/util/ArrayList
    //   58: astore_3
    //   59: aload_0
    //   60: getfield 14	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:this$0	Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;
    //   63: invokestatic 64	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager:a	(Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   66: aload_0
    //   67: getfield 16	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:a	Ljava/lang/String;
    //   70: aload_3
    //   71: invokevirtual 70	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: getfield 14	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:this$0	Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;
    //   79: aload_0
    //   80: getfield 16	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:a	Ljava/lang/String;
    //   83: iconst_1
    //   84: invokevirtual 73	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager:a	(Ljava/lang/String;Z)V
    //   87: aload_0
    //   88: getfield 14	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:this$0	Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;
    //   91: aload_0
    //   92: getfield 14	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:this$0	Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;
    //   95: invokestatic 64	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager:a	(Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   98: aload_0
    //   99: getfield 16	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:a	Ljava/lang/String;
    //   102: invokevirtual 77	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: checkcast 79	java/util/List
    //   108: aload_0
    //   109: getfield 16	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:a	Ljava/lang/String;
    //   112: invokevirtual 82	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager:a	(Ljava/util/List;Ljava/lang/String;)Ljava/util/Map;
    //   115: astore_3
    //   116: aload 4
    //   118: invokevirtual 85	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   121: aload_3
    //   122: astore_2
    //   123: iconst_1
    //   124: istore_1
    //   125: goto +29 -> 154
    //   128: astore_2
    //   129: goto +16 -> 145
    //   132: astore_3
    //   133: aload_3
    //   134: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   137: aload 4
    //   139: invokevirtual 85	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   142: goto +10 -> 152
    //   145: aload 4
    //   147: invokevirtual 85	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   150: aload_2
    //   151: athrow
    //   152: iconst_0
    //   153: istore_1
    //   154: aload_0
    //   155: getfield 14	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:this$0	Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;
    //   158: invokestatic 91	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager:a	(Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager;)Lcom/tencent/mobileqq/multicard/manager/TroopMemberRecommendHandler;
    //   161: iconst_1
    //   162: iload_1
    //   163: iconst_3
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_2
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload_0
    //   174: getfield 16	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendManager$2:a	Ljava/lang/String;
    //   177: aastore
    //   178: dup
    //   179: iconst_2
    //   180: iconst_2
    //   181: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokevirtual 103	com/tencent/mobileqq/multicard/manager/TroopMemberRecommendHandler:notifyUI	(IZLjava/lang/Object;)V
    //   188: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	2
    //   124	39	1	bool	boolean
    //   7	116	2	localObject1	Object
    //   128	42	2	localObject2	Object
    //   58	64	3	localObject3	Object
    //   132	2	3	localException	java.lang.Exception
    //   21	125	4	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    // Exception table:
    //   from	to	target	type
    //   28	116	128	finally
    //   133	137	128	finally
    //   28	116	132	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */