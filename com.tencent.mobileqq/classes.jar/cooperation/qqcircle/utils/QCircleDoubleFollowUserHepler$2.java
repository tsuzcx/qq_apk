package cooperation.qqcircle.utils;

import java.util.List;

class QCircleDoubleFollowUserHepler$2
  implements Runnable
{
  QCircleDoubleFollowUserHepler$2(QCircleDoubleFollowUserHepler paramQCircleDoubleFollowUserHepler, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler$2:this$0	Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;
    //   4: invokestatic 29	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler:access$300	(Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: ldc 31
    //   9: invokevirtual 37	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   12: aconst_null
    //   13: aconst_null
    //   14: invokevirtual 43	com/tencent/mobileqq/persistence/EntityManager:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   17: istore_1
    //   18: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +28 -> 49
    //   24: ldc 51
    //   26: iconst_2
    //   27: new 53	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   34: ldc 56
    //   36: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 14	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler$2:this$0	Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;
    //   53: invokestatic 29	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler:access$300	(Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 79	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   64: aload_0
    //   65: getfield 16	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler$2:val$friends	Ljava/util/List;
    //   68: invokeinterface 85 1 0
    //   73: astore_3
    //   74: aload_3
    //   75: invokeinterface 90 1 0
    //   80: ifeq +55 -> 135
    //   83: aload_3
    //   84: invokeinterface 94 1 0
    //   89: checkcast 31	cooperation/qqcircle/beans/Friend
    //   92: astore 4
    //   94: aload_0
    //   95: getfield 14	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler$2:this$0	Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;
    //   98: invokestatic 29	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler:access$300	(Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   101: aload 4
    //   103: invokevirtual 98	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   106: goto -32 -> 74
    //   109: astore_3
    //   110: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +13 -> 126
    //   116: ldc 51
    //   118: iconst_2
    //   119: aload_3
    //   120: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 107	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   134: return
    //   135: aload_2
    //   136: invokevirtual 110	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   139: aload_2
    //   140: ifnull -6 -> 134
    //   143: aload_2
    //   144: invokevirtual 107	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   147: return
    //   148: astore_3
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 107	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   157: aload_3
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	2
    //   17	23	1	i	int
    //   59	95	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   73	11	3	localIterator	java.util.Iterator
    //   109	11	3	localException	java.lang.Exception
    //   148	10	3	localObject	Object
    //   92	10	4	localFriend	cooperation.qqcircle.beans.Friend
    // Exception table:
    //   from	to	target	type
    //   60	74	109	java/lang/Exception
    //   74	106	109	java/lang/Exception
    //   135	139	109	java/lang/Exception
    //   60	74	148	finally
    //   74	106	148	finally
    //   110	126	148	finally
    //   135	139	148	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler.2
 * JD-Core Version:    0.7.0.1
 */