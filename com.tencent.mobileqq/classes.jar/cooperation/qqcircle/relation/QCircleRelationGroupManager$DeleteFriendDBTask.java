package cooperation.qqcircle.relation;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.relation.entitys.QCircleFriendEntity;
import mqq.util.WeakReference;

class QCircleRelationGroupManager$DeleteFriendDBTask
  implements Runnable
{
  private static final String TAG = "RFL-DeleteFriendDBTask";
  private final WeakReference<EntityManager> mEntityManagerWeak;
  private final QCircleFriendEntity mFriendEntity;
  
  public QCircleRelationGroupManager$DeleteFriendDBTask(QCircleFriendEntity paramQCircleFriendEntity, EntityManager paramEntityManager)
  {
    this.mEntityManagerWeak = new WeakReference(paramEntityManager);
    this.mFriendEntity = paramQCircleFriendEntity;
  }
  
  public void run()
  {
    if (this.mFriendEntity == null)
    {
      QLog.d("RFL-DeleteFriendDBTask", 1, "[run] friend entity not is null.");
      return;
    }
    EntityManager localEntityManager = (EntityManager)this.mEntityManagerWeak.get();
    if (localEntityManager == null)
    {
      QLog.d("RFL-DeleteFriendDBTask", 1, "[run] entity manager not is null.");
      return;
    }
    try
    {
      long l = this.mFriendEntity.getUin();
      QLog.d("RFL-DeleteFriendDBTask", 1, new Object[] { "[run] delete count: ", Integer.valueOf(localEntityManager.delete(QCircleFriendEntity.class.getSimpleName(), "mUin=?", new String[] { String.valueOf(l) })) });
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("RFL-DeleteFriendDBTask", 1, "[run] delete fail: ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.relation.QCircleRelationGroupManager.DeleteFriendDBTask
 * JD-Core Version:    0.7.0.1
 */