package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;

class DraftTextManager$2
  implements Runnable
{
  DraftTextManager$2(DraftTextManager paramDraftTextManager, DraftTextInfo paramDraftTextInfo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/mobileqq/managers/DraftTextManager$2:a	Lcom/tencent/mobileqq/data/DraftTextInfo;
    //   4: astore_2
    //   5: aload_2
    //   6: astore_1
    //   7: aload_2
    //   8: ifnonnull +23 -> 31
    //   11: aload_0
    //   12: getfield 20	com/tencent/mobileqq/managers/DraftTextManager$2:this$0	Lcom/tencent/mobileqq/managers/DraftTextManager;
    //   15: aload_0
    //   16: getfield 24	com/tencent/mobileqq/managers/DraftTextManager$2:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: aload_0
    //   20: getfield 26	com/tencent/mobileqq/managers/DraftTextManager$2:c	Ljava/lang/String;
    //   23: aload_0
    //   24: getfield 28	com/tencent/mobileqq/managers/DraftTextManager$2:d	I
    //   27: invokevirtual 40	com/tencent/mobileqq/managers/DraftTextManager:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Lcom/tencent/mobileqq/data/DraftTextInfo;
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 24	com/tencent/mobileqq/managers/DraftTextManager$2:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   35: invokevirtual 46	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   38: invokevirtual 52	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: astore_2
    //   42: aload_2
    //   43: aload_1
    //   44: invokevirtual 58	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   47: pop
    //   48: aload_2
    //   49: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   52: return
    //   53: astore_1
    //   54: goto +11 -> 65
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   62: goto -14 -> 48
    //   65: aload_2
    //   66: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   69: goto +5 -> 74
    //   72: aload_1
    //   73: athrow
    //   74: goto -2 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	2
    //   6	38	1	localObject1	Object
    //   53	1	1	localObject2	Object
    //   57	16	1	localException	java.lang.Exception
    //   4	62	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   42	48	53	finally
    //   58	62	53	finally
    //   42	48	57	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager.2
 * JD-Core Version:    0.7.0.1
 */