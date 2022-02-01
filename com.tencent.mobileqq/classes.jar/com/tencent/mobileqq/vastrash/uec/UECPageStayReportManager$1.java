package com.tencent.mobileqq.vastrash.uec;

class UECPageStayReportManager$1
  implements Runnable
{
  UECPageStayReportManager$1(UECPageStayReportManager paramUECPageStayReportManager) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager$1:this$0	Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;
    //   4: invokestatic 25	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager:a	(Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;)J
    //   7: lconst_0
    //   8: lcmp
    //   9: ifle +13 -> 22
    //   12: aload_0
    //   13: getfield 12	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager$1:this$0	Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;
    //   16: invokestatic 25	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager:a	(Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;)J
    //   19: invokestatic 31	java/lang/Thread:sleep	(J)V
    //   22: new 33	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 34	java/util/ArrayList:<init>	()V
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 12	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager$1:this$0	Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;
    //   34: invokestatic 37	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager:a	(Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;)Ljava/util/ArrayList;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 12	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager$1:this$0	Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;
    //   45: invokestatic 37	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager:a	(Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;)Ljava/util/ArrayList;
    //   48: invokevirtual 41	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   51: pop
    //   52: aload_0
    //   53: getfield 12	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager$1:this$0	Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;
    //   56: invokestatic 37	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager:a	(Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;)Ljava/util/ArrayList;
    //   59: invokevirtual 44	java/util/ArrayList:clear	()V
    //   62: aload_0
    //   63: getfield 12	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager$1:this$0	Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;
    //   66: invokestatic 47	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager:a	(Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   69: iconst_0
    //   70: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   73: aload_1
    //   74: monitorexit
    //   75: aload_0
    //   76: getfield 12	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager$1:this$0	Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;
    //   79: aload_2
    //   80: invokestatic 56	com/tencent/mobileqq/vastrash/uec/UECPageStayReportManager:a	(Lcom/tencent/mobileqq/vastrash/uec/UECPageStayReportManager;Ljava/util/ArrayList;)V
    //   83: invokestatic 62	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   86: ifeq +11 -> 97
    //   89: ldc 64
    //   91: iconst_4
    //   92: ldc 66
    //   94: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 73	java/lang/InterruptedException:printStackTrace	()V
    //   103: goto -81 -> 22
    //   106: astore_2
    //   107: aload_1
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	1
    //   98	10	1	localInterruptedException	java.lang.InterruptedException
    //   29	51	2	localArrayList2	java.util.ArrayList
    //   106	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	22	98	java/lang/InterruptedException
    //   40	75	106	finally
    //   107	109	106	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayReportManager.1
 * JD-Core Version:    0.7.0.1
 */