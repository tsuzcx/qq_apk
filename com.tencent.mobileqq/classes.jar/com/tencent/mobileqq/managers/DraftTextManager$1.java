package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;

class DraftTextManager$1
  implements Runnable
{
  DraftTextManager$1(DraftTextManager paramDraftTextManager, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/managers/DraftTextManager$1:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 33	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   7: invokevirtual 39	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 45	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual 50	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 20	com/tencent/mobileqq/managers/DraftTextManager$1:b	Lcom/tencent/mobileqq/data/DraftTextInfo;
    //   25: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   28: aload_1
    //   29: invokevirtual 57	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   32: goto +12 -> 44
    //   35: astore_2
    //   36: goto +17 -> 53
    //   39: astore_3
    //   40: aload_3
    //   41: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   44: aload_1
    //   45: invokevirtual 63	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   48: aload_2
    //   49: invokevirtual 66	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   52: return
    //   53: aload_1
    //   54: invokevirtual 63	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	1
    //   15	39	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	11	2	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   35	23	2	localObject	Object
    //   39	2	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   16	32	35	finally
    //   40	44	35	finally
    //   16	32	39	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.1
 * JD-Core Version:    0.7.0.1
 */