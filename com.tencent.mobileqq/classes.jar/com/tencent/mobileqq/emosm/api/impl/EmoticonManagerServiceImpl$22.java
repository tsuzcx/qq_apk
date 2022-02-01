package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonKeywords;

class EmoticonManagerServiceImpl$22
  implements Runnable
{
  EmoticonManagerServiceImpl$22(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, EmoticonKeywords paramEmoticonKeywords) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 14	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl$22:this$0	Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;
    //   8: getfield 35	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 41	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 46	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_0
    //   20: getfield 14	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl$22:this$0	Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;
    //   23: aload_0
    //   24: getfield 16	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl$22:a	Lcom/tencent/mobileqq/data/EmoticonKeywords;
    //   27: invokestatic 50	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:access$100	(Lcom/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   30: pop
    //   31: aload_3
    //   32: invokevirtual 53	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   35: aload_3
    //   36: invokevirtual 56	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   39: goto +52 -> 91
    //   42: astore 4
    //   44: goto +89 -> 133
    //   47: astore 4
    //   49: new 58	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   56: astore 5
    //   58: aload 5
    //   60: ldc 61
    //   62: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 5
    //   68: aload 4
    //   70: invokevirtual 69	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: ldc 71
    //   79: iconst_1
    //   80: aload 5
    //   82: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: goto -53 -> 35
    //   91: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +38 -> 132
    //   97: new 58	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: ldc 86
    //   108: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_3
    //   113: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   116: lload_1
    //   117: lsub
    //   118: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc 71
    //   124: iconst_2
    //   125: aload_3
    //   126: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: return
    //   133: aload_3
    //   134: invokevirtual 56	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   137: goto +6 -> 143
    //   140: aload 4
    //   142: athrow
    //   143: goto -3 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	22
    //   3	114	1	l	long
    //   14	120	3	localObject1	Object
    //   42	1	4	localObject2	Object
    //   47	94	4	localException	java.lang.Exception
    //   56	25	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	35	42	finally
    //   49	88	42	finally
    //   15	35	47	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.22
 * JD-Core Version:    0.7.0.1
 */