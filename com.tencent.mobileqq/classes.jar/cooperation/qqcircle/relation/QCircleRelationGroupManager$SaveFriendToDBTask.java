package cooperation.qqcircle.relation;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.relation.entitys.QCircleFriendEntity;
import java.util.List;
import mqq.util.WeakReference;

class QCircleRelationGroupManager$SaveFriendToDBTask
  implements Runnable
{
  private static final String TAG = "RFL-SaveFriendToDBTask";
  private final boolean mIsClearDB;
  private final WeakReference<EntityManager> mSaveFriendToDBTaskWeak;
  private final List<QCircleFriendEntity> mSaveToDBFriendList;
  
  public QCircleRelationGroupManager$SaveFriendToDBTask(boolean paramBoolean, List<QCircleFriendEntity> paramList, EntityManager paramEntityManager)
  {
    this.mIsClearDB = paramBoolean;
    this.mSaveToDBFriendList = paramList;
    this.mSaveFriendToDBTaskWeak = new WeakReference(paramEntityManager);
  }
  
  private void clearLocalQCircleFriendList()
  {
    EntityManager localEntityManager = (EntityManager)this.mSaveFriendToDBTaskWeak.get();
    if (localEntityManager == null)
    {
      QLog.w("RFL-SaveFriendToDBTask", 1, "[clearLocalQCircleFriendList] manager not is null.");
      return;
    }
    try
    {
      QLog.d("RFL-SaveFriendToDBTask", 1, new Object[] { "[clearLocalQCircleFriendList] clear qcircle friend count: ", Integer.valueOf(localEntityManager.delete(QCircleFriendEntity.class.getSimpleName(), null, null)) });
      return;
    }
    catch (Exception localException)
    {
      QLog.w("RFL-SaveFriendToDBTask", 1, "[clearLocalQCircleFriendList] error: ", localException);
    }
  }
  
  /* Error */
  private void updateNewFriendListToDB()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	cooperation/qqcircle/relation/QCircleRelationGroupManager$SaveFriendToDBTask:mSaveFriendToDBTaskWeak	Lmqq/util/WeakReference;
    //   4: invokevirtual 44	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 46	com/tencent/mobileqq/persistence/EntityManager
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +12 -> 24
    //   15: ldc 10
    //   17: iconst_1
    //   18: ldc 88
    //   20: invokestatic 54	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload_2
    //   25: invokevirtual 92	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   28: astore_1
    //   29: ldc 10
    //   31: iconst_1
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc 94
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_0
    //   44: getfield 27	cooperation/qqcircle/relation/QCircleRelationGroupManager$SaveFriendToDBTask:mSaveToDBFriendList	Ljava/util/List;
    //   47: invokeinterface 100 1 0
    //   52: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   59: aload_1
    //   60: invokevirtual 105	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   63: aload_0
    //   64: getfield 27	cooperation/qqcircle/relation/QCircleRelationGroupManager$SaveFriendToDBTask:mSaveToDBFriendList	Ljava/util/List;
    //   67: invokeinterface 109 1 0
    //   72: astore_3
    //   73: aload_3
    //   74: invokeinterface 115 1 0
    //   79: ifeq +31 -> 110
    //   82: aload_3
    //   83: invokeinterface 118 1 0
    //   88: checkcast 58	cooperation/qqcircle/relation/entitys/QCircleFriendEntity
    //   91: astore 4
    //   93: aload 4
    //   95: ifnonnull +6 -> 101
    //   98: goto -25 -> 73
    //   101: aload_2
    //   102: aload 4
    //   104: invokevirtual 122	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   107: goto -34 -> 73
    //   110: aload_1
    //   111: invokevirtual 125	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   114: goto +17 -> 131
    //   117: astore_2
    //   118: goto +18 -> 136
    //   121: astore_2
    //   122: ldc 10
    //   124: iconst_1
    //   125: ldc 127
    //   127: aload_2
    //   128: invokestatic 83	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload_1
    //   132: invokevirtual 130	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   135: return
    //   136: aload_1
    //   137: invokevirtual 130	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   140: goto +5 -> 145
    //   143: aload_2
    //   144: athrow
    //   145: goto -2 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	SaveFriendToDBTask
    //   28	109	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	92	2	localEntityManager	EntityManager
    //   117	1	2	localObject	Object
    //   121	23	2	localThrowable	java.lang.Throwable
    //   72	11	3	localIterator	java.util.Iterator
    //   91	12	4	localQCircleFriendEntity	QCircleFriendEntity
    // Exception table:
    //   from	to	target	type
    //   29	73	117	finally
    //   73	93	117	finally
    //   101	107	117	finally
    //   110	114	117	finally
    //   122	131	117	finally
    //   29	73	121	java/lang/Throwable
    //   73	93	121	java/lang/Throwable
    //   101	107	121	java/lang/Throwable
    //   110	114	121	java/lang/Throwable
  }
  
  public void run()
  {
    if (this.mIsClearDB) {
      clearLocalQCircleFriendList();
    }
    updateNewFriendListToDB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.relation.QCircleRelationGroupManager.SaveFriendToDBTask
 * JD-Core Version:    0.7.0.1
 */