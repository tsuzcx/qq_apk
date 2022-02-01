package com.tencent.qidian.controller;

import com.tencent.qidian.data.PubAccountNavigationMenu;

class QidianPubAccountBigDataHandler$3
  implements Runnable
{
  QidianPubAccountBigDataHandler$3(QidianPubAccountBigDataHandler paramQidianPubAccountBigDataHandler, PubAccountNavigationMenu paramPubAccountNavigationMenu) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/qidian/controller/QidianPubAccountBigDataHandler$3:this$0	Lcom/tencent/qidian/controller/QidianPubAccountBigDataHandler;
    //   4: getfield 28	com/tencent/qidian/controller/QidianPubAccountBigDataHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   10: invokevirtual 40	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +58 -> 73
    //   18: aload_0
    //   19: getfield 16	com/tencent/qidian/controller/QidianPubAccountBigDataHandler$3:a	Lcom/tencent/qidian/data/PubAccountNavigationMenu;
    //   22: ifnull +14 -> 36
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 16	com/tencent/qidian/controller/QidianPubAccountBigDataHandler$3:a	Lcom/tencent/qidian/data/PubAccountNavigationMenu;
    //   30: invokevirtual 46	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   33: goto +29 -> 62
    //   36: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +23 -> 62
    //   42: ldc 54
    //   44: iconst_2
    //   45: ldc 56
    //   47: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: goto +12 -> 62
    //   53: astore_2
    //   54: goto +13 -> 67
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   62: aload_1
    //   63: invokevirtual 66	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   66: return
    //   67: aload_1
    //   68: invokevirtual 66	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   71: aload_2
    //   72: athrow
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	3
    //   13	55	1	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   53	1	2	localObject	Object
    //   57	15	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	33	53	finally
    //   36	50	53	finally
    //   58	62	53	finally
    //   18	33	57	java/lang/Exception
    //   36	50	57	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianPubAccountBigDataHandler.3
 * JD-Core Version:    0.7.0.1
 */