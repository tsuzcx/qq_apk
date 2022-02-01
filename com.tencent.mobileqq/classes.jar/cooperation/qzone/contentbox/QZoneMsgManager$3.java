package cooperation.qzone.contentbox;

import mqq.app.AppRuntime;

class QZoneMsgManager$3
  implements Runnable
{
  QZoneMsgManager$3(QZoneMsgManager paramQZoneMsgManager, AppRuntime paramAppRuntime) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	cooperation/qzone/contentbox/QZoneMsgManager$3:val$app	Lmqq/app/AppRuntime;
    //   4: invokevirtual 29	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   7: invokevirtual 35	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore_1
    //   11: aload_1
    //   12: ldc 37
    //   14: invokevirtual 43	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   17: pop
    //   18: aload_1
    //   19: ifnull +31 -> 50
    //   22: aload_1
    //   23: invokevirtual 46	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   26: return
    //   27: astore_2
    //   28: goto +23 -> 51
    //   31: astore_2
    //   32: ldc 48
    //   34: iconst_1
    //   35: aload_2
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 54	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   43: aload_1
    //   44: ifnull +6 -> 50
    //   47: goto -25 -> 22
    //   50: return
    //   51: aload_1
    //   52: ifnull +7 -> 59
    //   55: aload_1
    //   56: invokevirtual 46	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   59: goto +5 -> 64
    //   62: aload_2
    //   63: athrow
    //   64: goto -2 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	3
    //   10	46	1	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   27	1	2	localObject	Object
    //   31	32	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   11	18	27	finally
    //   32	43	27	finally
    //   11	18	31	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.3
 * JD-Core Version:    0.7.0.1
 */