package com.tencent.mobileqq.statistics;

import android.content.Intent;

public class ReportReceiver$ReportRunner
  implements Runnable
{
  private Intent a;
  
  public ReportReceiver$ReportRunner(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 27	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 31	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6: checkcast 33	com/tencent/mobileqq/app/QQAppInterface
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/statistics/ReportReceiver$ReportRunner:a	Landroid/content/Intent;
    //   19: astore 4
    //   21: aload 4
    //   23: ldc 35
    //   25: iconst_m1
    //   26: invokevirtual 41	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   29: istore_1
    //   30: iload_1
    //   31: sipush 1001
    //   34: if_icmpne +18 -> 52
    //   37: aload_3
    //   38: bipush 125
    //   40: invokevirtual 45	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   43: checkcast 47	com/tencent/mobileqq/app/soso/LbsInfoReportManager
    //   46: aload 4
    //   48: invokevirtual 49	com/tencent/mobileqq/app/soso/LbsInfoReportManager:a	(Landroid/content/Intent;)V
    //   51: return
    //   52: aload 4
    //   54: ldc 51
    //   56: invokevirtual 55	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 5
    //   61: aload 4
    //   63: ldc 57
    //   65: invokevirtual 55	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 6
    //   70: aload 4
    //   72: ldc 59
    //   74: iconst_1
    //   75: invokevirtual 41	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   78: istore_2
    //   79: ldc 61
    //   81: aload 5
    //   83: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +29 -> 115
    //   89: iload_1
    //   90: ifeq -76 -> 14
    //   93: iload_1
    //   94: iconst_1
    //   95: if_icmpne -81 -> 14
    //   98: aload 5
    //   100: aload_3
    //   101: aload 4
    //   103: ldc 57
    //   105: invokevirtual 71	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   108: checkcast 73	com/tencent/mobileqq/search/report/ReportModel
    //   111: invokestatic 78	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/search/report/ReportModel;)V
    //   114: return
    //   115: ldc 80
    //   117: aload 5
    //   119: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifeq +30 -> 152
    //   125: iload_1
    //   126: ifne +12 -> 138
    //   129: aload 5
    //   131: aload_3
    //   132: aload 6
    //   134: invokestatic 86	com/tencent/mobileqq/statistics/CaptureReportController:b	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   137: return
    //   138: iload_1
    //   139: iconst_1
    //   140: if_icmpne -126 -> 14
    //   143: aload 5
    //   145: aload_3
    //   146: aload 6
    //   148: invokestatic 88	com/tencent/mobileqq/statistics/CaptureReportController:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   151: return
    //   152: iload_1
    //   153: ifne +13 -> 166
    //   156: aload_3
    //   157: aload 5
    //   159: aload 6
    //   161: iload_2
    //   162: invokestatic 93	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   165: return
    //   166: iload_1
    //   167: iconst_1
    //   168: if_icmpne -154 -> 14
    //   171: aload_3
    //   172: aload 5
    //   174: aload 6
    //   176: iload_2
    //   177: invokestatic 95	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   180: return
    //   181: astore_3
    //   182: return
    //   183: astore_3
    //   184: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	ReportRunner
    //   29	140	1	i	int
    //   78	99	2	j	int
    //   9	163	3	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   181	1	3	localException	java.lang.Exception
    //   183	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   19	83	4	localIntent	Intent
    //   59	114	5	str1	java.lang.String
    //   68	107	6	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   15	30	181	java/lang/Exception
    //   37	51	181	java/lang/Exception
    //   52	79	181	java/lang/Exception
    //   79	89	181	java/lang/Exception
    //   98	114	181	java/lang/Exception
    //   115	125	181	java/lang/Exception
    //   129	137	181	java/lang/Exception
    //   143	151	181	java/lang/Exception
    //   156	165	181	java/lang/Exception
    //   171	180	181	java/lang/Exception
    //   79	89	183	java/lang/OutOfMemoryError
    //   98	114	183	java/lang/OutOfMemoryError
    //   115	125	183	java/lang/OutOfMemoryError
    //   129	137	183	java/lang/OutOfMemoryError
    //   143	151	183	java/lang/OutOfMemoryError
    //   156	165	183	java/lang/OutOfMemoryError
    //   171	180	183	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportReceiver.ReportRunner
 * JD-Core Version:    0.7.0.1
 */