package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.persistence.Entity;

class MiniAppUserAppInfoListManager$9
  implements Runnable
{
  MiniAppUserAppInfoListManager$9(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, Entity paramEntity) {}
  
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
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +104 -> 130
    //   29: aload_0
    //   30: getfield 16	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$9:val$entity	Lcom/tencent/mobileqq/persistence/Entity;
    //   33: ifnull +97 -> 130
    //   36: aload_2
    //   37: invokevirtual 57	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 62	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: aload_0
    //   46: getfield 14	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$9:this$0	Lcom/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager;
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 16	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$9:val$entity	Lcom/tencent/mobileqq/persistence/Entity;
    //   54: invokestatic 68	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager:access$1100	(Lcom/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager;Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   57: pop
    //   58: aload_1
    //   59: invokevirtual 71	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   62: new 73	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   69: astore_2
    //   70: aload_2
    //   71: ldc 76
    //   73: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_2
    //   78: aload_0
    //   79: getfield 16	com/tencent/mobileqq/mini/entry/MiniAppUserAppInfoListManager$9:val$entity	Lcom/tencent/mobileqq/persistence/Entity;
    //   82: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: ldc 31
    //   88: iconst_2
    //   89: aload_2
    //   90: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 90	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: goto +23 -> 119
    //   99: astore_2
    //   100: goto +24 -> 124
    //   103: astore_2
    //   104: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +12 -> 119
    //   110: ldc 31
    //   112: iconst_2
    //   113: ldc 96
    //   115: aload_2
    //   116: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_1
    //   120: invokevirtual 103	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   123: return
    //   124: aload_1
    //   125: invokevirtual 103	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   128: aload_2
    //   129: athrow
    //   130: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	9
    //   3	122	1	localObject1	Object
    //   24	66	2	localObject2	Object
    //   99	1	2	localObject3	Object
    //   103	26	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   45	96	99	finally
    //   104	119	99	finally
    //   45	96	103	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.9
 * JD-Core Version:    0.7.0.1
 */