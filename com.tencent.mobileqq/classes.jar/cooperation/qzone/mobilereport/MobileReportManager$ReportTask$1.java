package cooperation.qzone.mobilereport;

import bjgc;

public class MobileReportManager$ReportTask$1
  implements Runnable
{
  public MobileReportManager$ReportTask$1(bjgc parambjgc) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc2_w 20
    //   3: invokestatic 27	java/lang/Thread:sleep	(J)V
    //   6: new 29	java/util/HashMap
    //   9: dup
    //   10: invokespecial 30	java/util/HashMap:<init>	()V
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 12	cooperation/qzone/mobilereport/MobileReportManager$ReportTask$1:this$0	Lbjgc;
    //   18: invokestatic 36	bjgc:a	(Lbjgc;)Ljava/util/HashMap;
    //   21: astore_1
    //   22: aload_1
    //   23: monitorenter
    //   24: aload_2
    //   25: aload_0
    //   26: getfield 12	cooperation/qzone/mobilereport/MobileReportManager$ReportTask$1:this$0	Lbjgc;
    //   29: invokestatic 36	bjgc:a	(Lbjgc;)Ljava/util/HashMap;
    //   32: invokevirtual 40	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   35: aload_0
    //   36: getfield 12	cooperation/qzone/mobilereport/MobileReportManager$ReportTask$1:this$0	Lbjgc;
    //   39: invokestatic 36	bjgc:a	(Lbjgc;)Ljava/util/HashMap;
    //   42: invokevirtual 43	java/util/HashMap:clear	()V
    //   45: aload_0
    //   46: getfield 12	cooperation/qzone/mobilereport/MobileReportManager$ReportTask$1:this$0	Lbjgc;
    //   49: invokestatic 46	bjgc:a	(Lbjgc;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   52: iconst_0
    //   53: invokevirtual 52	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   56: aload_1
    //   57: monitorexit
    //   58: aload_0
    //   59: getfield 12	cooperation/qzone/mobilereport/MobileReportManager$ReportTask$1:this$0	Lbjgc;
    //   62: aload_2
    //   63: invokestatic 55	bjgc:a	(Lbjgc;Ljava/util/HashMap;)V
    //   66: invokestatic 61	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   69: ifeq +11 -> 80
    //   72: ldc 63
    //   74: iconst_4
    //   75: ldc 65
    //   77: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: return
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 72	java/lang/InterruptedException:printStackTrace	()V
    //   86: goto -80 -> 6
    //   89: astore_2
    //   90: aload_1
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	1
    //   81	10	1	localInterruptedException	java.lang.InterruptedException
    //   13	50	2	localHashMap2	java.util.HashMap
    //   89	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	81	java/lang/InterruptedException
    //   24	58	89	finally
    //   90	92	89	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager.ReportTask.1
 * JD-Core Version:    0.7.0.1
 */