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
    //   18: invokestatic 49	com/tencent/biz/richframework/delegate/impl/RFLog:isColorLevel	()Z
    //   21: ifeq +30 -> 51
    //   24: ldc 51
    //   26: getstatic 55	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   29: new 57	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   36: ldc 60
    //   38: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_1
    //   42: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 74	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 14	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler$2:this$0	Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;
    //   55: invokestatic 29	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler:access$300	(Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: invokevirtual 78	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 83	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   66: aload_0
    //   67: getfield 16	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler$2:val$friends	Ljava/util/List;
    //   70: invokeinterface 89 1 0
    //   75: astore_3
    //   76: aload_3
    //   77: invokeinterface 94 1 0
    //   82: ifeq +57 -> 139
    //   85: aload_3
    //   86: invokeinterface 98 1 0
    //   91: checkcast 31	cooperation/qqcircle/beans/Friend
    //   94: astore 4
    //   96: aload_0
    //   97: getfield 14	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler$2:this$0	Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;
    //   100: invokestatic 29	cooperation/qqcircle/utils/QCircleDoubleFollowUserHepler:access$300	(Lcooperation/qqcircle/utils/QCircleDoubleFollowUserHepler;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   103: aload 4
    //   105: invokevirtual 102	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   108: goto -32 -> 76
    //   111: astore_3
    //   112: invokestatic 49	com/tencent/biz/richframework/delegate/impl/RFLog:isColorLevel	()Z
    //   115: ifeq +15 -> 130
    //   118: ldc 51
    //   120: getstatic 55	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   123: aload_3
    //   124: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: invokestatic 108	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 111	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   138: return
    //   139: aload_2
    //   140: invokevirtual 114	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   143: aload_2
    //   144: ifnull -6 -> 138
    //   147: aload_2
    //   148: invokevirtual 111	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   151: return
    //   152: astore_3
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 111	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   161: aload_3
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	2
    //   17	25	1	i	int
    //   61	97	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   75	11	3	localIterator	java.util.Iterator
    //   111	13	3	localException	java.lang.Exception
    //   152	10	3	localObject	Object
    //   94	10	4	localFriend	cooperation.qqcircle.beans.Friend
    // Exception table:
    //   from	to	target	type
    //   62	76	111	java/lang/Exception
    //   76	108	111	java/lang/Exception
    //   139	143	111	java/lang/Exception
    //   62	76	152	finally
    //   76	108	152	finally
    //   112	130	152	finally
    //   139	143	152	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler.2
 * JD-Core Version:    0.7.0.1
 */