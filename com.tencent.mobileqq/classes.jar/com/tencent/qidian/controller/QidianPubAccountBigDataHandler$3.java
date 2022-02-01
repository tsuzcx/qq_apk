package com.tencent.qidian.controller;

import bjhd;
import com.tencent.qidian.data.PubAccountNavigationMenu;

public class QidianPubAccountBigDataHandler$3
  implements Runnable
{
  public QidianPubAccountBigDataHandler$3(bjhd parambjhd, PubAccountNavigationMenu paramPubAccountNavigationMenu) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/qidian/controller/QidianPubAccountBigDataHandler$3:this$0	Lbjhd;
    //   4: getfield 29	bjhd:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   10: invokevirtual 40	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +22 -> 37
    //   18: aload_0
    //   19: getfield 16	com/tencent/qidian/controller/QidianPubAccountBigDataHandler$3:a	Lcom/tencent/qidian/data/PubAccountNavigationMenu;
    //   22: ifnull +16 -> 38
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 16	com/tencent/qidian/controller/QidianPubAccountBigDataHandler$3:a	Lcom/tencent/qidian/data/PubAccountNavigationMenu;
    //   30: invokevirtual 46	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   33: aload_1
    //   34: invokevirtual 49	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   37: return
    //   38: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq -8 -> 33
    //   44: ldc 57
    //   46: iconst_2
    //   47: ldc 59
    //   49: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: goto -19 -> 33
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   60: aload_1
    //   61: invokevirtual 49	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   64: return
    //   65: astore_2
    //   66: aload_1
    //   67: invokevirtual 49	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	3
    //   13	54	1	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   55	2	2	localException	java.lang.Exception
    //   65	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	33	55	java/lang/Exception
    //   38	52	55	java/lang/Exception
    //   18	33	65	finally
    //   38	52	65	finally
    //   56	60	65	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianPubAccountBigDataHandler.3
 * JD-Core Version:    0.7.0.1
 */